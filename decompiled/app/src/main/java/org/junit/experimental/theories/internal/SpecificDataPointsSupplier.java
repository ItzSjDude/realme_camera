package org.junit.experimental.theories.internal;

/* loaded from: classes2.dex */
public class SpecificDataPointsSupplier extends org.junit.experimental.theories.internal.AllMembersSupplier {
    public SpecificDataPointsSupplier(org.junit.runners.model.TestClass testClass) {
        super(testClass);
    }

    @Override // org.junit.experimental.theories.internal.AllMembersSupplier
    protected java.util.Collection<java.lang.reflect.Field> getSingleDataPointFields(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.util.Collection<java.lang.reflect.Field> singleDataPointFields = super.getSingleDataPointFields(parameterSignature);
        java.lang.String strValue = ((org.junit.experimental.theories.FromDataPoints) parameterSignature.getAnnotation(org.junit.experimental.theories.FromDataPoints.class)).value();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.reflect.Field field : singleDataPointFields) {
            if (java.util.Arrays.asList(((org.junit.experimental.theories.DataPoint) field.getAnnotation(org.junit.experimental.theories.DataPoint.class)).value()).contains(strValue)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.AllMembersSupplier
    protected java.util.Collection<java.lang.reflect.Field> getDataPointsFields(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.util.Collection<java.lang.reflect.Field> dataPointsFields = super.getDataPointsFields(parameterSignature);
        java.lang.String strValue = ((org.junit.experimental.theories.FromDataPoints) parameterSignature.getAnnotation(org.junit.experimental.theories.FromDataPoints.class)).value();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.reflect.Field field : dataPointsFields) {
            if (java.util.Arrays.asList(((org.junit.experimental.theories.DataPoints) field.getAnnotation(org.junit.experimental.theories.DataPoints.class)).value()).contains(strValue)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.AllMembersSupplier
    protected java.util.Collection<org.junit.runners.model.FrameworkMethod> getSingleDataPointMethods(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.util.Collection<org.junit.runners.model.FrameworkMethod> singleDataPointMethods = super.getSingleDataPointMethods(parameterSignature);
        java.lang.String strValue = ((org.junit.experimental.theories.FromDataPoints) parameterSignature.getAnnotation(org.junit.experimental.theories.FromDataPoints.class)).value();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.junit.runners.model.FrameworkMethod frameworkMethod : singleDataPointMethods) {
            if (java.util.Arrays.asList(((org.junit.experimental.theories.DataPoint) frameworkMethod.getAnnotation(org.junit.experimental.theories.DataPoint.class)).value()).contains(strValue)) {
                arrayList.add(frameworkMethod);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.AllMembersSupplier
    protected java.util.Collection<org.junit.runners.model.FrameworkMethod> getDataPointsMethods(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.util.Collection<org.junit.runners.model.FrameworkMethod> dataPointsMethods = super.getDataPointsMethods(parameterSignature);
        java.lang.String strValue = ((org.junit.experimental.theories.FromDataPoints) parameterSignature.getAnnotation(org.junit.experimental.theories.FromDataPoints.class)).value();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.junit.runners.model.FrameworkMethod frameworkMethod : dataPointsMethods) {
            if (java.util.Arrays.asList(((org.junit.experimental.theories.DataPoints) frameworkMethod.getAnnotation(org.junit.experimental.theories.DataPoints.class)).value()).contains(strValue)) {
                arrayList.add(frameworkMethod);
            }
        }
        return arrayList;
    }
}
