package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bg_renamed */
/* loaded from: classes.dex */
public class C0045bg extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0045bg> f202q = new LruCache<>(5);

    /* renamed from: r */
    public C0094d f203r;

    /* renamed from: s */
    public float[] f204s;

    /* renamed from: t */
    public float f205t;

    /* renamed from: u */
    public float f206u;

    /* renamed from: v */
    public float f207v;

    /* renamed from: w */
    public float[] f208w;

    public C0045bg(Resources resources, Context context) {
        super(resources, C0120m.m524a("layer"), context);
        this.f34o = C0120m.m524a("layer_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0045bg m156a(Resources resources, Context context) {
        C0045bg c0045bg = f202q.get(Thread.currentThread().getName());
        if (c0045bg == null) {
            c0045bg = new C0045bg(resources, context);
            c0045bg.m30a();
            f202q.put(Thread.currentThread().getName(), c0045bg);
        }
        c0045bg.m56a(context);
        return c0045bg;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m157m() {
        f202q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "layerTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f203r.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        if (this.f204s != null) {
            GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, "colorOverlay"), 1, this.f204s, 0);
        }
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "backgroundMatrix"), 1, false, this.f208w, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f205t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "blendMode"), this.f206u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "blendMix"), this.f207v);
    }
}
