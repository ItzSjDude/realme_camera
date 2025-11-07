package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.t */
/* loaded from: classes.dex */
public class C0083t extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0083t> f347q = new LruCache<>(5);

    /* renamed from: r */
    public int f348r;

    public C0083t(Resources resources, Context context) {
        super(resources, C0120m.m524a("combine_mask"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0083t m246a(Resources resources, Context context) {
        C0083t c0083t = f347q.get(Thread.currentThread().getName());
        if (c0083t == null) {
            c0083t = new C0083t(resources, context);
            c0083t.m30a();
            f347q.put(Thread.currentThread().getName(), c0083t);
        }
        c0083t.m56a(context);
        return c0083t;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m247m() {
        f347q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "mask");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f348r);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
    }
}
