package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.graphics.PointF;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ag */
/* loaded from: classes.dex */
public class C0018ag extends C0009b {

    /* renamed from: q */
    public float f81q;

    /* renamed from: r */
    public PointF f82r;

    /* renamed from: s */
    public float f83s;

    /* renamed from: t */
    public float f84t;

    public C0018ag(Resources resources, Context context) {
        super(resources, C0120m.m524a("fringing"), context);
        this.f81q = 0.16f;
        this.f82r = new PointF(0.5f, 0.5f);
        this.f83s = 0.8f;
        this.f84t = 0.4f;
        this.f34o = C0120m.m524a("fringing2_vertex");
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        m35a("fringing", this.f81q);
        PointF pointF = this.f82r;
        m36a("fringing_center", pointF.x, pointF.y);
        m35a("fringing_radius", this.f83s);
        m35a("fringing_radius_inner", this.f84t);
    }
}
