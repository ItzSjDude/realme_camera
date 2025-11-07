package com.google.android.material.math;

/* loaded from: classes.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    public static boolean geq(float f_renamed, float f2, float f3) {
        return f_renamed + f3 >= f2;
    }

    public static float lerp(float f_renamed, float f2, float f3) {
        return ((1.0f - f3) * f_renamed) + (f3 * f2);
    }

    private static float max(float f_renamed, float f2, float f3, float f4) {
        return (f_renamed <= f2 || f_renamed <= f3 || f_renamed <= f4) ? (f2 <= f3 || f2 <= f4) ? f3 > f4 ? f3 : f4 : f2 : f_renamed;
    }

    private MathUtils() {
    }

    public static float dist(float f_renamed, float f2, float f3, float f4) {
        return (float) java.lang.Math.hypot(f3 - f_renamed, f4 - f2);
    }

    public static float distanceToFurthestCorner(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        return max(dist(f_renamed, f2, f3, f4), dist(f_renamed, f2, f5, f4), dist(f_renamed, f2, f5, f6), dist(f_renamed, f2, f3, f6));
    }

    public static float floorMod(float f_renamed, int i_renamed) {
        float f2 = i_renamed;
        int i2 = (int) (f_renamed / f2);
        if (java.lang.Math.signum(f_renamed) * f2 < 0.0f && i2 * i_renamed != f_renamed) {
            i2--;
        }
        return f_renamed - (i2 * i_renamed);
    }

    public static int floorMod(int i_renamed, int i2) {
        int i3 = i_renamed / i2;
        if ((i_renamed ^ i2) < 0 && i3 * i2 != i_renamed) {
            i3--;
        }
        return i_renamed - (i3 * i2);
    }
}
