/*
 * generated by Xtext
 */
package org.osate.alisa.workbench.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractAlisaValidator extends org.osate.alisa.common.validation.CommonValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>(super.getEPackages());
	    result.add(org.osate.alisa.workbench.alisa.AlisaPackage.eINSTANCE);
		return result;
	}
}
