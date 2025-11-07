package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bv_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed> n_renamed = new android.util.LruCache<>(5);
    public float[] o_renamed;
    public float p_renamed;
    public float[] q_renamed;
    public boolean r_renamed;

    public bv_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(context, resources);
        this.o_renamed = new float[]{0.5f, 0.5f};
        this.p_renamed = 42.0f;
        this.q_renamed = new float[]{0.0f, 0.0f, 0.0f};
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed bvVar = n_renamed.get(java.lang.Thread.currentThread().getName());
        if (bvVar == null) {
            bvVar = new a_renamed.a_renamed.b_renamed.b_renamed.bv_renamed(resources, context);
            bvVar.a_renamed();
            n_renamed.put(java.lang.Thread.currentThread().getName(), bvVar);
        }
        bvVar.f15a = context;
        return bvVar;
    }

    public static void l_renamed() {
        n_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
        k_renamed();
        j_renamed();
        e_renamed();
        h_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        this.f16b = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.c_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.vertexHeader + this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("vertex")), this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("color_cursor")));
        this.f17c = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_Vertex");
        this.d_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_TexCoord");
        this.e_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_Distortion");
        this.f_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_Delta");
        this.g_renamed = android.opengl.GLES20.glGetUniformLocation(this.f16b, "u_ModelViewProjectionMatrix");
        this.h_renamed = android.opengl.GLES20.glGetUniformLocation(this.f16b, "texture");
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void h_renamed() {
        int i_renamed = this.f17c;
        if (i_renamed >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i_renamed);
            android.opengl.GLES20.glVertexAttribPointer(this.f17c, 3, 5126, false, 0, (java.nio.Buffer) co_renamed.polarr.renderer.entities.Context.overlayMesh.mVerBuffer);
        }
        int i2 = this.d_renamed;
        if (i2 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i2);
            android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 2, 5126, false, 0, (java.nio.Buffer) co_renamed.polarr.renderer.entities.Context.overlayMesh.mTexBuffer);
        }
        int i3 = this.e_renamed;
        if (i3 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i3);
            android.opengl.GLES20.glVertexAttribPointer(this.e_renamed, 2, 5126, false, 0, (java.nio.Buffer) co_renamed.polarr.renderer.entities.Context.overlayMesh.mDistortionBuffer);
        }
        int i4 = this.f_renamed;
        if (i4 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i4);
            android.opengl.GLES20.glVertexAttribPointer(this.f_renamed, 2, 5126, false, 0, (java.nio.Buffer) co_renamed.polarr.renderer.entities.Context.overlayMesh.mDeltaBuffer);
        }
        android.opengl.GLES20.glDrawElements(4, co_renamed.polarr.renderer.entities.Context.overlayMesh.trianglesBuffer.capacity(), 5123, co_renamed.polarr.renderer.entities.Context.overlayMesh.trianglesBuffer);
        int i5 = this.f17c;
        if (i5 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i5);
        }
        int i6 = this.d_renamed;
        if (i6 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i6);
        }
        int i7 = this.e_renamed;
        if (i7 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i7);
        }
        int i8 = this.f_renamed;
        if (i8 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i8);
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        if (this.o_renamed != null) {
            android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "position"), 1, this.o_renamed, 0);
            float fC_renamed = this.p_renamed * a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.c_renamed(this.f15a);
            co_renamed.polarr.renderer.entities.Context context = this.f15a;
            float f_renamed = context.imageTexture.f35b;
            float f2 = context.screen.zoom;
            float[] fArr = {fC_renamed / (f_renamed * f2), fC_renamed / (r7.f36c * f2), 1.0f};
            float[] fArr2 = this.o_renamed;
            float[] fArr3 = {fArr2[0] * 2.0f, (-fArr2[1]) * 2.0f, 0.0f};
            android.opengl.Matrix.translateM(this.j_renamed, 0, context.overlayMatrix, 0, fArr3[0], fArr3[1], fArr3[2]);
            android.opengl.Matrix.scaleM(this.j_renamed, 0, fArr[0], fArr[1], fArr[2]);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "texel"), 1.0f / fC_renamed);
            float[] fArr4 = this.q_renamed;
            if (fArr4 == null || fArr4.length != 3) {
                android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "colorMix"), 0.0f);
            } else {
                android.opengl.GLES20.glUniform3fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_COLOR), 1, this.q_renamed, 0);
                android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "colorMix"), 1.0f);
            }
        }
        a_renamed(this.f15a.dehazeTexture.f34a);
        super.j_renamed();
    }
}
