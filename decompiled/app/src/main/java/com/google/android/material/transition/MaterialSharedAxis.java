package com.google.android.material.transition;

/* loaded from: classes.dex */
public class MaterialSharedAxis extends com.google.android.material.transition.MaterialVisibility<com.google.android.material.transition.VisibilityAnimatorProvider> {
    public static final int X_renamed = 0;
    public static final int Y_renamed = 1;
    public static final int Z_renamed = 2;
    private final int axis;
    private final boolean forward;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ com.google.android.material.transition.VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

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

    public static com.google.android.material.transition.MaterialSharedAxis create(int i_renamed, boolean z_renamed) {
        return new com.google.android.material.transition.MaterialSharedAxis(i_renamed, z_renamed);
    }

    private MaterialSharedAxis(int i_renamed, boolean z_renamed) {
        this.axis = i_renamed;
        this.forward = z_renamed;
        setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        initialize();
    }

    public int getAxis() {
        return this.axis;
    }

    public boolean isEntering() {
        return this.forward;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    com.google.android.material.transition.VisibilityAnimatorProvider getDefaultPrimaryAnimatorProvider() {
        int i_renamed = this.axis;
        if (i_renamed == 0) {
            return new com.google.android.material.transition.SlideDistanceProvider(this.forward ? 8388613 : 8388611);
        }
        if (i_renamed == 1) {
            return new com.google.android.material.transition.SlideDistanceProvider(this.forward ? 80 : 48);
        }
        if (i_renamed == 2) {
            return new com.google.android.material.transition.ScaleProvider(this.forward);
        }
        throw new java.lang.IllegalArgumentException("Invalid axis: " + this.axis);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public com.google.android.material.transition.VisibilityAnimatorProvider getDefaultSecondaryAnimatorProvider() {
        return new com.google.android.material.transition.FadeThroughProvider();
    }
}
