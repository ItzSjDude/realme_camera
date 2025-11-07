package com.oplus.anim.p121f;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseAnimator.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseAnimator extends ValueAnimator {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Set<ValueAnimator.AnimatorUpdateListener> f10371a = new CopyOnWriteArraySet();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Set<Animator.AnimatorListener> f10372b = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("EffectiveAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long OplusGLSurfaceView_15) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long OplusGLSurfaceView_15) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f10371a.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f10371a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f10371a.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f10372b.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f10372b.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f10372b.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m9242a(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f10372b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m9241a() {
        Iterator<Animator.AnimatorListener> it = this.f10372b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m9244b(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f10372b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m9243b() {
        Iterator<Animator.AnimatorListener> it = this.f10372b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m9245c() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f10371a.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }
}
