package com.google.android.material.textview;

/* loaded from: classes.dex */
public class MaterialTextView extends androidx.appcompat.widget.AppCompatTextView {
    public MaterialTextView(android.content.Context context) {
        this(context, null);
    }

    public MaterialTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, android.R_renamed.attr.textViewStyle);
    }

    public MaterialTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public MaterialTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        int iFindViewAppearanceResourceId;
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, i2), attributeSet, i_renamed);
        android.content.Context context2 = getContext();
        if (canApplyTextAppearanceLineHeight(context2)) {
            android.content.res.Resources.Theme theme = context2.getTheme();
            if (viewAttrsHasLineHeight(context2, theme, attributeSet, i_renamed, i2) || (iFindViewAppearanceResourceId = findViewAppearanceResourceId(theme, attributeSet, i_renamed, i2)) == -1) {
                return;
            }
            applyLineHeightFromViewAppearance(theme, iFindViewAppearanceResourceId);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super.setTextAppearance(context, i_renamed);
        if (canApplyTextAppearanceLineHeight(context)) {
            applyLineHeightFromViewAppearance(context.getTheme(), i_renamed);
        }
    }

    private void applyLineHeightFromViewAppearance(android.content.res.Resources.Theme theme, int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i_renamed, com.google.android.material.R_renamed.styleable.MaterialTextAppearance);
        int firstAvailableDimension = readFirstAvailableDimension(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialTextAppearance_android_lineHeight, com.google.android.material.R_renamed.styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (firstAvailableDimension >= 0) {
            setLineHeight(firstAvailableDimension);
        }
    }

    private static boolean canApplyTextAppearanceLineHeight(android.content.Context context) {
        return com.google.android.material.resources.MaterialAttributes.resolveBoolean(context, com.google.android.material.R_renamed.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int readFirstAvailableDimension(android.content.Context context, android.content.res.TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int i_renamed = 0; i_renamed < iArr.length && dimensionPixelSize < 0; i_renamed++) {
            dimensionPixelSize = com.google.android.material.resources.MaterialResources.getDimensionPixelSize(context, typedArray, iArr[i_renamed], -1);
        }
        return dimensionPixelSize;
    }

    private static boolean viewAttrsHasLineHeight(android.content.Context context, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.MaterialTextView, i_renamed, i2);
        int firstAvailableDimension = readFirstAvailableDimension(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialTextView_android_lineHeight, com.google.android.material.R_renamed.styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return firstAvailableDimension != -1;
    }

    private static int findViewAppearanceResourceId(android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.MaterialTextView, i_renamed, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }
}
