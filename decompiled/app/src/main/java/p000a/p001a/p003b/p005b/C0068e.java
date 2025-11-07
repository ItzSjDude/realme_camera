package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class C0068e extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0068e> f309q = new LruCache<>(5);

    /* renamed from: r */
    public float[] f310r;

    public C0068e(Resources resources, Context context) {
        super(resources, C0120m.m524a("denoise_nlm1"), context);
        this.f310r = new float[15];
        m58a(new String[]{"delta"});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0068e m225a(Resources resources, Context context) {
        C0068e c0068e = f309q.get(Thread.currentThread().getName());
        if (c0068e == null) {
            c0068e = new C0068e(resources, context);
            c0068e.m30a();
            f309q.put(Thread.currentThread().getName(), c0068e);
        }
        c0068e.m56a(context);
        return c0068e;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m226m() {
        f309q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "textureResolution");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "kernel[0]");
        float[] fArr = this.f310r;
        GLES20.glUniform1fv(iGlGetUniformLocation2, fArr.length, fArr, 0);
    }
}
