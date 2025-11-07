package androidx.constraintlayout.p025a.p026a;

/* compiled from: ResolutionDimension.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class ResolutionDimension extends ResolutionNode {

    /* renamed from: PlatformImplementations.kt_3 */
    float f2346a = 0.0f;

    @Override // androidx.constraintlayout.p025a.p026a.ResolutionNode
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo2073b() {
        super.mo2073b();
        this.f2346a = 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2079a(int OplusGLSurfaceView_13) {
        if (this.f2348i == 0 || this.f2346a != OplusGLSurfaceView_13) {
            this.f2346a = OplusGLSurfaceView_13;
            if (this.f2348i == 1) {
                m2082e();
            }
            m2083f();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2080c() {
        this.f2348i = 2;
    }
}
