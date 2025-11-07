package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.aq */
/* loaded from: classes.dex */
public class C0028aq extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0028aq> f130q = new LruCache<>(5);

    /* renamed from: r */
    public int f131r;

    /* renamed from: s */
    public float[] f132s;

    /* renamed from: t */
    public float[] f133t;

    /* renamed from: u */
    public float f134u;

    /* renamed from: v */
    public float[] f135v;

    public C0028aq(Resources resources, Context context) {
        super(resources, C0120m.m524a("initialize_field"), context);
        this.f34o = C0120m.m524a("patchmatch_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0028aq m116a(Resources resources, Context context) {
        C0028aq c0028aq = f130q.get(Thread.currentThread().getName());
        if (c0028aq == null) {
            c0028aq = new C0028aq(resources, context);
            c0028aq.m30a();
            f130q.put(Thread.currentThread().getName(), c0028aq);
        }
        c0028aq.m56a(context);
        return c0028aq;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m117m() {
        f130q.evictAll();
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
        GLES20.glBindTexture(3553, this.f131r);
        GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "source_size");
        float[] fArr = this.f132s;
        GLES20.glUniform2f(iGlGetUniformLocation2, fArr[0], fArr[1]);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "full_size");
        float[] fArr2 = this.f133t;
        GLES20.glUniform2f(iGlGetUniformLocation3, fArr2[0], fArr2[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "seed"), this.f134u);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, TtmlNode.TAG_REGION), 1, false, this.f135v, 0);
    }
}
