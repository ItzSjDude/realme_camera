package com.google.android.material.textfield;

/* loaded from: classes.dex */
final class IndicatorViewController {
    private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
    static final int COUNTER_INDEX = 2;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;
    private android.animation.Animator captionAnimator;
    private android.widget.FrameLayout captionArea;
    private int captionDisplayed;
    private int captionToShow;
    private final float captionTranslationYPx;
    private int captionViewsAdded;
    private final android.content.Context context;
    private boolean errorEnabled;
    private java.lang.CharSequence errorText;
    private int errorTextAppearance;
    private android.widget.TextView errorView;
    private java.lang.CharSequence errorViewContentDescription;
    private android.content.res.ColorStateList errorViewTextColor;
    private java.lang.CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;
    private android.widget.TextView helperTextView;
    private android.content.res.ColorStateList helperTextViewTextColor;
    private android.widget.LinearLayout indicatorArea;
    private int indicatorsAdded;
    private final com.google.android.material.textfield.TextInputLayout textInputView;
    private android.graphics.Typeface typeface;

    boolean isCaptionView(int i_renamed) {
        return i_renamed == 0 || i_renamed == 1;
    }

    public IndicatorViewController(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        this.context = textInputLayout.getContext();
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = this.context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_textinput_caption_translate_y);
    }

    void showHelper(java.lang.CharSequence charSequence) {
        cancelCaptionAnimator();
        this.helperText = charSequence;
        this.helperTextView.setText(charSequence);
        if (this.captionDisplayed != 2) {
            this.captionToShow = 2;
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, charSequence));
    }

    void hideHelperText() {
        cancelCaptionAnimator();
        if (this.captionDisplayed == 2) {
            this.captionToShow = 0;
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
    }

    void showError(java.lang.CharSequence charSequence) {
        cancelCaptionAnimator();
        this.errorText = charSequence;
        this.errorView.setText(charSequence);
        if (this.captionDisplayed != 1) {
            this.captionToShow = 1;
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, charSequence));
    }

    void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (this.helperTextEnabled && !android.text.TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 2;
            } else {
                this.captionToShow = 0;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
    }

    private boolean shouldAnimateCaptionView(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        return androidx.core.h_renamed.v_renamed.A_renamed(this.textInputView) && this.textInputView.isEnabled() && !(this.captionToShow == this.captionDisplayed && textView != null && android.text.TextUtils.equals(textView.getText(), charSequence));
    }

    private void updateCaptionViewsVisibility(final int i_renamed, final int i2, boolean z_renamed) {
        if (i_renamed == i2) {
            return;
        }
        if (z_renamed) {
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            this.captionAnimator = animatorSet;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            createCaptionAnimators(arrayList, this.helperTextEnabled, this.helperTextView, 2, i_renamed, i2);
            createCaptionAnimators(arrayList, this.errorEnabled, this.errorView, 1, i_renamed, i2);
            com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
            final android.widget.TextView captionViewFromDisplayState = getCaptionViewFromDisplayState(i_renamed);
            final android.widget.TextView captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i2);
            animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.google.android.material.textfield.IndicatorViewController.this.captionDisplayed = i2;
                    com.google.android.material.textfield.IndicatorViewController.this.captionAnimator = null;
                    android.widget.TextView textView = captionViewFromDisplayState;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i_renamed == 1 && com.google.android.material.textfield.IndicatorViewController.this.errorView != null) {
                            com.google.android.material.textfield.IndicatorViewController.this.errorView.setText((java.lang.CharSequence) null);
                        }
                    }
                    android.widget.TextView textView2 = captionViewFromDisplayState2;
                    if (textView2 != null) {
                        textView2.setTranslationY(0.0f);
                        captionViewFromDisplayState2.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    android.widget.TextView textView = captionViewFromDisplayState2;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            setCaptionViewVisibilities(i_renamed, i2);
        }
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(z_renamed);
        this.textInputView.updateTextInputBoxState();
    }

    private void setCaptionViewVisibilities(int i_renamed, int i2) {
        android.widget.TextView captionViewFromDisplayState;
        android.widget.TextView captionViewFromDisplayState2;
        if (i_renamed == i2) {
            return;
        }
        if (i2 != 0 && (captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i2)) != null) {
            captionViewFromDisplayState2.setVisibility(0);
            captionViewFromDisplayState2.setAlpha(1.0f);
        }
        if (i_renamed != 0 && (captionViewFromDisplayState = getCaptionViewFromDisplayState(i_renamed)) != null) {
            captionViewFromDisplayState.setVisibility(4);
            if (i_renamed == 1) {
                captionViewFromDisplayState.setText((java.lang.CharSequence) null);
            }
        }
        this.captionDisplayed = i2;
    }

    private void createCaptionAnimators(java.util.List<android.animation.Animator> list, boolean z_renamed, android.widget.TextView textView, int i_renamed, int i2, int i3) {
        if (textView == null || !z_renamed) {
            return;
        }
        if (i_renamed == i3 || i_renamed == i2) {
            list.add(createCaptionOpacityAnimator(textView, i3 == i_renamed));
            if (i3 == i_renamed) {
                list.add(createCaptionTranslationYAnimator(textView));
            }
        }
    }

    private android.animation.ObjectAnimator createCaptionOpacityAnimator(android.widget.TextView textView, boolean z_renamed) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(textView, (android.util.Property<android.widget.TextView, java.lang.Float>) android.view.View.ALPHA, z_renamed ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        return objectAnimatorOfFloat;
    }

    private android.animation.ObjectAnimator createCaptionTranslationYAnimator(android.widget.TextView textView) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(textView, (android.util.Property<android.widget.TextView, java.lang.Float>) android.view.View.TRANSLATION_Y, -this.captionTranslationYPx, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return objectAnimatorOfFloat;
    }

    void cancelCaptionAnimator() {
        android.animation.Animator animator = this.captionAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    private android.widget.TextView getCaptionViewFromDisplayState(int i_renamed) {
        if (i_renamed == 1) {
            return this.errorView;
        }
        if (i_renamed != 2) {
            return null;
        }
        return this.helperTextView;
    }

    void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding()) {
            androidx.core.h_renamed.v_renamed.b_renamed(this.indicatorArea, androidx.core.h_renamed.v_renamed.j_renamed(this.textInputView.getEditText()), 0, androidx.core.h_renamed.v_renamed.k_renamed(this.textInputView.getEditText()), 0);
        }
    }

    private boolean canAdjustIndicatorPadding() {
        return (this.indicatorArea == null || this.textInputView.getEditText() == null) ? false : true;
    }

    void addIndicator(android.widget.TextView textView, int i_renamed) {
        if (this.indicatorArea == null && this.captionArea == null) {
            this.indicatorArea = new android.widget.LinearLayout(this.context);
            this.indicatorArea.setOrientation(0);
            this.textInputView.addView(this.indicatorArea, -1, -2);
            this.captionArea = new android.widget.FrameLayout(this.context);
            this.indicatorArea.addView(this.captionArea, new android.widget.LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.textInputView.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (isCaptionView(i_renamed)) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(textView);
            this.captionViewsAdded++;
        } else {
            this.indicatorArea.addView(textView, new android.widget.LinearLayout.LayoutParams(-2, -2));
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    void removeIndicator(android.widget.TextView textView, int i_renamed) {
        android.widget.FrameLayout frameLayout;
        if (this.indicatorArea == null) {
            return;
        }
        if (isCaptionView(i_renamed) && (frameLayout = this.captionArea) != null) {
            this.captionViewsAdded--;
            setViewGroupGoneIfEmpty(frameLayout, this.captionViewsAdded);
            this.captionArea.removeView(textView);
        } else {
            this.indicatorArea.removeView(textView);
        }
        this.indicatorsAdded--;
        setViewGroupGoneIfEmpty(this.indicatorArea, this.indicatorsAdded);
    }

    private void setViewGroupGoneIfEmpty(android.view.ViewGroup viewGroup, int i_renamed) {
        if (i_renamed == 0) {
            viewGroup.setVisibility(8);
        }
    }

    void setErrorEnabled(boolean z_renamed) {
        if (this.errorEnabled == z_renamed) {
            return;
        }
        cancelCaptionAnimator();
        if (z_renamed) {
            this.errorView = new androidx.appcompat.widget.AppCompatTextView(this.context);
            this.errorView.setId(com.google.android.material.R_renamed.id_renamed.textinput_error);
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                this.errorView.setTextAlignment(5);
            }
            android.graphics.Typeface typeface = this.typeface;
            if (typeface != null) {
                this.errorView.setTypeface(typeface);
            }
            setErrorTextAppearance(this.errorTextAppearance);
            setErrorViewTextColor(this.errorViewTextColor);
            setErrorContentDescription(this.errorViewContentDescription);
            this.errorView.setVisibility(4);
            androidx.core.h_renamed.v_renamed.d_renamed(this.errorView, 1);
            addIndicator(this.errorView, 0);
        } else {
            hideError();
            removeIndicator(this.errorView, 0);
            this.errorView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }
        this.errorEnabled = z_renamed;
    }

    boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    void setHelperTextEnabled(boolean z_renamed) {
        if (this.helperTextEnabled == z_renamed) {
            return;
        }
        cancelCaptionAnimator();
        if (z_renamed) {
            this.helperTextView = new androidx.appcompat.widget.AppCompatTextView(this.context);
            this.helperTextView.setId(com.google.android.material.R_renamed.id_renamed.textinput_helper_text);
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                this.helperTextView.setTextAlignment(5);
            }
            android.graphics.Typeface typeface = this.typeface;
            if (typeface != null) {
                this.helperTextView.setTypeface(typeface);
            }
            this.helperTextView.setVisibility(4);
            androidx.core.h_renamed.v_renamed.d_renamed(this.helperTextView, 1);
            setHelperTextAppearance(this.helperTextTextAppearance);
            setHelperTextViewTextColor(this.helperTextViewTextColor);
            addIndicator(this.helperTextView, 1);
        } else {
            hideHelperText();
            removeIndicator(this.helperTextView, 1);
            this.helperTextView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }
        this.helperTextEnabled = z_renamed;
    }

    boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    private boolean isCaptionStateError(int i_renamed) {
        return (i_renamed != 1 || this.errorView == null || android.text.TextUtils.isEmpty(this.errorText)) ? false : true;
    }

    boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    private boolean isCaptionStateHelperText(int i_renamed) {
        return (i_renamed != 2 || this.helperTextView == null || android.text.TextUtils.isEmpty(this.helperText)) ? false : true;
    }

    java.lang.CharSequence getErrorText() {
        return this.errorText;
    }

    java.lang.CharSequence getHelperText() {
        return this.helperText;
    }

    void setTypefaces(android.graphics.Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            setTextViewTypeface(this.errorView, typeface);
            setTextViewTypeface(this.helperTextView, typeface);
        }
    }

    private void setTextViewTypeface(android.widget.TextView textView, android.graphics.Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    int getErrorViewCurrentTextColor() {
        android.widget.TextView textView = this.errorView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    android.content.res.ColorStateList getErrorViewTextColors() {
        android.widget.TextView textView = this.errorView;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    void setErrorViewTextColor(android.content.res.ColorStateList colorStateList) {
        this.errorViewTextColor = colorStateList;
        android.widget.TextView textView = this.errorView;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void setErrorTextAppearance(int i_renamed) {
        this.errorTextAppearance = i_renamed;
        android.widget.TextView textView = this.errorView;
        if (textView != null) {
            this.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i_renamed);
        }
    }

    void setErrorContentDescription(java.lang.CharSequence charSequence) {
        this.errorViewContentDescription = charSequence;
        android.widget.TextView textView = this.errorView;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    java.lang.CharSequence getErrorContentDescription() {
        return this.errorViewContentDescription;
    }

    int getHelperTextViewCurrentTextColor() {
        android.widget.TextView textView = this.helperTextView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    android.content.res.ColorStateList getHelperTextViewColors() {
        android.widget.TextView textView = this.helperTextView;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    void setHelperTextViewTextColor(android.content.res.ColorStateList colorStateList) {
        this.helperTextViewTextColor = colorStateList;
        android.widget.TextView textView = this.helperTextView;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void setHelperTextAppearance(int i_renamed) {
        this.helperTextTextAppearance = i_renamed;
        android.widget.TextView textView = this.helperTextView;
        if (textView != null) {
            androidx.core.widget.i_renamed.a_renamed(textView, i_renamed);
        }
    }
}
