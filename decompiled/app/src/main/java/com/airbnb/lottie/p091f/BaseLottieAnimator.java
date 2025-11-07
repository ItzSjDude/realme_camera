package com.airbnb.lottie.p091f;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseLottieAnimator.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class BaseLottieAnimator extends ValueAnimator {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Set<ValueAnimator.AnimatorUpdateListener> f5866a = new CopyOnWriteArraySet();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Set<Animator.AnimatorListener> f5867b = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long OplusGLSurfaceView_15) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long OplusGLSurfaceView_15) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f5866a.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f5866a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f5866a.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f5867b.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f5867b.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f5867b.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m6086a(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f5867b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m6085a() {
        Iterator<Animator.AnimatorListener> it = this.f5867b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m6088b(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f5867b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m6087b() {
        Iterator<Animator.AnimatorListener> it = this.f5867b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m6089c() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f5866a.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }
}
