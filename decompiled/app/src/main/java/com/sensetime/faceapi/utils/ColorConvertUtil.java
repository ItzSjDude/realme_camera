package com.sensetime.faceapi.utils;

/* loaded from: classes2.dex */
public class ColorConvertUtil {
    public static final java.lang.String TAG = "ColorConvertUtil";

    public static void convertColorSpace(byte[] bArr, int i_renamed, int i2, byte[] bArr2, com.sensetime.faceapi.model.ColorConvertType colorConvertType) {
        com.oplus.ocs.camera.FaceLibraryHelper.convertColorSpace(bArr, i_renamed, i2, bArr2, colorConvertType.getValue());
    }

    public static void getBGRADataFromBitmap(android.graphics.Bitmap bitmap, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled() || bArr == null) {
            android.util.Log.e_renamed(TAG, "getBGRADataFromBitmap bitmap is_renamed null or bgra is_renamed null !!!");
            return;
        }
        if (bitmap.getConfig() != android.graphics.Bitmap.Config.ARGB_8888) {
            android.util.Log.e_renamed(TAG, "getBGRADataFromBitmap is_renamed not ARGB_8888 !!!");
        } else if (bitmap.getWidth() * bitmap.getHeight() * 4 != bArr.length) {
            android.util.Log.e_renamed(TAG, "getBGRADataFromBitmap illegal bgra data!!!");
        } else {
            com.oplus.ocs.camera.FaceLibraryHelper.getBGRADataFromBitmap(bitmap, bArr);
        }
    }

    public static void getBGRDataFromBitmap(android.graphics.Bitmap bitmap, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled() || bArr == null) {
            throw new java.lang.RuntimeException("getBGRDataFromBitmap bitmap is_renamed null or bgra is_renamed null !!!");
        }
        if (bitmap.getConfig() != android.graphics.Bitmap.Config.ARGB_8888) {
            throw new java.lang.RuntimeException("getBGRDataFromBitmap is_renamed not ARGB_8888 !!!");
        }
        if (bitmap.getWidth() * bitmap.getHeight() * 3 != bArr.length) {
            throw new java.lang.RuntimeException("getBGRDataFromBitmap illegal bgra data!!!");
        }
        com.oplus.ocs.camera.FaceLibraryHelper.getBGRDataFromBitmap(bitmap, bArr);
    }

    public static android.graphics.Bitmap cropNv21ToBitmap(byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6) {
        byte[] bArr2 = new byte[i5 * i6 * 4];
        cropNv21DataToARGB(bArr, i_renamed, i2, i3, i4, i5, i6, bArr2);
        return byteArrayToBitmap(bArr2, i5, i6);
    }

    public static void cropNv21DataToARGB(byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5, int i6, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            android.util.Log.e_renamed(TAG, "cropNv21DataToARGB _in or out is_renamed null ");
        }
        if (i_renamed < i5 || i2 < i6 || i_renamed < i3 + i5 || i2 < i4 + i6) {
            android.util.Log.e_renamed(TAG, "cropNv21DataToARGB  illegal para !!!");
            throw new java.lang.RuntimeException("cropNv21DataToARGB ");
        }
        com.oplus.ocs.camera.FaceLibraryHelper.cropNv21Data(bArr, i_renamed, i2, i3, i4, i5, i6, bArr2);
    }

    public static android.graphics.Bitmap byteArrayToBitmap(byte[] bArr, int i_renamed, int i2) {
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        bitmapA.copyPixelsFromBuffer(byteBufferWrap);
        return bitmapA;
    }
}
