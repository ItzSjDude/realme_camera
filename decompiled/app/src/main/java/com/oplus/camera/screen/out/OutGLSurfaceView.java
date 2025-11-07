package com.oplus.camera.screen.out;

/* loaded from: classes2.dex */
public class OutGLSurfaceView extends android.opengl.GLSurfaceView implements android.opengl.GLSurfaceView.Renderer {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.Queue<com.oplus.camera.screen.out.a_renamed> f5378a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.screen.out.d_renamed f5379b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private volatile boolean f5380c;
    private android.graphics.Rect d_renamed;
    private java.lang.StringBuffer e_renamed;

    public OutGLSurfaceView(android.content.Context context) {
        super(context);
        this.f5378a = new java.util.concurrent.ConcurrentLinkedQueue();
        this.f5379b = null;
        this.f5380c = false;
        this.d_renamed = null;
        this.e_renamed = null;
        a_renamed(context);
    }

    public OutGLSurfaceView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5378a = new java.util.concurrent.ConcurrentLinkedQueue();
        this.f5379b = null;
        this.f5380c = false;
        this.d_renamed = null;
        this.e_renamed = null;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        setEGLContextClientVersion(2);
        setRenderer(this);
        this.f5379b = new com.oplus.camera.screen.out.d_renamed(context);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        com.oplus.camera.e_renamed.b_renamed("OutGLSurfaceView", "onSurfaceCreated");
        setRenderMode(0);
        android.opengl.GLES20.glEnable(3553);
        this.f5380c = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.b_renamed("OutGLSurfaceView", "onSurfaceChanged");
        android.opengl.GLES20.glViewport(0, 0, i_renamed, i2);
        this.d_renamed = new android.graphics.Rect(0, 0, i_renamed, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl10) throws java.lang.InterruptedException {
        com.oplus.camera.screen.out.a_renamed aVarPoll = null;
        while (true) {
            if (this.f5378a.size() >= 1) {
                aVarPoll = this.f5378a.poll();
                if (aVarPoll != null && 1 == aVarPoll.f5381a) {
                    com.oplus.camera.e_renamed.b_renamed("OutGLSurfaceView", "onDrawFrame, size change, queue size: " + this.f5378a.size());
                    break;
                }
            } else {
                break;
            }
        }
        android.opengl.GLES20.glClear(16384);
        this.e_renamed = new java.lang.StringBuffer();
        if (aVarPoll != null) {
            b_renamed(aVarPoll);
        } else {
            this.e_renamed.append("onDrawFrame null, ");
            b_renamed();
        }
        com.oplus.camera.e_renamed.f_renamed("OutGLSurfaceView", this.e_renamed.toString());
        android.opengl.GLES20.glFinish();
    }

    private void b_renamed() throws java.lang.InterruptedException {
        com.oplus.camera.screen.out.a_renamed aVarPoll;
        if (this.f5380c && this.f5379b.c_renamed()) {
            this.e_renamed.append("drawFrameDelay, ");
            com.oplus.camera.screen.out.a_renamed aVar = null;
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= 3) {
                    break;
                }
                try {
                    java.lang.Thread.sleep(1L);
                    aVarPoll = this.f5378a.poll();
                } catch (java.lang.InterruptedException e_renamed) {
                    e_renamed.printStackTrace();
                }
                if (aVarPoll != null) {
                    aVar = aVarPoll;
                    break;
                } else {
                    aVar = aVarPoll;
                    i_renamed++;
                }
            }
            if (aVar != null) {
                b_renamed(aVar);
            } else {
                this.e_renamed.append("drawLastFrame, ");
                this.f5379b.d_renamed();
            }
        }
    }

    private void b_renamed(com.oplus.camera.screen.out.a_renamed aVar) throws java.lang.InterruptedException {
        int i_renamed = aVar.f5381a;
        if (i_renamed == 0) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - aVar.g_renamed;
            java.lang.StringBuffer stringBuffer = this.e_renamed;
            stringBuffer.append("frame thread cost: ");
            stringBuffer.append(jCurrentTimeMillis);
            stringBuffer.append(", ");
            if (jCurrentTimeMillis > 10) {
                b_renamed();
                return;
            }
            aVar.f_renamed.lock();
            this.e_renamed.append("lock, ");
            if (!aVar.f5382b.isClosed()) {
                this.e_renamed.append("draw, ");
                this.f5379b.a_renamed(aVar, this.d_renamed);
            }
            this.e_renamed.append("unlock, ");
            aVar.f_renamed.unlock();
            return;
        }
        if (i_renamed == 1) {
            this.e_renamed.append("size change, ");
            this.f5379b.b_renamed(aVar, this.d_renamed);
            this.f5379b.c_renamed(aVar, this.d_renamed);
            this.f5378a.offer(new com.oplus.camera.screen.out.a_renamed(2));
            requestRender();
            return;
        }
        if (i_renamed != 2) {
            return;
        }
        this.e_renamed.append("animation, ");
        boolean zC = this.f5379b.c_renamed(aVar, this.d_renamed);
        java.lang.StringBuffer stringBuffer2 = this.e_renamed;
        stringBuffer2.append("end: ");
        stringBuffer2.append(zC);
        stringBuffer2.append(", ");
        if (!zC) {
            this.f5378a.offer(new com.oplus.camera.screen.out.a_renamed(2));
            requestRender();
        } else {
            this.f5380c = true;
        }
    }

    public void a_renamed(com.oplus.camera.screen.out.a_renamed aVar) {
        com.oplus.camera.e_renamed.b_renamed("OutGLSurfaceView", "addFrame, mbEnable: " + this.f5380c);
        if (this.f5380c) {
            aVar.g_renamed = java.lang.System.currentTimeMillis();
            this.f5378a.offer(aVar);
            requestRender();
        }
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.f_renamed("OutGLSurfaceView", "onStop");
        this.f5380c = false;
        this.f5378a.clear();
        queueEvent(new java.lang.Runnable() { // from class: com.oplus.camera.screen.out.-$$Lambda$OutGLSurfaceView$fEa94jyWP9wxL254bsOwOa1Be3M
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.c_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed() {
        this.f5379b.b_renamed();
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.f_renamed("OutGLSurfaceView", "changePreviewSize, width: " + i_renamed + ", height: " + i2);
        this.f5380c = false;
        this.f5378a.offer(new com.oplus.camera.screen.out.a_renamed(i_renamed, i2));
        requestRender();
    }
}
