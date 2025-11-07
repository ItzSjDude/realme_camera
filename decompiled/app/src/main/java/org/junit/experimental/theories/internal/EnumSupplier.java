package org.junit.experimental.theories.internal;

/* loaded from: classes2.dex */
public class EnumSupplier extends org.junit.experimental.theories.ParameterSupplier {
    private java.lang.Class<?> enumType;

    public EnumSupplier(java.lang.Class<?> cls) {
        this.enumType = cls;
    }

    @Override // org.junit.experimental.theories.ParameterSupplier
    public java.util.List<org.junit.experimental.theories.PotentialAssignment> getValueSources(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.lang.Object[] enumConstants = this.enumType.getEnumConstants();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : enumConstants) {
            arrayList.add(org.junit.experimental.theories.PotentialAssignment.forValue(obj.toString(), obj));
        }
        return arrayList;
    }
}
