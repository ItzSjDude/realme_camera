package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class C0007a extends C0009b {

    /* renamed from: q */
    public float f19q;

    public C0007a(Resources resources, Context context) {
        super(resources, C0120m.m524a("lookup_export_filter"), context);
        this.f19q = 0.0f;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "lut_color_space"), this.f19q);
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "img_size");
        C0094d c0094d = this.f21a.imageTexture;
        GLES20.glUniform2f(iGlGetUniformLocation, c0094d.f388b, c0094d.f389c);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b
    /* renamed from: OplusGLSurfaceView_14 */
    public boolean mo24l() {
        return !this.f21a.isLutRender;
    }
}
