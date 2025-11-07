package com.p094b.p095a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.ConditionVariable;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import com.p094b.p095a.p096a.AnimationManager;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import org.andresoviedo.p225a.p226a.GL;

/* compiled from: ModelSurfaceView.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class ModelSurfaceView extends SurfaceView {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final String f6172c = "COUIBaseListPopupWindow_8";

    /* renamed from: PlatformImplementations.kt_3 */
    public SurfaceListener f6173a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f6174b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ModelActivity f6175d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ModelRenderer f6176e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f6177f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private TouchController f6178g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f6179h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6180i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f6181j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Surface f6182k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f6183l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ConditionVariable f6184m;

    /* renamed from: OplusGLSurfaceView_11 */
    private AtomicBoolean f6185n;

    /* renamed from: o */
    private AtomicBoolean f6186o;

    public ModelSurfaceView(ModelActivity c1232c, Surface surface, int OplusGLSurfaceView_13, int i2, SurfaceListener interfaceC1240k) throws IllegalAccessException, IOException {
        super(c1232c.f6108c);
        this.f6179h = 0;
        this.f6180i = 0;
        this.f6181j = 0.75f;
        this.f6182k = null;
        this.f6183l = false;
        this.f6184m = new ConditionVariable(false);
        this.f6185n = new AtomicBoolean(false);
        this.f6186o = new AtomicBoolean(false);
        this.f6174b = 0;
        this.f6182k = surface;
        this.f6179h = OplusGLSurfaceView_13;
        this.f6180i = i2;
        this.f6173a = interfaceC1240k;
        try {
            Log.m6278d("ModelSurfaceView", "Loading [OpenGL 2] ModelSurfaceView...");
            this.f6175d = c1232c;
            this.f6176e = new ModelRenderer(this);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.m6275a("ModelActivity", COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
            Toast.makeText(c1232c.f6108c, "Error loading shaders:\OplusGLSurfaceView_11" + COUIBaseListPopupWindow_8.getMessage(), 1).show();
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    public void setVideoResizeRatio(float COUIBaseListPopupWindow_12) {
        this.f6181j = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6309a() {
        if (!this.f6185n.get()) {
            this.f6177f = new PlatformImplementations.kt_3();
            getHolder().addCallback(this.f6177f);
        }
        this.f6183l = false;
        if (this.f6182k != null) {
            this.f6186o.set(true);
            this.f6177f.surfaceCreated(null);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6310b() {
        this.f6177f.m6313a();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6311c() {
        Log.m6277c(f6172c, "onLoadComplete");
        this.f6184m.open();
    }

    public void setTouchController(TouchController c1241l) {
        this.f6178g = c1241l;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return this.f6178g.m6359a(motionEvent);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.m6275a("ModelSurfaceView", "Exception: " + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
            return false;
        }
    }

    public ModelActivity getModelActivity() {
        return this.f6175d;
    }

    public ModelRenderer getModelRenderer() {
        return this.f6176e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m6301b(EGLSurface eGLSurface) {
        return (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) ? false : true;
    }

    /* compiled from: ModelSurfaceView.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends Thread implements SurfaceHolder.Callback {

        /* renamed from: PlatformImplementations.kt_3 */
        int[] f6187a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private volatile boolean f6189c;

        private PlatformImplementations.kt_3() {
            this.f6189c = false;
            this.f6187a = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 5, 12610, 1, 12325, 24, 12344};
        }

        /* renamed from: PlatformImplementations.kt_3 */
        EGLConfig m6312a(EGLDisplay eGLDisplay) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(eGLDisplay, this.f6187a, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[]{0}, 0);
            return eGLConfigArr[0];
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m6313a() {
            this.f6189c = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (ModelSurfaceView.this.f6185n.get()) {
                return;
            }
            if (ModelSurfaceView.this.f6176e != null) {
                if (ModelSurfaceView.this.f6182k == null) {
                    throw new RuntimeException("no output surface");
                }
                EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                int[] iArr = new int[2];
                EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
                EGLConfig eGLConfigM6312a = m6312a(eGLDisplayEglGetDisplay);
                EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfigM6312a, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplayEglGetDisplay, eGLConfigM6312a, ModelSurfaceView.this.f6182k, new int[]{12344}, 0);
                EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, eGLContextEglCreateContext);
                ModelSurfaceView.this.f6176e.onSurfaceCreated(null, null);
                if (!ModelSurfaceView.m6301b(eGLSurfaceEglCreateWindowSurface)) {
                    throw new RuntimeException("Failed to create surface");
                }
                GL.f24804a.m26079a(0.0f, 0.0f, 0.0f, 1.0f);
                ModelSurfaceView.this.f6185n.set(true);
                Log.m6277c(ModelSurfaceView.f6172c, "render start --E");
                ModelSurfaceView.this.f6184m.block();
                boolean zM6291a = false;
                boolean z = false;
                long jCurrentTimeMillis = 0;
                int OplusGLSurfaceView_13 = 0;
                boolean z2 = true;
                while (!this.f6189c && !zM6291a) {
                    if (!ModelSurfaceView.this.f6183l) {
                        if (ModelSurfaceView.this.f6186o.get()) {
                            GL.f24804a.m26096b(0, 0, ModelSurfaceView.this.f6179h, ModelSurfaceView.this.f6180i);
                            ModelSurfaceView.this.f6176e.onSurfaceChanged(null, ModelSurfaceView.this.f6179h, ModelSurfaceView.this.f6180i);
                            ModelSurfaceView.this.f6186o.set(false);
                        }
                        zM6291a = ModelSurfaceView.this.f6176e.m6291a(null);
                        if (z2 && OplusGLSurfaceView_13 == 0) {
                            z2 = false;
                        } else {
                            EGL14.eglSwapBuffers(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
                            if (!z && ModelSurfaceView.this.f6173a != null) {
                                Log.m6277c("SurfaceListener", "Calling onRenderStart on " + ModelSurfaceView.this.f6173a);
                                ModelSurfaceView.this.f6173a.mo6353a(ModelSurfaceView.this.f6182k);
                                z = true;
                            }
                        }
                    }
                    if (ModelSurfaceView.this.f6173a != null && !ModelSurfaceView.this.f6173a.m6355a(jCurrentTimeMillis)) {
                        break;
                    } else if (!zM6291a) {
                        OplusGLSurfaceView_13++;
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (ModelSurfaceView.this.f6173a != null) {
                    Log.m6277c("SurfaceListener", "Calling onRenderFinish on " + ModelSurfaceView.this.f6173a);
                    ModelSurfaceView.this.f6173a.mo6356b(ModelSurfaceView.this.f6182k);
                }
                Log.m6277c(ModelSurfaceView.f6172c, "render end --X totalCount : " + OplusGLSurfaceView_13);
                EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
                EGL14.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
                ModelSurfaceView.this.f6185n.set(false);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(eGLDisplayEglGetDisplay);
                GL.f24804a.m26106d();
                if (ModelSurfaceView.this.f6173a != null) {
                    ModelSurfaceView.this.f6173a.mo6357b((AnimationManager) null);
                    return;
                }
                return;
            }
            throw new RuntimeException("no renderer set");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (isAlive() || isInterrupted() || getState() == Thread.State.TERMINATED) {
                return;
            }
            start();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int OplusGLSurfaceView_13, int i2, int i3) {
            if (ModelSurfaceView.this.f6179h != i2) {
                ModelSurfaceView.this.f6179h = i2;
                ModelSurfaceView.this.f6186o.set(true);
            }
            if (ModelSurfaceView.this.f6180i != i3) {
                ModelSurfaceView.this.f6180i = i3;
                ModelSurfaceView.this.f6186o.set(true);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            interrupt();
            ModelSurfaceView.this.getHolder().removeCallback(this);
        }
    }
}
