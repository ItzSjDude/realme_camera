package com.google.android.material.radiobutton;

/* loaded from: classes.dex */
public class MaterialRadioButton extends androidx.appcompat.widget.q_renamed {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_CompoundButton_RadioButton;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{android.R_renamed.attr.state_enabled, android.R_renamed.attr.state_checked}, new int[]{android.R_renamed.attr.state_enabled, -16842912}, new int[]{-16842910, android.R_renamed.attr.state_checked}, new int[]{-16842910, -16842912}};
    private android.content.res.ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    public MaterialRadioButton(android.content.Context context) {
        this(context, null);
    }

    public MaterialRadioButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.radioButtonStyle);
    }

    public MaterialRadioButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R_renamed.styleable.MaterialRadioButton, i_renamed, DEF_STYLE_RES, new int[0]);
        this.useMaterialThemeColors = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.MaterialRadioButton_useMaterialThemeColors, false);
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
            int color = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorControlActivated);
            int color2 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorOnSurface);
            int color3 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorSurface);
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            iArr[0] = com.google.android.material.color.MaterialColors.layer(color3, color, 1.0f);
            iArr[1] = com.google.android.material.color.MaterialColors.layer(color3, color2, 0.54f);
            iArr[2] = com.google.android.material.color.MaterialColors.layer(color3, color2, 0.38f);
            iArr[3] = com.google.android.material.color.MaterialColors.layer(color3, color2, 0.38f);
            this.materialThemeColorsTintList = new android.content.res.ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTintList;
    }
}
