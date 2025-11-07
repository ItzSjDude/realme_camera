package com.oplus.anim.f_renamed;

/* compiled from: GammaEvaluator.java */
/* loaded from: classes2.dex */
public class c_renamed {
    private static float a_renamed(float f_renamed) {
        return f_renamed <= 0.0031308f ? f_renamed * 12.92f : (float) ((java.lang.Math.pow(f_renamed, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float b_renamed(float f_renamed) {
        return f_renamed <= 0.04045f ? f_renamed / 12.92f : (float) java.lang.Math.pow((f_renamed + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int a_renamed(float f_renamed, int i_renamed, int i2) {
        float f2 = ((i_renamed >> 24) & 255) / 255.0f;
        float fB_renamed = b_renamed(((i_renamed >> 16) & 255) / 255.0f);
        float fB2 = b_renamed(((i_renamed >> 8) & 255) / 255.0f);
        float fB3 = b_renamed((i_renamed & 255) / 255.0f);
        float fB4 = b_renamed(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f_renamed);
        float fB5 = fB2 + ((b_renamed(((i2 >> 8) & 255) / 255.0f) - fB2) * f_renamed);
        float fB6 = fB3 + (f_renamed * (b_renamed((i2 & 255) / 255.0f) - fB3));
        return (java.lang.Math.round(a_renamed(fB_renamed + ((fB4 - fB_renamed) * f_renamed)) * 255.0f) << 16) | (java.lang.Math.round(f3 * 255.0f) << 24) | (java.lang.Math.round(a_renamed(fB5) * 255.0f) << 8) | java.lang.Math.round(a_renamed(fB6) * 255.0f);
    }
}
