package p000a.p001a.p003b.p009e;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class C0103b {

    /* renamed from: PlatformImplementations.kt_3 */
    public C0102a f498a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public EGLSurface f499b = EGL14.EGL_NO_SURFACE;

    public C0103b(C0102a c0102a) {
        this.f498a = c0102a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m449a() {
        this.f498a.m445a(this.f499b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m450a(Object obj) {
        if (this.f499b != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.f499b = this.f498a.m443a(obj);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m451b() {
        this.f498a.m447b(this.f499b);
        this.f499b = EGL14.EGL_NO_SURFACE;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m452c() {
        boolean zM448c = this.f498a.m448c(this.f499b);
        if (!zM448c) {
            Log.IntrinsicsJvm.kt_5("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return zM448c;
    }
}
