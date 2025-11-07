package p000a.p001a.p003b.p009e;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class C0104c extends C0103b {

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Surface f500c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f501d;

    public C0104c(C0102a c0102a, SurfaceTexture surfaceTexture) {
        super(c0102a);
        m450a(surfaceTexture);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m453d() {
        m451b();
        Surface surface = this.f500c;
        if (surface != null) {
            if (this.f501d) {
                surface.release();
            }
            this.f500c = null;
        }
    }
}
