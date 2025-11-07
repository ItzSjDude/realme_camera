package com.oplus.camera.capmode;

/* compiled from: DoubleExposureMode.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.camera.capmode.e_renamed implements android.view.View.OnClickListener {
    private boolean A_renamed;
    private boolean B_renamed;
    private final android.content.DialogInterface.OnClickListener C_renamed;
    private com.oplus.camera.doubleexposure.a_renamed D_renamed;
    private final android.content.DialogInterface.OnClickListener E_renamed;
    private com.oplus.camera.capmode.g_renamed.a_renamed g_renamed;
    private com.oplus.camera.capmode.g_renamed.a_renamed h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private java.lang.String m_renamed;
    private java.lang.String n_renamed;
    private com.oplus.camera.doubleexposure.b_renamed o_renamed;
    private com.oplus.camera.doubleexposure.b_renamed p_renamed;
    private com.coui.appcompat.dialog.app.b_renamed q_renamed;
    private int r_renamed;
    private com.oplus.camera.ui.RotateImageView s_renamed;
    private com.oplus.camera.ui.widget.e_renamed t_renamed;
    private boolean u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;
    private boolean x_renamed;
    private long y_renamed;
    private long z_renamed;

    /* compiled from: DoubleExposureMode.java */
    enum a_renamed {
        FIRST_STAGE_PREVIEW,
        FIRST_STAGE_RECORDING,
        FIRST_STAGE_PAUSED,
        SECOND_STAGE_PREVIEW,
        SECOND_STAGE_RECORDING,
        SECOND_STAGE_PAUSED,
        SECOND_STAGE_REPLAY
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        return com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_DOUBLE_EXPOSURE;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32779;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportFaceView() {
        return false;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getVideoSizeType() {
        return "video_size_720p";
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected long getVideoTimeLimit() {
        return 15000L;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isDoubleExposureOpen() {
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isNeedAudioEncode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        return true;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public g_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW;
        this.h_renamed = com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW;
        this.i_renamed = true;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = "";
        this.n_renamed = "";
        this.o_renamed = null;
        this.p_renamed = null;
        this.r_renamed = 0;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = false;
        this.v_renamed = false;
        this.w_renamed = false;
        this.x_renamed = false;
        this.y_renamed = 0L;
        this.z_renamed = 0L;
        this.A_renamed = false;
        this.B_renamed = false;
        this.C_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.capmode.g_renamed.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == com.oplus.camera.capmode.g_renamed.this.f_renamed()) {
                    com.oplus.camera.capmode.g_renamed.this.a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW);
                    com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.aM_renamed();
                    com.oplus.camera.capmode.g_renamed.this.t_renamed();
                    com.oplus.camera.capmode.g_renamed.this.r_renamed();
                    if (com.oplus.camera.capmode.g_renamed.this.l_renamed) {
                        com.oplus.camera.capmode.g_renamed.this.a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE0, "cancel");
                    } else {
                        com.oplus.camera.capmode.g_renamed.this.a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE1, "cancel");
                    }
                } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == com.oplus.camera.capmode.g_renamed.this.f_renamed()) {
                    com.oplus.camera.capmode.g_renamed.this.a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW);
                    com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.aN_renamed();
                    com.oplus.camera.capmode.g_renamed gVar = com.oplus.camera.capmode.g_renamed.this;
                    gVar.a_renamed(gVar.o_renamed, false, null);
                    com.oplus.camera.capmode.g_renamed.this.s_renamed();
                    com.oplus.camera.capmode.g_renamed.this.a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "cancel");
                }
                com.oplus.camera.ui.control.b_renamed shutterButtonInfo = com.oplus.camera.capmode.g_renamed.this.getShutterButtonInfo();
                shutterButtonInfo.c_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == com.oplus.camera.capmode.g_renamed.this.f_renamed());
                com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.a_renamed(shutterButtonInfo);
                com.oplus.camera.capmode.g_renamed.this.p_renamed();
                com.oplus.camera.capmode.g_renamed.this.q_renamed();
            }
        };
        this.D_renamed = new com.oplus.camera.doubleexposure.a_renamed() { // from class: com.oplus.camera.capmode.g_renamed.5
            @Override // com.oplus.camera.doubleexposure.a_renamed
            public void a_renamed() {
                com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "hideBlurView, mState: " + com.oplus.camera.capmode.g_renamed.this.f_renamed());
                if ((com.oplus.camera.capmode.g_renamed.this.f_renamed() == com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW || com.oplus.camera.capmode.g_renamed.this.f_renamed() == com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY) && com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface != null) {
                    com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.aR_renamed();
                    com.oplus.camera.capmode.g_renamed.this.B_renamed = false;
                }
            }
        };
        this.E_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.capmode.g_renamed.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == com.oplus.camera.capmode.g_renamed.this.f_renamed()) {
                    com.oplus.camera.capmode.g_renamed.this.a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "exit");
                }
                if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PAUSED == com.oplus.camera.capmode.g_renamed.this.f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PAUSED == com.oplus.camera.capmode.g_renamed.this.f_renamed()) {
                    com.oplus.camera.capmode.g_renamed.this.stopShortVideoRecording();
                }
                com.oplus.camera.capmode.g_renamed.this.cancelOp(false);
            }
        };
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        return getVideoFrameRate();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        this.mPreviewEffectProcess.k_renamed(this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5));
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        boolean z2 = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
        if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, true) || z2) {
            this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT, this.r_renamed).apply();
        }
        if (z_renamed && z2) {
            this.mCameraUIInterface.k_renamed(5);
        }
        p_renamed();
        q_renamed();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchToMode(boolean z_renamed) {
        super.beforeSwitchToMode(z_renamed);
        a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW);
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        this.B_renamed = false;
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.q_renamed();
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:110:0x019e  */
    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.g_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(strD)) {
            return com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY != f_renamed() && getSupportFunction(strD);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD)) {
            return (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == f_renamed()) ? false : true;
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE.equals(str) && com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed()) {
            b_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_first_video_hint);
            return;
        }
        android.content.SharedPreferences sharedPreferences2 = this.mPreferences;
        java.lang.String str2 = com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_FIRST_GUIDE;
        if (sharedPreferences2 != null && com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS.equals(str)) {
            if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, false)) {
                return;
            }
            b_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_first_video_hint);
            a_renamed(java.lang.String.valueOf(-1), java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - this.z_renamed), com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CLICK, com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_FIRST_GUIDE);
            return;
        }
        if (this.mPreferences != null && com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT.equals(str)) {
            int i_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT, 0);
            boolean z_renamed = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
            if (3 == i_renamed) {
                this.z_renamed = android.os.SystemClock.uptimeMillis();
                this.mCameraUIInterface.a_renamed(this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.load_video_button), 16, 0, this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_tip_offset));
                return;
            } else {
                if (z_renamed || 3 <= i_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW != f_renamed()) {
                    return;
                }
                b_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_first_video_hint);
                return;
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE.equals(str)) {
            if (5 == this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5)) {
                a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_EFFECT, "mixed");
                return;
            } else {
                a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_EFFECT, "silhouette");
                return;
            }
        }
        if (this.mPreferences != null && com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION.equals(str)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION, "");
            java.lang.String[] strArrSplit = android.text.TextUtils.isEmpty(string) ? null : string.split(":");
            if (strArrSplit == null || 2 >= strArrSplit.length) {
                return;
            }
            boolean z2 = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
            java.lang.String str3 = strArrSplit[0];
            java.lang.String str4 = strArrSplit[1];
            java.lang.String str5 = strArrSplit[2];
            if (!z2) {
                str2 = com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_DURABLE_GUIDE;
            }
            a_renamed(str3, str4, str5, str2);
            return;
        }
        if (!com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || !this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").equals("off") || com.oplus.camera.Camera.l_renamed || com.oplus.camera.Camera.m_renamed) {
            return;
        }
        p_renamed();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        this.B_renamed = f_renamed() != com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW;
        this.u_renamed = false;
        this.mCameraUIInterface.f_renamed(16, true);
        h_renamed();
        super.onPause();
    }

    /* compiled from: DoubleExposureMode.java */
    /* renamed from: com.oplus.camera.capmode.g_renamed$4, reason: invalid class name */
    static /* synthetic */ class DoubleExposureMode_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f4270a = new int[com.oplus.camera.capmode.g_renamed.a_renamed.values().length];

        static {
            try {
                f4270a[com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f4270a[com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f4270a[com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed bVar;
        if (com.oplus.camera.capmode.g_renamed.DoubleExposureMode_3.f4270a[f_renamed().ordinal()] == 1) {
            bVar = new com.oplus.camera.ui.control.b_renamed(21, "button_color_inside_none", "button_shape_ring_none", 0);
        } else {
            bVar = super.getShutterButtonInfo();
        }
        bVar.b_renamed(true);
        return bVar;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        super.beforeStartRecording(true);
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$g_renamed$Ab908pFMcIPky9npln3j7gKumG0
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.D_renamed();
            }
        });
        if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING);
            this.i_renamed = false;
            this.mCameraUIInterface.aH_renamed();
        } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING);
            this.i_renamed = false;
            this.mCameraUIInterface.aI_renamed();
            u_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D_renamed() {
        this.mCameraUIInterface.h_renamed(15000);
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
        bVar.a_renamed(22);
        bVar.b_renamed(1);
        bVar.b_renamed(true);
        this.mCameraUIInterface.a_renamed(bVar);
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        displayScreenHintIconInSwitchOn();
        super.afterStartRecording();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed
    protected void onStopVideoRecording(boolean z_renamed) {
        resetTimeUi();
        super.onStopVideoRecording(z_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void stopVideoRecordThread() {
        super.stopVideoRecordThread();
        if (isRecordFileValid()) {
            if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PAUSED == f_renamed()) {
                a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW);
            } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PAUSED == f_renamed()) {
                a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY);
            }
            p_renamed();
            q_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoLoadedDone(com.oplus.camera.doubleexposure.b_renamed bVar, com.oplus.camera.doubleexposure.g_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onVideoLoadedDone, clipVideoInfo: " + bVar);
        this.j_renamed = false;
        this.m_renamed = bVar.c_renamed();
        this.o_renamed = bVar;
        a_renamed(this.o_renamed, aVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoRecordingFinish() {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onVideoRecordingFinish, mState: " + f_renamed());
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PAUSED == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW);
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$g_renamed$4opmBrVgitep2sfakXINTMxGH_s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.C_renamed();
                }
            });
            this.m_renamed = this.mVideoFilename;
            this.o_renamed = new com.oplus.camera.doubleexposure.b_renamed(this.m_renamed);
            a_renamed(this.o_renamed, (com.oplus.camera.doubleexposure.g_renamed.a_renamed) null);
        } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PAUSED == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY);
            j_renamed();
        }
        p_renamed();
        q_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C_renamed() {
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_ring_none", 1);
        bVar.b_renamed(true);
        this.mCameraUIInterface.a_renamed(bVar);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onVideoRecordingFail() {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onVideoRecordingFail, mState: " + f_renamed());
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING == this.g_renamed) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_recording_hint, 3000);
            c_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_recording_hint);
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW);
            b_renamed(false);
        }
        if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed()) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_recording_hint, 3000);
            c_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_recording_hint);
        } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == this.g_renamed) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_recording_hint, 3000);
            c_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_recording_hint);
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW);
            com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_ring_none", 1);
            bVar.b_renamed(true);
            this.mCameraUIInterface.a_renamed(bVar);
            a_renamed(this.o_renamed, (com.oplus.camera.doubleexposure.g_renamed.a_renamed) null);
        }
        p_renamed();
        q_renamed();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.g_renamed.7
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface != null) {
                    com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.q_renamed();
                }
            }
        });
    }

    private void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onSecondStateRecordingFinish, mVideoFilename: " + this.mVideoFilename);
        this.y_renamed = android.os.SystemClock.uptimeMillis();
        this.n_renamed = this.mVideoFilename;
        this.p_renamed = new com.oplus.camera.doubleexposure.b_renamed(this.n_renamed);
        a_renamed("2", this.p_renamed);
        this.mCameraUIInterface.aJ_renamed();
        a_renamed(this.p_renamed, true, null);
        a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "save");
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$g_renamed$QrIApx6ya19IfzkdE1LRi9eT_6E
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.B_renamed();
            }
        });
        displayScreenHintIconInSwitchOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B_renamed() {
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(17, "button_color_inside_none", "button_shape_ring_none", 0);
        bVar.b_renamed(true);
        this.mCameraUIInterface.a_renamed(bVar);
    }

    private void a_renamed(com.oplus.camera.doubleexposure.b_renamed bVar, com.oplus.camera.doubleexposure.g_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onFirstStageDone, clipVideoInfo: " + bVar);
        a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW);
        if (aVar == null) {
            a_renamed("1", bVar);
            this.mCameraUIInterface.aK_renamed();
            a_renamed(bVar, false, null);
            this.l_renamed = false;
            a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE1, "save");
            return;
        }
        a_renamed(bVar, false, new com.oplus.camera.capmode.g_renamed.DoubleExposureMode_4(bVar, aVar));
    }

    /* compiled from: DoubleExposureMode.java */
    /* renamed from: com.oplus.camera.capmode.g_renamed$8, reason: invalid class name */
    class DoubleExposureMode_4 implements com.oplus.camera.doubleexposure.g_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.camera.doubleexposure.b_renamed f4274a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.camera.doubleexposure.g_renamed.a_renamed f4275b;

        DoubleExposureMode_4(com.oplus.camera.doubleexposure.b_renamed bVar, com.oplus.camera.doubleexposure.g_renamed.a_renamed aVar) {
            this.f4274a = bVar;
            this.f4275b = aVar;
        }

        @Override // com.oplus.camera.doubleexposure.g_renamed.a_renamed
        public void onVideoClipDone() {
            com.oplus.camera.capmode.g_renamed.this.a_renamed("0", this.f4274a);
            this.f4275b.onVideoClipDone();
            com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.aK_renamed();
            com.oplus.camera.capmode.g_renamed.this.l_renamed = true;
            com.oplus.camera.capmode.g_renamed.this.a_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE0, "save");
            com.oplus.camera.capmode.g_renamed.this.mHandler.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$g_renamed$8$0efWdS0GwEZU-NkYEKbxO39diSs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.a_renamed();
                }
            }, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a_renamed() {
            com.oplus.camera.capmode.g_renamed.this.p_renamed();
            com.oplus.camera.capmode.g_renamed.this.q_renamed();
        }
    }

    private void b_renamed(final boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onSecondStageDone, isNeedButtonAnim: " + z_renamed);
        t_renamed();
        i_renamed();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$g_renamed$WfuJubcaFTMSvrsIEp1XRw80AJk
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.d_renamed(z_renamed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed bVar;
        if (this.mActivity == null || this.mActivity.isFinishing()) {
            return;
        }
        this.mCameraUIInterface.aL_renamed();
        if (z_renamed) {
            bVar = new com.oplus.camera.ui.control.b_renamed(19, "button_color_inside_red", "button_shape_ring_none", 0);
        } else {
            bVar = new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_ring_none", 1);
        }
        bVar.b_renamed(true);
        this.mCameraUIInterface.a_renamed(bVar);
        this.A_renamed = false;
    }

    private void k_renamed() {
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.g_renamed.9
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.capmode.g_renamed.this.l_renamed();
            }
        }, "clear cache video");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "deleteCacheVideos");
        java.io.File[] fileArrListFiles = new java.io.File(v_renamed()).listFiles(new java.io.FileFilter() { // from class: com.oplus.camera.capmode.g_renamed.10
            @Override // java.io.FileFilter
            public boolean accept(java.io.File file) {
                return file.getName().contains(".mp4");
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (java.io.File file : fileArrListFiles) {
            file.delete();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /* renamed from: onVideoShutterButtonClick */
    public void aj_renamed() {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onVideoShutterButtonClick, mState: " + f_renamed());
        if (o_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onVideoShutterButtonClick, need wait hide blur");
            return;
        }
        if (this.A_renamed) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onVideoShutterButtonClick Cannot record while saving");
            return;
        }
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == f_renamed()) {
            this.A_renamed = true;
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW);
            this.mCurrentVideoValues.put("relative_path", super.getRelativePath());
            this.mCurrentVideoUri = com.oplus.camera.util.storage.a_renamed.a_renamed(this.mActivity, this.mActivity.getContentResolver(), this.mCurrentVideoValues);
            com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$g_renamed$MxAImdDgNZkqG68REGzO_fnvx2A
                @Override // java.lang.Runnable
                public final void run() throws java.lang.Throwable {
                    this.f_renamed$0.A_renamed();
                }
            }, "save-video");
        } else {
            if (this.mCameraUIInterface != null && !getSupportMenu(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING)) {
                this.mCameraUIInterface.e_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING);
            }
            super.aj_renamed();
        }
        if (!this.mbLowBatteryDisabled) {
            p_renamed();
            q_renamed();
        }
        this.B_renamed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x0083 A_renamed[Catch: IOException -> 0x007f, TRY_LEAVE, TryCatch #4 {IOException -> 0x007f, blocks: (B_renamed:34:0x007b, B_renamed:38:0x0083), top: B_renamed:44:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x007b A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void A_renamed() throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            android.app.Activity r1 = r5.mActivity     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            android.net.Uri r2 = r5.mCurrentVideoUri     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.lang.String r3 = "rw"
            android.os.ParcelFileDescriptor r1 = r1.openFileDescriptor(r2, r3)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            r5.mVideoFileDescriptor = r1     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.lang.String r2 = r5.mVideoFilename     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            android.os.ParcelFileDescriptor r3 = r5.mVideoFileDescriptor     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            android.os.FileUtils.copy(r1, r2)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r1.close()     // Catch: java.io.IOException -> L4c
            r2.close()     // Catch: java.io.IOException -> L4c
            goto L57
        L2d:
            r5 = move-exception
            goto L36
        L2f:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L43
        L34:
            r5 = move-exception
            r2 = r0
        L36:
            r0 = r1
            goto L79
        L38:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r1
            r1 = r4
            goto L43
        L3e:
            r5 = move-exception
            r2 = r0
            goto L79
        L41:
            r1 = move-exception
            r2 = r0
        L43:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L4e
            r0.close()     // Catch: java.io.IOException -> L4c
            goto L4e
        L4c:
            r0 = move-exception
            goto L54
        L4e:
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L4c
            goto L57
        L54:
            r0.printStackTrace()
        L57:
            com.oplus.camera.ui.control.e_renamed$d_renamed r0 = new com.oplus.camera.ui.control.e_renamed$d_renamed
            r0.<init>()
            r1 = 1
            r0.k_renamed = r1
            android.net.Uri r2 = r5.mCurrentVideoUri
            r0.d_renamed = r2
            r2 = 0
            java.lang.String r3 = r5.getVideoTitle()
            r5.addVideoToMediaStore(r0, r2, r3)
            r5.closeVideoFileDescriptor()
            r5.n_renamed()
            r5.b_renamed(r1)
            r5.a_renamed(r0)
            return
        L78:
            r5 = move-exception
        L79:
            if (r0 == 0) goto L81
            r0.close()     // Catch: java.io.IOException -> L7f
            goto L81
        L7f:
            r0 = move-exception
            goto L87
        L81:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.io.IOException -> L7f
            goto L8a
        L87:
            r0.printStackTrace()
        L8a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.g_renamed.A_renamed():void");
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        super.onResume(z_renamed);
        if (this.w_renamed && !this.x_renamed) {
            this.w_renamed = false;
            this.x_renamed = false;
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "DoubleExposureMode, onResume, mbNeedRestore");
            return;
        }
        if (this.j_renamed) {
            this.j_renamed = false;
            this.mCameraUIInterface.aL_renamed();
            return;
        }
        int i_renamed = com.oplus.camera.capmode.g_renamed.DoubleExposureMode_3.f4270a[this.g_renamed.ordinal()];
        if (i_renamed == 1) {
            j_renamed();
            return;
        }
        if (i_renamed == 2) {
            b_renamed(false);
            m_renamed();
        } else {
            if (i_renamed != 3) {
                return;
            }
            com.oplus.camera.doubleexposure.b_renamed bVar = this.o_renamed;
            if (bVar != null) {
                a_renamed(bVar, (com.oplus.camera.doubleexposure.g_renamed.a_renamed) null);
                return;
            }
            this.B_renamed = false;
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW);
            b_renamed(false);
        }
    }

    private void m_renamed() {
        if (this.mPreviewEffectProcess != null && this.k_renamed) {
            this.mPreviewEffectProcess.r_renamed();
            this.mPreviewEffectProcess.k_renamed(this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5));
        }
        this.k_renamed = true;
    }

    private void n_renamed() {
        r_renamed();
        s_renamed();
        this.m_renamed = "";
        this.n_renamed = "";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void revertOp() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "revertOp, not a_renamed valid state");
        } else if (o_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "revertOp, need wait hide blur");
        } else {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "revertOp");
            g_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cancelOp(boolean z_renamed) {
        if (o_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "cancelOp, need wait hide blur");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "cancelOp, showDialog: " + z_renamed);
        if (z_renamed) {
            a_renamed(false);
        } else {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW);
            this.mCameraUIInterface.aM_renamed();
            t_renamed();
            r_renamed();
            s_renamed();
            com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
            shutterButtonInfo.c_renamed(true);
            this.mCameraUIInterface.a_renamed(shutterButtonInfo);
        }
        p_renamed();
        q_renamed();
    }

    private boolean o_renamed() {
        return this.B_renamed && com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW != f_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p_renamed() {
        boolean z_renamed = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
        boolean z2 = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, true);
        if (z_renamed || w_renamed() || (z2 && 3 == this.r_renamed && com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW != f_renamed())) {
            c_renamed(!y_renamed());
            c_renamed(!y_renamed());
        } else if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed()) {
            b_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_first_video_hint);
        } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == f_renamed()) {
            b_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_two_video_hint);
        } else {
            c_renamed(!y_renamed());
            c_renamed(!y_renamed());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q_renamed() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$g_renamed$F4tCr_7WQEqiBCbXYiJpcWvyiUM
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.z_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z_renamed() {
        if (this.s_renamed != null && !w_renamed()) {
            if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.s_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
                return;
            } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == f_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.s_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
                return;
            } else {
                com.oplus.camera.util.Util.a_renamed(this.s_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
                return;
            }
        }
        com.oplus.camera.util.Util.a_renamed(this.s_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r_renamed() {
        java.io.File file = new java.io.File(this.m_renamed);
        if (file.exists() && a_renamed(file)) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s_renamed() {
        java.io.File file = new java.io.File(this.n_renamed);
        if (file.exists() && a_renamed(file)) {
            file.delete();
        }
    }

    private boolean a_renamed(java.io.File file) {
        return file.getAbsolutePath().startsWith(v_renamed());
    }

    private void a_renamed(final com.oplus.camera.ui.control.e_renamed.d_renamed dVar) {
        if (this.mCameraInterface != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.g_renamed.11
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.capmode.g_renamed.this.mCameraInterface.a_renamed(dVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t_renamed() {
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.o_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.doubleexposure.b_renamed bVar, boolean z_renamed, com.oplus.camera.doubleexposure.g_renamed.a_renamed aVar) {
        if (this.mbPaused) {
            com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "decodeVideo, cancel decode video, mbPaused: " + this.mbPaused);
            return;
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.a_renamed(new com.oplus.camera.doubleexposure.c_renamed(bVar, z_renamed, aVar, this.D_renamed));
        }
    }

    private void u_renamed() {
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.p_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingPause() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PAUSED);
        } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PAUSED);
        }
        return super.onVideoRecordingPause();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingResume() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PAUSED == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING);
        } else if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PAUSED == this.g_renamed) {
            a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING);
        }
        return super.onVideoRecordingResume();
    }

    public com.oplus.camera.capmode.g_renamed.a_renamed f_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(com.oplus.camera.capmode.g_renamed.a_renamed aVar) {
        this.h_renamed = this.g_renamed;
        this.g_renamed = aVar;
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.g_renamed.12
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface != null) {
                    if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == com.oplus.camera.capmode.g_renamed.this.h_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == com.oplus.camera.capmode.g_renamed.this.g_renamed) {
                        com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.q_renamed();
                    }
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void startLoadVideo(boolean z_renamed) {
        if (this.mbDisplayOnLock) {
            this.u_renamed = true;
            com.oplus.camera.util.Util.aO_renamed();
            return;
        }
        this.u_renamed = false;
        this.j_renamed = true;
        if (this.mPreferences != null && initVideoFileDescriptor()) {
            com.oplus.camera.ui.RotateImageView rotateImageView = this.s_renamed;
            if (rotateImageView != null) {
                com.oplus.camera.util.Util.a_renamed(rotateImageView, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
            }
            b_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ID_VALUE_TO_GALLERY);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CLIP_SAVE_PATH, this.mVideoFilename).apply();
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, false).apply();
            android.content.Intent intent = new android.content.Intent("android.intent.action.PICK", android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.setPackage(com.oplus.camera.util.Util.aP_renamed());
            intent.putExtra("from-Camera-For-Limit", true);
            intent.putExtra("limit_type", 0);
            intent.putExtra("animation_type", 0);
            this.mActivity.startActivityForResult(intent, 11111);
            this.mActivity.overridePendingTransition(com.oplus.camera.R_renamed.anim.gallery_video_in, com.oplus.camera.R_renamed.anim.camera_video_out);
            return;
        }
        this.j_renamed = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setDisplayOnLock(boolean z_renamed) {
        super.setDisplayOnLock(z_renamed);
        if (this.mbDisplayOnLock || !this.u_renamed) {
            return;
        }
        startLoadVideo(false);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected java.lang.String getVideoSavePath() {
        java.lang.String strV;
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING == this.g_renamed || this.j_renamed) {
            strV = v_renamed();
        } else {
            strV = super.getVideoSavePath();
        }
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "getVideoSavePath, path: " + strV + ", mState: " + this.g_renamed);
        return strV;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getRelativePath() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == this.g_renamed || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING == this.g_renamed) {
            return v_renamed();
        }
        return super.getRelativePath();
    }

    private java.lang.String v_renamed() {
        return this.mActivity.getDataDir().getAbsolutePath() + java.io.File.separator + "files" + java.io.File.separator;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean isNeedGenerateUri() {
        return this.i_renamed;
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onInitCameraMode");
        super.onInitCameraMode();
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.g_renamed.2
            @Override // java.lang.Runnable
            public void run() throws java.lang.Exception {
                if (com.oplus.camera.capmode.g_renamed.this.v_renamed) {
                    return;
                }
                com.meicam.sdk.NvsStreamingContext.init(com.oplus.camera.capmode.g_renamed.this.mActivity.getApplicationContext(), "assets:/meicam.lic", 1);
                com.oplus.camera.capmode.g_renamed.this.v_renamed = true;
                if (com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface != null) {
                    com.oplus.camera.capmode.g_renamed.this.mCameraUIInterface.aP_renamed();
                }
            }
        }, "init NvsStreamingContext");
        if (this.mPreferences != null) {
            boolean z_renamed = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
            boolean z2 = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, true);
            if (z_renamed || z2) {
                this.r_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT, 0);
                this.r_renamed++;
            }
        }
        this.t_renamed = (com.oplus.camera.ui.widget.e_renamed) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.video_clip_view);
        x_renamed();
        this.u_renamed = false;
        this.A_renamed = false;
    }

    private boolean w_renamed() {
        if (this.t_renamed == null && this.mActivity != null) {
            this.t_renamed = (com.oplus.camera.ui.widget.e_renamed) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.video_clip_view);
        }
        com.oplus.camera.ui.widget.e_renamed eVar = this.t_renamed;
        return eVar != null && eVar.d_renamed();
    }

    private void b_renamed(int i_renamed) {
        if (this.mCameraUIInterface != null && (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == f_renamed())) {
            this.mCameraUIInterface.a_renamed(i_renamed, 0, false, false, true, false, false, true, 5000, true);
        } else {
            c_renamed(!y_renamed());
        }
    }

    private void c_renamed(boolean z_renamed) {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(true, false, z_renamed);
        }
    }

    private void a_renamed(int i_renamed, int i2) {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(i_renamed, 0, true, false, false, false, false, true, i2, true);
        }
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "onDeInitCameraMode");
        super.onDeInitCameraMode(str);
        com.oplus.camera.ui.RotateImageView rotateImageView = this.s_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        h_renamed();
        this.u_renamed = false;
        this.A_renamed = false;
        this.mCameraUIInterface.aO_renamed();
        this.mCameraUIInterface.e_renamed(5, true);
        this.mCameraUIInterface.aT_renamed();
        k_renamed();
        this.mCameraUIInterface.f_renamed(16, true);
        c_renamed(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == f_renamed()) {
            return (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.effect_menu_zoom_margin_bottom);
        }
        return super.getZoomBarOffset();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z_renamed) {
        com.oplus.camera.e_renamed.e_renamed("DoubleExposureMode", "restoreDefaultMode, isNeedKeepCurrentMode: " + z_renamed);
        super.restoreDefaultMode(z_renamed);
        this.w_renamed = android.text.TextUtils.equals(this.mCameraUIInterface.aV_renamed(), getCameraMode());
        this.x_renamed = z_renamed;
        this.mCameraUIInterface.M_renamed(com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING == f_renamed() || !this.x_renamed);
    }

    public void a_renamed(boolean z_renamed) {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == f_renamed() || z_renamed) {
            h_renamed();
            this.q_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.mActivity).f_renamed(1).setNeutralButton(com.oplus.camera.R_renamed.string.camera_double_exposure_exit_hint, this.E_renamed).setNegativeButton(com.oplus.camera.R_renamed.string.camera_double_exposure_cancel, (android.content.DialogInterface.OnClickListener) null).create();
            if (this.mActivity.isFinishing()) {
                return;
            }
            this.q_renamed.show();
        }
    }

    public void g_renamed() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == f_renamed()) {
            h_renamed();
            this.q_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.mActivity).f_renamed(1).setNeutralButton(com.oplus.camera.R_renamed.string.camera_double_exposure_replay_last_video_hint, this.C_renamed).setNegativeButton(com.oplus.camera.R_renamed.string.camera_double_exposure_cancel, (android.content.DialogInterface.OnClickListener) null).create();
            if (this.mActivity.isFinishing()) {
                return;
            }
            this.q_renamed.show();
        }
    }

    public void h_renamed() {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.q_renamed;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.q_renamed.dismiss();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW != f_renamed()) {
            if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_RECORDING != f_renamed() && com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_RECORDING != f_renamed()) {
                a_renamed(true);
            } else if (this.mRecordingTotalTime >= getRecordingMinTime(false)) {
                this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.video_pause_resume).performClick();
                a_renamed(true);
            }
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopShortVideoRecording() {
        if (isVideoRecordStarted()) {
            aj_renamed();
        } else {
            this.mHandler.removeMessages(10);
            this.mHandler.sendEmptyMessage(10);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        if (this.s_renamed != null) {
            this.s_renamed = null;
        }
        super.onDestroy();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.s_renamed;
        if (rotateImageView != null) {
            rotateImageView.a_renamed(i_renamed, true);
        }
        super.setOrientation(i_renamed);
    }

    private void x_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.s_renamed == null) {
            this.s_renamed = new com.oplus.camera.ui.RotateImageView(this.mActivity);
            this.s_renamed.setId(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry);
            this.s_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_guide_tip);
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_size);
            int settingMenuPanelHeight = com.oplus.camera.util.Util.getSettingMenuPanelHeight() + this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_end);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMargins(0, settingMenuPanelHeight, 0, 0);
            layoutParams.setMarginEnd(dimensionPixelSize2);
            this.s_renamed.setLayoutParams(layoutParams);
            this.s_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$xW5jzJJ1VZaBFepN-Obd1Hssr3U
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f_renamed$0.onClick(view);
                }
            });
        }
        this.mCameraUIInterface.a_renamed((android.view.View) this.s_renamed, com.oplus.camera.aps.constant.ApsConstant.REC_MODE_DOUBLE_EXPOSURE, 3, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onModeShownTips(int i_renamed) {
        c_renamed(i_renamed);
    }

    public void a_renamed(java.lang.String str, java.lang.String str2) {
        if (this.mActivity == null) {
            return;
        }
        com.oplus.camera.statistics.model.DoubleExposureMsgData doubleExposureMsgData = new com.oplus.camera.statistics.model.DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId("funcValue_select");
        doubleExposureMsgData.mFuncKeyId = com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ID_VALUE;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mFuncKeyItem = str;
        doubleExposureMsgData.mFuncKeyValue = str2;
        doubleExposureMsgData.report();
    }

    public void b_renamed(java.lang.String str) {
        if (this.mActivity == null) {
            return;
        }
        com.oplus.camera.statistics.model.DoubleExposureMsgData doubleExposureMsgData = new com.oplus.camera.statistics.model.DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId("funcKey_click");
        doubleExposureMsgData.mFuncKeyId = str;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mFuncKeyResult = java.lang.String.valueOf(2);
        doubleExposureMsgData.report();
    }

    public void a_renamed(java.lang.String str, com.oplus.camera.doubleexposure.b_renamed bVar) {
        if (this.mActivity == null) {
            return;
        }
        com.oplus.camera.statistics.model.DoubleExposureMsgData doubleExposureMsgData = new com.oplus.camera.statistics.model.DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId(com.oplus.camera.statistics.model.DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_VIDEO_CLIP);
        doubleExposureMsgData.mPageId = str;
        doubleExposureMsgData.mOrientation = this.mOrientation;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        if (bVar != null) {
            if (!bVar.h_renamed()) {
                doubleExposureMsgData.mVideoTime = java.lang.String.valueOf(bVar.e_renamed() - bVar.d_renamed());
                doubleExposureMsgData.mVideoRecMode = bVar.b_renamed();
                doubleExposureMsgData.mVideoFps = java.lang.String.valueOf(bVar.a_renamed());
                doubleExposureMsgData.report();
                return;
            }
            a_renamed(doubleExposureMsgData, bVar);
        }
    }

    private void a_renamed(final com.oplus.camera.statistics.model.DoubleExposureMsgData doubleExposureMsgData, final com.oplus.camera.doubleexposure.b_renamed bVar) {
        if (bVar == null || android.text.TextUtils.isEmpty(bVar.c_renamed())) {
            return;
        }
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.g_renamed.3
            @Override // java.lang.Runnable
            public void run() throws java.io.IOException, java.lang.IllegalArgumentException {
                try {
                    android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(bVar.c_renamed());
                    doubleExposureMsgData.mVideoFps = java.lang.String.valueOf(mediaMetadataRetriever.extractMetadata(20));
                    doubleExposureMsgData.mVideoTime = java.lang.String.valueOf(mediaMetadataRetriever.extractMetadata(9));
                    java.lang.String strValueOf = java.lang.String.valueOf(mediaMetadataRetriever.extractMetadata(18));
                    java.lang.String strValueOf2 = java.lang.String.valueOf(mediaMetadataRetriever.extractMetadata(19));
                    mediaMetadataRetriever.release();
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    stringBuffer.append(strValueOf2);
                    stringBuffer.append("x_renamed");
                    stringBuffer.append(strValueOf);
                    doubleExposureMsgData.mVideoRecMode = stringBuffer.toString();
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
                doubleExposureMsgData.report();
            }
        }, "setClipVideoInfo");
    }

    public void i_renamed() {
        if (this.mActivity == null || this.mCurrentVideoUri == null) {
            return;
        }
        com.oplus.camera.statistics.model.DoubleExposureMsgData doubleExposureMsgData = new com.oplus.camera.statistics.model.DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId(com.oplus.camera.statistics.model.DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_VIDEO_PLAYBACK);
        doubleExposureMsgData.mPageId = "2";
        doubleExposureMsgData.mOrientation = this.mOrientation;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mDuration = java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - this.y_renamed);
        doubleExposureMsgData.report();
    }

    private void c_renamed(int i_renamed) {
        com.oplus.camera.statistics.model.ReminderMsgData reminderMsgData = new com.oplus.camera.statistics.model.ReminderMsgData(this.mActivity, false);
        switch (i_renamed) {
            case com.oplus.camera.R_renamed.string.camera_double_exposure_nobody_hint /* 2131755312 */:
                reminderMsgData.mReminderTypeValue = com.oplus.camera.statistics.model.ReminderMsgData.TYPE_ADVICE;
                reminderMsgData.mReminderCodeValue = "no_face";
                break;
            case com.oplus.camera.R_renamed.string.camera_double_exposure_recording_hint /* 2131755313 */:
                reminderMsgData.mReminderTypeValue = com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE;
                reminderMsgData.mReminderCodeValue = com.oplus.camera.statistics.model.ReminderMsgData.CODE_TIME_SHORT;
                break;
            case com.oplus.camera.R_renamed.string.mode_double_exposure_move_closer /* 2131756529 */:
                reminderMsgData.mReminderTypeValue = "bokeh_code";
                reminderMsgData.mReminderCodeValue = com.oplus.camera.statistics.model.ReminderMsgData.CODE_MOVE_CLOSER;
                break;
            case com.oplus.camera.R_renamed.string.mode_double_exposure_video_cannot_resolve /* 2131756531 */:
                reminderMsgData.mReminderTypeValue = com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE;
                reminderMsgData.mReminderCodeValue = com.oplus.camera.statistics.model.ReminderMsgData.CODE_VIDEO_UNPARSEABLE;
                break;
            default:
                return;
        }
        reminderMsgData.mCameraId = getProperCameraId(this.mCameraId);
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        reminderMsgData.report();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (this.mActivity == null) {
            return;
        }
        com.oplus.camera.statistics.model.DoubleExposureMsgData doubleExposureMsgData = new com.oplus.camera.statistics.model.DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId(com.oplus.camera.statistics.model.DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_GUIDE_PAGE);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            doubleExposureMsgData.mPageId = com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_VIDEO_OVERLAY;
        } else if (c2 == 1) {
            doubleExposureMsgData.mPageId = com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_SCENE_VIDEO;
        } else if (c2 == 2) {
            doubleExposureMsgData.mPageId = com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_PORTRAIT_VIDEO;
        } else {
            doubleExposureMsgData.mPageId = com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_GUIDE_GALLERY;
        }
        doubleExposureMsgData.mPageDuration = str2;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mExitType = str3.trim();
        doubleExposureMsgData.mOpenType = str4;
        doubleExposureMsgData.report();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        if (dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData) {
            com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData = (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
            if (5 == this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5)) {
                videoRecordMsgData.mDoubleExposureEffect = "mixed";
            } else {
                videoRecordMsgData.mDoubleExposureEffect = "silhouette";
            }
        }
        return dcsMsgData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view.getId() != com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry || this.mCameraUIInterface == null || this.mCameraInterface == null || this.mCameraInterface.F_renamed()) {
            return;
        }
        b_renamed(com.oplus.camera.statistics.model.DoubleExposureMsgData.KEY_FUNC_ID_VALUE_i);
        this.mCameraUIInterface.k_renamed(5);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean shouldHideBlur() {
        boolean z_renamed = (f_renamed() == com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW || f_renamed() == com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY) ? false : true;
        com.oplus.camera.e_renamed.a_renamed("DoubleExposureMode", "shouldHideBlur, shouldHideBlur: " + z_renamed);
        return z_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        return com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == f_renamed();
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (!needUpdateFlashIcon()) {
            this.mCameraUIInterface.a_renamed(false, true, true);
        } else {
            super.displayScreenHintIconInSwitchOn();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUpdateFlashIcon() {
        return (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_PREVIEW == f_renamed() || com.oplus.camera.capmode.g_renamed.a_renamed.SECOND_STAGE_REPLAY == f_renamed()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        android.view.View viewFindViewById = this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.load_video_button);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView = this.s_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        this.mCameraUIInterface.e_renamed(5, true);
    }

    @Override // com.oplus.camera.capmode.e_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        android.view.View viewFindViewById = this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.load_video_button);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView = this.s_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(0);
        }
        p_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAllowSwitch(com.oplus.camera.d_renamed.a_renamed aVar) {
        if (aVar == com.oplus.camera.d_renamed.a_renamed.MODE && this.g_renamed != com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW) {
            com.oplus.camera.e_renamed.f_renamed("DoubleExposureMode", "isAllowSwitch, not preview state, can't_renamed swith mode.");
            return false;
        }
        return super.isAllowSwitch(aVar);
    }

    private boolean y_renamed() {
        return this.mCameraUIInterface != null && isVideoFlashTorchOpen() && needUpdateFlashIcon();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideHeadLine() {
        if (com.oplus.camera.capmode.g_renamed.a_renamed.FIRST_STAGE_PREVIEW != f_renamed() || w_renamed()) {
            return true;
        }
        return super.isHideHeadLine();
    }
}
