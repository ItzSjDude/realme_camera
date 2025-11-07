package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class ae_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed> n_renamed = new android.util.LruCache<>(5);
    public float[] o_renamed;
    public float[] p_renamed;
    public float[] q_renamed;
    public float r_renamed;
    public float s_renamed;
    public float t_renamed;
    public boolean u_renamed;

    public ae_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(context, resources);
        this.s_renamed = 0.0f;
        this.t_renamed = 0.5f;
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed aeVar = n_renamed.get(java.lang.Thread.currentThread().getName());
        if (aeVar == null) {
            aeVar = new a_renamed.a_renamed.b_renamed.b_renamed.ae_renamed(resources, context);
            aeVar.a_renamed();
            n_renamed.put(java.lang.Thread.currentThread().getName(), aeVar);
        }
        aeVar.f15a = context;
        return aeVar;
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
        h_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        this.f16b = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.c_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.vertexHeader + this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("vertex")), this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("brush_cursor")));
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
        if (this.o_renamed == null) {
            this.o_renamed = new float[]{0.0f, 0.0f, 0.0f};
        }
        float fMin = java.lang.Math.min(1.0f, this.o_renamed[2] * 2.0f);
        float[] fArr = this.j_renamed;
        float[] fArr2 = this.f15a.overlayMatrix;
        float[] fArr3 = this.q_renamed;
        android.opengl.Matrix.translateM(fArr, 0, fArr2, 0, fArr3[0], fArr3[1], fArr3[2]);
        float[] fArr4 = this.j_renamed;
        float[] fArr5 = this.p_renamed;
        android.opengl.Matrix.scaleM(fArr4, 0, fArr5[0], fArr5[1], fArr5[2]);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "pressure"), fMin);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "hardness"), this.s_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "flow"), this.t_renamed);
        super.j_renamed();
    }
}
