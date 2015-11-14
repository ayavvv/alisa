/*
 * generated by Xtext
 */
package org.osate.reqspec.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider;
import org.osate.reqspec.ui.outline.ReqSpecEObjectHoverProvider;
import org.osate.reqspec.ui.outline.ReqSpecOutlineNodeLabelProvider;
import org.osate.reqspec.ui.outline.ReqSpecOutlinePage;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ReqSpecUiModule extends org.osate.reqspec.ui.AbstractReqSpecUiModule {

	public ReqSpecUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

////	@Override TODO
//	public Class<? extends org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper> bindIHyperlinkHelper() {
//		return org.osate.alisa.common.ui.util.AlisaHyperLinkHelper.class;
//	}

	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return ReqSpecOutlinePage.class;
	}

	public Class<? extends OutlineNodeLabelProvider> bindOutlineNodeLabelProvider() {
		return ReqSpecOutlineNodeLabelProvider.class;
	}

	public Class<? extends org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return org.osate.reqspec.ui.linking.ReqSpecLinkingDiagnosticMessageProvider.class;
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return ReqSpecEObjectHoverProvider.class;
	}

}
