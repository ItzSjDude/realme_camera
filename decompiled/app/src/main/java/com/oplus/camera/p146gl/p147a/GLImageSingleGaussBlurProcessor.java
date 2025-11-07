package com.oplus.camera.p146gl.p147a;

import android.opengl.GLES20;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GLImageSingleGaussBlurProcessor.java */
/* renamed from: com.oplus.camera.gl.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
class GLImageSingleGaussBlurProcessor {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Map<Integer, float[]> f13904a = new HashMap();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private GLImageProcessor f13908e;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final double f13905b = 2.0d;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final double f13906c = 0.25d;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final double f13907d = -0.5d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13909f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f13910g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f13911h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13912i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13913j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f13914k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f13915l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f13916m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f13917n = 50;

    GLImageSingleGaussBlurProcessor() {
        this.f13908e = null;
        m13860a();
        this.f13908e = new GLImageProcessor(this.f13909f, this.f13910g, this.f13911h, this.f13912i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13860a() {
        this.f13909f = OpenGLUtils.m24589a("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec2 singleStepOffset;\nvoid main() {\OplusGLSurfaceView_11    gl_Position = aPosition;\OplusGLSurfaceView_11    textureCoordinate = aTextureCoord.xy;\OplusGLSurfaceView_11    singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\OplusGLSurfaceView_11}", "precision mediump float;\nvarying vec2 textureCoordinate;\nvarying vec2 singleStepOffset;\nuniform float weight[25];\nuniform sampler2D inputTexture;\nuniform int radius;\nvoid main() {\OplusGLSurfaceView_11    vec4 currentColor = texture2D(inputTexture, textureCoordinate);\OplusGLSurfaceView_11    mediump vec3 sum = currentColor.rgb * weight[0];\OplusGLSurfaceView_11    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < radius - 1; OplusGLSurfaceView_13++) {\OplusGLSurfaceView_11        vec2 offset = float(OplusGLSurfaceView_13 + 1) * singleStepOffset;\OplusGLSurfaceView_11        float offsetWeight = weight[OplusGLSurfaceView_13 + 1];\OplusGLSurfaceView_11        sum += texture2D(inputTexture, textureCoordinate + offset).rgb * offsetWeight;\OplusGLSurfaceView_11        sum += texture2D(inputTexture, textureCoordinate - offset).rgb * offsetWeight;\OplusGLSurfaceView_11    }\OplusGLSurfaceView_11    gl_FragColor = vec4(sum, currentColor.PlatformImplementations.kt_3);\OplusGLSurfaceView_11}");
        this.f13910g = GLES20.glGetAttribLocation(this.f13909f, "aPosition");
        this.f13911h = GLES20.glGetAttribLocation(this.f13909f, "aTextureCoord");
        this.f13912i = GLES20.glGetUniformLocation(this.f13909f, "inputTexture");
        this.f13913j = GLES20.glGetUniformLocation(this.f13909f, "texelWidthOffset");
        this.f13914k = GLES20.glGetUniformLocation(this.f13909f, "texelHeightOffset");
        this.f13915l = GLES20.glGetUniformLocation(this.f13909f, "radius");
        this.f13916m = GLES20.glGetUniformLocation(this.f13909f, "weight");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float[] m13858b(int OplusGLSurfaceView_13) {
        double dSqrt;
        int i2 = this.f13917n;
        if (OplusGLSurfaceView_13 > i2) {
            OplusGLSurfaceView_13 = i2;
        }
        if (f13904a.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            return f13904a.get(Integer.valueOf(OplusGLSurfaceView_13));
        }
        float[] fArr = new float[OplusGLSurfaceView_13];
        double IntrinsicsJvm.kt_5 = (OplusGLSurfaceView_13 * 0.25d) + 2.0d;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            double d2 = i3;
            fArr[i3] = (float) Math.exp(((((-0.5d) * d2) * d2) / IntrinsicsJvm.kt_5) / IntrinsicsJvm.kt_5);
        }
        if (OplusGLSurfaceView_13 < this.f13917n) {
            dSqrt = fArr[0];
            for (int i4 = 1; i4 < OplusGLSurfaceView_13; i4++) {
                dSqrt += fArr[i4] * 2.0f;
            }
        } else {
            dSqrt = IntrinsicsJvm.kt_5 * Math.sqrt(6.283185307179586d);
        }
        for (int i5 = 0; i5 < OplusGLSurfaceView_13; i5++) {
            fArr[i5] = (float) (fArr[i5] / dSqrt);
        }
        f13904a.put(Integer.valueOf(OplusGLSurfaceView_13), fArr);
        return fArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13863a(int OplusGLSurfaceView_13, int i2) {
        this.f13908e.m13845a(OplusGLSurfaceView_13, i2, 2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13859a(int OplusGLSurfaceView_13, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2) {
        return OplusGLSurfaceView_13 == -1 ? OplusGLSurfaceView_13 : this.f13908e.m13841a(OplusGLSurfaceView_13, floatBuffer, floatBuffer2, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13864b() {
        this.f13908e.m13850d();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13865c() {
        this.f13908e.m13849c();
        this.f13908e = null;
        f13904a.clear();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13862a(int OplusGLSurfaceView_13) {
        this.f13908e.m13844a(this.f13915l, OplusGLSurfaceView_13);
        this.f13908e.m13846a(this.f13916m, m13858b(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13861a(float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 != 0.0f) {
            this.f13908e.m13843a(this.f13913j, 1.0f / COUIBaseListPopupWindow_12);
        } else {
            this.f13908e.m13843a(this.f13913j, 0.0f);
        }
        if (f2 != 0.0f) {
            this.f13908e.m13843a(this.f13914k, 1.0f / f2);
        } else {
            this.f13908e.m13843a(this.f13914k, 0.0f);
        }
    }
}
