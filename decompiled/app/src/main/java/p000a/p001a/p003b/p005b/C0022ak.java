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

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ak */
/* loaded from: classes.dex */
public class C0022ak extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0022ak> f103q = new LruCache<>(5);

    /* renamed from: A */
    public float f104A;

    /* renamed from: r */
    public float f105r;

    /* renamed from: s */
    public float f106s;

    /* renamed from: t */
    public float f107t;

    /* renamed from: u */
    public float f108u;

    /* renamed from: v */
    public float[] f109v;

    /* renamed from: w */
    public float[] f110w;

    /* renamed from: x */
    public float f111x;

    /* renamed from: y */
    public float f112y;

    /* renamed from: z */
    public float[] f113z;

    public C0022ak(Resources resources, Context context) {
        super(resources, C0120m.m524a("mask_color"), context);
        this.f34o = C0120m.m524a("distortion_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0022ak m108a(Resources resources, Context context) {
        C0022ak c0022ak = f103q.get(Thread.currentThread().getName());
        if (c0022ak == null) {
            c0022ak = new C0022ak(resources, context);
            c0022ak.m30a();
            f103q.put(Thread.currentThread().getName(), c0022ak);
        }
        c0022ak.m56a(context);
        return c0022ak;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m109m() {
        f103q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "colorMap");
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
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "feather"), this.f105r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "invert"), this.f106s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "useRadius"), this.f107t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "threshold"), this.f108u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f111x);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "alpha"), this.f112y);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, "position"), 1, this.f109v, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, CameraParameter.WaterMarkParamKeys.SIZE), 1, this.f110w, 0);
        float[] fArr = this.f113z;
        if (fArr != null && fArr.length == 3) {
            GLES20.glUniform3fv(GLES20.glGetUniformLocation(this.f22b, "selectedColor"), 1, this.f113z, 0);
        }
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "useSelectedColor"), this.f104A);
    }
}
