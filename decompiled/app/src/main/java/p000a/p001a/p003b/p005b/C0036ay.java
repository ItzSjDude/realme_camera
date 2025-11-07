package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ay */
/* loaded from: classes.dex */
public class C0036ay extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0036ay> f163q = new LruCache<>(5);

    /* renamed from: r */
    public int f164r;

    public C0036ay(Resources resources, Context context) {
        super(resources, C0120m.m524a("paint_blend"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0036ay m138a(Resources resources, Context context) {
        C0036ay c0036ay = f163q.get(Thread.currentThread().getName());
        if (c0036ay == null) {
            c0036ay = new C0036ay(resources, context);
            c0036ay.m30a();
            f163q.put(Thread.currentThread().getName(), c0036ay);
        }
        c0036ay.m56a(context);
        return c0036ay;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m139m() {
        f163q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f164r);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
    }
}
