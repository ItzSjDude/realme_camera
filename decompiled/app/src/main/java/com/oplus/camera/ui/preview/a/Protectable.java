package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: AnimojiTexturePreview.java */
/* loaded from: classes2.dex */
public class c_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6878a = "0ms";
    private java.lang.String A_renamed;
    private java.lang.String B_renamed;
    private boolean C_renamed;
    private boolean D_renamed;
    private boolean E_renamed;
    private com.arcsoft.arcsoftjni.ArcSoftAvatarEngine F_renamed;
    private com.arcsoft.arcsoftjni.ArcSoftOffscreen G_renamed;
    private com.arcsoft.arcsoftjni.ArcSoftOffscreen H_renamed;
    private com.arcsoft.arcsoftjni.ArcSoftOffscreen I_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.Runnable f6879b;

    /* renamed from: c_renamed, reason: collision with root package name */
    java.lang.Runnable f6880c;
    java.lang.Runnable d_renamed;
    private final java.lang.Object k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private float[] o_renamed;
    private com.oplus.camera.gl_renamed.s_renamed p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private android.util.Size u_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed v_renamed;
    private boolean w_renamed;
    private boolean x_renamed;
    private boolean y_renamed;
    private boolean z_renamed;

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void c_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int d_renamed() {
        return 16;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed() {
        boolean z_renamed;
        synchronized (this.k_renamed) {
            z_renamed = this.D_renamed;
        }
        return z_renamed;
    }

    public c_renamed(android.content.Context context) {
        super(context);
        this.k_renamed = new java.lang.Object();
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = new float[3];
        this.p_renamed = null;
        this.q_renamed = false;
        this.r_renamed = false;
        this.s_renamed = false;
        this.t_renamed = false;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = false;
        this.x_renamed = false;
        this.y_renamed = false;
        this.z_renamed = false;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = false;
        this.D_renamed = false;
        this.E_renamed = false;
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.f6879b = new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.c_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.c_renamed.this.k_renamed) {
                    if (com.oplus.camera.ui.preview.a_renamed.c_renamed.this.z_renamed) {
                        return;
                    }
                    com.oplus.camera.ui.preview.a_renamed.c_renamed.this.r_renamed();
                }
            }
        };
        this.f6880c = new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.c_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.c_renamed.this.k_renamed) {
                    com.oplus.camera.ui.preview.a_renamed.c_renamed.this.a_renamed(com.oplus.camera.ui.preview.a_renamed.c_renamed.this.j_renamed, com.oplus.camera.ui.preview.a_renamed.c_renamed.this.l_renamed, com.oplus.camera.ui.preview.a_renamed.c_renamed.this.m_renamed);
                }
            }
        };
        this.d_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.c_renamed.3
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                com.oplus.camera.ui.preview.a_renamed.c_renamed.this.B_renamed();
            }
        };
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(byte[] bArr, int i_renamed, int i2) {
        if (this.w_renamed) {
            synchronized (this.k_renamed) {
                if (this.G_renamed == null || i_renamed != this.G_renamed.getWidth() || i2 != this.G_renamed.getHeight()) {
                    this.G_renamed = new com.arcsoft.arcsoftjni.ArcSoftOffscreen(i_renamed, i2, (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER_USE_NV12) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_YUV_FORMAT_NV12)) ? 2049 : 2050);
                    com.oplus.camera.e_renamed.a_renamed("AnimojiTexturePreview", "onPreviewCallback, new ArcSoftOffscreen, width: " + i_renamed + ", height: " + i2);
                }
                if (this.G_renamed != null && this.v_renamed != null && bArr != null) {
                    this.G_renamed.setData(bArr);
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar = this.v_renamed;
        if (aaVar == null) {
            return false;
        }
        if (aaVar.C_renamed() > 0 && this.C_renamed) {
            this.C_renamed = false;
        }
        if (a__renamed(i_renamed) && this.x_renamed && this.v_renamed.r_renamed() && this.v_renamed.s_renamed() && 2 == this.v_renamed.o_renamed().getMaterialType()) {
            return !this.C_renamed;
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) throws java.lang.Throwable {
        com.arcsoft.arcsoftjni.ArcSoftOffscreen arcSoftOffscreen;
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (this.v_renamed == null || !this.w_renamed || this.F_renamed == null || this.p_renamed == null || (arcSoftOffscreen = this.G_renamed) == null || arcSoftOffscreen.getData() == null || aVar == null || aVar.j_renamed <= 0 || aVar.k_renamed <= 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("process, something wrong, so return! mRequest: ");
            sb.append(this.v_renamed);
            sb.append(", mbInitialized: ");
            sb.append(this.w_renamed);
            sb.append(", mAvatarEngineRender: ");
            sb.append(this.F_renamed);
            sb.append(", mOutputAnimojiTexture: ");
            sb.append(this.p_renamed);
            sb.append(", mPreviewOffscreen: ");
            sb.append(this.G_renamed);
            sb.append(", mPreviewOffscreen.data: ");
            com.arcsoft.arcsoftjni.ArcSoftOffscreen arcSoftOffscreen2 = this.G_renamed;
            sb.append(arcSoftOffscreen2 != null ? arcSoftOffscreen2.getData() : null);
            sb.append(", frameInfo: ");
            sb.append(aVar);
            sb.append(", outTextureWidth: ");
            sb.append(aVar == null ? 0 : aVar.j_renamed);
            sb.append(", outTextureHeight: ");
            sb.append(aVar == null ? 0 : aVar.k_renamed);
            com.oplus.camera.e_renamed.e_renamed("AnimojiTexturePreview", sb.toString());
            return false;
        }
        int i_renamed = this.n_renamed;
        int i2 = this.f_renamed;
        int i3 = aVar.j_renamed;
        int i4 = aVar.k_renamed;
        synchronized (this.k_renamed) {
            try {
                try {
                    if (this.F_renamed == null) {
                        return false;
                    }
                    if (!this.q_renamed) {
                        if (!this.E_renamed) {
                            com.oplus.camera.util.Util.a_renamed(this.d_renamed);
                            this.E_renamed = true;
                        }
                        com.oplus.camera.e_renamed.f_renamed("AnimojiTexturePreview", "process, non selected template!");
                        return false;
                    }
                    boolean z_renamed = this.g_renamed;
                    this.F_renamed.setDevicesOrientation(i_renamed);
                    int iA = this.i_renamed != null ? this.i_renamed.a_renamed(i2, i_renamed) : 0;
                    if (this.y_renamed && this.H_renamed != null && this.H_renamed.getData() != null) {
                        this.F_renamed.process(this.G_renamed, this.H_renamed, 90, iA, z_renamed);
                    } else {
                        this.F_renamed.process(this.G_renamed, null, 90, iA, z_renamed);
                    }
                    float f_renamed = this.o_renamed[0];
                    float f2 = this.o_renamed[1];
                    float f3 = this.o_renamed[2];
                    android.opengl.GLES20.glClearColor(f_renamed, f2, f3, 1.0f);
                    android.opengl.GLES20.glViewport(0, 0, i3, i4);
                    int[] iArr = new int[1];
                    long jRender = this.F_renamed.render(i3, i4, 0, false, iArr, null);
                    this.p_renamed.a_renamed(aVar.f6975a, iArr[0], i3, i4);
                    this.D_renamed = true;
                    if (this.s_renamed) {
                        com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "process, captureRender start");
                        this.s_renamed = false;
                        this.I_renamed = new com.arcsoft.arcsoftjni.ArcSoftOffscreen(this.u_renamed.getWidth(), this.u_renamed.getHeight(), (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER_USE_NV12) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_YUV_FORMAT_NV12)) ? 2049 : 2050);
                        this.I_renamed.setData(new byte[(int) (this.u_renamed.getWidth() * this.u_renamed.getHeight() * 1.5f)]);
                        android.opengl.GLES20.glClearColor(f_renamed, f2, f3, 1.0f);
                        com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "process, captureRender end, captureResult: " + this.F_renamed.render(this.I_renamed.getWidth(), this.I_renamed.getHeight(), 270, this.t_renamed, null, this.I_renamed));
                    }
                    f6878a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
                    return jRender != -1;
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("AnimojiTexturePreview", "createEngine, reques: " + aaVar + ", mbCreateEngine: " + this.z_renamed);
        this.v_renamed = aaVar;
        if (this.z_renamed) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("Animoji.createEngine");
        this.z_renamed = true;
        this.C_renamed = true;
        this.D_renamed = false;
        com.oplus.camera.util.Util.a_renamed(this.f6880c);
        synchronized (this.k_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.d_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("Animoji.createEngine");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("AnimojiTexturePreview", "destroyEngine, mReques: " + this.v_renamed);
        if (this.z_renamed) {
            this.z_renamed = false;
            this.C_renamed = false;
            if (this.v_renamed == null || this.h_renamed == null) {
                return;
            }
            this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.c_renamed.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (com.oplus.camera.ui.preview.a_renamed.c_renamed.this.k_renamed) {
                        com.oplus.camera.ui.preview.a_renamed.c_renamed.this.A_renamed();
                    }
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.ui.preview.a_renamed.c_renamed.this.f6879b);
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.p_renamed;
    }

    private boolean q_renamed() {
        com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2 c0096aB = com.oplus.camera.e_renamed.a_renamed.b_renamed();
        com.oplus.camera.e_renamed.a_renamed.CameraCharacteristicsUtil_2 c0096aC = com.oplus.camera.e_renamed.a_renamed.c_renamed();
        if (c0096aB == null || c0096aC == null || !c0096aB.a_renamed() || !c0096aC.a_renamed()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("setCameraConf, masterCalibParam valid: ");
            sb.append(c0096aB == null ? null : java.lang.Boolean.valueOf(c0096aB.a_renamed()));
            sb.append(", depthCalibParam valid: ");
            sb.append(c0096aC != null ? java.lang.Boolean.valueOf(c0096aC.a_renamed()) : null);
            com.oplus.camera.e_renamed.f_renamed("AnimojiTexturePreview", sb.toString());
            return false;
        }
        com.arcsoft.arcsoftjni.ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera = new com.arcsoft.arcsoftjni.ArcSoftAvatarEngine.AvatarEngineCamera();
        avatarEngineCamera.iFrameWidth = com.oplus.camera.e_renamed.a_renamed.b_renamed().f4417a;
        avatarEngineCamera.iFrameHeight = com.oplus.camera.e_renamed.a_renamed.b_renamed().f4418b;
        avatarEngineCamera.fCameraFx = com.oplus.camera.e_renamed.a_renamed.b_renamed().f4419c;
        avatarEngineCamera.fCameraFy = com.oplus.camera.e_renamed.a_renamed.b_renamed().d_renamed;
        avatarEngineCamera.fCameraCx = com.oplus.camera.e_renamed.a_renamed.b_renamed().e_renamed;
        avatarEngineCamera.fCameraCy = com.oplus.camera.e_renamed.a_renamed.b_renamed().f_renamed;
        com.arcsoft.arcsoftjni.ArcSoftAvatarEngine.AvatarEngineCamera avatarEngineCamera2 = new com.arcsoft.arcsoftjni.ArcSoftAvatarEngine.AvatarEngineCamera();
        avatarEngineCamera2.iFrameWidth = com.oplus.camera.e_renamed.a_renamed.c_renamed().f4417a;
        avatarEngineCamera2.iFrameHeight = com.oplus.camera.e_renamed.a_renamed.c_renamed().f4418b;
        avatarEngineCamera2.fCameraFx = com.oplus.camera.e_renamed.a_renamed.c_renamed().f4419c;
        avatarEngineCamera2.fCameraFy = com.oplus.camera.e_renamed.a_renamed.c_renamed().d_renamed;
        avatarEngineCamera2.fCameraCx = com.oplus.camera.e_renamed.a_renamed.c_renamed().e_renamed;
        avatarEngineCamera2.fCameraCy = com.oplus.camera.e_renamed.a_renamed.c_renamed().f_renamed;
        long camera = -1;
        com.arcsoft.arcsoftjni.ArcSoftAvatarEngine arcSoftAvatarEngine = this.F_renamed;
        if (arcSoftAvatarEngine != null) {
            camera = arcSoftAvatarEngine.setCamera(avatarEngineCamera, avatarEngineCamera2);
            com.oplus.camera.e_renamed.a_renamed("AnimojiTexturePreview", "setCameraConf, masterCalibParam: " + c0096aB.toString() + ", depthCalibParam: " + c0096aC.toString() + ", result: " + camera);
        }
        return camera == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a_renamed(android.content.Context context, int i_renamed, int i2) throws java.lang.Throwable {
        com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "initAnimojiEngine, start, mbInitialized: " + this.w_renamed + ", width: " + i_renamed + ", height: " + i2);
        long jInitialize = -1;
        if (this.j_renamed == null) {
            return -1L;
        }
        java.lang.String strC = C_renamed();
        a_renamed(this.j_renamed, "/odm/etc/camera/sticker/material/animoji/data.zip", strC, false);
        synchronized (this.k_renamed) {
            if (!this.w_renamed && this.F_renamed == null) {
                com.oplus.camera.e_renamed.a_renamed("Animoji.initAnimojiEngine");
                this.F_renamed = new com.arcsoft.arcsoftjni.ArcSoftAvatarEngine(context);
                jInitialize = this.F_renamed.initialize(strC.concat("/data/track_data.dat"), strC.concat("/data/config.txt"), 1);
                com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "initAnimojiEngine, end, mCurrentTemplatePath: " + this.A_renamed + ", initResult: " + jInitialize);
                this.y_renamed = q_renamed();
                this.w_renamed = true;
                com.oplus.camera.e_renamed.b_renamed("Animoji.initAnimojiEngine");
                com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "initAnimojiEngine, end, initResult: " + jInitialize + ", dataPath: " + strC);
            }
        }
        return jInitialize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r_renamed() {
        com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "unInitAnimojiEngine, mbInitialized: " + this.w_renamed + ", mAvatarEngineRender: " + this.F_renamed);
        if (!this.w_renamed || this.F_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("Animoji.unInitAnimojiEngine");
        this.F_renamed.uninitialize();
        this.F_renamed = null;
        this.G_renamed = null;
        this.q_renamed = false;
        this.E_renamed = false;
        this.H_renamed = null;
        this.w_renamed = false;
        this.y_renamed = false;
        com.oplus.camera.e_renamed.b_renamed("Animoji.unInitAnimojiEngine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A_renamed() {
        com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "releaseAnimojiRender, mbInitialized: " + this.w_renamed + ", mAvatarEngineRender: " + this.F_renamed);
        if (this.w_renamed && this.F_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("Animoji.releaseAnimojiRender");
            this.F_renamed.releaseRender();
            com.arcsoft.arcsoftjni.ArcSoftOffscreen arcSoftOffscreen = this.G_renamed;
            if (arcSoftOffscreen != null) {
                arcSoftOffscreen.setData(null);
            }
            com.arcsoft.arcsoftjni.ArcSoftOffscreen arcSoftOffscreen2 = this.H_renamed;
            if (arcSoftOffscreen2 != null) {
                arcSoftOffscreen2.setData(null);
            }
            com.oplus.camera.e_renamed.b_renamed("Animoji.releaseAnimojiRender");
        }
        com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "releaseAnimojiEngine, end");
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        synchronized (this.k_renamed) {
            com.oplus.camera.util.Util.b_renamed(this.d_renamed);
            com.oplus.camera.util.Util.a_renamed(this.d_renamed);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B_renamed() throws java.lang.Throwable {
        com.oplus.camera.sticker.data.StickerItem stickerItemO = this.v_renamed.o_renamed();
        if (stickerItemO == null) {
            com.oplus.camera.e_renamed.f_renamed("AnimojiTexturePreview", "initTemplateResource, item is_renamed null");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("Animoji.initTemplateResource");
        java.lang.String fileContentUri = stickerItemO.getFileContentUri();
        java.lang.String stickerName = stickerItemO.getStickerName();
        com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo animojiStickerExtendedInfoB = com.oplus.camera.sticker.g_renamed.b_renamed(this.j_renamed, stickerItemO);
        java.lang.String backgroundColor = animojiStickerExtendedInfoB != null ? animojiStickerExtendedInfoB.getBackgroundColor() : "#F5E274";
        java.lang.String str = C_renamed() + java.io.File.separator + stickerName;
        if (this.j_renamed != null) {
            com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.j_renamed);
            boolean zA = a_renamed(com.oplus.camera.ui.preview.a_renamed.q_renamed.a_renamed(this.j_renamed, fileContentUri), str);
            synchronized (this.k_renamed) {
                long template = -1;
                com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "initTemplateResource, stickerName: " + stickerName + ", unZipResult: " + zA);
                boolean z_renamed = true;
                if (zA) {
                    this.A_renamed = a_renamed(stickerName);
                    if (backgroundColor != null) {
                        int color = android.graphics.Color.parseColor(backgroundColor);
                        this.o_renamed[0] = android.graphics.Color.red(color) / 255.0f;
                        this.o_renamed[1] = android.graphics.Color.green(color) / 255.0f;
                        this.o_renamed[2] = android.graphics.Color.blue(color) / 255.0f;
                    }
                    if (this.F_renamed != null) {
                        template = this.F_renamed.setTemplate(this.A_renamed);
                    }
                }
                com.oplus.camera.e_renamed.b_renamed("Animoji.initTemplateResource");
                com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "initTemplateResource, stickerName: " + stickerName + ", unZipResult: " + zA + ", templateResult: " + template);
                if (0 != template) {
                    z_renamed = false;
                }
                this.q_renamed = z_renamed;
            }
        }
    }

    private java.lang.String a_renamed(java.lang.String str) {
        java.io.File[] fileArrListFiles;
        java.io.File file = new java.io.File(C_renamed() + java.io.File.separator + str);
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            return null;
        }
        return fileArrListFiles[0].getPath();
    }

    private java.lang.String C_renamed() {
        if (this.B_renamed == null && this.j_renamed != null) {
            this.B_renamed = this.j_renamed.getExternalCacheDir().getPath() + "/animoji";
        }
        return this.B_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        this.p_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.l_renamed, this.m_renamed, true);
        this.x_renamed = true;
        com.oplus.camera.e_renamed.a_renamed("AnimojiTexturePreview", "newTextures, mOutputAnimojiTexture: " + this.p_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("AnimojiTexturePreview", "recycleTextures, mbTextureInited: " + this.x_renamed + ", mOutputAnimojiTexture: " + this.p_renamed);
        if (this.x_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.p_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.p_renamed = null;
            }
            this.x_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "setSize, width: " + i_renamed + ", height: " + i2 + ", mWidth: " + this.l_renamed + ", mHeight: " + this.m_renamed);
        this.r_renamed = (i_renamed == this.l_renamed && i2 == this.m_renamed) ? false : true;
        this.l_renamed = i_renamed;
        this.m_renamed = i2;
        if (!this.r_renamed || this.h_renamed == null) {
            return;
        }
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.c_renamed.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.c_renamed.this.k_renamed) {
                    com.oplus.camera.ui.preview.a_renamed.c_renamed.this.A_renamed();
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.n_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(android.util.Size size, boolean z_renamed) {
        synchronized (this.k_renamed) {
            this.s_renamed = true;
            this.t_renamed = z_renamed;
            this.u_renamed = size;
            com.oplus.camera.e_renamed.b_renamed("AnimojiTexturePreview", "capture, mOutputOffscreen: " + this.I_renamed + ", mbMirror: " + this.t_renamed);
        }
    }

    private static void a_renamed(java.io.File file, java.lang.String str) throws java.lang.Throwable {
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(file);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            java.lang.String name = zipEntryNextElement.getName();
            if (!name.contains("../")) {
                java.io.InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                java.lang.String strReplaceAll = (str + java.io.File.separator + name).replaceAll("\\*", java.io.File.separator);
                java.io.File file3 = new java.io.File(strReplaceAll);
                java.io.FileOutputStream fileOutputStream = null;
                try {
                    try {
                        java.io.File file4 = new java.io.File(strReplaceAll.substring(0, strReplaceAll.lastIndexOf(java.io.File.separator)));
                        if (!file4.exists()) {
                            file4.mkdirs();
                        }
                        if (!file3.isDirectory()) {
                            if (file3.getName().toLowerCase().endsWith(".zip")) {
                                arrayList.add(file3.getPath());
                            }
                            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file3);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i_renamed = inputStream.read(bArr);
                                    if (i_renamed <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, i_renamed);
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                fileOutputStream2.close();
                            } catch (java.lang.Exception e_renamed) {
                                fileOutputStream = fileOutputStream2;
                                e_renamed = e_renamed;
                                e_renamed.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } else if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (java.lang.Exception e2) {
                        e_renamed = e2;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        }
        zipFile.close();
        if (arrayList.size() > 0) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                java.io.File file5 = new java.io.File((java.lang.String) it.next());
                a_renamed(file5, file5.getParentFile().getPath());
                file5.delete();
            }
        }
    }

    private boolean a_renamed(byte[] bArr, java.lang.String str) throws java.lang.Throwable {
        boolean z_renamed = false;
        if (bArr == null || str == null) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if (!new java.io.File(str).exists()) {
                        java.lang.String strConcat = str.concat(".zip");
                        java.io.File file = new java.io.File(strConcat);
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            a_renamed(file, strConcat.substring(0, strConcat.lastIndexOf(".zip")));
                            file.delete();
                            fileOutputStream = fileOutputStream2;
                        } catch (java.lang.Exception e_renamed) {
                            e_renamed = e_renamed;
                            fileOutputStream = fileOutputStream2;
                            e_renamed.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            return z_renamed;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    z_renamed = true;
                } catch (java.lang.Exception e3) {
                    e_renamed = e3;
                }
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
        return z_renamed;
    }

    private boolean a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z_renamed) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.lang.String str3;
        java.io.File file;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            if (!new java.io.File(str2).exists() || z_renamed) {
                java.io.File file2 = new java.io.File(str2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    try {
                        java.lang.String[] strArrSplit = str.split(java.io.File.separator);
                        str3 = str2 + java.io.File.separator + strArrSplit[strArrSplit.length - 1];
                        file = new java.io.File(str3);
                        fileOutputStream = new java.io.FileOutputStream(file);
                    } catch (java.lang.Exception e_renamed) {
                        e_renamed = e_renamed;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i_renamed = fileInputStream.read(bArr);
                        if (i_renamed == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i_renamed);
                    }
                    a_renamed(file, str3.substring(0, str3.lastIndexOf(".zip")));
                    file.delete();
                    fileOutputStream2 = fileOutputStream;
                } catch (java.lang.Exception e2) {
                    e_renamed = e2;
                    fileOutputStream2 = fileOutputStream;
                    e_renamed.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (java.lang.Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } else {
                fileInputStream = null;
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (java.lang.Exception e5) {
                    e5.printStackTrace();
                    return true;
                }
            }
            if (fileInputStream == null) {
                return true;
            }
            fileInputStream.close();
            return true;
        } catch (java.lang.Exception e6) {
            e_renamed = e6;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
