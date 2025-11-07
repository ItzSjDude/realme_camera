package com.google.android.material.textfield;

/* loaded from: classes.dex */
class ClearTextEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    private static final int ANIMATION_FADE_DURATION = 100;
    private static final int ANIMATION_SCALE_DURATION = 150;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private final android.text.TextWatcher clearTextEndIconTextWatcher;
    private final com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    private android.animation.AnimatorSet iconInAnim;
    private android.animation.ValueAnimator iconOutAnim;

    ClearTextEndIconDelegate(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.clearTextEndIconTextWatcher = new android.text.TextWatcher() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                if (com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() != null) {
                    return;
                }
                com.google.android.material.textfield.ClearTextEndIconDelegate.this.animateIcon(com.google.android.material.textfield.ClearTextEndIconDelegate.hasText(editable));
            }
        };
        this.clearTextOnEditTextAttachedListener = new com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(com.google.android.material.textfield.TextInputLayout textInputLayout2) {
                android.widget.EditText editText = textInputLayout2.getEditText();
                textInputLayout2.setEndIconVisible(com.google.android.material.textfield.ClearTextEndIconDelegate.hasText(editText.getText()));
                textInputLayout2.setEndIconCheckable(false);
                editText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2.1
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(android.view.View view, boolean z_renamed) {
                        com.google.android.material.textfield.ClearTextEndIconDelegate.this.animateIcon((android.text.TextUtils.isEmpty(((android.widget.EditText) view).getText()) ^ true) && z_renamed);
                    }
                });
                editText.removeTextChangedListener(com.google.android.material.textfield.ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                editText.addTextChangedListener(com.google.android.material.textfield.ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            }
        };
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.context, com.google.android.material.R_renamed.drawable.mtrl_ic_cancel));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(com.google.android.material.R_renamed.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new android.view.View.OnClickListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.3
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                android.text.Editable text = com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void onSuffixVisibilityChanged(boolean z_renamed) {
        if (this.textInputLayout.getSuffixText() == null) {
            return;
        }
        animateIcon(z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateIcon(boolean z_renamed) {
        boolean z2 = this.textInputLayout.isEndIconVisible() == z_renamed;
        if (z_renamed) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
                return;
            }
            return;
        }
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (z2) {
            this.iconOutAnim.end();
        }
    }

    private void initAnimators() {
        android.animation.ValueAnimator scaleAnimator = getScaleAnimator();
        android.animation.ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        this.iconInAnim = new android.animation.AnimatorSet();
        this.iconInAnim.playTogether(scaleAnimator, alphaAnimator);
        this.iconInAnim.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        this.iconOutAnim = getAlphaAnimator(1.0f, 0.0f);
        this.iconOutAnim.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }

    private android.animation.ValueAnimator getAlphaAnimator(float... fArr) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.google.android.material.textfield.ClearTextEndIconDelegate.this.endIconView.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimatorOfFloat;
    }

    private android.animation.ValueAnimator getScaleAnimator() {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(ANIMATION_SCALE_FROM_VALUE, 1.0f);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.google.android.material.textfield.ClearTextEndIconDelegate.this.endIconView.setScaleX(fFloatValue);
                com.google.android.material.textfield.ClearTextEndIconDelegate.this.endIconView.setScaleY(fFloatValue);
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasText(android.text.Editable editable) {
        return editable.length() > 0;
    }
}
