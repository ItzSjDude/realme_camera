package a_renamed.a_renamed.b_renamed.c_renamed;

/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public javax.microedition.khronos.egl.EGL10 f31a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public javax.microedition.khronos.egl.EGLDisplay f32b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public javax.microedition.khronos.egl.EGLConfig f33c;
    public javax.microedition.khronos.egl.EGLSurface d_renamed;
    public javax.microedition.khronos.egl.EGLContext e_renamed;
    public java.lang.Object g_renamed;
    public int f_renamed = 1;
    public int h_renamed = 8;
    public int i_renamed = 8;
    public int j_renamed = 8;
    public int k_renamed = 8;
    public int l_renamed = 0;
    public int m_renamed = 4;
    public javax.microedition.khronos.egl.EGLContext n_renamed = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;

    public int a_renamed(int i_renamed, int i2) {
        int[] iArr = {12324, this.h_renamed, 12323, this.i_renamed, 12322, this.j_renamed, 12321, this.k_renamed, 12325, this.l_renamed, 12352, this.m_renamed, 12344};
        this.f31a = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
        this.f32b = this.f31a.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
        this.f31a.eglInitialize(this.f32b, new int[2]);
        int[] iArr2 = new int[1];
        this.f31a.eglChooseConfig(this.f32b, iArr, null, 0, iArr2);
        if (iArr2[0] == 0) {
            return -1;
        }
        javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[iArr2[0]];
        this.f31a.eglChooseConfig(this.f32b, iArr, eGLConfigArr, iArr2[0], iArr2);
        this.f33c = eGLConfigArr[0];
        this.d_renamed = a_renamed(new int[]{12375, i_renamed, 12374, i2, 12344});
        this.e_renamed = this.f31a.eglCreateContext(this.f32b, this.f33c, this.n_renamed, new int[]{12440, 2, 12344});
        b_renamed();
        return this.f31a.eglGetError();
    }

    public final javax.microedition.khronos.egl.EGLSurface a_renamed(int[] iArr) {
        int i_renamed = this.f_renamed;
        return i_renamed != 2 ? i_renamed != 3 ? this.f31a.eglCreatePbufferSurface(this.f32b, this.f33c, iArr) : this.f31a.eglCreateWindowSurface(this.f32b, this.f33c, this.g_renamed, iArr) : this.f31a.eglCreatePixmapSurface(this.f32b, this.f33c, this.g_renamed, iArr);
    }

    public void a_renamed() {
        javax.microedition.khronos.egl.EGL10 egl10 = this.f31a;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.f32b;
        javax.microedition.khronos.egl.EGLSurface eGLSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
        this.f31a.eglDestroySurface(this.f32b, this.d_renamed);
        this.f31a.eglDestroyContext(this.f32b, this.e_renamed);
        this.f31a.eglTerminate(this.f32b);
    }

    public void b_renamed() {
        javax.microedition.khronos.egl.EGL10 egl10 = this.f31a;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.f32b;
        javax.microedition.khronos.egl.EGLSurface eGLSurface = this.d_renamed;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e_renamed);
    }
}
