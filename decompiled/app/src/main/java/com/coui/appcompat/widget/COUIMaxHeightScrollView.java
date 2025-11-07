package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIMaxHeightScrollView extends android.widget.ScrollView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2780a;

    public COUIMaxHeightScrollView(android.content.Context context) {
        this(context, null);
    }

    public COUIMaxHeightScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIMaxHeightScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIMaxHeightScrollView);
        this.f2780a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R_renamed.styleable.COUIMaxHeightScrollView_scrollViewMaxHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i2);
        int i3 = this.f2780a;
        if (i3 > 0) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(i3, size), Integer.MIN_VALUE);
        }
        super.onMeasure(i_renamed, i2);
    }

    public void setMaxHeight(int i_renamed) {
        this.f2780a = i_renamed;
        requestLayout();
    }
}
