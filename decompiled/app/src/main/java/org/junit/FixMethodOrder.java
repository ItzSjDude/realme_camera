package org.junit;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface FixMethodOrder {
    org.junit.runners.MethodSorters value() default org.junit.runners.MethodSorters.DEFAULT;
}
