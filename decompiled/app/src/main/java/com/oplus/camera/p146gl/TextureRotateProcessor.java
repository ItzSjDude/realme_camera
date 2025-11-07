package com.oplus.camera.p146gl;

import android.opengl.GLES20;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: TextureRotateProcessor.java */
/* renamed from: com.oplus.camera.gl.w */
/* loaded from: classes2.dex */
public class TextureRotateProcessor {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float[] f14297a = {1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float[] f14298b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int[] f14299c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int[] f14300d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f14301e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f14302f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f14303g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f14304h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f14305i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f14306j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private FloatBuffer f14307k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private FloatBuffer f14308l = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public int m14275a(RawTexture c2768s) {
        m14274c();
        m14276a();
        m14273a(this.f14302f, c2768s.f13967a, c2768s.f13968b);
        GLES20.glViewport(0, 0, c2768s.f13967a, c2768s.f13968b);
        GLES20.glBindFramebuffer(36160, this.f14301e);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f14302f, 0);
        GLES20.glUseProgram(this.f14303g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, c2768s.m13934e());
        GLES20.glUniform1i(this.f14304h, 0);
        GLES20.glVertexAttribPointer(this.f14305i, 2, 5126, false, 8, (Buffer) this.f14308l);
        GLES20.glEnableVertexAttribArray(this.f14305i);
        GLES20.glVertexAttribPointer(this.f14306j, 2, 5126, false, 8, (Buffer) this.f14307k);
        GLES20.glEnableVertexAttribArray(this.f14306j);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return this.f14302f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FloatBuffer m14272a(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14274c() {
        if (this.f14303g == 0) {
            this.f14303g = OpenGLUtils.m24596b("attribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\OplusGLSurfaceView_11   gl_Position = aPosition;\OplusGLSurfaceView_11   vTextureCoord = aTextureCoord.xy;\OplusGLSurfaceView_11}", "precision mediump float;\nuniform sampler2D aTexture;\nvarying vec2 vTextureCoord;\nvoid main() {\OplusGLSurfaceView_11    gl_FragColor = texture2D(aTexture, vTextureCoord);\OplusGLSurfaceView_11}");
            this.f14304h = GLES20.glGetUniformLocation(this.f14303g, "aTexture");
            this.f14305i = GLES20.glGetAttribLocation(this.f14303g, "aPosition");
            this.f14306j = GLES20.glGetAttribLocation(this.f14303g, "aTextureCoord");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14276a() {
        if (this.f14299c == null) {
            this.f14299c = new int[1];
            int[] iArr = this.f14299c;
            GLES20.glGenFramebuffers(iArr.length, iArr, 0);
            this.f14301e = this.f14299c[0];
        }
        if (this.f14300d == null) {
            this.f14300d = new int[1];
            int[] iArr2 = this.f14300d;
            GLES20.glGenTextures(iArr2.length, iArr2, 0);
            this.f14302f = this.f14300d[0];
        }
        if (this.f14308l == null) {
            this.f14308l = m14272a(f14297a);
        }
        if (this.f14307k == null) {
            this.f14307k = m14272a(f14298b);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14277b() {
        int[] iArr = this.f14299c;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            this.f14299c = null;
        }
        int[] iArr2 = this.f14300d;
        if (iArr2 != null) {
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
            this.f14300d = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14273a(int OplusGLSurfaceView_13, int i2, int i3) {
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
    }
}
