package com.oplus.camera.p146gl;

import android.opengl.GLDebugHelper;
import android.util.Log;
import android.view.Choreographer;
import android.view.SurfaceHolder;
import com.sensetime.blur.BlurFilterLibrary;
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

/* compiled from: GLProducer.java */
/* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class GLProducer<T> {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final OplusGLSurfaceView_15 f14042b = new OplusGLSurfaceView_15();

    /* renamed from: PlatformImplementations.kt_3 */
    Choreographer.FrameCallback f14043a = new Choreographer.FrameCallback() { // from class: com.oplus.camera.gl.OplusGLSurfaceView_6.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            GLProducer.this.m14052d();
            if (GLProducer.this.m14051c() == 1) {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final WeakReference<GLProducer> f14044c = new WeakReference<>(this);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private OplusGLSurfaceView_13 f14045d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private OplusGLSurfaceView_6 f14046e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private T f14047f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private COUIBaseListPopupWindow_8 f14048g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUIBaseListPopupWindow_12 f14049h;

    /* renamed from: OplusGLSurfaceView_13 */
    private COUIBaseListPopupWindow_11 f14050i;

    /* renamed from: OplusGLSurfaceView_15 */
    private OplusGLSurfaceView_5 f14051j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f14052k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f14053l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f14054m;

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        EGLConfig mo14058a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$COUIBaseListPopupWindow_12 */
    public interface COUIBaseListPopupWindow_12 {
        /* renamed from: PlatformImplementations.kt_3 */
        EGLContext mo14061a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14062a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$COUIBaseListPopupWindow_11 */
    public interface COUIBaseListPopupWindow_11 {
        /* renamed from: PlatformImplementations.kt_3 */
        EGLSurface mo14063a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14064a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$OplusGLSurfaceView_5 */
    public interface OplusGLSurfaceView_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        GL m14095a(GL gl);
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$OplusGLSurfaceView_6 */
    public interface OplusGLSurfaceView_6 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14097a(GL10 gl10);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14098a(GL10 gl10, int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo14099a(GL10 gl10, EGLConfig eGLConfig);
    }

    public GLProducer(T t) {
        this.f14047f = t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public T m14039a() {
        return this.f14047f;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f14045d != null) {
                this.f14045d.m14091h();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14047a(boolean z) {
        this.f14054m = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14045a(OplusGLSurfaceView_6 mVar) {
        m14038j();
        if (this.f14048g == null) {
            this.f14048g = new OplusGLSurfaceView_11(true);
        }
        if (this.f14049h == null) {
            this.f14049h = new IntrinsicsJvm.kt_3();
        }
        if (this.f14050i == null) {
            this.f14050i = new IntrinsicsJvm.kt_5();
        }
        this.f14046e = mVar;
        this.f14045d = new OplusGLSurfaceView_13(this.f14044c);
        this.f14045d.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14044a(COUIBaseListPopupWindow_8 eVar) {
        m14038j();
        this.f14048g = eVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14041a(int i2, int i3, int i4, int i5, int i6, int i7) {
        m14044a(new IntrinsicsJvm.kt_4(i2, i3, i4, i5, i6, i7));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14040a(int i2) {
        m14038j();
        this.f14053l = i2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14049b(int i2) {
        this.f14045d.m14081a(i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14048b() {
        Choreographer.getInstance().removeFrameCallback(this.f14043a);
        Choreographer.getInstance().postFrameCallback(this.f14043a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m14051c() {
        return this.f14045d.m14085b();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14052d() {
        this.f14045d.m14086c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14042a(SurfaceHolder surfaceHolder) {
        this.f14045d.m14087d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14050b(SurfaceHolder surfaceHolder) {
        this.f14045d.m14088e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14043a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.f14045d.m14082a(i3, i4);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14053e() {
        Log.IntrinsicsJvm.kt_5("GLProducer", "requestExitAndWait");
        OplusGLSurfaceView_13 iVar = this.f14045d;
        if (iVar != null) {
            iVar.m14091h();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14054f() {
        this.f14045d.m14089f();
        Choreographer.getInstance().removeFrameCallback(this.f14043a);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m14055g() {
        this.f14045d.m14090g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14046a(Runnable runnable) {
        this.f14045d.m14083a(runnable);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m14056h() {
        this.f14045d.m14092i();
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 implements COUIBaseListPopupWindow_12 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f14067b;

        private IntrinsicsJvm.kt_3() {
            this.f14067b = 12440;
        }

        @Override // com.oplus.camera.p146gl.GLProducer.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public EGLContext mo14061a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f14067b, GLProducer.this.f14053l, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLProducer.this.f14053l == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.oplus.camera.p146gl.GLProducer.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo14062a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.COUIBaseListPopupWindow_8("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            COUIBaseListPopupWindow_10.m14066a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$IntrinsicsJvm.kt_5 */
    private static class IntrinsicsJvm.kt_5 implements COUIBaseListPopupWindow_11 {
        private IntrinsicsJvm.kt_5() {
        }

        @Override // com.oplus.camera.p146gl.GLProducer.COUIBaseListPopupWindow_11
        /* renamed from: PlatformImplementations.kt_3 */
        public EGLSurface mo14063a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("GLProducer", "eglCreateWindowSurface", COUIBaseListPopupWindow_8);
                return null;
            }
        }

        @Override // com.oplus.camera.p146gl.GLProducer.COUIBaseListPopupWindow_11
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo14064a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$PlatformImplementations.kt_3 */
    private abstract class PlatformImplementations.kt_3 implements COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        protected int[] f14056a;

        /* renamed from: PlatformImplementations.kt_3 */
        abstract EGLConfig mo14059a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public PlatformImplementations.kt_3(int[] iArr) {
            this.f14056a = m14057a(iArr);
        }

        @Override // com.oplus.camera.p146gl.GLProducer.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public EGLConfig mo14058a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f14056a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int OplusGLSurfaceView_13 = iArr[0];
            if (OplusGLSurfaceView_13 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[OplusGLSurfaceView_13];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f14056a, eGLConfigArr, OplusGLSurfaceView_13, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig eGLConfigMo14059a = mo14059a(egl10, eGLDisplay, eGLConfigArr);
            if (eGLConfigMo14059a != null) {
                return eGLConfigMo14059a;
            }
            throw new IllegalArgumentException("No config chosen");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int[] m14057a(int[] iArr) {
            if (GLProducer.this.f14053l != 2 && GLProducer.this.f14053l != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int OplusGLSurfaceView_13 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, OplusGLSurfaceView_13);
            iArr2[OplusGLSurfaceView_13] = 12352;
            if (GLProducer.this.f14053l == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends GLProducer<T>.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected int f14058c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        protected int f14059d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        protected int f14060e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        protected int f14061f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        protected int f14062g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        protected int f14063h;

        /* renamed from: OplusGLSurfaceView_15 */
        private int[] f14065j;

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, OplusGLSurfaceView_13, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f14065j = new int[1];
            this.f14058c = OplusGLSurfaceView_13;
            this.f14059d = i2;
            this.f14060e = i3;
            this.f14061f = i4;
            this.f14062g = i5;
            this.f14063h = i6;
        }

        @Override // com.oplus.camera.p146gl.GLProducer.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public EGLConfig mo14059a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int iM14060a = m14060a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int iM14060a2 = m14060a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (iM14060a >= this.f14062g && iM14060a2 >= this.f14063h) {
                    int iM14060a3 = m14060a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int iM14060a4 = m14060a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int iM14060a5 = m14060a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int iM14060a6 = m14060a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (iM14060a3 == this.f14058c && iM14060a4 == this.f14059d && iM14060a5 == this.f14060e && iM14060a6 == this.f14061f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int m14060a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int OplusGLSurfaceView_13, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, OplusGLSurfaceView_13, this.f14065j) ? this.f14065j[0] : i2;
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$OplusGLSurfaceView_11 */
    private class OplusGLSurfaceView_11 extends GLProducer<T>.IntrinsicsJvm.kt_4 {
        public OplusGLSurfaceView_11(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$COUIBaseListPopupWindow_10 */
    private static class COUIBaseListPopupWindow_10 {

        /* renamed from: PlatformImplementations.kt_3 */
        EGL10 f14068a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        EGLDisplay f14069b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        EGLSurface f14070c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        EGLConfig f14071d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        EGLContext f14072e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private WeakReference<GLProducer> f14073f;

        public COUIBaseListPopupWindow_10(WeakReference<GLProducer> weakReference) {
            this.f14073f = weakReference;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14070a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            this.f14068a = (EGL10) EGLContext.getEGL();
            this.f14069b = this.f14068a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f14069b == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f14068a.eglInitialize(this.f14069b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLProducer c2762m = this.f14073f.get();
            if (c2762m != null) {
                this.f14071d = c2762m.f14048g.mo14058a(this.f14068a, this.f14069b);
                this.f14072e = c2762m.f14049h.mo14061a(this.f14068a, this.f14069b, this.f14071d);
            } else {
                this.f14071d = null;
                this.f14072e = null;
            }
            if (this.f14072e == null || EGL10.EGL_NO_CONTEXT == this.f14072e) {
                this.f14072e = null;
                m14065a("createContext");
            }
            Log.v("GLProducer", "createContext, mEglContext: " + this.f14072e + " tid: " + Thread.currentThread().getId());
            this.f14070c = null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m14071b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f14068a == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f14069b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f14071d == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            m14069g();
            GLProducer c2762m = this.f14073f.get();
            if (c2762m != null) {
                this.f14070c = c2762m.f14050i.mo14063a(this.f14068a, this.f14069b, this.f14071d, c2762m.m14039a());
            } else {
                this.f14070c = null;
            }
            if (this.f14070c != null) {
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                EGLSurface eGLSurface2 = this.f14070c;
                if (eGLSurface != eGLSurface2) {
                    if (this.f14068a.eglMakeCurrent(this.f14069b, eGLSurface2, eGLSurface2, this.f14072e)) {
                        return true;
                    }
                    m14067a("EGLHelper", "eglMakeCurrent", this.f14068a.eglGetError());
                    return false;
                }
            }
            if (this.f14068a.eglGetError() == 12299) {
                Log.COUIBaseListPopupWindow_8("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
            }
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        GL m14072c() {
            GL gl = this.f14072e.getGL();
            GLProducer c2762m = this.f14073f.get();
            if (c2762m == null) {
                return gl;
            }
            if (c2762m.f14051j != null) {
                gl = c2762m.f14051j.m14095a(gl);
            }
            if ((c2762m.f14052k & 3) != 0) {
                return GLDebugHelper.wrap(gl, (c2762m.f14052k & 1) != 0 ? 1 : 0, (c2762m.f14052k & 2) != 0 ? new OplusGLSurfaceView_14() : null);
            }
            return gl;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m14073d() {
            if (this.f14068a.eglSwapBuffers(this.f14069b, this.f14070c)) {
                return 12288;
            }
            return this.f14068a.eglGetError();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m14074e() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            m14069g();
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        private void m14069g() {
            EGLSurface eGLSurface = this.f14070c;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f14068a.eglMakeCurrent(this.f14069b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GLProducer c2762m = this.f14073f.get();
            if (c2762m != null) {
                c2762m.f14050i.mo14064a(this.f14068a, this.f14069b, this.f14070c);
            }
            this.f14070c = null;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public void m14075f() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.f14072e != null) {
                GLProducer c2762m = this.f14073f.get();
                if (c2762m != null) {
                    Log.v("GLProducer", "finish, destroyContext mEglContext: " + this.f14072e);
                    c2762m.f14049h.mo14062a(this.f14068a, this.f14069b, this.f14072e);
                }
                this.f14072e = null;
            }
            EGLDisplay eGLDisplay = this.f14069b;
            if (eGLDisplay != null) {
                this.f14068a.eglTerminate(eGLDisplay);
                this.f14069b = null;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m14065a(String str) {
            m14066a(str, this.f14068a.eglGetError());
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static void m14066a(String str, int OplusGLSurfaceView_13) {
            throw new RuntimeException(m14068b(str, OplusGLSurfaceView_13));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static void m14067a(String str, String str2, int OplusGLSurfaceView_13) {
            Log.w(str, m14068b(str2, OplusGLSurfaceView_13));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static String m14068b(String str, int OplusGLSurfaceView_13) {
            return str + " failed: " + GLProducer.m14033e(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static String m14031d(int i2) {
        return "0x" + Integer.toHexString(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public static String m14033e(int i2) {
        switch (i2) {
            case 12288:
                return "EGL_SUCCESS";
            case BlurFilterLibrary.ST_BLUR_PARAM_TYPE_EFFECT_TYPE /* 12289 */:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return m14031d(i2);
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$OplusGLSurfaceView_13 */
    static class OplusGLSurfaceView_13 extends Thread {

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean f14074a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f14075b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f14076c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f14077d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f14078e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f14079f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private boolean f14080g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f14081h;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f14082i;

        /* renamed from: OplusGLSurfaceView_15 */
        private boolean f14083j;

        /* renamed from: OplusGLSurfaceView_5 */
        private boolean f14084k;

        /* renamed from: q */
        private boolean f14090q;

        /* renamed from: t */
        private COUIBaseListPopupWindow_10 f14093t;

        /* renamed from: u */
        private WeakReference<GLProducer> f14094u;

        /* renamed from: r */
        private ArrayList<Runnable> f14091r = new ArrayList<>();

        /* renamed from: s */
        private boolean f14092s = true;

        /* renamed from: OplusGLSurfaceView_14 */
        private int f14085l = 0;

        /* renamed from: OplusGLSurfaceView_6 */
        private int f14086m = 0;

        /* renamed from: o */
        private boolean f14088o = true;

        /* renamed from: OplusGLSurfaceView_11 */
        private int f14087n = 1;

        /* renamed from: p */
        private boolean f14089p = false;

        OplusGLSurfaceView_13(WeakReference<GLProducer> weakReference) {
            this.f14094u = weakReference;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLProducer " + getId());
            try {
                m14079l();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLProducer.f14042b.m14093a(this);
                throw th;
            }
            GLProducer.f14042b.m14093a(this);
        }

        /* renamed from: OplusGLSurfaceView_15 */
        private void m14077j() {
            if (this.f14082i) {
                this.f14082i = false;
                this.f14093t.m14074e();
            }
        }

        /* renamed from: OplusGLSurfaceView_5 */
        private void m14078k() {
            if (this.f14081h) {
                this.f14093t.m14075f();
                this.f14081h = false;
                GLProducer.f14042b.m14094b(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:175:0x037d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: OplusGLSurfaceView_14 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void m14079l() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 904
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p146gl.GLProducer.OplusGLSurfaceView_13.m14079l():void");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m14084a() {
            return this.f14081h && this.f14082i && m14080m();
        }

        /* renamed from: OplusGLSurfaceView_6 */
        private boolean m14080m() {
            return !this.f14077d && this.f14078e && !this.f14079f && this.f14085l > 0 && this.f14086m > 0 && this.f14088o;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14081a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 1) {
                synchronized (GLProducer.f14042b) {
                    this.f14087n = OplusGLSurfaceView_13;
                    GLProducer.f14042b.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m14085b() {
            int OplusGLSurfaceView_13;
            synchronized (GLProducer.f14042b) {
                OplusGLSurfaceView_13 = this.f14087n;
            }
            return OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m14086c() {
            synchronized (GLProducer.f14042b) {
                this.f14088o = true;
                GLProducer.f14042b.notifyAll();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m14087d() {
            synchronized (GLProducer.f14042b) {
                this.f14078e = true;
                this.f14083j = false;
                GLProducer.f14042b.notifyAll();
                while (this.f14080g && !this.f14083j && !this.f14075b) {
                    try {
                        GLProducer.f14042b.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m14088e() {
            synchronized (GLProducer.f14042b) {
                this.f14078e = false;
                GLProducer.f14042b.notifyAll();
                while (!this.f14080g && !this.f14075b) {
                    try {
                        GLProducer.f14042b.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public void m14089f() {
            synchronized (GLProducer.f14042b) {
                Log.OplusGLSurfaceView_13("GLThread", "onPause tid=" + getId());
                this.f14076c = true;
                GLProducer.f14042b.notifyAll();
                while (!this.f14075b && !this.f14077d) {
                    Log.OplusGLSurfaceView_13("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLProducer.f14042b.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public void m14090g() {
            synchronized (GLProducer.f14042b) {
                Log.OplusGLSurfaceView_13("GLThread", "onResume tid=" + getId());
                this.f14076c = false;
                this.f14088o = true;
                this.f14090q = false;
                GLProducer.f14042b.notifyAll();
                while (!this.f14075b && this.f14077d && !this.f14090q) {
                    Log.OplusGLSurfaceView_13("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLProducer.f14042b.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14082a(int OplusGLSurfaceView_13, int i2) {
            synchronized (GLProducer.f14042b) {
                this.f14085l = OplusGLSurfaceView_13;
                this.f14086m = i2;
                this.f14092s = true;
                this.f14088o = true;
                this.f14090q = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                GLProducer.f14042b.notifyAll();
                while (!this.f14075b && !this.f14077d && !this.f14090q && m14084a()) {
                    Log.OplusGLSurfaceView_13("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLProducer.f14042b.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public void m14091h() {
            synchronized (GLProducer.f14042b) {
                this.f14074a = true;
                GLProducer.f14042b.notifyAll();
                while (!this.f14075b) {
                    try {
                        GLProducer.f14042b.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m14083a(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLProducer.f14042b) {
                    this.f14091r.add(runnable);
                    GLProducer.f14042b.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public void m14092i() {
            synchronized (GLProducer.f14042b) {
                this.f14091r.clear();
            }
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$OplusGLSurfaceView_14 */
    static class OplusGLSurfaceView_14 extends Writer {

        /* renamed from: PlatformImplementations.kt_3 */
        private StringBuilder f14096a = new StringBuilder();

        OplusGLSurfaceView_14() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m14096a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            m14096a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int OplusGLSurfaceView_13, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[OplusGLSurfaceView_13 + i3];
                if (c2 == '\OplusGLSurfaceView_11') {
                    m14096a();
                } else {
                    this.f14096a.append(c2);
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m14096a() {
            if (this.f14096a.length() > 0) {
                Log.v("GLSurfaceView", this.f14096a.toString());
                StringBuilder sb = this.f14096a;
                sb.delete(0, sb.length());
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m14038j() {
        if (this.f14045d != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* compiled from: GLProducer.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_6$OplusGLSurfaceView_15 */
    private static class OplusGLSurfaceView_15 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static String f14095a = "GLThreadManager";

        private OplusGLSurfaceView_15() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public synchronized void m14093a(OplusGLSurfaceView_13 iVar) {
            iVar.f14075b = true;
            notifyAll();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m14094b(OplusGLSurfaceView_13 iVar) {
            notifyAll();
        }
    }
}
