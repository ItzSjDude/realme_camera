package com.sensetime.faceapi;

import com.oplus.ocs.camera.FaceLibraryHelper;

/* loaded from: classes2.dex */
public class LicenseHelper {
    public static int initLicense(byte[] bArr) {
        return FaceLibraryHelper.initLiscence(bArr);
    }

    public static int initLicense(String str) {
        return FaceLibraryHelper.initLiscenceStr(str);
    }
}
