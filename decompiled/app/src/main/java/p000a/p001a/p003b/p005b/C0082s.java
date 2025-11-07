package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.s */
/* loaded from: classes.dex */
public class C0082s extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0082s> f342q = new LruCache<>(5);

    /* renamed from: r */
    public float f343r;

    /* renamed from: s */
    public float[] f344s;

    /* renamed from: t */
    public float f345t;

    /* renamed from: u */
    public float f346u;

    public C0082s(Resources resources, Context context) {
        super(resources, C0120m.m524a("mask_brush"), context);
        this.f34o = C0120m.m524a("composite_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0082s m244a(Resources resources, Context context) {
        C0082s c0082s = f342q.get(Thread.currentThread().getName());
        if (c0082s == null) {
            c0082s = new C0082s(resources, context);
            c0082s.m30a();
            f342q.put(Thread.currentThread().getName(), c0082s);
        }
        c0082s.m56a(context);
        return c0082s;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m245m() {
        f342q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "brushTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.paintTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "invert"), this.f343r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f345t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "alpha"), this.f346u);
        if (this.f344s != null) {
            GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, "channel"), 1, this.f344s, 0);
        }
    }
}
