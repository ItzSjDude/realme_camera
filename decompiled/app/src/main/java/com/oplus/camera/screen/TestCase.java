package com.oplus.camera.screen;

/* compiled from: ScreenModeChangeAnimation.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.e_renamed.b_renamed f5366a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.animation.ValueAnimator f5367b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.e_renamed.a_renamed f5368c;
    private android.animation.ValueAnimator d_renamed;
    private float e_renamed = 1.0f;
    private android.view.animation.PathInterpolator f_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator g_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* compiled from: ScreenModeChangeAnimation.java */
    public interface b_renamed {
        android.view.View a_renamed();

        android.view.View b_renamed();

        void c_renamed();
    }

    public e_renamed(com.oplus.camera.screen.e_renamed.b_renamed bVar) {
        this.f5366a = null;
        this.f5367b = null;
        this.f5368c = null;
        this.d_renamed = null;
        this.f5366a = bVar;
        this.f5367b = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
        this.d_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(250L);
        this.f5367b.setInterpolator(this.g_renamed);
        this.d_renamed.setInterpolator(this.f_renamed);
        this.f5367b.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.screen.-$$Lambda$e_renamed$dJ6gzVC91PAKobEjcz70VTFKreU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.b_renamed(valueAnimator);
            }
        });
        this.d_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.screen.-$$Lambda$e_renamed$DX1nI9lnYfgtzG1ahA4nSH9nYPo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(valueAnimator);
            }
        });
        this.f5368c = new com.oplus.camera.screen.e_renamed.a_renamed();
        this.f5367b.addListener(this.f5368c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.animation.ValueAnimator valueAnimator) {
        this.e_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f5366a.a_renamed().setAlpha(this.e_renamed);
        android.view.View viewB = this.f5366a.b_renamed();
        if (viewB != null) {
            viewB.setAlpha(this.e_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        this.e_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f5366a.a_renamed().setAlpha(this.e_renamed);
        android.view.View viewB = this.f5366a.b_renamed();
        if (viewB != null) {
            viewB.setAlpha(this.e_renamed);
        }
    }

    public void a_renamed() {
        a_renamed(true);
        this.f5367b.setFloatValues(this.e_renamed, 0.0f);
        this.f5367b.start();
    }

    public void b_renamed() {
        a_renamed(false);
    }

    public void a_renamed(boolean z_renamed) {
        if (this.f5367b.isRunning()) {
            this.f5368c.f5370b = !z_renamed;
            this.f5367b.cancel();
        }
        if (this.d_renamed.isRunning()) {
            this.d_renamed.cancel();
        }
    }

    /* compiled from: ScreenModeChangeAnimation.java */
    public class a_renamed extends android.animation.AnimatorListenerAdapter {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f5370b = true;

        public a_renamed() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            if (this.f5370b) {
                com.oplus.camera.screen.e_renamed.this.f5366a.c_renamed();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.oplus.camera.screen.e_renamed.this.f5366a.c_renamed();
            com.oplus.camera.screen.e_renamed.this.d_renamed.start();
        }
    }
}
