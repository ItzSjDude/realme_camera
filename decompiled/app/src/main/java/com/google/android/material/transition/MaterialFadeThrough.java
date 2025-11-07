package com.google.android.material.transition;

/* loaded from: classes.dex */
public class MaterialFadeThrough extends com.google.android.material.transition.MaterialVisibility<com.google.android.material.transition.FadeThroughProvider> {
    private static final float DEFAULT_START_SCALE = 0.92f;

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ com.google.android.material.transition.VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(com.google.android.material.transition.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }

    public static com.google.android.material.transition.MaterialFadeThrough create() {
        return new com.google.android.material.transition.MaterialFadeThrough();
    }

    private MaterialFadeThrough() {
        setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.transition.MaterialVisibility
    public com.google.android.material.transition.FadeThroughProvider getDefaultPrimaryAnimatorProvider() {
        return new com.google.android.material.transition.FadeThroughProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    com.google.android.material.transition.VisibilityAnimatorProvider getDefaultSecondaryAnimatorProvider() {
        com.google.android.material.transition.ScaleProvider scaleProvider = new com.google.android.material.transition.ScaleProvider();
        scaleProvider.setScaleOnDisappear(false);
        scaleProvider.setIncomingStartScale(DEFAULT_START_SCALE);
        return scaleProvider;
    }
}
