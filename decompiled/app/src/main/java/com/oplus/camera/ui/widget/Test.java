package com.oplus.camera.ui.widget;

/* compiled from: TouchFeedbackListener.java */
/* loaded from: classes2.dex */
public class d_renamed implements android.view.View.OnTouchListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.animation.Interpolator f7266a = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.view.animation.Interpolator f7267b = new android.view.animation.PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.animation.ValueAnimator f7268c = null;
    private boolean d_renamed = false;
    private float e_renamed = 1.0f;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        if (view.isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a_renamed(view, true);
            } else if (action == 1 || action == 3) {
                a_renamed(view, false);
            }
        }
        return false;
    }

    private void a_renamed(final android.view.View view, final boolean z_renamed) {
        this.d_renamed = false;
        a_renamed(z_renamed);
        if (this.d_renamed) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z_renamed ? 1.0f : this.e_renamed;
        fArr[1] = z_renamed ? 0.92f : 1.0f;
        this.f7268c = android.animation.ValueAnimator.ofPropertyValuesHolder(android.animation.PropertyValuesHolder.ofFloat("scaleHolder", fArr));
        this.f7268c.setInterpolator(z_renamed ? this.f7267b : this.f7266a);
        this.f7268c.setDuration(z_renamed ? 200L : 295L);
        this.f7268c.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.-$$Lambda$d_renamed$4Ae44HWvC2gyFZm2adL-XByELzY
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(z_renamed, view, valueAnimator);
            }
        });
        this.f7268c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(boolean z_renamed, android.view.View view, android.animation.ValueAnimator valueAnimator) {
        java.lang.Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
        if (animatedValue != null) {
            this.e_renamed = ((java.lang.Float) animatedValue).floatValue();
        }
        if (this.d_renamed && z_renamed && this.e_renamed <= 0.99f && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
            valueAnimator.cancel();
            a_renamed(view, false);
        } else {
            a_renamed(view, this.e_renamed);
        }
    }

    private void a_renamed(android.view.View view, float f_renamed) {
        float fMax = java.lang.Math.max(0.92f, java.lang.Math.min(1.0f, f_renamed));
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        view.invalidate();
    }

    private void a_renamed(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.f7268c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.d_renamed = !z_renamed && this.e_renamed > 0.99f;
        if (this.d_renamed) {
            return;
        }
        this.f7268c.cancel();
    }
}
