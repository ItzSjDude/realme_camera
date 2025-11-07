package com.google.android.material.appbar;

/* loaded from: classes.dex */
class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final android.view.View view;
    private boolean verticalOffsetEnabled = true;
    private boolean horizontalOffsetEnabled = true;

    public ViewOffsetHelper(android.view.View view) {
        this.view = view;
    }

    void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    void applyOffsets() {
        android.view.View view = this.view;
        androidx.core.h_renamed.v_renamed.e_renamed(view, this.offsetTop - (view.getTop() - this.layoutTop));
        android.view.View view2 = this.view;
        androidx.core.h_renamed.v_renamed.f_renamed(view2, this.offsetLeft - (view2.getLeft() - this.layoutLeft));
    }

    public boolean setTopAndBottomOffset(int i_renamed) {
        if (!this.verticalOffsetEnabled || this.offsetTop == i_renamed) {
            return false;
        }
        this.offsetTop = i_renamed;
        applyOffsets();
        return true;
    }

    public boolean setLeftAndRightOffset(int i_renamed) {
        if (!this.horizontalOffsetEnabled || this.offsetLeft == i_renamed) {
            return false;
        }
        this.offsetLeft = i_renamed;
        applyOffsets();
        return true;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public void setVerticalOffsetEnabled(boolean z_renamed) {
        this.verticalOffsetEnabled = z_renamed;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    public void setHorizontalOffsetEnabled(boolean z_renamed) {
        this.horizontalOffsetEnabled = z_renamed;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }
}
