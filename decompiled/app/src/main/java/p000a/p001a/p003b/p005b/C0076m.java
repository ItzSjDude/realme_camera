package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0115h;
import p000a.p001a.p003b.p010f.C0120m;
import p000a.p001a.p003b.p010f.C0125r;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class C0076m extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0076m> f326q = new LruCache<>(5);

    public C0076m(Resources resources, Context context) {
        super(resources, C0120m.m524a("watermark"), context);
        m58a(new String[]{"opacity"});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0076m m235a(Resources resources, Context context) {
        C0076m c0076m = f326q.get(Thread.currentThread().getName());
        if (c0076m == null) {
            c0076m = new C0076m(resources, context);
            c0076m.m30a();
            f326q.put(Thread.currentThread().getName(), c0076m);
        }
        c0076m.m56a(context);
        return c0076m;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m236m() {
        f326q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo50e() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        Context context = this.f21a;
        if (context.watermarkTexture != null) {
            Context.WatermarkOptions watermarkOptions = context.watermarkOptions;
            if (watermarkOptions.enabled || watermarkOptions.preview) {
                m237n();
                super.mo23j();
                int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "texture");
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.f21a.watermarkTexture.f387a);
                GLES20.glUniform1i(iGlGetUniformLocation, 0);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f21a.watermarkOptions.opacity);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public final void m237n() {
        float[] fArrM496a = C0115h.m496a(this.f21a);
        Context context = this.f21a;
        C0094d c0094d = context.watermarkTexture;
        float COUIBaseListPopupWindow_12 = c0094d.f388b;
        float f2 = c0094d.f389c;
        float f3 = fArrM496a[2];
        float f4 = fArrM496a[3];
        float[] fArrM497b = C0115h.m497b(context);
        if (this.f21a.cropMode) {
            f3 = fArrM497b[0];
            f4 = fArrM497b[1];
        }
        float f5 = COUIBaseListPopupWindow_12 / f3;
        float f6 = f2 / f4;
        Context.WatermarkOptions watermarkOptions = this.f21a.watermarkOptions;
        float[] fArr = watermarkOptions.position;
        float f7 = watermarkOptions.scale;
        float f8 = watermarkOptions.rotation;
        float fMax = Math.max(f5, f6);
        float f9 = (f5 / fMax) * f7;
        float f10 = (f6 / fMax) * f7;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArrM497b[0] / 2.0f;
        float f14 = fArrM497b[1] / 2.0f;
        float f15 = fArrM496a[0];
        float f16 = this.f21a.cropScale;
        float[] fArr2 = {((f15 - f13) * f16) + f13, ((fArrM496a[1] - f14) * f16) + f14, fArrM496a[2] * f16, fArrM496a[3] * f16};
        float f17 = (fArrM497b[0] - fArr2[2]) / 2.0f;
        float f18 = fArr2[0];
        float f19 = (fArrM497b[1] - fArr2[3]) / 2.0f;
        float f20 = fArr2[1];
        float f21 = (-(f17 - f18)) / fArr2[2];
        float f22 = (-(f19 - f20)) / fArr2[3];
        float f23 = fArr2[2] / fArrM497b[0];
        float f24 = fArr2[3] / fArrM497b[1];
        float[] fArrM596a = C0125r.m596a();
        Matrix.multiplyMM(fArrM596a, 0, fArrM596a, 0, this.f21a.viewMatrix, 0);
        Matrix.scaleM(fArrM596a, 0, this.f21a.viewMatrix, 0, f23, f24, 1.0f);
        Matrix.translateM(fArrM596a, 0, f21 * 2.0f, f22 * 2.0f, 0.0f);
        Matrix.translateM(fArrM596a, 0, f11 - (f9 * f11), f12 - (f10 * f12), 0.0f);
        Matrix.scaleM(fArrM596a, 0, 1.0f / f3, 1.0f / f4, 1.0f);
        Matrix.rotateM(fArrM596a, 0, f8, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArrM596a, 0, f3, f4, 1.0f);
        Matrix.scaleM(fArrM596a, 0, f9, f10, 1.0f);
        m42a(fArrM596a);
    }
}
