package com.google.android.material.transition;

/* loaded from: classes.dex */
public class FadeProvider implements com.google.android.material.transition.VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f_renamed) {
        this.incomingEndThreshold = f_renamed;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public android.animation.Animator createAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createFadeAnimator(view, 0.0f, 1.0f, 0.0f, this.incomingEndThreshold);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public android.animation.Animator createDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createFadeAnimator(view, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    private static android.animation.Animator createFadeAnimator(final android.view.View view, final float f_renamed, final float f2, final float f3, final float f4) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.FadeProvider.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                view.setAlpha(com.google.android.material.transition.TransitionUtils.lerp(f_renamed, f2, f3, f4, ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        return valueAnimatorOfFloat;
    }
}
