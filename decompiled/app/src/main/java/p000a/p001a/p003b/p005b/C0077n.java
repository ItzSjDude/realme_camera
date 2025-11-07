package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class C0077n extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0077n> f327q = new LruCache<>(5);

    /* renamed from: r */
    public int f328r;

    public C0077n(Resources resources, Context context) {
        super(resources, C0120m.m524a("unmask"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0077n m238a(Resources resources, Context context) {
        C0077n c0077n = f327q.get(Thread.currentThread().getName());
        if (c0077n == null) {
            c0077n = new C0077n(resources, context);
            c0077n.m30a();
            f327q.put(Thread.currentThread().getName(), c0077n);
        }
        c0077n.m56a(context);
        return c0077n;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m239m() {
        f327q.evictAll();
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
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "source");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f328r);
        GLES20.glUniform1i(iGlGetUniformLocation, 0);
    }
}
