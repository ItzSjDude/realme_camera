package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: TrimPathContent.java */
/* loaded from: classes2.dex */
public class s_renamed implements com.oplus.anim.a_renamed.a_renamed.c_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3495a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final boolean f3496b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2> f3497c = new java.util.ArrayList();
    private final com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed d_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> e_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> f_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> g_renamed;

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
    }

    public s_renamed(com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.q_renamed qVar) {
        this.f3495a = qVar.a_renamed();
        this.f3496b = qVar.f_renamed();
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

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        for (int i_renamed = 0; i_renamed < this.f3497c.size(); i_renamed++) {
            this.f3497c.get(i_renamed).a_renamed();
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3495a;
    }

    void a_renamed(com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 interfaceC0077a) {
        this.f3497c.add(interfaceC0077a);
    }

    com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed c_renamed() {
        return this.d_renamed;
    }

    public com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> d_renamed() {
        return this.e_renamed;
    }

    public com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> e_renamed() {
        return this.f_renamed;
    }

    public com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> f_renamed() {
        return this.g_renamed;
    }

    public boolean g_renamed() {
        return this.f3496b;
    }
}
