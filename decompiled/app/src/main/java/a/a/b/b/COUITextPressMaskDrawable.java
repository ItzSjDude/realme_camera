package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class q_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.q_renamed> q_renamed = new android.util.LruCache<>(5);
    public co_renamed.polarr.renderer.entities.Mesh r_renamed;

    public q_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("mul"), context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.q_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.q_renamed qVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (qVar == null) {
            qVar = new a_renamed.a_renamed.b_renamed.b_renamed.q_renamed(resources, context);
            qVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), qVar);
        }
        qVar.a_renamed(context);
        return qVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void h_renamed() {
        int i_renamed = this.f17c;
        if (i_renamed >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i_renamed);
            android.opengl.GLES20.glVertexAttribPointer(this.f17c, 3, 5126, false, 0, (java.nio.Buffer) this.r_renamed.mVerBuffer);
        }
        int i2 = this.d_renamed;
        if (i2 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i2);
            android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.r_renamed.mTexBuffer);
        }
        int i3 = this.e_renamed;
        if (i3 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i3);
            android.opengl.GLES20.glVertexAttribPointer(this.e_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.r_renamed.mDistortionBuffer);
        }
        int i4 = this.f_renamed;
        if (i4 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i4);
            android.opengl.GLES20.glVertexAttribPointer(this.f_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.r_renamed.mDeltaBuffer);
        }
        android.opengl.GLES20.glDrawElements(4, this.r_renamed.trianglesBuffer.capacity(), 5123, this.r_renamed.trianglesBuffer);
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
