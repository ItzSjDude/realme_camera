package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bz */
/* loaded from: classes.dex */
public class C0064bz extends C0009b {

    /* renamed from: q */
    public float f303q;

    public C0064bz(Resources resources, Context context) {
        super(resources, C0120m.m524a("high_throughput"), context);
        this.f303q = 0.9f;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        m35a("threshold", this.f303q);
    }
}
