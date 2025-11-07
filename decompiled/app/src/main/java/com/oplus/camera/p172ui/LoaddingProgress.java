package com.oplus.camera.p172ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class LoaddingProgress extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private ObjectAnimator f17121a;

    public LoaddingProgress(Context context) {
        super(context);
        this.f17121a = null;
        m18289b();
    }

    public LoaddingProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17121a = null;
        m18289b();
    }

    public LoaddingProgress(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17121a = null;
        m18289b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18289b() {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f17121a = ObjectAnimator.ofFloat(this, "rotation", 0.0f, 360.0f);
        this.f17121a.setDuration(1000L);
        this.f17121a.setRepeatCount(-1);
        this.f17121a.setInterpolator(linearInterpolator);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18290a() {
        ObjectAnimator objectAnimator = this.f17121a;
        if (objectAnimator == null || objectAnimator.isRunning() || this.f17121a.isStarted()) {
            return;
        }
        this.f17121a.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f17121a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }
}
