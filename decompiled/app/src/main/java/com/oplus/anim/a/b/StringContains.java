package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class j_renamed extends com.oplus.anim.a_renamed.b_renamed.f_renamed<android.graphics.PointF> {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.PointF f3506c;

    public j_renamed(java.util.List<com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF>> list) {
        super(list);
        this.f3506c = new android.graphics.PointF();
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a_renamed(com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF> cVar, float f_renamed) {
        android.graphics.PointF pointF;
        if (cVar.f3704a == null || cVar.d_renamed == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        android.graphics.PointF pointF2 = cVar.f3704a;
        android.graphics.PointF pointF3 = cVar.d_renamed;
        if (this.f3499b != null && (pointF = (android.graphics.PointF) this.f3499b.a_renamed(cVar.f3706c, cVar.e_renamed.floatValue(), pointF2, pointF3, f_renamed, d_renamed(), h_renamed())) != null) {
            return pointF;
        }
        this.f3506c.set(pointF2.x_renamed + ((pointF3.x_renamed - pointF2.x_renamed) * f_renamed), pointF2.y_renamed + (f_renamed * (pointF3.y_renamed - pointF2.y_renamed)));
        return this.f3506c;
    }
}
