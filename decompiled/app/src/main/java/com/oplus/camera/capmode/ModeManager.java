package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import android.util.Size;
import android.view.MotionEvent;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.ApsService;
import com.oplus.camera.aps.service.ThumbnailItem;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.camera.doubleexposure.VideoClipManager;
import com.oplus.camera.filmvideomode.MovieMode;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p149h.FastVideoMode;
import com.oplus.camera.p150i.FeatureFactory;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p155n.PortraitCapMode;
import com.oplus.camera.p158p.QuickCaptureMode;
import com.oplus.camera.p161r.SlowVideoMode;
import com.oplus.camera.p162s.StarVideoMode;
import com.oplus.camera.p162s.StarryMode;
import com.oplus.camera.p169t.StreetMode;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.OplusViewOutlineProvider;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.ImageCallback;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.panorama.PanoramaCapMode;
import com.oplus.camera.perf.SwitchCameraPerformance;
import com.oplus.camera.photo3d.ThreeDPhotoMode;
import com.oplus.camera.professional.HSProfessionalCapMode;
import com.oplus.camera.professional.ProfessionalCapMode;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.tiltshift.TiltShiftFastVideoMode;
import com.oplus.camera.tiltshift.TiltShiftParam;
import com.oplus.camera.tiltshift.TiltShiftPhotoMode;
import com.oplus.camera.timelapsepro.TimeLapseProMode;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class ModeManager {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f12676b;

    /* renamed from: OplusGLSurfaceView_15 */
    private Activity f12684j;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f12675a = -1;
    private BaseMode mCurrentMode = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private BaseMode f12677c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Map<String, BaseMode> f12678d = new ConcurrentHashMap();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private OneCamera f12679e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f12680f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12681g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f12682h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f12683i = ApsConstant.CAPTURE_MODE_COMMON;

    /* renamed from: OplusGLSurfaceView_5 */
    private CameraInterface f12685k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private CameraUIInterface f12686l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private PreviewEffectProcess f12687m = null;

    /* renamed from: q */
    public String m12117q() {
        return ApsConstant.CAPTURE_MODE_COMMON;
    }

    public ModeManager(Activity activity) {
        this.f12684j = null;
        this.f12684j = activity;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11816a(CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        this.f12685k = interfaceC2646a;
        this.f12686l = cameraUIInterface;
        this.f12687m = interfaceC3423t;
        FeatureFactory.m14365a().m14368a(this.f12685k, this.f12686l);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public BaseMode m11800a(String str) {
        Map<String, BaseMode> map = this.f12678d;
        if (map != null) {
            return map.get(str);
        }
        CameraLog.m12967f("ModeManager", "getModeByName, error, mBaseModeMap is null.");
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11832a() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isPanelMode();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11829a(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onBinauralRecordStateChanged(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11899b() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHideUICapture();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11961c() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHideHeadLine();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m12020d() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isModeBarSelected();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m12067e() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getOperatingMode();
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m12072f() {
        BaseMode baseMode = this.f12678d.get(this.f12683i);
        return (baseMode == null || !baseMode.isPanelMode()) ? this.f12683i : ApsConstant.CAPTURE_MODE_COMMON;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public MainShutterButtonInfo m12076g() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getShutterButtonInfo();
        }
        CameraLog.m12967f("ModeManager", "getShutterButtonInfo, mCurrentMode is null..");
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m12082h() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCaptureModeType();
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m12086i() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCommonVideoMode();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m12090j() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedMetaDataWhenPause();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m12095k() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoModeType();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11896b(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.hideBubble(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11897b(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.operateViewWhenMultiFinger(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m11803a(int OplusGLSurfaceView_13, String str) {
        if (m11901b(OplusGLSurfaceView_13, str)) {
            return str;
        }
        String strM24382b = Util.m24382b(this.f12685k.mo10583m());
        CameraLog.m12954a("ModeManager", "getEnabledModeForCameraId, modeName: " + str + ", Switch to mode: " + strM24382b);
        return strM24382b;
    }

    /* renamed from: dR */
    private BaseMode m11764dR() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT)) {
            return new QuickCaptureMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
        }
        return new CommonCapMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11965c(String str) {
        if (!m11901b(this.f12675a, str)) {
            CameraLog.m12967f("ModeManager", "setCurrentMode fail, the mode: " + str + " is not enabled at cameraId: " + this.f12675a);
            str = Util.m24382b(this.f12685k.mo10583m());
            if (ApsConstant.CAPTURE_MODE_COMMON.equals(str) && this.f12678d.get(ApsConstant.CAPTURE_MODE_COMMON) == null) {
                BaseMode baseModeM11764dR = m11764dR();
                this.f12678d.put(baseModeM11764dR.getCameraMode(), baseModeM11764dR);
            } else if (ApsConstant.REC_MODE_COMMON.equals(str) && this.f12678d.get(ApsConstant.REC_MODE_COMMON) == null) {
                CommonVideoMode c2651e = new CommonVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                this.f12678d.put(c2651e.getCameraMode(), c2651e);
            }
        }
        BaseMode baseMode = this.f12678d.get(str);
        if (baseMode == null) {
            CameraLog.m12967f("ModeManager", "setCurrentMode, cannot find cap mode: " + str);
            return false;
        }
        baseMode.setCameraId(this.f12675a);
        baseMode.updateFilterNoneIndex();
        BaseMode baseMode2 = this.mCurrentMode;
        if (baseMode2 != null) {
            if (baseMode2.getCameraMode().equals(str)) {
                CameraLog.m12954a("ModeManager", "setCurrentMode fail, the mode not change: " + str);
                return false;
            }
            if (!m11832a()) {
                this.f12683i = this.mCurrentMode.getCameraMode();
            }
            this.mCurrentMode.deInitCameraMode(str);
        }
        this.mCurrentMode = baseMode;
        this.mCurrentMode.updateOneCamera(this.f12679e);
        this.mCurrentMode.initCameraMode();
        this.mCurrentMode.setLowBatteryState(this.f12681g);
        this.mCurrentMode.setDisplayOnLock(this.f12682h);
        CameraLog.m12954a("ModeManager", "setCurrentMode, mCurrentMode mode: " + baseMode.getCameraMode());
        return true;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m12098l() {
        return this.mCurrentMode.onBackPressed();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m12100m() {
        this.mCurrentMode.hideViewWhileResume();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public String m12105n() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCameraMode();
        }
        return null;
    }

    /* renamed from: o */
    public boolean m12110o() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isZoomFaceRectifySupported();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11835a(MotionEvent motionEvent) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null) {
            return false;
        }
        return baseMode.onDown(motionEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11902b(MotionEvent motionEvent) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null) {
            return false;
        }
        return baseMode.onSingleTapUp(motionEvent);
    }

    /* renamed from: p */
    public void m12112p() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTouchFocus();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11836a(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onScroll(motionEvent, motionEvent2, COUIBaseListPopupWindow_12, f2);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11963c(MotionEvent motionEvent) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onLongPress(motionEvent);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11839a(boolean z, boolean z2) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.checkSensorMask(z, z2);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11824a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onPreviewCaptureResult(cameraPreviewResult);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11814a(ThumbnailItem thumbnailItem) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onThumbnailUpdated(thumbnailItem);
        }
    }

    /* renamed from: r */
    public void m12121r() throws NumberFormatException {
        CameraLog.m12952a("onBeforePreview");
        if (this.mCurrentMode != null) {
            CameraLog.m12967f("ModeManager", "onBeforePreview, capMode: " + this.mCurrentMode.getCameraMode() + ", mCurrentMode: " + this.mCurrentMode);
            this.mCurrentMode.beforePreview();
        }
        CameraLog.m12958b("onBeforePreview");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11959c(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.afterStartPreview(z);
        }
    }

    /* renamed from: s */
    public boolean m12125s() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHyperLapseOpen();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11818a(OneCamera interfaceC2694d) {
        this.f12679e = interfaceC2694d;
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateOneCamera(interfaceC2694d);
        }
    }

    /* renamed from: t */
    public void m12126t() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onUpdateCameraSettingMenu();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m12022d(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportMenu(str);
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m12071e(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportSubMenu(str);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11806a(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setOrientation(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: u */
    public boolean m12131u() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null) {
            return false;
        }
        this.f12677c = baseMode;
        return baseMode.burstShotCapture();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m12023d(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        this.f12677c = baseMode;
        return baseMode.capture(z);
    }

    /* renamed from: v */
    public void m12132v() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startShortVideoRecording();
        }
    }

    /* renamed from: w */
    public void m12135w() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopShortVideoRecording();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11807a(int OplusGLSurfaceView_13, int i2) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onThermalLevelChange(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11893b(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onVideoTemperatureThresholdChanged(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: x */
    public void m12138x() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onShutterButtonLongClick();
        }
    }

    /* renamed from: y */
    public void m12140y() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopQuickVideoRecording();
        }
    }

    /* renamed from: z */
    public boolean m12143z() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getQuickVideoRecording();
        }
        return false;
    }

    /* renamed from: A */
    public boolean m11767A() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isQuickVideoInRestriction();
        }
        return false;
    }

    /* renamed from: B */
    public boolean m11769B() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.canShowResumeButton();
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12069e(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setQuickVideoBeforeLockTime(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m12075f(boolean z) {
        return this.mCurrentMode.stopTakePicture(z);
    }

    /* renamed from: C */
    public void m11770C() {
        this.mCurrentMode.disableBurstShot();
    }

    /* renamed from: D */
    public void m11772D() {
        this.mCurrentMode.beforeStartRecording();
        m11763D(false);
    }

    /* renamed from: E */
    public void m11773E() {
        this.mCurrentMode.afterStartRecording();
    }

    /* renamed from: F */
    public void m11774F() {
        this.mCurrentMode.afterStopRecording();
        m11763D(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11957c(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModeManager", "setCameraId, cameraId: " + this.f12675a + " -> " + OplusGLSurfaceView_13);
        int i2 = this.f12675a;
        if (-1 != i2 && OplusGLSurfaceView_13 != i2) {
            SwitchCameraPerformance.setSwitchCameraId(i2, OplusGLSurfaceView_13);
        }
        this.f12675a = OplusGLSurfaceView_13;
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setCameraId(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: G */
    public void m11775G() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforeSwitchCamera();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12019d(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModeManager", "cameraIdChanged, cameraId: " + this.f12675a + " -> " + OplusGLSurfaceView_13);
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null || this.f12675a == -1) {
            return;
        }
        this.f12675a = OplusGLSurfaceView_13;
        baseMode.cameraIdChanged(OplusGLSurfaceView_13);
    }

    /* renamed from: H */
    public void m11776H() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomMenuCollapsing();
        }
    }

    /* renamed from: I */
    public void m11777I() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomMenuCollapsed();
        }
    }

    /* renamed from: J */
    public void m11778J() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomMenuExpand();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12068e(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomTransitionChanged(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11804a(float COUIBaseListPopupWindow_12) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomAlphaChanged(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12073f(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateControlPanelBgColor(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12077g(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFilterItemChange(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m12083h(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onEffectItemClick(OplusGLSurfaceView_13);
        }
        return false;
    }

    /* renamed from: K */
    public boolean m11779K() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAnyModeAnimationRunning();
        }
        return false;
    }

    /* renamed from: L */
    public boolean m11780L() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isBackPortraitCameraSwitching();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11825a(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onApsPreviewCaptureCompleted(cameraPreviewResult, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11821a(ImageCallback interfaceC3419p) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.createEffectTextures(interfaceC3419p);
        }
    }

    /* renamed from: M */
    public void m11781M() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectSurfaceCreated();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12074f(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectMenuChange(str);
        }
    }

    /* renamed from: N */
    public boolean m11782N() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.hasEffectSelected();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11898b(boolean z, boolean z2) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.displayAllIcon(z, z2);
        }
    }

    /* renamed from: O */
    public void m11783O() {
        CameraLog.m12954a("ModeManager", "displayScreenHint");
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateHintView();
            this.mCurrentMode.displayFixedUpModeHint();
            this.mCurrentMode.displayScreenHintIconInSwitchOn();
            this.mCurrentMode.clearFocusOutOfRange();
        }
    }

    /* renamed from: P */
    public void m11784P() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.showLowMemory();
        }
    }

    /* renamed from: Q */
    public long m11785Q() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getMinimumCaptureMemory();
        }
        return 52428800L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean m11837a(com.oplus.camera.CameraConstant.PlatformImplementations.kt_3 r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f12680f     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L13
            com.oplus.camera.capmode.BaseMode r0 = r1.mCurrentMode     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L13
            com.oplus.camera.capmode.BaseMode r0 = r1.mCurrentMode     // Catch: java.lang.Throwable -> L16
            boolean r2 = r0.isAllowSwitch(r2)     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            monitor-exit(r1)
            return r2
        L16:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.ModeManager.m11837a(com.oplus.camera.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3):boolean");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m12079g(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getAddMenuOptionEnabled(str);
        }
        return false;
    }

    /* renamed from: R */
    public int m11786R() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultAFMode();
        }
        return 4;
    }

    /* renamed from: S */
    public String m11787S() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getFlashMode() : "off";
    }

    /* renamed from: T */
    public boolean m11788T() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFrontTorchEnabled();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Size m11796a(OplusCameraCharacteristics c2698h) {
        return m11798a(c2698h, (String) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Size m11798a(OplusCameraCharacteristics c2698h, String str) {
        CameraLog.m12952a("getPreviewSize");
        BaseMode baseMode = this.mCurrentMode;
        Size previewSize = baseMode == null ? null : baseMode.getPreviewSize(c2698h, str);
        CameraLog.m12958b("getPreviewSize");
        return previewSize;
    }

    /* renamed from: U */
    public int m11789U() {
        return this.mCurrentMode.getPreviewDispalyWidth();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Size m11892b(OplusCameraCharacteristics c2698h) {
        return this.mCurrentMode.getPreviewFrameSize(c2698h);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Size m11956c(OplusCameraCharacteristics c2698h) {
        return this.mCurrentMode.getPictureSize(c2698h);
    }

    /* renamed from: V */
    public boolean m11790V() {
        return this.mCurrentMode.isInCapturePreparing();
    }

    /* renamed from: W */
    public boolean m11791W() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getIsCapturingState();
        }
        CameraLog.m12967f("ModeManager", "getIsCapturingState, camera has been destroyed");
        return false;
    }

    /* renamed from: X */
    public boolean m11792X() {
        return this.mCurrentMode.getIsBurstShotCapturing();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12078g(boolean z) {
        this.mCurrentMode.setBurstShotCapturing(z);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12081h(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setAllowSwitchMode(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12080h(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.showPictureSizeHint(str);
        }
    }

    /* renamed from: Y */
    public void m11793Y() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onShareMenuExpand();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m12087i(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needUploadOplusStatistics(str);
        }
        return false;
    }

    /* renamed from: Z */
    public void m11794Z() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.checkoutTimerSnapShotState();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m12085i(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTimeSnapShotEnd(z);
        }
    }

    /* renamed from: aa */
    public boolean m11866aa() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.supportBeautyButton();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m12091j(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportFunction(str);
        }
        return false;
    }

    /* renamed from: ab */
    public boolean m11867ab() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportShowFilterMenu();
        }
        return false;
    }

    /* renamed from: ac */
    public boolean m11868ac() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getScreenTorchModeState();
        }
        return false;
    }

    /* renamed from: ad */
    public String m11869ad() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getFullPictureSizeType() : DcsMsgData.FULL;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public DcsMsgData m11801a(DcsMsgData dcsMsgData) {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getBeforeCaptureMsgCommonData(dcsMsgData) : dcsMsgData;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public DcsMsgData m11802a(DcsMsgData dcsMsgData, Storage.CameraPicture cameraPicture) {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getAfterCaptureMsgCommonData(dcsMsgData, cameraPicture) : dcsMsgData;
    }

    /* renamed from: ae */
    public void m11870ae() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.closeImageReader();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016b  */
    /* renamed from: OplusGLSurfaceView_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m12093k(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.ModeManager.m12093k(java.lang.String):void");
    }

    /* renamed from: af */
    public boolean m11871af() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isMicroscopeMode();
        }
        return false;
    }

    /* renamed from: ag */
    public boolean m11872ag() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode instanceof FishEyeMode;
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m12089j(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resume(z);
        }
    }

    /* renamed from: ah */
    public void m11873ah() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.pause();
        }
    }

    /* renamed from: ai */
    public void m11874ai() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stop();
        }
    }

    /* renamed from: aj */
    public void m11875aj() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforePause();
        }
    }

    /* renamed from: ak */
    public String m11876ak() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getTimeLapse();
        }
        return null;
    }

    /* renamed from: al */
    public void m11877al() {
        synchronized (this) {
            if (this.f12678d != null) {
                Iterator<String> it = this.f12678d.keySet().iterator();
                while (it.hasNext()) {
                    BaseMode baseMode = this.f12678d.get(it.next());
                    if (baseMode != null) {
                        baseMode.destroy();
                    }
                }
                this.f12678d.clear();
                this.f12680f = false;
                this.f12678d = null;
                this.mCurrentMode = null;
                this.f12677c = null;
            }
        }
        this.f12684j = null;
    }

    /* renamed from: dS */
    private void m11765dS() {
        if (this.f12676b != this.mCurrentMode.mCameraInterface.mo10591u()) {
            this.f12676b = this.mCurrentMode.mCameraInterface.mo10591u();
            m11806a(this.f12676b);
        }
    }

    /* renamed from: D */
    private void m11763D(boolean z) {
        if (z) {
            m11765dS();
        }
    }

    /* renamed from: am */
    public boolean m11878am() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowProgressBarForOtherApp();
        }
        return true;
    }

    /* renamed from: an */
    public boolean m11879an() {
        return this.mCurrentMode.getIsShowPostCaptureAlert();
    }

    /* renamed from: ao */
    public boolean m11880ao() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedProgressBarInCapture();
        }
        return false;
    }

    /* renamed from: ap */
    public boolean m11881ap() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedShowMenuOnTimeSnapShotEnd();
        }
        return true;
    }

    /* renamed from: aq */
    public boolean m11882aq() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedSetRecordingMargin();
        }
        return false;
    }

    /* renamed from: ar */
    public int m11883ar() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getReceiveBustShotNum();
        }
        return 0;
    }

    /* renamed from: as */
    public void m11884as() {
        this.mCurrentMode.onCameraIdChangedAnimationEnd();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11810a(int OplusGLSurfaceView_13, boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPIEnable(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: at */
    public void m11885at() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetFiltersList();
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m12096l(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateGrandTourCityFiltersPosition(str);
        }
    }

    /* renamed from: au */
    public void m11886au() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateAISceneMode();
        }
    }

    /* renamed from: av */
    public void m11887av() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updatePIMode();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m12084i(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onAISceneClosed(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: aw */
    public synchronized void m11888aw() {
        CameraLog.m12952a("initBaseModeMap");
        if (this.f12678d == null) {
            CameraLog.m12967f("ModeManager", "initBaseModeMap, mBaseModeMap is null!");
            return;
        }
        CameraLog.m12954a("ModeManager", "initBaseModeMap, mBaseModeList Size: " + this.f12678d.size());
        if (this.f12685k.mo10583m()) {
            if (this.f12678d.get(ApsConstant.REC_MODE_COMMON) == null) {
                CommonVideoMode c2651e = new CommonVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                this.f12678d.put(c2651e.getCameraMode(), c2651e);
            }
        } else {
            if (this.f12678d.get(ApsConstant.CAPTURE_MODE_COMMON) == null) {
                BaseMode baseModeM11764dR = m11764dR();
                this.f12678d.put(baseModeM11764dR.getCameraMode(), baseModeM11764dR);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PORTRAIT) && this.f12678d.get("portrait") == null) {
                PortraitCapMode c2814a = new PortraitCapMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                this.f12678d.put(c2814a.getCameraMode(), c2814a);
            }
            if (this.f12685k.mo10575i()) {
                if (this.f12678d.get(ApsConstant.REC_MODE_COMMON) == null) {
                    CommonVideoMode c2651e2 = new CommonVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2651e2.getCameraMode(), c2651e2);
                }
                if (this.f12678d.get(ApsConstant.CAPTURE_MODE_PANORAMA) == null) {
                    PanoramaCapMode c2840f = new PanoramaCapMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2840f.getCameraMode(), c2840f);
                }
                if (this.f12678d.get(ApsConstant.REC_MODE_FAST_VIDEO) == null) {
                    FastVideoMode c2777a = new FastVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2777a.getCameraMode(), c2777a);
                }
                if (this.f12678d.get(ApsConstant.REC_MODE_SLOW_VIDEO) == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO)) {
                    SlowVideoMode c2917g = new SlowVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2917g.getCameraMode(), c2917g);
                }
                if (this.f12678d.get(ApsConstant.CAPTURE_MODE_MULTI_VIDEO) == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
                    MultiVideoMode c2663q = new MultiVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2663q.getCameraMode(), c2663q);
                }
                if (this.f12678d.get("movie") == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MOVIE_MODE)) {
                    MovieMode c2724s = new MovieMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2724s.getCameraMode(), c2724s);
                }
                if (this.f12678d.get(ApsConstant.CAPTURE_MODE_PROFESSIONAL) == null) {
                    if (!Util.m24352ao()) {
                        ProfessionalCapMode viewOnClickListenerC2904v = new ProfessionalCapMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                        this.f12678d.put(viewOnClickListenerC2904v.getCameraMode(), viewOnClickListenerC2904v);
                    } else {
                        HSProfessionalCapMode viewOnClickListenerC2890h = new HSProfessionalCapMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                        this.f12678d.put(viewOnClickListenerC2890h.getCameraMode(), viewOnClickListenerC2890h);
                    }
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER) && this.f12678d.get(ApsConstant.CAPTURE_MODE_STICKER) == null) {
                    StickerMode c2666t = new StickerMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2666t.getCameraMode(), c2666t);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT)) {
                    NightMode c2664r = new NightMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2664r.getCameraMode(), c2664r);
                }
                if (this.f12678d.get(ApsConstant.CAPTURE_MODE_MACRO) == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MACRO_MODE)) {
                    MacroMode c2660n = new MacroMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2660n.getCameraMode(), c2660n);
                }
                if (this.f12678d.get("superText") == null) {
                    SuperTextMode c2667u = new SuperTextMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2667u.getCameraMode(), c2667u);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ID_PHOTO) && this.f12678d.get(ApsConstant.CAPTURE_MODE_ID_PHOTO) == null && Util.m24500v(this.f12684j) && RegionCommonFeatureAdapter.m14538g()) {
                    IdPhotoMode c2658l = new IdPhotoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2658l.getCameraMode(), c2658l);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FISH_EYE) && this.f12678d.get(ApsConstant.CAPTURE_MODE_FISH_EYE) == null) {
                    FishEyeMode c2654h = new FishEyeMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2654h.getCameraMode(), c2654h);
                }
                if (this.f12678d.get(ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION) == null) {
                    UltraHighResolutionMode c2668v = new UltraHighResolutionMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2668v.getCameraMode(), c2668v);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HIGH_PIXEL_SUPPORT) && this.f12678d.get(ApsConstant.CAPTURE_MODE_HIGH_PIXEL) == null) {
                    HighPixelMode c2657k = new HighPixelMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2657k.getCameraMode(), c2657k);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION) && this.f12678d.get(ApsConstant.CAPTURE_MODE_HIGH_DEFINITION) == null) {
                    HighDefinitionMode c2656j = new HighDefinitionMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2656j.getCameraMode(), c2656j);
                }
                if (this.f12678d.get(ApsConstant.CAPTURE_MODE_GROUP_SHOT) == null) {
                    GroupShotMode c2655i = new GroupShotMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2655i.getCameraMode(), c2655i);
                }
                if (CameraConfig.isSupportMicroscope() && this.f12678d.get(ApsConstant.CAPTURE_MODE_MICROSCOPE) == null) {
                    MicroscopeCaptureMode c2661o = new MicroscopeCaptureMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2661o.getCameraMode(), c2661o);
                }
                if (CameraConfig.isSupportMicroscope() && this.f12678d.get(ApsConstant.REC_MODE_MICROSCOPE) == null) {
                    MicroscopeVideoMode c2662p = new MicroscopeVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2662p.getCameraMode(), c2662p);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT) && this.f12678d.get(ApsConstant.REC_MODE_DOUBLE_EXPOSURE) == null) {
                    DoubleExposureMode viewOnClickListenerC2653g = new DoubleExposureMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(viewOnClickListenerC2653g.getCameraMode(), viewOnClickListenerC2653g);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STARRY_MODE) && this.f12678d.get(ApsConstant.CAPTURE_MODE_STARRY) == null) {
                    StarryMode c2922d = new StarryMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2922d.getCameraMode(), c2922d);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STARRY_MODE) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO) && this.f12678d.get(ApsConstant.REC_MODE_STAR_VIDEO) == null) {
                    StarVideoMode c2920b = new StarVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2920b.getCameraMode(), c2920b);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_XPAN_MODE) && this.f12678d.get(ApsConstant.CAPTURE_MODE_XPAN) == null) {
                    XPanMode c2671y = new XPanMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2671y.getCameraMode(), c2671y);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_PHOTO) && this.f12678d.get(ApsConstant.CAPTURE_MODE_TILT_SHIFT) == null) {
                    TiltShiftPhotoMode tiltShiftPhotoMode = new TiltShiftPhotoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(tiltShiftPhotoMode.getCameraMode(), tiltShiftPhotoMode);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_FAST_VIDEO) && this.f12678d.get(ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO) == null) {
                    TiltShiftFastVideoMode tiltShiftFastVideoMode = new TiltShiftFastVideoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(tiltShiftFastVideoMode.getCameraMode(), tiltShiftFastVideoMode);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT) && this.f12678d.get(ApsConstant.REC_MODE_TIMELASPE_PRO) == null) {
                    TimeLapseProMode c3072h = new TimeLapseProMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c3072h.getCameraMode(), c3072h);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STREET_MODE) && this.f12678d.get(ApsConstant.CAPTURE_MODE_STREET) == null) {
                    StreetMode c3025e = new StreetMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c3025e.getCameraMode(), c3025e);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LONG_EXPOSURE_MODE)) {
                    LongExposureMode c2659m = new LongExposureMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2659m.getCameraMode(), c2659m);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_3D_PHOTO) && this.f12678d.get(ApsConstant.CAPTURE_MODE_3D_PHOTO) == null) {
                    ThreeDPhotoMode c2865c = new ThreeDPhotoMode(this.f12684j, this.f12685k, this.f12686l, this.f12687m);
                    this.f12678d.put(c2865c.getCameraMode(), c2865c);
                }
            }
        }
        this.f12680f = true;
        CameraLog.m12958b("initBaseModeMap");
        CameraLog.m12954a("ModeManager", "initBaseModeMap X, mBaseModeList Size: " + this.f12678d.size());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized boolean m11901b(int OplusGLSurfaceView_13, String str) {
        if (str == null) {
            CameraLog.m12967f("ModeManager", "getPluginEnabled ,mode-string or mPlugins is null,so return");
            return false;
        }
        if (!this.f12678d.containsKey(str)) {
            return false;
        }
        BaseMode baseMode = this.f12678d.get(str);
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            return baseMode.getFrontEnable();
        }
        return baseMode.getRearEnable();
    }

    /* renamed from: ax */
    public void m11889ax() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onUiModeChanged();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11811a(SharedPreferences sharedPreferences, String str) {
        this.mCurrentMode.onSharedPreferenceChanged(sharedPreferences, str);
    }

    /* renamed from: ay */
    public boolean m11890ay() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAnimojiOpen();
        }
        return false;
    }

    /* renamed from: az */
    public boolean m11891az() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHistogramOpen();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m12094k(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateInversePositionRatio(z);
        }
    }

    /* renamed from: aA */
    public boolean m11840aA() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAISceneOpen();
        }
        return false;
    }

    /* renamed from: aB */
    public boolean m11841aB() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isPIAISceneOpen();
        }
        return false;
    }

    /* renamed from: aC */
    public boolean m11842aC() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVividEffectOpen();
        }
        return false;
    }

    /* renamed from: aD */
    public boolean m11843aD() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFlashState();
        }
        return false;
    }

    /* renamed from: aE */
    public boolean m11844aE() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedAPSProcess();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11895b(int OplusGLSurfaceView_13, boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: aF */
    public void m11845aF() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetMetadataBokehCode();
        }
    }

    /* renamed from: aG */
    public void m11846aG() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.hideFirstBeautyTipView();
        }
    }

    /* renamed from: aH */
    public void m11847aH() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.hideStreetRockerShutterTipView();
        }
    }

    /* renamed from: aI */
    public void m11848aI() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onShowBubble();
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m12102m(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onHDRModeChanged(str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11819a(TiltShiftParam tiltShiftParam) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setTiltShiftParams(tiltShiftParam);
        }
    }

    /* renamed from: aJ */
    public boolean m11849aJ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isTiltShiftOpen();
        }
        return false;
    }

    /* renamed from: aK */
    public boolean m11850aK() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isTiltShiftSupportBeauty();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m12097l(boolean z) {
        this.f12682h = z;
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setDisplayOnLock(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m12103m(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.forceStopVideoRecording(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m12106n(boolean z) {
        this.f12681g = z;
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setLowBatteryState(z);
        }
    }

    /* renamed from: o */
    public void m12109o(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.doReturnToCaller(z);
        }
    }

    /* renamed from: aL */
    public void m11851aL() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.deleteCurrentVideo();
        }
    }

    /* renamed from: aM */
    public boolean m11852aM() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needDelayFaceDetection();
        }
        return false;
    }

    /* renamed from: aN */
    public void m11853aN() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startPlayVideoActivity();
        }
    }

    /* renamed from: aO */
    public void m11854aO() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onVideoRetakeButtonClick();
        }
    }

    /* renamed from: aP */
    public void m11855aP() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.m17833aj();
        }
    }

    /* renamed from: aQ */
    public void m11856aQ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onScreenOffWhenLocked();
        }
    }

    /* renamed from: aR */
    public boolean m11857aR() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onVideoRecordingPause();
        }
        return false;
    }

    /* renamed from: aS */
    public boolean m11858aS() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onVideoRecordingResume();
        }
        return false;
    }

    /* renamed from: aT */
    public boolean m11859aT() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStarting();
        }
        return false;
    }

    /* renamed from: aU */
    public boolean m11860aU() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStarted();
        }
        return false;
    }

    /* renamed from: aV */
    public boolean m11861aV() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecording();
        }
        return false;
    }

    /* renamed from: aW */
    public boolean m11862aW() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHalVideoRecording();
        }
        return false;
    }

    /* renamed from: aX */
    public boolean m11863aX() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.showMenuLeftButton();
        }
        return false;
    }

    /* renamed from: aY */
    public boolean m11864aY() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.showBeautyButton();
        }
        return false;
    }

    /* renamed from: aZ */
    public boolean m11865aZ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStopped();
        }
        return true;
    }

    /* renamed from: ba */
    public boolean m11930ba() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStopping();
        }
        return false;
    }

    /* renamed from: p */
    public void m12115p(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPreburstShotCapture(z);
        }
    }

    /* renamed from: bb */
    public boolean m11931bb() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoHighFps();
        }
        return false;
    }

    /* renamed from: bc */
    public boolean m11932bc() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.is4k();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public Bitmap m12088j(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getVideoThumbnail(OplusGLSurfaceView_13);
        }
        return null;
    }

    /* renamed from: bd */
    public CameraStatisticsUtil.MakerNote m11933bd() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getMakerNote();
        }
        return null;
    }

    /* renamed from: be */
    public long m11934be() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getResumePauseRecordingTotalTime();
        }
        return 0L;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m12092k(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setSysBrightness(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: bf */
    public void m11935bf() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectMenuPopUp();
        }
    }

    /* renamed from: q */
    public void m12119q(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectMenuPopDown(z);
        }
    }

    /* renamed from: bg_renamed */
    public boolean m11936bg() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.showEffectMenu();
        }
        return true;
    }

    /* renamed from: bh */
    public boolean m11937bh() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isStickerMenuOpen();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11833a(int OplusGLSurfaceView_13, MotionEvent motionEvent) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.performSlide(OplusGLSurfaceView_13, motionEvent);
        }
        return false;
    }

    /* renamed from: bi */
    public boolean m11938bi() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.updateViewByEnterCameraType();
        }
        return false;
    }

    /* renamed from: bj */
    public void m11939bj() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startScreenTorch();
        }
    }

    /* renamed from: bk */
    public void m11940bk() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopScreenTorch();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11834a(Image image) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onPreviewFrameReceived(image);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11831a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null || baseMode != this.f12677c) {
            return;
        }
        baseMode.onPictureCallback(bArr, OplusGLSurfaceView_13, i2, i3, z, i4);
    }

    /* renamed from: r */
    public void m12122r(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPictureHasSuperTextResult(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m12107n(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needSurface(str);
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m12099l(int OplusGLSurfaceView_13) {
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            return false;
        }
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needPreviewMeta(OplusGLSurfaceView_13);
        }
        return true;
    }

    /* renamed from: bl */
    public boolean m11941bl() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needSatCrossAnimation();
        }
        return false;
    }

    /* renamed from: bm */
    public boolean m11942bm() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needClearFocusView();
        }
        return false;
    }

    /* renamed from: bn */
    public boolean m11943bn() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getZSLMode();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m12021d(MotionEvent motionEvent) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11822a(CameraDeviceConfig.Builder builder) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setConfigureParameter(builder);
        }
    }

    /* renamed from: bo */
    public void m11944bo() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSessionConfigured();
        }
    }

    /* renamed from: bp */
    public boolean m11945bp() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHFR();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m12101m(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setBeauty3DState(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public int m12104n(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getBeauty3DScanIconType(OplusGLSurfaceView_13);
        }
        return 0;
    }

    /* renamed from: bq */
    public boolean m11946bq() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowBeauty3D();
        }
        return false;
    }

    /* renamed from: br */
    public boolean m11947br() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowAnimojiMenu();
        }
        return false;
    }

    /* renamed from: bs */
    public boolean m11948bs() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowProPanelMenu();
        }
        return false;
    }

    /* renamed from: bt */
    public boolean m11949bt() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.supportMenuLeftButton();
        }
        return false;
    }

    /* renamed from: bu */
    public boolean m11950bu() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.canShowTimeLapseProButtons();
        }
        return false;
    }

    /* renamed from: bv */
    public void m11951bv() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomChanged();
        }
    }

    /* renamed from: bw */
    public int m11952bw() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getBeauty3Dstatus();
        }
        return 0;
    }

    /* renamed from: bx */
    public boolean m11953bx() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowingGuideView();
        }
        return false;
    }

    /* renamed from: by */
    public int m11954by() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getShortcutFaceBeautyIndex();
        }
        return 0;
    }

    /* renamed from: bz */
    public void m11955bz() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSwitchCameraButtonClick();
        }
    }

    /* renamed from: bA */
    public String m11904bA() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPhotoRatio();
        }
        return null;
    }

    /* renamed from: bB */
    public int m11905bB() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getVideoFps();
        }
        return 0;
    }

    /* renamed from: o */
    public int m12108o(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSwitchAnimTime(OplusGLSurfaceView_13);
        }
        return 0;
    }

    /* renamed from: bC */
    public int m11906bC() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFaceBeautyCurrIndex();
        }
        return 0;
    }

    /* renamed from: bD */
    public boolean m11907bD() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isMakeupOpen();
        }
        return false;
    }

    /* renamed from: bE */
    public int m11908bE() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getZoomBarOffset();
        }
        return 0;
    }

    /* renamed from: bF */
    public int m11909bF() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFaceBeautyMenuType();
        }
        return 0;
    }

    /* renamed from: p */
    public void m12113p(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFaceBeautyItemChange(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: bG */
    public void m11910bG() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetFaceBeautyValues();
        }
    }

    /* renamed from: q */
    public int m12116q(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFaceBeautyItemValue(OplusGLSurfaceView_13);
        }
        return -100000;
    }

    /* renamed from: bH */
    public int m11911bH() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultCommonBeautyValue();
        }
        return 40;
    }

    /* renamed from: bI */
    public int[] m11912bI() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultCustomBeautyValues();
        }
        return CameraConstant.f13116a;
    }

    /* renamed from: bJ */
    public int[] m11913bJ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultMakeupValues();
        }
        return FaceBeautyHelp.f21226a;
    }

    /* renamed from: r */
    public int m12120r(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getMakeupItemValue(OplusGLSurfaceView_13);
        }
        return FaceBeautyHelp.f21226a[OplusGLSurfaceView_13];
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11958c(int OplusGLSurfaceView_13, boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMakeupTypeChanged(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11808a(int OplusGLSurfaceView_13, int i2, boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMakeupValueChanged(OplusGLSurfaceView_13, i2, z);
        }
    }

    /* renamed from: bK */
    public int m11914bK() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCurrMakeupIndex();
        }
        return 0;
    }

    /* renamed from: bL */
    public boolean m11915bL() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportShowCustomAll();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11894b(int OplusGLSurfaceView_13, int i2, boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFaceBeautyItemValueChange(OplusGLSurfaceView_13, i2, z);
        }
    }

    /* renamed from: bM */
    public boolean m11916bM() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onFaceBeautyMenuClick();
        }
        return true;
    }

    /* renamed from: bN */
    public boolean m11917bN() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHighPictureSize();
        }
        return false;
    }

    /* renamed from: bO */
    public boolean m11918bO() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isUltraWideHighPictureSize();
        }
        return false;
    }

    /* renamed from: bP */
    public double m11919bP() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDisplayHighPictureSize();
        }
        return -1.0d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Size m11799a(String str, OplusCameraCharacteristics c2698h) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSurfaceSize(str, c2698h);
        }
        return null;
    }

    /* renamed from: s */
    public void m12123s(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFocusingSoundVolume(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11815a(CameraApsDecision cameraApsDecision) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onPreviewDecisionResult(cameraApsDecision);
        }
    }

    /* renamed from: bQ */
    public int m11920bQ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getBlurIndex();
        }
        return 60;
    }

    /* renamed from: t */
    public void m12127t(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setBlurIndex(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11960c(boolean z, boolean z2) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.switchVideoBlur(z, z2);
        }
    }

    /* renamed from: bR */
    public boolean m11921bR() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isBlurOpen();
        }
        return false;
    }

    /* renamed from: bS */
    public boolean m11922bS() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowUltraWide();
        }
        return true;
    }

    /* renamed from: bT */
    public void m11923bT() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFilterMenuClicked();
        }
    }

    /* renamed from: bU */
    public boolean m11924bU() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoNeonOpen();
        }
        return false;
    }

    /* renamed from: s */
    public void m12124s(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setVideoBlurOpen(z);
        }
    }

    /* renamed from: bV */
    public void m11925bV() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setCapturePreviewDataStateIdle();
        }
    }

    /* renamed from: t */
    public void m12128t(boolean z) {
        this.mCurrentMode.setCachePreviewStart(z);
    }

    /* renamed from: bW */
    public boolean m11926bW() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSuperTextOpen();
        }
        return false;
    }

    /* renamed from: bX */
    public boolean m11927bX() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isIdPhotoOpen();
        }
        return false;
    }

    /* renamed from: bY */
    public boolean m11928bY() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportFaceView();
        }
        return false;
    }

    /* renamed from: bZ */
    public String m11929bZ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getHeicCodecFormat();
        }
        return null;
    }

    /* renamed from: ca */
    public boolean m11992ca() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isInNightProcess();
        }
        return false;
    }

    /* renamed from: cb */
    public boolean m11993cb() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCountDownStarted();
        }
        return false;
    }

    /* renamed from: cc */
    public boolean m11994cc() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isLongExposureSceneMenuOpen();
        }
        return false;
    }

    /* renamed from: cd */
    public boolean m11995cd() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isOpenHDR();
        }
        return false;
    }

    /* renamed from: ce */
    public boolean m11996ce() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isAutoHDR() && this.mCurrentMode.isHDRSceneModeInAuto();
    }

    /* renamed from: cf */
    public boolean m11997cf() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSuperClearPortraitEnable();
        }
        return false;
    }

    /* renamed from: cg */
    public boolean m11998cg() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isUltraHighResolutionOpened();
        }
        return false;
    }

    /* renamed from: ch */
    public boolean m11999ch() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFilterEffectOpen();
        }
        return false;
    }

    /* renamed from: ci */
    public FilterTexturePreview.PlatformImplementations.kt_3 m12000ci() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFilterCategory();
        }
        return FilterTexturePreview.PlatformImplementations.kt_3.Polarr;
    }

    /* renamed from: cj */
    public int m12001cj() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getImageFormat();
        }
        return 256;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Size m11797a(OplusCameraCharacteristics c2698h, double IntrinsicsJvm.kt_5) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPreviewSize(c2698h, IntrinsicsJvm.kt_5);
        }
        return null;
    }

    public boolean isSatOpen() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSatOpen();
        }
        return false;
    }

    /* renamed from: ck */
    public void m12002ck() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onUltraWideAngleOpened();
        }
    }

    /* renamed from: cl */
    public void m12003cl() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTeleAngleOpened();
        }
    }

    /* renamed from: cm */
    public void m12004cm() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSuperEISChange();
        }
    }

    /* renamed from: o */
    public boolean m12111o(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCameraSettingMenuOptionEnable(str);
        }
        return true;
    }

    public boolean isNoneSatUltraWideAngleOpen() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNoneSatUltraWideAngleOpen();
        }
        return false;
    }

    /* renamed from: cn */
    public boolean m12005cn() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHyperLapseUltraWideOpen();
        }
        return false;
    }

    /* renamed from: co */
    public boolean m12006co() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNoneSatTeleAngleOpen();
        }
        return false;
    }

    /* renamed from: cp */
    public int m12007cp() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getHintTextId();
        }
        return -1;
    }

    /* renamed from: cq */
    public void m12008cq() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onResumeFromSetting();
        }
    }

    /* renamed from: cr */
    public void m12009cr() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTopSubMenuCollapse();
        }
    }

    /* renamed from: cs */
    public void m12010cs() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTopSubMenuExpand();
        }
    }

    /* renamed from: ct */
    public void m12011ct() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateRatioType();
        }
    }

    /* renamed from: u */
    public void m12130u(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.switchSuperEISWide(z);
        }
    }

    /* renamed from: cu */
    public ZoomConfigure m12012cu() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getZoomConfigure();
        }
        return new ZoomConfigure();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11900b(float COUIBaseListPopupWindow_12) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.withinSatMainRange(COUIBaseListPopupWindow_12);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11962c(float COUIBaseListPopupWindow_12) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.withinSatMainAndWideRange(COUIBaseListPopupWindow_12);
        }
        return false;
    }

    /* renamed from: cv */
    public boolean m12013cv() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoSuperEisWideOpen();
        }
        return false;
    }

    /* renamed from: cw */
    public void m12014cw() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetCaptureButton();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11820a(DetectResult c3077a) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPreviewDetectResult(c3077a);
        }
    }

    /* renamed from: cx */
    public boolean m12015cx() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isTrackFocusOpen();
        }
        return false;
    }

    /* renamed from: cy */
    public void m12016cy() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateTrackEnable();
        }
    }

    /* renamed from: cz */
    public boolean m12017cz() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFaceRectifyOpen();
        }
        return false;
    }

    /* renamed from: cA */
    public void m11966cA() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onHomeKeyClick();
        }
    }

    /* renamed from: cB */
    public void m11967cB() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onCameraPermissionGranted();
        }
    }

    /* renamed from: p */
    public void m12114p(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMenuOptionAdded(str);
        }
    }

    /* renamed from: q */
    public void m12118q(String str) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMenuOptionRemoved(str);
        }
    }

    /* renamed from: cC */
    public boolean m11968cC() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isQrCodeOpened();
    }

    /* renamed from: cD */
    public void m11969cD() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopRecordingFrame();
        }
    }

    /* renamed from: cE */
    public void m11970cE() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFrameInterpolationStarted();
        }
    }

    /* renamed from: cF */
    public void m11971cF() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMotionDetected();
        }
    }

    /* renamed from: cG */
    public Thumbnail.IntrinsicsJvm.kt_3 m11972cG() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getAfterStoreRunnable();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11812a(CaptureResult captureResult) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onReceivePreviewCaptureResult(captureResult);
        }
    }

    /* renamed from: cH */
    public boolean m11973cH() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowSceneNightTips();
        }
        return false;
    }

    /* renamed from: cI */
    public boolean m11974cI() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportGestureCapture();
        }
        return true;
    }

    /* renamed from: cJ */
    public boolean m11975cJ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isUltraNightVideoOpen();
        }
        return false;
    }

    /* renamed from: cK */
    public boolean m11976cK() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAiEnhancementVideoOpen();
        }
        return false;
    }

    /* renamed from: cL */
    public boolean m11977cL() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSuperEISOpen();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11827a(String str, boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateFlashState(str, z);
        }
    }

    /* renamed from: v */
    public void m12134v(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFlashTemporaryDisabled(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Size m11795a(Size size) {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getPreviewSurfaceSize(size) : size;
    }

    /* renamed from: cM */
    public void m11978cM() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.clearApsDecisionResult();
        }
    }

    /* renamed from: cN */
    public boolean m11979cN() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportSelectPhotoRatio();
        }
        return false;
    }

    /* renamed from: cO */
    public boolean m11980cO() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSlowVideoMode();
        }
        return false;
    }

    /* renamed from: cP */
    public boolean m11981cP() {
        return this.mCurrentMode instanceof XPanMode;
    }

    /* renamed from: cQ */
    public boolean m11982cQ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isMultiVideoMode();
        }
        return false;
    }

    /* renamed from: cR */
    public boolean m11983cR() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedTransAnimWhenRecording();
        }
        return false;
    }

    /* renamed from: cS */
    public boolean m11984cS() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isStarryMode();
    }

    /* renamed from: cT */
    public boolean m11985cT() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.consumeBackEventOnPictureTaken();
    }

    /* renamed from: w */
    public void m12137w(boolean z) {
        synchronized (this) {
            if (this.f12678d != null) {
                Iterator<String> it = this.f12678d.keySet().iterator();
                while (it.hasNext()) {
                    BaseMode baseMode = this.f12678d.get(it.next());
                    if (baseMode != null) {
                        baseMode.restoreDefaultMode(z);
                    }
                }
            }
        }
    }

    /* renamed from: cU */
    public String m11986cU() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getGuideLineType();
        }
        return null;
    }

    /* renamed from: x */
    public void m12139x(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setNeedCapture(z);
        }
    }

    /* renamed from: cV */
    public float m11987cV() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPreviewXScale();
        }
        return 1.0f;
    }

    /* renamed from: cW */
    public boolean m11988cW() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isCropX();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11838a(boolean z, int OplusGLSurfaceView_13, int i2) {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.getTouchEnable(z, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: cX */
    public int m11989cX() {
        return this.mCurrentMode.getEntryGalleryAnim();
    }

    /* renamed from: cY */
    public boolean m11990cY() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.is10bitsHeicEncodeEnable();
    }

    /* renamed from: cZ */
    public boolean m11991cZ() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.needLutTexture();
    }

    /* renamed from: da */
    public boolean m12041da() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.needShow10bitHint();
    }

    /* renamed from: db */
    public void m12042db() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMoreModeShown();
        }
    }

    /* renamed from: u */
    public void m12129u(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMoreModeHidden(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: dc */
    public long m12043dc() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureDate();
        }
        return 0L;
    }

    /* renamed from: dd */
    public boolean m12044dd() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportLensSwicth();
        }
        return false;
    }

    /* renamed from: de */
    public int m12045de() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureIso();
        }
        return -1;
    }

    /* renamed from: df */
    public long m12046df() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureExposureTime();
        }
        return -1L;
    }

    /* renamed from: v */
    public void m12133v(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSlowVideoFrameChange(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11809a(int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.reportIntelligentDragViewMoveToDcs(OplusGLSurfaceView_13, i2, z, i3);
        }
    }

    /* renamed from: dg */
    public void m12047dg() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFaceBeautyMenuClose();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m11813a(ApsService apsService) {
        if (this.mCurrentMode != null) {
            this.mCurrentMode.setApsService(apsService);
        }
    }

    /* renamed from: dh */
    public void m12048dh() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.revertOp();
        }
    }

    /* renamed from: y */
    public void m12141y(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.cancelOp(z);
        }
    }

    /* renamed from: di */
    public boolean m12049di() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isDoubleExposureOpen();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11830a(byte[] bArr) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onYuvDataReceviced(bArr);
        }
    }

    /* renamed from: dj */
    public boolean m12050dj() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isMirrorEnable();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12018d(float COUIBaseListPopupWindow_12) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setVideoSoundValue(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: dk */
    public void m12051dk() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.checkAiEnhancementVideoState();
        }
    }

    /* renamed from: z */
    public void m12142z(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFocusTrackingState(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11805a(float COUIBaseListPopupWindow_12, float f2) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFocusTrackingLocation(COUIBaseListPopupWindow_12, f2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11826a(String str, Object obj, boolean z, boolean z2) {
        Map<String, BaseMode> map;
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null || (map = this.f12678d) == null || obj == null) {
            return;
        }
        if (z) {
            baseMode.operateSpecificViewCallBack(obj, true, z2);
            return;
        }
        BaseMode baseMode2 = map.get(str);
        if (baseMode2 != null) {
            baseMode2.operateSpecificViewCallBack(obj, false, z2);
        }
    }

    /* renamed from: dl */
    public String m12052dl() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getCurrFilterType() : "default";
    }

    /* renamed from: dm */
    public String m12053dm() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getFilterEffectMenuPreferenceKey() : "key_filter_index";
    }

    /* renamed from: dn */
    public String m12054dn() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getEffectMenuKeyByMode() : CameraUIInterface.KEY_FILTER_MENU;
    }

    /* renamed from: do */
    public String m12055do() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getBlurMenuKeyByMode() : CameraUIInterface.KEY_VIDEO_BLUR_MENU;
    }

    /* renamed from: dp */
    public boolean m12056dp() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needPostProcessAfterStopRecord();
        }
        return false;
    }

    /* renamed from: dq */
    public boolean m12057dq() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.is4k60fps() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11817a(ClipVideoInfo c2683b, VideoClipManager.PlatformImplementations.kt_3 aVar) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onVideoLoadedDone(c2683b, aVar);
        }
    }

    /* renamed from: A */
    public void m11766A(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startLoadVideo(z);
        }
    }

    /* renamed from: w */
    public void m12136w(int OplusGLSurfaceView_13) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onModeShownTips(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: dr */
    public boolean m12058dr() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.shouldHideBlur();
        }
        return true;
    }

    /* renamed from: B */
    public void m11768B(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setVideoBlurEffect(z);
        }
    }

    /* renamed from: ds */
    public boolean m12059ds() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isBottomGuideEntryViewShown();
        }
        return false;
    }

    /* renamed from: dt */
    public void m12060dt() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateEffectMenuNames();
        }
    }

    /* renamed from: du */
    public void m12061du() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopVideoRestoreUIWithControlUI();
        }
    }

    /* renamed from: dv */
    public long m12062dv() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureMergeIdentity();
        }
        return 0L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11823a(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onRawImageReceived(cameraPictureImage);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11903b(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.consumeImage(cameraPictureImage);
        }
        return false;
    }

    /* renamed from: dw */
    public void m12063dw() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforeConfig();
        }
    }

    /* renamed from: dx */
    public boolean m12064dx() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedResetAutoFocus();
        }
        return true;
    }

    /* renamed from: C */
    public void m11771C(boolean z) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setOpenFaceBeautyMenu(z);
        }
    }

    /* renamed from: dy */
    public boolean m12065dy() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowZoomMenu();
        }
        return false;
    }

    /* renamed from: dz */
    public boolean m12066dz() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAutoFocus();
        }
        return false;
    }

    /* renamed from: dA */
    public int m12024dA() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getAssistViewLayoutType();
        }
        return 0;
    }

    /* renamed from: dB */
    public void m12025dB() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforeModeChanged();
        }
    }

    /* renamed from: dC */
    public boolean m12026dC() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowFixFocusMenu();
        }
        return false;
    }

    /* renamed from: dD */
    public boolean m12027dD() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAfFixFocuse();
        }
        return false;
    }

    /* renamed from: dE */
    public boolean m12028dE() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportAutoFocus();
        }
        return true;
    }

    /* renamed from: dF */
    public boolean m12029dF() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isStreetOpen();
        }
        return false;
    }

    /* renamed from: dG */
    public boolean m12030dG() {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isAutoFlash() && this.mCurrentMode.mbAutoFlash;
    }

    /* renamed from: dH */
    public boolean m12031dH() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.checkVideoHdrPreCondition();
        }
        return false;
    }

    /* renamed from: dI */
    public boolean m12032dI() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.check3HDRPreCondition();
        }
        return false;
    }

    /* renamed from: dJ */
    public boolean m12033dJ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoHdrOpen();
        }
        return false;
    }

    /* renamed from: dK */
    public int m12034dK() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultBlurValue();
        }
        return 60;
    }

    /* renamed from: dL */
    public boolean m12035dL() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isInProMode();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11964c(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.onImageReceived(cameraPictureImage);
    }

    /* renamed from: dM */
    public int m12036dM() {
        return this.mCurrentMode.getExpectedFrameRate();
    }

    /* renamed from: dN */
    public void m12037dN() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSendCapturePictureRequest();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11828a(Map<String, Object> map) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.generateImageInfo(map);
        }
    }

    /* renamed from: dO */
    public void m12038dO() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onCancleCapturePictureRequest();
        }
    }

    /* renamed from: dP */
    public OplusViewOutlineProvider m12039dP() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPreviewOutlineProvider();
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m12070e(MotionEvent motionEvent) {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isInSlideModeChangeAreaForFull(motionEvent);
        }
        return false;
    }

    /* renamed from: dQ */
    public void m12040dQ() {
        BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMenuBackButtonClick();
        }
    }
}
