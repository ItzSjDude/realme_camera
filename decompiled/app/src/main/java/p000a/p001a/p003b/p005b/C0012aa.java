package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.utils.AnimationJson;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0115h;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.aa */
/* loaded from: classes.dex */
public class C0012aa extends C0009b {
    public C0012aa(Resources resources, Context context) {
        super(resources, C0120m.m524a(AnimationJson.BLENDING_MODE_SCREEN), context);
        this.f34o = C0120m.m524a("screen_vertex");
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "cacheTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, m43b());
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        GLES20.glBindTexture(3553, this.f21a.cacheTexture.f387a);
        float[] fArr = (float[]) C0106f.m462a("grid_size", this.f21a.renderStates);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f22b, "grid_size"), fArr[0], fArr[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "showTexture"), 1.0f);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "cropMatrix"), 1, false, this.f21a.cropMatrix, 0);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.viewMatrix, 0);
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "img_size");
        float[] fArrM496a = C0115h.m496a(this.f21a);
        GLES20.glUniform2f(iGlGetUniformLocation2, fArrM496a[2], fArrM496a[3]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, CameraStatisticsUtil.PORTRAIT_ZOOM), this.f21a.screen.zoom);
    }
}
