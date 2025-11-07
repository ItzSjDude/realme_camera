package com.oplus.camera.gl_renamed;

/* compiled from: OplusGLSurfaceView.java */
/* loaded from: classes2.dex */
public class q_renamed extends android.view.SurfaceView implements android.view.SurfaceHolder.Callback {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.gl_renamed.q_renamed.j_renamed f4647a = new com.oplus.camera.gl_renamed.q_renamed.j_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.q_renamed> f4648b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.Surface f4649c;
    private com.oplus.camera.gl_renamed.r_renamed d_renamed;
    private boolean e_renamed;
    private com.oplus.camera.gl_renamed.q_renamed.i_renamed f_renamed;
    private com.oplus.camera.gl_renamed.q_renamed.m_renamed g_renamed;
    private boolean h_renamed;
    private com.oplus.camera.gl_renamed.q_renamed.e_renamed i_renamed;
    private com.oplus.camera.gl_renamed.q_renamed.f_renamed j_renamed;
    private com.oplus.camera.gl_renamed.q_renamed.g_renamed k_renamed;
    private com.oplus.camera.gl_renamed.q_renamed.k_renamed l_renamed;
    private int m_renamed;
    private int n_renamed;
    private boolean o_renamed;
    private android.view.Surface p_renamed;

    /* compiled from: OplusGLSurfaceView.java */
    public interface e_renamed {
    }

    /* compiled from: OplusGLSurfaceView.java */
    public interface f_renamed {
        javax.microedition.khronos.egl.EGLContext a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig);

        void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext);
    }

    /* compiled from: OplusGLSurfaceView.java */
    public interface g_renamed {
        javax.microedition.khronos.egl.EGLSurface a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj);

        void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface);
    }

    /* compiled from: OplusGLSurfaceView.java */
    public interface k_renamed {
        javax.microedition.khronos.opengles.GL a_renamed(javax.microedition.khronos.opengles.GL gl_renamed);
    }

    /* compiled from: OplusGLSurfaceView.java */
    public interface m_renamed {
        void a_renamed(javax.microedition.khronos.opengles.GL10 gl10);

        void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2);

        void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig);
    }

    public q_renamed(android.content.Context context) {
        super(context);
        this.f4648b = new java.lang.ref.WeakReference<>(this);
        this.f4649c = null;
        this.d_renamed = null;
        this.e_renamed = false;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = false;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = true;
        this.p_renamed = null;
        b_renamed();
    }

    public q_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4648b = new java.lang.ref.WeakReference<>(this);
        this.f4649c = null;
        this.d_renamed = null;
        this.e_renamed = false;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = false;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = true;
        this.p_renamed = null;
        b_renamed();
    }

    protected void finalize() throws java.lang.Throwable {
        try {
            if (this.f_renamed != null) {
                this.f_renamed.h_renamed();
            }
        } finally {
            super.finalize();
        }
    }

    private void b_renamed() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(com.oplus.camera.gl_renamed.q_renamed.k_renamed kVar) {
        this.l_renamed = kVar;
    }

    public void setDebugFlags(int i2) {
        this.m_renamed = i2;
    }

    public int getDebugFlags() {
        return this.m_renamed;
    }

    public void setPreserveEGLContextOnPause(boolean z_renamed) {
        this.o_renamed = z_renamed;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.o_renamed;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.q_renamed.m_renamed mVar, java.lang.String str) {
        e_renamed();
        if (this.i_renamed == null) {
            this.i_renamed = new com.oplus.camera.gl_renamed.q_renamed.n_renamed(true);
        }
        if (this.j_renamed == null) {
            this.j_renamed = new com.oplus.camera.gl_renamed.q_renamed.c_renamed();
        }
        if (this.k_renamed == null) {
            this.k_renamed = new com.oplus.camera.gl_renamed.q_renamed.d_renamed();
        }
        this.g_renamed = mVar;
        this.f_renamed = new com.oplus.camera.gl_renamed.q_renamed.i_renamed(this.f4648b);
        if ("PreviewGLThread".equals(str)) {
            this.f_renamed.f4661a = true;
        } else {
            this.f_renamed.f4661a = false;
        }
        this.f_renamed.setName(str + this.f_renamed.getId());
        this.f_renamed.start();
    }

    public void setEGLContextFactory(com.oplus.camera.gl_renamed.q_renamed.f_renamed fVar) {
        e_renamed();
        this.j_renamed = fVar;
    }

    public void setEGLWindowSurfaceFactory(com.oplus.camera.gl_renamed.q_renamed.g_renamed gVar) {
        e_renamed();
        this.k_renamed = gVar;
    }

    public void setEGLConfigChooser(com.oplus.camera.gl_renamed.q_renamed.e_renamed eVar) {
        e_renamed();
        this.i_renamed = eVar;
    }

    public void setEGLConfigChooser(boolean z_renamed) {
        setEGLConfigChooser(new com.oplus.camera.gl_renamed.q_renamed.n_renamed(z_renamed));
    }

    public void a_renamed(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new com.oplus.camera.gl_renamed.q_renamed.b_renamed(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        e_renamed();
        this.n_renamed = i2;
    }

    public void setRenderMode(int i2) {
        this.f_renamed.a_renamed(i2);
    }

    public int getRenderMode() {
        return this.f_renamed.b_renamed();
    }

    public void a_renamed() {
        this.f_renamed.c_renamed();
    }

    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        this.f_renamed.d_renamed();
        com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "surfaceCreated");
    }

    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        this.f_renamed.e_renamed();
        com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "surfaceDestroyed");
    }

    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.f_renamed.a_renamed(i3, i4);
        com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "surfaceChanged, w_renamed: " + i3 + ", h_renamed: " + i4);
    }

    public void d_renamed() {
        this.f_renamed.f_renamed();
    }

    public void c_renamed() {
        this.f_renamed.g_renamed();
    }

    public void a_renamed(java.lang.Runnable runnable) {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        com.oplus.camera.gl_renamed.q_renamed.i_renamed iVar = this.f_renamed;
        if (threadCurrentThread == iVar) {
            runnable.run();
        } else {
            iVar.a_renamed(runnable);
        }
    }

    public void g_renamed() {
        com.oplus.camera.gl_renamed.q_renamed.i_renamed iVar = this.f_renamed;
        if (iVar == null || iVar.v_renamed == null || this.f_renamed.v_renamed.e_renamed == null) {
            return;
        }
        this.f_renamed.v_renamed.b_renamed(this.f_renamed.v_renamed.e_renamed);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h_renamed && this.g_renamed != null) {
            com.oplus.camera.gl_renamed.q_renamed.i_renamed iVar = this.f_renamed;
            int iB = iVar != null ? iVar.b_renamed() : 1;
            this.f_renamed = new com.oplus.camera.gl_renamed.q_renamed.i_renamed(this.f4648b);
            if (iB != 1) {
                this.f_renamed.a_renamed(iB);
            }
            this.f_renamed.start();
        }
        this.h_renamed = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        com.oplus.camera.gl_renamed.q_renamed.i_renamed iVar = this.f_renamed;
        if (iVar != null) {
            iVar.h_renamed();
        }
        this.h_renamed = true;
        super.onDetachedFromWindow();
    }

    /* compiled from: OplusGLSurfaceView.java */
    private class c_renamed implements com.oplus.camera.gl_renamed.q_renamed.f_renamed {
        private c_renamed() {
        }

        @Override // com.oplus.camera.gl_renamed.q_renamed.f_renamed
        public javax.microedition.khronos.egl.EGLContext a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            int[] iArr = {12440, com.oplus.camera.gl_renamed.q_renamed.this.n_renamed, 12344};
            javax.microedition.khronos.egl.EGLContext eGLContext = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
            if (com.oplus.camera.gl_renamed.q_renamed.this.n_renamed == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.oplus.camera.gl_renamed.q_renamed.f_renamed
        public void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            com.oplus.camera.e_renamed.f_renamed("GLSurfaceView", "destroyContext, display: " + eGLDisplay + " context: " + eGLContext);
            com.oplus.camera.gl_renamed.q_renamed.h_renamed.a_renamed("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    private static class d_renamed implements com.oplus.camera.gl_renamed.q_renamed.g_renamed {
        private d_renamed() {
        }

        @Override // com.oplus.camera.gl_renamed.q_renamed.g_renamed
        public javax.microedition.khronos.egl.EGLSurface a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (java.lang.IllegalArgumentException e_renamed) {
                com.oplus.camera.e_renamed.d_renamed("GLSurfaceView", "eglCreateWindowSurface", e_renamed);
                return null;
            }
        }

        @Override // com.oplus.camera.gl_renamed.q_renamed.g_renamed
        public void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    private abstract class a_renamed implements com.oplus.camera.gl_renamed.q_renamed.e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        protected int[] f4654a;

        public a_renamed(int[] iArr) {
            this.f4654a = null;
            this.f4654a = a_renamed(iArr);
        }

        private int[] a_renamed(int[] iArr) {
            if (com.oplus.camera.gl_renamed.q_renamed.this.n_renamed != 2 && com.oplus.camera.gl_renamed.q_renamed.this.n_renamed != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i_renamed = length - 1;
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i_renamed);
            iArr2[i_renamed] = 12352;
            if (com.oplus.camera.gl_renamed.q_renamed.this.n_renamed == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    private class b_renamed extends com.oplus.camera.gl_renamed.q_renamed.a_renamed {

        /* renamed from: c_renamed, reason: collision with root package name */
        protected int f4656c;
        protected int d_renamed;
        protected int e_renamed;
        protected int f_renamed;
        protected int g_renamed;
        protected int h_renamed;
        private int[] j_renamed;

        public b_renamed(int i_renamed, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i_renamed, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f4656c = 0;
            this.d_renamed = 0;
            this.e_renamed = 0;
            this.f_renamed = 0;
            this.g_renamed = 0;
            this.h_renamed = 0;
            this.j_renamed = null;
            this.j_renamed = new int[1];
            this.f4656c = i_renamed;
            this.d_renamed = i2;
            this.e_renamed = i3;
            this.f_renamed = i4;
            this.g_renamed = i5;
            this.h_renamed = i6;
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    private class n_renamed extends com.oplus.camera.gl_renamed.q_renamed.b_renamed {
        public n_renamed(boolean z_renamed) {
            super(8, 8, 8, 0, z_renamed ? 16 : 0, 0);
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    private static class h_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final int[] f4658a = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.q_renamed> f4659b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private javax.microedition.khronos.egl.EGL10 f4660c = null;
        private javax.microedition.khronos.egl.EGLDisplay d_renamed = null;
        private javax.microedition.khronos.egl.EGLSurface e_renamed = null;
        private javax.microedition.khronos.egl.EGLSurface f_renamed = null;
        private javax.microedition.khronos.egl.EGLConfig g_renamed = null;
        private javax.microedition.khronos.egl.EGLContext h_renamed = null;
        private javax.microedition.khronos.egl.EGLSurface i_renamed = null;

        public h_renamed(java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.q_renamed> weakReference) {
            this.f4659b = null;
            this.f4659b = weakReference;
        }

        public void a_renamed() {
            this.f4660c = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
            this.d_renamed = this.f4660c.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
            if (this.d_renamed == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) {
                throw new java.lang.RuntimeException("eglGetDisplay failed");
            }
            if (!this.f4660c.eglInitialize(this.d_renamed, new int[2])) {
                throw new java.lang.RuntimeException("eglInitialize failed");
            }
            com.oplus.camera.gl_renamed.q_renamed qVar = this.f4659b.get();
            if (qVar == null) {
                this.g_renamed = null;
                this.h_renamed = null;
            } else {
                javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[1];
                this.f4660c.eglChooseConfig(this.d_renamed, f4658a, eGLConfigArr, eGLConfigArr.length, new int[1]);
                this.g_renamed = eGLConfigArr[0];
                this.h_renamed = qVar.j_renamed.a_renamed(this.f4660c, this.d_renamed, this.g_renamed);
            }
            javax.microedition.khronos.egl.EGLContext eGLContext = this.h_renamed;
            if (eGLContext == null || eGLContext == javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT) {
                this.h_renamed = null;
                a_renamed("createContext");
            }
            com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "start, createContext: " + this.h_renamed + ", tid: " + java.lang.Thread.currentThread().getId());
            this.e_renamed = null;
            this.f_renamed = null;
        }

        public boolean b_renamed() {
            if (this.f4660c == null) {
                throw new java.lang.RuntimeException("egl not initialized");
            }
            if (this.d_renamed == null) {
                throw new java.lang.RuntimeException("eglDisplay not initialized");
            }
            if (this.g_renamed == null) {
                throw new java.lang.RuntimeException("mEglConfig not initialized");
            }
            g_renamed();
            com.oplus.camera.gl_renamed.q_renamed qVar = this.f4659b.get();
            if (qVar != null) {
                this.e_renamed = qVar.k_renamed.a_renamed(this.f4660c, this.d_renamed, this.g_renamed, qVar.getHolder());
            } else {
                this.e_renamed = null;
            }
            javax.microedition.khronos.egl.EGLSurface eGLSurface = this.e_renamed;
            if (eGLSurface == null || eGLSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                if (this.f4660c.eglGetError() == 12299) {
                    com.oplus.camera.e_renamed.f_renamed("GLSurfaceView", "createSurface, createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            javax.microedition.khronos.egl.EGL10 egl10 = this.f4660c;
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.d_renamed;
            javax.microedition.khronos.egl.EGLSurface eGLSurface2 = this.e_renamed;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.h_renamed)) {
                return true;
            }
            a_renamed("GLSurfaceView", "eglMakeCurrent", this.f4660c.eglGetError());
            return false;
        }

        public javax.microedition.khronos.egl.EGLSurface a_renamed(android.view.Surface surface) {
            com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "createOutputEGLSurface");
            if (this.f4660c == null) {
                throw new java.lang.RuntimeException("egl not initialized");
            }
            if (this.d_renamed == null) {
                throw new java.lang.RuntimeException("eglDisplay not initialized");
            }
            if (this.g_renamed == null) {
                throw new java.lang.RuntimeException("mEglConfig not initialized");
            }
            com.oplus.camera.gl_renamed.q_renamed qVar = this.f4659b.get();
            javax.microedition.khronos.egl.EGLSurface eGLSurfaceA = qVar != null ? qVar.k_renamed.a_renamed(this.f4660c, this.d_renamed, this.g_renamed, surface) : null;
            if (eGLSurfaceA == null || eGLSurfaceA == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                if (this.f4660c.eglGetError() == 12299) {
                    com.oplus.camera.e_renamed.f_renamed("GLSurfaceView", "createOutputEGLSurface, createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return null;
            }
            if (this.f4660c.eglMakeCurrent(this.d_renamed, eGLSurfaceA, eGLSurfaceA, this.h_renamed)) {
                return eGLSurfaceA;
            }
            a_renamed("GLSurfaceView", "eglMakeCurrent", this.f4660c.eglGetError());
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public javax.microedition.khronos.opengles.GL f_renamed() {
            javax.microedition.khronos.opengles.GL gl_renamed = this.h_renamed.getGL();
            com.oplus.camera.gl_renamed.q_renamed qVar = this.f4659b.get();
            if (qVar == null) {
                return gl_renamed;
            }
            if (qVar.l_renamed != null) {
                gl_renamed = qVar.l_renamed.a_renamed(gl_renamed);
            }
            if ((qVar.m_renamed & 3) != 0) {
                return android.opengl.GLDebugHelper.wrap(gl_renamed, (qVar.m_renamed & 1) != 0 ? 1 : 0, (qVar.m_renamed & 2) != 0 ? new com.oplus.camera.gl_renamed.q_renamed.l_renamed() : null);
            }
            return gl_renamed;
        }

        public int c_renamed() {
            com.oplus.camera.e_renamed.a_renamed("EGL10.eglSwapBuffers", "70pv_eglSwapBuffers", com.oplus.camera.d_renamed.d_renamed.longValue());
            if (!this.f4660c.eglSwapBuffers(this.d_renamed, this.e_renamed)) {
                com.oplus.camera.e_renamed.d_renamed("EGL10.eglSwapBuffers", "70pv_eglSwapBuffers");
                com.oplus.camera.e_renamed.a_renamed("EGL10.eglSwapBuffersError", "71pv_eglSwapBuffersError", com.oplus.camera.d_renamed.d_renamed.longValue());
                com.oplus.camera.e_renamed.d_renamed("EGL10.eglSwapBuffersError", "71pv_eglSwapBuffersError");
                return this.f4660c.eglGetError();
            }
            com.oplus.camera.e_renamed.d_renamed("EGL10.eglSwapBuffers", "70pv_eglSwapBuffers");
            return 12288;
        }

        public int a_renamed(javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.d_renamed;
            if (eGLDisplay == null || eGLSurface == null || this.f4660c.eglSwapBuffers(eGLDisplay, eGLSurface)) {
                return 12288;
            }
            return this.f4660c.eglGetError();
        }

        public void d_renamed() {
            g_renamed();
            c_renamed(this.f_renamed);
            this.f_renamed = null;
            c_renamed(this.i_renamed);
            this.i_renamed = null;
        }

        private void g_renamed() {
            javax.microedition.khronos.egl.EGLSurface eGLSurface = this.e_renamed;
            if (eGLSurface == null || eGLSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f4660c.eglMakeCurrent(this.d_renamed, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
            com.oplus.camera.gl_renamed.q_renamed qVar = this.f4659b.get();
            if (qVar != null) {
                qVar.k_renamed.a_renamed(this.f4660c, this.d_renamed, this.e_renamed);
            }
            this.e_renamed = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c_renamed(javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            if (eGLSurface == null || eGLSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f4660c.eglMakeCurrent(this.d_renamed, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
            com.oplus.camera.gl_renamed.q_renamed qVar = this.f4659b.get();
            if (qVar != null) {
                qVar.k_renamed.a_renamed(this.f4660c, this.d_renamed, eGLSurface);
            }
            com.oplus.camera.e_renamed.e_renamed("GLSurfaceView", "destroyOutputEGLSurfaceImp, error: " + this.f4660c.eglGetError());
        }

        public void e_renamed() {
            if (this.h_renamed != null) {
                com.oplus.camera.gl_renamed.q_renamed qVar = this.f4659b.get();
                if (qVar != null) {
                    com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "finish, destroyContext mEglContext: " + this.h_renamed);
                    qVar.j_renamed.a_renamed(this.f4660c, this.d_renamed, this.h_renamed);
                }
                this.h_renamed = null;
            }
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.d_renamed;
            if (eGLDisplay != null) {
                this.f4660c.eglTerminate(eGLDisplay);
                this.d_renamed = null;
            }
        }

        private void a_renamed(java.lang.String str) {
            a_renamed(str, this.f4660c.eglGetError());
        }

        public static void a_renamed(java.lang.String str, int i_renamed) {
            throw new java.lang.RuntimeException("error: " + i_renamed);
        }

        public static void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) {
            com.oplus.camera.e_renamed.e_renamed(str, "logEglErrorAsWarning, function: " + str2 + ", error: " + i_renamed);
        }

        public void b_renamed(javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            javax.microedition.khronos.egl.EGLContext eGLContext;
            if (this.e_renamed == null || eGLSurface == null || (eGLContext = this.h_renamed) == null || this.f4660c.eglMakeCurrent(this.d_renamed, eGLSurface, eGLSurface, eGLContext)) {
                return;
            }
            a_renamed("GLSurfaceView", "eglMakeCurrent", this.f4660c.eglGetError());
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    static class i_renamed extends java.lang.Thread {
        private int m_renamed;
        private int n_renamed;
        private int o_renamed;
        private boolean p_renamed;
        private boolean q_renamed;
        private java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.q_renamed> x_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        public boolean f4661a = false;

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f4662b = false;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f4663c = false;
        private boolean d_renamed = false;
        private boolean e_renamed = false;
        private boolean f_renamed = false;
        private boolean g_renamed = false;
        private boolean h_renamed = false;
        private boolean i_renamed = false;
        private boolean j_renamed = false;
        private boolean k_renamed = false;
        private boolean l_renamed = false;
        private boolean r_renamed = false;
        private java.util.ArrayList<java.lang.Runnable> s_renamed = new java.util.ArrayList<>();
        private boolean t_renamed = true;
        private java.lang.Runnable u_renamed = null;
        private com.oplus.camera.gl_renamed.q_renamed.h_renamed v_renamed = null;
        private boolean w_renamed = false;

        i_renamed(java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.q_renamed> weakReference) {
            this.m_renamed = 0;
            this.n_renamed = 0;
            this.o_renamed = 0;
            this.p_renamed = false;
            this.q_renamed = false;
            this.x_renamed = null;
            this.m_renamed = 0;
            this.n_renamed = 0;
            this.p_renamed = true;
            this.o_renamed = 1;
            this.q_renamed = false;
            this.x_renamed = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f4661a) {
                com.oplus.camera.perf.b_renamed.a_renamed("129", android.os.Process.myTid());
            }
            try {
                k_renamed();
                synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                    com.oplus.camera.gl_renamed.q_renamed.f4647a.a_renamed(this);
                }
            } catch (java.lang.InterruptedException unused) {
                synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                    com.oplus.camera.gl_renamed.q_renamed.f4647a.a_renamed(this);
                }
            } catch (java.lang.Throwable th) {
                synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                    com.oplus.camera.gl_renamed.q_renamed.f4647a.a_renamed(this);
                    throw th;
                }
            }
        }

        private void i_renamed() {
            if (this.j_renamed) {
                this.j_renamed = false;
                this.v_renamed.d_renamed();
            }
        }

        private void j_renamed() {
            com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "stopEglContextLocked");
            if (this.i_renamed) {
                this.v_renamed.e_renamed();
                this.i_renamed = false;
                com.oplus.camera.gl_renamed.q_renamed.f4647a.b_renamed(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:177:0x02ed A_renamed[Catch: all -> 0x0395, TryCatch #4 {all -> 0x0395, blocks: (B_renamed:8:0x0025, B_renamed:9:0x0029, B_renamed:95:0x0152, B_renamed:97:0x015a, B_renamed:99:0x0162, B_renamed:100:0x0166, B_renamed:107:0x0176, B_renamed:108:0x0177, B_renamed:109:0x017b, B_renamed:116:0x018e, B_renamed:118:0x0191, B_renamed:120:0x019d, B_renamed:123:0x01b9, B_renamed:125:0x01c0, B_renamed:126:0x01c5, B_renamed:129:0x01c9, B_renamed:132:0x01df, B_renamed:134:0x01e6, B_renamed:135:0x01eb, B_renamed:137:0x01ed, B_renamed:143:0x0214, B_renamed:147:0x0221, B_renamed:149:0x0227, B_renamed:154:0x0235, B_renamed:155:0x0242, B_renamed:166:0x0258, B_renamed:168:0x0266, B_renamed:170:0x0278, B_renamed:172:0x0286, B_renamed:174:0x028e, B_renamed:176:0x02aa, B_renamed:178:0x0305, B_renamed:180:0x0313, B_renamed:182:0x0325, B_renamed:184:0x032d, B_renamed:185:0x0344, B_renamed:186:0x0350, B_renamed:177:0x02ed, B_renamed:162:0x0251, B_renamed:145:0x021b, B_renamed:146:0x0220, B_renamed:199:0x0394, B_renamed:10:0x002a, B_renamed:12:0x002e, B_renamed:21:0x003f, B_renamed:23:0x0047, B_renamed:93:0x014f, B_renamed:24:0x0053, B_renamed:26:0x0059, B_renamed:28:0x0068, B_renamed:30:0x006c, B_renamed:32:0x0078, B_renamed:34:0x0081, B_renamed:36:0x0085, B_renamed:38:0x008a, B_renamed:40:0x008e, B_renamed:45:0x00a0, B_renamed:43:0x009a, B_renamed:46:0x00a3, B_renamed:48:0x00a7, B_renamed:50:0x00ab, B_renamed:52:0x00af, B_renamed:53:0x00b2, B_renamed:54:0x00bf, B_renamed:56:0x00c3, B_renamed:58:0x00c7, B_renamed:60:0x00d3, B_renamed:61:0x00e1, B_renamed:63:0x00e5, B_renamed:65:0x00ed, B_renamed:67:0x00f3, B_renamed:71:0x00fb, B_renamed:73:0x0101, B_renamed:75:0x010d, B_renamed:76:0x0114, B_renamed:77:0x0115, B_renamed:79:0x0119, B_renamed:81:0x011d, B_renamed:83:0x0125, B_renamed:85:0x0129, B_renamed:87:0x012d, B_renamed:89:0x013c, B_renamed:196:0x0387, B_renamed:194:0x037a, B_renamed:102:0x0168, B_renamed:103:0x0171, B_renamed:131:0x01d3, B_renamed:139:0x0202, B_renamed:141:0x0210, B_renamed:111:0x017d, B_renamed:112:0x0188, B_renamed:157:0x0244, B_renamed:158:0x024d, B_renamed:122:0x01a7), top: B_renamed:219:0x0025, inners: #0, #2, #3, #6, #7, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:186:0x0350 A_renamed[Catch: all -> 0x0395, TRY_LEAVE, TryCatch #4 {all -> 0x0395, blocks: (B_renamed:8:0x0025, B_renamed:9:0x0029, B_renamed:95:0x0152, B_renamed:97:0x015a, B_renamed:99:0x0162, B_renamed:100:0x0166, B_renamed:107:0x0176, B_renamed:108:0x0177, B_renamed:109:0x017b, B_renamed:116:0x018e, B_renamed:118:0x0191, B_renamed:120:0x019d, B_renamed:123:0x01b9, B_renamed:125:0x01c0, B_renamed:126:0x01c5, B_renamed:129:0x01c9, B_renamed:132:0x01df, B_renamed:134:0x01e6, B_renamed:135:0x01eb, B_renamed:137:0x01ed, B_renamed:143:0x0214, B_renamed:147:0x0221, B_renamed:149:0x0227, B_renamed:154:0x0235, B_renamed:155:0x0242, B_renamed:166:0x0258, B_renamed:168:0x0266, B_renamed:170:0x0278, B_renamed:172:0x0286, B_renamed:174:0x028e, B_renamed:176:0x02aa, B_renamed:178:0x0305, B_renamed:180:0x0313, B_renamed:182:0x0325, B_renamed:184:0x032d, B_renamed:185:0x0344, B_renamed:186:0x0350, B_renamed:177:0x02ed, B_renamed:162:0x0251, B_renamed:145:0x021b, B_renamed:146:0x0220, B_renamed:199:0x0394, B_renamed:10:0x002a, B_renamed:12:0x002e, B_renamed:21:0x003f, B_renamed:23:0x0047, B_renamed:93:0x014f, B_renamed:24:0x0053, B_renamed:26:0x0059, B_renamed:28:0x0068, B_renamed:30:0x006c, B_renamed:32:0x0078, B_renamed:34:0x0081, B_renamed:36:0x0085, B_renamed:38:0x008a, B_renamed:40:0x008e, B_renamed:45:0x00a0, B_renamed:43:0x009a, B_renamed:46:0x00a3, B_renamed:48:0x00a7, B_renamed:50:0x00ab, B_renamed:52:0x00af, B_renamed:53:0x00b2, B_renamed:54:0x00bf, B_renamed:56:0x00c3, B_renamed:58:0x00c7, B_renamed:60:0x00d3, B_renamed:61:0x00e1, B_renamed:63:0x00e5, B_renamed:65:0x00ed, B_renamed:67:0x00f3, B_renamed:71:0x00fb, B_renamed:73:0x0101, B_renamed:75:0x010d, B_renamed:76:0x0114, B_renamed:77:0x0115, B_renamed:79:0x0119, B_renamed:81:0x011d, B_renamed:83:0x0125, B_renamed:85:0x0129, B_renamed:87:0x012d, B_renamed:89:0x013c, B_renamed:196:0x0387, B_renamed:194:0x037a, B_renamed:102:0x0168, B_renamed:103:0x0171, B_renamed:131:0x01d3, B_renamed:139:0x0202, B_renamed:141:0x0210, B_renamed:111:0x017d, B_renamed:112:0x0188, B_renamed:157:0x0244, B_renamed:158:0x024d, B_renamed:122:0x01a7), top: B_renamed:219:0x0025, inners: #0, #2, #3, #6, #7, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:188:0x0364  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:189:0x0366  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:213:0x039b A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void k_renamed() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 937
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.gl_renamed.q_renamed.i_renamed.k_renamed():void");
        }

        private void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLSurface eGLSurface, int i_renamed) {
            this.v_renamed.b_renamed(eGLSurface);
            com.oplus.camera.gl_renamed.q_renamed qVar = this.x_renamed.get();
            if (qVar.d_renamed != null) {
                qVar.d_renamed.a_renamed(gl10, i_renamed);
            }
            this.v_renamed.a_renamed(eGLSurface);
        }

        public boolean a_renamed() {
            return this.i_renamed && this.j_renamed && l_renamed();
        }

        private boolean l_renamed() {
            return !this.e_renamed && this.f_renamed && !this.g_renamed && this.m_renamed > 0 && this.n_renamed > 0 && (this.p_renamed || this.o_renamed == 1);
        }

        public void a_renamed(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 1) {
                synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                    this.o_renamed = i_renamed;
                    com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                }
                return;
            }
            throw new java.lang.IllegalArgumentException("renderMode");
        }

        public int b_renamed() {
            int i_renamed;
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                i_renamed = this.o_renamed;
            }
            return i_renamed;
        }

        public void c_renamed() {
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                this.p_renamed = true;
                com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
            }
        }

        public void d_renamed() {
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                this.f_renamed = true;
                this.k_renamed = false;
                com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                while (this.h_renamed && !this.k_renamed && !this.f4663c) {
                    try {
                        com.oplus.camera.gl_renamed.q_renamed.f4647a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e_renamed() {
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                this.f_renamed = false;
                com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                while (!this.h_renamed && !this.f4663c) {
                    try {
                        com.oplus.camera.gl_renamed.q_renamed.f4647a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f_renamed() {
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                this.d_renamed = true;
                com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                while (!this.f4663c && !this.e_renamed) {
                    try {
                        com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "onPause, sGLThreadManager.wait");
                        com.oplus.camera.gl_renamed.q_renamed.f4647a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g_renamed() {
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                this.d_renamed = false;
                this.p_renamed = true;
                this.r_renamed = false;
                com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                while (!this.f4663c && this.e_renamed && !this.r_renamed) {
                    try {
                        com.oplus.camera.gl_renamed.q_renamed.f4647a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a_renamed(int i_renamed, int i2) {
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                this.m_renamed = i_renamed;
                this.n_renamed = i2;
                this.t_renamed = true;
                this.p_renamed = true;
                this.r_renamed = false;
                if (java.lang.Thread.currentThread() == this) {
                    return;
                }
                com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                while (!this.f4663c && !this.e_renamed && !this.r_renamed && a_renamed()) {
                    try {
                        com.oplus.camera.gl_renamed.q_renamed.f4647a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h_renamed() {
            synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "requestExitAndWait");
                this.f4662b = true;
                com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                while (!this.f4663c) {
                    try {
                        com.oplus.camera.gl_renamed.q_renamed.f4647a.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a_renamed(java.lang.Runnable runnable) {
            if (runnable != null) {
                synchronized (com.oplus.camera.gl_renamed.q_renamed.f4647a) {
                    this.s_renamed.add(runnable);
                    com.oplus.camera.gl_renamed.q_renamed.f4647a.notifyAll();
                }
                return;
            }
            throw new java.lang.IllegalArgumentException("r_renamed must not be_renamed null");
        }

        public void a_renamed(boolean z_renamed) {
            this.w_renamed = z_renamed;
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    static class l_renamed extends java.io.Writer {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.StringBuilder f4664a = new java.lang.StringBuilder();

        l_renamed() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a_renamed();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a_renamed();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i_renamed, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[i_renamed + i3];
                if (c2 == '\n_renamed') {
                    a_renamed();
                } else {
                    this.f4664a.append(c2);
                }
            }
        }

        private void a_renamed() {
            if (this.f4664a.length() > 0) {
                com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "flushBuilder, mBuilder: " + this.f4664a.toString());
                java.lang.StringBuilder sb = this.f4664a;
                sb.delete(0, sb.length());
            }
        }
    }

    private void e_renamed() {
        if (this.f_renamed != null) {
            throw new java.lang.IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void h_renamed() {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.gl_renamed.q_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.gl_renamed.q_renamed.this.f_renamed.v_renamed.c_renamed(com.oplus.camera.gl_renamed.q_renamed.this.f_renamed.v_renamed.f_renamed);
                com.oplus.camera.gl_renamed.q_renamed.this.f_renamed.v_renamed.f_renamed = null;
                if (com.oplus.camera.gl_renamed.q_renamed.this.f4649c != null) {
                    com.oplus.camera.gl_renamed.q_renamed.this.f4649c.release();
                    com.oplus.camera.gl_renamed.q_renamed.this.f4649c = null;
                }
            }
        });
    }

    public void i_renamed() {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.gl_renamed.q_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "destroyWatchOutputSurface");
                com.oplus.camera.gl_renamed.q_renamed.this.f_renamed.v_renamed.c_renamed(com.oplus.camera.gl_renamed.q_renamed.this.f_renamed.v_renamed.i_renamed);
                com.oplus.camera.gl_renamed.q_renamed.this.f_renamed.v_renamed.i_renamed = null;
                if (com.oplus.camera.gl_renamed.q_renamed.this.p_renamed != null) {
                    com.oplus.camera.gl_renamed.q_renamed.this.p_renamed.release();
                    com.oplus.camera.gl_renamed.q_renamed.this.p_renamed = null;
                }
            }
        });
    }

    public void setOutputRender(com.oplus.camera.gl_renamed.r_renamed rVar) {
        this.d_renamed = rVar;
    }

    public void j_renamed() {
        this.e_renamed = true;
    }

    public void k_renamed() {
        this.e_renamed = false;
    }

    public void setOutput(android.view.Surface surface) {
        this.f4649c = surface;
    }

    public void setWatchOutputSurface(final android.view.Surface surface) {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.gl_renamed.q_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("GLSurfaceView", "setWatchOutputSurface");
                com.oplus.camera.gl_renamed.q_renamed.this.p_renamed = surface;
            }
        });
    }

    public android.view.Surface getOutputSurface() {
        return this.f4649c;
    }

    /* compiled from: OplusGLSurfaceView.java */
    private static class j_renamed {
        private j_renamed() {
        }

        public synchronized void a_renamed(com.oplus.camera.gl_renamed.q_renamed.i_renamed iVar) {
            iVar.f4663c = true;
            notifyAll();
        }

        public void b_renamed(com.oplus.camera.gl_renamed.q_renamed.i_renamed iVar) {
            notifyAll();
        }
    }

    public void setPreventRenderByPause(boolean z_renamed) {
        com.oplus.camera.gl_renamed.q_renamed.i_renamed iVar = this.f_renamed;
        if (iVar != null) {
            iVar.a_renamed(z_renamed);
        }
    }
}
