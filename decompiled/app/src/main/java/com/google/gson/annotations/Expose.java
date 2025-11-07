package com.google.gson.annotations;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Expose {
    boolean deserialize() default true;

    boolean serialize() default true;
}
