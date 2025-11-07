package com.oplus.camera.screen.out;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.oplus.camera.CameraLog;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public class OutGLSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: PlatformImplementations.kt_3 */
    private Queue<Frame> f16054a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private OesDrawer f16055b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private volatile boolean f16056c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Rect f16057d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private StringBuffer f16058e;

    public OutGLSurfaceView(Context context) {
        super(context);
        this.f16054a = new ConcurrentLinkedQueue();
        this.f16055b = null;
        this.f16056c = false;
        this.f16057d = null;
        this.f16058e = null;
        m16673a(context);
    }

    public OutGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16054a = new ConcurrentLinkedQueue();
        this.f16055b = null;
        this.f16056c = false;
        this.f16057d = null;
        this.f16058e = null;
        m16673a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16673a(Context context) {
        setEGLContextClientVersion(2);
        setRenderer(this);
        this.f16055b = new OesDrawer(context);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        CameraLog.m12959b("OutGLSurfaceView", "onSurfaceCreated");
        setRenderMode(0);
        GLES20.glEnable(3553);
        this.f16056c = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12959b("OutGLSurfaceView", "onSurfaceChanged");
        GLES20.glViewport(0, 0, OplusGLSurfaceView_13, i2);
        this.f16057d = new Rect(0, 0, OplusGLSurfaceView_13, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) throws InterruptedException {
        Frame c2955aPoll = null;
        while (true) {
            if (this.f16054a.size() >= 1) {
                c2955aPoll = this.f16054a.poll();
                if (c2955aPoll != null && 1 == c2955aPoll.f16059a) {
                    CameraLog.m12959b("OutGLSurfaceView", "onDrawFrame, size change, queue size: " + this.f16054a.size());
                    break;
                }
            } else {
                break;
            }
        }
        GLES20.glClear(16384);
        this.f16058e = new StringBuffer();
        if (c2955aPoll != null) {
            m16675b(c2955aPoll);
        } else {
            this.f16058e.append("onDrawFrame null, ");
            m16674b();
        }
        CameraLog.m12967f("OutGLSurfaceView", this.f16058e.toString());
        GLES20.glFinish();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16674b() throws InterruptedException {
        Frame c2955aPoll;
        if (this.f16056c && this.f16055b.m16703c()) {
            this.f16058e.append("drawFrameDelay, ");
            Frame c2955a = null;
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= 3) {
                    break;
                }
                try {
                    Thread.sleep(1L);
                    c2955aPoll = this.f16054a.poll();
                } catch (InterruptedException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                if (c2955aPoll != null) {
                    c2955a = c2955aPoll;
                    break;
                } else {
                    c2955a = c2955aPoll;
                    OplusGLSurfaceView_13++;
                }
            }
            if (c2955a != null) {
                m16675b(c2955a);
            } else {
                this.f16058e.append("drawLastFrame, ");
                this.f16055b.m16705d();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16675b(Frame c2955a) throws InterruptedException {
        int OplusGLSurfaceView_13 = c2955a.f16059a;
        if (OplusGLSurfaceView_13 == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - c2955a.f16065g;
            StringBuffer stringBuffer = this.f16058e;
            stringBuffer.append("frame thread cost: ");
            stringBuffer.append(jCurrentTimeMillis);
            stringBuffer.append(", ");
            if (jCurrentTimeMillis > 10) {
                m16674b();
                return;
            }
            c2955a.f16064f.lock();
            this.f16058e.append("lock, ");
            if (!c2955a.f16060b.isClosed()) {
                this.f16058e.append("draw, ");
                this.f16055b.m16701a(c2955a, this.f16057d);
            }
            this.f16058e.append("unlock, ");
            c2955a.f16064f.unlock();
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            this.f16058e.append("size change, ");
            this.f16055b.m16702b(c2955a, this.f16057d);
            this.f16055b.m16704c(c2955a, this.f16057d);
            this.f16054a.offer(new Frame(2));
            requestRender();
            return;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return;
        }
        this.f16058e.append("animation, ");
        boolean zM16704c = this.f16055b.m16704c(c2955a, this.f16057d);
        StringBuffer stringBuffer2 = this.f16058e;
        stringBuffer2.append("end: ");
        stringBuffer2.append(zM16704c);
        stringBuffer2.append(", ");
        if (!zM16704c) {
            this.f16054a.offer(new Frame(2));
            requestRender();
        } else {
            this.f16056c = true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16679a(Frame c2955a) {
        CameraLog.m12959b("OutGLSurfaceView", "addFrame, mbEnable: " + this.f16056c);
        if (this.f16056c) {
            c2955a.f16065g = System.currentTimeMillis();
            this.f16054a.offer(c2955a);
            requestRender();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16677a() {
        CameraLog.m12967f("OutGLSurfaceView", "onStop");
        this.f16056c = false;
        this.f16054a.clear();
        queueEvent(new Runnable() { // from class: com.oplus.camera.screen.out.-$$Lambda$OutGLSurfaceView$fEa94jyWP9wxL254bsOwOa1Be3M
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m16676c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m16676c() {
        this.f16055b.mo16689b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16678a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12967f("OutGLSurfaceView", "changePreviewSize, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        this.f16056c = false;
        this.f16054a.offer(new Frame(OplusGLSurfaceView_13, i2));
        requestRender();
    }
}
