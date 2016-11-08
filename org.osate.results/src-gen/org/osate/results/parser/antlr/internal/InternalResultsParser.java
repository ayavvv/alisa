package org.osate.results.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.results.services.ResultsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
@SuppressWarnings("all")
public class InternalResultsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_REAL_LIT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_EXTENDED_DIGIT", "RULE_BASED_INTEGER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reports'", "':'", "'for'", "'['", "'description'", "']'", "'report'", "'heading'", "'results'", "'contributor'", "'='", "'issues'", "'this'", "'target'", "'exception'", "'diagnosticId'", "'boolean'", "'integer'", "'units'", "'real'", "'string'", "'model'", "'element'", "'#'", "'.'", "'%'", "'in'", "'img'", "'/'", "'or'", "'||'", "'and'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'><'", "'+'", "'-'", "'*'", "'div'", "'mod'", "'not'", "'('", "','", "')'", "'..'", "'delta'", "'if'", "'then'", "'else'", "'endif'", "'true'", "'false'", "'::'", "'tbd'", "'error'", "'warning'", "'info'", "'success'", "'fail'"
    };
    public static final int T__50=50;
    public static final int RULE_INT_EXPONENT=10;
    public static final int T__19=19;
    public static final int T__59=59;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BASED_INTEGER=12;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_DIGIT=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_REAL_LIT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_EXPONENT=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_EXTENDED_DIGIT=11;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalResultsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalResultsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalResultsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g"; }



     	private ResultsGrammarAccess grammarAccess;
     	
        public InternalResultsParser(TokenStream input, ResultsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ResultReport";	
       	}
       	
       	@Override
       	protected ResultsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleResultReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:80:1: entryRuleResultReport returns [EObject current=null] : iv_ruleResultReport= ruleResultReport EOF ;
    public final EObject entryRuleResultReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:2: (iv_ruleResultReport= ruleResultReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:82:2: iv_ruleResultReport= ruleResultReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultReportRule()); 
            }
            pushFollow(FOLLOW_ruleResultReport_in_entryRuleResultReport75);
            iv_ruleResultReport=ruleResultReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultReport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReport85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResultReport"


    // $ANTLR start "ruleResultReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:89:1: ruleResultReport returns [EObject current=null] : (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport ) ;
    public final EObject ruleResultReport() throws RecognitionException {
        EObject current = null;

        EObject this_ResultDataReport_0 = null;

        EObject this_ResultReportCollection_1 = null;

        EObject this_IssuesReport_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:92:28: ( (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:93:1: (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:93:1: (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 17:
                {
                alt1=2;
                }
                break;
            case 28:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:94:5: this_ResultDataReport_0= ruleResultDataReport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleResultDataReport_in_ruleResultReport132);
                    this_ResultDataReport_0=ruleResultDataReport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ResultDataReport_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:104:5: this_ResultReportCollection_1= ruleResultReportCollection
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleResultReportCollection_in_ruleResultReport159);
                    this_ResultReportCollection_1=ruleResultReportCollection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ResultReportCollection_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:114:5: this_IssuesReport_2= ruleIssuesReport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIssuesReport_in_ruleResultReport186);
                    this_IssuesReport_2=ruleIssuesReport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IssuesReport_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResultReport"


    // $ANTLR start "entryRuleResultReportCollection"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:130:1: entryRuleResultReportCollection returns [EObject current=null] : iv_ruleResultReportCollection= ruleResultReportCollection EOF ;
    public final EObject entryRuleResultReportCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReportCollection = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:131:2: (iv_ruleResultReportCollection= ruleResultReportCollection EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:132:2: iv_ruleResultReportCollection= ruleResultReportCollection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultReportCollectionRule()); 
            }
            pushFollow(FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection221);
            iv_ruleResultReportCollection=ruleResultReportCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultReportCollection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReportCollection231); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResultReportCollection"


    // $ANTLR start "ruleResultReportCollection"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:139:1: ruleResultReportCollection returns [EObject current=null] : (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) ;
    public final EObject ruleResultReportCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_description_8_0=null;
        Token otherlv_11=null;
        EObject lv_content_9_0 = null;

        EObject lv_issues_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:142:28: ( (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:3: otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleResultReportCollection268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:147:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:149:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultReportCollection285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:165:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:165:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleResultReportCollection303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:169:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:171:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportCollection320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_title_3_0, grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"title",
                              		lv_title_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleResultReportCollection339); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getResultReportCollectionAccess().getForKeyword_3());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:191:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:192:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:192:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:193:3: ruleURIID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleURIID_in_ruleResultReportCollection362);
            ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleResultReportCollection374); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:1: (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:3: otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleResultReportCollection387); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:214:1: ( (lv_description_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_description_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_description_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:216:3: lv_description_8_0= RULE_STRING
                    {
                    lv_description_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportCollection404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_8_0, grammarAccess.getResultReportCollectionAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:232:4: ( (lv_content_9_0= ruleResultReport ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17||LA4_0==23||LA4_0==28) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:233:1: (lv_content_9_0= ruleResultReport )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:233:1: (lv_content_9_0= ruleResultReport )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:234:3: lv_content_9_0= ruleResultReport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultReport_in_ruleResultReportCollection432);
            	    lv_content_9_0=ruleResultReport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"content",
            	              		lv_content_9_0, 
            	              		"ResultReport");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:250:3: ( (lv_issues_10_0= ruleResultIssue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=75 && LA5_0<=80)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:251:1: (lv_issues_10_0= ruleResultIssue )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:251:1: (lv_issues_10_0= ruleResultIssue )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:252:3: lv_issues_10_0= ruleResultIssue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultReportCollection454);
                    lv_issues_10_0=ruleResultIssue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
                      	        }
                             		add(
                             			current, 
                             			"issues",
                              		lv_issues_10_0, 
                              		"ResultIssue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleResultReportCollection467); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResultReportCollection"


    // $ANTLR start "entryRuleResultDataReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:280:1: entryRuleResultDataReport returns [EObject current=null] : iv_ruleResultDataReport= ruleResultDataReport EOF ;
    public final EObject entryRuleResultDataReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultDataReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:281:2: (iv_ruleResultDataReport= ruleResultDataReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:282:2: iv_ruleResultDataReport= ruleResultDataReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultDataReportRule()); 
            }
            pushFollow(FOLLOW_ruleResultDataReport_in_entryRuleResultDataReport503);
            iv_ruleResultDataReport=ruleResultDataReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultDataReport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultDataReport513); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResultDataReport"


    // $ANTLR start "ruleResultDataReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:289:1: ruleResultDataReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' ) ;
    public final EObject ruleResultDataReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_description_8_0=null;
        Token otherlv_9=null;
        Token lv_heading_10_0=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_content_11_0 = null;

        EObject lv_resultData_13_0 = null;

        EObject lv_issues_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:292:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleResultDataReport550); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResultDataReportAccess().getReportKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:297:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:298:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:298:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:299:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultDataReport567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResultDataReportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:315:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:315:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleResultDataReport585); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultDataReportAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:319:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:320:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:320:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:321:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultDataReport602); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_title_3_0, grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataReportRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"title",
                              		lv_title_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleResultDataReport621); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getResultDataReportAccess().getForKeyword_3());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:341:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:342:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:342:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:343:3: ruleURIID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getResultDataReportRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleURIID_in_ruleResultDataReport644);
            ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleResultDataReport656); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:360:1: (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:360:3: otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleResultDataReport669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:364:1: ( (lv_description_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:365:1: (lv_description_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:365:1: (lv_description_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:366:3: lv_description_8_0= RULE_STRING
                    {
                    lv_description_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultDataReport686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_8_0, grammarAccess.getResultDataReportAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataReportRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:382:4: (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:382:6: otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )*
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleResultDataReport706); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:386:1: ( (lv_heading_10_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:387:1: (lv_heading_10_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:387:1: (lv_heading_10_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:388:3: lv_heading_10_0= RULE_STRING
                    {
                    lv_heading_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultDataReport723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_heading_10_0, grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataReportRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"heading",
                              		lv_heading_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:404:2: ( (lv_content_11_0= ruleResultContributor ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==26) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:405:1: (lv_content_11_0= ruleResultContributor )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:405:1: (lv_content_11_0= ruleResultContributor )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:406:3: lv_content_11_0= ruleResultContributor
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultDataReport749);
                    	    lv_content_11_0=ruleResultContributor();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultDataReportRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"content",
                    	              		lv_content_11_0, 
                    	              		"ResultContributor");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:422:5: (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:422:7: otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+
                    {
                    otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleResultDataReport765); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:426:1: ( (lv_resultData_13_0= ruleResultData ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:427:1: (lv_resultData_13_0= ruleResultData )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:427:1: (lv_resultData_13_0= ruleResultData )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:428:3: lv_resultData_13_0= ruleResultData
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultData_in_ruleResultDataReport786);
                    	    lv_resultData_13_0=ruleResultData();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultDataReportRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"resultData",
                    	              		lv_resultData_13_0, 
                    	              		"ResultData");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:444:5: ( (lv_issues_14_0= ruleResultIssue ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=75 && LA12_0<=80)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:445:1: (lv_issues_14_0= ruleResultIssue )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:445:1: (lv_issues_14_0= ruleResultIssue )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:446:3: lv_issues_14_0= ruleResultIssue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultDataReport810);
            	    lv_issues_14_0=ruleResultIssue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResultDataReportRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"issues",
            	              		lv_issues_14_0, 
            	              		"ResultIssue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_15=(Token)match(input,22,FOLLOW_22_in_ruleResultDataReport823); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResultDataReport"


    // $ANTLR start "entryRuleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:474:1: entryRuleResultContributor returns [EObject current=null] : iv_ruleResultContributor= ruleResultContributor EOF ;
    public final EObject entryRuleResultContributor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultContributor = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:475:2: (iv_ruleResultContributor= ruleResultContributor EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:476:2: iv_ruleResultContributor= ruleResultContributor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultContributorRule()); 
            }
            pushFollow(FOLLOW_ruleResultContributor_in_entryRuleResultContributor859);
            iv_ruleResultContributor=ruleResultContributor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultContributor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultContributor869); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResultContributor"


    // $ANTLR start "ruleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:483:1: ruleResultContributor returns [EObject current=null] : (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' ) ;
    public final EObject ruleResultContributor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_resultData_4_0 = null;

        EObject lv_issues_5_0 = null;

        EObject lv_subcontributor_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:486:28: ( (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:3: otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleResultContributor906); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResultContributorAccess().getContributorKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:491:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:492:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:492:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:493:3: ruleURIID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getResultContributorRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleURIID_in_ruleResultContributor929);
            ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleResultContributor941); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:510:1: (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:510:3: otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleResultContributor954); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getResultContributorAccess().getResultsKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:514:1: ( (lv_resultData_4_0= ruleResultData ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:515:1: (lv_resultData_4_0= ruleResultData )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:515:1: (lv_resultData_4_0= ruleResultData )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:516:3: lv_resultData_4_0= ruleResultData
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultData_in_ruleResultContributor975);
                    	    lv_resultData_4_0=ruleResultData();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"resultData",
                    	              		lv_resultData_4_0, 
                    	              		"ResultData");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:532:5: ( (lv_issues_5_0= ruleResultIssue ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=75 && LA15_0<=80)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:533:1: (lv_issues_5_0= ruleResultIssue )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:533:1: (lv_issues_5_0= ruleResultIssue )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:534:3: lv_issues_5_0= ruleResultIssue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultContributor999);
            	    lv_issues_5_0=ruleResultIssue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"issues",
            	              		lv_issues_5_0, 
            	              		"ResultIssue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:550:3: ( (lv_subcontributor_6_0= ruleResultContributor ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:551:1: (lv_subcontributor_6_0= ruleResultContributor )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:551:1: (lv_subcontributor_6_0= ruleResultContributor )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:552:3: lv_subcontributor_6_0= ruleResultContributor
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultContributor1021);
            	    lv_subcontributor_6_0=ruleResultContributor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"subcontributor",
            	              		lv_subcontributor_6_0, 
            	              		"ResultContributor");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleResultContributor1034); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResultContributor"


    // $ANTLR start "entryRuleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:580:1: entryRuleResultData returns [EObject current=null] : iv_ruleResultData= ruleResultData EOF ;
    public final EObject entryRuleResultData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultData = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:581:2: (iv_ruleResultData= ruleResultData EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:582:2: iv_ruleResultData= ruleResultData EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultDataRule()); 
            }
            pushFollow(FOLLOW_ruleResultData_in_entryRuleResultData1070);
            iv_ruleResultData=ruleResultData();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultData; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultData1080); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResultData"


    // $ANTLR start "ruleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:589:1: ruleResultData returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) ) ;
    public final EObject ruleResultData() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token lv_integerValue_3_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:592:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:594:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:594:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:595:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultData1122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResultDataRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleResultData1139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getResultDataAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:1: ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_INT) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:2: ( (lv_value_2_0= RULE_STRING ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:2: ( (lv_value_2_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_value_2_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_value_2_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:617:3: lv_value_2_0= RULE_STRING
                    {
                    lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultData1157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_2_0, grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_2_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:634:6: ( (lv_integerValue_3_0= RULE_INT ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:634:6: ( (lv_integerValue_3_0= RULE_INT ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:635:1: (lv_integerValue_3_0= RULE_INT )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:635:1: (lv_integerValue_3_0= RULE_INT )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:636:3: lv_integerValue_3_0= RULE_INT
                    {
                    lv_integerValue_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleResultData1185); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_integerValue_3_0, grammarAccess.getResultDataAccess().getIntegerValueINTTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"integerValue",
                              		lv_integerValue_3_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResultData"


    // $ANTLR start "entryRuleIssuesReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:660:1: entryRuleIssuesReport returns [EObject current=null] : iv_ruleIssuesReport= ruleIssuesReport EOF ;
    public final EObject entryRuleIssuesReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIssuesReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:661:2: (iv_ruleIssuesReport= ruleIssuesReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:662:2: iv_ruleIssuesReport= ruleIssuesReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIssuesReportRule()); 
            }
            pushFollow(FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport1227);
            iv_ruleIssuesReport=ruleIssuesReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIssuesReport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssuesReport1237); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIssuesReport"


    // $ANTLR start "ruleIssuesReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:669:1: ruleIssuesReport returns [EObject current=null] : (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? ) ;
    public final EObject ruleIssuesReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_8=null;
        EObject lv_issues_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:672:28: ( (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:673:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:673:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:673:3: otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleIssuesReport1274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIssuesReportAccess().getIssuesKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:677:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:678:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:678:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:679:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIssuesReport1291); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIssuesReportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:695:2: (otherlv_2= 'for' ( ( ruleURIID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:695:4: otherlv_2= 'for' ( ( ruleURIID ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleIssuesReport1309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIssuesReportAccess().getForKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:699:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:700:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:700:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:701:3: ruleURIID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIssuesReportRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleURIID_in_ruleIssuesReport1332);
                    ruleURIID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:714:4: (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:714:6: otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']'
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleIssuesReport1347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:718:1: (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==21) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:718:3: otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) )
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleIssuesReport1360); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0());
                                  
                            }
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:722:1: ( (lv_description_6_0= RULE_STRING ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:723:1: (lv_description_6_0= RULE_STRING )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:723:1: (lv_description_6_0= RULE_STRING )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:724:3: lv_description_6_0= RULE_STRING
                            {
                            lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIssuesReport1377); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_description_6_0, grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getIssuesReportRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"description",
                                      		lv_description_6_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:740:4: ( (lv_issues_7_0= ruleResultIssue ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=75 && LA20_0<=80)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:741:1: (lv_issues_7_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:741:1: (lv_issues_7_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:742:3: lv_issues_7_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleIssuesReport1405);
                    	    lv_issues_7_0=ruleResultIssue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getIssuesReportRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"issues",
                    	              		lv_issues_7_0, 
                    	              		"ResultIssue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleIssuesReport1418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIssuesReport"


    // $ANTLR start "entryRuleDescriptionElement"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:772:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:773:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:774:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            }
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1458);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1468); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionElement"


    // $ANTLR start "ruleDescriptionElement"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:781:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_2_0=null;
        EObject lv_showValue_1_0 = null;

        EObject lv_image_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:784:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt22=1;
                }
                break;
            case RULE_ID:
                {
                alt22=2;
                }
                break;
            case 29:
                {
                alt22=3;
                }
                break;
            case 44:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:787:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1510); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"text",
                              		lv_text_0_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:805:1: (lv_showValue_1_0= ruleShowValue )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:805:1: (lv_showValue_1_0= ruleShowValue )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:806:3: lv_showValue_1_0= ruleShowValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement1542);
                    lv_showValue_1_0=ruleShowValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      	        }
                             		set(
                             			current, 
                             			"showValue",
                              		lv_showValue_1_0, 
                              		"ShowValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:823:6: ( (lv_thisTarget_2_0= 'this' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:823:6: ( (lv_thisTarget_2_0= 'this' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:824:1: (lv_thisTarget_2_0= 'this' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:824:1: (lv_thisTarget_2_0= 'this' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:825:3: lv_thisTarget_2_0= 'this'
                    {
                    lv_thisTarget_2_0=(Token)match(input,29,FOLLOW_29_in_ruleDescriptionElement1566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_thisTarget_2_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                      	        }
                             		setWithLastConsumed(current, "thisTarget", true, "this");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:839:6: ( (lv_image_3_0= ruleImageReference ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:839:6: ( (lv_image_3_0= ruleImageReference ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:840:1: (lv_image_3_0= ruleImageReference )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:840:1: (lv_image_3_0= ruleImageReference )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:841:3: lv_image_3_0= ruleImageReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImageReference_in_ruleDescriptionElement1606);
                    lv_image_3_0=ruleImageReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      	        }
                             		set(
                             			current, 
                             			"image",
                              		lv_image_3_0, 
                              		"ImageReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleResultIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:869:1: entryRuleResultIssue returns [EObject current=null] : iv_ruleResultIssue= ruleResultIssue EOF ;
    public final EObject entryRuleResultIssue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultIssue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:870:2: (iv_ruleResultIssue= ruleResultIssue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:871:2: iv_ruleResultIssue= ruleResultIssue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultIssueRule()); 
            }
            pushFollow(FOLLOW_ruleResultIssue_in_entryRuleResultIssue1646);
            iv_ruleResultIssue=ruleResultIssue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultIssue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultIssue1656); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResultIssue"


    // $ANTLR start "ruleResultIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:878:1: ruleResultIssue returns [EObject current=null] : ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleNoQuoteString ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) ;
    public final EObject ruleResultIssue() throws RecognitionException {
        EObject current = null;

        Token lv_message_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_exceptionType_5_0=null;
        Token otherlv_6=null;
        Token lv_diagnosticId_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_issueType_0_0 = null;

        EObject lv_issues_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:881:28: ( ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleNoQuoteString ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleNoQuoteString ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleNoQuoteString ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:2: ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleNoQuoteString ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:2: ( (lv_issueType_0_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:883:1: (lv_issueType_0_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:883:1: (lv_issueType_0_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:884:3: lv_issueType_0_0= ruleResultIssueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultIssue1702);
            lv_issueType_0_0=ruleResultIssueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
              	        }
                     		set(
                     			current, 
                     			"issueType",
                      		lv_issueType_0_0, 
                      		"ResultIssueType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:900:2: ( (lv_message_1_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:901:1: (lv_message_1_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:901:1: (lv_message_1_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:902:3: lv_message_1_0= RULE_STRING
            {
            lv_message_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1719); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_message_1_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResultIssueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"message",
                      		lv_message_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:918:2: (otherlv_2= 'target' ( ( ruleNoQuoteString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:918:4: otherlv_2= 'target' ( ( ruleNoQuoteString ) )
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleResultIssue1737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultIssueAccess().getTargetKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:922:1: ( ( ruleNoQuoteString ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:923:1: ( ruleNoQuoteString )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:923:1: ( ruleNoQuoteString )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:924:3: ruleNoQuoteString
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNoQuoteString_in_ruleResultIssue1760);
                    ruleNoQuoteString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:937:4: (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:937:6: otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleResultIssue1775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:941:1: ( (lv_exceptionType_5_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:942:1: (lv_exceptionType_5_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:942:1: (lv_exceptionType_5_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:943:3: lv_exceptionType_5_0= RULE_STRING
                    {
                    lv_exceptionType_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_exceptionType_5_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"exceptionType",
                              		lv_exceptionType_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:959:4: (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:959:6: otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleResultIssue1812); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getResultIssueAccess().getDiagnosticIdKeyword_4_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:963:1: ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:964:1: (lv_diagnosticId_7_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:964:1: (lv_diagnosticId_7_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:965:3: lv_diagnosticId_7_0= RULE_STRING
                    {
                    lv_diagnosticId_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_diagnosticId_7_0, grammarAccess.getResultIssueAccess().getDiagnosticIdSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"diagnosticId",
                              		lv_diagnosticId_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:981:4: (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==20) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:981:6: otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleResultIssue1849); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:985:1: ( (lv_issues_9_0= ruleResultIssue ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0>=75 && LA26_0<=80)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:986:1: (lv_issues_9_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:986:1: (lv_issues_9_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:987:3: lv_issues_9_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultIssue1870);
                    	    lv_issues_9_0=ruleResultIssue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"issues",
                    	              		lv_issues_9_0, 
                    	              		"ResultIssue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleResultIssue1883); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResultIssue"


    // $ANTLR start "entryRuleTypeRef"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1015:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1016:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1017:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1921);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1931); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1024:1: ruleTypeRef returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1027:28: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:1: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:1: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            int alt30=6;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt30=1;
                }
                break;
            case 34:
                {
                alt30=2;
                }
                break;
            case 36:
                {
                alt30=3;
                }
                break;
            case 37:
                {
                alt30=4;
                }
                break;
            case 38:
                {
                alt30=5;
                }
                break;
            case RULE_ID:
                {
                alt30=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:2: ( () otherlv_1= 'boolean' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:2: ( () otherlv_1= 'boolean' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:3: () otherlv_1= 'boolean'
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:3: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1029:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleTypeRef1978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:6: ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:6: ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:7: () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1040:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleTypeRef2007); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1049:1: (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==35) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1049:3: otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleTypeRef2020); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeRefAccess().getUnitsKeyword_1_2_0());
                                  
                            }
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1053:1: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1054:1: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1054:1: ( ruleAADLPROPERTYREFERENCE )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1055:3: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTypeRefRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2043);
                            ruleAADLPROPERTYREFERENCE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1069:6: ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1069:6: ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1069:7: () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1069:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1070:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlRealAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,36,FOLLOW_36_in_ruleTypeRef2074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getTypeRefAccess().getRealKeyword_2_1());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1079:1: (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==35) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1079:3: otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleTypeRef2087); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getTypeRefAccess().getUnitsKeyword_2_2_0());
                                  
                            }
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1083:1: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1084:1: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1084:1: ( ruleAADLPROPERTYREFERENCE )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1085:3: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTypeRefRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2110);
                            ruleAADLPROPERTYREFERENCE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:6: ( () otherlv_11= 'string' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:6: ( () otherlv_11= 'string' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:7: () otherlv_11= 'string'
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1100:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlStringAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_11=(Token)match(input,37,FOLLOW_37_in_ruleTypeRef2141); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getTypeRefAccess().getStringKeyword_3_1());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1110:6: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1110:6: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1110:7: () otherlv_13= 'model' otherlv_14= 'element'
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1110:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1111:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getModelRefAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_13=(Token)match(input,38,FOLLOW_38_in_ruleTypeRef2170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTypeRefAccess().getModelKeyword_4_1());
                          
                    }
                    otherlv_14=(Token)match(input,39,FOLLOW_39_in_ruleTypeRef2182); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTypeRefAccess().getElementKeyword_4_2());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1125:6: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1125:6: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1125:7: () ( ( ruleAADLPROPERTYREFERENCE ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1125:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1126:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getTypeRefAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1131:2: ( ( ruleAADLPROPERTYREFERENCE ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1132:1: ( ruleAADLPROPERTYREFERENCE )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1132:1: ( ruleAADLPROPERTYREFERENCE )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1133:3: ruleAADLPROPERTYREFERENCE
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRefRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2222);
                    ruleAADLPROPERTYREFERENCE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRulePropertyRef"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1154:1: entryRulePropertyRef returns [EObject current=null] : iv_rulePropertyRef= rulePropertyRef EOF ;
    public final EObject entryRulePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRef = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1155:2: (iv_rulePropertyRef= rulePropertyRef EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1156:2: iv_rulePropertyRef= rulePropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRefRule()); 
            }
            pushFollow(FOLLOW_rulePropertyRef_in_entryRulePropertyRef2259);
            iv_rulePropertyRef=rulePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyRef2269); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyRef"


    // $ANTLR start "rulePropertyRef"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1163:1: rulePropertyRef returns [EObject current=null] : ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject rulePropertyRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1166:28: ( ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1167:1: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1167:1: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1167:2: () ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1167:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1168:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPropertyRefAccess().getPropertyRefAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1173:2: ( ( ruleAADLPROPERTYREFERENCE ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1174:1: ( ruleAADLPROPERTYREFERENCE )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1174:1: ( ruleAADLPROPERTYREFERENCE )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1175:3: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_rulePropertyRef2326);
            ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyRef"


    // $ANTLR start "entryRuleAModelOrPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1200:1: entryRuleAModelOrPropertyReference returns [EObject current=null] : iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF ;
    public final EObject entryRuleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelOrPropertyReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1201:2: (iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1202:2: iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelOrPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAModelOrPropertyReference_in_entryRuleAModelOrPropertyReference2366);
            iv_ruleAModelOrPropertyReference=ruleAModelOrPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelOrPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAModelOrPropertyReference2376); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAModelOrPropertyReference"


    // $ANTLR start "ruleAModelOrPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1209:1: ruleAModelOrPropertyReference returns [EObject current=null] : ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) ;
    public final EObject ruleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AModelReference_0 = null;

        EObject this_APropertyReference_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1212:28: ( ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1213:1: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1213:1: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29) ) {
                alt32=1;
            }
            else if ( (LA32_0==40) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1213:2: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1213:2: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1214:5: this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAModelReference_in_ruleAModelOrPropertyReference2424);
                    this_AModelReference_0=ruleAModelReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AModelReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:1: ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==40) && (synpred1_InternalResults())) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:2: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:2: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:3: ( ( () '#' ) )=> ( () otherlv_2= '#' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1224:5: ( () otherlv_2= '#' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1224:6: () otherlv_2= '#'
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1224:6: ()
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1225:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleAModelOrPropertyReference2459); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1());
                                  
                            }

                            }


                            }

                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1234:3: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1235:1: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1235:1: ( ruleAADLPROPERTYREFERENCE )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1236:3: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getAModelOrPropertyReferenceRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAModelOrPropertyReference2484);
                            ruleAADLPROPERTYREFERENCE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1251:5: this_APropertyReference_4= ruleAPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPropertyReference_in_ruleAModelOrPropertyReference2515);
                    this_APropertyReference_4=ruleAPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_APropertyReference_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAModelOrPropertyReference"


    // $ANTLR start "entryRuleAModelReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1267:1: entryRuleAModelReference returns [EObject current=null] : iv_ruleAModelReference= ruleAModelReference EOF ;
    public final EObject entryRuleAModelReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:2: (iv_ruleAModelReference= ruleAModelReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1269:2: iv_ruleAModelReference= ruleAModelReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAModelReference_in_entryRuleAModelReference2550);
            iv_ruleAModelReference=ruleAModelReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAModelReference2560); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAModelReference"


    // $ANTLR start "ruleAModelReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1276:1: ruleAModelReference returns [EObject current=null] : ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleAModelReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1279:28: ( ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1280:1: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1280:1: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1280:2: ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1280:2: ( ( ruleThisKeyword ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1281:1: ( ruleThisKeyword )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1281:1: ( ruleThisKeyword )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1282:3: ruleThisKeyword
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAModelReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleThisKeyword_in_ruleAModelReference2608);
            ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1295:2: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==41) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1295:3: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1295:3: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1296:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleAModelReference2630); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAModelReferenceAccess().getFullStopKeyword_1_1());
            	          
            	    }
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1305:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1306:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1306:1: (otherlv_3= RULE_ID )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1307:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAModelReferenceRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAModelReference2650); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAModelReference"


    // $ANTLR start "entryRuleAPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1326:1: entryRuleAPropertyReference returns [EObject current=null] : iv_ruleAPropertyReference= ruleAPropertyReference EOF ;
    public final EObject entryRuleAPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPropertyReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1327:2: (iv_ruleAPropertyReference= ruleAPropertyReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1328:2: iv_ruleAPropertyReference= ruleAPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference2688);
            iv_ruleAPropertyReference=ruleAPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPropertyReference2698); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAPropertyReference"


    // $ANTLR start "ruleAPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1335:1: ruleAPropertyReference returns [EObject current=null] : ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject ruleAPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1338:28: ( ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1339:1: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1339:1: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1339:2: () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1339:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1340:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleAPropertyReference2744); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1349:1: ( ( ruleAADLPROPERTYREFERENCE ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1350:1: ( ruleAADLPROPERTYREFERENCE )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1350:1: ( ruleAADLPROPERTYREFERENCE )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1351:3: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAPropertyReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference2767);
            ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAPropertyReference"


    // $ANTLR start "entryRuleAVariableReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:1: entryRuleAVariableReference returns [EObject current=null] : iv_ruleAVariableReference= ruleAVariableReference EOF ;
    public final EObject entryRuleAVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1373:2: (iv_ruleAVariableReference= ruleAVariableReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1374:2: iv_ruleAVariableReference= ruleAVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAVariableReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference2803);
            iv_ruleAVariableReference=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAVariableReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAVariableReference2813); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAVariableReference"


    // $ANTLR start "ruleAVariableReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1381:1: ruleAVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleAVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1384:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1385:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1385:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1385:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1385:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1386:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1391:2: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1392:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1392:1: (otherlv_1= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1393:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAVariableReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAVariableReference2867); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0()); 
              	
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAVariableReference"


    // $ANTLR start "entryRuleShowValue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1412:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1413:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1414:2: iv_ruleShowValue= ruleShowValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShowValueRule()); 
            }
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue2903);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShowValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue2913); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShowValue"


    // $ANTLR start "ruleShowValue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1421:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1424:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1425:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1425:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1425:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1425:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1426:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1426:1: (otherlv_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1427:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShowValueRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue2958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1438:2: (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )?
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==42) ) {
                alt34=1;
            }
            else if ( (LA34_0==43) ) {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1438:4: otherlv_1= '%'
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleShowValue2971); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1443:6: (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1443:6: (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1443:8: otherlv_2= 'in' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleShowValue2990); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getShowValueAccess().getInKeyword_1_1_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1447:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1448:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1448:1: (otherlv_3= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1449:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getShowValueRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue3010); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShowValue"


    // $ANTLR start "entryRuleImageReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1468:1: entryRuleImageReference returns [EObject current=null] : iv_ruleImageReference= ruleImageReference EOF ;
    public final EObject entryRuleImageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1469:2: (iv_ruleImageReference= ruleImageReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1470:2: iv_ruleImageReference= ruleImageReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImageReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleImageReference_in_entryRuleImageReference3049);
            iv_ruleImageReference=ruleImageReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImageReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImageReference3059); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImageReference"


    // $ANTLR start "ruleImageReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1477:1: ruleImageReference returns [EObject current=null] : (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) ;
    public final EObject ruleImageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_imgfile_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1480:28: ( (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1481:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1481:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1481:3: otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleImageReference3096); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1485:1: ( (lv_imgfile_1_0= ruleIMGREF ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1486:1: (lv_imgfile_1_0= ruleIMGREF )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1486:1: (lv_imgfile_1_0= ruleIMGREF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1487:3: lv_imgfile_1_0= ruleIMGREF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIMGREF_in_ruleImageReference3117);
            lv_imgfile_1_0=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImageReferenceRule());
              	        }
                     		set(
                     			current, 
                     			"imgfile",
                      		lv_imgfile_1_0, 
                      		"IMGREF");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImageReference"


    // $ANTLR start "entryRuleIMGREF"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1511:1: entryRuleIMGREF returns [String current=null] : iv_ruleIMGREF= ruleIMGREF EOF ;
    public final String entryRuleIMGREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMGREF = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1512:2: (iv_ruleIMGREF= ruleIMGREF EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1513:2: iv_ruleIMGREF= ruleIMGREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMGREFRule()); 
            }
            pushFollow(FOLLOW_ruleIMGREF_in_entryRuleIMGREF3154);
            iv_ruleIMGREF=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMGREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMGREF3165); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIMGREF"


    // $ANTLR start "ruleIMGREF"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1520:1: ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMGREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1523:28: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1524:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1524:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1524:2: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1524:2: (this_ID_0= RULE_ID kw= '/' )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    int LA35_1 = input.LA(2);

                    if ( (LA35_1==45) ) {
                        alt35=1;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1524:7: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF3206); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,45,FOLLOW_45_in_ruleIMGREF3224); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF3241); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            kw=(Token)match(input,41,FOLLOW_41_in_ruleIMGREF3259); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); 
                  
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF3274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_4);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_4, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIMGREF"


    // $ANTLR start "entryRuleAExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1565:1: entryRuleAExpression returns [EObject current=null] : iv_ruleAExpression= ruleAExpression EOF ;
    public final EObject entryRuleAExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1566:2: (iv_ruleAExpression= ruleAExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1567:2: iv_ruleAExpression= ruleAExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAExpression_in_entryRuleAExpression3319);
            iv_ruleAExpression=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExpression3329); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAExpression"


    // $ANTLR start "ruleAExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1574:1: ruleAExpression returns [EObject current=null] : this_AOrExpression_0= ruleAOrExpression ;
    public final EObject ruleAExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOrExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1577:28: (this_AOrExpression_0= ruleAOrExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1579:5: this_AOrExpression_0= ruleAOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_ruleAExpression3375);
            this_AOrExpression_0=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAExpression"


    // $ANTLR start "entryRuleAOrExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1595:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1596:2: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1597:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression3409);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOrExpression3419); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAOrExpression"


    // $ANTLR start "ruleAOrExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1604:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1607:28: ( (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1608:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1608:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1609:5: this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression3466);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==46) && (synpred2_InternalResults())) {
                    alt36=1;
                }
                else if ( (LA36_0==47) && (synpred2_InternalResults())) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1622:6: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1622:7: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1622:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1623:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1628:2: ( (lv_operator_2_0= ruleOpOr ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1629:1: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1629:1: (lv_operator_2_0= ruleOpOr )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1630:3: lv_operator_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleAOrExpression3515);
            	    lv_operator_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpOr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1646:4: ( (lv_right_3_0= ruleAAndExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1647:1: (lv_right_3_0= ruleAAndExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1647:1: (lv_right_3_0= ruleAAndExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1648:3: lv_right_3_0= ruleAAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression3538);
            	    lv_right_3_0=ruleAAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1672:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1673:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1674:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr3577);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr3588); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1681:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'or' | kw= '||' ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1684:28: ( (kw= 'or' | kw= '||' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1685:1: (kw= 'or' | kw= '||' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1685:1: (kw= 'or' | kw= '||' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==46) ) {
                alt37=1;
            }
            else if ( (LA37_0==47) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1686:2: kw= 'or'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleOpOr3626); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1693:2: kw= '||'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpOr3645); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAAndExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1706:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1707:2: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1708:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression3685);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAndExpression3695); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAndExpression"


    // $ANTLR start "ruleAAndExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1715:1: ruleAAndExpression returns [EObject current=null] : (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:28: ( (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1719:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1719:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1720:5: this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3742);
            this_AEqualityExpression_0=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==48) && (synpred3_InternalResults())) {
                    alt38=1;
                }
                else if ( (LA38_0==49) && (synpred3_InternalResults())) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1733:6: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1733:7: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1733:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1734:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1739:2: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1740:1: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1740:1: (lv_operator_2_0= ruleOpAnd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1741:3: lv_operator_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleAAndExpression3791);
            	    lv_operator_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpAnd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1757:4: ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1758:1: (lv_right_3_0= ruleAEqualityExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1758:1: (lv_right_3_0= ruleAEqualityExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1759:3: lv_right_3_0= ruleAEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3814);
            	    lv_right_3_0=ruleAEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1783:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1784:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1785:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3853);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3864); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1792:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= '&&' ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1795:28: ( (kw= 'and' | kw= '&&' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1796:1: (kw= 'and' | kw= '&&' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1796:1: (kw= 'and' | kw= '&&' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==48) ) {
                alt39=1;
            }
            else if ( (LA39_0==49) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1797:2: kw= 'and'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpAnd3902); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1804:2: kw= '&&'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpAnd3921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleAEqualityExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1817:1: entryRuleAEqualityExpression returns [EObject current=null] : iv_ruleAEqualityExpression= ruleAEqualityExpression EOF ;
    public final EObject entryRuleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEqualityExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1818:2: (iv_ruleAEqualityExpression= ruleAEqualityExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1819:2: iv_ruleAEqualityExpression= ruleAEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3961);
            iv_ruleAEqualityExpression=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAEqualityExpression3971); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAEqualityExpression"


    // $ANTLR start "ruleAEqualityExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1826:1: ruleAEqualityExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ARelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1829:28: ( (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1830:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1830:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1831:5: this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression4018);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ARelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==50) && (synpred4_InternalResults())) {
                    alt40=1;
                }
                else if ( (LA40_0==51) && (synpred4_InternalResults())) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1844:6: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1844:7: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1844:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1845:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1850:2: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:1: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:1: (lv_operator_2_0= ruleOpEquality )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1852:3: lv_operator_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleAEqualityExpression4067);
            	    lv_operator_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpEquality");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1868:4: ( (lv_right_3_0= ruleARelationalExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1869:1: (lv_right_3_0= ruleARelationalExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1869:1: (lv_right_3_0= ruleARelationalExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1870:3: lv_right_3_0= ruleARelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression4090);
            	    lv_right_3_0=ruleARelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"ARelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1894:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1895:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1896:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality4129);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality4140); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1903:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1906:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1907:1: (kw= '==' | kw= '!=' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1907:1: (kw= '==' | kw= '!=' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==50) ) {
                alt41=1;
            }
            else if ( (LA41_0==51) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1908:2: kw= '=='
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpEquality4178); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1915:2: kw= '!='
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpEquality4197); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleARelationalExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1928:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1929:2: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1930:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression4237);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARelationalExpression4247); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARelationalExpression"


    // $ANTLR start "ruleARelationalExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:1: ruleARelationalExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1940:28: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1941:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1941:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1942:5: this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4294);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==52) && (synpred5_InternalResults())) {
                    alt42=1;
                }
                else if ( (LA42_0==53) && (synpred5_InternalResults())) {
                    alt42=1;
                }
                else if ( (LA42_0==54) && (synpred5_InternalResults())) {
                    alt42=1;
                }
                else if ( (LA42_0==55) && (synpred5_InternalResults())) {
                    alt42=1;
                }
                else if ( (LA42_0==56) && (synpred5_InternalResults())) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:6: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:7: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1956:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1961:2: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1962:1: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1962:1: (lv_operator_2_0= ruleOpCompare )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1963:3: lv_operator_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleARelationalExpression4343);
            	    lv_operator_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpCompare");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1979:4: ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1980:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1980:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1981:3: lv_right_3_0= ruleAAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4366);
            	    lv_right_3_0=ruleAAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AAdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleARelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2005:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2006:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2007:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare4405);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare4416); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2014:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2017:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2018:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2018:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            int alt43=5;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt43=1;
                }
                break;
            case 53:
                {
                alt43=2;
                }
                break;
            case 54:
                {
                alt43=3;
                }
                break;
            case 55:
                {
                alt43=4;
                }
                break;
            case 56:
                {
                alt43=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2019:2: kw= '>='
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpCompare4454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2026:2: kw= '<='
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleOpCompare4473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2033:2: kw= '>'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleOpCompare4492); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2040:2: kw= '<'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleOpCompare4511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2047:2: kw= '><'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleOpCompare4530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleAAdditiveExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2060:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2061:2: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2062:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4570);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAdditiveExpression4580); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAdditiveExpression"


    // $ANTLR start "ruleAAdditiveExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2069:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2072:28: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2073:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2073:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2074:5: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4627);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==57) && (synpred6_InternalResults())) {
                    alt44=1;
                }
                else if ( (LA44_0==58) && (synpred6_InternalResults())) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2087:6: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2087:7: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2087:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2088:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2093:2: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2094:1: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2094:1: (lv_operator_2_0= ruleOpAdd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2095:3: lv_operator_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4676);
            	    lv_operator_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpAdd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2111:4: ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2112:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2112:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2113:3: lv_right_3_0= ruleAMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4699);
            	    lv_right_3_0=ruleAMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2137:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2138:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2139:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4738);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4749); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2146:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2149:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2150:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2150:1: (kw= '+' | kw= '-' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==57) ) {
                alt45=1;
            }
            else if ( (LA45_0==58) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2151:2: kw= '+'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleOpAdd4787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2158:2: kw= '-'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleOpAdd4806); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleAMultiplicativeExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2171:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2172:2: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2173:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4846);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4856); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMultiplicativeExpression"


    // $ANTLR start "ruleAMultiplicativeExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2180:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2183:28: ( (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2184:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2184:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2185:5: this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4903);
            this_AUnaryOperation_0=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==59) && (synpred7_InternalResults())) {
                    alt46=1;
                }
                else if ( (LA46_0==45) && (synpred7_InternalResults())) {
                    alt46=1;
                }
                else if ( (LA46_0==60) && (synpred7_InternalResults())) {
                    alt46=1;
                }
                else if ( (LA46_0==61) && (synpred7_InternalResults())) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2198:6: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2198:7: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2198:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2199:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2204:2: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2205:1: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2205:1: (lv_operator_2_0= ruleOpMulti )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2206:3: lv_operator_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4952);
            	    lv_operator_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpMulti");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2222:4: ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2223:1: (lv_right_3_0= ruleAUnaryOperation )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2223:1: (lv_right_3_0= ruleAUnaryOperation )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2224:3: lv_right_3_0= ruleAUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4975);
            	    lv_right_3_0=ruleAUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2248:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2249:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2250:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti5014);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti5025); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2257:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2260:28: ( (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2261:1: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2261:1: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt47=1;
                }
                break;
            case 45:
                {
                alt47=2;
                }
                break;
            case 60:
                {
                alt47=3;
                }
                break;
            case 61:
                {
                alt47=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2262:2: kw= '*'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleOpMulti5063); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2269:2: kw= '/'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleOpMulti5082); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2276:2: kw= 'div'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleOpMulti5101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2283:2: kw= 'mod'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleOpMulti5120); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getModKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleAUnaryOperation"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2296:1: entryRuleAUnaryOperation returns [EObject current=null] : iv_ruleAUnaryOperation= ruleAUnaryOperation EOF ;
    public final EObject entryRuleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOperation = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2297:2: (iv_ruleAUnaryOperation= ruleAUnaryOperation EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2298:2: iv_ruleAUnaryOperation= ruleAUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation5160);
            iv_ruleAUnaryOperation=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryOperation5170); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAUnaryOperation"


    // $ANTLR start "ruleAUnaryOperation"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2305:1: ruleAUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) ;
    public final EObject ruleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_AUnitExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2308:28: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=57 && LA48_0<=58)||LA48_0==62) ) {
                alt48=1;
            }
            else if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_REAL_LIT)||LA48_0==20||LA48_0==29||LA48_0==40||LA48_0==63||LA48_0==68||(LA48_0>=72 && LA48_0<=73)) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:3: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:3: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2310:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2315:2: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2315:3: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2320:1: (lv_operator_1_0= ruleOpUnary )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2321:3: lv_operator_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleAUnaryOperation5236);
                    lv_operator_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_1_0, 
                              		"OpUnary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2337:2: ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2338:1: (lv_operand_2_0= ruleAUnaryOperation )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2338:1: (lv_operand_2_0= ruleAUnaryOperation )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2339:3: lv_operand_2_0= ruleAUnaryOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation5257);
                    lv_operand_2_0=ruleAUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"AUnaryOperation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2357:5: this_AUnitExpression_3= ruleAUnitExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAUnitExpression_in_ruleAUnaryOperation5286);
                    this_AUnitExpression_3=ruleAUnitExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AUnitExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2373:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2374:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2375:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5322);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5333); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2382:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2385:28: ( (kw= 'not' | kw= '-' | kw= '+' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2386:1: (kw= 'not' | kw= '-' | kw= '+' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2386:1: (kw= 'not' | kw= '-' | kw= '+' )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt49=1;
                }
                break;
            case 58:
                {
                alt49=2;
                }
                break;
            case 57:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2387:2: kw= 'not'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleOpUnary5371); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2394:2: kw= '-'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleOpUnary5390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2401:2: kw= '+'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleOpUnary5409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleAUnitExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2414:1: entryRuleAUnitExpression returns [EObject current=null] : iv_ruleAUnitExpression= ruleAUnitExpression EOF ;
    public final EObject entryRuleAUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnitExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2415:2: (iv_ruleAUnitExpression= ruleAUnitExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2416:2: iv_ruleAUnitExpression= ruleAUnitExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnitExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAUnitExpression_in_entryRuleAUnitExpression5449);
            iv_ruleAUnitExpression=ruleAUnitExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnitExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnitExpression5459); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAUnitExpression"


    // $ANTLR start "ruleAUnitExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2423:1: ruleAUnitExpression returns [EObject current=null] : (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleAUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_APrimaryExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2426:28: ( (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2427:1: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2427:1: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2428:5: this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAPrimaryExpression_in_ruleAUnitExpression5506);
            this_APrimaryExpression_0=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_APrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2436:1: ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID||(LA51_0>=42 && LA51_0<=43)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2436:2: () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2436:2: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2437:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2442:2: ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )?
                    int alt50=3;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==42) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==43) ) {
                        alt50=2;
                    }
                    switch (alt50) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2442:3: ( (lv_convert_2_0= '%' ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2442:3: ( (lv_convert_2_0= '%' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2443:1: (lv_convert_2_0= '%' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2443:1: (lv_convert_2_0= '%' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2444:3: lv_convert_2_0= '%'
                            {
                            lv_convert_2_0=(Token)match(input,42,FOLLOW_42_in_ruleAUnitExpression5534); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_convert_2_0, grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAUnitExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "convert", true, "%");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2458:6: ( (lv_drop_3_0= 'in' ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2458:6: ( (lv_drop_3_0= 'in' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2459:1: (lv_drop_3_0= 'in' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2459:1: (lv_drop_3_0= 'in' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2460:3: lv_drop_3_0= 'in'
                            {
                            lv_drop_3_0=(Token)match(input,43,FOLLOW_43_in_ruleAUnitExpression5571); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_drop_3_0, grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAUnitExpressionRule());
                              	        }
                                     		setWithLastConsumed(current, "drop", true, "in");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2473:4: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2474:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2474:1: (otherlv_4= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2475:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAUnitExpressionRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAUnitExpression5606); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAUnitExpression"


    // $ANTLR start "entryRuleAPrimaryExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2494:1: entryRuleAPrimaryExpression returns [EObject current=null] : iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF ;
    public final EObject entryRuleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPrimaryExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2495:2: (iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2496:2: iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5644);
            iv_ruleAPrimaryExpression=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPrimaryExpression5654); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAPrimaryExpression"


    // $ANTLR start "ruleAPrimaryExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2503:1: ruleAPrimaryExpression returns [EObject current=null] : (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) ;
    public final EObject ruleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ALiteral_0 = null;

        EObject this_AVariableReference_1 = null;

        EObject this_AModelOrPropertyReference_2 = null;

        EObject this_AFunctionCall_3 = null;

        EObject this_ARangeExpression_4 = null;

        EObject this_AIfExpression_5 = null;

        EObject this_AParenthesizedExpression_6 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2506:28: ( (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2507:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2507:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            int alt52=7;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL_LIT:
            case 72:
            case 73:
                {
                alt52=1;
                }
                break;
            case RULE_ID:
                {
                int LA52_2 = input.LA(2);

                if ( (LA52_2==EOF||LA52_2==RULE_ID||LA52_2==22||(LA52_2>=42 && LA52_2<=43)||(LA52_2>=45 && LA52_2<=61)||(LA52_2>=64 && LA52_2<=67)||(LA52_2>=69 && LA52_2<=71)) ) {
                    alt52=2;
                }
                else if ( (LA52_2==41||LA52_2==63) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;
                }
                }
                break;
            case 29:
            case 40:
                {
                alt52=3;
                }
                break;
            case 20:
                {
                alt52=5;
                }
                break;
            case 68:
                {
                alt52=6;
                }
                break;
            case 63:
                {
                alt52=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2508:5: this_ALiteral_0= ruleALiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5701);
                    this_ALiteral_0=ruleALiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ALiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2518:5: this_AVariableReference_1= ruleAVariableReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5728);
                    this_AVariableReference_1=ruleAVariableReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AVariableReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2528:5: this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAModelOrPropertyReference_in_ruleAPrimaryExpression5755);
                    this_AModelOrPropertyReference_2=ruleAModelOrPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AModelOrPropertyReference_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2538:5: this_AFunctionCall_3= ruleAFunctionCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAFunctionCall_in_ruleAPrimaryExpression5782);
                    this_AFunctionCall_3=ruleAFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AFunctionCall_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2548:5: this_ARangeExpression_4= ruleARangeExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARangeExpression_in_ruleAPrimaryExpression5809);
                    this_ARangeExpression_4=ruleARangeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ARangeExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2558:5: this_AIfExpression_5= ruleAIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIfExpression_in_ruleAPrimaryExpression5836);
                    this_AIfExpression_5=ruleAIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AIfExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2568:5: this_AParenthesizedExpression_6= ruleAParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5863);
                    this_AParenthesizedExpression_6=ruleAParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AParenthesizedExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAPrimaryExpression"


    // $ANTLR start "entryRuleAFunctionCall"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2584:1: entryRuleAFunctionCall returns [EObject current=null] : iv_ruleAFunctionCall= ruleAFunctionCall EOF ;
    public final EObject entryRuleAFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunctionCall = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2585:2: (iv_ruleAFunctionCall= ruleAFunctionCall EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2586:2: iv_ruleAFunctionCall= ruleAFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAFunctionCallRule()); 
            }
            pushFollow(FOLLOW_ruleAFunctionCall_in_entryRuleAFunctionCall5898);
            iv_ruleAFunctionCall=ruleAFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAFunctionCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAFunctionCall5908); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAFunctionCall"


    // $ANTLR start "ruleAFunctionCall"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2593:1: ruleAFunctionCall returns [EObject current=null] : ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleAFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_function_1_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2596:28: ( ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2597:1: ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2597:1: ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2597:2: () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2597:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2598:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2603:2: ( (lv_function_1_0= ruleQualifiedName ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2604:1: (lv_function_1_0= ruleQualifiedName )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2604:1: (lv_function_1_0= ruleQualifiedName )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2605:3: lv_function_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getFunctionQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAFunctionCall5963);
            lv_function_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
              	        }
                     		set(
                     			current, 
                     			"function",
                      		lv_function_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleAFunctionCall5975); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2625:1: ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_ID && LA54_0<=RULE_REAL_LIT)||LA54_0==20||LA54_0==29||LA54_0==40||(LA54_0>=57 && LA54_0<=58)||(LA54_0>=62 && LA54_0<=63)||LA54_0==68||(LA54_0>=72 && LA54_0<=73)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2625:2: ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )*
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2625:2: ( (lv_arguments_3_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2626:1: (lv_arguments_3_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2626:1: (lv_arguments_3_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2627:3: lv_arguments_3_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleAFunctionCall5997);
                    lv_arguments_3_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_3_0, 
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2643:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==64) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2643:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,64,FOLLOW_64_in_ruleAFunctionCall6010); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getAFunctionCallAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2647:1: ( (lv_arguments_5_0= ruleAExpression ) )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2648:1: (lv_arguments_5_0= ruleAExpression )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2648:1: (lv_arguments_5_0= ruleAExpression )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2649:3: lv_arguments_5_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAExpression_in_ruleAFunctionCall6031);
                    	    lv_arguments_5_0=ruleAExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_5_0, 
                    	              		"AExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,65,FOLLOW_65_in_ruleAFunctionCall6047); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAFunctionCall"


    // $ANTLR start "entryRuleARangeExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2677:1: entryRuleARangeExpression returns [EObject current=null] : iv_ruleARangeExpression= ruleARangeExpression EOF ;
    public final EObject entryRuleARangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARangeExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2678:2: (iv_ruleARangeExpression= ruleARangeExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2679:2: iv_ruleARangeExpression= ruleARangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARangeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleARangeExpression_in_entryRuleARangeExpression6083);
            iv_ruleARangeExpression=ruleARangeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARangeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARangeExpression6093); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARangeExpression"


    // $ANTLR start "ruleARangeExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2686:1: ruleARangeExpression returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) ;
    public final EObject ruleARangeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_minimum_2_0 = null;

        EObject lv_maximum_4_0 = null;

        EObject lv_delta_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2689:28: ( ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2690:1: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2690:1: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2690:2: () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2690:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2691:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getARangeExpressionAccess().getARangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleARangeExpression6139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2700:1: ( (lv_minimum_2_0= ruleAExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2701:1: (lv_minimum_2_0= ruleAExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2701:1: (lv_minimum_2_0= ruleAExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2702:3: lv_minimum_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleARangeExpression6160);
            lv_minimum_2_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"minimum",
                      		lv_minimum_2_0, 
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,66,FOLLOW_66_in_ruleARangeExpression6172); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2722:1: ( (lv_maximum_4_0= ruleAExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2723:1: (lv_maximum_4_0= ruleAExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2723:1: (lv_maximum_4_0= ruleAExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2724:3: lv_maximum_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleARangeExpression6193);
            lv_maximum_4_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"maximum",
                      		lv_maximum_4_0, 
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2740:2: ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==67) && (synpred9_InternalResults())) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2740:3: ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2740:3: ( ( 'delta' )=>otherlv_5= 'delta' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2740:4: ( 'delta' )=>otherlv_5= 'delta'
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_67_in_ruleARangeExpression6214); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2745:2: ( (lv_delta_6_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2746:1: (lv_delta_6_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2746:1: (lv_delta_6_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2747:3: lv_delta_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleARangeExpression6236);
                    lv_delta_6_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"delta",
                              		lv_delta_6_0, 
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleARangeExpression6250); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleARangeExpression"


    // $ANTLR start "entryRuleAIfExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2775:1: entryRuleAIfExpression returns [EObject current=null] : iv_ruleAIfExpression= ruleAIfExpression EOF ;
    public final EObject entryRuleAIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIfExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2776:2: (iv_ruleAIfExpression= ruleAIfExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2777:2: iv_ruleAIfExpression= ruleAIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression6286);
            iv_ruleAIfExpression=ruleAIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIfExpression6296); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIfExpression"


    // $ANTLR start "ruleAIfExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2784:1: ruleAIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) ;
    public final EObject ruleAIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2787:28: ( ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2788:1: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2788:1: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2788:2: () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2788:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2789:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAIfExpressionAccess().getAConditionalAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleAIfExpression6342); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAIfExpressionAccess().getIfKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2798:1: ( (lv_if_2_0= ruleAExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2799:1: (lv_if_2_0= ruleAExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2799:1: (lv_if_2_0= ruleAExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2800:3: lv_if_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAIfExpression6363);
            lv_if_2_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_2_0, 
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,69,FOLLOW_69_in_ruleAIfExpression6375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAIfExpressionAccess().getThenKeyword_3());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2820:1: ( (lv_then_4_0= ruleAExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2821:1: (lv_then_4_0= ruleAExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2821:1: (lv_then_4_0= ruleAExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2822:3: lv_then_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAIfExpression6396);
            lv_then_4_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_4_0, 
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2838:2: (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==70) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2838:4: otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) )
                    {
                    otherlv_5=(Token)match(input,70,FOLLOW_70_in_ruleAIfExpression6409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2842:1: ( (lv_else_6_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2843:1: (lv_else_6_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2843:1: (lv_else_6_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2844:3: lv_else_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleAIfExpression6430);
                    lv_else_6_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_6_0, 
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,71,FOLLOW_71_in_ruleAIfExpression6444); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAIfExpressionAccess().getEndifKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIfExpression"


    // $ANTLR start "entryRuleALiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2872:1: entryRuleALiteral returns [EObject current=null] : iv_ruleALiteral= ruleALiteral EOF ;
    public final EObject entryRuleALiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2873:2: (iv_ruleALiteral= ruleALiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2874:2: iv_ruleALiteral= ruleALiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getALiteralRule()); 
            }
            pushFollow(FOLLOW_ruleALiteral_in_entryRuleALiteral6480);
            iv_ruleALiteral=ruleALiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleALiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleALiteral6490); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleALiteral"


    // $ANTLR start "ruleALiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2881:1: ruleALiteral returns [EObject current=null] : (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) ;
    public final EObject ruleALiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ABooleanLiteral_0 = null;

        EObject this_ARealTerm_1 = null;

        EObject this_AIntegerTerm_2 = null;

        EObject this_StringTerm_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2884:28: ( (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2885:1: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2885:1: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            int alt57=4;
            switch ( input.LA(1) ) {
            case 72:
            case 73:
                {
                alt57=1;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt57=2;
                }
                break;
            case RULE_INT:
                {
                alt57=3;
                }
                break;
            case RULE_STRING:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2886:5: this_ABooleanLiteral_0= ruleABooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleABooleanLiteral_in_ruleALiteral6537);
                    this_ABooleanLiteral_0=ruleABooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ABooleanLiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2896:5: this_ARealTerm_1= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleALiteral6564);
                    this_ARealTerm_1=ruleARealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ARealTerm_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2906:5: this_AIntegerTerm_2= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleALiteral6591);
                    this_AIntegerTerm_2=ruleAIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AIntegerTerm_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2916:5: this_StringTerm_3= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleALiteral6618);
                    this_StringTerm_3=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringTerm_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleALiteral"


    // $ANTLR start "entryRuleAIntegerTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2932:1: entryRuleAIntegerTerm returns [EObject current=null] : iv_ruleAIntegerTerm= ruleAIntegerTerm EOF ;
    public final EObject entryRuleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2933:2: (iv_ruleAIntegerTerm= ruleAIntegerTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2934:2: iv_ruleAIntegerTerm= ruleAIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntegerTermRule()); 
            }
            pushFollow(FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm6653);
            iv_ruleAIntegerTerm=ruleAIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIntegerTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIntegerTerm6663); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIntegerTerm"


    // $ANTLR start "ruleAIntegerTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2941:1: ruleAIntegerTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAInt ) ) ;
    public final EObject ruleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2944:28: ( ( (lv_value_0_0= ruleAInt ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2945:1: ( (lv_value_0_0= ruleAInt ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2945:1: ( (lv_value_0_0= ruleAInt ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2946:1: (lv_value_0_0= ruleAInt )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2946:1: (lv_value_0_0= ruleAInt )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2947:3: lv_value_0_0= ruleAInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAInt_in_ruleAIntegerTerm6708);
            lv_value_0_0=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAIntegerTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"AInt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIntegerTerm"


    // $ANTLR start "entryRuleAInt"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2971:1: entryRuleAInt returns [String current=null] : iv_ruleAInt= ruleAInt EOF ;
    public final String entryRuleAInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAInt = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2972:2: (iv_ruleAInt= ruleAInt EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2973:2: iv_ruleAInt= ruleAInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntRule()); 
            }
            pushFollow(FOLLOW_ruleAInt_in_entryRuleAInt6744);
            iv_ruleAInt=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAInt6755); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAInt"


    // $ANTLR start "ruleAInt"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2980:1: ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleAInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2983:28: (this_INT_0= RULE_INT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2984:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAInt6794); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getAIntAccess().getINTTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAInt"


    // $ANTLR start "entryRuleARealTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2999:1: entryRuleARealTerm returns [EObject current=null] : iv_ruleARealTerm= ruleARealTerm EOF ;
    public final EObject entryRuleARealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3000:2: (iv_ruleARealTerm= ruleARealTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3001:2: iv_ruleARealTerm= ruleARealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealTermRule()); 
            }
            pushFollow(FOLLOW_ruleARealTerm_in_entryRuleARealTerm6838);
            iv_ruleARealTerm=ruleARealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARealTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARealTerm6848); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARealTerm"


    // $ANTLR start "ruleARealTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3008:1: ruleARealTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAReal ) ) ;
    public final EObject ruleARealTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3011:28: ( ( (lv_value_0_0= ruleAReal ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3012:1: ( (lv_value_0_0= ruleAReal ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3012:1: ( (lv_value_0_0= ruleAReal ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3013:1: (lv_value_0_0= ruleAReal )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3013:1: (lv_value_0_0= ruleAReal )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3014:3: lv_value_0_0= ruleAReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAReal_in_ruleARealTerm6893);
            lv_value_0_0=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getARealTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"AReal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleARealTerm"


    // $ANTLR start "entryRuleAReal"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3038:1: entryRuleAReal returns [String current=null] : iv_ruleAReal= ruleAReal EOF ;
    public final String entryRuleAReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAReal = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3039:2: (iv_ruleAReal= ruleAReal EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3040:2: iv_ruleAReal= ruleAReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealRule()); 
            }
            pushFollow(FOLLOW_ruleAReal_in_entryRuleAReal6929);
            iv_ruleAReal=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAReal.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAReal6940); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAReal"


    // $ANTLR start "ruleAReal"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3047:1: ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleAReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:28: (this_REAL_LIT_0= RULE_REAL_LIT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3051:5: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_RULE_REAL_LIT_in_ruleAReal6979); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_REAL_LIT_0, grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAReal"


    // $ANTLR start "entryRuleABooleanLiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3066:1: entryRuleABooleanLiteral returns [EObject current=null] : iv_ruleABooleanLiteral= ruleABooleanLiteral EOF ;
    public final EObject entryRuleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanLiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3067:2: (iv_ruleABooleanLiteral= ruleABooleanLiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3068:2: iv_ruleABooleanLiteral= ruleABooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getABooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral7023);
            iv_ruleABooleanLiteral=ruleABooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleABooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleABooleanLiteral7033); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleABooleanLiteral"


    // $ANTLR start "ruleABooleanLiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3075:1: ruleABooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3078:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3079:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3079:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3079:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3079:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3080:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3085:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==72) ) {
                alt58=1;
            }
            else if ( (LA58_0==73) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3085:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3085:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3086:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3086:1: (lv_value_1_0= 'true' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3087:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,72,FOLLOW_72_in_ruleABooleanLiteral7086); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_1_0, grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getABooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "value", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3101:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,73,FOLLOW_73_in_ruleABooleanLiteral7117); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleABooleanLiteral"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3113:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3114:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3115:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm7154);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm7164); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3122:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3125:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3126:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3126:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3127:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3127:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3128:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm7209);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStringTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"NoQuoteString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3152:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3153:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3154:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString7245);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString7256); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3161:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3164:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3165:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString7295); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleAParenthesizedExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3180:1: entryRuleAParenthesizedExpression returns [EObject current=null] : iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF ;
    public final EObject entryRuleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParenthesizedExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3181:2: (iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3182:2: iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression7339);
            iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAParenthesizedExpression7349); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAParenthesizedExpression"


    // $ANTLR start "ruleAParenthesizedExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3189:1: ruleAParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) ;
    public final EObject ruleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3192:28: ( (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3193:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3193:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3193:3: otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleAParenthesizedExpression7386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression7408);
            this_AExpression_1=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,65,FOLLOW_65_in_ruleAParenthesizedExpression7419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAParenthesizedExpression"


    // $ANTLR start "entryRuleAADLPROPERTYREFERENCE"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3222:1: entryRuleAADLPROPERTYREFERENCE returns [String current=null] : iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF ;
    public final String entryRuleAADLPROPERTYREFERENCE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAADLPROPERTYREFERENCE = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3223:2: (iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3224:2: iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); 
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE7460);
            iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAADLPROPERTYREFERENCE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE7471); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAADLPROPERTYREFERENCE"


    // $ANTLR start "ruleAADLPROPERTYREFERENCE"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3231:1: ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAADLPROPERTYREFERENCE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3234:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3235:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3235:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3235:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7511); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3242:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==74) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3243:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleAADLPROPERTYREFERENCE7530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_2, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAADLPROPERTYREFERENCE"


    // $ANTLR start "entryRuleURIID"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3263:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3264:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3265:2: iv_ruleURIID= ruleURIID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIIDRule()); 
            }
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID7593);
            iv_ruleURIID=ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID7604); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIID"


    // $ANTLR start "ruleURIID"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3272:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3275:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3276:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID7643); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIID"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3291:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3292:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3293:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7688);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7699); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3300:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3303:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3304:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3304:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3304:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3311:1: (kw= '.' this_ID_2= RULE_ID )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==41) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3312:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,41,FOLLOW_41_in_ruleQualifiedName7758); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7773); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleThisKeyword"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3332:1: entryRuleThisKeyword returns [String current=null] : iv_ruleThisKeyword= ruleThisKeyword EOF ;
    public final String entryRuleThisKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleThisKeyword = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3333:2: (iv_ruleThisKeyword= ruleThisKeyword EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3334:2: iv_ruleThisKeyword= ruleThisKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThisKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleThisKeyword_in_entryRuleThisKeyword7821);
            iv_ruleThisKeyword=ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThisKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleThisKeyword7832); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisKeyword"


    // $ANTLR start "ruleThisKeyword"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3341:1: ruleThisKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'this' ;
    public final AntlrDatatypeRuleToken ruleThisKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3344:28: (kw= 'this' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3346:2: kw= 'this'
            {
            kw=(Token)match(input,29,FOLLOW_29_in_ruleThisKeyword7869); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getThisKeywordAccess().getThisKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisKeyword"


    // $ANTLR start "ruleResultIssueType"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3359:1: ruleResultIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) ;
    public final Enumerator ruleResultIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3361:28: ( ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3362:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3362:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            int alt61=6;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt61=1;
                }
                break;
            case 76:
                {
                alt61=2;
                }
                break;
            case 77:
                {
                alt61=3;
                }
                break;
            case 78:
                {
                alt61=4;
                }
                break;
            case 79:
                {
                alt61=5;
                }
                break;
            case 80:
                {
                alt61=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3362:2: (enumLiteral_0= 'tbd' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3362:2: (enumLiteral_0= 'tbd' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3362:4: enumLiteral_0= 'tbd'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_75_in_ruleResultIssueType7922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3368:6: (enumLiteral_1= 'error' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3368:6: (enumLiteral_1= 'error' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3368:8: enumLiteral_1= 'error'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_76_in_ruleResultIssueType7939); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3374:6: (enumLiteral_2= 'warning' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3374:6: (enumLiteral_2= 'warning' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3374:8: enumLiteral_2= 'warning'
                    {
                    enumLiteral_2=(Token)match(input,77,FOLLOW_77_in_ruleResultIssueType7956); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3380:6: (enumLiteral_3= 'info' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3380:6: (enumLiteral_3= 'info' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3380:8: enumLiteral_3= 'info'
                    {
                    enumLiteral_3=(Token)match(input,78,FOLLOW_78_in_ruleResultIssueType7973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3386:6: (enumLiteral_4= 'success' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3386:6: (enumLiteral_4= 'success' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3386:8: enumLiteral_4= 'success'
                    {
                    enumLiteral_4=(Token)match(input,79,FOLLOW_79_in_ruleResultIssueType7990); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3392:6: (enumLiteral_5= 'fail' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3392:6: (enumLiteral_5= 'fail' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3392:8: enumLiteral_5= 'fail'
                    {
                    enumLiteral_5=(Token)match(input,80,FOLLOW_80_in_ruleResultIssueType8007); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResultIssueType"

    // $ANTLR start synpred1_InternalResults
    public final void synpred1_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:3: ( ( () '#' ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:4: ( () '#' )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:4: ( () '#' )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:5: () '#'
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1222:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1223:1: 
        {
        }

        match(input,40,FOLLOW_40_in_synpred1_InternalResults2440); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalResults

    // $ANTLR start synpred2_InternalResults
    public final void synpred2_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:4: ( () ( ( ruleOpOr ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:5: () ( ( ruleOpOr ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1618:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1618:2: ( ( ruleOpOr ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1619:1: ( ruleOpOr )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1619:1: ( ruleOpOr )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1620:1: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalResults3485);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalResults

    // $ANTLR start synpred3_InternalResults
    public final void synpred3_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:5: () ( ( ruleOpAnd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1729:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1729:2: ( ( ruleOpAnd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1730:1: ( ruleOpAnd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1730:1: ( ruleOpAnd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1731:1: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalResults3761);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalResults

    // $ANTLR start synpred4_InternalResults
    public final void synpred4_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:5: () ( ( ruleOpEquality ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1840:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1840:2: ( ( ruleOpEquality ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1841:1: ( ruleOpEquality )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1841:1: ( ruleOpEquality )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1842:1: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalResults4037);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalResults

    // $ANTLR start synpred5_InternalResults
    public final void synpred5_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:4: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:4: ( () ( ( ruleOpCompare ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:5: () ( ( ruleOpCompare ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1951:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1951:2: ( ( ruleOpCompare ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1952:1: ( ruleOpCompare )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1952:1: ( ruleOpCompare )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1953:1: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred5_InternalResults4313);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalResults

    // $ANTLR start synpred6_InternalResults
    public final void synpred6_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:5: () ( ( ruleOpAdd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2082:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2083:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2083:2: ( ( ruleOpAdd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2084:1: ( ruleOpAdd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2084:1: ( ruleOpAdd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2085:1: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred6_InternalResults4646);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalResults

    // $ANTLR start synpred7_InternalResults
    public final void synpred7_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:5: () ( ( ruleOpMulti ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2193:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2194:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2194:2: ( ( ruleOpMulti ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2195:1: ( ruleOpMulti )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2195:1: ( ruleOpMulti )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2196:1: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred7_InternalResults4922);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalResults

    // $ANTLR start synpred9_InternalResults
    public final void synpred9_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2740:4: ( 'delta' )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2740:6: 'delta'
        {
        match(input,67,FOLLOW_67_in_synpred9_InternalResults6206); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalResults

    // Delegated rules

    public final boolean synpred9_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleResultReport_in_entryRuleResultReport75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReport85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultDataReport_in_ruleResultReport132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_ruleResultReport159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_ruleResultReport186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReportCollection231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleResultReportCollection268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReportCollection285 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleResultReportCollection303 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection320 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleResultReportCollection339 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReportCollection362 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultReportCollection374 = new BitSet(new long[]{0x0000000010E20000L,0x000000000001F800L});
    public static final BitSet FOLLOW_21_in_ruleResultReportCollection387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection404 = new BitSet(new long[]{0x0000000010C20000L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReportCollection432 = new BitSet(new long[]{0x0000000010C20000L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultReportCollection454 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleResultReportCollection467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultDataReport_in_entryRuleResultDataReport503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultDataReport513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleResultDataReport550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultDataReport567 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleResultDataReport585 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport602 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleResultDataReport621 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultDataReport644 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultDataReport656 = new BitSet(new long[]{0x0000000003600000L,0x000000000001F800L});
    public static final BitSet FOLLOW_21_in_ruleResultDataReport669 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport686 = new BitSet(new long[]{0x0000000003400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_24_in_ruleResultDataReport706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport723 = new BitSet(new long[]{0x0000000006400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultDataReport749 = new BitSet(new long[]{0x0000000006400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_25_in_ruleResultDataReport765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultDataReport786 = new BitSet(new long[]{0x0000000000400010L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultDataReport810 = new BitSet(new long[]{0x0000000000400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_22_in_ruleResultDataReport823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleResultContributor906 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultContributor929 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultContributor941 = new BitSet(new long[]{0x0000000006400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_25_in_ruleResultContributor954 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultContributor975 = new BitSet(new long[]{0x0000000004400010L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultContributor999 = new BitSet(new long[]{0x0000000004400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultContributor1021 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_22_in_ruleResultContributor1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData1070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultData1122 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleResultData1139 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultData1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleResultData1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport1227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssuesReport1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleIssuesReport1274 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIssuesReport1291 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleIssuesReport1309 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleIssuesReport1332 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleIssuesReport1347 = new BitSet(new long[]{0x0000000000600000L,0x000000000001F800L});
    public static final BitSet FOLLOW_21_in_ruleIssuesReport1360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssuesReport1377 = new BitSet(new long[]{0x0000000000400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleIssuesReport1405 = new BitSet(new long[]{0x0000000000400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_22_in_ruleIssuesReport1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDescriptionElement1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_ruleDescriptionElement1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_entryRuleResultIssue1646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultIssue1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultIssue1702 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1719 = new BitSet(new long[]{0x00000001C0100002L});
    public static final BitSet FOLLOW_30_in_ruleResultIssue1737 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleResultIssue1760 = new BitSet(new long[]{0x0000000180100002L});
    public static final BitSet FOLLOW_31_in_ruleResultIssue1775 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1792 = new BitSet(new long[]{0x0000000100100002L});
    public static final BitSet FOLLOW_32_in_ruleResultIssue1812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1829 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleResultIssue1849 = new BitSet(new long[]{0x0000000000400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultIssue1870 = new BitSet(new long[]{0x0000000000400000L,0x000000000001F800L});
    public static final BitSet FOLLOW_22_in_ruleResultIssue1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleTypeRef1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleTypeRef2007 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleTypeRef2020 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleTypeRef2074 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleTypeRef2087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleTypeRef2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleTypeRef2170 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleTypeRef2182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyRef_in_entryRulePropertyRef2259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyRef2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_rulePropertyRef2326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelOrPropertyReference_in_entryRuleAModelOrPropertyReference2366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAModelOrPropertyReference2376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelReference_in_ruleAModelOrPropertyReference2424 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleAModelOrPropertyReference2459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAModelOrPropertyReference2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_ruleAModelOrPropertyReference2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelReference_in_entryRuleAModelReference2550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAModelReference2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisKeyword_in_ruleAModelReference2608 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleAModelReference2630 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAModelReference2650 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference2688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPropertyReference2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAPropertyReference2744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference2803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAVariableReference2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAVariableReference2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue2903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue2958 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_42_in_ruleShowValue2971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleShowValue2990 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_entryRuleImageReference3049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImageReference3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleImageReference3096 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMGREF_in_ruleImageReference3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMGREF_in_entryRuleIMGREF3154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMGREF3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF3206 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleIMGREF3224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF3241 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleIMGREF3259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF3274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExpression_in_entryRuleAExpression3319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExpression3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_ruleAExpression3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression3409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOrExpression3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression3466 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleAOrExpression3515 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression3538 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr3577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleOpOr3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOpOr3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression3685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAndExpression3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3742 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleAAndExpression3791 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3814 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpAnd3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpAnd3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAEqualityExpression3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression4018 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleAEqualityExpression4067 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression4090 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality4129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpEquality4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpEquality4197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression4237 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARelationalExpression4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4294 = new BitSet(new long[]{0x01F0000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleARelationalExpression4343 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4366 = new BitSet(new long[]{0x01F0000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare4405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpCompare4454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOpCompare4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpCompare4492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleOpCompare4511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleOpCompare4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAdditiveExpression4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4627 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4676 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4699 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleOpAdd4787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleOpAdd4806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4903 = new BitSet(new long[]{0x3800200000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4952 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4975 = new BitSet(new long[]{0x3800200000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti5014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleOpMulti5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOpMulti5082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleOpMulti5101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleOpMulti5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation5160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryOperation5170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleAUnaryOperation5236 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation5257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnitExpression_in_ruleAUnaryOperation5286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleOpUnary5371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleOpUnary5390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleOpUnary5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnitExpression_in_entryRuleAUnitExpression5449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnitExpression5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_ruleAUnitExpression5506 = new BitSet(new long[]{0x00000C0000000012L});
    public static final BitSet FOLLOW_42_in_ruleAUnitExpression5534 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_43_in_ruleAUnitExpression5571 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAUnitExpression5606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPrimaryExpression5654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelOrPropertyReference_in_ruleAPrimaryExpression5755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionCall_in_ruleAPrimaryExpression5782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARangeExpression_in_ruleAPrimaryExpression5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_ruleAPrimaryExpression5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionCall_in_entryRuleAFunctionCall5898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAFunctionCall5908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAFunctionCall5963 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleAFunctionCall5975 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000312L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAFunctionCall5997 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_64_in_ruleAFunctionCall6010 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAFunctionCall6031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_65_in_ruleAFunctionCall6047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARangeExpression_in_entryRuleARangeExpression6083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARangeExpression6093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleARangeExpression6139 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleARangeExpression6160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleARangeExpression6172 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleARangeExpression6193 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleARangeExpression6214 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleARangeExpression6236 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleARangeExpression6250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression6286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIfExpression6296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleAIfExpression6342 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAIfExpression6363 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleAIfExpression6375 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAIfExpression6396 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_70_in_ruleAIfExpression6409 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAIfExpression6430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleAIfExpression6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_entryRuleALiteral6480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALiteral6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_ruleALiteral6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleALiteral6564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleALiteral6591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleALiteral6618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm6653 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIntegerTerm6663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_ruleAIntegerTerm6708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_entryRuleAInt6744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAInt6755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAInt6794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_entryRuleARealTerm6838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARealTerm6848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_ruleARealTerm6893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_entryRuleAReal6929 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAReal6940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleAReal6979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral7023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleABooleanLiteral7033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleABooleanLiteral7086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleABooleanLiteral7117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm7154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm7164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm7209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString7245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString7256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString7295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression7339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAParenthesizedExpression7349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAParenthesizedExpression7386 = new BitSet(new long[]{0xC6000100201000F0L,0x0000000000000310L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression7408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAParenthesizedExpression7419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE7460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE7471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7511 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleAADLPROPERTYREFERENCE7530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID7593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID7604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID7643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7739 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleQualifiedName7758 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7773 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleThisKeyword_in_entryRuleThisKeyword7821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThisKeyword7832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleThisKeyword7869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleResultIssueType7922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleResultIssueType7939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleResultIssueType7956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleResultIssueType7973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleResultIssueType7990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleResultIssueType8007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred1_InternalResults2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalResults3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalResults3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalResults4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred5_InternalResults4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred6_InternalResults4646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred7_InternalResults4922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred9_InternalResults6206 = new BitSet(new long[]{0x0000000000000002L});

}
