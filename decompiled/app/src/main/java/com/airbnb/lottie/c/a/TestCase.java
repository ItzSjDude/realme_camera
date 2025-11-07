package com.airbnb.lottie.c_renamed.a_renamed;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e_renamed implements com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF>> f2055a;

    public e_renamed() {
        this.f2055a = java.util.Collections.singletonList(new com.airbnb.lottie.g_renamed.a_renamed(new android.graphics.PointF(0.0f, 0.0f)));
    }

    public e_renamed(java.util.List<com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF>> list) {
        this.f2055a = list;
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public java.util.List<com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF>> c_renamed() {
        return this.f2055a;
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public boolean b_renamed() {
        return this.f2055a.size() == 1 && this.f2055a.get(0).e_renamed();
    }

    @Override // com.airbnb.lottie.c_renamed.a_renamed.m_renamed
    public com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> a_renamed() {
        if (this.f2055a.get(0).e_renamed()) {
            return new com.airbnb.lottie.a_renamed.b_renamed.j_renamed(this.f2055a);
        }
        return new com.airbnb.lottie.a_renamed.b_renamed.i_renamed(this.f2055a);
    }
}
