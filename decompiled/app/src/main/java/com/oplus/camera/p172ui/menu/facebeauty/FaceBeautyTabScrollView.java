package com.oplus.camera.p172ui.menu.facebeauty;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* loaded from: classes2.dex */
public class FaceBeautyTabScrollView extends HorizontalScrollView {
    public FaceBeautyTabScrollView(Context context) {
        super(context);
    }

    public FaceBeautyTabScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FaceBeautyTabScrollView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (getChildCount() != 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = getChildAt(0).getMeasuredWidth();
            int iMax = Math.max(0, (measuredWidth - measuredWidth2) / 2);
            getChildAt(0).layout(iMax, 0, measuredWidth2 + iMax, getChildAt(0).getMeasuredHeight());
        }
    }
}
