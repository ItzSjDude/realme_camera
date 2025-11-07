package com.google.android.material.floatingactionbutton;

/* loaded from: classes.dex */
class FloatingActionButtonImplLollipop extends com.google.android.material.floatingactionbutton.FloatingActionButtonImpl {
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void updateFromViewRotation() {
    }

    FloatingActionButtonImplLollipop(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, com.google.android.material.shadow.ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void initializeBackgroundDrawable(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode, android.content.res.ColorStateList colorStateList2, int i_renamed) {
        android.graphics.drawable.Drawable layerDrawable;
        this.shapeDrawable = createShapeDrawable();
        this.shapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (i_renamed > 0) {
            this.borderDrawable = createBorderDrawable(i_renamed, colorStateList);
            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{(android.graphics.drawable.Drawable) androidx.core.g_renamed.f_renamed.a_renamed(this.borderDrawable), (android.graphics.drawable.Drawable) androidx.core.g_renamed.f_renamed.a_renamed(this.shapeDrawable)});
        } else {
            this.borderDrawable = null;
            layerDrawable = this.shapeDrawable;
        }
        this.rippleDrawable = new android.graphics.drawable.RippleDrawable(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList2), layerDrawable, null);
        this.contentBackground = this.rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void setRippleColor(android.content.res.ColorStateList colorStateList) {
        if (this.rippleDrawable instanceof android.graphics.drawable.RippleDrawable) {
            ((android.graphics.drawable.RippleDrawable) this.rippleDrawable).setColor(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else {
            super.setRippleColor(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onElevationsChanged(float f_renamed, float f2, float f3) {
        if (android.os.Build.VERSION.SDK_INT == 21) {
            this.view.refreshDrawableState();
        } else {
            android.animation.StateListAnimator stateListAnimator = new android.animation.StateListAnimator();
            stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(f_renamed, f3));
            stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f_renamed, f2));
            stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f_renamed, f2));
            stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(f_renamed, f2));
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(android.animation.ObjectAnimator.ofFloat(this.view, "elevation", f_renamed).setDuration(0L));
            if (android.os.Build.VERSION.SDK_INT >= 22 && android.os.Build.VERSION.SDK_INT <= 24) {
                arrayList.add(android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.TRANSLATION_Z, this.view.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((android.animation.Animator[]) arrayList.toArray(new android.animation.Animator[0]));
            animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
            stateListAnimator.addState(ENABLED_STATE_SET, animatorSet);
            stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
            this.view.setStateListAnimator(stateListAnimator);
        }
        if (shouldAddPadding()) {
            updatePadding();
        }
    }

    private android.animation.Animator createElevationAnimator(float f_renamed, float f2) {
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.play(android.animation.ObjectAnimator.ofFloat(this.view, "elevation", f_renamed).setDuration(0L)).with(android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean shouldAddPadding() {
        return this.shadowViewDelegate.isCompatPaddingEnabled() || !shouldExpandBoundsForA11y();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onDrawableStateChanged(int[] iArr) {
        if (android.os.Build.VERSION.SDK_INT == 21) {
            if (this.view.isEnabled()) {
                this.view.setElevation(this.elevation);
                if (this.view.isPressed()) {
                    this.view.setTranslationZ(this.pressedTranslationZ);
                    return;
                } else if (this.view.isFocused() || this.view.isHovered()) {
                    this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
                    return;
                } else {
                    this.view.setTranslationZ(0.0f);
                    return;
                }
            }
            this.view.setElevation(0.0f);
            this.view.setTranslationZ(0.0f);
        }
    }

    com.google.android.material.floatingactionbutton.BorderDrawable createBorderDrawable(int i_renamed, android.content.res.ColorStateList colorStateList) {
        android.content.Context context = this.view.getContext();
        com.google.android.material.floatingactionbutton.BorderDrawable borderDrawable = new com.google.android.material.floatingactionbutton.BorderDrawable((com.google.android.material.shape.ShapeAppearanceModel) androidx.core.g_renamed.f_renamed.a_renamed(this.shapeAppearance));
        borderDrawable.setGradientColors(androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_fab_stroke_top_outer_color), androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_fab_stroke_top_inner_color), androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_fab_stroke_end_inner_color), androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_fab_stroke_end_outer_color));
        borderDrawable.setBorderWidth(i_renamed);
        borderDrawable.setBorderTint(colorStateList);
        return borderDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    com.google.android.material.shape.MaterialShapeDrawable createShapeDrawable() {
        return new com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop.AlwaysStatefulMaterialShapeDrawable((com.google.android.material.shape.ShapeAppearanceModel) androidx.core.g_renamed.f_renamed.a_renamed(this.shapeAppearance));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void getPadding(android.graphics.Rect rect) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
            super.getPadding(rect);
        } else if (!shouldExpandBoundsForA11y()) {
            int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    static class AlwaysStatefulMaterialShapeDrawable extends com.google.android.material.shape.MaterialShapeDrawable {
        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        AlwaysStatefulMaterialShapeDrawable(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }
    }
}
