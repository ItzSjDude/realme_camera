package com.google.android.material.card;

/* loaded from: classes.dex */
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};
    private static final double COS_45 = java.lang.Math.cos(java.lang.Math.toRadians(45.0d));
    private static final int DEFAULT_STROKE_VALUE = -1;
    private final com.google.android.material.shape.MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    private android.graphics.drawable.Drawable checkedIcon;
    private final int checkedIconMargin;
    private final int checkedIconSize;
    private android.content.res.ColorStateList checkedIconTint;
    private android.graphics.drawable.LayerDrawable clickableForegroundDrawable;
    private com.google.android.material.shape.MaterialShapeDrawable compatRippleDrawable;
    private android.graphics.drawable.Drawable fgDrawable;
    private final com.google.android.material.shape.MaterialShapeDrawable foregroundContentDrawable;
    private com.google.android.material.shape.MaterialShapeDrawable foregroundShapeDrawable;
    private final com.google.android.material.card.MaterialCardView materialCardView;
    private android.content.res.ColorStateList rippleColor;
    private android.graphics.drawable.Drawable rippleDrawable;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;
    private android.content.res.ColorStateList strokeColor;
    private int strokeWidth;
    private final android.graphics.Rect userContentPadding = new android.graphics.Rect();
    private boolean isBackgroundOverwritten = false;

    public MaterialCardViewHelper(com.google.android.material.card.MaterialCardView materialCardView, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        this.materialCardView = materialCardView;
        this.bgDrawable = new com.google.android.material.shape.MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i_renamed, i2);
        this.bgDrawable.initializeElevationOverlay(materialCardView.getContext());
        this.bgDrawable.setShadowColor(-12303292);
        com.google.android.material.shape.ShapeAppearanceModel.Builder builder = this.bgDrawable.getShapeAppearanceModel().toBuilder();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.CardView, i_renamed, com.google.android.material.R_renamed.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.CardView_cardCornerRadius)) {
            builder.setAllCornerSizes(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.foregroundContentDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        android.content.res.Resources resources = materialCardView.getResources();
        this.checkedIconMargin = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_card_checked_icon_margin);
        this.checkedIconSize = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_card_checked_icon_size);
        typedArrayObtainStyledAttributes.recycle();
    }

    void loadFromAttributes(android.content.res.TypedArray typedArray) {
        this.strokeColor = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialCardView_strokeColor);
        if (this.strokeColor == null) {
            this.strokeColor = android.content.res.ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialCardView_strokeWidth, 0);
        this.checkable = typedArray.getBoolean(com.google.android.material.R_renamed.styleable.MaterialCardView_android_checkable, false);
        this.materialCardView.setLongClickable(this.checkable);
        this.checkedIconTint = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialCardView_checkedIcon));
        this.rippleColor = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialCardView_rippleColor);
        if (this.rippleColor == null) {
            this.rippleColor = android.content.res.ColorStateList.valueOf(com.google.android.material.color.MaterialColors.getColor(this.materialCardView, com.google.android.material.R_renamed.attr.colorControlHighlight));
        }
        setCardForegroundColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R_renamed.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        this.fgDrawable = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    void setBackgroundOverwritten(boolean z_renamed) {
        this.isBackgroundOverwritten = z_renamed;
    }

    void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        if (this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    int getStrokeColor() {
        android.content.res.ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    android.content.res.ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    void setStrokeWidth(int i_renamed) {
        if (i_renamed == this.strokeWidth) {
            return;
        }
        this.strokeWidth = i_renamed;
        updateStroke();
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    com.google.android.material.shape.MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    void setCardBackgroundColor(android.content.res.ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    android.content.res.ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    void setCardForegroundColor(android.content.res.ColorStateList colorStateList) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = android.content.res.ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    android.content.res.ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    void setUserContentPadding(int i_renamed, int i2, int i3, int i4) {
        this.userContentPadding.set(i_renamed, i2, i3, i4);
        updateContentPadding();
    }

    android.graphics.Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    void updateClickable() {
        android.graphics.drawable.Drawable drawable = this.fgDrawable;
        this.fgDrawable = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        android.graphics.drawable.Drawable drawable2 = this.fgDrawable;
        if (drawable != drawable2) {
            updateInsetForeground(drawable2);
        }
    }

    void setCornerRadius(float f_renamed) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f_renamed));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    void setProgress(float f_renamed) {
        this.bgDrawable.setInterpolation(f_renamed);
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f_renamed);
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f_renamed);
        }
    }

    float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }

    void updateContentPadding() {
        int iCalculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f) - getParentCardViewCalculatedCornerPadding());
        this.materialCardView.setAncestorContentPadding(this.userContentPadding.left + iCalculateActualCornerPadding, this.userContentPadding.top + iCalculateActualCornerPadding, this.userContentPadding.right + iCalculateActualCornerPadding, this.userContentPadding.bottom + iCalculateActualCornerPadding);
    }

    void setCheckable(boolean z_renamed) {
        this.checkable = z_renamed;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    void setRippleColor(android.content.res.ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    void setCheckedIconTint(android.content.res.ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        android.graphics.drawable.Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, colorStateList);
        }
    }

    android.content.res.ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    android.content.res.ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    android.graphics.drawable.Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    void setCheckedIcon(android.graphics.drawable.Drawable drawable) {
        this.checkedIcon = drawable;
        if (drawable != null) {
            this.checkedIcon = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable.mutate());
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.checkedIcon, this.checkedIconTint);
        }
        if (this.clickableForegroundDrawable != null) {
            this.clickableForegroundDrawable.setDrawableByLayerId(com.google.android.material.R_renamed.id_renamed.mtrl_card_checked_layer_id, createCheckedIconLayer());
        }
    }

    void onMeasure(int i_renamed, int i2) {
        int i3;
        int i4;
        if (this.clickableForegroundDrawable != null) {
            int i5 = this.checkedIconMargin;
            int i6 = this.checkedIconSize;
            int iCeil = (i_renamed - i5) - i6;
            int iCeil2 = (i2 - i5) - i6;
            if ((android.os.Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
                iCeil2 -= (int) java.lang.Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
                iCeil -= (int) java.lang.Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
            }
            int i7 = iCeil2;
            int i8 = this.checkedIconMargin;
            if (androidx.core.h_renamed.v_renamed.g_renamed(this.materialCardView) == 1) {
                i4 = iCeil;
                i3 = i8;
            } else {
                i3 = iCeil;
                i4 = i8;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i3, this.checkedIconMargin, i4, i7);
        }
    }

    void forceRippleRedraw() {
        android.graphics.drawable.Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            android.graphics.Rect bounds = drawable.getBounds();
            int i_renamed = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i_renamed - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i_renamed);
        }
    }

    void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        this.bgDrawable.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable3 = this.compatRippleDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    private void updateInsetForeground(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 23 && (this.materialCardView.getForeground() instanceof android.graphics.drawable.InsetDrawable)) {
            ((android.graphics.drawable.InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        } else {
            this.materialCardView.setForeground(insetDrawable(drawable));
        }
    }

    private android.graphics.drawable.Drawable insetDrawable(android.graphics.drawable.Drawable drawable) {
        int iCeil;
        int i_renamed;
        if ((android.os.Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
            int iCeil2 = (int) java.lang.Math.ceil(calculateVerticalBackgroundPadding());
            iCeil = (int) java.lang.Math.ceil(calculateHorizontalBackgroundPadding());
            i_renamed = iCeil2;
        } else {
            iCeil = 0;
            i_renamed = 0;
        }
        return new android.graphics.drawable.InsetDrawable(drawable, iCeil, i_renamed, iCeil, i_renamed) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
            public boolean getPadding(android.graphics.Rect rect) {
                return false;
            }
        };
    }

    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private boolean canClipToOutline() {
        return android.os.Build.VERSION.SDK_INT >= 21 && this.bgDrawable.isRoundRect();
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (!this.materialCardView.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (android.os.Build.VERSION.SDK_INT < 21 || this.materialCardView.getUseCompatPadding()) {
            return (float) ((1.0d - COS_45) * this.materialCardView.getCardViewRadius());
        }
        return 0.0f;
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    private float calculateActualCornerPadding() {
        return java.lang.Math.max(java.lang.Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), java.lang.Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(com.google.android.material.shape.CornerTreatment cornerTreatment, float f_renamed) {
        if (cornerTreatment instanceof com.google.android.material.shape.RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * f_renamed);
        }
        if (cornerTreatment instanceof com.google.android.material.shape.CutCornerTreatment) {
            return f_renamed / 2.0f;
        }
        return 0.0f;
    }

    private android.graphics.drawable.Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            this.clickableForegroundDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, createCheckedIconLayer()});
            this.clickableForegroundDrawable.setId(2, com.google.android.material.R_renamed.id_renamed.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    private android.graphics.drawable.Drawable createForegroundRippleDrawable() {
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
            this.foregroundShapeDrawable = createForegroundShapeDrawable();
            return new android.graphics.drawable.RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
        }
        return createCompatRippleDrawable();
    }

    private android.graphics.drawable.Drawable createCompatRippleDrawable() {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable.setFillColor(this.rippleColor);
        stateListDrawable.addState(new int[]{android.R_renamed.attr.state_pressed}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    private void updateRippleColor() {
        android.graphics.drawable.Drawable drawable;
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.rippleDrawable) != null) {
            ((android.graphics.drawable.RippleDrawable) drawable).setColor(this.rippleColor);
            return;
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.rippleColor);
        }
    }

    private android.graphics.drawable.Drawable createCheckedIconLayer() {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        android.graphics.drawable.Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            stateListDrawable.addState(CHECKED_STATE_SET, drawable);
        }
        return stateListDrawable;
    }

    private com.google.android.material.shape.MaterialShapeDrawable createForegroundShapeDrawable() {
        return new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
    }
}
