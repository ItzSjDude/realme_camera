package p000a.p001a.p003b.p009e;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class C0102a {

    /* renamed from: PlatformImplementations.kt_3 */
    public EGLDisplay f495a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public EGLContext f496b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public EGLConfig f497c;

    public C0102a(EGLContext eGLContext, int OplusGLSurfaceView_13) {
        EGLConfig eGLConfigM442a;
        this.f495a = EGL14.EGL_NO_DISPLAY;
        this.f496b = EGL14.EGL_NO_CONTEXT;
        this.f497c = null;
        if (this.f495a != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        this.f495a = EGL14.eglGetDisplay(0);
        EGLDisplay eGLDisplay = this.f495a;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplay, iArr, 0, iArr, 1)) {
            this.f495a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((OplusGLSurfaceView_13 & 2) != 0 && (eGLConfigM442a = m442a(OplusGLSurfaceView_13, 3)) != null) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f495a, eGLConfigM442a, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.f497c = eGLConfigM442a;
                this.f496b = eGLContextEglCreateContext;
            }
        }
        if (this.f496b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig eGLConfigM442a2 = m442a(OplusGLSurfaceView_13, 2);
            if (eGLConfigM442a2 == null) {
                throw new RuntimeException("Unable to find PlatformImplementations.kt_3 suitable EGLConfig");
            }
            EGLContext eGLContextEglCreateContext2 = EGL14.eglCreateContext(this.f495a, eGLConfigM442a2, eGLContext, new int[]{12440, 2, 12344}, 0);
            m446a("eglCreateContext");
            this.f497c = eGLConfigM442a2;
            this.f496b = eGLContextEglCreateContext2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.f495a, this.f496b, 12440, iArr2, 0);
        Log.IntrinsicsJvm.kt_5("EglCore", "EGLContext created, client version " + iArr2[0]);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final EGLConfig m442a(int OplusGLSurfaceView_13, int i2) {
        int i3 = i2 >= 3 ? 68 : 4;
        int[] iArr = new int[13];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12352;
        iArr[9] = i3;
        iArr[10] = 12344;
        iArr[11] = 0;
        iArr[12] = 12344;
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f495a, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("EglCore", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public EGLSurface m443a(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f495a, this.f497c, obj, new int[]{12344}, 0);
        m446a("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m444a() {
        EGLDisplay eGLDisplay = this.f495a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f495a, this.f496b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f495a);
        }
        this.f495a = EGL14.EGL_NO_DISPLAY;
        this.f496b = EGL14.EGL_NO_CONTEXT;
        this.f497c = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m445a(EGLSurface eGLSurface) {
        if (this.f495a == EGL14.EGL_NO_DISPLAY) {
            Log.IntrinsicsJvm.kt_5("EglCore", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f495a, eGLSurface, eGLSurface, this.f496b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m446a(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m447b(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f495a, eGLSurface);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m448c(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f495a, eGLSurface);
    }

    public void finalize() throws Throwable {
        try {
            if (this.f495a != EGL14.EGL_NO_DISPLAY) {
                Log.w("EglCore", "WARNING: EglCore was not explicitly released -- state may be leaked");
                m444a();
            }
        } finally {
            super.finalize();
        }
    }
}
