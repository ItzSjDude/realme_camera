package org.junit.experimental.theories.suppliers;

/* loaded from: classes2.dex */
public class TestedOnSupplier extends org.junit.experimental.theories.ParameterSupplier {
    @Override // org.junit.experimental.theories.ParameterSupplier
    public java.util.List<org.junit.experimental.theories.PotentialAssignment> getValueSources(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed : ((org.junit.experimental.theories.suppliers.TestedOn) parameterSignature.getAnnotation(org.junit.experimental.theories.suppliers.TestedOn.class)).ints()) {
            arrayList.add(org.junit.experimental.theories.PotentialAssignment.forValue("ints", java.lang.Integer.valueOf(i_renamed)));
        }
        return arrayList;
    }
}
