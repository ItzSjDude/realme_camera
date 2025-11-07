package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bl */
/* loaded from: classes.dex */
public class C0050bl extends C0009b {

    /* renamed from: q */
    public static LruCache<String, C0050bl> f221q = new LruCache<>(5);

    /* renamed from: r */
    public float[] f222r;

    public C0050bl(Resources resources, Context context) {
        super(resources, C0120m.m524a(CameraStatisticsUtil.PORTRAIT_BLUR), context);
        m58a(new String[]{CameraStatisticsUtil.PORTRAIT_BLUR});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0050bl m164a(Resources resources, Context context) {
        C0050bl c0050bl = f221q.get(Thread.currentThread().getName());
        if (c0050bl == null) {
            c0050bl = new C0050bl(resources, context);
            c0050bl.m30a();
            f221q.put(Thread.currentThread().getName(), c0050bl);
        }
        c0050bl.m56a(context);
        return c0050bl;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m165m() {
        f221q.evictAll();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "delta");
        float[] fArr = this.f222r;
        GLES20.glUniform2fv(iGlGetUniformLocation, fArr.length / 2, fArr, 0);
    }
}
