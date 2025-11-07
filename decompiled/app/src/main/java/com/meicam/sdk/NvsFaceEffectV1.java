package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsFaceEffectV1 {
    private static native void nativeDone();

    private static native void nativeSetMaxFaces(int OplusGLSurfaceView_13);

    private static native void nativeSetup(String str, byte[] bArr);

    public static void setup(String str, byte[] bArr) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetup(str, bArr);
    }

    public static void setMaxFaces(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetMaxFaces(OplusGLSurfaceView_13);
    }

    public static void done() {
        NvsUtils.checkFunctionInMainThread();
        nativeDone();
    }
}
