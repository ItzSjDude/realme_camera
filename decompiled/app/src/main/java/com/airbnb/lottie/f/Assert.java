package com.airbnb.lottie.f_renamed;

/* compiled from: BaseLottieAnimator.java */
/* loaded from: classes.dex */
public abstract class a_renamed extends android.animation.ValueAnimator {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.Set<android.animation.ValueAnimator.AnimatorUpdateListener> f2250a = new java.util.concurrent.CopyOnWriteArraySet();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Set<android.animation.Animator.AnimatorListener> f2251b = new java.util.concurrent.CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j_renamed) {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public android.animation.ValueAnimator setDuration(long j_renamed) {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(android.animation.TimeInterpolator timeInterpolator) {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2250a.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2250a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f2250a.clear();
    }

    @Override // android.animation.Animator
    public void addListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.f2251b.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.f2251b.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f2251b.clear();
    }

    void a_renamed(boolean z_renamed) {
        for (android.animation.Animator.AnimatorListener animatorListener : this.f2251b) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z_renamed);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    void a_renamed() {
        java.util.Iterator<android.animation.Animator.AnimatorListener> it = this.f2251b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void b_renamed(boolean z_renamed) {
        for (android.animation.Animator.AnimatorListener animatorListener : this.f2251b) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z_renamed);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    void b_renamed() {
        java.util.Iterator<android.animation.Animator.AnimatorListener> it = this.f2251b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void c_renamed() {
        java.util.Iterator<android.animation.ValueAnimator.AnimatorUpdateListener> it = this.f2250a.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }
}
