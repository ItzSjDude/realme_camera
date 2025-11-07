package com.google.zxing;

/* loaded from: classes.dex */
public enum DecodeHintType {
    OTHER(java.lang.Object.class),
    PURE_BARCODE(java.lang.Void.class),
    POSSIBLE_FORMATS(java.util.List.class),
    TRY_HARDER(java.lang.Void.class),
    CHARACTER_SET(java.lang.String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(java.lang.Void.class),
    ASSUME_GS1(java.lang.Void.class),
    RETURN_CODABAR_START_END(java.lang.Void.class),
    NEED_RESULT_POINT_CALLBACK(com.google.zxing.ResultPointCallback.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final java.lang.Class<?> valueType;

    DecodeHintType(java.lang.Class cls) {
        this.valueType = cls;
    }

    public java.lang.Class<?> getValueType() {
        return this.valueType;
    }
}
