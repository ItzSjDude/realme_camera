package p000a.p001a.p003b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class C0006b {

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f13e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f15g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int f16h;

    /* renamed from: OplusGLSurfaceView_13 */
    public int f17i;

    /* renamed from: OplusGLSurfaceView_15 */
    public int f18j;

    /* renamed from: PlatformImplementations.kt_3 */
    public final float[] f9a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float[] f11c = new float[16];

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float[] f12d = new float[16];

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int f14f = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public FloatBuffer f10b = ByteBuffer.allocateDirect(this.f9a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public C0006b() {
        this.f10b.put(this.f9a).position(0);
        Matrix.setIdentityM(this.f12d, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m17a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        m22a("glCreateShader type=" + OplusGLSurfaceView_13);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.COUIBaseListPopupWindow_8("TextureRender", "Could not compile shader " + OplusGLSurfaceView_13 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.COUIBaseListPopupWindow_8("TextureRender", sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m18a(String str, String str2) {
        int iM17a;
        int iM17a2 = m17a(35633, str);
        int OplusGLSurfaceView_13 = 0;
        if (iM17a2 == 0 || (iM17a = m17a(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        m22a("glCreateProgram");
        if (iGlCreateProgram == 0) {
            Log.COUIBaseListPopupWindow_8("TextureRender", "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iM17a2);
        m22a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iM17a);
        m22a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.COUIBaseListPopupWindow_8("TextureRender", "Could not link program: ");
            Log.COUIBaseListPopupWindow_8("TextureRender", GLES20.glGetProgramInfoLog(iGlCreateProgram));
            GLES20.glDeleteProgram(iGlCreateProgram);
        } else {
            OplusGLSurfaceView_13 = iGlCreateProgram;
        }
        if (OplusGLSurfaceView_13 != 0) {
            C0097g.m302b(OplusGLSurfaceView_13);
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19a() {
        this.f13e = m18a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\OplusGLSurfaceView_11  gl_Position = uMVPMatrix * aPosition;\OplusGLSurfaceView_11  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\OplusGLSurfaceView_11}\OplusGLSurfaceView_11", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\OplusGLSurfaceView_11  gl_FragColor = texture2D(sTexture, vTextureCoord);\OplusGLSurfaceView_11}\OplusGLSurfaceView_11");
        int OplusGLSurfaceView_13 = this.f13e;
        if (OplusGLSurfaceView_13 == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.f17i = GLES20.glGetAttribLocation(OplusGLSurfaceView_13, "aPosition");
        m22a("glGetAttribLocation aPosition");
        if (this.f17i == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.f18j = GLES20.glGetAttribLocation(this.f13e, "aTextureCoord");
        m22a("glGetAttribLocation aTextureCoord");
        if (this.f18j == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.f15g = GLES20.glGetUniformLocation(this.f13e, "uMVPMatrix");
        m22a("glGetUniformLocation uMVPMatrix");
        if (this.f15g == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.f16h = GLES20.glGetUniformLocation(this.f13e, "uSTMatrix");
        m22a("glGetUniformLocation uSTMatrix");
        if (this.f16h == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        Matrix.setIdentityM(this.f11c, 0);
        Matrix.scaleM(this.f11c, 0, -1.0f, -1.0f, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20a(int OplusGLSurfaceView_13) {
        this.f14f = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21a(SurfaceTexture surfaceTexture, float[] fArr) {
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(this.f12d);
        }
        GLES20.glUseProgram(this.f13e);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f14f);
        this.f10b.position(0);
        GLES20.glVertexAttribPointer(this.f17i, 3, 5126, false, 20, (Buffer) this.f10b);
        GLES20.glEnableVertexAttribArray(this.f17i);
        this.f10b.position(3);
        GLES20.glVertexAttribPointer(this.f18j, 2, 5126, false, 20, (Buffer) this.f10b);
        GLES20.glEnableVertexAttribArray(this.f18j);
        if (fArr != null) {
            Matrix.setIdentityM(this.f11c, 0);
            Matrix.scaleM(this.f11c, 0, -1.0f, -1.0f, 1.0f);
            float[] fArr2 = this.f11c;
            Matrix.multiplyMM(fArr2, 0, fArr2, 0, fArr, 0);
        }
        GLES20.glUniformMatrix4fv(this.f15g, 1, false, this.f11c, 0);
        GLES20.glUniformMatrix4fv(this.f16h, 1, false, this.f12d, 0);
        GLES20.glDrawArrays(5, 0, 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22a(String str) {
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            Log.COUIBaseListPopupWindow_8("TextureRender", str + ": glError " + iGlGetError);
        }
    }
}
