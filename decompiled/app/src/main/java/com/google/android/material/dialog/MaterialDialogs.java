package com.google.android.material.dialog;

/* loaded from: classes.dex */
public class MaterialDialogs {
    private MaterialDialogs() {
    }

    public static android.graphics.drawable.InsetDrawable insetDrawable(android.graphics.drawable.Drawable drawable, android.graphics.Rect rect) {
        return new android.graphics.drawable.InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }

    public static android.graphics.Rect getDialogBackgroundInsets(android.content.Context context, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, null, com.google.android.material.R_renamed.styleable.MaterialAlertDialog, i_renamed, i2, new int[0]);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        if (android.os.Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new android.graphics.Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }
}
