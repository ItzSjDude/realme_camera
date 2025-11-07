package com.oplus.camera.capmode;

/* compiled from: NightMode.java */
/* loaded from: classes2.dex */
public class r_renamed extends com.oplus.camera.capmode.d_renamed {
    private long g_renamed;
    private int h_renamed;
    private int i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private int m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private com.oplus.camera.professional.n_renamed t_renamed;
    private int u_renamed;
    private int v_renamed;
    private final com.sensetime.utils.ShakeDetectorUtils.OnShakeListener w_renamed;

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        return null;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getEffectMenuKeyByMode() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 3;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32793;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onGetNearMeOnClickData() {
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public r_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = Long.MAX_VALUE;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = 0;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = false;
        this.s_renamed = true;
        this.t_renamed = null;
        this.u_renamed = 0;
        this.v_renamed = 3000;
        this.w_renamed = new com.sensetime.utils.ShakeDetectorUtils.OnShakeListener() { // from class: com.oplus.camera.capmode.r_renamed.1
            @Override // com.sensetime.utils.ShakeDetectorUtils.OnShakeListener
            public void onShake(boolean z_renamed) {
                if (z_renamed && com.oplus.camera.capmode.r_renamed.this.mCameraUIInterface != null && com.oplus.camera.capmode.r_renamed.this.isTripodModeOpened()) {
                    com.oplus.camera.capmode.r_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tripod_night_keep_steady_tips, -1, true, false, false);
                }
            }
        };
        this.u_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_TRIPOD_RAM_THRESHOLD);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:52:0x010e  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed r17) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.r_renamed.getPictureSize(com.oplus.camera.e_renamed.h_renamed):android.util.Size");
    }

    private android.util.Size b_renamed() {
        java.util.List<android.util.Size> configSizeListValue;
        android.util.Size sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_BACK_NIGHT_LOW_MEMORY_RAW_PICTURE_SIZE);
        if (sizeConfigValue != null && com.oplus.camera.util.Util.g_renamed(this.mActivity).totalMem <= com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1) {
            return sizeConfigValue;
        }
        if (com.oplus.camera.e_renamed.a_renamed.h_renamed() == getProperCameraId(this.mCameraId)) {
            configSizeListValue = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_BACK_NIGHT_RAW_PICTURE_SIZE);
        } else {
            configSizeListValue = com.oplus.camera.e_renamed.a_renamed.i_renamed() == getProperCameraId(this.mCameraId) ? com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_NIGHT_RAW_PICTURE_SIZE) : null;
        }
        if (configSizeListValue == null || configSizeListValue.size() == 0) {
            return null;
        }
        return configSizeListValue.get(0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDeleteTheSizeByRatio(java.lang.String str) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) && "16_9".equals(str)) {
            return true;
        }
        return super.needDeleteTheSizeByRatio(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (this.n_renamed || this.k_renamed || this.o_renamed || this.p_renamed || isTripodModeOpened()) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    private void a_renamed(boolean z_renamed) {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tripod_night_keep_steady_tips);
        this.mCameraUIInterface.a_renamed(z_renamed ? com.oplus.camera.R_renamed.string.camera_scene_tripod_night_mode_on_tips : com.oplus.camera.R_renamed.string.camera_scene_tripod_night_mode_off_tips, -1, true, false, false);
    }

    private void c_renamed() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tips_tripod_night_fixed_phone_on);
    }

    private void d_renamed() {
        if (this.q_renamed || this.mbPaused || !this.mbCapModeInit) {
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_ultra_dark_mode_tips, -1, false, false, true);
        this.q_renamed = true;
    }

    private void e_renamed() {
        if (!this.q_renamed || this.mbPaused) {
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_ultra_dark_mode_tips);
        this.q_renamed = false;
    }

    private void f_renamed() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_night_starburst_hint);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_night_starburst_hint, -1, true, false, false);
    }

    private void g_renamed() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_night_starburst_hint);
    }

    private void h_renamed() {
        this.j_renamed = false;
        this.i_renamed = 0;
        this.q_renamed = false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        this.k_renamed = false;
        this.n_renamed = false;
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.a_renamed(this.mbCapModeInit);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("NightMode", "onDeInitCameraMode()");
        c_renamed();
        e_renamed();
        h_renamed();
        b_renamed(false);
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.b_renamed();
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) && this.mOneCamera != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, "16_9");
        }
        super.onDeInitCameraMode(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.s_renamed = true;
        h_renamed();
        b_renamed(false);
        if (this.mNightCountDownUI != null) {
            this.mNightCountDownUI.b_renamed();
        }
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.c_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        int i_renamed = cVar.N_renamed == null ? -1 : cVar.N_renamed.mMultiFrameCount;
        this.g_renamed = com.oplus.camera.util.Util.k_renamed(this.mActivity);
        this.r_renamed = false;
        this.s_renamed = false;
        e_renamed();
        b_renamed(false);
        com.oplus.camera.e_renamed.b_renamed("NightMode", "onBeforeSnapping, rawCaptureNum: " + i_renamed + ", getNightStateDecision: " + getNightStateDecision() + ", mAvailMemory: " + this.g_renamed);
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null && !nVar.a_renamed(cVar, this.mbSceneNight)) {
            return false;
        }
        boolean zOnBeforeSnapping = super.onBeforeSnapping(cVar);
        this.mbCheckTakeAnimateDelay = false;
        if (isInNightProProcess()) {
            this.mCameraUIInterface.a_renamed(true, true, false);
            if (this.t_renamed != null && a_renamed()) {
                this.mCameraUIInterface.a_renamed(this.t_renamed.r_renamed(), com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
            i_renamed();
        } else if (isSuperNightShutterCountDownOpen()) {
            this.mNightCaptureTotalTime = this.v_renamed;
            this.mbCaptureRawTimeDone = false;
            i_renamed();
        }
        onProcessCapturePictureRequest();
        return zOnBeforeSnapping;
    }

    private void i_renamed() {
        if (this.mNightCaptureTotalTime > 0) {
            this.mNightCountDownUI.a_renamed(this.mNightCaptureTotalTime);
        }
        updateNightCaptureShutter();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, int i4) {
        com.oplus.camera.e_renamed.b_renamed("NightMode", "onPictureCallback, data: " + bArr + ",isInNightProProcess: " + isInNightProProcess() + ",mbCaptureRawTimeDone: " + this.mbCaptureRawTimeDone);
        if (isInNightProProcess() && !this.mbCaptureRawTimeDone) {
            stopNightCountdownTime();
        }
        super.onPictureCallback(bArr, i_renamed, i2, i3, z_renamed, i4);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        if (isInNightProProcess()) {
            this.mCameraUIInterface.n_renamed();
            this.mCameraInterface.aJ_renamed();
        }
        this.s_renamed = true;
        this.mbEnableUILater = false;
        if (isTripodModeOpened()) {
            b_renamed(true);
        }
        super.onAfterPictureTaken(bArr, z_renamed);
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.a_renamed(bArr, z_renamed, isInNightProProcess());
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) && a_renamed()) {
            this.mCameraUIInterface.b_renamed(0, com.oplus.camera.util.Util.c_renamed(getPreviewSize(getCameraInfo(this.mCameraId))));
            l_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected void resetAfterPictureTaken(boolean z_renamed, boolean z2) {
        if (!this.mbCaptureRawTimeDone && z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("NightMode", "resetAfterPictureTaken, CaptureRawTime not end");
            return;
        }
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.g_renamed();
        }
        super.resetAfterPictureTaken(z_renamed, z2);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        if (shutterButtonInfo != null && 4 == this.mCameraUIInterface.s_renamed()) {
            shutterButtonInfo.a_renamed(32);
        }
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        int[] iArrA;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed("NightMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (!this.mbInCapturing && a_renamed()) {
            a_renamed(captureResult);
        }
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.a_renamed(captureResult);
        }
        boolean zIsTripodModeOpened = isTripodModeOpened();
        if (this.mbInCapturing || !zIsTripodModeOpened || (iArrA = this.mOneCamera.a_renamed((android.hardware.camera2.CaptureResult.Key<?>) com.oplus.camera.e_renamed.b_renamed.ad_renamed, captureResult)) == null || iArrA.length <= 0) {
            return;
        }
        this.h_renamed += iArrA[0];
        this.i_renamed++;
        if (this.i_renamed == 10) {
            this.j_renamed = this.h_renamed >= 6;
            this.h_renamed = 0;
            this.i_renamed = 0;
        }
    }

    private void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        long jB = b_renamed(captureResult);
        com.oplus.camera.e_renamed.b_renamed("NightMode", "updateEstimatedCaptureTime, estimatedCountDownTime: " + jB);
        if (jB <= 0) {
            this.mNightCaptureTotalTime = 0L;
        } else {
            this.mNightCaptureTotalTime = jB / 1000000;
            this.mNightCaptureTotalTime = java.lang.Math.round(this.mNightCaptureTotalTime / 1000.0f) * 1000;
        }
    }

    private long b_renamed(android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Object objA;
        if (captureResult == null || (objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bh_renamed)) == null) {
            return -1L;
        }
        return ((long[]) objA)[0];
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewDecisionResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        super.onPreviewDecisionResult(cameraApsDecision);
        synchronized (this.mApsDecisionResultLock) {
            boolean z_renamed = true;
            if (com.oplus.camera.util.Util.C_renamed()) {
                if (this.mDecisionResult != null && this.mDecisionResult.mApsAlgoFlag != null) {
                    java.lang.String str = this.mDecisionResult.mApsAlgoFlag[0];
                    if (!com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_DARKSIGHT.equals(str) && 16 != this.mDecisionResult.mApsDecisionSceneMode) {
                        z_renamed = false;
                    }
                    this.k_renamed = z_renamed;
                    this.n_renamed = com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_AI_NIGHT.equals(str);
                    this.o_renamed = com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SUPERNIGHT.equals(str);
                    this.p_renamed = com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_FRONT_PORTRAIT_SUPERNIGHT.equals(str);
                }
            } else {
                if (this.mDecisionResult == null || (13 != this.mDecisionResult.mApsDecisionFeatureType && 14 != this.mDecisionResult.mApsDecisionFeatureType && 29 != this.mDecisionResult.mApsDecisionFeatureType)) {
                    z_renamed = false;
                }
                this.k_renamed = z_renamed;
            }
        }
        if (com.oplus.camera.util.Util.C_renamed()) {
            if (!com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_DARKSIGHT)) {
                e_renamed();
                return;
            }
        } else if (!com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_AINR) && !com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_AIHDR)) {
            e_renamed();
            return;
        }
        if (this.k_renamed && this.mbCaptureRawTimeDone && !isTripodModeOpened() && !a_renamed() && this.s_renamed) {
            d_renamed();
        } else {
            e_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) throws java.lang.Throwable {
        com.oplus.camera.e_renamed.f_renamed("NightMode", "onResume");
        this.mbStopSteadyTips = true;
        int iAD = this.m_renamed;
        if (iAD <= 0) {
            iAD = com.oplus.camera.util.Util.aD_renamed();
        }
        this.m_renamed = iAD;
        int i_renamed = this.m_renamed;
        this.l_renamed = i_renamed > this.u_renamed || i_renamed <= 0;
        if (isTripodModeOpened()) {
            b_renamed(true);
        }
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.b_renamed(z_renamed);
        }
        super.onResume(z_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws java.lang.Throwable {
        super.onInitCameraMode();
        int iAD = this.m_renamed;
        if (iAD <= 0) {
            iAD = com.oplus.camera.util.Util.aD_renamed();
        }
        this.m_renamed = iAD;
        int i_renamed = this.m_renamed;
        this.l_renamed = i_renamed > this.u_renamed || i_renamed <= 0;
        if (isNightProModeSupport()) {
            restoreProPreference();
            p_renamed();
        }
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.h_renamed();
            this.t_renamed.e_renamed(true);
        }
        if (isTripodModeOpened()) {
            b_renamed(true);
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) || this.mOneCamera == null) {
            return;
        }
        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, "16_9");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateRatioType() {
        super.updateRatioType();
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) || this.mOneCamera == null) {
            return;
        }
        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, "16_9");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        com.oplus.camera.e_renamed.f_renamed("NightMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (this.mbFrontCamera && com.oplus.camera.util.Util.au_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            super.displayScreenHintIconInSwitchOn();
        } else if (is10bitsHeicEncodeEnable() && this.mbStopSteadyTips) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected boolean isTripodModeOpened() {
        if (this.mPreferences != null) {
            return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, this.mActivity != null ? this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_night_tripod_mode_default_value) : "off"));
        }
        return false;
    }

    private boolean j_renamed() {
        if (this.mPreferences != null) {
            return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE, this.mActivity != null ? this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_night_starburst_mode_default_value) : "off"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return ((isTripodNight() && isInNightProcess()) || isNightAlgoCaptureTriggered() || this.mNightAlgoTriggeredStep != 0 || isInNightProProcess()) && getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData ? (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mIsTripodMode = isTripodModeOpened() ? "on_renamed" : "off";
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS)) {
            if (this.k_renamed) {
                captureMsgData.mNightState = 5;
            } else {
                captureMsgData.mNightState = getNightStateDecision();
            }
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:158:0x025e  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 1192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.r_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if (!com.oplus.camera.util.Util.C_renamed() && !this.mbFrontCamera && (("type_still_capture_yuv_main".equals(str) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str) || "type_tuning_data_yuv".equals(str) || ("type_tuning_data_raw".equals(str) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)))) {
            return false;
        }
        if ("type_reprocess_data_yuv".equals(str)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) && !this.mbFrontCamera;
        }
        if ("type_tele_small_preview".equals(str)) {
            return false;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return com.oplus.camera.util.Util.au_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar == null || !nVar.k_renamed()) {
            return super.onBackPressed();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(android.view.MotionEvent motionEvent) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS)) {
            return true;
        }
        return super.onLongPress(motionEvent);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isInNightProcess() {
        return getNightStateDecision() > 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void checkIfLockAutoExposure() {
        if (com.oplus.camera.util.Util.C_renamed() || this.mbResetAeLockAfterCaptured || !this.mbFrontCamera || !isInNightProcess()) {
            return;
        }
        this.mOneCamera.b_renamed(true, false);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        this.mbResetAeLockAfterCaptured = true;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_CUSTOM_BEAUTY;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getMakeupKeys() {
        return getCurrentKeys(com.oplus.camera.ui.preview.a_renamed.g_renamed.f_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String getMakeupTypeKey() {
        return com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType) ? com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_MAKEUP_TYPE, this.mCameraEntryType) : com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_MAKEUP_TYPE;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(str) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            return !isNoneSatUltraWideAngleOpen();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowSceneNightTips() {
        return this.mbShowSteadyTips;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE)) {
            m_renamed();
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.TRIPOD_MODE_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(isTripodModeOpened()));
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            boolean zIsTripodModeOpened = isTripodModeOpened();
            a_renamed(zIsTripodModeOpened);
            b_renamed(zIsTripodModeOpened);
        } else {
            if (com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE.equals(str)) {
                boolean zA = a_renamed();
                boolean zIsNoneSatUltraWideAngleOpen = isNoneSatUltraWideAngleOpen();
                com.oplus.camera.e_renamed.b_renamed("NightMode", "onSharedPreferenceChanged isProModeOn: " + zA);
                k_renamed();
                n_renamed();
                if (zA) {
                    o_renamed();
                    this.mCameraUIInterface.k_renamed(false, false);
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint);
                } else {
                    this.mCameraUIInterface.l_renamed(false, false);
                }
                com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
                if (nVar != null) {
                    nVar.c_renamed(zA);
                }
                if (!zIsNoneSatUltraWideAngleOpen) {
                    l_renamed();
                }
            } else if (com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE)) {
                boolean zJ = j_renamed();
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.STARBURST_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(zJ));
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                if (zJ) {
                    f_renamed();
                } else {
                    g_renamed();
                }
            } else if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
                boolean z_renamed = 1 == java.lang.Integer.parseInt(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0)));
                com.oplus.camera.professional.n_renamed nVar2 = this.t_renamed;
                if (nVar2 != null) {
                    nVar2.d_renamed(z_renamed);
                }
            } else {
                com.oplus.camera.professional.n_renamed nVar3 = this.t_renamed;
                if (nVar3 != null) {
                    nVar3.a_renamed(sharedPreferences, str);
                }
            }
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    private void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("NightMode", "setShakeDetectEnable, enable: " + z_renamed);
        if (z_renamed) {
            com.sensetime.utils.ShakeDetectorUtils.getInstance(this.mActivity).registerOnShakeListener(this.w_renamed).start();
        } else {
            com.sensetime.utils.ShakeDetectorUtils.getInstance(this.mActivity).unregisterOnShakeListener(this.w_renamed).stop();
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tripod_night_keep_steady_tips);
        }
    }

    private void k_renamed() {
        if (isNoneSatUltraWideAngleOpen()) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            return nVar.a_renamed(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    private void l_renamed() {
        com.oplus.camera.professional.n_renamed nVar;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) && (nVar = this.t_renamed) != null) {
            nVar.q_renamed();
        }
    }

    private void m_renamed() {
        com.oplus.camera.professional.n_renamed nVar;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            if ((this.mCameraInterface.a_renamed(getZoomValue()) || isTripodModeOpened() || this.mCameraUIInterface.A_renamed()) && (nVar = this.t_renamed) != null) {
                nVar.p_renamed();
            }
        }
    }

    private void n_renamed() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE)) {
            if (a_renamed() && !"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, "off"))) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, "off").apply();
            }
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        l_renamed();
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.i_renamed();
        }
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        if (isInNightProProcess() && this.r_renamed) {
            return;
        }
        super.onShutterCallback(z_renamed, z2);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureCompleted(cameraCaptureResult, cVar);
        this.mCameraUIInterface.i_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        if (this.mCaptureRequestTag == null || !this.mCaptureRequestTag.Y_renamed) {
            return;
        }
        if (com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_RAW == this.mCaptureRequestTag.a_renamed() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) {
            resetAwbLockAfterCaptured();
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.v_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_INSENSOR_ZOOM_POINT_2X_SUPPORT));
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            boolean zA = a_renamed();
            zoomConfigure.p_renamed(zA);
            zoomConfigure.w_renamed(zA);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_NIGHT_MODE_MAX_ZOOM_SUPPORT)) {
            zoomConfigure.x_renamed(true);
        }
        float configFloatValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue) {
            zoomConfigure.b_renamed(configFloatValue);
        } else {
            zoomConfigure.b_renamed(0.0f);
        }
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        com.oplus.camera.e_renamed.a_renamed("NightMode", "onAfterSnapping");
        if (isInNightProProcess()) {
            this.mCameraInterface.c_renamed(0);
            this.mCameraUIInterface.a_renamed(true, false);
            this.r_renamed = true;
        }
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.k_renamed.f_renamed;
        }
        return super.getFilterNameIdList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.k_renamed.e_renamed;
        }
        return super.getFilterTypeList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        super.onFilterMenuClicked();
        if (this.t_renamed == null || !a_renamed()) {
            return;
        }
        this.t_renamed.p_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.a_renamed(3, false);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z_renamed) {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.a_renamed(3, true);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int i_renamed) {
        super.onFilterItemChange(i_renamed);
        if (!isTripodModeOpened() || com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a == i_renamed) {
            return;
        }
        n_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) {
        if (isTripodModeOpened() && this.mNightCountDownUI != null && this.mNightCountDownUI.g_renamed()) {
            return false;
        }
        return super.getTouchEnable(z_renamed, i_renamed, i2);
    }

    private void o_renamed() {
        if (this.mCameraUIInterface.A_renamed()) {
            this.mCameraUIInterface.m_renamed(true, false);
        }
        if (isFilterEffectOpen()) {
            this.mPreferences.edit().putInt(getFilterEffectMenuPreferenceKey(), com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a).apply();
            onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        }
    }

    private void p_renamed() {
        this.t_renamed = new com.oplus.camera.professional.n_renamed(this.mActivity, this.mCameraInterface, this.mCameraUIInterface, getCameraMode(), this.mOneCamera);
        this.t_renamed.a_renamed(new com.oplus.camera.professional.n_renamed.a_renamed() { // from class: com.oplus.camera.capmode.r_renamed.2
            @Override // com.oplus.camera.professional.n_renamed.a_renamed
            public boolean a_renamed() {
                return com.oplus.camera.capmode.r_renamed.this.mbInCapturing;
            }

            @Override // com.oplus.camera.professional.n_renamed.a_renamed
            public boolean b_renamed() {
                return com.oplus.camera.capmode.r_renamed.this.isInNightProProcess();
            }

            @Override // com.oplus.camera.professional.n_renamed.a_renamed
            public boolean a_renamed(java.lang.String str) {
                return com.oplus.camera.capmode.r_renamed.this.getSupportFunction(str);
            }

            @Override // com.oplus.camera.professional.n_renamed.a_renamed
            public int c_renamed() {
                return com.oplus.camera.capmode.r_renamed.super.getDefaultAFMode();
            }

            @Override // com.oplus.camera.professional.n_renamed.a_renamed
            public com.oplus.camera.ui.control.b_renamed d_renamed() {
                return com.oplus.camera.capmode.r_renamed.this.getShutterButtonInfo();
            }

            @Override // com.oplus.camera.professional.n_renamed.a_renamed
            public boolean e_renamed() {
                return com.oplus.camera.capmode.r_renamed.this.isPanelMode();
            }
        });
    }

    private boolean a_renamed(java.lang.String str) {
        if (getSupportFunction(str) && this.mPreferences != null) {
            return "on_renamed".equals(this.mPreferences.getString(str, "off"));
        }
        return false;
    }

    protected boolean a_renamed() {
        if (this.mPreferences != null) {
            return a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_PRO_MODE) && !(1 == java.lang.Integer.parseInt(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0))));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            return nVar.d_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.n_renamed();
        }
        super.onZoomMenuCollapsed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.o_renamed();
        }
        super.onZoomMenuExpand();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateControlPanelBgColor(int i_renamed) {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.b_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        if (isInNightProProcess()) {
            return true;
        }
        return super.isNeedProgressBarInCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.a_renamed(i_renamed);
        }
        super.setOrientation(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null && nVar.e_renamed()) {
            return this.mActivity.getApplicationContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_height);
        }
        return super.getZoomBarOffset();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        m_renamed();
        displayScreenHintIconInSwitchOn();
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected boolean isInNightProProcess() {
        return a_renamed() && this.mNightCaptureTotalTime > 0;
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected boolean isNightProSoundPlayed() {
        return this.r_renamed;
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected boolean isInNightProMode() {
        return a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInProMode() {
        return a_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        com.oplus.camera.e_renamed.a_renamed("NightMode", "onMoreModeShown");
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.l_renamed();
        }
        super.onMoreModeShown();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("NightMode", "onMoreModeHidden");
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.m_renamed();
        }
        super.onMoreModeHidden(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showBeautyButton() {
        if (a_renamed()) {
            return false;
        }
        if (isTripodModeOpened() && this.mNightCountDownUI != null && this.mNightCountDownUI.g_renamed()) {
            return false;
        }
        return super.showBeautyButton();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("NightMode", "changeModeAllView animationType: " + i_renamed + ", isShow: " + z_renamed);
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.a_renamed(i_renamed, z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedResetAutoFocus() {
        return !isInNightProMode();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowZoomMenu() {
        if (this.t_renamed != null) {
            return !r0.f_renamed();
        }
        return super.isShowZoomMenu();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (a_renamed()) {
            return false;
        }
        return super.supportBeautyButton();
    }

    @Override // com.oplus.camera.capmode.d_renamed
    public boolean isSuperNightShutterCountDownOpen() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_MODE_SHUTTER_COUNTDOWN_SUPPORT)) {
            return this.mbNightShutterCountDown;
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSendCapturePictureRequest() {
        super.onSendCapturePictureRequest();
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.s_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCancleCapturePictureRequest() {
        super.onCancleCapturePictureRequest();
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.t_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onProcessCapturePictureRequest() {
        super.onProcessCapturePictureRequest();
        com.oplus.camera.professional.n_renamed nVar = this.t_renamed;
        if (nVar != null) {
            nVar.u_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected void restoreAllViews(boolean z_renamed) {
        restoreAllViews(z_renamed, false, false);
    }
}
