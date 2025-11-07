package com.oplus.camera.util;

import com.oplus.camera.CameraLog;

/* loaded from: classes2.dex */
public class YuvUtil {

    public static class YuvParameter {
        public int mFormat = 17;
        public int mWidth = 0;
        public int mHeight = 0;
    }

    public native int scale(byte[] bArr, YuvParameter yuvParameter, byte[] bArr2, YuvParameter yuvParameter2);

    static {
        System.loadLibrary("YuvUtil");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] m24512a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        byte[] bArr2 = new byte[(int) (i3 * i4 * 1.5f)];
        YuvParameter yuvParameter = new YuvParameter();
        yuvParameter.mWidth = OplusGLSurfaceView_13;
        yuvParameter.mHeight = i2;
        YuvParameter yuvParameter2 = new YuvParameter();
        yuvParameter2.mWidth = i3;
        yuvParameter2.mHeight = i4;
        int iScale = scale(bArr, yuvParameter, bArr2, yuvParameter2);
        if (iScale == 0) {
            return bArr2;
        }
        CameraLog.m12967f("YuvUtil", "scaleImage, result: " + iScale);
        return null;
    }
}
