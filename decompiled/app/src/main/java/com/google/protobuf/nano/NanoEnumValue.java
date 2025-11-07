package com.google.protobuf.nano;

@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface NanoEnumValue {
    boolean keepAsInt() default false;

    boolean legacy() default false;

    java.lang.Class<?> value();
}
