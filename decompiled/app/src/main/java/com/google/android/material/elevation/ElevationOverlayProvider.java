package com.google.android.material.elevation;

/* loaded from: classes.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(android.content.Context context) {
        this.elevationOverlayEnabled = com.google.android.material.resources.MaterialAttributes.resolveBoolean(context, com.google.android.material.R_renamed.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = com.google.android.material.color.MaterialColors.getColor(context, com.google.android.material.R_renamed.attr.elevationOverlayColor, 0);
        this.colorSurface = com.google.android.material.color.MaterialColors.getColor(context, com.google.android.material.R_renamed.attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f_renamed, android.view.View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f_renamed + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f_renamed) {
        return compositeOverlayIfNeeded(this.colorSurface, f_renamed);
    }

    public int compositeOverlayIfNeeded(int i_renamed, float f_renamed, android.view.View view) {
        return compositeOverlayIfNeeded(i_renamed, f_renamed + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayIfNeeded(int i_renamed, float f_renamed) {
        return (this.elevationOverlayEnabled && isThemeSurfaceColor(i_renamed)) ? compositeOverlay(i_renamed, f_renamed) : i_renamed;
    }

    public int compositeOverlay(int i_renamed, float f_renamed, android.view.View view) {
        return compositeOverlay(i_renamed, f_renamed + getParentAbsoluteElevation(view));
    }

    public int compositeOverlay(int i_renamed, float f_renamed) {
        float fCalculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f_renamed);
        return androidx.core.graphics.d_renamed.b_renamed(com.google.android.material.color.MaterialColors.layer(androidx.core.graphics.d_renamed.b_renamed(i_renamed, 255), this.elevationOverlayColor, fCalculateOverlayAlphaFraction), android.graphics.Color.alpha(i_renamed));
    }

    public int calculateOverlayAlpha(float f_renamed) {
        return java.lang.Math.round(calculateOverlayAlphaFraction(f_renamed) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float f_renamed) {
        if (this.displayDensity <= 0.0f || f_renamed <= 0.0f) {
            return 0.0f;
        }
        return java.lang.Math.min(((((float) java.lang.Math.log1p(f_renamed / r2)) * FORMULA_MULTIPLIER) + FORMULA_OFFSET) / 100.0f, 1.0f);
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public float getParentAbsoluteElevation(android.view.View view) {
        return com.google.android.material.internal.ViewUtils.getParentAbsoluteElevation(view);
    }

    private boolean isThemeSurfaceColor(int i_renamed) {
        return androidx.core.graphics.d_renamed.b_renamed(i_renamed, 255) == this.colorSurface;
    }
}
