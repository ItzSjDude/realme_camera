package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class i_renamed extends com.oplus.anim.a_renamed.b_renamed.f_renamed<android.graphics.PointF> {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.PointF f3505c;
    private final float[] d_renamed;
    private com.oplus.anim.a_renamed.b_renamed.h_renamed e_renamed;
    private android.graphics.PathMeasure f_renamed;

    public i_renamed(java.util.List<? extends com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF>> list) {
        super(list);
        this.f3505c = new android.graphics.PointF();
        this.d_renamed = new float[2];
        this.f_renamed = new android.graphics.PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a_renamed(com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF> cVar, float f_renamed) {
        android.graphics.PointF pointF;
        com.oplus.anim.a_renamed.b_renamed.h_renamed hVar = (com.oplus.anim.a_renamed.b_renamed.h_renamed) cVar;
        android.graphics.Path pathB = hVar.b_renamed();
        if (pathB == null) {
            return cVar.f3704a;
        }
        if (this.f3499b != null && (pointF = (android.graphics.PointF) this.f3499b.a_renamed(hVar.f3706c, hVar.e_renamed.floatValue(), hVar.f3704a, hVar.d_renamed, d_renamed(), f_renamed, h_renamed())) != null) {
            return pointF;
        }
        if (this.e_renamed != hVar) {
            this.f_renamed.setPath(pathB, false);
            this.e_renamed = hVar;
        }
        android.graphics.PathMeasure pathMeasure = this.f_renamed;
        pathMeasure.getPosTan(f_renamed * pathMeasure.getLength(), this.d_renamed, null);
        android.graphics.PointF pointF2 = this.f3505c;
        float[] fArr = this.d_renamed;
        pointF2.set(fArr[0], fArr[1]);
        return this.f3505c;
    }
}
