package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class j_renamed extends com.airbnb.lottie.a_renamed.b_renamed.f_renamed<android.graphics.PointF> {
    private final android.graphics.PointF d_renamed;

    public j_renamed(java.util.List<com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF>> list) {
        super(list);
        this.d_renamed = new android.graphics.PointF();
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a_renamed(com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF> aVar, float f_renamed) {
        return a_renamed(aVar, f_renamed, f_renamed, f_renamed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a_renamed(com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF> aVar, float f_renamed, float f2, float f3) {
        android.graphics.PointF pointF;
        if (aVar.f2266a == null || aVar.f2267b == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        android.graphics.PointF pointF2 = aVar.f2266a;
        android.graphics.PointF pointF3 = aVar.f2267b;
        if (this.f2030c != null && (pointF = (android.graphics.PointF) this.f2030c.a_renamed(aVar.f_renamed, aVar.g_renamed.floatValue(), pointF2, pointF3, f_renamed, d_renamed(), h_renamed())) != null) {
            return pointF;
        }
        this.d_renamed.set(pointF2.x_renamed + (f2 * (pointF3.x_renamed - pointF2.x_renamed)), pointF2.y_renamed + (f3 * (pointF3.y_renamed - pointF2.y_renamed)));
        return this.d_renamed;
    }
}
