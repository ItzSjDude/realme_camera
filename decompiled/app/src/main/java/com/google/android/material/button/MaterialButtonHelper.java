package com.google.android.material.button;

/* loaded from: classes.dex */
class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP;
    private android.content.res.ColorStateList backgroundTint;
    private android.graphics.PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private android.graphics.drawable.Drawable maskDrawable;
    private final com.google.android.material.button.MaterialButton materialButton;
    private android.content.res.ColorStateList rippleColor;
    private android.graphics.drawable.LayerDrawable rippleDrawable;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;
    private android.content.res.ColorStateList strokeColor;
    private int strokeWidth;
    private boolean shouldDrawSurfaceColorStroke = false;
    private boolean backgroundOverwritten = false;
    private boolean cornerRadiusSet = false;

    static {
        IS_LOLLIPOP = android.os.Build.VERSION.SDK_INT >= 21;
    }

    MaterialButtonHelper(com.google.android.material.button.MaterialButton materialButton, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.materialButton = materialButton;
        this.shapeAppearanceModel = shapeAppearanceModel;
    }

    void loadFromAttributes(android.content.res.TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(com.google.android.material.R_renamed.styleable.MaterialButton_cornerRadius)) {
            this.cornerRadius = typedArray.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialButton_cornerRadius, -1);
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(this.cornerRadius));
            this.cornerRadiusSet = true;
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = com.google.android.material.internal.ViewUtils.parseTintMode(typedArray.getInt(com.google.android.material.R_renamed.styleable.MaterialButton_backgroundTintMode, -1), android.graphics.PorterDuff.Mode.SRC_IN);
        this.backgroundTint = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialButton_backgroundTint);
        this.strokeColor = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialButton_strokeColor);
        this.rippleColor = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialButton_rippleColor);
        this.checkable = typedArray.getBoolean(com.google.android.material.R_renamed.styleable.MaterialButton_android_checkable, false);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialButton_elevation, 0);
        int iJ = androidx.core.h_renamed.v_renamed.j_renamed(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int iK = androidx.core.h_renamed.v_renamed.k_renamed(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        if (typedArray.hasValue(com.google.android.material.R_renamed.styleable.MaterialButton_android_background)) {
            setBackgroundOverwritten();
        } else {
            this.materialButton.setInternalBackground(createBackground());
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setElevation(dimensionPixelSize);
            }
        }
        androidx.core.h_renamed.v_renamed.b_renamed(this.materialButton, iJ + this.insetLeft, paddingTop + this.insetTop, iK + this.insetRight, paddingBottom + this.insetBottom);
    }

    void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    private android.graphics.drawable.InsetDrawable wrapDrawableWithInset(android.graphics.drawable.Drawable drawable) {
        return new android.graphics.drawable.InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (getMaterialShapeDrawable() != null) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(getMaterialShapeDrawable(), this.backgroundTint);
            }
        }
    }

    android.content.res.ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (getMaterialShapeDrawable() == null || this.backgroundTintMode == null) {
                return;
            }
            androidx.core.graphics.drawable.a_renamed.a_renamed(getMaterialShapeDrawable(), this.backgroundTintMode);
        }
    }

    android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    void setShouldDrawSurfaceColorStroke(boolean z_renamed) {
        this.shouldDrawSurfaceColorStroke = z_renamed;
        updateStroke();
    }

    private android.graphics.drawable.Drawable createBackground() {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
        androidx.core.graphics.drawable.a_renamed.a_renamed(materialShapeDrawable, this.backgroundTint);
        android.graphics.PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke(this.strokeWidth, this.shouldDrawSurfaceColorStroke ? com.google.android.material.color.MaterialColors.getColor(this.materialButton, com.google.android.material.R_renamed.attr.colorSurface) : 0);
        if (IS_LOLLIPOP) {
            this.maskDrawable = new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.maskDrawable, -1);
            this.rippleDrawable = new android.graphics.drawable.RippleDrawable(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.maskDrawable);
            return this.rippleDrawable;
        }
        this.maskDrawable = new com.google.android.material.ripple.RippleDrawableCompat(this.shapeAppearanceModel);
        androidx.core.graphics.drawable.a_renamed.a_renamed(this.maskDrawable, com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        this.rippleDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.maskDrawable});
        return wrapDrawableWithInset(this.rippleDrawable);
    }

    void updateMaskBounds(int i_renamed, int i2) {
        android.graphics.drawable.Drawable drawable = this.maskDrawable;
        if (drawable != null) {
            drawable.setBounds(this.insetLeft, this.insetTop, i2 - this.insetRight, i_renamed - this.insetBottom);
        }
    }

    void setBackgroundColor(int i_renamed) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setTint(i_renamed);
        }
    }

    void setRippleColor(android.content.res.ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            if (IS_LOLLIPOP && (this.materialButton.getBackground() instanceof android.graphics.drawable.RippleDrawable)) {
                ((android.graphics.drawable.RippleDrawable) this.materialButton.getBackground()).setColor(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            } else {
                if (IS_LOLLIPOP || !(this.materialButton.getBackground() instanceof com.google.android.material.ripple.RippleDrawableCompat)) {
                    return;
                }
                ((com.google.android.material.ripple.RippleDrawableCompat) this.materialButton.getBackground()).setTintList(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    android.content.res.ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    android.content.res.ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    void setStrokeWidth(int i_renamed) {
        if (this.strokeWidth != i_renamed) {
            this.strokeWidth = i_renamed;
            updateStroke();
        }
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    private void updateStroke() {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        com.google.android.material.shape.MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                surfaceColorStrokeDrawable.setStroke(this.strokeWidth, this.shouldDrawSurfaceColorStroke ? com.google.android.material.color.MaterialColors.getColor(this.materialButton, com.google.android.material.R_renamed.attr.colorSurface) : 0);
            }
        }
    }

    void setCornerRadius(int i_renamed) {
        if (this.cornerRadiusSet && this.cornerRadius == i_renamed) {
            return;
        }
        this.cornerRadius = i_renamed;
        this.cornerRadiusSet = true;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(i_renamed));
    }

    int getCornerRadius() {
        return this.cornerRadius;
    }

    private com.google.android.material.shape.MaterialShapeDrawable getMaterialShapeDrawable(boolean z_renamed) {
        android.graphics.drawable.LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (IS_LOLLIPOP) {
            return (com.google.android.material.shape.MaterialShapeDrawable) ((android.graphics.drawable.LayerDrawable) ((android.graphics.drawable.InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z_renamed ? 1 : 0);
        }
        return (com.google.android.material.shape.MaterialShapeDrawable) this.rippleDrawable.getDrawable(!z_renamed ? 1 : 0);
    }

    com.google.android.material.shape.MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }

    void setCheckable(boolean z_renamed) {
        this.checkable = z_renamed;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    private com.google.android.material.shape.MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void updateButtonShape(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getSurfaceColorStrokeDrawable() != null) {
            getSurfaceColorStrokeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public com.google.android.material.shape.Shapeable getMaskDrawable() {
        android.graphics.drawable.LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.rippleDrawable.getNumberOfLayers() > 2) {
            return (com.google.android.material.shape.Shapeable) this.rippleDrawable.getDrawable(2);
        }
        return (com.google.android.material.shape.Shapeable) this.rippleDrawable.getDrawable(1);
    }

    void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        updateButtonShape(shapeAppearanceModel);
    }

    com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }
}
