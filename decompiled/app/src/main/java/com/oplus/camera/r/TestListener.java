package com.oplus.camera.r_renamed;

/* compiled from: SlowVideoMode.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.camera.capmode.w_renamed {
    private boolean g_renamed;
    private java.util.HashMap<java.lang.String, java.lang.String> h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private com.oplus.camera.r_renamed.a_renamed o_renamed;
    private com.oplus.camera.ui.menu.setting.CameraMenuOption p_renamed;
    private final com.oplus.camera.r_renamed.a_renamed.SLVBaseMode_2 q_renamed;

    private java.lang.String b_renamed(int i_renamed) {
        return i_renamed != 120 ? i_renamed != 240 ? i_renamed != 480 ? i_renamed != 960 ? com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_120 : com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_960 : com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_480 : com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_240 : com.oplus.ocs.camera.CameraParameter.VideoFpsValue.VIDEO_FPS_120;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSlowVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int i_renamed) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
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

    public g_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = false;
        this.h_renamed = new java.util.HashMap<>();
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = new com.oplus.camera.r_renamed.a_renamed.SLVBaseMode_2() { // from class: com.oplus.camera.r_renamed.g_renamed.7
            @Override // com.oplus.camera.r_renamed.a_renamed.SLVBaseMode_2
            public void a_renamed(java.lang.String str) throws java.lang.Throwable {
                com.oplus.camera.ui.control.e_renamed.d_renamed dVar = new com.oplus.camera.ui.control.e_renamed.d_renamed();
                dVar.k_renamed = 1;
                dVar.d_renamed = android.net.Uri.parse(str);
                com.oplus.camera.r_renamed.g_renamed gVar = com.oplus.camera.r_renamed.g_renamed.this;
                gVar.a_renamed(gVar.getVideoFileName(), str, dVar);
                com.oplus.camera.r_renamed.g_renamed.this.a_renamed(dVar, true, true);
                com.oplus.camera.r_renamed.g_renamed.this.m_renamed = false;
                com.oplus.camera.e_renamed.f_renamed("SlowVideoMode", "onProcessFinished !, videoContentUri = " + str);
            }

            @Override // com.oplus.camera.r_renamed.a_renamed.SLVBaseMode_2
            public void b_renamed(java.lang.String str) {
                com.oplus.camera.r_renamed.g_renamed gVar = com.oplus.camera.r_renamed.g_renamed.this;
                gVar.deleteVideoFile(gVar.getVideoFileName());
                com.oplus.camera.r_renamed.g_renamed.this.a_renamed((com.oplus.camera.ui.control.e_renamed.d_renamed) null, true, false);
                com.oplus.camera.r_renamed.g_renamed.this.m_renamed = false;
                com.oplus.camera.e_renamed.f_renamed("SlowVideoMode", "onCompileFailed !, videoContentUri = " + str);
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        super.onResume(z_renamed);
        this.mCameraInterface.a_renamed(4);
        if (isVideoRecordStopped()) {
            this.i_renamed = false;
            this.j_renamed = false;
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        super.onDestroy();
        this.g_renamed = false;
        j_renamed();
        java.util.HashMap<java.lang.String, java.lang.String> map = this.h_renamed;
        if (map != null) {
            map.clear();
            this.h_renamed = null;
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(str)) {
            return true;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        this.mbHasDragIntelligentView = false;
        this.mHandler.removeMessages(12);
        super.onPause();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_saving);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_not_detected);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.b_renamed(4);
        }
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) || this.l_renamed) {
            return;
        }
        if (isVideoRecordStarted() || isVideoRecordStarting() || isVideoRecordStopping()) {
            stopVideoRecordThread();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "onInitCameraMode");
        super.onInitCameraMode();
        enableVideoRecordingSound(false);
        this.mOrientation = this.mCameraInterface.u_renamed();
        this.mCameraInterface.a_renamed(4);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM.equals(str)) {
            return !this.mbFrontCamera && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO_ZOOM);
        }
        return super.needUploadOplusStatistics(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_default_selected));
            if (isSlowVideoHighFrame()) {
                java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, "");
                if (!android.text.TextUtils.isEmpty(string2)) {
                    android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string2);
                    editorEdit.apply();
                    string = string2;
                }
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, string).apply();
                this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, "off");
            }
            if (isSlowVideoHighFrame() && "on_renamed".equals(string)) {
                a_renamed(0);
            } else {
                a_renamed(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed() {
        if (this.mCameraUIInterface == null || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU)) {
            return;
        }
        this.mCameraUIInterface.p_renamed(e_renamed());
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x0102  */
    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.r_renamed.g_renamed.getSupportFunction(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c_renamed() {
        return this.mActivity != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU) && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_slow_video_mode_frame_default_value)));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "onDeInitCameraMode");
        enableVideoRecordingSound(true);
        j_renamed();
        super.onDeInitCameraMode(str);
        this.mCameraInterface.b_renamed(4);
        a_renamed(false, false, false);
        a_renamed(8);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeModeChanged() {
        super.beforeModeChanged();
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_hint_on);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_hint_off);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_slow_selected);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_super_selected);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.c_renamed("button_shape_dial_still");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        if (getSupportMenu(com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS)) {
            i_renamed();
        }
        if (this.mVideoSizeType.equals("video_size_1080p")) {
            this.mProfile.videoBitRate = com.oplus.camera.jni.YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        } else if (this.mVideoSizeType.equals("video_size_720p")) {
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_720P_VIDEO_BIT_RATE);
            if (configIntValue > 0 && com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264.equals(getVideoCodec())) {
                this.mProfile.videoBitRate = configIntValue;
            } else {
                this.mProfile.videoBitRate = 7500000;
            }
        }
        com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "onBeforePreview, slowVideoFps: " + getSlowVideoFps());
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        if (!this.g_renamed && z_renamed) {
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.g_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_slow_video_tips, -1, true, false, false);
                        }
                    }
                });
            }
            this.g_renamed = true;
        }
        if (this.mHandler == null || !z_renamed) {
            return;
        }
        this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.g_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.r_renamed.g_renamed.this.b_renamed();
                com.oplus.camera.r_renamed.g_renamed.this.a_renamed();
                com.oplus.camera.r_renamed.g_renamed gVar = com.oplus.camera.r_renamed.g_renamed.this;
                gVar.a_renamed(gVar.c_renamed(), false, true);
                if (com.oplus.camera.r_renamed.g_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED) && com.oplus.camera.r_renamed.g_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && "on_renamed".equals(com.oplus.camera.r_renamed.g_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, com.oplus.camera.r_renamed.g_renamed.this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_default_selected)))) {
                    com.oplus.camera.r_renamed.g_renamed.this.a_renamed(0);
                }
                if (com.oplus.camera.r_renamed.g_renamed.this.mCameraInterface != null) {
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraInterface.i_renamed(false);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public void checkVideoCodecAndReset() {
        if (com.oplus.camera.util.Util.at_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SLOW_VIDEO_H265)) {
            return;
        }
        java.lang.String string = this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_codec_default_value);
        if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, string))) {
            com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "checkVideoCodecAndReset, reset video codec to default.");
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, string);
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public java.lang.Float getRealVideoTimeRatio() {
        return super.getRealVideoTimeRatio();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public boolean getNeedReduceBitRate() {
        return com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_codec_default_value)));
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public java.lang.Double getRealCaptureRate() {
        java.lang.String strF = f_renamed();
        if (android.text.TextUtils.isEmpty(strF)) {
            return null;
        }
        return java.lang.Double.valueOf(java.lang.Double.parseDouble(strF));
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected java.lang.String getVideoTitle() {
        java.lang.String strF = f_renamed();
        if (!android.text.TextUtils.isEmpty(strF)) {
            if (needPostProcessAfterStopRecord()) {
                return this.o_renamed.a_renamed(strF);
            }
            return "slow_motion_hfr_" + strF + ":0,0,0,0";
        }
        return super.getVideoTitle();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if (!"type_video_frame".equals(str) || this.mCameraInterface == null) {
            return "type_video".equals(str);
        }
        return this.mCameraInterface.i_renamed() && !isUseMediaCodec() && !isUseMediaRecorderNotUseAPS() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHFR() {
        return com.oplus.camera.util.Util.C_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Range<java.lang.Integer> getVideoFpsRange() {
        java.lang.String strF = f_renamed();
        if (android.text.TextUtils.isEmpty(strF)) {
            return null;
        }
        return android.util.Range.create(java.lang.Integer.valueOf((isVideoRecording() || com.oplus.camera.util.Util.C_renamed()) ? java.lang.Integer.parseInt(strF) : 30), java.lang.Integer.valueOf(java.lang.Integer.parseInt(strF)));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getVideoSizeType() {
        if (this.mPreferences instanceof com.oplus.camera.ComboPreferences) {
            return ((com.oplus.camera.ComboPreferences) this.mPreferences).a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, getDefaultVideoSize());
        }
        return this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, getDefaultVideoSize());
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public java.lang.String getDefaultVideoSize() {
        return com.oplus.camera.util.Util.o_renamed(this.mCameraId);
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
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.z_renamed(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        return (com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsPreview() && !this.mbFrontCamera && isSlowVideoHighFrame()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected int getSlowVideoFps() {
        int slowVideoFps = super.getSlowVideoFps();
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
            slowVideoFps = e_renamed();
        } else if (getSupportMenu(com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS)) {
            slowVideoFps = h_renamed();
        } else {
            android.util.Range<java.lang.Integer> videoFpsRange = getVideoFpsRange();
            if (videoFpsRange != null) {
                slowVideoFps = ((java.lang.Integer) videoFpsRange.getLower()).intValue();
            }
        }
        com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "getSlowVideoFps: " + slowVideoFps);
        return slowVideoFps;
    }

    private int d_renamed() {
        if (this.mbFrontCamera && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
            return java.lang.Integer.parseInt(a_renamed(java.lang.Boolean.valueOf(this.mbFrontCamera), com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P));
        }
        return k_renamed();
    }

    private int e_renamed() {
        return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, d_renamed());
    }

    private java.lang.String f_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) && !this.mbFrontCamera) {
            int iE = e_renamed();
            if (iE == 120) {
                return com.oplus.camera.aps.config.CameraConfig.getConfigFpsValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE);
            }
            if (iE == 240) {
                return com.oplus.camera.aps.config.CameraConfig.getConfigFpsValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE);
            }
            if (iE != 480) {
                return iE != 960 ? "" : com.oplus.camera.aps.config.CameraConfig.getConfigFpsValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE);
            }
            return com.oplus.camera.aps.config.CameraConfig.getConfigFpsValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE);
        }
        if (getSupportMenu(com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS)) {
            return com.oplus.camera.r_renamed.f_renamed.b_renamed(h_renamed());
        }
        java.lang.String videoSizeType = getVideoSizeType();
        if ("video_size_1080p".equals(videoSizeType)) {
            return a_renamed(java.lang.Boolean.valueOf(this.mbFrontCamera), com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P);
        }
        return "video_size_720p".equals(videoSizeType) ? com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_FPS_HFR_720P) : "";
    }

    private java.lang.String a_renamed(java.lang.Boolean bool, java.lang.String str) {
        if (com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P.equals(str)) {
            java.lang.String configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P_FRONT);
            java.lang.String configStringValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PREVIEW_FPS_HFR_1080P);
            return (!bool.booleanValue() || configStringValue == null) ? configStringValue2 : configStringValue;
        }
        return com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str)) {
            return !this.mbFrontCamera;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE.equals(str)) {
            if (this.p_renamed == null) {
                this.p_renamed = this.mCameraUIInterface.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE);
            }
            if (this.p_renamed != null && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_720P_SLOW_VIDEO)) {
                if (this.mbFrontCamera && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
                    this.p_renamed.l_renamed(getDefaultVideoSize());
                    this.p_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_size_value_720p));
                } else {
                    this.p_renamed.l_renamed(getDefaultVideoSize());
                    this.p_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_size_value_720p));
                }
            } else if (this.p_renamed != null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_720P_SLOW_VIDEO) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_1080P_SLOW_VIDEO)) {
                if (this.mbFrontCamera && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) {
                    this.p_renamed.l_renamed(getDefaultVideoSize());
                    this.p_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_size_value_1080p));
                } else {
                    this.p_renamed.l_renamed(getDefaultVideoSize());
                    this.p_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_size_value_1080p));
                }
            }
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.p_renamed;
            if (cameraMenuOption == null || cameraMenuOption.X_renamed() > 1) {
                return getSupportFunction(str);
            }
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        int i_renamed = (this.mbFrontCamera || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_FOVC)) ? 32781 : 33549;
        if (this.mOneCamera == null || this.mOneCamera.e_renamed().a_renamed(getVideoSizeType()) == null) {
            return i_renamed;
        }
        return 0;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        if (this.mCameraInterface != null) {
            if (needPostProcessAfterStopRecord()) {
                this.mCameraUIInterface.h_renamed(this.o_renamed.c_renamed());
                this.mCameraUIInterface.a_renamed(this.o_renamed.a_renamed(2));
            } else {
                a_renamed(false, true, true);
                this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_dial_still", 1));
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_super_selected, com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_slow_selected);
        }
        if (!com.oplus.camera.util.Util.C_renamed()) {
            this.mOneCamera.a_renamed(true, getVideoSizeType());
        }
        super.beforeStartRecording();
        if (this.mOneCamera != null) {
            if (!com.oplus.camera.util.Util.C_renamed() && this.mCameraInterface != null) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.u_renamed())));
            }
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        this.mOneCamera.a_renamed(1, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), false);
        if (com.oplus.camera.util.Util.C_renamed()) {
            this.mOneCamera.a_renamed(1, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), false);
        }
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        if (isMotionDetectOpen()) {
            if (this.mCameraUIInterface != null) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_detecting, -1, false, false, true);
                this.mCameraUIInterface.E_renamed(false);
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.Z_renamed();
                this.mCameraInterface.i_renamed(true);
            }
            this.mHandler.removeMessages(12);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12), 120000L);
        } else if (this.mCameraUIInterface != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
            this.mCameraUIInterface.a_renamed(false, true);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_recording, -1, false, false, true);
        } else if (needPostProcessAfterStopRecord()) {
            this.mCameraUIInterface.a_renamed(false, true);
        }
        if (!this.mbPaused && this.k_renamed) {
            this.k_renamed = false;
        }
        if (this.mbPaused || !this.l_renamed) {
            return;
        }
        this.l_renamed = false;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isMotionDetectOpen() {
        return this.mActivity != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_default_selected)));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z_renamed) {
        super.forceStopVideoRecording(z_renamed);
        this.k_renamed = true;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void stopVideoRecordThread() {
        this.l_renamed = true;
        super.stopVideoRecordThread();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isRecordFileValid() {
        boolean zIsRecordFileValid;
        if (isSlowVideoHighFrame()) {
            zIsRecordFileValid = (this.mbStopVideoFail || this.k_renamed) ? false : true;
        } else {
            zIsRecordFileValid = super.isRecordFileValid();
        }
        boolean zIsMotionDetectOpen = isMotionDetectOpen();
        if (zIsMotionDetectOpen) {
            zIsRecordFileValid = zIsRecordFileValid && this.i_renamed;
        }
        com.oplus.camera.e_renamed.b_renamed("SlowVideoMode", "isRecordFileValid: " + zIsRecordFileValid + ", motionDetectOpen: " + zIsMotionDetectOpen + ", mbMotionDetected: " + this.i_renamed + ", motionDetectOpen: " + zIsMotionDetectOpen + ", mbStopVideoFail: " + this.mbStopVideoFail + ", mbForceStopRecord: " + this.k_renamed);
        return zIsRecordFileValid;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isMotionDetected() {
        return this.i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onMotionDetected() {
        if (!this.i_renamed && !this.mbPaused) {
            com.oplus.camera.e_renamed.b_renamed("SlowVideoMode", "onMotionDetected");
            this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.g_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface == null || !com.oplus.camera.r_renamed.g_renamed.this.isMotionDetectOpen() || com.oplus.camera.r_renamed.g_renamed.this.mbPaused) {
                        return;
                    }
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_recording, -1, false, false, true);
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(false, true);
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.h_renamed(2800);
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(3, "button_color_inside_none", "button_shape_dial_still", 1));
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraInterface.i_renamed(false);
                }
            });
        }
        if (this.i_renamed) {
            return;
        }
        this.i_renamed = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFrameInterpolationStarted() {
        if (!this.j_renamed && !this.mbPaused) {
            com.oplus.camera.e_renamed.b_renamed("SlowVideoMode", "onFrameInterpolationStarted");
            this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.g_renamed.4
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface == null || com.oplus.camera.r_renamed.g_renamed.this.mbPaused) {
                        return;
                    }
                    com.oplus.camera.e_renamed.b_renamed("SlowVideoMode", "onFrameInterpolationStarted, onVideoShutterButtonClick");
                    com.oplus.camera.r_renamed.g_renamed.this.aj_renamed();
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(4, "button_color_inside_red", "button_shape_dial_still"));
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_saving, -1, false, false, true);
                }
            });
        }
        this.j_renamed = true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
            return super.onBackPressed();
        }
        if ((960 == getSlowVideoFps() || isSlowVideoHighFrame()) && !this.mbFrontCamera && isVideoRecordStarted() && this.mRecordingTotalTime < getRecordingMinTime(false) && !this.mbPaused && !this.mCameraInterface.m_renamed() && this.mVideoRecorder != null) {
            com.oplus.camera.e_renamed.e_renamed("SlowVideoMode", "onBackPressed(), Record Time less than 1 second.");
            return true;
        }
        this.mbBackPressedAfterCapture = true;
        if (!this.k_renamed && isSlowVideoHighFrame() && !g_renamed() && (isVideoRecordStarted() || isVideoRecordStopping())) {
            forceStopVideoRecording(false);
            if (this.mCameraUIInterface != null) {
                this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_dial_still", 1));
                this.mCameraUIInterface.a_renamed(false, true);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_detecting);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_recording);
            }
            com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "onBackPressed, return, isVideoRecordStarted: " + isVideoRecordStarted() + ", isVideoRecordStopping: " + isVideoRecordStopping());
            return true;
        }
        if (isVideoRecording() || isVideoRecordStopping() || g_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "onBackPressed, return, isVideoRecording: " + isVideoRecording() + ", isVideoRecordStopping: " + isVideoRecordStopping() + ", isSlowVideoFileSaving: " + g_renamed());
            return true;
        }
        return super.onBackPressed();
    }

    private boolean g_renamed() {
        return this.j_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.a_renamed(true, false);
        }
        this.mOneCamera.a_renamed(3, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        if (this.mCameraUIInterface != null && !this.mbPaused && !needPostProcessAfterStopRecord()) {
            this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_dial_still", 1));
            this.mCameraUIInterface.E_renamed(true);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_detecting);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_recording);
            b_renamed();
            if (isMotionDetectOpen()) {
                if (this.mCameraInterface != null) {
                    this.mCameraInterface.i_renamed(false);
                }
                if (this.i_renamed) {
                    this.mCameraUIInterface.d_renamed(true, false);
                } else {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_not_detected, -1, true, false, false);
                }
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_saving);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(12);
        }
        this.i_renamed = false;
        this.j_renamed = false;
        this.mbHasDragIntelligentView = false;
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (this.mCameraUIInterface.k_renamed().b_renamed() && com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed())) {
            if (isVideoFlashTorchOpen()) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_off);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_torch, -1, true, true, false);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_torch);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_off, -1, true, true, false);
            }
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
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        if (this.mbFrontCamera) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_slow_selected);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_super_selected);
            a_renamed(4);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            a_renamed("on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_slow_video_mode_frame_default_value))), true, true);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            java.lang.String string = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_default_selected));
            boolean zEquals = "on_renamed".equals(string);
            if (isSlowVideoHighFrame()) {
                sharedPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, string).apply();
            }
            if (zEquals && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE)) {
                a_renamed(0);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_hint_on, -1, true, false, false);
            } else {
                a_renamed(4);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_hint_off, -1, true, false, false);
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS.equals(str)) {
            i_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isSlowVideoHighFrame() {
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) || this.mbFrontCamera) {
            return false;
        }
        int iE = e_renamed();
        return 480 == iE || 960 == iE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (this.mCameraUIInterface != null) {
            if (z_renamed) {
                this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                this.mCameraUIInterface.D_renamed(z2);
                return;
            }
            this.mCameraUIInterface.C_renamed(z2);
            if (z3) {
                this.mCameraInterface.a_renamed(true, false);
                this.mCameraInterface.d_renamed(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed) {
        if (this.mCameraUIInterface == null || this.mCameraInterface == null) {
            return;
        }
        if (i_renamed == 0 && this.mCameraInterface.J_renamed()) {
            this.mCameraInterface.H_renamed();
        }
        this.mCameraUIInterface.o_renamed(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z_renamed) {
        if (this.mPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU);
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSlowVideoFrameChange(int i_renamed) {
        java.lang.String configFpsVideoType;
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (120 == i_renamed) {
            configFpsVideoType = com.oplus.camera.aps.config.CameraConfig.getConfigFpsVideoType(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE);
        } else if (240 == i_renamed) {
            configFpsVideoType = com.oplus.camera.aps.config.CameraConfig.getConfigFpsVideoType(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE);
        } else if (480 == i_renamed) {
            configFpsVideoType = com.oplus.camera.aps.config.CameraConfig.getConfigFpsVideoType(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE);
        } else {
            configFpsVideoType = 960 == i_renamed ? com.oplus.camera.aps.config.CameraConfig.getConfigFpsVideoType(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE) : null;
        }
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, configFpsVideoType);
        editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, i_renamed).apply();
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_default_selected));
        if (!isSlowVideoHighFrame() || "off".equals(string)) {
            a_renamed(4);
        }
        this.mCameraInterface.av_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void reportIntelligentDragViewMoveToDcs(int i_renamed, int i2, boolean z_renamed, int i3) {
        this.mbHasDragIntelligentView = true;
        java.lang.String str = i_renamed + "x_renamed" + i2;
        com.oplus.camera.statistics.model.FocusAimMsgData focusAimMsgData = new com.oplus.camera.statistics.model.FocusAimMsgData(this.mActivity);
        focusAimMsgData.mCameraId = getProperCameraId(this.mCameraId);
        focusAimMsgData.mCaptureMode = getCameraMode();
        focusAimMsgData.mOrientation = this.mOrientation;
        focusAimMsgData.mCaptureType = 1;
        focusAimMsgData.mbVideoRecording = false;
        focusAimMsgData.mTouchXY = str;
        if (!this.mbFrontCamera) {
            focusAimMsgData.mAeAfLock = java.lang.String.valueOf(z_renamed);
        }
        focusAimMsgData.mTouchEV = java.lang.String.valueOf(i3);
        focusAimMsgData.mActType = com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE;
        focusAimMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData) {
            com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData2 = (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData2.mLux = java.lang.String.valueOf(this.mDcsLux);
            videoRecordMsgData2.mIsIntelligentDetect = isMotionDetectOpen() ? "on_renamed" : "off";
            videoRecordMsgData = videoRecordMsgData2;
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) {
        if (isMotionDetectOpen() && (isVideoRecordStarted() || isVideoRecordStarting())) {
            return false;
        }
        return super.getTouchEnable(z_renamed, i_renamed, i2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        super.onZoomMenuExpand();
        if (isMotionDetectOpen()) {
            a_renamed(4);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        super.onZoomMenuCollapsed();
        if (isMotionDetectOpen()) {
            a_renamed(0);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected java.lang.String getVideoFileExifTag() {
        return com.oplus.camera.g_renamed.b_renamed.b_renamed(getCameraMode(), 0);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void onStopVideoRecording(boolean z_renamed) {
        if (this.mRecordingTotalTime < getRecordingMinTime(false) && !this.mbPaused && !this.mCameraInterface.m_renamed() && this.mVideoRecorder != null && z_renamed && 960 == getSlowVideoFps() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME)) {
            com.oplus.camera.e_renamed.e_renamed("SlowVideoMode", "onStopVideoRecording, Record Time less than 1 second.");
            return;
        }
        super.onStopVideoRecording(z_renamed);
        boolean zEquals = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_storage_default_value)));
        if (com.oplus.camera.Storage.d_renamed() && zEquals) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.g_renamed.5
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                    bVar.a_renamed("button_color_inside_none");
                    bVar.a_renamed(4);
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(bVar);
                }
            });
        }
    }

    private int h_renamed() {
        return java.lang.Integer.parseInt(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS, com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE)));
    }

    private com.oplus.camera.r_renamed.a_renamed i_renamed() {
        com.oplus.camera.r_renamed.a_renamed aVar = this.o_renamed;
        if (aVar == null || aVar.a_renamed() != h_renamed()) {
            j_renamed();
            this.o_renamed = com.oplus.camera.r_renamed.f_renamed.a_renamed(h_renamed(), this.mActivity, this.mCameraUIInterface);
            this.o_renamed.a_renamed(this.q_renamed);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, com.oplus.camera.r_renamed.f_renamed.c_renamed(this.o_renamed.a_renamed())).apply();
        }
        com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "fpsModeInstanceWrap fpsMode: " + this.o_renamed.a_renamed());
        return this.o_renamed;
    }

    private void j_renamed() {
        if (this.o_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "destroyFpsMode mbCompilingVideo: " + this.m_renamed);
            if (this.m_renamed) {
                this.o_renamed.d_renamed();
            }
            this.o_renamed.e_renamed();
            this.o_renamed = null;
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected int configVideoBitRate() {
        if (needPostProcessAfterStopRecord()) {
            return com.oplus.camera.jni.YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        }
        if (this.mVideoSizeType.equals("video_size_1080p")) {
            this.mProfile.videoBitRate = com.oplus.camera.jni.YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE;
        } else if (this.mVideoSizeType.equals("video_size_720p")) {
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_720P_VIDEO_BIT_RATE);
            if (configIntValue > 0 && com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264.equals(getVideoCodec())) {
                this.mProfile.videoBitRate = configIntValue;
            } else {
                this.mProfile.videoBitRate = 7500000;
            }
        }
        return super.configVideoBitRate();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean shouldAutoStop(long j_renamed) {
        com.oplus.camera.r_renamed.a_renamed aVar = this.o_renamed;
        if (aVar != null) {
            this.n_renamed = j_renamed > ((long) aVar.c_renamed());
        }
        return this.n_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void processPlatformSlowVideo() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.r_renamed.g_renamed.6
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.control.b_renamed bVarA = com.oplus.camera.r_renamed.g_renamed.this.o_renamed.a_renamed(3);
                if (bVarA != null) {
                    com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.a_renamed(bVarA);
                }
                com.oplus.camera.r_renamed.g_renamed.this.mCameraUIInterface.d_renamed(false, false);
                com.oplus.camera.r_renamed.g_renamed.this.m_renamed = true;
                com.oplus.camera.r_renamed.g_renamed.this.o_renamed.a_renamed(com.oplus.camera.r_renamed.g_renamed.this.mVideoOrientation, com.oplus.camera.r_renamed.g_renamed.this.mCurrentVideoUri, com.oplus.camera.r_renamed.g_renamed.this.mCurrentVideoValues, com.oplus.camera.r_renamed.g_renamed.this.getVideoFileExifTag().concat(com.oplus.camera.r_renamed.g_renamed.this.getVideoTitle()));
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPostProcessAfterStopRecord() {
        com.oplus.camera.r_renamed.a_renamed aVar = this.o_renamed;
        return aVar != null && aVar.b_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void generateImageInfo(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.mCameraUIInterface == null || !isMotionDetectOpen()) {
            return;
        }
        map.put(com.oplus.camera.aps.constant.CameraUnitKeys.KEY_INTELLIGENT_CROP_REGION, this.mCameraUIInterface.q_renamed(getSensorOrientation(this.mCameraId)));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        android.util.Size videoPreviewSize = getVideoPreviewSize(getVideoSizeType());
        if (videoPreviewSize != null) {
            builder.setVideoSize(videoPreviewSize);
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_FPS, b_renamed(java.lang.Integer.parseInt(f_renamed())));
        }
        if (isSlowVideoHighFrame()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.SLOW_VIDEO_INTELLIGENT_HIGH_FRAME_ENABLE, "on_renamed");
        }
    }

    private void a_renamed(java.lang.String str, com.oplus.camera.ui.control.e_renamed.d_renamed dVar) throws java.lang.Throwable {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            } catch (java.lang.Throwable th) {
                th = th;
                mediaMetadataRetriever = mediaMetadataRetriever2;
            }
        } catch (java.lang.Exception unused) {
        }
        try {
            mediaMetadataRetriever.setDataSource(this.mActivity.getApplicationContext(), android.net.Uri.parse(str));
            dVar.m_renamed = com.oplus.camera.ui.control.e_renamed.b_renamed(mediaMetadataRetriever.getFrameAtTime(-1L), com.oplus.camera.ui.control.ThumbImageView.f6022a);
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("is_pending", (java.lang.Integer) 0);
            this.mActivity.getContentResolver().update(android.net.Uri.parse(str), contentValues, null, null);
            mediaMetadataRetriever.release();
        } catch (java.lang.Exception unused2) {
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "extractMetadataThumbnailFromFile, get video thumbnail fail.");
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(java.lang.String str, java.lang.String str2, com.oplus.camera.ui.control.e_renamed.d_renamed dVar) throws java.lang.Throwable {
        if ("on_renamed".equals(com.oplus.camera.Storage.e_renamed()) && !com.oplus.camera.Storage.b_renamed(true)) {
            this.mCurrentVideoUri = null;
            if (this.mCurrentVideoValues != null) {
                this.mCurrentVideoValues.clear();
                this.mCurrentVideoValues = null;
            }
            com.oplus.camera.e_renamed.a_renamed("SlowVideoMode", "deleteUpdateSlowVideoToMediaStore, Exception: sdcard has removed, so not add to mediaStore.");
            return false;
        }
        this.mCameraUIInterface.t_renamed();
        a_renamed(str2, dVar);
        com.oplus.camera.e_renamed.b_renamed("SlowVideoMode", "deleteUpdateVideo, originalVideoFileName: " + str + ",  compiledSlowVideoUri: " + str2);
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_DUMP_960FPS_ORIGINAL)) {
            deleteVideoFile(str);
        }
        if (this.mCurrentVideoValues != null) {
            this.mCurrentVideoValues.clear();
            this.mCurrentVideoValues = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed dVar, boolean z_renamed, boolean z2) {
        if (this.mCameraUIInterface != null) {
            com.oplus.camera.e_renamed.b_renamed("SlowVideoMode", "enableUIView enable: " + z_renamed + ", animation: " + z2);
            com.oplus.camera.ui.control.b_renamed bVarA = this.o_renamed.a_renamed(1);
            if (bVarA != null) {
                this.mCameraUIInterface.a_renamed(bVarA);
            }
            this.mCameraUIInterface.a_renamed(dVar, z2);
            this.mCameraUIInterface.d_renamed(z_renamed, z2);
        }
    }

    private int k_renamed() {
        int configIntValue;
        java.lang.String videoSizeType = getVideoSizeType();
        if ("video_size_1080p".equals(videoSizeType)) {
            configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE);
        } else {
            configIntValue = "video_size_720p".equals(videoSizeType) ? com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE) : 0;
        }
        return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, configIntValue);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        a_renamed(false, false, false);
        if (isMotionDetectOpen()) {
            a_renamed(4);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        if (this.mCameraInterface == null || 1 != this.mCameraInterface.g_renamed() || 1 == i_renamed) {
            return;
        }
        a_renamed(c_renamed(), false, false);
        b_renamed();
        if (isMotionDetectOpen()) {
            a_renamed(0);
        }
    }
}
