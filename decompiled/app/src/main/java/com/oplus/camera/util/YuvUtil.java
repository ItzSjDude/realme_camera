package com.oplus.camera.util;

/* loaded from: classes2.dex */
public class YuvUtil {

    public static class YuvParameter {
        public int mFormat = 17;
        public int mWidth = 0;
        public int mHeight = 0;
    }

    public native int scale(byte[] bArr, com.oplus.camera.util.YuvUtil.YuvParameter yuvParameter, byte[] bArr2, com.oplus.camera.util.YuvUtil.YuvParameter yuvParameter2);

    static {
        java.lang.System.loadLibrary("YuvUtil");
    }

    public byte[] a_renamed(byte[] bArr, int i_renamed, int i2, int i3, int i4) {
        byte[] bArr2 = new byte[(int) (i3 * i4 * 1.5f)];
        com.oplus.camera.util.YuvUtil.YuvParameter yuvParameter = new com.oplus.camera.util.YuvUtil.YuvParameter();
        yuvParameter.mWidth = i_renamed;
        yuvParameter.mHeight = i2;
        com.oplus.camera.util.YuvUtil.YuvParameter yuvParameter2 = new com.oplus.camera.util.YuvUtil.YuvParameter();
        yuvParameter2.mWidth = i3;
        yuvParameter2.mHeight = i4;
        int iScale = scale(bArr, yuvParameter, bArr2, yuvParameter2);
        if (iScale == 0) {
            return bArr2;
        }
        com.oplus.camera.e_renamed.f_renamed("YuvUtil", "scaleImage, result: " + iScale);
        return null;
    }
}
