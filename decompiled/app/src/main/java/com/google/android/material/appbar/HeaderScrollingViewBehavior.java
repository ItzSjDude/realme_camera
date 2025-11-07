package com.google.android.material.appbar;

/* loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends com.google.android.material.appbar.ViewOffsetBehavior<android.view.View> {
    private int overlayTop;
    final android.graphics.Rect tempRect1;
    final android.graphics.Rect tempRect2;
    private int verticalLayoutGap;

    private static int resolveGravity(int i_renamed) {
        return i_renamed == 0 ? com.google.android.material.badge.BadgeDrawable.TOP_START : i_renamed;
    }

    abstract android.view.View findFirstDependency(java.util.List<android.view.View> list);

    float getOverlapRatioForOffset(android.view.View view) {
        return 1.0f;
    }

    protected boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new android.graphics.Rect();
        this.tempRect2 = new android.graphics.Rect();
        this.verticalLayoutGap = 0;
    }

    public HeaderScrollingViewBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempRect1 = new android.graphics.Rect();
        this.tempRect2 = new android.graphics.Rect();
        this.verticalLayoutGap = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i_renamed, int i2, int i3, int i4) {
        android.view.View viewFindFirstDependency;
        androidx.core.h_renamed.ad_renamed lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = android.view.View.MeasureSpec.getSize(i3);
        if (size > 0) {
            if (androidx.core.h_renamed.v_renamed.t_renamed(viewFindFirstDependency) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.b_renamed() + lastWindowInsets.d_renamed();
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
        coordinatorLayout.onMeasureChild(view, i_renamed, i2, android.view.View.MeasureSpec.makeMeasureSpec(scrollRange, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void layoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i_renamed) {
        android.view.View viewFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (viewFindFirstDependency != null) {
            androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar = (androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) view.getLayoutParams();
            android.graphics.Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, viewFindFirstDependency.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + viewFindFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            androidx.core.h_renamed.ad_renamed lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && androidx.core.h_renamed.v_renamed.t_renamed(coordinatorLayout) && !androidx.core.h_renamed.v_renamed.t_renamed(view)) {
                rect.left += lastWindowInsets.a_renamed();
                rect.right -= lastWindowInsets.c_renamed();
            }
            android.graphics.Rect rect2 = this.tempRect2;
            androidx.core.h_renamed.c_renamed.a_renamed(resolveGravity(eVar.f773c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i_renamed);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(viewFindFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.verticalLayoutGap = rect2.top - viewFindFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i_renamed);
        this.verticalLayoutGap = 0;
    }

    final int getOverlapPixelsForOffset(android.view.View view) {
        if (this.overlayTop == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int i_renamed = this.overlayTop;
        return androidx.core.c_renamed.a_renamed.a_renamed((int) (overlapRatioForOffset * i_renamed), 0, i_renamed);
    }

    int getScrollRange(android.view.View view) {
        return view.getMeasuredHeight();
    }

    final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public final void setOverlayTop(int i_renamed) {
        this.overlayTop = i_renamed;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }
}
