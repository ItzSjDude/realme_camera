package com.oplus.camera.p146gl;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.os.Process;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.perf.CameraPerformance;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: OplusGLSurfaceView.java */
/* renamed from: com.oplus.camera.gl.q */
/* loaded from: classes2.dex */
public class OplusGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: PlatformImplementations.kt_3 */
    private static OplusGLSurfaceView_15 f14115a = new OplusGLSurfaceView_15();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final WeakReference<OplusGLSurfaceView> f14116b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Surface f14117c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private OutputRender f14118d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f14119e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private OplusGLSurfaceView_13 f14120f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private OplusGLSurfaceView_6 f14121g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f14122h;

    /* renamed from: OplusGLSurfaceView_13 */
    private COUIBaseListPopupWindow_8 f14123i;

    /* renamed from: OplusGLSurfaceView_15 */
    private COUIBaseListPopupWindow_12 f14124j;

    /* renamed from: OplusGLSurfaceView_5 */
    private COUIBaseListPopupWindow_11 f14125k;

    /* renamed from: OplusGLSurfaceView_14 */
    private OplusGLSurfaceView_5 f14126l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f14127m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f14128n;

    /* renamed from: o */
    private boolean f14129o;

    /* renamed from: p */
    private Surface f14130p;

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$COUIBaseListPopupWindow_12 */
    public interface COUIBaseListPopupWindow_12 {
        /* renamed from: PlatformImplementations.kt_3 */
        EGLContext mo14139a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14140a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$COUIBaseListPopupWindow_11 */
    public interface COUIBaseListPopupWindow_11 {
        /* renamed from: PlatformImplementations.kt_3 */
        EGLSurface mo14141a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14142a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$OplusGLSurfaceView_5 */
    public interface OplusGLSurfaceView_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        GL m14186a(GL gl);
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$OplusGLSurfaceView_6 */
    public interface OplusGLSurfaceView_6 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo13789a(GL10 gl10);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo13791a(GL10 gl10, int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo13792a(GL10 gl10, EGLConfig eGLConfig);
    }

    public OplusGLSurfaceView(Context context) {
        super(context);
        this.f14116b = new WeakReference<>(this);
        this.f14117c = null;
        this.f14118d = null;
        this.f14119e = false;
        this.f14120f = null;
        this.f14121g = null;
        this.f14122h = false;
        this.f14123i = null;
        this.f14124j = null;
        this.f14125k = null;
        this.f14126l = null;
        this.f14127m = 0;
        this.f14128n = 0;
        this.f14129o = true;
        this.f14130p = null;
        m14117b();
    }

    public OplusGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14116b = new WeakReference<>(this);
        this.f14117c = null;
        this.f14118d = null;
        this.f14119e = false;
        this.f14120f = null;
        this.f14121g = null;
        this.f14122h = false;
        this.f14123i = null;
        this.f14124j = null;
        this.f14125k = null;
        this.f14126l = null;
        this.f14127m = 0;
        this.f14128n = 0;
        this.f14129o = true;
        this.f14130p = null;
        m14117b();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f14120f != null) {
                this.f14120f.m14183h();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14117b() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(OplusGLSurfaceView_5 kVar) {
        this.f14126l = kVar;
    }

    public void setDebugFlags(int i2) {
        this.f14127m = i2;
    }

    public int getDebugFlags() {
        return this.f14127m;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.f14129o = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f14129o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14131a(OplusGLSurfaceView_6 mVar, String str) {
        m14121e();
        if (this.f14123i == null) {
            this.f14123i = new OplusGLSurfaceView_11(true);
        }
        if (this.f14124j == null) {
            this.f14124j = new IntrinsicsJvm.kt_3();
        }
        if (this.f14125k == null) {
            this.f14125k = new IntrinsicsJvm.kt_5();
        }
        this.f14121g = mVar;
        this.f14120f = new OplusGLSurfaceView_13(this.f14116b);
        if ("PreviewGLThread".equals(str)) {
            this.f14120f.f14155a = true;
        } else {
            this.f14120f.f14155a = false;
        }
        this.f14120f.setName(str + this.f14120f.getId());
        this.f14120f.start();
    }

    public void setEGLContextFactory(COUIBaseListPopupWindow_12 fVar) {
        m14121e();
        this.f14124j = fVar;
    }

    public void setEGLWindowSurfaceFactory(COUIBaseListPopupWindow_11 gVar) {
        m14121e();
        this.f14125k = gVar;
    }

    public void setEGLConfigChooser(COUIBaseListPopupWindow_8 eVar) {
        m14121e();
        this.f14123i = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new OplusGLSurfaceView_11(z));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14130a(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new IntrinsicsJvm.kt_4(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        m14121e();
        this.f14128n = i2;
    }

    public void setRenderMode(int i2) {
        this.f14120f.m14172a(i2);
    }

    public int getRenderMode() {
        return this.f14120f.m14177b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13788a() {
        this.f14120f.m14178c();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f14120f.m14179d();
        CameraLog.m12954a("GLSurfaceView", "surfaceCreated");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f14120f.m14180e();
        CameraLog.m12954a("GLSurfaceView", "surfaceDestroyed");
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.f14120f.m14173a(i3, i4);
        CameraLog.m12954a("GLSurfaceView", "surfaceChanged, w: " + i3 + ", COUIBaseListPopupWindow_10: " + i4);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13795d() {
        this.f14120f.m14181f();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13794c() {
        this.f14120f.m14182g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14132a(Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        OplusGLSurfaceView_13 iVar = this.f14120f;
        if (threadCurrentThread == iVar) {
            runnable.run();
        } else {
            iVar.m14174a(runnable);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m14133g() {
        OplusGLSurfaceView_13 iVar = this.f14120f;
        if (iVar == null || iVar.f14176v == null || this.f14120f.f14176v.f14150e == null) {
            return;
        }
        this.f14120f.f14176v.m14160b(this.f14120f.f14176v.f14150e);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14122h && this.f14121g != null) {
            OplusGLSurfaceView_13 iVar = this.f14120f;
            int iM14177b = iVar != null ? iVar.m14177b() : 1;
            this.f14120f = new OplusGLSurfaceView_13(this.f14116b);
            if (iM14177b != 1) {
                this.f14120f.m14172a(iM14177b);
            }
            this.f14120f.start();
        }
        this.f14122h = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        OplusGLSurfaceView_13 iVar = this.f14120f;
        if (iVar != null) {
            iVar.m14183h();
        }
        this.f14122h = true;
        super.onDetachedFromWindow();
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 implements COUIBaseListPopupWindow_12 {
        private IntrinsicsJvm.kt_3() {
        }

        @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public EGLContext mo14139a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, OplusGLSurfaceView.this.f14128n, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (OplusGLSurfaceView.this.f14128n == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo14140a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            CameraLog.m12967f("GLSurfaceView", "destroyContext, display: " + eGLDisplay + " context: " + eGLContext);
            COUIBaseListPopupWindow_10.m14146a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$IntrinsicsJvm.kt_5 */
    private static class IntrinsicsJvm.kt_5 implements COUIBaseListPopupWindow_11 {
        private IntrinsicsJvm.kt_5() {
        }

        @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.COUIBaseListPopupWindow_11
        /* renamed from: PlatformImplementations.kt_3 */
        public EGLSurface mo14141a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                CameraLog.m12965d("GLSurfaceView", "eglCreateWindowSurface", COUIBaseListPopupWindow_8);
                return null;
            }
        }

        @Override // com.oplus.camera.p146gl.OplusGLSurfaceView.COUIBaseListPopupWindow_11
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo14142a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$PlatformImplementations.kt_3 */
    private abstract class PlatformImplementations.kt_3 implements COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        protected int[] f14135a;

        public PlatformImplementations.kt_3(int[] iArr) {
            this.f14135a = null;
            this.f14135a = m14138a(iArr);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int[] m14138a(int[] iArr) {
            if (OplusGLSurfaceView.this.f14128n != 2 && OplusGLSurfaceView.this.f14128n != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int OplusGLSurfaceView_13 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, OplusGLSurfaceView_13);
            iArr2[OplusGLSurfaceView_13] = 12352;
            if (OplusGLSurfaceView.this.f14128n == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected int f14137c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        protected int f14138d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        protected int f14139e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        protected int f14140f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        protected int f14141g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        protected int f14142h;

        /* renamed from: OplusGLSurfaceView_15 */
        private int[] f14144j;

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, OplusGLSurfaceView_13, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f14137c = 0;
            this.f14138d = 0;
            this.f14139e = 0;
            this.f14140f = 0;
            this.f14141g = 0;
            this.f14142h = 0;
            this.f14144j = null;
            this.f14144j = new int[1];
            this.f14137c = OplusGLSurfaceView_13;
            this.f14138d = i2;
            this.f14139e = i3;
            this.f14140f = i4;
            this.f14141g = i5;
            this.f14142h = i6;
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$OplusGLSurfaceView_11 */
    private class OplusGLSurfaceView_11 extends IntrinsicsJvm.kt_4 {
        public OplusGLSurfaceView_11(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$COUIBaseListPopupWindow_10 */
    private static class COUIBaseListPopupWindow_10 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final int[] f14146a = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};

        /* renamed from: IntrinsicsJvm.kt_4 */
        private WeakReference<OplusGLSurfaceView> f14147b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private EGL10 f14148c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private EGLDisplay f14149d = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private EGLSurface f14150e = null;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private EGLSurface f14151f = null;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private EGLConfig f14152g = null;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private EGLContext f14153h = null;

        /* renamed from: OplusGLSurfaceView_13 */
        private EGLSurface f14154i = null;

        public COUIBaseListPopupWindow_10(WeakReference<OplusGLSurfaceView> weakReference) {
            this.f14147b = null;
            this.f14147b = weakReference;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14159a() {
            this.f14148c = (EGL10) EGLContext.getEGL();
            this.f14149d = this.f14148c.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f14149d == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f14148c.eglInitialize(this.f14149d, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14147b.get();
            if (surfaceHolderCallbackC2766q == null) {
                this.f14152g = null;
                this.f14153h = null;
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                this.f14148c.eglChooseConfig(this.f14149d, f14146a, eGLConfigArr, eGLConfigArr.length, new int[1]);
                this.f14152g = eGLConfigArr[0];
                this.f14153h = surfaceHolderCallbackC2766q.f14124j.mo14139a(this.f14148c, this.f14149d, this.f14152g);
            }
            EGLContext eGLContext = this.f14153h;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f14153h = null;
                m14145a("createContext");
            }
            CameraLog.m12954a("GLSurfaceView", "start, createContext: " + this.f14153h + ", tid: " + Thread.currentThread().getId());
            this.f14150e = null;
            this.f14151f = null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m14161b() {
            if (this.f14148c == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f14149d == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f14152g == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            m14156g();
            OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14147b.get();
            if (surfaceHolderCallbackC2766q != null) {
                this.f14150e = surfaceHolderCallbackC2766q.f14125k.mo14141a(this.f14148c, this.f14149d, this.f14152g, surfaceHolderCallbackC2766q.getHolder());
            } else {
                this.f14150e = null;
            }
            EGLSurface eGLSurface = this.f14150e;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.f14148c.eglGetError() == 12299) {
                    CameraLog.m12967f("GLSurfaceView", "createSurface, createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            EGL10 egl10 = this.f14148c;
            EGLDisplay eGLDisplay = this.f14149d;
            EGLSurface eGLSurface2 = this.f14150e;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.f14153h)) {
                return true;
            }
            m14147a("GLSurfaceView", "eglMakeCurrent", this.f14148c.eglGetError());
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public EGLSurface m14158a(Surface surface) {
            CameraLog.m12954a("GLSurfaceView", "createOutputEGLSurface");
            if (this.f14148c == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f14149d == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f14152g == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14147b.get();
            EGLSurface eGLSurfaceMo14141a = surfaceHolderCallbackC2766q != null ? surfaceHolderCallbackC2766q.f14125k.mo14141a(this.f14148c, this.f14149d, this.f14152g, surface) : null;
            if (eGLSurfaceMo14141a == null || eGLSurfaceMo14141a == EGL10.EGL_NO_SURFACE) {
                if (this.f14148c.eglGetError() == 12299) {
                    CameraLog.m12967f("GLSurfaceView", "createOutputEGLSurface, createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return null;
            }
            if (this.f14148c.eglMakeCurrent(this.f14149d, eGLSurfaceMo14141a, eGLSurfaceMo14141a, this.f14153h)) {
                return eGLSurfaceMo14141a;
            }
            m14147a("GLSurfaceView", "eglMakeCurrent", this.f14148c.eglGetError());
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: COUIBaseListPopupWindow_12 */
        public GL m14155f() {
            GL gl = this.f14153h.getGL();
            OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14147b.get();
            if (surfaceHolderCallbackC2766q == null) {
                return gl;
            }
            if (surfaceHolderCallbackC2766q.f14126l != null) {
                gl = surfaceHolderCallbackC2766q.f14126l.m14186a(gl);
            }
            if ((surfaceHolderCallbackC2766q.f14127m & 3) != 0) {
                return GLDebugHelper.wrap(gl, (surfaceHolderCallbackC2766q.f14127m & 1) != 0 ? 1 : 0, (surfaceHolderCallbackC2766q.f14127m & 2) != 0 ? new OplusGLSurfaceView_14() : null);
            }
            return gl;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m14162c() {
            CameraLog.m12955a("EGL10.eglSwapBuffers", "70pv_eglSwapBuffers", CameraConstant.f13119d.longValue());
            if (!this.f14148c.eglSwapBuffers(this.f14149d, this.f14150e)) {
                CameraLog.m12964d("EGL10.eglSwapBuffers", "70pv_eglSwapBuffers");
                CameraLog.m12955a("EGL10.eglSwapBuffersError", "71pv_eglSwapBuffersError", CameraConstant.f13119d.longValue());
                CameraLog.m12964d("EGL10.eglSwapBuffersError", "71pv_eglSwapBuffersError");
                return this.f14148c.eglGetError();
            }
            CameraLog.m12964d("EGL10.eglSwapBuffers", "70pv_eglSwapBuffers");
            return 12288;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m14157a(EGLSurface eGLSurface) {
            EGLDisplay eGLDisplay = this.f14149d;
            if (eGLDisplay == null || eGLSurface == null || this.f14148c.eglSwapBuffers(eGLDisplay, eGLSurface)) {
                return 12288;
            }
            return this.f14148c.eglGetError();
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m14163d() {
            m14156g();
            m14152c(this.f14151f);
            this.f14151f = null;
            m14152c(this.f14154i);
            this.f14154i = null;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        private void m14156g() {
            EGLSurface eGLSurface = this.f14150e;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f14148c.eglMakeCurrent(this.f14149d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14147b.get();
            if (surfaceHolderCallbackC2766q != null) {
                surfaceHolderCallbackC2766q.f14125k.mo14142a(this.f14148c, this.f14149d, this.f14150e);
            }
            this.f14150e = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m14152c(EGLSurface eGLSurface) {
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f14148c.eglMakeCurrent(this.f14149d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14147b.get();
            if (surfaceHolderCallbackC2766q != null) {
                surfaceHolderCallbackC2766q.f14125k.mo14142a(this.f14148c, this.f14149d, eGLSurface);
            }
            CameraLog.m12966e("GLSurfaceView", "destroyOutputEGLSurfaceImp, error: " + this.f14148c.eglGetError());
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m14164e() {
            if (this.f14153h != null) {
                OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14147b.get();
                if (surfaceHolderCallbackC2766q != null) {
                    CameraLog.m12954a("GLSurfaceView", "finish, destroyContext mEglContext: " + this.f14153h);
                    surfaceHolderCallbackC2766q.f14124j.mo14140a(this.f14148c, this.f14149d, this.f14153h);
                }
                this.f14153h = null;
            }
            EGLDisplay eGLDisplay = this.f14149d;
            if (eGLDisplay != null) {
                this.f14148c.eglTerminate(eGLDisplay);
                this.f14149d = null;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m14145a(String str) {
            m14146a(str, this.f14148c.eglGetError());
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static void m14146a(String str, int OplusGLSurfaceView_13) {
            throw new RuntimeException("error: " + OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static void m14147a(String str, String str2, int OplusGLSurfaceView_13) {
            CameraLog.m12966e(str, "logEglErrorAsWarning, function: " + str2 + ", error: " + OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m14160b(EGLSurface eGLSurface) {
            EGLContext eGLContext;
            if (this.f14150e == null || eGLSurface == null || (eGLContext = this.f14153h) == null || this.f14148c.eglMakeCurrent(this.f14149d, eGLSurface, eGLSurface, eGLContext)) {
                return;
            }
            m14147a("GLSurfaceView", "eglMakeCurrent", this.f14148c.eglGetError());
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$OplusGLSurfaceView_13 */
    static class OplusGLSurfaceView_13 extends Thread {

        /* renamed from: OplusGLSurfaceView_6 */
        private int f14167m;

        /* renamed from: OplusGLSurfaceView_11 */
        private int f14168n;

        /* renamed from: o */
        private int f14169o;

        /* renamed from: p */
        private boolean f14170p;

        /* renamed from: q */
        private boolean f14171q;

        /* renamed from: x */
        private WeakReference<OplusGLSurfaceView> f14178x;

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f14155a = false;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f14156b = false;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f14157c = false;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f14158d = false;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f14159e = false;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f14160f = false;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private boolean f14161g = false;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f14162h = false;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f14163i = false;

        /* renamed from: OplusGLSurfaceView_15 */
        private boolean f14164j = false;

        /* renamed from: OplusGLSurfaceView_5 */
        private boolean f14165k = false;

        /* renamed from: OplusGLSurfaceView_14 */
        private boolean f14166l = false;

        /* renamed from: r */
        private boolean f14172r = false;

        /* renamed from: s */
        private ArrayList<Runnable> f14173s = new ArrayList<>();

        /* renamed from: t */
        private boolean f14174t = true;

        /* renamed from: u */
        private Runnable f14175u = null;

        /* renamed from: v */
        private COUIBaseListPopupWindow_10 f14176v = null;

        /* renamed from: w */
        private boolean f14177w = false;

        OplusGLSurfaceView_13(WeakReference<OplusGLSurfaceView> weakReference) {
            this.f14167m = 0;
            this.f14168n = 0;
            this.f14169o = 0;
            this.f14170p = false;
            this.f14171q = false;
            this.f14178x = null;
            this.f14167m = 0;
            this.f14168n = 0;
            this.f14170p = true;
            this.f14169o = 1;
            this.f14171q = false;
            this.f14178x = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f14155a) {
                CameraPerformance.m15186a("129", Process.myTid());
            }
            try {
                m14170k();
                synchronized (OplusGLSurfaceView.f14115a) {
                    OplusGLSurfaceView.f14115a.m14184a(this);
                }
            } catch (InterruptedException unused) {
                synchronized (OplusGLSurfaceView.f14115a) {
                    OplusGLSurfaceView.f14115a.m14184a(this);
                }
            } catch (Throwable th) {
                synchronized (OplusGLSurfaceView.f14115a) {
                    OplusGLSurfaceView.f14115a.m14184a(this);
                    throw th;
                }
            }
        }

        /* renamed from: OplusGLSurfaceView_13 */
        private void m14168i() {
            if (this.f14164j) {
                this.f14164j = false;
                this.f14176v.m14163d();
            }
        }

        /* renamed from: OplusGLSurfaceView_15 */
        private void m14169j() {
            CameraLog.m12954a("GLSurfaceView", "stopEglContextLocked");
            if (this.f14163i) {
                this.f14176v.m14164e();
                this.f14163i = false;
                OplusGLSurfaceView.f14115a.m14185b(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:177:0x02ed A[Catch: all -> 0x0395, TryCatch #4 {all -> 0x0395, blocks: (B:8:0x0025, B:9:0x0029, B:95:0x0152, B:97:0x015a, B:99:0x0162, B:100:0x0166, B:107:0x0176, B:108:0x0177, B:109:0x017b, B:116:0x018e, B:118:0x0191, B:120:0x019d, B:123:0x01b9, B:125:0x01c0, B:126:0x01c5, B:129:0x01c9, B:132:0x01df, B:134:0x01e6, B:135:0x01eb, B:137:0x01ed, B:143:0x0214, B:147:0x0221, B:149:0x0227, B:154:0x0235, B:155:0x0242, B:166:0x0258, B:168:0x0266, B:170:0x0278, B:172:0x0286, B:174:0x028e, B:176:0x02aa, B:178:0x0305, B:180:0x0313, B:182:0x0325, B:184:0x032d, B:185:0x0344, B:186:0x0350, B:177:0x02ed, B:162:0x0251, B:145:0x021b, B:146:0x0220, B:199:0x0394, B:10:0x002a, B:12:0x002e, B:21:0x003f, B:23:0x0047, B:93:0x014f, B:24:0x0053, B:26:0x0059, B:28:0x0068, B:30:0x006c, B:32:0x0078, B:34:0x0081, B:36:0x0085, B:38:0x008a, B:40:0x008e, B:45:0x00a0, B:43:0x009a, B:46:0x00a3, B:48:0x00a7, B:50:0x00ab, B:52:0x00af, B:53:0x00b2, B:54:0x00bf, B:56:0x00c3, B:58:0x00c7, B:60:0x00d3, B:61:0x00e1, B:63:0x00e5, B:65:0x00ed, B:67:0x00f3, B:71:0x00fb, B:73:0x0101, B:75:0x010d, B:76:0x0114, B:77:0x0115, B:79:0x0119, B:81:0x011d, B:83:0x0125, B:85:0x0129, B:87:0x012d, B:89:0x013c, B:196:0x0387, B:194:0x037a, B:102:0x0168, B:103:0x0171, B:131:0x01d3, B:139:0x0202, B:141:0x0210, B:111:0x017d, B:112:0x0188, B:157:0x0244, B:158:0x024d, B:122:0x01a7), top: B:219:0x0025, inners: #0, #2, #3, #6, #7, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:186:0x0350 A[Catch: all -> 0x0395, TRY_LEAVE, TryCatch #4 {all -> 0x0395, blocks: (B:8:0x0025, B:9:0x0029, B:95:0x0152, B:97:0x015a, B:99:0x0162, B:100:0x0166, B:107:0x0176, B:108:0x0177, B:109:0x017b, B:116:0x018e, B:118:0x0191, B:120:0x019d, B:123:0x01b9, B:125:0x01c0, B:126:0x01c5, B:129:0x01c9, B:132:0x01df, B:134:0x01e6, B:135:0x01eb, B:137:0x01ed, B:143:0x0214, B:147:0x0221, B:149:0x0227, B:154:0x0235, B:155:0x0242, B:166:0x0258, B:168:0x0266, B:170:0x0278, B:172:0x0286, B:174:0x028e, B:176:0x02aa, B:178:0x0305, B:180:0x0313, B:182:0x0325, B:184:0x032d, B:185:0x0344, B:186:0x0350, B:177:0x02ed, B:162:0x0251, B:145:0x021b, B:146:0x0220, B:199:0x0394, B:10:0x002a, B:12:0x002e, B:21:0x003f, B:23:0x0047, B:93:0x014f, B:24:0x0053, B:26:0x0059, B:28:0x0068, B:30:0x006c, B:32:0x0078, B:34:0x0081, B:36:0x0085, B:38:0x008a, B:40:0x008e, B:45:0x00a0, B:43:0x009a, B:46:0x00a3, B:48:0x00a7, B:50:0x00ab, B:52:0x00af, B:53:0x00b2, B:54:0x00bf, B:56:0x00c3, B:58:0x00c7, B:60:0x00d3, B:61:0x00e1, B:63:0x00e5, B:65:0x00ed, B:67:0x00f3, B:71:0x00fb, B:73:0x0101, B:75:0x010d, B:76:0x0114, B:77:0x0115, B:79:0x0119, B:81:0x011d, B:83:0x0125, B:85:0x0129, B:87:0x012d, B:89:0x013c, B:196:0x0387, B:194:0x037a, B:102:0x0168, B:103:0x0171, B:131:0x01d3, B:139:0x0202, B:141:0x0210, B:111:0x017d, B:112:0x0188, B:157:0x0244, B:158:0x024d, B:122:0x01a7), top: B:219:0x0025, inners: #0, #2, #3, #6, #7, #10, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:188:0x0364  */
        /* JADX WARN: Removed duplicated region for block: B:189:0x0366  */
        /* JADX WARN: Removed duplicated region for block: B:213:0x039b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: OplusGLSurfaceView_5 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void m14170k() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 937
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p146gl.OplusGLSurfaceView.OplusGLSurfaceView_13.m14170k():void");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m14166a(GL10 gl10, EGLSurface eGLSurface, int OplusGLSurfaceView_13) {
            this.f14176v.m14160b(eGLSurface);
            OplusGLSurfaceView surfaceHolderCallbackC2766q = this.f14178x.get();
            if (surfaceHolderCallbackC2766q.f14118d != null) {
                surfaceHolderCallbackC2766q.f14118d.mo13790a(gl10, OplusGLSurfaceView_13);
            }
            this.f14176v.m14157a(eGLSurface);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m14176a() {
            return this.f14163i && this.f14164j && m14171l();
        }

        /* renamed from: OplusGLSurfaceView_14 */
        private boolean m14171l() {
            return !this.f14159e && this.f14160f && !this.f14161g && this.f14167m > 0 && this.f14168n > 0 && (this.f14170p || this.f14169o == 1);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14172a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 1) {
                synchronized (OplusGLSurfaceView.f14115a) {
                    this.f14169o = OplusGLSurfaceView_13;
                    OplusGLSurfaceView.f14115a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m14177b() {
            int OplusGLSurfaceView_13;
            synchronized (OplusGLSurfaceView.f14115a) {
                OplusGLSurfaceView_13 = this.f14169o;
            }
            return OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m14178c() {
            synchronized (OplusGLSurfaceView.f14115a) {
                this.f14170p = true;
                OplusGLSurfaceView.f14115a.notifyAll();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m14179d() {
            synchronized (OplusGLSurfaceView.f14115a) {
                this.f14160f = true;
                this.f14165k = false;
                OplusGLSurfaceView.f14115a.notifyAll();
                while (this.f14162h && !this.f14165k && !this.f14157c) {
                    try {
                        OplusGLSurfaceView.f14115a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m14180e() {
            synchronized (OplusGLSurfaceView.f14115a) {
                this.f14160f = false;
                OplusGLSurfaceView.f14115a.notifyAll();
                while (!this.f14162h && !this.f14157c) {
                    try {
                        OplusGLSurfaceView.f14115a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public void m14181f() {
            synchronized (OplusGLSurfaceView.f14115a) {
                this.f14158d = true;
                OplusGLSurfaceView.f14115a.notifyAll();
                while (!this.f14157c && !this.f14159e) {
                    try {
                        CameraLog.m12954a("GLSurfaceView", "onPause, sGLThreadManager.wait");
                        OplusGLSurfaceView.f14115a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public void m14182g() {
            synchronized (OplusGLSurfaceView.f14115a) {
                this.f14158d = false;
                this.f14170p = true;
                this.f14172r = false;
                OplusGLSurfaceView.f14115a.notifyAll();
                while (!this.f14157c && this.f14159e && !this.f14172r) {
                    try {
                        OplusGLSurfaceView.f14115a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14173a(int OplusGLSurfaceView_13, int i2) {
            synchronized (OplusGLSurfaceView.f14115a) {
                this.f14167m = OplusGLSurfaceView_13;
                this.f14168n = i2;
                this.f14174t = true;
                this.f14170p = true;
                this.f14172r = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                OplusGLSurfaceView.f14115a.notifyAll();
                while (!this.f14157c && !this.f14159e && !this.f14172r && m14176a()) {
                    try {
                        OplusGLSurfaceView.f14115a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public void m14183h() {
            synchronized (OplusGLSurfaceView.f14115a) {
                CameraLog.m12954a("GLSurfaceView", "requestExitAndWait");
                this.f14156b = true;
                OplusGLSurfaceView.f14115a.notifyAll();
                while (!this.f14157c) {
                    try {
                        OplusGLSurfaceView.f14115a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14174a(Runnable runnable) {
            if (runnable != null) {
                synchronized (OplusGLSurfaceView.f14115a) {
                    this.f14173s.add(runnable);
                    OplusGLSurfaceView.f14115a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14175a(boolean z) {
            this.f14177w = z;
        }
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$OplusGLSurfaceView_14 */
    static class OplusGLSurfaceView_14 extends Writer {

        /* renamed from: PlatformImplementations.kt_3 */
        private StringBuilder f14179a = new StringBuilder();

        OplusGLSurfaceView_14() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m14187a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            m14187a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int OplusGLSurfaceView_13, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[OplusGLSurfaceView_13 + i3];
                if (c2 == '\OplusGLSurfaceView_11') {
                    m14187a();
                } else {
                    this.f14179a.append(c2);
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m14187a() {
            if (this.f14179a.length() > 0) {
                CameraLog.m12954a("GLSurfaceView", "flushBuilder, mBuilder: " + this.f14179a.toString());
                StringBuilder sb = this.f14179a;
                sb.delete(0, sb.length());
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m14121e() {
        if (this.f14120f != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m14134h() {
        m14132a(new Runnable() { // from class: com.oplus.camera.gl.q.1
            @Override // java.lang.Runnable
            public void run() {
                OplusGLSurfaceView.this.f14120f.f14176v.m14152c(OplusGLSurfaceView.this.f14120f.f14176v.f14151f);
                OplusGLSurfaceView.this.f14120f.f14176v.f14151f = null;
                if (OplusGLSurfaceView.this.f14117c != null) {
                    OplusGLSurfaceView.this.f14117c.release();
                    OplusGLSurfaceView.this.f14117c = null;
                }
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m14135i() {
        m14132a(new Runnable() { // from class: com.oplus.camera.gl.q.2
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("GLSurfaceView", "destroyWatchOutputSurface");
                OplusGLSurfaceView.this.f14120f.f14176v.m14152c(OplusGLSurfaceView.this.f14120f.f14176v.f14154i);
                OplusGLSurfaceView.this.f14120f.f14176v.f14154i = null;
                if (OplusGLSurfaceView.this.f14130p != null) {
                    OplusGLSurfaceView.this.f14130p.release();
                    OplusGLSurfaceView.this.f14130p = null;
                }
            }
        });
    }

    public void setOutputRender(OutputRender interfaceC2767r) {
        this.f14118d = interfaceC2767r;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m14136j() {
        this.f14119e = true;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m14137k() {
        this.f14119e = false;
    }

    public void setOutput(Surface surface) {
        this.f14117c = surface;
    }

    public void setWatchOutputSurface(final Surface surface) {
        m14132a(new Runnable() { // from class: com.oplus.camera.gl.q.3
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("GLSurfaceView", "setWatchOutputSurface");
                OplusGLSurfaceView.this.f14130p = surface;
            }
        });
    }

    public Surface getOutputSurface() {
        return this.f14117c;
    }

    /* compiled from: OplusGLSurfaceView.java */
    /* renamed from: com.oplus.camera.gl.q$OplusGLSurfaceView_15 */
    private static class OplusGLSurfaceView_15 {
        private OplusGLSurfaceView_15() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public synchronized void m14184a(OplusGLSurfaceView_13 iVar) {
            iVar.f14157c = true;
            notifyAll();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m14185b(OplusGLSurfaceView_13 iVar) {
            notifyAll();
        }
    }

    public void setPreventRenderByPause(boolean z) {
        OplusGLSurfaceView_13 iVar = this.f14120f;
        if (iVar != null) {
            iVar.m14175a(z);
        }
    }
}
