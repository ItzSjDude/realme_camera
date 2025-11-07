package com.oplus.camera.capmode;

/* compiled from: MacroMode.java */
/* loaded from: classes2.dex */
public class n_renamed extends com.oplus.camera.capmode.BaseMode {
    private boolean g_renamed;
    private int h_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32934;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public n_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = false;
        this.h_renamed = 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed.b_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return com.oplus.camera.util.Util.b_renamed(hVar.a_renamed(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if (sharedPreferences == null) {
            return;
        }
        if (!com.oplus.camera.Camera.m_renamed && !com.oplus.camera.Camera.l_renamed) {
            if (this.mCameraUIInterface.k_renamed().b_renamed() && com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed())) {
                if ("off".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off"))) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_off, -1, true, true, false);
                } else {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_torch, -1, true, true, false);
                }
            }
            if (this.mActivity == null) {
                return;
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str)) {
                if ("off".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
                    b_renamed();
                } else {
                    a_renamed();
                }
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str) && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"))) {
            a_renamed();
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (!isFlashState() && this.g_renamed) {
            this.g_renamed = false;
        } else {
            super.displayScreenHintIconInSwitchOn();
        }
    }

    private void a_renamed() {
        if (this.mCameraUIInterface == null || this.mActivity == null) {
            return;
        }
        this.mCameraUIInterface.b_renamed(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_macro_best_focus_distance_text, java.lang.Integer.valueOf(this.h_renamed)));
    }

    private void b_renamed() {
        if (this.mCameraInterface == null || this.mCameraUIInterface.T_renamed() || this.mActivity == null || this.mOneCamera.e_renamed().s_renamed()) {
            return;
        }
        this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_macro_best_focus_distance_text, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Integer.valueOf(this.h_renamed));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("MacroMode", "onAfterPictureTaken");
        if (this.mCameraInterface == null || !this.mCameraInterface.i_renamed()) {
            return;
        }
        this.mCameraUIInterface.d_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(str)) {
            return false;
        }
        return super.getSupportSubMenu(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x005a  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1957553773: goto L50;
                case -1932966768: goto L46;
                case -1593450737: goto L3c;
                case -408507050: goto L32;
                case 336270991: goto L28;
                case 1599576324: goto L1e;
                case 1706373443: goto L14;
                case 1961723364: goto La;
                default: goto L9;
            }
        L9:
            goto L5a
        La:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = r2
            goto L5b
        L14:
            java.lang.String r0 = "pref_support_capture_preview"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 2
            goto L5b
        L1e:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 5
            goto L5b
        L28:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 4
            goto L5b
        L32:
            java.lang.String r0 = "pref_camera_videoflashmode_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 3
            goto L5b
        L3c:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 6
            goto L5b
        L46:
            java.lang.String r0 = "key_support_show_dim_hint"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = r1
            goto L5b
        L50:
            java.lang.String r0 = "pref_support_raw_post_process"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 7
            goto L5b
        L5a:
            r0 = -1
        L5b:
            switch(r0) {
                case 0: goto L84;
                case 1: goto L84;
                case 2: goto L84;
                case 3: goto L7e;
                case 4: goto L7d;
                case 5: goto L7d;
                case 6: goto L70;
                case 7: goto L63;
                default: goto L5e;
            }
        L5e:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        L63:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_raw2yuv"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        L70:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_watermark"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        L7d:
            return r1
        L7e:
            boolean r3 = com.oplus.camera.util.Util.aQ_renamed()
            r3 = r3 ^ r2
            return r3
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.n_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        this.h_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE);
        this.g_renamed = !isFlashState();
        b_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        super.onShutterCallback(z_renamed, z2);
        if (z2) {
            this.mCameraInterface.c_renamed(0);
            this.mCameraInterface.h_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        shutterButtonInfo.b_renamed(0);
        this.mCameraUIInterface.a_renamed(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        if (1 != i_renamed) {
            b_renamed();
        }
    }
}
