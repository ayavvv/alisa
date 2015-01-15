package org.osate.assure.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.instance.InstancePackage;

public class AssureLinkingService extends DefaultLinkingService {

	public AssureLinkingService() {
		super();
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();
		final String name = getCrossRefNodeAsString(node);
		if (InstancePackage.eINSTANCE.getInstanceObject() == requiredType) {
			ResourceSet resset = context.eResource().getResourceSet();
			if (name.length() > 2) {
				String uriname = name.substring(1, name.length() - 1);
				try {
					URI rooturi = URI.createURI(uriname);
					EObject searchResult = resset.getEObject(rooturi, true);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					return Collections.<EObject> emptyList();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return super.getLinkedObjects(context, reference, node);
	}
}