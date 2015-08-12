package org.osate.reqspec.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.SystemRequirements
import org.eclipse.emf.ecore.EObject
import org.osate.reqspec.reqSpec.ProjectConstants
import org.eclipse.emf.ecore.util.EcoreUtil

@ImplementedBy(ReqspecGlobalReferenceFinder)
interface IReqspecGlobalReferenceFinder {
	/**
	 * these methods should not be used to construct scopes
	 */
	def Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci);
	def Iterable<Requirement> getAllRequirements(ComponentInstance ci);
	def Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc);
	def Iterable<Requirement> getAllRequirements(ComponentClassifier cc);
	def Iterable<ProjectConstants> getAllProjectConstants(EObject context);
}

class ReqspecGlobalReferenceFinder implements IReqspecGlobalReferenceFinder{
		
	@Inject
	var ICommonGlobalReferenceFinder commonRefFinder
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci){
			ci.componentClassifier.systemRequirements
		}
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc){
			val srURIs = commonRefFinder.getEObjectReferences(cc, ReqSpecPackage.Literals.SYSTEM_REQUIREMENTS__TARGET, "reqspec") 
			val resset = cc.eResource.resourceSet
			return srURIs.map[ srURI | resset.getEObject(srURI, true) as SystemRequirements]
		}
		
		override Iterable<Requirement> getAllRequirements(ComponentInstance ci){
			ci.componentClassifier.allRequirements
		}
		override Iterable<Requirement> getAllRequirements(ComponentClassifier cc){
			cc.systemRequirements.map[it.content].flatten
		}

	override Iterable<ProjectConstants> getAllProjectConstants(EObject context){
		val Iterable<ProjectConstants> result = commonRefFinder.getEObjectDescriptions(
			context, ReqSpecPackage.Literals.PROJECT_CONSTANTS, "constants").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as ProjectConstants]
		return result
	}

}