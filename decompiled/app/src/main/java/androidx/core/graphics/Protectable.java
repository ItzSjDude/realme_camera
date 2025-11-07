package androidx.core.graphics;

/* compiled from: BlendModeUtils.java */
/* loaded from: classes.dex */
class c_renamed {
    static android.graphics.BlendMode a_renamed(androidx.core.graphics.b_renamed bVar) {
        switch (bVar) {
            case CLEAR:
                return android.graphics.BlendMode.CLEAR;
            case SRC:
                return android.graphics.BlendMode.SRC;
            case DST:
                return android.graphics.BlendMode.DST;
            case SRC_OVER:
                return android.graphics.BlendMode.SRC_OVER;
            case DST_OVER:
                return android.graphics.BlendMode.DST_OVER;
            case SRC_IN:
                return android.graphics.BlendMode.SRC_IN;
            case DST_IN:
                return android.graphics.BlendMode.DST_IN;
            case SRC_OUT:
                return android.graphics.BlendMode.SRC_OUT;
            case DST_OUT:
                return android.graphics.BlendMode.DST_OUT;
            case SRC_ATOP:
                return android.graphics.BlendMode.SRC_ATOP;
            case DST_ATOP:
                return android.graphics.BlendMode.DST_ATOP;
            case XOR:
                return android.graphics.BlendMode.XOR;
            case PLUS:
                return android.graphics.BlendMode.PLUS;
            case MODULATE:
                return android.graphics.BlendMode.MODULATE;
            case SCREEN:
                return android.graphics.BlendMode.SCREEN;
            case OVERLAY:
                return android.graphics.BlendMode.OVERLAY;
            case DARKEN:
                return android.graphics.BlendMode.DARKEN;
            case LIGHTEN:
                return android.graphics.BlendMode.LIGHTEN;
            case COLOR_DODGE:
                return android.graphics.BlendMode.COLOR_DODGE;
            case COLOR_BURN:
                return android.graphics.BlendMode.COLOR_BURN;
            case HARD_LIGHT:
                return android.graphics.BlendMode.HARD_LIGHT;
            case SOFT_LIGHT:
                return android.graphics.BlendMode.SOFT_LIGHT;
            case DIFFERENCE:
                return android.graphics.BlendMode.DIFFERENCE;
            case EXCLUSION:
                return android.graphics.BlendMode.EXCLUSION;
            case MULTIPLY:
                return android.graphics.BlendMode.MULTIPLY;
            case HUE:
                return android.graphics.BlendMode.HUE;
            case SATURATION:
                return android.graphics.BlendMode.SATURATION;
            case COLOR:
                return android.graphics.BlendMode.COLOR;
            case LUMINOSITY:
                return android.graphics.BlendMode.LUMINOSITY;
            default:
                return null;
        }
    }

    static android.graphics.PorterDuff.Mode b_renamed(androidx.core.graphics.b_renamed bVar) {
        if (bVar == null) {
            return null;
        }
        switch (bVar) {
            case CLEAR:
                return android.graphics.PorterDuff.Mode.CLEAR;
            case SRC:
                return android.graphics.PorterDuff.Mode.SRC;
            case DST:
                return android.graphics.PorterDuff.Mode.DST;
            case SRC_OVER:
                return android.graphics.PorterDuff.Mode.SRC_OVER;
            case DST_OVER:
                return android.graphics.PorterDuff.Mode.DST_OVER;
            case SRC_IN:
                return android.graphics.PorterDuff.Mode.SRC_IN;
            case DST_IN:
                return android.graphics.PorterDuff.Mode.DST_IN;
            case SRC_OUT:
                return android.graphics.PorterDuff.Mode.SRC_OUT;
            case DST_OUT:
                return android.graphics.PorterDuff.Mode.DST_OUT;
            case SRC_ATOP:
                return android.graphics.PorterDuff.Mode.SRC_ATOP;
            case DST_ATOP:
                return android.graphics.PorterDuff.Mode.DST_ATOP;
            case XOR:
                return android.graphics.PorterDuff.Mode.XOR;
            case PLUS:
                return android.graphics.PorterDuff.Mode.ADD;
            case MODULATE:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case SCREEN:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case OVERLAY:
                return android.graphics.PorterDuff.Mode.OVERLAY;
            case DARKEN:
                return android.graphics.PorterDuff.Mode.DARKEN;
            case LIGHTEN:
                return android.graphics.PorterDuff.Mode.LIGHTEN;
            default:
                return null;
        }
    }
}
