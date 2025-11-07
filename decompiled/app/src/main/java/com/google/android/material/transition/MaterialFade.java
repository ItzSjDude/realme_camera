package com.google.android.material.transition;

/* loaded from: classes.dex */
public class MaterialFade extends com.google.android.material.transition.MaterialVisibility<com.google.android.material.transition.FadeProvider> {
    private static final long DEFAULT_DURATION_ENTER = 150;
    private static final long DEFAULT_DURATION_RETURN = 75;
    private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3f;
    private static final float DEFAULT_START_SCALE = 0.8f;
    private boolean entering;

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

    public static com.google.android.material.transition.MaterialFade create() {
        return create(true);
    }

    public static com.google.android.material.transition.MaterialFade create(boolean z_renamed) {
        return new com.google.android.material.transition.MaterialFade(z_renamed);
    }

    private MaterialFade(boolean z_renamed) {
        this.entering = z_renamed;
        setDuration(z_renamed ? 150L : 75L);
        setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.transition.MaterialVisibility
    public com.google.android.material.transition.FadeProvider getDefaultPrimaryAnimatorProvider() {
        com.google.android.material.transition.FadeProvider fadeProvider = new com.google.android.material.transition.FadeProvider();
        if (this.entering) {
            fadeProvider.setIncomingEndThreshold(DEFAULT_FADE_END_THRESHOLD_ENTER);
        }
        return fadeProvider;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    com.google.android.material.transition.VisibilityAnimatorProvider getDefaultSecondaryAnimatorProvider() {
        com.google.android.material.transition.ScaleProvider scaleProvider = new com.google.android.material.transition.ScaleProvider();
        scaleProvider.setScaleOnDisappear(false);
        scaleProvider.setIncomingStartScale(DEFAULT_START_SCALE);
        return scaleProvider;
    }
}
