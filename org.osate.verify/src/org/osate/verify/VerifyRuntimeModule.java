<<<<<<< HEAD
/*
 * generated by Xtext
 */
package org.osate.verify;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class VerifyRuntimeModule extends org.osate.verify.AbstractVerifyRuntimeModule {

//	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return org.osate.alisa.common.naming.CommonQualifiedNameConverter.class;
	}

//	@Override
//	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
//		return org.osate.verify.naming.VerifyQualifiedNameProvider.class;
//	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return org.osate.alisa.common.services.CommonValueConverters.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return org.osate.verify.scoping.VerifyScopeProvider.class;
	}

}
=======
/*
 * generated by Xtext
 */
package org.osate.verify;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class VerifyRuntimeModule extends org.osate.verify.AbstractVerifyRuntimeModule {

//	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return org.osate.alisa.common.naming.CommonQualifiedNameConverter.class;
	}

//	@Override
//	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
//		return org.osate.verify.naming.VerifyQualifiedNameProvider.class;
//	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return org.osate.alisa.common.services.CommonValueConverters.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return org.osate.verify.scoping.VerifyScopeProvider.class;
	}

}
>>>>>>> refs/remotes/origin/PeterWork
