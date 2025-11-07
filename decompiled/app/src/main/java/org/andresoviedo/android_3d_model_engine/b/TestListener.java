package org.andresoviedo.android_3d_model_engine.b_renamed;

/* compiled from: Object3DData.java */
/* loaded from: classes2.dex */
public class g_renamed {
    private final float[] A_renamed;
    private float[] B_renamed;
    private final float[] C_renamed;
    private boolean D_renamed;
    private org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed E_renamed;
    private java.util.List<java.lang.String> F_renamed;
    private com.b_renamed.a_renamed.o_renamed G_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected java.nio.FloatBuffer f7983b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed> f7984c;
    protected float[] d_renamed;
    protected float[] e_renamed;
    protected float[] f_renamed;
    protected org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;
    private int m_renamed;
    private java.nio.FloatBuffer n_renamed;
    private java.nio.FloatBuffer o_renamed;
    private java.nio.FloatBuffer p_renamed;
    private java.nio.FloatBuffer q_renamed;
    private java.nio.FloatBuffer r_renamed;
    private byte[] s_renamed;
    private org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed t_renamed;
    private java.nio.IntBuffer u_renamed;
    private java.nio.ShortBuffer v_renamed;
    private java.util.List<int[]> w_renamed;
    private float[] x_renamed;
    private float[] y_renamed;
    private float[] z_renamed;
    private boolean j_renamed = false;
    private boolean k_renamed = true;

    /* renamed from: a_renamed, reason: collision with root package name */
    public boolean f7982a = false;
    private boolean l_renamed = true;

    protected void L_renamed() {
    }

    protected void a_renamed(java.util.EventObject eventObject) {
    }

    public void a_renamed(org.andresoviedo.android_3d_model_engine.a_renamed.c_renamed cVar, float[] fArr, float[] fArr2) {
    }

    public int p_renamed() {
        return 0;
    }

    /* compiled from: Object3DData.java */
    protected static class a_renamed extends java.util.EventObject {
        a_renamed(java.lang.Object obj) {
            super(obj);
        }
    }

    public g_renamed() {
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        this.m_renamed = 0;
        this.f7983b = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.f7984c = null;
        this.s_renamed = null;
        this.t_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed("default");
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.d_renamed = new float[]{1.0f, 1.0f, 1.0f};
        this.e_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.f_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = new float[16];
        this.C_renamed = new float[16];
        android.opengl.Matrix.setIdentityM(this.A_renamed, 0);
        android.opengl.Matrix.setIdentityM(this.C_renamed, 0);
        this.E_renamed = null;
        this.g_renamed = null;
        this.F_renamed = new java.util.ArrayList();
    }

    public g_renamed(java.nio.FloatBuffer floatBuffer, java.nio.IntBuffer intBuffer) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        this.m_renamed = 0;
        this.f7983b = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.f7984c = null;
        this.s_renamed = null;
        this.t_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed("default");
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.d_renamed = new float[]{1.0f, 1.0f, 1.0f};
        this.e_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.f_renamed = new float[]{0.0f, 0.0f, 0.0f};
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = new float[16];
        this.C_renamed = new float[16];
        android.opengl.Matrix.setIdentityM(this.A_renamed, 0);
        android.opengl.Matrix.setIdentityM(this.C_renamed, 0);
        this.E_renamed = null;
        this.g_renamed = null;
        this.F_renamed = new java.util.ArrayList();
        this.f7983b = floatBuffer;
        this.u_renamed = intBuffer;
        a_renamed(false);
        L_renamed();
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed a_renamed(java.lang.String str) {
        this.h_renamed = str;
        return this;
    }

    public java.lang.String g_renamed() {
        return this.h_renamed;
    }

    public java.lang.String h_renamed() {
        return this.i_renamed;
    }

    public boolean i_renamed() {
        return this.j_renamed;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed a_renamed(boolean z_renamed) {
        this.j_renamed = z_renamed;
        return this;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed j_renamed() {
        return this.t_renamed;
    }

    public void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.f_renamed fVar) {
        this.t_renamed = fVar;
    }

    public void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed dVar) {
        this.g_renamed = dVar;
    }

    public void a_renamed(com.b_renamed.a_renamed.o_renamed oVar) {
        this.G_renamed = oVar;
    }

    public com.b_renamed.a_renamed.o_renamed k_renamed() {
        return this.G_renamed;
    }

    public void a_renamed(com.b_renamed.a_renamed.o_renamed.b_renamed bVar) {
        this.E_renamed = new org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed(bVar.f2375a, bVar.f2376b, bVar.f2377c, bVar.d_renamed, bVar.f_renamed, bVar.e_renamed);
        com.b_renamed.a_renamed.b_renamed.c_renamed("Object3DData", "New fixed dimensions for " + g_renamed() + ": " + this.E_renamed);
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed d_renamed() {
        if (this.g_renamed == null) {
            float[] fArr = new float[4];
            float[] fArr2 = new float[4];
            org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed dVar = new org.andresoviedo.android_3d_model_engine.b_renamed.d_renamed();
            com.b_renamed.a_renamed.b_renamed.d_renamed("Object3DData", "id_renamed:" + g_renamed() + ", elements:" + this.f7984c);
            java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed> list = this.f7984c;
            if (list == null || list.isEmpty()) {
                for (int i_renamed = 0; i_renamed < this.f7983b.capacity(); i_renamed += 3) {
                    fArr[0] = this.f7983b.get(i_renamed);
                    fArr[1] = this.f7983b.get(i_renamed + 1);
                    fArr[2] = this.f7983b.get(i_renamed + 2);
                    fArr[3] = 1.0f;
                    android.opengl.Matrix.multiplyMV(fArr2, 0, C_renamed(), 0, fArr, 0);
                    dVar.a_renamed(fArr2[0], fArr2[1], fArr2[2]);
                }
            } else {
                java.util.Iterator<org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed> it = N_renamed().iterator();
                while (it.hasNext()) {
                    int i2 = 0;
                    for (java.nio.IntBuffer intBufferA = it.next().a_renamed(); i2 < intBufferA.capacity(); intBufferA = intBufferA) {
                        int i3 = intBufferA.get(i2) * 3;
                        fArr[0] = this.f7983b.get(i3);
                        fArr[1] = this.f7983b.get(i3 + 1);
                        fArr[2] = this.f7983b.get(i3 + 2);
                        fArr[3] = 1.0f;
                        android.opengl.Matrix.multiplyMV(fArr2, 0, C_renamed(), 0, fArr, 0);
                        dVar.a_renamed(fArr2[0], fArr2[1], fArr2[2]);
                        i2++;
                    }
                }
            }
            this.g_renamed = dVar;
            com.b_renamed.a_renamed.b_renamed.c_renamed("Object3DData", "Calculated current dimensions for '" + g_renamed() + "': " + this.g_renamed);
        }
        return this.g_renamed;
    }

    public boolean l_renamed() {
        return this.k_renamed;
    }

    public boolean m_renamed() {
        return this.D_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.D_renamed = z_renamed;
    }

    public float[] n_renamed() {
        return j_renamed().c_renamed();
    }

    public int o_renamed() {
        return this.m_renamed;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed a_renamed(int i_renamed) {
        this.m_renamed = i_renamed;
        return this;
    }

    public byte[] q_renamed() {
        return this.s_renamed;
    }

    public void a_renamed(byte[] bArr) {
        this.s_renamed = bArr;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed a_renamed(float[] fArr) {
        this.f_renamed = fArr;
        a_renamed();
        L_renamed();
        this.D_renamed = true;
        return this;
    }

    public float[] r_renamed() {
        return this.f_renamed;
    }

    public float s_renamed() {
        float[] fArr = this.f_renamed;
        if (fArr != null) {
            return fArr[0];
        }
        return 0.0f;
    }

    public float t_renamed() {
        float[] fArr = this.f_renamed;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    public float u_renamed() {
        float[] fArr = this.f_renamed;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    public float[] v_renamed() {
        return this.e_renamed;
    }

    public float w_renamed() {
        return this.e_renamed[2];
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed b_renamed(float[] fArr) {
        this.d_renamed = fArr;
        a_renamed();
        L_renamed();
        this.D_renamed = true;
        return this;
    }

    public float[] x_renamed() {
        return this.d_renamed;
    }

    public float y_renamed() {
        return x_renamed()[0];
    }

    public float z_renamed() {
        return x_renamed()[1];
    }

    public float A_renamed() {
        return x_renamed()[2];
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed c_renamed(float[] fArr) {
        this.e_renamed = fArr;
        a_renamed();
        return this;
    }

    public float[] B_renamed() {
        return this.y_renamed;
    }

    private void a_renamed() {
        float[] fArr;
        android.opengl.Matrix.setIdentityM(this.A_renamed, 0);
        float[] fArr2 = this.x_renamed;
        if (fArr2 != null) {
            android.opengl.Matrix.rotateM(this.A_renamed, 0, fArr2[1], 0.0f, 1.0f, 0.0f);
        }
        if (r_renamed() != null) {
            android.opengl.Matrix.translateM(this.A_renamed, 0, s_renamed(), t_renamed(), u_renamed());
        }
        if (this.y_renamed != null && (fArr = this.z_renamed) != null) {
            android.opengl.Matrix.translateM(this.A_renamed, 0, fArr[0], fArr[1], fArr[2]);
            android.opengl.Matrix.rotateM(this.A_renamed, 0, B_renamed()[0], 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.rotateM(this.A_renamed, 0, B_renamed()[1], 0.0f, 1.0f, 0.0f);
            android.opengl.Matrix.rotateM(this.A_renamed, 0, B_renamed()[2], 0.0f, 0.0f, 1.0f);
            float[] fArr3 = this.A_renamed;
            float[] fArr4 = this.z_renamed;
            android.opengl.Matrix.translateM(fArr3, 0, -fArr4[0], -fArr4[1], -fArr4[2]);
        }
        if (v_renamed() != null) {
            android.opengl.Matrix.rotateM(this.A_renamed, 0, v_renamed()[0], 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.rotateM(this.A_renamed, 0, v_renamed()[1], 0.0f, 1.0f, 0.0f);
            android.opengl.Matrix.rotateM(this.A_renamed, 0, w_renamed(), 0.0f, 0.0f, 1.0f);
        }
        if (x_renamed() != null) {
            android.opengl.Matrix.scaleM(this.A_renamed, 0, y_renamed(), z_renamed(), A_renamed());
        }
        float[] fArr5 = this.B_renamed;
        if (fArr5 == null) {
            java.lang.System.arraycopy(this.A_renamed, 0, this.C_renamed, 0, 16);
        } else {
            android.opengl.Matrix.multiplyMM(this.C_renamed, 0, this.A_renamed, 0, fArr5, 0);
        }
        a_renamed(new org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed.a_renamed(this));
    }

    public float[] C_renamed() {
        return this.C_renamed;
    }

    public java.nio.IntBuffer D_renamed() {
        return this.u_renamed;
    }

    public java.nio.ShortBuffer E_renamed() {
        java.nio.IntBuffer intBuffer;
        if (this.v_renamed == null && (intBuffer = this.u_renamed) != null) {
            this.v_renamed = org.andresoviedo.a_renamed.b_renamed.a_renamed.b_renamed(intBuffer.capacity());
            for (int i_renamed = 0; i_renamed < this.u_renamed.capacity(); i_renamed++) {
                this.v_renamed.put((short) this.u_renamed.get(i_renamed));
            }
        }
        return this.v_renamed;
    }

    public java.nio.FloatBuffer F_renamed() {
        return this.q_renamed;
    }

    public java.nio.FloatBuffer G_renamed() {
        return this.f7983b;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed c_renamed(java.nio.FloatBuffer floatBuffer) {
        this.f7983b = floatBuffer;
        L_renamed();
        return this;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed d_renamed(java.nio.FloatBuffer floatBuffer) {
        this.r_renamed = floatBuffer;
        return this;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed e_renamed(java.nio.FloatBuffer floatBuffer) {
        this.q_renamed = floatBuffer;
        return this;
    }

    public java.nio.FloatBuffer H_renamed() {
        return this.n_renamed;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed f_renamed(java.nio.FloatBuffer floatBuffer) {
        this.n_renamed = floatBuffer;
        return this;
    }

    public java.nio.FloatBuffer I_renamed() {
        return this.p_renamed;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed g_renamed(java.nio.FloatBuffer floatBuffer) {
        this.p_renamed = floatBuffer;
        return this;
    }

    public java.util.List<int[]> J_renamed() {
        return this.w_renamed;
    }

    public java.nio.FloatBuffer K_renamed() {
        return this.r_renamed;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed h_renamed(java.nio.FloatBuffer floatBuffer) {
        if (floatBuffer != null && floatBuffer.capacity() % 4 != 0) {
            throw new java.lang.IllegalArgumentException("Color buffer not multiple of_renamed 4 floats");
        }
        this.o_renamed = floatBuffer;
        return this;
    }

    public java.util.List<java.lang.String> M_renamed() {
        return this.F_renamed;
    }

    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed a_renamed(java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed> list) {
        this.f7984c = list;
        L_renamed();
        return this;
    }

    public java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed> N_renamed() {
        if (this.f7984c == null && D_renamed() != null) {
            org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed eVar = new org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed(g_renamed(), D_renamed(), null);
            eVar.a_renamed(j_renamed());
            this.f7984c = java.util.Collections.singletonList(eVar);
        }
        return this.f7984c;
    }

    @Override // 
    /* renamed from: f_renamed, reason: merged with bridge method [inline-methods] */
    public org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed clone() {
        org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar = new org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed();
        a_renamed(gVar);
        return gVar;
    }

    void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar) {
        gVar.a_renamed(g_renamed());
        gVar.a_renamed((float[]) r_renamed().clone());
        gVar.b_renamed((float[]) x_renamed().clone());
        gVar.c_renamed((float[]) v_renamed().clone());
        gVar.a_renamed(d_renamed());
        gVar.c_renamed(G_renamed());
        gVar.f_renamed(H_renamed());
        gVar.h_renamed(K_renamed());
        gVar.g_renamed(I_renamed());
        gVar.a_renamed(j_renamed());
        gVar.a_renamed(N_renamed());
        gVar.a_renamed(o_renamed());
        gVar.a_renamed(i_renamed());
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Object3DData{id_renamed='");
        sb.append(this.h_renamed);
        sb.append("', name=");
        sb.append(h_renamed());
        sb.append(", isVisible=");
        sb.append(this.k_renamed);
        sb.append(", color=");
        sb.append(java.util.Arrays.toString(j_renamed().c_renamed()));
        sb.append(", position=");
        sb.append(java.util.Arrays.toString(this.f_renamed));
        sb.append(", scale=");
        sb.append(java.util.Arrays.toString(this.d_renamed));
        sb.append(", indexed=");
        sb.append(!i_renamed());
        sb.append(", vertices: ");
        java.nio.FloatBuffer floatBuffer = this.f7983b;
        sb.append(floatBuffer != null ? floatBuffer.capacity() / 3 : 0);
        sb.append(", normals: ");
        java.nio.FloatBuffer floatBuffer2 = this.n_renamed;
        sb.append(floatBuffer2 != null ? floatBuffer2.capacity() / 3 : 0);
        sb.append(", dimensions: ");
        sb.append(this.E_renamed);
        sb.append(", current dimensions: ");
        sb.append(this.g_renamed);
        sb.append(", material=");
        sb.append(j_renamed());
        sb.append(", elements=");
        sb.append(N_renamed());
        sb.append('}');
        return sb.toString();
    }
}
