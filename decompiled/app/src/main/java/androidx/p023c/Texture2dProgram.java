package androidx.p023c;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: Texture2dProgram.java */
/* renamed from: androidx.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class Texture2dProgram {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final float[] f2127a = new float[16];

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final float[] f2128b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f2129c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f2130d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f2131e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f2132f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f2133g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f2134h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f2135i;

    static {
        Matrix.setIdentityM(f2127a, 0);
        f2128b = new float[16];
        Matrix.setIdentityM(f2128b, 0);
        Matrix.translateM(f2128b, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(f2128b, 0, 1.0f, -1.0f, 1.0f);
    }

    public Texture2dProgram(int OplusGLSurfaceView_13) {
        this.f2129c = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 0) {
            this.f2135i = 3553;
            this.f2130d = m1828a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\OplusGLSurfaceView_11    gl_Position = uMVPMatrix * aPosition;\OplusGLSurfaceView_11    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\OplusGLSurfaceView_11}\OplusGLSurfaceView_11", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\OplusGLSurfaceView_11    gl_FragColor = texture2D(sTexture, vTextureCoord);\OplusGLSurfaceView_11}\OplusGLSurfaceView_11");
        } else if (OplusGLSurfaceView_13 == 1) {
            this.f2135i = 36197;
            this.f2130d = m1828a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\OplusGLSurfaceView_11    gl_Position = uMVPMatrix * aPosition;\OplusGLSurfaceView_11    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\OplusGLSurfaceView_11}\OplusGLSurfaceView_11", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\OplusGLSurfaceView_11    gl_FragColor = texture2D(sTexture, vTextureCoord);\OplusGLSurfaceView_11}\OplusGLSurfaceView_11");
        } else {
            throw new RuntimeException("Unhandled type " + OplusGLSurfaceView_13);
        }
        int i2 = this.f2130d;
        if (i2 == 0) {
            throw new RuntimeException("Unable to create program");
        }
        this.f2133g = GLES20.glGetAttribLocation(i2, "aPosition");
        m1830b(this.f2133g, "aPosition");
        this.f2134h = GLES20.glGetAttribLocation(this.f2130d, "aTextureCoord");
        m1830b(this.f2134h, "aTextureCoord");
        this.f2131e = GLES20.glGetUniformLocation(this.f2130d, "uMVPMatrix");
        m1830b(this.f2131e, "uMVPMatrix");
        this.f2132f = GLES20.glGetUniformLocation(this.f2130d, "uTexMatrix");
        m1830b(this.f2132f, "uTexMatrix");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1831a() {
        Log.IntrinsicsJvm.kt_5("Texture2dProgram", "deleting program " + this.f2130d);
        GLES20.glDeleteProgram(this.f2130d);
        this.f2130d = -1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m1834b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        m1829a("glGenTextures");
        int OplusGLSurfaceView_13 = iArr[0];
        GLES20.glBindTexture(this.f2135i, OplusGLSurfaceView_13);
        m1829a("glBindTexture " + OplusGLSurfaceView_13);
        GLES20.glTexParameterf(this.f2135i, 10241, 9728.0f);
        int i2 = this.f2135i;
        GLES20.glTexParameterf(i2, 10240, i2 != 3553 ? 9729.0f : 9728.0f);
        GLES20.glTexParameteri(this.f2135i, 10242, 33071);
        GLES20.glTexParameteri(this.f2135i, 10243, 33071);
        m1829a("glTexParameter");
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1832a(int OplusGLSurfaceView_13, Bitmap bitmap) {
        GLES20.glBindTexture(this.f2135i, OplusGLSurfaceView_13);
        GLUtils.texImage2D(this.f2135i, 0, bitmap, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1833a(float[] fArr, FloatBuffer floatBuffer, int OplusGLSurfaceView_13, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        m1829a("draw start");
        GLES20.glUseProgram(this.f2130d);
        m1829a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f2135i, i5);
        GLES20.glUniformMatrix4fv(this.f2131e, 1, false, fArr, 0);
        m1829a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f2132f, 1, false, fArr2, 0);
        m1829a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f2133g);
        m1829a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f2133g, i3, 5126, false, i4, (Buffer) floatBuffer);
        m1829a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f2134h);
        m1829a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f2134h, 2, 5126, false, i6, (Buffer) floatBuffer2);
        m1829a("glVertexAttribPointer");
        GLES20.glDrawArrays(5, OplusGLSurfaceView_13, i2);
        m1829a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f2133g);
        GLES20.glDisableVertexAttribArray(this.f2134h);
        GLES20.glBindTexture(this.f2135i, 0);
        GLES20.glUseProgram(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m1828a(String str, String str2) {
        int iM1827a;
        int iM1827a2 = m1827a(35633, str);
        if (iM1827a2 == 0 || (iM1827a = m1827a(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        m1829a("glCreateProgram");
        if (iGlCreateProgram == 0) {
            Log.COUIBaseListPopupWindow_8("Texture2dProgram", "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iM1827a2);
        m1829a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iM1827a);
        m1829a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        Log.COUIBaseListPopupWindow_8("Texture2dProgram", "Could not link program: ");
        Log.COUIBaseListPopupWindow_8("Texture2dProgram", GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m1827a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        m1829a("glCreateShader type=" + OplusGLSurfaceView_13);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.COUIBaseListPopupWindow_8("Texture2dProgram", "Could not compile shader " + OplusGLSurfaceView_13 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.COUIBaseListPopupWindow_8("Texture2dProgram", sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m1830b(int OplusGLSurfaceView_13, String str) {
        if (OplusGLSurfaceView_13 >= 0) {
            return;
        }
        throw new RuntimeException("Unable to locate '" + str + "' in program");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m1829a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 1285) {
            Log.OplusGLSurfaceView_13("Texture2dProgram", str + " GL_OUT_OF_MEMORY");
        }
        if (iGlGetError == 0 || iGlGetError == 1285) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(iGlGetError);
        Log.COUIBaseListPopupWindow_8("Texture2dProgram", str2);
        throw new RuntimeException(str2);
    }
}
