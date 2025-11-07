package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class q_renamed implements com.airbnb.lottie.a_renamed.a_renamed.m_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f2022b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f2023c;
    private final com.airbnb.lottie.f_renamed d_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, android.graphics.Path> e_renamed;
    private boolean f_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f2021a = new android.graphics.Path();
    private com.airbnb.lottie.a_renamed.a_renamed.b_renamed g_renamed = new com.airbnb.lottie.a_renamed.a_renamed.b_renamed();

    public q_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.o_renamed oVar) {
        this.f2022b = oVar.a_renamed();
        this.f2023c = oVar.c_renamed();
        this.d_renamed = fVar;
        this.e_renamed = oVar.b_renamed().a_renamed();
        aVar.a_renamed(this.e_renamed);
        this.e_renamed.a_renamed(this);
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        c_renamed();
    }

    private void c_renamed() {
        this.f_renamed = false;
        this.d_renamed.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = list.get(i_renamed);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.s_renamed) {
                com.airbnb.lottie.a_renamed.a_renamed.s_renamed sVar = (com.airbnb.lottie.a_renamed.a_renamed.s_renamed) cVar;
                if (sVar.c_renamed() == com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed.SIMULTANEOUSLY) {
                    this.g_renamed.a_renamed(sVar);
                    sVar.a_renamed(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        if (this.f_renamed) {
            return this.f2021a;
        }
        this.f2021a.reset();
        if (this.f2023c) {
            this.f_renamed = true;
            return this.f2021a;
        }
        this.f2021a.set(this.e_renamed.g_renamed());
        this.f2021a.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        this.g_renamed.a_renamed(this.f2021a);
        this.f_renamed = true;
        return this.f2021a;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f2022b;
    }
}
