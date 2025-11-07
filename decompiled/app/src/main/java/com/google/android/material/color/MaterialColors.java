package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    public static int getColor(View view, int OplusGLSurfaceView_13) {
        return MaterialAttributes.resolveOrThrow(view, OplusGLSurfaceView_13);
    }

    public static int getColor(Context context, int OplusGLSurfaceView_13, String str) {
        return MaterialAttributes.resolveOrThrow(context, OplusGLSurfaceView_13, str);
    }

    public static int getColor(View view, int OplusGLSurfaceView_13, int i2) {
        return getColor(view.getContext(), OplusGLSurfaceView_13, i2);
    }

    public static int getColor(Context context, int OplusGLSurfaceView_13, int i2) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, OplusGLSurfaceView_13);
        return typedValueResolve != null ? typedValueResolve.data : i2;
    }

    public static int layer(View view, int OplusGLSurfaceView_13, int i2) {
        return layer(view, OplusGLSurfaceView_13, i2, 1.0f);
    }

    public static int layer(View view, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        return layer(getColor(view, OplusGLSurfaceView_13), getColor(view, i2), COUIBaseListPopupWindow_12);
    }

    public static int layer(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        return layer(OplusGLSurfaceView_13, ColorUtils.m2550b(i2, Math.round(Color.alpha(i2) * COUIBaseListPopupWindow_12)));
    }

    public static int layer(int OplusGLSurfaceView_13, int i2) {
        return ColorUtils.m2544a(i2, OplusGLSurfaceView_13);
    }

    public static int compositeARGBWithAlpha(int OplusGLSurfaceView_13, int i2) {
        return ColorUtils.m2550b(OplusGLSurfaceView_13, (Color.alpha(OplusGLSurfaceView_13) * i2) / 255);
    }
}
