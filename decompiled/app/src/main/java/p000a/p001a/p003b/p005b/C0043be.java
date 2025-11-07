package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.be */
/* loaded from: classes.dex */
public final class C0043be extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0043be> f188q = new LruCache<>(5);

    /* renamed from: r */
    public float f189r;

    /* renamed from: s */
    public float f190s;

    /* renamed from: t */
    public float f191t;

    /* renamed from: u */
    public float f192u;

    /* renamed from: v */
    public float f193v;

    /* renamed from: w */
    public float f194w;

    public C0043be(Resources resources, Context context) {
        super(resources, C0120m.m524a("mask_luminance"), context);
        this.f34o = C0120m.m524a("distortion_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0043be m152a(Resources resources, Context context) {
        C0043be c0043be = f188q.get(Thread.currentThread().getName());
        if (c0043be == null) {
            c0043be = new C0043be(resources, context);
            c0043be.m30a();
            f188q.put(Thread.currentThread().getName(), c0043be);
        }
        c0043be.m56a(context);
        return c0043be;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m153m() {
        f188q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "smoothTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.dehazeTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation2, c0094d.f388b, c0094d.f389c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "target"), this.f189r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "range"), this.f190s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "smoothness"), this.f191t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "invert"), this.f192u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f193v);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "alpha"), this.f194w);
    }
}
