package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bn */
/* loaded from: classes.dex */
public class C0052bn extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0052bn> f225q = new LruCache<>(5);

    public C0052bn(Resources resources, Context context) {
        super(resources, C0120m.m524a("out_multitexture"), context);
        this.f34o = C0120m.m524a("distortion_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0052bn m168a(Resources resources, Context context) {
        C0052bn c0052bn = f225q.get(Thread.currentThread().getName());
        if (c0052bn == null) {
            c0052bn = new C0052bn(resources, context);
            c0052bn.m30a();
            f225q.put(Thread.currentThread().getName(), c0052bn);
        }
        c0052bn.m56a(context);
        return c0052bn;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m169m() {
        f225q.evictAll();
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
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "texture");
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.f21a.readableTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 4);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation2, c0094d.f388b, c0094d.f389c);
    }
}
