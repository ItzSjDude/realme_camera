package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import android.view.MotionEvent;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.professional.HighPictureProMenuManager;
import com.oplus.camera.professional.ProMenuManager;
import com.oplus.camera.professional.ProSwitchButtonManager;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HighDefinitionMode.java */
/* renamed from: com.oplus.camera.capmode.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class HighDefinitionMode extends CommonCapMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ProMenuManager f12903g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ProSwitchButtonManager f12904h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ArrayList f12905i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f12906j;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFrontTorchEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isHighPictureSize() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isNeedResetNoneSatWide() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onHomeKeyClick() {
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onUltraWideAngleOpened() {
    }

    public HighDefinitionMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12903g = null;
        this.f12904h = null;
        this.f12905i = null;
        this.f12906j = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getPhotoRatio() {
        return this.mActivity.getString(R.string.camera_picture_size_standard);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12455a() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && isNoneSatUltraWideAngleOpen();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        Size sizeConfigValue;
        if (m12455a()) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_FULL_SIZE);
        }
        return (getHeicCodecFormat() == null || (sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_HEIF)) == null) ? CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE) : sizeConfigValue;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws Resources.NotFoundException {
        CameraLog.m12954a("HighDefinitionMode", "onInitCameraMode");
        super.onInitCameraMode();
        restoreProPreference();
        if (isProModeSupport()) {
            if (m12459b()) {
                m12453a(1);
                m12458b(0, false);
            } else {
                m12453a(0);
            }
            this.f12904h = new ProSwitchButtonManager(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
            this.f12904h.m15913a(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE);
            m12454a(getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) ? 0 : 8, false);
            this.mCameraUIInterface.mo18288z(false);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        ProMenuManager c2900r;
        CameraLog.m12967f("HighDefinitionMode", "onResume");
        super.onResume(z);
        if (!m12459b() || (c2900r = this.f12903g) == null) {
            return;
        }
        c2900r.mo15776e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m12459b() {
        if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) && this.mPreferences != null) {
            return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE, "off"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        ProMenuManager c2900r = this.f12903g;
        if (c2900r != null) {
            return c2900r.m15885i();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12454a(int OplusGLSurfaceView_13, boolean z) {
        if (isProModeSupport()) {
            if (this.f12904h == null) {
                if (OplusGLSurfaceView_13 != 0) {
                    return;
                }
                this.f12904h = new ProSwitchButtonManager(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
                this.f12904h.m15913a(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE);
            }
            this.f12904h.m15912a(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12458b(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("HighDefinitionMode", "setProMenuVisibility visibility: " + OplusGLSurfaceView_13);
        if (this.f12903g == null) {
            if (OplusGLSurfaceView_13 != 0) {
                return;
            } else {
                m12461c();
            }
        }
        this.f12903g.m15865a(OplusGLSurfaceView_13, z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        ProMenuManager c2900r = this.f12903g;
        if (c2900r != null) {
            c2900r.m15864a(OplusGLSurfaceView_13);
        }
        if (this.mOrientation == OplusGLSurfaceView_13) {
            return;
        }
        this.mOrientation = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12461c() {
        this.f12903g = new HighPictureProMenuManager(this.mActivity, this.mCameraInterface, this.mCameraUIInterface, getCameraMode());
        this.f12903g.m15868a(new HighPictureProMenuManager.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_15.1
            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12470a() {
                return HighDefinitionMode.this.mbInCapturing;
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public boolean mo12476b() {
                return HighDefinitionMode.this.m12459b();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12471a(String str) {
                return HighDefinitionMode.this.getSupportFunction(str);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public int mo12477c() {
                return HighDefinitionMode.super.getDefaultAFMode();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12474b(String str) {
                HighDefinitionMode.this.mOneCamera.mo13069b(str);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12467a(int OplusGLSurfaceView_13) {
                HighDefinitionMode.this.mOneCamera.mo13028a(OplusGLSurfaceView_13, true);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_5 */
            public int mo12479d() {
                return HighDefinitionMode.this.mOneCamera.mo13122p();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12472b(int OplusGLSurfaceView_13) {
                HighDefinitionMode.this.mOneCamera.mo13029a(OplusGLSurfaceView_13, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12466a(float COUIBaseListPopupWindow_12) {
                HighDefinitionMode.this.mOneCamera.mo13023a(COUIBaseListPopupWindow_12, true);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12468a(long OplusGLSurfaceView_15) {
                HighDefinitionMode.this.mOneCamera.mo13031a(OplusGLSurfaceView_15, true);
            }

            @Override // com.oplus.camera.professional.HighPictureProMenuManager.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12473b(long OplusGLSurfaceView_15) {
                HighDefinitionMode.this.mOneCamera.mo13077c(OplusGLSurfaceView_15);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12469a(boolean z) {
                HighDefinitionMode.this.mOneCamera.mo13112l(z);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo12478c(int OplusGLSurfaceView_13) {
                HighDefinitionMode.this.mOneCamera.mo13065b(OplusGLSurfaceView_13, true);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo12481e() {
                HighDefinitionMode.this.mOneCamera.mo13103i(true);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo12480d(int OplusGLSurfaceView_13) {
                HighDefinitionMode.this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo12482e(int OplusGLSurfaceView_13) {
                HighDefinitionMode.this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(OplusGLSurfaceView_13));
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_12 */
            public void mo12483f() {
                HighDefinitionMode.this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_11 */
            public void mo12484g() {
                HighDefinitionMode.this.mOneCamera.mo13105j(true);
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: COUIBaseListPopupWindow_10 */
            public MainShutterButtonInfo mo12485h() {
                return HighDefinitionMode.this.getShutterButtonInfo();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: OplusGLSurfaceView_13 */
            public boolean mo12486i() {
                return HighDefinitionMode.this.isPanelMode();
            }

            @Override // com.oplus.camera.professional.ProMenuManager.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12475b(boolean z) {
                if (HighDefinitionMode.this.f12904h == null || !mo12471a(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
                    return;
                }
                HighDefinitionMode.this.f12904h.m15912a(z ? 0 : 8, false);
            }
        });
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (this.mbCapModeInit && this.f12903g != null && m12459b()) {
            this.f12903g.m15867a(cameraPreviewResult.getCaptureResult());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00de  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.HighDefinitionMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str) || CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        return super.getSupportMenu(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12465a(boolean z) {
        forceClosePIEffect();
        if (z) {
            if (getSupportFunction(CameraUIInterface.KEY_PI_AI)) {
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_PI_AI, "off");
                return;
            } else {
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_PI, "off");
                return;
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_PI_AI)) {
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_PI_AI, (String) null);
        } else {
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_PI, (String) null);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(String str) {
        if (CameraUIInterface.KEY_PI_AI.equals(str) || CameraUIInterface.KEY_PI.equals(str)) {
            return !m12459b();
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws Resources.NotFoundException, NumberFormatException {
        ProMenuManager c2900r;
        if (CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE.equals(str)) {
            boolean zM12459b = m12459b();
            CameraLog.m12959b("HighDefinitionMode", "onSharedPreferenceChanged isProModeOn: " + zM12459b);
            if (zM12459b) {
                m12461c();
            } else {
                ProMenuManager c2900r2 = this.f12903g;
                if (c2900r2 != null) {
                    c2900r2.m15883g();
                    this.f12903g.m15868a((ProMenuManager.IntrinsicsJvm.kt_4) null);
                    this.f12903g = null;
                }
            }
            m12465a(zM12459b);
            m12458b(zM12459b ? 0 : 8, false);
            m12462d();
            this.f12904h.m15914a(zM12459b);
            this.mCameraInterface.mo10506aH();
            this.mCameraUIInterface.mo18288z(false);
            m12453a(m12459b() ? 1 : 0);
            m12463e();
            if (!zM12459b && (c2900r = this.f12903g) != null) {
                c2900r.m15890n();
            }
        } else if (CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE.equals(str) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, sharedPreferences.getString(str, "off")).apply();
        }
        ProMenuManager c2900r3 = this.f12903g;
        if (c2900r3 != null) {
            c2900r3.m15866a(sharedPreferences, str);
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m12462d() throws Resources.NotFoundException {
        if (this.f12903g == null || this.mPreferences == null || !m12459b() || !this.mPreferences.getBoolean(CameraUIInterface.KEY_RESTORE_HIGH_PICTURE_PRO_PARAMS, false)) {
            return;
        }
        this.mPreferences.edit().remove(CameraUIInterface.KEY_RESTORE_HIGH_PICTURE_PRO_PARAMS).apply();
        this.f12903g.m15890n();
        this.f12903g.mo15716b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12453a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("HighDefinitionMode", "updateHighpictureProMode, value: " + OplusGLSurfaceView_13);
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13150y(OplusGLSurfaceView_13);
            this.mOneCamera.mo13031a(-1L, true);
            this.mOneCamera.mo13065b(-1, true);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m12463e() {
        if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            if (m12459b()) {
                this.mCameraUIInterface.mo18070a(R.string.camera_scene_highpicture_pro_tips_oplus_r, -1, false, false, true);
            } else {
                this.mCameraUIInterface.mo18067a(R.string.camera_scene_highpicture_pro_tips_oplus_r);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private List<Integer> m12464f() {
        ArrayList arrayList = this.f12905i;
        if (arrayList != null) {
            return arrayList;
        }
        this.f12905i = new ArrayList();
        this.f12905i.add(Integer.valueOf(R.string.camera_scene_night_tips));
        this.f12905i.add(Integer.valueOf(R.string.camera_scene_night_low_exposure_time_tips_oplus_r));
        this.f12905i.add(Integer.valueOf(R.string.camera_scene_night_image_optimizing_tips_oplus_r));
        return this.f12905i;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION_ZOOM) && isNoneSatUltraWideAngleOpen()) {
            zoomConfigure.m11324a(1.0f);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION_ZOOM)) {
            zoomConfigure.m11352l(false);
            zoomConfigure.m11356n(false);
        }
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (m12459b()) {
            return;
        }
        super.displayScreenHintIconInSwitchOn();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() throws Resources.NotFoundException {
        CameraLog.m12954a("HighDefinitionMode", "onMoreModeShown");
        if (isProModeSupport()) {
            if (m12459b()) {
                m12458b(8, false);
            }
            m12454a(8, false);
        }
        super.onMoreModeShown();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraLog.m12954a("HighDefinitionMode", "onMoreModeHidden");
        if (isProModeSupport()) {
            if (m12459b()) {
                m12458b(0, false);
                m12463e();
            }
            m12454a((!getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) || isShowProPanelMenu()) ? 8 : 0, false);
        }
        super.onMoreModeHidden(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (this.f12903g != null && m12459b()) {
            return this.f12903g.mo15717c();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkoutTimerSnapShotState() {
        super.checkoutTimerSnapShotState();
        this.f12906j = false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        super.onTimeSnapShotEnd(z);
        this.f12906j = z;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12959b("HighDefinitionMode", "onBeforePreview");
        if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            m12453a(m12459b() ? 1 : 0);
        }
        if (this.f12903g != null && m12459b()) {
            this.f12903g.m15878c(this.mbCapModeInit);
            m12463e();
        }
        super.onBeforePreview();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        if (isProModeSupport()) {
            if (this.f12903g != null && m12459b()) {
                if (!this.f12903g.mo15774a(false)) {
                    return false;
                }
                ProMenuManager c2900r = this.f12903g;
                if (c2900r.m15881d(c2900r.m15899w())) {
                    this.mCameraUIInterface.mo18067a(R.string.camera_scene_highpicture_pro_tips_oplus_r);
                    this.mCameraUIInterface.mo18104a(m12464f(), 3000L);
                }
            }
            ProSwitchButtonManager c2901s = this.f12904h;
            if (c2901s != null) {
                c2901s.m15912a(8, false);
            }
        }
        return super.onBeforeSnapping(c2693c);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        if (this.f12903g != null && m12459b()) {
            this.f12903g.m15898v();
        }
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        if (this.f12903g != null && m12459b()) {
            this.f12903g.mo15715a(bArr, z, false);
        }
        if (this.f12904h != null && getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE) && !isShowProPanelMenu()) {
            this.f12904h.m15912a(0, true);
        }
        if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            this.mCameraUIInterface.mo18245n();
            m12463e();
        }
        super.onAfterPictureTaken(bArr, z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f12903g != null && m12459b()) {
            return this.f12903g.m15870a(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        CameraLog.m12959b("HighDefinitionMode", "onAfterStartPreview");
        if (isProModeSupport()) {
            if (this.f12903g != null && m12459b()) {
                this.f12903g.m15897u();
            }
            if (this.f12904h != null && !isShowProPanelMenu()) {
                this.f12904h.m15916c();
            }
            if (m12459b()) {
                this.mCameraUIInterface.mo18288z(false);
            }
        }
        if (this.mOneCamera != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_PICTURE_ULTRA_RESOLUTION_MODE)) {
            this.mOneCamera.mo13142v(true);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) throws Resources.NotFoundException {
        CameraLog.m12962c("HighDefinitionMode", "onDeInitCameraMode");
        if (isProModeSupport()) {
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_highpicture_pro_tips_oplus_r);
            this.mCameraUIInterface.mo18108a(true, true, false);
            ProMenuManager c2900r = this.f12903g;
            if (c2900r != null) {
                c2900r.m15883g();
                this.f12903g.m15868a((ProMenuManager.IntrinsicsJvm.kt_4) null);
                this.f12903g = null;
            }
            if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
                m12453a(0);
            }
            ProSwitchButtonManager c2901s = this.f12904h;
            if (c2901s != null) {
                c2901s.m15911a();
                this.f12904h = null;
            }
        }
        super.onDeInitCameraMode(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("HighDefinitionMode", "onPause");
        if (isProModeSupport()) {
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_highpicture_pro_tips_oplus_r);
            this.mCameraUIInterface.mo18108a(true, true, false);
            if (this.f12903g != null && m12459b()) {
                this.f12903g.m15889m();
                this.mCameraUIInterface.mo18215g(0);
                m12453a(0);
            }
        }
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        ProMenuManager c2900r;
        if (!m12459b() || (c2900r = this.f12903g) == null || c2900r.m15880d(2)) {
            return super.getZSLMode();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return super.getOperatingMode();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("HighDefinitionMode", "changeModeAllView animationType: " + OplusGLSurfaceView_13 + ", isShow: " + z);
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (3 == OplusGLSurfaceView_13 && getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_PRO_MODE)) {
            if (this.f12903g != null) {
                this.f12903g.m15874b((z && this.mbInCapturing) ? false : z);
            }
            if (z) {
                if (m12459b()) {
                    m12458b(m12459b() ? 0 : 8, true);
                }
                if (this.f12906j) {
                    return;
                }
                m12454a(0, false);
                return;
            }
            if (m12459b()) {
                m12458b(8, true);
            }
            m12454a(8, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedResetAutoFocus() {
        return !m12459b();
    }
}
