package com.oplus.camera.longexposure;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;

/* loaded from: classes2.dex */
public class LongExposureItemFrame extends RelativeLayout implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f14514a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f14515b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f14516c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Animator f14517d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ValueAnimator f14518e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PathInterpolator f14519f;

    public LongExposureItemFrame(Context context) {
        super(context);
        this.f14514a = null;
        this.f14515b = false;
        this.f14516c = false;
        this.f14517d = null;
        this.f14518e = null;
        this.f14519f = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f14514a = context;
        m14551a();
    }

    public LongExposureItemFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14514a = null;
        this.f14515b = false;
        this.f14516c = false;
        this.f14517d = null;
        this.f14518e = null;
        this.f14519f = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f14514a = context;
        m14551a();
    }

    public LongExposureItemFrame(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f14514a = null;
        this.f14515b = false;
        this.f14516c = false;
        this.f14517d = null;
        this.f14518e = null;
        this.f14519f = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f14514a = context;
        m14551a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14551a() {
        InverseManager.INS.registerInverse(this.f14514a, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f14515b) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14553b() {
        CameraLog.m12954a("LongExposureRoundRingImageView", "executeShowAnimator");
        Drawable background = getBackground();
        if (background != null) {
            this.f14517d = ObjectAnimator.ofInt(background, "alpha", 0, 255);
            this.f14517d.setInterpolator(this.f14519f);
            this.f14517d.setDuration(180L);
            this.f14517d.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14554c() {
        CameraLog.m12954a("LongExposureRoundRingImageView", "executeHideAnimator");
        final Drawable background = getBackground();
        if (background != null) {
            this.f14518e = ValueAnimator.ofInt(255, 0);
            this.f14518e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.LongExposureItemFrame.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    background.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    LongExposureItemFrame.this.invalidate();
                }
            });
            this.f14518e.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.LongExposureItemFrame.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    LongExposureItemFrame.super.setSelected(false);
                    background.setAlpha(255);
                }
            });
            this.f14518e.setInterpolator(this.f14519f);
            this.f14518e.setDuration(180L);
            this.f14518e.start();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        boolean z2 = this.f14516c;
        this.f14516c = z;
        if (z2 != z) {
            Animator animator = this.f14517d;
            if (animator != null && animator.isRunning()) {
                this.f14517d.cancel();
            }
            ValueAnimator valueAnimator = this.f14518e;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f14518e.cancel();
            }
            if (z) {
                super.setSelected(true);
                m14553b();
            } else {
                m14554c();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f14515b = z;
        refreshDrawableState();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Animator animator = this.f14517d;
        if (animator != null && animator.isRunning()) {
            this.f14517d.cancel();
            this.f14517d.removeAllListeners();
        }
        ValueAnimator valueAnimator = this.f14518e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14518e.cancel();
            this.f14518e.removeAllListeners();
            this.f14518e.removeAllUpdateListeners();
        }
        this.f14517d = null;
        this.f14518e = null;
        super.onDetachedFromWindow();
    }
}
