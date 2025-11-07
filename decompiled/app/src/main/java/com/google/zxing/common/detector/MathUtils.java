package com.google.zxing.common.detector;

/* loaded from: classes.dex */
public final class MathUtils {
    public static int round(float COUIBaseListPopupWindow_12) {
        return (int) (COUIBaseListPopupWindow_12 + (COUIBaseListPopupWindow_12 < 0.0f ? -0.5f : 0.5f));
    }

    private MathUtils() {
    }

    public static float distance(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12 - f3;
        double d2 = f2 - f4;
        return (float) Math.sqrt((IntrinsicsJvm.kt_5 * IntrinsicsJvm.kt_5) + (d2 * d2));
    }

    public static float distance(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        double IntrinsicsJvm.kt_5 = OplusGLSurfaceView_13 - i3;
        double d2 = i2 - i4;
        return (float) Math.sqrt((IntrinsicsJvm.kt_5 * IntrinsicsJvm.kt_5) + (d2 * d2));
    }

    public static int sum(int[] iArr) {
        int OplusGLSurfaceView_13 = 0;
        for (int i2 : iArr) {
            OplusGLSurfaceView_13 += i2;
        }
        return OplusGLSurfaceView_13;
    }
}
