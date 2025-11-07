package com.google.android.material.resources;

/* loaded from: classes.dex */
public class MaterialResources {
    private MaterialResources() {
    }

    public static android.content.res.ColorStateList getColorStateList(android.content.Context context, android.content.res.TypedArray typedArray, int i_renamed) {
        int color;
        int resourceId;
        android.content.res.ColorStateList colorStateListA;
        if (typedArray.hasValue(i_renamed) && (resourceId = typedArray.getResourceId(i_renamed, 0)) != 0 && (colorStateListA = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, resourceId)) != null) {
            return colorStateListA;
        }
        if (android.os.Build.VERSION.SDK_INT <= 15 && (color = typedArray.getColor(i_renamed, -1)) != -1) {
            return android.content.res.ColorStateList.valueOf(color);
        }
        return typedArray.getColorStateList(i_renamed);
    }

    public static android.content.res.ColorStateList getColorStateList(android.content.Context context, androidx.appcompat.widget.ar_renamed arVar, int i_renamed) {
        int iB;
        int iG;
        android.content.res.ColorStateList colorStateListA;
        if (arVar.g_renamed(i_renamed) && (iG = arVar.g_renamed(i_renamed, 0)) != 0 && (colorStateListA = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(context, iG)) != null) {
            return colorStateListA;
        }
        if (android.os.Build.VERSION.SDK_INT <= 15 && (iB = arVar.b_renamed(i_renamed, -1)) != -1) {
            return android.content.res.ColorStateList.valueOf(iB);
        }
        return arVar.e_renamed(i_renamed);
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, android.content.res.TypedArray typedArray, int i_renamed) {
        int resourceId;
        android.graphics.drawable.Drawable drawableB;
        return (!typedArray.hasValue(i_renamed) || (resourceId = typedArray.getResourceId(i_renamed, 0)) == 0 || (drawableB = androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, resourceId)) == null) ? typedArray.getDrawable(i_renamed) : drawableB;
    }

    public static com.google.android.material.resources.TextAppearance getTextAppearance(android.content.Context context, android.content.res.TypedArray typedArray, int i_renamed) {
        int resourceId;
        if (!typedArray.hasValue(i_renamed) || (resourceId = typedArray.getResourceId(i_renamed, 0)) == 0) {
            return null;
        }
        return new com.google.android.material.resources.TextAppearance(context, resourceId);
    }

    public static int getDimensionPixelSize(android.content.Context context, android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!typedArray.getValue(i_renamed, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i_renamed, i2);
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    static int getIndexWithValue(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        return typedArray.hasValue(i_renamed) ? i_renamed : i2;
    }
}
