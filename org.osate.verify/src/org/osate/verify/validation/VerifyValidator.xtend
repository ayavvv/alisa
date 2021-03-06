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
package org.osate.verify.validation

import com.google.inject.Inject
import com.rockwellcollins.atc.resolute.resolute.BaseType
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.PropertyType
import org.osate.alisa.common.common.PropertyRef
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.verify.typing.validation.VerifyTypeSystemValidator
import org.osate.verify.util.IVerifyGlobalReferenceFinder
import org.osate.verify.util.VerificationMethodDispatchers
import org.osate.verify.verify.Claim
import org.osate.verify.verify.JUnit4Method
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.PluginMethod
import org.osate.verify.verify.ResoluteMethod
import org.osate.verify.verify.Verification
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationCondition
import org.osate.verify.verify.VerificationMethod
import org.osate.verify.verify.VerificationMethodRegistry
import org.osate.verify.verify.VerificationPlan
import org.osate.verify.verify.VerifyPackage

/**
 * Custom validation rules. 
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class VerifyValidator extends VerifyTypeSystemValidator {

	public static val INCORRECT_METHOD_PATH = "org.osate.verify.incorrectMethodPath"
	public static val INCORRECT_CLASS_PATH = "org.osate.verify.incorrectClassPath"
	public static val INCORRECT_METHOD_REFERENCE = "org.osate.verify.incorrectMethodReference"
	public static val MISSING_METHOD_REFERENCE = "org.osate.verify.missingMethodReference"
	public static val INCORRECT_METHOD_ID = "org.osate.verify.incorrectMethodID"
	public static val CLAIM_MISSING_REQUIREMENT = "org.osate.verify.claimMissingRequirement"
	public static val CLAIM_INVALID_REQUIREMENT = "org.osate.verify.claimInvalidRequirement"
	public static val MISSING_CLAIM_FOR_REQ = "org.osate.verify.missingClaimForReq"
	public static val MISSING_CLAIM_FOR_MULTIPLE_REQ = "org.osate.verify.missingClaimForMultipleReq"
	public static val CLAIM_REQ_FOR_NOT_VP_FOR = "org.osate.verify.claimReqForNotVpFor"
	public static val ILLEGAL_OBJECT_FOR_FILETYPE = "org.osate.verify.illegal.object.for.filetype"
	public static val MISSING_REQUIREMENTS_FOR_MULTIPLE_CLAIMS = "org.osate.verify.missingRequirementsForMultipleClaims"
	public static val MULTIPLE_CLAIMS_WITH_DUPLICATE_REQUIREMENTS = "org.osate.verify.multipleClaimsWithDuplicateRequirements"
	public static val METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION = "org.osate.verify.METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION"

	override protected List<EPackage> getEPackages() {
		val List<EPackage> result = new ArrayList<EPackage>(super.getEPackages())
		result.add(VerifyPackage.eINSTANCE)
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://aadl.info/AADL/2.0"))
		return result
	}

	@Inject IVerifyGlobalReferenceFinder verifyGlobalRefFinder

	@Check
	def checkMethodPath(JavaMethod method) {
		val result = VerificationMethodDispatchers.eInstance.methodExists(method)
		if (result !== null) {
			warning("Could not find method: " + result, VerifyPackage.Literals.JAVA_METHOD__METHOD_PATH,
				INCORRECT_METHOD_PATH)
		}
	}

	@Check
	def checkClassPath(JUnit4Method method) {
		val result = VerificationMethodDispatchers.eInstance.classExists(method.classPath)
		if (result !== null) {
			warning("Could not find JUnit4 test class: " + result, VerifyPackage.Literals.JUNIT4_METHOD__CLASS_PATH,
				INCORRECT_CLASS_PATH)
		}
	}

	@Check
	def checkMethodID(PluginMethod method) {
		val result = VerificationMethodDispatchers.eInstance.dispatchVerificationMethod(method, null, null)
		if (result === null) {
			warning('Plugin verification method ID not found', VerifyPackage.Literals.PLUGIN_METHOD__METHOD_ID,
				INCORRECT_METHOD_ID)
		}
	}

	@Check
	def checkMethodReference(VerificationCondition cond) {
		if (cond.method === null) {
			warning('Verification precondition or validation should have a verification method reference',
				VerifyPackage.Literals.VERIFICATION_CONDITION__METHOD, MISSING_METHOD_REFERENCE)
		}
	}

	@Check
	def checkMissingMethodReference(VerificationActivity va) {
		if (va.method === null) {
			warning('Verification activity should have a method reference',
				VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD, MISSING_METHOD_REFERENCE)
		}
	}

	@Check(CheckType.NORMAL)
	def checkVerificationActivityParams(VerificationActivity va) {
		val actualParameters = va.actuals
		val method = va.method
		val expectedParms = method.formals
		if ((expectedParms?.size != actualParameters?.size)) {
			warning(
				"The number of actual parameters differs from the number of formal parameters for verification activity",
				va, VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD)
		}
	}

	@Check(CheckType.FAST)
	def checkForDuplicateClaims(VerificationPlan vp) {
		val claims = vp.claim
		claims.forEach[EcoreUtil.resolveAll(it)]
		val vpUri = EcoreUtil.getURI(vp).toString()
		claims.forEach [ claim |
			val possibleDuplicates = claims.filter[it != claim && it.requirement == claim.requirement]
			if (possibleDuplicates.size > 0) {
				val duplicateUris = new ArrayList<String>()
				duplicateUris.add(vpUri)
				duplicateUris.add(claim.requirement.name)
				possibleDuplicates.forEach[duplicateUris.add(EcoreUtil.getURI(it).toString())]
				warning('Multiple Claims with duplicate Requirements', claim, VerifyPackage.Literals.CLAIM__REQUIREMENT,
					MULTIPLE_CLAIMS_WITH_DUPLICATE_REQUIREMENTS, duplicateUris)
			}
		]
	}

	@Check(CheckType.FAST)
	def checkMultipleInvalidRequirementsForClaims(VerificationPlan vp) {

		val claims = vp.claim
		claims.forEach[EcoreUtil.resolveAll(it)]
		val sysreqs = vp.requirementSet
		val sysreqsContent = sysreqs.requirements
		val vpURI = EcoreUtil.getURI(vp).toString()
		val claimsRequirements = claims.map[requirement].toSet
		val requirementsWithoutClaims = sysreqsContent.filter[!claimsRequirements.contains(it)]
		val organizeClaims = requirementsWithoutClaims.size > 0

		val claimsMissingRequirements = claims.filter[it.requirement === null]
		val missingReqURIs = new ArrayList<String>()
		requirementsWithoutClaims.forEach [ req |
			missingReqURIs.add(EcoreUtil.getURI(req).toString())
		]

		val claimsRequirementsUnresolved = claims.filter[claim|claim?.requirement !== null && claim.requirement.eIsProxy]
		val claimsWithMissingReqs = new ArrayList<Claim>()

		claimsMissingRequirements.forEach [ cl |
			if (!organizeClaims) {
				error('Claim is missing requirement', cl, null, CLAIM_MISSING_REQUIREMENT, vpURI)
			} else {
				claimsWithMissingReqs.add(cl)
			}
		]
		claimsRequirementsUnresolved.forEach [ cl |
			if (!organizeClaims) {
				var reqName = cl.requirement.name ?: ""
				if (reqName.length > 0) reqName = reqName + " "
				error('Requirement ' + reqName + 'does not exist in ' + sysreqs.name + '.', cl,
					VerifyPackage.Literals.CLAIM__REQUIREMENT, CLAIM_INVALID_REQUIREMENT, vpURI)
			} else {
				claimsWithMissingReqs.add(cl)
			}
		]

		if (claimsWithMissingReqs.size > 0) {
			val String[] uris = missingReqURIs

			error('Claims with missing or unresolved Requirements', vp, VerifyPackage.Literals.VERIFICATION_PLAN__NAME,
				MISSING_REQUIREMENTS_FOR_MULTIPLE_CLAIMS, uris)
		}
	}

	@Check(CheckType.NORMAL)
	def checkClaimsForRequirement(VerificationPlan vp) {
		val systemRequirements = vp.requirementSet
		val requirements = systemRequirements.requirements
		requirements.forEach [ req |
			if (req.refinesReference.empty) {
				if (!vp.claim.exists[claim|claim.requirement === req]) {
					warning('No claim for requirement ' + req.name, vp, VerifyPackage.Literals.VERIFICATION_PLAN__NAME,
						MISSING_CLAIM_FOR_REQ, req.name, EcoreUtil.getURI(req).toString())
				}
			}
		]
	}

	@Check(CheckType.NORMAL)
	def checkClaimsForMultipleRequirement(VerificationPlan vp) {
		val systemRequirements = vp.requirementSet
		val requirements = systemRequirements.requirements
		val List<String> missingRequirements = new ArrayList<String>
		requirements.forEach [ req |
			if (req.refinesReference.empty && !vp.claim.exists[claim|claim.requirement === req]) {
				missingRequirements.add(EcoreUtil.getURI(req).toString())
			}
		]
		if (missingRequirements.size > 1) {
			warning('Missing claims for multiple requirements', vp, VerifyPackage.Literals.VERIFICATION_PLAN__NAME,
				MISSING_CLAIM_FOR_MULTIPLE_REQ, missingRequirements)

		}
	}

	@Check(CheckType.FAST)
	def void checkVerificationMethodSignature(VerificationMethod vm) {
		switch methodKind : vm.methodKind {
			ResoluteMethod: {
				val fparams = vm.formals
				val aparams = methodKind.methodReference.args
				val methodRefName = methodKind.methodReference.name
				val hasComponentType = vm.targetType !== null
				val fcount = if (hasComponentType) {
						fparams.size + 1
					} else {
						fparams.size
					}
				if (fcount != aparams.size) {
					warning(
						"method " + vm.name +
							"'s number of parameters does not match the number of arguments for the Resolute method " +
							methodRefName, vm, VerifyPackage.Literals.VERIFICATION_METHOD__NAME,
							METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION)
							return
						}
						val i = if (hasComponentType) {
								1
							} else {
								0
							}
						fparams.forEach [ vmParm, j |
							val aparam = aparams.get(j + i)
							val baseType = aparam.type as BaseType
							if (!matchResoluteType(vmParm.type, baseType)) {
								warning(
									"method " + vm.name + "'s parameter " + vmParm.name +
										" does not match the type of " + aparam.name + " in the Resolute method " +
										methodRefName, vm, VerifyPackage.Literals.VERIFICATION_METHOD__NAME,
										METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION)
										return
									}
								]
							}
						}
					}

					def boolean matchResoluteType(PropertyType formalType, BaseType resoluteType) {
						switch (formalType) {
							AadlBoolean: return resoluteType.type.equalsIgnoreCase("bool")
							AadlReal: return resoluteType.type.equalsIgnoreCase("real")
							AadlInteger: return resoluteType.type.equalsIgnoreCase("int")
							AadlString: return resoluteType.type.equalsIgnoreCase("string")
							PropertyRef: return resoluteType.type.equalsIgnoreCase("property")
						}
						false
					}

					@Check(CheckType.FAST)
					def void checkFileTypeContents(Verification verification) {
						val verificationURI = EcoreUtil.getURI(verification)
						val fileExt = verificationURI.fileExtension.toLowerCase
						val contents = verification.contents
						switch fileExt {
							case "verify": {
								contents.forEach [ content |
									switch content {
										VerificationPlan: {
										}
										VerificationMethodRegistry:
											fileTypeError(fileExt, "verification methods", content)
										default:
											fileTypeError(fileExt, content.class.name, content)
									}
								]
							}
							case "methodregistry": {
								contents.forEach [ content |
									switch content {
										VerificationMethodRegistry: {
										}
										VerificationPlan:
											fileTypeError(fileExt, "verification plan", content)
										default:
											fileTypeError(fileExt, content.class.name, content)
									}
								]
							}
							default: {
							}
						}
					}

					// TODO: This method overload calls the quickfix which does not work as expected, commenting out for the immediate future
//	def void fileTypeError(String fileType, String partName, EObject part, URI verificationURI){
//		error( partName +" not allowed in '"+ fileType + "' file.", part, null, ILLEGAL_OBJECT_FOR_FILETYPE, partName, verificationURI.toString())
//	}
					def void fileTypeError(String fileType, String partName, EObject part) {
						warning(partName + " not allowed in '" + fileType + "' file.", part, null)
					}

					@Check(CheckType.NORMAL)
					def void checkVerificationPlanUniqueToComponentClassifier(VerificationPlan vp) {
						val sysReq = vp.requirementSet
						if (sysReq instanceof SystemRequirementSet) {
							val vps = verifyGlobalRefFinder.getAllVerificationPlansForRequirements(sysReq, vp)
							if (vps.size > 1) {
								error("Other Verification Plans exist for '" + sysReq.name +
									"'. Only one Verification Plans is allowed for a specific System Requirements.", vp,
									VerifyPackage.Literals.VERIFICATION_PLAN__REQUIREMENT_SET)
							}
						}
					}

				}
