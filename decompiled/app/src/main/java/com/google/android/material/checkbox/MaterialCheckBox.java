package com.google.android.material.checkbox;

/* loaded from: classes.dex */
public class MaterialCheckBox extends androidx.appcompat.widget.AppCompatCheckBox {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{android.R_renamed.attr.state_enabled, android.R_renamed.attr.state_checked}, new int[]{android.R_renamed.attr.state_enabled, -16842912}, new int[]{-16842910, android.R_renamed.attr.state_checked}, new int[]{-16842910, -16842912}};
    private android.content.res.ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    public MaterialCheckBox(android.content.Context context) {
        this(context, null);
    }

    public MaterialCheckBox(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.checkboxStyle);
    }

    public MaterialCheckBox(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        android.content.Context context2 = getContext();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.MaterialCheckBox, i_renamed, DEF_STYLE_RES, new int[0]);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.MaterialCheckBox_buttonTint)) {
            androidx.core.widget.c_renamed.a_renamed(this, com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialCheckBox_buttonTint));
        }
        this.useMaterialThemeColors = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && androidx.core.widget.c_renamed.a_renamed(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z_renamed) {
        this.useMaterialThemeColors = z_renamed;
        if (z_renamed) {
            androidx.core.widget.c_renamed.a_renamed(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c_renamed.a_renamed(this, (android.content.res.ColorStateList) null);
        }
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    private android.content.res.ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            int color = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorControlActivated);
            int color2 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorSurface);
            int color3 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorOnSurface);
            iArr[0] = com.google.android.material.color.MaterialColors.layer(color2, color, 1.0f);
            iArr[1] = com.google.android.material.color.MaterialColors.layer(color2, color3, 0.54f);
            iArr[2] = com.google.android.material.color.MaterialColors.layer(color2, color3, 0.38f);
            iArr[3] = com.google.android.material.color.MaterialColors.layer(color2, color3, 0.38f);
            this.materialThemeColorsTintList = new android.content.res.ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTintList;
    }
}
