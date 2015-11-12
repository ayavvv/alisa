/*
 * generated by Xtext
 */
package org.osate.reqspec.scoping

import com.google.inject.Inject
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.BasicInternalEList
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.alisa.common.common.AVariableDeclaration
import org.osate.alisa.common.scoping.CommonScopeProvider
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.reqspec.reqSpec.ContractualElement
import org.osate.reqspec.reqSpec.Goal
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.SystemRequirements
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

import static org.osate.alisa.common.util.CommonUtilExtension.*
import static org.osate.reqspec.util.ReqSpecUtilExtension.*
import org.osate.alisa.common.common.AVariableReference

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it 
 * 
 */
class ReqSpecScopeProvider extends AlisaAbstractDeclarativeScopeProvider {
	@Inject var ICommonGlobalReferenceFinder commonRefFinder
	@Inject var IReqspecGlobalReferenceFinder refFinder

	// For Reference is from Goal, Requirement 
	def scope_NamedElement(ContractualElement context, EReference reference) {
		val targetClassifier = targetClassifier(context)
		if (targetClassifier != null) {
//			targetClassifier.getAllFeatures.scopeFor
			val thescope = new SimpleScope(IScope::NULLSCOPE,
				Scopes::scopedElementsFor(targetClassifier.getAllFeatures+targetClassifier.allModes,
					QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			if (targetClassifier instanceof ComponentImplementation) {
				new SimpleScope(thescope,
					Scopes::scopedElementsFor(targetClassifier.allSubcomponents+targetClassifier.allEndToEndFlows,
						QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			} else {
				return thescope
			}
		} else {
			IScope.NULLSCOPE
		}
	}

//	Offer property definitions via scope. Here we can add filter to allow only those properties that actually apply to the target object
//	def scope_Property(PropertyConsistentVariableDeclaration context, EReference reference){
//			val props = (scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(context,
//				Aadl2Package.eINSTANCE.property, null)
//		new SimpleScope(IScope::NULLSCOPE, props,true)
//	}

	def scope_AVariableDeclaration(AVariableReference context, EReference reference) {
		val result = scopeForGlobalVal(context,IScope.NULLSCOPE)
		val contract = containingContractualElement(context)
		switch (contract){
			Requirement: return scopeForValCompute(contract, result)
			Goal: return scopeForVal(contract,result)
		}
	}

	
	def scope_AVariableDeclaration(Requirement context, EReference reference) {
		val result = scopeForGlobalVal(context,IScope.NULLSCOPE)
		return scopeForValCompute(context, result)
	}


	def scope_AVariableDeclaration(Goal context, EReference reference) {
		val result = scopeForGlobalVal(context,IScope.NULLSCOPE)
		return scopeForVal(context, result)
	}
		
	def IScope scopeForGlobalVal(EObject context,IScope parentScope){
		var result = parentScope
		val projectconstants = getImportedGlobals(context) //refFinder.getAllGlobalConstants(context)
		var Iterable<AVariableDeclaration> constants = new BasicEList
		for (pc : projectconstants) {
			constants = constants +  pc.constants
		}
		if (!constants.empty) {
			result = new SimpleScope(result,
				Scopes::scopedElementsFor(constants,
					QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
		}
		return result
	}
	
	def getImportedGlobals(EObject context){
		val sr = containingSystemRequirements(context)
		val sg =containingStakeholderGoals(context)
		val res = sr?.importConstants?:sg?.importConstants
		res
	}

	// TODO: probably want validation to take care of Refining itself. Need to take care of inheritance
	def scope_Requirement_refinesReference(Requirement context, EReference reference) {
// use delegate to get other scopes including the global scope
		var result = delegateGetScope(context,reference)//IScope.NULLSCOPE

		val targetComponentClassifier = containingSystemRequirements(context).target
		val Iterable<SystemRequirements> listAccessibleSystemRequirements = commonRefFinder.getEObjectDescriptions(
			targetComponentClassifier, ReqSpecPackage.Literals.SYSTEM_REQUIREMENTS, "reqspec").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as SystemRequirements
		].filter[sysreqs|isSameorExtends(targetComponentClassifier, sysreqs.target)]
		// TODO sort in extends hierarchy order
		for (sr : listAccessibleSystemRequirements) {
			if (!sr.content.empty) {
				result = new SimpleScope(result,
					Scopes::scopedElementsFor(sr.content,
						QualifiedName::wrapper(SimpleAttributeResolver::NAME_RESOLVER)), true)
			}
		}
		result
	}

	def scope_Requirement_decomposesReference(Requirement context, EReference reference) {
		scope_Requirement_refinesReference(context, reference)
	}

	def scope_Requirement_evolvesReference(Requirement context, EReference reference) {
		scope_Requirement_refinesReference(context, reference)
	}

	// Brought from Aadl2JavaValidator
	def EList<ComponentClassifier> getSelfPlusAncestors(ComponentClassifier cl) {
		val cls = new BasicInternalEList<ComponentClassifier>(typeof(ComponentClassifier));
		cls.add(cl);

		var temp = cl
		while (temp.getExtended() != null) {
			if (cls.contains(temp.getExtended())) {
				return cls;
			}
			temp = temp.getExtended() as ComponentClassifier;
			cls.add(temp);
		}

		// If implementation collect for type
		if (cl instanceof ComponentImplementation) {
			temp = (cl as ComponentImplementation).type
			cls.add(temp);
			while (temp.getExtended() != null) {
				if (cls.contains(temp.getExtended())) {
					return cls;
				}
				temp = temp.getExtended() as ComponentClassifier;
				cls.add(temp);
			}

		}
		cls
	}


}
