package com.oplus.camera.p146gl.p147a;

import android.opengl.GLES20;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* compiled from: GLImageProcessor.java */
/* renamed from: com.oplus.camera.gl.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class GLImageProcessor {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final float[] f13872a = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final float[] f13873b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f13875d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13876e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13877f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f13878g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f13879h;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final LinkedList<Runnable> f13874c = new LinkedList<>();

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13880i = f13873b.length / 2;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13881j = -1;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f13882k = -1;

    /* renamed from: OplusGLSurfaceView_14 */
    private int[] f13883l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private int[] f13884m = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13848b() {
        return 3553;
    }

    GLImageProcessor(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f13875d = 0;
        this.f13876e = 0;
        this.f13877f = 0;
        this.f13878g = 0;
        this.f13879h = false;
        this.f13875d = OplusGLSurfaceView_13;
        this.f13876e = i2;
        this.f13877f = i3;
        this.f13878g = i4;
        this.f13879h = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13841a(int OplusGLSurfaceView_13, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2) {
        if (OplusGLSurfaceView_13 == -1 || this.f13883l == null || !this.f13879h) {
            return OplusGLSurfaceView_13;
        }
        GLES20.glViewport(0, 0, this.f13881j, this.f13882k);
        GLES20.glBindFramebuffer(36160, this.f13883l[i2]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f13884m[i2], 0);
        GLES20Canvas.m14010i();
        GLES20.glUseProgram(this.f13875d);
        GLES20Canvas.m14010i();
        m13852f();
        GLES20Canvas.m14010i();
        m13840a(OplusGLSurfaceView_13, floatBuffer, floatBuffer2);
        GLES20Canvas.m14010i();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20Canvas.m14010i();
        return this.f13884m[i2];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13840a(int OplusGLSurfaceView_13, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f13876e, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20Canvas.m14010i();
        GLES20.glEnableVertexAttribArray(this.f13876e);
        GLES20Canvas.m14010i();
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f13877f, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20Canvas.m14010i();
        GLES20.glEnableVertexAttribArray(this.f13877f);
        GLES20Canvas.m14010i();
        GLES20.glActiveTexture(33984);
        GLES20Canvas.m14010i();
        GLES20.glBindTexture(m13848b(), OplusGLSurfaceView_13);
        GLES20Canvas.m14010i();
        GLES20.glUniform1i(this.f13878g, 0);
        GLES20Canvas.m14010i();
        m13842a();
        GLES20.glDisableVertexAttribArray(this.f13876e);
        GLES20Canvas.m14010i();
        GLES20.glDisableVertexAttribArray(this.f13877f);
        GLES20Canvas.m14010i();
        GLES20.glBindTexture(m13848b(), 0);
        GLES20Canvas.m14010i();
        GLES20.glUseProgram(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13842a() {
        GLES20.glDrawArrays(5, 0, this.f13880i);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13849c() {
        if (this.f13879h) {
            GLES20.glDeleteProgram(this.f13875d);
            this.f13875d = -1;
        }
        m13850d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13845a(int OplusGLSurfaceView_13, int i2, int i3) {
        if (m13851e()) {
            if (this.f13883l != null && (this.f13881j != OplusGLSurfaceView_13 || this.f13882k != i2)) {
                m13850d();
            }
            if (this.f13883l == null) {
                this.f13881j = OplusGLSurfaceView_13;
                this.f13882k = i2;
                this.f13883l = new int[i3];
                this.f13884m = new int[i3];
                OpenGLUtils.m24595a(this.f13883l, this.f13884m, OplusGLSurfaceView_13, i2);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13850d() {
        if (this.f13879h) {
            int[] iArr = this.f13884m;
            if (iArr != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
                this.f13884m = null;
            }
            int[] iArr2 = this.f13883l;
            if (iArr2 != null) {
                GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
                this.f13883l = null;
            }
            this.f13881j = -1;
            this.f13882k = -1;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m13851e() {
        return this.f13879h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13844a(final int OplusGLSurfaceView_13, final int i2) {
        m13847a(new Runnable() { // from class: com.oplus.camera.gl.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1i(OplusGLSurfaceView_13, i2);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13843a(final int OplusGLSurfaceView_13, final float COUIBaseListPopupWindow_12) {
        m13847a(new Runnable() { // from class: com.oplus.camera.gl.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1f(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13846a(final int OplusGLSurfaceView_13, final float[] fArr) {
        m13847a(new Runnable() { // from class: com.oplus.camera.gl.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.3
            @Override // java.lang.Runnable
            public void run() {
                int i2 = OplusGLSurfaceView_13;
                float[] fArr2 = fArr;
                GLES20.glUniform1fv(i2, fArr2.length, FloatBuffer.wrap(fArr2));
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13847a(Runnable runnable) {
        synchronized (this.f13874c) {
            this.f13874c.addLast(runnable);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m13852f() {
        while (!this.f13874c.isEmpty()) {
            this.f13874c.removeFirst().run();
        }
    }
}
