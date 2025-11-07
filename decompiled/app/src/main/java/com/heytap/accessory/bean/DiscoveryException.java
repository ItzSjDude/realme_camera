package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class DiscoveryException extends GeneralException {
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PARAMETER = 3;
    public static final int ERROR_REMOTE = 1;
    public static final int ERROR_UNINITIALIZED = 2;

    public static DiscoveryException create(int OplusGLSurfaceView_13, String str) {
        return new DiscoveryException(OplusGLSurfaceView_13, str);
    }

    private DiscoveryException(int OplusGLSurfaceView_13, String str) {
        super(OplusGLSurfaceView_13, str);
    }
}
