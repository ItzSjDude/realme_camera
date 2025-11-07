package com.oplus.camera.capmode;

/* compiled from: GroupShotMode.java */
/* loaded from: classes2.dex */
public class i_renamed extends com.oplus.camera.capmode.d_renamed implements com.oplus.camera.d_renamed {
    private int g_renamed;

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        return null;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_GROUP_SHOT;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getDefaultCommonBeautyValue() {
        return 30;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_GROUPSHOT_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFaceBeautyMenuType() {
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 0;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFlashMode() {
        return "off";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 34817;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    public i_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = 0;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        super.onResume(z_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_GROUPSHOT_CUSTOM_BEAUTY;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:10:0x002b  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        /*
            r4 = this;
            android.content.SharedPreferences r0 = r4.mPreferences
            if (r0 == 0) goto L2b
            android.content.SharedPreferences r0 = r4.mPreferences
            android.app.Activity r4 = r4.mActivity
            r1 = 2131755978(0x7f1003ca, float:1.914285E38)
            java.lang.String r4 = r4.getString(r1)
            java.lang.String r1 = "pref_camera_timer_shutter_key"
            java.lang.String r4 = r0.getString(r1, r4)
            java.lang.String r0 = "10"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L20
            java.lang.String r4 = "button_shape_countdown_ten_seconds"
            goto L2d
        L20:
            java.lang.String r0 = "3"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L2b
            java.lang.String r4 = "button_shape_countdown_three_seconds"
            goto L2d
        L2b:
            java.lang.String r4 = "button_shape_ring_none"
        L2d:
            com.oplus.camera.ui.control.b_renamed r0 = new com.oplus.camera.ui.control.b_renamed
            r1 = 1
            r2 = 0
            java.lang.String r3 = "button_color_inside_none"
            r0.<init>(r1, r3, r4, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.i_renamed.getShutterButtonInfo():com.oplus.camera.ui.control.b_renamed");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.i_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.i_renamed.this.mbPaused) {
                    com.oplus.camera.e_renamed.a_renamed("GroupShotMode", "onBeforeSnapping, return after pause");
                    return;
                }
                com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                bVar.a_renamed("button_color_inside_none");
                bVar.a_renamed(4);
                com.oplus.camera.capmode.i_renamed.this.mCameraUIInterface.a_renamed(bVar);
            }
        });
        this.mbCheckTakeAnimateDelay = false;
        return true;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:59:0x00d2  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.i_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isSuperClearPortraitOpen() {
        return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, "off"));
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (20 == this.g_renamed) {
            return true;
        }
        return super.getZSLMode();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewDecisionResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        this.g_renamed = cameraApsDecision.mApsDecisionFeatureType;
        super.onPreviewDecisionResult(cameraApsDecision);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed afVar = new com.oplus.camera.af_renamed();
        afVar.t_renamed(false);
        afVar.b_renamed(false);
        afVar.h_renamed(false);
        afVar.c_renamed(false);
        afVar.f_renamed(false);
        afVar.p_renamed(true);
        return afVar;
    }
}
