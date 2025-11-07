package com.coui.appcompat.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes.dex */
public abstract class COUISlideDeleteAnimation {

    /* renamed from: PlatformImplementations.kt_3 */
    private View f7755a;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void m7431a();

    /* renamed from: com.coui.appcompat.widget.COUISlideDeleteAnimation$1 */
    class C14241 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUISlideDeleteAnimation f7756a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7756a.f7755a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUISlideDeleteAnimation$2 */
    class C14252 implements Animator.AnimatorListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUISlideDeleteAnimation f7757a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7757a.m7431a();
        }
    }

    private static class ViewWrapper {

        /* renamed from: PlatformImplementations.kt_3 */
        View f7758a;

        public int getHeight() {
            return this.f7758a.getLayoutParams().height;
        }

        public void setHeight(int OplusGLSurfaceView_13) {
            this.f7758a.getLayoutParams().height = OplusGLSurfaceView_13;
            this.f7758a.requestLayout();
        }
    }
}
