package com.coui.appcompat.p099a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;

/* compiled from: COUIThemeUtils.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.u */
/* loaded from: classes.dex */
public class COUIThemeUtils {

    /* renamed from: OplusGLSurfaceView_13 */
    private static final ThreadLocal<TypedValue> f6361i = new ThreadLocal<>();

    /* renamed from: PlatformImplementations.kt_3 */
    static final int[] f6353a = {-16842910};

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final int[] f6354b = {R.attr.state_focused};

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final int[] f6355c = {R.attr.state_activated};

    /* renamed from: IntrinsicsJvm.kt_5 */
    static final int[] f6356d = {R.attr.state_pressed};

    /* renamed from: COUIBaseListPopupWindow_8 */
    static final int[] f6357e = {R.attr.state_checked};

    /* renamed from: COUIBaseListPopupWindow_12 */
    static final int[] f6358f = {R.attr.state_selected};

    /* renamed from: COUIBaseListPopupWindow_11 */
    static final int[] f6359g = {-16842919, -16842908};

    /* renamed from: COUIBaseListPopupWindow_10 */
    static final int[] f6360h = new int[0];

    /* renamed from: OplusGLSurfaceView_15 */
    private static final int[] f6362j = new int[1];

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6483a(Context context, int OplusGLSurfaceView_13) {
        int[] iArr = f6362j;
        iArr[0] = OplusGLSurfaceView_13;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static ColorStateList m6486b(Context context, int OplusGLSurfaceView_13) {
        int[] iArr = f6362j;
        iArr[0] = OplusGLSurfaceView_13;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColorStateList(0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m6487c(Context context, int OplusGLSurfaceView_13) {
        ColorStateList colorStateListM6486b = m6486b(context, OplusGLSurfaceView_13);
        if (colorStateListM6486b != null && colorStateListM6486b.isStateful()) {
            return colorStateListM6486b.getColorForState(f6353a, colorStateListM6486b.getDefaultColor());
        }
        TypedValue typedValueM6485a = m6485a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueM6485a, true);
        return m6484a(context, OplusGLSurfaceView_13, typedValueM6485a.getFloat());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static TypedValue m6485a() {
        TypedValue typedValue = f6361i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f6361i.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m6484a(Context context, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return ColorUtils.m2550b(m6483a(context, OplusGLSurfaceView_13), Math.round(Color.alpha(r0) * COUIBaseListPopupWindow_12));
    }
}
