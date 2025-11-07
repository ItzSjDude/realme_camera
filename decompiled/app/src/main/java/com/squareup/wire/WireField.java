package com.squareup.wire;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface WireField {
    java.lang.String adapter();

    java.lang.String keyAdapter() default "";

    com.squareup.wire.WireField.Label label() default com.squareup.wire.WireField.Label.OPTIONAL;

    boolean redacted() default false;

    int tag();

    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        boolean isPacked() {
            return this == PACKED;
        }

        boolean isOneOf() {
            return this == ONE_OF;
        }
    }
}
