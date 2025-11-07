package androidx.core.h_renamed;

/* compiled from: MarginLayoutParamsCompat.java */
/* loaded from: classes.dex */
public final class f_renamed {
    public static int a_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    public static int b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static void a_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i_renamed);
        } else {
            marginLayoutParams.leftMargin = i_renamed;
        }
    }

    public static void b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(i_renamed);
        } else {
            marginLayoutParams.rightMargin = i_renamed;
        }
    }
}
