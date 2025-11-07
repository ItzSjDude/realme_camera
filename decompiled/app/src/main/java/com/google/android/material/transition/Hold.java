package com.google.android.material.transition;

/* loaded from: classes.dex */
public class Hold extends android.transition.Visibility {
    @Override // android.transition.Visibility
    public android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return android.animation.ValueAnimator.ofFloat(0.0f);
    }

    @Override // android.transition.Visibility
    public android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return android.animation.ValueAnimator.ofFloat(0.0f);
    }
}
