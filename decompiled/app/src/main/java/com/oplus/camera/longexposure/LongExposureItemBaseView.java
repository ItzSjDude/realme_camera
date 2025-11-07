package com.oplus.camera.longexposure;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;

/* loaded from: classes2.dex */
public class LongExposureItemBaseView extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f14505a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f14506b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ValueAnimator f14507c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f14508d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f14509e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f14510f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Interpolator f14511g;

    public LongExposureItemBaseView(Context context) {
        super(context);
        this.f14505a = false;
        this.f14506b = true;
        this.f14507c = null;
        this.f14508d = 0.0f;
        this.f14509e = 0.0f;
        this.f14510f = 0.0f;
        this.f14511g = null;
        m14543a();
    }

    public LongExposureItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14505a = false;
        this.f14506b = true;
        this.f14507c = null;
        this.f14508d = 0.0f;
        this.f14509e = 0.0f;
        this.f14510f = 0.0f;
        this.f14511g = null;
        m14543a();
    }

    public LongExposureItemBaseView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f14505a = false;
        this.f14506b = true;
        this.f14507c = null;
        this.f14508d = 0.0f;
        this.f14509e = 0.0f;
        this.f14510f = 0.0f;
        this.f14511g = null;
        m14543a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14543a() {
        this.f14508d = 1.0f;
        this.f14509e = 1.0f;
        if (this.f14506b) {
            this.f14510f = 0.8f;
        }
        this.f14511g = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f14506b) {
            int action = motionEvent.getAction();
            if (action == 0) {
                m14545a(true);
            } else if (action == 1 || action == 3) {
                m14545a(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14545a(final boolean z) {
        this.f14505a = false;
        m14549b(z);
        if (this.f14505a) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z ? 1.0f : this.f14508d;
        fArr[1] = z ? this.f14510f : 1.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 1.0f : this.f14509e;
        fArr2[1] = z ? 0.92f : 1.0f;
        this.f14507c = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.f14507c.setInterpolator(this.f14511g);
        this.f14507c.setDuration(z ? 200L : 340L);
        this.f14507c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.LongExposureItemBaseView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
                if (animatedValue == null) {
                    LongExposureItemBaseView.this.f14509e = 0.0f;
                } else {
                    LongExposureItemBaseView.this.f14509e = ((Float) animatedValue).floatValue();
                }
                if (LongExposureItemBaseView.this.f14505a && z && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    LongExposureItemBaseView.this.m14545a(false);
                    return;
                }
                Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
                if (animatedValue2 == null) {
                    LongExposureItemBaseView.this.f14508d = 0.0f;
                } else {
                    LongExposureItemBaseView.this.f14508d = ((Float) animatedValue2).floatValue();
                }
                LongExposureItemBaseView longExposureItemBaseView = LongExposureItemBaseView.this;
                longExposureItemBaseView.setScale(longExposureItemBaseView.f14509e);
            }
        });
        this.f14507c.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14549b(boolean z) {
        ValueAnimator valueAnimator = this.f14507c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f14505a = !z && ((float) this.f14507c.getCurrentPlayTime()) < ((float) this.f14507c.getDuration()) * 0.4f;
        if (this.f14505a) {
            return;
        }
        this.f14507c.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float COUIBaseListPopupWindow_12) {
        float fMax = Math.max(0.92f, Math.min(1.0f, COUIBaseListPopupWindow_12));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }
}
