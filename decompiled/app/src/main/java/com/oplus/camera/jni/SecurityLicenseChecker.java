package com.oplus.camera.jni;

/* loaded from: classes2.dex */
public class SecurityLicenseChecker {
    public static native byte[] decodeBuffer(android.content.Context context, byte[] bArr);

    public static native byte[] encodeBuffer(byte[] bArr);

    static {
        java.lang.System.loadLibrary("license-checker-jni");
    }
}
