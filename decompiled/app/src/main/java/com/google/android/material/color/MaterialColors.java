package com.google.android.material.color;

/* loaded from: classes.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    public static int getColor(android.view.View view, int i_renamed) {
        return com.google.android.material.resources.MaterialAttributes.resolveOrThrow(view, i_renamed);
    }

    public static int getColor(android.content.Context context, int i_renamed, java.lang.String str) {
        return com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, i_renamed, str);
    }

    public static int getColor(android.view.View view, int i_renamed, int i2) {
        return getColor(view.getContext(), i_renamed, i2);
    }

    public static int getColor(android.content.Context context, int i_renamed, int i2) {
        android.util.TypedValue typedValueResolve = com.google.android.material.resources.MaterialAttributes.resolve(context, i_renamed);
        return typedValueResolve != null ? typedValueResolve.data : i2;
    }

    public static int layer(android.view.View view, int i_renamed, int i2) {
        return layer(view, i_renamed, i2, 1.0f);
    }

    public static int layer(android.view.View view, int i_renamed, int i2, float f_renamed) {
        return layer(getColor(view, i_renamed), getColor(view, i2), f_renamed);
    }

    public static int layer(int i_renamed, int i2, float f_renamed) {
        return layer(i_renamed, androidx.core.graphics.d_renamed.b_renamed(i2, java.lang.Math.round(android.graphics.Color.alpha(i2) * f_renamed)));
    }

    public static int layer(int i_renamed, int i2) {
        return androidx.core.graphics.d_renamed.a_renamed(i2, i_renamed);
    }

    public static int compositeARGBWithAlpha(int i_renamed, int i2) {
        return androidx.core.graphics.d_renamed.b_renamed(i_renamed, (android.graphics.Color.alpha(i_renamed) * i2) / 255);
    }
}
