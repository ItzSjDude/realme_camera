package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class LoaddingProgress extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.animation.ObjectAnimator f5760a;

    public LoaddingProgress(android.content.Context context) {
        super(context);
        this.f5760a = null;
        b_renamed();
    }

    public LoaddingProgress(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5760a = null;
        b_renamed();
    }

    public LoaddingProgress(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5760a = null;
        b_renamed();
    }

    private void b_renamed() {
        android.view.animation.LinearInterpolator linearInterpolator = new android.view.animation.LinearInterpolator();
        this.f5760a = android.animation.ObjectAnimator.ofFloat(this, "rotation", 0.0f, 360.0f);
        this.f5760a.setDuration(1000L);
        this.f5760a.setRepeatCount(-1);
        this.f5760a.setInterpolator(linearInterpolator);
    }

    public void a_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.f5760a;
        if (objectAnimator == null || objectAnimator.isRunning() || this.f5760a.isStarted()) {
            return;
        }
        this.f5760a.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.ObjectAnimator objectAnimator = this.f5760a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }
}
