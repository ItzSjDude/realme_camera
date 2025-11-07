package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: PathKeyframe.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF> {
    private final com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF> h_renamed;
    private android.graphics.Path i_renamed;

    public h_renamed(com.oplus.anim.a_renamed aVar, com.oplus.anim.g_renamed.c_renamed<android.graphics.PointF> cVar) {
        super(aVar, cVar.f3704a, cVar.d_renamed, cVar.f3705b, cVar.f3706c, cVar.e_renamed);
        this.h_renamed = cVar;
        a_renamed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a_renamed() {
        boolean z_renamed = (this.d_renamed == 0 || this.f3704a == 0 || !((android.graphics.PointF) this.f3704a).equals(((android.graphics.PointF) this.d_renamed).x_renamed, ((android.graphics.PointF) this.d_renamed).y_renamed)) ? false : true;
        if (this.d_renamed == 0 || this.f3704a == 0 || z_renamed) {
            return;
        }
        this.i_renamed = com.oplus.anim.f_renamed.g_renamed.a_renamed((android.graphics.PointF) this.f3704a, (android.graphics.PointF) this.d_renamed, this.h_renamed.f_renamed, this.h_renamed.g_renamed);
    }

    android.graphics.Path b_renamed() {
        return this.i_renamed;
    }
}
