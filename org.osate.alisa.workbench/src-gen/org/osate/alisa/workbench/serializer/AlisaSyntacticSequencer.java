/*
 * generated by Xtext
 */
package org.osate.alisa.workbench.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

@SuppressWarnings("all")
public class AlisaSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AlisaGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AssurancePlan_IssuesKeyword_7_5_0_q;
	protected AbstractElementAlias match_AssurancePlan___AssumeKeyword_7_4_0_SubsystemsKeyword_7_4_1__q;
	protected AbstractElementAlias match_AssurancePlan___AssureKeyword_7_1_0_OwnKeyword_7_1_1__q;
	protected AbstractElementAlias match_AssurancePlan___AssureKeyword_7_2_0_GlobalKeyword_7_2_1__q;
	protected AbstractElementAlias match_AssurancePlan___AssureKeyword_7_3_0_SubsystemKeyword_7_3_1_PlansKeyword_7_3_2__q;
	protected AbstractElementAlias match_AssuranceTask_FilterKeyword_7_1_0_0_a;
	protected AbstractElementAlias match_AssuranceTask_FilterKeyword_7_1_0_0_p;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_a_IssuesKeyword_7_2_0__q;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_a_SelectionsKeyword_7_1_2_0__q;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_a_VerificationsKeyword_7_1_1_0__q;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_p_RequirementsKeyword_7_1_0_1_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlisaGrammarAccess) access;
		match_AssurancePlan_IssuesKeyword_7_5_0_q = new TokenAlias(false, true, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_5_0());
		match_AssurancePlan___AssumeKeyword_7_4_0_SubsystemsKeyword_7_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_4_0()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getSubsystemsKeyword_7_4_1()));
		match_AssurancePlan___AssureKeyword_7_1_0_OwnKeyword_7_1_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_1_0()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getOwnKeyword_7_1_1()));
		match_AssurancePlan___AssureKeyword_7_2_0_GlobalKeyword_7_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_2_0()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getGlobalKeyword_7_2_1()));
		match_AssurancePlan___AssureKeyword_7_3_0_SubsystemKeyword_7_3_1_PlansKeyword_7_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_3_0()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_3_1()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getPlansKeyword_7_3_2()));
		match_AssuranceTask_FilterKeyword_7_1_0_0_a = new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0());
		match_AssuranceTask_FilterKeyword_7_1_0_0_p = new TokenAlias(true, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0());
		match_AssuranceTask___FilterKeyword_7_1_0_0_a_IssuesKeyword_7_2_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_7_2_0()));
		match_AssuranceTask___FilterKeyword_7_1_0_0_a_SelectionsKeyword_7_1_2_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getSelectionsKeyword_7_1_2_0()));
		match_AssuranceTask___FilterKeyword_7_1_0_0_a_VerificationsKeyword_7_1_1_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getVerificationsKeyword_7_1_1_0()));
		match_AssuranceTask___FilterKeyword_7_1_0_0_p_RequirementsKeyword_7_1_0_1_0__q = new GroupAlias(false, true, new TokenAlias(true, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getRequirementsKeyword_7_1_0_1_0()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AssurancePlan_IssuesKeyword_7_5_0_q.equals(syntax))
				emit_AssurancePlan_IssuesKeyword_7_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan___AssumeKeyword_7_4_0_SubsystemsKeyword_7_4_1__q.equals(syntax))
				emit_AssurancePlan___AssumeKeyword_7_4_0_SubsystemsKeyword_7_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan___AssureKeyword_7_1_0_OwnKeyword_7_1_1__q.equals(syntax))
				emit_AssurancePlan___AssureKeyword_7_1_0_OwnKeyword_7_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan___AssureKeyword_7_2_0_GlobalKeyword_7_2_1__q.equals(syntax))
				emit_AssurancePlan___AssureKeyword_7_2_0_GlobalKeyword_7_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan___AssureKeyword_7_3_0_SubsystemKeyword_7_3_1_PlansKeyword_7_3_2__q.equals(syntax))
				emit_AssurancePlan___AssureKeyword_7_3_0_SubsystemKeyword_7_3_1_PlansKeyword_7_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_FilterKeyword_7_1_0_0_a.equals(syntax))
				emit_AssuranceTask_FilterKeyword_7_1_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_FilterKeyword_7_1_0_0_p.equals(syntax))
				emit_AssuranceTask_FilterKeyword_7_1_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_a_IssuesKeyword_7_2_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_a_IssuesKeyword_7_2_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_a_SelectionsKeyword_7_1_2_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_a_SelectionsKeyword_7_1_2_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_a_VerificationsKeyword_7_1_1_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_a_VerificationsKeyword_7_1_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_p_RequirementsKeyword_7_1_0_1_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_p_RequirementsKeyword_7_1_0_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_AssurancePlan_IssuesKeyword_7_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('assume' 'subsystems')?
	 *
	 * This ambiguous syntax occurs at:
	 *     assumeSubsystems+=[ComponentClassifier|AadlClassifierReference] (ambiguity) assumeSubsystems+=[ComponentClassifier|AadlClassifierReference]
	 */
	protected void emit_AssurancePlan___AssumeKeyword_7_4_0_SubsystemsKeyword_7_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('assure' 'own')?
	 *
	 * This ambiguous syntax occurs at:
	 *     assureOwn+=[VerificationPlan|QualifiedName] (ambiguity) assureOwn+=[VerificationPlan|QualifiedName]
	 */
	protected void emit_AssurancePlan___AssureKeyword_7_1_0_OwnKeyword_7_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('assure' 'global')?
	 *
	 * This ambiguous syntax occurs at:
	 *     assureGlobal+=[VerificationPlan|QualifiedName] (ambiguity) assureGlobal+=[VerificationPlan|QualifiedName]
	 */
	protected void emit_AssurancePlan___AssureKeyword_7_2_0_GlobalKeyword_7_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('assure' 'subsystem' 'plans')?
	 *
	 * This ambiguous syntax occurs at:
	 *     assureSubsystemPlans+=[AssurancePlan|QualifiedName] (ambiguity) assureSubsystemPlans+=[AssurancePlan|QualifiedName]
	 */
	protected void emit_AssurancePlan___AssureKeyword_7_3_0_SubsystemKeyword_7_3_1_PlansKeyword_7_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'filter'*
	 *
	 * This ambiguous syntax occurs at:
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) ']' (rule end)
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'description' description=Description
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'issues' issues+=STRING
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'selections' selectionFilter+=[SelectionCategory|ID]
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'verifications' verificationFilter+=[VerificationCategory|ID]
	 *     description=Description (ambiguity) ']' (rule end)
	 *     description=Description (ambiguity) 'description' description=Description
	 *     description=Description (ambiguity) 'issues' issues+=STRING
	 *     description=Description (ambiguity) 'selections' selectionFilter+=[SelectionCategory|ID]
	 *     description=Description (ambiguity) 'verifications' verificationFilter+=[VerificationCategory|ID]
	 *     issues+=STRING (ambiguity) ']' (rule end)
	 *     issues+=STRING (ambiguity) 'description' description=Description
	 *     issues+=STRING (ambiguity) 'selections' selectionFilter+=[SelectionCategory|ID]
	 *     issues+=STRING (ambiguity) 'verifications' verificationFilter+=[VerificationCategory|ID]
	 *     requirementFilter+=[RequirementCategory|ID] (ambiguity) ']' (rule end)
	 *     requirementFilter+=[RequirementCategory|ID] (ambiguity) 'description' description=Description
	 *     requirementFilter+=[RequirementCategory|ID] (ambiguity) 'issues' issues+=STRING
	 *     requirementFilter+=[RequirementCategory|ID] (ambiguity) 'selections' selectionFilter+=[SelectionCategory|ID]
	 *     requirementFilter+=[RequirementCategory|ID] (ambiguity) 'verifications' verificationFilter+=[VerificationCategory|ID]
	 *     selectionFilter+=[SelectionCategory|ID] (ambiguity) ']' (rule end)
	 *     selectionFilter+=[SelectionCategory|ID] (ambiguity) 'description' description=Description
	 *     selectionFilter+=[SelectionCategory|ID] (ambiguity) 'issues' issues+=STRING
	 *     selectionFilter+=[SelectionCategory|ID] (ambiguity) 'verifications' verificationFilter+=[VerificationCategory|ID]
	 *     verificationFilter+=[VerificationCategory|ID] (ambiguity) ']' (rule end)
	 *     verificationFilter+=[VerificationCategory|ID] (ambiguity) 'description' description=Description
	 *     verificationFilter+=[VerificationCategory|ID] (ambiguity) 'issues' issues+=STRING
	 *     verificationFilter+=[VerificationCategory|ID] (ambiguity) 'selections' selectionFilter+=[SelectionCategory|ID]
	 */
	protected void emit_AssuranceTask_FilterKeyword_7_1_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'filter'+
	 *
	 * This ambiguous syntax occurs at:
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'requirements' requirementFilter+=[RequirementCategory|ID]
	 *     description=Description (ambiguity) 'requirements' requirementFilter+=[RequirementCategory|ID]
	 *     issues+=STRING (ambiguity) 'requirements' requirementFilter+=[RequirementCategory|ID]
	 *     selectionFilter+=[SelectionCategory|ID] (ambiguity) 'requirements' requirementFilter+=[RequirementCategory|ID]
	 *     verificationFilter+=[VerificationCategory|ID] (ambiguity) 'requirements' requirementFilter+=[RequirementCategory|ID]
	 */
	protected void emit_AssuranceTask_FilterKeyword_7_1_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('filter'* 'issues')?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_a_IssuesKeyword_7_2_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('filter'* 'selections')?
	 *
	 * This ambiguous syntax occurs at:
	 *     selectionFilter+=[SelectionCategory|ID] (ambiguity) selectionFilter+=[SelectionCategory|ID]
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_a_SelectionsKeyword_7_1_2_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('filter'* 'verifications')?
	 *
	 * This ambiguous syntax occurs at:
	 *     verificationFilter+=[VerificationCategory|ID] (ambiguity) verificationFilter+=[VerificationCategory|ID]
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_a_VerificationsKeyword_7_1_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('filter'+ 'requirements')?
	 *
	 * This ambiguous syntax occurs at:
	 *     requirementFilter+=[RequirementCategory|ID] (ambiguity) requirementFilter+=[RequirementCategory|ID]
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_p_RequirementsKeyword_7_1_0_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
