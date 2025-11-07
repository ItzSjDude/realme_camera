package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.util.Map;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.aw */
/* loaded from: classes.dex */
public class C0034aw extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0034aw> f157q = new LruCache<>(5);

    /* renamed from: r */
    public String f158r;

    /* renamed from: s */
    public float f159s;

    /* renamed from: t */
    public float f160t;

    /* renamed from: u */
    public float f161u;

    /* renamed from: v */
    public int f162v;

    public C0034aw(Resources resources, Context context) {
        super(resources, C0120m.m524a("mosaic"), context);
        this.f158r = "square";
        this.f34o = C0120m.m524a("composite_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0034aw m136a(Resources resources, Context context) {
        C0034aw c0034aw = f157q.get(Thread.currentThread().getName());
        if (c0034aw == null) {
            c0034aw = new C0034aw(resources, context);
            c0034aw.m30a();
            f157q.put(Thread.currentThread().getName(), c0034aw);
        }
        c0034aw.m56a(context);
        return c0034aw;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m137m() {
        f157q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        Map<String, C0094d> map;
        C0094d c0094d;
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "blurTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f162v);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        String str = this.f158r;
        if (str != null && (map = this.f21a.patterns) != null && (c0094d = map.get(str)) != null) {
            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "patternTexture");
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, c0094d.f387a);
            GLES20.glUniform1i(iGlGetUniformLocation2, 2);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f22b, "patternSize"), c0094d.f388b, c0094d.f389c);
        }
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "mosaic_size"), (float) (this.f159s * Math.sqrt((this.f160t * this.f161u) / 2073600.0f)));
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, AbstractC0008a.f20m, 0);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f22b, "imgSize"), this.f160t, this.f161u);
    }
}
