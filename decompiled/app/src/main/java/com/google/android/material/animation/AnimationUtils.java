package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.p040d.p041a.p042a.FastOutLinearInInterpolator;
import androidx.p040d.p041a.p042a.FastOutSlowInInterpolator;
import androidx.p040d.p041a.p042a.LinearOutSlowInInterpolator;

/* loaded from: classes.dex */
public class AnimationUtils {
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static float lerp(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 + (f3 * (f2 - COUIBaseListPopupWindow_12));
    }

    public static int lerp(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        return OplusGLSurfaceView_13 + Math.round(COUIBaseListPopupWindow_12 * (i2 - OplusGLSurfaceView_13));
    }
}
