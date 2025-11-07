package com.oplus.camera.gl_renamed;

/* compiled from: RawTexture.java */
/* loaded from: classes2.dex */
public class s_renamed extends com.oplus.camera.gl_renamed.c_renamed {
    private final boolean h_renamed;
    private boolean i_renamed;
    private android.hardware.camera2.CaptureResult j_renamed = null;
    private float[] k_renamed = null;

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public int m_renamed() {
        return 3553;
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public void q_renamed() {
    }

    public s_renamed(int i_renamed, int i2, boolean z_renamed) {
        this.h_renamed = z_renamed;
        a_renamed(i_renamed, i2);
    }

    @Override // com.oplus.camera.gl_renamed.v_renamed
    public boolean r_renamed() {
        return this.h_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    public boolean d_renamed() {
        return this.i_renamed;
    }

    public void c_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        this.f4613c = hVar.a_renamed().b_renamed();
        hVar.a_renamed(this, 6408, 5121);
        hVar.b_renamed(this);
        this.d_renamed = 1;
        a_renamed(hVar);
    }

    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed) {
        this.f4613c = i_renamed;
        hVar.b_renamed(this, 6408, 5121);
        hVar.b_renamed(this);
        this.d_renamed = 1;
        a_renamed(hVar);
    }

    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3) {
        this.f4613c = i_renamed;
        a_renamed(i2, i3);
        this.d_renamed = 1;
    }

    public void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        this.j_renamed = captureResult;
    }

    public android.hardware.camera2.CaptureResult s_renamed() {
        return this.j_renamed;
    }

    public void a_renamed(float[] fArr) {
        this.k_renamed = fArr;
    }

    public float[] t_renamed() {
        return this.k_renamed;
    }

    public boolean a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        return sVar != null && this.f4611a == sVar.f_renamed() && this.f4612b == sVar.g_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.c_renamed
    protected boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        if (n_renamed()) {
            return true;
        }
        com.oplus.camera.e_renamed.e_renamed("RawTexture", "onBind, lost the content due to context change");
        return false;
    }

    public java.lang.String toString() {
        return "{timestamp: " + j_renamed() + ", preview timestamp: " + k_renamed() + ", id_renamed: " + e_renamed() + "}";
    }
}
