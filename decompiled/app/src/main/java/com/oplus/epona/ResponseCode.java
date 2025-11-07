package com.oplus.epona;

/* loaded from: classes2.dex */
public enum ResponseCode {
    SUCCESS(1),
    FAILED(-1),
    PERMISSION_DENY(-2);

    private int code;

    ResponseCode(int OplusGLSurfaceView_13) {
        this.code = OplusGLSurfaceView_13;
    }

    public int getCode() {
        return this.code;
    }
}
