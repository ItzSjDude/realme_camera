package com.google.android.material.internal;

/* loaded from: classes.dex */
public class FlowLayout extends android.view.ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(android.content.Context context) {
        this(context, null);
    }

    public FlowLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    @android.annotation.TargetApi(21)
    public FlowLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    private void loadFromAttributes(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.FlowLayout, 0, 0);
        this.lineSpacing = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    protected void setLineSpacing(int i_renamed) {
        this.lineSpacing = i_renamed;
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    protected void setItemSpacing(int i_renamed) {
        this.itemSpacing = i_renamed;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    public void setSingleLine(boolean z_renamed) {
        this.singleLine = z_renamed;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int i3;
        int i4;
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i5 - getPaddingRight();
        int i6 = paddingLeft;
        int i7 = paddingTop;
        int i8 = i7;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            android.view.View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i_renamed, i2);
                android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                    android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
                    i3 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                int i11 = i6;
                if (i6 + i3 + childAt.getMeasuredWidth() > paddingRight && !isSingleLine()) {
                    int paddingLeft2 = getPaddingLeft();
                    i8 = this.lineSpacing + i7;
                    i11 = paddingLeft2;
                }
                int measuredWidth = i11 + i3 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                int measuredWidth2 = i11 + i3 + i4 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i10 == getChildCount() - 1) {
                    i9 += i4;
                }
                i7 = measuredHeight;
                i6 = measuredWidth2;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i9 + getPaddingRight()), getMeasuredDimension(size2, mode2, i7 + getPaddingBottom()));
    }

    private static int getMeasuredDimension(int i_renamed, int i2, int i3) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 1073741824 ? i3 : i_renamed;
        }
        return java.lang.Math.min(i3, i_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int iB;
        int iA;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        boolean z2 = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i5 = (i3 - i_renamed) - paddingLeft;
        int measuredWidth = paddingRight;
        int i6 = paddingTop;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            android.view.View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(com.google.android.material.R_renamed.id_renamed.row_index_key, -1);
            } else {
                android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                    android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
                    iA = androidx.core.h_renamed.f_renamed.a_renamed(marginLayoutParams);
                    iB = androidx.core.h_renamed.f_renamed.b_renamed(marginLayoutParams);
                } else {
                    iB = 0;
                    iA = 0;
                }
                int measuredWidth2 = measuredWidth + iA + childAt.getMeasuredWidth();
                if (!this.singleLine && measuredWidth2 > i5) {
                    i6 = paddingTop + this.lineSpacing;
                    this.rowCount++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(com.google.android.material.R_renamed.id_renamed.row_index_key, java.lang.Integer.valueOf(this.rowCount - 1));
                int i8 = measuredWidth + iA;
                int measuredWidth3 = childAt.getMeasuredWidth() + i8;
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                if (z2) {
                    childAt.layout(i5 - measuredWidth3, i6, (i5 - measuredWidth) - iA, measuredHeight);
                } else {
                    childAt.layout(i8, i6, measuredWidth3, measuredHeight);
                }
                measuredWidth += iA + iB + childAt.getMeasuredWidth() + this.itemSpacing;
                paddingTop = measuredHeight;
            }
        }
    }

    protected int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(android.view.View view) {
        java.lang.Object tag = view.getTag(com.google.android.material.R_renamed.id_renamed.row_index_key);
        if (tag instanceof java.lang.Integer) {
            return ((java.lang.Integer) tag).intValue();
        }
        return -1;
    }
}
