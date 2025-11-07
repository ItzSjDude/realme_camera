package com.google.android.material.math;

/* loaded from: classes.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    public static boolean geq(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 + f3 >= f2;
    }

    public static float lerp(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return ((1.0f - f3) * COUIBaseListPopupWindow_12) + (f3 * f2);
    }

    private static float max(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        return (COUIBaseListPopupWindow_12 <= f2 || COUIBaseListPopupWindow_12 <= f3 || COUIBaseListPopupWindow_12 <= f4) ? (f2 <= f3 || f2 <= f4) ? f3 > f4 ? f3 : f4 : f2 : COUIBaseListPopupWindow_12;
    }

    private MathUtils() {
    }

    public static float dist(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        return (float) Math.hypot(f3 - COUIBaseListPopupWindow_12, f4 - f2);
    }

    public static float distanceToFurthestCorner(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        return max(dist(COUIBaseListPopupWindow_12, f2, f3, f4), dist(COUIBaseListPopupWindow_12, f2, f5, f4), dist(COUIBaseListPopupWindow_12, f2, f5, f6), dist(COUIBaseListPopupWindow_12, f2, f3, f6));
    }

    public static float floorMod(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        float f2 = OplusGLSurfaceView_13;
        int i2 = (int) (COUIBaseListPopupWindow_12 / f2);
        if (Math.signum(COUIBaseListPopupWindow_12) * f2 < 0.0f && i2 * OplusGLSurfaceView_13 != COUIBaseListPopupWindow_12) {
            i2--;
        }
        return COUIBaseListPopupWindow_12 - (i2 * OplusGLSurfaceView_13);
    }

    public static int floorMod(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 / i2;
        if ((OplusGLSurfaceView_13 ^ i2) < 0 && i3 * i2 != OplusGLSurfaceView_13) {
            i3--;
        }
        return OplusGLSurfaceView_13 - (i3 * i2);
    }
}
