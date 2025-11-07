package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: RectangleShape.java */
/* loaded from: classes2.dex */
public class j_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3586a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> f3587b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.f_renamed f3588c;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed d_renamed;
    private final boolean e_renamed;

    public j_renamed(java.lang.String str, com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar, com.oplus.anim.c_renamed.a_renamed.f_renamed fVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar, boolean z_renamed) {
        this.f3586a = str;
        this.f3587b = mVar;
        this.f3588c = fVar;
        this.d_renamed = bVar;
        this.e_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f3586a;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed b_renamed() {
        return this.d_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.f_renamed c_renamed() {
        return this.f3588c;
    }

    public com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> d_renamed() {
        return this.f3587b;
    }

    public boolean e_renamed() {
        return this.e_renamed;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("RectangleShape to RectangleContent, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.o_renamed(bVar, aVar, this);
    }

    public java.lang.String toString() {
        return "RectangleShape{position=" + this.f3587b + ", size=" + this.f3588c + '}';
    }
}
