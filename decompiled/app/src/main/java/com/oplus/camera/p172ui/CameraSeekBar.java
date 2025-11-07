package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.util.Util;

/* compiled from: CameraSeekBar.java */
/* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public abstract class CameraSeekBar extends View {

    /* renamed from: A */
    protected float f17482A;

    /* renamed from: B */
    protected float f17483B;

    /* renamed from: C */
    protected float f17484C;

    /* renamed from: D */
    protected float f17485D;

    /* renamed from: E */
    protected float f17486E;

    /* renamed from: F */
    protected volatile float f17487F;

    /* renamed from: G */
    protected float f17488G;

    /* renamed from: H */
    protected float f17489H;

    /* renamed from: I */
    protected float f17490I;

    /* renamed from: J */
    protected float f17491J;

    /* renamed from: K */
    protected float f17492K;

    /* renamed from: L */
    protected float f17493L;

    /* renamed from: M */
    protected int f17494M;

    /* renamed from: N */
    protected float f17495N;

    /* renamed from: O */
    protected float f17496O;

    /* renamed from: P */
    protected float f17497P;

    /* renamed from: Q */
    protected float f17498Q;

    /* renamed from: R */
    protected int f17499R;

    /* renamed from: S */
    protected volatile int f17500S;

    /* renamed from: T */
    protected boolean f17501T;

    /* renamed from: U */
    protected boolean f17502U;

    /* renamed from: V */
    protected boolean f17503V;

    /* renamed from: W */
    protected boolean f17504W;

    /* renamed from: PlatformImplementations.kt_3 */
    protected ValueAnimator f17505a;

    /* renamed from: aa */
    protected Interpolator f17506aa;

    /* renamed from: ab */
    protected Interpolator f17507ab;

    /* renamed from: ac */
    protected float f17508ac;

    /* renamed from: ad */
    protected float f17509ad;

    /* renamed from: ae */
    protected float f17510ae;

    /* renamed from: af */
    protected float f17511af;

    /* renamed from: ag */
    protected float f17512ag;

    /* renamed from: ah */
    protected float f17513ah;

    /* renamed from: ai */
    protected long f17514ai;

    /* renamed from: aj */
    protected Paint f17515aj;

    /* renamed from: ak */
    protected Context f17516ak;

    /* renamed from: al */
    protected PlatformImplementations.kt_3 f17517al;

    /* renamed from: am */
    public boolean f17518am;

    /* renamed from: an */
    protected Handler f17519an;

    /* renamed from: ao */
    private final PathInterpolator f17520ao;

    /* renamed from: ap */
    private final PathInterpolator f17521ap;

    /* renamed from: aq */
    private AnimatorSet f17522aq;

    /* renamed from: ar */
    private AnimatorSet f17523ar;

    /* renamed from: as */
    private int f17524as;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected ValueAnimator f17525b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected ValueAnimator f17526c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected ValueAnimator f17527d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected ValueAnimator f17528e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected ValueAnimator f17529f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected ValueAnimator f17530g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected ValueAnimator f17531h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected ValueAnimator f17532i;

    /* renamed from: OplusGLSurfaceView_15 */
    protected ValueAnimator f17533j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected ValueAnimator f17534k;

    /* renamed from: OplusGLSurfaceView_14 */
    protected ValueAnimator f17535l;

    /* renamed from: OplusGLSurfaceView_6 */
    protected ValueAnimator f17536m;

    /* renamed from: OplusGLSurfaceView_11 */
    protected ValueAnimator f17537n;

    /* renamed from: o */
    protected ValueAnimator f17538o;

    /* renamed from: p */
    protected ValueAnimator f17539p;

    /* renamed from: q */
    protected ValueAnimator f17540q;

    /* renamed from: r */
    protected AnimatorSet f17541r;

    /* renamed from: s */
    protected AnimatorSet f17542s;

    /* renamed from: t */
    protected AnimatorSet f17543t;

    /* renamed from: u */
    protected Paint f17544u;

    /* renamed from: v */
    protected Paint f17545v;

    /* renamed from: w */
    protected Paint f17546w;

    /* renamed from: x */
    protected Paint f17547x;

    /* renamed from: y */
    protected Paint f17548y;

    /* renamed from: z */
    protected float f17549z;

    /* compiled from: CameraSeekBar.java */
    /* renamed from: com.oplus.camera.ui.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11547a(float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11548a(float COUIBaseListPopupWindow_12, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo11549a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11550b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11551b(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo11552c();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo11553c(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo11554d();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo11555d(float COUIBaseListPopupWindow_12);

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo11556e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo11557f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo11558g();

        /* renamed from: COUIBaseListPopupWindow_10 */
        void mo11559h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo18512a(Canvas canvas) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo18516b(Canvas canvas) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo18520c(Canvas canvas) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo18523d(Canvas canvas) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo18525e(Canvas canvas) {
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void m18531h(Canvas canvas) {
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected void m18533i(Canvas canvas) {
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected void mo18535j(Canvas canvas) {
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected void mo18536k() {
    }

    /* renamed from: o */
    protected abstract void mo18540o();

    /* renamed from: p */
    public void mo18541p() {
    }

    /* renamed from: q */
    public void mo18542q() {
    }

    /* renamed from: t */
    protected void mo18545t() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m18510a() {
        m18522d();
        this.f17505a.start();
        this.f17525b.start();
        this.f17526c.start();
        this.f17528e.start();
        this.f17529f.start();
        this.f17530g.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m18513a(boolean z) {
        m18519c();
        if (z) {
            this.f17532i.setFloatValues(0.0f, 1.0f);
        } else {
            this.f17532i.setFloatValues(0.0f, 0.0f);
        }
        this.f17531h.start();
        this.f17532i.start();
        this.f17533j.start();
        this.f17534k.start();
        this.f17535l.start();
        this.f17536m.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean m18517b() {
        return this.f17531h.isRunning() || this.f17532i.isRunning() || this.f17533j.isRunning() || this.f17534k.isRunning() || this.f17535l.isRunning() || this.f17536m.isRunning();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m18519c() {
        this.f17505a.cancel();
        this.f17525b.cancel();
        this.f17526c.cancel();
        this.f17528e.cancel();
        this.f17529f.cancel();
        this.f17530g.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void m18522d() {
        this.f17531h.cancel();
        this.f17532i.cancel();
        this.f17533j.cancel();
        this.f17534k.cancel();
        this.f17535l.cancel();
        this.f17536m.cancel();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void m18524e() {
        this.f17531h.end();
        this.f17532i.end();
        this.f17533j.end();
        this.f17534k.end();
        this.f17535l.end();
        this.f17536m.end();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo18526f() {
        this.f17549z = 1.0f;
        this.f17482A = 0.0f;
        this.f17483B = 1.0f;
        this.f17484C = 1.0f;
        this.f17485D = 1.0f;
        this.f17486E = 1.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void m18528g() {
        this.f17549z = 0.0f;
        this.f17482A = 1.0f;
        this.f17483B = 0.0f;
        this.f17484C = 0.0f;
        this.f17485D = 0.0f;
        this.f17486E = 0.0f;
        mo18536k();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void m18530h() {
        this.f17505a = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17505a.setDuration(500L);
        this.f17505a.setInterpolator(getExpandInterpolator());
        this.f17505a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17549z = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.invalidate();
            }
        });
        this.f17525b = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f17525b.setDuration(250L);
        this.f17525b.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.f17525b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.23
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17482A = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17526c = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17526c.setDuration(400L);
        this.f17526c.setInterpolator(getExpandInterpolator());
        this.f17526c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.29
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17483B = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17528e = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17528e.setDuration(500L);
        this.f17528e.setInterpolator(getExpandControlPanelInterpolator());
        this.f17528e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.30
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17484C = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17529f = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17529f.setDuration(500L);
        this.f17529f.setInterpolator(getExpandInterpolator());
        this.f17529f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.31
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17485D = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17530g = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17530g.setDuration(500L);
        this.f17530g.setInterpolator(getExpandInterpolator());
        this.f17530g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.32
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17486E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected void m18532i() {
        this.f17531h = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f17531h.setDuration(500L);
        this.f17531h.setInterpolator(getExpandInterpolator());
        this.f17531h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.33
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17549z = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.invalidate();
            }
        });
        this.f17531h.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.34
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraSeekBar.this.invalidate();
                CameraSeekBar.this.m18528g();
                CameraSeekBar.this.setAlpha(1.0f);
                CameraSeekBar.this.setStatus(0);
                if (CameraSeekBar.this.f17501T) {
                    CameraSeekBar.this.setVisibility(8);
                }
                CameraSeekBar.this.mo18540o();
                CameraSeekBar abstractC3132b = CameraSeekBar.this;
                abstractC3132b.f17501T = false;
                abstractC3132b.f17502U = false;
                if (abstractC3132b.f17517al != null) {
                    CameraSeekBar.this.f17517al.mo11554d();
                }
            }
        });
        this.f17533j = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f17533j.setDuration(400L);
        this.f17533j.setStartDelay(150L);
        this.f17533j.setInterpolator(getExpandInterpolator());
        this.f17533j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17483B = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17532i = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17532i.setDuration(300L);
        this.f17532i.setStartDelay(150L);
        this.f17532i.setInterpolator(getExpandPointAlphaInterpolator());
        this.f17532i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17482A = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17532i.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CameraSeekBar.this.mo18536k();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraSeekBar.this.mo18536k();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CameraSeekBar.this.mo18536k();
            }
        });
        this.f17534k = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f17534k.setDuration(250L);
        this.f17534k.setInterpolator(getExpandControlPanelInterpolator());
        this.f17534k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17484C = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (CameraSeekBar.this.f17517al != null) {
                    CameraSeekBar.this.f17517al.mo11553c(CameraSeekBar.this.f17484C);
                }
            }
        });
        this.f17535l = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f17535l.setDuration(500L);
        this.f17535l.setInterpolator(getExpandInterpolator());
        this.f17535l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17485D = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f17536m = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f17536m.setDuration(250L);
        this.f17536m.setInterpolator(getExpandPointAlphaInterpolator());
        this.f17536m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17486E = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
    }

    /* renamed from: u */
    private void m18509u() {
        this.f17537n = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17537n.setDuration(450L);
        this.f17537n.setInterpolator(getExpandInterpolator());
        this.f17537n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17487F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        this.f17537n.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CameraSeekBar.this.f17515aj.setAlpha(255);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraSeekBar.this.setStatus(9);
                CameraSeekBar abstractC3132b = CameraSeekBar.this;
                abstractC3132b.f17487F = 1.0f;
                abstractC3132b.f17544u.setAlpha(255);
            }
        });
        this.f17539p = ValueAnimator.ofInt(0, 255);
        this.f17539p.setDuration(200L);
        this.f17539p.setInterpolator(getExpandControlPanelInterpolator());
        this.f17539p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17494M = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        this.f17539p.setStartDelay(150L);
        this.f17538o = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f17538o.setDuration(450L);
        this.f17538o.setInterpolator(getExpandInterpolator());
        this.f17538o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17487F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        this.f17538o.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraSeekBar.this.setStatus(0);
                CameraSeekBar abstractC3132b = CameraSeekBar.this;
                abstractC3132b.f17487F = 0.0f;
                abstractC3132b.f17495N = -1.0f;
                abstractC3132b.f17544u.setAlpha(255);
            }
        });
        this.f17540q = ValueAnimator.ofInt(255, 0);
        this.f17540q.setDuration(200L);
        this.f17540q.setInterpolator(getExpandControlPanelInterpolator());
        this.f17540q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17494M = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
    }

    public CameraSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f17505a = null;
        this.f17525b = null;
        this.f17526c = null;
        this.f17527d = null;
        this.f17528e = null;
        this.f17529f = null;
        this.f17530g = null;
        this.f17531h = null;
        this.f17532i = null;
        this.f17533j = null;
        this.f17534k = null;
        this.f17535l = null;
        this.f17536m = null;
        this.f17537n = null;
        this.f17538o = null;
        this.f17539p = null;
        this.f17540q = null;
        this.f17541r = null;
        this.f17542s = null;
        this.f17543t = null;
        this.f17544u = null;
        this.f17545v = null;
        this.f17546w = null;
        this.f17547x = null;
        this.f17548y = null;
        this.f17549z = 0.0f;
        this.f17482A = 0.0f;
        this.f17483B = 0.0f;
        this.f17484C = 0.0f;
        this.f17485D = 0.0f;
        this.f17486E = 0.0f;
        this.f17487F = 0.0f;
        this.f17488G = 0.0f;
        this.f17489H = 0.0f;
        this.f17490I = 0.0f;
        this.f17491J = 1.0f;
        this.f17492K = 0.0f;
        this.f17493L = 1.0f;
        this.f17494M = 0;
        this.f17495N = -1.0f;
        this.f17496O = -1.0f;
        this.f17497P = -1.0f;
        this.f17498Q = 0.0f;
        this.f17499R = 0;
        this.f17500S = -1;
        this.f17501T = false;
        this.f17502U = false;
        this.f17503V = false;
        this.f17504W = false;
        this.f17506aa = null;
        this.f17507ab = null;
        this.f17508ac = 0.0f;
        this.f17509ad = 0.0f;
        this.f17510ae = 0.0f;
        this.f17511af = 0.0f;
        this.f17512ag = 0.0f;
        this.f17513ah = Util.m24187O() / 2.0f;
        this.f17514ai = 3000L;
        this.f17515aj = null;
        this.f17516ak = null;
        this.f17517al = null;
        this.f17520ao = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f17521ap = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f17518am = false;
        this.f17522aq = null;
        this.f17523ar = null;
        this.f17524as = 0;
        this.f17519an = new Handler() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                CameraSeekBar.this.mo18518b(false);
            }
        };
        this.f17516ak = context;
        this.f17499R = Util.getScreenWidth();
        this.f17511af = (this.f17499R * 1.0f) / 2.0f;
        this.f17524as = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_enter_button_animation_y);
        this.f17506aa = getCollapseInterpolator();
        this.f17507ab = getExpandInterpolator();
        m18532i();
        m18530h();
        m18509u();
        m18534j();
        setStatus(0);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected void m18534j() {
        this.f17541r = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(getExpandInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17488G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(500L);
        valueAnimatorOfFloat2.setInterpolator(this.f17520ao);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.16
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17489H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.setInterpolator(this.f17520ao);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17490I = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        this.f17541r.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2).with(valueAnimatorOfFloat3);
        this.f17541r.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraSeekBar.this.setStatus(0);
                CameraSeekBar abstractC3132b = CameraSeekBar.this;
                abstractC3132b.f17488G = 1.0f;
                abstractC3132b.f17489H = 1.0f;
                abstractC3132b.f17490I = 1.0f;
            }
        });
        this.f17542s = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat4.setDuration(500L);
        valueAnimatorOfFloat4.setInterpolator(getExpandInterpolator());
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17488G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat5.setDuration(250L);
        valueAnimatorOfFloat5.setInterpolator(this.f17520ao);
        valueAnimatorOfFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.20
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17489H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        this.f17542s.play(valueAnimatorOfFloat4).with(valueAnimatorOfFloat5);
        this.f17542s.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.21
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraSeekBar.this.setStatus(0);
                CameraSeekBar abstractC3132b = CameraSeekBar.this;
                abstractC3132b.f17488G = 1.0f;
                abstractC3132b.f17489H = 0.0f;
            }
        });
        this.f17543t = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat6 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat6.setDuration(250L);
        valueAnimatorOfFloat6.setInterpolator(ProfessionalAnimConstant.f15694a);
        valueAnimatorOfFloat6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.22
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17492K = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat7 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat7.setDuration(500L);
        valueAnimatorOfFloat7.setInterpolator(ProfessionalAnimConstant.f15694a);
        valueAnimatorOfFloat7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.24
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17493L = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat8 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat8.setDuration(500L);
        valueAnimatorOfFloat8.setInterpolator(ProfessionalAnimConstant.f15695b);
        valueAnimatorOfFloat8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.25
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CameraSeekBar.this.f17491J = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CameraSeekBar.this.postInvalidate();
            }
        });
        this.f17543t.play(valueAnimatorOfFloat7).with(valueAnimatorOfFloat8).with(valueAnimatorOfFloat6);
        this.f17543t.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.26
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CameraSeekBar.this.setStatus(0);
                CameraSeekBar abstractC3132b = CameraSeekBar.this;
                abstractC3132b.f17492K = 0.0f;
                abstractC3132b.f17491J = 1.0f;
                abstractC3132b.f17493L = 1.0f;
                abstractC3132b.postInvalidate();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
            }
        });
    }

    public void setOnSeekBarChangeListener(PlatformImplementations.kt_3 aVar) {
        this.f17517al = aVar;
    }

    public void setStatus(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraSeekBar", "setStatus, status: " + OplusGLSurfaceView_13);
        this.f17500S = OplusGLSurfaceView_13;
    }

    public int getStatus() {
        return this.f17500S;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m18537l() {
        m18524e();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m18538m() {
        m18522d();
        m18519c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int OplusGLSurfaceView_13 = this.f17500S;
        if (OplusGLSurfaceView_13 != 15) {
            switch (OplusGLSurfaceView_13) {
                case 0:
                    mo18516b(canvas);
                    break;
                case 1:
                    mo18527f(canvas);
                    break;
                case 2:
                    mo18535j(canvas);
                    break;
                case 3:
                    mo18529g(canvas);
                    break;
                case 4:
                    m18531h(canvas);
                    break;
                case 5:
                    m18533i(canvas);
                    break;
                case 6:
                    m18528g();
                    mo18529g(canvas);
                    break;
                case 7:
                    mo18543r();
                    mo18529g(canvas);
                    this.f17502U = false;
                    break;
                case 8:
                    mo18520c(canvas);
                    break;
                case 9:
                    mo18523d(canvas);
                    break;
                case 10:
                    mo18525e(canvas);
                    break;
            }
        }
        mo18512a(canvas);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo18527f(Canvas canvas) {
        if (1.0f > this.f17549z) {
            this.f17517al.mo11551b(this.f17484C);
            return;
        }
        this.f17517al.mo11551b(1.0f);
        mo18535j(canvas);
        mo18526f();
        setStatus(2);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo18529g(Canvas canvas) {
        PlatformImplementations.kt_3 aVar = this.f17517al;
        if (aVar != null && !this.f17502U) {
            aVar.mo11552c();
            this.f17502U = true;
        }
        if (0.0f >= this.f17549z || !this.f17501T) {
            return;
        }
        setAlpha(this.f17484C);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m18539n() {
        if (1 == this.f17500S || 2 == this.f17500S) {
            m18519c();
            setStatus(7);
            invalidate();
        }
        if (3 == this.f17500S) {
            this.f17508ac = 0.0f;
            invalidate();
        }
    }

    public long getCollapseDelay() {
        return this.f17514ai;
    }

    public void setCollapseDelay(long OplusGLSurfaceView_15) {
        this.f17514ai = OplusGLSurfaceView_15;
    }

    /* renamed from: r */
    protected void mo18543r() {
        m18528g();
        setStatus(0);
        setAlpha(1.0f);
        this.f17502U = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18511a(AnimatorListenerAdapter animatorListenerAdapter, boolean z, boolean z2) {
        if (3 != this.f17500S) {
            if (1 == this.f17500S || 2 == this.f17500S) {
                this.f17519an.removeMessages(1);
                this.f17501T = true;
                setStatus(3);
                m18513a(false);
                return;
            }
            m18508b(animatorListenerAdapter, z, z2);
            return;
        }
        this.f17501T = true;
    }

    /* renamed from: s */
    public boolean m18544s() {
        return this.f17503V || 8 == this.f17500S || 9 == this.f17500S || 10 == this.f17500S;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18515a(boolean z, boolean z2, boolean z3) {
        if (6 == this.f17500S || (3 == this.f17500S && !this.f17501T)) {
            CameraLog.m12959b("CameraSeekBar", "performShow not prepared, mStatus: " + this.f17500S);
            return;
        }
        if (3 == this.f17500S) {
            m18522d();
        }
        if (1 == this.f17500S || 2 == this.f17500S || 3 == this.f17500S) {
            setAlpha(1.0f);
            setVisibility(0);
            this.f17501T = false;
            if (z) {
                this.f17519an.removeMessages(1);
                setStatus(3);
                m18513a(true);
                return;
            }
            return;
        }
        m18514a(z2, z3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18514a(boolean z, boolean z2) {
        CameraLog.m12954a("CameraSeekBar", "showZoomMenuButton, needAnim: " + z + ", needTranslateAni: " + z2);
        AnimatorSet animatorSet = this.f17522aq;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f17522aq.cancel();
        } else {
            if (isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f17523ar;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.f17520ao);
            objectAnimatorOfFloat.setDuration(z2 ? 400L : 250L);
            this.f17523ar = new AnimatorSet();
            AnimatorSet.Builder builderPlay = this.f17523ar.play(objectAnimatorOfFloat);
            if (z2) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "translationY", -this.f17524as, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.f17521ap);
                objectAnimatorOfFloat2.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat2);
                this.f17523ar.setStartDelay(150L);
            } else {
                setTranslationY(0.0f);
            }
            this.f17523ar.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.27
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CameraSeekBar.this.setAlpha(0.0f);
                    CameraSeekBar.this.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CameraSeekBar.this.setAlpha(1.0f);
                    CameraSeekBar.this.setTranslationY(0.0f);
                    CameraSeekBar.this.setVisibility(0);
                }
            });
            this.f17523ar.start();
            return;
        }
        setAlpha(1.0f);
        setTranslationY(0.0f);
        setVisibility(0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18508b(AnimatorListenerAdapter animatorListenerAdapter, boolean z, boolean z2) {
        CameraLog.m12954a("CameraSeekBar", "hideZoomMenuButton, needAnim: " + z + ", needTranslateAni: " + z2);
        AnimatorSet animatorSet = this.f17523ar;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f17523ar.cancel();
        } else {
            if (!isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f17522aq;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f17520ao);
            objectAnimatorOfFloat.setDuration(250L);
            this.f17522aq = new AnimatorSet();
            AnimatorSet.Builder builderPlay = this.f17522aq.play(objectAnimatorOfFloat);
            if (z2) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "translationY", 0.0f, -this.f17524as);
                objectAnimatorOfFloat2.setInterpolator(this.f17521ap);
                objectAnimatorOfFloat2.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat2);
            } else {
                setTranslationY(0.0f);
            }
            if (animatorListenerAdapter != null) {
                this.f17522aq.addListener(animatorListenerAdapter);
            }
            this.f17522aq.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.IntrinsicsJvm.kt_4.28
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CameraSeekBar.this.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CameraSeekBar.this.setAlpha(1.0f);
                    CameraSeekBar.this.setTranslationY(0.0f);
                    CameraSeekBar.this.setVisibility(8);
                }
            });
            this.f17522aq.start();
            return;
        }
        setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean mo18518b(boolean z) {
        if (3 != this.f17500S && this.f17500S != 0 && 9 != this.f17500S && 8 != this.f17500S && 10 != this.f17500S && 15 != this.f17500S && 6 != this.f17500S) {
            if (8 == getVisibility() || 4 == getVisibility()) {
                setStatus(0);
            } else {
                this.f17501T = false;
                setStatus(z ? 6 : 3);
                m18513a(true);
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo18521c(boolean z) {
        PlatformImplementations.kt_3 aVar;
        if (1 == this.f17500S || 8 == this.f17500S || 10 == this.f17500S || 9 == this.f17500S || getVisibility() != 0) {
            return;
        }
        if ((getParent() == null || ((View) getParent()).getVisibility() == 0) && (aVar = this.f17517al) != null && aVar.mo11549a()) {
            this.f17501T = false;
            this.f17504W = false;
            setStatus(1);
            if (!z) {
                this.f17518am = false;
            } else {
                this.f17518am = true;
            }
            mo18545t();
            this.f17517al.mo11550b();
            m18510a();
        }
    }

    public void setRate(float COUIBaseListPopupWindow_12) {
        float fM24201a = Util.m24201a(COUIBaseListPopupWindow_12, -0.042f, 1.042f);
        this.f17510ae = this.f17509ad;
        this.f17509ad = fM24201a;
    }

    protected Interpolator getCollapseInterpolator() {
        return AnimationUtils.loadInterpolator(this.f17516ak, R.anim.zoom_interpolator_out);
    }

    protected Interpolator getExpandInterpolator() {
        return AnimationUtils.loadInterpolator(this.f17516ak, R.anim.zoom_interpolator_in);
    }

    protected Interpolator getExpandControlPanelInterpolator() {
        return AnimationUtils.loadInterpolator(this.f17516ak, R.anim.zoom_seek_bar_interpolator_in);
    }

    protected Interpolator getExpandPointAlphaInterpolator() {
        return AnimationUtils.loadInterpolator(this.f17516ak, R.anim.zoom_interpolator_point_alpha);
    }

    @Override // android.view.View
    public int getLayoutDirection() {
        return getContext().getResources().getConfiguration().getLayoutDirection();
    }
}
