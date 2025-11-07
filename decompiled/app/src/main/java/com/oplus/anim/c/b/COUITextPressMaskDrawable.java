package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: ShapeTrimPath.java */
/* loaded from: classes2.dex */
public class q_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3609a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed f3610b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f3611c;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed d_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed e_renamed;
    private final boolean f_renamed;

    public q_renamed(java.lang.String str, com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed aVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar2, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar3, boolean z_renamed) {
        this.f3609a = str;
        this.f3610b = aVar;
        this.f3611c = bVar;
        this.d_renamed = bVar2;
        this.e_renamed = bVar3;
        this.f_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f3609a;
    }

    public com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed b_renamed() {
        return this.f3610b;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed c_renamed() {
        return this.d_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed d_renamed() {
        return this.f3611c;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed e_renamed() {
        return this.e_renamed;
    }

    public boolean f_renamed() {
        return this.f_renamed;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ShapeTrimPath to TrimPathContent, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.s_renamed(aVar, this);
    }

    public java.lang.String toString() {
        return "Trim Path: {start: " + this.f3611c + ", end: " + this.d_renamed + ", offset: " + this.e_renamed + "}";
    }

    /* compiled from: ShapeTrimPath.java */
    public enum a_renamed {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed forId(int i_renamed) {
            if (i_renamed == 1) {
                return SIMULTANEOUSLY;
            }
            if (i_renamed == 2) {
                return INDIVIDUALLY;
            }
            throw new java.lang.IllegalArgumentException("Unknown trim path type " + i_renamed);
        }
    }
}
