package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIMaxHeightScrollView extends ScrollView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f7470a;

    public COUIMaxHeightScrollView(Context context) {
        this(context, null);
    }

    public COUIMaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIMaxHeightScrollView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIMaxHeightScrollView);
        this.f7470a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.COUIMaxHeightScrollView_scrollViewMaxHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f7470a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, size), Integer.MIN_VALUE);
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    public void setMaxHeight(int OplusGLSurfaceView_13) {
        this.f7470a = OplusGLSurfaceView_13;
        requestLayout();
    }
}
