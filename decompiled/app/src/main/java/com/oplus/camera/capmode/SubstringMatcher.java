package com.oplus.camera.capmode;

/* compiled from: HighPixelMode.java */
/* loaded from: classes2.dex */
public class k_renamed extends com.oplus.camera.capmode.d_renamed {
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_PIXEL;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isHighPictureSize() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isUltraWideHighPictureSize() {
        return false;
    }

    public k_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:92:0x0156  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.k_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_HIGH_PIXEL.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(str)) {
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
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
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_HIGH_PIXEL.equals(str)) {
            if ("on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_HIGH_PIXEL, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_ai_high_pixel_value)))) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_picture_size_standard_high_hint);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_AI_high_pixel_scenes_hint);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_AI_high_pixel_hint);
            }
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        if ("on_renamed".equals(getFlashMode())) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off").apply();
            updateFlashState("off");
        }
        super.onInitCameraMode();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        if (a_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_AI_high_pixel_scenes_hint, 2800, new java.lang.Object[0]);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (!this.mbDestroyed && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE)) {
            return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        return super.getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected int getHighPictureSizeHint() {
        return a_renamed() ? com.oplus.camera.R_renamed.string.camera_AI_high_pixel_hint : super.getHighPictureSizeHint();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.AI_HIGH_PIXEL_ENABLE, this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_HIGH_PIXEL, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_ai_high_pixel_value)));
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return !a_renamed() && super.getZSLMode();
    }

    private boolean a_renamed() {
        return this.mPreferences != null && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_HIGH_PIXEL, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_ai_high_pixel_value)));
    }

    @Override // com.oplus.camera.capmode.d_renamed
    public boolean shouldShowSteadyTips() {
        return a_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData ? (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mAiHighPixel = a_renamed() ? "50M" : "off";
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }
}
