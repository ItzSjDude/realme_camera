package com.anc.humansdk.doubleexposure;

/* loaded from: classes.dex */
public class ErrorCode {
    public static final int ANC_HUM_FAILURE = 3;
    public static final int ANC_HUM_GL_COMPILING = 8;
    public static final int ANC_HUM_INTERNAL_ERROR = 12;
    public static final int ANC_HUM_INVALID_ARGUMENT = 1;
    public static final int ANC_HUM_INVALID_HANDLE = 2;
    public static final int ANC_HUM_INVALID_OPERATION = 9;
    public static final int ANC_HUM_LOADING = 7;
    public static final int ANC_HUM_MODEL_LOADING = 10;
    public static final int ANC_HUM_MORE_PERSON = 6;
    public static final int ANC_HUM_NO_PERSON = 4;
    public static final int ANC_HUM_OK = 0;
    public static final int ANC_HUM_TOO_FAR = 5;
    public static final int ANC_HUM_UNAVAILABLE = 11;

    public static String getErrorMessage(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 0:
                return "SUCCESS";
            case 1:
                return "INVALID ARGUMENT";
            case 2:
                return "INVALID HANDLE";
            case 3:
                return "FAILURE";
            case 4:
                return "NO PERSON";
            case 5:
                return "TOO FAR";
            case 6:
                return "TOO MANY PERSON";
            case 7:
            default:
                return "UNKNOWN ERROR";
            case 8:
                return "UNDER INITIALIZING";
        }
    }

    public static boolean isError(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 0;
    }
}
