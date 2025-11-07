package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class C0072i extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0072i> f316q = new LruCache<>(5);

    public C0072i(Resources resources, Context context) {
        super(resources, C0120m.m524a("multitexture"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0072i m231a(Resources resources, Context context) {
        C0072i c0072i = f316q.get(Thread.currentThread().getName());
        if (c0072i == null) {
            c0072i = new C0072i(resources, context);
            c0072i.m30a();
            f316q.put(Thread.currentThread().getName(), c0072i);
        }
        c0072i.m56a(context);
        return c0072i;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m232m() {
        f316q.evictAll();
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
    }
}
