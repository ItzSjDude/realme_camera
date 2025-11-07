package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.o */
/* loaded from: classes.dex */
public class C0078o extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0078o> f329q = new LruCache<>(5);

    /* renamed from: r */
    public int f330r;

    /* renamed from: s */
    public int f331s;

    /* renamed from: t */
    public int f332t;

    /* renamed from: u */
    public float[] f333u;

    /* renamed from: v */
    public float[] f334v;

    /* renamed from: w */
    public float[] f335w;

    /* renamed from: x */
    public float[] f336x;

    public C0078o(Resources resources, Context context) {
        super(resources, C0120m.m524a("initialize_from_field"), context);
        this.f34o = C0120m.m524a("patchmatch_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0078o m240a(Resources resources, Context context) {
        C0078o c0078o = f329q.get(Thread.currentThread().getName());
        if (c0078o == null) {
            c0078o = new C0078o(resources, context);
            c0078o.m30a();
            f329q.put(Thread.currentThread().getName(), c0078o);
        }
        c0078o.m56a(context);
        return c0078o;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m241m() {
        f329q.evictAll();
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
        GLES20.glBindTexture(3553, this.f330r);
        GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f331s);
        GLES20.glUniform1i(iGlGetUniformLocation2, 1);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "field");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f332t);
        GLES20.glUniform1i(iGlGetUniformLocation3, 2);
        int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.f22b, "source_size");
        float[] fArr = this.f333u;
        GLES20.glUniform2f(iGlGetUniformLocation4, fArr[0], fArr[1]);
        int iGlGetUniformLocation5 = GLES20.glGetUniformLocation(this.f22b, "target_size");
        float[] fArr2 = this.f334v;
        GLES20.glUniform2f(iGlGetUniformLocation5, fArr2[0], fArr2[1]);
        int iGlGetUniformLocation6 = GLES20.glGetUniformLocation(this.f22b, "full_size");
        float[] fArr3 = this.f335w;
        GLES20.glUniform2f(iGlGetUniformLocation6, fArr3[0], fArr3[1]);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, TtmlNode.TAG_REGION), 1, false, this.f336x, 0);
    }
}
