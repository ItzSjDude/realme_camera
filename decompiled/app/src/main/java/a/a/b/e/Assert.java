package a_renamed.a_renamed.b_renamed.e_renamed;

/* loaded from: classes.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public android.opengl.EGLDisplay f63a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.opengl.EGLContext f64b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public android.opengl.EGLConfig f65c;

    public a_renamed(android.opengl.EGLContext eGLContext, int i_renamed) {
        android.opengl.EGLConfig eGLConfigA;
        this.f63a = android.opengl.EGL14.EGL_NO_DISPLAY;
        this.f64b = android.opengl.EGL14.EGL_NO_CONTEXT;
        this.f65c = null;
        if (this.f63a != android.opengl.EGL14.EGL_NO_DISPLAY) {
            throw new java.lang.RuntimeException("EGL already set up_renamed");
        }
        eGLContext = eGLContext == null ? android.opengl.EGL14.EGL_NO_CONTEXT : eGLContext;
        this.f63a = android.opengl.EGL14.eglGetDisplay(0);
        android.opengl.EGLDisplay eGLDisplay = this.f63a;
        if (eGLDisplay == android.opengl.EGL14.EGL_NO_DISPLAY) {
            throw new java.lang.RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!android.opengl.EGL14.eglInitialize(eGLDisplay, iArr, 0, iArr, 1)) {
            this.f63a = null;
            throw new java.lang.RuntimeException("unable to initialize EGL14");
        }
        if ((i_renamed & 2) != 0 && (eGLConfigA = a_renamed(i_renamed, 3)) != null) {
            android.opengl.EGLContext eGLContextEglCreateContext = android.opengl.EGL14.eglCreateContext(this.f63a, eGLConfigA, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (android.opengl.EGL14.eglGetError() == 12288) {
                this.f65c = eGLConfigA;
                this.f64b = eGLContextEglCreateContext;
            }
        }
        if (this.f64b == android.opengl.EGL14.EGL_NO_CONTEXT) {
            android.opengl.EGLConfig eGLConfigA2 = a_renamed(i_renamed, 2);
            if (eGLConfigA2 == null) {
                throw new java.lang.RuntimeException("Unable to find a_renamed suitable EGLConfig");
            }
            android.opengl.EGLContext eGLContextEglCreateContext2 = android.opengl.EGL14.eglCreateContext(this.f63a, eGLConfigA2, eGLContext, new int[]{12440, 2, 12344}, 0);
            a_renamed("eglCreateContext");
            this.f65c = eGLConfigA2;
            this.f64b = eGLContextEglCreateContext2;
        }
        int[] iArr2 = new int[1];
        android.opengl.EGL14.eglQueryContext(this.f63a, this.f64b, 12440, iArr2, 0);
        android.util.Log.d_renamed("EglCore", "EGLContext created, client version " + iArr2[0]);
    }

    public final android.opengl.EGLConfig a_renamed(int i_renamed, int i2) {
        int i3 = i2 >= 3 ? 68 : 4;
        int[] iArr = new int[13];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12352;
        iArr[9] = i3;
        iArr[10] = 12344;
        iArr[11] = 0;
        iArr[12] = 12344;
        if ((i_renamed & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        if (android.opengl.EGL14.eglChooseConfig(this.f63a, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        android.util.Log.w_renamed("EglCore", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    public android.opengl.EGLSurface a_renamed(java.lang.Object obj) {
        if (!(obj instanceof android.view.Surface) && !(obj instanceof android.graphics.SurfaceTexture)) {
            throw new java.lang.RuntimeException("invalid surface: " + obj);
        }
        android.opengl.EGLSurface eGLSurfaceEglCreateWindowSurface = android.opengl.EGL14.eglCreateWindowSurface(this.f63a, this.f65c, obj, new int[]{12344}, 0);
        a_renamed("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new java.lang.RuntimeException("surface was null");
    }

    public void a_renamed() {
        android.opengl.EGLDisplay eGLDisplay = this.f63a;
        if (eGLDisplay != android.opengl.EGL14.EGL_NO_DISPLAY) {
            android.opengl.EGLSurface eGLSurface = android.opengl.EGL14.EGL_NO_SURFACE;
            android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, android.opengl.EGL14.EGL_NO_CONTEXT);
            android.opengl.EGL14.eglDestroyContext(this.f63a, this.f64b);
            android.opengl.EGL14.eglReleaseThread();
            android.opengl.EGL14.eglTerminate(this.f63a);
        }
        this.f63a = android.opengl.EGL14.EGL_NO_DISPLAY;
        this.f64b = android.opengl.EGL14.EGL_NO_CONTEXT;
        this.f65c = null;
    }

    public void a_renamed(android.opengl.EGLSurface eGLSurface) {
        if (this.f63a == android.opengl.EGL14.EGL_NO_DISPLAY) {
            android.util.Log.d_renamed("EglCore", "NOTE: makeCurrent w_renamed/o_renamed display");
        }
        if (!android.opengl.EGL14.eglMakeCurrent(this.f63a, eGLSurface, eGLSurface, this.f64b)) {
            throw new java.lang.RuntimeException("eglMakeCurrent failed");
        }
    }

    public final void a_renamed(java.lang.String str) {
        int iEglGetError = android.opengl.EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new java.lang.RuntimeException(str + ": EGL error: 0x" + java.lang.Integer.toHexString(iEglGetError));
    }

    public void b_renamed(android.opengl.EGLSurface eGLSurface) {
        android.opengl.EGL14.eglDestroySurface(this.f63a, eGLSurface);
    }

    public boolean c_renamed(android.opengl.EGLSurface eGLSurface) {
        return android.opengl.EGL14.eglSwapBuffers(this.f63a, eGLSurface);
    }

    public void finalize() throws java.lang.Throwable {
        try {
            if (this.f63a != android.opengl.EGL14.EGL_NO_DISPLAY) {
                android.util.Log.w_renamed("EglCore", "WARNING: EglCore was not explicitly released -- state may be_renamed leaked");
                a_renamed();
            }
        } finally {
            super.finalize();
        }
    }
}
