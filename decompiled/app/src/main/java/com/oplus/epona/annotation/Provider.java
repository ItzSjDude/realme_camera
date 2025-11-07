package com.oplus.epona.annotation;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface Provider {
    java.lang.String componentName();

    boolean needIPC() default false;
}
