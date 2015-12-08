/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.util

import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider
import com.rockwellcollins.atc.resolute.resolute.FailExpr
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
import com.rockwellcollins.atc.resolute.validation.BaseType
import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.SortedSet
import java.util.TreeSet
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.NamedElement
import org.osate.aadl2.NumberValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.modelsupport.AadlConstants
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.aadl2.util.Aadl2Util
import org.osate.alisa.common.common.CommonFactory
import org.osate.alisa.common.common.ResultIssue
import org.osate.alisa.common.common.ResultIssueType
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ElseType
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationExecutionState
import org.osate.assure.assure.VerificationExpr
import org.osate.assure.assure.VerificationResult
import org.osate.assure.assure.VerificationResultState
import org.osate.verify.verify.VerificationMethod

import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*

class AssureUtilExtension {

	
	def static SubsystemResult getEnclosingSubsystemResult(EObject assureObject) {
		if (assureObject.eContainer == null) return null;
		var result = assureObject.eContainer
		while (result != null && !(result instanceof SubsystemResult)) {
			result = result.eContainer
		}
		if(result == null) return null
		return result as SubsystemResult
	}

	def static AssuranceCaseResult getAssuranceCaseResult(EObject assureObject) {
		var result = assureObject
		while (result.eContainer != null) {
			result = result.eContainer
		}
		return result as AssuranceCaseResult
	}

	def static ComponentImplementation getAssuranceCaseTarget(EObject assureObject) {
		var ac = assureObject
		while (ac != null) {
			ac = ac.eContainer
			if (ac instanceof ModelResult){
				if (ac.target != null){
					return ac.target
				}
			}
		}
		return null
	}

	def static ClaimResult getEnclosingClaimResult(EObject assureObject) {
		var result = assureObject.eContainer
		while (!(result instanceof ClaimResult)) {
			result = result.eContainer
		}
		if (result == null) return null
		return result as ClaimResult
	}

	def static NamedElement getClaimSubject(EObject assureObject) {
		val req = if (assureObject instanceof ClaimResult) assureObject.target else assureObject.enclosingClaimResult.
				target
		req?.targetElement ?: req.targetClassifier
	}

	def static NamedElement getTargetElement(EObject assureObject) {
		val req = if (assureObject instanceof ClaimResult) assureObject.target else assureObject.enclosingClaimResult.
				target
		req?.targetElement
	}

	def static SystemInstance getAssuranceCaseInstanceModel(VerificationResult assureObject) {
		val rac = assureObject.assuranceCaseTarget
		if (rac == null) return null
		rac.instanceModel
	}

	def static ComponentInstance findTargetSystemComponentInstance(SystemInstance si,SubsystemResult ac){
		if (ac != null && ac.targetSystem != null){
			val ci = findTargetSystemComponentInstance(si,ac.enclosingSubsystemResult)
			findElementInstance(ci,ac.targetSystem) as ComponentInstance
		} else {
			si
		}
	}

	def static VerificationMethod getMethod(VerificationResult vr) {
		switch (vr) {
			VerificationActivityResult: return vr.target.method
			PreconditionResult: return vr.target
			ValidationResult: return vr.target
		}
	}

	/**
	 * methods to process results from verification methods
	 */
	def static void addMarkersAsResult(VerificationResult verificationActivityResult, InstanceObject instance,
		String markertype, VerificationMethod vm) {
		val res = instance.eResource
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
		val markers = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE) // analysisMarkerType
//		var Iterable<IMarker> finalmarkers = null
//		if (scope == SupportedScopes.SELF){
//			finalmarkers = markers.filter [ IMarker m |
//			m.getAttribute(AadlConstants.AADLURI) == EcoreUtil.getURI(instance).toString()]
//		} else if (scope == SupportedScopes.PARTS){
//			finalmarkers = markers.filter [ IMarker m |
//			val URI targetURI = URI.createURI(m.getAttribute(AadlConstants.AADLURI) as String)
//			val target = res.resourceSet.getEObject(targetURI, false)
//			val parent = target.getContainerOfType(ComponentInstance)
//			(EcoreUtil.getURI(parent).toString() == EcoreUtil.getURI(instance).toString())
//			]
//		} else {
//			finalmarkers = markers
//		}
//		if(finalmarkers.isEmpty) return false
		val targetURI = EcoreUtil.getURI(instance).toString()
		var targetmarkers = markers.filter [ IMarker m |
			matchURI(m.getAttribute(AadlConstants.AADLURI) as String, targetURI)
		]
//	enable if we want to default to all messages.	if (targetmarkers.empty) targetmarkers = markers
		val matchstr = matchMessage(vm)
		if (!matchstr.empty) {
			targetmarkers = targetmarkers.filter [ IMarker m |
				val msg = m.getAttribute(IMarker.MESSAGE) as String;
				msg.contains(matchstr)
			]
		}
		targetmarkers.forEach[em|verificationActivityResult.addMarkerIssue(instance, em)]
		if (verificationActivityResult.issues.exists[ri|ri.issueType == ResultIssueType.FAIL]) {
			verificationActivityResult.setToFail
		} else if (verificationActivityResult.issues.exists[ri|ri.issueType == ResultIssueType.ERROR]){
			verificationActivityResult.setToError
		} else {
			verificationActivityResult.setToSuccess
		}
	}

	def private static boolean matchURI(String uri1, String uri2) {
		return uri1 == uri2;
	}

	def private static String matchMessage(VerificationMethod vm) {
		switch (vm.name) {
			case "MaxFlowLatencyAnalysis": return "Maximum actual latency"
			case "MinFlowLatencyAnalysis": return "Minimum actual latency"
			case "FlowLatencyJitterAnalysis": return "Jitter"
		}
		return ""
	}

	def static ResultIssue addMarkerIssue(VerificationResult vr, EObject target, IMarker marker) {
		val msg = marker.getAttribute(IMarker.MESSAGE) as String
		switch (marker.getAttribute(IMarker.SEVERITY)) {
			case IMarker.SEVERITY_ERROR: addErrorIssue(vr, target, msg)
			case IMarker.SEVERITY_WARNING: addWarningIssue(vr, target, msg)
			case IMarker.SEVERITY_INFO: addSuccessIssue(vr, target, msg)
		}
	}

	def static ResultIssue addErrorIssue(VerificationResult vr, EObject target, String message) {
		addErrorIssue(vr, target, message, null)
	}

	def static ResultIssue addErrorIssue(VerificationResult vr, EObject target, String message, String issueSource) {
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.message = message?:"no message"
		issue.issueType = ResultIssueType.ERROR;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	def static ResultIssue addFailIssue(VerificationResult vr, EObject target, String message) {
		addFailIssue(vr, target, message, null)
	}

	def static ResultIssue addFailIssue(VerificationResult vr, EObject target, String message, String issueSource) {
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.message = message?:"no message"
		issue.issueType = ResultIssueType.FAIL;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	def static ResultIssue addInfoIssue(VerificationResult vr, EObject target, String message) {
		addInfoIssue(vr, target, message, null)
	}

	def static ResultIssue addInfoIssue(VerificationResult vr, EObject target, String message, String issueSource) {
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.INFO;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	def static ResultIssue addSuccessIssue(VerificationResult vr, EObject target, String message) {
		addSuccessIssue(vr, target, message, null)
	}

	def static ResultIssue addSuccessIssue(VerificationResult vr, EObject target, String message, String issueSource) {
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.SUCCESS;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	def static ResultIssue addWarningIssue(VerificationResult vr, EObject target, String message) {
		addWarningIssue(vr, target, message, null)
	}

	def static ResultIssue addWarningIssue(VerificationResult vr, EObject target, String message, String issueSource) {
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.WARNING;
		issue.exceptionType = issueSource
		issue.target = target
		vr.issues.add(issue)
		issue
	}

	static val resoluteContent = new ResoluteResultContentProvider

	def static void doResoluteResults(ResoluteResult rr, ResultIssue ri) {
		val subrrs = resoluteContent.getChildren(rr)
		subrrs.forEach [ subrr |
			val subclaim = subrr as com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			val subri = if (subclaim.isValid)
					ri.addSuccessIssue(subclaim.location, subclaim.text)
				else
					ri.addErrorIssue(subclaim.location, subclaim.text)
			subclaim.doResoluteResults(subri)
		]
	}

	def static ResultIssue addErrorIssue(ResultIssue ri, EObject target, String message) {
		addErrorIssue(ri, target, message, null)
	}

	def static ResultIssue addErrorIssue(ResultIssue ri, EObject target, String message, String issueSource) {
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.ERROR;
		issue.exceptionType = issueSource
		if (target instanceof FunctionDefinition) {
			issue.target = target
		} else if (!(target instanceof FailExpr)) {
			issue.target = target
		} else if (target instanceof FailExpr) {
			if (message.length > 14) {
				issue.message = message.substring(15)
			}
		}
		ri.issues.add(issue)
		issue
	}

	def static ResultIssue addSuccessIssue(ResultIssue ri, EObject target, String message) {
		addSuccessIssue(ri, target, message, null)
	}

	def static ResultIssue addSuccessIssue(ResultIssue ri, EObject target, String message, String issueSource) {
		val issue = CommonFactory.eINSTANCE.createResultIssue
		issue.message = message
		issue.issueType = ResultIssueType.SUCCESS;
		issue.exceptionType = issueSource
		if (target instanceof FunctionDefinition) {
			issue.target = target
		} else if (!(target instanceof FailExpr)) {
			issue.target = target
		} else if (target instanceof FailExpr) {
			if (message.length > 14) {
				ri.message = message.substring(15)
			} else {
				ri.message = message
			}
		}
		ri.issues.add(issue)
		issue
	}

	def static getTotalCount(AssureResult ar) {
		val counts = ar.metrics
		counts.timeoutCount + counts.errorCount + counts.failCount + counts.successCount + counts.tbdCount +
			counts.didelseCount + counts.thenskipCount
	}

	def static isSuccessful(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount == 0 && counts.errorCount == 0 && counts.timeoutCount == 0 && counts.tbdCount == 0 &&
			counts.successCount > 0
	}

	def static isNoSuccess(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount != 0 || counts.errorCount != 0 || counts.timeoutCount != 0
	}

	def static isFail(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount != 0
	}

	def static isErrorTimeOut(AssureResult ar) {
		val counts = ar.metrics
		counts.errorCount != 0 || counts.timeoutCount != 0
	}

	def static isTBD(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount == 0 && counts.errorCount == 0 && counts.timeoutCount == 0 && counts.tbdCount > 0
	}

	def static isZeroCount(AssureResult ar) {
		val counts = ar.metrics
		counts.failCount == 0 && counts.errorCount == 0 && counts.timeoutCount == 0 && counts.tbdCount == 0
	}

	/** 
	 * state of VerificationResult 
	 */
	def static boolean isSuccess(VerificationResult vr) {
		vr.resultState == VerificationResultState.SUCCESS
	}

	def static boolean isError(VerificationResult vr) {
		vr.resultState == VerificationResultState.ERROR
	}

	def static boolean isFailed(VerificationResult vr) {
		vr.resultState == VerificationResultState.FAIL
	}

	def static boolean isTimeout(VerificationResult vr) {
		vr.resultState == VerificationResultState.TIMEOUT
	}

	/**
	 * true iff none of the elements have a fail or error
	 */
	def static boolean isSuccess(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if (ar.noSuccess) return false
		}
		return true
	}

	/**
	 * true iff none of the elements have a fail or error
	 */
	def static boolean isSuccessFul(EList<VerificationResult> vel) {
		for (ar : vel) {
			if (ar.noSuccess) return false
		}
		return true
	}

	/**
	 * true iff at least one has a non-zero fail or unknown count
	 */
	def static boolean isNoSuccess(EList<VerificationExpr> vel) {
		for (ar : vel) {
			if (ar.isNoSuccess) return true
		}
		return false
	}

	def static boolean hasError(EList<VerificationExpr> vel) {
		if (vel.size == 1 && vel.head instanceof VerificationActivityResult) {
			return (vel.head as VerificationActivityResult).isError
		} else {
			return isNoSuccess(vel)
		}
	}

	def static boolean isTimeout(EList<VerificationExpr> vel) {
		if (vel.size == 1 && vel.head instanceof VerificationActivityResult) {
			return (vel.head as VerificationActivityResult).isTimeout
		} else {
			return false
		}
	}

	def static boolean isFailed(EList<VerificationExpr> vel) {
		if (vel.size == 1 && vel.head instanceof VerificationActivityResult) {
			return (vel.head as VerificationActivityResult).isFailed
		} else {
			return false
		}
	}

	def static String constructLabel(EObject obj) {
		switch (obj) {
			SystemInstance: return "top " + obj.componentImplementation.name + ": "
			ComponentInstance: return obj.category.getName + " " + obj.name + ": "
			NamedElement: obj.name + ": "
		}
		""
	}

	def static String getNamePath(AssureResult ar) {
		if (ar.eContainer == null) {
			return ar.printableName
		} else {
			return (ar.eContainer as AssureResult).namePath + "." + ar.printableName
		}
	}

	def static getPrintableName(AssureResult ar) {
		switch (ar) {
			AssuranceCaseResult: return "system "+ar.name
			ModelResult: return "model "+ar.name
			SubsystemResult: return "subsystem "+ar.name
			ClaimResult: return "claim "+ar.name
			ValidationResult: return "validation "+ar.name
			PreconditionResult: return "precondition "+ar.name
			VerificationActivityResult: return "evidence "+ar.name
			ElseResult: return "Else"
			ThenResult: return "Then"
		}
		return ""
	}

	def static getName(AssureResult ar) {
		switch (ar) {
			AssuranceCaseResult: return ar.name
			ModelResult: return ar.name
			SubsystemResult: return ar.name
			ClaimResult: return ar.name
			ValidationResult: return ar.name
			PreconditionResult: return ar.name
			VerificationActivityResult: return ar.name
		}
		return ""
	}

	/**
	 * interface with Resolute
	 * we initialize the sets on demand. See populate function.
	 * We reset the sets and maps on an evelaution run.
	 */
	static var SystemInstance systemroot

	static var Map<String, SortedSet<NamedElement>> sets
	static var FeatureToConnectionsMap featToConnsMap

	def static FeatureToConnectionsMap getFeatToConnsMap() {
		if (featToConnsMap == null) {
			populateResoluteContext
		}
		return featToConnsMap
	}

	def static Map<String, SortedSet<NamedElement>> getSets() {
		if (sets == null) {
			populateResoluteContext
		}
		return sets
	}

	def static initializeResoluteContext(SystemInstance si) {
		if (systemroot != si) {
			sets = null
			featToConnsMap = null
			systemroot = si
		}
	}

	def private static void populateResoluteContext() {
		sets = new HashMap<String, SortedSet<NamedElement>>()
		systemroot.initializeSets(sets);
		featToConnsMap = new FeatureToConnectionsMap(systemroot);
	}

	def private static void initializeSets(ComponentInstance ci, Map<String, SortedSet<NamedElement>> sets) {
		if (ci == null) {
			return;
		}

		addToSet(sets, getCategoryName(ci.getCategory()), ci);
		addToSet(sets, "component", ci);

		for (ComponentInstance sub : ci.getComponentInstances()) {
			initializeSets(sub, sets);
		}

		for (ConnectionInstance conn : ci.getConnectionInstances()) {
			addToSet(sets, "connection", conn);
		}
	}

	def private static String getCategoryName(ComponentCategory category) {
		return new BaseType(category).toString();
	}

	def private static void addToSet(Map<String, SortedSet<NamedElement>> sets, String name, NamedElement ne) {
		var SortedSet<NamedElement> set = sets.get(name);
		if (set == null) {
			set = new TreeSet<NamedElement>(new NamedElementComparator());
			sets.put(name, set);
		}
		set.add(ne);
	}

	/************************
	 * methods to deal with assurance case instance
	 */
	/**
	  * this method resets the execution state of all verification activities to TBD
	  */
	def static void resetToTBD(AssuranceCaseResult root) {
		val vrlist = EcoreUtil2.eAllOfType(root, VerificationResult)
		vrlist.forEach [ vr |
			vr.resultState = VerificationResultState.TBD
			vr.executionState = VerificationExecutionState.TODO
			vr.issues.clear
		]
	}

	/**
	 * this next set of methods recomputes all the counts from the VerificationResult states bottom up for the whole hierarchy 
	 * Only the top method should be called
	 * This method is useful when counts are messed up but the state is ok.
	 */
	/** Helper methods */
	private def static void resetCounts(AssureResult result) {
		val counts = result.metrics
		counts.failCount = 0
		counts.successCount = 0
		counts.errorCount = 0
		counts.timeoutCount = 0
		counts.thenskipCount = 0
		counts.didelseCount = 0
		counts.tbdCount = 0
		counts.preconditionfailCount = 0
		counts.validationfailCount = 0
	}

	/**
	 * update the counts to reflect existing own status
	 * Used by complete process and set result
	 */
	private def static addOwnResultStateToCount(VerificationActivityResult ar) {
		val counts = ar.metrics
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount + 1
			case VerificationResultState.FAIL:
				counts.failCount = counts.failCount + 1
			case VerificationResultState.ERROR:
				counts.errorCount = counts.errorCount + 1
			case VerificationResultState.TIMEOUT:
				counts.timeoutCount = counts.timeoutCount + 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount + 1
		}
		ar
	}

	private def static addOwnResultStateToCount(PreconditionResult ar) {
		val counts = ar.metrics
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount + 1
			case VerificationResultState.FAIL:
				counts.preconditionfailCount = counts.preconditionfailCount + 1
			case VerificationResultState.ERROR:
				counts.preconditionfailCount = counts.preconditionfailCount + 1
			case VerificationResultState.TIMEOUT:
				counts.preconditionfailCount = counts.preconditionfailCount + 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount + 1
		}
		ar
	}

	private def static addOwnResultStateToCount(ValidationResult ar) {
		val counts = ar.metrics
		switch (ar.resultState) {
			case VerificationResultState.SUCCESS:
				counts.successCount = counts.successCount + 1
			case VerificationResultState.FAIL:
				counts.validationfailCount = counts.validationfailCount + 1
			case VerificationResultState.ERROR:
				counts.validationfailCount = counts.validationfailCount + 1
			case VerificationResultState.TIMEOUT:
				counts.validationfailCount = counts.validationfailCount + 1
			case VerificationResultState.TBD:
				counts.tbdCount = counts.tbdCount + 1
		}
		ar
	}

	/**
	 * add all but the total count to the result object
	 * This method is used in the process and set result methods
	 */
	private def static void addTo(AssureResult subresult, AssureResult result) {
		if (subresult == null) return
		val counts = result.metrics
		val subcounts = subresult.metrics
		counts.failCount = counts.failCount + subcounts.failCount
		counts.successCount = counts.successCount + subcounts.successCount
		counts.errorCount = counts.errorCount + subcounts.errorCount
		counts.timeoutCount = counts.timeoutCount + subcounts.timeoutCount
		counts.thenskipCount = counts.thenskipCount + subcounts.thenskipCount
		counts.didelseCount = counts.didelseCount + subcounts.didelseCount
		counts.tbdCount = counts.tbdCount + subcounts.tbdCount
		counts.preconditionfailCount = counts.preconditionfailCount + subcounts.preconditionfailCount
		counts.validationfailCount = counts.validationfailCount + subcounts.validationfailCount
	}

	/**
	 * recompute and add the counts of the parts list to the result
	 */
	private def static void recomputeAllCounts(AssureResult result, List<? extends AssureResult> parts) {
		parts.forEach[e|e.recomputeAllCounts.addTo(result)]
	}

	def static AssuranceCaseResult recomputeAllCounts(AssuranceCaseResult caseResult) {
		caseResult.resetCounts
		caseResult.recomputeAllCounts(caseResult.modelResult)
		caseResult
	}

	def static ModelResult recomputeAllCounts(ModelResult modelResult) {
		modelResult.resetCounts
		modelResult.recomputeAllCounts(modelResult.claimResult)
		modelResult.recomputeAllCounts(modelResult.subsystemResult)
		modelResult.recomputeAllCounts(modelResult.subAssuranceCase)
		modelResult
	}

	def static SubsystemResult recomputeAllCounts(SubsystemResult subsystemResult) {
		subsystemResult.resetCounts
		subsystemResult.recomputeAllCounts(subsystemResult.claimResult)
		subsystemResult.recomputeAllCounts(subsystemResult.subsystemResult)
		subsystemResult
	}

	private def static ClaimResult recomputeAllCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.recomputeAllCounts(claimResult.verificationActivityResult)
		claimResult.recomputeAllCounts(claimResult.subClaimResult)
		claimResult
	}

	private def static VerificationActivityResult recomputeAllCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		if (vaResult.preconditionResult != null) vaResult.preconditionResult.recomputeAllCounts.addTo(vaResult)
		vaResult.addOwnResultStateToCount()
		if (vaResult.validationResult != null) vaResult.validationResult.recomputeAllCounts.addTo(vaResult)
		vaResult
	}

	private def static ElseResult recomputeAllCounts(ElseResult vaResult) {
		vaResult.resetCounts
		vaResult.didFail = ElseType.OK
		vaResult.recomputeAllCounts(vaResult.first)
		if (vaResult.first.isSuccess) {
			vaResult.recordNoElse
		} else {
			if (vaResult.first.isFailed)
				vaResult.recordElse(ElseType.FAIL)
			else if (vaResult.first.isTimeout) vaResult.recordElse(ElseType.TIMEOUT) else vaResult.recordElse(
				ElseType.ERROR)
			vaResult.recomputeAllCounts(vaResult.error)
			vaResult.recomputeAllCounts(vaResult.fail)
			vaResult.recomputeAllCounts(vaResult.timeout)
		}
		vaResult
	}

	private def static ThenResult recomputeAllCounts(ThenResult vaResult) {
		vaResult.resetCounts
		vaResult.didThenFail = false
		vaResult.recomputeAllCounts(vaResult.first)
		if (vaResult.first.isSuccess) {
			vaResult.recordSkip
			vaResult.recomputeAllCounts(vaResult.second)
		} else {
			vaResult.recordNoSkip
		}
		vaResult
	}

	private def static ValidationResult recomputeAllCounts(ValidationResult validationResult) {
		validationResult.resetCounts
		validationResult.addOwnResultStateToCount()
		validationResult
	}

	private def static PreconditionResult recomputeAllCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.addOwnResultStateToCount()
		preconditionResult
	}

	private def static AssureResult recomputeAllCounts(AssureResult assureResult) {
		switch (assureResult) {
			AssuranceCaseResult: assureResult.recomputeAllCounts
			ModelResult: assureResult.recomputeAllCounts
			SubsystemResult: assureResult.recomputeAllCounts
			ClaimResult: assureResult.recomputeAllCounts
			ValidationResult: assureResult.recomputeAllCounts
			PreconditionResult: assureResult.recomputeAllCounts
			VerificationActivityResult: assureResult.recomputeAllCounts
			ElseResult: assureResult.recomputeAllCounts
			ThenResult: assureResult.recomputeAllCounts
		}
	}

	/**
	 * methods to incrementally set the state of a verification activity and propagate the state change
	 * up the hierarchy
	 */
	def static void setToSuccess(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToSuccess(VerificationResult verificationActivityResult, String message, EObject target) {
		if (message != null && !message.isEmpty) verificationActivityResult.addSuccessIssue(target, message, null);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToSuccess(VerificationResult verificationActivityResult, List<ResultIssue> rl) {
		verificationActivityResult.issues.addAll(rl);
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.SUCCESS))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToTBD(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.TBD))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToTimeout(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.TIMEOUT))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToError(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.ERROR))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToError(VerificationResult verificationActivityResult, String message, EObject target) {
		verificationActivityResult.addErrorIssue(target, message, null);
		verificationActivityResult.setToError
	}

	def static void setToFail(VerificationResult verificationActivityResult) {
		if (verificationActivityResult.updateOwnResultState(VerificationResultState.FAIL))
			verificationActivityResult.propagateCountChangeUp
	}

	def static void setToFail(VerificationResult verificationActivityResult, String message, EObject target) {
		verificationActivityResult.addFailIssue(target, message, null);
		verificationActivityResult.setToFail
	}

	def static void setToFail(VerificationResult verificationActivityResult, List<ResultIssue> rl) {
		verificationActivityResult.issues.addAll(rl);
		verificationActivityResult.setToFail
	}

	def static void setToFail(VerificationResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addFailIssue(null, e.message ?: e.toString, null); // e.getClass().getName());
		verificationActivityResult.setToFail
	}

	def static void setToError(VerificationResult verificationActivityResult, Throwable e) {
		verificationActivityResult.addErrorIssue(null, e.message ?: e.toString, null); // e.getClass().getName());
		verificationActivityResult.setToError
	}

	def static void setToError(VerificationResult verificationActivityResult, String message) {
		verificationActivityResult.addErrorIssue(null, message, null);
		verificationActivityResult.setToError
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 */
	def static void recordElse(ElseResult result, ElseType et) {
		if (result.didFail != ElseType.OK) {
			// was didthen from previous time
		} else {
			result.didFail = et
			result.metrics.didelseCount = result.metrics.didelseCount + 1
			result.propagateCountChangeUp
		}
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 * Initial didFail is false
	 */
	def static void recordNoElse(ElseResult result) {
		if (result.didFail != ElseType.OK) {
			result.didFail = ElseType.OK
			result.metrics.didelseCount = result.metrics.didelseCount - 1
			result.propagateCountChangeUp
		} else {
			// was already no didThen
		}
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 * returns true if change of state
	 */
	def static void recordSkip(ThenResult result) {
		if (result.didThenFail) {
			// was didAndThenFail from previous time
		} else {
			result.didThenFail = true
			result.metrics.thenskipCount = result.metrics.thenskipCount + 1
			result.propagateCountChangeUp
		}
	}

	/**
	 * the next methods update the counts for FailThen and AndThen
	 * returns true if change of state
	 */
	def static void recordNoSkip(ThenResult result) {
		if (result.didThenFail) {
			result.didThenFail = false
			result.metrics.thenskipCount = result.metrics.thenskipCount - 1
			result.propagateCountChangeUp
		} else {
			// was already no didThen
		}
	}

	/**
	 * set the status and update the counts
	 * true if state changed
	 */
	def private static boolean updateOwnResultState(VerificationResult ar, VerificationResultState newState) {
		val counts = ar.metrics
		if (ar.resultState == newState) return false
	
		if (ar.resultState == VerificationResultState.FAIL && newState != VerificationResultState.TBD) return true 
		if (ar.resultState == VerificationResultState.ERROR && (newState == VerificationResultState.SUCCESS|| newState == VerificationResultState.TIMEOUT)) return true 
		if (ar.resultState == VerificationResultState.TIMEOUT && newState == VerificationResultState.SUCCESS ) return true 
	// undo old state count
			switch (ar.resultState) {
				case VerificationResultState.SUCCESS:
					counts.successCount = counts.successCount - 1
				case VerificationResultState.FAIL:
					counts.failCount = counts.failCount - 1
				case VerificationResultState.ERROR:
					counts.errorCount = counts.errorCount - 1
				case VerificationResultState.TIMEOUT:
					counts.timeoutCount = counts.timeoutCount - 1
				case VerificationResultState.TBD:
					counts.tbdCount = counts.tbdCount - 1
			}
		// do new state count
			switch (newState) {
				case VerificationResultState.SUCCESS:
					counts.successCount = counts.successCount + 1
				case VerificationResultState.FAIL:
					counts.failCount = counts.failCount + 1
				case VerificationResultState.ERROR:
					counts.errorCount = counts.errorCount + 1
				case VerificationResultState.TIMEOUT:
					counts.timeoutCount = counts.timeoutCount + 1
				case VerificationResultState.TBD: {
				}
			}
		
		ar.resultState = newState
		true
	}

	/**
	 * Given the state (and count) change to ar, propagate the counts up the hierarchy
	 */
	private def static void propagateCountChangeUp(AssureResult ar) {
		var parent = ar.eContainer
		while (parent != null && parent instanceof AssureResult) {
			val parentResult = (parent as AssureResult)
			parentResult.addAllSubCounts()
			parent = parent.eContainer
		}
	}

	/**
	 * recompute the result count from the part list counts without recursing
	 */
	private def static AssuranceCaseResult addAllSubCounts(AssuranceCaseResult caseResult) {
		caseResult.resetCounts
		caseResult.modelResult.forEach[e|e.addTo(caseResult)]
		caseResult
	}

	private def static ModelResult addAllSubCounts(ModelResult modelResult) {
		modelResult.resetCounts
		modelResult.claimResult.forEach[e|e.addTo(modelResult)]
		modelResult.subsystemResult.forEach[e|e.addTo(modelResult)]
		modelResult.subAssuranceCase.forEach[e|e.addTo(modelResult)]
		modelResult
	}

	private def static SubsystemResult addAllSubCounts(SubsystemResult subsystemResult) {
		subsystemResult.resetCounts
		subsystemResult.claimResult.forEach[e|e.addTo(subsystemResult)]
		subsystemResult.subsystemResult.forEach[e|e.addTo(subsystemResult)]
		subsystemResult
	}

	private def static ClaimResult addAllSubCounts(ClaimResult claimResult) {
		claimResult.resetCounts
		claimResult.verificationActivityResult.forEach[e|e.addTo(claimResult)]
		claimResult.subClaimResult.forEach[e|e.addTo(claimResult)]
		claimResult
	}

	private def static VerificationActivityResult addAllSubCounts(VerificationActivityResult vaResult) {
		vaResult.resetCounts
		vaResult.preconditionResult.addTo(vaResult)
		vaResult.addOwnResultStateToCount()
		vaResult.validationResult.addTo(vaResult)
		vaResult
	}

	private def static ElseResult addAllSubCounts(ElseResult vaResult) {
		vaResult.resetCounts
		vaResult.didFail = ElseType.OK
		vaResult.first.forEach[e|e.addTo(vaResult)]
		if (vaResult.first.isSuccess) {
			vaResult.recordNoElse
		} else {
			if (vaResult.first.isFailed)
				vaResult.recordElse(ElseType.FAIL)
			else if (vaResult.first.isTimeout) vaResult.recordElse(ElseType.TIMEOUT) else vaResult.recordElse(
				ElseType.ERROR)
			vaResult.error.forEach[e|e.addTo(vaResult)]
			vaResult.fail.forEach[e|e.addTo(vaResult)]
			vaResult.timeout.forEach[e|e.addTo(vaResult)]
		}
		vaResult
	}

	private def static ThenResult addAllSubCounts(ThenResult vaResult) {
		vaResult.resetCounts
		vaResult.didThenFail = false
		vaResult.first.forEach[e|e.addTo(vaResult)]
		if (vaResult.first.isSuccess) {
			vaResult.recordSkip
			vaResult.second.forEach[e|e.addTo(vaResult)]
		} else {
			vaResult.recordNoSkip
		}
		vaResult
	}

	private def static ValidationResult addAllSubCounts(ValidationResult validationResult) {
		validationResult.resetCounts
		validationResult.addOwnResultStateToCount()
		validationResult
	}

	private def static PreconditionResult addAllSubCounts(PreconditionResult preconditionResult) {
		preconditionResult.resetCounts
		preconditionResult.addOwnResultStateToCount()
		preconditionResult
	}

	private def static AssureResult addAllSubCounts(AssureResult assureResult) {
		switch (assureResult) {
			AssuranceCaseResult: assureResult.addAllSubCounts
			ModelResult: assureResult.addAllSubCounts
			SubsystemResult: assureResult.addAllSubCounts
			ClaimResult: assureResult.addAllSubCounts
			ValidationResult: assureResult.addAllSubCounts
			PreconditionResult: assureResult.addAllSubCounts
			VerificationActivityResult: assureResult.addAllSubCounts
			ElseResult: assureResult.addAllSubCounts
			ThenResult: assureResult.addAllSubCounts
		}
	}

	/**
	 * methods to retrieve messages and status 
	 * Note that the message could be in the Result object or if not present we want to get it from the 
	 * object the result object is derived from.
	 */
	def static String toTextLabel(VerificationResultState vs) {
		switch (vs) {
			case VerificationResultState.SUCCESS: return "[S]"
			case VerificationResultState.FAIL: return "[F]"
			case VerificationResultState.ERROR: return "[E]"
			case VerificationResultState.TIMEOUT: return "[T]"
			case VerificationResultState.TBD: return "[tbd]"
		}
	}

	def static constructLabel(AssureResult ar) {

		// has to be a string without space (ID) 
		switch (ar) {
			AssuranceCaseResult:
				return ar.name
			ModelResult:
				return ar.name
			SubsystemResult:
				return ar.name
			ClaimResult:
				return ar.target?.title ?: ar.target.name
			ValidationResult:
				return ar.target?.title ?: ar.target.name
			PreconditionResult:
				return ar.target?.title ?: ar.target.name
			VerificationActivityResult: {
				return ar.target.name
			}
		}
		return "unknown assure result type"
	}

	def static String constructMessage(VerificationActivityResult vr) {
		if (vr.message != null) return vr.message
		return vr.constructDescription
	}

	def static String constructDescription(VerificationActivityResult vr) {
		val va = vr.target
		if (va.title != null) return va.title
		val vm = va.method
		if (vm.description != null) return vm.description.toText(null)//va.target)
		if (vm.title != null) return vm.title
		return ""
	}

	def static String constructMessage(AssuranceCaseResult ce) {
		if(ce.message != null) return ce.message
		return ""
	}

	def static String constructMessage(ModelResult ce) {
		if(ce.message != null) return ce.message
		return ""
	}

	def static String constructMessage(SubsystemResult ce) {
		if(ce.message != null) return ce.message
		return ""
	}

	def static String constructDescription(ModelResult ar) {
		val plan = ar.plan
		if (plan?.description != null) return plan.description.toText(plan.target)
		if (plan.title != null) return plan.title
		"Verified system implementation "+plan.target.getQualifiedName()
	}

	def static String getName(VerificationActivityResult cr) {
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name
		}
		return "[unresolved:" + cr.target.toString + "]"
	}

	def static String getName(ValidationResult cr) {
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name
		}
		return "[unresolved:" + cr.target.toString + "]"
	}

	def static String getName(PreconditionResult cr) {
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name
		}
		return "[unresolved:" + cr.target.toString + "]"
	}

	def static String getName(AssuranceCaseResult ce) {
		return ce.name
	}

	def static String getName(ModelResult ce) {
		return ce.assuranceCaseResult.name+'.'+ce.plan.getName
	}

	def static String getName(SubsystemResult ce) {
		return ce.targetSystem
	}

	def static String getName(ClaimResult cr) {
		if (!Aadl2Util.isNull(cr.target)) {
			return cr.target?.name
		}
		return "[unresolved:" + cr.target.toString + "]"
	}

	def static String constructDescription(ClaimResult cr) {
		val r = cr.target
		if (r.description != null) return r.description.toText(cr.claimSubject)
		if (r.title != null) return r.title
		""
	}

	def static String constructMessage(ClaimResult cr) {
		if (cr.message != null) return cr.message
		constructDescription(cr)
	}

	def static String constructMessage(ValidationResult cr) {
		if(cr.message != null) return cr.message
		""
	}

	def static String constructMessage(PreconditionResult cr) {
		if(cr.message != null) return cr.message
		""
	}

	def static String constructMessage(ResultIssue ri) {
		if (ri.message != null) return ri.message +
			if (ri.exceptionType != null) ( " [" + ri.exceptionType + "]" ) else ""
		if (ri.exceptionType != null) return ri.exceptionType
		""
	}

	def static String assureResultCounts(AssureResult ele) {
		val elec= ele.metrics
		if (ele instanceof AssuranceCaseResult && ele.isZeroCount && ele.eContainer == null){
			ele.resetCounts
			ele.recomputeAllCounts
		}
		" (S" + elec.successCount + " F" + elec.failCount + " T" + elec.timeoutCount + " E" + elec.errorCount + " tbd" +
			elec.tbdCount + " EL" + elec.didelseCount + " TS" + elec.thenskipCount + ")"
	}


	def static String assureExecutionTime(AssureResult ele) {
		val elec= ele.metrics
		"("+elec.executionTime+" ms)"
	}

	// manage instance model generation
	static val instanceModelRecord = Collections.synchronizedMap(newHashMap)

	def static void setInstanceModel(ComponentImplementation key, SystemInstance target) {
		instanceModelRecord.put(key.name, target)
	}

	def static void clearAllInstanceModels() {
		instanceModelRecord.clear
	}

	def static SystemInstance getInstanceModel(ComponentImplementation cimpl) {
		if (Aadl2Util.isNull(cimpl)) return null
		var si = instanceModelRecord.get(cimpl.name) as SystemInstance
		if (si == null) {
			System.out.println("Instantiating "+cimpl.getQualifiedName())
			si = cimpl.buildInstanceModelFile
			setInstanceModel(cimpl, si)
		}
		return si
	}
	
	def static int  numberVerificationResults(AssuranceCaseResult ac){
		return EcoreUtil2.eAllOfType(ac, typeof(VerificationActivityResult)).size();
	}

	def static Object convertToJavaObjects(EObject actual) {
		switch (actual) {
			IntegerLiteral: return actual.scaledValue
			RealLiteral: return actual.scaledValue
			StringLiteral: return actual.value
			BooleanLiteral: return actual.isValue
		}
	}

	def static NumberValue convertValueToUnit(NumberValue numberValue, UnitLiteral target) {
		val value = numberValue.scaledValue;
		val unit = numberValue.getUnit();
		var factor = 1.0
		if (unit != null) factor = unit.getAbsoluteFactor(target);
		val result = value * factor;
		val resultValue = numberValue.cloneNumber();
		resultValue.setUnit(target);
		setValue(resultValue, result);
		return resultValue;
	}

	def static void setValue(NumberValue numberValue, double value) {
		switch (numberValue) {
			RealLiteral: numberValue.setValue(value)
			IntegerLiteral: numberValue.setValue((value as long))
		}
	}

}
