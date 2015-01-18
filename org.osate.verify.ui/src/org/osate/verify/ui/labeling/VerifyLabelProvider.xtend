/*
* generated by Xtext
*/
package org.osate.verify.ui.labeling

import com.google.inject.Inject
import org.osate.verify.verify.FailThenExpr
import org.osate.verify.verify.AndThenExpr
import org.osate.verify.verify.AllExpr

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class VerifyLabelProvider extends org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider {

	@Inject
	new(org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:
	
	
	def text(FailThenExpr ele) {
		'failthen'
	}
	def text(AndThenExpr ele) {
		'andthen'
	}
	def text(AllExpr ele) {
		'all'
	}
//
//	def image(Greeting ele) {
//		'Greeting.gif'
//	}
}
