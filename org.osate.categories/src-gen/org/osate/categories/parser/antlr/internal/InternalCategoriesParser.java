package org.osate.categories.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.categories.services.CategoriesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
public class InternalCategoriesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Filter", "Any", "FullStop", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int FullStop=6;
    public static final int RULE_ID=9;
    public static final int RULE_WS=14;
    public static final int RULE_STRING=11;
    public static final int RULE_ANY_OTHER=15;
    public static final int Any=5;
    public static final int RULE_SL_COMMENT=13;
    public static final int Filter=4;
    public static final int RULE_INT=10;
    public static final int RULE_ML_COMMENT=12;
    public static final int LeftSquareBracket=7;
    public static final int EOF=-1;
    public static final int RightSquareBracket=8;

    // delegates
    // delegators


        public InternalCategoriesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCategoriesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCategoriesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCategoriesParser.g"; }




    	private CategoriesGrammarAccess grammarAccess;
    	 	
    	public InternalCategoriesParser(TokenStream input, CategoriesGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "CategoriesDefinitions";	
    	} 
    	   	   	
    	@Override
    	protected CategoriesGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleCategoriesDefinitions"
    // InternalCategoriesParser.g:73:1: entryRuleCategoriesDefinitions returns [EObject current=null] : iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF ;
    public final EObject entryRuleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoriesDefinitions = null;


        try {
            // InternalCategoriesParser.g:74:2: (iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF )
            // InternalCategoriesParser.g:75:2: iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF
            {
             newCompositeNode(grammarAccess.getCategoriesDefinitionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategoriesDefinitions=ruleCategoriesDefinitions();

            state._fsp--;

             current =iv_ruleCategoriesDefinitions; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCategoriesDefinitions"


    // $ANTLR start "ruleCategoriesDefinitions"
    // InternalCategoriesParser.g:82:1: ruleCategoriesDefinitions returns [EObject current=null] : ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* ) ;
    public final EObject ruleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject lv_categories_0_0 = null;

        EObject lv_categoryFilters_1_0 = null;


         enterRule(); 
            
        try {
            // InternalCategoriesParser.g:85:28: ( ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* ) )
            // InternalCategoriesParser.g:86:1: ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* )
            {
            // InternalCategoriesParser.g:86:1: ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* )
            // InternalCategoriesParser.g:86:2: ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )*
            {
            // InternalCategoriesParser.g:86:2: ( (lv_categories_0_0= ruleCategories ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCategoriesParser.g:87:1: (lv_categories_0_0= ruleCategories )
            	    {
            	    // InternalCategoriesParser.g:87:1: (lv_categories_0_0= ruleCategories )
            	    // InternalCategoriesParser.g:88:3: lv_categories_0_0= ruleCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_categories_0_0=ruleCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"categories",
            	            		lv_categories_0_0, 
            	            		"org.osate.categories.Categories.Categories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalCategoriesParser.g:104:3: ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Filter) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCategoriesParser.g:105:1: (lv_categoryFilters_1_0= ruleCategoryFilter )
            	    {
            	    // InternalCategoriesParser.g:105:1: (lv_categoryFilters_1_0= ruleCategoryFilter )
            	    // InternalCategoriesParser.g:106:3: lv_categoryFilters_1_0= ruleCategoryFilter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersCategoryFilterParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_4);
            	    lv_categoryFilters_1_0=ruleCategoryFilter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"categoryFilters",
            	            		lv_categoryFilters_1_0, 
            	            		"org.osate.categories.Categories.CategoryFilter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategoriesDefinitions"


    // $ANTLR start "entryRuleCategories"
    // InternalCategoriesParser.g:130:1: entryRuleCategories returns [EObject current=null] : iv_ruleCategories= ruleCategories EOF ;
    public final EObject entryRuleCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategories = null;


        try {
            // InternalCategoriesParser.g:131:2: (iv_ruleCategories= ruleCategories EOF )
            // InternalCategoriesParser.g:132:2: iv_ruleCategories= ruleCategories EOF
            {
             newCompositeNode(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategories=ruleCategories();

            state._fsp--;

             current =iv_ruleCategories; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCategories"


    // $ANTLR start "ruleCategories"
    // InternalCategoriesParser.g:139:1: ruleCategories returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_category_2_0 = null;


         enterRule(); 
            
        try {
            // InternalCategoriesParser.g:142:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket ) )
            // InternalCategoriesParser.g:143:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket )
            {
            // InternalCategoriesParser.g:143:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket )
            // InternalCategoriesParser.g:143:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket
            {
            // InternalCategoriesParser.g:143:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalCategoriesParser.g:144:1: (lv_name_0_0= RULE_ID )
            {
            // InternalCategoriesParser.g:144:1: (lv_name_0_0= RULE_ID )
            // InternalCategoriesParser.g:145:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCategoriesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1());
                
            // InternalCategoriesParser.g:166:1: ( (lv_category_2_0= ruleCategory ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCategoriesParser.g:167:1: (lv_category_2_0= ruleCategory )
            	    {
            	    // InternalCategoriesParser.g:167:1: (lv_category_2_0= ruleCategory )
            	    // InternalCategoriesParser.g:168:3: lv_category_2_0= ruleCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_category_2_0=ruleCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_2_0, 
            	            		"org.osate.categories.Categories.Category");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategories"


    // $ANTLR start "entryRuleCategory"
    // InternalCategoriesParser.g:197:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // InternalCategoriesParser.g:198:2: (iv_ruleCategory= ruleCategory EOF )
            // InternalCategoriesParser.g:199:2: iv_ruleCategory= ruleCategory EOF
            {
             newCompositeNode(grammarAccess.getCategoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategory=ruleCategory();

            state._fsp--;

             current =iv_ruleCategory; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCategory"


    // $ANTLR start "ruleCategory"
    // InternalCategoriesParser.g:206:1: ruleCategory returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalCategoriesParser.g:209:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalCategoriesParser.g:210:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalCategoriesParser.g:210:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalCategoriesParser.g:211:1: (lv_name_0_0= RULE_ID )
            {
            // InternalCategoriesParser.g:211:1: (lv_name_0_0= RULE_ID )
            // InternalCategoriesParser.g:212:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategory"


    // $ANTLR start "entryRuleCategoryFilter"
    // InternalCategoriesParser.g:236:1: entryRuleCategoryFilter returns [EObject current=null] : iv_ruleCategoryFilter= ruleCategoryFilter EOF ;
    public final EObject entryRuleCategoryFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoryFilter = null;


        try {
            // InternalCategoriesParser.g:237:2: (iv_ruleCategoryFilter= ruleCategoryFilter EOF )
            // InternalCategoriesParser.g:238:2: iv_ruleCategoryFilter= ruleCategoryFilter EOF
            {
             newCompositeNode(grammarAccess.getCategoryFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategoryFilter=ruleCategoryFilter();

            state._fsp--;

             current =iv_ruleCategoryFilter; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCategoryFilter"


    // $ANTLR start "ruleCategoryFilter"
    // InternalCategoriesParser.g:245:1: ruleCategoryFilter returns [EObject current=null] : (otherlv_0= Filter ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= Any ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleCategoryFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_anyCategory_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalCategoriesParser.g:248:28: ( (otherlv_0= Filter ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= Any ) )? otherlv_5= RightSquareBracket ) )
            // InternalCategoriesParser.g:249:1: (otherlv_0= Filter ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= Any ) )? otherlv_5= RightSquareBracket )
            {
            // InternalCategoriesParser.g:249:1: (otherlv_0= Filter ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= Any ) )? otherlv_5= RightSquareBracket )
            // InternalCategoriesParser.g:250:2: otherlv_0= Filter ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= Any ) )? otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Filter,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getCategoryFilterAccess().getFilterKeyword_0());
                
            // InternalCategoriesParser.g:254:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalCategoriesParser.g:255:1: (lv_name_1_0= RULE_ID )
            {
            // InternalCategoriesParser.g:255:1: (lv_name_1_0= RULE_ID )
            // InternalCategoriesParser.g:256:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCategoryFilterAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCategoryFilterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_8); 

                	newLeafNode(otherlv_2, grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2());
                
            // InternalCategoriesParser.g:277:1: ( ( ruleCatRef ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCategoriesParser.g:278:1: ( ruleCatRef )
            	    {
            	    // InternalCategoriesParser.g:278:1: ( ruleCatRef )
            	    // InternalCategoriesParser.g:279:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCategoryFilterRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalCategoriesParser.g:293:3: ( (lv_anyCategory_4_0= Any ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Any) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalCategoriesParser.g:294:1: (lv_anyCategory_4_0= Any )
                    {
                    // InternalCategoriesParser.g:294:1: (lv_anyCategory_4_0= Any )
                    // InternalCategoriesParser.g:295:3: lv_anyCategory_4_0= Any
                    {
                    lv_anyCategory_4_0=(Token)match(input,Any,FOLLOW_9); 

                            newLeafNode(lv_anyCategory_4_0, grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCategoryFilterRule());
                    	        }
                           		setWithLastConsumed(current, "anyCategory", true, "any");
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategoryFilter"


    // $ANTLR start "entryRuleCatRef"
    // InternalCategoriesParser.g:322:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // InternalCategoriesParser.g:323:1: (iv_ruleCatRef= ruleCatRef EOF )
            // InternalCategoriesParser.g:324:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCatRef"


    // $ANTLR start "ruleCatRef"
    // InternalCategoriesParser.g:331:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalCategoriesParser.g:335:6: ( (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID ) )
            // InternalCategoriesParser.g:336:1: (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID )
            {
            // InternalCategoriesParser.g:336:1: (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID )
            // InternalCategoriesParser.g:336:6: this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_6); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); 
                

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCatRef"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000212L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});

}