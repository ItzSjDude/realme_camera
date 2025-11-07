package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: VideoRetentionV2TexturePreview.java */
/* loaded from: classes2.dex */
public class af_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6863a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6864b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6865c;
    private boolean d_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private com.oplus.camera.gl_renamed.s_renamed n_renamed;
    private com.oplus.camera.gl_renamed.s_renamed o_renamed;
    private com.oplus.ocs.camera.HumanEffectRetainApiV2Helper p_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed q_renamed;
    private com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoConfig r_renamed;
    private java.util.concurrent.locks.Lock s_renamed;

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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.af_renamed.a_renamed(int, boolean):int");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed() {
        return false;
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

    public af_renamed(android.content.Context context) {
        super(context);
        this.f6863a = 0;
        this.f6864b = 0;
        this.f6865c = 0;
        this.d_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = new java.util.concurrent.locks.ReentrantLock();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        this.s_renamed.lock();
        try {
            if (this.q_renamed != null) {
                if (this.q_renamed.h_renamed()) {
                    this.s_renamed.unlock();
                    if (this.k_renamed) {
                        return true;
                    }
                    com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "canProcess, texture is_renamed not init");
                    return false;
                }
            }
            return false;
        } finally {
            this.s_renamed.unlock();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        this.s_renamed.lock();
        try {
            if (this.q_renamed == null || aVar == null || aVar.f6977c == null || this.n_renamed == null) {
                com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "process, false");
            } else if (!this.d_renamed) {
                com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "process, not create, so return!");
            } else {
                this.s_renamed.unlock();
                com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
                int iH = sVar.h_renamed();
                int i_renamed = sVar.i_renamed();
                boolean z_renamed = this.g_renamed;
                this.s_renamed.lock();
                try {
                    if (this.l_renamed && !B_renamed()) {
                        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "process, inTextureWidth: " + i_renamed + ", inTextureHeight: " + iH);
                        a_renamed(i_renamed, iH, z_renamed);
                        this.l_renamed = false;
                    }
                    int iA = this.q_renamed.h_renamed() ? a_renamed(sVar.e_renamed(), new int[]{this.n_renamed.e_renamed()}, z_renamed, a_renamed(this.f6865c, z_renamed)) : -1;
                    this.m_renamed = iA == 0 || 4 == iA;
                    return this.m_renamed;
                } finally {
                }
            }
            return false;
        } finally {
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean y_renamed() {
        return this.m_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("VideoRetentionV2TexturePreview", "onDestroy");
        e_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(final com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "createEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.af_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.preview.a_renamed.af_renamed.this.s_renamed.lock();
                try {
                    if (com.oplus.camera.ui.preview.a_renamed.af_renamed.this.B_renamed()) {
                        com.oplus.camera.ui.preview.a_renamed.af_renamed.this.A_renamed();
                    }
                    com.oplus.camera.ui.preview.a_renamed.af_renamed.this.d_renamed = true;
                    com.oplus.camera.ui.preview.a_renamed.af_renamed.this.q_renamed = aaVar;
                    com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "createEngine X_renamed");
                } finally {
                    com.oplus.camera.ui.preview.a_renamed.af_renamed.this.s_renamed.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "destroyEngine, mHumanEffectApi: " + this.p_renamed);
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.af_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.preview.a_renamed.af_renamed.this.s_renamed.lock();
                try {
                    if (com.oplus.camera.ui.preview.a_renamed.af_renamed.this.p_renamed != null) {
                        com.oplus.camera.e_renamed.b_renamed("VideoRetentionV2TexturePreview", "destroyEngine, mHumanEffectApi release");
                        com.oplus.camera.ui.preview.a_renamed.af_renamed.this.h_renamed.g_renamed();
                        com.oplus.camera.ui.preview.a_renamed.af_renamed.this.p_renamed.release();
                        com.oplus.camera.ui.preview.a_renamed.af_renamed.this.p_renamed = null;
                    }
                    com.oplus.camera.ui.preview.a_renamed.af_renamed.this.q_renamed = null;
                    com.oplus.camera.ui.preview.a_renamed.af_renamed.this.d_renamed = false;
                    com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "destroyEngine X_renamed");
                } finally {
                    com.oplus.camera.ui.preview.a_renamed.af_renamed.this.s_renamed.unlock();
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.o_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.n_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "newTextures");
        this.o_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6863a, this.f6864b, true);
        this.n_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6863a, this.f6864b, true);
        this.k_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.o_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.o_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "prepareTextures, mInputTexture.getId: " + this.o_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.n_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.n_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "prepareTextures, mOutputTexture.getId: " + this.n_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "recycleTextures");
        if (this.k_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.o_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.o_renamed = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar2 = this.n_renamed;
            if (sVar2 != null) {
                sVar2.o_renamed();
                this.n_renamed = null;
            }
            this.k_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6863a = i2;
        this.f6864b = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        this.s_renamed.lock();
        try {
            this.l_renamed = z_renamed;
        } finally {
            this.s_renamed.unlock();
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.f6865c = i_renamed;
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        if (B_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "initVideoEffect, width: " + i_renamed + ", height: " + i2 + ", isFrontCamera: " + z_renamed);
        if (this.r_renamed == null) {
            this.r_renamed = r_renamed();
        }
        q_renamed();
        this.p_renamed.release();
        b_renamed(z_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    private void q_renamed() {
        com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.getInstance().preInit();
    }

    private int a_renamed(int i_renamed, int[] iArr, boolean z_renamed, int i2) {
        if (B_renamed() || iArr == null) {
            return -1;
        }
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "processVideoEffect, textureInput: " + i_renamed + ", textureOutput[0]: " + iArr[0] + ", isFrontCamera: " + z_renamed + ", orientation: " + i2 + ", mWidth: " + this.f6863a + ", mHeight: " + this.f6864b);
        int iA = a_renamed(i_renamed, iArr, i2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glFinish();
        return iA;
    }

    private com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoConfig r_renamed() {
        java.lang.String str = this.j_renamed.getApplicationContext().getCacheDir() + java.io.File.separator + "anc_cache";
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoConfig humanVideoConfig = new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoConfig();
        humanVideoConfig.nativeLibPath = "/odm/lib64;/odm/lib/rfsa/adsp";
        humanVideoConfig.isRealTime = true;
        humanVideoConfig.cachePath = str;
        humanVideoConfig.modelPath = "odm/etc/camera/megvii/video_retention_model";
        humanVideoConfig.sdkLoadType = com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.SdkLoadType.ANC_LOAD_TYPE_VNDKSUPPORT.ordinal();
        return humanVideoConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A_renamed() {
        this.p_renamed = com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.getInstance();
        this.p_renamed.setLogLevel(4);
        com.oplus.camera.e_renamed.b_renamed("VideoRetentionV2TexturePreview", "initVideoEffectPara, mHumanEffectApi: " + this.p_renamed);
    }

    private int a_renamed(int i_renamed, int[] iArr, int i2) {
        com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequest humanProcessTextureRequestBuild = new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTextureRequestBuilder().setCameraType(this.g_renamed ? com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.CameraType.CAMERA_TYPE_FRONT : com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.CameraType.CAMERA_TYPE_REAR).setHeight(this.f6864b).setWidth(this.f6863a).setRotation(i2).setOES(false).setTexID(i_renamed).build();
        com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTexureResult humanProcessTexureResult = new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanProcessTexureResult(iArr[0], false, this.f6863a, this.f6864b, i2);
        int iProcess = this.p_renamed.process(humanProcessTextureRequestBuild, humanProcessTexureResult);
        com.oplus.camera.e_renamed.a_renamed("VideoRetentionV2TexturePreview", "processEffect, request: " + humanProcessTextureRequestBuild + ", result: " + humanProcessTexureResult + ", processResult: " + iProcess);
        return iProcess;
    }

    private void b_renamed(boolean z_renamed) {
        int iInitHandle = this.p_renamed.initHandle(this.r_renamed);
        com.oplus.camera.e_renamed.b_renamed("VideoRetentionV2TexturePreview", "initVideoRetentionV2, initResult: " + iInitHandle + ", paraRet: " + this.p_renamed.setParams(new com.oplus.ocs.camera.HumanEffectRetainApiV2Helper.HumanVideoRetainParams(z_renamed ? "odm/etc/camera/megvii/videolut_portrait_front.png" : "odm/etc/camera/megvii/videolut_portrait.png", "odm/etc/camera/megvii/videolut_background.png")) + ", sdk version: " + this.p_renamed.getVersion());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B_renamed() {
        return this.p_renamed == null;
    }
}
