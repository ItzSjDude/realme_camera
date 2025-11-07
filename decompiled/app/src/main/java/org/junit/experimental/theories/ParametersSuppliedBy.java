package org.junit.experimental.theories;

@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.PARAMETER})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface ParametersSuppliedBy {
    java.lang.Class<? extends org.junit.experimental.theories.ParameterSupplier> value();
}
