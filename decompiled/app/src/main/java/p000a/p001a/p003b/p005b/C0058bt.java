package p000a.p001a.p003b.p005b;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import com.oplus.ocs.camera.CameraParameter;
import p000a.p001a.p003b.p005b.p006a.C0009b;
import p000a.p001a.p003b.p010f.C0120m;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.bt */
/* loaded from: classes.dex */
public class C0058bt extends C0009b {

    /* renamed from: q */
    public float f283q;

    /* renamed from: r */
    public float f284r;

    public C0058bt(Resources resources, Context context) {
        super(resources, C0120m.m524a("gausspyd"), context);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m212d(int OplusGLSurfaceView_13, int i2) {
        this.f283q = OplusGLSurfaceView_13;
        this.f284r = i2;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.C0009b, p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        super.mo23j();
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f22b, CameraParameter.WaterMarkParamKeys.SIZE), this.f283q, this.f284r);
    }
}
