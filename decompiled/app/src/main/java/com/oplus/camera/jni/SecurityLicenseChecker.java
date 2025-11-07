package com.oplus.camera.jni;

import android.content.Context;

/* loaded from: classes2.dex */
public class SecurityLicenseChecker {
    public static native byte[] decodeBuffer(Context context, byte[] bArr);

    public static native byte[] encodeBuffer(byte[] bArr);

    static {
        System.loadLibrary("license-checker-jni");
    }
}
