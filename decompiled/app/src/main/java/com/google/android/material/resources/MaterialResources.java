package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

/* loaded from: classes.dex */
public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int OplusGLSurfaceView_13) {
        int color;
        int resourceId;
        ColorStateList colorStateListM729a;
        if (typedArray.hasValue(OplusGLSurfaceView_13) && (resourceId = typedArray.getResourceId(OplusGLSurfaceView_13, 0)) != 0 && (colorStateListM729a = AppCompatResources.m729a(context, resourceId)) != null) {
            return colorStateListM729a;
        }
        if (Build.VERSION.SDK_INT <= 15 && (color = typedArray.getColor(OplusGLSurfaceView_13, -1)) != -1) {
            return ColorStateList.valueOf(color);
        }
        return typedArray.getColorStateList(OplusGLSurfaceView_13);
    }

    public static ColorStateList getColorStateList(Context context, TintTypedArray c0322ar, int OplusGLSurfaceView_13) {
        int iM1549b;
        int iM1560g;
        ColorStateList colorStateListM729a;
        if (c0322ar.m1561g(OplusGLSurfaceView_13) && (iM1560g = c0322ar.m1560g(OplusGLSurfaceView_13, 0)) != 0 && (colorStateListM729a = AppCompatResources.m729a(context, iM1560g)) != null) {
            return colorStateListM729a;
        }
        if (Build.VERSION.SDK_INT <= 15 && (iM1549b = c0322ar.m1549b(OplusGLSurfaceView_13, -1)) != -1) {
            return ColorStateList.valueOf(iM1549b);
        }
        return c0322ar.m1557e(OplusGLSurfaceView_13);
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int OplusGLSurfaceView_13) {
        int resourceId;
        Drawable drawableM732b;
        return (!typedArray.hasValue(OplusGLSurfaceView_13) || (resourceId = typedArray.getResourceId(OplusGLSurfaceView_13, 0)) == 0 || (drawableM732b = AppCompatResources.m732b(context, resourceId)) == null) ? typedArray.getDrawable(OplusGLSurfaceView_13) : drawableM732b;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int OplusGLSurfaceView_13) {
        int resourceId;
        if (!typedArray.hasValue(OplusGLSurfaceView_13) || (resourceId = typedArray.getResourceId(OplusGLSurfaceView_13, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(OplusGLSurfaceView_13, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(OplusGLSurfaceView_13, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    static int getIndexWithValue(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        return typedArray.hasValue(OplusGLSurfaceView_13) ? OplusGLSurfaceView_13 : i2;
    }
}
