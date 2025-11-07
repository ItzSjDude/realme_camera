package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.ah */
/* loaded from: classes.dex */
public class C0019ah extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0019ah> f85q = new LruCache<>(5);

    /* renamed from: r */
    public int f86r;

    /* renamed from: s */
    public int f87s;

    /* renamed from: t */
    public int f88t;

    /* renamed from: u */
    public float[] f89u;

    /* renamed from: v */
    public float[] f90v;

    /* renamed from: w */
    public float[] f91w;

    /* renamed from: x */
    public float[] f92x;

    /* renamed from: y */
    public float f93y;

    /* renamed from: z */
    public float[] f94z;

    public C0019ah(Resources resources, Context context) {
        super(resources, C0120m.m524a("propagate"), context);
        this.f34o = C0120m.m524a("patchmatch_vertex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0019ah m103a(Resources resources, Context context) {
        C0019ah c0019ah = f85q.get(Thread.currentThread().getName());
        if (c0019ah == null) {
            c0019ah = new C0019ah(resources, context);
            c0019ah.m30a();
            f85q.put(Thread.currentThread().getName(), c0019ah);
        }
        c0019ah.m56a(context);
        return c0019ah;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m104m() {
        f85q.evictAll();
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
        GLES20.glBindTexture(3553, this.f86r);
        GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f87s);
        GLES20.glUniform1i(iGlGetUniformLocation2, 1);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "field");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f88t);
        GLES20.glUniform1i(iGlGetUniformLocation3, 2);
        int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.f22b, "source_size");
        float[] fArr = this.f89u;
        GLES20.glUniform2f(iGlGetUniformLocation4, fArr[0], fArr[1]);
        int iGlGetUniformLocation5 = GLES20.glGetUniformLocation(this.f22b, "target_size");
        float[] fArr2 = this.f90v;
        GLES20.glUniform2f(iGlGetUniformLocation5, fArr2[0], fArr2[1]);
        int iGlGetUniformLocation6 = GLES20.glGetUniformLocation(this.f22b, "field_size");
        float[] fArr3 = this.f91w;
        GLES20.glUniform2f(iGlGetUniformLocation6, fArr3[0], fArr3[1]);
        int iGlGetUniformLocation7 = GLES20.glGetUniformLocation(this.f22b, "full_size");
        float[] fArr4 = this.f92x;
        GLES20.glUniform2f(iGlGetUniformLocation7, fArr4[0], fArr4[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "jump"), this.f93y);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, TtmlNode.TAG_REGION), 1, false, this.f94z, 0);
    }
}
