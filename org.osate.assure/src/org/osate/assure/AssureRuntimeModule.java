/*
 * generated by Xtext
 */
package org.osate.assure;

import org.osate.assure.linking.AssureLinkingService;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class AssureRuntimeModule extends org.osate.assure.AbstractAssureRuntimeModule {
	@Override
	public Class<? extends org.eclipse.xtext.linking.ILinkingService> bindILinkingService() {
		return AssureLinkingService.class;
	}

}
