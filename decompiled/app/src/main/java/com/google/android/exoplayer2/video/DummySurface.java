package com.google.android.exoplayer2.video;

@android.annotation.TargetApi(17)
/* loaded from: classes.dex */
public final class DummySurface extends android.view.Surface {
    private static final java.lang.String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final java.lang.String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final java.lang.String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread thread;
    private boolean threadReleased;

    public static synchronized boolean isSecureSupported(android.content.Context context) {
        if (!secureModeInitialized) {
            secureMode = com.google.android.exoplayer2.util.Util.SDK_INT < 24 ? 0 : getSecureModeV24(context);
            secureModeInitialized = true;
        }
        return secureMode != 0;
    }

    public static com.google.android.exoplayer2.video.DummySurface newInstanceV17(android.content.Context context, boolean z_renamed) {
        assertApiLevel17OrHigher();
        com.google.android.exoplayer2.util.Assertions.checkState(!z_renamed || isSecureSupported(context));
        return new com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread().init(z_renamed ? secureMode : 0);
    }

    private DummySurface(com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread dummySurfaceThread, android.graphics.SurfaceTexture surfaceTexture, boolean z_renamed) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z_renamed;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private static void assertApiLevel17OrHigher() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 17) {
            throw new java.lang.UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @android.annotation.TargetApi(24)
    private static int getSecureModeV24(android.content.Context context) {
        java.lang.String strEglQueryString;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 26 && ("samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) || "XT1650".equals(com.google.android.exoplayer2.util.Util.MODEL))) {
            return 0;
        }
        if ((com.google.android.exoplayer2.util.Util.SDK_INT >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = android.opengl.EGL14.eglQueryString(android.opengl.EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return strEglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT) ? 1 : 2;
        }
        return 0;
    }

    private static class DummySurfaceThread extends android.os.HandlerThread implements android.os.Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private com.google.android.exoplayer2.util.EGLSurfaceTexture eglSurfaceTexture;
        private android.os.Handler handler;
        private java.lang.Error initError;
        private java.lang.RuntimeException initException;
        private com.google.android.exoplayer2.video.DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        public com.google.android.exoplayer2.video.DummySurface init(int i_renamed) {
            boolean z_renamed;
            start();
            this.handler = new android.os.Handler(getLooper(), this);
            this.eglSurfaceTexture = new com.google.android.exoplayer2.util.EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z_renamed = false;
                this.handler.obtainMessage(1, i_renamed, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (java.lang.InterruptedException unused) {
                        z_renamed = true;
                    }
                }
            }
            if (z_renamed) {
                java.lang.Thread.currentThread().interrupt();
            }
            java.lang.RuntimeException runtimeException = this.initException;
            if (runtimeException != null) {
                throw runtimeException;
            }
            java.lang.Error error = this.initError;
            if (error != null) {
                throw error;
            }
            return (com.google.android.exoplayer2.video.DummySurface) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.surface);
        }

        public void release() {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.handler);
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            try {
                if (i_renamed != 1) {
                    try {
                        if (i_renamed != 2) {
                            return true;
                        }
                        try {
                            releaseInternal();
                        } catch (java.lang.Throwable th) {
                            com.google.android.exoplayer2.util.Log.e_renamed(com.google.android.exoplayer2.video.DummySurface.TAG, "Failed to release dummy surface", th);
                        }
                        return true;
                    } finally {
                        quit();
                    }
                }
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (java.lang.Error e_renamed) {
                    com.google.android.exoplayer2.util.Log.e_renamed(com.google.android.exoplayer2.video.DummySurface.TAG, "Failed to initialize dummy surface", e_renamed);
                    this.initError = e_renamed;
                    synchronized (this) {
                        notify();
                    }
                } catch (java.lang.RuntimeException e2) {
                    com.google.android.exoplayer2.util.Log.e_renamed(com.google.android.exoplayer2.video.DummySurface.TAG, "Failed to initialize dummy surface", e2);
                    this.initException = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (java.lang.Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }

        private void initInternal(int i_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.init(i_renamed);
            this.surface = new com.google.android.exoplayer2.video.DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i_renamed != 0);
        }

        private void releaseInternal() {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.release();
        }
    }
}
