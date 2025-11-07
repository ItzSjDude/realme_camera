package com.google.android.material.floatingactionbutton;

/* loaded from: classes.dex */
abstract class BaseMotionStrategy implements com.google.android.material.floatingactionbutton.MotionStrategy {
    private final android.content.Context context;
    private com.google.android.material.animation.MotionSpec defaultMotionSpec;
    private final com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton fab;
    private final java.util.ArrayList<android.animation.Animator.AnimatorListener> listeners = new java.util.ArrayList<>();
    private com.google.android.material.animation.MotionSpec motionSpec;
    private final com.google.android.material.floatingactionbutton.AnimatorTracker tracker;

    BaseMotionStrategy(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker) {
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void setMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        this.motionSpec = motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final com.google.android.material.animation.MotionSpec getCurrentMotionSpec() {
        com.google.android.material.animation.MotionSpec motionSpec = this.motionSpec;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.defaultMotionSpec == null) {
            this.defaultMotionSpec = com.google.android.material.animation.MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
        }
        return (com.google.android.material.animation.MotionSpec) androidx.core.g_renamed.f_renamed.a_renamed(this.defaultMotionSpec);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void addAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void removeAnimationListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final java.util.List<android.animation.Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public com.google.android.material.animation.MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationStart(android.animation.Animator animator) {
        this.tracker.onNextAnimationStart(animator);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationEnd() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationCancel() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public android.animation.AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    android.animation.AnimatorSet createAnimator(com.google.android.material.animation.MotionSpec motionSpec) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (motionSpec.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec.getAnimator("opacity", this.fab, android.view.View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", this.fab, android.view.View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", this.fab, android.view.View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues("width")) {
            arrayList.add(motionSpec.getAnimator("width", this.fab, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec.hasPropertyValues("height")) {
            arrayList.add(motionSpec.getAnimator("height", this.fab, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.HEIGHT));
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }
}
