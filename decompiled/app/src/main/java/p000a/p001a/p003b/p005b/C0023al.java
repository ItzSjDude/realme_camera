package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.al */
/* loaded from: classes.dex */
public class C0023al extends C0009b {
    public C0023al(Resources resources, Context context) {
        super(resources, C0120m.m524a("denoise"), context);
        this.f34o = C0120m.m524a("distortion_vertex");
        m58a(new String[]{"color_denoise", "luminance_denoise"});
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo50e() {
        super.mo50e();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.denoiseTexture.f387a);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f21a.dehazeTexture.f387a);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f22b, "denoiseMap"), 1);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f22b, "dehazeMap"), 2);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
    }
}
