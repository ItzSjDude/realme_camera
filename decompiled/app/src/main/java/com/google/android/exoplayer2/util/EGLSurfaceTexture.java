package com.google.android.exoplayer2.util;

@android.annotation.TargetApi(17)
/* loaded from: classes.dex */
public final class EGLSurfaceTexture implements android.graphics.SurfaceTexture.OnFrameAvailableListener, java.lang.Runnable {
    private static final int[] EGL_CONFIG_ATTRIBUTES = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final int EGL_SURFACE_HEIGHT = 1;
    private static final int EGL_SURFACE_WIDTH = 1;
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    private final com.google.android.exoplayer2.util.EGLSurfaceTexture.TextureImageListener callback;
    private android.opengl.EGLContext context;
    private android.opengl.EGLDisplay display;
    private final android.os.Handler handler;
    private android.opengl.EGLSurface surface;
    private android.graphics.SurfaceTexture texture;
    private final int[] textureIdHolder;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface SecureMode {
    }

    public interface TextureImageListener {
        void onFrameAvailable();
    }

    public static final class GlException extends java.lang.RuntimeException {
        private GlException(java.lang.String str) {
            super(str);
        }
    }

    public EGLSurfaceTexture(android.os.Handler handler) {
        this(handler, null);
    }

    public EGLSurfaceTexture(android.os.Handler handler, com.google.android.exoplayer2.util.EGLSurfaceTexture.TextureImageListener textureImageListener) {
        this.handler = handler;
        this.callback = textureImageListener;
        this.textureIdHolder = new int[1];
    }

    public void init(int i_renamed) {
        this.display = getDefaultDisplay();
        android.opengl.EGLConfig eGLConfigChooseEGLConfig = chooseEGLConfig(this.display);
        this.context = createEGLContext(this.display, eGLConfigChooseEGLConfig, i_renamed);
        this.surface = createEGLSurface(this.display, eGLConfigChooseEGLConfig, this.context, i_renamed);
        generateTextureIds(this.textureIdHolder);
        this.texture = new android.graphics.SurfaceTexture(this.textureIdHolder[0]);
        this.texture.setOnFrameAvailableListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release() {
        this.handler.removeCallbacks(this);
        try {
            if (this.texture != null) {
                this.texture.release();
                android.opengl.GLES20.glDeleteTextures(1, this.textureIdHolder, 0);
            }
        } finally {
            android.opengl.EGLDisplay eGLDisplay = this.display;
            if (eGLDisplay != null && !eGLDisplay.equals(android.opengl.EGL14.EGL_NO_DISPLAY)) {
                android.opengl.EGL14.eglMakeCurrent(this.display, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_CONTEXT);
            }
            android.opengl.EGLSurface eGLSurface = this.surface;
            if (eGLSurface != null && !eGLSurface.equals(android.opengl.EGL14.EGL_NO_SURFACE)) {
                android.opengl.EGL14.eglDestroySurface(this.display, this.surface);
            }
            android.opengl.EGLContext eGLContext = this.context;
            if (eGLContext != null) {
                android.opengl.EGL14.eglDestroyContext(this.display, eGLContext);
            }
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 19) {
                android.opengl.EGL14.eglReleaseThread();
            }
            android.opengl.EGLDisplay eGLDisplay2 = this.display;
            if (eGLDisplay2 != null && !eGLDisplay2.equals(android.opengl.EGL14.EGL_NO_DISPLAY)) {
                android.opengl.EGL14.eglTerminate(this.display);
            }
            this.display = null;
            this.context = null;
            this.surface = null;
            this.texture = null;
        }
    }

    public android.graphics.SurfaceTexture getSurfaceTexture() {
        return (android.graphics.SurfaceTexture) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.texture);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        this.handler.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        dispatchOnFrameAvailable();
        android.graphics.SurfaceTexture surfaceTexture = this.texture;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (java.lang.RuntimeException unused) {
            }
        }
    }

    private void dispatchOnFrameAvailable() {
        com.google.android.exoplayer2.util.EGLSurfaceTexture.TextureImageListener textureImageListener = this.callback;
        if (textureImageListener != null) {
            textureImageListener.onFrameAvailable();
        }
    }

    private static android.opengl.EGLDisplay getDefaultDisplay() {
        android.opengl.EGLDisplay eGLDisplayEglGetDisplay = android.opengl.EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (android.opengl.EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglInitialize failed");
    }

    private static android.opengl.EGLConfig chooseEGLConfig(android.opengl.EGLDisplay eGLDisplay) {
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = android.opengl.EGL14.eglChooseConfig(eGLDisplay, EGL_CONFIG_ATTRIBUTES, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!zEglChooseConfig || iArr[0] <= 0 || eGLConfigArr[0] == null) {
            throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException(com.google.android.exoplayer2.util.Util.formatInvariant("eglChooseConfig failed: success=%b_renamed, numConfigs[0]=%d_renamed, configs[0]=%s_renamed", java.lang.Boolean.valueOf(zEglChooseConfig), java.lang.Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        }
        return eGLConfigArr[0];
    }

    private static android.opengl.EGLContext createEGLContext(android.opengl.EGLDisplay eGLDisplay, android.opengl.EGLConfig eGLConfig, int i_renamed) {
        int[] iArr;
        if (i_renamed == 0) {
            iArr = new int[]{12440, 2, 12344};
        } else {
            iArr = new int[]{12440, 2, EGL_PROTECTED_CONTENT_EXT, 1, 12344};
        }
        android.opengl.EGLContext eGLContextEglCreateContext = android.opengl.EGL14.eglCreateContext(eGLDisplay, eGLConfig, android.opengl.EGL14.EGL_NO_CONTEXT, iArr, 0);
        if (eGLContextEglCreateContext != null) {
            return eGLContextEglCreateContext;
        }
        throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglCreateContext failed");
    }

    private static android.opengl.EGLSurface createEGLSurface(android.opengl.EGLDisplay eGLDisplay, android.opengl.EGLConfig eGLConfig, android.opengl.EGLContext eGLContext, int i_renamed) {
        int[] iArr;
        android.opengl.EGLSurface eGLSurfaceEglCreatePbufferSurface;
        if (i_renamed == 1) {
            eGLSurfaceEglCreatePbufferSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        } else {
            if (i_renamed == 2) {
                iArr = new int[]{12375, 1, 12374, 1, EGL_PROTECTED_CONTENT_EXT, 1, 12344};
            } else {
                iArr = new int[]{12375, 1, 12374, 1, 12344};
            }
            eGLSurfaceEglCreatePbufferSurface = android.opengl.EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglCreatePbufferSurface failed");
            }
        }
        if (android.opengl.EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext)) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("eglMakeCurrent failed");
    }

    private static void generateTextureIds(int[] iArr) {
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        int iGlGetError = android.opengl.GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new com.google.android.exoplayer2.util.EGLSurfaceTexture.GlException("glGenTextures failed. Error: " + java.lang.Integer.toHexString(iGlGetError));
    }
}
