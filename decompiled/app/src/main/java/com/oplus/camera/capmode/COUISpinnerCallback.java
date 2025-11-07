package com.oplus.camera.capmode;

/* compiled from: MicroscopeVideoMode.java */
/* loaded from: classes2.dex */
public class p_renamed extends com.oplus.camera.capmode.w_renamed {
    private com.oplus.camera.capmode.s_renamed g_renamed;
    private com.oplus.camera.ui.MicroscopeHintView.a_renamed h_renamed;
    private android.view.View.OnClickListener i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private int l_renamed;
    private int m_renamed;
    private android.widget.TextView n_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_MICROSCOPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getEffectMenuKeyByMode() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_ANC_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return com.oplus.camera.R_renamed.string.camera_filter_effect;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFlashMode() {
        return com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean getNeedReduceBitRate() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32779;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOrientationRectify() {
        return 180;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMicroscopeMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(android.view.MotionEvent motionEvent) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainRange(float f_renamed) {
        return true;
    }

    public p_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = new com.oplus.camera.capmode.s_renamed();
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = null;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.e_renamed.c_renamed getCaptureRequestTag(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z_renamed);
        captureRequestTag.ac_renamed = true;
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureCompleted(cameraCaptureResult, cVar);
        if (cVar.ac_renamed) {
            this.mCameraInterface.a_renamed(cameraCaptureResult.mIdentity, com.oplus.camera.util.Util.a_renamed(java.lang.System.currentTimeMillis()), false, false, false);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        super.setOrientation(i_renamed);
        if (3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && this.mCameraInterface.i_renamed() && this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf((getJpegOrientation(this.mCameraId, this.mOrientation) + getOrientationRectify()) % 360));
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 95);
            this.mOneCamera.b_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_GPS_LOCATION, (android.hardware.camera2.CaptureRequest.Key) this.mCameraInterface.y_renamed());
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x00ac  */
    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -1808424762: goto La2;
                case -1449790675: goto L97;
                case -1135915663: goto L8d;
                case -867604430: goto L82;
                case -408507050: goto L78;
                case -185556839: goto L6e;
                case -100202123: goto L63;
                case 39023177: goto L58;
                case 86895712: goto L4e;
                case 771732173: goto L43;
                case 1062270711: goto L38;
                case 1082475231: goto L2c;
                case 1433615423: goto L20;
                case 1709159627: goto L15;
                case 1961723364: goto La;
                default: goto L8;
            }
        L8:
            goto Lac
        La:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = r1
            goto Lad
        L15:
            java.lang.String r0 = "pref_video_super_eis_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 4
            goto Lad
        L20:
            java.lang.String r0 = "key_high_picture_size"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 10
            goto Lad
        L2c:
            java.lang.String r0 = "pref_face_detection_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 14
            goto Lad
        L38:
            java.lang.String r0 = "pref_time_lapse_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 1
            goto Lad
        L43:
            java.lang.String r0 = "func_enhancement_video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 12
            goto Lad
        L4e:
            java.lang.String r0 = "key_support_video_high_fps"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 5
            goto Lad
        L58:
            java.lang.String r0 = "func_google_lens"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 13
            goto Lad
        L63:
            java.lang.String r0 = "pref_burst_shot_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 9
            goto Lad
        L6e:
            java.lang.String r0 = "pref_camera_gesture_shutter_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 6
            goto Lad
        L78:
            java.lang.String r0 = "pref_camera_videoflashmode_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 2
            goto Lad
        L82:
            java.lang.String r0 = "key_support_show_soloop"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 11
            goto Lad
        L8d:
            java.lang.String r0 = "pref_ai_scene_key"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 7
            goto Lad
        L97:
            java.lang.String r0 = "pref_super_clear_portrait"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 8
            goto Lad
        La2:
            java.lang.String r0 = "func_ultra_night_video"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lac
            r0 = 3
            goto Lad
        Lac:
            r0 = -1
        Lad:
            switch(r0) {
                case 0: goto Lb6;
                case 1: goto Lb5;
                case 2: goto Lb5;
                case 3: goto Lb5;
                case 4: goto Lb5;
                case 5: goto Lb5;
                case 6: goto Lb5;
                case 7: goto Lb5;
                case 8: goto Lb5;
                case 9: goto Lb5;
                case 10: goto Lb5;
                case 11: goto Lb5;
                case 12: goto Lb5;
                case 13: goto Lb5;
                case 14: goto Lb5;
                default: goto Lb0;
            }
        Lb0:
            boolean r2 = super.getSupportFunction(r3)
            return r2
        Lb5:
            return r1
        Lb6:
            java.lang.String r3 = r2.getCameraMode()
            int r2 = r2.mCameraId
            java.lang.String r0 = "aps_algo_filter"
            boolean r2 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r3, r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.p_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        super.onAfterStartPreview(z_renamed);
        a_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.j_renamed = true;
        this.m_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICRO_GUIDE_ANIM_TYPE);
        sendBoradCastNotifyMicroscopeState(true);
        this.g_renamed.a_renamed(this.mActivity, this.mCameraInterface);
        this.n_renamed = new android.widget.TextView(this.mActivity);
        this.n_renamed.setWillNotDraw(true);
        this.n_renamed.setVisibility(4);
        this.mCameraUIInterface.b_renamed().addView(this.n_renamed, new android.widget.RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.microscope_hint_width), -2));
        this.i_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.capmode.p_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.av_renamed()) {
                    com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.a_renamed(true, true, false);
                }
                if (com.oplus.camera.capmode.p_renamed.this.j_renamed) {
                    com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.p_renamed.this.h_renamed, true, com.oplus.camera.capmode.p_renamed.this.l_renamed);
                }
            }
        };
        this.h_renamed = new com.oplus.camera.ui.MicroscopeHintView.a_renamed() { // from class: com.oplus.camera.capmode.p_renamed.2
            @Override // com.oplus.camera.ui.MicroscopeHintView.a_renamed
            public void a_renamed() {
                if (com.oplus.camera.capmode.p_renamed.this.mbCapModeInit) {
                    com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.p_renamed.this.i_renamed, false, false);
                }
            }

            @Override // com.oplus.camera.ui.MicroscopeHintView.a_renamed
            public void b_renamed() {
                if (com.oplus.camera.capmode.p_renamed.this.mbCapModeInit && !com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.R_renamed() && !com.oplus.camera.capmode.p_renamed.this.isVideoRecording()) {
                    com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.p_renamed.this.i_renamed, true, false);
                }
                com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.al_renamed();
            }

            @Override // com.oplus.camera.ui.MicroscopeHintView.a_renamed
            public void c_renamed() {
                if (com.oplus.camera.capmode.p_renamed.this.mbCapModeInit && !com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.R_renamed() && !com.oplus.camera.capmode.p_renamed.this.isVideoRecording()) {
                    com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.p_renamed.this.i_renamed, true, false);
                }
                com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.al_renamed();
            }
        };
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.g_renamed.a_renamed(this.mActivity);
        this.mCameraUIInterface.a_renamed(this.h_renamed, false, this.l_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        super.onResume(z_renamed);
        this.g_renamed.a_renamed(this.mActivity, this.mCameraInterface);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        super.onDeInitCameraMode(str);
        this.j_renamed = false;
        this.k_renamed = false;
        this.mCameraUIInterface.b_renamed().removeView(this.n_renamed);
        this.mCameraUIInterface.a_renamed(this.h_renamed, false, this.l_renamed);
        this.mCameraUIInterface.a_renamed(this.i_renamed, false, false);
        sendBoradCastNotifyMicroscopeState(false);
        this.g_renamed.a_renamed(this.mActivity);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTouchFocus() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_hint_distance_microscope, -1, true, false, false);
        super.onTouchFocus();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.A_renamed(true);
        zoomConfigure.c_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICROSCOPE_ZOOM_SCALE_VALUE));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        return "type_main_preview_frame".equals(str) && 3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.c_renamed("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return getVideoPreviewSize(getVideoSizeType());
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getVideoSizeType() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICROSCOPE_VIDEO_SIZE);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected android.util.Size getVideoPreviewSize(java.lang.String str) {
        android.util.Size sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICROSCOPE_VIDEO_PREVIEW_SIZE);
        return sizeConfigValue != null ? sizeConfigValue : super.getVideoPreviewSize(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return getPreviewSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed getFilterCategory() {
        return com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Anc;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.f_renamed.d_renamed;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.f_renamed.f6903b;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        super.beforeStartRecording();
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_hint_steady_microscope, -1, false, false, true);
        if (this.mOneCamera != null) {
            if (this.mCameraInterface != null) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf((getJpegOrientation(this.mCameraId, this.mOrientation) + getOrientationRectify()) % 360));
            }
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        this.mCameraUIInterface.a_renamed(this.h_renamed, false, this.l_renamed);
        this.mCameraUIInterface.a_renamed(this.i_renamed, false, false);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void onStopVideoRecording(boolean z_renamed) {
        super.onStopVideoRecording(z_renamed);
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_ring_none", 1));
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_hint_steady_microscope);
        if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
            this.mCameraUIInterface.a_renamed(this.h_renamed, true, this.l_renamed);
        } else {
            this.mCameraUIInterface.a_renamed(this.i_renamed, true, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        this.mCameraUIInterface.a_renamed(this.h_renamed, false, this.l_renamed);
        this.mCameraUIInterface.a_renamed(this.i_renamed, false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) throws android.content.res.Resources.NotFoundException {
        super.onMoreModeHidden(i_renamed);
        a_renamed();
    }

    private void a_renamed() throws android.content.res.Resources.NotFoundException {
        java.lang.String string;
        if (this.k_renamed) {
            if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                this.mCameraUIInterface.a_renamed(this.h_renamed, true, this.l_renamed);
                return;
            } else {
                this.mCameraUIInterface.a_renamed(this.i_renamed, true, false);
                return;
            }
        }
        java.lang.String string2 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step1);
        java.lang.String string3 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step2);
        int i_renamed = this.m_renamed;
        if (i_renamed == 0) {
            string = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step2);
        } else {
            string = i_renamed != 1 ? string3 : this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step2_lift_head);
        }
        android.widget.TextView textView = this.n_renamed;
        if (string2.length() <= string.length()) {
            string2 = string;
        }
        textView.setText(string2);
        this.n_renamed.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.p_renamed.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                com.oplus.camera.capmode.p_renamed pVar = com.oplus.camera.capmode.p_renamed.this;
                pVar.l_renamed = pVar.n_renamed.getHeight();
                com.oplus.camera.capmode.p_renamed.this.k_renamed = true;
                if (com.oplus.camera.capmode.p_renamed.this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                    com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.p_renamed.this.h_renamed, true, com.oplus.camera.capmode.p_renamed.this.l_renamed);
                } else {
                    com.oplus.camera.capmode.p_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.p_renamed.this.i_renamed, true, false);
                }
                com.oplus.camera.capmode.p_renamed.this.n_renamed.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
