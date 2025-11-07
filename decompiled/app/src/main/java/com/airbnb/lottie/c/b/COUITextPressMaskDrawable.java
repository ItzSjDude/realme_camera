package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: ShapeTrimPath.java */
/* loaded from: classes.dex */
public class q_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2111a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed f2112b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed f2113c;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed d_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed e_renamed;
    private final boolean f_renamed;

    /* compiled from: ShapeTrimPath.java */
    public enum a_renamed {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed forId(int i_renamed) {
            if (i_renamed == 1) {
                return SIMULTANEOUSLY;
            }
            if (i_renamed == 2) {
                return INDIVIDUALLY;
            }
            throw new java.lang.IllegalArgumentException("Unknown trim path type " + i_renamed);
        }
    }

    public q_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar2, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar3, boolean z_renamed) {
        this.f2111a = str;
        this.f2112b = aVar;
        this.f2113c = bVar;
        this.d_renamed = bVar2;
        this.e_renamed = bVar3;
        this.f_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f2111a;
    }

    public com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed b_renamed() {
        return this.f2112b;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed c_renamed() {
        return this.d_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed d_renamed() {
        return this.f2113c;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed e_renamed() {
        return this.e_renamed;
    }

    public boolean f_renamed() {
        return this.f_renamed;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        return new com.airbnb.lottie.a_renamed.a_renamed.s_renamed(aVar, this);
    }

    public java.lang.String toString() {
        return "Trim Path: {start: " + this.f2113c + ", end: " + this.d_renamed + ", offset: " + this.e_renamed + "}";
    }
}
