package com.oplus.camera.p146gl.p147a;

import java.nio.FloatBuffer;

/* compiled from: GLImageCircularGaussBlurProcessor.java */
/* renamed from: com.oplus.camera.gl.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class GLImageCircularGaussBlurProcessor {

    /* renamed from: PlatformImplementations.kt_3 */
    private GLImageSingleGaussBlurProcessor f13854a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f13855b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f13856c = 0;

    public GLImageCircularGaussBlurProcessor() {
        this.f13854a = null;
        this.f13854a = new GLImageSingleGaussBlurProcessor();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13825a(int OplusGLSurfaceView_13, int i2) {
        this.f13855b = OplusGLSurfaceView_13;
        this.f13856c = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int mo13822a(int OplusGLSurfaceView_13, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLImageSingleGaussBlurProcessor c2742e = this.f13854a;
        if (c2742e == null) {
            return OplusGLSurfaceView_13;
        }
        c2742e.m13861a(0.0f, this.f13856c);
        int iM13859a = this.f13854a.m13859a(OplusGLSurfaceView_13, floatBuffer, floatBuffer2, 0);
        this.f13854a.m13861a(this.f13855b, 0.0f);
        return this.f13854a.m13859a(iM13859a, floatBuffer, floatBuffer2, 1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13827b(int OplusGLSurfaceView_13, int i2) {
        GLImageSingleGaussBlurProcessor c2742e = this.f13854a;
        if (c2742e != null) {
            c2742e.m13863a(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13823a() {
        GLImageSingleGaussBlurProcessor c2742e = this.f13854a;
        if (c2742e != null) {
            c2742e.m13864b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13826b() {
        GLImageSingleGaussBlurProcessor c2742e = this.f13854a;
        if (c2742e != null) {
            c2742e.m13865c();
            this.f13854a = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13824a(int OplusGLSurfaceView_13) {
        GLImageSingleGaussBlurProcessor c2742e = this.f13854a;
        if (c2742e != null) {
            c2742e.m13862a(OplusGLSurfaceView_13);
        }
    }
}
