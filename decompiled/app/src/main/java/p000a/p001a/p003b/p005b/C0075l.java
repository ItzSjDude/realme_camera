package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class C0075l extends C0009b {
    public C0075l(Resources resources, Context context) {
        super(resources, C0120m.m524a("grain"), context);
        this.f34o = C0120m.m524a("composite_vertex");
        m58a(new String[]{"grain_amount", "grain_size"});
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "scale"), this.f21a.zoom);
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "imgSize");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f22b, "viewMatrix"), 1, false, this.f21a.matrix, 0);
    }
}
