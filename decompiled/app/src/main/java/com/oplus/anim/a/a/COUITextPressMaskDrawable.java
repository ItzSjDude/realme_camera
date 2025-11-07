package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: ShapeContent.java */
/* loaded from: classes2.dex */
public class q_renamed implements com.oplus.anim.a_renamed.a_renamed.m_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f3491b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f3492c;
    private final com.oplus.anim.b_renamed d_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.Path> e_renamed;
    private boolean f_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f3490a = new android.graphics.Path();
    private com.oplus.anim.a_renamed.a_renamed.b_renamed g_renamed = new com.oplus.anim.a_renamed.a_renamed.b_renamed();

    public q_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.o_renamed oVar) {
        this.f3491b = oVar.a_renamed();
        this.f3492c = oVar.c_renamed();
        this.d_renamed = bVar;
        this.e_renamed = oVar.b_renamed().a_renamed();
        aVar.a_renamed(this.e_renamed);
        this.e_renamed.a_renamed(this);
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        c_renamed();
    }

    private void c_renamed() {
        this.f_renamed = false;
        this.d_renamed.invalidateSelf();
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = list.get(i_renamed);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.s_renamed) {
                com.oplus.anim.a_renamed.a_renamed.s_renamed sVar = (com.oplus.anim.a_renamed.a_renamed.s_renamed) cVar;
                if (sVar.c_renamed() == com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed.SIMULTANEOUSLY) {
                    this.g_renamed.a_renamed(sVar);
                    sVar.a_renamed(this);
                }
            }
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        if (this.f_renamed) {
            return this.f3490a;
        }
        this.f3490a.reset();
        if (this.f3492c) {
            this.f_renamed = true;
            return this.f3490a;
        }
        this.f3490a.set(this.e_renamed.g_renamed());
        this.f3490a.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        this.g_renamed.a_renamed(this.f3490a);
        this.f_renamed = true;
        return this.f3490a;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3491b;
    }
}
