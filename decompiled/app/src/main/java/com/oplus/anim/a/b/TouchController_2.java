package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class m_renamed extends com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.PointF f3509c;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> d_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> e_renamed;

    public m_renamed(com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar, com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar2) {
        super(java.util.Collections.emptyList());
        this.f3509c = new android.graphics.PointF();
        this.d_renamed = aVar;
        this.e_renamed = aVar2;
        a_renamed(h_renamed());
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    public void a_renamed(float f_renamed) {
        this.d_renamed.a_renamed(f_renamed);
        this.e_renamed.a_renamed(f_renamed);
        this.f3509c.set(this.d_renamed.g_renamed().floatValue(), this.e_renamed.g_renamed().floatValue());
        for (int i_renamed = 0; i_renamed < this.f3498a.size(); i_renamed++) {
            this.f3498a.get(i_renamed).a_renamed();
        }
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: i_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF g_renamed() {
        return a_renamed(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a_renamed(com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF> cVar, float f_renamed) {
        return this.f3509c;
    }
}
