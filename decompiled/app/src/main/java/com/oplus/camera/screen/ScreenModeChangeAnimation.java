package com.oplus.camera.screen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;

/* compiled from: ScreenModeChangeAnimation.java */
/* renamed from: com.oplus.camera.screen.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class ScreenModeChangeAnimation {

    /* renamed from: PlatformImplementations.kt_3 */
    private IntrinsicsJvm.kt_4 f16025a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ValueAnimator f16026b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f16027c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ValueAnimator f16028d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f16029e = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PathInterpolator f16030f = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PathInterpolator f16031g = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* compiled from: ScreenModeChangeAnimation.java */
    /* renamed from: com.oplus.camera.screen.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        View mo16644a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        View mo16645b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo16646c();
    }

    public ScreenModeChangeAnimation(IntrinsicsJvm.kt_4 bVar) {
        this.f16025a = null;
        this.f16026b = null;
        this.f16027c = null;
        this.f16028d = null;
        this.f16025a = bVar;
        this.f16026b = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
        this.f16028d = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(250L);
        this.f16026b.setInterpolator(this.f16031g);
        this.f16028d.setInterpolator(this.f16030f);
        this.f16026b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.screen.-$$Lambda$COUIBaseListPopupWindow_8$dJ6gzVC91PAKobEjcz70VTFKreU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m16639b(valueAnimator);
            }
        });
        this.f16028d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.screen.-$$Lambda$COUIBaseListPopupWindow_8$DX1nI9lnYfgtzG1ahA4nSH9nYPo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m16637a(valueAnimator);
            }
        });
        this.f16027c = new PlatformImplementations.kt_3();
        this.f16026b.addListener(this.f16027c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m16639b(ValueAnimator valueAnimator) {
        this.f16029e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f16025a.mo16644a().setAlpha(this.f16029e);
        View viewMo16645b = this.f16025a.mo16645b();
        if (viewMo16645b != null) {
            viewMo16645b.setAlpha(this.f16029e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m16637a(ValueAnimator valueAnimator) {
        this.f16029e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f16025a.mo16644a().setAlpha(this.f16029e);
        View viewMo16645b = this.f16025a.mo16645b();
        if (viewMo16645b != null) {
            viewMo16645b.setAlpha(this.f16029e);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16640a() {
        m16641a(true);
        this.f16026b.setFloatValues(this.f16029e, 0.0f);
        this.f16026b.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16642b() {
        m16641a(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16641a(boolean z) {
        if (this.f16026b.isRunning()) {
            this.f16027c.f16033b = !z;
            this.f16026b.cancel();
        }
        if (this.f16028d.isRunning()) {
            this.f16028d.cancel();
        }
    }

    /* compiled from: ScreenModeChangeAnimation.java */
    /* renamed from: com.oplus.camera.screen.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends AnimatorListenerAdapter {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f16033b = true;

        public PlatformImplementations.kt_3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f16033b) {
                ScreenModeChangeAnimation.this.f16025a.mo16646c();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ScreenModeChangeAnimation.this.f16025a.mo16646c();
            ScreenModeChangeAnimation.this.f16028d.start();
        }
    }
}
