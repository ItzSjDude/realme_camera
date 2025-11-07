package com.google.android.material.transition;

/* loaded from: classes.dex */
abstract class MaterialVisibility<P_renamed extends com.google.android.material.transition.VisibilityAnimatorProvider> extends android.transition.Visibility {
    private P_renamed primaryAnimatorProvider;
    private com.google.android.material.transition.VisibilityAnimatorProvider secondaryAnimatorProvider;

    abstract P_renamed getDefaultPrimaryAnimatorProvider();

    abstract com.google.android.material.transition.VisibilityAnimatorProvider getDefaultSecondaryAnimatorProvider();

    MaterialVisibility() {
    }

    void initialize() {
        this.primaryAnimatorProvider = (P_renamed) getDefaultPrimaryAnimatorProvider();
        this.secondaryAnimatorProvider = getDefaultSecondaryAnimatorProvider();
    }

    public P_renamed getPrimaryAnimatorProvider() {
        if (this.primaryAnimatorProvider == null) {
            this.primaryAnimatorProvider = (P_renamed) getDefaultPrimaryAnimatorProvider();
        }
        return this.primaryAnimatorProvider;
    }

    public com.google.android.material.transition.VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public void setSecondaryAnimatorProvider(com.google.android.material.transition.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    @Override // android.transition.Visibility
    public android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, transitionValues, transitionValues2, true);
    }

    @Override // android.transition.Visibility
    public android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, transitionValues, transitionValues2, false);
    }

    private android.animation.Animator createAnimator(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2, boolean z_renamed) {
        android.animation.Animator animatorCreateDisappear;
        android.animation.Animator animatorCreateDisappear2;
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (z_renamed) {
            animatorCreateDisappear = getPrimaryAnimatorProvider().createAppear(viewGroup, view, transitionValues, transitionValues2);
        } else {
            animatorCreateDisappear = getPrimaryAnimatorProvider().createDisappear(viewGroup, view, transitionValues, transitionValues2);
        }
        if (animatorCreateDisappear != null) {
            arrayList.add(animatorCreateDisappear);
        }
        com.google.android.material.transition.VisibilityAnimatorProvider secondaryAnimatorProvider = getSecondaryAnimatorProvider();
        if (secondaryAnimatorProvider != null) {
            if (z_renamed) {
                animatorCreateDisappear2 = secondaryAnimatorProvider.createAppear(viewGroup, view, transitionValues, transitionValues2);
            } else {
                animatorCreateDisappear2 = secondaryAnimatorProvider.createDisappear(viewGroup, view, transitionValues, transitionValues2);
            }
            if (animatorCreateDisappear2 != null) {
                arrayList.add(animatorCreateDisappear2);
            }
        }
        com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }
}
