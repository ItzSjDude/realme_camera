package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bj */
/* loaded from: classes.dex */
public class C0048bj extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0048bj> f216q = new LruCache<>(5);

    public C0048bj(Resources resources, Context context) {
        super(resources, C0120m.m524a("distortion"), context);
        this.f34o = C0120m.m524a("fringing_vertex");
        m58a(new String[]{"distortion_amount", "fringing", "distortion_horizontal", "distortion_vertical"});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0048bj m160a(Resources resources, Context context) {
        C0048bj c0048bj = f216q.get(Thread.currentThread().getName());
        if (c0048bj == null) {
            c0048bj = new C0048bj(resources, context);
            c0048bj.m30a();
            f216q.put(Thread.currentThread().getName(), c0048bj);
        }
        c0048bj.m56a(context);
        return c0048bj;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m161m() {
        f216q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo24l() {
        return false;
    }
}
