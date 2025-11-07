package com.airbnb.lottie.f_renamed;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class e_renamed extends com.airbnb.lottie.f_renamed.a_renamed implements android.view.Choreographer.FrameCallback {
    private com.airbnb.lottie.d_renamed i_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f2255b = 1.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f2256c = false;
    private long d_renamed = 0;
    private float e_renamed = 0.0f;
    private int f_renamed = 0;
    private float g_renamed = -2.14748365E9f;
    private float h_renamed = 2.14748365E9f;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected boolean f2254a = false;

    @Override // android.animation.ValueAnimator
    public java.lang.Object getAnimatedValue() {
        return java.lang.Float.valueOf(d_renamed());
    }

    public float d_renamed() {
        com.airbnb.lottie.d_renamed dVar = this.i_renamed;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.e_renamed - dVar.f_renamed()) / (this.i_renamed.g_renamed() - this.i_renamed.f_renamed());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fM_renamed;
        float fN_renamed;
        float fM2;
        if (this.i_renamed == null) {
            return 0.0f;
        }
        if (r_renamed()) {
            fM_renamed = n_renamed() - this.e_renamed;
            fN_renamed = n_renamed();
            fM2 = m_renamed();
        } else {
            fM_renamed = this.e_renamed - m_renamed();
            fN_renamed = n_renamed();
            fM2 = m_renamed();
        }
        return fM_renamed / (fN_renamed - fM2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.d_renamed dVar = this.i_renamed;
        if (dVar == null) {
            return 0L;
        }
        return (long) dVar.e_renamed();
    }

    public float e_renamed() {
        return this.e_renamed;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f2254a;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j_renamed) {
        o_renamed();
        if (this.i_renamed == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.c_renamed.a_renamed("LottieValueAnimator#doFrame");
        float fQ_renamed = (this.d_renamed != 0 ? j_renamed - r1 : 0L) / q_renamed();
        float f_renamed = this.e_renamed;
        if (r_renamed()) {
            fQ_renamed = -fQ_renamed;
        }
        this.e_renamed = f_renamed + fQ_renamed;
        boolean z_renamed = !com.airbnb.lottie.f_renamed.g_renamed.c_renamed(this.e_renamed, m_renamed(), n_renamed());
        this.e_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(this.e_renamed, m_renamed(), n_renamed());
        this.d_renamed = j_renamed;
        c_renamed();
        if (z_renamed) {
            if (getRepeatCount() != -1 && this.f_renamed >= getRepeatCount()) {
                this.e_renamed = this.f2255b < 0.0f ? m_renamed() : n_renamed();
                p_renamed();
                b_renamed(r_renamed());
            } else {
                a_renamed();
                this.f_renamed++;
                if (getRepeatMode() == 2) {
                    this.f2256c = !this.f2256c;
                    g_renamed();
                } else {
                    this.e_renamed = r_renamed() ? n_renamed() : m_renamed();
                }
                this.d_renamed = j_renamed;
            }
        }
        s_renamed();
        com.airbnb.lottie.c_renamed.b_renamed("LottieValueAnimator#doFrame");
    }

    private float q_renamed() {
        com.airbnb.lottie.d_renamed dVar = this.i_renamed;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.h_renamed()) / java.lang.Math.abs(this.f2255b);
    }

    public void f_renamed() {
        this.i_renamed = null;
        this.g_renamed = -2.14748365E9f;
        this.h_renamed = 2.14748365E9f;
    }

    public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
        boolean z_renamed = this.i_renamed == null;
        this.i_renamed = dVar;
        if (z_renamed) {
            a_renamed((int) java.lang.Math.max(this.g_renamed, dVar.f_renamed()), (int) java.lang.Math.min(this.h_renamed, dVar.g_renamed()));
        } else {
            a_renamed((int) dVar.f_renamed(), (int) dVar.g_renamed());
        }
        float f_renamed = this.e_renamed;
        this.e_renamed = 0.0f;
        a_renamed((int) f_renamed);
        c_renamed();
    }

    public void a_renamed(float f_renamed) {
        if (this.e_renamed == f_renamed) {
            return;
        }
        this.e_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(f_renamed, m_renamed(), n_renamed());
        this.d_renamed = 0L;
        c_renamed();
    }

    public void a_renamed(int i_renamed) {
        a_renamed(i_renamed, (int) this.h_renamed);
    }

    public void b_renamed(float f_renamed) {
        a_renamed(this.g_renamed, f_renamed);
    }

    public void a_renamed(float f_renamed, float f2) {
        if (f_renamed > f2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("minFrame (%s_renamed) must be_renamed <= maxFrame (%s_renamed)", java.lang.Float.valueOf(f_renamed), java.lang.Float.valueOf(f2)));
        }
        com.airbnb.lottie.d_renamed dVar = this.i_renamed;
        float f3 = dVar == null ? -3.4028235E38f : dVar.f_renamed();
        com.airbnb.lottie.d_renamed dVar2 = this.i_renamed;
        float fG_renamed = dVar2 == null ? Float.MAX_VALUE : dVar2.g_renamed();
        this.g_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(f_renamed, f3, fG_renamed);
        this.h_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(f2, f3, fG_renamed);
        a_renamed((int) com.airbnb.lottie.f_renamed.g_renamed.b_renamed(this.e_renamed, f_renamed, f2));
    }

    public void g_renamed() {
        c_renamed(-h_renamed());
    }

    public void c_renamed(float f_renamed) {
        this.f2255b = f_renamed;
    }

    public float h_renamed() {
        return this.f2255b;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i_renamed) {
        super.setRepeatMode(i_renamed);
        if (i_renamed == 2 || !this.f2256c) {
            return;
        }
        this.f2256c = false;
        g_renamed();
    }

    public void i_renamed() {
        this.f2254a = true;
        a_renamed(r_renamed());
        a_renamed((int) (r_renamed() ? n_renamed() : m_renamed()));
        this.d_renamed = 0L;
        this.f_renamed = 0;
        o_renamed();
    }

    public void j_renamed() {
        p_renamed();
        b_renamed(r_renamed());
    }

    public void k_renamed() {
        p_renamed();
    }

    public void l_renamed() {
        this.f2254a = true;
        o_renamed();
        this.d_renamed = 0L;
        if (r_renamed() && e_renamed() == m_renamed()) {
            this.e_renamed = n_renamed();
        } else {
            if (r_renamed() || e_renamed() != n_renamed()) {
                return;
            }
            this.e_renamed = m_renamed();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        b_renamed();
        p_renamed();
    }

    private boolean r_renamed() {
        return h_renamed() < 0.0f;
    }

    public float m_renamed() {
        com.airbnb.lottie.d_renamed dVar = this.i_renamed;
        if (dVar == null) {
            return 0.0f;
        }
        float f_renamed = this.g_renamed;
        return f_renamed == -2.14748365E9f ? dVar.f_renamed() : f_renamed;
    }

    public float n_renamed() {
        com.airbnb.lottie.d_renamed dVar = this.i_renamed;
        if (dVar == null) {
            return 0.0f;
        }
        float f_renamed = this.h_renamed;
        return f_renamed == 2.14748365E9f ? dVar.g_renamed() : f_renamed;
    }

    protected void o_renamed() {
        if (isRunning()) {
            c_renamed(false);
            android.view.Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void p_renamed() {
        c_renamed(true);
    }

    protected void c_renamed(boolean z_renamed) {
        android.view.Choreographer.getInstance().removeFrameCallback(this);
        if (z_renamed) {
            this.f2254a = false;
        }
    }

    private void s_renamed() {
        if (this.i_renamed == null) {
            return;
        }
        float f_renamed = this.e_renamed;
        if (f_renamed < this.g_renamed || f_renamed > this.h_renamed) {
            throw new java.lang.IllegalStateException(java.lang.String.format("Frame must be_renamed [%f_renamed,%f_renamed]. It is_renamed %f_renamed", java.lang.Float.valueOf(this.g_renamed), java.lang.Float.valueOf(this.h_renamed), java.lang.Float.valueOf(this.e_renamed)));
        }
    }
}
