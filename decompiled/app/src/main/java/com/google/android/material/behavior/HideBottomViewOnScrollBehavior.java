package com.google.android.material.behavior;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V_renamed extends android.view.View> extends androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed<V_renamed> {
    protected static final int ENTER_ANIMATION_DURATION = 225;
    protected static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY;
    private android.view.ViewPropertyAnimator currentAnimator;
    private int currentState;
    private int height;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.View view, android.view.View view2, int i_renamed, int i2) {
        return i_renamed == 2;
    }

    public HideBottomViewOnScrollBehavior() {
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    public HideBottomViewOnScrollBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, int i_renamed) {
        this.height = v_renamed.getMeasuredHeight() + ((android.view.ViewGroup.MarginLayoutParams) v_renamed.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v_renamed, i_renamed);
    }

    public void setAdditionalHiddenOffsetY(V_renamed v_renamed, int i_renamed) {
        this.additionalHiddenOffsetY = i_renamed;
        if (this.currentState == 1) {
            v_renamed.setTranslationY(this.height + this.additionalHiddenOffsetY);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b_renamed
    public void onNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, V_renamed v_renamed, android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            slideDown(v_renamed);
        } else if (i2 < 0) {
            slideUp(v_renamed);
        }
    }

    public void slideUp(V_renamed v_renamed) {
        if (this.currentState == 2) {
            return;
        }
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v_renamed.clearAnimation();
        }
        this.currentState = 2;
        animateChildTo(v_renamed, 0, 225L, com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    public void slideDown(V_renamed v_renamed) {
        if (this.currentState == 1) {
            return;
        }
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v_renamed.clearAnimation();
        }
        this.currentState = 1;
        animateChildTo(v_renamed, this.height + this.additionalHiddenOffsetY, 175L, com.google.android.material.animation.AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    }

    private void animateChildTo(V_renamed v_renamed, int i_renamed, long j_renamed, android.animation.TimeInterpolator timeInterpolator) {
        this.currentAnimator = v_renamed.animate().translationY(i_renamed).setInterpolator(timeInterpolator).setDuration(j_renamed).setListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.behavior.HideBottomViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }
}
