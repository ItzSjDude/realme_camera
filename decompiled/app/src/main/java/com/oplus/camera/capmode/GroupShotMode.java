package com.oplus.camera.capmode;

import android.app.Activity;
import android.util.Size;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;

/* compiled from: GroupShotMode.java */
/* renamed from: com.oplus.camera.capmode.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class GroupShotMode extends CommonCapMode implements CameraConstant {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f12901g;

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        return null;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_GROUP_SHOT;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getDefaultCommonBeautyValue() {
        return 30;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_GROUPSHOT_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFaceBeautyMenuType() {
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 0;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFlashMode() {
        return "off";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 34817;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
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

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    public GroupShotMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12901g = 0;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        super.onResume(z);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str) || CameraUIInterface.KEY_PI_AI.equals(str) || CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return CameraUIInterface.KEY_GROUPSHOT_CUSTOM_BEAUTY;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.oplus.camera.p172ui.control.MainShutterButtonInfo getShutterButtonInfo() {
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
            com.oplus.camera.ui.control.IntrinsicsJvm.kt_4 r0 = new com.oplus.camera.ui.control.IntrinsicsJvm.kt_4
            r1 = 1
            r2 = 0
            java.lang.String r3 = "button_color_inside_none"
            r0.<init>(r1, r3, r4, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.GroupShotMode.getShutterButtonInfo():com.oplus.camera.ui.control.IntrinsicsJvm.kt_4");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_13.1
            @Override // java.lang.Runnable
            public void run() {
                if (GroupShotMode.this.mbPaused) {
                    CameraLog.m12954a("GroupShotMode", "onBeforeSnapping, return after pause");
                    return;
                }
                MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                c3200b.m19227a("button_color_inside_none");
                c3200b.m19226a(4);
                GroupShotMode.this.mCameraUIInterface.mo18091a(c3200b);
            }
        });
        this.mbCheckTakeAnimateDelay = false;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.GroupShotMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isSuperClearPortraitOpen() {
        return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, "off"));
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (20 == this.f12901g) {
            return true;
        }
        return super.getZSLMode();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewDecisionResult(CameraApsDecision cameraApsDecision) {
        this.f12901g = cameraApsDecision.mApsDecisionFeatureType;
        super.onPreviewDecisionResult(cameraApsDecision);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure c2614af = new ZoomConfigure();
        c2614af.m11368t(false);
        c2614af.m11331b(false);
        c2614af.m11344h(false);
        c2614af.m11334c(false);
        c2614af.m11340f(false);
        c2614af.m11360p(true);
        return c2614af;
    }
}
