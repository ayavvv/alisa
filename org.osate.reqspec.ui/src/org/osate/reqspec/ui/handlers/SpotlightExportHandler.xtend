package org.osate.reqspec.ui.handlers;

import com.google.inject.Inject
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.categories.categories.Category
import org.osate.recspec.ui.spotlight.utils.SpotlightUtil
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.*

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see IHandler
 * @see AbstractHandler
 */
class SpotlightExportHandler extends AbstractHandler {
	@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder
	val SPOTLIGHTEXT = "_spotlight.csv"
	val SPOTLIGHTFOLDER = "spotlight"

	new() {
		ReqSpecActivator.instance.getInjector(ReqSpecActivator.ORG_OSATE_REQSPEC_REQSPEC).injectMembers(this)
	}

	/**
	 * the command has been executed, so extract the needed information
	 * from the application context.
	 */
	override Object execute(ExecutionEvent event) throws ExecutionException {
		val window = HandlerUtil.getActiveWorkbenchWindowChecked(event)
		if (window != null) {
			val selection = window.getSelectionService().getSelection() as IStructuredSelection
			val firstElement = selection.getFirstElement()
			var SystemInstance systemInstance = null

			if (firstElement instanceof IAdaptable) {
				val project = switch firstElement {
					SystemInstance: {
						systemInstance = ((firstElement as IAdaptable).getAdapter(SystemInstance)) as SystemInstance
						(systemInstance.eResource.convertToIResource as IFile).project
					}
					IFile: {
						val potentialFile = (firstElement as IAdaptable).getAdapter(IFile) as IFile
						if (potentialFile.name.endsWith(".aaxl2")) {
							systemInstance = potentialFile.resource.contents.head as SystemInstance
							potentialFile.project
						}
					}
					InstanceObject: {
						val instanceObject = ((firstElement as IAdaptable).getAdapter(InstanceObject)) as InstanceObject
						systemInstance = instanceObject.getContainerOfType(SystemInstance)
						(systemInstance.eResource.convertToIResource as IFile).project
					}
				}
				if (systemInstance == null) {
					return null
				}

				val spotlightFolder = project.getSpotlightFolder();

				val spotlightRequirementsFile = spotlightFolder.getFile(systemInstance.name + SPOTLIGHTEXT)
				if (spotlightRequirementsFile.exists) {
					spotlightRequirementsFile.delete(true, null)
				}

				val leafNodesIterator = systemInstance.getAllContents(true).filter(ComponentInstance).filter [
					componentInstances.empty
				]
				val leafNodesList = leafNodesIterator.toList

				val numleaves = leafNodesList.size
				/* Console */ println("Name  Classifier [#ASRs] <<PUR>>")

				val ASRTable = leafNodesList.map[leaf|leaf.name + ":  " + leaf.category + "   " + leaf.analyze(numleaves)]
				ASRTable.sort.forEach[req|println(req)]

				project.refreshLocal(IResource.DEPTH_ONE, null)
			}
		}
		null
	}

	def String analyze(ComponentInstance leafInstance, int numleaves) {
		val ASRsForLeafNode = reqSpecrefFinder.getAllRequirements(leafInstance).filter[req|req.ssp].toList
		val numASRs = ASRsForLeafNode.size

		val midMinusASRs = (numASRs / 2) - 1
		val midPlusASRs = midMinusASRs + 1

		val volSorted = ASRsForLeafNode.map[req|req.changeUncertainty.volatility].sort
		val precSorted = ASRsForLeafNode.map[req|req.changeUncertainty.precedence].sort
		val double maxVol = volSorted.max
		val double medianVol = if (numASRs % 2 == 0) {
				(volSorted.get(midMinusASRs) + volSorted.get(midPlusASRs)) / 2.0
			} else {
				volSorted.get(midPlusASRs)
			}
		val double medianPrec = if (numASRs % 2 == 0) {
				(precSorted.get(midMinusASRs) + precSorted.get(midPlusASRs)) / 2.0
			} else {
				precSorted.get(midPlusASRs)
			}
		// We use a nested lambda function to produce the list of category lists, one per ASR for the given leaf node
		// For example, for a component c15 that has 5 ASRs, two security-only ASR, two safety-and-security-only ASRs,
		// and one security-and-performance-only ASR,
		// we'd get a list of lists of strings that might look something like this: 
		// [[Security], [Safety, Security], [Safety, Security], [Security], [Security, Performance]]
		val ASRsForLeafNodeCategories = ASRsForLeafNode.map[req|req.category.map[cat|cat.name.toLowerCase]]

		val numSafety = ASRsForLeafNodeCategories.filter[contains("safety")].size
		val numSecurity = ASRsForLeafNodeCategories.filter[contains("security")].size
		val numPerformance = ASRsForLeafNodeCategories.filter[contains("performance")].size

		val PUR = SpotlightUtil.calculatePUR(numleaves, maxVol, medianVol, medianPrec, numSafety, numSecurity,
			numPerformance)
		return "[" + numASRs + "]     " + PUR
	}

	def boolean isSsp(Requirement req) {
		val ssp = #{"safety", "security", "performance"}
		val categories = req.category
		val iterator = categories.iterator
		while (iterator.hasNext) {
			var nextCat = iterator.next as Category
			if (ssp.contains(nextCat.name.toLowerCase)) {
				return true
			}
		}
		false
	}

	def IFolder getSpotlightFolder(IProject project) {
		if (project.exists() && !project.isOpen()) {
			project.open(null)
		}
		val spotlightFolder = project.getFolder(SPOTLIGHTFOLDER);
		if (!spotlightFolder.exists()) {
			spotlightFolder.create(true, false, null)
		}
		spotlightFolder
	}

}
