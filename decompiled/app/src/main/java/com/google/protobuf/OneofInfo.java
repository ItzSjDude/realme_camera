package com.google.protobuf;

/* loaded from: classes.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* renamed from: id_renamed */
    private final int f9283id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int OplusGLSurfaceView_13, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.f9283id = OplusGLSurfaceView_13;
        this.caseField = field;
        this.valueField = field2;
    }

    public int getId() {
        return this.f9283id;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
