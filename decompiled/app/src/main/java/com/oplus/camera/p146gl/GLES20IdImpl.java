package com.oplus.camera.p146gl;

import android.opengl.GLES20;
import android.util.Log;
import javax.microedition.khronos.opengles.GL11;

/* compiled from: GLES20IdImpl.java */
/* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class GLES20IdImpl implements GLId {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int[] f14039a = new int[1];

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized void m14017a(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        m14016a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14016a() {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            Log.COUIBaseListPopupWindow_8("GLES20IdImpl", "GL error: " + iGlGetError, new Throwable());
        }
    }

    @Override // com.oplus.camera.p146gl.GLId
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo14020b() {
        GLES20.glGenTextures(1, this.f14039a, 0);
        GLES20Canvas.m14010i();
        return this.f14039a[0];
    }

    @Override // com.oplus.camera.p146gl.GLId
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14018a(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        GLES20.glGenBuffers(OplusGLSurfaceView_13, iArr, i2);
        GLES20Canvas.m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLId
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14019a(GL11 gl11, int OplusGLSurfaceView_13, int[] iArr, int i2) {
        GLES20.glDeleteTextures(OplusGLSurfaceView_13, iArr, i2);
        GLES20Canvas.m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLId
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo14021b(GL11 gl11, int OplusGLSurfaceView_13, int[] iArr, int i2) {
        GLES20.glDeleteBuffers(OplusGLSurfaceView_13, iArr, i2);
        GLES20Canvas.m14010i();
    }
}
