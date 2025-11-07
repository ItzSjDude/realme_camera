package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: FilterTexturePreview.java */
/* loaded from: classes2.dex */
public class l_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed implements com.oplus.camera.ui.preview.a_renamed.aa_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6911a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed f6912b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6913c;
    private int d_renamed;
    private com.oplus.camera.gl_renamed.s_renamed k_renamed;
    private com.oplus.camera.gl_renamed.s_renamed l_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed m_renamed;
    private com.oplus.camera.ui.preview.a_renamed.a_renamed n_renamed;
    private com.oplus.camera.ui.preview.a_renamed.a_renamed o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private java.lang.String r_renamed;
    private boolean s_renamed;
    private java.lang.String t_renamed;

    /* compiled from: FilterTexturePreview.java */
    public enum a_renamed {
        Polarr,
        Anc
    }

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
        return 2;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public l_renamed(android.content.Context context) {
        super(context);
        this.f6912b = com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr;
        this.f6913c = 0;
        this.d_renamed = 0;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = "default";
        this.s_renamed = false;
        this.t_renamed = "";
        this.n_renamed = new com.oplus.camera.ui.preview.a_renamed.s_renamed();
        this.o_renamed = new com.oplus.camera.ui.preview.a_renamed.b_renamed();
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed aVar) {
        this.f6912b = aVar;
    }

    private com.oplus.camera.ui.preview.a_renamed.a_renamed q_renamed() {
        if (com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr == this.f6912b) {
            return this.n_renamed;
        }
        return this.o_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (this.m_renamed == null || aVar == null || aVar.f6977c == null) {
            return false;
        }
        java.lang.String str = this.t_renamed;
        boolean zN = this.m_renamed.n_renamed();
        if ("default".equals(str)) {
            return false;
        }
        q_renamed().a_renamed(this.j_renamed, g_renamed().h_renamed(), g_renamed().i_renamed(), this.p_renamed);
        com.oplus.camera.e_renamed.a_renamed("Filter.process");
        q_renamed().a_renamed(this.l_renamed.e_renamed());
        q_renamed().b_renamed(aVar.f6977c.e_renamed());
        if (this.p_renamed || !str.equals(this.r_renamed)) {
            if (zN) {
                q_renamed().a_renamed(-0.7f, 0.44f, 0.83f, 0.25f, -0.74f, 0.98f);
            }
            q_renamed().a_renamed(str);
            this.r_renamed = str;
        }
        q_renamed().b_renamed();
        if (zN) {
            q_renamed().c_renamed();
        } else {
            q_renamed().d_renamed();
        }
        this.p_renamed = false;
        com.oplus.camera.e_renamed.b_renamed("Filter.process");
        f6911a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
        return true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (this.m_renamed == null || "default".equals(this.t_renamed) || !this.s_renamed || !a__renamed(i_renamed)) {
            return false;
        }
        if (this.l_renamed == null || this.k_renamed == null) {
            com.oplus.camera.e_renamed.e_renamed("FilterTexturePreview", "canProcess, mOutputTexture or mInputTexture is_renamed null, mOutputTexture: " + this.l_renamed + ", mInputTexture: " + this.k_renamed);
            return false;
        }
        if (this.q_renamed) {
            return true;
        }
        com.oplus.camera.e_renamed.f_renamed("FilterTexturePreview", "canProcess, texture is_renamed not inited");
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        this.p_renamed = z_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "createEngine");
        this.m_renamed = aaVar;
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar2 = this.m_renamed;
        if (aaVar2 != null) {
            aaVar2.a_renamed(this);
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.l_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "destroyEngine");
                com.oplus.camera.e_renamed.f_renamed("FilterTexturePreview", "destroyEngine, mReques: " + com.oplus.camera.ui.preview.a_renamed.l_renamed.this.m_renamed + ", mGLRootView: " + com.oplus.camera.ui.preview.a_renamed.l_renamed.this.h_renamed);
                com.oplus.camera.ui.preview.a_renamed.l_renamed.this.n_renamed.e_renamed();
                com.oplus.camera.ui.preview.a_renamed.l_renamed.this.o_renamed.e_renamed();
                if (com.oplus.camera.ui.preview.a_renamed.l_renamed.this.m_renamed != null) {
                    com.oplus.camera.ui.preview.a_renamed.l_renamed.this.m_renamed.G_renamed();
                    com.oplus.camera.ui.preview.a_renamed.l_renamed.this.m_renamed = null;
                }
                com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "destroyEngine X_renamed");
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.k_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.l_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        this.l_renamed = sVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "newTextures");
        this.k_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6913c, this.d_renamed, true);
        this.l_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6913c, this.d_renamed, true);
        this.q_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.k_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.k_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "prepareTextures, mInputTexture id_renamed: " + this.k_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.l_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "prepareTextures, mOutputTexture id_renamed: " + this.l_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        if (this.q_renamed) {
            if (this.k_renamed != null) {
                com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "recycleTextures, mInputTexture id_renamed: " + this.k_renamed.e_renamed());
                this.k_renamed.o_renamed();
                this.k_renamed = null;
            }
            if (this.l_renamed != null) {
                com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "recycleTextures, mOutputTexture id_renamed: " + this.l_renamed.e_renamed());
                this.l_renamed.o_renamed();
                this.l_renamed = null;
            }
            this.q_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("FilterTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6913c = i2;
        this.d_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.c_renamed
    public void b_renamed(boolean z_renamed) {
        this.s_renamed = z_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.c_renamed
    public void a_renamed(java.lang.String str) {
        this.t_renamed = str;
    }
}
