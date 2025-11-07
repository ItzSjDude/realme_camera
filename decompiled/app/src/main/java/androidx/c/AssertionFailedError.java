package androidx.c_renamed;

/* compiled from: EglWindowSurface.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.opengl.EGLDisplay f663a = android.opengl.EGL14.EGL_NO_DISPLAY;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.opengl.EGLContext f664b = android.opengl.EGL14.EGL_NO_CONTEXT;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.opengl.EGLSurface f665c = android.opengl.EGL14.EGL_NO_SURFACE;
    private android.opengl.EGLConfig[] d_renamed = new android.opengl.EGLConfig[1];
    private android.view.Surface e_renamed;
    private int f_renamed;
    private int g_renamed;

    public b_renamed(android.view.Surface surface) {
        if (surface == null) {
            throw new java.lang.NullPointerException();
        }
        this.e_renamed = surface;
        g_renamed();
    }

    private void g_renamed() {
        this.f663a = android.opengl.EGL14.eglGetDisplay(0);
        if (java.util.Objects.equals(this.f663a, android.opengl.EGL14.EGL_NO_DISPLAY)) {
            throw new java.lang.RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!android.opengl.EGL14.eglInitialize(this.f663a, iArr, 0, iArr, 1)) {
            this.f663a = null;
            throw new java.lang.RuntimeException("unable to initialize EGL14");
        }
        android.opengl.EGLDisplay eGLDisplay = this.f663a;
        android.opengl.EGLConfig[] eGLConfigArr = this.d_renamed;
        if (!android.opengl.EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            throw new java.lang.RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f664b = android.opengl.EGL14.eglCreateContext(this.f663a, this.d_renamed[0], android.opengl.EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        a_renamed("eglCreateContext");
        if (this.f664b == null) {
            throw new java.lang.RuntimeException("null context");
        }
        h_renamed();
        this.f_renamed = e_renamed();
        this.g_renamed = f_renamed();
    }

    private void h_renamed() {
        this.f665c = android.opengl.EGL14.eglCreateWindowSurface(this.f663a, this.d_renamed[0], this.e_renamed, new int[]{12344}, 0);
        a_renamed("eglCreateWindowSurface");
        if (this.f665c == null) {
            throw new java.lang.RuntimeException("surface was null");
        }
    }

    public void a_renamed() {
        if (!java.util.Objects.equals(this.f663a, android.opengl.EGL14.EGL_NO_DISPLAY)) {
            android.opengl.EGL14.eglDestroySurface(this.f663a, this.f665c);
            android.opengl.EGL14.eglDestroyContext(this.f663a, this.f664b);
            android.opengl.EGL14.eglReleaseThread();
            android.opengl.EGL14.eglTerminate(this.f663a);
        }
        this.e_renamed.release();
        this.f663a = android.opengl.EGL14.EGL_NO_DISPLAY;
        this.f664b = android.opengl.EGL14.EGL_NO_CONTEXT;
        this.f665c = android.opengl.EGL14.EGL_NO_SURFACE;
        this.e_renamed = null;
    }

    public void b_renamed() {
        android.opengl.EGLDisplay eGLDisplay = this.f663a;
        android.opengl.EGLSurface eGLSurface = this.f665c;
        if (!android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f664b)) {
            throw new java.lang.RuntimeException("eglMakeCurrent failed");
        }
    }

    public void c_renamed() {
        if (!android.opengl.EGL14.eglMakeCurrent(this.f663a, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_CONTEXT)) {
            throw new java.lang.RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean d_renamed() {
        return android.opengl.EGL14.eglSwapBuffers(this.f663a, this.f665c);
    }

    public int e_renamed() {
        int[] iArr = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.f663a, this.f665c, 12375, iArr, 0);
        return iArr[0];
    }

    public int f_renamed() {
        int[] iArr = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.f663a, this.f665c, 12374, iArr, 0);
        return iArr[0];
    }

    public void a_renamed(long j_renamed) {
        android.opengl.EGLExt.eglPresentationTimeANDROID(this.f663a, this.f665c, j_renamed);
    }

    private void a_renamed(java.lang.String str) {
        int iEglGetError = android.opengl.EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new java.lang.RuntimeException(str + ": EGL error: 0x" + java.lang.Integer.toHexString(iEglGetError));
    }
}
