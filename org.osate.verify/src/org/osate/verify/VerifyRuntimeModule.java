/*
 * generated by Xtext
 */
package org.osate.verify;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class VerifyRuntimeModule extends org.osate.verify.AbstractVerifyRuntimeModule {

	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return org.osate.alisa.common.naming.CommonQualifiedNameConverter.class;
	}

}
