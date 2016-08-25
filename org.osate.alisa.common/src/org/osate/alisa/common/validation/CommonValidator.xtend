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

/*
 * generated by Xtext
 */
package org.osate.alisa.common.validation

import org.eclipse.xtext.validation.Check
import org.osate.alisa.common.common.AFunctionCall
import org.osate.alisa.common.common.CommonPackage
import org.osate.alisa.common.typing.validation.CommonTypeSystemValidator

//import org.eclipse.xtext.validation.Check
/**
 * Custom validation rules. 
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class CommonValidator extends CommonTypeSystemValidator {
	public static val UNSUPPORTED_FUNCTION = 'UnSupportedFunction'

	public static val SupportedFunctions = #['max', 'min', 'abs', 'floor', 'ceil', 'round','atTime','prev']

	@Check
	def checkAFeatureCall(AFunctionCall call) {
		if (!SupportedFunctions.contains(call.function)) {
			warning('Unsupported function ' + call.function, CommonPackage.Literals.AFUNCTION_CALL__FUNCTION,
				UNSUPPORTED_FUNCTION)
		}
	}
}
