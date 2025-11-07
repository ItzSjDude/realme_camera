package com.sensetime.faceapi;

/* loaded from: classes2.dex */
public class LicenseHelper {
    public static int initLicense(byte[] bArr) {
        return com.oplus.ocs.camera.FaceLibraryHelper.initLiscence(bArr);
    }

    public static int initLicense(java.lang.String str) {
        return com.oplus.ocs.camera.FaceLibraryHelper.initLiscenceStr(str);
    }
}
