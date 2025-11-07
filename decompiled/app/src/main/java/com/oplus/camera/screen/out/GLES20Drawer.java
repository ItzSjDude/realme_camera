package com.oplus.camera.screen.out;

import android.content.Context;
import android.opengl.GLES20;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: GLES20Drawer.java */
/* renamed from: com.oplus.camera.screen.out.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class GLES20Drawer {

    /* renamed from: PlatformImplementations.kt_3 */
    protected FloatBuffer f16066a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected FloatBuffer f16067b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int[] f16068c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int[] f16069d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f16070e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f16071f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16072g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16073h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f16074i = 0;

    public GLES20Drawer(Context context, int OplusGLSurfaceView_13) {
        this.f16066a = null;
        this.f16067b = null;
        this.f16068c = null;
        this.f16069d = null;
        this.f16070e = null;
        this.f16071f = null;
        this.f16068c = new int[OplusGLSurfaceView_13];
        this.f16069d = new int[OplusGLSurfaceView_13];
        float[] fArr = new float[RenderConst.f16120b.length];
        m16684a(RenderConst.f16120b, fArr);
        this.f16066a = m16686a(fArr);
        float[] fArr2 = new float[RenderConst.f16119a.length];
        m16684a(RenderConst.f16119a, fArr2);
        this.f16067b = m16686a(fArr2);
        this.f16070e = m16682a(context.getResources().openRawResource(R.raw.fragment_shader_common));
        this.f16071f = m16682a(context.getResources().openRawResource(R.raw.vertex_shader_common));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo16687a() {
        m16685c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m16685c() {
        if (this.f16072g == 0) {
            this.f16072g = m16681a(this.f16071f, this.f16070e);
            this.f16073h = GLES20.glGetAttribLocation(this.f16072g, "aPosition");
            this.f16074i = GLES20.glGetAttribLocation(this.f16072g, "aTextureCoord");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m16688a(int OplusGLSurfaceView_13, FloatBuffer floatBuffer) {
        GLES20.glUseProgram(this.f16072g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glVertexAttribPointer(this.f16073h, 2, 5126, false, 8, (Buffer) this.f16067b);
        GLES20.glEnableVertexAttribArray(this.f16073h);
        int i2 = this.f16074i;
        if (floatBuffer == null) {
            floatBuffer = this.f16066a;
        }
        GLES20.glVertexAttribPointer(i2, 2, 5126, false, 8, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f16074i);
        GLES20.glDrawArrays(5, 0, 4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16689b() {
        int[] iArr = this.f16068c;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m16690b(int OplusGLSurfaceView_13, FloatBuffer floatBuffer) {
        GLES20.glVertexAttribPointer(OplusGLSurfaceView_13, 2, 5126, false, 8, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m16691c(int OplusGLSurfaceView_13, FloatBuffer floatBuffer) {
        GLES20.glVertexAttribPointer(OplusGLSurfaceView_13, 2, 5126, false, 8, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected FloatBuffer m16686a(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16681a(String str, String str2) {
        int iM16680a = m16680a(35633, str);
        if (iM16680a == 0) {
            CameraLog.m12967f("GLES20Drawer", "load vertex shader error");
        }
        int iM16680a2 = m16680a(35632, str2);
        if (iM16680a2 == 0) {
            CameraLog.m12967f("GLES20Drawer", "load fragment shader error");
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        m16683a("glCreateProgram");
        GLES20.glAttachShader(iGlCreateProgram, iM16680a);
        m16683a("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iM16680a2);
        m16683a("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (1 == iArr[0]) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m16680a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        m16683a("glCreateShader type = " + OplusGLSurfaceView_13);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16683a(String str) {
        for (int iGlGetError = GLES20.glGetError(); iGlGetError != 0; iGlGetError = GLES20.glGetError()) {
            CameraLog.m12967f("GLES20Drawer", str + ": glError " + iGlGetError);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16682a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int OplusGLSurfaceView_13 = inputStream.read(bArr);
                        if (-1 == OplusGLSurfaceView_13) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    inputStream.close();
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        inputStream.close();
        return byteArrayOutputStream.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m16684a(float[] fArr, float[] fArr2) {
        if (fArr2 == null) {
            fArr2 = new float[fArr.length];
        }
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        return fArr2;
    }
}
