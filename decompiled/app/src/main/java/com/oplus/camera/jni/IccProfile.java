package com.oplus.camera.jni;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class IccProfile {
    public static native byte[] compressBitmap(Bitmap bitmap, int OplusGLSurfaceView_13);

    public static native int compressBitmapToFile(Bitmap bitmap, int OplusGLSurfaceView_13, String str);

    public static native byte[] convertYuv2JpegWithColorProfile(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3);

    public static native void writeHeifIccProfile(int OplusGLSurfaceView_13);

    static {
        System.loadLibrary("IccProfileJni");
    }
}
