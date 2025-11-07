package com.google.android.material.internal;

/* loaded from: classes.dex */
public final class ThemeEnforcement {
    private static final java.lang.String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final java.lang.String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
    private static final int[] APPCOMPAT_CHECK_ATTRS = {com.google.android.material.R_renamed.attr.colorPrimary};
    private static final int[] MATERIAL_CHECK_ATTRS = {com.google.android.material.R_renamed.attr.colorPrimaryVariant};

    private ThemeEnforcement() {
    }

    public static android.content.res.TypedArray obtainStyledAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr, int i_renamed, int i2, int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i_renamed, i2);
        checkTextAppearance(context, attributeSet, iArr, i_renamed, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i_renamed, i2);
    }

    public static androidx.appcompat.widget.ar_renamed obtainTintedStyledAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr, int i_renamed, int i2, int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i_renamed, i2);
        checkTextAppearance(context, attributeSet, iArr, i_renamed, i2, iArr2);
        return androidx.appcompat.widget.ar_renamed.a_renamed(context, attributeSet, iArr, i_renamed, i2);
    }

    private static void checkCompatibleTheme(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.ThemeEnforcement, i_renamed, i2);
        boolean z_renamed = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z_renamed) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            if (!context.getTheme().resolveAttribute(com.google.android.material.R_renamed.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    private static void checkTextAppearance(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr, int i_renamed, int i2, int... iArr2) {
        boolean zIsCustomTextAppearanceValid;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.ThemeEnforcement, i_renamed, i2);
        if (!typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zIsCustomTextAppearanceValid = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zIsCustomTextAppearanceValid = isCustomTextAppearanceValid(context, attributeSet, iArr, i_renamed, i2, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zIsCustomTextAppearanceValid) {
            throw new java.lang.IllegalArgumentException("This component requires that you specify a_renamed valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a_renamed descendant).");
        }
    }

    private static boolean isCustomTextAppearanceValid(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr, int i_renamed, int i2, int... iArr2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i_renamed, i2);
        for (int i3 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i3, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static void checkAppCompatTheme(android.content.Context context) {
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    public static void checkMaterialTheme(android.content.Context context) {
        checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    public static boolean isAppCompatTheme(android.content.Context context) {
        return isTheme(context, APPCOMPAT_CHECK_ATTRS);
    }

    public static boolean isMaterialTheme(android.content.Context context) {
        return isTheme(context, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(android.content.Context context, int[] iArr) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i_renamed)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    private static void checkTheme(android.content.Context context, int[] iArr, java.lang.String str) {
        if (isTheme(context, iArr)) {
            return;
        }
        throw new java.lang.IllegalArgumentException("The style on_renamed this component requires your app theme to be_renamed " + str + " (or a_renamed descendant).");
    }
}
