package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class o_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2103a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f2104b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.h_renamed f2105c;
    private final boolean d_renamed;

    public o_renamed(java.lang.String str, int i_renamed, com.airbnb.lottie.c_renamed.a_renamed.h_renamed hVar, boolean z_renamed) {
        this.f2103a = str;
        this.f2104b = i_renamed;
        this.f2105c = hVar;
        this.d_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f2103a;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.h_renamed b_renamed() {
        return this.f2105c;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        return new com.airbnb.lottie.a_renamed.a_renamed.q_renamed(fVar, aVar, this);
    }

    public boolean c_renamed() {
        return this.d_renamed;
    }

    public java.lang.String toString() {
        return "ShapePath{name=" + this.f2103a + ", index=" + this.f2104b + '}';
    }
}
