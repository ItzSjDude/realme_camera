package com.oplus.camera.capmode;

/* compiled from: UltraHighResolutionMode.java */
/* loaded from: classes2.dex */
public class v_renamed extends com.oplus.camera.capmode.d_renamed {
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected boolean isNightAlgoCaptureTriggered() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isUltraHighResolutionOpened() {
        return true;
    }

    public v_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return com.oplus.camera.util.Util.av_renamed();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:80:0x0126  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.v_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU) ? com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_HIGH_RESOLUTION_FILTER_INDEX : super.getFilterEffectMenuPreferenceKey();
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

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int i_renamed) {
        super.onFilterItemChange(i_renamed);
        a_renamed(i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        if ("on_renamed".equals(getFlashMode())) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off").apply();
            updateFlashState("off");
        }
        super.onInitCameraMode();
    }

    private void a_renamed(int i_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 4;
        menuClickMsgData.mItemValue = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(i_renamed, this.mCameraId);
        menuClickMsgData.mCameraEnterType = java.lang.String.valueOf(1);
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        menuClickMsgData.mOrientation = this.mOrientation;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z_renamed) {
        com.oplus.camera.ui.inverse.e_renamed.INS.setPositionRatio(this.mActivity, 0.5f, z_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData ? (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            captureMsgData.mFilterType = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(getCurrFilterIndex(), this.mCameraId);
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return com.oplus.camera.util.Util.b_renamed(hVar.a_renamed(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected android.util.Size getUltraPictureSize(java.lang.String str) {
        return com.oplus.camera.util.Util.b_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(str), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        if (isSatOpen()) {
            return super.getZoomConfigure();
        }
        com.oplus.camera.af_renamed afVar = new com.oplus.camera.af_renamed();
        afVar.a_renamed(isCaptureModeType());
        afVar.b_renamed(false);
        afVar.s_renamed(true);
        afVar.h_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA));
        return afVar;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (this.mPreferences == null) {
            return -1;
        }
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if ("camera_main".equals(string)) {
            return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_switch_main);
        }
        if ("camera_ultra_wide".equals(string)) {
            if (java.lang.Float.compare(this.mOneCamera.e_renamed().n_renamed(), 0.0f) == 0) {
                return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_switch_ultra_wide);
            }
            return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_switch_ultra_wide_micro_lens);
        }
        if ("camera_tele".equals(string)) {
            return com.oplus.camera.R_renamed.string.camera_switch_tele;
        }
        return -1;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        if (this.mOneCamera != null) {
            this.mOneCamera.v_renamed(true);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getPhotoRatio() {
        return this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_picture_size_standard);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(cVar);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }
}
