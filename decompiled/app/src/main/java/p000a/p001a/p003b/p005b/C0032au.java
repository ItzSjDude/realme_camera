package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.au */
/* loaded from: classes.dex */
public class C0032au extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0032au> f156q = new LruCache<>(5);

    public C0032au(Resources resources, Context context) {
        super(resources, C0120m.m524a("out"), context);
        this.f34o = C0120m.m524a("distortion_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0032au m134a(Resources resources, Context context) {
        C0032au c0032au = f156q.get(Thread.currentThread().getName());
        if (c0032au == null) {
            c0032au = new C0032au(resources, context);
            c0032au.m30a();
            f156q.put(Thread.currentThread().getName(), c0032au);
        }
        c0032au.m56a(context);
        return c0032au;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m135m() {
        f156q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "original");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.imageTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation2, c0094d.f388b, c0094d.f389c);
    }
}
