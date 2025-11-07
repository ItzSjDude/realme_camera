package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: FaceSlenderTexturePreview.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6898a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.gl_renamed.s_renamed f6899b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.gl_renamed.s_renamed f6900c;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed d_renamed;
    private com.oplus.ocs.camera.OplusFaceBeautyPreviewHelper k_renamed;
    private boolean l_renamed;
    private int m_renamed;
    private int n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private int q_renamed;
    private int r_renamed;
    private float s_renamed;
    private final java.lang.Object t_renamed;

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
        return 4;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public h_renamed(android.content.Context context) {
        super(context);
        this.f6899b = null;
        this.f6900c = null;
        this.d_renamed = null;
        this.k_renamed = null;
        this.l_renamed = false;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = -1;
        this.r_renamed = 1;
        this.s_renamed = 1.0f;
        this.t_renamed = new java.lang.Object();
        this.q_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE);
        if (com.oplus.camera.e_renamed.a_renamed()) {
            this.r_renamed = 2;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(byte[] bArr, int i_renamed, int i2) {
        synchronized (this.t_renamed) {
            if (this.k_renamed != null && bArr != null) {
                this.k_renamed.updataMetaParams(bArr);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(byte[] bArr, byte[] bArr2, int i_renamed, int i2) {
        synchronized (this.t_renamed) {
            if (this.k_renamed != null) {
                this.k_renamed.updataMetaParams(bArr);
                this.k_renamed.updataFfd(bArr2);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (this.d_renamed == null || aVar == null || aVar.f6977c == null || !aVar.h_renamed) {
            com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "process, mReques: " + this.d_renamed + ", frameInfo: " + aVar);
            return false;
        }
        if (this.l_renamed) {
            b_renamed(aVar.f6977c.h_renamed(), aVar.f6977c.i_renamed());
            this.l_renamed = false;
        }
        if (this.k_renamed == null) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview.process");
        this.k_renamed.setPreviewParams("preview_face_beauty_enable", com.oplus.camera.ui.preview.a_renamed.g_renamed.a_renamed(this.d_renamed.j_renamed() != 0));
        this.k_renamed.setPreviewParams("preview_makeup_type", this.d_renamed.k_renamed());
        this.k_renamed.setPreviewParams("preview_ai_video_state", java.lang.String.valueOf(this.d_renamed.K_renamed()));
        this.k_renamed.setPreviewParams("preview_face_dr_state", java.lang.String.valueOf(this.d_renamed.L_renamed()));
        if ("none".equals(this.d_renamed.k_renamed())) {
            this.k_renamed.setPreviewParams("preview_makeup_value", java.lang.String.valueOf(0));
        } else {
            this.k_renamed.setPreviewParams("preview_makeup_value", java.lang.String.valueOf(this.d_renamed.l_renamed()));
        }
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "process, makeup type: " + this.d_renamed.k_renamed() + ", makeup level: " + this.d_renamed.l_renamed());
        this.k_renamed.updataPreviewParams(this.d_renamed.u_renamed());
        this.k_renamed.process(aVar.f6977c.e_renamed(), new int[]{this.f6900c.e_renamed()}, null, this.d_renamed.q_renamed());
        com.oplus.camera.e_renamed.b_renamed("FaceSlenderTexturePreview.process");
        float zoomScale = this.k_renamed.getZoomScale();
        if (this.d_renamed.H_renamed() != null && java.lang.Float.compare(zoomScale, this.s_renamed) != 0) {
            com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "process, zoomScale: " + zoomScale);
            this.s_renamed = zoomScale;
            this.d_renamed.H_renamed().a_renamed(zoomScale);
        }
        f6898a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
        return true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int k_renamed() {
        com.oplus.ocs.camera.OplusFaceBeautyPreviewHelper oplusFaceBeautyPreviewHelper = this.k_renamed;
        if (oplusFaceBeautyPreviewHelper != null) {
            return oplusFaceBeautyPreviewHelper.reset();
        }
        return -1;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        int iJ;
        if (!a__renamed(i_renamed)) {
            return false;
        }
        if (this.f6900c == null || this.f6899b == null) {
            com.oplus.camera.e_renamed.e_renamed("FaceSlenderTexturePreview", "canProcess, mOutputTexture or mInputTexture is_renamed null, mOutputTexture: " + this.f6900c + ", mInputTexture: " + this.f6899b);
            return false;
        }
        if (!this.o_renamed) {
            com.oplus.camera.e_renamed.e_renamed("FaceSlenderTexturePreview", "canProcess, texture is_renamed not inited");
            return false;
        }
        if (this.d_renamed == null) {
            com.oplus.camera.e_renamed.e_renamed("FaceSlenderTexturePreview", "canProcess, mRequest is_renamed null");
            return false;
        }
        try {
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            iJ = 0;
        }
        if (!com.oplus.camera.util.Util.C_renamed() && this.d_renamed.C_renamed() == 0 && this.d_renamed.H_renamed() != null && !this.d_renamed.H_renamed().a_renamed() && !this.g_renamed) {
            return false;
        }
        iJ = this.d_renamed.j_renamed();
        boolean z_renamed = (iJ == 0 && "none".equals(this.d_renamed.k_renamed())) ? false : true;
        if (!this.p_renamed && z_renamed) {
            k_renamed();
        }
        this.p_renamed = z_renamed;
        return z_renamed;
    }

    private void b_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "initOplusFaceBeautyPreview, textureWidth: " + i_renamed + ", textureHeight: " + i2 + ", facebeauty version: " + this.q_renamed + ", isMakeupSupport: " + this.d_renamed.m_renamed() + ", makeupType: " + this.d_renamed.k_renamed());
        com.oplus.camera.e_renamed.a_renamed("initOplusFaceBeautyPreview");
        boolean zA = this.d_renamed.H_renamed() != null ? this.d_renamed.H_renamed().a_renamed() : false;
        synchronized (this.t_renamed) {
            if (this.k_renamed != null) {
                this.h_renamed.g_renamed();
                this.k_renamed.destroy();
            }
            this.k_renamed = new com.oplus.ocs.camera.OplusFaceBeautyPreviewHelper();
            this.k_renamed.setPreviewParams("preview_makeup_support", com.oplus.camera.ui.preview.a_renamed.g_renamed.a_renamed(this.d_renamed.m_renamed()));
            this.k_renamed.setPreviewParams("preview_makeup_type", this.d_renamed.k_renamed());
            this.k_renamed.setPreviewParams("preview_ai_video_state", java.lang.String.valueOf(this.d_renamed.K_renamed()));
            this.k_renamed.setPreviewParams("preview_face_dr_state", java.lang.String.valueOf(this.d_renamed.L_renamed()));
            if ("none".equals(this.d_renamed.k_renamed())) {
                this.k_renamed.setPreviewParams("preview_makeup_value", java.lang.String.valueOf(0));
            } else {
                this.k_renamed.setPreviewParams("preview_makeup_value", java.lang.String.valueOf(this.d_renamed.l_renamed()));
            }
            this.k_renamed.init(i_renamed, i2, this.q_renamed, this.r_renamed, com.oplus.camera.l_renamed.c_renamed.h_renamed() ? "cn_renamed" : "", com.oplus.camera.util.Util.aw_renamed(), com.oplus.camera.util.Util.ax_renamed(), zA || this.g_renamed, true, this.d_renamed.t_renamed(), this.d_renamed.B_renamed());
        }
        com.oplus.camera.e_renamed.b_renamed("initOplusFaceBeautyPreview");
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "initOplusFaceBeautyPreview, X_renamed");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "setTextureSizeChanged, sizeChanged: " + z_renamed);
        this.l_renamed = z_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "createEngine");
        this.d_renamed = aaVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.h_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "destroyEngine");
                if (com.oplus.camera.ui.preview.a_renamed.h_renamed.this.h_renamed != null) {
                    synchronized (com.oplus.camera.ui.preview.a_renamed.h_renamed.this.t_renamed) {
                        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "destroyEngine, mOplusFaceBeautyPreviewHelper: " + com.oplus.camera.ui.preview.a_renamed.h_renamed.this.k_renamed);
                        if (com.oplus.camera.ui.preview.a_renamed.h_renamed.this.k_renamed != null) {
                            com.oplus.camera.ui.preview.a_renamed.h_renamed.this.h_renamed.g_renamed();
                            com.oplus.camera.ui.preview.a_renamed.h_renamed.this.k_renamed.destroy();
                            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                            com.oplus.camera.ui.preview.a_renamed.h_renamed.this.k_renamed = null;
                        }
                    }
                    com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "destroyEngine X_renamed");
                    return;
                }
                com.oplus.camera.e_renamed.f_renamed("FaceSlenderTexturePreview", "destroyEngine, , mGLRootView is_renamed null ");
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "newTextures");
        this.f6899b = new com.oplus.camera.gl_renamed.s_renamed(this.m_renamed, this.n_renamed, true);
        this.f6900c = new com.oplus.camera.gl_renamed.s_renamed(this.m_renamed, this.n_renamed, true);
        this.o_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.f6899b;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.f6900c;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        this.f6900c = sVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.f6899b;
        if (sVar != null && !sVar.n_renamed()) {
            this.f6899b.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "prepareTextures, mInputTexture id_renamed: " + this.f6899b.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.f6900c;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.f6900c.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "prepareTextures, mOutputTexture id_renamed: " + this.f6900c.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        if (this.o_renamed) {
            if (this.f6899b != null) {
                com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "recycleTextures, mInputTexture id_renamed: " + this.f6899b.e_renamed());
                this.f6899b.o_renamed();
                this.f6899b = null;
            }
            if (this.f6900c != null) {
                com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "recycleTextures, mOutputTexture id_renamed: " + this.f6900c.e_renamed());
                this.f6900c.o_renamed();
                this.f6900c = null;
            }
            this.o_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("FaceSlenderTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.m_renamed = i2;
        this.n_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int l_renamed() {
        return this.g_renamed ? 2 : 0;
    }
}
