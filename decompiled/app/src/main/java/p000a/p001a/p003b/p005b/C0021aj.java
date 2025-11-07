package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.oplus.ocs.camera.CameraParameter;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.aj */
/* loaded from: classes.dex */
public class C0021aj extends C0009b {

    /* renamed from: r */
    public static LruCache<String, C0021aj> f95r = new LruCache<>(5);

    /* renamed from: s */
    public float f96s;

    /* renamed from: t */
    public float[] f97t;

    /* renamed from: u */
    public float[] f98u;

    /* renamed from: v */
    public float[] f99v;

    /* renamed from: w */
    public float f100w;

    /* renamed from: x */
    public float f101x;

    /* renamed from: y */
    public float f102y;

    public C0021aj(Resources resources, Context context) {
        super(resources, C0120m.m524a("spot_heal"), context);
        this.f34o = C0120m.m524a("spot_heal_vertex");
    }

    public C0021aj(Resources resources, String str, Context context) {
        super(resources, str, context);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static C0021aj m105b(Resources resources, Context context) {
        C0021aj c0021aj = f95r.get(Thread.currentThread().getName());
        if (c0021aj == null) {
            c0021aj = new C0021aj(resources, context);
            c0021aj.m30a();
            f95r.put(Thread.currentThread().getName(), c0021aj);
        }
        c0021aj.m56a(context);
        return c0021aj;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static void m106n() {
        f95r.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "smoothTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.dehazeTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "originalTexture");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f21a.imageTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "retouchTexture");
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f21a.retouchTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation3, 3);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
        int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation4, c0094d.f388b, c0094d.f389c);
        m107o();
    }

    /* renamed from: o */
    public void m107o() {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "feather"), this.f96s);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, CameraParameter.WaterMarkParamKeys.SIZE), 1, this.f97t, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "position"), 1, this.f98u, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "sourcePosition"), 1, this.f99v, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f101x);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "angle"), this.f100w);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "mode"), this.f102y);
    }
}
