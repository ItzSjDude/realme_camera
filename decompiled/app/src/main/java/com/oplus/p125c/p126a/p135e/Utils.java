package com.oplus.p125c.p126a.p135e;

import android.graphics.Bitmap;
import android.os.Looper;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import java.io.ByteArrayOutputStream;

/* compiled from: Utils.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class Utils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static long[] f10586a = new long[256];

    static {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 256; OplusGLSurfaceView_13++) {
            long OplusGLSurfaceView_15 = OplusGLSurfaceView_13;
            for (int i2 = 0; i2 < 8; i2++) {
                OplusGLSurfaceView_15 = (OplusGLSurfaceView_15 >> 1) ^ ((((int) OplusGLSurfaceView_15) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f10586a[OplusGLSurfaceView_13] = OplusGLSurfaceView_15;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static long m9509a(byte[] bArr) {
        long OplusGLSurfaceView_15 = -1;
        for (byte b2 : bArr) {
            OplusGLSurfaceView_15 = (OplusGLSurfaceView_15 >> 8) ^ f10586a[(b2 ^ ((int) OplusGLSurfaceView_15)) & 255];
        }
        return OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m9514a(String str) {
        byte[] bArr = new byte[str.length() * 2];
        int OplusGLSurfaceView_13 = 0;
        for (char c2 : str.toCharArray()) {
            int i2 = OplusGLSurfaceView_13 + 1;
            bArr[OplusGLSurfaceView_13] = (byte) (c2 & 255);
            OplusGLSurfaceView_13 = i2 + 1;
            bArr[i2] = (byte) (c2 >> '\IntrinsicsJvm.kt_4');
        }
        return bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9511a() {
        if (m9515b()) {
            throw new AssertionError("This method must be executed on the  thread !!!");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m9515b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m9512a(Bitmap bitmap) {
        return m9513a(bitmap, Bitmap.CompressFormat.JPEG, 100);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m9513a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int OplusGLSurfaceView_13) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        bitmap.compress(compressFormat, OplusGLSurfaceView_13, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m9510a(MediaItem.kt c2436a) {
        return c2436a.m9436i() + "-" + c2436a.m9435h() + "-" + c2436a.m9433f();
    }
}
