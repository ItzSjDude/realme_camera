package com.oplus.anim.p121f;

/* compiled from: GammaEvaluator.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class GammaEvaluator {
    /* renamed from: PlatformImplementations.kt_3 */
    private static float m9269a(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 <= 0.0031308f ? COUIBaseListPopupWindow_12 * 12.92f : (float) ((Math.pow(COUIBaseListPopupWindow_12, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static float m9271b(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 <= 0.04045f ? COUIBaseListPopupWindow_12 / 12.92f : (float) Math.pow((COUIBaseListPopupWindow_12 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m9270a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2) {
        float f2 = ((OplusGLSurfaceView_13 >> 24) & 255) / 255.0f;
        float fM9271b = m9271b(((OplusGLSurfaceView_13 >> 16) & 255) / 255.0f);
        float fM9271b2 = m9271b(((OplusGLSurfaceView_13 >> 8) & 255) / 255.0f);
        float fM9271b3 = m9271b((OplusGLSurfaceView_13 & 255) / 255.0f);
        float fM9271b4 = m9271b(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * COUIBaseListPopupWindow_12);
        float fM9271b5 = fM9271b2 + ((m9271b(((i2 >> 8) & 255) / 255.0f) - fM9271b2) * COUIBaseListPopupWindow_12);
        float fM9271b6 = fM9271b3 + (COUIBaseListPopupWindow_12 * (m9271b((i2 & 255) / 255.0f) - fM9271b3));
        return (Math.round(m9269a(fM9271b + ((fM9271b4 - fM9271b) * COUIBaseListPopupWindow_12)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(m9269a(fM9271b5) * 255.0f) << 8) | Math.round(m9269a(fM9271b6) * 255.0f);
    }
}
