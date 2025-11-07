package com.oplus.camera.p149h;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import android.util.Size;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.VideoRecorder;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* compiled from: FastVideoMode.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class FastVideoMode extends VideoMode {
    private static final int HYPER_LAPSE_RATE = 3;
    private static final int RECORDING_DEFAULT_MIN_TIME = 1000;
    private static final int RECORDING_MIN_TIME = 1500;
    private static final int RECORDING_MIN_TIME_RATIO = 15;
    private static final String SPEED_VALUE_10X = "10";
    private static final String SPEED_VALUE_120X = "120";
    private static final String SPEED_VALUE_480X = "480";
    private static final String SPEED_VALUE_60X = "60";
    private static final String SPEED_VALUE_960X = "960";
    private static final String SPEED_VALUE_DEFAULT = "10";
    private static final String TAG = "FastVideoMode";
    private double mCaptureRate;
    private HashMap<String, String> mConfigs;
    private long mCurrentFrameTime;
    private float mRealVideoTimeRatio;
    private int mRecordingMinTime;
    private String mSpeedValue;
    private String mVideoSizeType;
    private boolean mbAfterInitCameraMode;
    private boolean mbHyperLapseOpen;

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.REC_MODE_FAST_VIDEO;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public boolean getNeedReduceBitRate() {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFastVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean supportBinauralRecord() {
        return false;
    }

    public FastVideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.mSpeedValue = null;
        this.mVideoSizeType = "video_size_1080p";
        this.mConfigs = new HashMap<>();
        this.mCaptureRate = 10.0d;
        this.mCurrentFrameTime = -1L;
        this.mbHyperLapseOpen = false;
        this.mRecordingMinTime = RECORDING_MIN_TIME;
        this.mbAfterInitCameraMode = false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        enableVideoRecordingSound(true);
        if (isSupportNoneSatUltraWideSupport() && this.mCameraInterface != null && !this.mCameraInterface.mo10544at()) {
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
        }
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        super.onDestroy();
        HashMap<String, String> map = this.mConfigs;
        if (map != null) {
            map.clear();
            this.mConfigs = null;
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(String str) {
        if (CameraUIInterface.KEY_VIDEO_SIZE.equals(str) || CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a(TAG, "onInitCameraMode");
        super.onInitCameraMode();
        this.mOrientation = this.mCameraInterface.mo10591u();
        this.mSpeedValue = this.mPreferences.getString(CameraUIInterface.KEY_TIME_LAPSE_RATE, FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
        this.mbHyperLapseOpen = isHyperLapseOpen();
        this.mbAfterInitCameraMode = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(String str) {
        if (CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        return super.needUploadOplusStatistics(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p149h.FastVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a(TAG, "onDeInitCameraMode");
        enableVideoRecordingSound(true);
        super.onDeInitCameraMode(str);
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
        hideHyperLapseView();
        hideTimeLapseSpeedHint();
    }

    private void hideTimeLapseSpeedHint() {
        this.mCameraUIInterface.mo18067a(R.string.camera_time_lapse_speed_desc_15x);
        this.mCameraUIInterface.mo18067a(R.string.camera_time_lapse_speed_desc_60x);
        this.mCameraUIInterface.mo18067a(R.string.camera_time_lapse_speed_desc_120x);
        this.mCameraUIInterface.mo18067a(R.string.camera_time_lapse_speed_desc_480x);
        this.mCameraUIInterface.mo18067a(R.string.camera_time_lapse_speed_desc_960x);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        this.mOrientation = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws NumberFormatException {
        OplusCameraCharacteristics cameraInfo;
        CameraLog.m12954a(TAG, "onBeforePreview");
        super.onBeforePreview();
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_BEAUTY)) {
            updateFaceBeautyLevel(0, false);
            if (this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.mo22834g(0);
            }
        }
        this.mbHyperLapseOpen = isHyperLapseOpen();
        setFastValueToParameter();
        enableVideoRecordingSound(false);
        setTiltShiftPreview();
        if (!this.mbHyperLapseOpen || !isHyperLapseUltraWideOpen() || (cameraInfo = getCameraInfo(this.mCameraId)) == null || this.mCameraInterface == null) {
            return;
        }
        float fMo10535ak = this.mCameraInterface.mo10535ak();
        if (cameraInfo.m13260a(getZoomConfigure(), fMo10535ak)) {
            return;
        }
        CameraLog.m12954a(TAG, "onBeforePreview, hyper lapse ultra wide not support zoom value : " + fMo10535ak);
        this.mCameraInterface.mo10557c(cameraInfo.m13263b(getZoomConfigure()));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        this.mbHyperLapseOpen = isHyperLapseOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof VideoRecordMsgData) {
            VideoRecordMsgData videoRecordMsgData2 = (VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData2.mLux = String.valueOf(this.mDcsLux);
            videoRecordMsgData = videoRecordMsgData2;
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNoneSatUltraWideAngleOpen() {
        if (this.mbHyperLapseOpen && isHyperLapseUltraWide() && this.mPreferences != null) {
            return this.mPreferences.getBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true);
        }
        return super.isNoneSatUltraWideAngleOpen();
    }

    private void setFastValueToParameter() throws NumberFormatException {
        CameraLog.m12954a(TAG, "setFastValueToParameter, mSpeedValue: " + this.mSpeedValue);
        double IntrinsicsJvm.kt_5 = Double.parseDouble(this.mSpeedValue);
        this.mCaptureRate = 30.0d / IntrinsicsJvm.kt_5;
        this.mRealVideoTimeRatio = (float) (1.0d / IntrinsicsJvm.kt_5);
        this.mRecordingMinTime = (int) ((IntrinsicsJvm.kt_5 * 15.0d) + 1000.0d);
        if (RECORDING_MIN_TIME > this.mRecordingMinTime) {
            this.mRecordingMinTime = RECORDING_MIN_TIME;
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        return isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public Float getRealVideoTimeRatio() {
        float COUIBaseListPopupWindow_12 = this.mRealVideoTimeRatio;
        CameraLog.m12954a(TAG, "getRealVideoTimeRatio, ratio: " + COUIBaseListPopupWindow_12);
        return Float.valueOf(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getHyperLapseRate() {
        return this.mbHyperLapseOpen ? 3 : 0;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected Double getRealCaptureRate() {
        return Double.valueOf(this.mbHyperLapseOpen ? 0.0d : this.mCaptureRate);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected Double getTimeLapseSpeed() {
        if (this.mbHyperLapseOpen) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(this.mSpeedValue));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return 3 == AlgoSwitchConfig.getApsVersion() && !this.mbFrontCamera && isSatOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL);
        }
        if ("type_video_frame".equals(str)) {
            if (this.mbHyperLapseOpen) {
                return true;
            }
            return getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        return "type_video".equals(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_TIME_LAPSE_RATE.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_FAST_VIDEO_SIZE.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isNeedAudioEncode() {
        return !isVideoTimeLapseTiltShiftOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return this.mCameraInterface != null && this.mCameraInterface.mo10575i() && isVideoTimeLapseTiltShiftOpen();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws NumberFormatException {
        if (CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU.equals(str)) {
            this.mbHyperLapseOpen = "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, this.mActivity.getString(R.string.camera_video_hyper_lapse_default_value)));
            if (isSupportNoneSatUltraWideSupport()) {
                sharedPreferences.edit().putBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
            }
            if (this.mbHyperLapseOpen) {
                this.mCameraUIInterface.mo18108a(true, true, false);
                if (!this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
                    this.mCameraUIInterface.mo18070a(R.string.camera_scene_tips_video_hyper_lapse_on, -1, true, false, false);
                    this.mCameraUIInterface.mo18072a(R.string.camera_video_hyper_lapse_hint, 0, false, false, true, false, false);
                }
            } else {
                if (ApsConstant.REC_MODE_FAST_VIDEO.equals(getCameraMode())) {
                    this.mCameraUIInterface.mo18070a(R.string.camera_scene_tips_video_hyper_lapse_off, -1, true, false, false);
                }
                hideHyperLapseView();
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                    this.mCameraInterface.mo10538an();
                }
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10546av();
            }
            if (this.mbHyperLapseOpen && !this.mbPaused && this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
                this.mCameraUIInterface.mo18234k(1);
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_TIME_LAPSE_RATE.equals(str)) {
            this.mSpeedValue = sharedPreferences.getString(CameraUIInterface.KEY_TIME_LAPSE_RATE, FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
            updateTimeLapseSpeedHint(true, this.mSpeedValue);
            setFastValueToParameter();
        }
        if (isSupportNoneSatUltraWideSupport() && CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN.equals(str) && this.mCameraInterface != null && !isVideoRecording()) {
            this.mCameraInterface.mo10545au();
            return;
        }
        if (CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO.equals(str)) {
            this.mCameraUIInterface.mo18072a(R.string.camera_video_hyper_lapse_hint, 0, false, false, true, false, false);
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateTimeLapseSpeedHint(boolean r11, java.lang.String r12) {
        /*
            r10 = this;
            int r1 = r12.hashCode()
            r2 = 1567(0x61f, float:2.196E-42)
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = -1
            if (r1 == r2) goto L4a
            r2 = 1722(0x6ba, float:2.413E-42)
            if (r1 == r2) goto L40
            r2 = 48687(0xbe2f, float:6.8225E-41)
            if (r1 == r2) goto L36
            r2 = 51756(0xca2c, float:7.2526E-41)
            if (r1 == r2) goto L2c
            r2 = 56499(0xdcb3, float:7.9172E-41)
            if (r1 == r2) goto L22
            goto L54
        L22:
            java.lang.String r1 = "960"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r4
            goto L55
        L2c:
            java.lang.String r1 = "480"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r5
            goto L55
        L36:
            java.lang.String r1 = "120"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r6
            goto L55
        L40:
            java.lang.String r1 = "60"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r7
            goto L55
        L4a:
            java.lang.String r1 = "10"
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L54
            r0 = r3
            goto L55
        L54:
            r0 = r8
        L55:
            if (r0 == 0) goto L71
            if (r0 == r7) goto L6d
            if (r0 == r6) goto L69
            if (r0 == r5) goto L65
            if (r0 == r4) goto L61
        L5f:
            r5 = r8
            goto L75
        L61:
            r8 = 2131756145(0x7f100471, float:1.914319E38)
            goto L5f
        L65:
            r8 = 2131756143(0x7f10046f, float:1.9143185E38)
            goto L5f
        L69:
            r8 = 2131756141(0x7f10046d, float:1.9143181E38)
            goto L5f
        L6d:
            r8 = 2131756144(0x7f100470, float:1.9143187E38)
            goto L5f
        L71:
            r8 = 2131756142(0x7f10046e, float:1.9143183E38)
            goto L5f
        L75:
            if (r11 == 0) goto L93
            com.oplus.camera.ui.CameraUIInterface r0 = r10.mCameraUIInterface
            com.oplus.camera.ui.PlatformImplementations.kt_3.PlatformImplementations.kt_3 r0 = r0.mo18233k()
            boolean r0 = r0.m18494b()
            if (r0 != 0) goto L87
            boolean r0 = r10.mbAfterInitCameraMode
            if (r0 == 0) goto L93
        L87:
            com.oplus.camera.ui.CameraUIInterface r4 = r10.mCameraUIInterface
            r6 = -1
            r7 = 1
            r8 = 0
            r9 = 0
            r4.mo18070a(r5, r6, r7, r8, r9)
            r10.mbAfterInitCameraMode = r3
            goto L96
        L93:
            r10.hideTimeLapseSpeedHint()
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p149h.FastVideoMode.updateTimeLapseSpeedHint(boolean, java.lang.String):void");
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        this.mSpeedValue = this.mPreferences.getString(CameraUIInterface.KEY_TIME_LAPSE_RATE, FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
        if (this.mbHyperLapseOpen && !this.mbFrontCamera && !this.mCameraUIInterface.mo18057R() && !this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
            this.mCameraUIInterface.mo18222h(true);
            if (this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
                return;
            }
            this.mCameraUIInterface.mo18072a(R.string.camera_video_hyper_lapse_hint, 0, false, false, true, true, false);
            return;
        }
        hideHyperLapseView();
        if (isHyperLapseUltraWide() && this.mbFrontCamera) {
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true).apply();
        }
    }

    private void hideHyperLapseView() {
        this.mCameraUIInterface.mo18222h(false);
        this.mCameraUIInterface.mo18067a(R.string.camera_video_hyper_lapse_hint);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public Size getSurfaceSize(String str, OplusCameraCharacteristics c2698h) {
        if (this.mbHyperLapseOpen) {
            Size sizeFromConfig = getSizeFromConfig(getCameraFeature(), str, BaseMode.EnumC2645a.INPUT);
            if (sizeFromConfig != null) {
                return sizeFromConfig;
            }
            CameraLog.m12966e(TAG, "getSurfaceSize, getVideoPipelineSize failed!");
        }
        return super.getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isQualcommEndOfStreamNeed() {
        if ((this.mbHyperLapseOpen && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_END_VIDEO_EIS_STREAM)) || !Util.m24169C()) {
            return false;
        }
        byte[] bArrM13276k = this.mOneCamera.mo13086e().m13276k();
        CameraLog.m12954a(TAG, "isQualcommEndOfStreamNeed, endOfStreamValue: " + bArrM13276k);
        return bArrM13276k != null && bArrM13276k.length > 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        return (AlgoSwitchConfig.getSupportApsPreview() && (needApsToProcessVideoWatermark() || this.mbHyperLapseOpen || (!this.mbFrontCamera && isSatOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)))) ? false : true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getVideoSizeType() {
        if (getSupportFunction(CameraUIInterface.KEY_FAST_VIDEO_SIZE)) {
            if (this.mPreferences instanceof ComboPreferences) {
                return ((ComboPreferences) this.mPreferences).m11073a(CameraUIInterface.KEY_FAST_VIDEO_SIZE, getDefaultVideoSize());
            }
            return this.mPreferences.getString(CameraUIInterface.KEY_FAST_VIDEO_SIZE, getDefaultVideoSize());
        }
        return this.mVideoSizeType;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        return getVideoFrameRate();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        Size videoPreviewSize = getVideoPreviewSize(getVideoSizeType());
        return videoPreviewSize != null ? videoPreviewSize : super.getPreviewSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        int OplusGLSurfaceView_13 = (this.mbFrontCamera || !getSupportFunction(CameraUIInterface.KEY_SUPPORT_FOVC)) ? 32780 : 33548;
        if (this.mbHyperLapseOpen) {
            OplusGLSurfaceView_13 = 32933;
        }
        return (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) && isSloganOpen()) ? OplusGLSurfaceView_13 | 1024 : OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.m19235c("button_shape_dial_rotate");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (isVideoFlashTorchOpen()) {
            this.mCameraUIInterface.mo18108a(false, true, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayAllIcon(boolean z, boolean z2) {
        if (isVideoFlashTorchOpen()) {
            return;
        }
        this.mCameraUIInterface.mo18108a(false, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFlashState() {
        return isVideoFlashTorchOpen();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() throws NumberFormatException {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
        }
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        if (!isHyperLapseOpen() && !isTiltShiftOpen()) {
            updateTimeLapseSpeedHint(false, this.mSpeedValue);
        }
        this.mSpeedValue = this.mPreferences.getString(CameraUIInterface.KEY_TIME_LAPSE_RATE, FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE);
        setFastValueToParameter();
        if (this.mOneCamera != null && !this.mbHyperLapseOpen && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_LOCK_AF_4_FPS)) {
            this.mOneCamera.mo13116n();
        }
        super.beforeStartRecording();
        if (this.mOneCamera != null) {
            if (!Util.m24169C() && this.mCameraInterface != null) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.mo10591u())));
            }
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public void onStopVideoRecording(boolean z) {
        super.onStopVideoRecording(z);
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10492a(true, false);
        }
        this.mCurrentFrameTime = -1L;
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_dial_rotate", 1));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return this.mbHyperLapseOpen ? isHyperLapseUltraWideOpen() ? ApsConstant.FEATURE_REC_HYPER_LAPSE_PRO : ApsConstant.FEATURE_REC_HYPER_LAPSE : (isSatOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) ? ApsConstant.FEATURE_REC_SAT_HAL : super.getCameraFeature();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(String str) {
        if (isSatOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
            return false;
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11365r(isHyperLapseOpen());
        zoomConfigure.m11334c(isNoneSatUltraWideAngleOpen());
        if (isNoneSatUltraWideAngleOpen()) {
            zoomConfigure.m11324a(CameraCharacteristicsUtil.m12971a(getCameraMode(), CameraCharacteristicsUtil.m12985h()).m13270e());
        }
        zoomConfigure.m11340f(isSupportNoneSatUltraWideSupport());
        zoomConfigure.m11342g(false);
        zoomConfigure.m11307F(getSupportFunction(CameraUIInterface.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT));
        float configFloatValue = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE);
        if (1.0E-6f < configFloatValue) {
            zoomConfigure.m11329b(configFloatValue);
        }
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected long getVideoTime() {
        double IntrinsicsJvm.kt_5;
        long OplusGLSurfaceView_15;
        if (this.mbHyperLapseOpen) {
            IntrinsicsJvm.kt_5 = 10.0d;
            OplusGLSurfaceView_15 = this.mRecordingTotalTime;
        } else {
            IntrinsicsJvm.kt_5 = 30.0d / this.mCaptureRate;
            OplusGLSurfaceView_15 = this.mRecordingTotalTime;
        }
        return (int) (OplusGLSurfaceView_15 / IntrinsicsJvm.kt_5);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHyperLapseUltraWideOpen() {
        return isSupportNoneSatUltraWideSupport() && this.mPreferences.getBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true);
    }

    private boolean isSupportNoneSatUltraWideSupport() {
        return getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) || (this.mbHyperLapseOpen && isHyperLapseUltraWide());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Range<Integer> getVideoFpsRange() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_LOCK_AF_4_FPS)) {
            return Range.create(4, 30);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean isHyperLapseOpen() {
        return !this.mbFrontCamera && this.mCameraInterface != null && this.mCameraInterface.mo10575i() && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, this.mActivity.getString(R.string.camera_video_hyper_lapse_default_value)));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (isHyperLapseOpen()) {
            builder.setParameter(CameraParameter.HYPER_LAPSE, CameraParameter.HyperLapse.HYPER_LAPSE);
            builder.setParameter(CameraParameter.VIDEO_FOVC_MODE, "off");
        } else {
            builder.setParameter(CameraParameter.HYPER_LAPSE, "off");
            builder.setParameter(CameraParameter.VIDEO_FOVC_MODE, "on");
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean needShowVideoTime() {
        return !isHyperLapseOpen();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected int getRecordingMinTime(boolean z) {
        return (z || this.mbHyperLapseOpen) ? RECORDING_MIN_TIME : this.mRecordingMinTime;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        this.mCameraUIInterface.mo18222h(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (!this.mbHyperLapseOpen || this.mbFrontCamera || this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
            return;
        }
        this.mCameraUIInterface.mo18222h(true);
        if (this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_TYPE_FAST_VIDEO, true)) {
            return;
        }
        this.mCameraUIInterface.mo18072a(R.string.camera_video_hyper_lapse_hint, 0, false, false, true, true, false);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void onInitializeRecorder(VideoRecorder c2670x) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onInitializeRecorder(c2670x);
        if (Util.m24169C()) {
            c2670x.m12737d("set-video-mode=fastvideo");
        }
    }
}
