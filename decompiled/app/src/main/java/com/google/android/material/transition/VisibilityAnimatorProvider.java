package com.google.android.material.transition;

/* loaded from: classes.dex */
public interface VisibilityAnimatorProvider {
    android.animation.Animator createAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2);

    android.animation.Animator createDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2);
}
