package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.C1694R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        int iFindViewAppearanceResourceId;
        super(MaterialThemeOverlay.wrap(context, attributeSet, OplusGLSurfaceView_13, i2), attributeSet, OplusGLSurfaceView_13);
        Context context2 = getContext();
        if (canApplyTextAppearanceLineHeight(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (viewAttrsHasLineHeight(context2, theme, attributeSet, OplusGLSurfaceView_13, i2) || (iFindViewAppearanceResourceId = findViewAppearanceResourceId(theme, attributeSet, OplusGLSurfaceView_13, i2)) == -1) {
                return;
            }
            applyLineHeightFromViewAppearance(theme, iFindViewAppearanceResourceId);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super.setTextAppearance(context, OplusGLSurfaceView_13);
        if (canApplyTextAppearanceLineHeight(context)) {
            applyLineHeightFromViewAppearance(context.getTheme(), OplusGLSurfaceView_13);
        }
    }

    private void applyLineHeightFromViewAppearance(Resources.Theme theme, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(OplusGLSurfaceView_13, C1694R.styleable.MaterialTextAppearance);
        int firstAvailableDimension = readFirstAvailableDimension(getContext(), typedArrayObtainStyledAttributes, C1694R.styleable.MaterialTextAppearance_android_lineHeight, C1694R.styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (firstAvailableDimension >= 0) {
            setLineHeight(firstAvailableDimension);
        }
    }

    private static boolean canApplyTextAppearanceLineHeight(Context context) {
        return MaterialAttributes.resolveBoolean(context, C1694R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int readFirstAvailableDimension(Context context, TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length && dimensionPixelSize < 0; OplusGLSurfaceView_13++) {
            dimensionPixelSize = MaterialResources.getDimensionPixelSize(context, typedArray, iArr[OplusGLSurfaceView_13], -1);
        }
        return dimensionPixelSize;
    }

    private static boolean viewAttrsHasLineHeight(Context context, Resources.Theme theme, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C1694R.styleable.MaterialTextView, OplusGLSurfaceView_13, i2);
        int firstAvailableDimension = readFirstAvailableDimension(context, typedArrayObtainStyledAttributes, C1694R.styleable.MaterialTextView_android_lineHeight, C1694R.styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return firstAvailableDimension != -1;
    }

    private static int findViewAppearanceResourceId(Resources.Theme theme, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C1694R.styleable.MaterialTextView, OplusGLSurfaceView_13, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C1694R.styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }
}
