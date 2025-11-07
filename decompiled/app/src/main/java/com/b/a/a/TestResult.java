package com.b_renamed.a_renamed.a_renamed;

/* compiled from: DollyZoomAnimator.java */
/* loaded from: classes.dex */
public class h_renamed extends com.b_renamed.a_renamed.a_renamed.f_renamed {
    final float e_renamed;
    final float f_renamed;
    final float g_renamed;
    final float h_renamed;
    final float i_renamed;
    float[] j_renamed;
    float[] k_renamed;
    float[] l_renamed;
    float[] m_renamed;
    float[] n_renamed;
    float[] o_renamed;
    float[] p_renamed;
    float[] q_renamed;
    private float r_renamed;
    private float s_renamed;

    public h_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed) {
        super(cVar, z_renamed);
        this.r_renamed = -0.0094f;
        this.s_renamed = -6.8E-4f;
        this.e_renamed = -0.0f;
        this.f_renamed = -0.0f;
        this.g_renamed = -30.0f;
        this.h_renamed = -0.1f;
        this.i_renamed = 1.0f;
        this.j_renamed = new float[]{0.0f, 0.0f};
        this.k_renamed = new float[]{0.0f, 0.0f};
        this.l_renamed = new float[]{0.0f, 0.0f};
        this.m_renamed = new float[]{0.0f, 0.0f};
        this.n_renamed = new float[]{0.0f, 0.0f};
        this.o_renamed = new float[]{0.0f, 0.0f};
        this.p_renamed = new float[]{0.0f, 0.0f};
        this.q_renamed = new float[]{0.0f, 0.0f};
    }

    public h_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed, com.b_renamed.a_renamed.a_renamed.a_renamed aVar) {
        super(cVar, z_renamed, aVar);
        this.r_renamed = -0.0094f;
        this.s_renamed = -6.8E-4f;
        this.e_renamed = -0.0f;
        this.f_renamed = -0.0f;
        this.g_renamed = -30.0f;
        this.h_renamed = -0.1f;
        this.i_renamed = 1.0f;
        this.j_renamed = new float[]{0.0f, 0.0f};
        this.k_renamed = new float[]{0.0f, 0.0f};
        this.l_renamed = new float[]{0.0f, 0.0f};
        this.m_renamed = new float[]{0.0f, 0.0f};
        this.n_renamed = new float[]{0.0f, 0.0f};
        this.o_renamed = new float[]{0.0f, 0.0f};
        this.p_renamed = new float[]{0.0f, 0.0f};
        this.q_renamed = new float[]{0.0f, 0.0f};
    }

    @Override // com.b_renamed.a_renamed.a_renamed.f_renamed, com.b_renamed.a_renamed.a_renamed.j_renamed
    public void b_renamed() {
        super.b_renamed();
        b_renamed(this.j_renamed, this.f2330a.f7970a, -0.0f);
        b_renamed(this.k_renamed, this.f2330a.f7971b, -0.0f);
        b_renamed(this.l_renamed, this.f2330a.f7972c, -30.0f);
        b_renamed(this.m_renamed, this.s_renamed, -0.1f);
        b_renamed(this.n_renamed, this.f2330a.m_renamed, this.f2330a.m_renamed);
        b_renamed(this.o_renamed, this.f2330a.l_renamed, this.f2330a.l_renamed);
        b_renamed(this.p_renamed, this.f2330a.j_renamed, this.f2330a.j_renamed);
        b_renamed(this.q_renamed, this.f2330a.k_renamed, this.f2330a.k_renamed);
        com.b_renamed.a_renamed.b_renamed.d_renamed("dolly zoom", "dolly start:" + this.n_renamed + "," + this.l_renamed + "," + this.p_renamed);
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void a_renamed(float f_renamed) {
        this.f2330a.f7972c = a_renamed(this.l_renamed, this.d_renamed == com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_DOLLYZOOM_FORWARD ? f_renamed : 1.0f - f_renamed, 3.0f);
        this.f2330a.f7970a = a_renamed(this.j_renamed, f_renamed);
        this.f2330a.f7971b = -a_renamed(this.j_renamed, f_renamed);
        this.f2330a.e_renamed = this.f2330a.f7970a;
        this.f2330a.m_renamed = (this.n_renamed[0] * (this.l_renamed[0] + 1.0f)) / (this.f2330a.f7972c + 1.0f);
        this.f2330a.l_renamed = (this.o_renamed[0] * (this.l_renamed[0] + 1.0f)) / (this.f2330a.f7972c + 1.0f);
        this.f2330a.j_renamed = (this.p_renamed[0] * (this.l_renamed[0] + 1.0f)) / (this.f2330a.f7972c + 1.0f);
        this.f2330a.k_renamed = (this.q_renamed[0] * (this.l_renamed[0] + 1.0f)) / (this.f2330a.f7972c + 1.0f);
        this.f2330a.a_renamed(true);
    }

    private static void b_renamed(float[] fArr, float f_renamed, float f2) {
        fArr[0] = f_renamed;
        fArr[1] = f_renamed + f2;
    }
}
