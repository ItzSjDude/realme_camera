package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public abstract class COUISlideDeleteAnimation {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.View f2833a;

    public abstract void a_renamed();

    /* renamed from: com.coui.appcompat.widget.COUISlideDeleteAnimation$1, reason: invalid class name */
    class SceneLoader_2 implements android.animation.ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.COUISlideDeleteAnimation f2834a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.f2834a.f2833a.scrollTo(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUISlideDeleteAnimation$2, reason: invalid class name */
    class XPanMode_2 implements android.animation.Animator.AnimatorListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.COUISlideDeleteAnimation f2835a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.f2835a.a_renamed();
        }
    }

    private static class ViewWrapper {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.view.View f2836a;

        public int getHeight() {
            return this.f2836a.getLayoutParams().height;
        }

        public void setHeight(int i_renamed) {
            this.f2836a.getLayoutParams().height = i_renamed;
            this.f2836a.requestLayout();
        }
    }
}
