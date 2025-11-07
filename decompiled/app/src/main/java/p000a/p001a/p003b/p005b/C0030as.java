package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.as */
/* loaded from: classes.dex */
public class C0030as extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0030as> f152q = new LruCache<>(5);

    public C0030as(Resources resources, Context context) {
        super(resources, C0120m.m524a("distortion_multitexture"), context);
        this.f34o = C0120m.m524a("fringing_vertex");
        m58a(new String[]{"distortion_amount", "fringing", "distortion_horizontal", "distortion_vertical"});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0030as m130a(Resources resources, Context context) {
        C0030as c0030as = f152q.get(Thread.currentThread().getName());
        if (c0030as == null) {
            c0030as = new C0030as(resources, context);
            c0030as.m30a();
            f152q.put(Thread.currentThread().getName(), c0030as);
        }
        c0030as.m56a(context);
        return c0030as;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m131m() {
        f152q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo50e() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            GLES20.glActiveTexture(33984 + OplusGLSurfaceView_13);
            GLES20.glBindTexture(3553, this.f21a.textures[OplusGLSurfaceView_13]);
        }
        GLES20.glUniform1iv(GLES20.glGetUniformLocation(this.f22b, "textures[0]"), 4, new int[]{0, 1, 2, 3}, 0);
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
    }
}
