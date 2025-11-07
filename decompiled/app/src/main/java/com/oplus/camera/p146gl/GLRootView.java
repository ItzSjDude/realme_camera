package com.oplus.camera.p146gl;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLRoot;
import com.oplus.camera.p146gl.OplusGLSurfaceView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

/* loaded from: classes2.dex */
public class GLRootView extends OplusGLSurfaceView implements GLRoot, OplusGLSurfaceView.OplusGLSurfaceView_6, OutputRender {

    /* renamed from: PlatformImplementations.kt_3 */
    private final CameraEGLConfigChooser f13807a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ArrayList<CanvasAnimation> f13808b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ArrayDeque<GLRoot.PlatformImplementations.kt_3> f13809c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final IdleRunner f13810d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final ReentrantLock f13811e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Condition f13812f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f13813g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private long f13814h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13815i;

    /* renamed from: OplusGLSurfaceView_15 */
    private GL11 f13816j;

    /* renamed from: OplusGLSurfaceView_5 */
    private GLCanvas f13817k;

    /* renamed from: OplusGLSurfaceView_14 */
    private GLView f13818l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f13819m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Matrix f13820n;

    /* renamed from: o */
    private int f13821o;

    /* renamed from: p */
    private int f13822p;

    /* renamed from: q */
    private volatile boolean f13823q;

    /* renamed from: r */
    private boolean f13824r;

    /* renamed from: s */
    private boolean f13825s;

    /* renamed from: t */
    private boolean f13826t;

    /* renamed from: u */
    private boolean f13827u;

    /* renamed from: v */
    private int f13828v;

    /* renamed from: w */
    private int f13829w;

    /* renamed from: x */
    private GLRootViewListener f13830x;

    /* renamed from: y */
    private boolean f13831y;

    /* renamed from: z */
    private boolean f13832z;

    public interface GLRootViewListener {
        void onSurfaceChanged();

        void onSurfaceCreated();
    }

    public GLRootView(Context context) {
        this(context, null);
    }

    public GLRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13807a = new CameraEGLConfigChooser();
        this.f13808b = new ArrayList<>();
        this.f13809c = new ArrayDeque<>();
        this.f13810d = new IdleRunner();
        this.f13811e = new ReentrantLock();
        this.f13812f = this.f13811e.newCondition();
        this.f13813g = 0;
        this.f13814h = 0L;
        this.f13815i = 0;
        this.f13820n = new Matrix();
        this.f13822p = 2;
        this.f13823q = false;
        this.f13825s = false;
        this.f13826t = true;
        this.f13827u = false;
        this.f13828v = 0;
        this.f13829w = 0;
        this.f13830x = null;
        this.f13831y = false;
        this.f13832z = false;
        setEGLContextClientVersion(2);
        this.f13822p |= 1;
        setBackgroundDrawable(null);
        setEGLConfigChooser(this.f13807a);
        m14131a(this, "PreviewGLThread");
        setOutputRender(this);
        getHolder().setFormat(3);
    }

    public void setGLRootViewListener(GLRootViewListener gLRootViewListener) {
        this.f13830x = gLRootViewListener;
    }

    public synchronized boolean getSurfaceState() {
        return this.f13831y;
    }

    public void setContentPane(GLView gLView) {
        GLView gLView2 = this.f13818l;
        if (gLView2 == gLView) {
            return;
        }
        if (gLView2 != null) {
            if (this.f13825s) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f13818l.m13813b(motionEventObtain);
                motionEventObtain.recycle();
                this.f13825s = false;
            }
            this.f13818l.m13810b();
            BasicTexture.m13922a();
        }
        this.f13818l = gLView;
        if (gLView != null) {
            gLView.m13806a(this);
            m13793b();
        }
    }

    public void setNeedLutTexture(boolean z) {
        this.f13832z = z;
        GLCanvas interfaceC2757h = this.f13817k;
        if (interfaceC2757h != null) {
            interfaceC2757h.mo13976a(z);
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView, com.oplus.camera.p146gl.GLRoot
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13788a() {
        if (this.f13827u) {
            Log.OplusGLSurfaceView_13("GLRootView", "requestRender, Activity.finish(), so return");
        } else {
            if (this.f13823q) {
                return;
            }
            this.f13823q = true;
            super.mo13788a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13793b() {
        Log.v("GLRootView", "requestLayoutContentPane, mRenderLock.lock()");
        this.f13811e.lock();
        try {
            if (this.f13818l != null && (this.f13822p & 2) == 0 && (this.f13822p & 1) != 0) {
                this.f13822p |= 2;
                mo13788a();
            }
        } finally {
            this.f13811e.unlock();
            Log.v("GLRootView", "requestLayoutContentPane, mRenderLock.unlock()");
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m13786m() {
        this.f13822p &= -3;
        int width = getWidth();
        int height = getHeight();
        if (this.f13819m != 0 || width != this.f13828v || height != this.f13829w) {
            this.f13819m = 0;
            int OplusGLSurfaceView_13 = this.f13819m;
            if (OplusGLSurfaceView_13 % 180 != 0) {
                this.f13820n.setRotate(OplusGLSurfaceView_13);
                this.f13820n.preTranslate((-width) / 2, (-height) / 2);
                this.f13820n.postTranslate(height / 2, width / 2);
            } else {
                this.f13820n.setRotate(OplusGLSurfaceView_13, width / 2, height / 2);
            }
            this.f13821o = 0;
            this.f13828v = width;
            this.f13829w = height;
        }
        if (this.f13819m % 180 != 0) {
            height = width;
            width = height;
        }
        Log.OplusGLSurfaceView_13("GLRootView", "layoutContentPane, size: " + width + "x" + height + ", compensation: " + this.f13819m);
        GLView gLView = this.f13818l;
        if (gLView == null || width == 0 || height == 0) {
            return;
        }
        gLView.mo13802a(0, 0, width, height);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (z) {
            m13793b();
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13792a(GL10 gl10, EGLConfig eGLConfig) {
        Log.OplusGLSurfaceView_13("GLRootView", "onSurfaceCreated(GL10 gl1, EGLConfig config)");
        GL11 gl11 = (GL11) gl10;
        if (this.f13816j != null) {
            Log.OplusGLSurfaceView_13("GLRootView", "GLObject has changed from " + this.f13816j + " to " + gl11);
        }
        CameraLog.m12954a("GLRootView", "onSurfaceCreated, mRenderLock.lock()");
        this.f13811e.lock();
        try {
            this.f13816j = gl11;
            this.f13817k = new GLES20Canvas();
            this.f13817k.mo13976a(this.f13832z);
            BasicTexture.m13923b();
            this.f13811e.unlock();
            CameraLog.m12954a("GLRootView", "onSurfaceCreated, mRenderLock.unlock()");
            setRenderMode(0);
            GLRootViewListener gLRootViewListener = this.f13830x;
            if (gLRootViewListener != null) {
                gLRootViewListener.onSurfaceCreated();
            }
            GLView gLView = this.f13818l;
            if (gLView != null) {
                gLView.mo13817f();
            }
            this.f13831y = true;
            this.f13827u = false;
            Log.v("GLRootView", "onSurfaceCreated mFinsh = false");
        } catch (Throwable th) {
            this.f13811e.unlock();
            CameraLog.m12954a("GLRootView", "onSurfaceCreated, mRenderLock.unlock()");
            throw th;
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13791a(GL10 gl10, int OplusGLSurfaceView_13, int i2) throws SecurityException, IllegalArgumentException {
        Log.OplusGLSurfaceView_13("GLRootView", "onSurfaceChanged: " + OplusGLSurfaceView_13 + "x" + i2 + ", gl10: " + gl10.toString() + ", mGLRootViewListener:" + this.f13830x);
        Process.setThreadPriority(-4);
        Utils_3.m14289a(this.f13816j == ((GL11) gl10));
        this.f13817k.mo13966a(OplusGLSurfaceView_13, i2);
        GLRootViewListener gLRootViewListener = this.f13830x;
        if (gLRootViewListener != null) {
            gLRootViewListener.onSurfaceChanged();
        }
        GLView gLView = this.f13818l;
        if (gLView != null) {
            gLView.mo13801a(OplusGLSurfaceView_13, i2);
        }
        this.f13831y = true;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m13787n() {
        long jNanoTime = System.nanoTime();
        long OplusGLSurfaceView_15 = this.f13814h;
        if (OplusGLSurfaceView_15 == 0) {
            this.f13814h = jNanoTime;
        } else if (jNanoTime - OplusGLSurfaceView_15 > C1547C.NANOS_PER_SECOND) {
            Log.w("GLRootView", "outputFps, fps: " + ((this.f13813g * 1.0E9d) / (jNanoTime - this.f13814h)));
            this.f13814h = jNanoTime;
            this.f13813g = 0;
        }
        this.f13813g++;
    }

    @Override // com.oplus.camera.p146gl.OutputRender
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13790a(GL10 gl10, int OplusGLSurfaceView_13) {
        GLView gLView = this.f13818l;
        if (gLView != null) {
            gLView.mo13804a(this.f13817k, OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.OplusGLSurfaceView_6
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13789a(GL10 gl10) {
        AnimationTime.m13866a();
        this.f13811e.lock();
        while (this.f13824r) {
            this.f13812f.awaitUninterruptibly();
        }
        try {
            m13783b(gl10);
            this.f13811e.unlock();
            if (this.f13826t) {
                this.f13826t = false;
            }
        } catch (Throwable th) {
            this.f13811e.unlock();
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13783b(GL10 gl10) {
        m13787n();
        this.f13817k.mo13986g();
        UploadedTexture.m14280s();
        this.f13823q = false;
        if ((this.f13822p & 2) != 0) {
            m13786m();
        }
        this.f13817k.mo13965a(-1);
        m13781a(-this.f13819m);
        GLView gLView = this.f13818l;
        if (gLView != null) {
            gLView.mo13803a(this.f13817k);
        }
        this.f13817k.mo13985f();
        if (!this.f13808b.isEmpty()) {
            long jM13867b = AnimationTime.m13867b();
            int size = this.f13808b.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                this.f13808b.get(OplusGLSurfaceView_13).m13820a(jM13867b);
            }
            this.f13808b.clear();
        }
        if (UploadedTexture.m14281t()) {
            mo13788a();
        }
        synchronized (this.f13809c) {
            if (!this.f13809c.isEmpty()) {
                this.f13810d.enable();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13781a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return;
        }
        this.f13817k.mo13959a(getWidth() / 2, getHeight() / 2);
        this.f13817k.mo13961a(OplusGLSurfaceView_13, 0.0f, 0.0f, 1.0f);
        if (OplusGLSurfaceView_13 % 180 != 0) {
            this.f13817k.mo13959a(-r1, -r0);
        } else {
            this.f13817k.mo13959a(-r0, -r1);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f13825s = false;
        } else if (!this.f13825s && action != 0) {
            return false;
        }
        if (this.f13819m != 0) {
            motionEvent.transform(this.f13820n);
        }
        CameraLog.m12954a("GLRootView", "dispatchTouchEvent, mRenderLock.lock()");
        this.f13811e.lock();
        try {
            if (this.f13818l != null && this.f13818l.m13813b(motionEvent)) {
                z = true;
            }
            if (action == 0 && z) {
                this.f13825s = true;
            }
            return z;
        } finally {
            this.f13811e.unlock();
            CameraLog.m12954a("GLRootView", "dispatchTouchEvent, mRenderLock.unlock()");
        }
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13794c() {
        super.mo13794c();
        this.f13827u = false;
        Log.v("GLRootView", "onResume mFinsh = false");
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13795d() {
        m13796e();
        super.mo13795d();
        this.f13831y = false;
        this.f13830x = null;
    }

    public int getDisplayRotation() {
        return this.f13821o;
    }

    public int getCompensation() {
        return this.f13819m;
    }

    public Matrix getCompensationMatrix() {
        return this.f13820n;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m13796e() {
        Log.v("GLRootView", "unfreeze, mRenderLock.lock()");
        this.f13811e.lock();
        try {
            this.f13824r = false;
            this.f13812f.signalAll();
        } finally {
            this.f13811e.unlock();
            Log.v("GLRootView", "unfreeze, mRenderLock.unlock()");
        }
    }

    public void setLightsOutMode(boolean z) {
        setSystemUiVisibility(z ? 261 : 0);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m13797f() {
        this.f13827u = true;
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int OplusGLSurfaceView_13, int i2, int i3) {
        m13796e();
        super.surfaceChanged(surfaceHolder, OplusGLSurfaceView_13, i2, i3);
        CameraLog.m12954a("GLRootView", "surfaceChanged, w: " + i2 + ", COUIBaseListPopupWindow_10: " + i3);
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        m13796e();
        super.surfaceCreated(surfaceHolder);
        CameraLog.m12954a("GLRootView", "surfaceCreated");
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        m13796e();
        super.surfaceDestroyed(surfaceHolder);
        CameraLog.m12954a("GLRootView", "surfaceDestroyed");
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        m13796e();
        super.onDetachedFromWindow();
    }

    @Override // com.oplus.camera.p146gl.OplusGLSurfaceView
    protected void finalize() throws Throwable {
        try {
            m13796e();
        } finally {
            super.finalize();
        }
    }

    private class IdleRunner implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f13834b;

        private IdleRunner() {
            this.f13834b = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (GLRootView.this.f13809c) {
                this.f13834b = false;
                if (GLRootView.this.f13809c.isEmpty()) {
                    return;
                }
                GLRoot.PlatformImplementations.kt_3 aVar = (GLRoot.PlatformImplementations.kt_3) GLRootView.this.f13809c.removeFirst();
                Log.v("GLRootView", "IdleRunner run, mRenderLock.lock()");
                GLRootView.this.f13811e.lock();
                try {
                    if (aVar.m14100a(GLRootView.this.f13817k, GLRootView.this.f13823q)) {
                        GLRootView.this.f13811e.unlock();
                        Log.v("GLRootView", "IdleRunner run, mRenderLock.unlock()");
                        synchronized (GLRootView.this.f13809c) {
                            GLRootView.this.f13809c.addLast(aVar);
                            if (!GLRootView.this.f13823q) {
                                enable();
                            }
                        }
                    }
                } finally {
                    GLRootView.this.f13811e.unlock();
                    Log.v("GLRootView", "IdleRunner run, mRenderLock.unlock()");
                }
            }
        }

        public void enable() {
            if (this.f13834b) {
                return;
            }
            this.f13834b = true;
            GLRootView.this.m14132a(this);
        }
    }
}
