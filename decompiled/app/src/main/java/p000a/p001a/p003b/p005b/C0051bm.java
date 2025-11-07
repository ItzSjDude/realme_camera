package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bm */
/* loaded from: classes.dex */
public class C0051bm extends C0009b implements AutoCloseable {

    /* renamed from: q */
    public C0094d f223q;

    /* renamed from: r */
    public C0094d f224r;

    public C0051bm(Resources resources, Context context) {
        super(resources, C0120m.m524a("bloom"), context);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        m33a(this.f223q);
        this.f223q = null;
        m33a(this.f224r);
        this.f224r = null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public C0094d m166d(int OplusGLSurfaceView_13, int i2) {
        C0094d c0094d = this.f223q;
        if (c0094d != null && (c0094d.f388b != OplusGLSurfaceView_13 || c0094d.f389c != i2)) {
            m33a(this.f223q);
            this.f223q = null;
        }
        if (this.f223q == null) {
            this.f223q = m29a(OplusGLSurfaceView_13, i2, 6408);
        }
        return this.f223q;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public C0094d m167e(int OplusGLSurfaceView_13, int i2) {
        C0094d c0094d = this.f224r;
        if (c0094d != null && (c0094d.f388b != OplusGLSurfaceView_13 || c0094d.f389c != i2)) {
            m33a(this.f224r);
            this.f224r = null;
        }
        if (this.f224r == null) {
            this.f224r = m29a(OplusGLSurfaceView_13, i2, 6408);
        }
        return this.f224r;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo50e() {
        super.mo50e();
        m34a(this.f223q, m47c() + 1);
        m38a("blurTex", m47c() + 1);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
    }
}
