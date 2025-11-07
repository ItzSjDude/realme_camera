package com.oplus.camera.p172ui.preview.p177a.p179b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.oplus.camera.CameraLog;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: VideoWatermarkRenderer.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class VideoWatermarkRenderer {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float[] f21116a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float[] f21117b = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final float[] f21118c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final float[] f21119d = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final float[] f21120e = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final float[] f21121f = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_11 */
    private FloatBuffer f21122g;

    /* renamed from: OplusGLSurfaceView_13 */
    private FloatBuffer f21124i;

    /* renamed from: OplusGLSurfaceView_15 */
    private FloatBuffer f21125j;

    /* renamed from: OplusGLSurfaceView_5 */
    private FloatBuffer f21126k;

    /* renamed from: OplusGLSurfaceView_14 */
    private FloatBuffer f21127l;

    /* renamed from: OplusGLSurfaceView_6 */
    private FloatBuffer f21128m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f21129n;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private FloatBuffer f21123h = null;

    /* renamed from: o */
    private int f21130o = 0;

    /* renamed from: p */
    private int f21131p = 0;

    /* renamed from: q */
    private int f21132q = 0;

    /* renamed from: r */
    private int f21133r = 0;

    /* renamed from: s */
    private int f21134s = 0;

    /* renamed from: t */
    private boolean f21135t = false;

    /* renamed from: u */
    private float[] f21136u = new float[16];

    /* renamed from: v */
    private float[] f21137v = new float[16];

    /* renamed from: w */
    private float[] f21138w = new float[16];

    /* renamed from: x */
    private float[] f21139x = new float[16];

    public VideoWatermarkRenderer() {
        this.f21122g = null;
        this.f21124i = null;
        this.f21125j = null;
        this.f21126k = null;
        this.f21127l = null;
        this.f21128m = null;
        this.f21129n = 0;
        this.f21122g = m22497a(f21116a);
        this.f21124i = m22497a(f21117b);
        this.f21125j = m22497a(f21118c);
        this.f21126k = m22497a(f21119d);
        this.f21127l = m22497a(f21120e);
        this.f21128m = m22497a(f21121f);
        this.f21129n = f21116a.length / 2;
        Matrix.setIdentityM(this.f21136u, 0);
        Matrix.setIdentityM(this.f21137v, 0);
        Matrix.setIdentityM(this.f21138w, 0);
        Matrix.setIdentityM(this.f21139x, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22500a() {
        if (this.f21135t) {
            return;
        }
        this.f21130o = OpenGLUtils.m24596b("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\OplusGLSurfaceView_11    gl_Position = uMVPMatrix * aPosition;\OplusGLSurfaceView_11    vTextureCoord = aTextureCoord.xy;\OplusGLSurfaceView_11}\OplusGLSurfaceView_11", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uSampleTexture;\nvoid main() {\OplusGLSurfaceView_11    gl_FragColor = texture2D(uSampleTexture, vTextureCoord);\OplusGLSurfaceView_11}\OplusGLSurfaceView_11");
        this.f21131p = GLES20.glGetUniformLocation(this.f21130o, "uMVPMatrix");
        m22498a(this.f21131p, "uMVPMatrix");
        this.f21132q = GLES20.glGetAttribLocation(this.f21130o, "aPosition");
        m22498a(this.f21132q, "aPosition");
        this.f21133r = GLES20.glGetAttribLocation(this.f21130o, "aTextureCoord");
        m22498a(this.f21133r, "aTextureCoord");
        this.f21134s = GLES20.glGetUniformLocation(this.f21130o, "uSampleTexture");
        m22498a(this.f21134s, "uSampleTexture");
        this.f21135t = true;
        CameraLog.m12959b("VideoWatermarkRenderer", "onAttached, mShaderProgram: " + this.f21130o);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22502b() {
        GLES20.glDeleteProgram(this.f21130o);
        this.f21130o = 0;
        this.f21131p = 0;
        this.f21132q = 0;
        this.f21133r = 0;
        this.f21134s = 0;
        this.f21135t = false;
        CameraLog.m12959b("VideoWatermarkRenderer", "onDetached");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22501a(int OplusGLSurfaceView_13, boolean z, int i2) {
        GLES20.glUseProgram(this.f21130o);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glUniform1i(this.f21134s, 0);
        OpenGLUtils.m24594a("glUniform1i mSampleTextureLoc");
        GLES20.glUniformMatrix4fv(this.f21131p, 1, false, m22499c(), 0);
        OpenGLUtils.m24594a("glUniformMatrix4fv mMVPMatrixLoc");
        GLES20.glEnableVertexAttribArray(this.f21132q);
        GLES20.glVertexAttribPointer(this.f21132q, 2, 5126, false, 8, (Buffer) this.f21122g);
        OpenGLUtils.m24594a("glVertexAttribPointer mPositionLoc");
        GLES20.glEnableVertexAttribArray(this.f21133r);
        if (i2 == 90) {
            this.f21123h = this.f21125j;
        } else if (i2 == 180) {
            this.f21123h = this.f21126k;
        } else if (i2 == 270) {
            this.f21123h = this.f21127l;
        } else {
            this.f21123h = this.f21124i;
        }
        GLES20.glVertexAttribPointer(this.f21133r, 2, 5126, false, 8, (Buffer) (z ? this.f21128m : this.f21123h));
        OpenGLUtils.m24594a("glVertexAttribPointer mTextureCoordLoc");
        GLES20.glDrawArrays(5, 0, this.f21129n);
        GLES20.glDisableVertexAttribArray(this.f21132q);
        GLES20.glDisableVertexAttribArray(this.f21133r);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22498a(int OplusGLSurfaceView_13, String str) {
        if (OplusGLSurfaceView_13 >= 0) {
            return;
        }
        throw new RuntimeException("Unable to locate '" + str + "' in program");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float[] m22499c() {
        Matrix.multiplyMM(this.f21139x, 0, this.f21137v, 0, this.f21138w, 0);
        float[] fArr = this.f21139x;
        Matrix.multiplyMM(fArr, 0, this.f21136u, 0, fArr, 0);
        return this.f21139x;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FloatBuffer m22497a(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
