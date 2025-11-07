package org.junit.experimental.theories;

@java.lang.annotation.Target({java.lang.annotation.ElementType.PARAMETER})
@org.junit.experimental.theories.ParametersSuppliedBy(org.junit.experimental.theories.internal.SpecificDataPointsSupplier.class)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface FromDataPoints {
    java.lang.String value();
}
