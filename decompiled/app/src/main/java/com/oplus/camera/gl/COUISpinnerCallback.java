package com.oplus.camera.gl_renamed;

/* compiled from: NoMoireThumbGenerator.java */
/* loaded from: classes2.dex */
public class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float[] f4644a = {1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float[] f4645b = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final float[] f4646c = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
    private static final float[] d_renamed = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] e_renamed = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] f_renamed = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private int h_renamed;
    private float[] i_renamed = new float[8];
    private float[] j_renamed = new float[8];
    private int[] k_renamed = new int[1];
    private int[] l_renamed = new int[1];
    private com.oplus.camera.jni.FormatConverter m_renamed = new com.oplus.camera.jni.FormatConverter();
    private int n_renamed = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_width_nomal);
    private int o_renamed = this.n_renamed;
    private int g_renamed = com.oplus.camera.util.k_renamed.b_renamed("attribute vec4 vPosition;\nattribute vec2 vCoordinate;\nvarying vec2 aCoordinate;\nvoid main() {\n_renamed   gl_Position = vPosition;\n_renamed   aCoordinate = vCoordinate;\n_renamed}", "precision mediump float;\nuniform sampler2D vTexture;\nuniform float srcWidth;\nuniform float srcHeight;\nuniform float dstWidth;\nuniform float dstHeight;\nvarying vec2 aCoordinate;\nvoid main() {\n_renamed    gl_FragColor = texture2D(vTexture, aCoordinate);\n_renamed}");

    public void a_renamed() {
    }

    public p_renamed() {
        int iGlCreateShader = android.opengl.GLES31.glCreateShader(37305);
        if (iGlCreateShader != 0) {
            android.opengl.GLES31.glShaderSource(iGlCreateShader, "#version 310 es_renamed\nlayout(local_size_x = 8, local_size_y = 4, local_size_z = 1) in_renamed;\nlayout(rgba8, binding = 0) readonly uniform highp image2D input0; \nlayout(rgba8, binding = 1) writeonly uniform highp image2D output0; \n_renamed\nuniform float srcWidth;\nuniform float srcHeight;\nuniform float dstWidth;\nuniform float dstHeight;\n_renamed\nvoid main() {\n_renamed    float gx_renamed = float(gl_GlobalInvocationID.x_renamed);\n_renamed    float gy_renamed = float(gl_GlobalInvocationID.y_renamed);\n_renamed    \n_renamed    float xScale = srcWidth / dstWidth;\n_renamed    float yScale = srcHeight / dstHeight;\n_renamed    float xScaleActual = xScale;\n_renamed    float yScaleActual = yScale;\n_renamed    \n_renamed    float yPos = gy_renamed * yScale;\n_renamed    float yBegin = floor(yPos);\n_renamed    float yEnd = ceil(yPos + yScale);\n_renamed    float fraction_y_0 = 1.0f - abs(yPos - yBegin);\n_renamed    float fraction_y_1 = 1.0f - abs(yPos + yScale - yEnd);\n_renamed    if (yEnd > srcHeight) {\n_renamed        yEnd = srcHeight;\n_renamed        yScaleActual = yEnd - yPos;\n_renamed        fraction_y_1 = 1.0f;\n_renamed    }\n_renamed\n_renamed    float xPos = gx_renamed * xScale;\n_renamed    float xBegin = floor(xPos);\n_renamed    float xEnd = ceil(xPos + xScale);\n_renamed    float fraction_x_0 = 1.0f - abs(xPos - xBegin);\n_renamed    float fraction_x_1 = 1.0f - abs(xPos + xScale - xEnd);\n_renamed    if (xEnd > srcWidth) {\n_renamed        xEnd = srcWidth;\n_renamed        xScaleActual = xEnd - xPos;\n_renamed        fraction_x_1 = 1.0f;\n_renamed    }\n_renamed\n_renamed    vec4 sum = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n_renamed    {\n_renamed        float y_renamed = yBegin;\n_renamed        {\n_renamed            float x_renamed = xBegin;\n_renamed            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n_renamed            sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\n_renamed\n_renamed            for (x_renamed = xBegin + 1.0f; x_renamed < xEnd - 1.0f; x_renamed += 1.0f) {\n_renamed                sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed)));\n_renamed            }\n_renamed\n_renamed            sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\n_renamed            sum += sumy * vec4(fraction_y_0, fraction_y_0, fraction_y_0, fraction_y_0);\n_renamed        }\n_renamed\n_renamed        for (y_renamed = yBegin + 1.0f; y_renamed < yEnd - 1.0f; y_renamed += 1.0f) {\n_renamed            float x_renamed = xBegin;\n_renamed            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n_renamed            sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\n_renamed\n_renamed            for (x_renamed = xBegin + 1.0f; x_renamed < xEnd - 1.0f; x_renamed += 1.0f) {\n_renamed                sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed)));\n_renamed            }\n_renamed\n_renamed            sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\n_renamed            sum += sumy;\n_renamed        }\n_renamed\n_renamed        {\n_renamed            float x_renamed = xBegin;\n_renamed            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n_renamed            sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\n_renamed\n_renamed            for (x_renamed = xBegin + 1.0f; x_renamed < xEnd - 1.0f; x_renamed += 1.0f) {\n_renamed                sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed)));\n_renamed            }\n_renamed\n_renamed            sumy += imageLoad(input0, ivec2(uint(x_renamed), uint(y_renamed))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\n_renamed            sum += sumy * vec4(fraction_y_1, fraction_y_1, fraction_y_1, fraction_y_1);\n_renamed        }\n_renamed    }\n_renamed\n_renamed    float area = xScaleActual * yScaleActual;\n_renamed    sum /= vec4(area, area, area, area);\n_renamed    imageStore(output0, ivec2(uint(gx_renamed), uint(gy_renamed)), sum);\n_renamed}\n_renamed");
            android.opengl.GLES31.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            android.opengl.GLES31.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                com.oplus.camera.e_renamed.f_renamed("NoMoireThumbGenerator", "loadShader, Could not compile shader 37305: " + android.opengl.GLES31.glGetShaderInfoLog(iGlCreateShader));
                android.opengl.GLES31.glDeleteShader(iGlCreateShader);
                iGlCreateShader = 0;
            }
        }
        int iGlCreateProgram = android.opengl.GLES31.glCreateProgram();
        if (iGlCreateProgram != 0) {
            android.opengl.GLES31.glAttachShader(iGlCreateProgram, iGlCreateShader);
            android.opengl.GLES31.glLinkProgram(iGlCreateProgram);
            int[] iArr2 = new int[1];
            android.opengl.GLES31.glGetProgramiv(iGlCreateProgram, 35714, iArr2, 0);
            if (1 != iArr2[0]) {
                com.oplus.camera.e_renamed.f_renamed("NoMoireThumbGenerator", "createProgram, Could not link program: " + android.opengl.GLES31.glGetProgramInfoLog(iGlCreateProgram));
                android.opengl.GLES31.glDeleteProgram(iGlCreateProgram);
            }
        }
        this.h_renamed = iGlCreateProgram;
    }

    public void a_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        if (z_renamed) {
            float[] fArr = e_renamed;
            java.lang.System.arraycopy(fArr, 0, this.j_renamed, 0, fArr.length);
        } else {
            float[] fArr2 = f_renamed;
            java.lang.System.arraycopy(fArr2, 0, this.j_renamed, 0, fArr2.length);
        }
        if (i_renamed != i2) {
            float f2 = (i2 - i_renamed) / (i2 * 2.0f);
            float[] fArr3 = this.j_renamed;
            fArr3[1] = fArr3[1] + f2;
            fArr3[5] = fArr3[5] + f2;
            fArr3[3] = fArr3[3] - f2;
            fArr3[7] = fArr3[7] - f2;
        }
        if (i3 == 0) {
            this.i_renamed = d_renamed;
            return;
        }
        if (90 == i3) {
            this.i_renamed = f4644a;
        } else if (180 == i3) {
            this.i_renamed = f4646c;
        } else if (270 == i3) {
            this.i_renamed = f4645b;
        }
    }

    private void a_renamed(int i_renamed, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7) {
        android.opengl.GLES31.glGenFramebuffers(1, iArr, 0);
        android.opengl.GLES31.glBindFramebuffer(36160, iArr[0]);
        android.opengl.GLES31.glFramebufferTexture2D(36160, 36064, 3553, i3, 0);
        java.nio.FloatBuffer floatBufferA = com.oplus.camera.util.k_renamed.a_renamed(this.i_renamed);
        java.nio.FloatBuffer floatBufferA2 = com.oplus.camera.util.k_renamed.a_renamed(this.j_renamed);
        android.opengl.GLES31.glViewport(i4, i5, i6, i7);
        android.opengl.GLES31.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        android.opengl.GLES31.glClear(16640);
        android.opengl.GLES31.glUseProgram(i_renamed);
        int iGlGetAttribLocation = android.opengl.GLES31.glGetAttribLocation(i_renamed, "vPosition");
        int iGlGetAttribLocation2 = android.opengl.GLES31.glGetAttribLocation(i_renamed, "vCoordinate");
        int iGlGetUniformLocation = android.opengl.GLES31.glGetUniformLocation(i_renamed, "vTexture");
        android.opengl.GLES31.glEnableVertexAttribArray(iGlGetAttribLocation);
        android.opengl.GLES31.glEnableVertexAttribArray(iGlGetAttribLocation2);
        android.opengl.GLES31.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (java.nio.Buffer) floatBufferA);
        android.opengl.GLES31.glVertexAttribPointer(iGlGetAttribLocation2, 2, 5126, false, 0, (java.nio.Buffer) floatBufferA2);
        android.opengl.GLES31.glActiveTexture(33984);
        android.opengl.GLES31.glBindTexture(3553, i2);
        android.opengl.GLES31.glUniform1i(iGlGetUniformLocation, 0);
        android.opengl.GLES31.glDrawArrays(5, 0, this.i_renamed.length / 2);
        android.opengl.GLES31.glDisableVertexAttribArray(iGlGetAttribLocation);
        android.opengl.GLES31.glDisableVertexAttribArray(iGlGetAttribLocation2);
        android.opengl.GLES31.glDeleteFramebuffers(1, iArr, 0);
    }

    private void a_renamed(int i_renamed, int[] iArr, int i2, int i3, int i4) {
        android.opengl.GLES31.glGenTextures(1, iArr, 0);
        android.opengl.GLES31.glBindTexture(3553, iArr[0]);
        android.opengl.GLES31.glTexStorage2D(3553, 1, 32856, i3, i4);
        a_renamed(i2, i_renamed, iArr[0], new int[1], 0, 0, i3, i4);
        android.opengl.GLES31.glUseProgram(this.h_renamed);
        android.opengl.GLES31.glBindTexture(3553, iArr[0]);
        android.opengl.GLES31.glBindImageTexture(0, iArr[0], 0, false, 0, 35000, 32856);
    }

    private void a_renamed(int[] iArr) {
        android.opengl.GLES31.glBindTexture(3553, iArr[0]);
        android.opengl.GLES31.glBindImageTexture(1, iArr[0], 0, false, 0, 35001, 32856);
    }

    private void a_renamed(int i_renamed, int i2, int i3, int i4, int i5) {
        android.opengl.GLES31.glUseProgram(i_renamed);
        int iGlGetUniformLocation = android.opengl.GLES31.glGetUniformLocation(i_renamed, "srcWidth");
        int iGlGetUniformLocation2 = android.opengl.GLES31.glGetUniformLocation(i_renamed, "srcHeight");
        int iGlGetUniformLocation3 = android.opengl.GLES31.glGetUniformLocation(i_renamed, "dstWidth");
        int iGlGetUniformLocation4 = android.opengl.GLES31.glGetUniformLocation(i_renamed, "dstHeight");
        android.opengl.GLES31.glUniform1f(iGlGetUniformLocation, i2);
        android.opengl.GLES31.glUniform1f(iGlGetUniformLocation2, i3);
        android.opengl.GLES31.glUniform1f(iGlGetUniformLocation3, i4);
        android.opengl.GLES31.glUniform1f(iGlGetUniformLocation4, i5);
        android.opengl.GLES31.glDispatchCompute(i4, i5, 1);
        android.opengl.GLES31.glMemoryBarrier(8);
    }

    public android.graphics.Bitmap a_renamed(int i_renamed, int i2, int i3) {
        int[] iArr = new int[1];
        com.oplus.camera.util.k_renamed.a_renamed(this.k_renamed, this.l_renamed, this.n_renamed, this.o_renamed);
        int i4 = i2 / 2;
        int i5 = i3 / 2;
        a_renamed(i_renamed, iArr, this.g_renamed, i4, i5);
        a_renamed(this.l_renamed);
        a_renamed(this.h_renamed, i4, i5, this.n_renamed, this.o_renamed);
        android.opengl.GLES31.glBindImageTexture(1, 0, 0, false, 0, 35001, 32856);
        android.opengl.GLES31.glBindFramebuffer(36160, this.k_renamed[0]);
        com.oplus.camera.e_renamed.b_renamed("NoMoireThumbGenerator", "onDrawFrame, mFbo: " + java.util.Arrays.toString(this.k_renamed));
        android.opengl.GLES31.glFramebufferTexture2D(36160, 36064, 3553, this.l_renamed[0], 0);
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(this.n_renamed, this.o_renamed, android.graphics.Bitmap.Config.ARGB_8888);
        this.m_renamed.glReadPixelsToBitmap(bitmapA, this.n_renamed, this.o_renamed, 6408, 5121);
        android.opengl.GLES31.glBindTexture(3553, 0);
        android.opengl.GLES31.glBindFramebuffer(36160, 0);
        android.opengl.GLES31.glUseProgram(0);
        android.opengl.GLES31.glDeleteTextures(1, iArr, 0);
        android.opengl.GLES31.glDeleteFramebuffers(1, this.k_renamed, 0);
        android.opengl.GLES31.glDeleteTextures(1, this.l_renamed, 0);
        return bitmapA;
    }
}
