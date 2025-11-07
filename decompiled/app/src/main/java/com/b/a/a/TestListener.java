package com.b_renamed.a_renamed.a_renamed;

/* compiled from: CircleAnimator.java */
/* loaded from: classes.dex */
public class g_renamed extends com.b_renamed.a_renamed.a_renamed.f_renamed {
    final float e_renamed;
    final float f_renamed;
    final float g_renamed;
    float h_renamed;
    boolean i_renamed;
    float[] j_renamed;
    float[] k_renamed;

    public g_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed) {
        super(cVar, z_renamed);
        this.e_renamed = 0.3f;
        this.f_renamed = 720.0f;
        this.g_renamed = 2.0f;
        this.h_renamed = 0.0f;
        this.i_renamed = false;
        this.j_renamed = new float[]{0.0f, 0.0f};
        this.k_renamed = new float[]{0.0f, 0.0f};
    }

    public g_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed, com.b_renamed.a_renamed.a_renamed.a_renamed aVar) {
        super(cVar, z_renamed, aVar);
        this.e_renamed = 0.3f;
        this.f_renamed = 720.0f;
        this.g_renamed = 2.0f;
        this.h_renamed = 0.0f;
        this.i_renamed = false;
        this.j_renamed = new float[]{0.0f, 0.0f};
        this.k_renamed = new float[]{0.0f, 0.0f};
    }

    @Override // com.b_renamed.a_renamed.a_renamed.f_renamed, com.b_renamed.a_renamed.a_renamed.j_renamed
    public void b_renamed() {
        super.b_renamed();
        b_renamed(this.j_renamed, 0.0f, 720.0f);
        b_renamed(this.k_renamed, this.f2330a.f7972c, 2.0f);
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void a_renamed(float f_renamed) {
        double radians = java.lang.Math.toRadians(a_renamed(this.j_renamed, f_renamed));
        this.f2330a.f7970a = ((float) java.lang.Math.cos(radians)) * 0.3f;
        this.f2330a.f7971b = ((float) java.lang.Math.sin(radians)) * 0.3f;
        this.f2330a.d_renamed = ((float) java.lang.Math.cos(radians)) * 0.3f;
        this.f2330a.e_renamed = ((float) java.lang.Math.sin(radians)) * 0.3f;
        if (f_renamed <= 0.5d) {
            this.f2330a.f7972c = a_renamed(this.k_renamed, f_renamed);
        } else {
            this.f2330a.f7972c = a_renamed(this.k_renamed, 1.0f - f_renamed);
        }
        this.f2330a.a_renamed(true);
    }

    private static void b_renamed(float[] fArr, float f_renamed, float f2) {
        fArr[0] = f_renamed;
        fArr[1] = f_renamed + f2;
    }
}
