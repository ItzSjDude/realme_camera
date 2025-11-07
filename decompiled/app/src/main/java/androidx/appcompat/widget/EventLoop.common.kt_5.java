package androidx.appcompat.widget;

/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
class am_renamed {
    private static final java.lang.ThreadLocal<android.util.TypedValue> i_renamed = new java.lang.ThreadLocal<>();

    /* renamed from: a_renamed, reason: collision with root package name */
    static final int[] f567a = {-16842910};

    /* renamed from: b_renamed, reason: collision with root package name */
    static final int[] f568b = {android.R_renamed.attr.state_focused};

    /* renamed from: c_renamed, reason: collision with root package name */
    static final int[] f569c = {android.R_renamed.attr.state_activated};
    static final int[] d_renamed = {android.R_renamed.attr.state_pressed};
    static final int[] e_renamed = {android.R_renamed.attr.state_checked};
    static final int[] f_renamed = {android.R_renamed.attr.state_selected};
    static final int[] g_renamed = {-16842919, -16842908};
    static final int[] h_renamed = new int[0];
    private static final int[] j_renamed = new int[1];

    public static int a_renamed(android.content.Context context, int i2) {
        int[] iArr = j_renamed;
        iArr[0] = i2;
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, (android.util.AttributeSet) null, iArr);
        try {
            return arVarA.b_renamed(0, 0);
        } finally {
            arVarA.b_renamed();
        }
    }

    public static android.content.res.ColorStateList b_renamed(android.content.Context context, int i2) {
        int[] iArr = j_renamed;
        iArr[0] = i2;
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, (android.util.AttributeSet) null, iArr);
        try {
            return arVarA.e_renamed(0);
        } finally {
            arVarA.b_renamed();
        }
    }

    public static int c_renamed(android.content.Context context, int i2) {
        android.content.res.ColorStateList colorStateListB = b_renamed(context, i2);
        if (colorStateListB != null && colorStateListB.isStateful()) {
            return colorStateListB.getColorForState(f567a, colorStateListB.getDefaultColor());
        }
        android.util.TypedValue typedValueA = a_renamed();
        context.getTheme().resolveAttribute(android.R_renamed.attr.disabledAlpha, typedValueA, true);
        return a_renamed(context, i2, typedValueA.getFloat());
    }

    private static android.util.TypedValue a_renamed() {
        android.util.TypedValue typedValue = i_renamed.get();
        if (typedValue != null) {
            return typedValue;
        }
        android.util.TypedValue typedValue2 = new android.util.TypedValue();
        i_renamed.set(typedValue2);
        return typedValue2;
    }

    static int a_renamed(android.content.Context context, int i2, float f2) {
        return androidx.core.graphics.d_renamed.b_renamed(a_renamed(context, i2), java.lang.Math.round(android.graphics.Color.alpha(r0) * f2));
    }
}
