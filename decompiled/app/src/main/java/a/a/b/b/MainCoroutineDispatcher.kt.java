package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bf_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed {
    public float n_renamed;
    public float o_renamed;
    public float p_renamed;
    public float[] q_renamed;
    public boolean r_renamed;
    public boolean s_renamed;
    public java.nio.FloatBuffer t_renamed;

    public bf_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        super(context, resources);
        this.n_renamed = 0.5f;
        this.o_renamed = 0.0f;
        this.p_renamed = 0.5f;
        this.q_renamed = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        a_renamed();
    }

    public void a_renamed(java.util.List<java.lang.Float> list, boolean z_renamed) {
        int size;
        if (list == null || list.isEmpty()) {
            return;
        }
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendEquation(32774);
        if (z_renamed) {
            if (this.r_renamed) {
                android.opengl.GLES20.glBlendFuncSeparate(0, 771, 0, 771);
            } else {
                android.opengl.GLES20.glBlendFuncSeparate(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
            }
        } else if (!this.r_renamed || this.s_renamed) {
            android.opengl.GLES20.glBlendFunc(1, 769);
        } else {
            android.opengl.GLES20.glBlendFunc(0, 769);
        }
        if (z_renamed) {
            synchronized (list) {
                int size2 = list.size() * 4;
                java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(size2);
                byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
                this.t_renamed = byteBufferAllocateDirect.asFloatBuffer();
                for (int i_renamed = 0; i_renamed < size2 && list.size() > i_renamed; i_renamed++) {
                    java.lang.Float fValueOf = list.get(i_renamed);
                    if (!this.f15a.isSDK && i_renamed % 4 == 1) {
                        fValueOf = java.lang.Float.valueOf(1.0f - fValueOf.floatValue());
                    }
                    this.t_renamed.put(fValueOf.floatValue());
                }
            }
            this.t_renamed.position(0);
            android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 4, 5126, false, 0, (java.nio.Buffer) this.t_renamed);
            android.opengl.GLES20.glEnableVertexAttribArray(this.d_renamed);
            android.opengl.GLES20.glUseProgram(this.f16b);
            l_renamed();
            size = list.size() / 4;
        } else {
            synchronized (list) {
                int size3 = list.size() * 4;
                java.nio.ByteBuffer byteBufferAllocateDirect2 = java.nio.ByteBuffer.allocateDirect(size3);
                byteBufferAllocateDirect2.order(java.nio.ByteOrder.nativeOrder());
                this.t_renamed = byteBufferAllocateDirect2.asFloatBuffer();
                for (int i2 = 0; i2 < size3 && list.size() > i2; i2++) {
                    java.lang.Float fValueOf2 = list.get(i2);
                    if (!this.f15a.isSDK && i2 % 3 == 1) {
                        fValueOf2 = java.lang.Float.valueOf(1.0f - fValueOf2.floatValue());
                    }
                    this.t_renamed.put(fValueOf2.floatValue());
                }
            }
            this.t_renamed.position(0);
            android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 3, 5126, false, 0, (java.nio.Buffer) this.t_renamed);
            android.opengl.GLES20.glEnableVertexAttribArray(this.d_renamed);
            android.opengl.GLES20.glUseProgram(this.f16b);
            l_renamed();
            size = list.size() / 3;
        }
        android.opengl.GLES20.glDrawArrays(0, 0, size);
        android.opengl.GLES20.glDisableVertexAttribArray(this.d_renamed);
        android.opengl.GLES20.glDisable(3042);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void d_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        this.f16b = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.c_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.vertexHeader + this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("brush_vertex")), a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.fragmentHeader + this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("brush")));
        this.d_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "coordinates");
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
    }

    public void l_renamed() {
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "brushSize"), this.n_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "hardness"), this.o_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "flow"), this.p_renamed);
        android.opengl.GLES20.glUniform4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "channelMask"), 1, this.q_renamed, 0);
    }
}
