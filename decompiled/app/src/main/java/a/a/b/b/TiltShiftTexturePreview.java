package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class ab_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.ab_renamed> q_renamed = new android.util.LruCache<>(5);
    public int r_renamed;
    public int s_renamed;
    public int t_renamed;
    public co_renamed.polarr.renderer.entities.Mesh u_renamed;

    public ab_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("compute_a"), context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.ab_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.ab_renamed abVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (abVar == null) {
            abVar = new a_renamed.a_renamed.b_renamed.b_renamed.ab_renamed(resources, context);
            abVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), abVar);
        }
        abVar.a_renamed(context);
        return abVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() {
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "mean_I");
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, this.r_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "mean_II");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 1);
        int iGlGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "mean_p");
        android.opengl.GLES20.glActiveTexture(33986);
        android.opengl.GLES20.glBindTexture(3553, this.t_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation3, 2);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void h_renamed() {
        int i_renamed = this.f17c;
        if (i_renamed >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i_renamed);
            android.opengl.GLES20.glVertexAttribPointer(this.f17c, 3, 5126, false, 0, (java.nio.Buffer) this.u_renamed.mVerBuffer);
        }
        int i2 = this.d_renamed;
        if (i2 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i2);
            android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.u_renamed.mTexBuffer);
        }
        int i3 = this.e_renamed;
        if (i3 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i3);
            android.opengl.GLES20.glVertexAttribPointer(this.e_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.u_renamed.mDistortionBuffer);
        }
        int i4 = this.f_renamed;
        if (i4 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i4);
            android.opengl.GLES20.glVertexAttribPointer(this.f_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.u_renamed.mDeltaBuffer);
        }
        android.opengl.GLES20.glDrawElements(4, this.u_renamed.trianglesBuffer.capacity(), 5123, this.u_renamed.trianglesBuffer);
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
}
