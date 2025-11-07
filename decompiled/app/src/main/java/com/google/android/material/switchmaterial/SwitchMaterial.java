package com.google.android.material.switchmaterial;

/* loaded from: classes.dex */
public class SwitchMaterial extends androidx.appcompat.widget.SwitchCompat {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{android.R_renamed.attr.state_enabled, android.R_renamed.attr.state_checked}, new int[]{android.R_renamed.attr.state_enabled, -16842912}, new int[]{-16842910, android.R_renamed.attr.state_checked}, new int[]{-16842910, -16842912}};
    private final com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider;
    private android.content.res.ColorStateList materialThemeColorsThumbTintList;
    private android.content.res.ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    public SwitchMaterial(android.content.Context context) {
        this(context, null);
    }

    public SwitchMaterial(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.switchStyle);
    }

    public SwitchMaterial(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        android.content.Context context2 = getContext();
        this.elevationOverlayProvider = new com.google.android.material.elevation.ElevationOverlayProvider(context2);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.SwitchMaterial, i_renamed, DEF_STYLE_RES, new int[0]);
        this.useMaterialThemeColors = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.useMaterialThemeColors && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z_renamed) {
        this.useMaterialThemeColors = z_renamed;
        if (z_renamed) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    private android.content.res.ColorStateList getMaterialThemeColorsThumbTintList() throws android.content.res.Resources.NotFoundException {
        if (this.materialThemeColorsThumbTintList == null) {
            int color = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorSurface);
            int color2 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorControlActivated);
            float dimension = getResources().getDimension(com.google.android.material.R_renamed.dimen.mtrl_switch_thumb_elevation);
            if (this.elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
                dimension += com.google.android.material.internal.ViewUtils.getParentAbsoluteElevation(this);
            }
            int iCompositeOverlayIfNeeded = this.elevationOverlayProvider.compositeOverlayIfNeeded(color, dimension);
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            iArr[0] = com.google.android.material.color.MaterialColors.layer(color, color2, 1.0f);
            iArr[1] = iCompositeOverlayIfNeeded;
            iArr[2] = com.google.android.material.color.MaterialColors.layer(color, color2, 0.38f);
            iArr[3] = iCompositeOverlayIfNeeded;
            this.materialThemeColorsThumbTintList = new android.content.res.ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsThumbTintList;
    }

    private android.content.res.ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList == null) {
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            int color = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorSurface);
            int color2 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorControlActivated);
            int color3 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R_renamed.attr.colorOnSurface);
            iArr[0] = com.google.android.material.color.MaterialColors.layer(color, color2, 0.54f);
            iArr[1] = com.google.android.material.color.MaterialColors.layer(color, color3, 0.32f);
            iArr[2] = com.google.android.material.color.MaterialColors.layer(color, color2, 0.12f);
            iArr[3] = com.google.android.material.color.MaterialColors.layer(color, color3, 0.12f);
            this.materialThemeColorsTrackTintList = new android.content.res.ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTrackTintList;
    }
}
