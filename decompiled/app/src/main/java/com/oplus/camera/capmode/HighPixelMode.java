package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Size;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HighPixelMode.java */
/* renamed from: com.oplus.camera.capmode.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class HighPixelMode extends CommonCapMode {
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_HIGH_PIXEL;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isHighPictureSize() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isUltraWideHighPictureSize() {
        return false;
    }

    public HighPixelMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0156  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.HighPixelMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_AI_HIGH_PIXEL.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(str)) {
            return false;
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SWITCH_CAMERA.equals(str) || CameraUIInterface.KEY_SUB_SETTING.equals(str) || CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public List<String> onGetSupportSettingList(String str, int OplusGLSurfaceView_13) {
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            List<String> supportSettingList = getSupportSettingList(CameraUIInterface.KEY_FLASH_MODE, this.mCameraId);
            ArrayList arrayList = new ArrayList();
            if (supportSettingList != null) {
                for (String str2 : supportSettingList) {
                    if (!"on".equals(str2) && !"auto".equals(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return super.onGetSupportSettingList(str, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (CameraUIInterface.KEY_AI_HIGH_PIXEL.equals(str)) {
            if ("on".equals(sharedPreferences.getString(CameraUIInterface.KEY_AI_HIGH_PIXEL, this.mActivity.getString(R.string.camera_ai_high_pixel_value)))) {
                this.mCameraUIInterface.mo18067a(R.string.camera_picture_size_standard_high_hint);
            } else {
                this.mCameraUIInterface.mo18067a(R.string.camera_AI_high_pixel_scenes_hint);
                this.mCameraUIInterface.mo18067a(R.string.camera_AI_high_pixel_hint);
            }
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        if ("on".equals(getFlashMode())) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_FLASH_MODE, "off").apply();
            updateFlashState("off");
        }
        super.onInitCameraMode();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        if (m12487a()) {
            this.mCameraUIInterface.mo18074a(R.string.camera_AI_high_pixel_scenes_hint, 2800, new Object[0]);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        if (!this.mbDestroyed && getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE)) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        return super.getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected int getHighPictureSizeHint() {
        return m12487a() ? R.string.camera_AI_high_pixel_hint : super.getHighPictureSizeHint();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        builder.setParameter(CameraParameter.AI_HIGH_PIXEL_ENABLE, this.mPreferences.getString(CameraUIInterface.KEY_AI_HIGH_PIXEL, this.mActivity.getString(R.string.camera_ai_high_pixel_value)));
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return !m12487a() && super.getZSLMode();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12487a() {
        return this.mPreferences != null && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_AI_HIGH_PIXEL, this.mActivity.getString(R.string.camera_ai_high_pixel_value)));
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    public boolean shouldShowSteadyTips() {
        return m12487a();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = dcsMsgData instanceof CaptureMsgData ? (CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mAiHighPixel = m12487a() ? "50M" : "off";
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }
}
