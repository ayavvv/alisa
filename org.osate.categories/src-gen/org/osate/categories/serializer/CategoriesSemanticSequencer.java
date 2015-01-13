package org.osate.categories.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.HazardCategories;
import org.osate.categories.categories.HazardCategory;
import org.osate.categories.categories.RequirementCategories;
import org.osate.categories.categories.RequirementCategory;
import org.osate.categories.categories.SelectionCategories;
import org.osate.categories.categories.SelectionCategory;
import org.osate.categories.categories.VerificationCategories;
import org.osate.categories.categories.VerificationCategory;
import org.osate.categories.services.CategoriesGrammarAccess;

@SuppressWarnings("all")
public class CategoriesSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CategoriesGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CategoriesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CategoriesPackage.HAZARD_CATEGORIES:
				if(context == grammarAccess.getCategoriesRule() ||
				   context == grammarAccess.getHazardCategoriesRule()) {
					sequence_HazardCategories(context, (HazardCategories) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.HAZARD_CATEGORY:
				if(context == grammarAccess.getCategoryRule() ||
				   context == grammarAccess.getHazardCategoryRule()) {
					sequence_HazardCategory(context, (HazardCategory) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.REQUIREMENT_CATEGORIES:
				if(context == grammarAccess.getCategoriesRule() ||
				   context == grammarAccess.getRequirementCategoriesRule()) {
					sequence_RequirementCategories(context, (RequirementCategories) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.REQUIREMENT_CATEGORY:
				if(context == grammarAccess.getCategoryRule() ||
				   context == grammarAccess.getRequirementCategoryRule()) {
					sequence_RequirementCategory(context, (RequirementCategory) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.SELECTION_CATEGORIES:
				if(context == grammarAccess.getCategoriesRule() ||
				   context == grammarAccess.getSelectionCategoriesRule()) {
					sequence_SelectionCategories(context, (SelectionCategories) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.SELECTION_CATEGORY:
				if(context == grammarAccess.getCategoryRule() ||
				   context == grammarAccess.getSelectionCategoryRule()) {
					sequence_SelectionCategory(context, (SelectionCategory) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.VERIFICATION_CATEGORIES:
				if(context == grammarAccess.getCategoriesRule() ||
				   context == grammarAccess.getVerificationCategoriesRule()) {
					sequence_VerificationCategories(context, (VerificationCategories) semanticObject); 
					return; 
				}
				else break;
			case CategoriesPackage.VERIFICATION_CATEGORY:
				if(context == grammarAccess.getCategoryRule() ||
				   context == grammarAccess.getVerificationCategoryRule()) {
					sequence_VerificationCategory(context, (VerificationCategory) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     category+=HazardCategory+
	 */
	protected void sequence_HazardCategories(EObject context, HazardCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID extends=[HazardCategory|CatRef]?)
	 */
	protected void sequence_HazardCategory(EObject context, HazardCategory semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     category+=RequirementCategory+
	 */
	protected void sequence_RequirementCategories(EObject context, RequirementCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID extends=[RequirementCategory|CatRef]?)
	 */
	protected void sequence_RequirementCategory(EObject context, RequirementCategory semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     category+=SelectionCategory+
	 */
	protected void sequence_SelectionCategories(EObject context, SelectionCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID extends=[SelectionCategory|CatRef]?)
	 */
	protected void sequence_SelectionCategory(EObject context, SelectionCategory semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     category+=VerificationCategory+
	 */
	protected void sequence_VerificationCategories(EObject context, VerificationCategories semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID extends=[VerificationCategory|CatRef]?)
	 */
	protected void sequence_VerificationCategory(EObject context, VerificationCategory semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
