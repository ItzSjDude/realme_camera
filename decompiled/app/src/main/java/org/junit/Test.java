package org.junit;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface Test {
    java.lang.Class<? extends java.lang.Throwable> expected() default org.junit.Test.None.class;

    long timeout() default 0;

    public static class None extends java.lang.Throwable {
        private static final long serialVersionUID = 1;

        private None() {
        }
    }
}
