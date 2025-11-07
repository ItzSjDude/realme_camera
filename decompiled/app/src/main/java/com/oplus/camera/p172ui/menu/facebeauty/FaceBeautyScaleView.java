package com.oplus.camera.p172ui.menu.facebeauty;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;

/* loaded from: classes2.dex */
public class FaceBeautyScaleView extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f19158a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f19159b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f19160c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Interpolator f19161d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f19162e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f19163f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ValueAnimator f19164g;

    public FaceBeautyScaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceBeautyScaleView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19158a = true;
        this.f19159b = 0.0f;
        this.f19160c = 0.0f;
        this.f19161d = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        this.f19162e = false;
        this.f19163f = 0.0f;
        this.f19164g = null;
        m20495a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20495a() {
        this.f19159b = 1.0f;
        this.f19163f = 1.0f;
        if (this.f19158a) {
            this.f19160c = 0.8f;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f19158a) {
            int action = motionEvent.getAction();
            if (action == 0) {
                m20497a(true);
            } else if (action == 1 || action == 3) {
                m20497a(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20497a(final boolean z) {
        this.f19162e = false;
        m20501b(z);
        if (this.f19162e) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z ? 1.0f : this.f19159b;
        fArr[1] = z ? this.f19160c : 1.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 1.0f : this.f19163f;
        fArr2[1] = z ? 0.92f : 1.0f;
        this.f19164g = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.f19164g.setInterpolator(this.f19161d);
        this.f19164g.setDuration(z ? 200L : 340L);
        this.f19164g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.FaceBeautyScaleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FaceBeautyScaleView.this.f19163f = ((Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                if (FaceBeautyScaleView.this.f19162e && z && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    FaceBeautyScaleView.this.m20497a(false);
                } else {
                    FaceBeautyScaleView.this.f19159b = ((Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    FaceBeautyScaleView faceBeautyScaleView = FaceBeautyScaleView.this;
                    faceBeautyScaleView.setScale(faceBeautyScaleView.f19163f);
                }
            }
        });
        this.f19164g.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20501b(boolean z) {
        ValueAnimator valueAnimator = this.f19164g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f19162e = !z && ((float) this.f19164g.getCurrentPlayTime()) < ((float) this.f19164g.getDuration()) * 0.4f;
        if (this.f19162e) {
            return;
        }
        this.f19164g.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float COUIBaseListPopupWindow_12) {
        float fMax = Math.max(0.92f, Math.min(1.0f, COUIBaseListPopupWindow_12));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }
}
