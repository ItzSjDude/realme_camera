package com.oplus.camera.p146gl.p147a;

import android.opengl.GLES20;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.FloatBuffer;

/* compiled from: GLImageScaleCircularGaussProcessor.java */
/* renamed from: com.oplus.camera.gl.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class GLImageScaleCircularGaussProcessor extends GLImageCircularGaussBlurProcessor {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private GLImageProcessor f13897d;

    /* renamed from: PlatformImplementations.kt_3 */
    private Size f13894a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Size f13895b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private FloatBuffer f13896c = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13898e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13899f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f13900g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f13901h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13902i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13903j = 0;

    public GLImageScaleCircularGaussProcessor() {
        this.f13897d = null;
        m13856c();
        this.f13897d = new GLImageProcessor(this.f13898e, this.f13899f, this.f13900g, this.f13901h);
    }

    @Override // com.oplus.camera.p146gl.p147a.GLImageCircularGaussBlurProcessor
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13825a(int OplusGLSurfaceView_13, int i2) {
        super.mo13825a(OplusGLSurfaceView_13, i2);
        m13854a(OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p146gl.p147a.GLImageCircularGaussBlurProcessor
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13827b(int OplusGLSurfaceView_13, int i2) {
        super.mo13827b(OplusGLSurfaceView_13, i2);
        this.f13897d.m13845a(OplusGLSurfaceView_13, i2, 1);
    }

    @Override // com.oplus.camera.p146gl.p147a.GLImageCircularGaussBlurProcessor
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13823a() {
        super.mo13823a();
        m13857d();
        this.f13897d.m13850d();
    }

    @Override // com.oplus.camera.p146gl.p147a.GLImageCircularGaussBlurProcessor
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13826b() {
        super.mo13826b();
        this.f13897d.m13849c();
        this.f13897d = null;
    }

    @Override // com.oplus.camera.p146gl.p147a.GLImageCircularGaussBlurProcessor
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13824a(int OplusGLSurfaceView_13) {
        super.mo13824a(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13856c() {
        this.f13898e = OpenGLUtils.m24589a("attribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 aCoordinate;\nvoid main() {\OplusGLSurfaceView_11    gl_Position = aPosition;\OplusGLSurfaceView_11    aCoordinate = aTextureCoord;\OplusGLSurfaceView_11}", "precision mediump float;\nuniform sampler2D inputTexture;\nvarying vec2 aCoordinate;\nvoid main() {\OplusGLSurfaceView_11    gl_FragColor = texture2D(inputTexture, aCoordinate);\OplusGLSurfaceView_11}\OplusGLSurfaceView_11");
        this.f13899f = GLES20.glGetAttribLocation(this.f13898e, "aPosition");
        this.f13900g = GLES20.glGetAttribLocation(this.f13898e, "aTextureCoord");
        this.f13901h = GLES20.glGetUniformLocation(this.f13898e, "inputTexture");
    }

    @Override // com.oplus.camera.p146gl.p147a.GLImageCircularGaussBlurProcessor
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo13822a(int OplusGLSurfaceView_13, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        this.f13896c = floatBuffer2;
        m13853c(this.f13902i, this.f13903j);
        return super.mo13822a(this.f13897d.m13841a(OplusGLSurfaceView_13, floatBuffer, this.f13896c, 0), floatBuffer, floatBuffer2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13854a(float COUIBaseListPopupWindow_12, float f2) {
        int OplusGLSurfaceView_13 = ((int) COUIBaseListPopupWindow_12) * 10;
        int i2 = ((int) f2) * 10;
        if (this.f13903j != i2) {
            this.f13902i = OplusGLSurfaceView_13;
            this.f13903j = i2;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13855a(Size size, Size size2) {
        this.f13894a = size;
        this.f13895b = size2;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13853c(int OplusGLSurfaceView_13, int i2) {
        float width;
        if (this.f13894a == null || this.f13895b == null) {
            return;
        }
        float COUIBaseListPopupWindow_12 = i2;
        if (Float.compare(r0.getWidth() / this.f13894a.getHeight(), COUIBaseListPopupWindow_12 / OplusGLSurfaceView_13) == 0) {
            CameraLog.m12959b("GLImageScaleCircularGaussProcessor", "changeTextureFloatBuffer, fromRatio is equal with toRatio, return");
            return;
        }
        if (this.f13894a.getWidth() > i2) {
            width = (this.f13894a.getWidth() - i2) / this.f13894a.getWidth();
        } else {
            width = (i2 - this.f13894a.getWidth()) / COUIBaseListPopupWindow_12;
        }
        float[] fArr = (float[]) GLImageProcessor.f13873b.clone();
        if (this.f13894a.getWidth() > i2) {
            float f2 = width / 2.0f;
            fArr[1] = fArr[1] + f2;
            fArr[3] = fArr[3] - f2;
            fArr[5] = fArr[5] + f2;
            fArr[7] = fArr[7] - f2;
        } else {
            float f3 = width / 2.0f;
            fArr[0] = fArr[0] + f3;
            fArr[2] = fArr[2] + f3;
            fArr[4] = fArr[4] - f3;
            fArr[6] = fArr[6] - f3;
        }
        this.f13896c = OpenGLUtils.m24592a(fArr);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13857d() {
        this.f13894a = null;
        this.f13895b = null;
        this.f13903j = 0;
        this.f13902i = 0;
        this.f13896c = null;
    }
}
