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
package org.osate.alisa.common.common.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Type;

import org.osate.alisa.common.common.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.alisa.common.common.CommonPackage
 * @generated
 */
public class CommonSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CommonPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommonSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = CommonPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case CommonPackage.DESCRIPTION:
      {
        Description description = (Description)theEObject;
        T result = caseDescription(description);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.DESCRIPTION_ELEMENT:
      {
        DescriptionElement descriptionElement = (DescriptionElement)theEObject;
        T result = caseDescriptionElement(descriptionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.RATIONALE:
      {
        Rationale rationale = (Rationale)theEObject;
        T result = caseRationale(rationale);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.UNCERTAINTY:
      {
        Uncertainty uncertainty = (Uncertainty)theEObject;
        T result = caseUncertainty(uncertainty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.RESULT_ISSUE:
      {
        ResultIssue resultIssue = (ResultIssue)theEObject;
        T result = caseResultIssue(resultIssue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.AVARIABLE_DECLARATION:
      {
        AVariableDeclaration aVariableDeclaration = (AVariableDeclaration)theEObject;
        T result = caseAVariableDeclaration(aVariableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.AEXPRESSION:
      {
        AExpression aExpression = (AExpression)theEObject;
        T result = caseAExpression(aExpression);
        if (result == null) result = casePropertyExpression(aExpression);
        if (result == null) result = caseElement(aExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.NESTED_MODEL_ELEMENT:
      {
        NestedModelElement nestedModelElement = (NestedModelElement)theEObject;
        T result = caseNestedModelElement(nestedModelElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.AMODEL_REFERENCE:
      {
        AModelReference aModelReference = (AModelReference)theEObject;
        T result = caseAModelReference(aModelReference);
        if (result == null) result = caseAExpression(aModelReference);
        if (result == null) result = casePropertyExpression(aModelReference);
        if (result == null) result = caseElement(aModelReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.APROPERTY_REFERENCE:
      {
        APropertyReference aPropertyReference = (APropertyReference)theEObject;
        T result = caseAPropertyReference(aPropertyReference);
        if (result == null) result = caseAExpression(aPropertyReference);
        if (result == null) result = casePropertyExpression(aPropertyReference);
        if (result == null) result = caseElement(aPropertyReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.SHOW_VALUE:
      {
        ShowValue showValue = (ShowValue)theEObject;
        T result = caseShowValue(showValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.IMAGE_REFERENCE:
      {
        ImageReference imageReference = (ImageReference)theEObject;
        T result = caseImageReference(imageReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.MODEL_REF:
      {
        ModelRef modelRef = (ModelRef)theEObject;
        T result = caseModelRef(modelRef);
        if (result == null) result = casePropertyType(modelRef);
        if (result == null) result = caseType(modelRef);
        if (result == null) result = caseNamedElement(modelRef);
        if (result == null) result = caseElement(modelRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.TYPE_REF:
      {
        TypeRef typeRef = (TypeRef)theEObject;
        T result = caseTypeRef(typeRef);
        if (result == null) result = casePropertyType(typeRef);
        if (result == null) result = caseType(typeRef);
        if (result == null) result = caseNamedElement(typeRef);
        if (result == null) result = caseElement(typeRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.PROPERTY_REF:
      {
        PropertyRef propertyRef = (PropertyRef)theEObject;
        T result = casePropertyRef(propertyRef);
        if (result == null) result = casePropertyType(propertyRef);
        if (result == null) result = caseType(propertyRef);
        if (result == null) result = caseNamedElement(propertyRef);
        if (result == null) result = caseElement(propertyRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.VAL_DECLARATION:
      {
        ValDeclaration valDeclaration = (ValDeclaration)theEObject;
        T result = caseValDeclaration(valDeclaration);
        if (result == null) result = caseAVariableDeclaration(valDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.COMPUTE_DECLARATION:
      {
        ComputeDeclaration computeDeclaration = (ComputeDeclaration)theEObject;
        T result = caseComputeDeclaration(computeDeclaration);
        if (result == null) result = caseAVariableDeclaration(computeDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.AVARIABLE_REFERENCE:
      {
        AVariableReference aVariableReference = (AVariableReference)theEObject;
        T result = caseAVariableReference(aVariableReference);
        if (result == null) result = caseAExpression(aVariableReference);
        if (result == null) result = casePropertyExpression(aVariableReference);
        if (result == null) result = caseElement(aVariableReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.ABINARY_OPERATION:
      {
        ABinaryOperation aBinaryOperation = (ABinaryOperation)theEObject;
        T result = caseABinaryOperation(aBinaryOperation);
        if (result == null) result = casePropertyExpression(aBinaryOperation);
        if (result == null) result = caseElement(aBinaryOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.AUNARY_OPERATION:
      {
        AUnaryOperation aUnaryOperation = (AUnaryOperation)theEObject;
        T result = caseAUnaryOperation(aUnaryOperation);
        if (result == null) result = casePropertyExpression(aUnaryOperation);
        if (result == null) result = caseElement(aUnaryOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.AFUNCTION_CALL:
      {
        AFunctionCall aFunctionCall = (AFunctionCall)theEObject;
        T result = caseAFunctionCall(aFunctionCall);
        if (result == null) result = casePropertyExpression(aFunctionCall);
        if (result == null) result = caseElement(aFunctionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.ASET_LITERAL:
      {
        ASetLiteral aSetLiteral = (ASetLiteral)theEObject;
        T result = caseASetLiteral(aSetLiteral);
        if (result == null) result = casePropertyExpression(aSetLiteral);
        if (result == null) result = caseElement(aSetLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.ALIST_TERM:
      {
        AListTerm aListTerm = (AListTerm)theEObject;
        T result = caseAListTerm(aListTerm);
        if (result == null) result = casePropertyExpression(aListTerm);
        if (result == null) result = caseElement(aListTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonPackage.ANULL_LITERAL:
      {
        ANullLiteral aNullLiteral = (ANullLiteral)theEObject;
        T result = caseANullLiteral(aNullLiteral);
        if (result == null) result = casePropertyExpression(aNullLiteral);
        if (result == null) result = caseElement(aNullLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Description</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDescription(Description object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Description Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Description Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDescriptionElement(DescriptionElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rationale</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rationale</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRationale(Rationale object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Uncertainty</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Uncertainty</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUncertainty(Uncertainty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Issue</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Issue</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultIssue(ResultIssue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AVariable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AVariable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAVariableDeclaration(AVariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AExpression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AExpression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAExpression(AExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Model Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Model Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedModelElement(NestedModelElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AModel Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AModel Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAModelReference(AModelReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AProperty Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AProperty Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAPropertyReference(APropertyReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Show Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Show Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShowValue(ShowValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Image Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Image Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImageReference(ImageReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelRef(ModelRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeRef(TypeRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyRef(PropertyRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Val Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Val Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValDeclaration(ValDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compute Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compute Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComputeDeclaration(ComputeDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AVariable Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AVariable Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAVariableReference(AVariableReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ABinary Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ABinary Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseABinaryOperation(ABinaryOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AUnary Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AUnary Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAUnaryOperation(AUnaryOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AFunction Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AFunction Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAFunctionCall(AFunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASet Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASet Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASetLiteral(ASetLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AList Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AList Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAListTerm(AListTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ANull Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ANull Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseANullLiteral(ANullLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyExpression(PropertyExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyType(PropertyType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //CommonSwitch
