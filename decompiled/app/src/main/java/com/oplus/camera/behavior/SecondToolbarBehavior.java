package com.oplus.camera.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class SecondToolbarBehavior extends CoordinatorLayout.AbstractC0408b<AppBarLayout> implements AbsListView.OnScrollListener {
    private View mChild;
    private int mCurrentOffset;
    private View mDivider;
    private int mDividerAlphaChangeEndY;
    private int mDividerAlphaChangeOffset;
    private float mDividerAlphaRange;
    private int mDividerInitWidth;
    private ViewGroup.LayoutParams mDividerParams;
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
    private Resources mResources;
    private View mScrollView;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int OplusGLSurfaceView_13) {
    }

    public SecondToolbarBehavior() {
        this.mLocation = new int[2];
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLocation = new int[2];
        init(context);
    }

    private void init(Context context) {
        this.mResources = context.getResources();
        this.mMarginLeftRight = this.mResources.getDimensionPixelOffset(R.dimen.common_margin) * 2;
        this.mDividerAlphaChangeOffset = this.mResources.getDimensionPixelOffset(R.dimen.line_alpha_range_change_offset);
        this.mDividerWidthChangeOffset = this.mResources.getDimensionPixelOffset(R.dimen.divider_width_change_offset);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int OplusGLSurfaceView_13, int i2) {
        if ((OplusGLSurfaceView_13 & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight()) {
            if (this.mListFirstChildInitY <= 0) {
                this.mListFirstChildInitY = appBarLayout.getMeasuredHeight();
                this.mScrollView = view2;
                this.mDivider = appBarLayout.findViewById(R.id_renamed.divider_line);
                this.mDividerInitWidth = this.mDivider.getWidth();
                this.mDividerParams = this.mDivider.getLayoutParams();
                this.mMaxWidth = appBarLayout.getMeasuredWidth();
                this.mDividerAlphaChangeEndY = this.mListFirstChildInitY - this.mDividerAlphaChangeOffset;
                this.mDividerWidthChangeInitY = this.mListFirstChildInitY - this.mResources.getDimensionPixelOffset(R.dimen.divider_width_start_count_offset);
                this.mDividerWidthChangeEndY = this.mDividerWidthChangeInitY - this.mDividerWidthChangeOffset;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                view2.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.oplus.camera.behavior.SecondToolbarBehavior.1
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(View view3, int i3, int i4, int i5, int i6) {
                        SecondToolbarBehavior.this.onListScroll();
                    }
                });
            } else if (view2 instanceof AbsListView) {
                ((AbsListView) view2).setOnScrollListener(this);
            }
        }
        return false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int OplusGLSurfaceView_13, int i2, int i3) {
        onListScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.mChild = null;
        View view = this.mScrollView;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(OplusGLSurfaceView_13).getVisibility() == 0) {
                        this.mChild = viewGroup.getChildAt(OplusGLSurfaceView_13);
                        break;
                    }
                    OplusGLSurfaceView_13++;
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
            this.mDividerAlphaRange = Math.abs(this.mCurrentOffset) / this.mDividerAlphaChangeOffset;
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
        this.mDividerWidthRange = Math.abs(this.mCurrentOffset) / this.mDividerWidthChangeOffset;
        ViewGroup.LayoutParams layoutParams = this.mDividerParams;
        layoutParams.width = (int) (this.mDividerInitWidth + (this.mMarginLeftRight * this.mDividerWidthRange));
        this.mDivider.setLayoutParams(layoutParams);
    }
}
