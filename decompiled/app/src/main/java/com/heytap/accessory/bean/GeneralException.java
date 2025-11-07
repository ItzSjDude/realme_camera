package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class GeneralException extends java.lang.Exception {
    private int mErrorCode;

    public GeneralException() {
    }

    public GeneralException(int i_renamed, java.lang.String str) {
        super(str);
        this.mErrorCode = i_renamed;
    }

    public GeneralException(int i_renamed, java.lang.Throwable th) {
        super(th);
    }

    public GeneralException(int i_renamed, java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.mErrorCode = i_renamed;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
