package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class m_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final boolean f2097a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Path.FillType f2098b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f2099c;
    private final com.airbnb.lottie.c_renamed.a_renamed.a_renamed d_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.d_renamed e_renamed;
    private final boolean f_renamed;

    public m_renamed(java.lang.String str, boolean z_renamed, android.graphics.Path.FillType fillType, com.airbnb.lottie.c_renamed.a_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.a_renamed.d_renamed dVar, boolean z2) {
        this.f2099c = str;
        this.f2097a = z_renamed;
        this.f2098b = fillType;
        this.d_renamed = aVar;
        this.e_renamed = dVar;
        this.f_renamed = z2;
    }

    public java.lang.String a_renamed() {
        return this.f2099c;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.a_renamed b_renamed() {
        return this.d_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.d_renamed c_renamed() {
        return this.e_renamed;
    }

    public android.graphics.Path.FillType d_renamed() {
        return this.f2098b;
    }

    public boolean e_renamed() {
        return this.f_renamed;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        return new com.airbnb.lottie.a_renamed.a_renamed.g_renamed(fVar, aVar, this);
    }

    public java.lang.String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f2097a + '}';
    }
}
