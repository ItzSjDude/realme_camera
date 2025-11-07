package com.oplus.camera.gl_renamed.a_renamed;

/* compiled from: GLImageScaleCircularGaussProcessor.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.gl_renamed.a_renamed.a_renamed {
    private com.oplus.camera.gl_renamed.a_renamed.c_renamed d_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.util.Size f4592a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.util.Size f4593b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.nio.FloatBuffer f4594c = null;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private int j_renamed = 0;

    public d_renamed() {
        this.d_renamed = null;
        c_renamed();
        this.d_renamed = new com.oplus.camera.gl_renamed.a_renamed.c_renamed(this.e_renamed, this.f_renamed, this.g_renamed, this.h_renamed);
    }

    @Override // com.oplus.camera.gl_renamed.a_renamed.a_renamed
    public void a_renamed(int i_renamed, int i2) {
        super.a_renamed(i_renamed, i2);
        a_renamed(i_renamed, i2);
    }

    @Override // com.oplus.camera.gl_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
        super.b_renamed(i_renamed, i2);
        this.d_renamed.a_renamed(i_renamed, i2, 1);
    }

    @Override // com.oplus.camera.gl_renamed.a_renamed.a_renamed
    public void a_renamed() {
        super.a_renamed();
        d_renamed();
        this.d_renamed.d_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.a_renamed.a_renamed
    public void b_renamed() {
        super.b_renamed();
        this.d_renamed.c_renamed();
        this.d_renamed = null;
    }

    @Override // com.oplus.camera.gl_renamed.a_renamed.a_renamed
    public void a_renamed(int i_renamed) {
        super.a_renamed(i_renamed);
    }

    public void c_renamed() {
        this.e_renamed = com.oplus.camera.util.k_renamed.a_renamed("attribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 aCoordinate;\nvoid main() {\n_renamed    gl_Position = aPosition;\n_renamed    aCoordinate = aTextureCoord;\n_renamed}", "precision mediump float;\nuniform sampler2D inputTexture;\nvarying vec2 aCoordinate;\nvoid main() {\n_renamed    gl_FragColor = texture2D(inputTexture, aCoordinate);\n_renamed}\n_renamed");
        this.f_renamed = android.opengl.GLES20.glGetAttribLocation(this.e_renamed, "aPosition");
        this.g_renamed = android.opengl.GLES20.glGetAttribLocation(this.e_renamed, "aTextureCoord");
        this.h_renamed = android.opengl.GLES20.glGetUniformLocation(this.e_renamed, "inputTexture");
    }

    @Override // com.oplus.camera.gl_renamed.a_renamed.a_renamed
    public int a_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer, java.nio.FloatBuffer floatBuffer2) {
        this.f4594c = floatBuffer2;
        c_renamed(this.i_renamed, this.j_renamed);
        return super.a_renamed(this.d_renamed.a_renamed(i_renamed, floatBuffer, this.f4594c, 0), floatBuffer, floatBuffer2);
    }

    public void a_renamed(float f_renamed, float f2) {
        int i_renamed = ((int) f_renamed) * 10;
        int i2 = ((int) f2) * 10;
        if (this.j_renamed != i2) {
            this.i_renamed = i_renamed;
            this.j_renamed = i2;
        }
    }

    public void a_renamed(android.util.Size size, android.util.Size size2) {
        this.f4592a = size;
        this.f4593b = size2;
    }

    private void c_renamed(int i_renamed, int i2) {
        float width;
        if (this.f4592a == null || this.f4593b == null) {
            return;
        }
        float f_renamed = i2;
        if (java.lang.Float.compare(r0.getWidth() / this.f4592a.getHeight(), f_renamed / i_renamed) == 0) {
            com.oplus.camera.e_renamed.b_renamed("GLImageScaleCircularGaussProcessor", "changeTextureFloatBuffer, fromRatio is_renamed equal with toRatio, return");
            return;
        }
        if (this.f4592a.getWidth() > i2) {
            width = (this.f4592a.getWidth() - i2) / this.f4592a.getWidth();
        } else {
            width = (i2 - this.f4592a.getWidth()) / f_renamed;
        }
        float[] fArr = (float[]) com.oplus.camera.gl_renamed.a_renamed.c_renamed.f4581b.clone();
        if (this.f4592a.getWidth() > i2) {
            float f2 = width / 2.0f;
            fArr[1] = fArr[1] + f2;
            fArr[3] = fArr[3] - f2;
            fArr[5] = fArr[5] + f2;
            fArr[7] = fArr[7] - f2;
        } else {
            float f3 = width / 2.0f;
            fArr[0] = fArr[0] + f3;
            fArr[2] = fArr[2] + f3;
            fArr[4] = fArr[4] - f3;
            fArr[6] = fArr[6] - f3;
        }
        this.f4594c = com.oplus.camera.util.k_renamed.a_renamed(fArr);
    }

    public void d_renamed() {
        this.f4592a = null;
        this.f4593b = null;
        this.j_renamed = 0;
        this.i_renamed = 0;
        this.f4594c = null;
    }
}
