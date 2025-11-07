package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0115h;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.r */
/* loaded from: classes.dex */
public class C0081r extends C0009b {

    /* renamed from: q */
    public float f340q;

    /* renamed from: r */
    public boolean f341r;

    public C0081r(Resources resources, Context context) {
        super(resources, C0120m.m524a("vertical_stripes"), context);
        this.f340q = 0.5f;
        this.f341r = false;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        float[] fArrM497b = C0115h.m497b(this.f21a);
        m36a("imageSize", fArrM497b[0], fArrM497b[1]);
        m35a("strength", this.f340q);
        m35a("axis", this.f341r ? 0.0f : 1.0f);
    }
}
