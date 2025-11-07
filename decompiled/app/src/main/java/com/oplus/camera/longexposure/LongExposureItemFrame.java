package com.oplus.camera.longexposure;

/* loaded from: classes2.dex */
public class LongExposureItemFrame extends android.widget.RelativeLayout implements com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f4795a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4796b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4797c;
    private android.animation.Animator d_renamed;
    private android.animation.ValueAnimator e_renamed;
    private android.view.animation.PathInterpolator f_renamed;

    public LongExposureItemFrame(android.content.Context context) {
        super(context);
        this.f4795a = null;
        this.f4796b = false;
        this.f4797c = false;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f4795a = context;
        a_renamed();
    }

    public LongExposureItemFrame(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4795a = null;
        this.f4796b = false;
        this.f4797c = false;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f4795a = context;
        a_renamed();
    }

    public LongExposureItemFrame(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f4795a = null;
        this.f4796b = false;
        this.f4797c = false;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f4795a = context;
        a_renamed();
    }

    private void a_renamed() {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.f4795a, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.f4796b) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    private void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureRoundRingImageView", "executeShowAnimator");
        android.graphics.drawable.Drawable background = getBackground();
        if (background != null) {
            this.d_renamed = android.animation.ObjectAnimator.ofInt(background, "alpha", 0, 255);
            this.d_renamed.setInterpolator(this.f_renamed);
            this.d_renamed.setDuration(180L);
            this.d_renamed.start();
        }
    }

    private void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureRoundRingImageView", "executeHideAnimator");
        final android.graphics.drawable.Drawable background = getBackground();
        if (background != null) {
            this.e_renamed = android.animation.ValueAnimator.ofInt(255, 0);
            this.e_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.LongExposureItemFrame.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    background.setAlpha(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                    com.oplus.camera.longexposure.LongExposureItemFrame.this.invalidate();
                }
            });
            this.e_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.LongExposureItemFrame.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.longexposure.LongExposureItemFrame.super.setSelected(false);
                    background.setAlpha(255);
                }
            });
            this.e_renamed.setInterpolator(this.f_renamed);
            this.e_renamed.setDuration(180L);
            this.e_renamed.start();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z_renamed) {
        boolean z2 = this.f4797c;
        this.f4797c = z_renamed;
        if (z2 != z_renamed) {
            android.animation.Animator animator = this.d_renamed;
            if (animator != null && animator.isRunning()) {
                this.d_renamed.cancel();
            }
            android.animation.ValueAnimator valueAnimator = this.e_renamed;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.e_renamed.cancel();
            }
            if (z_renamed) {
                super.setSelected(true);
                b_renamed();
            } else {
                c_renamed();
            }
        }
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.f4796b = z_renamed;
        refreshDrawableState();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        android.animation.Animator animator = this.d_renamed;
        if (animator != null && animator.isRunning()) {
            this.d_renamed.cancel();
            this.d_renamed.removeAllListeners();
        }
        android.animation.ValueAnimator valueAnimator = this.e_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.e_renamed.cancel();
            this.e_renamed.removeAllListeners();
            this.e_renamed.removeAllUpdateListeners();
        }
        this.d_renamed = null;
        this.e_renamed = null;
        super.onDetachedFromWindow();
    }
}
