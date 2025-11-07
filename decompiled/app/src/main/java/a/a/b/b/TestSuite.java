package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class i_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.i_renamed> q_renamed = new android.util.LruCache<>(5);

    public i_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("multitexture"), context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.i_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.i_renamed iVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (iVar == null) {
            iVar = new a_renamed.a_renamed.b_renamed.b_renamed.i_renamed(resources, context);
            iVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), iVar);
        }
        iVar.a_renamed(context);
        return iVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            android.opengl.GLES20.glActiveTexture(33984 + i_renamed);
            android.opengl.GLES20.glBindTexture(3553, this.f15a.textures[i_renamed]);
        }
        android.opengl.GLES20.glUniform1iv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "textures[0]"), 4, new int[]{0, 1, 2, 3}, 0);
    }
}
