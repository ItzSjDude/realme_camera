package androidx.p023c;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

/* compiled from: EglWindowSurface.java */
/* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class EglWindowSurface {

    /* renamed from: PlatformImplementations.kt_3 */
    private EGLDisplay f2045a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private EGLContext f2046b = EGL14.EGL_NO_CONTEXT;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private EGLSurface f2047c = EGL14.EGL_NO_SURFACE;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private EGLConfig[] f2048d = new EGLConfig[1];

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Surface f2049e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f2050f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f2051g;

    public EglWindowSurface(Surface surface) {
        if (surface == null) {
            throw new NullPointerException();
        }
        this.f2049e = surface;
        m1776g();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m1776g() {
        this.f2045a = EGL14.eglGetDisplay(0);
        if (Objects.equals(this.f2045a, EGL14.EGL_NO_DISPLAY)) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f2045a, iArr, 0, iArr, 1)) {
            this.f2045a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLDisplay eGLDisplay = this.f2045a;
        EGLConfig[] eGLConfigArr = this.f2048d;
        if (!EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f2046b = EGL14.eglCreateContext(this.f2045a, this.f2048d[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        m1775a("eglCreateContext");
        if (this.f2046b == null) {
            throw new RuntimeException("null context");
        }
        m1777h();
        this.f2050f = m1783e();
        this.f2051g = m1784f();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m1777h() {
        this.f2047c = EGL14.eglCreateWindowSurface(this.f2045a, this.f2048d[0], this.f2049e, new int[]{12344}, 0);
        m1775a("eglCreateWindowSurface");
        if (this.f2047c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1778a() {
        if (!Objects.equals(this.f2045a, EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglDestroySurface(this.f2045a, this.f2047c);
            EGL14.eglDestroyContext(this.f2045a, this.f2046b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f2045a);
        }
        this.f2049e.release();
        this.f2045a = EGL14.EGL_NO_DISPLAY;
        this.f2046b = EGL14.EGL_NO_CONTEXT;
        this.f2047c = EGL14.EGL_NO_SURFACE;
        this.f2049e = null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1780b() {
        EGLDisplay eGLDisplay = this.f2045a;
        EGLSurface eGLSurface = this.f2047c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f2046b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m1781c() {
        if (!EGL14.eglMakeCurrent(this.f2045a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m1782d() {
        return EGL14.eglSwapBuffers(this.f2045a, this.f2047c);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m1783e() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f2045a, this.f2047c, 12375, iArr, 0);
        return iArr[0];
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m1784f() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f2045a, this.f2047c, 12374, iArr, 0);
        return iArr[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1779a(long OplusGLSurfaceView_15) {
        EGLExt.eglPresentationTimeANDROID(this.f2045a, this.f2047c, OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1775a(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }
}
