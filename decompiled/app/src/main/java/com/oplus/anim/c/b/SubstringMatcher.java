package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: Repeater.java */
/* loaded from: classes2.dex */
public class k_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3589a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f3590b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f3591c;
    private final com.oplus.anim.c_renamed.a_renamed.l_renamed d_renamed;
    private final boolean e_renamed;

    public k_renamed(java.lang.String str, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar2, com.oplus.anim.c_renamed.a_renamed.l_renamed lVar, boolean z_renamed) {
        this.f3589a = str;
        this.f3590b = bVar;
        this.f3591c = bVar2;
        this.d_renamed = lVar;
        this.e_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f3589a;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed b_renamed() {
        return this.f3590b;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed c_renamed() {
        return this.f3591c;
    }

    public com.oplus.anim.c_renamed.a_renamed.l_renamed d_renamed() {
        return this.d_renamed;
    }

    public boolean e_renamed() {
        return this.e_renamed;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("Repeater to RepeaterContent, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.p_renamed(bVar, aVar, this);
    }
}
