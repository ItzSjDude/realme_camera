package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: VideoBlurTexturePreview.java */
/* loaded from: classes2.dex */
public class ac_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6842a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Object f6843b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6844c;
    private int d_renamed;
    private int k_renamed;
    private com.oplus.camera.gl_renamed.s_renamed l_renamed;
    private com.oplus.camera.gl_renamed.s_renamed m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private com.oplus.ocs.camera.HumanEffectBokehHelper p_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed q_renamed;
    private boolean r_renamed;

    private int a_renamed(int i_renamed, boolean z_renamed) {
        if (z_renamed) {
            if (i_renamed != 0) {
                if (i_renamed != 90) {
                    if (i_renamed != 180) {
                        return 0;
                    }
                    return 270;
                }
                return 180;
            }
            return 90;
        }
        if (i_renamed != 0) {
            if (i_renamed != 90) {
                if (i_renamed != 180) {
                    return 0;
                }
                return 90;
            }
            return 180;
        }
        return 270;
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
        return 32;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int[] z_renamed() {
        return null;
    }

    public ac_renamed(android.content.Context context) {
        super(context);
        this.f6843b = new java.lang.Object();
        this.f6844c = 0;
        this.d_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        synchronized (this.f6843b) {
            if (this.q_renamed == null) {
                return false;
            }
            if (!this.q_renamed.b_renamed()) {
                return false;
            }
            if (this.r_renamed) {
                return true;
            }
            com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "canProcess, texture is_renamed not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        boolean z_renamed;
        int iA;
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (this.q_renamed == null || aVar == null || aVar.f6977c == null || this.l_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "process, false");
            return false;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
        int iH = sVar.h_renamed();
        int i_renamed = sVar.i_renamed();
        boolean z2 = this.g_renamed;
        synchronized (this.f6843b) {
            if (this.n_renamed) {
                com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "process, inTextureWidth: " + i_renamed + ", inTextureHeight: " + iH);
                q_renamed();
                this.n_renamed = false;
            }
            int iA2 = a_renamed(this.k_renamed, z2);
            float fG_renamed = this.q_renamed.g_renamed();
            int iE = sVar.e_renamed();
            z_renamed = true;
            iA = a_renamed(iE, new int[]{this.l_renamed.e_renamed()}, z2, fG_renamed, iA2, this.q_renamed.I_renamed());
        }
        this.o_renamed = iA == 0;
        if (iA != 0 && 4 != iA && 5 != iA && 6 != iA) {
            z_renamed = false;
        }
        f6842a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
        return z_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean y_renamed() {
        return this.o_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(final com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "createEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ac_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.f6843b) {
                    com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.q_renamed = aaVar;
                    com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "createEngine X_renamed");
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "destroyEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ac_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.f6843b) {
                    if (com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.p_renamed != null) {
                        com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.h_renamed.g_renamed();
                        com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.p_renamed.release();
                        com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.p_renamed = null;
                    }
                    com.oplus.camera.ui.preview.a_renamed.ac_renamed.this.q_renamed = null;
                    com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "destroyEngine X_renamed");
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.m_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.l_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "newTextures");
        this.m_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6844c, this.d_renamed, true);
        this.l_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6844c, this.d_renamed, true);
        this.r_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.m_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.m_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.m_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.l_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.l_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "recycleTextures");
        if (this.r_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.m_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.m_renamed = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar2 = this.l_renamed;
            if (sVar2 != null) {
                sVar2.o_renamed();
                this.l_renamed = null;
            }
            this.r_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6844c = i2;
        this.d_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        synchronized (this.f6843b) {
            this.n_renamed = z_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.k_renamed = i_renamed;
    }

    private void q_renamed() {
        if (r_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "initVideoBlur, start");
            java.lang.String configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_CACHE_PATH);
            java.lang.String str = !android.text.TextUtils.isEmpty(configStringValue) ? configStringValue : this.j_renamed.getApplicationContext().getCacheDir() + java.io.File.separator + "anc_cache";
            com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "initVideoBlur, path:" + str);
            try {
                java.io.File file = new java.io.File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            this.p_renamed = new com.oplus.ocs.camera.HumanEffectBokehHelper(str, "odm/etc/camera/megvii/merged_model", "/odm/lib64;/odm/lib/rfsa/adsp", com.oplus.camera.util.Util.C_renamed(), com.oplus.camera.e_renamed.a_renamed() ? 4 : 0);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        }
    }

    private int a_renamed(int i_renamed, int[] iArr, boolean z_renamed, float f_renamed, int i2, android.graphics.Point point) {
        int iProcess;
        if (r_renamed() || iArr == null) {
            return -1;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (point != null) {
            iProcess = this.p_renamed.process(i_renamed, iArr[0], -1, null, null, f_renamed, i2, z_renamed ? 1 : 0, point.x_renamed, point.y_renamed, this.f6844c, this.d_renamed);
        } else {
            iProcess = this.p_renamed.process(i_renamed, iArr[0], -1, null, null, f_renamed, i2, z_renamed ? 1 : 0, 0.0f, 0.0f, this.f6844c, this.d_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("VideoBlurTexturePreview", "processVideoBlur, result: " + iProcess + ", costTime: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        return iProcess;
    }

    private boolean r_renamed() {
        return this.p_renamed == null;
    }
}
