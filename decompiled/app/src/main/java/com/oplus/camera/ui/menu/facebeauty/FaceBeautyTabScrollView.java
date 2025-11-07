package com.oplus.camera.ui.menu.facebeauty;

/* loaded from: classes2.dex */
public class FaceBeautyTabScrollView extends android.widget.HorizontalScrollView {
    public FaceBeautyTabScrollView(android.content.Context context) {
        super(context);
    }

    public FaceBeautyTabScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FaceBeautyTabScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        if (getChildCount() != 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = getChildAt(0).getMeasuredWidth();
            int iMax = java.lang.Math.max(0, (measuredWidth - measuredWidth2) / 2);
            getChildAt(0).layout(iMax, 0, measuredWidth2 + iMax, getChildAt(0).getMeasuredHeight());
        }
    }
}
