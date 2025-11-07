package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: VideoRetentionTexturePreview.java */
/* loaded from: classes2.dex */
public class ae_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6857a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6858b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6859c;
    private int d_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private android.content.Context o_renamed;
    private com.oplus.camera.gl_renamed.s_renamed p_renamed;
    private com.oplus.camera.gl_renamed.s_renamed q_renamed;
    private com.oplus.ocs.camera.HumanVideoApiHelper r_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed s_renamed;
    private com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoConfig t_renamed;
    private java.util.concurrent.locks.Lock u_renamed;

    /* JADX WARN: Code restructure failed: missing block: B_renamed:10:0x0015, code lost:
    
        if (r5 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:14:?, code lost:
    
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:15:?, code lost:
    
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:7:0x000f, code lost:
    
        if (r5 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a_renamed(int r4, boolean r5) {
        /*
            r3 = this;
            r3 = 180(0xb4, float:2.52E-43)
            r0 = 0
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r4 == 0) goto L15
            if (r4 == r2) goto L18
            if (r4 == r3) goto Lf
            r3 = r0
            goto L18
        Lf:
            if (r5 == 0) goto L13
        L11:
            r3 = r1
            goto L18
        L13:
            r3 = r2
            goto L18
        L15:
            if (r5 == 0) goto L11
            goto L13
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.ae_renamed.a_renamed(int, boolean):int");
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
        return 256;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public ae_renamed(android.content.Context context) {
        super(context);
        this.f6858b = 0;
        this.f6859c = 0;
        this.d_renamed = 0;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = new java.util.concurrent.locks.ReentrantLock();
        this.o_renamed = context;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        this.u_renamed.lock();
        try {
            if (this.s_renamed != null) {
                if (this.s_renamed.h_renamed()) {
                    this.u_renamed.unlock();
                    if (this.l_renamed) {
                        return true;
                    }
                    com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "canProcess, texture is_renamed not init");
                    return false;
                }
            }
            return false;
        } finally {
            this.u_renamed.unlock();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        this.u_renamed.lock();
        try {
            if (this.s_renamed == null || aVar == null || aVar.f6977c == null || this.p_renamed == null) {
                com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "process, false");
            } else if (!this.k_renamed) {
                com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "process, not create, so return!");
            } else {
                this.u_renamed.unlock();
                com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
                int iH = sVar.h_renamed();
                int i_renamed = sVar.i_renamed();
                boolean z_renamed = this.g_renamed;
                this.u_renamed.lock();
                try {
                    if (this.m_renamed && !B_renamed()) {
                        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "process, inTextureWidth: " + i_renamed + ", inTextureHeight: " + iH);
                        a_renamed(i_renamed, iH, z_renamed);
                        this.m_renamed = false;
                    }
                    int iA = this.s_renamed.h_renamed() ? a_renamed(sVar.e_renamed(), new int[]{this.p_renamed.e_renamed()}, z_renamed, a_renamed(this.d_renamed, z_renamed)) : -1;
                    this.n_renamed = iA == 0 || 4 == iA;
                    f6857a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
                    return this.n_renamed;
                } finally {
                }
            }
            return false;
        } finally {
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean y_renamed() {
        return this.n_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(final com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "createEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ae_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.u_renamed.lock();
                try {
                    if (com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.B_renamed()) {
                        com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.A_renamed();
                    }
                    com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.k_renamed = true;
                    com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.s_renamed = aaVar;
                    com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "createEngine X_renamed");
                } finally {
                    com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.u_renamed.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "destroyEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ae_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.u_renamed.lock();
                try {
                    if (com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.r_renamed != null) {
                        com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.h_renamed.g_renamed();
                        com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.r_renamed.release();
                        com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.r_renamed = null;
                    }
                    com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.s_renamed = null;
                    com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.k_renamed = false;
                    com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "destroyEngine X_renamed");
                } finally {
                    com.oplus.camera.ui.preview.a_renamed.ae_renamed.this.u_renamed.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.q_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.p_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "newTextures");
        this.q_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6858b, this.f6859c, true);
        this.p_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6858b, this.f6859c, true);
        this.l_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.q_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.q_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "prepareTextures, mInputTexture.getId: " + this.q_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.p_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.p_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.p_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "recycleTextures");
        if (this.l_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.q_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.q_renamed = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar2 = this.p_renamed;
            if (sVar2 != null) {
                sVar2.o_renamed();
                this.p_renamed = null;
            }
            this.l_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6858b = i2;
        this.f6859c = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        this.u_renamed.lock();
        try {
            this.m_renamed = z_renamed;
        } finally {
            this.u_renamed.unlock();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        if (B_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "initVideoEffect, width: " + i_renamed + ", height: " + i2 + ", isFrontCamera: " + z_renamed);
        if (this.t_renamed == null) {
            this.t_renamed = r_renamed();
        }
        q_renamed();
        this.r_renamed.release();
        b_renamed(z_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    private void q_renamed() {
        com.oplus.ocs.camera.HumanVideoApiHelper.getInstance().preInit();
    }

    private int a_renamed(int i_renamed, int[] iArr, boolean z_renamed, int i2) {
        if (B_renamed() || iArr == null) {
            return -1;
        }
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "processVideoEffect, textureInput: " + i_renamed + ", textureOutput[0]: " + iArr[0] + ", isFrontCamera: " + z_renamed + ", orientation: " + i2 + ", mWidth: " + this.f6858b + ", mHeight: " + this.f6859c);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        int iA = a_renamed(i_renamed, iArr, i2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("processVideoEffect X_renamed, costTime: ");
        sb.append(java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", sb.toString());
        return iA;
    }

    private void a_renamed(com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessTextureRequest humanProcessTextureRequest, int i_renamed, int i2) {
        humanProcessTextureRequest.humanTexture.height = this.f6859c;
        humanProcessTextureRequest.humanTexture.width = this.f6858b;
        humanProcessTextureRequest.humanTexture.rotation = i2;
        humanProcessTextureRequest.humanTexture.texID = i_renamed;
        humanProcessTextureRequest.humanTexture.isOES = false;
    }

    private void a_renamed(com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessTexureResult humanProcessTexureResult, int[] iArr, int i_renamed) {
        humanProcessTexureResult.humanTexture.texID = iArr[0];
        humanProcessTexureResult.humanTexture.rotation = i_renamed;
        humanProcessTexureResult.humanTexture.width = this.f6858b;
        humanProcessTexureResult.humanTexture.height = this.f6859c;
        humanProcessTexureResult.humanTexture.isOES = false;
    }

    private com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoConfig r_renamed() {
        java.lang.String str = this.o_renamed.getApplicationContext().getCacheDir() + java.io.File.separator + "anc_cache";
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoConfig humanVideoConfig = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoConfig();
        humanVideoConfig.sdkCapability = com.oplus.ocs.camera.HumanVideoApiHelper.FeatureType.ANCHUM_FEATURE_RETAIN.getValue();
        humanVideoConfig.nativeLibPath = "/odm/lib64;/odm/lib/rfsa/adsp";
        humanVideoConfig.isRealTime = true;
        humanVideoConfig.cachePath = str;
        humanVideoConfig.modelPath = "odm/etc/camera/megvii/video_retention_model";
        return humanVideoConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A_renamed() {
        this.r_renamed = com.oplus.ocs.camera.HumanVideoApiHelper.getInstance();
        this.r_renamed.setLogLevel(4);
    }

    private int a_renamed(int i_renamed, int[] iArr, int i2) {
        com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessTextureRequest humanProcessTextureRequest = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessTextureRequest();
        com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessTexureResult humanProcessTexureResult = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanProcessTexureResult();
        a_renamed(humanProcessTextureRequest, i_renamed, i2);
        a_renamed(humanProcessTexureResult, iArr, i2);
        int iProcess = this.r_renamed.process(humanProcessTextureRequest, humanProcessTexureResult);
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "processVideoEffect, processResult: " + iProcess);
        return iProcess;
    }

    private void b_renamed(boolean z_renamed) {
        int iInitHandle = this.r_renamed.initHandle(this.t_renamed);
        this.r_renamed.enableRuntimeFeature(com.oplus.ocs.camera.HumanVideoApiHelper.FeatureType.ANCHUM_FEATURE_BOKEH, false);
        this.r_renamed.enableRuntimeFeature(com.oplus.ocs.camera.HumanVideoApiHelper.FeatureType.ANCHUM_FEATURE_RETAIN, true);
        com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoRetainParams humanVideoRetainParams = new com.oplus.ocs.camera.HumanVideoApiHelper.HumanVideoRetainParams();
        humanVideoRetainParams.bgPath = "odm/etc/camera/megvii/videolut_background.png";
        if (z_renamed) {
            humanVideoRetainParams.fgPath = "odm/etc/camera/megvii/videolut_portrait_front.png";
        } else {
            humanVideoRetainParams.fgPath = "odm/etc/camera/megvii/videolut_portrait.png";
        }
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionTexturePreview", "initVideoLut  initResult:" + iInitHandle + " paraRet:" + this.r_renamed.setParams(humanVideoRetainParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B_renamed() {
        return this.r_renamed == null;
    }
}
