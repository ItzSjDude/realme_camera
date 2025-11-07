package com.b_renamed.a_renamed.a_renamed;

/* compiled from: CameraAnimator.java */
/* loaded from: classes.dex */
public abstract class f_renamed implements com.b_renamed.a_renamed.a_renamed.j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed f2330a;

    /* renamed from: b_renamed, reason: collision with root package name */
    com.b_renamed.a_renamed.a_renamed.f_renamed.a_renamed f2331b;

    /* renamed from: c_renamed, reason: collision with root package name */
    boolean f2332c;
    com.b_renamed.a_renamed.a_renamed.b_renamed d_renamed;

    public f_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed) {
        this.f2331b = null;
        this.f2332c = true;
        this.d_renamed = com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_DEFAULT;
        this.f2330a = cVar;
        this.f2332c = z_renamed;
    }

    public f_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar, boolean z_renamed, com.b_renamed.a_renamed.a_renamed.a_renamed aVar) {
        this.f2331b = null;
        this.f2332c = true;
        this.d_renamed = com.b_renamed.a_renamed.a_renamed.b_renamed.ANIM_DIRECTION_DEFAULT;
        this.f2330a = cVar;
        if (aVar.f2317b != null) {
            cVar.f7970a = aVar.f2317b.f2318a;
            cVar.f7971b = aVar.f2317b.f2319b;
            cVar.f7972c = aVar.f2317b.f2320c;
            cVar.a_renamed(true);
        }
        this.f2332c = z_renamed;
        this.d_renamed = aVar.f2316a;
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void b_renamed() {
        this.f2331b = new com.b_renamed.a_renamed.a_renamed.f_renamed.a_renamed(this.f2330a);
    }

    @Override // com.b_renamed.a_renamed.a_renamed.j_renamed
    public void d_renamed() {
        if (this.f2331b != null) {
            this.f2331b = null;
            this.f2330a.a_renamed(true);
        }
    }

    /* compiled from: CameraAnimator.java */
    class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        float f2333a;

        /* renamed from: b_renamed, reason: collision with root package name */
        float f2334b;

        /* renamed from: c_renamed, reason: collision with root package name */
        float f2335c;
        float[] d_renamed;
        float e_renamed;
        float f_renamed;
        float g_renamed;
        float h_renamed;

        a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVar) {
            this.f2333a = cVar.f7970a;
            this.f2334b = cVar.f7971b;
            this.f2335c = cVar.f7972c;
            this.d_renamed = java.util.Arrays.copyOf(cVar.a_renamed(), cVar.a_renamed().length);
            this.e_renamed = cVar.j_renamed;
            this.f_renamed = cVar.m_renamed;
            this.g_renamed = cVar.k_renamed;
            this.h_renamed = cVar.l_renamed;
        }
    }
}
