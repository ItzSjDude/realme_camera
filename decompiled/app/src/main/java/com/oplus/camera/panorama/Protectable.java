package com.oplus.camera.panorama;

/* compiled from: DirectionMode.java */
/* loaded from: classes2.dex */
public abstract class c_renamed {
    protected float h_renamed;
    protected float i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.graphics.Matrix f4938a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected float f4939b = 10.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected float f4940c = 260.0f;
    protected float d_renamed = -40.0f;
    protected float e_renamed = 220.0f;
    protected float[] f_renamed = null;
    protected float[] g_renamed = null;
    protected float j_renamed = 0.0f;
    protected float k_renamed = 0.0f;
    protected boolean l_renamed = false;
    protected int m_renamed = 0;

    public abstract java.lang.String a_renamed(android.content.Context context);

    public abstract void a_renamed(float f_renamed);

    protected abstract float[] a_renamed(int i_renamed, int i2);

    public abstract float b_renamed(float f_renamed);

    public abstract float c_renamed(float f_renamed);

    public c_renamed(android.content.Context context) {
        this.h_renamed = 0.0f;
        this.i_renamed = 0.0f;
        this.i_renamed = context.getResources().getDimension(com.oplus.camera.R_renamed.dimen.front_panorama_guide_camera_width_narrow);
        this.h_renamed = context.getResources().getDimension(com.oplus.camera.R_renamed.dimen.front_panorama_guide_camera_height_narrow);
    }

    public int b_renamed() {
        return this.m_renamed;
    }

    public void b_renamed(int i_renamed, int i2) {
        this.f4938a = new android.graphics.Matrix();
        float f_renamed = i_renamed;
        float f2 = i2;
        this.f_renamed = new float[]{0.0f, 0.0f, f_renamed, 0.0f, f_renamed, f2, 0.0f, f2};
    }

    public android.graphics.Matrix a_renamed(int i_renamed, int i2, int i3, int i4) {
        if (this.f4938a == null) {
            b_renamed(i_renamed, i2);
        }
        this.g_renamed = a_renamed(i_renamed, i2);
        this.f4938a.reset();
        this.f4938a.setPolyToPoly(this.f_renamed, 0, this.g_renamed, 0, 4);
        this.f4938a.postTranslate((i3 - i_renamed) / 2, (i4 - i2) / 2);
        return this.f4938a;
    }

    protected void c_renamed() {
        if (this.g_renamed == null) {
            this.g_renamed = new float[8];
        }
    }

    public float d_renamed() {
        return this.d_renamed;
    }

    public float e_renamed() {
        return this.f4939b;
    }

    public void a_renamed() {
        this.f4939b = 0.0f;
        this.k_renamed = 0.0f;
        this.j_renamed = 0.0f;
        this.l_renamed = false;
    }
}
