package com.airbnb.lottie.p091f;

import android.view.Choreographer;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.LottieComposition;

/* compiled from: LottieValueAnimator.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    /* renamed from: OplusGLSurfaceView_13 */
    private LottieComposition f5878i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f5871b = 1.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f5872c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private long f5873d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f5874e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f5875f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f5876g = -2.14748365E9f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f5877h = 2.14748365E9f;

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean f5870a = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m6112d());
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m6112d() {
        LottieComposition c1136d = this.f5878i;
        if (c1136d == null) {
            return 0.0f;
        }
        return (this.f5874e - c1136d.m5853f()) / (this.f5878i.m5854g() - this.f5878i.m5853f());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fM6121m;
        float fM6122n;
        float fM6121m2;
        if (this.f5878i == null) {
            return 0.0f;
        }
        if (m6103r()) {
            fM6121m = m6122n() - this.f5874e;
            fM6122n = m6122n();
            fM6121m2 = m6121m();
        } else {
            fM6121m = this.f5874e - m6121m();
            fM6122n = m6122n();
            fM6121m2 = m6121m();
        }
        return fM6121m / (fM6122n - fM6121m2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition c1136d = this.f5878i;
        if (c1136d == null) {
            return 0L;
        }
        return (long) c1136d.m5852e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m6113e() {
        return this.f5874e;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f5870a;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long OplusGLSurfaceView_15) {
        m6123o();
        if (this.f5878i == null || !isRunning()) {
            return;
        }
        L_2.m5637a("LottieValueAnimator#doFrame");
        float fM6102q = (this.f5873d != 0 ? OplusGLSurfaceView_15 - r1 : 0L) / m6102q();
        float COUIBaseListPopupWindow_12 = this.f5874e;
        if (m6103r()) {
            fM6102q = -fM6102q;
        }
        this.f5874e = COUIBaseListPopupWindow_12 + fM6102q;
        boolean z = !MiscUtils_2.m6138c(this.f5874e, m6121m(), m6122n());
        this.f5874e = MiscUtils_2.m6136b(this.f5874e, m6121m(), m6122n());
        this.f5873d = OplusGLSurfaceView_15;
        m6089c();
        if (z) {
            if (getRepeatCount() != -1 && this.f5875f >= getRepeatCount()) {
                this.f5874e = this.f5871b < 0.0f ? m6121m() : m6122n();
                m6124p();
                m6088b(m6103r());
            } else {
                m6085a();
                this.f5875f++;
                if (getRepeatMode() == 2) {
                    this.f5872c = !this.f5872c;
                    m6115g();
                } else {
                    this.f5874e = m6103r() ? m6122n() : m6121m();
                }
                this.f5873d = OplusGLSurfaceView_15;
            }
        }
        m6104s();
        L_2.m5638b("LottieValueAnimator#doFrame");
    }

    /* renamed from: q */
    private float m6102q() {
        LottieComposition c1136d = this.f5878i;
        if (c1136d == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / c1136d.m5855h()) / Math.abs(this.f5871b);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m6114f() {
        this.f5878i = null;
        this.f5876g = -2.14748365E9f;
        this.f5877h = 2.14748365E9f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6108a(LottieComposition c1136d) {
        boolean z = this.f5878i == null;
        this.f5878i = c1136d;
        if (z) {
            m6106a((int) Math.max(this.f5876g, c1136d.m5853f()), (int) Math.min(this.f5877h, c1136d.m5854g()));
        } else {
            m6106a((int) c1136d.m5853f(), (int) c1136d.m5854g());
        }
        float COUIBaseListPopupWindow_12 = this.f5874e;
        this.f5874e = 0.0f;
        m6105a((int) COUIBaseListPopupWindow_12);
        m6089c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6105a(float COUIBaseListPopupWindow_12) {
        if (this.f5874e == COUIBaseListPopupWindow_12) {
            return;
        }
        this.f5874e = MiscUtils_2.m6136b(COUIBaseListPopupWindow_12, m6121m(), m6122n());
        this.f5873d = 0L;
        m6089c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6107a(int OplusGLSurfaceView_13) {
        m6106a(OplusGLSurfaceView_13, (int) this.f5877h);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6109b(float COUIBaseListPopupWindow_12) {
        m6106a(this.f5876g, COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6106a(float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(COUIBaseListPopupWindow_12), Float.valueOf(f2)));
        }
        LottieComposition c1136d = this.f5878i;
        float fM5853f = c1136d == null ? -3.4028235E38f : c1136d.m5853f();
        LottieComposition c1136d2 = this.f5878i;
        float fM5854g = c1136d2 == null ? Float.MAX_VALUE : c1136d2.m5854g();
        this.f5876g = MiscUtils_2.m6136b(COUIBaseListPopupWindow_12, fM5853f, fM5854g);
        this.f5877h = MiscUtils_2.m6136b(f2, fM5853f, fM5854g);
        m6105a((int) MiscUtils_2.m6136b(this.f5874e, COUIBaseListPopupWindow_12, f2));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m6115g() {
        m6110c(-m6116h());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6110c(float COUIBaseListPopupWindow_12) {
        this.f5871b = COUIBaseListPopupWindow_12;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float m6116h() {
        return this.f5871b;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int OplusGLSurfaceView_13) {
        super.setRepeatMode(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 2 || !this.f5872c) {
            return;
        }
        this.f5872c = false;
        m6115g();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m6117i() {
        this.f5870a = true;
        m6086a(m6103r());
        m6105a((int) (m6103r() ? m6122n() : m6121m()));
        this.f5873d = 0L;
        this.f5875f = 0;
        m6123o();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m6118j() {
        m6124p();
        m6088b(m6103r());
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m6119k() {
        m6124p();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m6120l() {
        this.f5870a = true;
        m6123o();
        this.f5873d = 0L;
        if (m6103r() && m6113e() == m6121m()) {
            this.f5874e = m6122n();
        } else {
            if (m6103r() || m6113e() != m6122n()) {
                return;
            }
            this.f5874e = m6121m();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        m6087b();
        m6124p();
    }

    /* renamed from: r */
    private boolean m6103r() {
        return m6116h() < 0.0f;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public float m6121m() {
        LottieComposition c1136d = this.f5878i;
        if (c1136d == null) {
            return 0.0f;
        }
        float COUIBaseListPopupWindow_12 = this.f5876g;
        return COUIBaseListPopupWindow_12 == -2.14748365E9f ? c1136d.m5853f() : COUIBaseListPopupWindow_12;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public float m6122n() {
        LottieComposition c1136d = this.f5878i;
        if (c1136d == null) {
            return 0.0f;
        }
        float COUIBaseListPopupWindow_12 = this.f5877h;
        return COUIBaseListPopupWindow_12 == 2.14748365E9f ? c1136d.m5854g() : COUIBaseListPopupWindow_12;
    }

    /* renamed from: o */
    protected void m6123o() {
        if (isRunning()) {
            m6111c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* renamed from: p */
    protected void m6124p() {
        m6111c(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m6111c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f5870a = false;
        }
    }

    /* renamed from: s */
    private void m6104s() {
        if (this.f5878i == null) {
            return;
        }
        float COUIBaseListPopupWindow_12 = this.f5874e;
        if (COUIBaseListPopupWindow_12 < this.f5876g || COUIBaseListPopupWindow_12 > this.f5877h) {
            throw new IllegalStateException(String.format("Frame must be [%COUIBaseListPopupWindow_12,%COUIBaseListPopupWindow_12]. It is %COUIBaseListPopupWindow_12", Float.valueOf(this.f5876g), Float.valueOf(this.f5877h), Float.valueOf(this.f5874e)));
        }
    }
}
