package com.google.android.material.transition;

/* loaded from: classes.dex */
public class ScaleProvider implements com.google.android.material.transition.VisibilityAnimatorProvider {
    private boolean entering;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    public ScaleProvider() {
        this(true);
    }

    public ScaleProvider(boolean z_renamed) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.entering = z_renamed;
    }

    public boolean isEntering() {
        return this.entering;
    }

    public void setEntering(boolean z_renamed) {
        this.entering = z_renamed;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setScaleOnDisappear(boolean z_renamed) {
        this.scaleOnDisappear = z_renamed;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public void setOutgoingStartScale(float f_renamed) {
        this.outgoingStartScale = f_renamed;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public void setOutgoingEndScale(float f_renamed) {
        this.outgoingEndScale = f_renamed;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public void setIncomingStartScale(float f_renamed) {
        this.incomingStartScale = f_renamed;
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public void setIncomingEndScale(float f_renamed) {
        this.incomingEndScale = f_renamed;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public android.animation.Animator createAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        if (this.entering) {
            return createScaleAnimator(view, this.incomingStartScale, this.incomingEndScale);
        }
        return createScaleAnimator(view, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public android.animation.Animator createDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        if (!this.scaleOnDisappear) {
            return null;
        }
        if (this.entering) {
            return createScaleAnimator(view, this.outgoingStartScale, this.outgoingEndScale);
        }
        return createScaleAnimator(view, this.incomingEndScale, this.incomingStartScale);
    }

    private static android.animation.Animator createScaleAnimator(android.view.View view, float f_renamed, float f2) {
        return android.animation.ObjectAnimator.ofPropertyValuesHolder(view, android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.SCALE_X, f_renamed, f2), android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.SCALE_Y, f_renamed, f2));
    }
}
