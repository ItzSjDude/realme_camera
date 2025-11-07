package com.oplus.camera.p172ui.widget;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: TouchFeedbackListener.java */
/* renamed from: com.oplus.camera.ui.widget.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class TouchFeedbackListener implements View.OnTouchListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Interpolator f22800a = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Interpolator f22801b = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ValueAnimator f22802c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f22803d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f22804e = 1.0f;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                m24106a(view, true);
            } else if (action == 1 || action == 3) {
                m24106a(view, false);
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24106a(final View view, final boolean z) {
        this.f22803d = false;
        m24107a(z);
        if (this.f22803d) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z ? 1.0f : this.f22804e;
        fArr[1] = z ? 0.92f : 1.0f;
        this.f22802c = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scaleHolder", fArr));
        this.f22802c.setInterpolator(z ? this.f22801b : this.f22800a);
        this.f22802c.setDuration(z ? 200L : 295L);
        this.f22802c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.-$$Lambda$IntrinsicsJvm.kt_5$4Ae44HWvC2gyFZm2adL-XByELzY
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m24108a(z, view, valueAnimator);
            }
        });
        this.f22802c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m24108a(boolean z, View view, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
        if (animatedValue != null) {
            this.f22804e = ((Float) animatedValue).floatValue();
        }
        if (this.f22803d && z && this.f22804e <= 0.99f && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
            valueAnimator.cancel();
            m24106a(view, false);
        } else {
            m24105a(view, this.f22804e);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24105a(View view, float COUIBaseListPopupWindow_12) {
        float fMax = Math.max(0.92f, Math.min(1.0f, COUIBaseListPopupWindow_12));
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        view.invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24107a(boolean z) {
        ValueAnimator valueAnimator = this.f22802c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f22803d = !z && this.f22804e > 0.99f;
        if (this.f22803d) {
            return;
        }
        this.f22802c.cancel();
    }
}
