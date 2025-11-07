package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class C0073j extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0073j> f317q = new LruCache<>(5);

    /* renamed from: r */
    public int f318r;

    /* renamed from: s */
    public int f319s;

    /* renamed from: t */
    public int f320t;

    /* renamed from: u */
    public float[] f321u;

    /* renamed from: v */
    public float[] f322v;

    /* renamed from: w */
    public float[] f323w;

    /* renamed from: x */
    public float f324x;

    /* renamed from: y */
    public float[] f325y;

    public C0073j(Resources resources, Context context) {
        super(resources, C0120m.m524a("random_search"), context);
        this.f34o = C0120m.m524a("patchmatch_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0073j m233a(Resources resources, Context context) {
        C0073j c0073j = f317q.get(Thread.currentThread().getName());
        if (c0073j == null) {
            c0073j = new C0073j(resources, context);
            c0073j.m30a();
            f317q.put(Thread.currentThread().getName(), c0073j);
        }
        c0073j.m56a(context);
        return c0073j;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m234m() {
        f317q.evictAll();
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
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "target");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f318r);
        GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f319s);
        GLES20.glUniform1i(iGlGetUniformLocation2, 1);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "field");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f320t);
        GLES20.glUniform1i(iGlGetUniformLocation3, 2);
        int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.f22b, "source_size");
        float[] fArr = this.f321u;
        GLES20.glUniform2f(iGlGetUniformLocation4, fArr[0], fArr[1]);
        int iGlGetUniformLocation5 = GLES20.glGetUniformLocation(this.f22b, "target_size");
        float[] fArr2 = this.f322v;
        GLES20.glUniform2f(iGlGetUniformLocation5, fArr2[0], fArr2[1]);
        int iGlGetUniformLocation6 = GLES20.glGetUniformLocation(this.f22b, "full_size");
        float[] fArr3 = this.f323w;
        GLES20.glUniform2f(iGlGetUniformLocation6, fArr3[0], fArr3[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "seed"), this.f324x);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, TtmlNode.TAG_REGION), 1, false, this.f325y, 0);
    }
}
