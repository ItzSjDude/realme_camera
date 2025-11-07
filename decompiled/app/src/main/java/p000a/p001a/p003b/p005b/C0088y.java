package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.y */
/* loaded from: classes.dex */
public class C0088y extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0088y> f357q = new LruCache<>(5);

    public C0088y(Resources resources, Context context) {
        super(resources, C0120m.m524a("blur_composite"), context);
        this.f34o = C0120m.m524a("composite_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0088y m256a(Resources resources, Context context) {
        C0088y c0088y = f357q.get(Thread.currentThread().getName());
        if (c0088y == null) {
            c0088y = new C0088y(resources, context);
            c0088y.m30a();
            f357q.put(Thread.currentThread().getName(), c0088y);
        }
        c0088y.m56a(context);
        return c0088y;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m257m() {
        f357q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "blurTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.lensBlurTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
    }
}
