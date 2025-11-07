package a_renamed.a_renamed.b_renamed.e_renamed;

/* loaded from: classes.dex */
public class d_renamed extends java.lang.Thread implements android.view.TextureView.SurfaceTextureListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.lang.Object f69a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.graphics.SurfaceTexture f70b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.e_renamed.a_renamed f71c;
    public boolean d_renamed;
    public boolean e_renamed;
    public a_renamed.a_renamed.b_renamed.c_renamed.g_renamed f_renamed;
    public java.util.Queue<java.lang.Runnable> g_renamed;

    public class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final /* synthetic */ int f72a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final /* synthetic */ int f73b;

        public a_renamed(int i_renamed, int i2) {
            this.f72a = i_renamed;
            this.f73b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a_renamed.a_renamed.b_renamed.e_renamed.d_renamed.this.f_renamed.onSurfaceCreated(null, null);
            a_renamed.a_renamed.b_renamed.e_renamed.d_renamed.this.f_renamed.onSurfaceChanged(null, this.f72a, this.f73b);
        }
    }

    public class b_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final /* synthetic */ int f75a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final /* synthetic */ int f76b;

        public b_renamed(int i_renamed, int i2) {
            this.f75a = i_renamed;
            this.f76b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a_renamed.a_renamed.b_renamed.e_renamed.d_renamed.this.f_renamed.onSurfaceChanged(null, this.f75a, this.f76b);
        }
    }

    public class c_renamed implements java.lang.Runnable {
        public c_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a_renamed.a_renamed.b_renamed.e_renamed.d_renamed.this.f_renamed.l_renamed();
        }
    }

    public d_renamed() {
        super("PPE TextureViewGL Renderer");
        this.f69a = new java.lang.Object();
        this.e_renamed = true;
        this.g_renamed = new java.util.concurrent.LinkedBlockingQueue();
    }

    public final void a_renamed() {
        java.util.Vector vector = new java.util.Vector();
        while (true) {
            java.lang.Runnable runnablePoll = this.g_renamed.poll();
            if (runnablePoll == null) {
                break;
            } else {
                vector.add(runnablePoll);
            }
        }
        java.util.Iterator it = vector.iterator();
        while (it.hasNext()) {
            ((java.lang.Runnable) it.next()).run();
        }
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.g_renamed gVar) {
        this.f_renamed = gVar;
    }

    public final void a_renamed(a_renamed.a_renamed.b_renamed.e_renamed.c_renamed cVar) throws java.lang.InterruptedException {
        while (true) {
            synchronized (this.f69a) {
                if (this.f70b == null) {
                    android.util.Log.d_renamed("RenderThread", "doAnimation exiting");
                    return;
                }
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (!this.f_renamed.m_renamed()) {
                cVar.c_renamed();
            }
            a_renamed();
            long jCurrentTimeMillis2 = (1000 / a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.f42c) - (java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
            if (jCurrentTimeMillis2 > 0) {
                try {
                    java.lang.Thread.sleep(jCurrentTimeMillis2);
                } catch (java.lang.InterruptedException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        }
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.g_renamed.add(runnable);
    }

    public void b_renamed() {
        synchronized (this.f69a) {
            this.d_renamed = true;
            this.f69a.notify();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
        android.util.Log.d_renamed("RenderThread", "onSurfaceTextureAvailable(" + i_renamed + "x_renamed" + i2 + ")");
        synchronized (this.f69a) {
            this.f70b = surfaceTexture;
            this.f69a.notify();
        }
        a_renamed(new a_renamed.a_renamed.b_renamed.e_renamed.d_renamed.a_renamed(i_renamed, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        android.util.Log.d_renamed("RenderThread", "onSurfaceTextureDestroyed");
        synchronized (this.f69a) {
            this.f70b = null;
        }
        a_renamed(new a_renamed.a_renamed.b_renamed.e_renamed.d_renamed.c_renamed());
        if (this.e_renamed) {
            android.util.Log.i_renamed("RenderThread", "Allowing TextureView to release SurfaceTexture");
        }
        return this.e_renamed;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
        android.util.Log.d_renamed("RenderThread", "onSurfaceTextureSizeChanged(" + i_renamed + "x_renamed" + i2 + ")");
        a_renamed(new a_renamed.a_renamed.b_renamed.e_renamed.d_renamed.b_renamed(i_renamed, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws java.lang.InterruptedException {
        android.graphics.SurfaceTexture surfaceTexture;
        while (true) {
            synchronized (this.f69a) {
                surfaceTexture = null;
                while (!this.d_renamed && (surfaceTexture = this.f70b) == null) {
                    try {
                        this.f69a.wait();
                    } catch (java.lang.InterruptedException e_renamed) {
                        throw new java.lang.RuntimeException(e_renamed);
                    }
                }
                if (this.d_renamed) {
                    android.util.Log.d_renamed("RenderThread", "Renderer thread exiting");
                    return;
                }
            }
            android.util.Log.d_renamed("RenderThread", "Got surfaceTexture=" + surfaceTexture);
            this.f71c = new a_renamed.a_renamed.b_renamed.e_renamed.a_renamed(null, 2);
            a_renamed.a_renamed.b_renamed.e_renamed.c_renamed cVar = new a_renamed.a_renamed.b_renamed.e_renamed.c_renamed(this.f71c, this.f70b);
            cVar.a_renamed();
            a_renamed(cVar);
            cVar.d_renamed();
            this.f71c.a_renamed();
            if (!this.e_renamed) {
                android.util.Log.i_renamed("RenderThread", "Releasing SurfaceTexture in_renamed renderer thread");
                surfaceTexture.release();
            }
        }
    }

    @Override // java.lang.Thread
    public void start() {
        synchronized (this) {
            super.start();
        }
    }
}
