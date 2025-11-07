package com.oplus.anim.g_renamed;

/* compiled from: Keyframe.java */
/* loaded from: classes2.dex */
public class c_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final T_renamed f3704a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final android.view.animation.Interpolator f3705b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final float f3706c;
    public T_renamed d_renamed;
    public java.lang.Float e_renamed;
    public android.graphics.PointF f_renamed;
    public android.graphics.PointF g_renamed;
    private final com.oplus.anim.a_renamed h_renamed;
    private float i_renamed;
    private float j_renamed;
    private int k_renamed;
    private int l_renamed;
    private float m_renamed;
    private float n_renamed;

    public c_renamed(com.oplus.anim.a_renamed aVar, T_renamed t_renamed, T_renamed t2, android.view.animation.Interpolator interpolator, float f_renamed, java.lang.Float f2) {
        this.f_renamed = null;
        this.g_renamed = null;
        this.i_renamed = -3987645.8f;
        this.j_renamed = -3987645.8f;
        this.k_renamed = 784923401;
        this.l_renamed = 784923401;
        this.m_renamed = Float.MIN_VALUE;
        this.n_renamed = Float.MIN_VALUE;
        this.h_renamed = aVar;
        this.f3704a = t_renamed;
        this.d_renamed = t2;
        this.f3705b = interpolator;
        this.f3706c = f_renamed;
        this.e_renamed = f2;
    }

    public c_renamed(T_renamed t_renamed) {
        this.f_renamed = null;
        this.g_renamed = null;
        this.i_renamed = -3987645.8f;
        this.j_renamed = -3987645.8f;
        this.k_renamed = 784923401;
        this.l_renamed = 784923401;
        this.m_renamed = Float.MIN_VALUE;
        this.n_renamed = Float.MIN_VALUE;
        this.h_renamed = null;
        this.f3704a = t_renamed;
        this.d_renamed = t_renamed;
        this.f3705b = null;
        this.f3706c = Float.MIN_VALUE;
        this.e_renamed = java.lang.Float.valueOf(Float.MAX_VALUE);
    }

    public float c_renamed() {
        com.oplus.anim.a_renamed aVar = this.h_renamed;
        if (aVar == null) {
            return 0.0f;
        }
        if (this.m_renamed == Float.MIN_VALUE) {
            this.m_renamed = (this.f3706c - aVar.f_renamed()) / this.h_renamed.m_renamed();
        }
        return this.m_renamed;
    }

    public float d_renamed() {
        if (this.h_renamed == null) {
            return 1.0f;
        }
        if (this.n_renamed == Float.MIN_VALUE) {
            if (this.e_renamed == null) {
                this.n_renamed = 1.0f;
            } else {
                this.n_renamed = c_renamed() + ((this.e_renamed.floatValue() - this.f3706c) / this.h_renamed.m_renamed());
            }
        }
        return this.n_renamed;
    }

    public boolean e_renamed() {
        return this.f3705b == null;
    }

    public boolean a_renamed(float f_renamed) {
        return f_renamed >= c_renamed() && f_renamed < d_renamed();
    }

    public float f_renamed() {
        if (this.i_renamed == -3987645.8f) {
            this.i_renamed = ((java.lang.Float) this.f3704a).floatValue();
        }
        return this.i_renamed;
    }

    public float g_renamed() {
        if (this.j_renamed == -3987645.8f) {
            this.j_renamed = ((java.lang.Float) this.d_renamed).floatValue();
        }
        return this.j_renamed;
    }

    public int h_renamed() {
        if (this.k_renamed == 784923401) {
            this.k_renamed = ((java.lang.Integer) this.f3704a).intValue();
        }
        return this.k_renamed;
    }

    public int i_renamed() {
        if (this.l_renamed == 784923401) {
            this.l_renamed = ((java.lang.Integer) this.d_renamed).intValue();
        }
        return this.l_renamed;
    }

    public java.lang.String toString() {
        return "Keyframe{startValue=" + this.f3704a + ", endValue=" + this.d_renamed + ", startFrame=" + this.f3706c + ", endFrame=" + this.e_renamed + ", interpolator=" + this.f3705b + '}';
    }
}
