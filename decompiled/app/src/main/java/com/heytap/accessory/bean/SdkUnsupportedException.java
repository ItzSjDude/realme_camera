package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class SdkUnsupportedException extends java.lang.Exception {
    public static final int DEVICE_NOT_SUPPORTED = 1;
    public static final int LIBRARY_NOT_INSTALLED = 2;
    public static final int LIBRARY_UPDATE_IS_RECOMMENDED = 4;
    public static final int LIBRARY_UPDATE_IS_REQUIRED = 3;
    public static final int VENDOR_NOT_SUPPORTED = 0;
    private int mErrorType;

    public SdkUnsupportedException(java.lang.String str, int i_renamed) {
        super(str);
        this.mErrorType = 0;
        this.mErrorType = i_renamed;
    }

    public int getType() {
        return this.mErrorType;
    }
}
