package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bk */
/* loaded from: classes.dex */
public class C0049bk extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0049bk> f217q = new LruCache<>(5);

    /* renamed from: r */
    public int f218r;

    /* renamed from: s */
    public int f219s;

    /* renamed from: t */
    public int f220t;

    public C0049bk(Resources resources, Context context) {
        super(resources, C0120m.m524a("paint_split"), context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0049bk m162a(Resources resources, Context context) {
        C0049bk c0049bk = f217q.get(Thread.currentThread().getName());
        if (c0049bk == null) {
            c0049bk = new C0049bk(resources, context);
            c0049bk.m30a();
            f217q.put(Thread.currentThread().getName(), c0049bk);
        }
        c0049bk.m56a(context);
        return c0049bk;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m163m() {
        f217q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f218r);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "prePainting");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f219s);
        GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "curBrush");
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f220t);
        GLES20.glUniform1i(iGlGetUniformLocation3, 3);
    }
}
