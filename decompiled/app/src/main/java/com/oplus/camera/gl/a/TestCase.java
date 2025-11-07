package com.oplus.camera.gl_renamed.a_renamed;

/* compiled from: GLImageSingleGaussBlurProcessor.java */
/* loaded from: classes2.dex */
class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Map<java.lang.Integer, float[]> f4595a = new java.util.HashMap();
    private com.oplus.camera.gl_renamed.a_renamed.c_renamed e_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final double f4596b = 2.0d;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final double f4597c = 0.25d;
    private final double d_renamed = -0.5d;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private int j_renamed = 0;
    private int k_renamed = 0;
    private int l_renamed = 0;
    private int m_renamed = 0;
    private int n_renamed = 50;

    e_renamed() {
        this.e_renamed = null;
        a_renamed();
        this.e_renamed = new com.oplus.camera.gl_renamed.a_renamed.c_renamed(this.f_renamed, this.g_renamed, this.h_renamed, this.i_renamed);
    }

    public void a_renamed() {
        this.f_renamed = com.oplus.camera.util.k_renamed.a_renamed("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec2 singleStepOffset;\nvoid main() {\n_renamed    gl_Position = aPosition;\n_renamed    textureCoordinate = aTextureCoord.xy;\n_renamed    singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n_renamed}", "precision mediump float;\nvarying vec2 textureCoordinate;\nvarying vec2 singleStepOffset;\nuniform float weight[25];\nuniform sampler2D inputTexture;\nuniform int radius;\nvoid main() {\n_renamed    vec4 currentColor = texture2D(inputTexture, textureCoordinate);\n_renamed    mediump vec3 sum = currentColor.rgb * weight[0];\n_renamed    for (int i_renamed = 0; i_renamed < radius - 1; i_renamed++) {\n_renamed        vec2 offset = float(i_renamed + 1) * singleStepOffset;\n_renamed        float offsetWeight = weight[i_renamed + 1];\n_renamed        sum += texture2D(inputTexture, textureCoordinate + offset).rgb * offsetWeight;\n_renamed        sum += texture2D(inputTexture, textureCoordinate - offset).rgb * offsetWeight;\n_renamed    }\n_renamed    gl_FragColor = vec4(sum, currentColor.a_renamed);\n_renamed}");
        this.g_renamed = android.opengl.GLES20.glGetAttribLocation(this.f_renamed, "aPosition");
        this.h_renamed = android.opengl.GLES20.glGetAttribLocation(this.f_renamed, "aTextureCoord");
        this.i_renamed = android.opengl.GLES20.glGetUniformLocation(this.f_renamed, "inputTexture");
        this.j_renamed = android.opengl.GLES20.glGetUniformLocation(this.f_renamed, "texelWidthOffset");
        this.k_renamed = android.opengl.GLES20.glGetUniformLocation(this.f_renamed, "texelHeightOffset");
        this.l_renamed = android.opengl.GLES20.glGetUniformLocation(this.f_renamed, "radius");
        this.m_renamed = android.opengl.GLES20.glGetUniformLocation(this.f_renamed, "weight");
    }

    private float[] b_renamed(int i_renamed) {
        double dSqrt;
        int i2 = this.n_renamed;
        if (i_renamed > i2) {
            i_renamed = i2;
        }
        if (f4595a.containsKey(java.lang.Integer.valueOf(i_renamed))) {
            return f4595a.get(java.lang.Integer.valueOf(i_renamed));
        }
        float[] fArr = new float[i_renamed];
        double d_renamed = (i_renamed * 0.25d) + 2.0d;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            double d2 = i3;
            fArr[i3] = (float) java.lang.Math.exp(((((-0.5d) * d2) * d2) / d_renamed) / d_renamed);
        }
        if (i_renamed < this.n_renamed) {
            dSqrt = fArr[0];
            for (int i4 = 1; i4 < i_renamed; i4++) {
                dSqrt += fArr[i4] * 2.0f;
            }
        } else {
            dSqrt = d_renamed * java.lang.Math.sqrt(6.283185307179586d);
        }
        for (int i5 = 0; i5 < i_renamed; i5++) {
            fArr[i5] = (float) (fArr[i5] / dSqrt);
        }
        f4595a.put(java.lang.Integer.valueOf(i_renamed), fArr);
        return fArr;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.e_renamed.a_renamed(i_renamed, i2, 2);
    }

    public int a_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer, java.nio.FloatBuffer floatBuffer2, int i2) {
        return i_renamed == -1 ? i_renamed : this.e_renamed.a_renamed(i_renamed, floatBuffer, floatBuffer2, i2);
    }

    public void b_renamed() {
        this.e_renamed.d_renamed();
    }

    public void c_renamed() {
        this.e_renamed.c_renamed();
        this.e_renamed = null;
        f4595a.clear();
    }

    public void a_renamed(int i_renamed) {
        this.e_renamed.a_renamed(this.l_renamed, i_renamed);
        this.e_renamed.a_renamed(this.m_renamed, b_renamed(i_renamed));
    }

    public void a_renamed(float f_renamed, float f2) {
        if (f_renamed != 0.0f) {
            this.e_renamed.a_renamed(this.j_renamed, 1.0f / f_renamed);
        } else {
            this.e_renamed.a_renamed(this.j_renamed, 0.0f);
        }
        if (f2 != 0.0f) {
            this.e_renamed.a_renamed(this.k_renamed, 1.0f / f2);
        } else {
            this.e_renamed.a_renamed(this.k_renamed, 0.0f);
        }
    }
}
