package com.google.android.material.textfield;

/* loaded from: classes.dex */
class DropdownMenuEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    private static final int ANIMATION_FADE_IN_DURATION = 67;
    private static final int ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP;
    private final com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate accessibilityDelegate;
    private android.view.accessibility.AccessibilityManager accessibilityManager;
    private final com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;
    private final android.text.TextWatcher exposedDropdownEndIconTextWatcher;
    private android.animation.ValueAnimator fadeInAnim;
    private android.animation.ValueAnimator fadeOutAnim;
    private android.graphics.drawable.StateListDrawable filledPopupBackground;
    private boolean isEndIconChecked;
    private com.google.android.material.shape.MaterialShapeDrawable outlinedPopupBackground;

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isBoxBackgroundModeSupported(int i_renamed) {
        return i_renamed != 0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean shouldTintIconOnError() {
        return true;
    }

    static {
        IS_LOLLIPOP = android.os.Build.VERSION.SDK_INT >= 21;
    }

    DropdownMenuEndIconDelegate(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.exposedDropdownEndIconTextWatcher = new android.text.TextWatcher() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                com.google.android.material.textfield.DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = com.google.android.material.textfield.DropdownMenuEndIconDelegate.this;
                final android.widget.AutoCompleteTextView autoCompleteTextViewCastAutoCompleteTextViewOrThrow = dropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(dropdownMenuEndIconDelegate.textInputLayout.getEditText());
                autoCompleteTextViewCastAutoCompleteTextViewOrThrow.post(new java.lang.Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zIsPopupShowing = autoCompleteTextViewCastAutoCompleteTextViewOrThrow.isPopupShowing();
                        com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setEndIconChecked(zIsPopupShowing);
                        com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = zIsPopupShowing;
                    }
                });
            }
        };
        this.accessibilityDelegate = new com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate(this.textInputLayout) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.2
            @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                dVar.b_renamed((java.lang.CharSequence) android.widget.Spinner.class.getName());
                if (dVar.x_renamed()) {
                    dVar.f_renamed((java.lang.CharSequence) null);
                }
            }

            @Override // androidx.core.h_renamed.a_renamed
            public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                com.google.android.material.textfield.DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = com.google.android.material.textfield.DropdownMenuEndIconDelegate.this;
                android.widget.AutoCompleteTextView autoCompleteTextViewCastAutoCompleteTextViewOrThrow = dropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(dropdownMenuEndIconDelegate.textInputLayout.getEditText());
                if (accessibilityEvent.getEventType() == 1 && com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled()) {
                    com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.showHideDropdown(autoCompleteTextViewCastAutoCompleteTextViewOrThrow);
                }
            }
        };
        this.dropdownMenuOnEditTextAttachedListener = new com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(com.google.android.material.textfield.TextInputLayout textInputLayout2) {
                android.widget.AutoCompleteTextView autoCompleteTextViewCastAutoCompleteTextViewOrThrow = com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.castAutoCompleteTextViewOrThrow(textInputLayout2.getEditText());
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setPopupBackground(autoCompleteTextViewCastAutoCompleteTextViewOrThrow);
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.addRippleEffect(autoCompleteTextViewCastAutoCompleteTextViewOrThrow);
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setUpDropdownShowHideBehavior(autoCompleteTextViewCastAutoCompleteTextViewOrThrow);
                autoCompleteTextViewCastAutoCompleteTextViewOrThrow.setThreshold(0);
                autoCompleteTextViewCastAutoCompleteTextViewOrThrow.removeTextChangedListener(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                autoCompleteTextViewCastAutoCompleteTextViewOrThrow.addTextChangedListener(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                textInputLayout2.setErrorIconDrawable((android.graphics.drawable.Drawable) null);
                textInputLayout2.setTextInputAccessibilityDelegate(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.accessibilityDelegate);
                textInputLayout2.setEndIconVisible(true);
            }
        };
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() throws android.content.res.Resources.NotFoundException {
        float dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        com.google.android.material.shape.MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        com.google.android.material.shape.MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        this.filledPopupBackground = new android.graphics.drawable.StateListDrawable();
        this.filledPopupBackground.addState(new int[]{android.R_renamed.attr.state_above_anchor}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        this.textInputLayout.setEndIconDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.context, IS_LOLLIPOP ? com.google.android.material.R_renamed.drawable.mtrl_dropdown_arrow : com.google.android.material.R_renamed.drawable.mtrl_ic_arrow_drop_down));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(com.google.android.material.R_renamed.string.exposed_dropdown_menu_content_description));
        this.textInputLayout.setEndIconOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.4
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.showHideDropdown((android.widget.AutoCompleteTextView) com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.getEditText());
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
        initAnimators();
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this.endIconView, 2);
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) this.context.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHideDropdown(android.widget.AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (isDropdownPopupActive()) {
            this.dropdownPopupDirty = false;
        }
        if (!this.dropdownPopupDirty) {
            if (IS_LOLLIPOP) {
                setEndIconChecked(!this.isEndIconChecked);
            } else {
                this.isEndIconChecked = !this.isEndIconChecked;
                this.endIconView.toggle();
            }
            if (this.isEndIconChecked) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            } else {
                autoCompleteTextView.dismissDropDown();
                return;
            }
        }
        this.dropdownPopupDirty = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPopupBackground(android.widget.AutoCompleteTextView autoCompleteTextView) {
        if (IS_LOLLIPOP) {
            int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.filledPopupBackground);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRippleEffect(android.widget.AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.textInputLayout.getBoxBackgroundMode();
        com.google.android.material.shape.MaterialShapeDrawable boxBackground = this.textInputLayout.getBoxBackground();
        int color = com.google.android.material.color.MaterialColors.getColor(autoCompleteTextView, com.google.android.material.R_renamed.attr.colorControlHighlight);
        int[][] iArr = {new int[]{android.R_renamed.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            addRippleEffectOnOutlinedLayout(autoCompleteTextView, color, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            addRippleEffectOnFilledLayout(autoCompleteTextView, color, iArr, boxBackground);
        }
    }

    private void addRippleEffectOnOutlinedLayout(android.widget.AutoCompleteTextView autoCompleteTextView, int i_renamed, int[][] iArr, com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable) {
        android.graphics.drawable.LayerDrawable layerDrawable;
        int color = com.google.android.material.color.MaterialColors.getColor(autoCompleteTextView, com.google.android.material.R_renamed.attr.colorSurface);
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = new com.google.android.material.shape.MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int iLayer = com.google.android.material.color.MaterialColors.layer(i_renamed, color, 0.1f);
        materialShapeDrawable2.setFillColor(new android.content.res.ColorStateList(iArr, new int[]{iLayer, 0}));
        if (IS_LOLLIPOP) {
            materialShapeDrawable2.setTint(color);
            android.content.res.ColorStateList colorStateList = new android.content.res.ColorStateList(iArr, new int[]{iLayer, color});
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable3 = new com.google.android.material.shape.MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{new android.graphics.drawable.RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        androidx.core.h_renamed.v_renamed.a_renamed(autoCompleteTextView, layerDrawable);
    }

    private void addRippleEffectOnFilledLayout(android.widget.AutoCompleteTextView autoCompleteTextView, int i_renamed, int[][] iArr, com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable) {
        int boxBackgroundColor = this.textInputLayout.getBoxBackgroundColor();
        int[] iArr2 = {com.google.android.material.color.MaterialColors.layer(i_renamed, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (IS_LOLLIPOP) {
            androidx.core.h_renamed.v_renamed.a_renamed(autoCompleteTextView, new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = new com.google.android.material.shape.MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable2.setFillColor(new android.content.res.ColorStateList(iArr, iArr2));
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int iJ = androidx.core.h_renamed.v_renamed.j_renamed(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int iK = androidx.core.h_renamed.v_renamed.k_renamed(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        androidx.core.h_renamed.v_renamed.a_renamed(autoCompleteTextView, layerDrawable);
        androidx.core.h_renamed.v_renamed.b_renamed(autoCompleteTextView, iJ, paddingTop, iK, paddingBottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void setUpDropdownShowHideBehavior(final android.widget.AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.isDropdownPopupActive()) {
                        com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
                    }
                    com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.showHideDropdown(autoCompleteTextView);
                }
                return false;
            }
        });
        autoCompleteTextView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(android.view.View view, boolean z_renamed) {
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.textInputLayout.setEndIconActivated(z_renamed);
                if (z_renamed) {
                    return;
                }
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = false;
            }
        });
        if (IS_LOLLIPOP) {
            autoCompleteTextView.setOnDismissListener(new android.widget.AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.7
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public void onDismiss() {
                    com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupDirty = true;
                    com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.dropdownPopupActivatedAt = java.lang.System.currentTimeMillis();
                    com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
                }
            });
        }
    }

    private com.google.android.material.shape.MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f_renamed, float f2, float f3, int i_renamed) {
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModelBuild = com.google.android.material.shape.ShapeAppearanceModel.builder().setTopLeftCornerSize(f_renamed).setTopRightCornerSize(f_renamed).setBottomLeftCornerSize(f2).setBottomRightCornerSize(f2).build();
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawableCreateWithElevationOverlay = com.google.android.material.shape.MaterialShapeDrawable.createWithElevationOverlay(this.context, f3);
        materialShapeDrawableCreateWithElevationOverlay.setShapeAppearanceModel(shapeAppearanceModelBuild);
        materialShapeDrawableCreateWithElevationOverlay.setPadding(0, i_renamed, 0, i_renamed);
        return materialShapeDrawableCreateWithElevationOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDropdownPopupActive() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.widget.AutoCompleteTextView castAutoCompleteTextViewOrThrow(android.widget.EditText editText) {
        if (!(editText instanceof android.widget.AutoCompleteTextView)) {
            throw new java.lang.RuntimeException("EditText needs to be_renamed an_renamed AutoCompleteTextView if an_renamed Exposed Dropdown Menu is_renamed being used.");
        }
        return (android.widget.AutoCompleteTextView) editText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndIconChecked(boolean z_renamed) {
        if (this.isEndIconChecked != z_renamed) {
            this.isEndIconChecked = z_renamed;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(67, 0.0f, 1.0f);
        this.fadeOutAnim = getAlphaAnimator(50, 1.0f, 0.0f);
        this.fadeOutAnim.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.endIconView.setChecked(com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.isEndIconChecked);
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.fadeInAnim.start();
            }
        });
    }

    private android.animation.ValueAnimator getAlphaAnimator(int i_renamed, float... fArr) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(i_renamed);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.google.android.material.textfield.DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimatorOfFloat;
    }
}
