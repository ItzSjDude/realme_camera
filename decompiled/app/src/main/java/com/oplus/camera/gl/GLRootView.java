package com.oplus.camera.gl_renamed;

/* loaded from: classes2.dex */
public class GLRootView extends com.oplus.camera.gl_renamed.q_renamed implements com.oplus.camera.gl_renamed.n_renamed, com.oplus.camera.gl_renamed.q_renamed.m_renamed, com.oplus.camera.gl_renamed.r_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.oplus.camera.gl_renamed.e_renamed f4563a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.ArrayList<com.oplus.camera.gl_renamed.f_renamed> f4564b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.ArrayDeque<com.oplus.camera.gl_renamed.n_renamed.a_renamed> f4565c;
    private final com.oplus.camera.gl_renamed.GLRootView.IdleRunner d_renamed;
    private final java.util.concurrent.locks.ReentrantLock e_renamed;
    private final java.util.concurrent.locks.Condition f_renamed;
    private int g_renamed;
    private long h_renamed;
    private int i_renamed;
    private javax.microedition.khronos.opengles.GL11 j_renamed;
    private com.oplus.camera.gl_renamed.h_renamed k_renamed;
    private com.oplus.camera.gl_renamed.GLView l_renamed;
    private int m_renamed;
    private android.graphics.Matrix n_renamed;
    private int o_renamed;
    private int p_renamed;
    private volatile boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private int v_renamed;
    private int w_renamed;
    private com.oplus.camera.gl_renamed.GLRootView.GLRootViewListener x_renamed;
    private boolean y_renamed;
    private boolean z_renamed;

    public interface GLRootViewListener {
        void onSurfaceChanged();

        void onSurfaceCreated();
    }

    public GLRootView(android.content.Context context) {
        this(context, null);
    }

    public GLRootView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4563a = new com.oplus.camera.gl_renamed.e_renamed();
        this.f4564b = new java.util.ArrayList<>();
        this.f4565c = new java.util.ArrayDeque<>();
        this.d_renamed = new com.oplus.camera.gl_renamed.GLRootView.IdleRunner();
        this.e_renamed = new java.util.concurrent.locks.ReentrantLock();
        this.f_renamed = this.e_renamed.newCondition();
        this.g_renamed = 0;
        this.h_renamed = 0L;
        this.i_renamed = 0;
        this.n_renamed = new android.graphics.Matrix();
        this.p_renamed = 2;
        this.q_renamed = false;
        this.s_renamed = false;
        this.t_renamed = true;
        this.u_renamed = false;
        this.v_renamed = 0;
        this.w_renamed = 0;
        this.x_renamed = null;
        this.y_renamed = false;
        this.z_renamed = false;
        setEGLContextClientVersion(2);
        this.p_renamed |= 1;
        setBackgroundDrawable(null);
        setEGLConfigChooser(this.f4563a);
        a_renamed(this, "PreviewGLThread");
        setOutputRender(this);
        getHolder().setFormat(3);
    }

    public void setGLRootViewListener(com.oplus.camera.gl_renamed.GLRootView.GLRootViewListener gLRootViewListener) {
        this.x_renamed = gLRootViewListener;
    }

    public synchronized boolean getSurfaceState() {
        return this.y_renamed;
    }

    public void setContentPane(com.oplus.camera.gl_renamed.GLView gLView) {
        com.oplus.camera.gl_renamed.GLView gLView2 = this.l_renamed;
        if (gLView2 == gLView) {
            return;
        }
        if (gLView2 != null) {
            if (this.s_renamed) {
                long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.l_renamed.b_renamed(motionEventObtain);
                motionEventObtain.recycle();
                this.s_renamed = false;
            }
            this.l_renamed.b_renamed();
            com.oplus.camera.gl_renamed.c_renamed.a_renamed();
        }
        this.l_renamed = gLView;
        if (gLView != null) {
            gLView.a_renamed(this);
            b_renamed();
        }
    }

    public void setNeedLutTexture(boolean z_renamed) {
        this.z_renamed = z_renamed;
        com.oplus.camera.gl_renamed.h_renamed hVar = this.k_renamed;
        if (hVar != null) {
            hVar.a_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed, com.oplus.camera.gl_renamed.n_renamed
    public void a_renamed() {
        if (this.u_renamed) {
            android.util.Log.i_renamed("GLRootView", "requestRender, Activity.finish(), so return");
        } else {
            if (this.q_renamed) {
                return;
            }
            this.q_renamed = true;
            super.a_renamed();
        }
    }

    public void b_renamed() {
        android.util.Log.v_renamed("GLRootView", "requestLayoutContentPane, mRenderLock.lock()");
        this.e_renamed.lock();
        try {
            if (this.l_renamed != null && (this.p_renamed & 2) == 0 && (this.p_renamed & 1) != 0) {
                this.p_renamed |= 2;
                a_renamed();
            }
        } finally {
            this.e_renamed.unlock();
            android.util.Log.v_renamed("GLRootView", "requestLayoutContentPane, mRenderLock.unlock()");
        }
    }

    private void m_renamed() {
        this.p_renamed &= -3;
        int width = getWidth();
        int height = getHeight();
        if (this.m_renamed != 0 || width != this.v_renamed || height != this.w_renamed) {
            this.m_renamed = 0;
            int i_renamed = this.m_renamed;
            if (i_renamed % 180 != 0) {
                this.n_renamed.setRotate(i_renamed);
                this.n_renamed.preTranslate((-width) / 2, (-height) / 2);
                this.n_renamed.postTranslate(height / 2, width / 2);
            } else {
                this.n_renamed.setRotate(i_renamed, width / 2, height / 2);
            }
            this.o_renamed = 0;
            this.v_renamed = width;
            this.w_renamed = height;
        }
        if (this.m_renamed % 180 != 0) {
            height = width;
            width = height;
        }
        android.util.Log.i_renamed("GLRootView", "layoutContentPane, size: " + width + "x_renamed" + height + ", compensation: " + this.m_renamed);
        com.oplus.camera.gl_renamed.GLView gLView = this.l_renamed;
        if (gLView == null || width == 0 || height == 0) {
            return;
        }
        gLView.a_renamed(0, 0, width, height);
    }

    @Override // android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        if (z_renamed) {
            b_renamed();
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed.m_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        android.util.Log.i_renamed("GLRootView", "onSurfaceCreated(GL10 gl1, EGLConfig config)");
        javax.microedition.khronos.opengles.GL11 gl11 = (javax.microedition.khronos.opengles.GL11) gl10;
        if (this.j_renamed != null) {
            android.util.Log.i_renamed("GLRootView", "GLObject has changed from " + this.j_renamed + " to " + gl11);
        }
        com.oplus.camera.e_renamed.a_renamed("GLRootView", "onSurfaceCreated, mRenderLock.lock()");
        this.e_renamed.lock();
        try {
            this.j_renamed = gl11;
            this.k_renamed = new com.oplus.camera.gl_renamed.i_renamed();
            this.k_renamed.a_renamed(this.z_renamed);
            com.oplus.camera.gl_renamed.c_renamed.b_renamed();
            this.e_renamed.unlock();
            com.oplus.camera.e_renamed.a_renamed("GLRootView", "onSurfaceCreated, mRenderLock.unlock()");
            setRenderMode(0);
            com.oplus.camera.gl_renamed.GLRootView.GLRootViewListener gLRootViewListener = this.x_renamed;
            if (gLRootViewListener != null) {
                gLRootViewListener.onSurfaceCreated();
            }
            com.oplus.camera.gl_renamed.GLView gLView = this.l_renamed;
            if (gLView != null) {
                gLView.f_renamed();
            }
            this.y_renamed = true;
            this.u_renamed = false;
            android.util.Log.v_renamed("GLRootView", "onSurfaceCreated mFinsh = false");
        } catch (java.lang.Throwable th) {
            this.e_renamed.unlock();
            com.oplus.camera.e_renamed.a_renamed("GLRootView", "onSurfaceCreated, mRenderLock.unlock()");
            throw th;
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed.m_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2) throws java.lang.SecurityException, java.lang.IllegalArgumentException {
        android.util.Log.i_renamed("GLRootView", "onSurfaceChanged: " + i_renamed + "x_renamed" + i2 + ", gl10: " + gl10.toString() + ", mGLRootViewListener:" + this.x_renamed);
        android.os.Process.setThreadPriority(-4);
        com.oplus.camera.gl_renamed.y_renamed.a_renamed(this.j_renamed == ((javax.microedition.khronos.opengles.GL11) gl10));
        this.k_renamed.a_renamed(i_renamed, i2);
        com.oplus.camera.gl_renamed.GLRootView.GLRootViewListener gLRootViewListener = this.x_renamed;
        if (gLRootViewListener != null) {
            gLRootViewListener.onSurfaceChanged();
        }
        com.oplus.camera.gl_renamed.GLView gLView = this.l_renamed;
        if (gLView != null) {
            gLView.a_renamed(i_renamed, i2);
        }
        this.y_renamed = true;
    }

    private void n_renamed() {
        long jNanoTime = java.lang.System.nanoTime();
        long j_renamed = this.h_renamed;
        if (j_renamed == 0) {
            this.h_renamed = jNanoTime;
        } else if (jNanoTime - j_renamed > com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
            android.util.Log.w_renamed("GLRootView", "outputFps, fps: " + ((this.g_renamed * 1.0E9d) / (jNanoTime - this.h_renamed)));
            this.h_renamed = jNanoTime;
            this.g_renamed = 0;
        }
        this.g_renamed++;
    }

    @Override // com.oplus.camera.gl_renamed.r_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed) {
        com.oplus.camera.gl_renamed.GLView gLView = this.l_renamed;
        if (gLView != null) {
            gLView.a_renamed(this.k_renamed, i_renamed);
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed.m_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        com.oplus.camera.gl_renamed.b_renamed.a_renamed();
        this.e_renamed.lock();
        while (this.r_renamed) {
            this.f_renamed.awaitUninterruptibly();
        }
        try {
            b_renamed(gl10);
            this.e_renamed.unlock();
            if (this.t_renamed) {
                this.t_renamed = false;
            }
        } catch (java.lang.Throwable th) {
            this.e_renamed.unlock();
            throw th;
        }
    }

    private void b_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        n_renamed();
        this.k_renamed.g_renamed();
        com.oplus.camera.gl_renamed.x_renamed.s_renamed();
        this.q_renamed = false;
        if ((this.p_renamed & 2) != 0) {
            m_renamed();
        }
        this.k_renamed.a_renamed(-1);
        a_renamed(-this.m_renamed);
        com.oplus.camera.gl_renamed.GLView gLView = this.l_renamed;
        if (gLView != null) {
            gLView.a_renamed(this.k_renamed);
        }
        this.k_renamed.f_renamed();
        if (!this.f4564b.isEmpty()) {
            long jB = com.oplus.camera.gl_renamed.b_renamed.b_renamed();
            int size = this.f4564b.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f4564b.get(i_renamed).a_renamed(jB);
            }
            this.f4564b.clear();
        }
        if (com.oplus.camera.gl_renamed.x_renamed.t_renamed()) {
            a_renamed();
        }
        synchronized (this.f4565c) {
            if (!this.f4565c.isEmpty()) {
                this.d_renamed.enable();
            }
        }
    }

    private void a_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return;
        }
        this.k_renamed.a_renamed(getWidth() / 2, getHeight() / 2);
        this.k_renamed.a_renamed(i_renamed, 0.0f, 0.0f, 1.0f);
        if (i_renamed % 180 != 0) {
            this.k_renamed.a_renamed(-r1, -r0);
        } else {
            this.k_renamed.a_renamed(-r0, -r1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z_renamed = false;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.s_renamed = false;
        } else if (!this.s_renamed && action != 0) {
            return false;
        }
        if (this.m_renamed != 0) {
            motionEvent.transform(this.n_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("GLRootView", "dispatchTouchEvent, mRenderLock.lock()");
        this.e_renamed.lock();
        try {
            if (this.l_renamed != null && this.l_renamed.b_renamed(motionEvent)) {
                z_renamed = true;
            }
            if (action == 0 && z_renamed) {
                this.s_renamed = true;
            }
            return z_renamed;
        } finally {
            this.e_renamed.unlock();
            com.oplus.camera.e_renamed.a_renamed("GLRootView", "dispatchTouchEvent, mRenderLock.unlock()");
        }
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed
    public void c_renamed() {
        super.c_renamed();
        this.u_renamed = false;
        android.util.Log.v_renamed("GLRootView", "onResume mFinsh = false");
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed
    public void d_renamed() {
        e_renamed();
        super.d_renamed();
        this.y_renamed = false;
        this.x_renamed = null;
    }

    public int getDisplayRotation() {
        return this.o_renamed;
    }

    public int getCompensation() {
        return this.m_renamed;
    }

    public android.graphics.Matrix getCompensationMatrix() {
        return this.n_renamed;
    }

    public void e_renamed() {
        android.util.Log.v_renamed("GLRootView", "unfreeze, mRenderLock.lock()");
        this.e_renamed.lock();
        try {
            this.r_renamed = false;
            this.f_renamed.signalAll();
        } finally {
            this.e_renamed.unlock();
            android.util.Log.v_renamed("GLRootView", "unfreeze, mRenderLock.unlock()");
        }
    }

    public void setLightsOutMode(boolean z_renamed) {
        setSystemUiVisibility(z_renamed ? 261 : 0);
    }

    public void f_renamed() {
        this.u_renamed = true;
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed, android.view.SurfaceHolder.Callback
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i_renamed, int i2, int i3) {
        e_renamed();
        super.surfaceChanged(surfaceHolder, i_renamed, i2, i3);
        com.oplus.camera.e_renamed.a_renamed("GLRootView", "surfaceChanged, w_renamed: " + i2 + ", h_renamed: " + i3);
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed, android.view.SurfaceHolder.Callback
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        e_renamed();
        super.surfaceCreated(surfaceHolder);
        com.oplus.camera.e_renamed.a_renamed("GLRootView", "surfaceCreated");
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        e_renamed();
        super.surfaceDestroyed(surfaceHolder);
        com.oplus.camera.e_renamed.a_renamed("GLRootView", "surfaceDestroyed");
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        e_renamed();
        super.onDetachedFromWindow();
    }

    @Override // com.oplus.camera.gl_renamed.q_renamed
    protected void finalize() throws java.lang.Throwable {
        try {
            e_renamed();
        } finally {
            super.finalize();
        }
    }

    private class IdleRunner implements java.lang.Runnable {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f4567b;

        private IdleRunner() {
            this.f4567b = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.oplus.camera.gl_renamed.GLRootView.this.f4565c) {
                this.f4567b = false;
                if (com.oplus.camera.gl_renamed.GLRootView.this.f4565c.isEmpty()) {
                    return;
                }
                com.oplus.camera.gl_renamed.n_renamed.a_renamed aVar = (com.oplus.camera.gl_renamed.n_renamed.a_renamed) com.oplus.camera.gl_renamed.GLRootView.this.f4565c.removeFirst();
                android.util.Log.v_renamed("GLRootView", "IdleRunner run, mRenderLock.lock()");
                com.oplus.camera.gl_renamed.GLRootView.this.e_renamed.lock();
                try {
                    if (aVar.a_renamed(com.oplus.camera.gl_renamed.GLRootView.this.k_renamed, com.oplus.camera.gl_renamed.GLRootView.this.q_renamed)) {
                        com.oplus.camera.gl_renamed.GLRootView.this.e_renamed.unlock();
                        android.util.Log.v_renamed("GLRootView", "IdleRunner run, mRenderLock.unlock()");
                        synchronized (com.oplus.camera.gl_renamed.GLRootView.this.f4565c) {
                            com.oplus.camera.gl_renamed.GLRootView.this.f4565c.addLast(aVar);
                            if (!com.oplus.camera.gl_renamed.GLRootView.this.q_renamed) {
                                enable();
                            }
                        }
                    }
                } finally {
                    com.oplus.camera.gl_renamed.GLRootView.this.e_renamed.unlock();
                    android.util.Log.v_renamed("GLRootView", "IdleRunner run, mRenderLock.unlock()");
                }
            }
        }

        public void enable() {
            if (this.f4567b) {
                return;
            }
            this.f4567b = true;
            com.oplus.camera.gl_renamed.GLRootView.this.a_renamed(this);
        }
    }
}
