package com.google.android.material.appbar;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends android.widget.FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_CollapsingToolbar;
    final com.google.android.material.internal.CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;
    private android.graphics.drawable.Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private android.view.View dummyView;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    androidx.core.h_renamed.ad_renamed lastInsets;
    private com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private android.animation.ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;
    android.graphics.drawable.Drawable statusBarScrim;
    private final android.graphics.Rect tmpRect;
    private androidx.appcompat.widget.Toolbar toolbar;
    private android.view.View toolbarDirectChild;
    private int toolbarId;

    public CollapsingToolbarLayout(android.content.Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.refreshToolbar = true;
        this.tmpRect = new android.graphics.Rect();
        this.scrimVisibleHeightTrigger = -1;
        android.content.Context context2 = getContext();
        this.collapsingTextHelper = new com.google.android.material.internal.CollapsingTextHelper(this);
        this.collapsingTextHelper.setTextSizeInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout, i_renamed, DEF_STYLE_RES, new int[0]);
        this.collapsingTextHelper.setExpandedTextGravity(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleGravity, com.google.android.material.badge.BadgeDrawable.BOTTOM_START));
        this.collapsingTextHelper.setCollapsedTextGravity(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = dimensionPixelSize;
        this.expandedMarginEnd = dimensionPixelSize;
        this.expandedMarginTop = dimensionPixelSize;
        this.expandedMarginStart = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.expandedMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.expandedMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.expandedMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.expandedMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.collapsingTitleEnabled = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_title));
        this.collapsingTextHelper.setExpandedTextAppearance(com.google.android.material.R_renamed.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.collapsingTextHelper.setCollapsedTextAppearance(androidx.appcompat.R_renamed.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.collapsingTextHelper.setExpandedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.collapsingTextHelper.setCollapsedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.scrimVisibleHeightTrigger = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_maxLines)) {
            this.collapsingTextHelper.setMaxLines(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        this.scrimAnimationDuration = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_scrimAnimationDuration, DEFAULT_SCRIM_ANIMATION_DURATION);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.toolbarId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_toolbarId, -1);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        androidx.core.h_renamed.v_renamed.a_renamed(this, new androidx.core.h_renamed.q_renamed() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.1
            @Override // androidx.core.h_renamed.q_renamed
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view, androidx.core.h_renamed.ad_renamed adVar) {
                return com.google.android.material.appbar.CollapsingToolbarLayout.this.onWindowInsetChanged(adVar);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.Object parent = getParent();
        if (parent instanceof com.google.android.material.appbar.AppBarLayout) {
            androidx.core.h_renamed.v_renamed.b_renamed(this, androidx.core.h_renamed.v_renamed.t_renamed((android.view.View) parent));
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new com.google.android.material.appbar.CollapsingToolbarLayout.OffsetUpdateListener();
            }
            ((com.google.android.material.appbar.AppBarLayout) parent).addOnOffsetChangedListener(this.onOffsetChangedListener);
            androidx.core.h_renamed.v_renamed.s_renamed(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        android.view.ViewParent parent = getParent();
        com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof com.google.android.material.appbar.AppBarLayout)) {
            ((com.google.android.material.appbar.AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    androidx.core.h_renamed.ad_renamed onWindowInsetChanged(androidx.core.h_renamed.ad_renamed adVar) {
        androidx.core.h_renamed.ad_renamed adVar2 = androidx.core.h_renamed.v_renamed.t_renamed(this) ? adVar : null;
        if (!androidx.core.g_renamed.c_renamed.a_renamed(this.lastInsets, adVar2)) {
            this.lastInsets = adVar2;
            requestLayout();
        }
        return adVar.g_renamed();
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
            drawable.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            this.collapsingTextHelper.draw(canvas);
        }
        if (this.statusBarScrim == null || this.scrimAlpha <= 0) {
            return;
        }
        androidx.core.h_renamed.ad_renamed adVar = this.lastInsets;
        int iB = adVar != null ? adVar.b_renamed() : 0;
        if (iB > 0) {
            this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), iB - this.currentOffset);
            this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
            this.statusBarScrim.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j_renamed) {
        boolean z_renamed;
        if (this.contentScrim == null || this.scrimAlpha <= 0 || !isToolbarChild(view)) {
            z_renamed = false;
        } else {
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
            z_renamed = true;
        }
        return super.drawChild(canvas, view, j_renamed) || z_renamed;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        android.graphics.drawable.Drawable drawable = this.contentScrim;
        if (drawable != null) {
            drawable.setBounds(0, 0, i_renamed, i2);
        }
    }

    private void ensureToolbar() {
        if (this.refreshToolbar) {
            androidx.appcompat.widget.Toolbar toolbar = null;
            this.toolbar = null;
            this.toolbarDirectChild = null;
            int i_renamed = this.toolbarId;
            if (i_renamed != -1) {
                this.toolbar = (androidx.appcompat.widget.Toolbar) findViewById(i_renamed);
                androidx.appcompat.widget.Toolbar toolbar2 = this.toolbar;
                if (toolbar2 != null) {
                    this.toolbarDirectChild = findDirectChild(toolbar2);
                }
            }
            if (this.toolbar == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    android.view.View childAt = getChildAt(i2);
                    if (childAt instanceof androidx.appcompat.widget.Toolbar) {
                        toolbar = (androidx.appcompat.widget.Toolbar) childAt;
                        break;
                    }
                    i2++;
                }
                this.toolbar = toolbar;
            }
            updateDummyView();
            this.refreshToolbar = false;
        }
    }

    private boolean isToolbarChild(android.view.View view) {
        android.view.View view2 = this.toolbarDirectChild;
        if (view2 == null || view2 == this) {
            if (view == this.toolbar) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private android.view.View findDirectChild(android.view.View view) {
        for (android.view.ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof android.view.View) {
                view = parent;
            }
        }
        return view;
    }

    private void updateDummyView() {
        android.view.View view;
        if (!this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            android.view.ViewParent parent = view.getParent();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).removeView(this.dummyView);
            }
        }
        if (!this.collapsingTitleEnabled || this.toolbar == null) {
            return;
        }
        if (this.dummyView == null) {
            this.dummyView = new android.view.View(getContext());
        }
        if (this.dummyView.getParent() == null) {
            this.toolbar.addView(this.dummyView, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        ensureToolbar();
        super.onMeasure(i_renamed, i2);
        int mode = android.view.View.MeasureSpec.getMode(i2);
        androidx.core.h_renamed.ad_renamed adVar = this.lastInsets;
        int iB = adVar != null ? adVar.b_renamed() : 0;
        if (mode != 0 || iB <= 0) {
            return;
        }
        super.onMeasure(i_renamed, android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iB, 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        android.view.View view;
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        androidx.core.h_renamed.ad_renamed adVar = this.lastInsets;
        if (adVar != null) {
            int iB = adVar.b_renamed();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                android.view.View childAt = getChildAt(i5);
                if (!androidx.core.h_renamed.v_renamed.t_renamed(childAt) && childAt.getTop() < iB) {
                    androidx.core.h_renamed.v_renamed.e_renamed(childAt, iB);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            getViewOffsetHelper(getChildAt(i6)).onViewLayout();
        }
        if (this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            this.drawCollapsingTitle = androidx.core.h_renamed.v_renamed.D_renamed(view) && this.dummyView.getVisibility() == 0;
            if (this.drawCollapsingTitle) {
                boolean z2 = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
                android.view.View view2 = this.toolbarDirectChild;
                if (view2 == null) {
                    view2 = this.toolbar;
                }
                int maxOffsetForPinChild = getMaxOffsetForPinChild(view2);
                com.google.android.material.internal.DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
                this.collapsingTextHelper.setCollapsedBounds(this.tmpRect.left + (z2 ? this.toolbar.getTitleMarginEnd() : this.toolbar.getTitleMarginStart()), this.tmpRect.top + maxOffsetForPinChild + this.toolbar.getTitleMarginTop(), this.tmpRect.right + (z2 ? this.toolbar.getTitleMarginStart() : this.toolbar.getTitleMarginEnd()), (this.tmpRect.bottom + maxOffsetForPinChild) - this.toolbar.getTitleMarginBottom());
                this.collapsingTextHelper.setExpandedBounds(z2 ? this.expandedMarginEnd : this.expandedMarginStart, this.tmpRect.top + this.expandedMarginTop, (i3 - i_renamed) - (z2 ? this.expandedMarginStart : this.expandedMarginEnd), (i4 - i2) - this.expandedMarginBottom);
                this.collapsingTextHelper.recalculate();
            }
        }
        if (this.toolbar != null) {
            if (this.collapsingTitleEnabled && android.text.TextUtils.isEmpty(this.collapsingTextHelper.getText())) {
                setTitle(this.toolbar.getTitle());
            }
            android.view.View view3 = this.toolbarDirectChild;
            if (view3 == null || view3 == this) {
                setMinimumHeight(getHeightWithMargins(this.toolbar));
            } else {
                setMinimumHeight(getHeightWithMargins(view3));
            }
        }
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            getViewOffsetHelper(getChildAt(i7)).applyOffsets();
        }
    }

    private static int getHeightWithMargins(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    static com.google.android.material.appbar.ViewOffsetHelper getViewOffsetHelper(android.view.View view) {
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = (com.google.android.material.appbar.ViewOffsetHelper) view.getTag(com.google.android.material.R_renamed.id_renamed.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper2 = new com.google.android.material.appbar.ViewOffsetHelper(view);
        view.setTag(com.google.android.material.R_renamed.id_renamed.view_offset_helper, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.collapsingTextHelper.setText(charSequence);
        updateContentDescriptionFromTitle();
    }

    public java.lang.CharSequence getTitle() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingTextHelper.getText();
        }
        return null;
    }

    public void setTitleEnabled(boolean z_renamed) {
        if (z_renamed != this.collapsingTitleEnabled) {
            this.collapsingTitleEnabled = z_renamed;
            updateContentDescriptionFromTitle();
            updateDummyView();
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    public void setScrimsShown(boolean z_renamed) {
        setScrimsShown(z_renamed, androidx.core.h_renamed.v_renamed.A_renamed(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z_renamed, boolean z2) {
        if (this.scrimsAreShown != z_renamed) {
            if (z2) {
                animateScrim(z_renamed ? 255 : 0);
            } else {
                setScrimAlpha(z_renamed ? 255 : 0);
            }
            this.scrimsAreShown = z_renamed;
        }
    }

    private void animateScrim(int i_renamed) {
        ensureToolbar();
        android.animation.ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            this.scrimAnimator = new android.animation.ValueAnimator();
            this.scrimAnimator.setDuration(this.scrimAnimationDuration);
            this.scrimAnimator.setInterpolator(i_renamed > this.scrimAlpha ? com.google.android.material.animation.AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            this.scrimAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    com.google.android.material.appbar.CollapsingToolbarLayout.this.setScrimAlpha(((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.scrimAnimator.cancel();
        }
        this.scrimAnimator.setIntValues(this.scrimAlpha, i_renamed);
        this.scrimAnimator.start();
    }

    void setScrimAlpha(int i_renamed) {
        androidx.appcompat.widget.Toolbar toolbar;
        if (i_renamed != this.scrimAlpha) {
            if (this.contentScrim != null && (toolbar = this.toolbar) != null) {
                androidx.core.h_renamed.v_renamed.e_renamed(toolbar);
            }
            this.scrimAlpha = i_renamed;
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public void setContentScrim(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.contentScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.contentScrim = drawable != null ? drawable.mutate() : null;
            android.graphics.drawable.Drawable drawable3 = this.contentScrim;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    public void setContentScrimColor(int i_renamed) {
        setContentScrim(new android.graphics.drawable.ColorDrawable(i_renamed));
    }

    public void setContentScrimResource(int i_renamed) {
        setContentScrim(androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public android.graphics.drawable.Drawable getContentScrim() {
        return this.contentScrim;
    }

    public void setStatusBarScrim(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.graphics.drawable.Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.statusBarScrim = drawable != null ? drawable.mutate() : null;
            android.graphics.drawable.Drawable drawable3 = this.statusBarScrim;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarScrim.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a_renamed.b_renamed(this.statusBarScrim, androidx.core.h_renamed.v_renamed.g_renamed(this));
                this.statusBarScrim.setVisible(getVisibility() == 0, false);
                this.statusBarScrim.setCallback(this);
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        android.graphics.drawable.Drawable drawable = this.statusBarScrim;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        android.graphics.drawable.Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null) {
            state |= collapsingTextHelper.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim;
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed);
        boolean z_renamed = i_renamed == 0;
        android.graphics.drawable.Drawable drawable = this.statusBarScrim;
        if (drawable != null && drawable.isVisible() != z_renamed) {
            this.statusBarScrim.setVisible(z_renamed, false);
        }
        android.graphics.drawable.Drawable drawable2 = this.contentScrim;
        if (drawable2 == null || drawable2.isVisible() == z_renamed) {
            return;
        }
        this.contentScrim.setVisible(z_renamed, false);
    }

    public void setStatusBarScrimColor(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setStatusBarScrim(new android.graphics.drawable.ColorDrawable(i_renamed));
    }

    public void setStatusBarScrimResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setStatusBarScrim(androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public android.graphics.drawable.Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public void setCollapsedTitleTextAppearance(int i_renamed) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i_renamed);
    }

    public void setCollapsedTitleTextColor(int i_renamed) {
        setCollapsedTitleTextColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setCollapsedTitleTextColor(android.content.res.ColorStateList colorStateList) {
        this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleGravity(int i_renamed) {
        this.collapsingTextHelper.setCollapsedTextGravity(i_renamed);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    public void setExpandedTitleTextAppearance(int i_renamed) {
        this.collapsingTextHelper.setExpandedTextAppearance(i_renamed);
    }

    public void setExpandedTitleColor(int i_renamed) {
        setExpandedTitleTextColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setExpandedTitleTextColor(android.content.res.ColorStateList colorStateList) {
        this.collapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleGravity(int i_renamed) {
        this.collapsingTextHelper.setExpandedTextGravity(i_renamed);
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public void setCollapsedTitleTypeface(android.graphics.Typeface typeface) {
        this.collapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public android.graphics.Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    public void setExpandedTitleTypeface(android.graphics.Typeface typeface) {
        this.collapsingTextHelper.setExpandedTypeface(typeface);
    }

    public android.graphics.Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    public void setExpandedTitleMargin(int i_renamed, int i2, int i3, int i4) {
        this.expandedMarginStart = i_renamed;
        this.expandedMarginTop = i2;
        this.expandedMarginEnd = i3;
        this.expandedMarginBottom = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public void setExpandedTitleMarginStart(int i_renamed) {
        this.expandedMarginStart = i_renamed;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public void setExpandedTitleMarginTop(int i_renamed) {
        this.expandedMarginTop = i_renamed;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public void setExpandedTitleMarginEnd(int i_renamed) {
        this.expandedMarginEnd = i_renamed;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public void setExpandedTitleMarginBottom(int i_renamed) {
        this.expandedMarginBottom = i_renamed;
        requestLayout();
    }

    public void setMaxLines(int i_renamed) {
        this.collapsingTextHelper.setMaxLines(i_renamed);
    }

    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    public void setScrimVisibleHeightTrigger(int i_renamed) {
        if (this.scrimVisibleHeightTrigger != i_renamed) {
            this.scrimVisibleHeightTrigger = i_renamed;
            updateScrimVisibility();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i_renamed = this.scrimVisibleHeightTrigger;
        if (i_renamed >= 0) {
            return i_renamed;
        }
        androidx.core.h_renamed.ad_renamed adVar = this.lastInsets;
        int iB = adVar != null ? adVar.b_renamed() : 0;
        int iM = androidx.core.h_renamed.v_renamed.m_renamed(this);
        if (iM > 0) {
            return java.lang.Math.min((iM * 2) + iB, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j_renamed) {
        this.scrimAnimationDuration = j_renamed;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams generateDefaultLayoutParams() {
        return new com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams(layoutParams);
    }

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, DEFAULT_PARALLAX_MULTIPLIER));
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(int i_renamed, int i2, int i3) {
            super(i_renamed, i2, i3);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public void setCollapseMode(int i_renamed) {
            this.collapseMode = i_renamed;
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public void setParallaxMultiplier(float f_renamed) {
            this.parallaxMult = f_renamed;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }
    }

    final void updateScrimVisibility() {
        if (this.contentScrim == null && this.statusBarScrim == null) {
            return;
        }
        setScrimsShown(getHeight() + this.currentOffset < getScrimVisibleHeightTrigger());
    }

    final int getMaxOffsetForPinChild(android.view.View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private class OffsetUpdateListener implements com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i_renamed) {
            com.google.android.material.appbar.CollapsingToolbarLayout collapsingToolbarLayout = com.google.android.material.appbar.CollapsingToolbarLayout.this;
            collapsingToolbarLayout.currentOffset = i_renamed;
            int iB = collapsingToolbarLayout.lastInsets != null ? com.google.android.material.appbar.CollapsingToolbarLayout.this.lastInsets.b_renamed() : 0;
            int childCount = com.google.android.material.appbar.CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = com.google.android.material.appbar.CollapsingToolbarLayout.this.getChildAt(i2);
                com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams layoutParams = (com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams) childAt.getLayoutParams();
                com.google.android.material.appbar.ViewOffsetHelper viewOffsetHelper = com.google.android.material.appbar.CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                int i3 = layoutParams.collapseMode;
                if (i3 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(androidx.core.c_renamed.a_renamed.a_renamed(-i_renamed, 0, com.google.android.material.appbar.CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i3 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(java.lang.Math.round((-i_renamed) * layoutParams.parallaxMult));
                }
            }
            com.google.android.material.appbar.CollapsingToolbarLayout.this.updateScrimVisibility();
            if (com.google.android.material.appbar.CollapsingToolbarLayout.this.statusBarScrim != null && iB > 0) {
                androidx.core.h_renamed.v_renamed.e_renamed(com.google.android.material.appbar.CollapsingToolbarLayout.this);
            }
            com.google.android.material.appbar.CollapsingToolbarLayout.this.collapsingTextHelper.setExpansionFraction(java.lang.Math.abs(i_renamed) / ((com.google.android.material.appbar.CollapsingToolbarLayout.this.getHeight() - androidx.core.h_renamed.v_renamed.m_renamed(com.google.android.material.appbar.CollapsingToolbarLayout.this)) - iB));
        }
    }
}
