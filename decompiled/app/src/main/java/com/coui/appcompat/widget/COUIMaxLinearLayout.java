package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIMaxLinearLayout extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2781a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2782b;

    public COUIMaxLinearLayout(android.content.Context context) {
        super(context);
    }

    public COUIMaxLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIMaxLinearLayout);
        this.f2781a = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIMaxLinearLayout_maxWidth, 0);
        this.f2782b = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIMaxLinearLayout_maxHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        boolean z_renamed;
        super.onMeasure(i_renamed, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i3 = this.f2781a;
        if (i3 == 0 || measuredWidth <= i3) {
            z_renamed = false;
        } else {
            i_renamed = android.view.View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            z_renamed = true;
        }
        int i4 = this.f2782b;
        if (measuredHeight > i4) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            z_renamed = true;
        }
        if (z_renamed) {
            super.onMeasure(i_renamed, i2);
        }
    }
}
