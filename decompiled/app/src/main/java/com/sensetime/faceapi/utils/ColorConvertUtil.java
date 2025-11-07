package com.sensetime.faceapi.utils;

import android.graphics.Bitmap;
import android.util.Log;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.FaceLibraryHelper;
import com.sensetime.faceapi.model.ColorConvertType;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ColorConvertUtil {
    public static final String TAG = "ColorConvertUtil";

    public static void convertColorSpace(byte[] bArr, int OplusGLSurfaceView_13, int i2, byte[] bArr2, ColorConvertType colorConvertType) {
        FaceLibraryHelper.convertColorSpace(bArr, OplusGLSurfaceView_13, i2, bArr2, colorConvertType.getValue());
    }

    public static void getBGRADataFromBitmap(Bitmap bitmap, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled() || bArr == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "getBGRADataFromBitmap bitmap is null or bgra is null !!!");
            return;
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            Log.COUIBaseListPopupWindow_8(TAG, "getBGRADataFromBitmap is not ARGB_8888 !!!");
        } else if (bitmap.getWidth() * bitmap.getHeight() * 4 != bArr.length) {
            Log.COUIBaseListPopupWindow_8(TAG, "getBGRADataFromBitmap illegal bgra data!!!");
        } else {
            FaceLibraryHelper.getBGRADataFromBitmap(bitmap, bArr);
        }
    }

    public static void getBGRDataFromBitmap(Bitmap bitmap, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled() || bArr == null) {
            throw new RuntimeException("getBGRDataFromBitmap bitmap is null or bgra is null !!!");
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new RuntimeException("getBGRDataFromBitmap is not ARGB_8888 !!!");
        }
        if (bitmap.getWidth() * bitmap.getHeight() * 3 != bArr.length) {
            throw new RuntimeException("getBGRDataFromBitmap illegal bgra data!!!");
        }
        FaceLibraryHelper.getBGRDataFromBitmap(bitmap, bArr);
    }

    public static Bitmap cropNv21ToBitmap(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        byte[] bArr2 = new byte[i5 * i6 * 4];
        cropNv21DataToARGB(bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, i6, bArr2);
        return byteArrayToBitmap(bArr2, i5, i6);
    }

    public static void cropNv21DataToARGB(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            Log.COUIBaseListPopupWindow_8(TAG, "cropNv21DataToARGB _in or out is null ");
        }
        if (OplusGLSurfaceView_13 < i5 || i2 < i6 || OplusGLSurfaceView_13 < i3 + i5 || i2 < i4 + i6) {
            Log.COUIBaseListPopupWindow_8(TAG, "cropNv21DataToARGB  illegal para !!!");
            throw new RuntimeException("cropNv21DataToARGB ");
        }
        FaceLibraryHelper.cropNv21Data(bArr, OplusGLSurfaceView_13, i2, i3, i4, i5, i6, bArr2);
    }

    public static Bitmap byteArrayToBitmap(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Bitmap bitmapM24215a = Util.m24215a(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        bitmapM24215a.copyPixelsFromBuffer(byteBufferWrap);
        return bitmapM24215a;
    }
}
