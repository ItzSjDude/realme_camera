package com.oplus.camera.capmode;

/* compiled from: LongExposureMode.java */
/* loaded from: classes2.dex */
public class m_renamed extends com.oplus.camera.capmode.BaseMode {
    private final java.lang.Object g_renamed;
    private com.oplus.camera.ui.o_renamed h_renamed;
    private com.oplus.camera.ui.i_renamed i_renamed;
    private android.os.Handler j_renamed;
    private int k_renamed;
    private long l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private com.oplus.camera.longexposure.g_renamed p_renamed;
    private com.oplus.camera.longexposure.d_renamed q_renamed;
    private com.oplus.camera.ui.RotateImageView r_renamed;
    private com.oplus.camera.longexposure.k_renamed s_renamed;
    private com.oplus.camera.longexposure.f_renamed t_renamed;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:2:0x0000. Please report as_renamed an_renamed issue. */
    public void a_renamed(int i_renamed) {
        switch (i_renamed) {
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_LONG_EXPOSURE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32938;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        return false;
    }

    public m_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = new java.lang.Object();
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = 0;
        this.l_renamed = 0L;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = new com.oplus.camera.longexposure.f_renamed() { // from class: com.oplus.camera.capmode.m_renamed.5
            @Override // com.oplus.camera.longexposure.f_renamed
            public void a_renamed(com.oplus.camera.longexposure.j_renamed jVar) {
                com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onSceneMenuItemClick, type：" + jVar.a_renamed());
                com.oplus.camera.capmode.m_renamed.this.s_renamed.b_renamed(jVar.a_renamed());
                com.oplus.camera.capmode.m_renamed.this.s_renamed.a_renamed(jVar.a_renamed(), true);
                com.oplus.camera.capmode.m_renamed.this.mPreferences.edit().putInt("pref_long_exposure_effect_type", jVar.a_renamed()).apply();
                if (com.oplus.camera.capmode.m_renamed.this.mOneCamera != null) {
                    com.oplus.camera.capmode.m_renamed.this.mOneCamera.m_renamed(jVar.a_renamed());
                    com.oplus.camera.capmode.m_renamed.this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
                com.oplus.camera.capmode.m_renamed.this.b_renamed(jVar.a_renamed());
            }

            @Override // com.oplus.camera.longexposure.f_renamed
            public void a_renamed() {
                int iC = com.oplus.camera.capmode.m_renamed.this.p_renamed.c_renamed();
                com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onSceneMenuStateClick, type：" + iC);
                com.oplus.camera.capmode.m_renamed.this.a_renamed(true, true);
                com.oplus.camera.capmode.m_renamed.this.s_renamed.a_renamed(true);
                com.oplus.camera.capmode.m_renamed.this.s_renamed.a_renamed(iC, false);
                com.oplus.camera.capmode.m_renamed.this.b_renamed(true);
                com.oplus.camera.capmode.m_renamed.this.mCameraUIInterface.j_renamed(true, true);
                com.oplus.camera.capmode.m_renamed.this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true).apply();
                com.oplus.camera.capmode.m_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, true);
                com.oplus.camera.capmode.m_renamed.this.h_renamed();
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.n_renamed.f_renamed;
        }
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.p_renamed.b_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.n_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.p_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        if (this.mPreferences == null) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        }
        int i_renamed = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), getFilterNoneIndex());
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)) {
            java.lang.String configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_FILTER_TYPE_DEFAULT);
            java.util.List<java.lang.String> filterTypeList = getFilterTypeList(this.mCameraId);
            if (filterTypeList != null && filterTypeList.contains(configStringValue)) {
                i_renamed = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), filterTypeList.indexOf(configStringValue));
            }
        }
        return com.oplus.camera.util.Util.a_renamed(i_renamed, 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return com.oplus.camera.util.Util.b_renamed(hVar.a_renamed(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onInitCameraMode");
        if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_LONG_EXPOSURE_PARAMS, false)) {
            f_renamed();
        }
        if (this.h_renamed == null) {
            this.h_renamed = new com.oplus.camera.ui.o_renamed(this.mCameraUIInterface, new com.oplus.camera.ui.g_renamed.a_renamed() { // from class: com.oplus.camera.capmode.m_renamed.1
                @Override // com.oplus.camera.ui.g_renamed.a_renamed
                public void a_renamed(boolean z_renamed) {
                    com.oplus.camera.capmode.m_renamed.this.b_renamed();
                }

                @Override // com.oplus.camera.ui.g_renamed.a_renamed
                public void a_renamed() {
                    if (com.oplus.camera.capmode.m_renamed.this.mbPaused) {
                        return;
                    }
                    com.oplus.camera.capmode.m_renamed.this.h_renamed.e_renamed();
                }
            });
        }
        if (this.i_renamed == null) {
            this.i_renamed = new com.oplus.camera.ui.i_renamed(this.mCameraUIInterface, new com.oplus.camera.ui.i_renamed.a_renamed() { // from class: com.oplus.camera.capmode.m_renamed.2
                @Override // com.oplus.camera.ui.i_renamed.a_renamed
                public void a_renamed(boolean z_renamed) {
                    com.oplus.camera.capmode.m_renamed.this.b_renamed();
                }

                @Override // com.oplus.camera.ui.i_renamed.a_renamed
                public void a_renamed() {
                    com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onUpdate");
                    if (com.oplus.camera.capmode.m_renamed.this.mbPaused) {
                        return;
                    }
                    long jB = com.oplus.camera.capmode.m_renamed.this.i_renamed.b_renamed() + 100;
                    if (jB > 360000) {
                        com.oplus.camera.capmode.m_renamed.this.i_renamed.a_renamed();
                        return;
                    }
                    if (jB <= 350000 || com.oplus.camera.R_renamed.string.long_exposure_keep_phone_steady != com.oplus.camera.capmode.m_renamed.this.k_renamed) {
                        com.oplus.camera.capmode.m_renamed.this.i_renamed.e_renamed();
                        return;
                    }
                    com.oplus.camera.capmode.m_renamed.this.h_renamed();
                    com.oplus.camera.capmode.m_renamed.this.a_renamed(com.oplus.camera.R_renamed.string.long_exposure_capture_coming_to_an_end, false, 0, 0);
                    com.oplus.camera.capmode.m_renamed.this.i_renamed.e_renamed();
                }
            });
        }
        if (this.p_renamed == null) {
            this.p_renamed = new com.oplus.camera.longexposure.g_renamed(this.mActivity, this.mPreferences);
            this.p_renamed.a_renamed(this.t_renamed);
        }
        if (this.q_renamed == null) {
            this.q_renamed = new com.oplus.camera.longexposure.d_renamed(this.mActivity);
            this.q_renamed.a_renamed(this.t_renamed);
        }
        this.q_renamed.a_renamed(this.mCameraInterface.u_renamed());
        if (this.j_renamed == null) {
            this.j_renamed = new android.os.Handler() { // from class: com.oplus.camera.capmode.m_renamed.3
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    super.handleMessage(message);
                    int i_renamed = message.what;
                    if (i_renamed != 1) {
                        if (i_renamed != 2) {
                            return;
                        }
                        if (com.oplus.camera.capmode.m_renamed.this.mCameraUIInterface != null && com.oplus.camera.capmode.m_renamed.this.k_renamed != 0) {
                            com.oplus.camera.capmode.m_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.m_renamed.this.k_renamed);
                        }
                        com.oplus.camera.capmode.m_renamed.this.k_renamed = 0;
                        return;
                    }
                    boolean zBooleanValue = ((java.lang.Boolean) message.obj).booleanValue();
                    int i2 = message.arg1;
                    com.oplus.camera.capmode.m_renamed.this.a_renamed(i2, zBooleanValue, message.arg2);
                    if (zBooleanValue) {
                        return;
                    }
                    com.oplus.camera.capmode.m_renamed.this.a_renamed(i2);
                }
            };
        }
        g_renamed();
        e_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onSharedPreferenceChanged, key: " + str);
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "changeModeAllViewWhenAnimation, animationType: " + i_renamed + ", isShow: " + z_renamed);
        if (i_renamed != 3) {
            if (i_renamed == 18 && z_renamed && !isLongExposureSceneMenuOpen()) {
                a_renamed(false, false, false);
                return;
            }
            return;
        }
        if (z_renamed) {
            this.r_renamed.setVisibility(0);
            a_renamed(false, false, true);
            this.mCameraUIInterface.l_renamed(true, false);
            a_renamed(this.p_renamed.d_renamed(), false, 0, 0);
            return;
        }
        this.r_renamed.setVisibility(8);
        if (isLongExposureSceneMenuOpen()) {
            a_renamed(true);
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
            this.s_renamed.b_renamed(true);
        } else {
            a_renamed(true, false);
            h_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        shutterButtonInfo.b_renamed(0);
        this.mCameraUIInterface.a_renamed(shutterButtonInfo);
    }

    private void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "hideLongExposureMenu");
        com.oplus.camera.longexposure.g_renamed gVar = this.p_renamed;
        if (gVar != null) {
            gVar.a_renamed(false);
            this.p_renamed.b_renamed(z_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.longexposure.g_renamed gVar;
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "showLongExposureMenu  isMoreModeShown: " + this.mCameraUIInterface.R_renamed());
        if (this.mCameraUIInterface.R_renamed() || this.mCameraUIInterface.A_renamed() || (gVar = this.p_renamed) == null) {
            return;
        }
        gVar.a_renamed(true);
        this.p_renamed.c_renamed(z_renamed);
    }

    private void e_renamed() {
        if (this.s_renamed == null) {
            this.s_renamed = new com.oplus.camera.longexposure.k_renamed(this.mActivity, this.mPreferences, this.j_renamed, this.mCameraInterface, this.mCameraUIInterface);
            this.s_renamed.a_renamed(this.p_renamed.c_renamed());
        }
        this.s_renamed.d_renamed(this.mCameraInterface.u_renamed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "hideLongExposureIcon");
        com.oplus.camera.longexposure.d_renamed dVar = this.q_renamed;
        if (dVar != null) {
            dVar.a_renamed(z_renamed, z2);
        }
    }

    private void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        com.oplus.camera.longexposure.d_renamed dVar;
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "showLongExposureIcon, isMoreModeShown: " + this.mCameraUIInterface.R_renamed());
        if (this.mCameraUIInterface.R_renamed() || this.mCameraUIInterface.A_renamed() || (dVar = this.q_renamed) == null) {
            return;
        }
        dVar.a_renamed(z_renamed, z2, z3);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onBeforePreview");
        if (this.mOneCamera != null) {
            this.mOneCamera.m_renamed(this.p_renamed.c_renamed());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (isLongExposureSceneMenuOpen()) {
            return false;
        }
        return super.supportBeautyButton();
    }

    private void f_renamed() {
        this.mPreferences.edit().remove("pref_long_exposure_effect_type").apply();
        this.mPreferences.edit().remove("pref_long_exposure_streamer_portrait_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_busy_traffic_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_flowing_clouds_and_water_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_light_painting_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_moving_crowd_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_streamer_portrait_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_busy_traffic_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_flowing_clouds_and_water_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_light_painting_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_moving_crowd_auto_key").apply();
        this.mPreferences.edit().remove("pref_key_long_exposure_exposure_time").apply();
        this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_LONG_EXPOSURE_PARAMS).apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onAfterStartPreview");
        if (isLongExposureSceneMenuOpen()) {
            this.s_renamed.a_renamed(this.p_renamed.c_renamed(), false);
            b_renamed(false);
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true).apply();
            this.s_renamed.a_renamed(false);
            return;
        }
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        this.q_renamed.a_renamed(true);
        this.mCameraUIInterface.l_renamed(true, false);
        this.mCameraInterface.d_renamed(true);
        a_renamed(this.p_renamed.d_renamed(), false, 0, 0);
        if (this.mCameraUIInterface.A_renamed()) {
            return;
        }
        this.mCameraInterface.a_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onBeforeSnapping");
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.m_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                if (!com.oplus.camera.capmode.m_renamed.this.mbPaused) {
                    com.oplus.camera.capmode.m_renamed.this.j_renamed();
                    com.oplus.camera.capmode.m_renamed.this.mCameraUIInterface.d_renamed(0, true);
                    com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                    bVar.a_renamed("button_color_inside_none");
                    if (com.oplus.camera.capmode.m_renamed.this.c_renamed()) {
                        com.oplus.camera.capmode.m_renamed.this.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady, false, 0, 0);
                        int iC = (int) (com.oplus.camera.capmode.m_renamed.this.s_renamed.c_renamed(com.oplus.camera.capmode.m_renamed.this.p_renamed.c_renamed()) * 1000.0f);
                        com.oplus.camera.capmode.m_renamed.this.mCameraUIInterface.h_renamed(iC);
                        com.oplus.camera.capmode.m_renamed.this.h_renamed.a_renamed(iC);
                        com.oplus.camera.capmode.m_renamed.this.h_renamed.c_renamed();
                        com.oplus.camera.capmode.m_renamed.this.h_renamed.e_renamed();
                        bVar.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 33 : 7);
                    } else {
                        com.oplus.camera.capmode.m_renamed.this.a_renamed(com.oplus.camera.R_renamed.string.long_exposure_keep_phone_steady, false, 0, 0);
                        com.oplus.camera.capmode.m_renamed.this.mCameraUIInterface.h_renamed(com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_FILE);
                        com.oplus.camera.capmode.m_renamed.this.i_renamed.b_renamed(100L);
                        com.oplus.camera.capmode.m_renamed.this.i_renamed.c_renamed();
                        bVar.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 35 : 30);
                    }
                    com.oplus.camera.capmode.m_renamed.this.mCameraUIInterface.a_renamed(bVar);
                    return;
                }
                com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onBeforeSnapping, return after pause");
            }
        });
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
            this.mOneCamera.b_renamed(true, false);
            this.mOneCamera.a_renamed(1, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), false);
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.n_renamed(true);
        }
        this.m_renamed = false;
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        com.oplus.camera.longexposure.k_renamed kVar = this.s_renamed;
        if (kVar != null) {
            kVar.d_renamed(i_renamed);
        }
        com.oplus.camera.longexposure.d_renamed dVar = this.q_renamed;
        if (dVar != null) {
            dVar.a_renamed(i_renamed);
        }
        this.r_renamed.a_renamed(i_renamed, true);
        super.setOrientation(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        if (com.oplus.camera.util.Util.ao_renamed()) {
            this.mCameraInterface.c_renamed(6);
        } else {
            this.mCameraInterface.c_renamed(4);
        }
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, int i4) {
        if (this.h_renamed.d_renamed()) {
            this.h_renamed.a_renamed();
        } else if (this.i_renamed.d_renamed()) {
            this.i_renamed.a_renamed();
        }
        super.onPictureCallback(bArr, i_renamed, i2, i3, z_renamed, i4);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureFailed(captureRequest, cVar);
        this.o_renamed = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureCompleted(cameraCaptureResult, cVar);
        this.o_renamed = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onAfterPictureTaken");
        this.mCameraInterface.aJ_renamed();
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.n_renamed(false);
        }
        i_renamed();
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
            this.mOneCamera.b_renamed(false, false);
            this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), false);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onFirstCaptureFrameAdd() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onFirstCaptureFrameAdd");
        this.m_renamed = true;
        this.mCameraUIInterface.a_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onStopTakePicture, mbFirstCaptureFrameAdd: " + this.m_renamed);
        if (this.h_renamed.d_renamed()) {
            if (this.m_renamed) {
                this.h_renamed.a_renamed();
            }
            return true;
        }
        if (this.i_renamed.d_renamed()) {
            if (this.m_renamed) {
                this.i_renamed.a_renamed();
            }
            return true;
        }
        h_renamed();
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onPause");
        this.n_renamed = false;
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed("type_still_capture_raw", false);
        }
        this.m_renamed = false;
        this.mCameraUIInterface.d_renamed(8, false);
        if (this.h_renamed.d_renamed()) {
            this.h_renamed.a_renamed();
        } else if (this.i_renamed.d_renamed()) {
            this.i_renamed.a_renamed();
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.n_renamed(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onDeInitCameraMode");
        if (this.j_renamed.hasMessages(1)) {
            this.j_renamed.removeMessages(1);
        }
        h_renamed();
        this.s_renamed.b_renamed(true);
        a_renamed(true);
        a_renamed(false, false);
        h_renamed();
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)).apply();
        this.mCameraUIInterface.e_renamed(8, true);
        if (this.mOneCamera != null) {
            this.mOneCamera.m_renamed(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onDestroy");
        this.p_renamed = null;
        this.q_renamed = null;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:65:0x00e9  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.m_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
        }
        return super.getSupportMenu(str);
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
        shutterButtonInfo.c_renamed("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed("LongExposureMode", "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.i_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE));
        zoomConfigure.J_renamed(false);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_tuning_data_raw".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return false;
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onSingleTapUp");
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return a_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onMoreModeShown");
        this.s_renamed.b_renamed(false);
        a_renamed(false);
        a_renamed(false, false);
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        com.oplus.camera.ui.RotateImageView rotateImageView = this.r_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        this.mCameraUIInterface.e_renamed(8, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onMoreModeHidden");
        if (isLongExposureSceneMenuOpen()) {
            this.s_renamed.b_renamed(false);
            this.p_renamed.b_renamed(false);
        }
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        a_renamed(false, false, true);
        this.mCameraUIInterface.l_renamed(true, false);
        this.mCameraInterface.a_renamed(true, false);
        this.mCameraInterface.d_renamed(true);
        a_renamed(this.p_renamed.d_renamed(), false, 100, 0);
        com.oplus.camera.ui.RotateImageView rotateImageView = this.r_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        a_renamed(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT) ? com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_INDEX : com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "onEffectMenuPopDown");
        a_renamed(true, true, true);
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.util.List<java.lang.String> onGetSupportSettingList(java.lang.String str, int i_renamed) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            java.util.List<java.lang.String> supportSettingList = getSupportSettingList(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mCameraId);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (supportSettingList != null) {
                for (java.lang.String str2 : supportSettingList) {
                    if (!"on_renamed".equals(str2) && !"auto".equals(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return super.onGetSupportSettingList(str, i_renamed);
    }

    private void g_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.r_renamed == null) {
            this.r_renamed = new com.oplus.camera.ui.RotateImageView(this.mActivity);
            this.r_renamed.setId(com.oplus.camera.R_renamed.id_renamed.long_exposure_parameter_bottom_guide_entry);
            this.r_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_guide_tip);
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_bottom_guide_entry_size);
            int settingMenuPanelHeight = com.oplus.camera.util.Util.getSettingMenuPanelHeight() + this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_bottom_guide_entry_margin_top);
            int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_bottom_guide_entry_margin_end);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMargins(0, settingMenuPanelHeight, 0, 0);
            layoutParams.setMarginEnd(dimensionPixelSize2);
            this.r_renamed.setLayoutParams(layoutParams);
            this.r_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$xx5HLlaTKn40VIrUcJgimvowXQ0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f_renamed$0.a_renamed(view);
                }
            });
        }
        this.r_renamed.a_renamed(this.mCameraInterface.u_renamed(), false);
        this.mCameraUIInterface.a_renamed((android.view.View) this.r_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_LONG_EXPOSURE, 2, false);
    }

    public void a_renamed(android.view.View view) {
        if (view.getId() != com.oplus.camera.R_renamed.id_renamed.long_exposure_parameter_bottom_guide_entry || this.mCameraUIInterface == null || this.mCameraInterface == null || this.mCameraInterface.F_renamed()) {
            return;
        }
        this.mCameraUIInterface.au_renamed();
        k_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed, int i2) {
        if (this.mCameraUIInterface != null) {
            this.k_renamed = i_renamed;
            this.mCameraUIInterface.a_renamed(i_renamed, 0, z_renamed, true, false, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        android.os.Message messageObtainMessage = this.j_renamed.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.arg2 = i3;
        messageObtainMessage.obj = java.lang.Boolean.valueOf(z_renamed);
        this.j_renamed.sendMessageDelayed(messageObtainMessage, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h_renamed() {
        android.os.Message messageObtainMessage = this.j_renamed.obtainMessage();
        messageObtainMessage.what = 2;
        this.j_renamed.sendMessage(messageObtainMessage);
    }

    public boolean a_renamed() {
        if (!this.p_renamed.b_renamed()) {
            return false;
        }
        this.s_renamed.b_renamed(true);
        a_renamed(true);
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        a_renamed(true, true, true);
        this.mCameraUIInterface.l_renamed(true, true);
        this.mCameraInterface.a_renamed(true, true);
        this.mCameraInterface.d_renamed(true);
        a_renamed(this.p_renamed.d_renamed(), false, 0, 0);
        return true;
    }

    private void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "resetAfterPictureTaken");
        h_renamed();
        this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BURST_SHOT));
        this.mCameraUIInterface.d_renamed(8, false);
        this.mCameraUIInterface.g_renamed(0);
        this.mCameraUIInterface.b_renamed(0, com.oplus.camera.util.Util.c_renamed(getPreviewSize(com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), this.mCameraId))));
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
            this.mCameraUIInterface.d_renamed(0);
        }
        this.mCameraUIInterface.f_renamed(0);
        this.mCameraInterface.az_renamed();
        if (this.o_renamed) {
            this.mCameraUIInterface.as_renamed();
            this.o_renamed = false;
        }
        this.mCameraUIInterface.d_renamed(true, false);
        com.oplus.camera.ui.RotateImageView rotateImageView = this.r_renamed;
        if (rotateImageView != null) {
            com.oplus.camera.util.Util.a_renamed(rotateImageView, 0, (android.view.animation.Animation.AnimationListener) null, 250L);
        }
        if (this.n_renamed) {
            this.mCameraUIInterface.u_renamed(true);
            this.n_renamed = false;
            return;
        }
        if (isPanelMode()) {
            this.mCameraUIInterface.a_renamed(0, true);
        } else if (!isShowProPanelMenu()) {
            this.mCameraUIInterface.a_renamed(0, 1);
        }
        if (isLongExposureSceneMenuOpen()) {
            b_renamed(true);
            this.mCameraUIInterface.j_renamed(true, false);
            this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true).apply();
            this.s_renamed.a_renamed(true);
            this.s_renamed.a_renamed(this.p_renamed.c_renamed(), false);
            return;
        }
        this.mCameraUIInterface.l_renamed(true, false);
        this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        a_renamed(false, false, true);
        this.mCameraUIInterface.l_renamed(true, false);
        this.mCameraInterface.a_renamed(true, false);
        this.mCameraInterface.d_renamed(true);
        a_renamed(this.p_renamed.d_renamed(), false, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) && this.mCameraUIInterface.A_renamed()) {
            this.n_renamed = true;
        }
        this.mCameraUIInterface.j_renamed(true, false);
        this.mCameraUIInterface.g_renamed(4);
        this.mCameraUIInterface.b_renamed(4, com.oplus.camera.util.Util.c_renamed(getPreviewSize(com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), this.mCameraId))));
        this.mCameraUIInterface.f_renamed(4);
        if (!this.n_renamed) {
            if (isPanelMode()) {
                this.mCameraUIInterface.a_renamed(4, true);
            } else {
                this.mCameraUIInterface.a_renamed(4, 1);
            }
        }
        a_renamed(true, false);
        a_renamed(true);
        this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        this.s_renamed.b_renamed(true);
        com.oplus.camera.ui.RotateImageView rotateImageView = this.r_renamed;
        if (rotateImageView != null) {
            com.oplus.camera.util.Util.a_renamed(rotateImageView, 8, (android.view.animation.Animation.AnimationListener) null, 250L);
        }
    }

    protected void b_renamed() {
        if (this.mbPaused) {
            com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "captureRawDone, cancel capture after pause");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("LongExposureMode", "captureRawDone");
        synchronized (this.g_renamed) {
            if (this.mOneCamera != null) {
                this.mOneCamera.j_renamed();
            }
        }
        if (c_renamed()) {
            this.l_renamed = d_renamed() - this.h_renamed.b_renamed();
        } else {
            this.l_renamed = this.i_renamed.b_renamed();
        }
        this.mCameraUIInterface.a_renamed(false, false);
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed("type_still_capture_raw", true);
        }
        if (com.oplus.camera.util.Util.ao_renamed()) {
            this.mCameraInterface.c_renamed(7);
        } else {
            this.mCameraInterface.c_renamed(5);
        }
        h_renamed();
        int i_renamed = com.oplus.camera.util.Util.ao_renamed() ? 28 : 4;
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
        bVar.a_renamed("button_color_inside_none");
        bVar.a_renamed(i_renamed);
        this.mCameraUIInterface.a_renamed(bVar);
        this.mCameraUIInterface.d_renamed(8, false);
        a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_process_image_after_capture, false, 0, 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isLongExposureSceneMenuOpen() {
        return this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true);
    }

    public boolean c_renamed() {
        return "auto".equals(this.mPreferences.getString("pref_key_long_exposure_exposure_time", "auto"));
    }

    public int d_renamed() {
        com.oplus.camera.longexposure.g_renamed gVar;
        com.oplus.camera.longexposure.k_renamed kVar = this.s_renamed;
        if (kVar == null || (gVar = this.p_renamed) == null) {
            return 0;
        }
        return (int) (kVar.c_renamed(gVar.c_renamed()) * 1000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        if (i_renamed == 1) {
            menuClickMsgData.mFuncKeyId = 72;
        } else if (i_renamed == 2) {
            menuClickMsgData.mFuncKeyId = 73;
        } else if (i_renamed == 3) {
            menuClickMsgData.mFuncKeyId = 74;
        } else if (i_renamed == 4) {
            menuClickMsgData.mFuncKeyId = 75;
        } else if (i_renamed == 5) {
            menuClickMsgData.mFuncKeyId = 87;
        }
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        menuClickMsgData.mOrientation = this.mOrientation;
        if (c_renamed()) {
            menuClickMsgData.mItemValue = java.lang.String.valueOf(d_renamed());
        } else {
            menuClickMsgData.mItemValue = "manual";
        }
        menuClickMsgData.report();
    }

    private void k_renamed() {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mFuncKeyId = 76;
        menuClickMsgData.mFuncKeyResult = 1;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetAfterCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) {
        if (!this.mbPaused) {
            com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
            com.oplus.camera.longexposure.g_renamed gVar = this.p_renamed;
            if (gVar != null) {
                captureMsgData.mLongExposureType = java.lang.String.valueOf(gVar.c_renamed());
            }
            if (c_renamed()) {
                captureMsgData.mLongExposureSettingTime = java.lang.String.valueOf(d_renamed());
            } else {
                captureMsgData.mLongExposureSettingTime = "manual";
            }
            captureMsgData.mLongExposureTotalCaptureTime = java.lang.String.valueOf(this.l_renamed);
        }
        return dcsMsgData;
    }
}
