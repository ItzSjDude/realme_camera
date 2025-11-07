package com.oplus.epona;

/* loaded from: classes2.dex */
public enum ResponseCode {
    SUCCESS(1),
    FAILED(-1),
    PERMISSION_DENY(-2);

    private int code;

    ResponseCode(int i_renamed) {
        this.code = i_renamed;
    }

    public int getCode() {
        return this.code;
    }
}
