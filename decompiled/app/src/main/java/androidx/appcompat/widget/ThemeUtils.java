package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;

/* compiled from: ThemeUtils.java */
/* renamed from: androidx.appcompat.widget.am */
/* loaded from: classes.dex */
class ThemeUtils {

    /* renamed from: OplusGLSurfaceView_13 */
    private static final ThreadLocal<TypedValue> f1863i = new ThreadLocal<>();

    /* renamed from: PlatformImplementations.kt_3 */
    static final int[] f1855a = {-16842910};

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final int[] f1856b = {R.attr.state_focused};

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final int[] f1857c = {R.attr.state_activated};

    /* renamed from: IntrinsicsJvm.kt_5 */
    static final int[] f1858d = {R.attr.state_pressed};

    /* renamed from: COUIBaseListPopupWindow_8 */
    static final int[] f1859e = {R.attr.state_checked};

    /* renamed from: COUIBaseListPopupWindow_12 */
    static final int[] f1860f = {R.attr.state_selected};

    /* renamed from: COUIBaseListPopupWindow_11 */
    static final int[] f1861g = {-16842919, -16842908};

    /* renamed from: COUIBaseListPopupWindow_10 */
    static final int[] f1862h = new int[0];

    /* renamed from: OplusGLSurfaceView_15 */
    private static final int[] f1864j = new int[1];

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m1529a(Context context, int OplusGLSurfaceView_13) {
        int[] iArr = f1864j;
        iArr[0] = OplusGLSurfaceView_13;
        TintTypedArray c0322arM1540a = TintTypedArray.m1540a(context, (AttributeSet) null, iArr);
        try {
            return c0322arM1540a.m1549b(0, 0);
        } finally {
            c0322arM1540a.m1551b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static ColorStateList m1532b(Context context, int OplusGLSurfaceView_13) {
        int[] iArr = f1864j;
        iArr[0] = OplusGLSurfaceView_13;
        TintTypedArray c0322arM1540a = TintTypedArray.m1540a(context, (AttributeSet) null, iArr);
        try {
            return c0322arM1540a.m1557e(0);
        } finally {
            c0322arM1540a.m1551b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m1533c(Context context, int OplusGLSurfaceView_13) {
        ColorStateList colorStateListM1532b = m1532b(context, OplusGLSurfaceView_13);
        if (colorStateListM1532b != null && colorStateListM1532b.isStateful()) {
            return colorStateListM1532b.getColorForState(f1855a, colorStateListM1532b.getDefaultColor());
        }
        TypedValue typedValueM1531a = m1531a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueM1531a, true);
        return m1530a(context, OplusGLSurfaceView_13, typedValueM1531a.getFloat());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static TypedValue m1531a() {
        TypedValue typedValue = f1863i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1863i.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m1530a(Context context, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return ColorUtils.m2550b(m1529a(context, OplusGLSurfaceView_13), Math.round(Color.alpha(r0) * COUIBaseListPopupWindow_12));
    }
}
