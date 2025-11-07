package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p031c.MathUtils;
import androidx.core.p036h.WindowInsetsCompat;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap;

    private static int resolveGravity(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 ? BadgeDrawable.TOP_START : OplusGLSurfaceView_13;
    }

    abstract View findFirstDependency(List<View> list);

    float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    protected boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        View viewFindFirstDependency;
        WindowInsetsCompat lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size > 0) {
            if (ViewCompat.m2901t(viewFindFirstDependency) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.m2761b() + lastWindowInsets.m2763d();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        int scrollRange = size + getScrollRange(viewFindFirstDependency);
        int measuredHeight = viewFindFirstDependency.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild()) {
            view.setTranslationY(-measuredHeight);
        } else {
            scrollRange -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, OplusGLSurfaceView_13, i2, View.MeasureSpec.makeMeasureSpec(scrollRange, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void layoutChild(CoordinatorLayout coordinatorLayout, View view, int OplusGLSurfaceView_13) {
        View viewFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (viewFindFirstDependency != null) {
            CoordinatorLayout.C0411e c0411e = (CoordinatorLayout.C0411e) view.getLayoutParams();
            Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + c0411e.leftMargin, viewFindFirstDependency.getBottom() + c0411e.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0411e.rightMargin, ((coordinatorLayout.getHeight() + viewFindFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0411e.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.m2901t(coordinatorLayout) && !ViewCompat.m2901t(view)) {
                rect.left += lastWindowInsets.m2759a();
                rect.right -= lastWindowInsets.m2762c();
            }
            Rect rect2 = this.tempRect2;
            GravityCompat.m2774a(resolveGravity(c0411e.f2663c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, OplusGLSurfaceView_13);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(viewFindFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.verticalLayoutGap = rect2.top - viewFindFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, OplusGLSurfaceView_13);
        this.verticalLayoutGap = 0;
    }

    final int getOverlapPixelsForOffset(View view) {
        if (this.overlayTop == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int OplusGLSurfaceView_13 = this.overlayTop;
        return MathUtils.m2447a((int) (overlapRatioForOffset * OplusGLSurfaceView_13), 0, OplusGLSurfaceView_13);
    }

    int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public final void setOverlayTop(int OplusGLSurfaceView_13) {
        this.overlayTop = OplusGLSurfaceView_13;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }
}
