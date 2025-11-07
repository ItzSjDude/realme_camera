package com.oplus.anim.c_renamed.a_renamed;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes2.dex */
public class i_renamed implements com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f3554a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f3555b;

    public i_renamed(com.oplus.anim.c_renamed.a_renamed.b_renamed bVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar2) {
        this.f3554a = bVar;
        this.f3555b = bVar2;
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public java.util.List<com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF>> c_renamed() {
        throw new java.lang.UnsupportedOperationException("Cannot call getKeyframes on_renamed AnimatableSplitDimensionPathValue.");
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public boolean b_renamed() {
        return this.f3554a.b_renamed() && this.f3555b.b_renamed();
    }

    @Override // com.oplus.anim.c_renamed.a_renamed.m_renamed
    public com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> a_renamed() {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("AnimatableSplitDimensionPathValue create SplitDimensionPathKeyframeAnimation.");
        }
        return new com.oplus.anim.a_renamed.b_renamed.m_renamed(this.f3554a.a_renamed(), this.f3555b.a_renamed());
    }
}
