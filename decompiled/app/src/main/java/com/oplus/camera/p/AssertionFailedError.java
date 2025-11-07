package com.oplus.camera.p_renamed;

/* compiled from: QuickVideoMode.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.capmode.e_renamed {
    private int g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;
    private java.lang.String j_renamed;
    private android.app.Activity k_renamed;
    private boolean l_renamed;
    private long m_renamed;
    private boolean n_renamed;
    private final java.lang.Runnable o_renamed;

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isCommonVideoMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public b_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = 0;
        this.h_renamed = "off";
        this.i_renamed = "off";
        this.j_renamed = "off";
        this.k_renamed = null;
        this.l_renamed = false;
        this.m_renamed = 0L;
        this.n_renamed = false;
        this.o_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.p_renamed.-$$Lambda$b_renamed$w7uqxdhNf0vfzEdb5qD5evRz1tI
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.n_renamed();
            }
        };
        this.k_renamed = activity;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        return super.onBeforeSnapping(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n_renamed() {
        aj_renamed();
    }

    protected void f_renamed() {
        if (!isVideoRecordStopped()) {
            com.oplus.camera.e_renamed.a_renamed("QuickVideoMode", "mMediaRecorderState is_renamed not RECORD_STOPPED, so return");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("QuickVideoMode", "startQuickVideoRecording");
        this.mRecordingStartTemperature = this.mPreferences.getFloat(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_TEMPERATURE, -1.0f);
        this.mHandler.removeCallbacks(this.o_renamed);
        this.mHandler.post(this.o_renamed);
        if (((android.app.KeyguardManager) this.k_renamed.getApplicationContext().getSystemService("keyguard")).isKeyguardLocked()) {
            this.mbDisplayOnLock = true;
            this.mCameraUIInterface.K_renamed(false);
        } else {
            this.mbDisplayOnLock = false;
        }
        setDisplayOnLock(this.mbDisplayOnLock);
    }

    public void a_renamed(android.util.Size size) {
        b_renamed(1);
        b_renamed(size);
        this.mWaitRecordStarted.close();
    }

    public int g_renamed() {
        return this.g_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    public void setHalStatus(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void setVideoRecordState(int i_renamed) {
        super.setVideoRecordState(i_renamed);
    }

    protected void h_renamed() {
        if (isVideoRecordStarting()) {
            this.mWaitRecordStarted.block();
        }
        if (isVideoRecordStopped()) {
            this.mHandler.removeCallbacks(this.o_renamed);
        } else {
            com.oplus.camera.e_renamed.a_renamed("QuickVideoMode", "stopQuickRecording");
            aj_renamed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0035  */
    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1932966768(0xffffffff8cc94490, float:-3.1010218E-31)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L2b
            r1 = -1221935740(0xffffffffb72abd84, float:-1.0176915E-5)
            if (r0 == r1) goto L21
            r1 = 1640046025(0x61c11dc9, float:4.4529598E20)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "key_quick_video"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = r3
            goto L36
        L21:
            java.lang.String r0 = "pref_inertial_zoom_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = r4
            goto L36
        L2b:
            java.lang.String r0 = "key_support_show_dim_hint"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = r2
            goto L36
        L35:
            r0 = -1
        L36:
            if (r0 == 0) goto L90
            if (r0 == r3) goto L5a
            if (r0 == r2) goto L41
            boolean r5 = super.getSupportFunction(r6)
            return r5
        L41:
            java.lang.String r6 = "pref_camera_videoflashmode_key"
            boolean r6 = r5.getSupportFunction(r6)
            if (r6 == 0) goto L4f
            boolean r6 = r5.isVideoRetentionOpen()
            if (r6 == 0) goto L59
        L4f:
            java.lang.String r6 = "pref_camera_torch_mode_key"
            boolean r5 = r5.getSupportFunction(r6)
            if (r5 == 0) goto L58
            goto L59
        L58:
            r3 = r4
        L59:
            return r3
        L5a:
            android.app.Activity r6 = r5.k_renamed
            if (r6 == 0) goto L90
            android.content.SharedPreferences r6 = r5.mPreferences
            if (r6 == 0) goto L90
            java.lang.String r6 = "com.oplus.quick.video.support"
            boolean r6 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r6)
            if (r6 == 0) goto L90
            android.app.Activity r6 = r5.k_renamed
            r0 = 2131755866(0x7f10035a, float:1.9142623E38)
            java.lang.String r6 = r6.getString(r0)
            android.content.SharedPreferences r0 = r5.mPreferences
            java.lang.String r1 = "pref_long_process_choice_key"
            java.lang.String r0 = r0.getString(r1, r6)
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L8e
            com.oplus.camera.capmode.a_renamed r6 = r5.mCameraInterface
            if (r6 == 0) goto L8e
            com.oplus.camera.capmode.a_renamed r5 = r5.mCameraInterface
            boolean r5 = r5.i_renamed()
            if (r5 == 0) goto L8e
            goto L8f
        L8e:
            r3 = r4
        L8f:
            return r3
        L90:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p_renamed.b_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onVideoTemperatureThresholdChanged(int i_renamed) {
        boolean zIsVideoRecording = isVideoRecording();
        com.oplus.camera.e_renamed.a_renamed("QuickVideoMode", "onVideoTemperatureThresholdChanged, isVideoRecording: " + zIsVideoRecording + ", thresholdLevel: " + i_renamed);
        if (zIsVideoRecording && !this.mCameraInterface.k_renamed() && 1 == i_renamed) {
            com.oplus.camera.e_renamed.a_renamed("QuickVideoMode", "onVideoTemperatureThresholdChanged, stop quick video recording because of_renamed high temperature");
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_stop_video_recording_hint, -1, true, false, false);
            this.mCameraInterface.d_renamed(5);
            this.mEndType = com.oplus.camera.statistics.model.VideoRecordMsgData.END_TYPE_TEMP_COUNT_DOWN_TO_STOP;
            reportReminderToDcs(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_TEMP_STOP_ALL_VIDEO);
        }
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        k_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        k_renamed();
        this.mCameraUIInterface.aC_renamed();
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z_renamed) {
        super.forceStopVideoRecording(z_renamed);
        k_renamed();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed
    protected void showRecordingTimeUI() {
        this.mCameraUIInterface.a_renamed(getRealVideoTimeRatio(), this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.record_quick_time_margin_top), needShowVideoTime(), true);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void startShutterButtonProgress() {
        super.startShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        super.onBeforePictureTaken(bArr, z_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        super.onAfterPictureTaken(bArr, z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        super.onShutterCallback(z_renamed, z2);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void stopShutterButtonProgress() {
        this.mCameraUIInterface.a_renamed(i_renamed());
        super.stopShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setQuickVideoBeforeLockTime(boolean z_renamed) {
        this.m_renamed = this.mRecordingTotalTime;
        this.l_renamed = z_renamed;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData = (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData)) ? null : (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
        if (videoRecordMsgData == null) {
            return null;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT)) {
            videoRecordMsgData.mCaptureMode = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_QUICK_VIDEO;
            videoRecordMsgData.mVideoMode = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_QUICK_VIDEO;
        }
        if (!isVideoRecording()) {
            if (this.l_renamed) {
                long j_renamed = this.mRecordingTotalTime;
                long j2 = this.m_renamed;
                videoRecordMsgData.mLockingTime = j_renamed - j2;
                videoRecordMsgData.mHoldingTime = j2;
                this.l_renamed = false;
            } else {
                videoRecordMsgData.mHoldingTime = this.mRecordingTotalTime;
            }
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    public com.oplus.camera.ui.control.b_renamed i_renamed() {
        java.lang.String str = "button_shape_ring_none";
        if (this.mPreferences != null) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.k_renamed.getString(com.oplus.camera.R_renamed.string.camera_shutter_mode_default_value));
            if (com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return com.oplus.camera.util.Util.ao_renamed() ? new com.oplus.camera.ui.control.b_renamed(23, "button_color_inside_none", str, 0) : new com.oplus.camera.ui.control.b_renamed(1, "button_color_inside_none", str, 0);
    }

    private void b_renamed(android.util.Size size) {
        try {
            this.mProfile = m_renamed();
        } catch (java.lang.Exception e_renamed) {
            this.mProfile = null;
            com.oplus.camera.e_renamed.d_renamed("QuickVideoMode", "initProfile, CamcorderProfile.get fail! ", e_renamed);
        }
        if (this.mProfile == null || size == null) {
            return;
        }
        this.mProfile.videoFrameWidth = size.getWidth();
        this.mProfile.videoFrameHeight = size.getHeight();
        com.oplus.camera.e_renamed.a_renamed("QuickVideoMode", "initProfile, record width: " + this.mProfile.videoFrameWidth + ", record height: " + this.mProfile.videoFrameHeight);
    }

    private android.media.CamcorderProfile m_renamed() {
        android.media.CamcorderProfile camcorderProfile;
        try {
            if (android.media.CamcorderProfile.hasProfile(this.mCameraId, 5)) {
                camcorderProfile = android.media.CamcorderProfile.get(this.mCameraId, 5);
            } else {
                camcorderProfile = android.media.CamcorderProfile.get(this.mCameraId, 4);
            }
            return camcorderProfile;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed("QuickVideoMode", "get CamcorderProfile fail");
            return null;
        }
    }

    public void j_renamed() {
        if (this.mPreferences == null || this.mCameraUIInterface == null || this.mCameraInterface == null) {
            return;
        }
        this.n_renamed = true;
        this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        this.mCameraUIInterface.aD_renamed();
        this.mCameraUIInterface.L_renamed(true);
        showRecordingTimeUI();
        this.mCameraInterface.L_renamed();
        if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, "off"))) {
            this.h_renamed = "on_renamed";
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, "off").apply();
        }
        this.j_renamed = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
        this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, "off").apply();
        this.mCameraUIInterface.a_renamed(true, true, false);
        this.mCameraUIInterface.ab_renamed();
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_gesture_take_picture);
        this.mCameraUIInterface.b_renamed(true);
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, this.k_renamed.getResources().getString(com.oplus.camera.R_renamed.string.camera_torch_mode_default_value));
        if (("on_renamed".equals(string) || "auto".equals(string)) && !getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT) && com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraInterface.aw_renamed())) {
            this.i_renamed = string;
            com.oplus.camera.ui.inverse.e_renamed.INS.setInverseColor((android.content.Context) this.k_renamed, false, false);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, "off").apply();
        }
    }

    public void k_renamed() {
        if (this.mPreferences == null || this.mCameraUIInterface == null || this.mCameraInterface == null) {
            return;
        }
        if ("on_renamed".equals(this.h_renamed)) {
            this.h_renamed = "off";
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, "on_renamed").apply();
        }
        this.mCameraUIInterface.w_renamed();
        this.mCameraInterface.N_renamed();
        com.oplus.camera.ui.widget.LockViewDragLayout.setIsQuickVideoStartedByShutterButtonLongClick(false);
        com.oplus.camera.ui.widget.LockViewDragLayout.setLongPressState(false);
        this.mCameraUIInterface.aa_renamed();
        if (18 == this.mCameraInterface.j_renamed()) {
            this.mCameraUIInterface.m_renamed(18);
        } else {
            this.mCameraInterface.T_renamed();
        }
        if (!"off".equals(this.j_renamed)) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.j_renamed).apply();
            this.j_renamed = "off";
        }
        if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false) && !com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraId)) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_picture_size_standard_high_hint, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Double.valueOf(getDisplayHighPictureSize()));
        }
        this.mCameraUIInterface.aC_renamed();
        this.mCameraUIInterface.l_renamed(false, false);
        stopShutterButtonProgress();
        if (("on_renamed".equals(this.i_renamed) || "auto".equals(this.i_renamed)) && !getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT) && com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraInterface.aw_renamed())) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, this.i_renamed).apply();
            com.oplus.camera.ui.inverse.e_renamed.INS.setInverseColor((android.content.Context) this.k_renamed, "on_renamed".equals(this.i_renamed), false);
            this.i_renamed = "off";
        }
        if (this.mCameraUIInterface.A_renamed()) {
            this.mCameraUIInterface.m_renamed(true, false);
        }
        this.mCameraUIInterface.d_renamed(true, true);
        this.n_renamed = false;
    }

    public boolean l_renamed() {
        return this.n_renamed;
    }

    protected void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("QuickVideoMode", "setHalQuickVideoState state:" + i_renamed);
        c_renamed(i_renamed);
        setHalStatus(i_renamed);
        this.mOneCamera.B_renamed(i_renamed == 0);
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.QUICK_VIDEO_RECORD_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (1 == i_renamed ? "on_renamed" : "off"));
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    private void c_renamed(int i_renamed) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_QUICK_VIDEO_OIS_CONFIG)) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(1 == i_renamed ? 0 : 1));
        }
    }
}
