package com.oplus.camera.jni;

/* loaded from: classes2.dex */
public class IccProfile {
    public static native byte[] compressBitmap(android.graphics.Bitmap bitmap, int i_renamed);

    public static native int compressBitmapToFile(android.graphics.Bitmap bitmap, int i_renamed, java.lang.String str);

    public static native byte[] convertYuv2JpegWithColorProfile(byte[] bArr, int i_renamed, int i2, int i3);

    public static native void writeHeifIccProfile(int i_renamed);

    static {
        java.lang.System.loadLibrary("IccProfileJni");
    }
}
