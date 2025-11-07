package com.oplus.camera.p146gl;

import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Utils.java */
/* renamed from: com.oplus.camera.gl.y */
/* loaded from: classes2.dex */
public class Utils_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f14321a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static long[] f14322b;

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m14287a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 > f3 ? f3 : COUIBaseListPopupWindow_12 < f2 ? f2 : COUIBaseListPopupWindow_12;
    }

    static {
        f14321a = Build.TYPE.equals("eng") || Build.TYPE.equals("userdebug");
        f14322b = new long[256];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 256; OplusGLSurfaceView_13++) {
            long OplusGLSurfaceView_15 = OplusGLSurfaceView_13;
            for (int i2 = 0; i2 < 8; i2++) {
                OplusGLSurfaceView_15 = (OplusGLSurfaceView_15 >> 1) ^ ((((int) OplusGLSurfaceView_15) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f14322b[OplusGLSurfaceView_13] = OplusGLSurfaceView_15;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14289a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m14288a(long OplusGLSurfaceView_15) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS", Locale.CHINA).format(Long.valueOf(OplusGLSurfaceView_15));
    }
}
