package com.airbnb.lottie.c_renamed.a_renamed;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i_renamed implements com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed f2056a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed f2057b;

    public i_renamed(com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar2) {
        this.f2056a = bVar;
        this.f2057b = bVar2;
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public java.util.List<com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF>> c_renamed() {
        throw new java.lang.UnsupportedOperationException("Cannot call getKeyframes on_renamed AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public boolean b_renamed() {
        return this.f2056a.b_renamed() && this.f2057b.b_renamed();
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> a_renamed() {
        return new com.airbnb.lottie.a_renamed.b_renamed.m_renamed(this.f2056a.a_renamed(), this.f2057b.a_renamed());
    }
}
