package com.google.android.material.floatingactionbutton;

/* loaded from: classes.dex */
public class FloatingActionButton extends com.google.android.material.internal.VisibilityAwareImageButton implements androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed, androidx.core.h_renamed.u_renamed, androidx.core.widget.l_renamed, com.google.android.material.expandable.ExpandableTransformationWidget, com.google.android.material.shape.Shapeable {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_FloatingActionButton;
    private static final java.lang.String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final java.lang.String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private android.content.res.ColorStateList backgroundTint;
    private android.graphics.PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final com.google.android.material.expandable.ExpandableWidgetHelper expandableWidgetHelper;
    private final androidx.appcompat.widget.m_renamed imageHelper;
    private android.graphics.PorterDuff.Mode imageMode;
    private int imagePadding;
    private android.content.res.ColorStateList imageTint;
    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl impl;
    private int maxImageSize;
    private android.content.res.ColorStateList rippleColor;
    final android.graphics.Rect shadowPadding;
    private int size;
    private final android.graphics.Rect touchArea;

    public static abstract class OnVisibilityChangedListener {
        public void onHidden(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        }

        public void onShown(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Size {
    }

    public FloatingActionButton(android.content.Context context) {
        this(context, null);
    }

    public FloatingActionButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.floatingActionButtonStyle);
    }

    public FloatingActionButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.shadowPadding = new android.graphics.Rect();
        this.touchArea = new android.graphics.Rect();
        android.content.Context context2 = getContext();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.FloatingActionButton, i_renamed, DEF_STYLE_RES, new int[0]);
        this.backgroundTint = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = com.google.android.material.internal.ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.FloatingActionButton_rippleColor);
        this.size = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.FloatingActionButton_fabSize, -1);
        this.customSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.compatPadding = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_fab_min_touch_target);
        this.maxImageSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.FloatingActionButton_maxImageSize, 0);
        com.google.android.material.animation.MotionSpec motionSpecCreateFromAttribute = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.FloatingActionButton_showMotionSpec);
        com.google.android.material.animation.MotionSpec motionSpecCreateFromAttribute2 = com.google.android.material.animation.MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.FloatingActionButton_hideMotionSpec);
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModelBuild = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i_renamed, DEF_STYLE_RES, com.google.android.material.shape.ShapeAppearanceModel.PILL).build();
        boolean z_renamed = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.FloatingActionButton_android_enabled, true));
        typedArrayObtainStyledAttributes.recycle();
        this.imageHelper = new androidx.appcompat.widget.m_renamed(this);
        this.imageHelper.a_renamed(attributeSet, i_renamed);
        this.expandableWidgetHelper = new com.google.android.material.expandable.ExpandableWidgetHelper(this);
        getImpl().setShapeAppearance(shapeAppearanceModelBuild);
        getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().setMinTouchTargetSize(dimensionPixelSize);
        getImpl().setElevation(dimension);
        getImpl().setHoveredFocusedTranslationZ(dimension2);
        getImpl().setPressedTranslationZ(dimension3);
        getImpl().setMaxImageSize(this.maxImageSize);
        getImpl().setShowMotionSpec(motionSpecCreateFromAttribute);
        getImpl().setHideMotionSpec(motionSpecCreateFromAttribute2);
        getImpl().setEnsureMinTouchTargetSize(z_renamed);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int iMin = java.lang.Math.min(resolveAdjustedSize(sizeDimension, i_renamed), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension(this.shadowPadding.left + iMin + this.shadowPadding.right, iMin + this.shadowPadding.top + this.shadowPadding.bottom);
    }

    @java.lang.Deprecated
    public int getRippleColor() {
        android.content.res.ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public android.content.res.ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public void setRippleColor(int i_renamed) {
        setRippleColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setRippleColor(android.content.res.ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().setRippleColor(this.rippleColor);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a_renamed
    public androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<com.google.android.material.floatingactionbutton.FloatingActionButton> getBehavior() {
        return new com.google.android.material.floatingactionbutton.FloatingActionButton.Behavior();
    }

    @Override // android.view.View
    public android.content.res.ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public void setBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            getImpl().setBackgroundTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public android.graphics.PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            getImpl().setBackgroundTintMode(mode);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.l_renamed
    public void setSupportImageTintList(android.content.res.ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    @Override // androidx.core.widget.l_renamed
    public android.content.res.ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.l_renamed
    public void setSupportImageTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    @Override // androidx.core.widget.l_renamed
    public android.graphics.PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    private void onApplySupportImageTint() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        android.content.res.ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a_renamed.f_renamed(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        android.graphics.PorterDuff.Mode mode = this.imageMode;
        if (mode == null) {
            mode = android.graphics.PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.i_renamed.a_renamed(colorForState, mode));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        android.util.Log.i_renamed(LOG_TAG, "Setting a_renamed custom background is_renamed not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i_renamed) {
        android.util.Log.i_renamed(LOG_TAG, "Setting a_renamed custom background is_renamed not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i_renamed) {
        android.util.Log.i_renamed(LOG_TAG, "Setting a_renamed custom background is_renamed not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i_renamed) {
        this.imageHelper.a_renamed(i_renamed);
        onApplySupportImageTint();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().updateImageMatrixScale();
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().setShapeAppearance(shapeAppearanceModel);
    }

    @Override // com.google.android.material.shape.Shapeable
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return (com.google.android.material.shape.ShapeAppearanceModel) androidx.core.g_renamed.f_renamed.a_renamed(getImpl().getShapeAppearance());
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().getEnsureMinTouchTargetSize();
    }

    public void setEnsureMinTouchTargetSize(boolean z_renamed) {
        if (z_renamed != getImpl().getEnsureMinTouchTargetSize()) {
            getImpl().setEnsureMinTouchTargetSize(z_renamed);
            requestLayout();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed);
    }

    public void show() {
        show(null);
    }

    public void show(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        show(onVisibilityChangedListener, true);
    }

    void show(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener, boolean z_renamed) {
        getImpl().show(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z_renamed);
    }

    public void addOnShowAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().addOnShowAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().removeOnShowAnimationListener(animatorListener);
    }

    public void hide() {
        hide(null);
    }

    public void hide(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        hide(onVisibilityChangedListener, true);
    }

    void hide(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener, boolean z_renamed) {
        getImpl().hide(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z_renamed);
    }

    public void addOnHideAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().addOnHideAnimationListener(animatorListener);
    }

    public void removeOnHideAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        getImpl().removeOnHideAnimationListener(animatorListener);
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean setExpanded(boolean z_renamed) {
        return this.expandableWidgetHelper.setExpanded(z_renamed);
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public void setExpandedComponentIdHint(int i_renamed) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(i_renamed);
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    public void setUseCompatPadding(boolean z_renamed) {
        if (this.compatPadding != z_renamed) {
            this.compatPadding = z_renamed;
            getImpl().onCompatShadowChanged();
        }
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void setSize(int i_renamed) {
        this.customSize = 0;
        if (i_renamed != this.size) {
            this.size = i_renamed;
            requestLayout();
        }
    }

    public int getSize() {
        return this.size;
    }

    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(final com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public void onShown() {
                onVisibilityChangedListener.onShown(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public void onHidden() {
                onVisibilityChangedListener.onHidden(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
            }
        };
    }

    public boolean isOrWillBeHidden() {
        return getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return getImpl().isOrWillBeShown();
    }

    public void setCustomSize(int i_renamed) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("Custom size must be_renamed non-negative");
        }
        if (i_renamed != this.customSize) {
            this.customSize = i_renamed;
            requestLayout();
        }
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    private int getSizeDimension(int i_renamed) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        android.content.res.Resources resources = getResources();
        if (i_renamed != -1) {
            if (i_renamed == 1) {
                return resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_fab_size_mini);
            }
            return resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_fab_size_normal);
        }
        if (java.lang.Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < AUTO_MINI_LARGEST_SCREEN_WIDTH) {
            return getSizeDimension(1);
        }
        return getSizeDimension(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        android.os.Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new android.os.Bundle();
        }
        com.google.android.material.stateful.ExtendableSavedState extendableSavedState = new com.google.android.material.stateful.ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.onSaveInstanceState());
        return extendableSavedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.stateful.ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.stateful.ExtendableSavedState extendableSavedState = (com.google.android.material.stateful.ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState((android.os.Bundle) androidx.core.g_renamed.f_renamed.a_renamed(extendableSavedState.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)));
    }

    @java.lang.Deprecated
    public boolean getContentRect(android.graphics.Rect rect) {
        if (!androidx.core.h_renamed.v_renamed.A_renamed(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(rect);
        return true;
    }

    public void getMeasuredContentRect(android.graphics.Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(rect);
    }

    private void offsetRectWithShadow(android.graphics.Rect rect) {
        rect.left += this.shadowPadding.left;
        rect.top += this.shadowPadding.top;
        rect.right -= this.shadowPadding.right;
        rect.bottom -= this.shadowPadding.bottom;
    }

    public android.graphics.drawable.Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    private static int resolveAdjustedSize(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return java.lang.Math.min(i_renamed, size);
        }
        if (mode == 0) {
            return i_renamed;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new java.lang.IllegalArgumentException();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getContentRect(this.touchArea) && !this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public static class Behavior extends com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior<com.google.android.material.floatingactionbutton.FloatingActionButton> {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, android.graphics.Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar) {
            super.onAttachedToLayoutParams(eVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, android.view.View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, int i_renamed) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i_renamed);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean z_renamed) {
            super.setAutoHideEnabled(z_renamed);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
            super.setInternalAutoHideListener(onVisibilityChangedListener);
        }

        public Behavior() {
        }

        public Behavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T_renamed extends com.google.android.material.floatingactionbutton.FloatingActionButton> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<T_renamed> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener internalAutoHideListener;
        private android.graphics.Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public BaseBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void setAutoHideEnabled(boolean z_renamed) {
            this.autoHideEnabled = z_renamed;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public void onAttachedToLayoutParams(androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar) {
            if (eVar.h_renamed == 0) {
                eVar.h_renamed = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, android.view.View view) {
            if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, floatingActionButton);
            return false;
        }

        private static boolean isBottomSheet(android.view.View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) {
                return ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) layoutParams).b_renamed() instanceof com.google.android.material.bottomsheet.BottomSheetBehavior;
            }
            return false;
        }

        public void setInternalAutoHideListener(com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
            this.internalAutoHideListener = onVisibilityChangedListener;
        }

        private boolean shouldUpdateVisibility(android.view.View view, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            return this.autoHideEnabled && ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) floatingActionButton.getLayoutParams()).a_renamed() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean updateFabVisibilityForAppBarLayout(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new android.graphics.Rect();
            }
            android.graphics.Rect rect = this.tmpRect;
            com.google.android.material.internal.DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(android.view.View view, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            if (!shouldUpdateVisibility(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.hide(this.internalAutoHideListener, false);
                return true;
            }
            floatingActionButton.show(this.internalAutoHideListener, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, int i_renamed) {
            java.util.List<android.view.View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                android.view.View view = dependencies.get(i2);
                if (view instanceof com.google.android.material.appbar.AppBarLayout) {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (com.google.android.material.appbar.AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i_renamed);
            offsetIfNeeded(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
        public boolean getInsetDodgeRect(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, android.graphics.Rect rect) {
            android.graphics.Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void offsetIfNeeded(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            int i_renamed;
            android.graphics.Rect rect = floatingActionButton.shadowPadding;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar = (androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin) {
                i_renamed = rect.right;
            } else {
                i_renamed = floatingActionButton.getLeft() <= eVar.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                androidx.core.h_renamed.v_renamed.e_renamed(floatingActionButton, i2);
            }
            if (i_renamed != 0) {
                androidx.core.h_renamed.v_renamed.f_renamed(floatingActionButton, i_renamed);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        super.setElevation(f_renamed);
        getImpl().updateShapeElevation(f_renamed);
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f_renamed) {
        getImpl().setElevation(f_renamed);
    }

    public void setCompatElevationResource(int i_renamed) {
        setCompatElevation(getResources().getDimension(i_renamed));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().getHoveredFocusedTranslationZ();
    }

    public void setCompatHoveredFocusedTranslationZ(float f_renamed) {
        getImpl().setHoveredFocusedTranslationZ(f_renamed);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i_renamed) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i_renamed));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().getPressedTranslationZ();
    }

    public void setCompatPressedTranslationZ(float f_renamed) {
        getImpl().setPressedTranslationZ(f_renamed);
    }

    public void setCompatPressedTranslationZResource(int i_renamed) {
        setCompatPressedTranslationZ(getResources().getDimension(i_renamed));
    }

    public com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        return getImpl().getShowMotionSpec();
    }

    public void setShowMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        getImpl().setShowMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(int i_renamed) {
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i_renamed));
    }

    public com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        return getImpl().getHideMotionSpec();
    }

    public void setHideMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        getImpl().setHideMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(int i_renamed) {
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(getContext(), i_renamed));
    }

    public void addTransformationCallback(com.google.android.material.animation.TransformationCallback<? extends com.google.android.material.floatingactionbutton.FloatingActionButton> transformationCallback) {
        getImpl().addTransformationCallback(new com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper(transformationCallback));
    }

    public void removeTransformationCallback(com.google.android.material.animation.TransformationCallback<? extends com.google.android.material.floatingactionbutton.FloatingActionButton> transformationCallback) {
        getImpl().removeTransformationCallback(new com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper(transformationCallback));
    }

    class TransformationCallbackWrapper<T_renamed extends com.google.android.material.floatingactionbutton.FloatingActionButton> implements com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback {
        private final com.google.android.material.animation.TransformationCallback<T_renamed> listener;

        TransformationCallbackWrapper(com.google.android.material.animation.TransformationCallback<T_renamed> transformationCallback) {
            this.listener = transformationCallback;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onTranslationChanged() {
            this.listener.onTranslationChanged(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onScaleChanged() {
            this.listener.onScaleChanged(com.google.android.material.floatingactionbutton.FloatingActionButton.this);
        }

        public boolean equals(java.lang.Object obj) {
            return (obj instanceof com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper) && ((com.google.android.material.floatingactionbutton.FloatingActionButton.TransformationCallbackWrapper) obj).listener.equals(this.listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f_renamed) {
        super.setTranslationX(f_renamed);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationY(float f_renamed) {
        super.setTranslationY(f_renamed);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationZ(float f_renamed) {
        super.setTranslationZ(f_renamed);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setScaleX(float f_renamed) {
        super.setScaleX(f_renamed);
        getImpl().onScaleChanged();
    }

    @Override // android.view.View
    public void setScaleY(float f_renamed) {
        super.setScaleY(f_renamed);
        getImpl().onScaleChanged();
    }

    public void setShadowPaddingEnabled(boolean z_renamed) {
        getImpl().setShadowPaddingEnabled(z_renamed);
    }

    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = createImpl();
        }
        return this.impl;
    }

    private com.google.android.material.floatingactionbutton.FloatingActionButtonImpl createImpl() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop(this, new com.google.android.material.floatingactionbutton.FloatingActionButton.ShadowDelegateImpl());
        }
        return new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl(this, new com.google.android.material.floatingactionbutton.FloatingActionButton.ShadowDelegateImpl());
    }

    private class ShadowDelegateImpl implements com.google.android.material.shadow.ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public float getRadius() {
            return com.google.android.material.floatingactionbutton.FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setShadowPadding(int i_renamed, int i2, int i3, int i4) {
            com.google.android.material.floatingactionbutton.FloatingActionButton.this.shadowPadding.set(i_renamed, i2, i3, i4);
            com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = com.google.android.material.floatingactionbutton.FloatingActionButton.this;
            floatingActionButton.setPadding(i_renamed + floatingActionButton.imagePadding, i2 + com.google.android.material.floatingactionbutton.FloatingActionButton.this.imagePadding, i3 + com.google.android.material.floatingactionbutton.FloatingActionButton.this.imagePadding, i4 + com.google.android.material.floatingactionbutton.FloatingActionButton.this.imagePadding);
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
            if (drawable != null) {
                com.google.android.material.floatingactionbutton.FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean isCompatPaddingEnabled() {
            return com.google.android.material.floatingactionbutton.FloatingActionButton.this.compatPadding;
        }
    }
}
