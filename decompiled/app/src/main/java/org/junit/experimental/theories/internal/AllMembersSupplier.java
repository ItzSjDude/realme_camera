package org.junit.experimental.theories.internal;

/* loaded from: classes2.dex */
public class AllMembersSupplier extends org.junit.experimental.theories.ParameterSupplier {
    private final org.junit.runners.model.TestClass clazz;

    static class MethodParameterValue extends org.junit.experimental.theories.PotentialAssignment {
        private final org.junit.runners.model.FrameworkMethod method;

        private MethodParameterValue(org.junit.runners.model.FrameworkMethod frameworkMethod) {
            this.method = frameworkMethod;
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public java.lang.Object getValue() throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException {
            try {
                return this.method.invokeExplosively(null, new java.lang.Object[0]);
            } catch (java.lang.IllegalAccessException unused) {
                throw new java.lang.RuntimeException("unexpected: getMethods returned an_renamed inaccessible method");
            } catch (java.lang.IllegalArgumentException unused2) {
                throw new java.lang.RuntimeException("unexpected: argument length is_renamed checked");
            } catch (java.lang.Throwable th) {
                org.junit.experimental.theories.DataPoint dataPoint = (org.junit.experimental.theories.DataPoint) this.method.getAnnotation(org.junit.experimental.theories.DataPoint.class);
                org.junit.Assume.assumeTrue(dataPoint == null || !org.junit.experimental.theories.internal.AllMembersSupplier.isAssignableToAnyOf(dataPoint.ignoredExceptions(), th));
                throw new org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException(th);
            }
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public java.lang.String getDescription() throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException {
            return this.method.getName();
        }
    }

    public AllMembersSupplier(org.junit.runners.model.TestClass testClass) {
        this.clazz = testClass;
    }

    @Override // org.junit.experimental.theories.ParameterSupplier
    public java.util.List<org.junit.experimental.theories.PotentialAssignment> getValueSources(org.junit.experimental.theories.ParameterSignature parameterSignature) throws java.lang.Throwable {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        addSinglePointFields(parameterSignature, arrayList);
        addMultiPointFields(parameterSignature, arrayList);
        addSinglePointMethods(parameterSignature, arrayList);
        addMultiPointMethods(parameterSignature, arrayList);
        return arrayList;
    }

    private void addMultiPointMethods(org.junit.experimental.theories.ParameterSignature parameterSignature, java.util.List<org.junit.experimental.theories.PotentialAssignment> list) throws java.lang.Throwable {
        for (org.junit.runners.model.FrameworkMethod frameworkMethod : getDataPointsMethods(parameterSignature)) {
            java.lang.Class<?> returnType = frameworkMethod.getReturnType();
            if ((returnType.isArray() && parameterSignature.canPotentiallyAcceptType(returnType.getComponentType())) || java.lang.Iterable.class.isAssignableFrom(returnType)) {
                try {
                    addDataPointsValues(returnType, parameterSignature, frameworkMethod.getName(), list, frameworkMethod.invokeExplosively(null, new java.lang.Object[0]));
                } catch (java.lang.Throwable th) {
                    org.junit.experimental.theories.DataPoints dataPoints = (org.junit.experimental.theories.DataPoints) frameworkMethod.getAnnotation(org.junit.experimental.theories.DataPoints.class);
                    if (dataPoints == null || !isAssignableToAnyOf(dataPoints.ignoredExceptions(), th)) {
                        throw th;
                    }
                    return;
                }
            }
        }
    }

    private void addSinglePointMethods(org.junit.experimental.theories.ParameterSignature parameterSignature, java.util.List<org.junit.experimental.theories.PotentialAssignment> list) {
        for (org.junit.runners.model.FrameworkMethod frameworkMethod : getSingleDataPointMethods(parameterSignature)) {
            if (parameterSignature.canAcceptType(frameworkMethod.getType())) {
                list.add(new org.junit.experimental.theories.internal.AllMembersSupplier.MethodParameterValue(frameworkMethod));
            }
        }
    }

    private void addMultiPointFields(org.junit.experimental.theories.ParameterSignature parameterSignature, java.util.List<org.junit.experimental.theories.PotentialAssignment> list) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        for (java.lang.reflect.Field field : getDataPointsFields(parameterSignature)) {
            addDataPointsValues(field.getType(), parameterSignature, field.getName(), list, getStaticFieldValue(field));
        }
    }

    private void addSinglePointFields(org.junit.experimental.theories.ParameterSignature parameterSignature, java.util.List<org.junit.experimental.theories.PotentialAssignment> list) {
        for (java.lang.reflect.Field field : getSingleDataPointFields(parameterSignature)) {
            java.lang.Object staticFieldValue = getStaticFieldValue(field);
            if (parameterSignature.canAcceptValue(staticFieldValue)) {
                list.add(org.junit.experimental.theories.PotentialAssignment.forValue(field.getName(), staticFieldValue));
            }
        }
    }

    private void addDataPointsValues(java.lang.Class<?> cls, org.junit.experimental.theories.ParameterSignature parameterSignature, java.lang.String str, java.util.List<org.junit.experimental.theories.PotentialAssignment> list, java.lang.Object obj) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if (cls.isArray()) {
            addArrayValues(parameterSignature, str, list, obj);
        } else if (java.lang.Iterable.class.isAssignableFrom(cls)) {
            addIterableValues(parameterSignature, str, list, (java.lang.Iterable) obj);
        }
    }

    private void addArrayValues(org.junit.experimental.theories.ParameterSignature parameterSignature, java.lang.String str, java.util.List<org.junit.experimental.theories.PotentialAssignment> list, java.lang.Object obj) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        for (int i_renamed = 0; i_renamed < java.lang.reflect.Array.getLength(obj); i_renamed++) {
            java.lang.Object obj2 = java.lang.reflect.Array.get(obj, i_renamed);
            if (parameterSignature.canAcceptValue(obj2)) {
                list.add(org.junit.experimental.theories.PotentialAssignment.forValue(str + "[" + i_renamed + "]", obj2));
            }
        }
    }

    private void addIterableValues(org.junit.experimental.theories.ParameterSignature parameterSignature, java.lang.String str, java.util.List<org.junit.experimental.theories.PotentialAssignment> list, java.lang.Iterable<?> iterable) {
        int i_renamed = 0;
        for (java.lang.Object obj : iterable) {
            if (parameterSignature.canAcceptValue(obj)) {
                list.add(org.junit.experimental.theories.PotentialAssignment.forValue(str + "[" + i_renamed + "]", obj));
            }
            i_renamed++;
        }
    }

    private java.lang.Object getStaticFieldValue(java.lang.reflect.Field field) {
        try {
            return field.get(null);
        } catch (java.lang.IllegalAccessException unused) {
            throw new java.lang.RuntimeException("unexpected: getFields returned an_renamed inaccessible field");
        } catch (java.lang.IllegalArgumentException unused2) {
            throw new java.lang.RuntimeException("unexpected: field from getClass doesn't_renamed exist on_renamed object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAssignableToAnyOf(java.lang.Class<?>[] clsArr, java.lang.Object obj) {
        for (java.lang.Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    protected java.util.Collection<org.junit.runners.model.FrameworkMethod> getDataPointsMethods(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(org.junit.experimental.theories.DataPoints.class);
    }

    protected java.util.Collection<java.lang.reflect.Field> getSingleDataPointFields(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.util.List<org.junit.runners.model.FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(org.junit.experimental.theories.DataPoint.class);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<org.junit.runners.model.FrameworkField> it = annotatedFields.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getField());
        }
        return arrayList;
    }

    protected java.util.Collection<java.lang.reflect.Field> getDataPointsFields(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.util.List<org.junit.runners.model.FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(org.junit.experimental.theories.DataPoints.class);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<org.junit.runners.model.FrameworkField> it = annotatedFields.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getField());
        }
        return arrayList;
    }

    protected java.util.Collection<org.junit.runners.model.FrameworkMethod> getSingleDataPointMethods(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(org.junit.experimental.theories.DataPoint.class);
    }
}
