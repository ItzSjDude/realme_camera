package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.Arrays;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0115h;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class C0074k extends C0009b {
    public C0074k(Resources resources, Context context) {
        super(resources, C0120m.m524a("vignette"), context);
        this.f34o = C0120m.m524a("composite_vertex");
        m58a(new String[]{"vignette_amount", "vignette_feather", "vignette_highlights", "vignette_roundness", "vignette_size"});
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "crop");
        float[] fArr = (float[]) C0106f.m462a("crop", this.f21a.renderStates);
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        fArrCopyOf[1] = (1.0f - fArrCopyOf[3]) - fArrCopyOf[1];
        GLES20.glUniform4fv(iGlGetUniformLocation, 1, fArrCopyOf, 0);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "rotationMatrix"), 1, false, this.f21a.rotation90MatrixInv, 0);
        float[] fArrM497b = C0115h.m497b(this.f21a);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f22b, "imgSize"), fArrM497b[0], fArrM497b[1]);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
    }
}
