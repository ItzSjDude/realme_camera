package org.junit.experimental.theories.internal;

/* loaded from: classes2.dex */
public class Assignments {
    private final java.util.List<org.junit.experimental.theories.PotentialAssignment> assigned;
    private final org.junit.runners.model.TestClass clazz;
    private final java.util.List<org.junit.experimental.theories.ParameterSignature> unassigned;

    private Assignments(java.util.List<org.junit.experimental.theories.PotentialAssignment> list, java.util.List<org.junit.experimental.theories.ParameterSignature> list2, org.junit.runners.model.TestClass testClass) {
        this.unassigned = list2;
        this.assigned = list;
        this.clazz = testClass;
    }

    public static org.junit.experimental.theories.internal.Assignments allUnassigned(java.lang.reflect.Method method, org.junit.runners.model.TestClass testClass) {
        java.util.List<org.junit.experimental.theories.ParameterSignature> listSignatures = org.junit.experimental.theories.ParameterSignature.signatures(testClass.getOnlyConstructor());
        listSignatures.addAll(org.junit.experimental.theories.ParameterSignature.signatures(method));
        return new org.junit.experimental.theories.internal.Assignments(new java.util.ArrayList(), listSignatures, testClass);
    }

    public boolean isComplete() {
        return this.unassigned.size() == 0;
    }

    public org.junit.experimental.theories.ParameterSignature nextUnassigned() {
        return this.unassigned.get(0);
    }

    public org.junit.experimental.theories.internal.Assignments assignNext(org.junit.experimental.theories.PotentialAssignment potentialAssignment) {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.assigned);
        arrayList.add(potentialAssignment);
        java.util.List<org.junit.experimental.theories.ParameterSignature> list = this.unassigned;
        return new org.junit.experimental.theories.internal.Assignments(arrayList, list.subList(1, list.size()), this.clazz);
    }

    public java.lang.Object[] getActualValues(int i_renamed, int i2) throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException {
        java.lang.Object[] objArr = new java.lang.Object[i2 - i_renamed];
        for (int i3 = i_renamed; i3 < i2; i3++) {
            objArr[i3 - i_renamed] = this.assigned.get(i3).getValue();
        }
        return objArr;
    }

    public java.util.List<org.junit.experimental.theories.PotentialAssignment> potentialsForNextUnassigned() throws java.lang.Throwable {
        org.junit.experimental.theories.ParameterSignature parameterSignatureNextUnassigned = nextUnassigned();
        java.util.List<org.junit.experimental.theories.PotentialAssignment> valueSources = getSupplier(parameterSignatureNextUnassigned).getValueSources(parameterSignatureNextUnassigned);
        return valueSources.size() == 0 ? generateAssignmentsFromTypeAlone(parameterSignatureNextUnassigned) : valueSources;
    }

    private java.util.List<org.junit.experimental.theories.PotentialAssignment> generateAssignmentsFromTypeAlone(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.lang.Class<?> type = parameterSignature.getType();
        if (type.isEnum()) {
            return new org.junit.experimental.theories.internal.EnumSupplier(type).getValueSources(parameterSignature);
        }
        if (type.equals(java.lang.Boolean.class) || type.equals(java.lang.Boolean.TYPE)) {
            return new org.junit.experimental.theories.internal.BooleanSupplier().getValueSources(parameterSignature);
        }
        return java.util.Collections.emptyList();
    }

    private org.junit.experimental.theories.ParameterSupplier getSupplier(org.junit.experimental.theories.ParameterSignature parameterSignature) throws java.lang.Exception {
        org.junit.experimental.theories.ParametersSuppliedBy parametersSuppliedBy = (org.junit.experimental.theories.ParametersSuppliedBy) parameterSignature.findDeepAnnotation(org.junit.experimental.theories.ParametersSuppliedBy.class);
        if (parametersSuppliedBy != null) {
            return buildParameterSupplierFromClass(parametersSuppliedBy.value());
        }
        return new org.junit.experimental.theories.internal.AllMembersSupplier(this.clazz);
    }

    private org.junit.experimental.theories.ParameterSupplier buildParameterSupplierFromClass(java.lang.Class<? extends org.junit.experimental.theories.ParameterSupplier> cls) throws java.lang.Exception {
        for (java.lang.reflect.Constructor<?> constructor : cls.getConstructors()) {
            java.lang.Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(org.junit.runners.model.TestClass.class)) {
                return (org.junit.experimental.theories.ParameterSupplier) constructor.newInstance(this.clazz);
            }
        }
        return cls.newInstance();
    }

    public java.lang.Object[] getConstructorArguments() throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(0, getConstructorParameterCount());
    }

    public java.lang.Object[] getMethodArguments() throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(getConstructorParameterCount(), this.assigned.size());
    }

    public java.lang.Object[] getAllArguments() throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(0, this.assigned.size());
    }

    private int getConstructorParameterCount() {
        return org.junit.experimental.theories.ParameterSignature.signatures(this.clazz.getOnlyConstructor()).size();
    }

    public java.lang.Object[] getArgumentStrings(boolean z_renamed) throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException {
        java.lang.Object[] objArr = new java.lang.Object[this.assigned.size()];
        for (int i_renamed = 0; i_renamed < objArr.length; i_renamed++) {
            objArr[i_renamed] = this.assigned.get(i_renamed).getDescription();
        }
        return objArr;
    }
}
