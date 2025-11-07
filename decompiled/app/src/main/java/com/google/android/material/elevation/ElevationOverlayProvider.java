package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.C1694R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(context, C1694R.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = MaterialColors.getColor(context, C1694R.attr.elevationOverlayColor, 0);
        this.colorSurface = MaterialColors.getColor(context, C1694R.attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float COUIBaseListPopupWindow_12, View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(COUIBaseListPopupWindow_12 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float COUIBaseListPopupWindow_12) {
        return compositeOverlayIfNeeded(this.colorSurface, COUIBaseListPopupWindow_12);
    }

    public int compositeOverlayIfNeeded(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, View view) {
        return compositeOverlayIfNeeded(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayIfNeeded(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return (this.elevationOverlayEnabled && isThemeSurfaceColor(OplusGLSurfaceView_13)) ? compositeOverlay(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12) : OplusGLSurfaceView_13;
    }

    public int compositeOverlay(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, View view) {
        return compositeOverlay(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlay(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float fCalculateOverlayAlphaFraction = calculateOverlayAlphaFraction(COUIBaseListPopupWindow_12);
        return ColorUtils.m2550b(MaterialColors.layer(ColorUtils.m2550b(OplusGLSurfaceView_13, 255), this.elevationOverlayColor, fCalculateOverlayAlphaFraction), Color.alpha(OplusGLSurfaceView_13));
    }

    public int calculateOverlayAlpha(float COUIBaseListPopupWindow_12) {
        return Math.round(calculateOverlayAlphaFraction(COUIBaseListPopupWindow_12) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float COUIBaseListPopupWindow_12) {
        if (this.displayDensity <= 0.0f || COUIBaseListPopupWindow_12 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(COUIBaseListPopupWindow_12 / r2)) * FORMULA_MULTIPLIER) + FORMULA_OFFSET) / 100.0f, 1.0f);
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

    public float getParentAbsoluteElevation(View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    private boolean isThemeSurfaceColor(int OplusGLSurfaceView_13) {
        return ColorUtils.m2550b(OplusGLSurfaceView_13, 255) == this.colorSurface;
    }
}
