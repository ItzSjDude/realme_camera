package com.google.android.material.floatingactionbutton;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends com.google.android.material.button.MaterialButton implements androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private int animState;
    private final androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> behavior;
    private final com.google.android.material.floatingactionbutton.AnimatorTracker changeVisibilityTracker;
    private final com.google.android.material.floatingactionbutton.MotionStrategy extendStrategy;
    private final com.google.android.material.floatingactionbutton.MotionStrategy hideStrategy;
    private boolean isExtended;
    private final com.google.android.material.floatingactionbutton.MotionStrategy showStrategy;
    private final com.google.android.material.floatingactionbutton.MotionStrategy shrinkStrategy;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final android.util.Property<android.view.View, java.lang.Float> WIDTH = new android.util.Property<android.view.View, java.lang.Float>(java.lang.Float.class, "width") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.4
        @Override // android.util.Property
        public void set(android.view.View view, java.lang.Float f_renamed) {
            view.getLayoutParams().width = f_renamed.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(view.getLayoutParams().width);
        }
    };
    static final android.util.Property<android.view.View, java.lang.Float> HEIGHT = new android.util.Property<android.view.View, java.lang.Float>(java.lang.Float.class, "height") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5
        @Override // android.util.Property
        public void set(android.view.View view, java.lang.Float f_renamed) {
            view.getLayoutParams().height = f_renamed.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(view.getLayoutParams().height);
        }
    };

    public static abstract class OnChangedCallback {
        public void onExtended(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onHidden(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShown(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShrunken(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    interface Size {
        int getHeight();

        android.view.ViewGroup.LayoutParams getLayoutParams();

        int getWidth();
    }

    public ExtendedFloatingActionButton(android.content.Context context) {
        this(context, null);
    }

    public ExtendedFloatingActionButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.extendedFloatingActionButtonStyle);
    }

    public ExtendedFloatingActionButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.animState = 0;
        this.changeVisibilityTracker = new com.google.android.material.floatingactionbutton.AnimatorTracker();
        this.showStrategy = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ShowStrategy(this.changeVisibilityTracker);
        this.hideStrategy = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.HideStrategy(this.changeVisibilityTracker);
        this.isExtended = true;
        android.content.Context context2 = getContext();
        this.behavior = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton, i_renamed, DEF_STYLE_RES, new int[0]);
        com.google.android.material.animation.MotionSpec motionSpecCreateFromAttribute = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton_showMotionSpec);
        com.google.android.material.animation.MotionSpec motionSpecCreateFromAttribute2 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        com.google.android.material.animation.MotionSpec motionSpecCreateFromAttribute3 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        com.google.android.material.animation.MotionSpec motionSpecCreateFromAttribute4 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker = new com.google.android.material.floatingactionbutton.AnimatorTracker();
        this.extendStrategy = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy(animatorTracker, new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getWidth() {
                return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getMeasuredWidth();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getHeight() {
                return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getMeasuredHeight();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public android.view.ViewGroup.LayoutParams getLayoutParams() {
                return new android.view.ViewGroup.LayoutParams(-2, -2);
            }
        }, true);
        this.shrinkStrategy = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy(animatorTracker, new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.2
            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getWidth() {
                return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getCollapsedSize();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getHeight() {
                return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getCollapsedSize();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public android.view.ViewGroup.LayoutParams getLayoutParams() {
                return new android.view.ViewGroup.LayoutParams(getWidth(), getHeight());
            }
        }, false);
        this.showStrategy.setMotionSpec(motionSpecCreateFromAttribute);
        this.hideStrategy.setMotionSpec(motionSpecCreateFromAttribute2);
        this.extendStrategy.setMotionSpec(motionSpecCreateFromAttribute3);
        this.shrinkStrategy.setMotionSpec(motionSpecCreateFromAttribute4);
        typedArrayObtainStyledAttributes.recycle();
        setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i_renamed, DEF_STYLE_RES, com.google.android.material.shape.ShapeAppearanceModel.PILL).build());
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && android.text.TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.performNow();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed
    public androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    public void setExtended(boolean z_renamed) {
        if (this.isExtended == z_renamed) {
            return;
        }
        com.google.android.material.floatingactionbutton.MotionStrategy motionStrategy = z_renamed ? this.extendStrategy : this.shrinkStrategy;
        if (motionStrategy.shouldCancel()) {
            return;
        }
        motionStrategy.performNow();
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    public void addOnShowAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.showStrategy.addAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.showStrategy.removeAnimationListener(animatorListener);
    }

    public void addOnHideAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.hideStrategy.addAnimationListener(animatorListener);
    }

    public void removeOnHideAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.hideStrategy.removeAnimationListener(animatorListener);
    }

    public void addOnShrinkAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.addAnimationListener(animatorListener);
    }

    public void removeOnShrinkAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.removeAnimationListener(animatorListener);
    }

    public void addOnExtendAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.extendStrategy.addAnimationListener(animatorListener);
    }

    public void removeOnExtendAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.extendStrategy.removeAnimationListener(animatorListener);
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public void hide(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.hideStrategy, onChangedCallback);
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void show(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.showStrategy, onChangedCallback);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    public void extend(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.extendStrategy, onChangedCallback);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void shrink(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        performMotion(this.shrinkStrategy, onChangedCallback);
    }

    public com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    public void setShowMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        this.showStrategy.setMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(int i_renamed) {
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i_renamed));
    }

    public com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    public void setHideMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        this.hideStrategy.setMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(int i_renamed) {
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i_renamed));
    }

    public com.google.android.material.animation.MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    public void setExtendMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        this.extendStrategy.setMotionSpec(motionSpec);
    }

    public void setExtendMotionSpecResource(int i_renamed) {
        setExtendMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i_renamed));
    }

    public com.google.android.material.animation.MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    public void setShrinkMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        this.shrinkStrategy.setMotionSpec(motionSpec);
    }

    public void setShrinkMotionSpecResource(int i_renamed) {
        setShrinkMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i_renamed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performMotion(final com.google.android.material.floatingactionbutton.MotionStrategy motionStrategy, final com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
        if (motionStrategy.shouldCancel()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            motionStrategy.performNow();
            motionStrategy.onChange(onChangedCallback);
            return;
        }
        measure(0, 0);
        android.animation.AnimatorSet animatorSetCreateAnimator = motionStrategy.createAnimator();
        animatorSetCreateAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.3
            private boolean cancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                motionStrategy.onAnimationStart(animator);
                this.cancelled = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                this.cancelled = true;
                motionStrategy.onAnimationCancel();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                motionStrategy.onAnimationEnd();
                if (this.cancelled) {
                    return;
                }
                motionStrategy.onChange(onChangedCallback);
            }
        });
        java.util.Iterator<android.animation.Animator.AnimatorListener> it = motionStrategy.getListeners().iterator();
        while (it.hasNext()) {
            animatorSetCreateAnimator.addListener(it.next());
        }
        animatorSetCreateAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeShown() {
        return getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeHidden() {
        return getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    private boolean shouldAnimateVisibilityChange() {
        return androidx.core.h_renamed.v_renamed.A_renamed(this) && !isInEditMode();
    }

    int getCollapsedSize() {
        return (java.lang.Math.min(androidx.core.h_renamed.v_renamed.j_renamed(this), androidx.core.h_renamed.v_renamed.k_renamed(this)) * 2) + getIconSize();
    }

    protected static class ExtendedFloatingActionButtonBehavior<T_renamed extends com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<T_renamed> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;
        private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback internalAutoHideCallback;
        private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback internalAutoShrinkCallback;
        private android.graphics.Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public ExtendedFloatingActionButtonBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void setAutoHideEnabled(boolean z_renamed) {
            this.autoHideEnabled = z_renamed;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public void setAutoShrinkEnabled(boolean z_renamed) {
            this.autoShrinkEnabled = z_renamed;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean getInsetDodgeRect(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, android.graphics.Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (androidx.coordinatorlayout.widget.CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public void onAttachedToLayoutParams(androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar) {
            if (eVar.h_renamed == 0) {
                eVar.h_renamed = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, android.view.View view) {
            if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
            return false;
        }

        private static boolean isBottomSheet(android.view.View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) {
                return ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) layoutParams).b_renamed() instanceof com.google.android.material.bottomsheet.BottomSheetBehavior;
            }
            return false;
        }

        void setInternalAutoHideCallback(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            this.internalAutoHideCallback = onChangedCallback;
        }

        void setInternalAutoShrinkCallback(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            this.internalAutoShrinkCallback = onChangedCallback;
        }

        private boolean shouldUpdateVisibility(android.view.View view, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.autoHideEnabled || this.autoShrinkEnabled) && ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) extendedFloatingActionButton.getLayoutParams()).a_renamed() == view.getId();
        }

        private boolean updateFabVisibilityForAppBarLayout(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new android.graphics.Rect();
            }
            android.graphics.Rect rect = this.tmpRect;
            com.google.android.material.internal.DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(android.view.View view, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        protected void shrinkOrHide(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.performMotion(this.autoShrinkEnabled ? extendedFloatingActionButton.shrinkStrategy : extendedFloatingActionButton.hideStrategy, this.autoShrinkEnabled ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        protected void extendOrShow(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.performMotion(this.autoShrinkEnabled ? extendedFloatingActionButton.extendStrategy : extendedFloatingActionButton.showStrategy, this.autoShrinkEnabled ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, int i_renamed) {
            java.util.List<android.view.View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                android.view.View view = dependencies.get(i2);
                if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i_renamed);
            return true;
        }
    }

    class ChangeSizeStrategy extends com.google.android.material.floatingactionbutton.BaseMotionStrategy {
        private final boolean extending;
        private final com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size size;

        ChangeSizeStrategy(com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size size, boolean z_renamed) {
            super(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this, animatorTracker);
            this.size = size;
            this.extending = z_renamed;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isExtended = this.extending;
            android.view.ViewGroup.LayoutParams layoutParams = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.extending) {
                onChangedCallback.onExtended(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            } else {
                onChangedCallback.onShrunken(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return com.google.android.material.R_renamed.animator.mtrl_extended_fab_change_size_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public android.animation.AnimatorSet createAnimator() {
            com.google.android.material.animation.MotionSpec currentMotionSpec = getCurrentMotionSpec();
            if (currentMotionSpec.hasPropertyValues("width")) {
                android.animation.PropertyValuesHolder[] propertyValues = currentMotionSpec.getPropertyValues("width");
                propertyValues[0].setFloatValues(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getWidth(), this.size.getWidth());
                currentMotionSpec.setPropertyValues("width", propertyValues);
            }
            if (currentMotionSpec.hasPropertyValues("height")) {
                android.animation.PropertyValuesHolder[] propertyValues2 = currentMotionSpec.getPropertyValues("height");
                propertyValues2[0].setFloatValues(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getHeight(), this.size.getHeight());
                currentMotionSpec.setPropertyValues("height", propertyValues2);
            }
            return super.createAnimator(currentMotionSpec);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isExtended = this.extending;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            android.view.ViewGroup.LayoutParams layoutParams = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return this.extending == com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isExtended || com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getIcon() == null || android.text.TextUtils.isEmpty(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.getText());
        }
    }

    class ShowStrategy extends com.google.android.material.floatingactionbutton.BaseMotionStrategy {
        public ShowStrategy(com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker) {
            super(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(0);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setAlpha(1.0f);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setScaleY(1.0f);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return com.google.android.material.R_renamed.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(0);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 2;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isOrWillBeShown();
        }
    }

    class HideStrategy extends com.google.android.material.floatingactionbutton.BaseMotionStrategy {
        private boolean isCancelled;

        public HideStrategy(com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker) {
            super(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.isOrWillBeHidden();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return com.google.android.material.R_renamed.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            this.isCancelled = false;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(0);
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 1;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.animState = 0;
            if (this.isCancelled) {
                return;
            }
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this.setVisibility(8);
        }
    }
}
