package com.b_renamed.a_renamed;

/* compiled from: ModelSurfaceView.java */
/* loaded from: classes.dex */
public class e_renamed extends android.view.SurfaceView {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.String f2345c = "e_renamed";

    /* renamed from: a_renamed, reason: collision with root package name */
    public com.b_renamed.a_renamed.k_renamed f2346a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f2347b;
    private com.b_renamed.a_renamed.c_renamed d_renamed;
    private com.b_renamed.a_renamed.d_renamed e_renamed;
    private com.b_renamed.a_renamed.e_renamed.a_renamed f_renamed;
    private com.b_renamed.a_renamed.l_renamed g_renamed;
    private int h_renamed;
    private int i_renamed;
    private float j_renamed;
    private android.view.Surface k_renamed;
    private boolean l_renamed;
    private android.os.ConditionVariable m_renamed;
    private java.util.concurrent.atomic.AtomicBoolean n_renamed;
    private java.util.concurrent.atomic.AtomicBoolean o_renamed;

    public e_renamed(com.b_renamed.a_renamed.c_renamed cVar, android.view.Surface surface, int i_renamed, int i2, com.b_renamed.a_renamed.k_renamed kVar) throws java.lang.IllegalAccessException, java.io.IOException {
        super(cVar.f2338c);
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0.75f;
        this.k_renamed = null;
        this.l_renamed = false;
        this.m_renamed = new android.os.ConditionVariable(false);
        this.n_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.o_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.f2347b = 0;
        this.k_renamed = surface;
        this.h_renamed = i_renamed;
        this.i_renamed = i2;
        this.f2346a = kVar;
        try {
            com.b_renamed.a_renamed.b_renamed.d_renamed("ModelSurfaceView", "Loading [OpenGL 2] ModelSurfaceView...");
            this.d_renamed = cVar;
            this.e_renamed = new com.b_renamed.a_renamed.d_renamed(this);
        } catch (java.lang.Exception e_renamed) {
            com.b_renamed.a_renamed.b_renamed.a_renamed("ModelActivity", e_renamed.getMessage(), e_renamed);
            android.widget.Toast.makeText(cVar.f2338c, "Error loading shaders:\n_renamed" + e_renamed.getMessage(), 1).show();
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    public void setVideoResizeRatio(float f_renamed) {
        this.j_renamed = f_renamed;
    }

    public void a_renamed() {
        if (!this.n_renamed.get()) {
            this.f_renamed = new com.b_renamed.a_renamed.e_renamed.a_renamed();
            getHolder().addCallback(this.f_renamed);
        }
        this.l_renamed = false;
        if (this.k_renamed != null) {
            this.o_renamed.set(true);
            this.f_renamed.surfaceCreated(null);
        }
    }

    public void b_renamed() {
        this.f_renamed.a_renamed();
    }

    public void c_renamed() {
        com.b_renamed.a_renamed.b_renamed.c_renamed(f2345c, "onLoadComplete");
        this.m_renamed.open();
    }

    public void setTouchController(com.b_renamed.a_renamed.l_renamed lVar) {
        this.g_renamed = lVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return this.g_renamed.a_renamed(motionEvent);
        } catch (java.lang.Exception e_renamed) {
            com.b_renamed.a_renamed.b_renamed.a_renamed("ModelSurfaceView", "Exception: " + e_renamed.getMessage(), e_renamed);
            return false;
        }
    }

    public com.b_renamed.a_renamed.c_renamed getModelActivity() {
        return this.d_renamed;
    }

    public com.b_renamed.a_renamed.d_renamed getModelRenderer() {
        return this.e_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b_renamed(android.opengl.EGLSurface eGLSurface) {
        return (eGLSurface == null || eGLSurface == android.opengl.EGL14.EGL_NO_SURFACE) ? false : true;
    }

    /* compiled from: ModelSurfaceView.java */
    private class a_renamed extends java.lang.Thread implements android.view.SurfaceHolder.Callback {

        /* renamed from: a_renamed, reason: collision with root package name */
        int[] f2348a;

        /* renamed from: c_renamed, reason: collision with root package name */
        private volatile boolean f2350c;

        private a_renamed() {
            this.f2350c = false;
            this.f2348a = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 5, 12610, 1, 12325, 24, 12344};
        }

        android.opengl.EGLConfig a_renamed(android.opengl.EGLDisplay eGLDisplay) {
            android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
            android.opengl.EGL14.eglChooseConfig(eGLDisplay, this.f2348a, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[]{0}, 0);
            return eGLConfigArr[0];
        }

        public void a_renamed() {
            this.f2350c = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (com.b_renamed.a_renamed.e_renamed.this.n_renamed.get()) {
                return;
            }
            if (com.b_renamed.a_renamed.e_renamed.this.e_renamed != null) {
                if (com.b_renamed.a_renamed.e_renamed.this.k_renamed == null) {
                    throw new java.lang.RuntimeException("no output surface");
                }
                android.opengl.EGLDisplay eGLDisplayEglGetDisplay = android.opengl.EGL14.eglGetDisplay(0);
                int[] iArr = new int[2];
                android.opengl.EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
                android.opengl.EGLConfig eGLConfigA = a_renamed(eGLDisplayEglGetDisplay);
                android.opengl.EGLContext eGLContextEglCreateContext = android.opengl.EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfigA, android.opengl.EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                android.opengl.EGLSurface eGLSurfaceEglCreateWindowSurface = android.opengl.EGL14.eglCreateWindowSurface(eGLDisplayEglGetDisplay, eGLConfigA, com.b_renamed.a_renamed.e_renamed.this.k_renamed, new int[]{12344}, 0);
                android.opengl.EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, eGLContextEglCreateContext);
                com.b_renamed.a_renamed.e_renamed.this.e_renamed.onSurfaceCreated(null, null);
                if (!com.b_renamed.a_renamed.e_renamed.b_renamed(eGLSurfaceEglCreateWindowSurface)) {
                    throw new java.lang.RuntimeException("Failed to create surface");
                }
                org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(0.0f, 0.0f, 0.0f, 1.0f);
                com.b_renamed.a_renamed.e_renamed.this.n_renamed.set(true);
                com.b_renamed.a_renamed.b_renamed.c_renamed(com.b_renamed.a_renamed.e_renamed.f2345c, "render start --E_renamed");
                com.b_renamed.a_renamed.e_renamed.this.m_renamed.block();
                boolean zA = false;
                boolean z_renamed = false;
                long jCurrentTimeMillis = 0;
                int i_renamed = 0;
                boolean z2 = true;
                while (!this.f2350c && !zA) {
                    if (!com.b_renamed.a_renamed.e_renamed.this.l_renamed) {
                        if (com.b_renamed.a_renamed.e_renamed.this.o_renamed.get()) {
                            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(0, 0, com.b_renamed.a_renamed.e_renamed.this.h_renamed, com.b_renamed.a_renamed.e_renamed.this.i_renamed);
                            com.b_renamed.a_renamed.e_renamed.this.e_renamed.onSurfaceChanged(null, com.b_renamed.a_renamed.e_renamed.this.h_renamed, com.b_renamed.a_renamed.e_renamed.this.i_renamed);
                            com.b_renamed.a_renamed.e_renamed.this.o_renamed.set(false);
                        }
                        zA = com.b_renamed.a_renamed.e_renamed.this.e_renamed.a_renamed(null);
                        if (z2 && i_renamed == 0) {
                            z2 = false;
                        } else {
                            android.opengl.EGL14.eglSwapBuffers(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
                            if (!z_renamed && com.b_renamed.a_renamed.e_renamed.this.f2346a != null) {
                                com.b_renamed.a_renamed.b_renamed.c_renamed("SurfaceListener", "Calling onRenderStart on_renamed " + com.b_renamed.a_renamed.e_renamed.this.f2346a);
                                com.b_renamed.a_renamed.e_renamed.this.f2346a.a_renamed(com.b_renamed.a_renamed.e_renamed.this.k_renamed);
                                z_renamed = true;
                            }
                        }
                    }
                    if (com.b_renamed.a_renamed.e_renamed.this.f2346a != null && !com.b_renamed.a_renamed.e_renamed.this.f2346a.a_renamed(jCurrentTimeMillis)) {
                        break;
                    } else if (!zA) {
                        i_renamed++;
                        jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    }
                }
                if (com.b_renamed.a_renamed.e_renamed.this.f2346a != null) {
                    com.b_renamed.a_renamed.b_renamed.c_renamed("SurfaceListener", "Calling onRenderFinish on_renamed " + com.b_renamed.a_renamed.e_renamed.this.f2346a);
                    com.b_renamed.a_renamed.e_renamed.this.f2346a.b_renamed(com.b_renamed.a_renamed.e_renamed.this.k_renamed);
                }
                com.b_renamed.a_renamed.b_renamed.c_renamed(com.b_renamed.a_renamed.e_renamed.f2345c, "render end --X_renamed totalCount : " + i_renamed);
                android.opengl.EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_CONTEXT);
                android.opengl.EGL14.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
                android.opengl.EGL14.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
                com.b_renamed.a_renamed.e_renamed.this.n_renamed.set(false);
                android.opengl.EGL14.eglReleaseThread();
                android.opengl.EGL14.eglTerminate(eGLDisplayEglGetDisplay);
                org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.d_renamed();
                if (com.b_renamed.a_renamed.e_renamed.this.f2346a != null) {
                    com.b_renamed.a_renamed.e_renamed.this.f2346a.b_renamed((com.b_renamed.a_renamed.a_renamed.e_renamed) null);
                    return;
                }
                return;
            }
            throw new java.lang.RuntimeException("no renderer set");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            if (isAlive() || isInterrupted() || getState() == java.lang.Thread.State.TERMINATED) {
                return;
            }
            start();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i_renamed, int i2, int i3) {
            if (com.b_renamed.a_renamed.e_renamed.this.h_renamed != i2) {
                com.b_renamed.a_renamed.e_renamed.this.h_renamed = i2;
                com.b_renamed.a_renamed.e_renamed.this.o_renamed.set(true);
            }
            if (com.b_renamed.a_renamed.e_renamed.this.i_renamed != i3) {
                com.b_renamed.a_renamed.e_renamed.this.i_renamed = i3;
                com.b_renamed.a_renamed.e_renamed.this.o_renamed.set(true);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            interrupt();
            com.b_renamed.a_renamed.e_renamed.this.getHolder().removeCallback(this);
        }
    }
}
