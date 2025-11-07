package com.oplus.camera.capmode;

/* compiled from: MultiVideoMode.java */
/* loaded from: classes2.dex */
public class q_renamed extends com.oplus.camera.capmode.w_renamed {
    private boolean g_renamed;
    private com.oplus.camera.capmode.a_renamed.a_renamed h_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canShowResumeButton() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_VIDEO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 5;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32812;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMultiVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int i_renamed) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public q_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = true;
        this.h_renamed = null;
        this.h_renamed = new com.oplus.camera.capmode.a_renamed.a_renamed(0, 1, 1);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        this.g_renamed = true;
        if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off"))) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off").apply();
        }
        super.onInitCameraMode();
        com.oplus.camera.gl_renamed.b_renamed.e_renamed.a_renamed().a_renamed((int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_small_surface_start_margin), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_small_surface_top_margin), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_small_surface_end_margin), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_small_surface_bottom_margin));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off").apply();
        super.onResume(z_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        return "type_multi_main_preview_frame".equals(str) || "type_multi_sub_preview_frame".equals(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
            return new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);
        }
        return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_PREVIEW_SIZE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, java.lang.String str) {
        android.util.Size size;
        if (str != null) {
            int i_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1);
            int i2 = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    size = null;
                } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
                    size = a_renamed(str, i_renamed, i2, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);
                } else {
                    android.util.Size sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_PREVIEW_SIZE);
                    size = a_renamed(str, i_renamed, i2, sizeConfigValue.getWidth(), sizeConfigValue.getHeight());
                }
            } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT)) {
                size = new android.util.Size(com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);
            } else {
                android.util.Size sizeConfigValue2 = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_PREVIEW_SIZE);
                size = new android.util.Size(sizeConfigValue2.getWidth() / 2, sizeConfigValue2.getHeight());
            }
            com.oplus.camera.e_renamed.b_renamed("MultiVideoMode", "getPreviewSize, surfaceType: " + str + ", previewSize: " + size);
            return size;
        }
        return getPreviewSize(hVar);
    }

    private android.util.Size a_renamed(java.lang.String str, int i_renamed, int i2, int i3, int i4) {
        com.oplus.camera.e_renamed.h_renamed cameraInfo = getCameraInfo(1);
        java.util.List<android.util.Size> listC = cameraInfo != null ? cameraInfo.C_renamed() : null;
        if (2 == i2) {
            if ("type_multi_main_preview_frame".equals(str)) {
                if (1 == i_renamed) {
                    return new android.util.Size(i3, i4);
                }
                return com.oplus.camera.util.Util.a_renamed(listC, (int) (i3 / 3.0f), (int) (i4 / 3.0f));
            }
            if (!"type_multi_sub_preview_frame".equals(str)) {
                return null;
            }
            if (1 == i_renamed) {
                return com.oplus.camera.util.Util.a_renamed(listC, (int) (i3 / 3.0f), (int) (i4 / 3.0f));
            }
            return new android.util.Size(i3, i4);
        }
        if (1 != i2) {
            return null;
        }
        if ("type_multi_main_preview_frame".equals(str)) {
            if (1 == i_renamed) {
                return new android.util.Size(i3, i4);
            }
            int i5 = (int) (i4 / 2.33f);
            return com.oplus.camera.util.Util.a_renamed(listC, i5, i5);
        }
        if (!"type_multi_sub_preview_frame".equals(str)) {
            return null;
        }
        if (1 == i_renamed) {
            int i6 = (int) (i4 / 2.33f);
            return com.oplus.camera.util.Util.a_renamed(listC, i6, i6);
        }
        return new android.util.Size(i3, i4);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.capmode.a_renamed.a_renamed getMultiCameraDecision() {
        return this.h_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x00b9  */
    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 0
            java.lang.String r2 = "func_face_beauty_process"
            r3 = 1
            switch(r0) {
                case -2070716397: goto Lae;
                case -1789212585: goto La4;
                case -1593450737: goto L99;
                case -1342983725: goto L91;
                case -1111057913: goto L87;
                case -821536541: goto L7c;
                case -408507050: goto L72;
                case -207649060: goto L67;
                case 121201516: goto L5d;
                case 336270991: goto L53;
                case 663120474: goto L47;
                case 1082475231: goto L3b;
                case 1248329464: goto L2f;
                case 1599576324: goto L24;
                case 1658068003: goto L19;
                case 1961723364: goto Ld;
                default: goto Lb;
            }
        Lb:
            goto Lb9
        Ld:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 10
            goto Lba
        L19:
            java.lang.String r0 = "key_multicamera_type_menu_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = r3
            goto Lba
        L24:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = r1
            goto Lba
        L2f:
            java.lang.String r0 = "func_face_slender_process"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 14
            goto Lba
        L3b:
            java.lang.String r0 = "pref_face_detection_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 9
            goto Lba
        L47:
            java.lang.String r0 = "func_out_capture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 12
            goto Lba
        L53:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 2
            goto Lba
        L5d:
            java.lang.String r0 = "pref_support_recording_capture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 6
            goto Lba
        L67:
            java.lang.String r0 = "func_out_preview"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 11
            goto Lba
        L72:
            java.lang.String r0 = "pref_camera_videoflashmode_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 5
            goto Lba
        L7c:
            java.lang.String r0 = "func_out_preview_capture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 13
            goto Lba
        L87:
            java.lang.String r0 = "func_face_beauty_common"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 4
            goto Lba
        L91:
            boolean r0 = r5.equals(r2)
            if (r0 == 0) goto Lb9
            r0 = 3
            goto Lba
        L99:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 15
            goto Lba
        La4:
            java.lang.String r0 = "pref_assist_gradienter"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 7
            goto Lba
        Lae:
            java.lang.String r0 = "pref_camera_assistant_line_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto Lb9
            r0 = 8
            goto Lba
        Lb9:
            r0 = -1
        Lba:
            switch(r0) {
                case 0: goto Ld5;
                case 1: goto Ld5;
                case 2: goto Ld5;
                case 3: goto Ld5;
                case 4: goto Ld5;
                case 5: goto Lcf;
                case 6: goto Lce;
                case 7: goto Lce;
                case 8: goto Lce;
                case 9: goto Lce;
                case 10: goto Lce;
                case 11: goto Lce;
                case 12: goto Lce;
                case 13: goto Lce;
                case 14: goto Lc9;
                case 15: goto Lc2;
                default: goto Lbd;
            }
        Lbd:
            boolean r4 = super.getSupportFunction(r5)
            return r4
        Lc2:
            java.lang.String r4 = "com.oplus.video.watermark.support"
            boolean r4 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            return r4
        Lc9:
            boolean r4 = r4.getSupportFunction(r2)
            return r4
        Lce:
            return r1
        Lcf:
            boolean r4 = com.oplus.camera.util.Util.aQ_renamed()
            r4 = r4 ^ r3
            return r4
        Ld5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.q_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            a_renamed("on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_multicamera_type_default))), true, "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_multicamera_type_need_zoom_default))));
        }
    }

    private void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        a_renamed(z_renamed, z2, z3, true);
        a_renamed();
    }

    private void a_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        if (this.mCameraInterface == null || this.mCameraUIInterface == null) {
            return;
        }
        this.mCameraUIInterface.c_renamed(z_renamed, z2, z4, true);
        if (z_renamed) {
            this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, true);
            if (this.mCameraUIInterface.K_renamed()) {
                this.mCameraUIInterface.a_renamed(z2, true, true, false);
            }
            this.mCameraUIInterface.h_renamed(z2, true);
            this.mCameraUIInterface.j_renamed(z2, true);
            return;
        }
        if (isVideoRecordStarting() || isVideoRecordStarted()) {
            return;
        }
        if (z3) {
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
        }
        if (z3 && supportMenuLeftButton()) {
            this.mCameraUIInterface.i_renamed(z2, true);
        }
        if (supportBeautyButton()) {
            this.mCameraUIInterface.l_renamed(z2, true);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraInterface.a_renamed(true, this.mCameraUIInterface.aA_renamed());
        this.mCameraInterface.d_renamed(true);
        super.beforeStartRecording();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void onStopVideoRecording(boolean z_renamed) {
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_ring_none", 1));
        super.onStopVideoRecording(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        super.afterStartRecording();
        a_renamed(false, true, true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z_renamed) {
        super.restoreDefaultMode(z_renamed);
        if (this.mPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU);
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        this.mCameraUIInterface.c_renamed(false, false, false, true);
        if (this.mCameraUIInterface.aA_renamed()) {
            this.mCameraUIInterface.J_renamed(true);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        int screenWidth;
        int screenWidth2;
        int settingMenuPanelHeight;
        super.onBeforePreview();
        applyBeautyParam();
        int i_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
        int i2 = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1);
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key<java.lang.Integer>>) com.oplus.camera.e_renamed.b_renamed.bf_renamed, (android.hardware.camera2.CaptureRequest.Key<java.lang.Integer>) java.lang.Integer.valueOf((i_renamed == 0 || 1 == i2) ? 1 : 0));
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.s_renamed(i_renamed);
            this.mCameraUIInterface.H_renamed(1 == i2);
            this.mCameraUIInterface.I_renamed(false);
            float fA_renamed = a_renamed(i_renamed);
            android.content.res.Resources resources = this.mActivity.getResources();
            if (com.oplus.camera.util.Util.t_renamed()) {
                int screenHeight = com.oplus.camera.util.Util.u_renamed() ? (int) (com.oplus.camera.util.Util.getScreenHeight() / 1.7777777777777777d) : com.oplus.camera.util.Util.getScreenWidth();
                screenWidth = java.lang.Math.round(screenHeight / fA_renamed);
                int dimension = (int) resources.getDimension(com.oplus.camera.R_renamed.dimen.fold_multicamera_small_surface_end_margin);
                settingMenuPanelHeight = (int) resources.getDimension(com.oplus.camera.R_renamed.dimen.fold_multicamera_small_surface_top_margin);
                screenWidth2 = (screenHeight - dimension) - screenWidth;
            } else {
                int dimension2 = (int) resources.getDimension(com.oplus.camera.R_renamed.dimen.multicamera_small_surface_end_margin);
                int dimension3 = (int) resources.getDimension(com.oplus.camera.R_renamed.dimen.multicamera_small_surface_top_margin);
                screenWidth = (int) (com.oplus.camera.util.Util.getScreenWidth() * (1.0f / fA_renamed));
                screenWidth2 = (com.oplus.camera.util.Util.getScreenWidth() - screenWidth) - dimension2;
                settingMenuPanelHeight = dimension3 + com.oplus.camera.util.Util.getSettingMenuPanelHeight();
            }
            this.mCameraUIInterface.c_renamed(screenWidth2, settingMenuPanelHeight);
            int i3 = (int) (screenWidth * (1 == i_renamed ? 1.0d : 1.7777777777777777d));
            this.mCameraUIInterface.d_renamed(screenWidth, i3);
            com.oplus.camera.e_renamed.b_renamed("MultiVideoMode", "onBeforePreview, state: " + i2 + ", type: " + i_renamed + ", smallSurfaceWidth: " + screenWidth + ", smallSurfaceHeight: " + i3 + ", x_renamed: " + screenWidth2 + ", y_renamed: " + settingMenuPanelHeight);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        a_renamed();
    }

    private void a_renamed() {
        if (this.mCameraUIInterface == null || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            return;
        }
        this.mCameraUIInterface.r_renamed(this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedTransAnimWhenRecording() {
        return this.mCameraUIInterface.aw_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_VIDEO_CUSTOM_BEAUTY;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getDefaultCommonBeautyValue() {
        return isFaceBeautyDefaultOff() ? 0 : 40;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData;
        int properCameraId;
        int properCameraId2;
        if (!(dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData) || this.mPreferences == null) {
            videoRecordMsgData = null;
        } else {
            com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData2 = (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
            int i_renamed = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0);
            if (this.mCameraUIInterface != null && i_renamed != 0) {
                videoRecordMsgData2.mSubScreenValue = java.lang.String.valueOf(this.mCameraUIInterface.az_renamed());
            }
            if (1 == this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1)) {
                int properCameraId3 = getProperCameraId(0);
                properCameraId = getProperCameraId(1);
                properCameraId2 = properCameraId3;
            } else {
                properCameraId = getProperCameraId(0);
                properCameraId2 = getProperCameraId(1);
            }
            videoRecordMsgData2.mScreenCompose = "{main: " + properCameraId2 + ", sub: " + properCameraId + "}";
            videoRecordMsgData2.mScreenMode = java.lang.String.valueOf(i_renamed);
            videoRecordMsgData = videoRecordMsgData2;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        if (!this.g_renamed || this.mCameraUIInterface == null) {
            return;
        }
        this.g_renamed = false;
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_mode_multi_video_switch_tip, 0, true, false, false);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        if (this.mCameraUIInterface != null && this.mCameraUIInterface.aA_renamed()) {
            this.mCameraUIInterface.J_renamed(true);
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(str) && this.mCameraUIInterface.af_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, true, (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m_renamed(false);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    @android.annotation.SuppressLint({"WrongConstant"})
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        com.oplus.camera.e_renamed.h_renamed hVarA = com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), com.oplus.camera.e_renamed.a_renamed.h_renamed());
        com.oplus.camera.e_renamed.h_renamed hVarA2 = com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), com.oplus.camera.e_renamed.a_renamed.i_renamed());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.ocs.camera.CameraDeviceConfig.PreviewConfig(com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN, getPreviewSize(hVarA, "type_multi_main_preview_frame"), 5));
        if (com.oplus.camera.util.Util.g_renamed() == 0) {
            arrayList.add(new com.oplus.ocs.camera.CameraDeviceConfig.PreviewConfig(com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_WIDE, getPreviewSize(hVarA2, "type_multi_sub_preview_frame"), 5));
        } else {
            arrayList.add(new com.oplus.ocs.camera.CameraDeviceConfig.PreviewConfig(com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_MAIN, getPreviewSize(hVarA2, "type_multi_sub_preview_frame"), 5));
        }
        builder.setPreviewConfig(arrayList);
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.KEY_DUAL_SCENE_MASTER, java.lang.Integer.valueOf((this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0) == 0 || 1 == this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, 1)) ? 1 : 0));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        super.onDeInitCameraMode(str);
        this.mCameraUIInterface.c_renamed(false, false, true, this.mCameraUIInterface.aA_renamed());
        if (isPanelMode() || !"position_headline".equals(com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(com.oplus.camera.ui.menu.a_renamed.c_renamed.b_renamed(str)).c_renamed())) {
            return;
        }
        this.mCameraUIInterface.a_renamed(0, 1);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        if ("position_headline".equals(com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(14).c_renamed())) {
            a_renamed(false, false, false, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        a_renamed("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_multicamera_type_default))), false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.screen.f_renamed.a_renamed getPreferredScreenMode(int i_renamed) {
        if (!com.oplus.camera.util.Util.u_renamed()) {
            return com.oplus.camera.screen.f_renamed.a_renamed.out;
        }
        if (270 == i_renamed) {
            return com.oplus.camera.screen.f_renamed.a_renamed.full90;
        }
        if (90 == i_renamed) {
            return com.oplus.camera.screen.f_renamed.a_renamed.full270;
        }
        return com.oplus.camera.screen.f_renamed.a_renamed.full;
    }

    public static float a_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return 1.0f;
        }
        boolean z_renamed = 1 == i_renamed;
        return com.oplus.camera.util.Util.t_renamed() ? com.oplus.camera.util.Util.u_renamed() ? z_renamed ? 2.13f : 2.68f : z_renamed ? 2.09f : 2.63f : z_renamed ? 2.33f : 3.0f;
    }
}
