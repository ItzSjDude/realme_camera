package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class C0071h extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0071h> f313q = new LruCache<>(5);

    /* renamed from: r */
    public float[] f314r;

    /* renamed from: s */
    public float f315s;

    public C0071h(Resources resources, Context context) {
        super(resources, C0120m.m524a("fill"), context);
        this.f314r = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        this.f315s = 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0071h m229a(Resources resources, Context context) {
        C0071h c0071h = f313q.get(Thread.currentThread().getName());
        if (c0071h == null) {
            c0071h = new C0071h(resources, context);
            c0071h.m30a();
            f313q.put(Thread.currentThread().getName(), c0071h);
        }
        c0071h.m56a(context);
        return c0071h;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m230m() {
        f313q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, "fill_color"), 1, this.f314r, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "fill_blend"), this.f315s);
    }
}
