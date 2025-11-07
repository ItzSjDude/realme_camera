package com.oplus.camera.p146gl;

import android.graphics.Bitmap;
import android.opengl.GLES31;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.camera.util.Util;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: NoMoireThumbGenerator.java */
/* renamed from: com.oplus.camera.gl.p */
/* loaded from: classes2.dex */
public class NoMoireThumbGenerator {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float[] f14100a = {1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float[] f14101b = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final float[] f14102c = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final float[] f14103d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final float[] f14104e = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final float[] f14105f = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f14107h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float[] f14108i = new float[8];

    /* renamed from: OplusGLSurfaceView_15 */
    private float[] f14109j = new float[8];

    /* renamed from: OplusGLSurfaceView_5 */
    private int[] f14110k = new int[1];

    /* renamed from: OplusGLSurfaceView_14 */
    private int[] f14111l = new int[1];

    /* renamed from: OplusGLSurfaceView_6 */
    private FormatConverter f14112m = new FormatConverter();

    /* renamed from: OplusGLSurfaceView_11 */
    private int f14113n = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.thumbnail_width_nomal);

    /* renamed from: o */
    private int f14114o = this.f14113n;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f14106g = OpenGLUtils.m24596b("attribute vec4 vPosition;\nattribute vec2 vCoordinate;\nvarying vec2 aCoordinate;\nvoid main() {\OplusGLSurfaceView_11   gl_Position = vPosition;\OplusGLSurfaceView_11   aCoordinate = vCoordinate;\OplusGLSurfaceView_11}", "precision mediump float;\nuniform sampler2D vTexture;\nuniform float srcWidth;\nuniform float srcHeight;\nuniform float dstWidth;\nuniform float dstHeight;\nvarying vec2 aCoordinate;\nvoid main() {\OplusGLSurfaceView_11    gl_FragColor = texture2D(vTexture, aCoordinate);\OplusGLSurfaceView_11}");

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14111a() {
    }

    public NoMoireThumbGenerator() {
        int iGlCreateShader = GLES31.glCreateShader(37305);
        if (iGlCreateShader != 0) {
            GLES31.glShaderSource(iGlCreateShader, "#version 310 es\nlayout(local_size_x = 8, local_size_y = 4, local_size_z = 1) in;\nlayout(rgba8, binding = 0) readonly uniform highp image2D input0; \nlayout(rgba8, binding = 1) writeonly uniform highp image2D output0; \OplusGLSurfaceView_11\nuniform float srcWidth;\nuniform float srcHeight;\nuniform float dstWidth;\nuniform float dstHeight;\OplusGLSurfaceView_11\nvoid main() {\OplusGLSurfaceView_11    float gx = float(gl_GlobalInvocationID.x);\OplusGLSurfaceView_11    float gy = float(gl_GlobalInvocationID.y);\OplusGLSurfaceView_11    \OplusGLSurfaceView_11    float xScale = srcWidth / dstWidth;\OplusGLSurfaceView_11    float yScale = srcHeight / dstHeight;\OplusGLSurfaceView_11    float xScaleActual = xScale;\OplusGLSurfaceView_11    float yScaleActual = yScale;\OplusGLSurfaceView_11    \OplusGLSurfaceView_11    float yPos = gy * yScale;\OplusGLSurfaceView_11    float yBegin = floor(yPos);\OplusGLSurfaceView_11    float yEnd = ceil(yPos + yScale);\OplusGLSurfaceView_11    float fraction_y_0 = 1.0f - abs(yPos - yBegin);\OplusGLSurfaceView_11    float fraction_y_1 = 1.0f - abs(yPos + yScale - yEnd);\OplusGLSurfaceView_11    if (yEnd > srcHeight) {\OplusGLSurfaceView_11        yEnd = srcHeight;\OplusGLSurfaceView_11        yScaleActual = yEnd - yPos;\OplusGLSurfaceView_11        fraction_y_1 = 1.0f;\OplusGLSurfaceView_11    }\OplusGLSurfaceView_11\OplusGLSurfaceView_11    float xPos = gx * xScale;\OplusGLSurfaceView_11    float xBegin = floor(xPos);\OplusGLSurfaceView_11    float xEnd = ceil(xPos + xScale);\OplusGLSurfaceView_11    float fraction_x_0 = 1.0f - abs(xPos - xBegin);\OplusGLSurfaceView_11    float fraction_x_1 = 1.0f - abs(xPos + xScale - xEnd);\OplusGLSurfaceView_11    if (xEnd > srcWidth) {\OplusGLSurfaceView_11        xEnd = srcWidth;\OplusGLSurfaceView_11        xScaleActual = xEnd - xPos;\OplusGLSurfaceView_11        fraction_x_1 = 1.0f;\OplusGLSurfaceView_11    }\OplusGLSurfaceView_11\OplusGLSurfaceView_11    vec4 sum = vec4(0.0f, 0.0f, 0.0f, 0.0f);\OplusGLSurfaceView_11    {\OplusGLSurfaceView_11        float y = yBegin;\OplusGLSurfaceView_11        {\OplusGLSurfaceView_11            float x = xBegin;\OplusGLSurfaceView_11            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\OplusGLSurfaceView_11            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\OplusGLSurfaceView_11\OplusGLSurfaceView_11            for (x = xBegin + 1.0f; x < xEnd - 1.0f; x += 1.0f) {\OplusGLSurfaceView_11                sumy += imageLoad(input0, ivec2(uint(x), uint(y)));\OplusGLSurfaceView_11            }\OplusGLSurfaceView_11\OplusGLSurfaceView_11            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\OplusGLSurfaceView_11            sum += sumy * vec4(fraction_y_0, fraction_y_0, fraction_y_0, fraction_y_0);\OplusGLSurfaceView_11        }\OplusGLSurfaceView_11\OplusGLSurfaceView_11        for (y = yBegin + 1.0f; y < yEnd - 1.0f; y += 1.0f) {\OplusGLSurfaceView_11            float x = xBegin;\OplusGLSurfaceView_11            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\OplusGLSurfaceView_11            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\OplusGLSurfaceView_11\OplusGLSurfaceView_11            for (x = xBegin + 1.0f; x < xEnd - 1.0f; x += 1.0f) {\OplusGLSurfaceView_11                sumy += imageLoad(input0, ivec2(uint(x), uint(y)));\OplusGLSurfaceView_11            }\OplusGLSurfaceView_11\OplusGLSurfaceView_11            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\OplusGLSurfaceView_11            sum += sumy;\OplusGLSurfaceView_11        }\OplusGLSurfaceView_11\OplusGLSurfaceView_11        {\OplusGLSurfaceView_11            float x = xBegin;\OplusGLSurfaceView_11            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\OplusGLSurfaceView_11            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\OplusGLSurfaceView_11\OplusGLSurfaceView_11            for (x = xBegin + 1.0f; x < xEnd - 1.0f; x += 1.0f) {\OplusGLSurfaceView_11                sumy += imageLoad(input0, ivec2(uint(x), uint(y)));\OplusGLSurfaceView_11            }\OplusGLSurfaceView_11\OplusGLSurfaceView_11            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\OplusGLSurfaceView_11            sum += sumy * vec4(fraction_y_1, fraction_y_1, fraction_y_1, fraction_y_1);\OplusGLSurfaceView_11        }\OplusGLSurfaceView_11    }\OplusGLSurfaceView_11\OplusGLSurfaceView_11    float area = xScaleActual * yScaleActual;\OplusGLSurfaceView_11    sum /= vec4(area, area, area, area);\OplusGLSurfaceView_11    imageStore(output0, ivec2(uint(gx), uint(gy)), sum);\OplusGLSurfaceView_11}\OplusGLSurfaceView_11");
            GLES31.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES31.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                CameraLog.m12967f("NoMoireThumbGenerator", "loadShader, Could not compile shader 37305: " + GLES31.glGetShaderInfoLog(iGlCreateShader));
                GLES31.glDeleteShader(iGlCreateShader);
                iGlCreateShader = 0;
            }
        }
        int iGlCreateProgram = GLES31.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES31.glAttachShader(iGlCreateProgram, iGlCreateShader);
            GLES31.glLinkProgram(iGlCreateProgram);
            int[] iArr2 = new int[1];
            GLES31.glGetProgramiv(iGlCreateProgram, 35714, iArr2, 0);
            if (1 != iArr2[0]) {
                CameraLog.m12967f("NoMoireThumbGenerator", "createProgram, Could not link program: " + GLES31.glGetProgramInfoLog(iGlCreateProgram));
                GLES31.glDeleteProgram(iGlCreateProgram);
            }
        }
        this.f14107h = iGlCreateProgram;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14112a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        if (z) {
            float[] fArr = f14104e;
            System.arraycopy(fArr, 0, this.f14109j, 0, fArr.length);
        } else {
            float[] fArr2 = f14105f;
            System.arraycopy(fArr2, 0, this.f14109j, 0, fArr2.length);
        }
        if (OplusGLSurfaceView_13 != i2) {
            float COUIBaseListPopupWindow_12 = (i2 - OplusGLSurfaceView_13) / (i2 * 2.0f);
            float[] fArr3 = this.f14109j;
            fArr3[1] = fArr3[1] + COUIBaseListPopupWindow_12;
            fArr3[5] = fArr3[5] + COUIBaseListPopupWindow_12;
            fArr3[3] = fArr3[3] - COUIBaseListPopupWindow_12;
            fArr3[7] = fArr3[7] - COUIBaseListPopupWindow_12;
        }
        if (i3 == 0) {
            this.f14108i = f14103d;
            return;
        }
        if (90 == i3) {
            this.f14108i = f14100a;
        } else if (180 == i3) {
            this.f14108i = f14102c;
        } else if (270 == i3) {
            this.f14108i = f14101b;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14107a(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7) {
        GLES31.glGenFramebuffers(1, iArr, 0);
        GLES31.glBindFramebuffer(36160, iArr[0]);
        GLES31.glFramebufferTexture2D(36160, 36064, 3553, i3, 0);
        FloatBuffer floatBufferM24592a = OpenGLUtils.m24592a(this.f14108i);
        FloatBuffer floatBufferM24592a2 = OpenGLUtils.m24592a(this.f14109j);
        GLES31.glViewport(i4, i5, i6, i7);
        GLES31.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES31.glClear(16640);
        GLES31.glUseProgram(OplusGLSurfaceView_13);
        int iGlGetAttribLocation = GLES31.glGetAttribLocation(OplusGLSurfaceView_13, "vPosition");
        int iGlGetAttribLocation2 = GLES31.glGetAttribLocation(OplusGLSurfaceView_13, "vCoordinate");
        int iGlGetUniformLocation = GLES31.glGetUniformLocation(OplusGLSurfaceView_13, "vTexture");
        GLES31.glEnableVertexAttribArray(iGlGetAttribLocation);
        GLES31.glEnableVertexAttribArray(iGlGetAttribLocation2);
        GLES31.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (Buffer) floatBufferM24592a);
        GLES31.glVertexAttribPointer(iGlGetAttribLocation2, 2, 5126, false, 0, (Buffer) floatBufferM24592a2);
        GLES31.glActiveTexture(33984);
        GLES31.glBindTexture(3553, i2);
        GLES31.glUniform1i(iGlGetUniformLocation, 0);
        GLES31.glDrawArrays(5, 0, this.f14108i.length / 2);
        GLES31.glDisableVertexAttribArray(iGlGetAttribLocation);
        GLES31.glDisableVertexAttribArray(iGlGetAttribLocation2);
        GLES31.glDeleteFramebuffers(1, iArr, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14108a(int OplusGLSurfaceView_13, int[] iArr, int i2, int i3, int i4) {
        GLES31.glGenTextures(1, iArr, 0);
        GLES31.glBindTexture(3553, iArr[0]);
        GLES31.glTexStorage2D(3553, 1, 32856, i3, i4);
        m14107a(i2, OplusGLSurfaceView_13, iArr[0], new int[1], 0, 0, i3, i4);
        GLES31.glUseProgram(this.f14107h);
        GLES31.glBindTexture(3553, iArr[0]);
        GLES31.glBindImageTexture(0, iArr[0], 0, false, 0, 35000, 32856);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14109a(int[] iArr) {
        GLES31.glBindTexture(3553, iArr[0]);
        GLES31.glBindImageTexture(1, iArr[0], 0, false, 0, 35001, 32856);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14106a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        GLES31.glUseProgram(OplusGLSurfaceView_13);
        int iGlGetUniformLocation = GLES31.glGetUniformLocation(OplusGLSurfaceView_13, "srcWidth");
        int iGlGetUniformLocation2 = GLES31.glGetUniformLocation(OplusGLSurfaceView_13, "srcHeight");
        int iGlGetUniformLocation3 = GLES31.glGetUniformLocation(OplusGLSurfaceView_13, "dstWidth");
        int iGlGetUniformLocation4 = GLES31.glGetUniformLocation(OplusGLSurfaceView_13, "dstHeight");
        GLES31.glUniform1f(iGlGetUniformLocation, i2);
        GLES31.glUniform1f(iGlGetUniformLocation2, i3);
        GLES31.glUniform1f(iGlGetUniformLocation3, i4);
        GLES31.glUniform1f(iGlGetUniformLocation4, i5);
        GLES31.glDispatchCompute(i4, i5, 1);
        GLES31.glMemoryBarrier(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m14110a(int OplusGLSurfaceView_13, int i2, int i3) {
        int[] iArr = new int[1];
        OpenGLUtils.m24595a(this.f14110k, this.f14111l, this.f14113n, this.f14114o);
        int i4 = i2 / 2;
        int i5 = i3 / 2;
        m14108a(OplusGLSurfaceView_13, iArr, this.f14106g, i4, i5);
        m14109a(this.f14111l);
        m14106a(this.f14107h, i4, i5, this.f14113n, this.f14114o);
        GLES31.glBindImageTexture(1, 0, 0, false, 0, 35001, 32856);
        GLES31.glBindFramebuffer(36160, this.f14110k[0]);
        CameraLog.m12959b("NoMoireThumbGenerator", "onDrawFrame, mFbo: " + Arrays.toString(this.f14110k));
        GLES31.glFramebufferTexture2D(36160, 36064, 3553, this.f14111l[0], 0);
        Bitmap bitmapM24215a = Util.m24215a(this.f14113n, this.f14114o, Bitmap.Config.ARGB_8888);
        this.f14112m.glReadPixelsToBitmap(bitmapM24215a, this.f14113n, this.f14114o, 6408, 5121);
        GLES31.glBindTexture(3553, 0);
        GLES31.glBindFramebuffer(36160, 0);
        GLES31.glUseProgram(0);
        GLES31.glDeleteTextures(1, iArr, 0);
        GLES31.glDeleteFramebuffers(1, this.f14110k, 0);
        GLES31.glDeleteTextures(1, this.f14111l, 0);
        return bitmapM24215a;
    }
}
