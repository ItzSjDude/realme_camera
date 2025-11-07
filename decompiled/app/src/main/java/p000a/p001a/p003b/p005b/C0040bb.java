package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.oplus.ocs.camera.CameraParameter;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bb */
/* loaded from: classes.dex */
public class C0040bb extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0040bb> f180q = new LruCache<>(5);

    /* renamed from: r */
    public float f181r;

    /* renamed from: s */
    public float[] f182s;

    /* renamed from: t */
    public float[] f183t;

    /* renamed from: u */
    public float[] f184u;

    /* renamed from: v */
    public float f185v;

    /* renamed from: w */
    public float f186w;

    public C0040bb(Resources resources, Context context) {
        super(resources, C0120m.m524a("spot_heal_mask"), context);
        this.f34o = C0120m.m524a("composite_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0040bb m148a(Resources resources, Context context) {
        C0040bb c0040bb = f180q.get(Thread.currentThread().getName());
        if (c0040bb == null) {
            c0040bb = new C0040bb(resources, context);
            c0040bb.m30a();
            f180q.put(Thread.currentThread().getName(), c0040bb);
        }
        c0040bb.m56a(context);
        return c0040bb;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m149m() {
        f180q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, getMatrix(), 0);
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "feather"), this.f181r);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, CameraParameter.WaterMarkParamKeys.SIZE), 1, this.f182s, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "position"), 1, this.f183t, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "sourcePosition"), 1, this.f184u, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f185v);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "alpha"), this.f186w);
    }
}
