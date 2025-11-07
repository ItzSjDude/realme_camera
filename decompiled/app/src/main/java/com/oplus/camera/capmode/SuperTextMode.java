package com.oplus.camera.capmode;

import android.app.Activity;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.util.Util;

/* compiled from: SuperTextMode.java */
/* renamed from: com.oplus.camera.capmode.u */
/* loaded from: classes2.dex */
public class SuperTextMode extends CommonCapMode {
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return "superText";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isNightAlgoCaptureTriggered() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    public SuperTextMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_SCANNER_SUPPORT) ? 32934 : 32769;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        if (CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_MACRO_SWITCH);
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a("SuperTextMode", "onInitCameraMode");
        this.mCameraUIInterface.mo18139ac();
        super.onInitCameraMode();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (this.mCameraInterface.mo10453I()) {
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isSuperTextOpen() {
        return getSupportFunction(CameraFunction.SUPER_TEXT);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.m19235c("button_shape_ring_none");
        return shutterButtonInfo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014a  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.SuperTextMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return AlgoSwitchConfig.getSupportCameraFeature("superText", this.mCameraId) ? "superText" : (isSatOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) ? ApsConstant.FEATURE_COMMON_SAT_HAL : ApsConstant.CAPTURE_MODE_COMMON;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void setPIEnable(int OplusGLSurfaceView_13, boolean z) {
        if (this.mOneCamera == null) {
            return;
        }
        CameraLog.m12954a("SuperTextMode", "setPIEnable, code: " + OplusGLSurfaceView_13 + ", enable: " + z);
        if (18 == OplusGLSurfaceView_13) {
            this.mOneCamera.mo13012B(z);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ScreenModeConst.PlatformImplementations.kt_3 getPreferredScreenMode(int OplusGLSurfaceView_13) {
        if (!Util.m24498u()) {
            return ScreenModeConst.PlatformImplementations.kt_3.out;
        }
        if (270 == OplusGLSurfaceView_13) {
            return ScreenModeConst.PlatformImplementations.kt_3.full90;
        }
        if (90 == OplusGLSurfaceView_13) {
            return ScreenModeConst.PlatformImplementations.kt_3.full270;
        }
        return ScreenModeConst.PlatformImplementations.kt_3.full;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(c2693c);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }
}
