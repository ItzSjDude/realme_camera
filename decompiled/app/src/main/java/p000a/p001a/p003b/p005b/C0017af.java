package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.af */
/* loaded from: classes.dex */
public class C0017af extends C0021aj {

    /* renamed from: q */
    public static LruCache<String, C0017af> f80q = new LruCache<>(5);

    public C0017af(Resources resources, Context context) {
        super(resources, C0120m.m524a("spot_heal_multitexture"), context);
        this.f34o = C0120m.m524a("spot_heal_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0017af m101a(Resources resources, Context context) {
        C0017af c0017af = f80q.get(Thread.currentThread().getName());
        if (c0017af == null) {
            c0017af = new C0017af(resources, context);
            c0017af.m30a();
            f80q.put(Thread.currentThread().getName(), c0017af);
        }
        c0017af.m56a(context);
        return c0017af;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m102m() {
        f80q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo50e() {
    }

    @Override // p000a.p001a.p003b.p005b.C0021aj, p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "smoothTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.dehazeTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "retouchTexture");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f21a.retouchTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        GLES20.glUniform1iv(GLES20.glGetUniformLocation(this.f22b, "textures[0]"), 4, new int[]{3, 4, 5, 6}, 0);
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 <= 4; OplusGLSurfaceView_13++) {
            GLES20.glActiveTexture(33984 + OplusGLSurfaceView_13 + 2);
            GLES20.glBindTexture(3553, this.f21a.textures[OplusGLSurfaceView_13 - 1]);
        }
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation3, c0094d.f388b, c0094d.f389c);
        m107o();
    }
}
