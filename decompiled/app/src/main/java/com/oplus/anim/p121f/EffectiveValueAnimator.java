package com.oplus.anim.p121f;

import android.util.Log;
import android.view.Choreographer;
import com.oplus.anim.EffectiveAnimationComposition;

/* compiled from: EffectiveValueAnimator.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class EffectiveValueAnimator extends BaseAnimator implements Choreographer.FrameCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean f10373a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f10374b = 1.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f10375c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private long f10376d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f10377e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f10378f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f10379g = -2.14748365E9f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f10380h = 2.14748365E9f;

    /* renamed from: OplusGLSurfaceView_13 */
    private EffectiveAnimationComposition f10381i;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m9256d());
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m9256d() {
        EffectiveAnimationComposition c2272a = this.f10381i;
        if (c2272a == null) {
            return 0.0f;
        }
        return (this.f10377e - c2272a.m8795f()) / (this.f10381i.m8796g() - this.f10381i.m8795f());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fM9265m;
        float fM9266n;
        float fM9265m2;
        if (this.f10381i == null) {
            return 0.0f;
        }
        if (m9247r()) {
            fM9265m = m9266n() - this.f10377e;
            fM9266n = m9266n();
            fM9265m2 = m9265m();
        } else {
            fM9265m = this.f10377e - m9265m();
            fM9266n = m9266n();
            fM9265m2 = m9265m();
        }
        return fM9265m / (fM9266n - fM9265m2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        EffectiveAnimationComposition c2272a = this.f10381i;
        if (c2272a == null) {
            return 0L;
        }
        return (long) c2272a.m8794e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m9257e() {
        return this.f10377e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9251a(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        if (this.f10377e == COUIBaseListPopupWindow_12) {
            return;
        }
        this.f10377e = MiscUtils.m9282b(COUIBaseListPopupWindow_12, m9265m(), m9266n());
        this.f10376d = System.nanoTime();
        m9245c();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f10373a;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long OplusGLSurfaceView_15) {
        m9267o();
        if (this.f10381i == null || !isRunning()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        float fM9246q = (jNanoTime - this.f10376d) / m9246q();
        float COUIBaseListPopupWindow_12 = this.f10377e;
        if (m9247r()) {
            fM9246q = -fM9246q;
        }
        this.f10377e = COUIBaseListPopupWindow_12 + fM9246q;
        boolean z = !MiscUtils.m9284c(this.f10377e, m9265m(), m9266n());
        this.f10377e = MiscUtils.m9282b(this.f10377e, m9265m(), m9266n());
        this.f10376d = jNanoTime;
        m9245c();
        if (z) {
            if (getRepeatCount() != -1 && this.f10378f >= getRepeatCount()) {
                this.f10377e = m9266n();
                m9268p();
                m9244b(m9247r());
            } else {
                m9241a();
                this.f10378f++;
                if (getRepeatMode() == 2) {
                    this.f10375c = !this.f10375c;
                    m9259g();
                } else {
                    this.f10377e = m9247r() ? m9266n() : m9265m();
                }
                this.f10376d = jNanoTime;
            }
        }
        m9248s();
    }

    /* renamed from: q */
    private float m9246q() {
        EffectiveAnimationComposition c2272a = this.f10381i;
        if (c2272a == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / c2272a.m8797h()) / Math.abs(this.f10374b);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m9258f() {
        this.f10381i = null;
        this.f10379g = -2.14748365E9f;
        this.f10380h = 2.14748365E9f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9252a(EffectiveAnimationComposition c2272a) {
        boolean z = this.f10381i == null;
        this.f10381i = c2272a;
        if (z) {
            m9250a((int) Math.max(this.f10379g, c2272a.m8795f()), (int) Math.min(this.f10380h, c2272a.m8796g()));
        } else {
            m9250a((int) c2272a.m8795f(), (int) c2272a.m8796g());
        }
        float COUIBaseListPopupWindow_12 = this.f10377e;
        this.f10377e = 0.0f;
        m9251a((int) COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9250a(float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(COUIBaseListPopupWindow_12), Float.valueOf(f2)));
        }
        EffectiveAnimationComposition c2272a = this.f10381i;
        float fM8795f = c2272a == null ? -3.4028235E38f : c2272a.m8795f();
        EffectiveAnimationComposition c2272a2 = this.f10381i;
        float fM8796g = c2272a2 == null ? Float.MAX_VALUE : c2272a2.m8796g();
        this.f10379g = MiscUtils.m9282b(COUIBaseListPopupWindow_12, fM8795f, fM8796g);
        this.f10380h = MiscUtils.m9282b(f2, fM8795f, fM8796g);
        m9251a((int) MiscUtils.m9282b(this.f10377e, COUIBaseListPopupWindow_12, f2));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m9259g() {
        m9249a(-m9260h());
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float m9260h() {
        return this.f10374b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9249a(float COUIBaseListPopupWindow_12) {
        this.f10374b = COUIBaseListPopupWindow_12;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int OplusGLSurfaceView_13) {
        super.setRepeatMode(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 2 || !this.f10375c) {
            return;
        }
        this.f10375c = false;
        m9259g();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m9261i() {
        this.f10373a = true;
        m9242a(m9247r());
        m9251a((int) (m9247r() ? m9266n() : m9265m()));
        this.f10376d = System.nanoTime();
        this.f10378f = 0;
        m9267o();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m9262j() {
        m9268p();
        m9244b(m9247r());
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m9263k() {
        m9268p();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m9264l() {
        this.f10373a = true;
        m9267o();
        this.f10376d = System.nanoTime();
        if (m9247r() && m9257e() == m9265m()) {
            this.f10377e = m9266n();
        } else {
            if (m9247r() || m9257e() != m9266n()) {
                return;
            }
            this.f10377e = m9265m();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        m9243b();
        m9268p();
    }

    /* renamed from: r */
    private boolean m9247r() {
        return m9260h() < 0.0f;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public float m9265m() {
        EffectiveAnimationComposition c2272a = this.f10381i;
        if (c2272a == null) {
            return 0.0f;
        }
        float COUIBaseListPopupWindow_12 = this.f10379g;
        return COUIBaseListPopupWindow_12 == -2.14748365E9f ? c2272a.m8795f() : COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9254b(int OplusGLSurfaceView_13) {
        m9250a(OplusGLSurfaceView_13, (int) this.f10380h);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public float m9266n() {
        EffectiveAnimationComposition c2272a = this.f10381i;
        if (c2272a == null) {
            return 0.0f;
        }
        float COUIBaseListPopupWindow_12 = this.f10380h;
        return COUIBaseListPopupWindow_12 == 2.14748365E9f ? c2272a.m8796g() : COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9253b(float COUIBaseListPopupWindow_12) {
        m9250a(this.f10379g, COUIBaseListPopupWindow_12);
    }

    /* renamed from: o */
    protected void m9267o() {
        if (isRunning()) {
            m9255c(false);
            if (Choreographer.getInstance() == null) {
                Log.IntrinsicsJvm.kt_5("EffectiveAnimation", "Gets the choreographer is null");
            } else {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* renamed from: p */
    protected void m9268p() {
        m9255c(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m9255c(boolean z) {
        if (Choreographer.getInstance() == null) {
            Log.IntrinsicsJvm.kt_5("EffectiveAnimation", "Gets the choreographer is null");
        } else {
            Choreographer.getInstance().removeFrameCallback(this);
        }
        if (z) {
            this.f10373a = false;
        }
    }

    /* renamed from: s */
    private void m9248s() {
        if (this.f10381i == null) {
            return;
        }
        float COUIBaseListPopupWindow_12 = this.f10377e;
        if (COUIBaseListPopupWindow_12 < this.f10379g || COUIBaseListPopupWindow_12 > this.f10380h) {
            throw new IllegalStateException(String.format("Frame must be [%COUIBaseListPopupWindow_12,%COUIBaseListPopupWindow_12]. It is %COUIBaseListPopupWindow_12", Float.valueOf(this.f10379g), Float.valueOf(this.f10380h), Float.valueOf(this.f10377e)));
        }
    }
}
