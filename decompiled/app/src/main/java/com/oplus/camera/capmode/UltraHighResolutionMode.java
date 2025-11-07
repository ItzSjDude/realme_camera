package com.oplus.camera.capmode;

import android.app.Activity;
import android.util.Size;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UltraHighResolutionMode.java */
/* renamed from: com.oplus.camera.capmode.v */
/* loaded from: classes2.dex */
public class UltraHighResolutionMode extends CommonCapMode {
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isNightAlgoCaptureTriggered() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
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

    public UltraHighResolutionMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return Util.m24359av();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.UltraHighResolutionMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_SWITCH_CAMERA.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        if (CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return getSupportFunction(CameraUIInterface.KEY_FILTER_MENU) ? CameraUIInterface.KEY_ULTRA_HIGH_RESOLUTION_FILTER_INDEX : super.getFilterEffectMenuPreferenceKey();
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
    public void onFilterItemChange(int OplusGLSurfaceView_13) {
        super.onFilterItemChange(OplusGLSurfaceView_13);
        m12684a(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        if ("on".equals(getFlashMode())) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_FLASH_MODE, "off").apply();
            updateFlashState("off");
        }
        super.onInitCameraMode();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12684a(int OplusGLSurfaceView_13) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 4;
        menuClickMsgData.mItemValue = FilterHelper.m22620b(OplusGLSurfaceView_13, this.mCameraId);
        menuClickMsgData.mCameraEnterType = String.valueOf(1);
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        menuClickMsgData.mOrientation = this.mOrientation;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z) {
        InverseManager.INS.setPositionRatio(this.mActivity, 0.5f, z);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = dcsMsgData instanceof CaptureMsgData ? (CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
            captureMsgData.mFilterType = FilterHelper.m22620b(getCurrFilterIndex(), this.mCameraId);
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return Util.m24378b(c2698h.m13258a(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected Size getUltraPictureSize(String str) {
        return Util.m24378b(CameraConfig.getConfigSizeListValue(str), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        if (isSatOpen()) {
            return super.getZoomConfigure();
        }
        ZoomConfigure c2614af = new ZoomConfigure();
        c2614af.m11326a(isCaptureModeType());
        c2614af.m11331b(false);
        c2614af.m11367s(true);
        c2614af.m11344h(getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA));
        return c2614af;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (this.mPreferences == null) {
            return -1;
        }
        String string = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if ("camera_main".equals(string)) {
            return Util.m24445f(R.string.camera_switch_main);
        }
        if ("camera_ultra_wide".equals(string)) {
            if (Float.compare(this.mOneCamera.mo13086e().m13279n(), 0.0f) == 0) {
                return Util.m24445f(R.string.camera_switch_ultra_wide);
            }
            return Util.m24445f(R.string.camera_switch_ultra_wide_micro_lens);
        }
        if ("camera_tele".equals(string)) {
            return R.string.camera_switch_tele;
        }
        return -1;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13142v(true);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getPhotoRatio() {
        return this.mActivity.getString(R.string.camera_picture_size_standard);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(c2693c);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }
}
