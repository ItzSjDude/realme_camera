package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.oplus.ocs.camera.CameraParameter;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ap */
/* loaded from: classes.dex */
public final class C0027ap extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0027ap> f122q = new LruCache<>(5);

    /* renamed from: r */
    public float f123r;

    /* renamed from: s */
    public float f124s;

    /* renamed from: t */
    public float f125t;

    /* renamed from: u */
    public float[] f126u;

    /* renamed from: v */
    public float[] f127v;

    /* renamed from: w */
    public float f128w;

    /* renamed from: x */
    public float f129x;

    public C0027ap(Resources resources, Context context) {
        super(resources, C0120m.m524a("mask_radial"), context);
        this.f34o = C0120m.m524a("composite_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0027ap m114a(Resources resources, Context context) {
        C0027ap c0027ap = f122q.get(Thread.currentThread().getName());
        if (c0027ap == null) {
            c0027ap = new C0027ap(resources, context);
            c0027ap.m30a();
            f122q.put(Thread.currentThread().getName(), c0027ap);
        }
        c0027ap.m56a(context);
        return c0027ap;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m115m() {
        f122q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "feather"), this.f123r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "invert"), this.f124s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "angle"), this.f125t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f128w);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "alpha"), this.f129x);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "position");
        if (this.f21a.isSDK) {
            float[] fArr = this.f126u;
            GLES20.glUniform2f(iGlGetUniformLocation2, fArr[0], -fArr[1]);
        } else {
            GLES20.glUniform2fv(iGlGetUniformLocation2, 1, this.f126u, 0);
        }
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, CameraParameter.WaterMarkParamKeys.SIZE), 1, this.f127v, 0);
    }
}
