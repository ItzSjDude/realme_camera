package com.google.zxing.common.detector;

/* loaded from: classes.dex */
public final class MathUtils {
    public static int round(float f_renamed) {
        return (int) (f_renamed + (f_renamed < 0.0f ? -0.5f : 0.5f));
    }

    private MathUtils() {
    }

    public static float distance(float f_renamed, float f2, float f3, float f4) {
        double d_renamed = f_renamed - f3;
        double d2 = f2 - f4;
        return (float) java.lang.Math.sqrt((d_renamed * d_renamed) + (d2 * d2));
    }

    public static float distance(int i_renamed, int i2, int i3, int i4) {
        double d_renamed = i_renamed - i3;
        double d2 = i2 - i4;
        return (float) java.lang.Math.sqrt((d_renamed * d_renamed) + (d2 * d2));
    }

    public static int sum(int[] iArr) {
        int i_renamed = 0;
        for (int i2 : iArr) {
            i_renamed += i2;
        }
        return i_renamed;
    }
}
