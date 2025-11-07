package org.junit.experimental.theories.suppliers;

@java.lang.annotation.Target({java.lang.annotation.ElementType.PARAMETER})
@org.junit.experimental.theories.ParametersSuppliedBy(org.junit.experimental.theories.suppliers.TestedOnSupplier.class)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface TestedOn {
    int[] ints();
}
