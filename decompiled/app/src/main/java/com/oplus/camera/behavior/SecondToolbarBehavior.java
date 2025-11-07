package com.oplus.camera.behavior;

/* loaded from: classes2.dex */
public class SecondToolbarBehavior extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<com.google.android.material.appbar.AppBarLayout> implements android.widget.AbsListView.OnScrollListener {
    private android.view.View mChild;
    private int mCurrentOffset;
    private android.view.View mDivider;
    private int mDividerAlphaChangeEndY;
    private int mDividerAlphaChangeOffset;
    private float mDividerAlphaRange;
    private int mDividerInitWidth;
    private android.view.ViewGroup.LayoutParams mDividerParams;
    private int mDividerWidthChangeEndY;
    private int mDividerWidthChangeInitY;
    private int mDividerWidthChangeOffset;
    private float mDividerWidthRange;
    private int mListFirstChildInitY;
    private int[] mLocation;
    private int mLocationY;
    private int mMarginLeftRight;
    private int mMaxWidth;
    private int mNewOffset;
    private android.content.res.Resources mResources;
    private android.view.View mScrollView;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(android.widget.AbsListView absListView, int i_renamed) {
    }

    public SecondToolbarBehavior() {
        this.mLocation = new int[2];
    }

    public SecondToolbarBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLocation = new int[2];
        init(context);
    }

    private void init(android.content.Context context) {
        this.mResources = context.getResources();
        this.mMarginLeftRight = this.mResources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.common_margin) * 2;
        this.mDividerAlphaChangeOffset = this.mResources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.line_alpha_range_change_offset);
        this.mDividerWidthChangeOffset = this.mResources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.divider_width_change_offset);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.view.View view, android.view.View view2, int i_renamed, int i2) {
        if ((i_renamed & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight()) {
            if (this.mListFirstChildInitY <= 0) {
                this.mListFirstChildInitY = appBarLayout.getMeasuredHeight();
                this.mScrollView = view2;
                this.mDivider = appBarLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.divider_line);
                this.mDividerInitWidth = this.mDivider.getWidth();
                this.mDividerParams = this.mDivider.getLayoutParams();
                this.mMaxWidth = appBarLayout.getMeasuredWidth();
                this.mDividerAlphaChangeEndY = this.mListFirstChildInitY - this.mDividerAlphaChangeOffset;
                this.mDividerWidthChangeInitY = this.mListFirstChildInitY - this.mResources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.divider_width_start_count_offset);
                this.mDividerWidthChangeEndY = this.mDividerWidthChangeInitY - this.mDividerWidthChangeOffset;
            }
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                view2.setOnScrollChangeListener(new android.view.View.OnScrollChangeListener() { // from class: com.oplus.camera.behavior.SecondToolbarBehavior.1
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(android.view.View view3, int i3, int i4, int i5, int i6) {
                        com.oplus.camera.behavior.SecondToolbarBehavior.this.onListScroll();
                    }
                });
            } else if (view2 instanceof android.widget.AbsListView) {
                ((android.widget.AbsListView) view2).setOnScrollListener(this);
            }
        }
        return false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(android.widget.AbsListView absListView, int i_renamed, int i2, int i3) {
        onListScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.mChild = null;
        android.view.View view = this.mScrollView;
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i_renamed).getVisibility() == 0) {
                        this.mChild = viewGroup.getChildAt(i_renamed);
                        break;
                    }
                    i_renamed++;
                }
            }
        }
        if (this.mChild == null) {
            this.mChild = this.mScrollView;
        }
        this.mChild.getLocationOnScreen(this.mLocation);
        this.mLocationY = this.mLocation[1];
        this.mNewOffset = 0;
        int i2 = this.mLocationY;
        if (i2 < this.mDividerAlphaChangeEndY) {
            this.mNewOffset = this.mDividerAlphaChangeOffset;
        } else {
            int i3 = this.mListFirstChildInitY;
            if (i2 > i3) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i3 - i2;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        if (this.mDividerAlphaRange <= 1.0f) {
            this.mDividerAlphaRange = java.lang.Math.abs(this.mCurrentOffset) / this.mDividerAlphaChangeOffset;
            this.mDivider.setAlpha(this.mDividerAlphaRange);
        }
        int i4 = this.mLocationY;
        if (i4 < this.mDividerWidthChangeEndY) {
            this.mNewOffset = this.mDividerWidthChangeOffset;
        } else {
            int i5 = this.mDividerWidthChangeInitY;
            if (i4 > i5) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i5 - i4;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        this.mDividerWidthRange = java.lang.Math.abs(this.mCurrentOffset) / this.mDividerWidthChangeOffset;
        android.view.ViewGroup.LayoutParams layoutParams = this.mDividerParams;
        layoutParams.width = (int) (this.mDividerInitWidth + (this.mMarginLeftRight * this.mDividerWidthRange));
        this.mDivider.setLayoutParams(layoutParams);
    }
}
