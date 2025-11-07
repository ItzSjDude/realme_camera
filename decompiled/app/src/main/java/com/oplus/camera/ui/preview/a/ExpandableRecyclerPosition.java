package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: SuperTextTexturePreview.java */
/* loaded from: classes2.dex */
public class x_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6972a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f6973b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed f6974c;
    private com.oplus.camera.gl_renamed.s_renamed d_renamed;
    private boolean k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private final java.lang.Object p_renamed;
    private long q_renamed;

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void c_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int d_renamed() {
        return 64;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public x_renamed(android.content.Context context) {
        super(context);
        this.f6973b = null;
        this.d_renamed = null;
        this.k_renamed = false;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 1;
        this.p_renamed = new java.lang.Object();
        this.q_renamed = 0L;
        this.f6973b = context;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        this.f6974c = aaVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("SuperTextTexturePreview", "setSize, height: " + i2 + ", width: " + i_renamed);
        this.l_renamed = i_renamed;
        this.m_renamed = i2;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.d_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        this.d_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.l_renamed, this.m_renamed, true);
        this.k_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.d_renamed;
        if (sVar == null || sVar.n_renamed()) {
            return;
        }
        this.d_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("SuperTextTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.d_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SuperTextTexturePreview", "recycleTextures");
        if (this.k_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.d_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.d_renamed = null;
            }
            this.k_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar;
        return a__renamed(i_renamed) && this.k_renamed && (aaVar = this.f6974c) != null && aaVar.p_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (this.f6974c == null) {
            return false;
        }
        com.oplus.camera.gl_renamed.g_renamed gVar = aVar.f6976b;
        if (this.d_renamed == null) {
            return false;
        }
        synchronized (this.p_renamed) {
            int i_renamed = this.o_renamed;
            this.o_renamed = i_renamed + 1;
            if (i_renamed % 3 == 0 && !com.oplus.camera.y_renamed.b_renamed()) {
                if (this.n_renamed % 180 == 0) {
                    this.i_renamed.a_renamed(gVar.e_renamed(), gVar.i_renamed(), gVar.h_renamed(), this.d_renamed.e_renamed(), this.n_renamed, true, this.q_renamed);
                } else {
                    this.i_renamed.a_renamed(gVar.e_renamed(), gVar.h_renamed(), gVar.i_renamed(), this.d_renamed.e_renamed(), this.n_renamed, true, this.q_renamed);
                }
            } else if (com.oplus.camera.y_renamed.b_renamed()) {
                this.i_renamed.a_renamed((com.oplus.camera.u_renamed.a_renamed) null);
            }
        }
        f6972a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        synchronized (this.p_renamed) {
            this.n_renamed = i_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(long j_renamed) {
        super.a_renamed(j_renamed);
        synchronized (this.p_renamed) {
            this.q_renamed = j_renamed;
        }
    }
}
