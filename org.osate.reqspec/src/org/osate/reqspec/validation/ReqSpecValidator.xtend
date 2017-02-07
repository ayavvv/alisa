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

/*
 * generated by Xtext
 */
package org.osate.reqspec.validation

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.NamedElement
import org.osate.aadl2.SystemImplementation
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.alisa.common.util.CommonUtilExtension
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.DocumentSection
import org.osate.reqspec.reqSpec.GlobalConstants
import org.osate.reqspec.reqSpec.GlobalRequirementSet
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.IncludeGlobalRequirement
import org.osate.reqspec.reqSpec.ReqDocument
import org.osate.reqspec.reqSpec.ReqSpec
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.RequirementSet
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class ReqSpecValidator extends AbstractReqSpecValidator {

  public static val MISSING_STAKEHOLDER = 'missingStakeholder'
  public static val MISSING_STAKEHOLDER_GOAL = 'missingStakeholderGoal'
  public static val MULTIPLE_CLASSIFIERS = 'multipleClassifiers'
  public static val FEATURES_WITHOUT_REQUIREMENT = 'featuresWithoutRequirement'
  public static val DUPLICATE_GOAL_WITHIN_STAKEHOLDER_GOALS = 'org.osate.reqspec.validation.duplicate.goal.within.stakeholdergoals'
  public static val DUPLICATE_STAKEHOLDER_GOALS = 'org.osate.reqspec.validation.duplicate.stakeholdergoals'
  public static val REQSPEC_FOR_DIFFERS_FROM_STAKEHOLDERGOALS_FOR = 'org.osate.reqspec.validation.reqspec.for.differs.from.stakeholdergoals.for'
  public static val GOAL_REFERENCE_NOT_FOUND = 'org.osate.reqspec.validation.goal.reference.not.found'
  public static val DUPLICATE_REQUIREMENTS = 'org.osate.reqspec.validation.duplicate.requirements'
  public static val DUPLICATE_REQUIREMENT_WITHIN_REQUIREMENTS = 'org.osate.reqspec.validation.duplicate.requirement.within.requirements'
  public static val CYCLE_IN_GOAL_REFINE_HIERARCHY = 'org.osate.reqspec.validation.cycle.in.goal.refine.hierarchy'
  public static val CYCLE_IN_REQUIREMENT_REFINE_HIERARCHY = 'org.osate.reqspec.validation.cycle.in.requirement.refine.hierarchy'
  public static val ILLEGAL_OBJECT_FOR_FILETYPE_IN_DOCUMENTSECTION = 'org.osate.reqspec.validation.illegal.object.for.filetype.in.documentsection'
  public static val ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQSPEC = 'org.osate.reqspec.validation.illegal.object.for.filetype.in.reqspec'
  public static val ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQDOCUMENT = 'org.osate.reqspec.validation.illegal.object.for.filetype.in.reqdocument'
  public static val REQSPEC_FILE_EXT = "reqspec"
  public static val GOALS_FILE_EXT = "goals"
  public static val REQDOC_FILE_EXT = "reqdoc"
  public static val GOALDOC_FILE_EXT = "goaldoc"
  public static val CONSTANTS_FILE_EXT = "constants"
  public static val INCORRECT_GLOBAL_REQUIREMENT_INCLUDE = "org.osate.reqspec.validation.incorrect.global.requirement.include"
  public static val DUPLICATE_GLOBALREQUIREMENTS = 'org.osate.reqspec.validation.duplicate.globalrequirements'


	@Check//(CheckType.EXPENSIVE)
	def void checkMissingStakeholder(Goal goal) {
		if (goal.stakeholderReference.empty) {
			if (goal.refinesReference.empty){
			warning('Goal should have stakeholders', 
					ReqSpecPackage.Literals.GOAL__STAKEHOLDER_REFERENCE,
					MISSING_STAKEHOLDER)
			} else {
				goal.refinesReference.forEach[checkMissingStakeholder]
			}		
		}
	}
	
	@Check(CheckType.EXPENSIVE)
	def void checkMissingGoal(Requirement req) {
		if (req.goalReference.empty  ) {
			if (req.refinesReference.empty){ 
			warning('System requirement should have stakeholder goal or requirement reference', 
					ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__GOAL_REFERENCE,
					MISSING_STAKEHOLDER_GOAL)
			} else {
				req.refinesReference.forEach[checkMissingGoal]
			}		
		}
	}

	
	@Check(CheckType.EXPENSIVE)
	def void checkMultipleSystems(ReqDocument reqdoc) {
		val syslist = new BasicEList<Classifier>
		reqdoc.content.forEach[e | if (e instanceof ContractualElement) syslist += e.targetClassifier]
		if (syslist.size > 1){
			val cls = syslist.map[name].reduce[p1, p2| p1 + ' ' + p2]
			warning('Requirements cover multiple classifiers: '+cls, 
					ReqSpecPackage.Literals.REQ_DOCUMENT__CONTENT,
					MULTIPLE_CLASSIFIERS)
		}
	}
	
		@Check(CheckType.EXPENSIVE)
	def void checkMultipleSystems(DocumentSection docsection) {
		val syslist = new BasicEList<Classifier>
		docsection.content.forEach[e | if (e instanceof ContractualElement) syslist += e.targetClassifier]
		if (!syslist.empty){
			val cls = syslist.map[name].reduce[p1, p2| p1 + ' ' + p2]
			warning('Requirements cover multiple classifiers: '+cls, 
					ReqSpecPackage.Literals.DOCUMENT_SECTION__CONTENT,
					MULTIPLE_CLASSIFIERS)
		}
	}
	
		@Check(CheckType.EXPENSIVE)
	def void checkFeatureCoverage(SystemRequirementSet sysreqs) {
		val cl = sysreqs.target
		if (cl === null || cl.getAllFeatures.empty ) return
		
		val fealist = new BasicEList<NamedElement>
		cl.getAllFeatures.forEach[e| if (!sysreqs.requirements.exists[r| r.targetElement == e ]) fealist += e]
		if (!fealist.empty){
			val fls = sysreqs.requirements.map[name].reduce[p1, p2| p1 + ' ' + p2]
			warning('Features without requirement: '+fls, 
					ReqSpecPackage.Literals.REQUIREMENT_SET__REQUIREMENTS,
					FEATURES_WITHOUT_REQUIREMENT)
		}
	}
	
	
		@Check(CheckType.NORMAL)
	def void checkDuplicateGoal(StakeholderGoals stakeHolderGoals) {
		stakeHolderGoals.goals.forEach[goal | 
			if (stakeHolderGoals.goals.filter[name == goal.name].size > 1) 
				error("Duplicate goal name '" + goal.name + "' in StakeholderGoals '" + stakeHolderGoals.name + "'",  
					goal, ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME,
					DUPLICATE_GOAL_WITHIN_STAKEHOLDER_GOALS, EcoreUtil.getURI(stakeHolderGoals).toString()
				)
		] 
	}
	
@Inject ICommonGlobalReferenceFinder refFinder

//	@Check(CheckType.FAST)
//	def void checkDuplicateGlobalReq(GlobalRequirementSet globalReqs) {
//		val dupes = refFinder.getDuplicates(globalReqs)
//		if (dupes.size > 0) {
//			val node = NodeModelUtils.getNode(globalReqs);
//			error("Duplicate Global Requirements name '" + globalReqs.name + "'",  
//				ReqSpecPackage.Literals.REQUIREMENTS__NAME, DUPLICATE_GLOBALREQUIREMENTS,
//				"" + node.offset, "" + node.length)
//		}
//	}


	@Check(CheckType.NORMAL)
	def void checkDuplicateStakeholderGoals(StakeholderGoals shg) {
		val dupes = refFinder.getDuplicates(shg)
			if (dupes.size > 0) {
				val node = NodeModelUtils.getNode(shg);
				error("Duplicate StakeholderGoal name '" + shg.name + "'",  
					shg, ReqSpecPackage.Literals.REQ_ROOT__NAME,
					DUPLICATE_STAKEHOLDER_GOALS, "" + node.offset, "" + node.length)
			}
	}
	
	@Check(CheckType.FAST)
	def void checkDuplicateRequirements(RequirementSet sysReq) {
		val dupes = refFinder.getDuplicates(sysReq)
			if (dupes.size > 0) {
				val node = NodeModelUtils.getNode(sysReq);
				error("Duplicate Requirements name '" + sysReq.name + "'",  
					sysReq, ReqSpecPackage.Literals.REQ_ROOT__NAME,
					DUPLICATE_REQUIREMENTS, "" + node.offset, "" + node.length)
			}
	}
	@Check(CheckType.NORMAL)
	def void checkDuplicateRequirement(RequirementSet sysReq) {
		sysReq.requirements.forEach[requirement | 
			if (sysReq.requirements.filter[name == requirement.name].size > 1) 
				error("Duplicate requirement name '" + requirement.name + "' in requirements '" + sysReq.name + "'",  
					requirement, ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME,
					DUPLICATE_REQUIREMENT_WITHIN_REQUIREMENTS, EcoreUtil.getURI(sysReq).toString()
				)
		] 
	}

	@Check(CheckType.NORMAL)
	def void checkSpecGoalTargetConsistency(SystemRequirementSet sysReqs) {
		val reqSpecTarget = sysReqs.target
		val requirements = sysReqs.requirements
		val resource = sysReqs.eResource();

		requirements.forEach[requirement | 
			val goalReferences = requirement.goalReference
			goalReferences.forEach[goalRef | 
				val goalRefResolved = 
					switch goalRef {
						case !goalRef.eIsProxy : goalRef
						case goalRef.eIsProxy && EcoreUtil.resolve(goalRef,  resource.resourceSet).eIsProxy : null
						default : EcoreUtil.resolve(goalRef,  resource.resourceSet)
					} as Goal
				if (goalRefResolved !== null && goalRefResolved.targetClassifier !== null 
					&& !CommonUtilExtension.isSameorExtends(reqSpecTarget,goalRefResolved.targetClassifier )){
						val goalTargetName = goalRefResolved.targetClassifier.name
						val goalTargetURI = EcoreUtil.getURI(goalRefResolved.targetClassifier).toString();
						error("System Requirement '" +  sysReqs.name + 
								"' is not for the same component as the StakeholderGoals that " +
								"holds the goal that corresponds to requirement '" + requirement.name + "'", sysReqs,  
								ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET__TARGET, REQSPEC_FOR_DIFFERS_FROM_STAKEHOLDERGOALS_FOR,
								sysReqs.target.name, goalTargetName, goalTargetURI )
				}
				
			]
		]
	}

	@Check(CheckType.FAST)
	def void checkGoalForCycles(Goal goal) {
		val  goalList = new ArrayList<Goal>()
		goalList.add(goal)
		goal.refinesReference.forEach[refinedGoal, index|
			goalList.add(refinedGoal)
			if(refinedGoal.checkGoalForCycles(goalList)){
				error("A circular dependency or dependencies exists in the 'refined' hierarchy of " + goal.getName() + ".", 
						goal, ReqSpecPackage.Literals.GOAL__REFINES_REFERENCE, index, CYCLE_IN_GOAL_REFINE_HIERARCHY, 
						refinedGoal.name, EcoreUtil.getURI(refinedGoal).toString())
			}
			goalList.remove(goalList.size - 1)
		]
	}


	def private boolean checkGoalForCycles(Goal goal, List<Goal> goalList) {
		val refinedGoals = goal.getRefinesReference()
		refinedGoals.exists[refinedGoal | goalList.contains(refinedGoal)] || refinedGoals.exists[refinedGoal |
			goalList.add(refinedGoal)
			val cycles = refinedGoal.checkGoalForCycles(goalList)
			goalList.remove(goalList.size - 1)
			return cycles
		]
	}		

	@Check(CheckType.FAST)
	def void checkRequirementForCycles(Requirement requirement) {
		val  reqList = new ArrayList<Requirement>()
		reqList.add(requirement)
		requirement.refinesReference.forEach[refinedReq, index|
			reqList.add(refinedReq)
			if(refinedReq.checkRequirementForCycles(reqList)){
				error("A circular dependency or dependencies exists in the 'refined' hierarchy of " + requirement.getName() + ".", 
						requirement, ReqSpecPackage.Literals.REQUIREMENT__REFINES_REFERENCE, index, CYCLE_IN_REQUIREMENT_REFINE_HIERARCHY,
						refinedReq.name, EcoreUtil.getURI(refinedReq).toString())
			}
			reqList.remove(reqList.size - 1)
		]
	}

	def private boolean checkRequirementForCycles(Requirement requirement, List<Requirement> reqList) {
		val refinedReqs = requirement.getRefinesReference()
		refinedReqs.exists[refinedReq | reqList.contains(refinedReq)] || refinedReqs.exists[refinedReq |
			reqList.add(refinedReq)
			val cycles = refinedReq.checkRequirementForCycles(reqList)
			reqList.remove(reqList.size - 1)
			return cycles
		]
	}	
	@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder
		
	@Check(CheckType.EXPENSIVE)
	def void checkCoverage(StakeholderGoals shgs) {
		val target = shgs.target
		if (!SystemImplementation.isInstance(target)){ return }
		val sysReqs = reqSpecrefFinder.getSystemRequirementSets(target)
		shgs.goals.forEach[goal | 
			if (!sysReqs.exists[sysReq | sysReq.requirements.exists[goalReference.exists[goalRef | goalRef === goal]]]){
				error("Goal " + goal.name + " does not have a corresponding System Requirement.", 
						goal, ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME)
			}
		]
	}
	
	@Check (CheckType.FAST)
	def void checkFileTypeContents(ReqSpec reqSpec) {
		val reqSpecURI =EcoreUtil.getURI(reqSpec)
		val fileExt = reqSpecURI.fileExtension.toLowerCase
		val parts = reqSpec.parts
		switch fileExt{
			case REQSPEC_FILE_EXT : {
				parts.forEach[part |
					switch part {
						SystemRequirementSet : {}
						GlobalRequirementSet : {}
//						StakeholderGoals : fileTypeWarning(fileExt, "stakeholder goals", part)	
//						ReqDocument : fileTypeWarning(fileExt, "document", part)	
						GlobalConstants : fileTypeWarning(fileExt, "constants", part)
						default : fileTypeWarning(fileExt, part.class.name, part)
					}
				]
			}
			case GOALS_FILE_EXT : {
				parts.forEach[part |
					switch part {
						StakeholderGoals : {}
						SystemRequirementSet : fileTypeWarning(fileExt, "system requirements", part)	
						ReqDocument : fileTypeWarning(fileExt, "document", part)	
						GlobalConstants : fileTypeWarning(fileExt, "constants", part)
						default : fileTypeWarning(fileExt, part.class.name, part)
					}
				]
			} 
			case REQDOC_FILE_EXT : {
				parts.forEach[part |
					switch part {
						ReqDocument : {
							val reqDocContent = part.content
							reqDocContent.forEach[element |
								switch element {
									Requirement : {}
									Goal : fileTypeWarning(fileExt, "goal" , element)
									DocumentSection : checkRecDocSection(element)
									default : fileTypeWarning(fileExt, element.class.name, element)
								}
							]
						}	
						SystemRequirementSet : fileTypeWarning(fileExt, "system requirements", part)	
						GlobalRequirementSet : fileTypeWarning(fileExt, "global requirements", part)	
						GlobalConstants : fileTypeWarning(fileExt, "constants", part)
						StakeholderGoals : fileTypeWarning(fileExt, "stakeholder goals", part)	
						default : fileTypeWarning(fileExt, part.class.name, part)
					}
				]
			}
			case GOALDOC_FILE_EXT : {
				parts.forEach[part |
					switch part {
						ReqDocument : {
							val reqDocContent = part.content
							reqDocContent.forEach[element |
								switch element {
									Goal : {}
									Requirement : fileTypeWarning(fileExt, "requirement" , element)
									DocumentSection : checkGoalDocSection(element)
									default : fileTypeWarning(fileExt, element.class.name, element)
								}
							]
						}	
						SystemRequirementSet : fileTypeWarning(fileExt, "system requirements", part)	
						GlobalRequirementSet : fileTypeWarning(fileExt, "global requirements", part)	
						GlobalConstants : fileTypeWarning(fileExt, "constants", part)
						StakeholderGoals : fileTypeWarning(fileExt, "stakeholder goals", part)	
						default : fileTypeWarning(fileExt, part.class.name, part)
					}
				]
			}
			case CONSTANTS_FILE_EXT : {
				parts.forEach[part |
					switch part {
						GlobalConstants : {}
						SystemRequirementSet : fileTypeWarning(fileExt, "system requirements", part)	
						GlobalRequirementSet : fileTypeWarning(fileExt, "global requirements", part)	
						StakeholderGoals : fileTypeWarning(fileExt, "stakeholder goals", part)	
						ReqDocument : fileTypeWarning(fileExt, "document", part)	
						default : fileTypeWarning(fileExt, part.class.name, part)
					}
				]
			}
			
			default : {}
		}
	}	
	def void fileTypeWarning(String fileType, String partName, EObject part){
		warning( partName +" not allowed in '"+ fileType + "' file.", part, null)
	}
	/** TODO: These methods invoke the QuickFixes, not using yet do to unexpected behavior: 
	 * 		  when removing illegal stakeholder goal from reqspec, the SystemsRequirementSet elements re-order in a way causing an error
	def void fileTypeError(String fileType, String partName, EObject part, ReqSpec parent){
		error( partName +" not allowed in '"+ fileType + "' file.", part, null, ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQSPEC, partName, EcoreUtil.getURI(parent).toString())
	}
	def void fileTypeError(String fileType, String partName, EObject part, ReqDocument parent){
		error( partName +" not allowed in '"+ fileType + "' file.", part, null, ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQDOCUMENT, partName, EcoreUtil.getURI(parent).toString())
	}
	def void fileTypeError(String fileType, String partName, EObject part, DocumentSection parent){
		error( partName +" not allowed in '"+ fileType + "' file.", part, null, ILLEGAL_OBJECT_FOR_FILETYPE_IN_DOCUMENTSECTION, partName, EcoreUtil.getURI(parent).toString())
	}
	 */
	def void checkRecDocSection(DocumentSection section){
		val contents = section.content
		contents.forEach[element |
			switch element {
				Requirement : {}
				Goal : fileTypeWarning(REQDOC_FILE_EXT,  "goal" , element)
				DocumentSection : checkRecDocSection(element)
				default : fileTypeWarning(REQDOC_FILE_EXT, element.class.name, element)
			}
		]
	}
	def void checkGoalDocSection(DocumentSection section){
		val contents = section.content
		contents.forEach[element |
			switch element {
				Goal : {}
				Requirement : fileTypeWarning(GOALDOC_FILE_EXT,  "requirement" , element)
				DocumentSection : checkGoalDocSection(element)
				default : fileTypeWarning(GOALDOC_FILE_EXT, element.class.name, element)
			}
		]
	}
	
	@Check//(CheckType.FAST)
	def void checkSystemRequirementsUniqueToComponentClassifier(SystemRequirementSet sysReq) {
		val target = sysReq.target
		val allSystemRequirements = reqSpecrefFinder.getSystemRequirementSetsNoExtends(target)
		if (allSystemRequirements.size > 1){
			error("Other System Requirements exist for '" +  target.name + 
								"'. Only one System Requirement is allowed for a specific component." , sysReq,  
								ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET__TARGET)
		}
	}
	
	@Check//(CheckType.FAST)
	def void checkStakeholderGoalsUniqueToComponentClassifier(StakeholderGoals shg) {
		val target = shg.target
		val allStakeholderGoals = reqSpecrefFinder.getStakeholderGoals(target)
		if (allStakeholderGoals.size > 1){
			error("Other Stakeholder Goals exist for '" +  target.name + 
								"'. Only one Stakeholder Goals is allowed for a specific component." , shg,  
								ReqSpecPackage.Literals.STAKEHOLDER_GOALS__TARGET)
		}
	}

	@Check//(CheckType.FAST)
	def void checkRequirementShadowing(Requirement req){
		val reqName = req.name.toLowerCase
		val reqEvolvesReferences = req.evolvesReference
		val containingSysReqs = req.containingRequirementSet
		if (containingSysReqs instanceof SystemRequirementSet){
		val componentClassifier = containingSysReqs.target
		val classifierParents = new ArrayList<ComponentClassifier>

		componentClassifier.buildExtended(classifierParents)
		
		var ComponentType compType
		if (componentClassifier instanceof ComponentImplementation)	 compType = componentClassifier.type
		classifierParents.toSet.toList.forEach[ classifierParent |
			reqSpecrefFinder.getSystemRequirementSets(classifierParent).forEach[ sysreqs |
				if (sysreqs.requirements.exists[r| r.name.toLowerCase == reqName && !r.dropped && !reqEvolvesReferences.contains(r)]){
					error("Requirement '" + req.name + "' for '" + componentClassifier.name + 
							"' shadows a requirement of the same name in the System Requirements for '" +
							classifierParent.name + "'. Shadowing '" + reqName + "' must evolve original or original '" + 
							reqName + "' must be tagged as 'dropped'", req,  
								ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME)
				}
			]
		]
			
		}
	}

	def void buildExtended(ComponentClassifier compClassifier, List<ComponentClassifier> ancestors){
		var ext = compClassifier.extended
		if (ext !== null && ext instanceof ComponentClassifier) {
			ancestors.add(ext as ComponentClassifier)
			(ext as ComponentClassifier).buildExtended(ancestors)
		}
		if (compClassifier instanceof ComponentImplementation){
			var type = compClassifier.type
			ancestors.add(type)
			type.buildExtended(ancestors)
		}
	}
	
	@Check(CheckType.FAST)
	def void checkRequirementRefinement(Requirement req){
		switch req {
			case req.refinesReference.nullOrEmpty : {}
			case req.refinesReference.head.containingRequirementSet === req.containingRequirementSet : {}
			default : {
				val classifierParents = new ArrayList<ComponentClassifier>
				val reqs = req.containingRequirementSet
				if (reqs instanceof SystemRequirementSet){
				reqs.target.buildExtended(classifierParents)
				val refinedreqs = req.refinesReference.head.containingRequirementSet
				if (refinedreqs instanceof SystemRequirementSet){
				if (classifierParents.contains(refinedreqs.target)) return;
				error("Requirement '" + req.name + "' refined from '" + req.refinesReference.head.name + 
						"' and must either be in the same System Requirements or '" +
						req.name + "' must be for an extension or implementation of the component '" + 
						req.refinesReference.head.name + "' is for. '", req,  
						ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME)
				}
				}
			}	
		}
	}

	
	@Check(CheckType.FAST)
	def void checkIncludeGlobalRequirement(IncludeGlobalRequirement igr) {
		if (!(igr.include instanceof GlobalRequirementSet || igr.include instanceof Requirement)){
			error("Must include global requirements or requirement in global requirements." , igr,  
								ReqSpecPackage.Literals.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE, INCORRECT_GLOBAL_REQUIREMENT_INCLUDE)
		}
	}
	
		
}
