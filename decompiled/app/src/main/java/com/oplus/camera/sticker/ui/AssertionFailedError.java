package com.oplus.camera.sticker.ui;

/* compiled from: GridItemViewTag.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public com.oplus.camera.ui.LoaddingProgress f5503a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public com.oplus.camera.ui.RotateImageView f5504b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public android.widget.ImageView f5505c;
    private boolean d_renamed = false;
    private android.animation.Animator e_renamed = null;
    private android.animation.Animator f_renamed = null;

    public b_renamed(com.oplus.camera.ui.LoaddingProgress loaddingProgress, com.oplus.camera.ui.RotateImageView rotateImageView, android.widget.ImageView imageView) {
        this.f5503a = null;
        this.f5504b = null;
        this.f5505c = null;
        this.f5503a = loaddingProgress;
        this.f5504b = rotateImageView;
        this.f5505c = imageView;
    }

    protected void a_renamed(boolean z_renamed, boolean z2) {
        android.widget.ImageView imageView = this.f5505c;
        if (imageView == null || this.d_renamed == z_renamed) {
            return;
        }
        android.animation.Animator animator = this.e_renamed;
        if (animator == null) {
            this.e_renamed = android.animation.ObjectAnimator.ofObject(imageView, "alpha", new android.animation.IntEvaluator(), 0, 255);
            this.e_renamed.setDuration(250L);
            this.e_renamed.setInterpolator(com.oplus.camera.util.b_renamed.f7321a);
            this.e_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.sticker.ui.b_renamed.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator2) {
                    com.oplus.camera.sticker.ui.b_renamed.this.f5505c.setVisibility(0);
                    com.oplus.camera.sticker.ui.b_renamed.this.f5505c.setAlpha(0);
                }
            });
        } else if (animator.isRunning()) {
            this.e_renamed.cancel();
        }
        android.animation.Animator animator2 = this.f_renamed;
        if (animator2 == null) {
            this.f_renamed = android.animation.ObjectAnimator.ofObject(this.f5505c, "alpha", new android.animation.IntEvaluator(), 255, 0);
            this.f_renamed.setDuration(250L);
            this.f_renamed.setInterpolator(com.oplus.camera.util.b_renamed.f7321a);
            this.f_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.sticker.ui.b_renamed.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator3) {
                    com.oplus.camera.sticker.ui.b_renamed.this.f5505c.setVisibility(0);
                    com.oplus.camera.sticker.ui.b_renamed.this.f5505c.setAlpha(255);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator3) {
                    com.oplus.camera.sticker.ui.b_renamed.this.f5505c.setVisibility(4);
                }
            });
        } else if (animator2.isRunning()) {
            this.f_renamed.cancel();
        }
        if (!z2) {
            this.f5505c.setAlpha(255);
            this.f5505c.setVisibility(z_renamed ? 0 : 4);
        } else if (z_renamed) {
            this.e_renamed.start();
        } else {
            this.f_renamed.start();
        }
        this.d_renamed = z_renamed;
    }
}
