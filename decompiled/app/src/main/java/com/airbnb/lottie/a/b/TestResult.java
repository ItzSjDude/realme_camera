package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class h_renamed extends com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF> {
    private android.graphics.Path j_renamed;
    private final com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF> k_renamed;

    public h_renamed(com.airbnb.lottie.d_renamed dVar, com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF> aVar) {
        super(dVar, aVar.f2266a, aVar.f2267b, aVar.f2268c, aVar.d_renamed, aVar.e_renamed, aVar.f_renamed, aVar.g_renamed);
        this.k_renamed = aVar;
        a_renamed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a_renamed() {
        boolean z_renamed = (this.f2267b == 0 || this.f2266a == 0 || !((android.graphics.PointF) this.f2266a).equals(((android.graphics.PointF) this.f2267b).x_renamed, ((android.graphics.PointF) this.f2267b).y_renamed)) ? false : true;
        if (this.f2266a == 0 || this.f2267b == 0 || z_renamed) {
            return;
        }
        this.j_renamed = com.airbnb.lottie.f_renamed.h_renamed.a_renamed((android.graphics.PointF) this.f2266a, (android.graphics.PointF) this.f2267b, this.k_renamed.h_renamed, this.k_renamed.i_renamed);
    }

    android.graphics.Path b_renamed() {
        return this.j_renamed;
    }
}
