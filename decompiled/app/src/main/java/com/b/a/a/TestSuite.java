package com.b_renamed.a_renamed.a_renamed;

/* compiled from: FixedGazeAnimator.java */
/* loaded from: classes.dex */
public class i_renamed extends com.b_renamed.a_renamed.a_renamed.f_renamed {
    float e_renamed;
    float f_renamed;
    final float g_renamed;
    final float h_renamed;
    float i_renamed;
    final float j_renamed;
    float[] k_renamed;
    float[] l_renamed;
    float[] m_renamed;
    float[] n_renamed;
    float[] o_renamed;
    float[] p_renamed;
    float[] q_renamed;
    float[] r_renamed;
    float[] s_renamed;
    private float t_renamed;
    private float u_renamed;

    public i_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed) {
        super(cVar, z_renamed);
        this.t_renamed = -0.0094f;
        this.u_renamed = -6.8E-4f;
        this.e_renamed = -3.0f;
        this.f_renamed = 0.5f;
        this.g_renamed = -3.5f;
        this.h_renamed = -0.0f;
        this.i_renamed = -0.1f;
        this.j_renamed = -5.0f;
        this.k_renamed = new float[]{0.0f, 0.0f};
        this.l_renamed = new float[]{0.0f, 0.0f};
        this.m_renamed = new float[]{0.0f, 0.0f};
        this.n_renamed = new float[]{0.0f, 0.0f};
        this.o_renamed = new float[]{0.0f, 0.0f};
        this.p_renamed = new float[]{0.0f, 0.0f};
        this.q_renamed = new float[]{0.0f, 0.0f};
        this.r_renamed = new float[]{0.0f, 0.0f};
        this.s_renamed = new float[]{0.0f, 0.0f};
    }

    public i_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed, com.b_renamed.a_renamed.a_renamed.a_renamed aVar) {
        super(cVar, z_renamed, aVar);
        this.t_renamed = -0.0094f;
        this.u_renamed = -6.8E-4f;
        this.e_renamed = -3.0f;
        this.f_renamed = 0.5f;
        this.g_renamed = -3.5f;
        this.h_renamed = -0.0f;
        this.i_renamed = -0.1f;
        this.j_renamed = -5.0f;
        this.k_renamed = new float[]{0.0f, 0.0f};
        this.l_renamed = new float[]{0.0f, 0.0f};
        this.m_renamed = new float[]{0.0f, 0.0f};
        this.n_renamed = new float[]{0.0f, 0.0f};
        this.o_renamed = new float[]{0.0f, 0.0f};
        this.p_renamed = new float[]{0.0f, 0.0f};
        this.q_renamed = new float[]{0.0f, 0.0f};
        this.r_renamed = new float[]{0.0f, 0.0f};
        this.s_renamed = new float[]{0.0f, 0.0f};
    }

    @Override // com.b_renamed.a_renamed.a_renamed.f_renamed, com.b_renamed.a_renamed.a_renamed.j_renamed
    public void b_renamed() {
        super.b_renamed();
        if (!this.f2332c) {
            this.e_renamed = -0.5f;
            this.f_renamed = -3.0f;
            this.i_renamed = 0.1f;
            if (this.d_renamed == com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT) {
                this.f2330a.f7971b = -this.f2330a.f7971b;
                this.f2330a.e_renamed = -this.f2330a.e_renamed;
                this.f_renamed = -this.f_renamed;
                this.i_renamed = -this.i_renamed;
                this.f2330a.a_renamed(true);
            }
        } else if (this.d_renamed == com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT) {
            this.f2330a.f7970a = -this.f2330a.f7970a;
            this.f2330a.d_renamed = -this.f2330a.d_renamed;
            this.e_renamed = -this.e_renamed;
            this.i_renamed = -this.i_renamed;
            this.f2330a.a_renamed(true);
        }
        b_renamed(this.k_renamed, this.f2330a.f7970a, this.e_renamed);
        b_renamed(this.l_renamed, this.f2330a.f7971b, this.f_renamed);
        b_renamed(this.m_renamed, this.f2330a.f7972c, -3.5f);
        if (this.f2332c) {
            b_renamed(this.o_renamed, this.f2330a.d_renamed, this.i_renamed);
        } else {
            b_renamed(this.o_renamed, this.f2330a.e_renamed, this.i_renamed);
        }
        b_renamed(this.n_renamed, this.u_renamed, -0.0f);
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void a_renamed(float f_renamed) {
        if (this.f2332c) {
            this.f2330a.f7970a = a_renamed(this.k_renamed, f_renamed, 0.3f);
            this.f2330a.f7971b = a_renamed(this.l_renamed, f_renamed, 0.3f);
            this.f2330a.d_renamed = a_renamed(this.o_renamed, f_renamed, 0.3f);
        } else {
            this.f2330a.f7970a = a_renamed(this.k_renamed, f_renamed, 0.3f);
            this.f2330a.f7971b = a_renamed(this.l_renamed, f_renamed, 0.3f);
            this.f2330a.e_renamed = a_renamed(this.o_renamed, f_renamed, 0.3f);
        }
        this.f2330a.f7972c = a_renamed(this.m_renamed, f_renamed, 0.2f);
        this.f2330a.a_renamed(true);
    }

    private static void b_renamed(float[] fArr, float f_renamed, float f2) {
        fArr[0] = f_renamed;
        fArr[1] = f_renamed + f2;
    }
}
