package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.Map;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.p */
/* loaded from: classes.dex */
public class C0079p extends C0009b {

    /* renamed from: q */
    public String f337q;

    public C0079p(Resources resources, Context context) {
        super(resources, C0120m.m524a("mosaic"), context);
        this.f337q = "square";
        this.f34o = C0120m.m524a("composite_vertex");
        m58a(new String[]{"mosaic_size"});
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        float fSqrt;
        Map<String, C0094d> map;
        C0094d c0094d;
        Map<String, C0094d> map2;
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "blurTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f21a.denoiseTexture.f387a);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        if (this.f21a.renderStates.containsKey("mosaic_pattern")) {
            Object obj = this.f21a.renderStates.get("mosaic_pattern");
            if ((obj instanceof String) && (map2 = this.f21a.patterns) != null && map2.containsKey(obj)) {
                this.f337q = (String) obj;
            }
        }
        String str = this.f337q;
        if (str != null && (map = this.f21a.patterns) != null && (c0094d = map.get(str)) != null) {
            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f22b, "patternTexture");
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, c0094d.f387a);
            GLES20.glUniform1i(iGlGetUniformLocation2, 2);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f22b, "patternSize"), c0094d.f388b, c0094d.f389c);
        }
        if (this.f21a.isSDK) {
            int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f22b, "mosaic_size");
            Object objM462a = C0106f.m462a("mosaic_size", this.f21a.renderStates);
            if (objM462a != null) {
                double IntrinsicsJvm.kt_5 = Float.parseFloat(objM462a.toString());
                C0094d c0094d2 = this.f21a.imageTexture;
                fSqrt = (float) (IntrinsicsJvm.kt_5 * Math.sqrt((c0094d2.f388b * c0094d2.f389c) / 2073600.0f));
            } else {
                fSqrt = 0.0f;
            }
            GLES20.glUniform1f(iGlGetUniformLocation3, fSqrt);
        }
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
        int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d3 = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation4, c0094d3.f388b, c0094d3.f389c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_amount"), ((Float) C0106f.m462a("distortion_amount", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_horizontal"), ((Float) C0106f.m462a("distortion_horizontal", this.f21a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "distortion_vertical"), ((Float) C0106f.m462a("distortion_vertical", this.f21a.renderStates)).floatValue());
    }
}
