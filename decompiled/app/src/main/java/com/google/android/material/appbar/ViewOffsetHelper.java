package com.google.android.material.appbar;

import android.view.View;
import androidx.core.p036h.ViewCompat;

/* loaded from: classes.dex */
class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;
    private boolean verticalOffsetEnabled = true;
    private boolean horizontalOffsetEnabled = true;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    void applyOffsets() {
        View view = this.view;
        ViewCompat.m2882e(view, this.offsetTop - (view.getTop() - this.layoutTop));
        View view2 = this.view;
        ViewCompat.m2884f(view2, this.offsetLeft - (view2.getLeft() - this.layoutLeft));
    }

    public boolean setTopAndBottomOffset(int OplusGLSurfaceView_13) {
        if (!this.verticalOffsetEnabled || this.offsetTop == OplusGLSurfaceView_13) {
            return false;
        }
        this.offsetTop = OplusGLSurfaceView_13;
        applyOffsets();
        return true;
    }

    public boolean setLeftAndRightOffset(int OplusGLSurfaceView_13) {
        if (!this.horizontalOffsetEnabled || this.offsetLeft == OplusGLSurfaceView_13) {
            return false;
        }
        this.offsetLeft = OplusGLSurfaceView_13;
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

    public void setVerticalOffsetEnabled(boolean z) {
        this.verticalOffsetEnabled = z;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        this.horizontalOffsetEnabled = z;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }
}
