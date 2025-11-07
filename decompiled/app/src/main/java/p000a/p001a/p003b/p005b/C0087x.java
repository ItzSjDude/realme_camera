package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.utils.AnimationJson;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.x */
/* loaded from: classes.dex */
public class C0087x extends C0009b {

    /* renamed from: q */
    public boolean f355q;

    /* renamed from: r */
    public float f356r;

    public C0087x(Resources resources, Context context) {
        super(resources, C0120m.m524a(AnimationJson.BLENDING_MODE_OVERLAY), context);
        this.f356r = 1.0f;
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
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, "overlayMask"), 1, this.f21a.overlayMask, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, "opacity"), this.f356r);
    }
}
