package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: ShapeFill.java */
/* loaded from: classes2.dex */
public class m_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final boolean f3595a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Path.FillType f3596b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f3597c;
    private final com.oplus.anim.c_renamed.a_renamed.a_renamed d_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.d_renamed e_renamed;
    private final boolean f_renamed;

    public m_renamed(java.lang.String str, boolean z_renamed, android.graphics.Path.FillType fillType, com.oplus.anim.c_renamed.a_renamed.a_renamed aVar, com.oplus.anim.c_renamed.a_renamed.d_renamed dVar, boolean z2) {
        this.f3597c = str;
        this.f3595a = z_renamed;
        this.f3596b = fillType;
        this.d_renamed = aVar;
        this.e_renamed = dVar;
        this.f_renamed = z2;
    }

    public java.lang.String a_renamed() {
        return this.f3597c;
    }

    public com.oplus.anim.c_renamed.a_renamed.a_renamed b_renamed() {
        return this.d_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.d_renamed c_renamed() {
        return this.e_renamed;
    }

    public android.graphics.Path.FillType d_renamed() {
        return this.f3596b;
    }

    public boolean e_renamed() {
        return this.f_renamed;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ShapeFill to FillContent, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.g_renamed(bVar, aVar, this);
    }

    public java.lang.String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f3595a + '}';
    }
}
