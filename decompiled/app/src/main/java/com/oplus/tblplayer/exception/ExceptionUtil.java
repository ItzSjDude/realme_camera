package com.oplus.tblplayer.exception;

/* loaded from: classes2.dex */
public class ExceptionUtil {
    public static final String ERROR_CODE_PREFIX = "errorCode:";
    private static final int INDEX = 10;

    public static final String formatMessage(int OplusGLSurfaceView_13, String str) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 999) {
            return str;
        }
        return ERROR_CODE_PREFIX + OplusGLSurfaceView_13 + " " + str;
    }
}
