package com.oplus.camera.ui.menu.facebeauty;

/* loaded from: classes2.dex */
public class FaceBeautyScaleView extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6383a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f6384b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f6385c;
    private android.view.animation.Interpolator d_renamed;
    private boolean e_renamed;
    private float f_renamed;
    private android.animation.ValueAnimator g_renamed;

    public FaceBeautyScaleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceBeautyScaleView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6383a = true;
        this.f6384b = 0.0f;
        this.f6385c = 0.0f;
        this.d_renamed = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        this.e_renamed = false;
        this.f_renamed = 0.0f;
        this.g_renamed = null;
        a_renamed();
    }

    private void a_renamed() {
        this.f6384b = 1.0f;
        this.f_renamed = 1.0f;
        if (this.f6383a) {
            this.f6385c = 0.8f;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && this.f6383a) {
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
        this.e_renamed = false;
        b_renamed(z_renamed);
        if (this.e_renamed) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z_renamed ? 1.0f : this.f6384b;
        fArr[1] = z_renamed ? this.f6385c : 1.0f;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z_renamed ? 1.0f : this.f_renamed;
        fArr2[1] = z_renamed ? 0.92f : 1.0f;
        this.g_renamed = android.animation.ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, android.animation.PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.g_renamed.setInterpolator(this.d_renamed);
        this.g_renamed.setDuration(z_renamed ? 200L : 340L);
        this.g_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView.this.f_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                if (com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView.this.e_renamed && z_renamed && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView.this.a_renamed(false);
                } else {
                    com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView.this.f6384b = ((java.lang.Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView faceBeautyScaleView = com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView.this;
                    faceBeautyScaleView.setScale(faceBeautyScaleView.f_renamed);
                }
            }
        });
        this.g_renamed.start();
    }

    private void b_renamed(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.g_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.e_renamed = !z_renamed && ((float) this.g_renamed.getCurrentPlayTime()) < ((float) this.g_renamed.getDuration()) * 0.4f;
        if (this.e_renamed) {
            return;
        }
        this.g_renamed.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float f_renamed) {
        float fMax = java.lang.Math.max(0.92f, java.lang.Math.min(1.0f, f_renamed));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }
}
