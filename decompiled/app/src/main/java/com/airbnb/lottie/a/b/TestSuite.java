package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i_renamed extends com.airbnb.lottie.a_renamed.b_renamed.f_renamed<android.graphics.PointF> {
    private final android.graphics.PointF d_renamed;
    private final float[] e_renamed;
    private final android.graphics.PathMeasure f_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.h_renamed g_renamed;

    public i_renamed(java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF>> list) {
        super(list);
        this.d_renamed = new android.graphics.PointF();
        this.e_renamed = new float[2];
        this.f_renamed = new android.graphics.PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a_renamed(com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF> aVar, float f_renamed) {
        android.graphics.PointF pointF;
        com.airbnb.lottie.a_renamed.b_renamed.h_renamed hVar = (com.airbnb.lottie.a_renamed.b_renamed.h_renamed) aVar;
        android.graphics.Path pathB = hVar.b_renamed();
        if (pathB == null) {
            return aVar.f2266a;
        }
        if (this.f2030c != null && (pointF = (android.graphics.PointF) this.f2030c.a_renamed(hVar.f_renamed, hVar.g_renamed.floatValue(), hVar.f2266a, hVar.f2267b, d_renamed(), f_renamed, h_renamed())) != null) {
            return pointF;
        }
        if (this.g_renamed != hVar) {
            this.f_renamed.setPath(pathB, false);
            this.g_renamed = hVar;
        }
        android.graphics.PathMeasure pathMeasure = this.f_renamed;
        pathMeasure.getPosTan(f_renamed * pathMeasure.getLength(), this.e_renamed, null);
        android.graphics.PointF pointF2 = this.d_renamed;
        float[] fArr = this.e_renamed;
        pointF2.set(fArr[0], fArr[1]);
        return this.d_renamed;
    }
}
