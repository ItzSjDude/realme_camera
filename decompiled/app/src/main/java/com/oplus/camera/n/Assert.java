package com.oplus.camera.n_renamed;

/* compiled from: PortraitCapMode.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.camera.capmode.BaseMode {
    private boolean g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private int m_renamed;
    private float n_renamed;
    private int o_renamed;
    private int p_renamed;
    private java.lang.String q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private android.os.Handler t_renamed;

    private java.lang.String h_renamed() {
        return "default";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getBlurMenuKeyByMode() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return "portrait";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getExpectedFrameRate() {
        return 24;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return com.oplus.camera.R_renamed.string.camera_fuji_style;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetMonoFilter() {
    }

    public a_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = false;
        this.h_renamed = true;
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = -1;
        this.n_renamed = -1.0f;
        this.o_renamed = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        this.p_renamed = 0;
        this.q_renamed = "";
        this.r_renamed = false;
        this.s_renamed = false;
        this.t_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.n_renamed.a_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 1 && com.oplus.camera.n_renamed.a_renamed.this.i_renamed) {
                    com.oplus.camera.n_renamed.a_renamed.this.h_renamed = true;
                    com.oplus.camera.n_renamed.a_renamed aVar2 = com.oplus.camera.n_renamed.a_renamed.this;
                    aVar2.a_renamed(aVar2.m_renamed, false);
                }
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getEnvironmentTipsThreshold() {
        if (this.mbFrontCamera) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD);
        }
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        if ((this.mCameraInterface == null || !this.mCameraInterface.i_renamed()) && !isNeonEnable() && (com.oplus.camera.util.Util.C_renamed() || !isStreamerEnable())) {
            return 1;
        }
        return super.getDefaultCaptureNumber();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getPreviewStreamNum() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA)) {
            return e_renamed() ? 1 : 2;
        }
        return super.getPreviewStreamNum();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureStreamNum() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA)) {
            return 2;
        }
        return super.getCaptureStreamNum();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterNoneIndex() {
        return this.mbFrontCamera ? com.oplus.camera.ui.preview.a_renamed.j_renamed.q_renamed() : com.oplus.camera.ui.preview.a_renamed.j_renamed.p_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        super.setOrientation(i_renamed);
        co_renamed.polarr.renderer.PolarrRender.updateGlobalScreenOrientation(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBackPortraitCameraSwitching() {
        return this.j_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() {
        com.oplus.camera.ui.preview.a_renamed.j_renamed.c_renamed();
        c_renamed();
        i_renamed();
    }

    private void c_renamed() {
        if (this.mPreferences instanceof com.oplus.camera.ComboPreferences) {
            if (com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed.d_renamed.size() == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed.f6904c.size() && -1 == com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed() && -1 == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT) == com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_STREAMER_SUPPORT)) {
                ((com.oplus.camera.ComboPreferences) this.mPreferences).c_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX);
            } else {
                ((com.oplus.camera.ComboPreferences) this.mPreferences).d_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA) ? (f_renamed() || g_renamed()) ? 32784 : 32785 : com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_OPERATING) ? 32806 : 32769;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onInitCameraMode");
        this.r_renamed = false;
        this.s_renamed = false;
        this.q_renamed = "";
        if (!com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
            this.mCameraUIInterface.a_renamed(false, true, true);
        }
        this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_common_shutter_button));
        this.i_renamed = getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA);
        this.k_renamed = b_renamed();
        com.oplus.camera.ui.preview.a_renamed.j_renamed.c_renamed();
        c_renamed();
        i_renamed();
        co_renamed.polarr.renderer.PolarrRender.updateGlobalScreenOrientation(this.mOrientation);
        if (this.k_renamed) {
            a_renamed("on_renamed");
        } else {
            a_renamed("off");
        }
        d_renamed();
    }

    private void d_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.a_renamed(new com.oplus.camera.ui.a_renamed.a_renamed.b_renamed() { // from class: com.oplus.camera.n_renamed.a_renamed.2
                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar) {
                    if (com.oplus.camera.R_renamed.string.camera_toast_unfold_palm_shutter == bVar.f5839a) {
                        com.oplus.camera.n_renamed.a_renamed.this.l_renamed = true;
                    }
                }

                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(int i_renamed) {
                    if (com.oplus.camera.R_renamed.string.camera_toast_unfold_palm_shutter == i_renamed) {
                        com.oplus.camera.n_renamed.a_renamed.this.l_renamed = false;
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onDeInitCameraMode");
        boolean z_renamed = false;
        this.s_renamed = false;
        updateFaceBeautyLevel(0, false);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_half_body_better);
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.g_renamed(0);
        }
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.mCameraInterface != null && !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            this.mCameraInterface.U_renamed();
            if (this.k_renamed) {
                a_renamed("on_renamed");
            } else {
                a_renamed("off");
            }
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(true, false, true);
        }
        this.n_renamed = -1.0f;
        if (2 == this.p_renamed && d_renamed(this.o_renamed)) {
            z_renamed = true;
        }
        b_renamed(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onMenuOptionAdded, key: " + str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(str) && this.mCameraUIInterface.ad_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, true, (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterRedpotKey(java.lang.String str) {
        if ("neon-2020.cube.rgb.bin".equals(str) && androidx.preference.j_renamed.a_renamed(this.mActivity).getBoolean("portrait_filter_neon_new", true)) {
            return "portrait_filter_neon_new";
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        if (this.mCameraUIInterface.ad_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, false, (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_y));
            androidx.preference.j_renamed.a_renamed(this.mActivity).edit().putBoolean("portrait_filter_reddot_show", false).apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onResume");
        this.h_renamed = getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA);
        co_renamed.polarr.renderer.PolarrRender.updateGlobalScreenOrientation(this.mOrientation);
        i_renamed();
        if (this.mCameraEntry.c_renamed() || this.mCameraEntry.T_renamed()) {
            if (this.k_renamed) {
                a_renamed("on_renamed");
            } else {
                a_renamed("off");
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SINGLE_CAMERA_USE_COMMOM_PORTRAIT_PREVIEW_SIZE)) {
            return super.getPreviewSize(hVar);
        }
        if (this.mbFrontCamera) {
            return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_PORTRAIT_PREVIEW_SIZE);
        }
        return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_REAR_PORTRAIT_PREVIEW_SIZE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, java.lang.String str) {
        double dX_renamed;
        if ("type_sub_preview_frame".equals(str) && !com.oplus.camera.util.Util.C_renamed()) {
            java.util.List<android.util.Size> listA = hVar.a_renamed(538982489);
            java.lang.String strA = com.oplus.camera.util.Util.a_renamed(getPictureSize(hVar), this.mCameraId);
            if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(strA)) {
                dX_renamed = com.oplus.camera.util.Util.X_renamed();
            } else if ("16_9".equals(strA)) {
                dX_renamed = 1.7777777777777777d;
            } else {
                dX_renamed = "square".equals(strA) ? 1.0d : 1.3333333333333333d;
            }
            com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "getPreviewSize, depth size list: " + listA);
            return com.oplus.camera.util.Util.a_renamed(listA, dX_renamed, 538982489);
        }
        return super.getPreviewSize(hVar, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA)) {
            java.util.List<android.util.Size> listA = hVar.a_renamed(256);
            android.util.Size sizeB = null;
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_FRONT_MAX_SIZE_SUPPORT)) {
                sizeB = com.oplus.camera.util.Util.b_renamed(listA, 1.3333333333333333d);
            } else {
                android.util.Size sizeA = com.oplus.camera.util.Util.a_renamed(listA, com.oplus.camera.capmode.BaseMode.PICTURE_SIZE_8M, 0);
                if (sizeA != null) {
                    sizeB = sizeA;
                }
            }
            if (sizeB != null) {
                com.oplus.camera.e_renamed.b_renamed("PortraitCapMode", "getPictureSize, width: " + sizeB.getWidth() + ", height: " + sizeB.getHeight());
                return sizeB;
            }
        }
        if (this.mbFrontCamera) {
            android.util.Size sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_PORTRAIT_NORMAL_MODE_PIC_SIZE);
            if (sizeConfigValue != null) {
                com.oplus.camera.e_renamed.b_renamed("PortraitCapMode", "getPictureSize, front size: " + sizeConfigValue.getWidth() + "x_renamed" + sizeConfigValue.getHeight());
            }
            return sizeConfigValue;
        }
        android.util.Size surfaceSize = getSurfaceSize("type_still_capture_yuv_main", hVar);
        if (surfaceSize != null) {
            com.oplus.camera.e_renamed.b_renamed("PortraitCapMode", "getPictureSize, use surfaceSize, rear size: " + surfaceSize.getWidth() + "x_renamed" + surfaceSize.getHeight());
            return surfaceSize;
        }
        android.util.Size sizeConfigValue2 = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_BACK_PORTRAIT_NORMAL_MODE_PIC_SIZE);
        if (sizeConfigValue2 != null) {
            com.oplus.camera.e_renamed.b_renamed("PortraitCapMode", "getPictureSize, rear size: " + sizeConfigValue2.getWidth() + "x_renamed" + sizeConfigValue2.getHeight());
        }
        return sizeConfigValue2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected float getBlurValue() {
        return getBlurValue(e_renamed(getCurrFilterIndex()) ? 100 : getBlurIndex());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isBlurOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.BOKEH) || getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStreamerOpen() {
        return a_renamed(getCurrFilterIndex());
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:113:0x01b2  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 1422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.n_renamed.a_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFilterOpen(java.lang.String str) {
        return ("portrait_retention".equals(str) || "portrait_streamer".equals(str) || (this.mbFrontCamera && "neon-2020.cube.rgb.bin".equals(str)) || !super.isFilterOpen(str)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        com.oplus.camera.e_renamed.f_renamed("PortraitCapMode", "onStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.util.List<java.lang.String> onGetSupportSettingList(java.lang.String str, int i_renamed) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            java.util.List<java.lang.String> supportedList = com.oplus.camera.aps.config.CameraConfig.getSupportedList(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, i_renamed);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (supportedList != null && supportedList.contains("standard")) {
                arrayList.add("standard");
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return super.onGetSupportSettingList(str, i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (((this.mCameraInterface == null || !this.mCameraInterface.i_renamed()) && !com.oplus.camera.util.Util.C_renamed()) || !((30 == this.mApsDecisionFeatureType || 34 == this.mApsDecisionFeatureType) && com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SINGLE_PORTRAIT))) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD)) {
            return getSupportFunction(strD);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU.equals(strD)) {
            return (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.BOKEH) || getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR)) && !d_renamed(getCurrFilterIndex()) && !e_renamed(getCurrFilterIndex()) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_BLUR_LEVEL_ENABLE);
        }
        return super.getSupportMenu(strD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed("PortraitCapMode", "onCameraIdChanged");
        b_renamed(2 == this.p_renamed && this.mbFrontCamera && isMonoIndex(this.o_renamed));
        i_renamed();
        this.q_renamed = "";
        super.cameraIdChanged(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onPause");
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        boolean z_renamed = false;
        if (this.mCameraUIInterface != null && this.mCameraInterface.i_renamed()) {
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), false);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.U_renamed();
        }
        this.q_renamed = "";
        this.r_renamed = false;
        this.h_renamed = false;
        this.j_renamed = false;
        this.s_renamed = false;
        this.mCameraEntry.y_renamed();
        if (2 == this.p_renamed && d_renamed(this.o_renamed)) {
            z_renamed = true;
        }
        b_renamed(z_renamed);
        if (this.mCameraInterface == null || this.mCameraInterface.at_renamed() || !this.mCameraEntry.c_renamed()) {
            return;
        }
        if (this.k_renamed) {
            a_renamed("on_renamed");
        } else {
            a_renamed("off");
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onDestroy");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        if (com.oplus.camera.util.Util.ao_renamed()) {
            if (this.mCameraUIInterface.s_renamed() == 28 || this.mCameraUIInterface.s_renamed() == 29) {
                shutterButtonInfo.a_renamed(26);
            } else {
                shutterButtonInfo.a_renamed(23);
            }
        }
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onBeforePreview");
        if (this.mCameraUIInterface != null && !"portrait_streamer".equals(this.q_renamed)) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_half_body_better);
        }
        updateRearAicolorEnable(false, f_renamed(getCurrFilterIndex()));
        this.r_renamed = false;
        if (this.j_renamed) {
            this.j_renamed = false;
            a_renamed(getFilterType(this.o_renamed), false);
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
            int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
            com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onBeforePreview, level: " + faceBeautyCurrIndex);
            updateFaceBeautyLevel(faceBeautyCurrIndex, false);
            updateCustomBeautyValues(getCustomBeautyValues());
            if (this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.g_renamed(faceBeautyCurrIndex);
                this.mPreviewEffectProcess.a_renamed(getCustomBeautyValues());
                return;
            }
            return;
        }
        updateFaceBeautyLevel(0, false);
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.g_renamed(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return getCurrentKeys(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_CUSTOM_BEAUTY);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getMakeupKeys() {
        return getCurrentKeys(com.oplus.camera.ui.preview.a_renamed.g_renamed.d_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getMakeupTypeKey() {
        return com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType) ? com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_MAKEUP_TYPE, this.mCameraEntryType) : com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_MAKEUP_TYPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getMakeupOpenState() {
        if (com.oplus.camera.util.Util.C_renamed()) {
            return super.getMakeupOpenState();
        }
        return 3;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getSupportShowCustomAll() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MAKEUP_LOW_PERFORMANCE) && this.mCameraInterface.i_renamed()) {
            return false;
        }
        return super.getSupportShowCustomAll();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isFaceBeautyOrMakeupOpen() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_BOKEH_BEAUTY_SUPPORT) || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA)) {
            return super.isFaceBeautyOrMakeupOpen();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getDefaultCommonBeautyValue() {
        if (isFaceBeautyDefaultOff()) {
            return 0;
        }
        return (this.mbFrontCamera || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_BOKEH_BEAUTY_OPEN_DEFAULT)) ? 40 : 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onBeforeSnapping");
        if (!this.mCameraInterface.i_renamed() && this.mCameraUIInterface.s_renamed() == 1) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.n_renamed.a_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.n_renamed.a_renamed.this.mbPaused) {
                        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onBeforeSnapping, return after pause");
                        return;
                    }
                    com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                    bVar.a_renamed("button_color_inside_none");
                    bVar.a_renamed(4);
                    com.oplus.camera.n_renamed.a_renamed.this.mCameraUIInterface.a_renamed(bVar);
                }
            });
        }
        if (8 == cVar.N_renamed.mApsDecisionFeatureType || 30 == cVar.N_renamed.mApsDecisionFeatureType || 34 == cVar.N_renamed.mApsDecisionFeatureType) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
            this.mbResetAwbLockAfterCaptured = true;
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        if (this.r_renamed) {
            return;
        }
        this.s_renamed = false;
        this.r_renamed = true;
        this.m_renamed = -1;
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.n_renamed.a_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.n_renamed.a_renamed.this.mbPaused) {
                    return;
                }
                if (com.oplus.camera.n_renamed.a_renamed.this.mCameraUIInterface != null && "portrait_streamer".equals(com.oplus.camera.n_renamed.a_renamed.this.q_renamed)) {
                    com.oplus.camera.n_renamed.a_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_half_body_better, -1, true, false, false);
                }
                com.oplus.camera.n_renamed.a_renamed.this.onUpdateCameraSettingMenu();
                com.oplus.camera.n_renamed.a_renamed aVar = com.oplus.camera.n_renamed.a_renamed.this;
                aVar.i_renamed = aVar.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA);
                if (com.oplus.camera.n_renamed.a_renamed.this.i_renamed) {
                    com.oplus.camera.n_renamed.a_renamed.this.t_renamed.removeMessages(1);
                    com.oplus.camera.n_renamed.a_renamed.this.t_renamed.sendEmptyMessageDelayed(1, 400L);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        if (z_renamed) {
            shutterButtonInfo.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 23 : 8);
            shutterButtonInfo.a_renamed("button_color_inside_none");
        } else {
            shutterButtonInfo.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 23 : 11);
            shutterButtonInfo.a_renamed("button_color_inside_none");
        }
        this.mCameraUIInterface.a_renamed(shutterButtonInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) {
        if (this.h_renamed) {
            this.mCameraUIInterface.a_renamed(i_renamed, 0, false, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed) {
        this.mCameraUIInterface.a_renamed(true, false, z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        super.onShutterCallback(z_renamed, z2);
        if (z2) {
            this.mCameraInterface.c_renamed(0);
            this.mCameraInterface.h_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("PortraitCapMode", "onBeforePictureTaken");
        if (this.mbPaused) {
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onAfterPictureTaken");
        if (this.mCameraInterface.i_renamed()) {
            if (!getZSLMode()) {
                this.mCameraInterface.n_renamed();
            }
            this.mCameraUIInterface.d_renamed(true, false);
        }
        this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), false);
        resetAeLockAfterCaptured();
        resetAwbLockAfterCaptured();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (i_renamed != 4) {
            if (i_renamed == 5) {
                this.h_renamed = z_renamed;
                if (z_renamed) {
                    if (this.mCameraUIInterface.s_renamed() == 4) {
                        this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), false);
                    }
                } else {
                    this.mCameraUIInterface.a_renamed(true, false, false);
                }
            } else if (i_renamed == 18 && !z_renamed) {
                this.h_renamed = false;
                android.os.Handler handler = this.t_renamed;
                if (handler != null) {
                    handler.removeMessages(1);
                }
                this.mCameraUIInterface.a_renamed(true, false, true);
            }
        } else if (this.i_renamed) {
            a_renamed(0, false);
        }
        if (4 == i_renamed || 7 == i_renamed || 8 == i_renamed || 9 == i_renamed || z_renamed || 3 == i_renamed) {
            return;
        }
        this.h_renamed = false;
        android.os.Handler handler2 = this.t_renamed;
        if (handler2 != null) {
            handler2.removeMessages(1);
        }
        this.mCameraUIInterface.a_renamed(true, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetMetadataBokehCode() {
        if (com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType)) {
            this.m_renamed = -1;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterItemChange(int i_renamed) {
        if (a_renamed(this.o_renamed, i_renamed)) {
            this.j_renamed = true;
        } else {
            this.j_renamed = false;
        }
        if (this.mPreviewEffectProcess != null) {
            java.lang.String filterType = getFilterType(i_renamed);
            java.lang.String filterRedpotKey = getFilterRedpotKey(filterType);
            if (filterRedpotKey != null) {
                this.mCameraUIInterface.l_renamed(i_renamed);
                androidx.preference.j_renamed.a_renamed(this.mActivity).edit().putBoolean(filterRedpotKey, false).apply();
            }
            this.s_renamed = a_renamed(filterType, true);
        }
        super.onFilterItemChange(i_renamed);
        if (this.s_renamed) {
            this.s_renamed = this.j_renamed;
            updateBlurValue();
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.n_renamed.a_renamed.5
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.n_renamed.a_renamed.this.mCameraUIInterface.q_renamed();
                }
            });
        }
        if (this.mbFrontCamera || this.o_renamed == i_renamed) {
            return;
        }
        if (this.j_renamed) {
            this.h_renamed = false;
            a_renamed(true);
            this.mCameraInterface.X_renamed();
            b_renamed(2 == this.p_renamed && d_renamed(this.o_renamed));
        }
        this.o_renamed = i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateFilterParam(int i_renamed) {
        if (this.mPreviewEffectProcess != null) {
            if (isVividEffectOpen() && i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
                forceCloseVividEffect();
            }
            java.lang.String filterType = getFilterType(i_renamed);
            if (!this.j_renamed) {
                a_renamed(filterType, false);
            }
            if (this.mOneCamera != null) {
                this.mOneCamera.a_renamed(filterType, isFilterOpen(filterType), false);
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.PORTRAIT_NEON_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isNeonEnable() ? "on_renamed" : "off"));
                return;
            } else {
                com.oplus.camera.e_renamed.f_renamed("PortraitCapMode", "updateFilterParam, mOneCamera is_renamed null ! ");
                return;
            }
        }
        com.oplus.camera.e_renamed.f_renamed("PortraitCapMode", "updateFilterParam, mPreviewEffectProcess: " + this.mPreviewEffectProcess + ", mPreferences: " + this.mPreferences);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed.b_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        return super.getFilterNameIdList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        return super.getFilterTypeList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU) ? com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX : super.getFilterEffectMenuPreferenceKey();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterType(int i_renamed) {
        return getFilterTypeList(this.mCameraId).get(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateHintView() {
        a_renamed(this.m_renamed, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        int iIntValue;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null) {
            com.oplus.camera.e_renamed.f_renamed("PortraitCapMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (this.h_renamed && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA)) {
            if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() || e_renamed()) {
                iIntValue = a_renamed(captureResult);
            } else {
                iIntValue = cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_BOKEN_STATE) != null ? ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_BOKEN_STATE)).intValue() : -1;
            }
            if (this.m_renamed != iIntValue) {
                com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "onPreviewCaptureResult, bokehState: " + this.m_renamed + " > " + iIntValue);
                this.m_renamed = iIntValue;
                a_renamed(this.m_renamed, true);
            }
        }
        if (this.mOneCamera.a_renamed((android.hardware.camera2.CaptureResult.Key<?>) com.oplus.camera.e_renamed.b_renamed.ae_renamed, captureResult) != null && java.lang.Float.compare(r6[0], 0.0f) > 0) {
            this.n_renamed = 1000.0f / r6[0];
        }
        if ("portrait_retention".equals(this.q_renamed) || "portrait_streamer".equals(this.q_renamed) || "neon-2020.cube.rgb.bin".equals(this.q_renamed)) {
            processFaceCount();
        }
    }

    private int a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.ak_renamed);
        if (objA == null || !(objA instanceof int[])) {
            return -1;
        }
        return ((int[]) objA)[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(int i_renamed) {
        if (7 == i_renamed && 2 != this.p_renamed) {
            this.p_renamed = 2;
            if (!d_renamed(this.o_renamed) || this.mPreviewEffectProcess == null) {
                return;
            }
            java.lang.String strH = h_renamed();
            this.mPreviewEffectProcess.a_renamed(strH);
            this.mCameraUIInterface.a_renamed(this.o_renamed, strH);
            a_renamed(true, this.o_renamed);
            return;
        }
        if (7 == i_renamed || 1 == this.p_renamed) {
            return;
        }
        this.p_renamed = 1;
        if (!d_renamed(this.o_renamed) || this.mPreviewEffectProcess == null) {
            return;
        }
        java.lang.String strG = g_renamed(this.o_renamed);
        this.mPreviewEffectProcess.a_renamed(strG);
        this.mCameraUIInterface.a_renamed(this.o_renamed, strG);
        a_renamed(false, this.o_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final int i_renamed, final boolean z_renamed) {
        if (this.mActivity == null) {
            return;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.n_renamed.a_renamed.6
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.n_renamed.a_renamed.this.mbPaused) {
                    return;
                }
                if (com.oplus.camera.n_renamed.a_renamed.this.mCameraUIInterface.T_renamed() || com.oplus.camera.n_renamed.a_renamed.this.mCameraUIInterface.R_renamed()) {
                    if (z_renamed) {
                        com.oplus.camera.n_renamed.a_renamed.this.c_renamed(i_renamed);
                        return;
                    }
                    return;
                }
                switch (i_renamed) {
                    case 1:
                        if (!com.oplus.camera.n_renamed.a_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || !com.oplus.camera.n_renamed.a_renamed.this.l_renamed) {
                            com.oplus.camera.n_renamed.a_renamed.this.a_renamed(true);
                            break;
                        }
                        break;
                    case 2:
                        if (!com.oplus.camera.n_renamed.a_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || !com.oplus.camera.n_renamed.a_renamed.this.l_renamed) {
                            com.oplus.camera.n_renamed.a_renamed.this.b_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_move_farther_away);
                        }
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed("bokeh_code", java.lang.String.valueOf(2));
                        break;
                    case 3:
                        com.oplus.camera.n_renamed.a_renamed.this.b_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_move_closer);
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed("bokeh_code", java.lang.String.valueOf(3));
                        break;
                    case 4:
                        com.oplus.camera.n_renamed.a_renamed.this.b_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_need_more_light);
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed("bokeh_code", java.lang.String.valueOf(4));
                        break;
                    case 5:
                        com.oplus.camera.n_renamed.a_renamed.this.b_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_place_subject_not_found);
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed("bokeh_code", java.lang.String.valueOf(5));
                        break;
                    case 6:
                    case 8:
                    default:
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed(true);
                        break;
                    case 7:
                        com.oplus.camera.n_renamed.a_renamed.this.b_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_camera_do_not_occlusion);
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed("bokeh_code", java.lang.String.valueOf(7), com.oplus.camera.n_renamed.a_renamed.this.getCurrFilterType());
                        break;
                    case 9:
                        com.oplus.camera.n_renamed.a_renamed.this.b_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_single);
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed("bokeh_code", java.lang.String.valueOf(9));
                        break;
                    case 10:
                        com.oplus.camera.n_renamed.a_renamed.this.b_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_camera_do_not_occlusion);
                        com.oplus.camera.n_renamed.a_renamed.this.a_renamed("bokeh_code", java.lang.String.valueOf(10), com.oplus.camera.n_renamed.a_renamed.this.getCurrFilterType());
                        break;
                }
                if (z_renamed) {
                    com.oplus.camera.n_renamed.a_renamed.this.c_renamed(i_renamed);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) ? null : (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mBokehCode = this.m_renamed;
        return captureMsgData;
    }

    private boolean e_renamed() {
        return !this.mbFrontCamera && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_BACK_PURE_3RD_BOKEH_PREVIEW);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_sub_preview_frame".equals(str)) {
            return 3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA) && !e_renamed();
        }
        if ("type_preview_frame".equals(str)) {
            return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        }
        if ("type_still_capture_yuv_sub".equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA);
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getPhotoRatio() {
        return this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_picture_size_standard);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(str, str2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.oplus.camera.statistics.model.ReminderMsgData reminderMsgData = new com.oplus.camera.statistics.model.ReminderMsgData(this.mActivity, true);
        if (this.mCameraInterface != null) {
            if (!this.mCameraInterface.i_renamed()) {
                reminderMsgData.mCameraEnterType = java.lang.String.valueOf(2);
            }
            reminderMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        }
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mCaptureType = 0;
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mPortraitNewStyleType = str3;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        reminderMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getEffectMenuKeyByMode() {
        return com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, this.mCameraEntryType);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY.equals(str) && !this.mbForbidPreferenceChange) {
            if (this.mCameraInterface != null) {
                this.mCameraInterface.au_renamed();
            }
        } else if (com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC.equals(str) && !this.mbForbidPreferenceChange) {
            if (this.mCameraInterface != null) {
                this.mCameraInterface.av_renamed();
            }
        } else {
            if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
                if (this.k_renamed) {
                    a_renamed("on_renamed");
                    return;
                } else {
                    a_renamed("off");
                    return;
                }
            }
            super.onSharedPreferenceChanged(sharedPreferences, str);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.j_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY));
        zoomConfigure.k_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC));
        return zoomConfigure;
    }

    private boolean f_renamed() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY) || this.mPreferences == null) {
            return false;
        }
        return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY, "off"));
    }

    private boolean g_renamed() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC) || this.mPreferences == null) {
            return false;
        }
        return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onHomeKeyClick() {
        if (this.mCameraEntry.c_renamed()) {
            if (this.k_renamed) {
                a_renamed("on_renamed");
            } else {
                a_renamed("off");
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public float getDefaultZoomValue(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (32784 == getOperatingMode()) {
            return 2.0f;
        }
        if (hVar != null) {
            return hVar.b_renamed(getZoomConfigure());
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(java.lang.String str) {
        if ("type_main_preview_frame".equals(str)) {
            if (e_renamed()) {
                return false;
            }
            return (!com.oplus.camera.util.Util.C_renamed() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA);
        }
        if ("type_sub_preview_frame".equals(str)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA);
        }
        if ("type_still_capture_yuv_main".equals(str) || "type_still_capture_yuv_sub".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return (!com.oplus.camera.util.Util.C_renamed() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA);
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMonoIndex(int i_renamed) {
        return i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed() || i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed();
    }

    private boolean d_renamed(int i_renamed) {
        return !this.mbFrontCamera && isMonoIndex(i_renamed);
    }

    public boolean a_renamed(int i_renamed) {
        return !this.mbFrontCamera && i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.l_renamed();
    }

    private boolean e_renamed(int i_renamed) {
        return i_renamed == (this.mbFrontCamera ? com.oplus.camera.ui.preview.a_renamed.j_renamed.m_renamed() : com.oplus.camera.ui.preview.a_renamed.j_renamed.n_renamed());
    }

    private boolean f_renamed(int i_renamed) {
        return !this.mbFrontCamera && i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.o_renamed();
    }

    private void b_renamed(boolean z_renamed) {
        if (z_renamed && this.mCameraUIInterface != null) {
            com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
            int i_renamed = this.o_renamed;
            cameraUIInterface.a_renamed(i_renamed, g_renamed(i_renamed));
            a_renamed(false, this.o_renamed);
        }
        this.p_renamed = 0;
        this.m_renamed = -1;
    }

    private java.lang.String g_renamed(int i_renamed) {
        return i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed() ? co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1 : i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed() ? co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_3 : "default";
    }

    public synchronized void a_renamed(boolean z_renamed, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "setIsShelterByIndex, isShelter: " + z_renamed + ", index: " + i_renamed);
        com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed.f6903b.set(i_renamed, z_renamed ? h_renamed() : g_renamed(i_renamed));
    }

    private boolean a_renamed(int i_renamed, int i2) {
        return (!this.mbFrontCamera && (isMonoIndex(i_renamed) || isMonoIndex(i2))) || a_renamed(i_renamed) || a_renamed(i2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean disableBokehHDR(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        synchronized (this.mApsDecisionResultLock) {
            boolean z_renamed = false;
            if (cameraApsDecision == null) {
                com.oplus.camera.e_renamed.a_renamed("PortraitCapMode", "disableBokehHDR, decisionResult null");
                return false;
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_BOKEH_HDR)) {
                return false;
            }
            if (1 == getDefaultCaptureNumber() && (12 == cameraApsDecision.mApsDecisionSceneMode || 13 == cameraApsDecision.mApsDecisionSceneMode || 30 == cameraApsDecision.mApsDecisionSceneMode)) {
                z_renamed = true;
            }
            return z_renamed;
        }
    }

    private boolean a_renamed(java.lang.String str, boolean z_renamed) {
        boolean z2 = false;
        if (this.q_renamed.equals(str) || this.mCameraUIInterface == null) {
            return false;
        }
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -928591791) {
            if (iHashCode != -404148440) {
                if (iHashCode == 205787002 && str.equals("portrait_retention")) {
                    c2 = 0;
                }
            } else if (str.equals("neon-2020.cube.rgb.bin")) {
                c2 = 2;
            }
        } else if (str.equals("portrait_streamer")) {
            c2 = 1;
        }
        if (c2 == 0) {
            this.mPreviewEffectProcess.a_renamed("default");
            this.mPreviewEffectProcess.b_renamed(true);
        } else if (c2 == 1) {
            this.mPreviewEffectProcess.a_renamed("default");
            this.mPreviewEffectProcess.b_renamed(false);
        } else if (c2 == 2) {
            this.mPreviewEffectProcess.a_renamed(this.mbFrontCamera ? "default" : str);
            this.mPreviewEffectProcess.b_renamed(false);
        } else {
            this.mPreviewEffectProcess.a_renamed(str);
            this.mPreviewEffectProcess.b_renamed(false);
        }
        boolean z3 = z_renamed && (b_renamed("neon-2020.cube.rgb.bin", this.q_renamed, str) || b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1, this.q_renamed, str) || b_renamed(co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_3, this.q_renamed, str));
        if (z_renamed && b_renamed("portrait_retention", this.q_renamed, str)) {
            z2 = true;
        }
        this.q_renamed = str;
        if (!com.oplus.camera.util.Util.C_renamed() && z3 && this.mOneCamera != null) {
            this.mOneCamera.C_renamed(isNeonEnable());
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        if (z2 && !this.mbFrontCamera) {
            updateRearAicolorEnable(true, "portrait_retention".equals(this.q_renamed));
        }
        return z3;
    }

    private void i_renamed() {
        if (this.mbFrontCamera || this.mPreferences == null) {
            return;
        }
        this.o_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX, com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
    }

    private boolean b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return (!str.equals(str2) && str.equals(str3)) || (str.equals(str2) && !str.equals(str3));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeonEnable() {
        return "neon-2020.cube.rgb.bin".equals(this.q_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStreamerEnable() {
        return "portrait_streamer".equals(this.q_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        if ("portrait_streamer".equals(getCurrFilterType())) {
            return com.oplus.camera.aps.constant.ApsConstant.FEATURE_STREAMER_PORTRAIT;
        }
        return null;
    }

    public float a_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_ZOOM_VALUE_DEFAULT);
    }

    public boolean b_renamed() {
        return java.lang.Float.compare(2.0f, a_renamed()) == 0;
    }

    public void a_renamed(java.lang.String str) {
        if (this.mPreferences != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY)) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY, str).apply();
                if (this.mCameraInterface != null) {
                    this.mCameraInterface.c_renamed("off".equals(str) ? 1.0f : 2.0f);
                }
                this.mbForbidPreferenceChange = false;
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC)) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC, str).apply();
                this.mbForbidPreferenceChange = false;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA)) {
            if (f_renamed() || g_renamed()) {
                builder.setParameter(com.oplus.ocs.camera.CameraParameter.PORTAIT_BODY_TYPE, "half_body");
            } else {
                builder.setParameter(com.oplus.ocs.camera.CameraParameter.PORTAIT_BODY_TYPE, com.oplus.ocs.camera.CameraParameter.PortraitBodyType.FULL_BODY);
            }
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_OPERATING)) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.PORTAIT_BOKEH_TYPE, com.oplus.ocs.camera.CameraParameter.BokehType.SINGLE_BOKEH);
        }
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.PORTRAIT_STREAMER_ENABLE, isStreamerOpen() ? "on_renamed" : "off");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null && currentScreenMode.r_renamed()) {
            this.mCameraUIInterface.b_renamed(true, true, false, false);
        }
        return super.onSingleTapUp(motionEvent);
    }
}
