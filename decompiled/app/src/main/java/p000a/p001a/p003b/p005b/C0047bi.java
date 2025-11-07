package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bi */
/* loaded from: classes.dex */
public class C0047bi extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0047bi> f209q = new LruCache<>(5);

    /* renamed from: r */
    public int f210r;

    /* renamed from: s */
    public int f211s;

    /* renamed from: t */
    public int f212t;

    /* renamed from: u */
    public float[] f213u;

    /* renamed from: v */
    public float[] f214v;

    /* renamed from: w */
    public float[] f215w;

    public C0047bi(Resources resources, Context context) {
        super(resources, C0120m.m524a("maximization"), context);
        this.f34o = C0120m.m524a("patchmatch_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0047bi m158a(Resources resources, Context context) {
        C0047bi c0047bi = f209q.get(Thread.currentThread().getName());
        if (c0047bi == null) {
            c0047bi = new C0047bi(resources, context);
            c0047bi.m30a();
            f209q.put(Thread.currentThread().getName(), c0047bi);
        }
        c0047bi.m56a(context);
        return c0047bi;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m159m() {
        f209q.evictAll();
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
        GLES20.glBindTexture(3553, this.f210r);
        GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f211s);
        GLES20.glUniform1i(iGlGetUniformLocation2, 1);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "field");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f212t);
        GLES20.glUniform1i(iGlGetUniformLocation3, 2);
        int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.f22b, "target_size");
        float[] fArr = this.f213u;
        GLES20.glUniform2f(iGlGetUniformLocation4, fArr[0], fArr[1]);
        int iGlGetUniformLocation5 = GLES20.glGetUniformLocation(this.f22b, "full_size");
        float[] fArr2 = this.f214v;
        GLES20.glUniform2f(iGlGetUniformLocation5, fArr2[0], fArr2[1]);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, TtmlNode.TAG_REGION), 1, false, this.f215w, 0);
    }
}
