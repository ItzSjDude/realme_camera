package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.C1694R;

/* loaded from: classes.dex */
public final class ThemeEnforcement {
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
    private static final int[] APPCOMPAT_CHECK_ATTRS = {C1694R.attr.colorPrimary};
    private static final int[] MATERIAL_CHECK_ATTRS = {C1694R.attr.colorPrimaryVariant};

    private ThemeEnforcement() {
    }

    public static TypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int OplusGLSurfaceView_13, int i2, int... iArr2) {
        checkCompatibleTheme(context, attributeSet, OplusGLSurfaceView_13, i2);
        checkTextAppearance(context, attributeSet, iArr, OplusGLSurfaceView_13, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, OplusGLSurfaceView_13, i2);
    }

    public static TintTypedArray obtainTintedStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int OplusGLSurfaceView_13, int i2, int... iArr2) {
        checkCompatibleTheme(context, attributeSet, OplusGLSurfaceView_13, i2);
        checkTextAppearance(context, attributeSet, iArr, OplusGLSurfaceView_13, i2, iArr2);
        return TintTypedArray.m1541a(context, attributeSet, iArr, OplusGLSurfaceView_13, i2);
    }

    private static void checkCompatibleTheme(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1694R.styleable.ThemeEnforcement, OplusGLSurfaceView_13, i2);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(C1694R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    private static void checkTextAppearance(Context context, AttributeSet attributeSet, int[] iArr, int OplusGLSurfaceView_13, int i2, int... iArr2) {
        boolean zIsCustomTextAppearanceValid;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1694R.styleable.ThemeEnforcement, OplusGLSurfaceView_13, i2);
        if (!typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zIsCustomTextAppearanceValid = typedArrayObtainStyledAttributes.getResourceId(C1694R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zIsCustomTextAppearanceValid = isCustomTextAppearanceValid(context, attributeSet, iArr, OplusGLSurfaceView_13, i2, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zIsCustomTextAppearanceValid) {
            throw new IllegalArgumentException("This component requires that you specify PlatformImplementations.kt_3 valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or PlatformImplementations.kt_3 descendant).");
        }
    }

    private static boolean isCustomTextAppearanceValid(Context context, AttributeSet attributeSet, int[] iArr, int OplusGLSurfaceView_13, int i2, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, OplusGLSurfaceView_13, i2);
        for (int i3 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i3, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static void checkAppCompatTheme(Context context) {
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    public static void checkMaterialTheme(Context context) {
        checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    public static boolean isAppCompatTheme(Context context) {
        return isTheme(context, APPCOMPAT_CHECK_ATTRS);
    }

    public static boolean isMaterialTheme(Context context) {
        return isTheme(context, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            if (!typedArrayObtainStyledAttributes.hasValue(OplusGLSurfaceView_13)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    private static void checkTheme(Context context, int[] iArr, String str) {
        if (isTheme(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or PlatformImplementations.kt_3 descendant).");
    }
}
