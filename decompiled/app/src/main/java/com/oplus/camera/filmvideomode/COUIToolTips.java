package com.oplus.camera.filmvideomode;

/* compiled from: MovieMode.java */
/* loaded from: classes2.dex */
public class s_renamed extends com.oplus.camera.capmode.w_renamed implements com.oplus.camera.filmvideomode.a_renamed.BaseFilmUIControl_2 {
    com.oplus.camera.p_renamed.a_renamed g_renamed;
    private com.oplus.camera.filmvideomode.a_renamed h_renamed;
    private com.oplus.camera.p_renamed i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private boolean m_renamed;
    private int n_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean enterNeedShutterButtonAlphaTransition() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return "movie";
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public java.lang.String getDefaultVideoCodec() {
        return com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String getGuideLineKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected int getVideoFrameRate() {
        return 30;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCropX() {
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isMovieMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedSetRecordingMargin() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSloganForceLandscape() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setFlashState() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean supportParameterAdjust() {
        return true;
    }

    public s_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.h_renamed = null;
        this.i_renamed = null;
        this.g_renamed = null;
        this.j_renamed = com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH;
        this.k_renamed = com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT;
        this.l_renamed = com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT;
        this.m_renamed = false;
        this.n_renamed = -1;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.a_renamed("FilmVideoMode", "onInitCameraMode");
        this.m_renamed = false;
        this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.s_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.filmvideomode.s_renamed.this.d_renamed();
            }
        });
        super.onInitCameraMode();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("FilmVideoMode", "onDeInitCameraMode");
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.v_renamed();
            this.h_renamed.w_renamed();
        }
        this.mCameraUIInterface.al_renamed();
        if (this.h_renamed != null) {
            this.mCameraUIInterface.N_renamed();
            this.h_renamed.a_renamed(this.mCameraRootView);
            this.mCameraUIInterface.ah_renamed();
            this.mCameraUIInterface.a_renamed(false, true, true);
            this.mCameraUIInterface.ar_renamed();
        }
        com.oplus.camera.p_renamed pVar = this.i_renamed;
        if (pVar != null) {
            pVar.c_renamed();
        }
        super.onDeInitCameraMode(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x010e  */
    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.filmvideomode.s_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.Byte getMovieHdrEnable() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR)) {
            return java.lang.Byte.valueOf(i_renamed() ? (byte) 1 : (byte) 0);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return g_renamed() ? 32932 : 32931;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (g_renamed()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_STABILIZATION_MODE, com.oplus.ocs.camera.CameraParameter.VideoStabilizationMode.VIDEO_STABILIZATION);
        }
        java.lang.Byte movieHdrEnable = getMovieHdrEnable();
        if (movieHdrEnable != null) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.KEY_MOVIE_HDR_ENABLE, movieHdrEnable);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG)) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.KEY_MOVIE_LOG_ENABLE, java.lang.Byte.valueOf(h_renamed() ? (byte) 1 : (byte) 0));
        }
        if (isVideo10BitOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_10BIT_ENABLE, "on_renamed");
        }
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_BITRATE, java.lang.Integer.valueOf(configVideoBitRate()));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getVideoSizeType() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.MOVIE_MODE_V2) ? "4K" : "video_size_1080p";
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected int configVideoBitRate() {
        if ("4K".equals(getVideoSizeType())) {
            return 80000000;
        }
        return super.configVideoBitRate();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        return (!com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCameraFeature(com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_MOVIE_NO_EIS, this.mCameraId) || g_renamed()) ? "movie" : com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_MOVIE_NO_EIS;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        c_renamed();
        return new android.util.Size(this.j_renamed, this.k_renamed);
    }

    private void c_renamed() {
        android.util.Size sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MOVIE_MODE_PICTURE_SIZE);
        if (sizeConfigValue == null) {
            sizeConfigValue = com.oplus.camera.util.Util.b_renamed(getCameraInfo(this.mCameraId).a_renamed(), 2.3333333333333335d, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);
        }
        if (sizeConfigValue != null) {
            this.j_renamed = sizeConfigValue.getWidth();
            this.k_renamed = sizeConfigValue.getHeight();
            this.l_renamed = (int) (this.k_renamed * (com.oplus.camera.util.Util.getScreenHeight() / this.j_renamed));
        }
        this.mPreviewXScale = com.oplus.camera.util.Util.u_renamed() ? 1.0f : this.l_renamed / com.oplus.camera.util.Util.getScreenWidth();
        com.oplus.camera.e_renamed.a_renamed("FilmVideoMode", "initMovieSize, mPreviewSizeWidth: " + this.j_renamed + ", mPreviewSizeHeight: " + this.k_renamed + ", mDisplayWidth: " + this.l_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed() {
        if (com.oplus.camera.util.Util.g_renamed() == 0) {
            this.mCameraUIInterface.j_renamed();
        }
        if (this.h_renamed == null || com.oplus.camera.util.Util.g_renamed() != this.n_renamed) {
            if (com.oplus.camera.util.Util.u_renamed()) {
                this.h_renamed = new com.oplus.camera.filmvideomode.r_renamed(this.mActivity, this.mOneCamera, this.mCameraInterface, this.mCameraRootView);
            } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.MOVIE_MODE_V2)) {
                this.h_renamed = new com.oplus.camera.filmvideomode.q_renamed(this.mActivity, this.mOneCamera, this.mCameraInterface, this.mCameraRootView);
            } else {
                this.h_renamed = new com.oplus.camera.filmvideomode.p_renamed(this.mActivity, this.mOneCamera, this.mCameraInterface, this.mCameraRootView);
            }
            if ("camera_ultra_wide".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_main")) && this.mOneCamera != null && this.mOneCamera.e_renamed() != null && !this.mOneCamera.e_renamed().s_renamed()) {
                this.h_renamed.a_renamed(false);
            } else {
                this.h_renamed.a_renamed(true);
            }
            this.h_renamed.a_renamed(this);
            this.n_renamed = com.oplus.camera.util.Util.g_renamed();
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM)) {
            l_renamed();
        }
        if (this.mCameraUIInterface != null) {
            b_renamed();
            this.mCameraUIInterface.ai_renamed();
            this.mCameraUIInterface.w_renamed(true);
            this.mCameraUIInterface.al_renamed();
            this.mCameraUIInterface.B_renamed(true);
            this.mCameraUIInterface.g_renamed(true, true);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && android.text.TextUtils.isEmpty(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR, ""))) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_ultra_wide").apply();
        }
        e_renamed();
        this.m_renamed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
        if (this.h_renamed != null) {
            if ("camera_ultra_wide".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_main")) && this.mOneCamera != null && this.mOneCamera.e_renamed() != null && !this.mOneCamera.e_renamed().s_renamed()) {
                this.h_renamed.a_renamed(4, false);
            } else {
                this.h_renamed.a_renamed(4, true);
            }
        }
    }

    private void f_renamed() {
        if (this.h_renamed != null && this.m_renamed && com.oplus.camera.util.Util.g_renamed() == this.n_renamed) {
            return;
        }
        d_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public java.lang.String getVideoCodec() {
        return (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG) && h_renamed()) ? com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265 : (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR) && i_renamed()) ? com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265 : com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeConfig() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(false, true, true);
        }
        this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$s_renamed$BoVQr2c3WiKG91U5VkdWEIygNoQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.e_renamed();
            }
        });
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.t_renamed();
        }
        if (this.mOneCamera != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG)) {
                this.mOneCamera.a_renamed(h_renamed() ? (byte) 1 : (byte) 0);
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR)) {
                this.mOneCamera.b_renamed(i_renamed() ? (byte) 1 : (byte) 0);
            }
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.s_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.filmvideomode.s_renamed.this.mCameraUIInterface.k_renamed(com.oplus.camera.filmvideomode.s_renamed.this.mPreferences != null && com.oplus.camera.filmvideomode.s_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid"));
            }
        });
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.u_renamed();
        }
        if (com.oplus.camera.util.Util.t_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM)) {
            l_renamed();
        }
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        com.oplus.camera.filmvideomode.a_renamed aVar;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (!this.mbCapModeInit || (aVar = this.h_renamed) == null) {
            return;
        }
        aVar.a_renamed(cameraPreviewResult);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_still_capture_yuv_main".equals(str)) {
            return false;
        }
        if ("type_video_frame".equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        if ("type_preview_frame".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    public void b_renamed() {
        if (this.h_renamed != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.s_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.filmvideomode.s_renamed.this.h_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.f_renamed(), com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MOVIE_ULTRA_WIDE_ANGLE_SUPPORT));
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.p_renamed();
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.N_renamed();
        }
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void readProfile() {
        super.readProfile();
        android.util.Size videoSize = getVideoSize();
        if (videoSize != null) {
            this.mProfile.videoFrameWidth = videoSize.getWidth();
            this.mProfile.videoFrameHeight = videoSize.getHeight();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public android.util.Size getVideoSize() {
        java.util.List<android.util.Size> listK;
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.MOVIE_MODE_V2)) {
            return getPreviewSize(null);
        }
        com.oplus.camera.e_renamed.h_renamed cameraInfo = getCameraInfo(this.mCameraId);
        if (cameraInfo == null || (listK = cameraInfo.K_renamed()) == null) {
            return null;
        }
        return listK.get(0);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) throws android.content.res.Resources.NotFoundException {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE.equals(str) && this.mCameraUIInterface != null && this.mPreferences != null) {
            this.mCameraUIInterface.k_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid"));
        } else if (com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE.equals(str) && this.mCameraUIInterface != null) {
            java.lang.String flashMode = getFlashMode();
            if (com.oplus.camera.Camera.m_renamed || com.oplus.camera.Camera.l_renamed) {
                if (!"off".equals(flashMode)) {
                    if (com.oplus.camera.Camera.m_renamed) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_high_temperature_flash_disable, -1, true, false, false, false, true, true, 3000, false);
                        reportReminderToDcs(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_TEMPS_FLASH);
                    } else if (com.oplus.camera.Camera.l_renamed) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_low_battery_flash_disable, -1, true, false, false, false, true, true, 3000, false);
                        reportReminderToDcs(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_BATTERY_FLASH);
                    }
                    if (this.mPreferences != null) {
                        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off");
                        editorEdit.apply();
                    }
                }
            } else if (this.mOneCamera != null) {
                this.mOneCamera.b_renamed(flashMode);
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
            com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
            if (aVar != null) {
                aVar.l_renamed();
            }
            displayScreenHintIconInSwitchOn();
        } else if (com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM) && this.mPreferences != null && this.i_renamed != null) {
            if (this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, "off").equals("on_renamed")) {
                this.i_renamed.a_renamed((com.oplus.camera.professional.u_renamed.a_renamed) null);
            } else {
                this.i_renamed.b_renamed((com.oplus.camera.professional.u_renamed.a_renamed) null);
            }
        } else if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR) && com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR.equals(str)) {
            if (i_renamed() && h_renamed()) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").apply();
                this.h_renamed.c_renamed(false);
            }
        } else if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG) && com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG.equals(str) && h_renamed() && i_renamed()) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").apply();
            this.h_renamed.d_renamed(false);
        }
        if (this.mCameraUIInterface != null) {
            super.onSharedPreferenceChanged(sharedPreferences, str);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraUIInterface.a_renamed(true, true, false);
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.m_renamed();
        }
        super.beforeStartRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        if (j_renamed()) {
            displayScreenHintIconInSwitchOn();
        }
        super.afterStartRecording();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void onStopVideoRecording(boolean z_renamed) {
        com.oplus.camera.filmvideomode.b_renamed.a_renamed();
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.n_renamed();
        }
        super.onStopVideoRecording(z_renamed);
        if (j_renamed()) {
            displayScreenHintIconInSwitchOn();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_ring_none", 1));
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        f_renamed();
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.o_renamed();
        }
        com.oplus.camera.p_renamed pVar = this.i_renamed;
        if (pVar != null) {
            pVar.d_renamed();
            this.i_renamed.a_renamed();
        }
        super.onResume(z_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.s_renamed();
        }
        com.oplus.camera.p_renamed pVar = this.i_renamed;
        if (pVar != null) {
            pVar.c_renamed();
            this.i_renamed = null;
        }
        super.onDestroy();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        if (this.h_renamed == null) {
            return false;
        }
        int actionIndex = motionEvent.getActionIndex();
        int x_renamed = (int) (motionEvent.getX(actionIndex) + 0.5d);
        int y_renamed = (int) (motionEvent.getY(actionIndex) + 0.5d);
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        boolean z_renamed = currentScreenMode != null && currentScreenMode.r_renamed();
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && !z_renamed) {
            return false;
        }
        this.h_renamed.q_renamed();
        if (getTouchEnable(true, x_renamed, y_renamed)) {
            this.h_renamed.r_renamed();
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (this.mCameraUIInterface != null) {
            if (j_renamed()) {
                this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.flash_torch_hint_icon, false, true, false);
            } else {
                if (com.oplus.camera.Camera.m_renamed || com.oplus.camera.Camera.l_renamed) {
                    return;
                }
                this.mCameraUIInterface.a_renamed(false, true, true);
            }
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isQualcommEndOfStreamNeed() {
        if (!com.oplus.camera.util.Util.C_renamed()) {
            return false;
        }
        byte[] bArrK = this.mOneCamera.e_renamed().k_renamed();
        com.oplus.camera.e_renamed.a_renamed("FilmVideoMode", "isQualcommEndOfStreamNeed, endOfStreamValue: " + java.util.Arrays.toString(bArrK));
        return bArrK != null && bArrK.length > 0;
    }

    private boolean g_renamed() {
        return this.mPreferences != null && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on_renamed").equals("on_renamed");
    }

    private boolean h_renamed() {
        return this.mPreferences != null && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").equals("on_renamed");
    }

    private boolean i_renamed() {
        return this.mPreferences != null && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").equals("on_renamed");
    }

    private boolean j_renamed() {
        return this.mPreferences != null && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").equals(com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH);
    }

    private boolean k_renamed() {
        return this.mPreferences != null && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, "off").equals("on_renamed");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MOVIE_DEFAULT_VIDEO_FRAME_RECORD_SUPPORT) || !(!"camera_ultra_wide".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR, "camera_main")) || is4k() || com.oplus.camera.util.Util.C_renamed() || isSloganOpen());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needLutTexture() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR) && i_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getPreviewDispalyWidth() {
        return this.l_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) {
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        return aVar != null && aVar.a_renamed(i_renamed, i2, getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_MANUAL_EXPOSURE));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getEntryGalleryAnim() {
        return com.oplus.camera.util.Util.t_renamed() ? com.oplus.camera.R_renamed.anim.gallery_in_folder : com.oplus.camera.R_renamed.anim.gallery_movie_mode_in;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public int getDefaultAFMode() {
        if (this.mPreferences == null || !"auto".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto"))) {
            return 0;
        }
        return super.getDefaultAFMode();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z_renamed) {
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.x_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.q_renamed getPreviewOutlineProvider() throws android.content.res.Resources.NotFoundException {
        if (com.oplus.camera.util.Util.t_renamed()) {
            return null;
        }
        c_renamed();
        int screenWidth = com.oplus.camera.util.Util.getScreenWidth();
        int screenHeight = com.oplus.camera.util.Util.getScreenHeight();
        int i_renamed = this.l_renamed;
        int i2 = (screenWidth - i_renamed) / 2;
        return new com.oplus.camera.ui.q_renamed().a_renamed(new android.graphics.Rect(i2, 0, i_renamed + i2, screenHeight + 0), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_preview_corners_radius));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            return aVar.a_renamed(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideo10BitOpen() {
        return (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG) && h_renamed()) || (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR) && i_renamed());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen()) {
            return !needApsToProcessVideoWatermark();
        }
        return super.isUseMediaRecorderNotUseAPS();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHistogramOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM) && k_renamed();
    }

    private void l_renamed() {
        m_renamed();
        com.oplus.camera.p_renamed pVar = this.i_renamed;
        if (pVar == null) {
            this.i_renamed = new com.oplus.camera.p_renamed(this.mActivity, this.mCameraRootView, this.g_renamed);
            this.i_renamed.a_renamed(com.oplus.camera.R_renamed.id_renamed.movie_mode_histogram);
        } else {
            pVar.a_renamed(this.g_renamed, true);
        }
        android.util.Size previewSize = getPreviewSize(null);
        this.i_renamed.a_renamed(com.oplus.camera.p_renamed.a_renamed(previewSize.getWidth(), previewSize.getHeight()));
    }

    private void m_renamed() {
        if (this.g_renamed == null) {
            this.g_renamed = new com.oplus.camera.p_renamed.a_renamed();
            this.g_renamed.f4922a = 12;
        }
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null) {
            currentScreenMode.a_renamed(this.g_renamed);
            return;
        }
        com.oplus.camera.p_renamed.a_renamed aVar = this.g_renamed;
        aVar.f4922a = 12;
        aVar.f4924c = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_histogram_margin_bottom) + com.oplus.camera.util.Util.aG_renamed();
        this.g_renamed.d_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_histogram_margin_left);
        this.g_renamed.e_renamed = 90;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.filmvideomode.a_renamed aVar;
        if ((dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData) && (aVar = this.h_renamed) != null) {
            com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData = (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
            aVar.a_renamed(videoRecordMsgData);
            videoRecordMsgData.mLux = java.lang.String.valueOf(this.mDcsLux);
        }
        return dcsMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onYuvDataReceviced(byte[] bArr) {
        if (this.i_renamed == null || !isHistogramOpen()) {
            return;
        }
        this.i_renamed.a_renamed(bArr);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed.BaseFilmUIControl_2
    public com.oplus.camera.e_renamed.h_renamed a_renamed(int i_renamed) {
        return getCameraInfo(i_renamed);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed.BaseFilmUIControl_2
    public android.graphics.Rect a_renamed() {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode == null) {
            return new android.graphics.Rect(0, 0, 0, 0);
        }
        return currentScreenMode.b_renamed(sizeI.getHeight(), sizeI.getWidth());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.screen.f_renamed.a_renamed getPreferredScreenMode(int i_renamed) {
        if (!com.oplus.camera.util.Util.u_renamed()) {
            return com.oplus.camera.screen.f_renamed.a_renamed.out;
        }
        return com.oplus.camera.screen.f_renamed.a_renamed.rack90;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.screen.f_renamed.a_renamed getLockedScreenMode() {
        if (com.oplus.camera.util.Util.u_renamed()) {
            return com.oplus.camera.screen.f_renamed.a_renamed.rack90;
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.filmvideomode.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.y_renamed();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        float configFloatValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MOVIE_MODE_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue) {
            zoomConfigure.c_renamed(configFloatValue);
        }
        return zoomConfigure;
    }
}
