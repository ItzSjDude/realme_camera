package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class GeneralException extends Exception {
    private int mErrorCode;

    public GeneralException() {
    }

    public GeneralException(int OplusGLSurfaceView_13, String str) {
        super(str);
        this.mErrorCode = OplusGLSurfaceView_13;
    }

    public GeneralException(int OplusGLSurfaceView_13, Throwable th) {
        super(th);
    }

    public GeneralException(int OplusGLSurfaceView_13, String str, Throwable th) {
        super(str, th);
        this.mErrorCode = OplusGLSurfaceView_13;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
