package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsFaceEffectV1 {
    private static native void nativeDone();

    private static native void nativeSetMaxFaces(int i_renamed);

    private static native void nativeSetup(java.lang.String str, byte[] bArr);

    public static void setup(java.lang.String str, byte[] bArr) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetup(str, bArr);
    }

    public static void setMaxFaces(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetMaxFaces(i_renamed);
    }

    public static void done() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeDone();
    }
}
