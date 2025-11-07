package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureResult;
import android.util.Size;
import android.view.MotionEvent;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.professional.NightPro;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.utils.ShakeDetectorUtils;
import java.util.List;

/* compiled from: NightMode.java */
/* renamed from: com.oplus.camera.capmode.r */
/* loaded from: classes2.dex */
public class NightMode extends CommonCapMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f12962g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f12963h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f12964i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f12965j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f12966k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f12967l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12968m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f12969n;

    /* renamed from: o */
    private boolean f12970o;

    /* renamed from: p */
    private boolean f12971p;

    /* renamed from: q */
    private boolean f12972q;

    /* renamed from: r */
    private boolean f12973r;

    /* renamed from: s */
    private boolean f12974s;

    /* renamed from: t */
    private NightPro f12975t;

    /* renamed from: u */
    private int f12976u;

    /* renamed from: v */
    private int f12977v;

    /* renamed from: w */
    private final ShakeDetectorUtils.OnShakeListener f12978w;

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        return null;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_NIGHT;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getEffectMenuKeyByMode() {
        return CameraUIInterface.KEY_NIGHT_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_NIGHT_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 3;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_NIGHT_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32793;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(String str) {
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

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onGetNearMeOnClickData() {
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public NightMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12962g = Long.MAX_VALUE;
        this.f12963h = 0;
        this.f12964i = 0;
        this.f12965j = false;
        this.f12966k = false;
        this.f12967l = false;
        this.f12968m = 0;
        this.f12969n = false;
        this.f12970o = false;
        this.f12971p = false;
        this.f12972q = false;
        this.f12973r = false;
        this.f12974s = true;
        this.f12975t = null;
        this.f12976u = 0;
        this.f12977v = 3000;
        this.f12978w = new ShakeDetectorUtils.OnShakeListener() { // from class: com.oplus.camera.capmode.r.1
            @Override // com.sensetime.utils.ShakeDetectorUtils.OnShakeListener
            public void onShake(boolean z) {
                if (z && NightMode.this.mCameraUIInterface != null && NightMode.this.isTripodModeOpened()) {
                    NightMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_tripod_night_keep_steady_tips, -1, true, false, false);
                }
            }
        };
        this.f12976u = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_NIGHT_TRIPOD_RAM_THRESHOLD);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010e  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Size getPictureSize(com.oplus.camera.p141e.OplusCameraCharacteristics r17) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.NightMode.getPictureSize(com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_10):android.util.Size");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Size m12570b() {
        List<Size> configSizeListValue;
        Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_BACK_NIGHT_LOW_MEMORY_RAW_PICTURE_SIZE);
        if (sizeConfigValue != null && Util.m24452g(this.mActivity).totalMem <= STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1) {
            return sizeConfigValue;
        }
        if (CameraCharacteristicsUtil.m12985h() == getProperCameraId(this.mCameraId)) {
            configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_BACK_NIGHT_RAW_PICTURE_SIZE);
        } else {
            configSizeListValue = CameraCharacteristicsUtil.m12986i() == getProperCameraId(this.mCameraId) ? CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_FRONT_NIGHT_RAW_PICTURE_SIZE) : null;
        }
        if (configSizeListValue == null || configSizeListValue.size() == 0) {
            return null;
        }
        return configSizeListValue.get(0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDeleteTheSizeByRatio(String str) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) && "16_9".equals(str)) {
            return true;
        }
        return super.needDeleteTheSizeByRatio(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (this.f12969n || this.f12966k || this.f12970o || this.f12971p || isTripodModeOpened()) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12567a(boolean z) {
        this.mCameraUIInterface.mo18067a(R.string.camera_scene_tripod_night_keep_steady_tips);
        this.mCameraUIInterface.mo18070a(z ? R.string.camera_scene_tripod_night_mode_on_tips : R.string.camera_scene_tripod_night_mode_off_tips, -1, true, false, false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12572c() {
        this.mCameraUIInterface.mo18067a(R.string.camera_scene_tips_tripod_night_fixed_phone_on);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m12573d() {
        if (this.f12972q || this.mbPaused || !this.mbCapModeInit) {
            return;
        }
        this.mCameraUIInterface.mo18070a(R.string.camera_scene_ultra_dark_mode_tips, -1, false, false, true);
        this.f12972q = true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m12574e() {
        if (!this.f12972q || this.mbPaused) {
            return;
        }
        this.mCameraUIInterface.mo18067a(R.string.camera_scene_ultra_dark_mode_tips);
        this.f12972q = false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m12575f() {
        this.mCameraUIInterface.mo18067a(R.string.camera_night_starburst_hint);
        this.mCameraUIInterface.mo18070a(R.string.camera_night_starburst_hint, -1, true, false, false);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m12576g() {
        this.mCameraUIInterface.mo18067a(R.string.camera_night_starburst_hint);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m12577h() {
        this.f12965j = false;
        this.f12964i = 0;
        this.f12972q = false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        this.f12966k = false;
        this.f12969n = false;
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15743a(this.mbCapModeInit);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("NightMode", "onDeInitCameraMode()");
        m12572c();
        m12574e();
        m12577h();
        m12571b(false);
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15748b();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) && this.mOneCamera != null) {
            this.mCameraUIInterface.mo18103a(CameraUIInterface.KEY_PHOTO_RATIO, "16_9");
        }
        super.onDeInitCameraMode(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.f12974s = true;
        m12577h();
        m12571b(false);
        if (this.mNightCountDownUI != null) {
            this.mNightCountDownUI.m20101b();
        }
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15751c();
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        int OplusGLSurfaceView_13 = c2693c.f13385N == null ? -1 : c2693c.f13385N.mMultiFrameCount;
        this.f12962g = Util.m24468k(this.mActivity);
        this.f12973r = false;
        this.f12974s = false;
        m12574e();
        m12571b(false);
        CameraLog.m12959b("NightMode", "onBeforeSnapping, rawCaptureNum: " + OplusGLSurfaceView_13 + ", getNightStateDecision: " + getNightStateDecision() + ", mAvailMemory: " + this.f12962g);
        NightPro c2896n = this.f12975t;
        if (c2896n != null && !c2896n.m15747a(c2693c, this.mbSceneNight)) {
            return false;
        }
        boolean zOnBeforeSnapping = super.onBeforeSnapping(c2693c);
        this.mbCheckTakeAnimateDelay = false;
        if (isInNightProProcess()) {
            this.mCameraUIInterface.mo18108a(true, true, false);
            if (this.f12975t != null && m12586a()) {
                this.mCameraUIInterface.mo18104a(this.f12975t.m15769r(), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
            m12578i();
        } else if (isSuperNightShutterCountDownOpen()) {
            this.mNightCaptureTotalTime = this.f12977v;
            this.mbCaptureRawTimeDone = false;
            m12578i();
        }
        onProcessCapturePictureRequest();
        return zOnBeforeSnapping;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m12578i() {
        if (this.mNightCaptureTotalTime > 0) {
            this.mNightCountDownUI.m20100a(this.mNightCaptureTotalTime);
        }
        updateNightCaptureShutter();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4) {
        CameraLog.m12959b("NightMode", "onPictureCallback, data: " + bArr + ",isInNightProProcess: " + isInNightProProcess() + ",mbCaptureRawTimeDone: " + this.mbCaptureRawTimeDone);
        if (isInNightProProcess() && !this.mbCaptureRawTimeDone) {
            stopNightCountdownTime();
        }
        super.onPictureCallback(bArr, OplusGLSurfaceView_13, i2, i3, z, i4);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        if (isInNightProProcess()) {
            this.mCameraUIInterface.mo18245n();
            this.mCameraInterface.mo10508aJ();
        }
        this.f12974s = true;
        this.mbEnableUILater = false;
        if (isTripodModeOpened()) {
            m12571b(true);
        }
        super.onAfterPictureTaken(bArr, z);
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15744a(bArr, z, isInNightProProcess());
        }
        if (getSupportFunction(CameraUIInterface.KEY_NIGHT_PRO_MODE) && m12586a()) {
            this.mCameraUIInterface.mo18167b(0, Util.m24420c(getPreviewSize(getCameraInfo(this.mCameraId))));
            m12581l();
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected void resetAfterPictureTaken(boolean z, boolean z2) {
        if (!this.mbCaptureRawTimeDone && z) {
            CameraLog.m12954a("NightMode", "resetAfterPictureTaken, CaptureRawTime not end");
            return;
        }
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15758g();
        }
        super.resetAfterPictureTaken(z, z2);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        if (shutterButtonInfo != null && 4 == this.mCameraUIInterface.mo18265s()) {
            shutterButtonInfo.m19226a(32);
        }
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        int[] iArrMo13061a;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f("NightMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (!this.mbInCapturing && m12586a()) {
            m12566a(captureResult);
        }
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15741a(captureResult);
        }
        boolean zIsTripodModeOpened = isTripodModeOpened();
        if (this.mbInCapturing || !zIsTripodModeOpened || (iArrMo13061a = this.mOneCamera.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13291ad, captureResult)) == null || iArrMo13061a.length <= 0) {
            return;
        }
        this.f12963h += iArrMo13061a[0];
        this.f12964i++;
        if (this.f12964i == 10) {
            this.f12965j = this.f12963h >= 6;
            this.f12963h = 0;
            this.f12964i = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12566a(CaptureResult captureResult) {
        long jM12569b = m12569b(captureResult);
        CameraLog.m12959b("NightMode", "updateEstimatedCaptureTime, estimatedCountDownTime: " + jM12569b);
        if (jM12569b <= 0) {
            this.mNightCaptureTotalTime = 0L;
        } else {
            this.mNightCaptureTotalTime = jM12569b / 1000000;
            this.mNightCaptureTotalTime = Math.round(this.mNightCaptureTotalTime / 1000.0f) * 1000;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long m12569b(CaptureResult captureResult) {
        Object objM13005a;
        if (captureResult == null || (objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13327bh)) == null) {
            return -1L;
        }
        return ((long[]) objM13005a)[0];
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewDecisionResult(CameraApsDecision cameraApsDecision) {
        super.onPreviewDecisionResult(cameraApsDecision);
        synchronized (this.mApsDecisionResultLock) {
            boolean z = true;
            if (Util.m24169C()) {
                if (this.mDecisionResult != null && this.mDecisionResult.mApsAlgoFlag != null) {
                    String str = this.mDecisionResult.mApsAlgoFlag[0];
                    if (!CameraUnitKeys.ALGO_NAME_DARKSIGHT.equals(str) && 16 != this.mDecisionResult.mApsDecisionSceneMode) {
                        z = false;
                    }
                    this.f12966k = z;
                    this.f12969n = CameraUnitKeys.ALGO_NAME_AI_NIGHT.equals(str);
                    this.f12970o = CameraUnitKeys.ALGO_NAME_SUPERNIGHT.equals(str);
                    this.f12971p = CameraUnitKeys.ALGO_NAME_FRONT_PORTRAIT_SUPERNIGHT.equals(str);
                }
            } else {
                if (this.mDecisionResult == null || (13 != this.mDecisionResult.mApsDecisionFeatureType && 14 != this.mDecisionResult.mApsDecisionFeatureType && 29 != this.mDecisionResult.mApsDecisionFeatureType)) {
                    z = false;
                }
                this.f12966k = z;
            }
        }
        if (Util.m24169C()) {
            if (!AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, CameraUnitKeys.ALGO_NAME_DARKSIGHT)) {
                m12574e();
                return;
            }
        } else if (!AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, CameraUnitKeys.ALGO_NAME_AINR) && !AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, CameraUnitKeys.ALGO_NAME_AIHDR)) {
            m12574e();
            return;
        }
        if (this.f12966k && this.mbCaptureRawTimeDone && !isTripodModeOpened() && !m12586a() && this.f12974s) {
            m12573d();
        } else {
            m12574e();
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) throws Throwable {
        CameraLog.m12967f("NightMode", "onResume");
        this.mbStopSteadyTips = true;
        int iM24315aD = this.f12968m;
        if (iM24315aD <= 0) {
            iM24315aD = Util.m24315aD();
        }
        this.f12968m = iM24315aD;
        int OplusGLSurfaceView_13 = this.f12968m;
        this.f12967l = OplusGLSurfaceView_13 > this.f12976u || OplusGLSurfaceView_13 <= 0;
        if (isTripodModeOpened()) {
            m12571b(true);
        }
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15750b(z);
        }
        super.onResume(z);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws Throwable {
        super.onInitCameraMode();
        int iM24315aD = this.f12968m;
        if (iM24315aD <= 0) {
            iM24315aD = Util.m24315aD();
        }
        this.f12968m = iM24315aD;
        int OplusGLSurfaceView_13 = this.f12968m;
        this.f12967l = OplusGLSurfaceView_13 > this.f12976u || OplusGLSurfaceView_13 <= 0;
        if (isNightProModeSupport()) {
            restoreProPreference();
            m12585p();
        }
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15759h();
            this.f12975t.m15755e(true);
        }
        if (isTripodModeOpened()) {
            m12571b(true);
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) || this.mOneCamera == null) {
            return;
        }
        this.mCameraUIInterface.mo18173b(CameraUIInterface.KEY_PHOTO_RATIO, "16_9");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateRatioType() {
        super.updateRatioType();
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_DELETE_RECTANGLESIZE) || this.mOneCamera == null) {
            return;
        }
        this.mCameraUIInterface.mo18173b(CameraUIInterface.KEY_PHOTO_RATIO, "16_9");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        CameraLog.m12967f("NightMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (this.mbFrontCamera && Util.m24358au() && getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
            super.displayScreenHintIconInSwitchOn();
        } else if (is10bitsHeicEncodeEnable() && this.mbStopSteadyTips) {
            this.mCameraUIInterface.mo18166b(R.string.camera_10bit_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isTripodModeOpened() {
        if (this.mPreferences != null) {
            return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, this.mActivity != null ? this.mActivity.getString(R.string.camera_night_tripod_mode_default_value) : "off"));
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m12579j() {
        if (this.mPreferences != null) {
            return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_NIGHT_STARBURST_MODE, this.mActivity != null ? this.mActivity.getString(R.string.camera_night_starburst_mode_default_value) : "off"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return ((isTripodNight() && isInNightProcess()) || isNightAlgoCaptureTriggered() || this.mNightAlgoTriggeredStep != 0 || isInNightProProcess()) && getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = dcsMsgData instanceof CaptureMsgData ? (CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mIsTripodMode = isTripodModeOpened() ? "on" : "off";
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS)) {
            if (this.f12966k) {
                captureMsgData.mNightState = 5;
            } else {
                captureMsgData.mNightState = getNightStateDecision();
            }
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:158:0x025e  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 1192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.NightMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if (!Util.m24169C() && !this.mbFrontCamera && (("type_still_capture_yuv_main".equals(str) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str) || "type_tuning_data_yuv".equals(str) || ("type_tuning_data_raw".equals(str) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)))) {
            return false;
        }
        if ("type_reprocess_data_yuv".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) && !this.mbFrontCamera;
        }
        if ("type_tele_small_preview".equals(str)) {
            return false;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return Util.m24358au();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(str) || CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        NightPro c2896n = this.f12975t;
        if (c2896n == null || !c2896n.m15762k()) {
            return super.onBackPressed();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(MotionEvent motionEvent) {
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS)) {
            return true;
        }
        return super.onLongPress(motionEvent);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isInNightProcess() {
        return getNightStateDecision() > 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void checkIfLockAutoExposure() {
        if (Util.m24169C() || this.mbResetAeLockAfterCaptured || !this.mbFrontCamera || !isInNightProcess()) {
            return;
        }
        this.mOneCamera.mo13071b(true, false);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        this.mbResetAeLockAfterCaptured = true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return CameraUIInterface.KEY_NIGHT_CUSTOM_BEAUTY;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String[] getMakeupKeys() {
        return getCurrentKeys(FaceBeautyHelp.f21231f);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected String getMakeupTypeKey() {
        return CameraEntry.m13302b(this.mCameraEntryType) ? CameraEntry.m13299b(CameraUIInterface.KEY_NIGHT_MAKEUP_TYPE, this.mCameraEntryType) : CameraUIInterface.KEY_NIGHT_MAKEUP_TYPE;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(String str) {
        if (CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(str) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE) && getSupportFunction(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE) && getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            return !isNoneSatUltraWideAngleOpen();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowSceneNightTips() {
        return this.mbShowSteadyTips;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(str) && getSupportFunction(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE)) {
            m12582m();
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.TRIPOD_MODE_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(isTripodModeOpened()));
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            boolean zIsTripodModeOpened = isTripodModeOpened();
            m12567a(zIsTripodModeOpened);
            m12571b(zIsTripodModeOpened);
        } else {
            if (CameraUIInterface.KEY_NIGHT_PRO_MODE.equals(str)) {
                boolean zM12586a = m12586a();
                boolean zIsNoneSatUltraWideAngleOpen = isNoneSatUltraWideAngleOpen();
                CameraLog.m12959b("NightMode", "onSharedPreferenceChanged isProModeOn: " + zM12586a);
                m12580k();
                m12583n();
                if (zM12586a) {
                    m12584o();
                    this.mCameraUIInterface.mo18236k(false, false);
                    this.mCameraUIInterface.mo18110a(R.string.camera_10bit_hint);
                } else {
                    this.mCameraUIInterface.mo18240l(false, false);
                }
                NightPro c2896n = this.f12975t;
                if (c2896n != null) {
                    c2896n.m15752c(zM12586a);
                }
                if (!zIsNoneSatUltraWideAngleOpen) {
                    m12581l();
                }
            } else if (CameraUIInterface.KEY_NIGHT_STARBURST_MODE.equals(str) && getSupportFunction(CameraUIInterface.KEY_NIGHT_STARBURST_MODE)) {
                boolean zM12579j = m12579j();
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.STARBURST_MODE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(zM12579j));
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                if (zM12579j) {
                    m12575f();
                } else {
                    m12576g();
                }
            } else if (CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
                boolean z = 1 == Integer.parseInt(sharedPreferences.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0)));
                NightPro c2896n2 = this.f12975t;
                if (c2896n2 != null) {
                    c2896n2.m15753d(z);
                }
            } else {
                NightPro c2896n3 = this.f12975t;
                if (c2896n3 != null) {
                    c2896n3.m15740a(sharedPreferences, str);
                }
            }
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12571b(boolean z) {
        CameraLog.m12954a("NightMode", "setShakeDetectEnable, enable: " + z);
        if (z) {
            ShakeDetectorUtils.getInstance(this.mActivity).registerOnShakeListener(this.f12978w).start();
        } else {
            ShakeDetectorUtils.getInstance(this.mActivity).unregisterOnShakeListener(this.f12978w).stop();
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_tripod_night_keep_steady_tips);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m12580k() {
        if (isNoneSatUltraWideAngleOpen()) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            return c2896n.m15746a(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m12581l() {
        NightPro c2896n;
        if (getSupportFunction(CameraUIInterface.KEY_NIGHT_PRO_MODE) && (c2896n = this.f12975t) != null) {
            c2896n.m15768q();
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m12582m() {
        NightPro c2896n;
        if (getSupportFunction(CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            if ((this.mCameraInterface.mo10495a(getZoomValue()) || isTripodModeOpened() || this.mCameraUIInterface.mo18023A()) && (c2896n = this.f12975t) != null) {
                c2896n.m15767p();
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m12583n() {
        if (getSupportFunction(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE)) {
            if (m12586a() && !"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, "off"))) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, "off").apply();
            }
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        m12581l();
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15760i();
        }
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        if (isInNightProProcess() && this.f12973r) {
            return;
        }
        super.onShutterCallback(z, z2);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
        this.mCameraUIInterface.mo18225i();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        if (this.mCaptureRequestTag == null || !this.mCaptureRequestTag.f13396Y) {
            return;
        }
        if (CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_RAW == this.mCaptureRequestTag.m13006a() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) {
            resetAwbLockAfterCaptured();
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11372v(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_INSENSOR_ZOOM_POINT_2X_SUPPORT));
        if (getSupportFunction(CameraUIInterface.KEY_NIGHT_PRO_MODE)) {
            boolean zM12586a = m12586a();
            zoomConfigure.m11360p(zM12586a);
            zoomConfigure.m11374w(zM12586a);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_NIGHT_MODE_MAX_ZOOM_SUPPORT)) {
            zoomConfigure.m11376x(true);
        }
        float configFloatValue = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue) {
            zoomConfigure.m11329b(configFloatValue);
        } else {
            zoomConfigure.m11329b(0.0f);
        }
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        CameraLog.m12954a("NightMode", "onAfterSnapping");
        if (isInNightProProcess()) {
            this.mCameraInterface.mo10558c(0);
            this.mCameraUIInterface.mo18107a(true, false);
            this.f12973r = true;
        }
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            return FilterHelper.f21321k.f21252f;
        }
        return super.getFilterNameIdList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            return FilterHelper.f21321k.f21251e;
        }
        return super.getFilterTypeList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        super.onFilterMenuClicked();
        if (this.f12975t == null || !m12586a()) {
            return;
        }
        this.f12975t.m15767p();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15739a(3, false);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z) {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15739a(3, true);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int OplusGLSurfaceView_13) {
        super.onFilterItemChange(OplusGLSurfaceView_13);
        if (!isTripodModeOpened() || FilterHelper.f21279a == OplusGLSurfaceView_13) {
            return;
        }
        m12583n();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) {
        if (isTripodModeOpened() && this.mNightCountDownUI != null && this.mNightCountDownUI.m20106g()) {
            return false;
        }
        return super.getTouchEnable(z, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: o */
    private void m12584o() {
        if (this.mCameraUIInterface.mo18023A()) {
            this.mCameraUIInterface.mo18244m(true, false);
        }
        if (isFilterEffectOpen()) {
            this.mPreferences.edit().putInt(getFilterEffectMenuPreferenceKey(), FilterHelper.f21279a).apply();
            onFilterItemChange(FilterHelper.f21279a);
        }
    }

    /* renamed from: p */
    private void m12585p() {
        this.f12975t = new NightPro(this.mActivity, this.mCameraInterface, this.mCameraUIInterface, getCameraMode(), this.mOneCamera);
        this.f12975t.m15742a(new NightPro.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.r.2
            @Override // com.oplus.camera.professional.NightPro.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12587a() {
                return NightMode.this.mbInCapturing;
            }

            @Override // com.oplus.camera.professional.NightPro.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public boolean mo12589b() {
                return NightMode.this.isInNightProProcess();
            }

            @Override // com.oplus.camera.professional.NightPro.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12588a(String str) {
                return NightMode.this.getSupportFunction(str);
            }

            @Override // com.oplus.camera.professional.NightPro.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public int mo12590c() {
                return NightMode.super.getDefaultAFMode();
            }

            @Override // com.oplus.camera.professional.NightPro.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_5 */
            public MainShutterButtonInfo mo12591d() {
                return NightMode.this.getShutterButtonInfo();
            }

            @Override // com.oplus.camera.professional.NightPro.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_8 */
            public boolean mo12592e() {
                return NightMode.this.isPanelMode();
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12568a(String str) {
        if (getSupportFunction(str) && this.mPreferences != null) {
            return "on".equals(this.mPreferences.getString(str, "off"));
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m12586a() {
        if (this.mPreferences != null) {
            return m12568a(CameraUIInterface.KEY_NIGHT_PRO_MODE) && !(1 == Integer.parseInt(this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0))));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            return c2896n.m15754d();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15765n();
        }
        super.onZoomMenuCollapsed();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15766o();
        }
        super.onZoomMenuExpand();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateControlPanelBgColor(int OplusGLSurfaceView_13) {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15749b(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        if (isInNightProProcess()) {
            return true;
        }
        return super.isNeedProgressBarInCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15738a(OplusGLSurfaceView_13);
        }
        super.setOrientation(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        NightPro c2896n = this.f12975t;
        if (c2896n != null && c2896n.m15756e()) {
            return this.mActivity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.main_mode_bar_height);
        }
        return super.getZoomBarOffset();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        m12582m();
        displayScreenHintIconInSwitchOn();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isInNightProProcess() {
        return m12586a() && this.mNightCaptureTotalTime > 0;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isNightProSoundPlayed() {
        return this.f12973r;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected boolean isInNightProMode() {
        return m12586a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInProMode() {
        return m12586a();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        CameraLog.m12954a("NightMode", "onMoreModeShown");
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15763l();
        }
        super.onMoreModeShown();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("NightMode", "onMoreModeHidden");
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15764m();
        }
        super.onMoreModeHidden(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showBeautyButton() {
        if (m12586a()) {
            return false;
        }
        if (isTripodModeOpened() && this.mNightCountDownUI != null && this.mNightCountDownUI.m20106g()) {
            return false;
        }
        return super.showBeautyButton();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("NightMode", "changeModeAllView animationType: " + OplusGLSurfaceView_13 + ", isShow: " + z);
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15739a(OplusGLSurfaceView_13, z);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedResetAutoFocus() {
        return !isInNightProMode();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowZoomMenu() {
        if (this.f12975t != null) {
            return !r0.m15757f();
        }
        return super.isShowZoomMenu();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (m12586a()) {
            return false;
        }
        return super.supportBeautyButton();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    public boolean isSuperNightShutterCountDownOpen() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_SHUTTER_COUNTDOWN_SUPPORT)) {
            return this.mbNightShutterCountDown;
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSendCapturePictureRequest() {
        super.onSendCapturePictureRequest();
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15770s();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCancleCapturePictureRequest() {
        super.onCancleCapturePictureRequest();
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15771t();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onProcessCapturePictureRequest() {
        super.onProcessCapturePictureRequest();
        NightPro c2896n = this.f12975t;
        if (c2896n != null) {
            c2896n.m15772u();
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode
    protected void restoreAllViews(boolean z) {
        restoreAllViews(z, false, false);
    }
}
