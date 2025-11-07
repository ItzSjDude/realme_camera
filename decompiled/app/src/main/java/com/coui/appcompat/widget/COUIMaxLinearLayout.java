package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIMaxLinearLayout extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f7471a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f7472b;

    public COUIMaxLinearLayout(Context context) {
        super(context);
    }

    public COUIMaxLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIMaxLinearLayout);
        this.f7471a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIMaxLinearLayout_maxWidth, 0);
        this.f7472b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIMaxLinearLayout_maxHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        boolean z;
        super.onMeasure(OplusGLSurfaceView_13, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i3 = this.f7471a;
        if (i3 == 0 || measuredWidth <= i3) {
            z = false;
        } else {
            OplusGLSurfaceView_13 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            z = true;
        }
        int i4 = this.f7472b;
        if (measuredHeight > i4) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            z = true;
        }
        if (z) {
            super.onMeasure(OplusGLSurfaceView_13, i2);
        }
    }
}
