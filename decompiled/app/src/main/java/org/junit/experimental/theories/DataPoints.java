package org.junit.experimental.theories;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface DataPoints {
    java.lang.Class<? extends java.lang.Throwable>[] ignoredExceptions() default {};

    java.lang.String[] value() default {};
}
