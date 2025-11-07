package com.oplus.anim.f_renamed;

/* compiled from: EffectiveValueAnimator.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.anim.f_renamed.a_renamed implements android.view.Choreographer.FrameCallback {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected boolean f3670a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f3671b = 1.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f3672c = false;
    private long d_renamed = 0;
    private float e_renamed = 0.0f;
    private int f_renamed = 0;
    private float g_renamed = -2.14748365E9f;
    private float h_renamed = 2.14748365E9f;
    private com.oplus.anim.a_renamed i_renamed;

    @Override // android.animation.ValueAnimator
    public java.lang.Object getAnimatedValue() {
        return java.lang.Float.valueOf(d_renamed());
    }

    public float d_renamed() {
        com.oplus.anim.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return 0.0f;
        }
        return (this.e_renamed - aVar.f_renamed()) / (this.i_renamed.g_renamed() - this.i_renamed.f_renamed());
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
        com.oplus.anim.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return 0L;
        }
        return (long) aVar.e_renamed();
    }

    public float e_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(int i_renamed) {
        float f_renamed = i_renamed;
        if (this.e_renamed == f_renamed) {
            return;
        }
        this.e_renamed = com.oplus.anim.f_renamed.e_renamed.b_renamed(f_renamed, m_renamed(), n_renamed());
        this.d_renamed = java.lang.System.nanoTime();
        c_renamed();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f3670a;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j_renamed) {
        o_renamed();
        if (this.i_renamed == null || !isRunning()) {
            return;
        }
        long jNanoTime = java.lang.System.nanoTime();
        float fQ_renamed = (jNanoTime - this.d_renamed) / q_renamed();
        float f_renamed = this.e_renamed;
        if (r_renamed()) {
            fQ_renamed = -fQ_renamed;
        }
        this.e_renamed = f_renamed + fQ_renamed;
        boolean z_renamed = !com.oplus.anim.f_renamed.e_renamed.c_renamed(this.e_renamed, m_renamed(), n_renamed());
        this.e_renamed = com.oplus.anim.f_renamed.e_renamed.b_renamed(this.e_renamed, m_renamed(), n_renamed());
        this.d_renamed = jNanoTime;
        c_renamed();
        if (z_renamed) {
            if (getRepeatCount() != -1 && this.f_renamed >= getRepeatCount()) {
                this.e_renamed = n_renamed();
                p_renamed();
                b_renamed(r_renamed());
            } else {
                a_renamed();
                this.f_renamed++;
                if (getRepeatMode() == 2) {
                    this.f3672c = !this.f3672c;
                    g_renamed();
                } else {
                    this.e_renamed = r_renamed() ? n_renamed() : m_renamed();
                }
                this.d_renamed = jNanoTime;
            }
        }
        s_renamed();
    }

    private float q_renamed() {
        com.oplus.anim.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / aVar.h_renamed()) / java.lang.Math.abs(this.f3671b);
    }

    public void f_renamed() {
        this.i_renamed = null;
        this.g_renamed = -2.14748365E9f;
        this.h_renamed = 2.14748365E9f;
    }

    public void a_renamed(com.oplus.anim.a_renamed aVar) {
        boolean z_renamed = this.i_renamed == null;
        this.i_renamed = aVar;
        if (z_renamed) {
            a_renamed((int) java.lang.Math.max(this.g_renamed, aVar.f_renamed()), (int) java.lang.Math.min(this.h_renamed, aVar.g_renamed()));
        } else {
            a_renamed((int) aVar.f_renamed(), (int) aVar.g_renamed());
        }
        float f_renamed = this.e_renamed;
        this.e_renamed = 0.0f;
        a_renamed((int) f_renamed);
    }

    public void a_renamed(float f_renamed, float f2) {
        if (f_renamed > f2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("minFrame (%s_renamed) must be_renamed <= maxFrame (%s_renamed)", java.lang.Float.valueOf(f_renamed), java.lang.Float.valueOf(f2)));
        }
        com.oplus.anim.a_renamed aVar = this.i_renamed;
        float f3 = aVar == null ? -3.4028235E38f : aVar.f_renamed();
        com.oplus.anim.a_renamed aVar2 = this.i_renamed;
        float fG_renamed = aVar2 == null ? Float.MAX_VALUE : aVar2.g_renamed();
        this.g_renamed = com.oplus.anim.f_renamed.e_renamed.b_renamed(f_renamed, f3, fG_renamed);
        this.h_renamed = com.oplus.anim.f_renamed.e_renamed.b_renamed(f2, f3, fG_renamed);
        a_renamed((int) com.oplus.anim.f_renamed.e_renamed.b_renamed(this.e_renamed, f_renamed, f2));
    }

    public void g_renamed() {
        a_renamed(-h_renamed());
    }

    public float h_renamed() {
        return this.f3671b;
    }

    public void a_renamed(float f_renamed) {
        this.f3671b = f_renamed;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i_renamed) {
        super.setRepeatMode(i_renamed);
        if (i_renamed == 2 || !this.f3672c) {
            return;
        }
        this.f3672c = false;
        g_renamed();
    }

    public void i_renamed() {
        this.f3670a = true;
        a_renamed(r_renamed());
        a_renamed((int) (r_renamed() ? n_renamed() : m_renamed()));
        this.d_renamed = java.lang.System.nanoTime();
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
        this.f3670a = true;
        o_renamed();
        this.d_renamed = java.lang.System.nanoTime();
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
        com.oplus.anim.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return 0.0f;
        }
        float f_renamed = this.g_renamed;
        return f_renamed == -2.14748365E9f ? aVar.f_renamed() : f_renamed;
    }

    public void b_renamed(int i_renamed) {
        a_renamed(i_renamed, (int) this.h_renamed);
    }

    public float n_renamed() {
        com.oplus.anim.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return 0.0f;
        }
        float f_renamed = this.h_renamed;
        return f_renamed == 2.14748365E9f ? aVar.g_renamed() : f_renamed;
    }

    public void b_renamed(float f_renamed) {
        a_renamed(this.g_renamed, f_renamed);
    }

    protected void o_renamed() {
        if (isRunning()) {
            c_renamed(false);
            if (android.view.Choreographer.getInstance() == null) {
                android.util.Log.d_renamed("EffectiveAnimation", "Gets the choreographer is_renamed null");
            } else {
                android.view.Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    protected void p_renamed() {
        c_renamed(true);
    }

    protected void c_renamed(boolean z_renamed) {
        if (android.view.Choreographer.getInstance() == null) {
            android.util.Log.d_renamed("EffectiveAnimation", "Gets the choreographer is_renamed null");
        } else {
            android.view.Choreographer.getInstance().removeFrameCallback(this);
        }
        if (z_renamed) {
            this.f3670a = false;
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
