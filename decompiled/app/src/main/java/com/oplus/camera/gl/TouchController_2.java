package com.oplus.camera.gl_renamed;

/* compiled from: GLProducer.java */
/* loaded from: classes2.dex */
public class m_renamed<T_renamed> {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.oplus.camera.gl_renamed.m_renamed.j_renamed f4625b = new com.oplus.camera.gl_renamed.m_renamed.j_renamed();

    /* renamed from: a_renamed, reason: collision with root package name */
    android.view.Choreographer.FrameCallback f4626a = new android.view.Choreographer.FrameCallback() { // from class: com.oplus.camera.gl_renamed.m_renamed.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            com.oplus.camera.gl_renamed.m_renamed.this.d_renamed();
            if (com.oplus.camera.gl_renamed.m_renamed.this.c_renamed() == 1) {
                android.view.Choreographer.getInstance().postFrameCallback(this);
            }
        }
    };

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.m_renamed> f4627c = new java.lang.ref.WeakReference<>(this);
    private com.oplus.camera.gl_renamed.m_renamed.i_renamed d_renamed;
    private com.oplus.camera.gl_renamed.m_renamed.GLProducer_6 e_renamed;
    private T_renamed f_renamed;
    private com.oplus.camera.gl_renamed.m_renamed.e_renamed g_renamed;
    private com.oplus.camera.gl_renamed.m_renamed.f_renamed h_renamed;
    private com.oplus.camera.gl_renamed.m_renamed.g_renamed i_renamed;
    private com.oplus.camera.gl_renamed.m_renamed.k_renamed j_renamed;
    private int k_renamed;
    private int l_renamed;
    private boolean m_renamed;

    /* compiled from: GLProducer.java */
    public interface e_renamed {
        javax.microedition.khronos.egl.EGLConfig a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay);
    }

    /* compiled from: GLProducer.java */
    public interface f_renamed {
        javax.microedition.khronos.egl.EGLContext a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig);

        void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext);
    }

    /* compiled from: GLProducer.java */
    public interface g_renamed {
        javax.microedition.khronos.egl.EGLSurface a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj);

        void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface);
    }

    /* compiled from: GLProducer.java */
    public interface k_renamed {
        javax.microedition.khronos.opengles.GL a_renamed(javax.microedition.khronos.opengles.GL gl_renamed);
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl_renamed.m_renamed$m_renamed, reason: collision with other inner class name */
    public interface GLProducer_6 {
        void a_renamed(javax.microedition.khronos.opengles.GL10 gl10);

        void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2);

        void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig);
    }

    public m_renamed(T_renamed t_renamed) {
        this.f_renamed = t_renamed;
    }

    public T_renamed a_renamed() {
        return this.f_renamed;
    }

    protected void finalize() throws java.lang.Throwable {
        try {
            if (this.d_renamed != null) {
                this.d_renamed.h_renamed();
            }
        } finally {
            super.finalize();
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.m_renamed.GLProducer_6 interfaceC0101m) {
        j_renamed();
        if (this.g_renamed == null) {
            this.g_renamed = new com.oplus.camera.gl_renamed.m_renamed.n_renamed(true);
        }
        if (this.h_renamed == null) {
            this.h_renamed = new com.oplus.camera.gl_renamed.m_renamed.c_renamed();
        }
        if (this.i_renamed == null) {
            this.i_renamed = new com.oplus.camera.gl_renamed.m_renamed.d_renamed();
        }
        this.e_renamed = interfaceC0101m;
        this.d_renamed = new com.oplus.camera.gl_renamed.m_renamed.i_renamed(this.f4627c);
        this.d_renamed.start();
    }

    public void a_renamed(com.oplus.camera.gl_renamed.m_renamed.e_renamed eVar) {
        j_renamed();
        this.g_renamed = eVar;
    }

    public void a_renamed(int i2, int i3, int i4, int i5, int i6, int i7) {
        a_renamed(new com.oplus.camera.gl_renamed.m_renamed.b_renamed(i2, i3, i4, i5, i6, i7));
    }

    public void a_renamed(int i2) {
        j_renamed();
        this.l_renamed = i2;
    }

    public void b_renamed(int i2) {
        this.d_renamed.a_renamed(i2);
    }

    public void b_renamed() {
        android.view.Choreographer.getInstance().removeFrameCallback(this.f4626a);
        android.view.Choreographer.getInstance().postFrameCallback(this.f4626a);
    }

    public int c_renamed() {
        return this.d_renamed.b_renamed();
    }

    public void d_renamed() {
        this.d_renamed.c_renamed();
    }

    public void a_renamed(android.view.SurfaceHolder surfaceHolder) {
        this.d_renamed.d_renamed();
    }

    public void b_renamed(android.view.SurfaceHolder surfaceHolder) {
        this.d_renamed.e_renamed();
    }

    public void a_renamed(android.view.SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.d_renamed.a_renamed(i3, i4);
    }

    public void e_renamed() {
        android.util.Log.d_renamed("GLProducer", "requestExitAndWait");
        com.oplus.camera.gl_renamed.m_renamed.i_renamed iVar = this.d_renamed;
        if (iVar != null) {
            iVar.h_renamed();
        }
    }

    public void f_renamed() {
        this.d_renamed.f_renamed();
        android.view.Choreographer.getInstance().removeFrameCallback(this.f4626a);
    }

    public void g_renamed() {
        this.d_renamed.g_renamed();
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.d_renamed.a_renamed(runnable);
    }

    public void h_renamed() {
        this.d_renamed.i_renamed();
    }

    /* compiled from: GLProducer.java */
    private class c_renamed implements com.oplus.camera.gl_renamed.m_renamed.f_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f4633b;

        private c_renamed() {
            this.f4633b = 12440;
        }

        @Override // com.oplus.camera.gl_renamed.m_renamed.f_renamed
        public javax.microedition.khronos.egl.EGLContext a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
            int[] iArr = {this.f4633b, com.oplus.camera.gl_renamed.m_renamed.this.l_renamed, 12344};
            javax.microedition.khronos.egl.EGLContext eGLContext = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
            if (com.oplus.camera.gl_renamed.m_renamed.this.l_renamed == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.oplus.camera.gl_renamed.m_renamed.f_renamed
        public void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            android.util.Log.e_renamed("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            com.oplus.camera.gl_renamed.m_renamed.h_renamed.a_renamed("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* compiled from: GLProducer.java */
    private static class d_renamed implements com.oplus.camera.gl_renamed.m_renamed.g_renamed {
        private d_renamed() {
        }

        @Override // com.oplus.camera.gl_renamed.m_renamed.g_renamed
        public javax.microedition.khronos.egl.EGLSurface a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, java.lang.Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (java.lang.IllegalArgumentException e_renamed) {
                android.util.Log.e_renamed("GLProducer", "eglCreateWindowSurface", e_renamed);
                return null;
            }
        }

        @Override // com.oplus.camera.gl_renamed.m_renamed.g_renamed
        public void a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLProducer.java */
    private abstract class a_renamed implements com.oplus.camera.gl_renamed.m_renamed.e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        protected int[] f4629a;

        abstract javax.microedition.khronos.egl.EGLConfig a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr);

        public a_renamed(int[] iArr) {
            this.f4629a = a_renamed(iArr);
        }

        @Override // com.oplus.camera.gl_renamed.m_renamed.e_renamed
        public javax.microedition.khronos.egl.EGLConfig a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f4629a, null, 0, iArr)) {
                throw new java.lang.IllegalArgumentException("eglChooseConfig failed");
            }
            int i_renamed = iArr[0];
            if (i_renamed <= 0) {
                throw new java.lang.IllegalArgumentException("No configs match configSpec");
            }
            javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[i_renamed];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f4629a, eGLConfigArr, i_renamed, iArr)) {
                throw new java.lang.IllegalArgumentException("eglChooseConfig#2 failed");
            }
            javax.microedition.khronos.egl.EGLConfig eGLConfigA = a_renamed(egl10, eGLDisplay, eGLConfigArr);
            if (eGLConfigA != null) {
                return eGLConfigA;
            }
            throw new java.lang.IllegalArgumentException("No config chosen");
        }

        private int[] a_renamed(int[] iArr) {
            if (com.oplus.camera.gl_renamed.m_renamed.this.l_renamed != 2 && com.oplus.camera.gl_renamed.m_renamed.this.l_renamed != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i_renamed = length - 1;
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i_renamed);
            iArr2[i_renamed] = 12352;
            if (com.oplus.camera.gl_renamed.m_renamed.this.l_renamed == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* compiled from: GLProducer.java */
    private class b_renamed extends com.oplus.camera.gl_renamed.m_renamed<T_renamed>.a_renamed {

        /* renamed from: c_renamed, reason: collision with root package name */
        protected int f4631c;
        protected int d_renamed;
        protected int e_renamed;
        protected int f_renamed;
        protected int g_renamed;
        protected int h_renamed;
        private int[] j_renamed;

        public b_renamed(int i_renamed, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i_renamed, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.j_renamed = new int[1];
            this.f4631c = i_renamed;
            this.d_renamed = i2;
            this.e_renamed = i3;
            this.f_renamed = i4;
            this.g_renamed = i5;
            this.h_renamed = i6;
        }

        @Override // com.oplus.camera.gl_renamed.m_renamed.a_renamed
        public javax.microedition.khronos.egl.EGLConfig a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
            for (javax.microedition.khronos.egl.EGLConfig eGLConfig : eGLConfigArr) {
                int iA = a_renamed(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int iA2 = a_renamed(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (iA >= this.g_renamed && iA2 >= this.h_renamed) {
                    int iA3 = a_renamed(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int iA4 = a_renamed(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int iA5 = a_renamed(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int iA6 = a_renamed(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (iA3 == this.f4631c && iA4 == this.d_renamed && iA5 == this.e_renamed && iA6 == this.f_renamed) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a_renamed(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i_renamed, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i_renamed, this.j_renamed) ? this.j_renamed[0] : i2;
        }
    }

    /* compiled from: GLProducer.java */
    private class n_renamed extends com.oplus.camera.gl_renamed.m_renamed<T_renamed>.b_renamed {
        public n_renamed(boolean z_renamed) {
            super(8, 8, 8, 0, z_renamed ? 16 : 0, 0);
        }
    }

    /* compiled from: GLProducer.java */
    private static class h_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        javax.microedition.khronos.egl.EGL10 f4634a;

        /* renamed from: b_renamed, reason: collision with root package name */
        javax.microedition.khronos.egl.EGLDisplay f4635b;

        /* renamed from: c_renamed, reason: collision with root package name */
        javax.microedition.khronos.egl.EGLSurface f4636c;
        javax.microedition.khronos.egl.EGLConfig d_renamed;
        javax.microedition.khronos.egl.EGLContext e_renamed;
        private java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.m_renamed> f_renamed;

        public h_renamed(java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.m_renamed> weakReference) {
            this.f_renamed = weakReference;
        }

        public void a_renamed() {
            android.util.Log.w_renamed("EglHelper", "start() tid=" + java.lang.Thread.currentThread().getId());
            this.f4634a = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
            this.f4635b = this.f4634a.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f4635b == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) {
                throw new java.lang.RuntimeException("eglGetDisplay failed");
            }
            if (!this.f4634a.eglInitialize(this.f4635b, new int[2])) {
                throw new java.lang.RuntimeException("eglInitialize failed");
            }
            com.oplus.camera.gl_renamed.m_renamed mVar = this.f_renamed.get();
            if (mVar != null) {
                this.d_renamed = mVar.g_renamed.a_renamed(this.f4634a, this.f4635b);
                this.e_renamed = mVar.h_renamed.a_renamed(this.f4634a, this.f4635b, this.d_renamed);
            } else {
                this.d_renamed = null;
                this.e_renamed = null;
            }
            if (this.e_renamed == null || javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT == this.e_renamed) {
                this.e_renamed = null;
                a_renamed("createContext");
            }
            android.util.Log.v_renamed("GLProducer", "createContext, mEglContext: " + this.e_renamed + " tid: " + java.lang.Thread.currentThread().getId());
            this.f4636c = null;
        }

        public boolean b_renamed() {
            android.util.Log.w_renamed("EglHelper", "createSurface()  tid=" + java.lang.Thread.currentThread().getId());
            if (this.f4634a == null) {
                throw new java.lang.RuntimeException("egl not initialized");
            }
            if (this.f4635b == null) {
                throw new java.lang.RuntimeException("eglDisplay not initialized");
            }
            if (this.d_renamed == null) {
                throw new java.lang.RuntimeException("mEglConfig not initialized");
            }
            g_renamed();
            com.oplus.camera.gl_renamed.m_renamed mVar = this.f_renamed.get();
            if (mVar != null) {
                this.f4636c = mVar.i_renamed.a_renamed(this.f4634a, this.f4635b, this.d_renamed, mVar.a_renamed());
            } else {
                this.f4636c = null;
            }
            if (this.f4636c != null) {
                javax.microedition.khronos.egl.EGLSurface eGLSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
                javax.microedition.khronos.egl.EGLSurface eGLSurface2 = this.f4636c;
                if (eGLSurface != eGLSurface2) {
                    if (this.f4634a.eglMakeCurrent(this.f4635b, eGLSurface2, eGLSurface2, this.e_renamed)) {
                        return true;
                    }
                    a_renamed("EGLHelper", "eglMakeCurrent", this.f4634a.eglGetError());
                    return false;
                }
            }
            if (this.f4634a.eglGetError() == 12299) {
                android.util.Log.e_renamed("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
            }
            return false;
        }

        javax.microedition.khronos.opengles.GL c_renamed() {
            javax.microedition.khronos.opengles.GL gl_renamed = this.e_renamed.getGL();
            com.oplus.camera.gl_renamed.m_renamed mVar = this.f_renamed.get();
            if (mVar == null) {
                return gl_renamed;
            }
            if (mVar.j_renamed != null) {
                gl_renamed = mVar.j_renamed.a_renamed(gl_renamed);
            }
            if ((mVar.k_renamed & 3) != 0) {
                return android.opengl.GLDebugHelper.wrap(gl_renamed, (mVar.k_renamed & 1) != 0 ? 1 : 0, (mVar.k_renamed & 2) != 0 ? new com.oplus.camera.gl_renamed.m_renamed.l_renamed() : null);
            }
            return gl_renamed;
        }

        public int d_renamed() {
            if (this.f4634a.eglSwapBuffers(this.f4635b, this.f4636c)) {
                return 12288;
            }
            return this.f4634a.eglGetError();
        }

        public void e_renamed() {
            android.util.Log.w_renamed("EglHelper", "destroySurface()  tid=" + java.lang.Thread.currentThread().getId());
            g_renamed();
        }

        private void g_renamed() {
            javax.microedition.khronos.egl.EGLSurface eGLSurface = this.f4636c;
            if (eGLSurface == null || eGLSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f4634a.eglMakeCurrent(this.f4635b, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
            com.oplus.camera.gl_renamed.m_renamed mVar = this.f_renamed.get();
            if (mVar != null) {
                mVar.i_renamed.a_renamed(this.f4634a, this.f4635b, this.f4636c);
            }
            this.f4636c = null;
        }

        public void f_renamed() {
            android.util.Log.w_renamed("EglHelper", "finish() tid=" + java.lang.Thread.currentThread().getId());
            if (this.e_renamed != null) {
                com.oplus.camera.gl_renamed.m_renamed mVar = this.f_renamed.get();
                if (mVar != null) {
                    android.util.Log.v_renamed("GLProducer", "finish, destroyContext mEglContext: " + this.e_renamed);
                    mVar.h_renamed.a_renamed(this.f4634a, this.f4635b, this.e_renamed);
                }
                this.e_renamed = null;
            }
            javax.microedition.khronos.egl.EGLDisplay eGLDisplay = this.f4635b;
            if (eGLDisplay != null) {
                this.f4634a.eglTerminate(eGLDisplay);
                this.f4635b = null;
            }
        }

        private void a_renamed(java.lang.String str) {
            a_renamed(str, this.f4634a.eglGetError());
        }

        public static void a_renamed(java.lang.String str, int i_renamed) {
            throw new java.lang.RuntimeException(b_renamed(str, i_renamed));
        }

        public static void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) {
            android.util.Log.w_renamed(str, b_renamed(str2, i_renamed));
        }

        public static java.lang.String b_renamed(java.lang.String str, int i_renamed) {
            return str + " failed: " + com.oplus.camera.gl_renamed.m_renamed.e_renamed(i_renamed);
        }
    }

    private static java.lang.String d_renamed(int i2) {
        return "0x" + java.lang.Integer.toHexString(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String e_renamed(int i2) {
        switch (i2) {
            case 12288:
                return "EGL_SUCCESS";
            case com.sensetime.blur.BlurFilterLibrary.ST_BLUR_PARAM_TYPE_EFFECT_TYPE /* 12289 */:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return d_renamed(i2);
        }
    }

    /* compiled from: GLProducer.java */
    static class i_renamed extends java.lang.Thread {

        /* renamed from: a_renamed, reason: collision with root package name */
        private boolean f4637a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f4638b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f4639c;
        private boolean d_renamed;
        private boolean e_renamed;
        private boolean f_renamed;
        private boolean g_renamed;
        private boolean h_renamed;
        private boolean i_renamed;
        private boolean j_renamed;
        private boolean k_renamed;
        private boolean q_renamed;
        private com.oplus.camera.gl_renamed.m_renamed.h_renamed t_renamed;
        private java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.m_renamed> u_renamed;
        private java.util.ArrayList<java.lang.Runnable> r_renamed = new java.util.ArrayList<>();
        private boolean s_renamed = true;
        private int l_renamed = 0;
        private int m_renamed = 0;
        private boolean o_renamed = true;
        private int n_renamed = 1;
        private boolean p_renamed = false;

        i_renamed(java.lang.ref.WeakReference<com.oplus.camera.gl_renamed.m_renamed> weakReference) {
            this.u_renamed = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLProducer " + getId());
            try {
                l_renamed();
            } catch (java.lang.InterruptedException unused) {
            } catch (java.lang.Throwable th) {
                com.oplus.camera.gl_renamed.m_renamed.f4625b.a_renamed(this);
                throw th;
            }
            com.oplus.camera.gl_renamed.m_renamed.f4625b.a_renamed(this);
        }

        private void j_renamed() {
            if (this.i_renamed) {
                this.i_renamed = false;
                this.t_renamed.e_renamed();
            }
        }

        private void k_renamed() {
            if (this.h_renamed) {
                this.t_renamed.f_renamed();
                this.h_renamed = false;
                com.oplus.camera.gl_renamed.m_renamed.f4625b.b_renamed(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:175:0x037d A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void l_renamed() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 904
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.gl_renamed.m_renamed.i_renamed.l_renamed():void");
        }

        public boolean a_renamed() {
            return this.h_renamed && this.i_renamed && m_renamed();
        }

        private boolean m_renamed() {
            return !this.d_renamed && this.e_renamed && !this.f_renamed && this.l_renamed > 0 && this.m_renamed > 0 && this.o_renamed;
        }

        public void a_renamed(int i_renamed) {
            if (i_renamed >= 0 && i_renamed <= 1) {
                synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                    this.n_renamed = i_renamed;
                    com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                }
                return;
            }
            throw new java.lang.IllegalArgumentException("renderMode");
        }

        public int b_renamed() {
            int i_renamed;
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                i_renamed = this.n_renamed;
            }
            return i_renamed;
        }

        public void c_renamed() {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                this.o_renamed = true;
                com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
            }
        }

        public void d_renamed() {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                this.e_renamed = true;
                this.j_renamed = false;
                com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                while (this.g_renamed && !this.j_renamed && !this.f4638b) {
                    try {
                        com.oplus.camera.gl_renamed.m_renamed.f4625b.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e_renamed() {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                this.e_renamed = false;
                com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                while (!this.g_renamed && !this.f4638b) {
                    try {
                        com.oplus.camera.gl_renamed.m_renamed.f4625b.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f_renamed() {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                android.util.Log.i_renamed("GLThread", "onPause tid=" + getId());
                this.f4639c = true;
                com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                while (!this.f4638b && !this.d_renamed) {
                    android.util.Log.i_renamed("Main thread", "onPause waiting for mPaused.");
                    try {
                        com.oplus.camera.gl_renamed.m_renamed.f4625b.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g_renamed() {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                android.util.Log.i_renamed("GLThread", "onResume tid=" + getId());
                this.f4639c = false;
                this.o_renamed = true;
                this.q_renamed = false;
                com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                while (!this.f4638b && this.d_renamed && !this.q_renamed) {
                    android.util.Log.i_renamed("Main thread", "onResume waiting for !mPaused.");
                    try {
                        com.oplus.camera.gl_renamed.m_renamed.f4625b.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a_renamed(int i_renamed, int i2) {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                this.l_renamed = i_renamed;
                this.m_renamed = i2;
                this.s_renamed = true;
                this.o_renamed = true;
                this.q_renamed = false;
                if (java.lang.Thread.currentThread() == this) {
                    return;
                }
                com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                while (!this.f4638b && !this.d_renamed && !this.q_renamed && a_renamed()) {
                    android.util.Log.i_renamed("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        com.oplus.camera.gl_renamed.m_renamed.f4625b.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h_renamed() {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                this.f4637a = true;
                com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                while (!this.f4638b) {
                    try {
                        com.oplus.camera.gl_renamed.m_renamed.f4625b.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a_renamed(java.lang.Runnable runnable) {
            if (runnable != null) {
                synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                    this.r_renamed.add(runnable);
                    com.oplus.camera.gl_renamed.m_renamed.f4625b.notifyAll();
                }
                return;
            }
            throw new java.lang.IllegalArgumentException("r_renamed must not be_renamed null");
        }

        public void i_renamed() {
            synchronized (com.oplus.camera.gl_renamed.m_renamed.f4625b) {
                this.r_renamed.clear();
            }
        }
    }

    /* compiled from: GLProducer.java */
    static class l_renamed extends java.io.Writer {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.StringBuilder f4641a = new java.lang.StringBuilder();

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
                    this.f4641a.append(c2);
                }
            }
        }

        private void a_renamed() {
            if (this.f4641a.length() > 0) {
                android.util.Log.v_renamed("GLSurfaceView", this.f4641a.toString());
                java.lang.StringBuilder sb = this.f4641a;
                sb.delete(0, sb.length());
            }
        }
    }

    private void j_renamed() {
        if (this.d_renamed != null) {
            throw new java.lang.IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* compiled from: GLProducer.java */
    private static class j_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static java.lang.String f4640a = "GLThreadManager";

        private j_renamed() {
        }

        public synchronized void a_renamed(com.oplus.camera.gl_renamed.m_renamed.i_renamed iVar) {
            iVar.f4638b = true;
            notifyAll();
        }

        public void b_renamed(com.oplus.camera.gl_renamed.m_renamed.i_renamed iVar) {
            notifyAll();
        }
    }
}
