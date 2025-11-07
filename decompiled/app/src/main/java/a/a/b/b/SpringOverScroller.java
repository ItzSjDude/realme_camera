package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class y_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.y_renamed> q_renamed = new android.util.LruCache<>(5);

    public y_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("blur_composite"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.y_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.y_renamed yVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (yVar == null) {
            yVar = new a_renamed.a_renamed.b_renamed.b_renamed.y_renamed(resources, context);
            yVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), yVar);
        }
        yVar.a_renamed(context);
        return yVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "blurTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.lensBlurTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
    }
}
