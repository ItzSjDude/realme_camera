package com.oplus.camera.capmode;

/* compiled from: HighDefinitionMode.java */
/* loaded from: classes2.dex */
public class j_renamed extends com.oplus.camera.capmode.d_renamed {
    private com.oplus.camera.professional.r_renamed g_renamed;
    private com.oplus.camera.professional.s_renamed h_renamed;
    private java.util.ArrayList i_renamed;
    private boolean j_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFrontTorchEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isHighPictureSize() {
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected boolean isNeedResetNoneSatWide() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onHomeKeyClick() {
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onUltraWideAngleOpened() {
    }

    public j_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getPhotoRatio() {
        return this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_picture_size_standard);
    }

    private boolean a_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && isNoneSatUltraWideAngleOpen();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size sizeConfigValue;
        if (a_renamed()) {
            return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_FULL_SIZE);
        }
        return (getHeicCodecFormat() == null || (sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE_HEIF)) == null) ? com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE) : sizeConfigValue;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HighDefinitionMode", "onInitCameraMode");
        super.onInitCameraMode();
        restoreProPreference();
        if (isProModeSupport()) {
            if (b_renamed()) {
                a_renamed(1);
                b_renamed(0, false);
            } else {
                a_renamed(0);
            }
            this.h_renamed = new com.oplus.camera.professional.s_renamed(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
            this.h_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE);
            a_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) ? 0 : 8, false);
            this.mCameraUIInterface.z_renamed(false);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.professional.r_renamed rVar;
        com.oplus.camera.e_renamed.f_renamed("HighDefinitionMode", "onResume");
        super.onResume(z_renamed);
        if (!b_renamed() || (rVar = this.g_renamed) == null) {
            return;
        }
        rVar.e_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b_renamed() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) && this.mPreferences != null) {
            return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE, "off"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        com.oplus.camera.professional.r_renamed rVar = this.g_renamed;
        if (rVar != null) {
            return rVar.i_renamed();
        }
        return false;
    }

    private void a_renamed(int i_renamed, boolean z_renamed) {
        if (isProModeSupport()) {
            if (this.h_renamed == null) {
                if (i_renamed != 0) {
                    return;
                }
                this.h_renamed = new com.oplus.camera.professional.s_renamed(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
                this.h_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE);
            }
            this.h_renamed.a_renamed(i_renamed, z_renamed);
        }
    }

    private void b_renamed(int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HighDefinitionMode", "setProMenuVisibility visibility: " + i_renamed);
        if (this.g_renamed == null) {
            if (i_renamed != 0) {
                return;
            } else {
                c_renamed();
            }
        }
        this.g_renamed.a_renamed(i_renamed, z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        com.oplus.camera.professional.r_renamed rVar = this.g_renamed;
        if (rVar != null) {
            rVar.a_renamed(i_renamed);
        }
        if (this.mOrientation == i_renamed) {
            return;
        }
        this.mOrientation = i_renamed;
    }

    private void c_renamed() {
        this.g_renamed = new com.oplus.camera.professional.j_renamed(this.mActivity, this.mCameraInterface, this.mCameraUIInterface, getCameraMode());
        this.g_renamed.a_renamed(new com.oplus.camera.professional.j_renamed.a_renamed() { // from class: com.oplus.camera.capmode.j_renamed.1
            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean a_renamed() {
                return com.oplus.camera.capmode.j_renamed.this.mbInCapturing;
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean b_renamed() {
                return com.oplus.camera.capmode.j_renamed.this.b_renamed();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean a_renamed(java.lang.String str) {
                return com.oplus.camera.capmode.j_renamed.this.getSupportFunction(str);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public int c_renamed() {
                return com.oplus.camera.capmode.j_renamed.super.getDefaultAFMode();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void b_renamed(java.lang.String str) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.b_renamed(str);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(int i_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.a_renamed(i_renamed, true);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public int d_renamed() {
                return com.oplus.camera.capmode.j_renamed.this.mOneCamera.p_renamed();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void b_renamed(int i_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.a_renamed(i_renamed, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(float f_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.a_renamed(f_renamed, true);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(long j_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.a_renamed(j_renamed, true);
            }

            @Override // com.oplus.camera.professional.j_renamed.a_renamed
            public void b_renamed(long j_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.c_renamed(j_renamed);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void a_renamed(boolean z_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.l_renamed(z_renamed);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void c_renamed(int i_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.b_renamed(i_renamed, true);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void e_renamed() {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.i_renamed(true);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void d_renamed(int i_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void e_renamed(int i_renamed) {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(i_renamed));
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void f_renamed() {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void g_renamed() {
                com.oplus.camera.capmode.j_renamed.this.mOneCamera.j_renamed(true);
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public com.oplus.camera.ui.control.b_renamed h_renamed() {
                return com.oplus.camera.capmode.j_renamed.this.getShutterButtonInfo();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public boolean i_renamed() {
                return com.oplus.camera.capmode.j_renamed.this.isPanelMode();
            }

            @Override // com.oplus.camera.professional.r_renamed.b_renamed
            public void b_renamed(boolean z_renamed) {
                if (com.oplus.camera.capmode.j_renamed.this.h_renamed == null || !a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
                    return;
                }
                com.oplus.camera.capmode.j_renamed.this.h_renamed.a_renamed(z_renamed ? 0 : 8, false);
            }
        });
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (this.mbCapModeInit && this.g_renamed != null && b_renamed()) {
            this.g_renamed.a_renamed(cameraPreviewResult.getCaptureResult());
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:62:0x00de  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.j_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        return super.getSupportMenu(str);
    }

    public void a_renamed(boolean z_renamed) {
        forceClosePIEffect();
        if (z_renamed) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI)) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, "off");
                return;
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI, "off");
                return;
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI)) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, (java.lang.String) null);
        } else {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI, (java.lang.String) null);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PI.equals(str)) {
            return !b_renamed();
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.professional.r_renamed rVar;
        if (com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE.equals(str)) {
            boolean zB = b_renamed();
            com.oplus.camera.e_renamed.b_renamed("HighDefinitionMode", "onSharedPreferenceChanged isProModeOn: " + zB);
            if (zB) {
                c_renamed();
            } else {
                com.oplus.camera.professional.r_renamed rVar2 = this.g_renamed;
                if (rVar2 != null) {
                    rVar2.g_renamed();
                    this.g_renamed.a_renamed((com.oplus.camera.professional.r_renamed.b_renamed) null);
                    this.g_renamed = null;
                }
            }
            a_renamed(zB);
            b_renamed(zB ? 0 : 8, false);
            d_renamed();
            this.h_renamed.a_renamed(zB);
            this.mCameraInterface.aH_renamed();
            this.mCameraUIInterface.z_renamed(false);
            a_renamed(b_renamed() ? 1 : 0);
            e_renamed();
            if (!zB && (rVar = this.g_renamed) != null) {
                rVar.n_renamed();
            }
        } else if (com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE.equals(str) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, sharedPreferences.getString(str, "off")).apply();
        }
        com.oplus.camera.professional.r_renamed rVar3 = this.g_renamed;
        if (rVar3 != null) {
            rVar3.a_renamed(sharedPreferences, str);
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    private void d_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.g_renamed == null || this.mPreferences == null || !b_renamed() || !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_HIGH_PICTURE_PRO_PARAMS, false)) {
            return;
        }
        this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_HIGH_PICTURE_PRO_PARAMS).apply();
        this.g_renamed.n_renamed();
        this.g_renamed.b_renamed();
    }

    private void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("HighDefinitionMode", "updateHighpictureProMode, value: " + i_renamed);
        if (this.mOneCamera != null) {
            this.mOneCamera.y_renamed(i_renamed);
            this.mOneCamera.a_renamed(-1L, true);
            this.mOneCamera.b_renamed(-1, true);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    private void e_renamed() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            if (b_renamed()) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_highpicture_pro_tips_oplus_r, -1, false, false, true);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_highpicture_pro_tips_oplus_r);
            }
        }
    }

    private java.util.List<java.lang.Integer> f_renamed() {
        java.util.ArrayList arrayList = this.i_renamed;
        if (arrayList != null) {
            return arrayList;
        }
        this.i_renamed = new java.util.ArrayList();
        this.i_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_tips));
        this.i_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_low_exposure_time_tips_oplus_r));
        this.i_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_scene_night_image_optimizing_tips_oplus_r));
        return this.i_renamed;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION_ZOOM) && isNoneSatUltraWideAngleOpen()) {
            zoomConfigure.a_renamed(1.0f);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION_ZOOM)) {
            zoomConfigure.l_renamed(false);
            zoomConfigure.n_renamed(false);
        }
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (b_renamed()) {
            return;
        }
        super.displayScreenHintIconInSwitchOn();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HighDefinitionMode", "onMoreModeShown");
        if (isProModeSupport()) {
            if (b_renamed()) {
                b_renamed(8, false);
            }
            a_renamed(8, false);
        }
        super.onMoreModeShown();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HighDefinitionMode", "onMoreModeHidden");
        if (isProModeSupport()) {
            if (b_renamed()) {
                b_renamed(0, false);
                e_renamed();
            }
            a_renamed((!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) || isShowProPanelMenu()) ? 8 : 0, false);
        }
        super.onMoreModeHidden(i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (this.g_renamed != null && b_renamed()) {
            return this.g_renamed.c_renamed();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkoutTimerSnapShotState() {
        super.checkoutTimerSnapShotState();
        this.j_renamed = false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        super.onTimeSnapShotEnd(z_renamed);
        this.j_renamed = z_renamed;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.b_renamed("HighDefinitionMode", "onBeforePreview");
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            a_renamed(b_renamed() ? 1 : 0);
        }
        if (this.g_renamed != null && b_renamed()) {
            this.g_renamed.c_renamed(this.mbCapModeInit);
            e_renamed();
        }
        super.onBeforePreview();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        if (isProModeSupport()) {
            if (this.g_renamed != null && b_renamed()) {
                if (!this.g_renamed.a_renamed(false)) {
                    return false;
                }
                com.oplus.camera.professional.r_renamed rVar = this.g_renamed;
                if (rVar.d_renamed(rVar.w_renamed())) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_highpicture_pro_tips_oplus_r);
                    this.mCameraUIInterface.a_renamed(f_renamed(), 3000L);
                }
            }
            com.oplus.camera.professional.s_renamed sVar = this.h_renamed;
            if (sVar != null) {
                sVar.a_renamed(8, false);
            }
        }
        return super.onBeforeSnapping(cVar);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        if (this.g_renamed != null && b_renamed()) {
            this.g_renamed.v_renamed();
        }
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        if (this.g_renamed != null && b_renamed()) {
            this.g_renamed.a_renamed(bArr, z_renamed, false);
        }
        if (this.h_renamed != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) && !isShowProPanelMenu()) {
            this.h_renamed.a_renamed(0, true);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            this.mCameraUIInterface.n_renamed();
            e_renamed();
        }
        super.onAfterPictureTaken(bArr, z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        if (this.g_renamed != null && b_renamed()) {
            return this.g_renamed.a_renamed(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("HighDefinitionMode", "onAfterStartPreview");
        if (isProModeSupport()) {
            if (this.g_renamed != null && b_renamed()) {
                this.g_renamed.u_renamed();
            }
            if (this.h_renamed != null && !isShowProPanelMenu()) {
                this.h_renamed.c_renamed();
            }
            if (b_renamed()) {
                this.mCameraUIInterface.z_renamed(false);
            }
        }
        if (this.mOneCamera != null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HIGH_PICTURE_ULTRA_RESOLUTION_MODE)) {
            this.mOneCamera.v_renamed(true);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.c_renamed("HighDefinitionMode", "onDeInitCameraMode");
        if (isProModeSupport()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_highpicture_pro_tips_oplus_r);
            this.mCameraUIInterface.a_renamed(true, true, false);
            com.oplus.camera.professional.r_renamed rVar = this.g_renamed;
            if (rVar != null) {
                rVar.g_renamed();
                this.g_renamed.a_renamed((com.oplus.camera.professional.r_renamed.b_renamed) null);
                this.g_renamed = null;
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
                a_renamed(0);
            }
            com.oplus.camera.professional.s_renamed sVar = this.h_renamed;
            if (sVar != null) {
                sVar.a_renamed();
                this.h_renamed = null;
            }
        }
        super.onDeInitCameraMode(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("HighDefinitionMode", "onPause");
        if (isProModeSupport()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_highpicture_pro_tips_oplus_r);
            this.mCameraUIInterface.a_renamed(true, true, false);
            if (this.g_renamed != null && b_renamed()) {
                this.g_renamed.m_renamed();
                this.mCameraUIInterface.g_renamed(0);
                a_renamed(0);
            }
        }
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        com.oplus.camera.professional.r_renamed rVar;
        if (!b_renamed() || (rVar = this.g_renamed) == null || rVar.d_renamed(2)) {
            return super.getZSLMode();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return super.getOperatingMode();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HighDefinitionMode", "changeModeAllView animationType: " + i_renamed + ", isShow: " + z_renamed);
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (3 == i_renamed && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            if (this.g_renamed != null) {
                this.g_renamed.b_renamed((z_renamed && this.mbInCapturing) ? false : z_renamed);
            }
            if (z_renamed) {
                if (b_renamed()) {
                    b_renamed(b_renamed() ? 0 : 8, true);
                }
                if (this.j_renamed) {
                    return;
                }
                a_renamed(0, false);
                return;
            }
            if (b_renamed()) {
                b_renamed(8, true);
            }
            a_renamed(8, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedResetAutoFocus() {
        return !b_renamed();
    }
}
