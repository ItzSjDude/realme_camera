package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class j_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2088a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> f2089b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> f2090c;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed d_renamed;
    private final boolean e_renamed;

    public j_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar, com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar2, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar, boolean z_renamed) {
        this.f2088a = str;
        this.f2089b = mVar;
        this.f2090c = mVar2;
        this.d_renamed = bVar;
        this.e_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f2088a;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed b_renamed() {
        return this.d_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> c_renamed() {
        return this.f2090c;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> d_renamed() {
        return this.f2089b;
    }

    public boolean e_renamed() {
        return this.e_renamed;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        return new com.airbnb.lottie.a_renamed.a_renamed.o_renamed(fVar, aVar, this);
    }

    public java.lang.String toString() {
        return "RectangleShape{position=" + this.f2089b + ", size=" + this.f2090c + '}';
    }
}
