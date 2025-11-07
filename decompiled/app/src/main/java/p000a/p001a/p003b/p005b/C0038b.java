package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.utils.AnimationJson;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class C0038b extends C0009b {

    /* renamed from: q */
    public float f170q;

    /* renamed from: r */
    public float f171r;

    /* renamed from: s */
    public int f172s;

    /* renamed from: t */
    public float[] f173t;

    public C0038b(Resources resources, Context context) {
        super(resources, C0120m.m524a("paint_overlay"), context);
        this.f170q = 1.0f;
        this.f171r = 1.0f;
        this.f172s = 0;
        this.f173t = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        m55k();
        mo23j();
        mo50e();
        mo53h();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f22b, AnimationJson.BLENDING_MODE_OVERLAY);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f172s);
        GLES20.glUniform1i(iGlGetUniformLocation, 1);
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, "overlayMask"), 1, this.f173t, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f170q);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "overlayMix"), this.f171r);
    }
}
