package com.airbnb.lottie.p091f;

/* compiled from: GammaEvaluator.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class GammaEvaluator_2 {
    /* renamed from: PlatformImplementations.kt_3 */
    private static float m6090a(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 <= 0.0031308f ? COUIBaseListPopupWindow_12 * 12.92f : (float) ((Math.pow(COUIBaseListPopupWindow_12, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static float m6092b(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 <= 0.04045f ? COUIBaseListPopupWindow_12 / 12.92f : (float) Math.pow((COUIBaseListPopupWindow_12 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6091a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == i2) {
            return OplusGLSurfaceView_13;
        }
        float f2 = ((OplusGLSurfaceView_13 >> 24) & 255) / 255.0f;
        float fM6092b = m6092b(((OplusGLSurfaceView_13 >> 16) & 255) / 255.0f);
        float fM6092b2 = m6092b(((OplusGLSurfaceView_13 >> 8) & 255) / 255.0f);
        float fM6092b3 = m6092b((OplusGLSurfaceView_13 & 255) / 255.0f);
        float fM6092b4 = m6092b(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * COUIBaseListPopupWindow_12);
        float fM6092b5 = fM6092b2 + ((m6092b(((i2 >> 8) & 255) / 255.0f) - fM6092b2) * COUIBaseListPopupWindow_12);
        float fM6092b6 = fM6092b3 + (COUIBaseListPopupWindow_12 * (m6092b((i2 & 255) / 255.0f) - fM6092b3));
        return (Math.round(m6090a(fM6092b + ((fM6092b4 - fM6092b) * COUIBaseListPopupWindow_12)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(m6090a(fM6092b5) * 255.0f) << 8) | Math.round(m6090a(fM6092b6) * 255.0f);
    }
}
