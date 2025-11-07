package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class s_renamed implements com.airbnb.lottie.a_renamed.a_renamed.c_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2025a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final boolean f2026b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4> f2027c = new java.util.ArrayList();
    private final com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed d_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> e_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> f_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> g_renamed;

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
    }

    public s_renamed(com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.q_renamed qVar) {
        this.f2025a = qVar.a_renamed();
        this.f2026b = qVar.f_renamed();
        this.d_renamed = qVar.b_renamed();
        this.e_renamed = qVar.d_renamed().a_renamed();
        this.f_renamed = qVar.c_renamed().a_renamed();
        this.g_renamed = qVar.e_renamed().a_renamed();
        aVar.a_renamed(this.e_renamed);
        aVar.a_renamed(this.f_renamed);
        aVar.a_renamed(this.g_renamed);
        this.e_renamed.a_renamed(this);
        this.f_renamed.a_renamed(this);
        this.g_renamed.a_renamed(this);
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        for (int i_renamed = 0; i_renamed < this.f2027c.size(); i_renamed++) {
            this.f2027c.get(i_renamed).a_renamed();
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f2025a;
    }

    void a_renamed(com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 interfaceC0051a) {
        this.f2027c.add(interfaceC0051a);
    }

    com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed c_renamed() {
        return this.d_renamed;
    }

    public com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> d_renamed() {
        return this.e_renamed;
    }

    public com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> e_renamed() {
        return this.f_renamed;
    }

    public com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> f_renamed() {
        return this.g_renamed;
    }

    public boolean g_renamed() {
        return this.f2026b;
    }
}
