package com.google.android.material.appbar;

/* loaded from: classes.dex */
public class AppBarLayout extends android.widget.LinearLayout implements androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_AppBarLayout;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private android.animation.ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;
    private androidx.core.h_renamed.ad_renamed lastInsets;
    private boolean liftOnScroll;
    private java.lang.ref.WeakReference<android.view.View> liftOnScrollTargetView;
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private java.util.List<com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener> listeners;
    private int pendingAction;
    private android.graphics.drawable.Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    public interface BaseOnOffsetChangedListener<T_renamed extends com.google.android.material.appbar.AppBarLayout> {
        void onOffsetChanged(T_renamed t_renamed, int i_renamed);
    }

    public interface OnOffsetChangedListener extends com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener<com.google.android.material.appbar.AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i_renamed);
    }

    @java.lang.Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(android.content.Context context) {
        this(context, null);
    }

    public AppBarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.appBarLayoutStyle);
    }

    public AppBarLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        android.content.Context context2 = getContext();
        setOrientation(1);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
            com.google.android.material.appbar.ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, i_renamed, DEF_STYLE_RES);
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.AppBarLayout, i_renamed, DEF_STYLE_RES, new int[0]);
        androidx.core.h_renamed.v_renamed.a_renamed(this, typedArrayObtainStyledAttributes.getDrawable(com.google.android.material.R_renamed.styleable.AppBarLayout_android_background));
        if (getBackground() instanceof android.graphics.drawable.ColorDrawable) {
            android.graphics.drawable.ColorDrawable colorDrawable = (android.graphics.drawable.ColorDrawable) getBackground();
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            androidx.core.h_renamed.v_renamed.a_renamed(this, materialShapeDrawable);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.AppBarLayout_expanded)) {
            setExpanded(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (android.os.Build.VERSION.SDK_INT >= 21 && typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.AppBarLayout_elevation)) {
            com.google.android.material.appbar.ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.AppBarLayout_elevation, 0));
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.liftOnScroll = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayObtainStyledAttributes.getDrawable(com.google.android.material.R_renamed.styleable.AppBarLayout_statusBarForeground));
        typedArrayObtainStyledAttributes.recycle();
        androidx.core.h_renamed.v_renamed.a_renamed(this, new androidx.core.h_renamed.q_renamed() { // from class: com.google.android.material.appbar.AppBarLayout.1
            @Override // androidx.core.h_renamed.q_renamed
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view, androidx.core.h_renamed.ad_renamed adVar) {
                return com.google.android.material.appbar.AppBarLayout.this.onWindowInsetChanged(adVar);
            }
        });
    }

    public void addOnOffsetChangedListener(com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new java.util.ArrayList();
        }
        if (baseOnOffsetChangedListener == null || this.listeners.contains(baseOnOffsetChangedListener)) {
            return;
        }
        this.listeners.add(baseOnOffsetChangedListener);
    }

    public void addOnOffsetChangedListener(com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void removeOnOffsetChangedListener(com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        java.util.List<com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener> list = this.listeners;
        if (list == null || baseOnOffsetChangedListener == null) {
            return;
        }
        list.remove(baseOnOffsetChangedListener);
    }

    public void removeOnOffsetChangedListener(com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void setStatusBarForeground(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.graphics.drawable.Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.statusBarForeground = drawable != null ? drawable.mutate() : null;
            android.graphics.drawable.Drawable drawable3 = this.statusBarForeground;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a_renamed.b_renamed(this.statusBarForeground, androidx.core.h_renamed.v_renamed.g_renamed(this));
                this.statusBarForeground.setVisible(getVisibility() == 0, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    public void setStatusBarForegroundColor(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setStatusBarForeground(new android.graphics.drawable.ColorDrawable(i_renamed));
    }

    public void setStatusBarForegroundResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setStatusBarForeground(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    public android.graphics.drawable.Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.currentOffset);
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        android.graphics.drawable.Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.statusBarForeground;
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed);
        boolean z_renamed = i_renamed == 0;
        android.graphics.drawable.Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z_renamed, false);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        int mode = android.view.View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && androidx.core.h_renamed.v_renamed.t_renamed(this) && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = androidx.core.c_renamed.a_renamed.a_renamed(getMeasuredHeight() + getTopInset(), 0, android.view.View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        if (androidx.core.h_renamed.v_renamed.t_renamed(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                androidx.core.h_renamed.v_renamed.e_renamed(getChildAt(childCount), topInset);
            }
        }
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            }
            if (((com.google.android.material.appbar.AppBarLayout.LayoutParams) getChildAt(i5).getLayoutParams()).getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
                break;
            }
            i5++;
        }
        android.graphics.drawable.Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.liftableOverride) {
            return;
        }
        setLiftableState(this.liftOnScroll || hasCollapsibleChild());
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    private boolean shouldDrawStatusBarForeground() {
        return this.statusBarForeground != null && getTopInset() > 0;
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            if (((com.google.android.material.appbar.AppBarLayout.LayoutParams) getChildAt(i_renamed).getLayoutParams()).isCollapsible()) {
                return true;
            }
        }
        return false;
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i_renamed) {
        if (i_renamed != 1) {
            throw new java.lang.IllegalArgumentException("AppBarLayout is_renamed always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed
    public androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<com.google.android.material.appbar.AppBarLayout> getBehavior() {
        return new com.google.android.material.appbar.AppBarLayout.Behavior();
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        super.setElevation(f_renamed);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f_renamed);
    }

    public void setExpanded(boolean z_renamed) {
        setExpanded(z_renamed, androidx.core.h_renamed.v_renamed.A_renamed(this));
    }

    public void setExpanded(boolean z_renamed, boolean z2) {
        setExpanded(z_renamed, z2, true);
    }

    private void setExpanded(boolean z_renamed, boolean z2, boolean z3) {
        this.pendingAction = (z_renamed ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof com.google.android.material.appbar.AppBarLayout.LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public com.google.android.material.appbar.AppBarLayout.LayoutParams generateDefaultLayoutParams() {
        return new com.google.android.material.appbar.AppBarLayout.LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public com.google.android.material.appbar.AppBarLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.google.android.material.appbar.AppBarLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public com.google.android.material.appbar.AppBarLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (android.os.Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof android.widget.LinearLayout.LayoutParams)) {
            return new com.google.android.material.appbar.AppBarLayout.LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            return new com.google.android.material.appbar.AppBarLayout.LayoutParams((android.view.ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new com.google.android.material.appbar.AppBarLayout.LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public final int getTotalScrollRange() {
        int i_renamed = this.totalScrollRange;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iM = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            android.view.View childAt = getChildAt(i2);
            com.google.android.material.appbar.AppBarLayout.LayoutParams layoutParams = (com.google.android.material.appbar.AppBarLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.scrollFlags;
            if ((i3 & 1) == 0) {
                break;
            }
            iM += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if (i2 == 0 && androidx.core.h_renamed.v_renamed.t_renamed(childAt)) {
                iM -= getTopInset();
            }
            if ((i3 & 2) != 0) {
                iM -= androidx.core.h_renamed.v_renamed.m_renamed(childAt);
                break;
            }
            i2++;
        }
        int iMax = java.lang.Math.max(0, iM);
        this.totalScrollRange = iMax;
        return iMax;
    }

    boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iM;
        int i_renamed = this.downPreScrollRange;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = getChildAt(childCount);
            com.google.android.material.appbar.AppBarLayout.LayoutParams layoutParams = (com.google.android.material.appbar.AppBarLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.scrollFlags;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
            } else {
                int i4 = layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i3 & 8) != 0) {
                    iM = androidx.core.h_renamed.v_renamed.m_renamed(childAt);
                } else if ((i3 & 2) != 0) {
                    iM = measuredHeight - androidx.core.h_renamed.v_renamed.m_renamed(childAt);
                } else {
                    iMin = i4 + measuredHeight;
                    if (childCount == 0 && androidx.core.h_renamed.v_renamed.t_renamed(childAt)) {
                        iMin = java.lang.Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i2 += iMin;
                }
                iMin = i4 + iM;
                if (childCount == 0) {
                    iMin = java.lang.Math.min(iMin, measuredHeight - getTopInset());
                }
                i2 += iMin;
            }
        }
        int iMax = java.lang.Math.max(0, i2);
        this.downPreScrollRange = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i_renamed = this.downScrollRange;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iM = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            android.view.View childAt = getChildAt(i2);
            com.google.android.material.appbar.AppBarLayout.LayoutParams layoutParams = (com.google.android.material.appbar.AppBarLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i3 = layoutParams.scrollFlags;
            if ((i3 & 1) == 0) {
                break;
            }
            iM += measuredHeight;
            if ((i3 & 2) != 0) {
                iM -= androidx.core.h_renamed.v_renamed.m_renamed(childAt);
                break;
            }
            i2++;
        }
        int iMax = java.lang.Math.max(0, iM);
        this.downScrollRange = iMax;
        return iMax;
    }

    void onOffsetChanged(int i_renamed) {
        this.currentOffset = i_renamed;
        if (!willNotDraw()) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
        java.util.List<com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i2);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i_renamed);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iM = androidx.core.h_renamed.v_renamed.m_renamed(this);
        if (iM == 0) {
            int childCount = getChildCount();
            iM = childCount >= 1 ? androidx.core.h_renamed.v_renamed.m_renamed(getChildAt(childCount - 1)) : 0;
            if (iM == 0) {
                return getHeight() / 3;
            }
        }
        return (iM * 2) + topInset;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i_renamed) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + iArr.length);
        iArr[0] = this.liftable ? com.google.android.material.R_renamed.attr.state_liftable : -com.google.android.material.R_renamed.attr.state_liftable;
        iArr[1] = (this.liftable && this.lifted) ? com.google.android.material.R_renamed.attr.state_lifted : -com.google.android.material.R_renamed.attr.state_lifted;
        iArr[2] = this.liftable ? com.google.android.material.R_renamed.attr.state_collapsible : -com.google.android.material.R_renamed.attr.state_collapsible;
        iArr[3] = (this.liftable && this.lifted) ? com.google.android.material.R_renamed.attr.state_collapsed : -com.google.android.material.R_renamed.attr.state_collapsed;
        return mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    public boolean setLiftable(boolean z_renamed) {
        this.liftableOverride = true;
        return setLiftableState(z_renamed);
    }

    private boolean setLiftableState(boolean z_renamed) {
        if (this.liftable == z_renamed) {
            return false;
        }
        this.liftable = z_renamed;
        refreshDrawableState();
        return true;
    }

    public boolean setLifted(boolean z_renamed) {
        return setLiftedState(z_renamed);
    }

    boolean setLiftedState(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.lifted == z_renamed) {
            return false;
        }
        this.lifted = z_renamed;
        refreshDrawableState();
        if (!this.liftOnScroll || !(getBackground() instanceof com.google.android.material.shape.MaterialShapeDrawable)) {
            return true;
        }
        startLiftOnScrollElevationOverlayAnimation((com.google.android.material.shape.MaterialShapeDrawable) getBackground(), z_renamed);
        return true;
    }

    private void startLiftOnScrollElevationOverlayAnimation(final com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        float dimension = getResources().getDimension(com.google.android.material.R_renamed.dimen.design_appbar_elevation);
        float f_renamed = z_renamed ? 0.0f : dimension;
        if (!z_renamed) {
            dimension = 0.0f;
        }
        android.animation.ValueAnimator valueAnimator = this.elevationOverlayAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.elevationOverlayAnimator = android.animation.ValueAnimator.ofFloat(f_renamed, dimension);
        this.elevationOverlayAnimator.setDuration(getResources().getInteger(com.google.android.material.R_renamed.integer.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        this.elevationOverlayAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                materialShapeDrawable.setElevation(((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        this.elevationOverlayAnimator.start();
    }

    public void setLiftOnScroll(boolean z_renamed) {
        this.liftOnScroll = z_renamed;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public void setLiftOnScrollTargetViewId(int i_renamed) {
        this.liftOnScrollTargetViewId = i_renamed;
        clearLiftOnScrollTargetView();
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    boolean shouldLift(android.view.View view) {
        android.view.View viewFindLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (viewFindLiftOnScrollTargetView == null) {
            viewFindLiftOnScrollTargetView = view;
        }
        return viewFindLiftOnScrollTargetView != null && (viewFindLiftOnScrollTargetView.canScrollVertically(-1) || viewFindLiftOnScrollTargetView.getScrollY() > 0);
    }

    private android.view.View findLiftOnScrollTargetView(android.view.View view) {
        int i_renamed;
        if (this.liftOnScrollTargetView == null && (i_renamed = this.liftOnScrollTargetViewId) != -1) {
            android.view.View viewFindViewById = view != null ? view.findViewById(i_renamed) : null;
            if (viewFindViewById == null && (getParent() instanceof android.view.ViewGroup)) {
                viewFindViewById = ((android.view.ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (viewFindViewById != null) {
                this.liftOnScrollTargetView = new java.lang.ref.WeakReference<>(viewFindViewById);
            }
        }
        java.lang.ref.WeakReference<android.view.View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void clearLiftOnScrollTargetView() {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @java.lang.Deprecated
    public void setTargetElevation(float f_renamed) throws android.content.res.Resources.NotFoundException {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f_renamed);
        }
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    final int getTopInset() {
        androidx.core.h_renamed.ad_renamed adVar = this.lastInsets;
        if (adVar != null) {
            return adVar.b_renamed();
        }
        return 0;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) {
            return false;
        }
        android.view.View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || androidx.core.h_renamed.v_renamed.t_renamed(childAt)) ? false : true;
    }

    androidx.core.h_renamed.ad_renamed onWindowInsetChanged(androidx.core.h_renamed.ad_renamed adVar) {
        androidx.core.h_renamed.ad_renamed adVar2 = androidx.core.h_renamed.v_renamed.t_renamed(this) ? adVar : null;
        if (!androidx.core.g_renamed.c_renamed.a_renamed(this.lastInsets, adVar2)) {
            this.lastInsets = adVar2;
            updateWillNotDraw();
            requestLayout();
        }
        return adVar;
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        int scrollFlags;
        android.view.animation.Interpolator scrollInterpolator;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.scrollFlags = 1;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.AppBarLayout_Layout);
            this.scrollFlags = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.scrollFlags = 1;
        }

        public LayoutParams(int i_renamed, int i2, float f_renamed) {
            super(i_renamed, i2, f_renamed);
            this.scrollFlags = 1;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(com.google.android.material.appbar.AppBarLayout.LayoutParams layoutParams) {
            super((android.widget.LinearLayout.LayoutParams) layoutParams);
            this.scrollFlags = 1;
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }

        public void setScrollFlags(int i_renamed) {
            this.scrollFlags = i_renamed;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public void setScrollInterpolator(android.view.animation.Interpolator interpolator) {
            this.scrollInterpolator = interpolator;
        }

        public android.view.animation.Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        boolean isCollapsible() {
            int i_renamed = this.scrollFlags;
            return (i_renamed & 1) == 1 && (i_renamed & 10) != 0;
        }
    }

    public static class Behavior extends com.google.android.material.appbar.AppBarLayout.BaseBehavior<com.google.android.material.appbar.AppBarLayout> {

        public static abstract class DragCallback extends com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback<com.google.android.material.appbar.AppBarLayout> {
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, int i_renamed) {
            return super.onLayoutChild(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout, i_renamed);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, int i_renamed, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout, i_renamed, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.view.View view, int i_renamed, int i2, int[] iArr, int i3) throws android.content.res.Resources.NotFoundException {
            super.onNestedPreScroll(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout, view, i_renamed, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout, view, i_renamed, i2, i3, i4, i5, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.os.Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ android.os.Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.view.View view, android.view.View view2, int i_renamed, int i2) {
            return super.onStartNestedScroll(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout, view, view2, i_renamed, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.view.View view, int i_renamed) throws android.content.res.Resources.NotFoundException {
            super.onStopNestedScroll(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) appBarLayout, view, i_renamed);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z_renamed) {
            super.setHorizontalOffsetEnabled(z_renamed);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i_renamed) {
            return super.setLeftAndRightOffset(i_renamed);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i_renamed) {
            return super.setTopAndBottomOffset(i_renamed);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z_renamed) {
            super.setVerticalOffsetEnabled(z_renamed);
        }

        public Behavior() {
        }

        public Behavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T_renamed extends com.google.android.material.appbar.AppBarLayout> extends com.google.android.material.appbar.HeaderBehavior<T_renamed> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private java.lang.ref.WeakReference<android.view.View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private android.animation.ValueAnimator offsetAnimator;
        private int offsetDelta;
        private int offsetToChildIndexOnLayout;
        private boolean offsetToChildIndexOnLayoutIsMinHeight;
        private float offsetToChildIndexOnLayoutPerc;
        private com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback onDragCallback;

        public static abstract class BaseDragCallback<T_renamed extends com.google.android.material.appbar.AppBarLayout> {
            public abstract boolean canDrag(T_renamed t_renamed);
        }

        private static boolean checkFlag(int i_renamed, int i2) {
            return (i_renamed & i2) == i2;
        }

        public BaseBehavior() {
            this.offsetToChildIndexOnLayout = -1;
        }

        public BaseBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.offsetToChildIndexOnLayout = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, android.view.View view, android.view.View view2, int i_renamed, int i2) {
            android.animation.ValueAnimator valueAnimator;
            boolean z_renamed = (i_renamed & 2) != 0 && (t_renamed.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t_renamed, view));
            if (z_renamed && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i2;
            return z_renamed;
        }

        private boolean canScrollChildren(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, android.view.View view) {
            return t_renamed.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t_renamed.getHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, android.view.View view, int i_renamed, int i2, int[] iArr, int i3) throws android.content.res.Resources.NotFoundException {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -t_renamed.getTotalScrollRange();
                    downNestedPreScrollRange = t_renamed.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -t_renamed.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i5 = i4;
                int i6 = downNestedPreScrollRange;
                if (i5 != i6) {
                    iArr[1] = scroll(coordinatorLayout, t_renamed, i2, i5, i6);
                }
            }
            if (t_renamed.isLiftOnScroll()) {
                t_renamed.setLiftedState(t_renamed.shouldLift(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = scroll(coordinatorLayout, t_renamed, i4, -t_renamed.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                updateAccessibilityActions(coordinatorLayout, t_renamed);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, android.view.View view, int i_renamed) throws android.content.res.Resources.NotFoundException {
            if (this.lastStartedType == 0 || i_renamed == 1) {
                snapToChildIfNeeded(coordinatorLayout, t_renamed);
                if (t_renamed.isLiftOnScroll()) {
                    t_renamed.setLiftedState(t_renamed.shouldLift(view));
                }
            }
            this.lastNestedScrollingChildRef = new java.lang.ref.WeakReference<>(view);
        }

        public void setDragCallback(com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback baseDragCallback) {
            this.onDragCallback = baseDragCallback;
        }

        private void animateOffsetTo(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, int i_renamed, float f_renamed) {
            int height;
            int iAbs = java.lang.Math.abs(getTopBottomOffsetForScrollingSibling() - i_renamed);
            float fAbs = java.lang.Math.abs(f_renamed);
            if (fAbs > 0.0f) {
                height = java.lang.Math.round((iAbs / fAbs) * 1000.0f) * 3;
            } else {
                height = (int) (((iAbs / t_renamed.getHeight()) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, t_renamed, i_renamed, height);
        }

        private void animateOffsetWithDuration(final androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, final T_renamed t_renamed, int i_renamed, int i2) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i_renamed) {
                android.animation.ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.offsetAnimator.cancel();
                return;
            }
            android.animation.ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                this.offsetAnimator = new android.animation.ValueAnimator();
                this.offsetAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator3) {
                        com.google.android.material.appbar.AppBarLayout.BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t_renamed, ((java.lang.Integer) valueAnimator3.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration(java.lang.Math.min(i2, MAX_OFFSET_ANIMATION_DURATION));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i_renamed);
            this.offsetAnimator.start();
        }

        private int getChildIndexOnOffset(T_renamed t_renamed, int i_renamed) {
            int childCount = t_renamed.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = t_renamed.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                com.google.android.material.appbar.AppBarLayout.LayoutParams layoutParams = (com.google.android.material.appbar.AppBarLayout.LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.getScrollFlags(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i3 = -i_renamed;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private void snapToChildIfNeeded(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(t_renamed, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                android.view.View childAt = t_renamed.getChildAt(childIndexOnOffset);
                com.google.android.material.appbar.AppBarLayout.LayoutParams layoutParams = (com.google.android.material.appbar.AppBarLayout.LayoutParams) childAt.getLayoutParams();
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i_renamed = -childAt.getTop();
                    int iM = -childAt.getBottom();
                    if (childIndexOnOffset == t_renamed.getChildCount() - 1) {
                        iM += t_renamed.getTopInset();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        iM += androidx.core.h_renamed.v_renamed.m_renamed(childAt);
                    } else if (checkFlag(scrollFlags, 5)) {
                        int iM2 = androidx.core.h_renamed.v_renamed.m_renamed(childAt) + iM;
                        if (topBottomOffsetForScrollingSibling < iM2) {
                            i_renamed = iM2;
                        } else {
                            iM = iM2;
                        }
                    }
                    if (checkFlag(scrollFlags, 32)) {
                        i_renamed += layoutParams.topMargin;
                        iM -= layoutParams.bottomMargin;
                    }
                    if (topBottomOffsetForScrollingSibling < (iM + i_renamed) / 2) {
                        i_renamed = iM;
                    }
                    animateOffsetTo(coordinatorLayout, t_renamed, androidx.core.c_renamed.a_renamed.a_renamed(i_renamed, -t_renamed.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, int i_renamed, int i2, int i3, int i4) {
            if (((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) t_renamed.getLayoutParams()).height == -2) {
                coordinatorLayout.onMeasureChild(t_renamed, i_renamed, i2, android.view.View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) t_renamed, i_renamed, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, int i_renamed) throws android.content.res.Resources.NotFoundException {
            int iRound;
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) t_renamed, i_renamed);
            int pendingAction = t_renamed.getPendingAction();
            int i2 = this.offsetToChildIndexOnLayout;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                android.view.View childAt = t_renamed.getChildAt(i2);
                int i3 = -childAt.getBottom();
                if (this.offsetToChildIndexOnLayoutIsMinHeight) {
                    iRound = androidx.core.h_renamed.v_renamed.m_renamed(childAt) + t_renamed.getTopInset();
                } else {
                    iRound = java.lang.Math.round(childAt.getHeight() * this.offsetToChildIndexOnLayoutPerc);
                }
                setHeaderTopBottomOffset(coordinatorLayout, t_renamed, i3 + iRound);
            } else if (pendingAction != 0) {
                boolean z_renamed = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -t_renamed.getUpNestedPreScrollRange();
                    if (z_renamed) {
                        animateOffsetTo(coordinatorLayout, t_renamed, i4, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, t_renamed, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z_renamed) {
                        animateOffsetTo(coordinatorLayout, t_renamed, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, t_renamed, 0);
                    }
                }
            }
            t_renamed.resetPendingAction();
            this.offsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(androidx.core.c_renamed.a_renamed.a_renamed(getTopAndBottomOffset(), -t_renamed.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, t_renamed, getTopAndBottomOffset(), 0, true);
            t_renamed.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout, t_renamed);
            return zOnLayoutChild;
        }

        private void updateAccessibilityActions(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed) {
            androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) coordinatorLayout, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.m_renamed.a_renamed());
            androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) coordinatorLayout, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.n_renamed.a_renamed());
            android.view.View viewFindFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (viewFindFirstScrollingChild == null || t_renamed.getTotalScrollRange() == 0 || !(((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) viewFindFirstScrollingChild.getLayoutParams()).b_renamed() instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior)) {
                return;
            }
            addAccessibilityScrollActions(coordinatorLayout, t_renamed, viewFindFirstScrollingChild);
        }

        private void addAccessibilityScrollActions(final androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, final T_renamed t_renamed, final android.view.View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t_renamed.getTotalScrollRange()) && view.canScrollVertically(1)) {
                addActionToExpand(coordinatorLayout, t_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.m_renamed, false);
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (view.canScrollVertically(-1)) {
                    final int i_renamed = -t_renamed.getDownNestedPreScrollRange();
                    if (i_renamed != 0) {
                        androidx.core.h_renamed.v_renamed.a_renamed(coordinatorLayout, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.n_renamed, null, new androidx.core.h_renamed.a_renamed.g_renamed() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // androidx.core.h_renamed.a_renamed.g_renamed
                            public boolean perform(android.view.View view2, androidx.core.h_renamed.a_renamed.g_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
                                com.google.android.material.appbar.AppBarLayout.BaseBehavior.this.onNestedPreScroll(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) t_renamed, view, 0, i_renamed, new int[]{0, 0}, 1);
                                return true;
                            }
                        });
                        return;
                    }
                    return;
                }
                addActionToExpand(coordinatorLayout, t_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.n_renamed, true);
            }
        }

        private void addActionToExpand(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, final T_renamed t_renamed, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed aVar, final boolean z_renamed) {
            androidx.core.h_renamed.v_renamed.a_renamed(coordinatorLayout, aVar, null, new androidx.core.h_renamed.a_renamed.g_renamed() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                @Override // androidx.core.h_renamed.a_renamed.g_renamed
                public boolean perform(android.view.View view, androidx.core.h_renamed.a_renamed.g_renamed.a_renamed aVar2) {
                    t_renamed.setExpanded(z_renamed);
                    return true;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(T_renamed t_renamed) {
            com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback baseDragCallback = this.onDragCallback;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t_renamed);
            }
            java.lang.ref.WeakReference<android.view.View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            android.view.View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public void onFlingFinished(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed) throws android.content.res.Resources.NotFoundException {
            snapToChildIfNeeded(coordinatorLayout, t_renamed);
            if (t_renamed.isLiftOnScroll()) {
                t_renamed.setLiftedState(t_renamed.shouldLift(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getMaxDragOffset(T_renamed t_renamed) {
            return -t_renamed.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getScrollRangeForDragFling(T_renamed t_renamed) {
            return t_renamed.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int setHeaderTopBottomOffset(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, int i_renamed, int i2, int i3) throws android.content.res.Resources.NotFoundException {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i4 = 0;
            if (i2 != 0 && topBottomOffsetForScrollingSibling >= i2 && topBottomOffsetForScrollingSibling <= i3) {
                int iA = androidx.core.c_renamed.a_renamed.a_renamed(i_renamed, i2, i3);
                if (topBottomOffsetForScrollingSibling != iA) {
                    int iInterpolateOffset = t_renamed.hasChildWithInterpolator() ? interpolateOffset(t_renamed, iA) : iA;
                    boolean topAndBottomOffset = setTopAndBottomOffset(iInterpolateOffset);
                    i4 = topBottomOffsetForScrollingSibling - iA;
                    this.offsetDelta = iA - iInterpolateOffset;
                    if (!topAndBottomOffset && t_renamed.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t_renamed);
                    }
                    t_renamed.onOffsetChanged(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, t_renamed, iA, iA < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                }
            } else {
                this.offsetDelta = 0;
            }
            updateAccessibilityActions(coordinatorLayout, t_renamed);
            return i4;
        }

        boolean isOffsetAnimatorRunning() {
            android.animation.ValueAnimator valueAnimator = this.offsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        private int interpolateOffset(T_renamed t_renamed, int i_renamed) {
            int iAbs = java.lang.Math.abs(i_renamed);
            int childCount = t_renamed.getChildCount();
            int topInset = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                android.view.View childAt = t_renamed.getChildAt(i2);
                com.google.android.material.appbar.AppBarLayout.LayoutParams layoutParams = (com.google.android.material.appbar.AppBarLayout.LayoutParams) childAt.getLayoutParams();
                android.view.animation.Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i2++;
                } else if (scrollInterpolator != null) {
                    int scrollFlags = layoutParams.getScrollFlags();
                    if ((scrollFlags & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((scrollFlags & 2) != 0) {
                            topInset -= androidx.core.h_renamed.v_renamed.m_renamed(childAt);
                        }
                    }
                    if (androidx.core.h_renamed.v_renamed.t_renamed(childAt)) {
                        topInset -= t_renamed.getTopInset();
                    }
                    if (topInset > 0) {
                        float f_renamed = topInset;
                        return java.lang.Integer.signum(i_renamed) * (childAt.getTop() + java.lang.Math.round(f_renamed * scrollInterpolator.getInterpolation((iAbs - childAt.getTop()) / f_renamed)));
                    }
                }
            }
            return i_renamed;
        }

        private void updateAppBarLayoutDrawableState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, int i_renamed, int i2, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
            android.view.View appBarChildOnOffset = getAppBarChildOnOffset(t_renamed, i_renamed);
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((com.google.android.material.appbar.AppBarLayout.LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                boolean zShouldLift = false;
                if ((scrollFlags & 1) != 0) {
                    int iM = androidx.core.h_renamed.v_renamed.m_renamed(appBarChildOnOffset);
                    if (i2 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i_renamed) < (appBarChildOnOffset.getBottom() - iM) - t_renamed.getTopInset()) : (-i_renamed) >= (appBarChildOnOffset.getBottom() - iM) - t_renamed.getTopInset()) {
                        zShouldLift = true;
                    }
                }
                if (t_renamed.isLiftOnScroll()) {
                    zShouldLift = t_renamed.shouldLift(findFirstScrollingChild(coordinatorLayout));
                }
                boolean liftedState = t_renamed.setLiftedState(zShouldLift);
                if (z_renamed || (liftedState && shouldJumpElevationState(coordinatorLayout, t_renamed))) {
                    t_renamed.jumpDrawablesToCurrentState();
                }
            }
        }

        private boolean shouldJumpElevationState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed) {
            java.util.List<android.view.View> dependents = coordinatorLayout.getDependents(t_renamed);
            int size = dependents.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed bVarB = ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) dependents.get(i_renamed).getLayoutParams()).b_renamed();
                if (bVarB instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) {
                    return ((com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) bVarB).getOverlayTop() != 0;
                }
            }
            return false;
        }

        private static android.view.View getAppBarChildOnOffset(com.google.android.material.appbar.AppBarLayout appBarLayout, int i_renamed) {
            int iAbs = java.lang.Math.abs(i_renamed);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private android.view.View findFirstScrollingChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = coordinatorLayout.getChildAt(i_renamed);
                if ((childAt instanceof androidx.core.h_renamed.i_renamed) || (childAt instanceof android.widget.ListView) || (childAt instanceof android.widget.ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public android.os.Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed) {
            android.os.Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) t_renamed);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t_renamed.getChildCount();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = t_renamed.getChildAt(i_renamed);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState savedState = new com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState(parcelableOnSaveInstanceState);
                    savedState.firstVisibleChildIndex = i_renamed;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == androidx.core.h_renamed.v_renamed.m_renamed(childAt) + t_renamed.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableOnSaveInstanceState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public void onRestoreInstanceState(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, T_renamed t_renamed, android.os.Parcelable parcelable) {
            if (parcelable instanceof com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState) {
                com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState savedState = (com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) t_renamed, savedState.getSuperState());
                this.offsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
                this.offsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
                this.offsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) t_renamed, parcelable);
            this.offsetToChildIndexOnLayout = -1;
        }

        protected static class SavedState extends androidx.customview.view.AbsSavedState {
            public static final android.os.Parcelable.Creator<com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                /* JADX WARN: Can't_renamed rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                    return new com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState createFromParcel(android.os.Parcel parcel) {
                    return new com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                public com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState[] newArray(int i_renamed) {
                    return new com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState[i_renamed];
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public SavedState(android.os.Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
                super.writeToParcel(parcel, i_renamed);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.HeaderScrollingViewBehavior {
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* bridge */ /* synthetic */ android.view.View findFirstDependency(java.util.List list) {
            return findFirstDependency((java.util.List<android.view.View>) list);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public /* bridge */ /* synthetic */ boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i_renamed) {
            return super.onLayoutChild(coordinatorLayout, view, i_renamed);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public /* bridge */ /* synthetic */ boolean onMeasureChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, int i_renamed, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i_renamed, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z_renamed) {
            super.setHorizontalOffsetEnabled(z_renamed);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i_renamed) {
            return super.setLeftAndRightOffset(i_renamed);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i_renamed) {
            return super.setTopAndBottomOffset(i_renamed);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z_renamed) {
            super.setVerticalOffsetEnabled(z_renamed);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean layoutDependsOn(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) {
            return view2 instanceof com.google.android.material.appbar.AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) throws android.content.res.Resources.NotFoundException {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public void onDependentViewRemoved(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.view.View view2) {
            if (view2 instanceof com.google.android.material.appbar.AppBarLayout) {
                androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) coordinatorLayout, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.m_renamed.a_renamed());
                androidx.core.h_renamed.v_renamed.c_renamed((android.view.View) coordinatorLayout, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.n_renamed.a_renamed());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onRequestChildRectangleOnScreen(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, android.view.View view, android.graphics.Rect rect, boolean z_renamed) {
            com.google.android.material.appbar.AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (appBarLayoutFindFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                android.graphics.Rect rect2 = this.tempRect1;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutFindFirstDependency.setExpanded(false, !z_renamed);
                    return true;
                }
            }
            return false;
        }

        private void offsetChildAsNeeded(android.view.View view, android.view.View view2) {
            androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed bVarB = ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) view2.getLayoutParams()).b_renamed();
            if (bVarB instanceof com.google.android.material.appbar.AppBarLayout.BaseBehavior) {
                androidx.core.h_renamed.v_renamed.e_renamed(view, (((view2.getBottom() - view.getTop()) + ((com.google.android.material.appbar.AppBarLayout.BaseBehavior) bVarB).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(android.view.View view) {
            int i_renamed;
            if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                com.google.android.material.appbar.AppBarLayout appBarLayout = (com.google.android.material.appbar.AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i_renamed = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i_renamed) + 1.0f;
                }
            }
            return 0.0f;
        }

        private static int getAppBarLayoutOffset(com.google.android.material.appbar.AppBarLayout appBarLayout) {
            androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed bVarB = ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) appBarLayout.getLayoutParams()).b_renamed();
            if (bVarB instanceof com.google.android.material.appbar.AppBarLayout.BaseBehavior) {
                return ((com.google.android.material.appbar.AppBarLayout.BaseBehavior) bVarB).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        com.google.android.material.appbar.AppBarLayout findFirstDependency(java.util.List<android.view.View> list) {
            int size = list.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                android.view.View view = list.get(i_renamed);
                if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                    return (com.google.android.material.appbar.AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(android.view.View view) {
            if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                return ((com.google.android.material.appbar.AppBarLayout) view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }

        private void updateLiftedStateIfNeeded(android.view.View view, android.view.View view2) throws android.content.res.Resources.NotFoundException {
            if (view2 instanceof com.google.android.material.appbar.AppBarLayout) {
                com.google.android.material.appbar.AppBarLayout appBarLayout = (com.google.android.material.appbar.AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }
    }
}
