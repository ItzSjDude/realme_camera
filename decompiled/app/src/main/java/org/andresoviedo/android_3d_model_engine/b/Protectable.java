package org.andresoviedo.android_3d_model_engine.b_renamed;

/* compiled from: Camera.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public float f7970a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public float f7971b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public float f7972c;
    public float d_renamed;
    public float e_renamed;
    public float f_renamed;
    public float g_renamed;
    public float h_renamed;
    public float i_renamed;
    public float j_renamed;
    public float k_renamed;
    public float l_renamed;
    public float m_renamed;
    public int n_renamed;
    private final org.andresoviedo.android_3d_model_engine.b_renamed.b_renamed o_renamed;
    private final org.andresoviedo.android_3d_model_engine.b_renamed.b_renamed p_renamed;
    private float[] q_renamed;
    private long r_renamed;
    private java.lang.Object[] s_renamed;
    private boolean t_renamed;
    private float[] u_renamed;
    private float[] v_renamed;

    private void a_renamed(float f_renamed, float f2) {
    }

    private void b_renamed(float f_renamed) {
    }

    private void c_renamed(float f_renamed) {
    }

    public c_renamed() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
    }

    public c_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this(0.0f, 0.0f, -15.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.1f, 0.1f, 0.1f, -0.1f);
    }

    public c_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.o_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.b_renamed("scene", -0.5f, 0.5f, -0.5f, 0.5f, -0.5f, 0.5f);
        this.p_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.b_renamed("scene", -100.0f, 100.0f, -100.0f, 100.0f, -100.0f, 100.0f);
        this.q_renamed = new float[56];
        this.t_renamed = false;
        this.u_renamed = new float[16];
        this.v_renamed = null;
        this.f7970a = f_renamed;
        this.f7971b = f2;
        this.f7972c = f3;
        this.d_renamed = f4;
        this.e_renamed = f5;
        this.f_renamed = f6;
        this.g_renamed = f7;
        this.h_renamed = f8;
        this.i_renamed = f9;
        this.j_renamed = f10;
        this.k_renamed = f11;
        this.m_renamed = f12;
        this.l_renamed = f13;
        this.n_renamed = 0;
    }

    public float[] a_renamed() {
        return this.q_renamed;
    }

    public synchronized void b_renamed() {
        if (this.s_renamed != null && this.r_renamed != 0) {
            java.lang.String str = (java.lang.String) this.s_renamed[0];
            if (str.equals("translate")) {
                a_renamed((((java.lang.Float) this.s_renamed[1]).floatValue() * this.r_renamed) / 100.0f, (((java.lang.Float) this.s_renamed[2]).floatValue() * this.r_renamed) / 100.0f);
            } else if (str.equals(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
                c_renamed((((java.lang.Float) this.s_renamed[1]).floatValue() / 100.0f) * this.r_renamed);
            }
            this.r_renamed--;
            return;
        }
        this.s_renamed = null;
        this.r_renamed = 100L;
    }

    public synchronized void a_renamed(float f_renamed) {
        if (f_renamed == 0.0f) {
            return;
        }
        b_renamed(f_renamed);
        this.s_renamed = new java.lang.Object[]{com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_ZOOM, java.lang.Float.valueOf(f_renamed)};
    }

    public boolean c_renamed() {
        return this.t_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.t_renamed = z_renamed;
    }

    public java.lang.String toString() {
        return "Camera [xPos=" + this.f7970a + ", yPos=" + this.f7971b + ", zPos=" + this.f7972c + ", xView=" + this.d_renamed + ", yView=" + this.e_renamed + ", zView=" + this.f_renamed + ", xUp=" + this.g_renamed + ", yUp=" + this.h_renamed + ", zUp=" + this.i_renamed + "]";
    }
}
