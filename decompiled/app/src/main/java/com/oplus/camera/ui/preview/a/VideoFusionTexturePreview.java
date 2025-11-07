package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: VideoFusionTexturePreview.java */
/* loaded from: classes2.dex */
public class ad_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed implements com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f6848a = new java.lang.Object();
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed A_renamed;
    private com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanEffectFusionConfig B_renamed;
    private com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams C_renamed;
    private byte[] D_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6849b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6850c;
    private int d_renamed;
    private int k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private int[] u_renamed;
    private int[] v_renamed;
    private int[] w_renamed;
    private com.oplus.camera.gl_renamed.s_renamed x_renamed;
    private com.oplus.camera.gl_renamed.s_renamed y_renamed;
    private com.oplus.ocs.camera.HumanEffectFusionApiHelper z_renamed;

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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.a_renamed.ad_renamed.a_renamed(int, boolean):int");
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
        return 32;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    public ad_renamed(android.content.Context context) {
        super(context);
        this.f6849b = 0;
        this.f6850c = 0;
        this.d_renamed = 0;
        this.k_renamed = -1;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = true;
        this.q_renamed = false;
        this.r_renamed = false;
        this.s_renamed = false;
        this.t_renamed = false;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = new int[11];
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = null;
        this.D_renamed = null;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        if (!a__renamed(i_renamed)) {
            return false;
        }
        synchronized (f6848a) {
            if (this.A_renamed != null && (this.o_renamed || this.A_renamed.b_renamed())) {
                if (this.l_renamed) {
                    return true;
                }
                com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "canProcess, texture is_renamed not init");
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        int i_renamed;
        int i2;
        int i3;
        int i4;
        int iA;
        boolean z_renamed;
        com.oplus.ocs.camera.HumanEffectFusionApiHelper.FeatureType featureType;
        com.oplus.ocs.camera.HumanEffectFusionApiHelper.FeatureType featureType2;
        synchronized (f6848a) {
            if (this.A_renamed != null && aVar != null && aVar.f6977c != null && this.x_renamed != null) {
                com.oplus.camera.gl_renamed.s_renamed sVar = aVar.f6977c;
                synchronized (f6848a) {
                    if (this.z_renamed == null) {
                        c_renamed(this.g_renamed);
                    }
                    if (this.m_renamed && this.z_renamed != null) {
                        com.oplus.ocs.camera.HumanEffectFusionApiHelper humanEffectFusionApiHelper = this.z_renamed;
                        if (this.o_renamed) {
                            featureType2 = com.oplus.ocs.camera.HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_NEON;
                        } else {
                            featureType2 = com.oplus.ocs.camera.HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_BOKEH;
                        }
                        humanEffectFusionApiHelper.setFeatureType(featureType2);
                        A_renamed();
                        this.m_renamed = false;
                        this.q_renamed = false;
                        this.r_renamed = false;
                    }
                    if (this.p_renamed && this.z_renamed != null) {
                        com.oplus.ocs.camera.HumanEffectFusionApiHelper humanEffectFusionApiHelper2 = this.z_renamed;
                        if (this.o_renamed) {
                            featureType = com.oplus.ocs.camera.HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_NEON;
                        } else {
                            featureType = com.oplus.ocs.camera.HumanEffectFusionApiHelper.FeatureType.ANC_HUM_FEATURE_BOKEH;
                        }
                        humanEffectFusionApiHelper2.setFeatureType(featureType);
                        A_renamed();
                        this.p_renamed = false;
                        this.q_renamed = false;
                        this.r_renamed = false;
                    }
                    if (this.q_renamed) {
                        a_renamed(this.u_renamed[0] / 100.0f, this.u_renamed[1] / 100.0f, this.u_renamed[2] / 100.0f, this.u_renamed[3] / 100.0f, this.u_renamed[4] / 100.0f, this.u_renamed[5] / 100.0f, this.u_renamed[6] / 100.0f, this.u_renamed[7] / 100.0f, this.u_renamed[8] / 100.0f, this.u_renamed[9] / 100.0f, this.u_renamed[10] / 100.0f);
                        this.q_renamed = false;
                    }
                    if (this.r_renamed) {
                        i_renamed = 1;
                        i2 = 3;
                        i3 = 4;
                        i4 = 5;
                        a_renamed(this.v_renamed[0] / 100.0f, this.v_renamed[1] / 100.0f, this.v_renamed[2] / 100.0f, this.v_renamed[3] / 100.0f, this.v_renamed[4] / 100.0f, this.v_renamed[5] / 100.0f, this.v_renamed[6] / 100.0f);
                        this.r_renamed = false;
                    } else {
                        i_renamed = 1;
                        i2 = 3;
                        i3 = 4;
                        i4 = 5;
                    }
                    int iA2 = a_renamed(this.d_renamed, this.g_renamed);
                    int iE = sVar.e_renamed();
                    int[] iArr = new int[i_renamed];
                    iArr[0] = this.x_renamed.e_renamed();
                    iA = a_renamed(iE, iArr, iA2);
                    z_renamed = i_renamed;
                    z_renamed = i_renamed;
                    z_renamed = i_renamed;
                    z_renamed = i_renamed;
                }
                if (iA != 0 && i2 != iA && i3 != iA && i4 != iA) {
                    z_renamed = i_renamed;
                    if (6 != iA) {
                        z_renamed = 0;
                    }
                }
                this.n_renamed = z_renamed;
                return this.n_renamed;
            }
            com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "process, false");
            return false;
        }
    }

    private void a_renamed(float f_renamed, float f2, float f3, float f4, float f5) {
        if (this.s_renamed) {
            this.C_renamed.UpdateBlurIntensity(0.0f);
            this.z_renamed.setParams(this.C_renamed);
            com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "setVideoNeonParams, set blurIntensity zero when rear orientation invalid.");
            return;
        }
        if (this.t_renamed) {
            f_renamed = ((int) ((f_renamed * 1.3f) * 100.0f)) / 100.0f;
        }
        this.C_renamed.UpdateBlurIntensity(f_renamed);
        this.C_renamed.UpdateSaturation(f2);
        this.C_renamed.UpdateFaculaDensity(f3);
        this.C_renamed.UpdateLightFactor(f4);
        this.C_renamed.UpdateSmoothAmount(f5);
        this.z_renamed.setParams(this.C_renamed);
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "setVideoNeonParams, intensity: " + f_renamed + ", saturation: " + f2 + ", faculaDensity: " + f3 + ", lightFactor: " + f4 + ", smoothAmount: " + f5);
    }

    private void a_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        if (this.s_renamed) {
            this.C_renamed.UpdateBlurIntensity(0.0f);
            this.z_renamed.setParams(this.C_renamed);
            com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "setVideoNeonParams, set blurIntensity zero when rear orientation invalid.");
            return;
        }
        if (this.t_renamed) {
            f_renamed = ((int) ((f_renamed * 1.3f) * 100.0f)) / 100.0f;
        }
        this.C_renamed.UpdateBlurIntensity(f_renamed);
        this.C_renamed.UpdateSaturation(f2);
        this.C_renamed.UpdateFaculaDensity(f3);
        this.C_renamed.UpdateLightFactor(f4);
        this.C_renamed.UpdateSmoothAmount(f5);
        this.C_renamed.UpdateBokehMaxRadiusFactor(f6);
        this.C_renamed.UpdateColorValue(f7, f8, f9, f10);
        this.C_renamed.UpdateBgLightFactor(f11);
        this.z_renamed.setParams(this.C_renamed);
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "setVideoNeonParams, intensity: " + f_renamed + ", saturation: " + f2 + ", faculaDensity: " + f3 + ", lightFactor: " + f4 + ", smoothAmount: " + f5 + ", bokehMaxRadiusFactor: " + f6 + ", red: " + f7 + ", green: " + f8 + ", blue: " + f9 + ", yellow: " + f10 + ", bGlightFactor: " + f11);
    }

    private void a_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.C_renamed.UpdateSaturation(f_renamed);
        this.C_renamed.UpdateLightFactor(f6);
        this.C_renamed.UpdateColorValue(f2, f3, f4, f5);
        this.C_renamed.UpdateBgLightFactor(f7);
        this.z_renamed.setParams(this.C_renamed);
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "setVideoBlurParams, saturation: " + f_renamed + ", lightFactor: " + f6 + ", red: " + f2 + ", green: " + f3 + ", blue: " + f4 + ", yellow: " + f5 + ", bGlightFactor: " + f7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A_renamed() {
        boolean z_renamed = true;
        if (this.o_renamed) {
            if (this.u_renamed != null) {
                a_renamed(r0[0] / 100.0f, r0[1] / 100.0f, r0[2] / 100.0f, r0[3] / 100.0f, r0[4] / 100.0f, r0[5] / 100.0f, r0[6] / 100.0f, r0[7] / 100.0f, r0[8] / 100.0f, r0[9] / 100.0f, r0[10] / 100.0f);
                return;
            }
            int[] configIntArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(this.g_renamed ? com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_APP_FRONT_PARAMS : com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_APP_REAR_PARAMS);
            if (configIntArrayValue != null) {
                if (11 == configIntArrayValue.length) {
                    a_renamed(configIntArrayValue[0] / 100.0f, configIntArrayValue[1] / 100.0f, configIntArrayValue[2] / 100.0f, configIntArrayValue[3] / 100.0f, configIntArrayValue[4] / 100.0f, configIntArrayValue[5] / 100.0f, configIntArrayValue[6] / 100.0f, configIntArrayValue[7] / 100.0f, configIntArrayValue[8] / 100.0f, configIntArrayValue[9] / 100.0f, configIntArrayValue[10] / 100.0f);
                    return;
                } else {
                    a_renamed(configIntArrayValue[0] / 100.0f, configIntArrayValue[1] / 100.0f, configIntArrayValue[2] / 100.0f, configIntArrayValue[3] / 100.0f, configIntArrayValue[4] / 100.0f);
                    return;
                }
            }
            return;
        }
        float fG_renamed = this.A_renamed.g_renamed();
        this.C_renamed.UpdateBlurIntensity(fG_renamed);
        if (this.v_renamed != null) {
            a_renamed(r0[0] / 100.0f, r0[1] / 100.0f, r0[2] / 100.0f, r0[3] / 100.0f, r0[4] / 100.0f, r0[5] / 100.0f, r0[6] / 100.0f);
        } else {
            int[] configIntArrayValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(this.g_renamed ? com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_APP_FRONT_PARAMS : com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_APP_REAR_PARAMS);
            if (configIntArrayValue2 == null || 11 != configIntArrayValue2.length) {
                z_renamed = false;
            } else {
                a_renamed(configIntArrayValue2[0] / 100.0f, configIntArrayValue2[7] / 100.0f, configIntArrayValue2[8] / 100.0f, configIntArrayValue2[9] / 100.0f, configIntArrayValue2[10] / 100.0f, configIntArrayValue2[5] / 100.0f, configIntArrayValue2[6] / 100.0f);
            }
        }
        if (!z_renamed) {
            this.z_renamed.setParams(this.C_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "initVideoFusionParams, currBlurIntensity: " + fG_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean y_renamed() {
        if (this.o_renamed && this.s_renamed) {
            return false;
        }
        return this.n_renamed;
    }

    public int[] q_renamed() {
        int[] iArr = this.u_renamed;
        if (iArr == null) {
            boolean z_renamed = this.t_renamed;
            java.lang.String str = com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_APP_FRONT_PARAMS;
            if (z_renamed) {
                if (!this.g_renamed) {
                    str = com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_APP_REAR_PARAMS;
                }
                int[] configIntArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(str);
                if (configIntArrayValue != null) {
                    int[] iArr2 = this.w_renamed;
                    iArr2[0] = (int) (configIntArrayValue[0] * 1.3f);
                    iArr2[1] = configIntArrayValue[1];
                    iArr2[2] = configIntArrayValue[2];
                    iArr2[3] = configIntArrayValue[3];
                    iArr2[4] = configIntArrayValue[4];
                    if (11 == configIntArrayValue.length) {
                        iArr2[5] = configIntArrayValue[5];
                        iArr2[6] = configIntArrayValue[6];
                        iArr2[7] = configIntArrayValue[7];
                        iArr2[8] = configIntArrayValue[8];
                        iArr2[9] = configIntArrayValue[9];
                        iArr2[10] = configIntArrayValue[10];
                    }
                }
                return this.w_renamed;
            }
            if (!this.g_renamed) {
                str = com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_APP_REAR_PARAMS;
            }
            return com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(str);
        }
        if (!this.t_renamed) {
            return iArr;
        }
        int[] iArr3 = this.w_renamed;
        iArr3[0] = (int) (iArr[0] * 1.3f);
        iArr3[1] = iArr[1];
        iArr3[2] = iArr[2];
        iArr3[3] = iArr[3];
        iArr3[4] = iArr[4];
        iArr3[5] = iArr[5];
        iArr3[6] = iArr[6];
        iArr3[7] = iArr[7];
        iArr3[8] = iArr[8];
        iArr3[9] = iArr[9];
        iArr3[10] = iArr[10];
        return iArr3;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int[] z_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "getVideoBlurParams");
        int[] iArr = this.v_renamed;
        if (iArr == null) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(this.g_renamed ? com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_APP_FRONT_PARAMS : com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_APP_REAR_PARAMS);
        }
        return iArr;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("VideoFusionTexturePreview", "onDestroy");
        e_renamed();
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(final com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "createEngine");
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ad_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.ad_renamed.f6848a) {
                    com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.A_renamed = aaVar;
                    if (com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.A_renamed != null) {
                        com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.A_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.ad_renamed.this);
                    }
                    com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "createEngine X_renamed");
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
        com.oplus.camera.e_renamed.b_renamed("VideoFusionTexturePreview", "destroyEngine, mHumanEffectFusionApi: " + this.z_renamed);
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ad_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.ad_renamed.f6848a) {
                    if (com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.z_renamed != null) {
                        com.oplus.camera.e_renamed.b_renamed("VideoFusionTexturePreview", "destroyEngine, mHumanEffectFusionApi release");
                        com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.h_renamed.g_renamed();
                        com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.z_renamed.release();
                        com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.z_renamed = null;
                        com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.C_renamed = null;
                    }
                    com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.A_renamed = null;
                    com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "destroyEngine X_renamed");
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.y_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.x_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "newTextures");
        this.y_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6849b, this.f6850c, true);
        this.x_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.f6849b, this.f6850c, true);
        this.l_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        com.oplus.camera.gl_renamed.s_renamed sVar = this.y_renamed;
        if (sVar != null && !sVar.n_renamed()) {
            this.y_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "prepareTextures, mInputTexture.getId: " + this.y_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.x_renamed;
        if (sVar2 == null || sVar2.n_renamed()) {
            return;
        }
        this.x_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.x_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "recycleTextures");
        if (this.l_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.y_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.y_renamed = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar2 = this.x_renamed;
            if (sVar2 != null) {
                sVar2.o_renamed();
                this.x_renamed = null;
            }
            this.l_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.f6849b = i2;
        this.f6850c = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(boolean z_renamed) {
        synchronized (f6848a) {
            this.m_renamed = z_renamed;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
        if (90 == i_renamed || (270 == i_renamed && !this.t_renamed)) {
            this.t_renamed = true;
            B_renamed();
        } else if (this.t_renamed) {
            this.t_renamed = false;
            B_renamed();
        }
    }

    private void B_renamed() {
        if (this.o_renamed) {
            this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ad_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (com.oplus.camera.ui.preview.a_renamed.ad_renamed.f6848a) {
                        if (com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.A_renamed != null && com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.z_renamed != null) {
                            com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.A_renamed();
                        }
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void d_renamed(int i_renamed) {
        this.k_renamed = i_renamed;
        if (!this.s_renamed && -1 == i_renamed) {
            this.s_renamed = true;
            B_renamed();
        } else {
            if (!this.s_renamed || -1 == i_renamed) {
                return;
            }
            this.s_renamed = false;
            B_renamed();
        }
    }

    private void c_renamed(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        android.opengl.GLES20.glFinish();
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "initFusionEffect, isFrontCamera: " + z_renamed);
        if (this.B_renamed == null) {
            this.B_renamed = C_renamed();
        }
        this.B_renamed.isBackCamera = !z_renamed;
        this.z_renamed = com.oplus.ocs.camera.HumanEffectFusionApiHelper.getPreviewInstance();
        this.z_renamed.preInit();
        this.C_renamed = new com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanVideoFusionParams();
        this.z_renamed.setLogLevel(com.oplus.camera.e_renamed.a_renamed() ? 4 : 0);
        int iInitByConfig = this.z_renamed.initByConfig(this.B_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "initFusionEffect end, res: " + iInitByConfig + ", sdk version: " + this.z_renamed.getVersion());
    }

    private int a_renamed(int i_renamed, int[] iArr, int i2) {
        if (iArr == null) {
            return -1;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        int iB = b_renamed(i_renamed, iArr, i2);
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "processVideoFusion, res: " + iB + ", costTime: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        return iB;
    }

    private com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanEffectFusionConfig C_renamed() {
        java.lang.String str = this.j_renamed.getApplicationContext().getCacheDir() + java.io.File.separator + "anc_cache";
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanEffectFusionConfig humanEffectFusionConfig = new com.oplus.ocs.camera.HumanEffectFusionApiHelper.HumanEffectFusionConfig();
        humanEffectFusionConfig.isRealTime = true;
        if (this.D_renamed == null) {
            this.D_renamed = com.oplus.camera.a_renamed.c_renamed.a_renamed("megvii/fusion_model");
        }
        humanEffectFusionConfig.model_data = this.D_renamed;
        humanEffectFusionConfig.cache_path = str;
        humanEffectFusionConfig.native_lib_path = "/odm/lib64;/odm/lib/rfsa/adsp";
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_FUSION_APP_LOAD_SO_TYPE);
        if (configIntValue == 0) {
            humanEffectFusionConfig.sdkLoadType = com.oplus.ocs.camera.HumanEffectFusionApiHelper.SdkLoadType.ANC_LOAD_TYPE_DLOEPN.getValue();
        } else if (configIntValue == 1) {
            humanEffectFusionConfig.sdkLoadType = com.oplus.ocs.camera.HumanEffectFusionApiHelper.SdkLoadType.ANC_LOAD_TYPE_ANDROID_DLOPEN.getValue();
        }
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "getFusionConfig, loadType: " + configIntValue);
        return humanEffectFusionConfig;
    }

    private int b_renamed(int i_renamed, int[] iArr, int i2) {
        return this.z_renamed.process(i_renamed, iArr, this.f6849b, this.f6850c, i2, this.g_renamed);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed
    public void b_renamed(boolean z_renamed) {
        synchronized (f6848a) {
            if (this.o_renamed != z_renamed) {
                com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "onVideoNeonOpenChanged, isOpen: " + z_renamed);
                this.o_renamed = z_renamed;
                this.p_renamed = true;
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed
    public void a_renamed(final float f_renamed) {
        this.h_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.a_renamed.ad_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.a_renamed.ad_renamed.f6848a) {
                    if (!com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.o_renamed && com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.z_renamed != null) {
                        com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.C_renamed.UpdateBlurIntensity(f_renamed);
                        com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.z_renamed.setParams(com.oplus.camera.ui.preview.a_renamed.ad_renamed.this.C_renamed);
                        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "onVideoBlurLevelChange, blurLevel: " + f_renamed);
                    }
                }
            }
        });
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed
    public void a_renamed(int[] iArr) {
        if (this.o_renamed && 11 == iArr.length) {
            if (this.u_renamed != null) {
                boolean z_renamed = false;
                int i_renamed = 0;
                while (true) {
                    int[] iArr2 = this.u_renamed;
                    if (i_renamed >= iArr2.length) {
                        break;
                    }
                    if (iArr2[i_renamed] != iArr[i_renamed]) {
                        z_renamed = true;
                        break;
                    }
                    i_renamed++;
                }
                if (!z_renamed) {
                    return;
                }
            }
            synchronized (f6848a) {
                this.u_renamed = iArr;
                this.q_renamed = true;
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.aa_renamed.e_renamed
    public void b_renamed(int[] iArr) {
        com.oplus.camera.e_renamed.a_renamed("VideoFusionTexturePreview", "onVideoBlurTuningParamsChange, received params");
        if (this.o_renamed || 7 != iArr.length) {
            return;
        }
        if (this.v_renamed != null) {
            boolean z_renamed = false;
            int i_renamed = 0;
            while (true) {
                int[] iArr2 = this.v_renamed;
                if (i_renamed >= iArr2.length) {
                    break;
                }
                if (iArr2[i_renamed] != iArr[i_renamed]) {
                    z_renamed = true;
                    break;
                }
                i_renamed++;
            }
            if (!z_renamed) {
                return;
            }
        }
        synchronized (f6848a) {
            this.v_renamed = iArr;
            this.r_renamed = true;
        }
    }
}
