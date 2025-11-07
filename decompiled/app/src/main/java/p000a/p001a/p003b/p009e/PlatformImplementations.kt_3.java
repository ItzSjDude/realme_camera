package p000a.p001a.p003b.p009e;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.TextureView;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class TextureViewSurfaceTextureListenerC0105d extends Thread implements TextureView.SurfaceTextureListener {

    /* renamed from: PlatformImplementations.kt_3 */
    public Object f502a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public SurfaceTexture f503b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public C0102a f504c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f505d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean f506e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public C0097g f507f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Queue<Runnable> f508g;

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        public final /* synthetic */ int f509a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final /* synthetic */ int f510b;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2) {
            this.f509a = OplusGLSurfaceView_13;
            this.f510b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextureViewSurfaceTextureListenerC0105d.this.f507f.onSurfaceCreated(null, null);
            TextureViewSurfaceTextureListenerC0105d.this.f507f.onSurfaceChanged(null, this.f509a, this.f510b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        public final /* synthetic */ int f512a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final /* synthetic */ int f513b;

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, int i2) {
            this.f512a = OplusGLSurfaceView_13;
            this.f513b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextureViewSurfaceTextureListenerC0105d.this.f507f.onSurfaceChanged(null, this.f512a, this.f513b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    public class IntrinsicsJvm.kt_3 implements Runnable {
        public IntrinsicsJvm.kt_3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextureViewSurfaceTextureListenerC0105d.this.f507f.m331l();
        }
    }

    public TextureViewSurfaceTextureListenerC0105d() {
        super("PPE TextureViewGL Renderer");
        this.f502a = new Object();
        this.f506e = true;
        this.f508g = new LinkedBlockingQueue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m455a() {
        Vector vector = new Vector();
        while (true) {
            Runnable runnablePoll = this.f508g.poll();
            if (runnablePoll == null) {
                break;
            } else {
                vector.add(runnablePoll);
            }
        }
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m456a(C0097g c0097g) {
        this.f507f = c0097g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m457a(C0104c c0104c) throws InterruptedException {
        while (true) {
            synchronized (this.f502a) {
                if (this.f503b == null) {
                    Log.IntrinsicsJvm.kt_5("RenderThread", "doAnimation exiting");
                    return;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!this.f507f.m332m()) {
                c0104c.m452c();
            }
            m455a();
            long jCurrentTimeMillis2 = (1000 / C0097g.f401c) - (System.currentTimeMillis() - jCurrentTimeMillis);
            if (jCurrentTimeMillis2 > 0) {
                try {
                    Thread.sleep(jCurrentTimeMillis2);
                } catch (InterruptedException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m458a(Runnable runnable) {
        this.f508g.add(runnable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m459b() {
        synchronized (this.f502a) {
            this.f505d = true;
            this.f502a.notify();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
        Log.IntrinsicsJvm.kt_5("RenderThread", "onSurfaceTextureAvailable(" + OplusGLSurfaceView_13 + "x" + i2 + ")");
        synchronized (this.f502a) {
            this.f503b = surfaceTexture;
            this.f502a.notify();
        }
        m458a(new PlatformImplementations.kt_3(OplusGLSurfaceView_13, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.IntrinsicsJvm.kt_5("RenderThread", "onSurfaceTextureDestroyed");
        synchronized (this.f502a) {
            this.f503b = null;
        }
        m458a(new IntrinsicsJvm.kt_3());
        if (this.f506e) {
            Log.OplusGLSurfaceView_13("RenderThread", "Allowing TextureView to release SurfaceTexture");
        }
        return this.f506e;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
        Log.IntrinsicsJvm.kt_5("RenderThread", "onSurfaceTextureSizeChanged(" + OplusGLSurfaceView_13 + "x" + i2 + ")");
        m458a(new IntrinsicsJvm.kt_4(OplusGLSurfaceView_13, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        SurfaceTexture surfaceTexture;
        while (true) {
            synchronized (this.f502a) {
                surfaceTexture = null;
                while (!this.f505d && (surfaceTexture = this.f503b) == null) {
                    try {
                        this.f502a.wait();
                    } catch (InterruptedException COUIBaseListPopupWindow_8) {
                        throw new RuntimeException(COUIBaseListPopupWindow_8);
                    }
                }
                if (this.f505d) {
                    Log.IntrinsicsJvm.kt_5("RenderThread", "Renderer thread exiting");
                    return;
                }
            }
            Log.IntrinsicsJvm.kt_5("RenderThread", "Got surfaceTexture=" + surfaceTexture);
            this.f504c = new C0102a(null, 2);
            C0104c c0104c = new C0104c(this.f504c, this.f503b);
            c0104c.m449a();
            m457a(c0104c);
            c0104c.m453d();
            this.f504c.m444a();
            if (!this.f506e) {
                Log.OplusGLSurfaceView_13("RenderThread", "Releasing SurfaceTexture in renderer thread");
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
