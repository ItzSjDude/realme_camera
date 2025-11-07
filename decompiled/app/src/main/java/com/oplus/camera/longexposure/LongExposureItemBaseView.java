package com.oplus.camera.longexposure;

/* loaded from: classes2.dex */
public class LongExposureItemBaseView extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f4790a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4791b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.animation.ValueAnimator f4792c;
    private float d_renamed;
    private float e_renamed;
    private float f_renamed;
    private android.view.animation.Interpolator g_renamed;

    public LongExposureItemBaseView(android.content.Context context) {
        super(context);
        this.f4790a = false;
        this.f4791b = true;
        this.f4792c = null;
        this.d_renamed = 0.0f;
        this.e_renamed = 0.0f;
        this.f_renamed = 0.0f;
        this.g_renamed = null;
        a_renamed();
    }

    public LongExposureItemBaseView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4790a = false;
        this.f4791b = true;
        this.f4792c = null;
        this.d_renamed = 0.0f;
        this.e_renamed = 0.0f;
        this.f_renamed = 0.0f;
        this.g_renamed = null;
        a_renamed();
    }

    public LongExposureItemBaseView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f4790a = false;
        this.f4791b = true;
        this.f4792c = null;
        this.d_renamed = 0.0f;
        this.e_renamed = 0.0f;
        this.f_renamed = 0.0f;
        this.g_renamed = null;
        a_renamed();
    }

    private void a_renamed() {
        this.d_renamed = 1.0f;
        this.e_renamed = 1.0f;
        if (this.f4791b) {
            this.f_renamed = 0.8f;
        }
        this.g_renamed = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && this.f4791b) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a_renamed(true);
            } else if (action == 1 || action == 3) {
                a_renamed(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final boolean z_renamed) {
        this.f4790a = false;
        b_renamed(z_renamed);
        if (this.f4790a) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z_renamed ? 1.0f : this.d_renamed;
        fArr[1] = z_renamed ? this.f_renamed : 1.0f;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z_renamed ? 1.0f : this.e_renamed;
        fArr2[1] = z_renamed ? 0.92f : 1.0f;
        this.f4792c = android.animation.ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, android.animation.PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.f4792c.setInterpolator(this.g_renamed);
        this.f4792c.setDuration(z_renamed ? 200L : 340L);
        this.f4792c.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.LongExposureItemBaseView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                java.lang.Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
                if (animatedValue == null) {
                    com.oplus.camera.longexposure.LongExposureItemBaseView.this.e_renamed = 0.0f;
                } else {
                    com.oplus.camera.longexposure.LongExposureItemBaseView.this.e_renamed = ((java.lang.Float) animatedValue).floatValue();
                }
                if (com.oplus.camera.longexposure.LongExposureItemBaseView.this.f4790a && z_renamed && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    com.oplus.camera.longexposure.LongExposureItemBaseView.this.a_renamed(false);
                    return;
                }
                java.lang.Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
                if (animatedValue2 == null) {
                    com.oplus.camera.longexposure.LongExposureItemBaseView.this.d_renamed = 0.0f;
                } else {
                    com.oplus.camera.longexposure.LongExposureItemBaseView.this.d_renamed = ((java.lang.Float) animatedValue2).floatValue();
                }
                com.oplus.camera.longexposure.LongExposureItemBaseView longExposureItemBaseView = com.oplus.camera.longexposure.LongExposureItemBaseView.this;
                longExposureItemBaseView.setScale(longExposureItemBaseView.e_renamed);
            }
        });
        this.f4792c.start();
    }

    private void b_renamed(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.f4792c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f4790a = !z_renamed && ((float) this.f4792c.getCurrentPlayTime()) < ((float) this.f4792c.getDuration()) * 0.4f;
        if (this.f4790a) {
            return;
        }
        this.f4792c.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float f_renamed) {
        float fMax = java.lang.Math.max(0.92f, java.lang.Math.min(1.0f, f_renamed));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }
}
