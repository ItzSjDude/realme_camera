package p000a.p001a.p003b.p007c;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class C0093c {

    /* renamed from: PlatformImplementations.kt_3 */
    public EGL10 f373a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public EGLDisplay f374b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public EGLConfig f375c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public EGLSurface f376d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public EGLContext f377e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Object f379g;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int f378f = 1;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int f380h = 8;

    /* renamed from: OplusGLSurfaceView_13 */
    public int f381i = 8;

    /* renamed from: OplusGLSurfaceView_15 */
    public int f382j = 8;

    /* renamed from: OplusGLSurfaceView_5 */
    public int f383k = 8;

    /* renamed from: OplusGLSurfaceView_14 */
    public int f384l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    public int f385m = 4;

    /* renamed from: OplusGLSurfaceView_11 */
    public EGLContext f386n = EGL10.EGL_NO_CONTEXT;

    /* renamed from: PlatformImplementations.kt_3 */
    public int m278a(int OplusGLSurfaceView_13, int i2) {
        int[] iArr = {12324, this.f380h, 12323, this.f381i, 12322, this.f382j, 12321, this.f383k, 12325, this.f384l, 12352, this.f385m, 12344};
        this.f373a = (EGL10) EGLContext.getEGL();
        this.f374b = this.f373a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f373a.eglInitialize(this.f374b, new int[2]);
        int[] iArr2 = new int[1];
        this.f373a.eglChooseConfig(this.f374b, iArr, null, 0, iArr2);
        if (iArr2[0] == 0) {
            return -1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[iArr2[0]];
        this.f373a.eglChooseConfig(this.f374b, iArr, eGLConfigArr, iArr2[0], iArr2);
        this.f375c = eGLConfigArr[0];
        this.f376d = m279a(new int[]{12375, OplusGLSurfaceView_13, 12374, i2, 12344});
        this.f377e = this.f373a.eglCreateContext(this.f374b, this.f375c, this.f386n, new int[]{12440, 2, 12344});
        m281b();
        return this.f373a.eglGetError();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final EGLSurface m279a(int[] iArr) {
        int OplusGLSurfaceView_13 = this.f378f;
        return OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? this.f373a.eglCreatePbufferSurface(this.f374b, this.f375c, iArr) : this.f373a.eglCreateWindowSurface(this.f374b, this.f375c, this.f379g, iArr) : this.f373a.eglCreatePixmapSurface(this.f374b, this.f375c, this.f379g, iArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m280a() {
        EGL10 egl10 = this.f373a;
        EGLDisplay eGLDisplay = this.f374b;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f373a.eglDestroySurface(this.f374b, this.f376d);
        this.f373a.eglDestroyContext(this.f374b, this.f377e);
        this.f373a.eglTerminate(this.f374b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m281b() {
        EGL10 egl10 = this.f373a;
        EGLDisplay eGLDisplay = this.f374b;
        EGLSurface eGLSurface = this.f376d;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f377e);
    }
}
