package com.google.android.material.bottomappbar;

/* loaded from: classes.dex */
public class BottomAppBar extends androidx.appcompat.widget.Toolbar implements androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_BottomAppBar;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private int animatingModeChangeCounter;
    private java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> animationListeners;
    private com.google.android.material.bottomappbar.BottomAppBar.Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;
    android.animation.AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    com.google.android.material.animation.TransformationCallback<com.google.android.material.floatingactionbutton.FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable;
    private android.animation.Animator menuAnimator;
    private android.animation.Animator modeAnimator;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;
    private int rightInset;

    interface AnimationListener {
        void onAnimationEnd(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar);

        void onAnimationStart(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(java.lang.CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(java.lang.CharSequence charSequence) {
    }

    public BottomAppBar(android.content.Context context) {
        this(context, null, 0);
    }

    public BottomAppBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.bottomAppBarStyle);
    }

    public BottomAppBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        this.animatingModeChangeCounter = 0;
        this.fabAttached = true;
        this.fabAnimationListener = new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.google.android.material.bottomappbar.BottomAppBar bottomAppBar = com.google.android.material.bottomappbar.BottomAppBar.this;
                bottomAppBar.maybeAnimateMenuView(bottomAppBar.fabAlignmentMode, com.google.android.material.bottomappbar.BottomAppBar.this.fabAttached);
            }
        };
        this.fabTransformationCallback = new com.google.android.material.animation.TransformationCallback<com.google.android.material.floatingactionbutton.FloatingActionButton>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.2
            @Override // com.google.android.material.animation.TransformationCallback
            public void onScaleChanged(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
                com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }

            @Override // com.google.android.material.animation.TransformationCallback
            public void onTranslationChanged(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
                float translationX = floatingActionButton.getTranslationX();
                if (com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().getHorizontalOffset() != translationX) {
                    com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().setHorizontalOffset(translationX);
                    com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.invalidateSelf();
                }
                float fMax = java.lang.Math.max(0.0f, -floatingActionButton.getTranslationY());
                if (com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().getCradleVerticalOffset() != fMax) {
                    com.google.android.material.bottomappbar.BottomAppBar.this.getTopEdgeTreatment().setCradleVerticalOffset(fMax);
                    com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.invalidateSelf();
                }
                com.google.android.material.bottomappbar.BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }
        };
        android.content.Context context2 = getContext();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.BottomAppBar, i_renamed, DEF_STYLE_RES, new int[0]);
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.materialShapeDrawable.setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.builder().setTopEdge(new com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).build());
        this.materialShapeDrawable.setShadowCompatibilityMode(2);
        this.materialShapeDrawable.setPaintStyle(android.graphics.Paint.Style.FILL);
        this.materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation(dimensionPixelSize);
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.materialShapeDrawable, colorStateList);
        androidx.core.h_renamed.v_renamed.a_renamed(this, this.materialShapeDrawable);
        com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(this, attributeSet, i_renamed, DEF_STYLE_RES, new com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view, androidx.core.h_renamed.ad_renamed adVar, com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
                boolean z_renamed;
                if (com.google.android.material.bottomappbar.BottomAppBar.this.paddingBottomSystemWindowInsets) {
                    com.google.android.material.bottomappbar.BottomAppBar.this.bottomInset = adVar.d_renamed();
                }
                if (com.google.android.material.bottomappbar.BottomAppBar.this.paddingLeftSystemWindowInsets) {
                    z_renamed = com.google.android.material.bottomappbar.BottomAppBar.this.leftInset != adVar.a_renamed();
                    com.google.android.material.bottomappbar.BottomAppBar.this.leftInset = adVar.a_renamed();
                } else {
                    z_renamed = false;
                }
                if (com.google.android.material.bottomappbar.BottomAppBar.this.paddingRightSystemWindowInsets) {
                    z_renamed = com.google.android.material.bottomappbar.BottomAppBar.this.rightInset != adVar.c_renamed();
                    com.google.android.material.bottomappbar.BottomAppBar.this.rightInset = adVar.c_renamed();
                }
                if (z_renamed || z_renamed) {
                    com.google.android.material.bottomappbar.BottomAppBar.this.cancelAnimations();
                    com.google.android.material.bottomappbar.BottomAppBar.this.setCutoutState();
                    com.google.android.material.bottomappbar.BottomAppBar.this.setActionMenuViewPosition();
                }
                return adVar;
            }
        });
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public void setFabAlignmentMode(int i_renamed) {
        maybeAnimateModeChange(i_renamed);
        maybeAnimateMenuView(i_renamed, this.fabAttached);
        this.fabAlignmentMode = i_renamed;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public void setFabAnimationMode(int i_renamed) {
        this.fabAnimationMode = i_renamed;
    }

    public void setBackgroundTint(android.content.res.ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.materialShapeDrawable, colorStateList);
    }

    public android.content.res.ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    public void setFabCradleMargin(float f_renamed) {
        if (f_renamed != getFabCradleMargin()) {
            getTopEdgeTreatment().setFabCradleMargin(f_renamed);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public void setFabCradleRoundedCornerRadius(float f_renamed) {
        if (f_renamed != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f_renamed);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public void setCradleVerticalOffset(float f_renamed) {
        if (f_renamed != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f_renamed);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutState();
        }
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public void setHideOnScroll(boolean z_renamed) {
        this.hideOnScroll = z_renamed;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        this.materialShapeDrawable.setElevation(f_renamed);
        getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void replaceMenu(int i_renamed) {
        getMenu().clear();
        inflateMenu(i_renamed);
    }

    void addAnimationListener(com.google.android.material.bottomappbar.BottomAppBar.AnimationListener animationListener) {
        if (this.animationListeners == null) {
            this.animationListeners = new java.util.ArrayList<>();
        }
        this.animationListeners.add(animationListener);
    }

    void removeAnimationListener(com.google.android.material.bottomappbar.BottomAppBar.AnimationListener animationListener) {
        java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> arrayList = this.animationListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationStart() {
        java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> arrayList;
        int i_renamed = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i_renamed + 1;
        if (i_renamed != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        java.util.Iterator<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        java.util.ArrayList<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> arrayList;
        int i_renamed = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i_renamed;
        if (i_renamed != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        java.util.Iterator<com.google.android.material.bottomappbar.BottomAppBar.AnimationListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this);
        }
    }

    boolean setFabDiameter(int i_renamed) {
        float f_renamed = i_renamed;
        if (f_renamed == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(f_renamed);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    private void maybeAnimateModeChange(int i_renamed) {
        if (this.fabAlignmentMode == i_renamed || !androidx.core.h_renamed.v_renamed.A_renamed(this)) {
            return;
        }
        android.animation.Animator animator = this.modeAnimator;
        if (animator != null) {
            animator.cancel();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.fabAnimationMode == 1) {
            createFabTranslationXAnimation(i_renamed, arrayList);
        } else {
            createFabDefaultXAnimation(i_renamed, arrayList);
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.modeAnimator = animatorSet;
        this.modeAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator2) {
                com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationStart();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator2) {
                com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationEnd();
            }
        });
        this.modeAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.floatingactionbutton.FloatingActionButton findDependentFab() {
        android.view.View viewFindDependentView = findDependentView();
        if (viewFindDependentView instanceof com.google.android.material.floatingactionbutton.FloatingActionButton) {
            return (com.google.android.material.floatingactionbutton.FloatingActionButton) viewFindDependentView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.View findDependentView() {
        if (!(getParent() instanceof androidx.coordinatorlayout.widget.CoordinatorLayout)) {
            return null;
        }
        for (android.view.View view : ((androidx.coordinatorlayout.widget.CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof com.google.android.material.floatingactionbutton.FloatingActionButton) || (view instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    private boolean isFabVisibleOrWillBeShown() {
        com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        return floatingActionButtonFindDependentFab != null && floatingActionButtonFindDependentFab.isOrWillBeShown();
    }

    protected void createFabDefaultXAnimation(final int i_renamed, java.util.List<android.animation.Animator> list) {
        com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        if (floatingActionButtonFindDependentFab == null || floatingActionButtonFindDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        floatingActionButtonFindDependentFab.hide(new com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void onHidden(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
                floatingActionButton.setTranslationX(com.google.android.material.bottomappbar.BottomAppBar.this.getFabTranslationX(i_renamed));
                floatingActionButton.show(new com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                    public void onShown(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton2) {
                        com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationEnd();
                    }
                });
            }
        });
    }

    private void createFabTranslationXAnimation(int i_renamed, java.util.List<android.animation.Animator> list) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(findDependentFab(), "translationX", getFabTranslationX(i_renamed));
        objectAnimatorOfFloat.setDuration(ANIMATION_DURATION);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeAnimateMenuView(int i_renamed, boolean z_renamed) {
        if (androidx.core.h_renamed.v_renamed.A_renamed(this)) {
            android.animation.Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (!isFabVisibleOrWillBeShown()) {
                i_renamed = 0;
                z_renamed = false;
            }
            createMenuViewTranslationAnimation(i_renamed, z_renamed, arrayList);
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.menuAnimator = animatorSet;
            this.menuAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator2) {
                    com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationStart();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator2) {
                    com.google.android.material.bottomappbar.BottomAppBar.this.dispatchAnimationEnd();
                    com.google.android.material.bottomappbar.BottomAppBar.this.menuAnimator = null;
                }
            });
            this.menuAnimator.start();
        }
    }

    private void createMenuViewTranslationAnimation(final int i_renamed, final boolean z_renamed, java.util.List<android.animation.Animator> list) {
        final androidx.appcompat.widget.ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        android.animation.Animator animatorOfFloat = android.animation.ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (java.lang.Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i_renamed, z_renamed)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7
                public boolean cancelled;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    this.cancelled = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (this.cancelled) {
                        return;
                    }
                    com.google.android.material.bottomappbar.BottomAppBar.this.translateActionMenuView(actionMenuView, i_renamed, z_renamed);
                }
            });
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX(int i_renamed) {
        boolean zIsLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(this);
        if (i_renamed == 1) {
            return ((getMeasuredWidth() / 2) - (this.fabOffsetEndMode + (zIsLayoutRtl ? this.leftInset : this.rightInset))) * (zIsLayoutRtl ? -1 : 1);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    private androidx.appcompat.widget.ActionMenuView getActionMenuView() {
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (childAt instanceof androidx.appcompat.widget.ActionMenuView) {
                return (androidx.appcompat.widget.ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateActionMenuView(androidx.appcompat.widget.ActionMenuView actionMenuView, int i_renamed, boolean z_renamed) {
        actionMenuView.setTranslationX(getActionMenuViewTranslationX(actionMenuView, i_renamed, z_renamed));
    }

    protected int getActionMenuViewTranslationX(androidx.appcompat.widget.ActionMenuView actionMenuView, int i_renamed, boolean z_renamed) {
        if (i_renamed != 1 || !z_renamed) {
            return 0;
        }
        boolean zIsLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(this);
        int measuredWidth = zIsLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            android.view.View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof androidx.appcompat.widget.Toolbar.b_renamed) && (((androidx.appcompat.widget.Toolbar.b_renamed) childAt.getLayoutParams()).f264a & 8388615) == 8388611) {
                if (zIsLayoutRtl) {
                    measuredWidth = java.lang.Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = java.lang.Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((zIsLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zIsLayoutRtl ? this.rightInset : -this.leftInset));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimations() {
        android.animation.Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        android.animation.Animator animator2 = this.modeAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        if (z_renamed) {
            cancelAnimations();
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCutoutState() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        android.view.View viewFindDependentView = findDependentView();
        this.materialShapeDrawable.setInterpolation((this.fabAttached && isFabVisibleOrWillBeShown()) ? 1.0f : 0.0f);
        if (viewFindDependentView != null) {
            viewFindDependentView.setTranslationY(getFabTranslationY());
            viewFindDependentView.setTranslationX(getFabTranslationX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionMenuViewPosition() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!isFabVisibleOrWillBeShown()) {
                translateActionMenuView(actionMenuView, 0, false);
            } else {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFabAnimationListeners(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.google.android.material.bottomappbar.BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
                com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButtonFindDependentFab = com.google.android.material.bottomappbar.BottomAppBar.this.findDependentFab();
                if (floatingActionButtonFindDependentFab != null) {
                    floatingActionButtonFindDependentFab.setTranslationX(com.google.android.material.bottomappbar.BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.bottomInset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.rightInset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.leftInset;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed
    public com.google.android.material.bottomappbar.BottomAppBar.Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new com.google.android.material.bottomappbar.BottomAppBar.Behavior();
        }
        return this.behavior;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) getParent()).setClipChildren(false);
        }
    }

    public static class Behavior extends com.google.android.material.behavior.HideBottomViewOnScrollBehavior<com.google.android.material.bottomappbar.BottomAppBar> {
        private final android.graphics.Rect fabContentRect;
        private final android.view.View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private java.lang.ref.WeakReference<com.google.android.material.bottomappbar.BottomAppBar> viewRef;

        public Behavior() {
            this.fabLayoutListener = new android.view.View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    com.google.android.material.bottomappbar.BottomAppBar bottomAppBar = (com.google.android.material.bottomappbar.BottomAppBar) com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.viewRef.get();
                    if (bottomAppBar == null || !(view instanceof com.google.android.material.floatingactionbutton.FloatingActionButton)) {
                        view.removeOnLayoutChangeListener(this);
                        return;
                    }
                    com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = (com.google.android.material.floatingactionbutton.FloatingActionButton) view;
                    floatingActionButton.getMeasuredContentRect(com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.fabContentRect);
                    int iHeight = com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.fabContentRect.height();
                    bottomAppBar.setFabDiameter(iHeight);
                    androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar = (androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) view.getLayoutParams();
                    if (com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.originalBottomMargin == 0) {
                        eVar.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                        eVar.leftMargin = bottomAppBar.getLeftInset();
                        eVar.rightMargin = bottomAppBar.getRightInset();
                        if (com.google.android.material.internal.ViewUtils.isLayoutRtl(floatingActionButton)) {
                            eVar.leftMargin += bottomAppBar.fabOffsetEndMode;
                        } else {
                            eVar.rightMargin += bottomAppBar.fabOffsetEndMode;
                        }
                    }
                }
            };
            this.fabContentRect = new android.graphics.Rect();
        }

        public Behavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabLayoutListener = new android.view.View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    com.google.android.material.bottomappbar.BottomAppBar bottomAppBar = (com.google.android.material.bottomappbar.BottomAppBar) com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.viewRef.get();
                    if (bottomAppBar == null || !(view instanceof com.google.android.material.floatingactionbutton.FloatingActionButton)) {
                        view.removeOnLayoutChangeListener(this);
                        return;
                    }
                    com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = (com.google.android.material.floatingactionbutton.FloatingActionButton) view;
                    floatingActionButton.getMeasuredContentRect(com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.fabContentRect);
                    int iHeight = com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.fabContentRect.height();
                    bottomAppBar.setFabDiameter(iHeight);
                    androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar = (androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) view.getLayoutParams();
                    if (com.google.android.material.bottomappbar.BottomAppBar.Behavior.this.originalBottomMargin == 0) {
                        eVar.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                        eVar.leftMargin = bottomAppBar.getLeftInset();
                        eVar.rightMargin = bottomAppBar.getRightInset();
                        if (com.google.android.material.internal.ViewUtils.isLayoutRtl(floatingActionButton)) {
                            eVar.leftMargin += bottomAppBar.fabOffsetEndMode;
                        } else {
                            eVar.rightMargin += bottomAppBar.fabOffsetEndMode;
                        }
                    }
                }
            };
            this.fabContentRect = new android.graphics.Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, int i_renamed) {
            this.viewRef = new java.lang.ref.WeakReference<>(bottomAppBar);
            android.view.View viewFindDependentView = bottomAppBar.findDependentView();
            if (viewFindDependentView != null && !androidx.core.h_renamed.v_renamed.A_renamed(viewFindDependentView)) {
                androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar = (androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) viewFindDependentView.getLayoutParams();
                eVar.d_renamed = 49;
                this.originalBottomMargin = eVar.bottomMargin;
                if (viewFindDependentView instanceof com.google.android.material.floatingactionbutton.FloatingActionButton) {
                    com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = (com.google.android.material.floatingactionbutton.FloatingActionButton) viewFindDependentView;
                    floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                    bottomAppBar.addFabAnimationListeners(floatingActionButton);
                }
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i_renamed);
            return super.onLayoutChild(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) bottomAppBar, i_renamed);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, android.view.View view, android.view.View view2, int i_renamed, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) bottomAppBar, view, view2, i_renamed, i2);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.bottomappbar.BottomAppBar.SavedState savedState = new com.google.android.material.bottomappbar.BottomAppBar.SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.bottomappbar.BottomAppBar.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.bottomappbar.BottomAppBar.SavedState savedState = (com.google.android.material.bottomappbar.BottomAppBar.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.bottomappbar.BottomAppBar.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.bottomappbar.BottomAppBar.SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.google.android.material.bottomappbar.BottomAppBar.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.bottomappbar.BottomAppBar.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomappbar.BottomAppBar.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.bottomappbar.BottomAppBar.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomappbar.BottomAppBar.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.bottomappbar.BottomAppBar.SavedState[i_renamed];
            }
        };
        int fabAlignmentMode;
        boolean fabAttached;

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }
    }
}
