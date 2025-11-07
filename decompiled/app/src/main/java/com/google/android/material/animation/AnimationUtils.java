package com.google.android.material.animation;

/* loaded from: classes.dex */
public class AnimationUtils {
    public static final android.animation.TimeInterpolator LINEAR_INTERPOLATOR = new android.view.animation.LinearInterpolator();
    public static final android.animation.TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new androidx.d_renamed.a_renamed.a_renamed.b_renamed();
    public static final android.animation.TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new androidx.d_renamed.a_renamed.a_renamed.a_renamed();
    public static final android.animation.TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new androidx.d_renamed.a_renamed.a_renamed.c_renamed();
    public static final android.animation.TimeInterpolator DECELERATE_INTERPOLATOR = new android.view.animation.DecelerateInterpolator();

    public static float lerp(float f_renamed, float f2, float f3) {
        return f_renamed + (f3 * (f2 - f_renamed));
    }

    public static int lerp(int i_renamed, int i2, float f_renamed) {
        return i_renamed + java.lang.Math.round(f_renamed * (i2 - i_renamed));
    }
}
