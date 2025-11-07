package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: CircleShape.java */
/* loaded from: classes2.dex */
public class a_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3566a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> f3567b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.f_renamed f3568c;
    private final boolean d_renamed;
    private final boolean e_renamed;

    public a_renamed(java.lang.String str, com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar, com.oplus.anim.c_renamed.a_renamed.f_renamed fVar, boolean z_renamed, boolean z2) {
        this.f3566a = str;
        this.f3567b = mVar;
        this.f3568c = fVar;
        this.d_renamed = z_renamed;
        this.e_renamed = z2;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("CircleShape::toContent layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.f_renamed(bVar, aVar, this);
    }

    public java.lang.String a_renamed() {
        return this.f3566a;
    }

    public com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> b_renamed() {
        return this.f3567b;
    }

    public com.oplus.anim.c_renamed.a_renamed.f_renamed c_renamed() {
        return this.f3568c;
    }

    public boolean d_renamed() {
        return this.d_renamed;
    }

    public boolean e_renamed() {
        return this.e_renamed;
    }
}
