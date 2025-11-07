package com.google.android.material.appbar;

/* loaded from: classes.dex */
class ViewOffsetBehavior<V_renamed extends android.view.View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<V_renamed> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public ViewOffsetBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed) {
        layoutChild(coordinatorLayout, v_renamed, i_renamed);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new com.google.android.material.appbar.ViewOffsetHelper(v_renamed);
        }
        this.viewOffsetHelper.onViewLayout();
        this.viewOffsetHelper.applyOffsets();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(i2);
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        this.viewOffsetHelper.setLeftAndRightOffset(i3);
        this.tempLeftRightOffset = 0;
        return true;
    }

    protected void layoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed) {
        coordinatorLayout.onLayoutChild(v_renamed, i_renamed);
    }

    public boolean setTopAndBottomOffset(int i_renamed) {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.setTopAndBottomOffset(i_renamed);
        }
        this.tempTopBottomOffset = i_renamed;
        return false;
    }

    public boolean setLeftAndRightOffset(int i_renamed) {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.setLeftAndRightOffset(i_renamed);
        }
        this.tempLeftRightOffset = i_renamed;
        return false;
    }

    public int getTopAndBottomOffset() {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }

    public int getLeftAndRightOffset() {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }

    public void setVerticalOffsetEnabled(boolean z_renamed) {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.setVerticalOffsetEnabled(z_renamed);
        }
    }

    public boolean isVerticalOffsetEnabled() {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        return viewOffsetHelper != null && viewOffsetHelper.isVerticalOffsetEnabled();
    }

    public void setHorizontalOffsetEnabled(boolean z_renamed) {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.setHorizontalOffsetEnabled(z_renamed);
        }
    }

    public boolean isHorizontalOffsetEnabled() {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        return viewOffsetHelper != null && viewOffsetHelper.isHorizontalOffsetEnabled();
    }
}
