package com.airbnb.lottie.g_renamed;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final T_renamed f2266a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public T_renamed f2267b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final android.view.animation.Interpolator f2268c;
    public final android.view.animation.Interpolator d_renamed;
    public final android.view.animation.Interpolator e_renamed;
    public final float f_renamed;
    public java.lang.Float g_renamed;
    public android.graphics.PointF h_renamed;
    public android.graphics.PointF i_renamed;
    private final com.airbnb.lottie.d_renamed j_renamed;
    private float k_renamed;
    private float l_renamed;
    private int m_renamed;
    private int n_renamed;
    private float o_renamed;
    private float p_renamed;

    public a_renamed(com.airbnb.lottie.d_renamed dVar, T_renamed t_renamed, T_renamed t2, android.view.animation.Interpolator interpolator, float f_renamed, java.lang.Float f2) {
        this.k_renamed = -3987645.8f;
        this.l_renamed = -3987645.8f;
        this.m_renamed = 784923401;
        this.n_renamed = 784923401;
        this.o_renamed = Float.MIN_VALUE;
        this.p_renamed = Float.MIN_VALUE;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = dVar;
        this.f2266a = t_renamed;
        this.f2267b = t2;
        this.f2268c = interpolator;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = f_renamed;
        this.g_renamed = f2;
    }

    public a_renamed(com.airbnb.lottie.d_renamed dVar, T_renamed t_renamed, T_renamed t2, android.view.animation.Interpolator interpolator, android.view.animation.Interpolator interpolator2, float f_renamed, java.lang.Float f2) {
        this.k_renamed = -3987645.8f;
        this.l_renamed = -3987645.8f;
        this.m_renamed = 784923401;
        this.n_renamed = 784923401;
        this.o_renamed = Float.MIN_VALUE;
        this.p_renamed = Float.MIN_VALUE;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = dVar;
        this.f2266a = t_renamed;
        this.f2267b = t2;
        this.f2268c = null;
        this.d_renamed = interpolator;
        this.e_renamed = interpolator2;
        this.f_renamed = f_renamed;
        this.g_renamed = f2;
    }

    protected a_renamed(com.airbnb.lottie.d_renamed dVar, T_renamed t_renamed, T_renamed t2, android.view.animation.Interpolator interpolator, android.view.animation.Interpolator interpolator2, android.view.animation.Interpolator interpolator3, float f_renamed, java.lang.Float f2) {
        this.k_renamed = -3987645.8f;
        this.l_renamed = -3987645.8f;
        this.m_renamed = 784923401;
        this.n_renamed = 784923401;
        this.o_renamed = Float.MIN_VALUE;
        this.p_renamed = Float.MIN_VALUE;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = dVar;
        this.f2266a = t_renamed;
        this.f2267b = t2;
        this.f2268c = interpolator;
        this.d_renamed = interpolator2;
        this.e_renamed = interpolator3;
        this.f_renamed = f_renamed;
        this.g_renamed = f2;
    }

    public a_renamed(T_renamed t_renamed) {
        this.k_renamed = -3987645.8f;
        this.l_renamed = -3987645.8f;
        this.m_renamed = 784923401;
        this.n_renamed = 784923401;
        this.o_renamed = Float.MIN_VALUE;
        this.p_renamed = Float.MIN_VALUE;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.f2266a = t_renamed;
        this.f2267b = t_renamed;
        this.f2268c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = Float.MIN_VALUE;
        this.g_renamed = java.lang.Float.valueOf(Float.MAX_VALUE);
    }

    public float c_renamed() {
        com.airbnb.lottie.d_renamed dVar = this.j_renamed;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.o_renamed == Float.MIN_VALUE) {
            this.o_renamed = (this.f_renamed - dVar.f_renamed()) / this.j_renamed.m_renamed();
        }
        return this.o_renamed;
    }

    public float d_renamed() {
        if (this.j_renamed == null) {
            return 1.0f;
        }
        if (this.p_renamed == Float.MIN_VALUE) {
            if (this.g_renamed == null) {
                this.p_renamed = 1.0f;
            } else {
                this.p_renamed = c_renamed() + ((this.g_renamed.floatValue() - this.f_renamed) / this.j_renamed.m_renamed());
            }
        }
        return this.p_renamed;
    }

    public boolean e_renamed() {
        return this.f2268c == null && this.d_renamed == null && this.e_renamed == null;
    }

    public boolean a_renamed(float f_renamed) {
        return f_renamed >= c_renamed() && f_renamed < d_renamed();
    }

    public float f_renamed() {
        if (this.k_renamed == -3987645.8f) {
            this.k_renamed = ((java.lang.Float) this.f2266a).floatValue();
        }
        return this.k_renamed;
    }

    public float g_renamed() {
        if (this.l_renamed == -3987645.8f) {
            this.l_renamed = ((java.lang.Float) this.f2267b).floatValue();
        }
        return this.l_renamed;
    }

    public int h_renamed() {
        if (this.m_renamed == 784923401) {
            this.m_renamed = ((java.lang.Integer) this.f2266a).intValue();
        }
        return this.m_renamed;
    }

    public int i_renamed() {
        if (this.n_renamed == 784923401) {
            this.n_renamed = ((java.lang.Integer) this.f2267b).intValue();
        }
        return this.n_renamed;
    }

    public java.lang.String toString() {
        return "Keyframe{startValue=" + this.f2266a + ", endValue=" + this.f2267b + ", startFrame=" + this.f_renamed + ", endFrame=" + this.g_renamed + ", interpolator=" + this.f2268c + '}';
    }
}
