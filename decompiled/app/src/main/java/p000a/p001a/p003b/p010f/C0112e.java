package p000a.p001a.p003b.p010f;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class C0112e {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f522a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int f523b;

    public C0112e(int OplusGLSurfaceView_13) {
        this.f523b = Math.max(1, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m472a() {
        int OplusGLSurfaceView_13 = this.f522a;
        if (OplusGLSurfaceView_13 == this.f523b) {
            this.f522a = 0;
            return true;
        }
        this.f522a = OplusGLSurfaceView_13 + 1;
        return false;
    }
}
