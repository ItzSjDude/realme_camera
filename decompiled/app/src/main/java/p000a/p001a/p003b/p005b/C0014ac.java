package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ac */
/* loaded from: classes.dex */
public final class C0014ac extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0014ac> f65q = new LruCache<>(5);

    /* renamed from: r */
    public float[] f66r;

    /* renamed from: s */
    public float[] f67s;

    /* renamed from: t */
    public float f68t;

    /* renamed from: u */
    public float f69u;

    /* renamed from: v */
    public float f70v;

    /* renamed from: w */
    public float f71w;

    public C0014ac(Resources resources, Context context) {
        super(resources, C0120m.m524a("mask_gradient"), context);
        this.f34o = C0120m.m524a("composite_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0014ac m97a(Resources resources, Context context) {
        C0014ac c0014ac = f65q.get(Thread.currentThread().getName());
        if (c0014ac == null) {
            c0014ac = new C0014ac(resources, context);
            c0014ac.m30a();
            f65q.put(Thread.currentThread().getName(), c0014ac);
        }
        c0014ac.m56a(context);
        return c0014ac;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m98m() {
        f65q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "invert"), this.f68t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "reflect"), this.f69u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f70v);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "alpha"), this.f71w);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "endPoint"), 1, this.f67s, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "startPoint"), 1, this.f66r, 0);
    }
}
