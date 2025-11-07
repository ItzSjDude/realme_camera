package com.oplus.camera.h_renamed;

/* compiled from: FastVideoMode.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.camera.capmode.w_renamed {
    private static final int HYPER_LAPSE_RATE = 3;
    private static final int RECORDING_DEFAULT_MIN_TIME = 1000;
    private static final int RECORDING_MIN_TIME = 1500;
    private static final int RECORDING_MIN_TIME_RATIO = 15;
    private static final java.lang.String SPEED_VALUE_10X = "10";
    private static final java.lang.String SPEED_VALUE_120X = "120";
    private static final java.lang.String SPEED_VALUE_480X = "480";
    private static final java.lang.String SPEED_VALUE_60X = "60";
    private static final java.lang.String SPEED_VALUE_960X = "960";
    private static final java.lang.String SPEED_VALUE_DEFAULT = "10";
    private static final java.lang.String TAG = "FastVideoMode";
    private double mCaptureRate;
    private java.util.HashMap<java.lang.String, java.lang.String> mConfigs;
    private long mCurrentFrameTime;
    private float mRealVideoTimeRatio;
    private int mRecordingMinTime;
    private java.lang.String mSpeedValue;
    private java.lang.String mVideoSizeType;
    private boolean mbAfterInitCameraMode;
    private boolean mbHyperLapseOpen;

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public boolean getNeedReduceBitRate() {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFastVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean supportBinauralRecord() {
        return false;
    }

    public a_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.mSpeedValue = null;
        this.mVideoSizeType = "video_size_1080p";
        this.mConfigs = new java.util.HashMap<>();
        this.mCaptureRate = 10.0d;
        this.mCurrentFrameTime = -1L;
        this.mbHyperLapseOpen = false;
        this.mRecordingMinTime = RECORDING_MIN_TIME;
        this.mbAfterInitCameraMode = false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        enableVideoRecordingSound(true);
        if (isSupportNoneSatUltraWideSupport() && this.mCameraInterface != null && !this.mCameraInterface.at_renamed()) {
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
        }
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        super.onDestroy();
        java.util.HashMap<java.lang.String, java.lang.String> map = this.mConfigs;
        if (map != null) {
            map.clear();
            this.mConfigs = null;
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onInitCameraMode");
        super.onInitCameraMode();
        this.mOrientation = this.mCameraInterface.u_renamed();
        this.mSpeedValue = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_RATE, com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
        this.mbHyperLapseOpen = isHyperLapseOpen();
        this.mbAfterInitCameraMode = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        return super.needUploadOplusStatistics(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x00c5  */
    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.h_renamed.a_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onDeInitCameraMode");
        enableVideoRecordingSound(true);
        super.onDeInitCameraMode(str);
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
        hideHyperLapseView();
        hideTimeLapseSpeedHint();
    }

    private void hideTimeLapseSpeedHint() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_speed_desc_15x);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_speed_desc_60x);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_speed_desc_120x);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_speed_desc_480x);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_speed_desc_960x);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        this.mOrientation = i_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.h_renamed cameraInfo;
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBeforePreview");
        super.onBeforePreview();
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_BEAUTY)) {
            updateFaceBeautyLevel(0, false);
            if (this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.g_renamed(0);
            }
        }
        this.mbHyperLapseOpen = isHyperLapseOpen();
        setFastValueToParameter();
        enableVideoRecordingSound(false);
        setTiltShiftPreview();
        if (!this.mbHyperLapseOpen || !isHyperLapseUltraWideOpen() || (cameraInfo = getCameraInfo(this.mCameraId)) == null || this.mCameraInterface == null) {
            return;
        }
        float fAk = this.mCameraInterface.ak_renamed();
        if (cameraInfo.a_renamed(getZoomConfigure(), fAk)) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBeforePreview, hyper lapse ultra wide not support zoom value : " + fAk);
        this.mCameraInterface.c_renamed(cameraInfo.b_renamed(getZoomConfigure()));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        this.mbHyperLapseOpen = isHyperLapseOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData) {
            com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData2 = (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData2.mLux = java.lang.String.valueOf(this.mDcsLux);
            videoRecordMsgData = videoRecordMsgData2;
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNoneSatUltraWideAngleOpen() {
        if (this.mbHyperLapseOpen && isHyperLapseUltraWide() && this.mPreferences != null) {
            return this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true);
        }
        return super.isNoneSatUltraWideAngleOpen();
    }

    private void setFastValueToParameter() throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setFastValueToParameter, mSpeedValue: " + this.mSpeedValue);
        double d_renamed = java.lang.Double.parseDouble(this.mSpeedValue);
        this.mCaptureRate = 30.0d / d_renamed;
        this.mRealVideoTimeRatio = (float) (1.0d / d_renamed);
        this.mRecordingMinTime = (int) ((d_renamed * 15.0d) + 1000.0d);
        if (RECORDING_MIN_TIME > this.mRecordingMinTime) {
            this.mRecordingMinTime = RECORDING_MIN_TIME;
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        return isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public java.lang.Float getRealVideoTimeRatio() {
        float f_renamed = this.mRealVideoTimeRatio;
        com.oplus.camera.e_renamed.a_renamed(TAG, "getRealVideoTimeRatio, ratio: " + f_renamed);
        return java.lang.Float.valueOf(f_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getHyperLapseRate() {
        return this.mbHyperLapseOpen ? 3 : 0;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected java.lang.Double getRealCaptureRate() {
        return java.lang.Double.valueOf(this.mbHyperLapseOpen ? 0.0d : this.mCaptureRate);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected java.lang.Double getTimeLapseSpeed() {
        if (this.mbHyperLapseOpen) {
            return null;
        }
        return java.lang.Double.valueOf(java.lang.Double.parseDouble(this.mSpeedValue));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return 3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && !this.mbFrontCamera && isSatOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL);
        }
        if ("type_video_frame".equals(str)) {
            if (this.mbHyperLapseOpen) {
                return true;
            }
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        return "type_video".equals(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_RATE.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FAST_VIDEO_SIZE.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isNeedAudioEncode() {
        return !isVideoTimeLapseTiltShiftOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return this.mCameraInterface != null && this.mCameraInterface.i_renamed() && isVideoTimeLapseTiltShiftOpen();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) throws java.lang.NumberFormatException {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU.equals(str)) {
            this.mbHyperLapseOpen = "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_default_value)));
            if (isSupportNoneSatUltraWideSupport()) {
                sharedPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
            }
            if (this.mbHyperLapseOpen) {
                this.mCameraUIInterface.a_renamed(true, true, false);
                if (!this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tips_video_hyper_lapse_on, -1, true, false, false);
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_hint, 0, false, false, true, false, false);
                }
            } else {
                if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO.equals(getCameraMode())) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tips_video_hyper_lapse_off, -1, true, false, false);
                }
                hideHyperLapseView();
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                    this.mCameraInterface.an_renamed();
                }
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.av_renamed();
            }
            if (this.mbHyperLapseOpen && !this.mbPaused && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
                this.mCameraUIInterface.k_renamed(1);
                return;
            }
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_RATE.equals(str)) {
            this.mSpeedValue = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_RATE, com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
            updateTimeLapseSpeedHint(true, this.mSpeedValue);
            setFastValueToParameter();
        }
        if (isSupportNoneSatUltraWideSupport() && com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN.equals(str) && this.mCameraInterface != null && !isVideoRecording()) {
            this.mCameraInterface.au_renamed();
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO.equals(str)) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_hint, 0, false, false, true, false, false);
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateTimeLapseSpeedHint(boolean r11, java.lang.String r12) {
        /*
            r10 = this;
            int r1 = r12.hashCode()
            r2 = 1567(0x61f, float:2.196E-42)
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = -1
            if (r1 == r2) goto L4a
            r2 = 1722(0x6ba, float:2.413E-42)
            if (r1 == r2) goto L40
            r2 = 48687(0xbe2f, float:6.8225E-41)
            if (r1 == r2) goto L36
            r2 = 51756(0xca2c, float:7.2526E-41)
            if (r1 == r2) goto L2c
            r2 = 56499(0xdcb3, float:7.9172E-41)
            if (r1 == r2) goto L22
            goto L54
        L22:
            java.lang.String r1 = "960"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r4
            goto L55
        L2c:
            java.lang.String r1 = "480"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r5
            goto L55
        L36:
            java.lang.String r1 = "120"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r6
            goto L55
        L40:
            java.lang.String r1 = "60"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r7
            goto L55
        L4a:
            java.lang.String r1 = "10"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r3
            goto L55
        L54:
            r0 = r8
        L55:
            if (r0 == 0) goto L71
            if (r0 == r7) goto L6d
            if (r0 == r6) goto L69
            if (r0 == r5) goto L65
            if (r0 == r4) goto L61
        L5f:
            r5 = r8
            goto L75
        L61:
            r8 = 2131756145(0x7f100471, float:1.914319E38)
            goto L5f
        L65:
            r8 = 2131756143(0x7f10046f, float:1.9143185E38)
            goto L5f
        L69:
            r8 = 2131756141(0x7f10046d, float:1.9143181E38)
            goto L5f
        L6d:
            r8 = 2131756144(0x7f100470, float:1.9143187E38)
            goto L5f
        L71:
            r8 = 2131756142(0x7f10046e, float:1.9143183E38)
            goto L5f
        L75:
            if (r11 == 0) goto L93
            com.oplus.camera.ui.CameraUIInterface r0 = r10.mCameraUIInterface
            com.oplus.camera.ui.a_renamed.a_renamed r0 = r0.k_renamed()
            boolean r0 = r0.b_renamed()
            if (r0 != 0) goto L87
            boolean r0 = r10.mbAfterInitCameraMode
            if (r0 == 0) goto L93
        L87:
            com.oplus.camera.ui.CameraUIInterface r4 = r10.mCameraUIInterface
            r6 = -1
            r7 = 1
            r8 = 0
            r9 = 0
            r4.a_renamed(r5, r6, r7, r8, r9)
            r10.mbAfterInitCameraMode = r3
            goto L96
        L93:
            r10.hideTimeLapseSpeedHint()
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.h_renamed.a_renamed.updateTimeLapseSpeedHint(boolean, java.lang.String):void");
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        this.mSpeedValue = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_RATE, com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
        if (this.mbHyperLapseOpen && !this.mbFrontCamera && !this.mCameraUIInterface.R_renamed() && !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
            this.mCameraUIInterface.h_renamed(true);
            if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
                return;
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_hint, 0, false, false, true, true, false);
            return;
        }
        hideHyperLapseView();
        if (isHyperLapseUltraWide() && this.mbFrontCamera) {
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
        }
    }

    private void hideHyperLapseView() {
        this.mCameraUIInterface.h_renamed(false);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_hint);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getSurfaceSize(java.lang.String str, com.oplus.camera.e_renamed.h_renamed hVar) {
        if (this.mbHyperLapseOpen) {
            android.util.Size sizeFromConfig = getSizeFromConfig(getCameraFeature(), str, com.oplus.camera.capmode.BaseMode.a_renamed.INPUT);
            if (sizeFromConfig != null) {
                return sizeFromConfig;
            }
            com.oplus.camera.e_renamed.e_renamed(TAG, "getSurfaceSize, getVideoPipelineSize failed!");
        }
        return super.getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isQualcommEndOfStreamNeed() {
        if ((this.mbHyperLapseOpen && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_END_VIDEO_EIS_STREAM)) || !com.oplus.camera.util.Util.C_renamed()) {
            return false;
        }
        byte[] bArrK = this.mOneCamera.e_renamed().k_renamed();
        com.oplus.camera.e_renamed.a_renamed(TAG, "isQualcommEndOfStreamNeed, endOfStreamValue: " + bArrK);
        return bArrK != null && bArrK.length > 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        return (com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsPreview() && (needApsToProcessVideoWatermark() || this.mbHyperLapseOpen || (!this.mbFrontCamera && isSatOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL)))) ? false : true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getVideoSizeType() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FAST_VIDEO_SIZE)) {
            if (this.mPreferences instanceof com.oplus.camera.ComboPreferences) {
                return ((com.oplus.camera.ComboPreferences) this.mPreferences).a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FAST_VIDEO_SIZE, getDefaultVideoSize());
            }
            return this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FAST_VIDEO_SIZE, getDefaultVideoSize());
        }
        return this.mVideoSizeType;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        return getVideoFrameRate();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size videoPreviewSize = getVideoPreviewSize(getVideoSizeType());
        return videoPreviewSize != null ? videoPreviewSize : super.getPreviewSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        int i_renamed = (this.mbFrontCamera || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_FOVC)) ? 32780 : 33548;
        if (this.mbHyperLapseOpen) {
            i_renamed = 32933;
        }
        return (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) && isSloganOpen()) ? i_renamed | 1024 : i_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.c_renamed("button_shape_dial_rotate");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (isVideoFlashTorchOpen()) {
            this.mCameraUIInterface.a_renamed(false, true, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayAllIcon(boolean z_renamed, boolean z2) {
        if (isVideoFlashTorchOpen()) {
            return;
        }
        this.mCameraUIInterface.a_renamed(false, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFlashState() {
        return isVideoFlashTorchOpen();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() throws java.lang.NumberFormatException {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        }
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        if (!isHyperLapseOpen() && !isTiltShiftOpen()) {
            updateTimeLapseSpeedHint(false, this.mSpeedValue);
        }
        this.mSpeedValue = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_RATE, com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
        setFastValueToParameter();
        if (this.mOneCamera != null && !this.mbHyperLapseOpen && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_LOCK_AF_4_FPS)) {
            this.mOneCamera.n_renamed();
        }
        super.beforeStartRecording();
        if (this.mOneCamera != null) {
            if (!com.oplus.camera.util.Util.C_renamed() && this.mCameraInterface != null) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.u_renamed())));
            }
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public void onStopVideoRecording(boolean z_renamed) {
        super.onStopVideoRecording(z_renamed);
        if (this.mCameraInterface != null) {
            this.mCameraInterface.a_renamed(true, false);
        }
        this.mCurrentFrameTime = -1L;
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_dial_rotate", 1));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return this.mbHyperLapseOpen ? isHyperLapseUltraWideOpen() ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_HYPER_LAPSE_PRO : com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_HYPER_LAPSE : (isSatOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL)) ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_SAT_HAL : super.getCameraFeature();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(java.lang.String str) {
        if (isSatOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL)) {
            return false;
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.r_renamed(isHyperLapseOpen());
        zoomConfigure.c_renamed(isNoneSatUltraWideAngleOpen());
        if (isNoneSatUltraWideAngleOpen()) {
            zoomConfigure.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), com.oplus.camera.e_renamed.a_renamed.h_renamed()).e_renamed());
        }
        zoomConfigure.f_renamed(isSupportNoneSatUltraWideSupport());
        zoomConfigure.g_renamed(false);
        zoomConfigure.F_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT));
        float configFloatValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue) {
            zoomConfigure.b_renamed(configFloatValue);
        }
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected long getVideoTime() {
        double d_renamed;
        long j_renamed;
        if (this.mbHyperLapseOpen) {
            d_renamed = 10.0d;
            j_renamed = this.mRecordingTotalTime;
        } else {
            d_renamed = 30.0d / this.mCaptureRate;
            j_renamed = this.mRecordingTotalTime;
        }
        return (int) (j_renamed / d_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHyperLapseUltraWideOpen() {
        return isSupportNoneSatUltraWideSupport() && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true);
    }

    private boolean isSupportNoneSatUltraWideSupport() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) || (this.mbHyperLapseOpen && isHyperLapseUltraWide());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Range<java.lang.Integer> getVideoFpsRange() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_LOCK_AF_4_FPS)) {
            return android.util.Range.create(4, 30);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isHyperLapseOpen() {
        return !this.mbFrontCamera && this.mCameraInterface != null && this.mCameraInterface.i_renamed() && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_default_value)));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (isHyperLapseOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.HYPER_LAPSE, com.oplus.ocs.camera.CameraParameter.HyperLapse.HYPER_LAPSE);
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_FOVC_MODE, "off");
        } else {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.HYPER_LAPSE, "off");
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_FOVC_MODE, "on_renamed");
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean needShowVideoTime() {
        return !isHyperLapseOpen();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected int getRecordingMinTime(boolean z_renamed) {
        return (z_renamed || this.mbHyperLapseOpen) ? RECORDING_MIN_TIME : this.mRecordingMinTime;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        this.mCameraUIInterface.h_renamed(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        if (!this.mbHyperLapseOpen || this.mbFrontCamera || this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
            return;
        }
        this.mCameraUIInterface.h_renamed(true);
        if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_hint, 0, false, false, true, true, false);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void onInitializeRecorder(com.oplus.camera.capmode.x_renamed xVar) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super.onInitializeRecorder(xVar);
        if (com.oplus.camera.util.Util.C_renamed()) {
            xVar.d_renamed("set-video-mode=fastvideo");
        }
    }
}
