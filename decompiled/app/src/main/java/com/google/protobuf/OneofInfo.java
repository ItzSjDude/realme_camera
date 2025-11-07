package com.google.protobuf;

/* loaded from: classes.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;
    private final int id_renamed;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int i_renamed, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.id_renamed = i_renamed;
        this.caseField = field;
        this.valueField = field2;
    }

    public int getId() {
        return this.id_renamed;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
