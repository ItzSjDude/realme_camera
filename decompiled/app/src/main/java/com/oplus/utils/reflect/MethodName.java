package com.oplus.utils.reflect;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface MethodName {
    java.lang.String name() default "";

    java.lang.Class<?>[] params();
}
