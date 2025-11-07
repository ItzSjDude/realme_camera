package org.junit.experimental.theories.internal;

/* loaded from: classes2.dex */
public class BooleanSupplier extends org.junit.experimental.theories.ParameterSupplier {
    @Override // org.junit.experimental.theories.ParameterSupplier
    public java.util.List<org.junit.experimental.theories.PotentialAssignment> getValueSources(org.junit.experimental.theories.ParameterSignature parameterSignature) {
        return java.util.Arrays.asList(org.junit.experimental.theories.PotentialAssignment.forValue("true", true), org.junit.experimental.theories.PotentialAssignment.forValue("false", false));
    }
}
