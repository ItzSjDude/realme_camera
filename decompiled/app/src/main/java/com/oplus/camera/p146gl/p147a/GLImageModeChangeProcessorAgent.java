package com.oplus.camera.p146gl.p147a;

import android.renderscript.Matrix4f;
import android.util.Size;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.FloatBuffer;

/* compiled from: GLImageModeChangeProcessorAgent.java */
/* renamed from: com.oplus.camera.gl.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class GLImageModeChangeProcessorAgent {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private GLImageScaleCircularGaussProcessor f13862f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PathInterpolator f13863g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private FloatBuffer f13864h;

    /* renamed from: OplusGLSurfaceView_13 */
    private FloatBuffer f13865i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Matrix4f f13866j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Matrix4f f13867k;

    /* renamed from: PlatformImplementations.kt_3 */
    private float f13857a = 5.0f;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f13858b = 1.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f13859c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f13860d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13861e = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f13868l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f13869m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f13870n = 0;

    /* renamed from: o */
    private float f13871o = 0.0f;

    public GLImageModeChangeProcessorAgent() {
        this.f13862f = null;
        this.f13863g = null;
        this.f13864h = null;
        this.f13865i = null;
        this.f13866j = null;
        this.f13867k = null;
        this.f13862f = new GLImageScaleCircularGaussProcessor();
        this.f13863g = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
        this.f13864h = OpenGLUtils.m24592a(GLImageProcessor.f13872a);
        this.f13865i = OpenGLUtils.m24592a(GLImageProcessor.f13873b);
        this.f13866j = new Matrix4f();
        this.f13866j.scale(1.0f, -1.0f, 1.0f);
        this.f13866j.translate(0.0f, -1.0f, 0.0f);
        this.f13867k = new Matrix4f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13830a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("GLImageModeChangeProcessorAgent", "init, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        this.f13859c = OplusGLSurfaceView_13;
        this.f13860d = i2;
        this.f13862f.mo13827b(OplusGLSurfaceView_13, i2);
        this.f13862f.mo13825a(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13831a(Size size, Size size2) {
        CameraLog.m12954a("GLImageModeChangeProcessorAgent", "setChangeSize, size change: " + size.getWidth() + " x " + size.getHeight() + " => " + size2.getWidth() + " x " + size2.getHeight());
        this.f13862f.m13855a(size, size2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13828a(int OplusGLSurfaceView_13) {
        this.f13862f.mo13824a(m13839e());
        return this.f13862f.mo13822a(OplusGLSurfaceView_13, this.f13864h, this.f13865i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float[] m13833a() {
        if (this.f13868l) {
            return this.f13867k.getArray();
        }
        return this.f13866j.getArray();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13835b(int OplusGLSurfaceView_13, int i2) {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        float f4;
        float f5 = this.f13871o;
        float f6 = OplusGLSurfaceView_13;
        int i3 = (int) (f5 * f6);
        if (i3 < i2) {
            f4 = f6 / ((int) (i2 / f5));
            f3 = ((r8 - OplusGLSurfaceView_13) / f6) / 2.0f;
            COUIBaseListPopupWindow_12 = 0.0f;
            f2 = 1.0f;
        } else {
            float f7 = i2;
            COUIBaseListPopupWindow_12 = ((i3 - i2) / f7) / 2.0f;
            f2 = f7 / i3;
            f3 = 0.0f;
            f4 = 1.0f;
        }
        if (this.f13868l) {
            this.f13867k.loadIdentity();
            this.f13867k.scale(f4, f2, 1.0f);
            this.f13867k.translate(f3, COUIBaseListPopupWindow_12, 0.0f);
        } else {
            this.f13866j.loadIdentity();
            this.f13866j.scale(1.0f, -1.0f, 1.0f);
            this.f13866j.translate(0.0f, -1.0f, 0.0f);
            this.f13866j.scale(f4, f2, 1.0f);
            this.f13866j.translate(f3, COUIBaseListPopupWindow_12, 0.0f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13832a(boolean z) {
        this.f13868l = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13834b() {
        CameraLog.m12954a("GLImageModeChangeProcessorAgent", "uninit");
        this.f13859c = 0;
        this.f13860d = 0;
        this.f13862f.mo13823a();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13836c() {
        this.f13862f.mo13826b();
        this.f13862f = null;
        this.f13864h = null;
        this.f13865i = null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13837c(int OplusGLSurfaceView_13, int i2) {
        this.f13869m = OplusGLSurfaceView_13;
        this.f13870n = i2;
        this.f13871o = i2 / OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13829a(int OplusGLSurfaceView_13, int i2, int i3) {
        CameraLog.m12954a("GLImageModeChangeProcessorAgent", "drawCoverBlur, textId: " + OplusGLSurfaceView_13 + ", mBlurShotWidth: " + this.f13859c + ", mBlurShotHeight: " + this.f13860d + ", width: " + i2 + ", height: " + i3 + ", mSizeRatioType: " + this.f13861e);
        if (this.f13859c != i2 || this.f13860d != i3) {
            m13830a(i2, i3);
            GLES20Canvas.m14010i();
        }
        return m13828a(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13838d() {
        this.f13857a = 5.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m13839e() {
        float interpolation = this.f13863g.getInterpolation(this.f13857a / 25.0f);
        this.f13857a += this.f13858b;
        if (this.f13857a > 25.0f) {
            this.f13857a = 25.0f;
        }
        return (int) (interpolation * 25.0f);
    }
}
