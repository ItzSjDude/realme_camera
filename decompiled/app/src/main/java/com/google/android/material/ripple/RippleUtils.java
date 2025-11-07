package com.google.android.material.ripple;

/* loaded from: classes.dex */
public class RippleUtils {
    private static final int[] ENABLED_PRESSED_STATE_SET;
    private static final int[] FOCUSED_STATE_SET;
    private static final int[] HOVERED_FOCUSED_STATE_SET;
    private static final int[] HOVERED_STATE_SET;
    static final java.lang.String LOG_TAG;
    private static final int[] PRESSED_STATE_SET;
    private static final int[] SELECTED_FOCUSED_STATE_SET;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET;
    private static final int[] SELECTED_HOVERED_STATE_SET;
    private static final int[] SELECTED_PRESSED_STATE_SET;
    private static final int[] SELECTED_STATE_SET;
    static final java.lang.String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a_renamed non-transparent color for the default color as_renamed it will be_renamed used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE;

    static {
        USE_FRAMEWORK_RIPPLE = android.os.Build.VERSION.SDK_INT >= 21;
        PRESSED_STATE_SET = new int[]{android.R_renamed.attr.state_pressed};
        HOVERED_FOCUSED_STATE_SET = new int[]{android.R_renamed.attr.state_hovered, android.R_renamed.attr.state_focused};
        FOCUSED_STATE_SET = new int[]{android.R_renamed.attr.state_focused};
        HOVERED_STATE_SET = new int[]{android.R_renamed.attr.state_hovered};
        SELECTED_PRESSED_STATE_SET = new int[]{android.R_renamed.attr.state_selected, android.R_renamed.attr.state_pressed};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{android.R_renamed.attr.state_selected, android.R_renamed.attr.state_hovered, android.R_renamed.attr.state_focused};
        SELECTED_FOCUSED_STATE_SET = new int[]{android.R_renamed.attr.state_selected, android.R_renamed.attr.state_focused};
        SELECTED_HOVERED_STATE_SET = new int[]{android.R_renamed.attr.state_selected, android.R_renamed.attr.state_hovered};
        SELECTED_STATE_SET = new int[]{android.R_renamed.attr.state_selected};
        ENABLED_PRESSED_STATE_SET = new int[]{android.R_renamed.attr.state_enabled, android.R_renamed.attr.state_pressed};
        LOG_TAG = com.google.android.material.ripple.RippleUtils.class.getSimpleName();
    }

    private RippleUtils() {
    }

    public static android.content.res.ColorStateList convertToRippleDrawableColor(android.content.res.ColorStateList colorStateList) {
        if (USE_FRAMEWORK_RIPPLE) {
            return new android.content.res.ColorStateList(new int[][]{SELECTED_STATE_SET, android.util.StateSet.NOTHING}, new int[]{getColorForState(colorStateList, SELECTED_PRESSED_STATE_SET), getColorForState(colorStateList, PRESSED_STATE_SET)});
        }
        int[] iArr = SELECTED_PRESSED_STATE_SET;
        int[] iArr2 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] iArr3 = SELECTED_FOCUSED_STATE_SET;
        int[] iArr4 = SELECTED_HOVERED_STATE_SET;
        int[] iArr5 = PRESSED_STATE_SET;
        int[] iArr6 = HOVERED_FOCUSED_STATE_SET;
        int[] iArr7 = FOCUSED_STATE_SET;
        int[] iArr8 = HOVERED_STATE_SET;
        return new android.content.res.ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, SELECTED_STATE_SET, iArr5, iArr6, iArr7, iArr8, android.util.StateSet.NOTHING}, new int[]{getColorForState(colorStateList, iArr), getColorForState(colorStateList, iArr2), getColorForState(colorStateList, iArr3), getColorForState(colorStateList, iArr4), 0, getColorForState(colorStateList, iArr5), getColorForState(colorStateList, iArr6), getColorForState(colorStateList, iArr7), getColorForState(colorStateList, iArr8), 0});
    }

    public static android.content.res.ColorStateList sanitizeRippleDrawableColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (android.os.Build.VERSION.SDK_INT >= 22 && android.os.Build.VERSION.SDK_INT <= 27 && android.graphics.Color.alpha(colorStateList.getDefaultColor()) == 0 && android.graphics.Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0) {
                android.util.Log.w_renamed(LOG_TAG, TRANSPARENT_DEFAULT_COLOR_WARNING);
            }
            return colorStateList;
        }
        return android.content.res.ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(int[] iArr) {
        boolean z_renamed = false;
        boolean z2 = false;
        for (int i_renamed : iArr) {
            if (i_renamed == 16842910) {
                z_renamed = true;
            } else if (i_renamed == 16842908 || i_renamed == 16842919 || i_renamed == 16843623) {
                z2 = true;
            }
        }
        return z_renamed && z2;
    }

    private static int getColorForState(android.content.res.ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return USE_FRAMEWORK_RIPPLE ? doubleAlpha(colorForState) : colorForState;
    }

    @android.annotation.TargetApi(21)
    private static int doubleAlpha(int i_renamed) {
        return androidx.core.graphics.d_renamed.b_renamed(i_renamed, java.lang.Math.min(android.graphics.Color.alpha(i_renamed) * 2, 255));
    }
}
