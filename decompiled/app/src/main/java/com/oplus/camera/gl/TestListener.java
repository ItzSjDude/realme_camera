package com.oplus.camera.gl_renamed;

/* compiled from: ExtTexture.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.camera.gl_renamed.c_renamed {
    private int[] h_renamed;
    private int i_renamed;
    private int j_renamed;
    private boolean k_renamed;

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public void q_renamed() {
    }

    @Override // com.oplus.camera.gl_renamed.v_renamed
    public boolean r_renamed() {
        return true;
    }

    public g_renamed(int i_renamed) {
        this.h_renamed = new int[1];
        this.j_renamed = 0;
        this.k_renamed = false;
        android.util.Log.v_renamed("ExtTexture", "target = " + i_renamed);
        com.oplus.camera.gl_renamed.j_renamed.a_renamed(this.h_renamed);
        android.util.Log.v_renamed("ExtTexture", "sTextureId[0] = " + this.h_renamed[0]);
        this.f4613c = this.h_renamed[0];
        this.i_renamed = i_renamed;
    }

    public g_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed) {
        this.h_renamed = new int[1];
        this.j_renamed = 0;
        this.k_renamed = false;
        this.f4613c = hVar.a_renamed().b_renamed();
        this.i_renamed = i_renamed;
    }

    private void c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        hVar.b_renamed(this);
        a_renamed(hVar);
        this.d_renamed = 1;
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    protected boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        if (n_renamed()) {
            return true;
        }
        c_renamed(hVar);
        return true;
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public int m_renamed() {
        return this.i_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
    }

    public int s_renamed() {
        return this.j_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
    }

    public boolean t_renamed() {
        return this.k_renamed;
    }
}
