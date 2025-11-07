package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bx */
/* loaded from: classes.dex */
public class C0062bx extends C0009b {
    public C0062bx(Resources resources, Context context) {
        super(resources, C0120m.m524a("sharpen"), context);
        this.f34o = C0120m.m524a("sharpen_vertex");
        m58a(new String[]{"sharpen"});
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, "step");
        Context context = this.f21a;
        C0094d c0094d = context.imageTexture;
        float COUIBaseListPopupWindow_12 = context.zoom;
        GLES20.glUniform2f(iGlGetUniformLocation, (1.0f / c0094d.f388b) * COUIBaseListPopupWindow_12, (1.0f / c0094d.f389c) * COUIBaseListPopupWindow_12);
    }
}
