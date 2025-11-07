package com.google.gson.annotations;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface SerializedName {
    java.lang.String[] alternate() default {};

    java.lang.String value();
}
