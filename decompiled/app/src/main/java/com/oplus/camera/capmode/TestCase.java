package com.oplus.camera.capmode;

/* compiled from: CommonVideoMode.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.camera.capmode.w_renamed {
    private boolean g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private int l_renamed;
    private int m_renamed;
    private com.oplus.camera.ui.menu.setting.CameraMenuOption n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private android.util.Range<java.lang.Integer> r_renamed;
    private android.util.Range<java.lang.Integer> s_renamed;
    private android.util.Range<java.lang.Integer> t_renamed;
    private android.util.Range<java.lang.Integer> u_renamed;
    private com.oplus.camera.util.a_renamed v_renamed;
    private int w_renamed;
    private java.lang.String x_renamed;
    private boolean y_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getBackUpFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FACEBEAUTY_LEVEL_MENU_BACKUP;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getEffectMenuKeyByMode() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return com.oplus.camera.R_renamed.string.camera_fuji_style;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getHDRKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(java.lang.String str) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCommonVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHFR() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public e_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = true;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = -1;
        this.m_renamed = 0;
        this.n_renamed = null;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = android.util.Range.create(120, 120);
        this.s_renamed = android.util.Range.create(60, 60);
        this.t_renamed = android.util.Range.create(30, 30);
        this.u_renamed = android.util.Range.create(20, 30);
        this.v_renamed = null;
        this.w_renamed = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        this.x_renamed = "";
        this.y_renamed = false;
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            this.v_renamed = new com.oplus.camera.util.a_renamed();
        }
        if (this.mPreviewEffectProcess != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU) || getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS)) {
                setVideoBlurEffect(isBlurOpen());
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getEnvironmentTipsThreshold() {
        if (this.mbFrontCamera) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD);
        }
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void showRecordingTimeUI() {
        super.showRecordingTimeUI();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setFocusingSoundVolume(int i_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.a_renamed(i_renamed, getZoomValue());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setVideoSoundValue(float f_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if ("all_around".equals(this.mPreferences.getString(f_renamed(), "all_around"))) {
            java.lang.String str = java.lang.Float.compare(f_renamed, 1.0f) != 0 ? "focusing" : com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA;
            if (this.mVideoRecorder != null) {
                this.mVideoRecorder.a_renamed(str);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setFocusTrackingState(boolean z_renamed) {
        if ("all_around".equals(this.mPreferences.getString(f_renamed(), "all_around")) && this.mVideoRecorder != null && isVideoRecordStarted() && com.oplus.camera.util.Util.F_renamed()) {
            this.mVideoRecorder.g_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setFocusTrackingLocation(float f_renamed, float f2) {
        if ("all_around".equals(this.mPreferences.getString(f_renamed(), "all_around")) && this.mVideoRecorder != null && isVideoRecordStarted() && com.oplus.camera.util.Util.F_renamed()) {
            this.mVideoRecorder.b_renamed(f_renamed, f2);
        }
    }

    private java.lang.String f_renamed() {
        return this.mbFrontCamera ? com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT : com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayFixedUpModeHint() {
        super.displayFixedUpModeHint();
        if (this.mActivity == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "displayFixedUpModeHint");
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isQualcommEndOfStreamNeed() {
        if ((isSuperEISOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_END_VIDEO_EIS_STREAM)) || !T_renamed() || !com.oplus.camera.util.Util.C_renamed()) {
            return false;
        }
        byte[] bArrK = this.mOneCamera.e_renamed().k_renamed();
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "isQualcommEndOfStreamNeed, endOfStreamValue: " + bArrK);
        return bArrK != null && bArrK.length > 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        int i_renamed;
        if (this.mbFrontCamera || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_FOVC)) {
            i_renamed = 32779;
        } else {
            i_renamed = 33547;
            if (com.oplus.camera.util.Util.C_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HIGH_FPS) && 60 == t_renamed()) {
                i_renamed = 32801;
            }
        }
        if (!com.oplus.camera.util.Util.C_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HIGH_FPS) && 60 == t_renamed()) {
            i_renamed = 32801;
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS)) {
            i_renamed = this.mbFrontCamera ? 32811 : 32808;
        }
        if (isVideoHdrOpen()) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
                i_renamed |= 1024;
            } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                i_renamed = 32929;
            }
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO) && !this.mbFrontCamera && isUltraNightVideoOpen()) {
            i_renamed = 32930;
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
            i_renamed = 32935;
        }
        return (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) && isSloganOpen()) ? i_renamed | 1024 : i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        readProfile();
        java.lang.String videoSizeType = getVideoSizeType();
        android.util.Size sizeFromConfig = getSizeFromConfig(getCameraFeature(), "type_main_preview_frame", com.oplus.camera.capmode.BaseMode.a_renamed.INPUT);
        return sizeFromConfig != null ? sizeFromConfig : getVideoPreviewSize(videoSizeType) != null ? getVideoPreviewSize(videoSizeType) : super.getPreviewSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSurfaceSize(android.util.Size size) {
        return (isVideoSuperEisWideOpen() || isRearSuperEISOpen()) ? com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_SURFACE_SIZE) : size;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_still_capture_jpeg".equals(str)) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                return false;
            }
            return !com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_still_capture_yuv_main".equals(str)) {
            return (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() || is4k() || (isVideo10BitOpen() && isVideoHdrOpen())) && (this.mCameraInterface.i_renamed() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREAM_SUPPORT_PREVERSION));
        }
        if ("type_video_frame".equals(str)) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS) && isRearSuperEISOpen() && com.oplus.camera.util.Util.C_renamed() && this.mCameraInterface.i_renamed()) {
                return true;
            }
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return 3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && isSatOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL);
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        super.onResume(z_renamed);
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, this.mCameraId));
        if (y_renamed() && !"video_size_1080p".equals(string)) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraInterface.c_renamed(false);
        }
        if (isNoneSatUltraWideAngleOpen() && !A_renamed() && !B_renamed()) {
            boolean z2 = !isAiEnhancementVideoOpen() && 60 == java.lang.Integer.parseInt(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS));
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NONE_SAT_ULTRA_WIDE_ANGLE_RESOLUTION_LIMIT);
            boolean z3 = configIntValue > 0 && configIntValue < getResolutionBySizeType(string);
            if ("video_size_4kuhd".equals(string) || z2 || z3 || a_renamed(string) || ("video_size_1080p".equals(string) && P_renamed())) {
                this.mCameraInterface.c_renamed(true);
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                this.mCameraInterface.c_renamed(false);
                this.mbFlashTemporaryDisabled = false;
            }
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
            p_renamed();
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO)) {
            q_renamed();
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            checkAiEnhancementVideoState();
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
            b_renamed();
        }
        if (isAiEnhancementVideoOpen() && R_renamed()) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
        }
        J_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void hideBubble(java.lang.String str) {
        if (!getCameraMode().equals(str) && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(7, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        super.onSwitchCameraButtonClick();
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(7, false);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        if (this.mPreferences != null && this.mPreferences.getBoolean("pref_camera_statement_key", false) && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(7, true);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.x_renamed = "";
        if (this.mPreferences != null) {
            if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off")) && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false)) {
                this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false).apply();
            }
            g_renamed();
        }
        this.l_renamed = -1;
    }

    private boolean b_renamed(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR.equals(str)) {
            return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(str)) {
            return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str)) {
            return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO);
        }
        return com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE.equals(str);
    }

    private void g_renamed() {
        if (!this.mCameraInterface.i_renamed() || isVideoRecording() || this.mPreferences == null || isDoubleExposureOpen()) {
            return;
        }
        boolean zI = i_renamed();
        boolean z_renamed = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false);
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "restoreSpecialEffectStatus, isAnySwitchOn: " + zI + ", isSavedStatus: " + z_renamed);
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (zI && !z_renamed) {
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, true);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, java.lang.String.valueOf(getVideoFps()));
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, getVideoSizeType());
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_CODEC, getVideoCodec());
            editorEdit.apply();
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "restoreSpecialEffectStatus, save status");
            return;
        }
        if (zI || !z_renamed) {
            return;
        }
        editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false).apply();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_CODEC, "");
        if (!"".equals(string)) {
            if (!android.text.TextUtils.equals(string, getVideoCodec())) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, string);
            }
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_CODEC, "");
            editorEdit.apply();
        }
        if (j_renamed()) {
            if (this.mCameraInterface.E_renamed()) {
                this.mCameraInterface.c_renamed(true);
            }
            java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
            java.lang.String string3 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, getDefaultVideoSize());
            boolean zA = a_renamed(string2, string3, this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(getVideoFps())), getVideoSizeType());
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "restoreSpecialEffectStatus, read status, videoSizeAndFpsSame: " + zA + ", VideoFps: " + string2 + ", VideoSize: " + string3);
            if (!zA) {
                if (!android.text.TextUtils.isEmpty(string2)) {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, string2);
                }
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, string3);
            }
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
            editorEdit.apply();
            if (this.mCameraInterface.E_renamed()) {
                this.mCameraInterface.c_renamed(false);
            }
            D_renamed();
        }
    }

    private void h_renamed() {
        if (isRearSuperEISOpen()) {
            this.mCameraInterface.c_renamed(true);
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            if (isBlurOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off");
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if (isFilterEffectOpen()) {
                E_renamed();
            }
            editorEdit.apply();
            this.mCameraInterface.c_renamed(false);
        }
    }

    private boolean a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return android.text.TextUtils.equals(str, str3) && android.text.TextUtils.equals(str2, str4);
    }

    private boolean i_renamed() {
        if (getCurrFilterIndex() != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, filter is_renamed open");
            return true;
        }
        if (isRearSuperEISOpen() || y_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, super EIS is_renamed open");
            return true;
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
            if (this.mbPaused && this.h_renamed && getFaceBeautyCurrIndex() == 0) {
                this.h_renamed = false;
            }
            if (this.h_renamed || getFaceBeautyCurrIndex() != 0) {
                com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, face beauty is_renamed open");
                return true;
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU)) {
            if ((!this.mCameraInterface.E_renamed() && this.mCameraUIInterface.O_renamed()) || this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false)) {
                com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, blur is_renamed open");
                return true;
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && isNoneSatUltraWideAngleOpen()) {
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, NoneSatUltraWideAngle is_renamed Open");
            return true;
        }
        if (isVideoHdrOpen()) {
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, 3hdr is_renamed open");
            return true;
        }
        if (isUltraNightVideoOpen()) {
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, night video is_renamed open.");
            return true;
        }
        if (!isAiEnhancementVideoOpen()) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkSpecialEffectSwitch, ai_renamed enhancement video is_renamed open.");
        return true;
    }

    private boolean j_renamed() {
        return ("".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, "")) || "".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, ""))) ? false : true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchToMode(boolean z_renamed) {
        super.beforeSwitchToMode(z_renamed);
        enableVideoRecordingSound(true);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        g_renamed();
        super.beforeSwitchCamera();
        if (this.mCameraUIInterface.T_renamed() && !this.i_renamed) {
            this.mCameraUIInterface.U_renamed();
        }
        if (y_renamed()) {
            this.mCameraUIInterface.M_renamed();
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_enhancement_video_hint_on);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_enhancement_video_hint_off);
        h_renamed();
        u_renamed();
        w_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        this.x_renamed = "";
        super.cameraIdChanged(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraIdChangedAnimationEnd() {
        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterNoneIndex() {
        return this.mbFrontCamera ? com.oplus.camera.ui.preview.a_renamed.j_renamed.t_renamed() : com.oplus.camera.ui.preview.a_renamed.j_renamed.r_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        super.setOrientation(i_renamed);
        if (3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && this.mCameraInterface.i_renamed() && this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(getJpegOrientation(this.mCameraId, this.mOrientation)));
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 95);
            this.mOneCamera.b_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_GPS_LOCATION, (android.hardware.camera2.CaptureRequest.Key) this.mCameraInterface.y_renamed());
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:60:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(boolean r12) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.e_renamed.a_renamed(boolean):void");
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.x_renamed = "";
        if (this.mPreferences instanceof com.oplus.camera.ComboPreferences) {
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT) && ((!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON)) && com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed.d_renamed.size() == com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed.f6904c.size())) {
                ((com.oplus.camera.ComboPreferences) this.mPreferences).c_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX);
            } else {
                ((com.oplus.camera.ComboPreferences) this.mPreferences).d_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX);
            }
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint);
        g_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        super.onDeInitCameraMode(str);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_fps_60);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void doAfterStartPreview() {
        super.doAfterStartPreview();
        if (this.mbPaused || this.mPreferences == null || !"on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"))) {
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_video_size_4KUHD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void disableRedDotHintOnModes() {
        if (androidx.preference.j_renamed.a_renamed(this.mActivity).getBoolean("video_mode_reddot_show", true)) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_mode_video);
            androidx.preference.j_renamed.a_renamed(this.mActivity).edit().putBoolean("video_mode_reddot_show", false).apply();
        }
    }

    private boolean k_renamed() {
        return isVideoNeonOpen() && !isFaceBeautyOrMakeupOpen();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.e_renamed.a_renamed(java.lang.String, java.lang.String):void");
    }

    private void b_renamed(java.lang.String str, java.lang.String str2) {
        int currFilterIndex = getCurrFilterIndex();
        java.lang.String filterType = getFilterType(currFilterIndex);
        boolean z_renamed = 60 == t_renamed() && !this.mbFrontCamera;
        boolean zEquals = "oplus_video_filter_portrait_retention".equals(filterType);
        boolean zEquals2 = "oplus_video_filter_neon".equals(filterType);
        if ("video_size_4kuhd".equals(str) || "video_size_8k".equals(str) || z_renamed || ((isUltraNightVideoOpen() && !zEquals) || y_renamed() || ((isAiEnhancementVideoOpen() && !zEquals && M_renamed()) || is10bitsHeicEncodeEnable() || ((isVideoHdrOpen() && currFilterIndex != getFilterNoneIndex()) || ((zEquals && !"video_size_720p".equals(str)) || (zEquals2 && ("video_size_4kuhd".equals(str) || ("video_size_1080p".equals(str) && !U_renamed())))))))) {
            g_renamed(false);
            currFilterIndex = getFilterNoneIndex();
            updateFilterParam(getFilterNoneIndex());
            this.mPreviewEffectProcess.l_renamed(false);
            this.mPreviewEffectProcess.m_renamed(false);
        } else {
            this.mPreviewEffectProcess.l_renamed(zEquals);
            this.mPreviewEffectProcess.m_renamed(zEquals2);
        }
        this.w_renamed = currFilterIndex;
    }

    private void c_renamed(java.lang.String str, java.lang.String str2) {
        if (d_renamed(str, str2)) {
            boolean zAA = this.mCameraInterface.aA_renamed();
            this.mCameraInterface.c_renamed(true);
            if (isVideoNeonOpen()) {
                g_renamed(false);
            } else {
                F_renamed();
            }
            this.mCameraInterface.c_renamed(zAA);
            boolean z_renamed = isFaceBeautyOrMakeupOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO);
            if ("video_size_4kuhd".equals(str) || "video_size_8k".equals(str) || 60 == java.lang.Integer.parseInt(str2) || (this.mHandler != null && "video_size_1080p".equals(str) && (!U_renamed() || z_renamed))) {
                this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$RHRPrx8S3p1xoEnpyhV_gc04HgQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.ae_renamed();
                    }
                });
            }
        }
        this.y_renamed = false;
        boolean z2 = isBlurOpen() || this.mCameraUIInterface.O_renamed();
        if (isVideoNeonOpen() && z2) {
            this.mCameraInterface.c_renamed(true);
            F_renamed();
            setVideoBlurEffect(false);
            if (this.mHandler != null) {
                this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$7P5GG-dmuxPNxGowCyLuZrfySVY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.ad_renamed();
                    }
                });
            }
        } else if (this.mPreviewEffectProcess != null) {
            setVideoBlurEffect(z2);
            if (z2) {
                this.mPreviewEffectProcess.b_renamed(getBlurValue());
            }
        }
        if (isBlurOpen() || isMakeupOpen() || this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0) == 0 || "oplus_video_filter_neon".equals(getCurrFilterType()) || o_renamed()) {
            return;
        }
        m_renamed();
        if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION, false)) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION);
            if (!isVideoRecording()) {
                editorEdit.putInt(getFaceBeautyKey(), 102);
                if (this.mPreviewEffectProcess != null) {
                    this.mPreviewEffectProcess.g_renamed(102);
                    this.mPreviewEffectProcess.a_renamed(getCustomBeautyValues());
                }
            }
            editorEdit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ae_renamed() {
        this.mCameraUIInterface.b_renamed(true, true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ad_renamed() {
        this.mCameraUIInterface.d_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, false);
    }

    private boolean d_renamed(java.lang.String str, java.lang.String str2) {
        return !this.y_renamed && ("video_size_4kuhd".equals(str) || "video_size_8k".equals(str) || isVideoHdrOpen() || isVideoRetentionOpen() || isUltraNightVideoOpen() || isAiEnhancementVideoOpen() || is10bitsHeicEncodeEnable() || (("video_size_1080p".equals(str) && (!U_renamed() || (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO) && isFaceBeautyOrMakeupOpen()))) || 60 == java.lang.Integer.parseInt(str2)));
    }

    private void c_renamed(java.lang.String str) {
        if (("video_size_4kuhd".equals(str) || isRearSuperEISOpen() || isFaceBeautyOrMakeupOpen() || isFilterEffectOpen() || isBlurOpen()) && !this.mbFrontCamera) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off").apply();
            S_renamed();
        }
    }

    private void l_renamed() {
        if (is10bitsHeicEncodeEnable()) {
            if (isCommonFaceBeautyOpen() || isFilterEffectOpen() || isBlurOpen() || isVideoNeonOpen() || is4k() || isSuperEISOpen()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off").apply();
                S_renamed();
                if (this.mCameraUIInterface != null) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint);
                }
                this.j_renamed = true;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onMakeupTypeChanged(int i_renamed, boolean z_renamed) {
        super.onMakeupTypeChanged(i_renamed, z_renamed);
        if (i_renamed != 0 && o_renamed()) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            if (z_renamed) {
                editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX);
            }
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU);
        }
        if (isMakeupOpen()) {
            android.content.SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
            editorEdit2.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
            if (com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(this.mbFrontCamera) == getCurrFilterIndex()) {
                onFilterItemChange(getFilterNoneIndex());
            }
            if ("video_size_1080p".equals(getVideoSizeType()) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MAKEUP_LOW_PERFORMANCE)) {
                editorEdit2.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_720p");
            }
            if (z_renamed) {
                editorEdit2.remove(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION);
            }
            editorEdit2.apply();
            if (isBlurOpen()) {
                I_renamed();
            }
        }
    }

    private void m_renamed() {
        int i_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
        if (i_renamed != 0) {
            this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX).apply();
            if (isVideoRecording()) {
                return;
            }
            this.mCameraUIInterface.u_renamed(i_renamed);
            com.oplus.camera.util.Util.c_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$NypIVyXfQqtaV0d7wYKVEWO2nwc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.ac_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ac_renamed() {
        this.mCameraInterface.av_renamed();
    }

    private void n_renamed() {
        if (isMakeupOpen()) {
            this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, getCurrMakeupIndex()).apply();
            super.onMakeupTypeChanged(0, false);
            this.mCameraUIInterface.u_renamed(0);
            this.mCameraInterface.av_renamed();
        }
    }

    private boolean o_renamed() {
        return isSuperEISOpen() && this.mbFrontCamera;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isRearSuperEISOpen() {
        return isSuperEISOpen() && !this.mbFrontCamera;
    }

    private void p_renamed() {
        if (!isVideoHdrOpen() || checkVideoHdrPreCondition()) {
            return;
        }
        this.mCameraInterface.c_renamed(true);
        this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
        this.mCameraInterface.c_renamed(false);
    }

    private void q_renamed() {
        if (!isUltraNightVideoOpen() || N_renamed()) {
            return;
        }
        this.mCameraInterface.c_renamed(true);
        this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
        this.mCameraInterface.c_renamed(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkAiEnhancementVideoState() {
        if (isAiEnhancementVideoOpen() && !O_renamed()) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
            this.mCameraInterface.c_renamed(false);
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$kYjIE-HADn5ZuZiVCfq_NcldSoE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.ab_renamed();
                }
            });
        }
        if (isAiEnhancementVideoOpen() && s_renamed()) {
            this.l_renamed = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ab_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
    }

    private void a_renamed(boolean z_renamed, boolean z2) {
        if (this.mActivity == null || this.mPreferences == null || this.mCameraInterface == null || !L_renamed() || isAiEnhancementVideoOpen() || !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHOULD_REOPEN_AI_ENHANCEMENT_VIDEO, false)) {
            return;
        }
        if ((z2 && !O_renamed()) || isBlurOpen() || isMakeupOpen()) {
            return;
        }
        if (isSuperEISOpen() && r_renamed()) {
            return;
        }
        if (isFilterEffectOpen() && M_renamed()) {
            return;
        }
        boolean zAA = this.mCameraInterface.aA_renamed();
        if (!z_renamed) {
            this.mCameraInterface.c_renamed(true);
        }
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE, null);
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        com.oplus.camera.e_renamed.b_renamed("CommonVideoMode", "checkReopenAiEnhancementVideo, reopen ai_renamed enhancement video, change video size to: " + string + ", oldForceChangeRecSize: " + zAA + ", isListenPreference: " + z_renamed);
        if (string != null) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, string);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE, null);
        }
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "on_renamed");
        editorEdit.apply();
        if (!z_renamed) {
            this.mCameraInterface.c_renamed(zAA);
        }
        if (g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE)) {
            return;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$yaZT1FNQDWUHmfyxxRfDU6qBnkg
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.aa_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
    }

    private boolean r_renamed() {
        return !this.mbFrontCamera;
    }

    private void e_renamed(java.lang.String str, java.lang.String str2) {
        if (this.mbFrontCamera) {
            if (!y_renamed() || "video_size_1080p".equals(str)) {
                return;
            }
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraInterface.c_renamed(false);
            return;
        }
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_FPS);
        boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS);
        boolean zIsSuperEISProOpen = isSuperEISProOpen();
        boolean zIsSuperEISOpen = isSuperEISOpen();
        if (!com.oplus.camera.util.Util.m_renamed(str) || ((zIsSuperEISProOpen && configBooleanValue && java.lang.Integer.parseInt(str2) != 60) || ((zIsSuperEISProOpen && !configBooleanValue && java.lang.Integer.parseInt(str2) == 60) || !(zIsSuperEISProOpen || !zIsSuperEISOpen || java.lang.Integer.parseInt(str2) == configIntValue)))) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
            this.mCameraInterface.c_renamed(false);
            if (zIsSuperEISProOpen) {
                com.oplus.camera.e_renamed.e_renamed("CommonVideoMode", "setSuperEisBeforePreview, reopen camera");
                this.mCameraInterface.W_renamed();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.e_renamed.c_renamed getCaptureRequestTag(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z_renamed);
        captureRequestTag.ac_renamed = !needSurface("type_still_capture_yuv_main") || (is4k() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FORCE_4k_VIDEO_SNAPSHOT_BY_APS));
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureCompleted(cameraCaptureResult, cVar);
        if (!cVar.ac_renamed || this.mCameraInterface == null) {
            return;
        }
        this.mCameraInterface.a_renamed(cameraCaptureResult.mIdentity, com.oplus.camera.util.Util.a_renamed(java.lang.System.currentTimeMillis()), false, false, false);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        com.oplus.camera.e_renamed.c_renamed("CommonVideoMode", "setConfigureParameter");
        if (!this.mbFrontCamera && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_FOVC)) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_FOVC_MODE, "on_renamed");
        }
        if (isUltraNightVideoOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_NIGHT_MODE, com.oplus.ocs.camera.CameraParameter.NightVideo.ULTRA_NIGHT_VIDEO);
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS)) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_STABILIZATION_MODE, this.mbFrontCamera ? com.oplus.ocs.camera.CameraParameter.VideoStabilizationMode.SUPER_STABILIZATION_FRONT : com.oplus.ocs.camera.CameraParameter.VideoStabilizationMode.SUPER_STABILIZATION);
        }
        if (isHighFps()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_FPS, com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_60);
        } else if (is4k120fps()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_FPS, com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_120);
        } else {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_FPS, com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_30);
        }
        builder.setVideoSize(new android.util.Size(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight));
        if (isVideo10BitOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_10BIT_ENABLE, "on_renamed");
        }
        if (isVideoHdrOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_3HDR_MODE, "on_renamed");
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.AI_NIGHT_VIDEO_MODE, 1);
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.BLUR_NOT_SUPPORT_EXPLORER) && isBlurOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_BLUR, "on_renamed");
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        if (this.mPreferences == null) {
            return;
        }
        if (!com.oplus.camera.util.Util.C_renamed()) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT) && this.mOneCamera != null) {
                this.mOneCamera.o_renamed(b_renamed(true) && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TRACK_FOCUS, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_face_rectify_default_value))));
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT) && this.mOneCamera != null) {
                this.mOneCamera.D_renamed(isVideoRetentionOpen());
            }
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS) && isBlurOpen() && this.mOneCamera != null) {
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_BLUR_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "on_renamed");
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS) && this.mOneCamera != null) {
            int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
            this.mOneCamera.h_renamed(faceBeautyCurrIndex);
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FACE_BEAUTY_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (faceBeautyCurrIndex == 0 ? "off" : "on_renamed"));
        }
        super.onBeforePreview();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkFunction() {
        com.oplus.camera.e_renamed.f_renamed("CommonVideoMode", "checkFunction");
        if (this.mCameraInterface.i_renamed()) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, this.mCameraId));
            java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkFunction, videoSizeType: " + string + ", videoFps: " + string2);
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS)) {
                c_renamed(string, string2);
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
                a_renamed(string, string2);
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
                b_renamed(string, string2);
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
                e_renamed(string, string2);
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
                p_renamed();
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO)) {
                q_renamed();
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen() && L_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onBeforePreview, ai_renamed enhancement on_renamed video size : " + string);
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_ON_VIDEO_SIZE, string).apply();
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
                c_renamed(string);
                b_renamed();
            }
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected int getVideoFrameRate() {
        if (is4k120fps()) {
            return 120;
        }
        return isHighFps() ? 60 : 30;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected java.lang.Double getRealCaptureRate() {
        if (is4k120fps()) {
            return java.lang.Double.valueOf(120.0d);
        }
        if (isHighFps()) {
            return java.lang.Double.valueOf(60.0d);
        }
        return java.lang.Double.valueOf(30.0d);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        android.view.View viewFindViewById;
        super.onAfterStartPreview(z_renamed);
        this.i_renamed = false;
        J_renamed();
        if (this.h_renamed && !this.mCameraUIInterface.K_renamed()) {
            this.mCameraUIInterface.u_renamed(true);
        }
        if (isOpenFrontTorch() && isBlurOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO)) {
            I_renamed();
        }
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode == null || !currentScreenMode.r_renamed()) {
            if (showBeautyButton()) {
                this.mCameraUIInterface.l_renamed(true, false);
            } else {
                this.mCameraUIInterface.k_renamed(true, false);
            }
            if (showMenuLeftButton()) {
                this.mCameraUIInterface.i_renamed(true, false);
            } else {
                this.mCameraUIInterface.h_renamed(true, false);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_TIPS) && !this.mbFrontCamera && isSuperEISOpen() && getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT)) {
                com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
                if (!isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE_TIPS) || (viewFindViewById = this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_anchor_view)) == null) {
                    return;
                }
                this.mCameraUIInterface.a_renamed(viewFindViewById, 19, getBubbleOffsetX(19), getBubbleOffsetY(19));
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        if (1 == i_renamed || 2 == i_renamed) {
            return;
        }
        showNextTip();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void showNextTip() {
        super.showNextTip();
        if (this.mCameraUIInterface == null || this.mCameraUIInterface.R_renamed() || this.mCameraUIInterface.S_renamed()) {
            return;
        }
        if (this.mPreferences != null && !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false)) {
            com.oplus.camera.e_renamed.f_renamed("CommonVideoMode", "showNextTip, return");
        } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.a_renamed((android.view.View) null, 7, getBubbleOffsetX(7), getBubbleOffsetY(7));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetX(int i_renamed) {
        int[] iArrA;
        if (7 == i_renamed && 1 == this.mCameraInterface.aU_renamed().j_renamed() && (iArrA = this.mCameraInterface.a_renamed(this.mActivity, 7)) != null) {
            return iArrA[0];
        }
        if (19 == i_renamed) {
            return this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.bubble_super_eis_wide_tip_tip_offset_x);
        }
        return 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetY(int i_renamed) {
        int[] iArrA;
        if (7 == i_renamed && 1 == this.mCameraInterface.aU_renamed().j_renamed() && (iArrA = this.mCameraInterface.a_renamed(this.mActivity, 7)) != null) {
            return iArrA[1];
        }
        if (19 == i_renamed) {
            return this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.bubble_super_eis_wide_tip_tip_offset_y);
        }
        return this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_menu_tip_offset_y);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z_renamed) {
        com.oplus.camera.ui.inverse.e_renamed.INS.setPositionRatio(this.mActivity, 0.87f, z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected float getHighBrightnessValue() {
        return com.oplus.camera.ui.inverse.e_renamed.INS.getVideoBrightness();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOpenFaceBeautyMenu(boolean z_renamed) {
        this.h_renamed = z_renamed;
    }

    private boolean s_renamed() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_AI_VIDEO_SCENE) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_FRONT_VIDEO) || 1 != this.mCameraId);
    }

    private synchronized void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Integer numValueOf = -1;
        if (com.oplus.camera.util.Util.C_renamed()) {
            float[] fArr = (float[]) captureResult.get(com.oplus.camera.e_renamed.b_renamed.V_renamed);
            float[] fArr2 = (float[]) captureResult.get(com.oplus.camera.e_renamed.b_renamed.bp_renamed);
            if (fArr != null && fArr.length > 0 && fArr2 != null && fArr2.length > 0) {
                numValueOf = isAiEnhancementVideoOpen() ? java.lang.Integer.valueOf(this.v_renamed.a_renamed(fArr[0], fArr2[0])) : java.lang.Integer.valueOf(this.v_renamed.b_renamed(fArr[0], fArr2[0]));
            }
        } else {
            this.m_renamed++;
            if (30 != this.m_renamed) {
                return;
            }
            this.m_renamed = 0;
            try {
                numValueOf = (java.lang.Integer) captureResult.get(com.oplus.camera.e_renamed.b_renamed.an_renamed);
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                return;
            }
        }
        if (numValueOf == null) {
            return;
        }
        if (isAiEnhancementVideoOpen()) {
            b_renamed(numValueOf.intValue());
        } else if (!isSuperEISOpen() && !isBlurOpen() && !isVideoFlashTorchOpen() && !isFilterEffectOpen() && !R_renamed()) {
            c_renamed(numValueOf.intValue());
        }
    }

    private void b_renamed(int i_renamed) {
        boolean zIsVideoRecording = isVideoRecording();
        boolean z_renamed = !this.o_renamed && zIsVideoRecording;
        this.o_renamed = zIsVideoRecording;
        if (z_renamed) {
            this.mAiEnhanceSceneChangeCount = 0;
            this.mAiEnhanceSceneStart = i_renamed;
        }
        if (this.o_renamed) {
            this.mAiEnhanceSceneEnd = i_renamed;
        }
        if (i_renamed == this.l_renamed && this.mCameraUIInterface.aU_renamed()) {
            return;
        }
        if (!z_renamed) {
            this.mAiEnhanceSceneChangeCount++;
        }
        this.l_renamed = i_renamed;
        if (i_renamed == 1) {
            this.mCameraInterface.e_renamed(26);
        } else if (i_renamed == 2) {
            this.mCameraInterface.e_renamed(12);
        } else {
            this.mCameraInterface.e_renamed(0);
        }
    }

    private void c_renamed(int i_renamed) {
        if (-1 == i_renamed) {
            return;
        }
        boolean zY = false;
        int i2 = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_GUIDE_REMINDER_TIMES, 0);
        if (i_renamed == 1) {
            zY = this.mCameraUIInterface.Y_renamed();
        } else if (i_renamed == 2) {
            zY = this.mCameraUIInterface.X_renamed();
        }
        if (i2 >= 3 || !zY) {
            return;
        }
        this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_GUIDE_REMINDER_TIMES, i2 + 1).apply();
        if (this.n_renamed == null) {
            this.n_renamed = this.mCameraUIInterface.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
        this.mHandler.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$rCkeR65Z_BZgQ08SL0xwqstoGeY
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.Z_renamed();
            }
        }, 170L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z_renamed() {
        this.n_renamed.y_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onReceivePreviewCaptureResult(android.hardware.camera2.CaptureResult captureResult) {
        super.onReceivePreviewCaptureResult(captureResult);
        boolean z_renamed = 10 < captureResult.getFrameNumber();
        if (!W_renamed() && z_renamed && s_renamed()) {
            a_renamed(captureResult);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed("CommonVideoMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        boolean z_renamed = 10 < cameraPreviewResult.getCaptureResult().getFrameNumber();
        if (z_renamed && s_renamed()) {
            a_renamed(cameraPreviewResult.getCaptureResult());
        }
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (z_renamed && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_EIS_PRO_LOW_LIGHT_HINT) && isVideoSuperEisWideOpen() && 1 == this.mFlashTrigger) {
            this.mCameraUIInterface.u_renamed();
        }
        int[] iArr = (int[]) com.oplus.camera.e_renamed.b_renamed.a_renamed(cameraPreviewResult.getCaptureResult(), com.oplus.camera.e_renamed.b_renamed.ar_renamed);
        if (iArr != null && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.b_renamed(iArr);
        }
        int[] iArr2 = (int[]) com.oplus.camera.e_renamed.b_renamed.a_renamed(cameraPreviewResult.getCaptureResult(), com.oplus.camera.e_renamed.b_renamed.as_renamed);
        if (iArr2 != null && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.c_renamed(iArr2);
        }
        if (isBlurOpen() || isVideoNeonOpen() || "oplus_video_filter_portrait_retention".equals(this.x_renamed)) {
            processFaceCount();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return this.mCameraInterface != null && this.mCameraInterface.i_renamed() && (isFilterEffectOpen() || isFaceBeautyOrMakeupOpen() || isBlurOpen() || isVideoRetentionOpen() || isVideoNeonOpen() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_DEFAULT_VIDEO_FRAME_RECORD) || (isNoneSatUltraWideAngleOpen() && (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_WIDE_ONLY_MEDIACODEC_SUPPORT) || (com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsPreview() && com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportPreviewAlgo(getCameraMode(), this.mCameraId, "preview", "preview_rectify")))));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        java.lang.String cameraFeature = getCameraFeature();
        if (cameraFeature == null) {
            cameraFeature = getCameraMode();
        }
        java.lang.String str = cameraFeature;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            if (isSloganOpen()) {
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
                    return !isUseMediaCodec();
                }
                return !needApsToProcessVideoWatermark();
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) {
                return (isRearSuperEISOpen() || isVideoSuperEisWideOpen()) ? false : true;
            }
            return true;
        }
        com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig previewConfig = com.oplus.camera.aps.util.AlgoSwitchConfig.getPreviewConfig(str, this.mCameraId, null, null, needApsToProcessVideoWatermark(), com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_SAT_HAL.equals(str) || com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_4KUHD.equals(str) || com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_LIVE_HDR.equals(str) || com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_ULTRA_NIGHT.equals(str) || (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON.equals(str) && 1 == this.mCameraId) || (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO.equals(str) && 1 == this.mCameraId), com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) && this.mCameraId == 0);
        com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig.Component component = previewConfig != null ? previewConfig.mComponentMap.get("video") : null;
        return previewConfig == null || component == null || !component.mbEnable;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.o_renamed((isUltraNightVideoOpen() || isAiEnhancementVideoOpen()) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE));
        zoomConfigure.F_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT));
        boolean z_renamed = zoomConfigure.g_renamed() && !isSuperEISOpen();
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_ULTAR_WIDE_VIDEO_4K_OR_60FPS) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT)) {
            z_renamed &= (!this.mCameraInterface.i_renamed() || isHighFps() || "video_size_4kuhd".equals(getVideoSizeType())) ? false : true;
        }
        zoomConfigure.f_renamed(z_renamed);
        zoomConfigure.H_renamed(getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE));
        if ("video_size_1080p".equals(getVideoSizeType()) && 30 == getVideoFps()) {
            zoomConfigure.b_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE));
        }
        zoomConfigure.I_renamed("video_size_8k".equals(getVideoSizeType()));
        zoomConfigure.E_renamed(isSuperEISOpen());
        zoomConfigure.D_renamed(isBlurOpen());
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        return super.needUploadOplusStatistics(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO) || getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) || getSupportSubMenu(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE) || getSupportSubMenu(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowFaceBeautyMenu() {
        if (this.mPreferences == null) {
            return false;
        }
        return this.mbFrontCamera || ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && "off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off")) && "off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off")));
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:149:0x023d  */
    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 2220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.e_renamed.getSupportFunction(java.lang.String):boolean");
    }

    private boolean b_renamed(boolean z_renamed) {
        return (this.mbFrontCamera || isBlurOpen() || isVideoNeonOpen() || isVideoRetentionOpen() || isSuperEISOpen() || this.mCameraInterface == null || (!z_renamed && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TRACK_FOCUS_ULTRA_WIDE_SUPPORT) && java.lang.Float.compare(this.mCameraInterface.ak_renamed(), 1.0f) < 0) || ((!z_renamed && java.lang.Float.compare(this.mCameraInterface.ak_renamed(), 1.1f) >= 0) || !this.mCameraInterface.i_renamed() || ((!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_4K_TRACK_FOCUS_SUPPORT) && is4k()) || ((!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_AI_ENHANCEMENT_TRACK_FOCUS_SUPPORT) && isAiEnhancementVideoOpen()) || ((!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_60FPS_TRACK_FOCUS_SUPPORT) && 60 == t_renamed()) || 120 == t_renamed() || e_renamed() || isUltraNightVideoOpen() || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)))))) ? false : true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD)) {
            return true;
        }
        if (R_renamed() && getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(strD)) {
                return false;
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_DISABLE_AI_ENHANCEMENT_VIDEO.equals(strD)) {
                return true;
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(strD)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        if (!com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(strD) || this.mCameraInterface == null || this.mCameraInterface.m_renamed()) {
            return super.getSupportMenu(strD);
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(str)) {
            if (this.mbFrontCamera) {
                return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS);
            }
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS);
        }
        return super.getSupportSubMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setVideoBlurOpen(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "setVideoBlurOpen, open: " + z_renamed);
        this.g_renamed = z_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getVideoOrientation(int i_renamed) {
        if (this.mbFrontCamera) {
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

    private int t_renamed() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        java.lang.String string = com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS;
        if (sharedPreferences != null) {
            string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        }
        return java.lang.Integer.valueOf(string).intValue();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HIGH_FPS)) {
            return t_renamed();
        }
        return java.lang.Integer.valueOf(com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS).intValue();
    }

    private void d_renamed(int i_renamed) {
        if (this.mPreviewEffectProcess == null || i_renamed == this.w_renamed) {
            return;
        }
        java.lang.String filterType = getFilterType(i_renamed);
        java.lang.String filterRedpotKey = getFilterRedpotKey(filterType);
        if (android.text.TextUtils.isEmpty(filterType)) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
        }
        if (filterRedpotKey != null) {
            this.mCameraUIInterface.l_renamed(i_renamed);
            androidx.preference.j_renamed.a_renamed(this.mActivity).edit().putBoolean(filterRedpotKey, false).apply();
        }
        if ((this.w_renamed != getFilterNoneIndex()) != (i_renamed != getFilterNoneIndex())) {
            g_renamed();
        }
        java.lang.String filterType2 = getFilterType(this.w_renamed);
        this.w_renamed = i_renamed;
        this.p_renamed = "oplus_video_filter_portrait_retention".equals(filterType) || "oplus_video_filter_portrait_retention".equals(filterType2);
        this.q_renamed = "oplus_video_filter_neon".equals(filterType) || "oplus_video_filter_neon".equals(filterType2);
        if (this.q_renamed && this.mCameraInterface != null && !isBlurOpen()) {
            this.mCameraInterface.aO_renamed();
        }
        if (this.p_renamed || this.q_renamed) {
            if ((this.p_renamed || ((getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA) && !isBlurOpen()) || (this.q_renamed && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P)))) && this.mCameraInterface != null) {
                this.mCameraInterface.av_renamed();
            } else {
                updateTrackEnable();
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
            if ("oplus_video_filter_portrait_retention".equals(filterType)) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_one_subject_hint);
                d_renamed(this.q_renamed);
            } else if ("oplus_video_filter_neon".equals(filterType)) {
                updateVideoBlurEnable(false, false);
                updateVideoNeonEnable(true, true);
                e_renamed(this.p_renamed);
            } else {
                updateVideoNeonEnable(true, false);
                c_renamed(this.p_renamed);
            }
        }
        this.x_renamed = filterType;
        this.mPreviewEffectProcess.l_renamed("oplus_video_filter_portrait_retention".equals(filterType));
        this.mPreviewEffectProcess.m_renamed("oplus_video_filter_neon".equals(filterType));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS.equals(str)) {
            return isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS);
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isVideoRetentionOpen() {
        return isFilterEffectOpen() && "oplus_video_filter_portrait_retention".equals(getCurrFilterType());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isVideoNeonOpen() {
        return isFilterEffectOpen() && "oplus_video_filter_neon".equals(getCurrFilterType());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isBlurOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS) && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isShowUltraWide() {
        if (isAiEnhancementVideoOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_ZOOM_SUPPORT)) {
            return false;
        }
        if (isBlurOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            return true;
        }
        if (isVideoNeonOpen()) {
            return false;
        }
        return !isBlurOpen() || e_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int i_renamed) {
        super.onFilterItemChange(i_renamed, a_renamed(i_renamed));
        d_renamed(i_renamed);
        boolean z_renamed = true;
        if (com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a != getCurrFilterIndex()) {
            if (isVideoHdrOpen()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR);
            }
            if (isRearSuperEISOpen() || y_renamed()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            }
            if (isUltraNightVideoOpen()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
            }
            if (isAiEnhancementVideoOpen() && M_renamed()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM) && isSuperEISOpen() && this.mbFrontCamera && isBlurOpen() && isFaceBeautyOrMakeupOpen()) {
                F_renamed();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            }
            java.lang.String videoSizeType = getVideoSizeType();
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
            boolean z2 = (java.lang.Integer.parseInt(string) == 60 || java.lang.Integer.parseInt(string) == 120) && !this.mbFrontCamera;
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onFilterItemChange, index: " + i_renamed + ", videoSizeType: " + videoSizeType + ", isHighFps: " + z2);
            boolean zEquals = "video_size_4kuhd".equals(videoSizeType);
            if ((com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) && zEquals && z2) || a_renamed(videoSizeType)) {
                this.mCameraInterface.c_renamed(true);
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                this.mCameraInterface.c_renamed(false);
            }
            if (z2 && getCurrFilterIndex() != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
                if (!zEquals && !e_renamed()) {
                    z_renamed = false;
                }
                f_renamed(z_renamed);
                D_renamed();
            }
            boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_30FPS_Filter);
            if (this.mCameraInterface.i_renamed()) {
                if (!((zEquals && !configBooleanValue) || z2 || e_renamed()) || getCurrFilterIndex() == com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
                    return;
                }
                if (zEquals || e_renamed()) {
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
                }
                G_renamed();
                return;
            }
            return;
        }
        u_renamed();
        a_renamed(!this.mCameraInterface.E_renamed(), x_renamed());
    }

    public boolean a_renamed(int i_renamed) {
        boolean z_renamed = java.lang.Integer.parseInt(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS)) == 60 && !this.mbFrontCamera;
        java.lang.String videoSizeType = getVideoSizeType();
        java.lang.String filterType = getFilterType(i_renamed);
        java.lang.String filterType2 = getFilterType(this.w_renamed);
        return (("oplus_video_filter_portrait_retention".equals(filterType) || "oplus_video_filter_portrait_retention".equals(filterType2)) || ((("oplus_video_filter_neon".equals(filterType) || "oplus_video_filter_neon".equals(filterType2)) && getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA) && !isBlurOpen()) || (i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a && (z_renamed || (this.mCameraInterface.i_renamed() && "video_size_4kuhd".equals(videoSizeType)))))) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_30FPS_Filter);
    }

    private void u_renamed() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) || !this.j_renamed || isFilterEffectOpen() || isBlurOpen() || isVideoNeonOpen() || v_renamed() || is4k() || isRearSuperEISOpen()) {
            return;
        }
        if (this.mCameraInterface.E_renamed()) {
            this.mCameraInterface.c_renamed(true);
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "on_renamed");
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "HEIF");
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265);
        editorEdit.apply();
        this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
        if (this.mCameraInterface.E_renamed()) {
            this.mCameraInterface.c_renamed(false);
        }
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "checkAndRestore10bit");
    }

    private boolean v_renamed() {
        return this.mCameraUIInterface.K_renamed() || isFaceBeautyOrMakeupOpen();
    }

    private void w_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && this.k_renamed && (C_renamed() || ((getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_SAT_SUPPORT)) || e_renamed()))) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
            this.mCameraInterface.c_renamed(false);
        }
        this.k_renamed = false;
    }

    private void c_renamed(boolean z_renamed) {
        boolean z2 = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
        if ((!i_renamed() || z_renamed) && z2) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_SIZE, getDefaultVideoSize());
            java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_FPS, java.lang.String.valueOf(getVideoFps()));
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
            if (!"".equals(string2)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, string2);
            }
            if (!"".equals(string)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, string);
            }
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_FPS, "");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_SIZE, "");
            editorEdit.apply();
        }
    }

    private void d_renamed(boolean z_renamed) {
        java.lang.String videoSizeType = getVideoSizeType();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        boolean zIsBlurOpen = isBlurOpen();
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (!"video_size_720p".equals(videoSizeType) || java.lang.Integer.parseInt(string) != 30) {
            if (!z_renamed && !zIsBlurOpen && !y_renamed() && !isSuperEISOpen()) {
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, true);
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_FPS, string);
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_SIZE, videoSizeType);
            }
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_720p");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30));
            editorEdit.apply();
            G_renamed();
        } else if (!z_renamed) {
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_FPS, "");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_SIZE, "");
            editorEdit.apply();
        }
        if (isNoneSatUltraWideAngleOpen()) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
        }
        if (zIsBlurOpen) {
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false).apply();
        }
        this.mCameraUIInterface.d_renamed(true, false);
    }

    private void e_renamed(boolean z_renamed) {
        java.lang.String videoSizeType = getVideoSizeType();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        boolean zIsBlurOpen = isBlurOpen();
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        java.lang.String str = "video_size_720p";
        if (java.lang.Integer.parseInt(string) != 30 || "video_size_4kuhd".equals(videoSizeType) || ("video_size_1080p".equals(videoSizeType) && !U_renamed())) {
            if (!z_renamed && !zIsBlurOpen && !isSuperEISOpen()) {
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, true);
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_FPS, string);
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_SIZE, videoSizeType);
            }
            if (!"video_size_720p".equals(videoSizeType) && U_renamed()) {
                str = "video_size_1080p";
            }
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, str);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30));
            editorEdit.apply();
            G_renamed();
        } else if (!z_renamed) {
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_FPS, "");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_SIZE, "");
            editorEdit.apply();
        } else if (U_renamed() && !"video_size_720p".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_OLD_VIDEO_SIZE, getDefaultVideoSize()))) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
            editorEdit.apply();
        }
        if (zIsBlurOpen) {
            this.mCameraInterface.c_renamed(true);
            F_renamed();
            this.mCameraInterface.c_renamed(false);
            setVideoBlurEffect(false);
            this.mCameraUIInterface.d_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, false);
        }
        n_renamed();
        this.mbFlashTemporaryDisabled = false;
        a_renamed(getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSuperEISChange() {
        boolean z_renamed;
        boolean z2;
        boolean z3;
        boolean z4;
        int i_renamed;
        java.lang.String string;
        boolean z5;
        boolean zIsSuperEISOpen = isSuperEISOpen();
        boolean z6 = this.mbFrontCamera;
        boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE);
        java.lang.String videoSizeType = getVideoSizeType();
        java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        int configIntValue = y_renamed() ? 30 : com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_FPS);
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onSuperEISChange, isOpen: " + zIsSuperEISOpen + ", videoSizeType: " + videoSizeType + ", isHighFps: " + (java.lang.Integer.valueOf(string2).intValue() == 60 && !this.mbFrontCamera) + ", videoEisFps: " + configIntValue);
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        this.mCameraInterface.c_renamed(true);
        if (!zIsSuperEISOpen && !this.h_renamed && !isBlurOpen() && !isVideoRetentionOpen()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
        }
        if (!zIsSuperEISOpen) {
            z_renamed = zIsSuperEISOpen;
            z2 = z6;
            z3 = false;
        } else if (z6 && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_SUPER_EIS_AND_AI_VIDEO_ENHANCE_COEXIST) && getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            z_renamed = zIsSuperEISOpen;
            z2 = z6;
            z3 = false;
        } else if (z6) {
            z_renamed = zIsSuperEISOpen;
            z2 = z6;
            if (configBooleanValue) {
                if (isBlurOpen()) {
                    F_renamed();
                }
                if (isFaceBeautyOrMakeupOpen()) {
                    editorEdit.putInt(getFaceBeautyKey(), 0);
                }
                if (isFilterEffectOpen()) {
                    E_renamed();
                }
                if (!"video_size_1080p".equals(videoSizeType)) {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, videoSizeType);
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                }
                editorEdit.apply();
            } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM) && isBlurOpen() && isFilterEffectOpen() && isFaceBeautyOrMakeupOpen()) {
                F_renamed();
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_one_subject_hint);
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
                this.mCameraUIInterface.b_renamed(true, false, true, false);
                E_renamed();
            } else if (z2 && 30 != java.lang.Integer.valueOf(string2).intValue()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30)).apply();
                z3 = true;
            }
            z3 = false;
        } else {
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR) && isVideoHdrOpen()) {
                z_renamed = zIsSuperEISOpen;
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR);
            } else {
                z_renamed = zIsSuperEISOpen;
            }
            if (isBlurOpen()) {
                F_renamed();
                z2 = z6;
                this.mCameraUIInterface.b_renamed(true, true, true, false);
                this.mCameraUIInterface.l_renamed(true, true);
            } else {
                z2 = z6;
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO) && isUltraNightVideoOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            }
            if (isFilterEffectOpen()) {
                E_renamed();
            }
            if (com.oplus.camera.util.Util.m_renamed(videoSizeType)) {
                z5 = false;
            } else {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                z5 = true;
            }
            if (java.lang.Integer.valueOf(string2).intValue() != configIntValue) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(configIntValue));
                z3 = true;
            } else {
                z3 = z5;
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT));
            }
            editorEdit.apply();
        }
        if (configBooleanValue && z2 && !z_renamed && (string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, null)) != null && !string.isEmpty() && !string.equals(videoSizeType)) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, string).apply();
        }
        this.mCameraInterface.c_renamed(false);
        if (z_renamed) {
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_CHANGE_EIS, false).apply();
            if (!z2) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                if (this.mCameraUIInterface.A_renamed() && com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                    this.mCameraUIInterface.s_renamed(true);
                    this.mCameraInterface.a_renamed(true, false);
                    this.mCameraInterface.d_renamed(true);
                } else {
                    this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU);
                }
                if (this.mCameraUIInterface.K_renamed()) {
                    i_renamed = 0;
                    this.mCameraUIInterface.a_renamed(true, true, true, false);
                } else {
                    i_renamed = 0;
                }
                if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
                    this.mCameraUIInterface.M_renamed();
                }
                this.mCameraUIInterface.j_renamed(i_renamed);
                java.lang.String string3 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off");
                if (isVideoSuperEisWideOpen() && !"off".equals(string3) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").apply();
                }
            } else if (configBooleanValue) {
                this.mCameraUIInterface.M_renamed();
                this.mCameraUIInterface.j_renamed(0);
                if (this.mCameraUIInterface.O_renamed()) {
                    z4 = true;
                    this.mCameraUIInterface.b_renamed(true, false, true, false);
                } else {
                    z4 = true;
                }
                if (this.mCameraUIInterface.K_renamed()) {
                    this.mCameraUIInterface.a_renamed(z4, z4, z4, false);
                }
                if (this.mCameraUIInterface.A_renamed() && com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                    this.mCameraUIInterface.s_renamed(z4);
                }
            }
        } else {
            this.mCameraUIInterface.N_renamed();
            if (!this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_CHANGE_EIS, true) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                this.mCameraInterface.an_renamed();
            }
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_CHANGE_EIS, false).apply();
        }
        if (z3) {
            G_renamed();
        }
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
            this.mCameraUIInterface.q_renamed();
        }
        if (z_renamed || !g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
            return;
        }
        a_renamed(false, x_renamed());
    }

    private boolean x_renamed() {
        return this.mPreferences != null && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoSuperEisWideOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) && this.mPreferences != null && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
    }

    private boolean y_renamed() {
        return java.lang.Boolean.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE)).booleanValue() && this.mbFrontCamera && isSuperEISOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Range<java.lang.Integer> getVideoFpsRange() {
        int[] iArrB;
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HIGH_FPS) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE)) {
            return null;
        }
        if (is4k120fps()) {
            return this.r_renamed;
        }
        if (isHighFps()) {
            if (isRearSuperEISOpen() && (iArrB = this.mOneCamera.e_renamed().b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.z_renamed)) != null && iArrB.length >= 2) {
                return android.util.Range.create(java.lang.Integer.valueOf(iArrB[0]), java.lang.Integer.valueOf(iArrB[1]));
            }
            return this.s_renamed;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE) && (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FIXED_FPS_IN_4K) || !is4k())) {
            return this.u_renamed;
        }
        return this.t_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFrontDefaultCommonBeautyValue() {
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_FRONT_FACE_BEAUTY_LEVEL);
        return configIntValue >= 0 ? configIntValue : super.getFrontDefaultCommonBeautyValue();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getMakeupKeys() {
        return getCurrentKeys(com.oplus.camera.ui.preview.a_renamed.g_renamed.e_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getMakeupTypeKey() {
        return com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType) ? com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_VIDEO_MAKEUP_TYPE, this.mCameraEntryType) : com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_VIDEO_MAKEUP_TYPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemChange(int i_renamed) {
        int faceBeautyCurrIndex;
        if (this.mbPaused || (faceBeautyCurrIndex = getFaceBeautyCurrIndex()) == i_renamed || this.mCameraInterface.g_renamed() != 1 || isVideoRecording()) {
            return;
        }
        if (faceBeautyCurrIndex != 0) {
            this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION).apply();
        }
        super.onFaceBeautyItemChange(i_renamed);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:81:0x01de  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFaceBeautyMenuClick() {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.e_renamed.onFaceBeautyMenuClick():boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyMenuClose() {
        u_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        return isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getTrackHalAlgoSize() {
        return getSurfaceSize("type_video_frame", this.mOneCamera.e_renamed());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateFilterParam(int i_renamed) {
        if (isVividEffectOpen() && i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
            forceCloseVividEffect();
        }
        h_renamed(getFilterType(i_renamed));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean exclusiveInverse() {
        return isBlurOpen();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        beforeStartRecording(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_ring_none", 1);
        bVar.b_renamed(z_renamed);
        this.mCameraUIInterface.a_renamed(bVar);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INERTIAL_ZOOM)) {
            this.mCameraInterface.ab_renamed();
            if (!e_renamed()) {
                this.mCameraInterface.j_renamed(true);
            }
        } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
            this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        }
        super.beforeStartRecording();
        if (this.mOneCamera != null) {
            if (this.mCameraInterface != null) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.u_renamed())));
            }
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        V_renamed();
        super.beforeStartRecording(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        super.afterStartRecording();
        if (z_renamed()) {
            this.mHandler.removeMessages(11);
            this.mHandler.sendEmptyMessageDelayed(11, 300000L);
        }
        if (com.oplus.camera.util.Util.C_renamed() && isVideoSuperEisWideOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_AF_AUTO_LOCK)) {
            this.mOneCamera.a_renamed(1, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), false);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    private boolean z_renamed() {
        return isSuperEISOpen() || isBlurOpen() || isVideoRetentionOpen() || isVideoNeonOpen();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void onStopVideoRecording(boolean z_renamed) {
        if (!isDoubleExposureOpen() && !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_QUICK_VIDEO)) {
            this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_ring_none", 1));
        }
        if (z_renamed()) {
            this.mHandler.removeMessages(11);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INERTIAL_ZOOM)) {
            this.mCameraInterface.k_renamed(true);
            if (!this.mCameraUIInterface.h_renamed()) {
                this.mCameraInterface.aa_renamed();
            }
        } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
            this.mCameraInterface.a_renamed(true, false);
        }
        super.onStopVideoRecording(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getHeicCodecFormat() {
        if (this.mPreferences != null && this.mCameraInterface.i_renamed() && !isUltraNightVideoOpen() && !this.mbFrontCamera) {
            if (is10bitsHeicEncodeEnable()) {
                return "heic_10bits";
            }
            com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "getHeicCodecFormat return null");
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (is4k60fps()) {
            this.mCameraInterface.k_renamed(false);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_AF_AUTO_LOCK)) {
            this.mOneCamera.a_renamed(3, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean check3HDRPreCondition() {
        return "video_size_1080p".equals(getVideoSizeType()) && 30 == t_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (isVideoHdrOpen() && checkVideoHdrPreCondition() && isVideoRecordStopped()) {
            this.mCameraUIInterface.a_renamed(false, true, true);
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
            return;
        }
        if (isUltraNightVideoOpen() && isVideoRecordStopped() && check3HDRPreCondition()) {
            this.mCameraUIInterface.a_renamed(false, true, true);
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_ultra_video_night, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
            return;
        }
        if (is10bitsHeicEncodeEnable()) {
            this.mCameraUIInterface.a_renamed(false, true, true);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ultra_video_night);
            if (isVideoRecordStarted()) {
                return;
            }
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
            return;
        }
        this.mCameraUIInterface.a_renamed(false, true, true);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ultra_video_night);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayAllIcon(boolean z_renamed, boolean z2) {
        if (isVideoFlashTorchOpen() || isVideoHdrOpen() || com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
            return;
        }
        this.mCameraUIInterface.a_renamed(false, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFlashState() {
        return isVideoFlashTorchOpen();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public java.lang.String getDefaultVideoSize() {
        return com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, this.mCameraId);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoHighFps() {
        return isHighFps();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onEffectMenuPopDown");
        if (!z_renamed) {
            D_renamed();
        }
        g_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemValueChange(int i_renamed, int i2, boolean z_renamed) {
        super.onFaceBeautyItemValueChange(i_renamed, i2, z_renamed);
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onFaceBeautyItemValueChange");
        D_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isHighFps() {
        if ((1 == this.mCameraId && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS)) || 30 == t_renamed()) {
            return false;
        }
        java.lang.String videoSizeType = getVideoSizeType();
        if ((!"video_size_720p".equals(videoSizeType) || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS)) && ((!"video_size_1080p".equals(videoSizeType) || (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS))) && (!"video_size_4kuhd".equals(videoSizeType) || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS)))) {
            return false;
        }
        boolean z_renamed = 60 == t_renamed();
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "isHighFps, isHighFps: " + z_renamed);
        return z_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean is4k120fps() {
        return 1 != this.mCameraId && "video_size_4kuhd".equals(getVideoSizeType()) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS) && 120 == t_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean is4k60fps() {
        return isHighFps() && is4k();
    }

    private boolean A_renamed() {
        return is4k60fps() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"));
    }

    private boolean B_renamed() {
        return e_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_8K_30FPS_ULTRA_WIDE) && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"));
    }

    private boolean C_renamed() {
        return is4k60fps() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE);
    }

    private void D_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onHighFpsStateChange");
        if (this.mCameraUIInterface != null && isHighFps() && !isSuperEISOpen() && !this.mCameraUIInterface.R_renamed() && this.mCameraUIInterface.W_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_fps_60, -1, true, false, false);
        } else {
            if (this.mCameraUIInterface == null || isHighFps()) {
                return;
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_fps_60);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void switchVideoBlur(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "switchVideoBlur, isOpen: " + z_renamed + ", changeByClick: " + z2);
        if (!z_renamed) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
            if (this.mCameraUIInterface.O_renamed()) {
                this.mCameraUIInterface.b_renamed(true, false, true, false);
            }
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            if (z_renamed && this.mCameraInterface.a_renamed(getZoomValue())) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
            } else if (!z_renamed) {
                if (isNoneSatUltraWideAngleOpen()) {
                    this.mCameraInterface.an_renamed();
                }
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
        }
        a_renamed(true, com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, z_renamed).apply();
        a_renamed(false, (java.lang.String) null);
        boolean zIsVideoNeonOpen = isVideoNeonOpen();
        if (z_renamed && (isVideoRetentionOpen() || zIsVideoNeonOpen)) {
            E_renamed();
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
            if (z_renamed) {
                this.mbFlashTemporaryDisabled = false;
                a_renamed(true);
            }
            if (zIsVideoNeonOpen) {
                setVideoBlurEffect(z_renamed);
            }
        } else {
            if (z_renamed) {
                this.mbFlashTemporaryDisabled = false;
                a_renamed(false);
            }
            setVideoBlurEffect(z_renamed);
            if (z_renamed && this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.b_renamed(getBlurValue());
            }
        }
        if (z_renamed) {
            updateVideoNeonEnable(false, false);
        }
        updateVideoBlurEnable(true, z_renamed);
    }

    private void f_renamed(boolean z_renamed) {
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        com.oplus.camera.e_renamed.b_renamed("CommonVideoMode", "setFpsToDefault, nowVideoFPS: " + string + ", executeBeforePreview: " + z_renamed);
        if (android.text.TextUtils.equals(string, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS)) {
            return;
        }
        if (z_renamed) {
            this.mCameraInterface.c_renamed(true);
        }
        this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS).apply();
        if (z_renamed) {
            this.mCameraInterface.c_renamed(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperEISProOpen() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU) || this.mPreferences == null) {
            return false;
        }
        return this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isSuperEISOpen() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU) || this.mPreferences == null) {
            return false;
        }
        return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSatOpen() {
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA) || isBlurOpen() || isVideoNeonOpen() || isVideoRetentionOpen() || isSuperEISOpen()) {
            return false;
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR_SAT) && isVideoHdrOpen() && checkVideoHdrPreCondition()) {
            return false;
        }
        if (isUltraNightVideoOpen() && N_renamed()) {
            return false;
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_SAT_SUPPORT) && isAiEnhancementVideoOpen() && N_renamed()) {
            return false;
        }
        java.lang.String videoSizeType = getVideoSizeType();
        boolean z_renamed = java.lang.Integer.parseInt(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS)) == 60 && !this.mbFrontCamera;
        if ((com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SAT_MASK) & 1) == 0 && z_renamed) {
            return false;
        }
        if ((com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SAT_MASK) & 2) == 0 && "video_size_4kuhd".equals(videoSizeType)) {
            return false;
        }
        if ((com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SAT_MASK) & 4) == 0 && z_renamed && "video_size_4kuhd".equals(videoSizeType)) {
            return false;
        }
        return ((com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SAT_MASK) & 16) == 0 && "video_size_8k".equals(videoSizeType)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUltraWideAngleOpened() {
        if (isSuperEISOpen()) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraInterface.c_renamed(false);
        }
        if (isVideoHdrOpen()) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
            this.mCameraInterface.c_renamed(false);
        }
        if (isBlurOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            this.mCameraInterface.c_renamed(true);
            F_renamed();
            this.mCameraInterface.c_renamed(false);
        }
        if (isVideoRetentionOpen() || isVideoNeonOpen()) {
            this.mCameraInterface.c_renamed(true);
            E_renamed();
            this.mCameraInterface.c_renamed(false);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_ZOOM_SUPPORT) && isAiEnhancementVideoOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE)) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
            this.mCameraInterface.c_renamed(false);
        }
        java.lang.String videoSizeType = getVideoSizeType();
        boolean z_renamed = java.lang.Integer.parseInt(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS)) == 60 && !this.mbFrontCamera;
        boolean zP = P_renamed();
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onUltraWideAngleOpened, videoSizeType: " + videoSizeType + ", isHighFps: " + z_renamed + ", isWideVideoOnly720P: " + zP);
        if ((com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) && "video_size_4kuhd".equals(videoSizeType) && z_renamed) || a_renamed(videoSizeType)) {
            return;
        }
        if ("video_size_4kuhd".equals(videoSizeType) || ("video_size_1080p".equals(videoSizeType) && zP)) {
            this.mCameraInterface.c_renamed(true);
            if (zP) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_720p").apply();
            } else {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
            }
            this.mCameraInterface.c_renamed(false);
        }
        if (!z_renamed || isAiEnhancementVideoOpen()) {
            return;
        }
        f_renamed(true);
        D_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) && this.mCameraUIInterface.ae_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU, true, (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterRedpotKey(java.lang.String str) {
        if ("oplus_video_filter_neon".equals(str) && androidx.preference.j_renamed.a_renamed(this.mActivity).getBoolean("video_filter_neon_show", true)) {
            return "video_filter_neon_show";
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        if (this.mCameraUIInterface.ae_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU, false, (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_y));
            androidx.preference.j_renamed.a_renamed(this.mActivity).edit().putBoolean("video_filter_reddot_show", false).apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFilterOpen(java.lang.String str) {
        return ("oplus_video_filter_portrait_retention".equals(str) || "oplus_video_filter_neon".equals(str) || !super.isFilterOpen(str)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (!isNoneSatUltraWideAngleOpen()) {
            return -1;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || java.lang.Float.compare(this.mOneCamera.e_renamed().n_renamed(), 0.0f) == 0) {
            return com.oplus.camera.R_renamed.string.toast_ultra_wide_angel_lens;
        }
        if (isAiEnhancementVideoOpen() || isSuperEISOpen()) {
            return -1;
        }
        return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.toast_ultra_wide_micro_lens);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResumeFromSetting() {
        super.onResumeFromSetting();
        if (!is10bitsHeicEncodeEnable() && !isFilterEffectOpen() && !isBlurOpen() && !isFaceBeautyOrMakeupOpen() && !is4k() && !isSuperEISOpen()) {
            this.j_renamed = false;
        } else if (is10bitsHeicEncodeEnable()) {
            this.j_renamed = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuCollapse() {
        if (this.mCameraInterface.i_renamed() && this.mbCapModeInit && this.mbModePreInit) {
            D_renamed();
            if (is4k()) {
                com.oplus.camera.util.Util.e_renamed(this.mActivity, "camera_mode_changed");
            }
        }
    }

    private void E_renamed() {
        g_renamed(true);
    }

    private void g_renamed(boolean z_renamed) {
        boolean z2 = isVideoNeonOpen() || isVideoRetentionOpen();
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getFilterEffectMenuPreferenceKey(), getFilterNoneIndex());
        editorEdit.apply();
        this.w_renamed = getFilterNoneIndex();
        this.mPreviewEffectProcess.l_renamed(false);
        this.mPreviewEffectProcess.m_renamed(false);
        if (z2 && this.mCameraInterface != null) {
            this.mCameraInterface.aO_renamed();
        }
        if (this.mHandler == null || !z_renamed) {
            return;
        }
        this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$oXjXFYFTGkKnkaoBTBphO8jVpaE
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.Y_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y_renamed() {
        this.mCameraUIInterface.c_renamed(getFilterCurrName(), getFilterNoneIndex());
        this.mCameraUIInterface.a_renamed(this.mCameraUIInterface.A_renamed(), getEffectMenuKeyByMode());
    }

    private void F_renamed() {
        com.oplus.camera.e_renamed.c_renamed("CommonVideoMode", "resetCurrentVideoBlurPreference");
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void switchSuperEISWide(boolean z_renamed) {
        if (z_renamed) {
            this.mCameraUIInterface.f_renamed(19, true);
        }
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, z_renamed).apply();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off");
        if (z_renamed && !"off".equals(string) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            this.mCameraUIInterface.a_renamed(false, true, true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").apply();
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS) && 60 == com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_FPS)) {
            boolean z2 = java.lang.Integer.parseInt(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS)) == 60;
            if (z_renamed && z2) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30)).apply();
                G_renamed();
            } else if (!z_renamed && !z2) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(60)).apply();
            }
        }
        this.mCameraUIInterface.M_renamed();
    }

    private java.lang.String d_renamed(java.lang.String str) {
        if ("video_size_8k".equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_size_8k);
        }
        if ("video_size_4kuhd".equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_size_4kuhd);
        }
        if ("video_size_1080p".equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_size_1080p);
        }
        if ("video_size_720p".equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_size_720p);
        }
        return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_size_1080p);
    }

    private java.lang.String e_renamed(java.lang.String str) {
        if (java.lang.String.valueOf(120).equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_fps_120_fps);
        }
        if (java.lang.String.valueOf(60).equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_fps_60_fps);
        }
        if (java.lang.String.valueOf(30).equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_fps_30_fps);
        }
        if (java.lang.String.valueOf(24).equals(str)) {
            return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_fps_24_fps);
        }
        return com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_fps_30_fps);
    }

    private void G_renamed() {
        java.lang.String videoSizeType = getVideoSizeType();
        java.lang.String strValueOf = this.mbFrontCamera ? java.lang.String.valueOf(30) : this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_video_low_ambient_light_hint);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60, 2800, d_renamed(videoSizeType), e_renamed(strValueOf));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            boolean zEquals = "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
            if (!zEquals) {
                if (sharedPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) {
                    l_renamed();
                    sharedPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
                } else if (this.mbFrontCamera && !isBlurOpen() && com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(this.mbFrontCamera) != getCurrFilterIndex()) {
                    int i_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
                    com.oplus.camera.e_renamed.c_renamed("CommonVideoMode", "onSharedPreferenceChanged, lastMakeupIndex: " + i_renamed);
                    if (i_renamed != 0) {
                        this.mCameraUIInterface.u_renamed(i_renamed);
                        this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX).apply();
                    }
                }
            } else if (o_renamed() && isMakeupOpen()) {
                int currMakeupIndex = getCurrMakeupIndex();
                com.oplus.camera.e_renamed.c_renamed("CommonVideoMode", "onSharedPreferenceChanged, currentMakeupIndex: " + currMakeupIndex);
                if (currMakeupIndex != 0) {
                    this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, currMakeupIndex).apply();
                    this.mCameraUIInterface.u_renamed(0);
                }
            }
            if (isRearSuperEISOpen()) {
                this.mCameraUIInterface.a_renamed(true, this.mCameraUIInterface.K_renamed(), false, false);
                this.mCameraUIInterface.j_renamed(true, false);
            } else if (supportBeautyButton()) {
                this.mCameraUIInterface.l_renamed(true, false);
            }
            if (supportMenuLeftButton()) {
                if (zEquals && !this.mbFrontCamera) {
                    this.mCameraUIInterface.b_renamed(true, true, true, false);
                    this.mCameraUIInterface.h_renamed(true, false);
                } else {
                    this.mCameraUIInterface.i_renamed(true, false);
                }
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX.equals(str)) {
            int i2 = sharedPreferences != null ? sharedPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX, getFilterNoneIndex()) : getFilterNoneIndex();
            int iA = com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(true);
            if (iA == this.w_renamed && iA != i2 && !isBlurOpen() && !o_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
                com.oplus.camera.e_renamed.c_renamed("CommonVideoMode", "onSharedPreferenceChanged, need to force reopen makeup ");
                this.mCameraUIInterface.aS_renamed();
                m_renamed();
            }
        }
        if (b_renamed(str)) {
            f_renamed(str);
            g_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str) && !this.mCameraInterface.aA_renamed()) {
            this.i_renamed = true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(str)) {
            a_renamed();
            K_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str)) {
            c_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_EXPLORER_CHIP_STATE.equals(str)) {
            this.mCameraUIInterface.q_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_DISABLE_AI_ENHANCEMENT_VIDEO.equals(str)) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.explorer_chip_damage_tip, 2000, new java.lang.Object[0]);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(str) && isOpenFrontTorch() && isBlurOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO)) {
            I_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str)) {
            boolean z_renamed = this.mPreferences != null && "on_renamed".equals(this.mPreferences.getString(str, "off"));
            int i3 = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
            if (z_renamed) {
                updateVideoNeonEnable(false, false);
                n_renamed();
            } else if (i3 != 0 && !"oplus_video_filter_neon".equals(getCurrFilterType()) && !o_renamed() && !isVideoRecording()) {
                this.mCameraInterface.av_renamed();
            }
            updateVideoBlurEnable(true, z_renamed);
            if (isOpenFrontTorch() && isBlurOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO)) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE);
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE.equals(str)) {
            b_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str)) {
            l_renamed();
            if (!isBlurOpen()) {
                u_renamed();
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str)) {
            l_renamed();
            if (!isFilterEffectOpen()) {
                u_renamed();
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0));
            if (java.lang.Integer.parseInt(string) == 0 && this.mCameraId != java.lang.Integer.parseInt(string)) {
                this.k_renamed = true;
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(str) && this.mPreferences.contains(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
            if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && "on_renamed".equals(string2) && !isRearSuperEISOpen()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE.equals(str)) {
            if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
                updateTrackEnable();
            }
            if (L_renamed() && !this.mCameraInterface.aA_renamed()) {
                if (isBlurOpen()) {
                    if (isAiEnhancementVideoOpen()) {
                        a_renamed(false);
                        this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$e_renamed$6rBNUu5_cT-43Nogc2lmUdsd7ZI
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f_renamed$0.X_renamed();
                            }
                        });
                    }
                } else if (H_renamed()) {
                    a_renamed(true, x_renamed());
                }
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            l_renamed();
            if (!is4k()) {
                u_renamed();
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_8K_24_FPS) && "video_size_8k".equals(this.mVideoSizeType) && !e_renamed() && java.lang.String.valueOf(24).equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS))) {
                f_renamed(true);
            }
            if (!isAiEnhancementVideoOpen() && !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, false)) {
                this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE)).apply();
            }
            if (L_renamed() && g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE)) {
                a_renamed(false, true);
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(str)) {
            if (!isAiEnhancementVideoOpen() && !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, false)) {
                this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS)).apply();
            }
            if (L_renamed() && g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS)) {
                a_renamed(false, true);
            }
        }
        if ((com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(str)) && this.mCameraUIInterface != null) {
            this.mCameraUIInterface.R_renamed(getSupportFunction(com.oplus.camera.aps.config.CameraFunction.OUT_PREVIEW_ENABLE));
            this.mCameraUIInterface.P_renamed(!is4k60fps());
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(str) && getSupportFunction(str)) {
            if (sharedPreferences != null && ("on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) || sharedPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false))) {
                l_renamed();
            } else {
                u_renamed();
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str) && L_renamed() && sharedPreferences != null && "off".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, ""))) {
            a_renamed(false, x_renamed());
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str) && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off")) && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(7, true);
        }
        J_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
    }

    private boolean H_renamed() {
        return g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE) || g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showMenuLeftButton() {
        return super.showMenuLeftButton() && !((!this.mbFrontCamera && isSuperEISOpen()) || isVideoRecording() || this.mCameraInterface.J_renamed() || this.mCameraUIInterface.O_renamed() || this.mCameraUIInterface.K_renamed());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showBeautyButton() {
        return super.showBeautyButton() && !((!this.mbFrontCamera && isSuperEISOpen()) || this.mCameraUIInterface.O_renamed() || this.mCameraUIInterface.K_renamed());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean needSetMakeupToAlgo() {
        return super.needSetMakeupToAlgo() && !o_renamed();
    }

    private void f_renamed(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str) && !isAiEnhancementVideoOpen() && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off")) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
            this.mCameraInterface.an_renamed();
        }
    }

    private void I_renamed() {
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
        editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        editorEdit.apply();
        setBlurIndex(0);
        setVideoBlurEffect(false);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_one_subject_hint);
        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        this.mCameraUIInterface.b_renamed(true, false, true, false);
    }

    private void J_renamed() {
        if (this.mCameraUIInterface == null || this.mPreferences == null || this.mCameraUIInterface.K_renamed() || this.mCameraUIInterface.O_renamed() || this.mCameraInterface.J_renamed() || isVideoRecording() || !supportBeautyButton()) {
            return;
        }
        this.mCameraUIInterface.l_renamed(true, com.oplus.camera.util.Util.u_renamed() && (this.mCameraUIInterface.P_renamed() || this.mCameraUIInterface.Q_renamed()));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getDefaultHDRValue() {
        return this.mActivity != null ? this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_hdr_default_value) : "off";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onHDRModeChanged(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR.equals(str)) {
            d_renamed();
            K_renamed();
        }
    }

    public void a_renamed() {
        boolean z_renamed;
        boolean zIsUltraNightVideoOpen = isUltraNightVideoOpen();
        java.lang.String videoSizeType = getVideoSizeType();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onUltraNightVideoChanged, isUltraNightVideoOpen: " + zIsUltraNightVideoOpen + ", videoSizeType: " + videoSizeType + ", videoFps: " + string);
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        this.mCameraInterface.c_renamed(true);
        if (!zIsUltraNightVideoOpen) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
        }
        if (zIsUltraNightVideoOpen) {
            if (isBlurOpen()) {
                I_renamed();
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_one_subject_hint);
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if (isFilterEffectOpen()) {
                E_renamed();
            }
            if (isSuperEISOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR) && isVideoHdrOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
            }
            if ("video_size_1080p".equals(videoSizeType)) {
                z_renamed = false;
            } else {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                z_renamed = true;
            }
            if (!"video_size_1080p".equals(videoSizeType)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                z_renamed = true;
            }
            if (30 != java.lang.Integer.parseInt(string)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30));
                z_renamed = true;
            }
            editorEdit.apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU);
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR);
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        } else {
            z_renamed = false;
        }
        this.mCameraInterface.c_renamed(false);
        if (zIsUltraNightVideoOpen) {
            if (isNoneSatUltraWideAngleOpen()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && !isNoneSatUltraWideAngleOpen() && this.mCameraInterface.a_renamed(getZoomValue())) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
            }
            if (this.mCameraUIInterface.A_renamed() && com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.s_renamed(true);
            } else {
                this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU);
            }
            if (this.mCameraUIInterface.K_renamed()) {
                this.mCameraUIInterface.j_renamed(true, false);
            }
            if (isVideoRecordStopped() && check3HDRPreCondition()) {
                this.mCameraUIInterface.a_renamed(false, true, true);
                this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_ultra_video_night, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_enhancement_video_hint_off);
            this.mCameraUIInterface.j_renamed(0);
        } else {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ultra_video_night);
            if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"))) {
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                    this.mCameraInterface.an_renamed();
                }
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
        }
        if (z_renamed) {
            G_renamed();
        }
    }

    private void K_renamed() {
        if (showBeautyButton()) {
            if (isPanelMode()) {
                this.mCameraUIInterface.a_renamed(0, true);
            } else {
                this.mCameraUIInterface.a_renamed(0, 1);
            }
        }
    }

    public void b_renamed() {
        boolean zIs10bitsHeicEncodeEnable = is10bitsHeicEncodeEnable();
        java.lang.String videoSizeType = getVideoSizeType();
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "on10bitChanged, is10bitOpen: " + zIs10bitsHeicEncodeEnable + ", videoSizeType: " + videoSizeType + ", videoFps: " + this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS));
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (zIs10bitsHeicEncodeEnable) {
            if (isBlurOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off");
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_one_subject_hint);
            }
            if (isFilterEffectOpen()) {
                E_renamed();
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if ("video_size_4kuhd".equals(videoSizeType) && !"video_size_1080p".equals(videoSizeType)) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
            }
            if (isRearSuperEISOpen()) {
                this.mCameraInterface.c_renamed(true);
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            }
            editorEdit.apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        }
        if (zIs10bitsHeicEncodeEnable) {
            if (!this.mCameraUIInterface.A_renamed() || !com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU);
            }
            if (this.mPreferences.getInt(getFaceBeautyKey(), 0) == 0) {
                onFaceBeautyItemChange(0);
                this.mCameraUIInterface.j_renamed(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:68:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:76:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:81:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:84:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:88:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:91:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c_renamed() {
        /*
            Method dump skipped, instructions count: 855
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.e_renamed.c_renamed():void");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needClearFocusView() {
        return !com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraId);
    }

    private void a_renamed(boolean z_renamed, java.lang.String str) {
        com.oplus.camera.ui.a_renamed.a_renamed aVarK;
        if (this.mCameraUIInterface == null || (aVarK = this.mCameraUIInterface.k_renamed()) == null) {
            return;
        }
        aVarK.a_renamed(z_renamed);
        aVarK.b_renamed(str);
    }

    private boolean g_renamed(java.lang.String str) {
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface != null ? this.mCameraUIInterface.k_renamed() : null;
        return aVarK != null && aVarK.a_renamed(str);
    }

    private boolean L_renamed() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_V3);
    }

    private boolean M_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_FILTER_MUTEX_SUPPORT);
    }

    public void d_renamed() {
        boolean z_renamed;
        boolean zIsVideoHdrOpen = isVideoHdrOpen();
        java.lang.String videoSizeType = getVideoSizeType();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        com.oplus.camera.e_renamed.a_renamed("CommonVideoMode", "onVideoHdrModeChanged, isVideHdrOpen: " + zIsVideoHdrOpen + ", videoSizeType: " + videoSizeType + ", videoFps: " + string);
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        this.mCameraInterface.c_renamed(true);
        if (!zIsVideoHdrOpen) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
        }
        if (zIsVideoHdrOpen) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(getVideoCodec())) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265);
            }
            if (isBlurOpen()) {
                I_renamed();
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if (isFilterEffectOpen()) {
                E_renamed();
            }
            if (isSuperEISOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU);
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
                if (!"video_size_4kuhd".equals(videoSizeType)) {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_4kuhd");
                    z_renamed = true;
                }
                z_renamed = false;
            } else {
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                    boolean zEquals = "video_size_1080p".equals(videoSizeType);
                    if (!zEquals && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR_EXCEPT_8K)) {
                        zEquals = !"video_size_8k".equals(videoSizeType);
                    }
                    if (!zEquals) {
                        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                        z_renamed = true;
                    }
                }
                z_renamed = false;
            }
            if (30 != java.lang.Integer.parseInt(string)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30));
                z_renamed = true;
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO) && isUltraNightVideoOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
            }
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            }
            editorEdit.apply();
        } else {
            z_renamed = false;
        }
        this.mCameraInterface.c_renamed(false);
        if (zIsVideoHdrOpen) {
            if (isNoneSatUltraWideAngleOpen()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
            if (this.mCameraUIInterface.A_renamed() && com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.s_renamed(true);
            } else {
                this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU);
            }
            if (this.mCameraUIInterface.K_renamed()) {
                this.mCameraUIInterface.j_renamed(true, false);
            }
            if (checkVideoHdrPreCondition() && isVideoRecordStopped()) {
                this.mCameraUIInterface.a_renamed(false, true, true);
                this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
            }
            this.mCameraUIInterface.j_renamed(0);
        } else {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr);
        }
        if (z_renamed) {
            G_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean checkVideoHdrPreCondition() {
        boolean zEquals;
        java.lang.String videoSizeType = getVideoSizeType();
        int iT = t_renamed();
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
            zEquals = "video_size_4kuhd".equals(videoSizeType);
        } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR_EXCEPT_8K)) {
            zEquals = !"video_size_8k".equals(videoSizeType);
        } else {
            zEquals = "video_size_1080p".equals(videoSizeType);
        }
        return zEquals && 30 == iT;
    }

    private boolean N_renamed() {
        return "video_size_1080p".equals(getVideoSizeType()) && 30 == t_renamed();
    }

    private boolean O_renamed() {
        java.lang.String videoSizeType = getVideoSizeType();
        int iT = t_renamed();
        java.lang.String[] configStringArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION);
        java.lang.String[] configStringArrayValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION);
        return (!this.mbFrontCamera || configStringArrayValue == null || configStringArrayValue.length <= 0) ? (this.mbFrontCamera || configStringArrayValue2 == null || configStringArrayValue2.length <= 0) ? getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) ? "video_size_1080p".equals(videoSizeType) && 30 == iT : 30 == iT && ("video_size_1080p".equals(videoSizeType) || "video_size_720p".equals(videoSizeType)) : com.oplus.camera.util.Util.b_renamed(configStringArrayValue2, videoSizeType) && 30 == iT : com.oplus.camera.util.Util.b_renamed(configStringArrayValue, videoSizeType) && 30 == iT;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoHdrOpen() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
            return "on_renamed".equals(getHDRModeValue(getHDRKey()));
        }
        return false;
    }

    private boolean P_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_WIDE_VIDEO_ONLY_720P_SUPPORT);
    }

    private boolean Q_renamed() {
        return this.mPreferences != null && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO, "off").equals("grid");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData) {
            com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData2 = (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData2.mLux = java.lang.String.valueOf(this.mDcsLux);
            videoRecordMsgData2.mCct = java.lang.String.valueOf(this.mDcsCCT);
            videoRecordMsgData2.mIso = java.lang.String.valueOf(this.mDcsIso);
            videoRecordMsgData2.mExp = java.lang.String.valueOf(this.mDcsExp);
            videoRecordMsgData2.mIsAssistantLine = java.lang.Boolean.toString(Q_renamed());
            videoRecordMsgData = videoRecordMsgData2;
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isUltraNightVideoOpen() {
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO) || this.mPreferences == null) {
            return false;
        }
        return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAiEnhancementVideoOpen() {
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO) || this.mPreferences == null) {
            return false;
        }
        return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, com.oplus.camera.util.Util.e_renamed(this.mbFrontCamera)));
    }

    private boolean R_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EXPLORER_SUPPORT) && this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1) == 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHDRState() {
        return isVideoHdrOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideo10BitOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) ? (isFaceBeautyOrMakeupOpen() || isBlurOpen() || isFilterEffectOpen() || !is10bitsHeicEncodeEnable() || 120 == getVideoFps()) ? false : true : isVideoHdrOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR_10BIT) && 120 != getVideoFps();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return (((this.mCameraInterface == null || this.mCameraInterface.i_renamed()) && (isSuperEISOpen() || isSatOpen() || !isHighFps())) || needApsToProcessVideoWatermark()) ? (this.mbFrontCamera || !isVideoRetentionOpen()) ? isRearSuperEISOpen() ? isVideoSuperEisWideOpen() ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_SUPER_EIS_PRO : com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_SUPER_EIS : (isSatOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL)) ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_SAT_HAL : isVideoHdrOpen() ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_LIVE_HDR : isUltraNightVideoOpen() ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_ULTRA_NIGHT : isAiEnhancementVideoOpen() ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_AI_ENHANCEMENT : super.getCameraFeature() : com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCameraFeature(com.oplus.camera.aps.constant.ApsConstant.FEATURE_VIDEO_RETENTION, this.mCameraId) ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_VIDEO_RETENTION : com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCameraFeature(com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_VIDEO_DUMMY, this.mCameraId) ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_VIDEO_DUMMY : com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_DUMMY : com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCameraFeature(com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_VIDEO_DUMMY, this.mCameraId) ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_VIDEO_DUMMY : com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_DUMMY;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean is4k() {
        return this.mPreferences != null && "video_size_4kuhd".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, getDefaultVideoSize()));
    }

    public boolean e_renamed() {
        if (this.mPreferences != null) {
            return a_renamed(getVideoSizeType());
        }
        return false;
    }

    public boolean a_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return "video_size_8k".equals(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAntibandingEnable() {
        return (isBlurOpen() || isVideoNeonOpen() || isHighFps()) ? false : true;
    }

    private void S_renamed() {
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_BACKUP, "JPEG");
        java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC_BACKUP, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264);
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, string);
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, string2);
        editorEdit.apply();
    }

    private boolean T_renamed() {
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_SUPPORT_PREVERSION) || isSuperEISOpen()) {
            return true;
        }
        return (is4k() || isHighFps()) ? false : true;
    }

    private void h_renamed(java.lang.String str) {
        if (this.mPreviewEffectProcess != null) {
            if ("oplus_video_filter_portrait_retention".equals(str) || "oplus_video_filter_neon".equals(str)) {
                this.mPreviewEffectProcess.a_renamed("default");
            } else {
                this.mPreviewEffectProcess.a_renamed(str);
            }
            this.x_renamed = str;
            this.mPreviewEffectProcess.c_renamed(getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(str));
        }
    }

    private boolean U_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P) && (this.mbFrontCamera || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P_DISABLE_REAR));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeConfig() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            checkAiEnhancementVideoState();
        }
        if (this.mCameraInterface == null || !this.mCameraInterface.i_renamed()) {
            return;
        }
        g_renamed();
    }

    private void V_renamed() {
        int iF;
        if (this.mbFrontCamera) {
            return;
        }
        java.lang.String str = this.mVideoSizeType;
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS);
        int recordingMaxDuration = getRecordingMaxDuration(str, string) / 60;
        if (recordingMaxDuration > 0 && (iF = f_renamed(str, string)) >= 0) {
            this.mCameraUIInterface.a_renamed(iF, 2800, recordingMaxDuration, java.lang.Integer.valueOf(recordingMaxDuration));
        }
    }

    private int f_renamed(java.lang.String str, java.lang.String str2) {
        if ("video_size_8k".equals(str) && java.lang.String.valueOf(30).equals(str2)) {
            return com.oplus.camera.R_renamed.plurals.video_message_max_duration_8k_30fps;
        }
        if ("video_size_8k".equals(str) && java.lang.String.valueOf(24).equals(str2)) {
            return com.oplus.camera.R_renamed.plurals.video_message_max_duration_8k_24fps;
        }
        if ("video_size_4kuhd".equals(str) && java.lang.String.valueOf(120).equals(str2)) {
            return com.oplus.camera.R_renamed.plurals.video_message_max_duration_4k_120fps;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:7:0x000a, code lost:
    
        r3 = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_MAX_DURATION_VALUE);
     */
    @Override // com.oplus.camera.capmode.w_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int getRecordingMaxDuration(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r3 = r3.mbFrontCamera
            r0 = -1
            if (r3 != 0) goto L56
            if (r4 == 0) goto L56
            if (r5 != 0) goto La
            goto L56
        La:
            java.lang.String r3 = "com.oplus.video.max.duration.value"
            java.lang.String[] r3 = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(r3)
            if (r3 == 0) goto L56
            int r1 = r3.length
            r2 = 3
            if (r1 < r2) goto L56
            int r1 = r3.length
            int r1 = r1 % r2
            if (r1 == 0) goto L1b
            goto L56
        L1b:
            r1 = 0
        L1c:
            int r2 = r3.length
            if (r1 >= r2) goto L56
            r2 = r3[r1]
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L53
            int r2 = r1 + 1
            r2 = r3[r2]
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L53
            int r1 = r1 + 2
            r4 = r3[r1]     // Catch: java.lang.NumberFormatException -> L3a
            int r3 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L3a
            return r3
        L3a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getRecordingMaxDuration, parse int error value:"
            r4.append(r5)
            r3 = r3[r1]
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "CommonVideoMode"
            com.oplus.camera.e_renamed.f_renamed(r4, r3)
            return r0
        L53:
            int r1 = r1 + 1
            goto L1c
        L56:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.e_renamed.getRecordingMaxDuration(java.lang.String, java.lang.String):int");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (isRearSuperEISOpen()) {
            return false;
        }
        return super.supportBeautyButton();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        if (W_renamed()) {
            return super.checkPreviewResult(cameraApsDecision);
        }
        return true;
    }

    private boolean W_renamed() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS) || isSloganOpen()) {
            return true;
        }
        return (isHighFps() || is4k120fps() || (!is4k() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_LOW_FPS_PREVIEW_PROCESS_BY_APS))) ? false : true;
    }
}
