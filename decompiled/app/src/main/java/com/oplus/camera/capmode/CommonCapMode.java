package com.oplus.camera.capmode;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import co.polarr.renderer.FilterPackageUtil;
import com.google.lens.sdk.LensApi;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraTipsManager;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p140d.Beauty3DManager;
import com.oplus.camera.p140d.Beauty3DUIListener;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.CountDownUI;
import com.oplus.camera.p172ui.NightCountDownUI;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseMaskView;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.ImageBeautyTools;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.tblplayer.misc.MediaInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CommonCapMode.java */
/* renamed from: com.oplus.camera.capmode.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class CommonCapMode extends BaseMode {
    private static final int AIS_BLURLESS_BASE_FRAME_NUM = 4;
    private static final int AIS_MFNR_BASE_FRAME_NUM = 5;
    private static final int BEAUTY3D_FILE_NUM = 1;
    private static final int BEAUTY3D_SCAN_PIC_SIZE_H = 2448;
    private static final int BEAUTY3D_SCAN_PIC_SIZE_W = 3264;
    private static final int BEAUTY3D_SCAN_PREVIEW_SIZE_H = 1080;
    private static final int BEAUTY3D_SCAN_PREVIEW_SIZE_W = 1440;
    private static final int BEAUTY_3D_HEAD_ICON_INDEX = -1;
    private static final long COUNT_DOWN_MIN_TIME = 100;
    private static final int HIDE_PICTURE_NUM_DELAY = 500;
    private static final int IS_OCCLUSION_CODE = 1;
    private static final long MAX_EXPOSURETIME_HAND = 200;
    private static final long MAX_EXPOSURETIME_TRIPOD = 5000;
    private static final int MICRO_OPEN = 1;
    private static final int MICRO_TOAST_SHOW_FROM_HAL = 1;
    private static final long MIN_PLAY_INTERVAL = 30;
    private static final int MSG_CODE_HIDE_MICRO_HINT = 5;
    private static final int MSG_CODE_HIDE_PICTURE_NUM = 1;
    private static final int MSG_CODE_SHOW_MICRO_HINT = 4;
    protected static final int NIGHT_ALGO_TRIGGERED_STEP_CAPTURE = 1;
    protected static final int NIGHT_ALGO_TRIGGERED_STEP_IDLE = 0;
    protected static final int NIGHT_ALGO_TRIGGERED_STEP_REPROCESS = 2;
    private static final long NIGHT_PROCESS_HAND_COST_TIME = 3000;
    private static final long NIGHT_PROCESS_TRIPOD_COST_TIME = 3500;
    private static final String TAG = "CommonCapMode";
    private static final long UPDATE_COUNTDOWN_TIME_DELAY = 100;
    private Beauty3DManager mBeauty3DManager;
    private long mBeauty3DScanTime;
    private int mBurstCaptureBufferLostNum;
    private long mCaptureStartTime;
    private Size mChangePreviewSize;
    private long mCountDownTemp;
    private long mFirstExposureTime;
    private RotateImageView mGoogleLensIcon;
    private boolean mGoogleLensShouldShow;
    private Size mLastPreviewSize;
    private LensApi mLensApi;
    private MainShutterButtonInfo mMainShutterButtonInfo;
    private PlatformImplementations.kt_3 mMemoryManager;
    private ReminderMsgData mMsgData;
    private Handler mMyHandler;
    protected int mNightAlgoTriggeredStep;
    protected long mNightCaptureTotalTime;
    private int mNightClosedCounter;
    protected NightCountDownUI mNightCountDownUI;
    protected long mNightProcessTotalTime;
    private int mNowRearEffectIndex;
    private long mPlaySoundTime;
    private int mReceivedPreviewResultNum;
    private int mReceivedRawResultNum;
    private int mReceivedSnapNum;
    private int mSaveBeautyIndexBeforeBurstShot;
    private int mSaveFilterIndexBeforeBurstShot;
    private int mSeNightCostTime;
    private boolean mbAutoMicroOpen;
    protected boolean mbCaptureRawTimeDone;
    protected boolean mbCheckTakeAnimateDelay;
    protected boolean mbEnableUILater;
    private boolean mbFirstEffectMenuOpened;
    private boolean mbGoogleLensStatusReady;
    private boolean mbHighResolutionChangeRatio;
    private boolean mbNightCheckClosed;
    private boolean mbNightJpegDone;
    protected boolean mbNightShutterCountDown;
    private boolean mbOcclusion;
    private boolean mbPreburstShotCapture;
    protected boolean mbSceneNight;
    private boolean mbShowBlurAnim;
    private boolean mbShowImageOptimizingTips;
    protected boolean mbShowSteadyTips;
    protected boolean mbStopSteadyTips;
    private boolean mbSuperTextOpen;
    protected boolean mbSupportNightPictureTime;
    protected boolean mbTakeAnimateDelay;
    private boolean mbTripodNight;

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_COMMON;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_COMMON_FACEBEAUTY_LEVEL_MENU;
    }

    protected int getHighPictureSizeHint() {
        return R.string.camera_picture_size_standard_high_hint;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
    }

    protected boolean isInNightProMode() {
        return false;
    }

    protected boolean isInNightProProcess() {
        return false;
    }

    protected boolean isNightProSoundPlayed() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSuperTextOpen() {
        return false;
    }

    protected boolean isTripodModeOpened() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public CommonCapMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.mNightCountDownUI = null;
        this.mbSceneNight = false;
        this.mbCaptureRawTimeDone = true;
        this.mbShowSteadyTips = false;
        this.mbSupportNightPictureTime = false;
        this.mbNightShutterCountDown = false;
        this.mNightAlgoTriggeredStep = 0;
        this.mNightCaptureTotalTime = 0L;
        this.mNightProcessTotalTime = 0L;
        this.mbCheckTakeAnimateDelay = false;
        this.mbTakeAnimateDelay = false;
        this.mbEnableUILater = false;
        this.mbStopSteadyTips = true;
        this.mReceivedSnapNum = 0;
        this.mBurstCaptureBufferLostNum = 0;
        this.mMemoryManager = new PlatformImplementations.kt_3();
        this.mMyHandler = null;
        this.mSaveFilterIndexBeforeBurstShot = FilterHelper.f21279a;
        this.mSaveBeautyIndexBeforeBurstShot = 0;
        this.mNightClosedCounter = 0;
        this.mSeNightCostTime = 2000;
        this.mBeauty3DScanTime = 0L;
        this.mbNightCheckClosed = false;
        this.mbTripodNight = false;
        this.mbNightJpegDone = true;
        this.mbSuperTextOpen = false;
        this.mbAutoMicroOpen = false;
        this.mbOcclusion = false;
        this.mbFirstEffectMenuOpened = false;
        this.mbHighResolutionChangeRatio = false;
        this.mFirstExposureTime = 0L;
        this.mCaptureStartTime = 0L;
        this.mCountDownTemp = 0L;
        this.mReceivedRawResultNum = 0;
        this.mPlaySoundTime = 0L;
        this.mReceivedPreviewResultNum = 0;
        this.mNowRearEffectIndex = FilterHelper.f21279a;
        this.mBeauty3DManager = null;
        this.mbShowBlurAnim = false;
        this.mbGoogleLensStatusReady = false;
        this.mLensApi = null;
        this.mGoogleLensIcon = null;
        this.mGoogleLensShouldShow = true;
        this.mLastPreviewSize = null;
        this.mChangePreviewSize = null;
        this.mbPreburstShotCapture = false;
        this.mbShowImageOptimizingTips = false;
        this.mMsgData = null;
        this.mSaveFilterIndexBeforeBurstShot = getCurrFilterIndex();
        this.mSaveBeautyIndexBeforeBurstShot = getFaceBeautyCurrIndex();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        if (getBeauty3Dstatus() == 2 || getBeauty3Dstatus() == 1) {
            return 32787;
        }
        return (getBeauty3Dstatus() == 6 || getBeauty3Dstatus() == 7 || getBeauty3Dstatus() == 8 || getBeauty3Dstatus() == 9) ? 32788 : 32769;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a(TAG, "onInitCameraMode");
        PlatformImplementations.kt_3 aVar = this.mMemoryManager;
        if (aVar != null) {
            aVar.m12303a();
        }
        if (this.mNightCountDownUI == null) {
            this.mNightCountDownUI = new NightCountDownUI(this.mCameraUIInterface, new CountDownUI.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.1
                @Override // com.oplus.camera.p172ui.CountDownUI.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12293a(boolean z) {
                    CommonCapMode.this.onTimerCountDownEnd();
                }

                @Override // com.oplus.camera.p172ui.CountDownUI.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12292a() {
                    CameraLog.m12954a(CommonCapMode.TAG, "updateCountDownTime");
                    if (CommonCapMode.this.mbPaused) {
                        return;
                    }
                    CommonCapMode.this.mNightCountDownUI.mo20104e();
                }
            });
        }
        if (this.mMyHandler == null) {
            this.mMyHandler = new Handler() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.10
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 == 1) {
                        CameraLog.m12954a(CommonCapMode.TAG, "handleMessage, MSG_CODE_HIDE_PICTURE_NUM");
                        if (CommonCapMode.this.mbPaused) {
                            return;
                        }
                        CommonCapMode.this.mCameraUIInterface.mo18206e(true, false);
                        if (CommonCapMode.this.mCameraInterface != null && !CommonCapMode.this.getSupportFunction(CameraUIInterface.KEY_EXPAND_POPBAR)) {
                            CommonCapMode.this.mCameraInterface.mo10492a(true, false);
                        }
                        if (CommonCapMode.this.mCameraInterface != null && !CommonCapMode.this.mCameraInterface.mo10445A() && CommonCapMode.this.supportBeautyButton()) {
                            CommonCapMode.this.mCameraUIInterface.mo18240l(true, false);
                            CommonCapMode.this.mCameraUIInterface.mo18279v(true);
                        }
                        CommonCapMode.this.displayScreenHintIconInSwitchOn();
                        return;
                    }
                    if (OplusGLSurfaceView_13 == 4) {
                        if (CommonCapMode.this.mbPaused) {
                            return;
                        }
                        CommonCapMode.this.mCameraInterface.mo10565e(18);
                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                            return;
                        }
                        CommonCapMode c2650d = CommonCapMode.this;
                        c2650d.mbFlashTemporaryDisabled = true;
                        c2650d.updateFlashState("off");
                        CommonCapMode.this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
                        if (1 == message.arg1) {
                            CommonCapMode.this.reportMicroShowReminderToDcs();
                            return;
                        }
                        return;
                    }
                    if (OplusGLSurfaceView_13 == 5 && !CommonCapMode.this.mbPaused) {
                        CommonCapMode.this.mCameraInterface.mo10565e(0);
                        CommonCapMode c2650d2 = CommonCapMode.this;
                        if (!c2650d2.withinSatMainRange(c2650d2.getZoomValue()) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                            return;
                        }
                        CommonCapMode c2650d3 = CommonCapMode.this;
                        c2650d3.mbFlashTemporaryDisabled = false;
                        c2650d3.updateFlashState(c2650d3.getFlashMode());
                        CommonCapMode.this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                    }
                }
            };
        }
        this.mbSupportNightPictureTime = true;
        this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_common_shutter_button));
        initBeauty3DManager();
        setBurstShotCapturing(false);
        this.mReceivedPreviewResultNum = 0;
        this.mGoogleLensShouldShow = true;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences.contains(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
            this.mbForbidPreferenceChange = true;
            this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
            this.mbForbidPreferenceChange = false;
        }
        if (getSupportFunction(CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            FilterHelper.m22627c();
        }
        updateNowRearEffectIndex();
    }

    protected void onTimerCountDownEnd() {
        if (this.mbDestroyed) {
            return;
        }
        if (!isInNightProProcess() || !isNightProSoundPlayed()) {
            this.mCameraInterface.mo10558c(0);
        }
        this.mbCaptureRawTimeDone = true;
        if (this.mbNightJpegDone || isInOfflineNightProcess()) {
            CameraLog.m12954a(TAG, "onTimerCountDownEnd, resetAfterPictureTaken");
            this.mCameraUIInterface.mo18200d(true, false);
            resetAfterPictureTaken(true, this.mbBurstShot);
            return;
        }
        this.mbEnableUILater = true;
        CameraLog.m12954a(TAG, "onTimerCountDownEnd");
        this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_keep_phone_steady);
        this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
        int OplusGLSurfaceView_13 = Util.m24352ao() ? 28 : 4;
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
        c3200b.m19227a("button_color_inside_none");
        c3200b.m19226a(OplusGLSurfaceView_13);
        this.mCameraUIInterface.mo18091a(c3200b);
        this.mCameraUIInterface.mo18107a(false, false);
        restoreAllViews(false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBeauty3DManager() {
        if (getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && this.mBeauty3DManager == null) {
            this.mBeauty3DManager = new Beauty3DManager(this.mActivity, new Beauty3DUIListener() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.11
                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12294a() {
                    CameraLog.m12954a(CommonCapMode.TAG, "onExitScan, beauty3D exit");
                    mo12295a(true);
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo12296b() {
                    CameraLog.m12954a(CommonCapMode.TAG, "onScanComplete, beauty3D scan Complete");
                    if (CommonCapMode.this.mPreferences != null) {
                        SharedPreferences.Editor editorEdit = CommonCapMode.this.mPreferences.edit();
                        editorEdit.putBoolean(CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D, false);
                        editorEdit.apply();
                    }
                    CommonCapMode.this.onBeauty3DChange(false);
                    long jCurrentTimeMillis = System.currentTimeMillis() - CommonCapMode.this.mBeauty3DScanTime;
                    if (jCurrentTimeMillis > 0) {
                        CameraStatisticsUtil.onCommon(CommonCapMode.this.mActivity, CameraStatisticsUtil.EVENT_BEAUTY3D, CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SCAN_TIME, String.valueOf(jCurrentTimeMillis)));
                    }
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: IntrinsicsJvm.kt_3 */
                public void mo12298c() {
                    if (CommonCapMode.this.mCameraUIInterface != null) {
                        CommonCapMode.this.mCameraUIInterface.mo18034G();
                    }
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: IntrinsicsJvm.kt_5 */
                public void mo12300d() {
                    CameraLog.m12954a(CommonCapMode.TAG, "onStartScan, open dual camera, Beauty3DState: " + CommonCapMode.this.getBeauty3Dstatus());
                    CommonCapMode.this.mBeauty3DScanTime = System.currentTimeMillis();
                    int faceBeautyCurrIndex = CommonCapMode.this.getFaceBeautyCurrIndex();
                    CameraLog.m12954a(CommonCapMode.TAG, "onStartScan, BeautyCurrIndex: " + faceBeautyCurrIndex);
                    if (faceBeautyCurrIndex == -1) {
                        CommonCapMode c2650d = CommonCapMode.this;
                        c2650d.createEffectTextures(c2650d.mCameraUIInterface.mo18038I());
                    }
                    ImageBeautyTools.m22675b(CommonCapMode.this.mActivity);
                    CommonCapMode.this.onBeauty3DChange(false);
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: COUIBaseListPopupWindow_8 */
                public void mo12301e() {
                    CommonCapMode.this.onBeauty3DChange(false);
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: COUIBaseListPopupWindow_12 */
                public void mo12302f() {
                    ImageBeautyTools.m22675b(CommonCapMode.this.mActivity);
                    CommonCapMode c2650d = CommonCapMode.this;
                    c2650d.createEffectTextures(c2650d.mCameraUIInterface.mo18038I());
                    if (CommonCapMode.this.mPreferences != null) {
                        SharedPreferences.Editor editorEdit = CommonCapMode.this.mPreferences.edit();
                        editorEdit.putBoolean(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D, true);
                        editorEdit.apply();
                    }
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12295a(boolean z) {
                    if (CommonCapMode.this.getBeauty3Dstatus() == 4) {
                        CameraLog.m12954a(CommonCapMode.TAG, "onScanCancel, Beauty3DState == BEAUTY3D_STATE_SCAN_CANCEL, return");
                    } else if (z) {
                        CommonCapMode.this.setBeauty3DState(4);
                        CommonCapMode.this.onBeauty3DChange(false);
                    }
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo12297b(boolean z) {
                    if (z && CommonCapMode.this.mPreferences != null) {
                        SharedPreferences.Editor editorEdit = CommonCapMode.this.mPreferences.edit();
                        editorEdit.putInt(CommonCapMode.this.getFaceBeautyKey(), -1);
                        editorEdit.apply();
                    }
                    CommonCapMode.this.onBeauty3DChange(z);
                }

                @Override // com.oplus.camera.p140d.Beauty3DUIListener
                /* renamed from: IntrinsicsJvm.kt_3 */
                public void mo12299c(boolean z) {
                    if (CommonCapMode.this.mCameraUIInterface != null) {
                        CommonCapMode.this.mCameraUIInterface.mo18255p(z);
                    }
                }
            });
            this.mBeauty3DManager.m12825a();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return getCurrentKeys(CameraUIInterface.KEY_COMMON_CUSTOM_BEAUTY);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String[] getMakeupKeys() {
        return getCurrentKeys(FaceBeautyHelp.f21228c);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getMakeupTypeKey() {
        return CameraEntry.m13302b(this.mCameraEntryType) ? CameraEntry.m13299b(CameraUIInterface.KEY_COMMON_MAKEUP_TYPE, this.mCameraEntryType) : CameraUIInterface.KEY_COMMON_MAKEUP_TYPE;
    }

    protected void stopNightCountdownTime() {
        this.mNightCountDownUI.mo20099a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onEffectItemClick(int OplusGLSurfaceView_13) {
        Beauty3DManager c2674b;
        if (1 != getBeauty3DScanIconType(OplusGLSurfaceView_13) || (c2674b = this.mBeauty3DManager) == null) {
            return false;
        }
        c2674b.m12854k();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowingGuideView() {
        Beauty3DManager c2674b;
        if (!getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) || (c2674b = this.mBeauty3DManager) == null) {
            return false;
        }
        return c2674b.m12852i();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setPIEnable(int OplusGLSurfaceView_13, boolean z) {
        if (this.mOneCamera == null) {
            return;
        }
        CameraLog.m12954a(TAG, "setPIEnable, code: " + OplusGLSurfaceView_13 + ", enable: " + z);
        boolean z2 = this.mbSuperTextOpen;
        if (!this.mbBurstShot && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && 4 == OplusGLSurfaceView_13) {
            this.mbSuperTextOpen = z;
            if (getSupportFunction(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.mo22809b(64);
            }
        } else {
            this.mbSuperTextOpen = false;
            if (12 == OplusGLSurfaceView_13 && !this.mbNightCheckClosed && z) {
                this.mbNightCheckClosed = true;
                this.mOneCamera.mo13120o(0);
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                this.mNightClosedCounter++;
            }
        }
        if (getSupportFunction(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22847k(this.mbSuperTextOpen);
        }
        if (getSupportFunction(CameraFunction.SUPER_TEXT) && z2 && !this.mbSuperTextOpen) {
            CameraLog.m12959b(TAG, "setPIEnable, clear SuperText!");
            this.mCameraUIInterface.mo18089a((DetectResult) null);
        }
        if (18 == OplusGLSurfaceView_13) {
            this.mOneCamera.mo13012B(z);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        } else {
            this.mOneCamera.mo13123p(this.mCameraUIInterface.mo18137aa());
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMonoIndex(int OplusGLSurfaceView_13) {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MONO_FILTER_SUPPORT) || 1 == CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE)) {
            return false;
        }
        return OplusGLSurfaceView_13 == FilterHelper.m22634h() || OplusGLSurfaceView_13 == FilterHelper.m22635i() || OplusGLSurfaceView_13 == FilterHelper.m22636j() || OplusGLSurfaceView_13 == FilterHelper.m22637k();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAISceneClosed(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 12 || this.mbNightCheckClosed) {
            return;
        }
        this.mbNightCheckClosed = true;
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13120o(0);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        this.mNightClosedCounter++;
    }

    public boolean getBeauty3DConfigured() {
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null) {
            return c2674b.m12850g();
        }
        return false;
    }

    public void showBeauty3DView() {
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b == null) {
            return;
        }
        int iM12849f = c2674b.m12849f();
        CameraLog.m12954a(TAG, "updateBeauty3DView, type: " + iM12849f);
        if (iM12849f == 1) {
            this.mBeauty3DManager.m12851h();
            return;
        }
        if (iM12849f != 10) {
            if (iM12849f == 6 || iM12849f == 7) {
                this.mBeauty3DManager.m12827a(1, new Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080));
                return;
            } else if (iM12849f != 8) {
                return;
            }
        }
        this.mBeauty3DManager.m12827a(2, new Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getBeauty3DScanIconType(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "getBeauty3DScanIconType, effectIndex: " + OplusGLSurfaceView_13);
        int iM22674a = ImageBeautyTools.m22674a(this.mActivity);
        if (OplusGLSurfaceView_13 != 0 || !"beauty".equals(getCurrEffectMenuName()) || !getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) || iM22674a != 0) {
            return (OplusGLSurfaceView_13 == 0 && "beauty".equals(getCurrEffectMenuName()) && getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && iM22674a == 1) ? 2 : 0;
        }
        this.mCameraUIInterface.mo18210f(6, true);
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        Size decreasedSizeForThirdApp;
        if (getBeauty3Dstatus() == 2 || getBeauty3Dstatus() == 1) {
            return new Size(BEAUTY3D_SCAN_PIC_SIZE_W, BEAUTY3D_SCAN_PIC_SIZE_H);
        }
        if (getBeauty3Dstatus() == 6 || getBeauty3Dstatus() == 7 || getBeauty3Dstatus() == 8 || getBeauty3Dstatus() == 9) {
            return new Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080);
        }
        if (this.mCameraInterface == null) {
            return null;
        }
        return (this.mbDestroyed || this.mCameraInterface.mo10575i() || (decreasedSizeForThirdApp = getDecreasedSizeForThirdApp(c2698h)) == null) ? super.getPictureSize(c2698h) : decreasedSizeForThirdApp;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        Size previewSize = super.getPreviewSize(c2698h);
        this.mLastPreviewSize = previewSize;
        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) && this.mbFrontCamera && getFaceBeautyCurrIndex() != 0) || ((CameraCharacteristicsUtil.m12985h() == this.mCameraId && (this.mCameraUIInterface.mo18043K() || getFaceBeautyCurrIndex() != 0)) || CameraCharacteristicsUtil.m12987j() == getProperCameraId(this.mCameraId))) {
            this.mChangePreviewSize = getFaceBeautyPreviewSize();
            Size size = this.mChangePreviewSize;
            if (size != null) {
                previewSize = size;
            }
        }
        CameraLog.m12954a(TAG, "getPreviewSize, previewSize: " + previewSize + ", mLastPreviewSize: " + this.mLastPreviewSize + ", mChangePreviewSize: " + this.mChangePreviewSize);
        int beauty3Dstatus = getBeauty3Dstatus();
        if (beauty3Dstatus != 0 && beauty3Dstatus != 4) {
            return new Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080);
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MAKEUP_LOW_PERFORMANCE) || !isMakeupOpen()) {
            return previewSize;
        }
        double targetPreviewRatio = getTargetPreviewRatio(c2698h);
        if (Double.compare(targetPreviewRatio, 1.3333333333333333d) == 0) {
            return new Size(CameraParameter.VideoFps.FPS_960, VideoMode.VIDEO_720P_HEIGHT);
        }
        if (Double.compare(targetPreviewRatio, 1.0d) == 0) {
            return new Size(CameraParameter.VideoFps.FPS_960, CameraParameter.VideoFps.FPS_960);
        }
        if (Double.compare(targetPreviewRatio, 1.7777777777777777d) == 0) {
            return new Size(VideoMode.VIDEO_720P_WIDTH, VideoMode.VIDEO_720P_HEIGHT);
        }
        return new Size(1600, VideoMode.VIDEO_720P_HEIGHT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getZoomAutoMicroOpen() {
        return this.mbAutoMicroOpen;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (this.mCameraInterface != null && !this.mCameraInterface.mo10575i() && this.mApsBracketMode <= 0 && Util.m24169C()) {
            return true;
        }
        if (Util.m24169C() && this.mDecisionResult != null && 28 == this.mDecisionResult.mApsDecisionFeatureType && 17 == this.mDecisionResult.mApsBracketMode) {
            return true;
        }
        if (!this.mbFrontCamera || !Util.m24169C() || !isFaceBeautyOrMakeupOpen() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZSL_SUPPORT_PREVERSION) || this.mDecisionResult == null || 4 == this.mDecisionResult.mApsDecisionFeatureType || 24 == this.mDecisionResult.mApsDecisionFeatureType || 5 == this.mDecisionResult.mApsDecisionFeatureType) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a(TAG, "onDeInitCameraMode");
        this.mCameraUIInterface.mo18282w(true);
        this.mCameraUIInterface.mo18067a(R.string.micro_lens_mode_toast);
        this.mbNightCheckClosed = false;
        this.mReceivedRawResultNum = 0;
        this.mReceivedPreviewResultNum = 0;
        this.mbAutoMicroOpen = false;
        this.mGoogleLensShouldShow = false;
        this.mbCheckTakeAnimateDelay = false;
        this.mbTakeAnimateDelay = false;
        Handler handler = this.mMyHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MTK_INSENSOR_ZOOM)) {
                this.mOneCamera.mo13129r(0);
            }
        }
        updateFaceBeautyLevel(0, false);
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22834g(0);
        }
        this.mCameraUIInterface.mo18206e(false, false);
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D) && getSupportFunction(CameraUIInterface.KEY_BEAUTY3D)) {
            this.mCameraUIInterface.mo18210f(6, false);
        }
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.mo18210f(5, false);
        }
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null) {
            c2674b.m12840c();
        }
        if (isUltraWideHighPictureSize() && this.mPreferences != null) {
            this.mbForbidPreferenceChange = true;
            this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
            this.mbForbidPreferenceChange = false;
        }
        if (this.mPreferences != null && this.mPreferences.getBoolean(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE, true)) {
            this.mCameraUIInterface.mo18210f(9, true);
        }
        if (isBubbleOpen(CameraUIInterface.KEY_FIRST_BEAUTY_TIPS)) {
            this.mCameraUIInterface.mo18210f(17, true);
        }
        if (this.mPreferences != null && getSupportFunction(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && this.mbFirstEffectMenuOpened) {
            this.mPreferences.edit().putString(getFilterEffectPrevSelectedKey(), getCurrFilterType()).apply();
        }
        this.mCameraUIInterface.mo18239l(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHighPictureSize() {
        if (!getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE) || this.mPreferences == null) {
            return false;
        }
        return this.mPreferences.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isUltraWideHighPictureSize() {
        return getSupportFunction(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences != null && this.mPreferences.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false) && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFaceRectifyMenuOpen() {
        if (getSupportFunction(CameraUIInterface.KEY_FACE_RECTIFY)) {
            String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_FACE_RECTIFY_CONFIG_VALUE);
            if (TextUtils.isEmpty(configStringValue)) {
                configStringValue = this.mActivity.getString(R.string.camera_face_rectify_default_value);
            }
            if (this.mPreferences != null) {
                configStringValue = this.mPreferences.getString(CameraUIInterface.KEY_FACE_RECTIFY, configStringValue);
            }
            return "on".equals(configStringValue);
        }
        return super.isFaceRectifyMenuOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFaceRectifyOpen() {
        return isFaceRectifyMenuOpen() && isZoomFaceRectifySupported();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isZoomFaceRectifySupported() {
        float zoomValue = getZoomValue();
        return Float.compare(zoomValue, getMinZoomValue()) == 0 || Float.compare(zoomValue, 1.0f) == 0 || (this.mbFrontCamera && Float.compare(zoomValue, 1.17f) == 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        if (Util.m24352ao()) {
            if (this.mCameraUIInterface.mo18265s() == 28 || this.mCameraUIInterface.mo18265s() == 29 || this.mCameraUIInterface.mo18265s() == 26) {
                shutterButtonInfo.m19226a(26);
            } else {
                shutterButtonInfo.m19226a(23);
            }
        }
        return shutterButtonInfo;
    }

    protected boolean isNeedResetNoneSatWide() {
        return isNoneSatUltraWideAngleOpen() && isHighPictureSize();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        Beauty3DManager c2674b;
        CameraLog.m12967f(TAG, "onResume");
        if (((KeyguardManager) this.mActivity.getApplicationContext().getSystemService("keyguard")).isKeyguardLocked()) {
            this.mbDisplayOnLock = true;
        }
        if (this.mbDisplayOnLock) {
            resetMonoFilter();
        }
        updateNowRearEffectIndex();
        if (getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && (c2674b = this.mBeauty3DManager) != null && c2674b.m12849f() != 0) {
            this.mBeauty3DManager.m12828a(new Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, BEAUTY3D_SCAN_PIC_SIZE_H));
        }
        if (isNeedResetNoneSatWide()) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            this.mCameraInterface.mo10559c(false);
        }
        LensApi lensApi = this.mLensApi;
        if (lensApi != null) {
            try {
                lensApi.onResume();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
            setGoogleLensIconClickable(true);
        } else {
            hideGoogleLensIcon(false);
        }
        if (this.mbShowSteadyTips) {
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_keep_phone_steady);
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_process_image_after_capture);
            this.mbShowSteadyTips = false;
            this.mNightAlgoTriggeredStep = 0;
        }
        if (this.mbShowImageOptimizingTips) {
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_image_optimizing_tips_oplus_r);
            this.mbShowImageOptimizingTips = false;
            this.mNightAlgoTriggeredStep = 0;
        }
        this.mCameraUIInterface.mo18217g(false);
        this.mCameraUIInterface.mo18186c(8, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        CameraLog.m12967f(TAG, "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onGetNearMeOnClickData() {
        StringBuilder sb = new StringBuilder();
        int OplusGLSurfaceView_13 = this.mNightClosedCounter;
        if (OplusGLSurfaceView_13 > 0) {
            String str = CameraStatisticsUtil.format(CameraStatisticsUtil.NIGHT_CLOSED_NUM, String.valueOf(OplusGLSurfaceView_13));
            this.mNightClosedCounter = 0;
            sb.append(str);
        }
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.mActivity, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) ? null : (CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS) && isAISceneOpen()) {
            captureMsgData.mNightState = getNightStateDecision();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_AUTO_MICRO)) {
            captureMsgData.mIsMacro = String.valueOf(this.mbAutoMicroOpen ? 1 : 0);
        }
        if (this.mbFrontCamera) {
            captureMsgData.mScreenHighLight = sHighBrightness ? "on" : "off";
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void saveAndClearEffectBeforeBurstShot() {
        this.mSaveFilterIndexBeforeBurstShot = getCurrFilterIndex();
        this.mSaveBeautyIndexBeforeBurstShot = getFaceBeautyCurrIndex();
        onFilterItemChange(FilterHelper.f21279a);
        onFaceBeautyItemChange(0);
        updateEffectMenuNames();
        this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
        this.mCameraUIInterface.mo18230j(0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null) {
            c2674b.m12829a(this.mOneCamera);
        }
        super.onSessionConfigured();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void restoreEffectAfterBurstShot() {
        onFilterItemChange(this.mSaveFilterIndexBeforeBurstShot);
        onFaceBeautyItemChange(this.mSaveBeautyIndexBeforeBurstShot);
        updateEffectMenuNames();
        this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
        this.mCameraUIInterface.mo18230j(this.mSaveBeautyIndexBeforeBurstShot);
    }

    private void resetPIModeAfterCapture() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || !getSupportFunction(CameraUIInterface.KEY_PI)) {
            return;
        }
        this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_PI, (String) null);
        onPIChanged(false, isPIModeOpen(), false, true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x05b7  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 2690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonCapMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_FLASH_MODE.equals(strM13305d) || CameraUIInterface.KEY_SETTING.equals(strM13305d) || CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(strM13305d) || CameraUIInterface.KEY_VIVID_EFFECT.equals(strM13305d) || CameraUIInterface.KEY_PI_AI.equals(strM13305d) || CameraUIInterface.KEY_PI.equals(strM13305d) || CameraUIInterface.KEY_PHOTO_RATIO.equals(strM13305d)) {
            return getSupportFunction(strM13305d);
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strM13305d)) {
            return this.mbFrontCamera || CameraEntry.m13302b(this.mCameraEntry.m13317J());
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(strM13305d)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        if (CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(strM13305d)) {
            return getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        }
        return super.getSupportMenu(strM13305d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(strM13305d)) {
            return getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strM13305d)) {
            return !this.mbFrontCamera;
        }
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(strM13305d)) {
            return getSupportFunction(strM13305d);
        }
        if (CameraUIInterface.KEY_SETTING.equals(strM13305d)) {
            return !CameraEntry.m13302b(this.mCameraEntryType);
        }
        if (CameraUIInterface.KEY_MACRO_SWITCH.equals(strM13305d)) {
            return getSupportFunction(strM13305d);
        }
        return super.getSupportSubMenu(strM13305d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowBeauty3D() {
        return getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && getBeauty3Dstatus() > 0 && getBeauty3Dstatus() != 4;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (CameraUIInterface.KEY_PI_AI.equals(str) && getSupportFunction(CameraUIInterface.KEY_PI_AI)) {
            boolean zEquals = "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_PI_AI, this.mActivity.getString(R.string.camera_pi_ai_default_value)));
            if (this.mPreferences != null) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_AI_SCN, zEquals ? "on" : "off").apply();
            }
            onPIChanged(this.mbBurstShot, zEquals, true, true);
            return;
        }
        if (CameraUIInterface.KEY_PI.equals(str) && getSupportFunction(CameraUIInterface.KEY_PI)) {
            onPIChanged(this.mbBurstShot, "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_PI, "off")), true, true);
            return;
        }
        if (CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE.equals(str) && !this.mbForbidPreferenceChange) {
            if (getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && this.mPreferences != null) {
                if (isUltraWideHighPictureSize() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                    this.mbFlashTemporaryDisabled = true;
                    updateFlashState("off");
                    this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
                } else {
                    this.mbFlashTemporaryDisabled = false;
                    updateFlashState(getFlashMode());
                }
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10545au();
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
            if (isUltraWideHighPictureSize() && this.mPreferences != null) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
                this.mbForbidPreferenceChange = false;
            }
            if (isAISceneOpen()) {
                this.mCameraUIInterface.mo18239l(true);
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(str)) {
            if (getSupportFunction(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences != null && "standard_high".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard_high"))) {
                if (Float.compare(getZoomValue(), 1.0f) < 0) {
                    this.mbForbidPreferenceChange = true;
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "on").apply();
                    this.mbForbidPreferenceChange = false;
                } else {
                    this.mbForbidPreferenceChange = true;
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
                    this.mbForbidPreferenceChange = false;
                }
            }
            if (getSupportFunction(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences != null && "standard".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard"))) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
                this.mbForbidPreferenceChange = false;
            }
            if (this.mPreferences != null && !"standard".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard")) && "auto".equals(this.mPreferences.getString(CameraUIInterface.KEY_MACRO_SWITCH, "auto"))) {
                SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                editorEdit.putString(CameraUIInterface.KEY_LAST_MACRO_SWITCH, "auto");
                editorEdit.putString(CameraUIInterface.KEY_MACRO_SWITCH, "off");
                editorEdit.apply();
            }
            if (this.mPreferences != null && "standard".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard")) && this.mPreferences.contains(CameraUIInterface.KEY_LAST_MACRO_SWITCH)) {
                if (!"auto".equals(this.mPreferences.getString(CameraUIInterface.KEY_MACRO_SWITCH, "auto")) && "auto".equals(this.mPreferences.getString(CameraUIInterface.KEY_LAST_MACRO_SWITCH, "auto"))) {
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_MACRO_SWITCH, "auto").apply();
                }
                this.mPreferences.edit().remove(CameraUIInterface.KEY_LAST_MACRO_SWITCH).apply();
            }
            if (this.mPreferences == null || !isMonoIndex(getCurrFilterIndex()) || "standard".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard"))) {
                return;
            }
            onHighResolution();
            return;
        }
        if (CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            if (this.mPreferences == null || !"auto".equals(this.mPreferences.getString(CameraUIInterface.KEY_MACRO_SWITCH, "auto")) || "standard".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard"))) {
                return;
            }
            this.mPreferences.edit().putString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard").apply();
            if (this.mPreferences.contains(CameraUIInterface.KEY_LAST_MACRO_SWITCH)) {
                this.mPreferences.edit().remove(CameraUIInterface.KEY_LAST_MACRO_SWITCH).apply();
                return;
            }
            return;
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePIBeforeCapture() {
        if (isPIModeOpen()) {
            if (!CameraParameter.FlashMode.FLASH_TORCH.equals(getFlashMode())) {
                this.mCameraUIInterface.mo18108a(false, true, true);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                return;
            }
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_PI, "off");
            onPIChanged(this.mbBurstShot, false, false, true);
        }
    }

    public void onPIChanged(boolean z, boolean z2, boolean z3, boolean z4) {
        CameraLog.m12954a(TAG, "onPIChanged, isOpen: " + z2 + ", isBurstShot: " + z + ", isShowHint: " + z3 + ", isUpdateParam: " + z4);
        if (z) {
            return;
        }
        int OplusGLSurfaceView_13 = R.string.camera_pi_off_hint;
        if (z2) {
            if (z3 && (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_PI_AI) || this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_PI))) {
                boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI);
                int i2 = configBooleanValue ? R.string.camera_pi_ai_scenes_hint_on : R.string.camera_pi_on_hint;
                CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
                if (configBooleanValue) {
                    OplusGLSurfaceView_13 = R.string.camera_pi_ai_scenes_hint_off;
                }
                cameraUIInterface.mo18067a(OplusGLSurfaceView_13);
                this.mCameraUIInterface.mo18070a(i2, -1, true, false, false);
            }
            onFilterItemChange(FilterHelper.f21279a);
            if (this.mCameraUIInterface.mo18023A() && MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.mo18267s(true);
                this.mCameraInterface.mo10492a(true, false);
                this.mCameraInterface.mo10563d(true);
            } else {
                this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
            }
            if (this.mCameraUIInterface.mo18043K()) {
                this.mCameraUIInterface.mo18109a(true, true, true, true);
            }
            this.mCameraUIInterface.mo18263r(true);
            return;
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            if (z3) {
                this.mCameraUIInterface.mo18070a(Util.m24445f(R.string.camera_pi_off_hint), -1, true, false, false);
                return;
            }
            return;
        }
        this.mbSuperTextOpen = false;
        this.mCameraUIInterface.mo18089a((DetectResult) null);
        this.mCameraUIInterface.mo18239l(true);
        if (getSupportFunction(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22847k(false);
        }
        if (getSupportFunction(CameraFunction.SUPER_TEXT)) {
            this.mCameraUIInterface.mo18089a((DetectResult) null);
        }
        if (z3) {
            this.mCameraUIInterface.mo18067a(R.string.camera_zoom_not_support);
            this.mCameraUIInterface.mo18070a(R.string.camera_pi_ai_scenes_hint_off, -1, true, false, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        CameraLog.m12967f(TAG, "onCameraIdChanged");
        super.cameraIdChanged(OplusGLSurfaceView_13);
        this.mbNightCheckClosed = false;
        this.mReceivedRawResultNum = 0;
        this.mbCheckTakeAnimateDelay = false;
        this.mbTakeAnimateDelay = false;
        updateNowRearEffectIndex();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.12
                @Override // java.lang.Runnable
                public void run() {
                    CommonCapMode.this.initBeauty3DManager();
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        Beauty3DManager c2674b;
        CameraLog.m12954a(TAG, "onPause, mbBurstShot: " + this.mbBurstShot);
        this.mbAutoMicroOpen = false;
        this.mbCaptureRawTimeDone = true;
        this.mbNightJpegDone = true;
        this.mbCheckTakeAnimateDelay = false;
        this.mbTakeAnimateDelay = false;
        if (this.mbBurstShot && this.mMyHandler != null) {
            disableBurstShot();
            this.mbBurstShot = false;
        }
        if (isInNightProcess()) {
            this.mCameraUIInterface.mo18215g(0);
        }
        this.mbTripodNight = false;
        Handler handler = this.mMyHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mCameraUIInterface.mo18280w();
        this.mCameraUIInterface.mo18206e(false, false);
        this.mCameraUIInterface.mo18217g(false);
        this.mCameraUIInterface.mo18186c(8, false);
        this.mbNightCheckClosed = false;
        this.mReceivedRawResultNum = 0;
        if (getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && (c2674b = this.mBeauty3DManager) != null) {
            c2674b.m12833b();
        }
        if (getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D) && this.mCameraUIInterface.mo18023A()) {
            this.mCameraUIInterface.mo18210f(6, true);
        }
        if (getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.mo18210f(5, true);
        }
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && this.mbFirstEffectMenuOpened) {
            this.mPreferences.edit().putString(getFilterEffectPrevSelectedKey(), getCurrFilterType()).apply();
        }
        if (this.mCameraInterface != null && !this.mCameraInterface.mo10544at() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences.contains(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
            this.mbForbidPreferenceChange = true;
            this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
            this.mbForbidPreferenceChange = false;
        }
        LensApi lensApi = this.mLensApi;
        if (lensApi != null) {
            try {
                lensApi.onPause();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        if (isAISceneOpen()) {
            this.mCameraUIInterface.mo18239l(true);
        }
        pauseNightCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getGrandTourFilterKey(String str) {
        if (this.mbFrontCamera) {
            CameraLog.m12966e(TAG, "getGrandTourFilterKey, Front camera. Ignore");
            return false;
        }
        if (!FilterHelper.f21312b.equalsIgnoreCase(MediaInfo.RENDERER_TYPE_NONE)) {
            ArrayList<String> arrayListM22597a = FilterHelper.m22597a(FilterHelper.f21312b);
            if (arrayListM22597a == null) {
                CameraLog.m12966e(TAG, "getGrandTourFilterKey, No grand filter for " + FilterHelper.f21312b + " city.");
                return false;
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayListM22597a.size(); OplusGLSurfaceView_13++) {
                if (str.equals(arrayListM22597a.get(OplusGLSurfaceView_13))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateGrandTourCityFiltersPosition(String str) {
        if (str == null) {
            CameraLog.m12966e(TAG, "updateGrandTourCityFiltersPosition, City is null. Ignore!");
            return;
        }
        CameraLog.m12959b(TAG, "updateGrandTourCityFiltersPosition, City : " + str);
        String string = this.mPreferences.getString(getFilterEffectPrevSelectedKey(), null);
        if (string == null) {
            if (this.mbFirstEffectMenuOpened) {
                this.mPreferences.edit().putString(getFilterEffectPrevSelectedKey(), getCurrFilterType()).apply();
                string = getCurrFilterType();
            } else {
                string = "default";
            }
        }
        FilterHelper.m22625b(str);
        onFilterItemChange(FilterHelper.m22589a(string, this.mCameraId));
        super.updateGrandTourCityFiltersPosition(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetFiltersList() {
        CameraLog.m12959b(TAG, "resetFilterList() - Grand tour filters");
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
            String currFilterType = getCurrFilterType();
            if (CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE_OTHER_APP.equals(getFilterEffectPrevSelectedKey())) {
                currFilterType = this.mPreferences.getString(getFilterEffectPrevSelectedKey(), "default");
            }
            FilterHelper.m22632f();
            onFilterItemChange(FilterHelper.m22589a(currFilterType, this.mCameraId));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a(TAG, "onDestroy");
        this.mMemoryManager = null;
        ReminderMsgData reminderMsgData = this.mMsgData;
        if (reminderMsgData != null) {
            reminderMsgData.destroy();
        }
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D)) {
            this.mCameraUIInterface.mo18210f(6, false);
        }
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.mo18210f(5, false);
        }
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null) {
            c2674b.m12861r();
            this.mBeauty3DManager = null;
        }
        resetMonoFilter();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        Beauty3DManager c2674b;
        if (getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && (c2674b = this.mBeauty3DManager) != null && c2674b.m12846d()) {
            return true;
        }
        if (this.mbInBurstShotCapturing) {
            CameraLog.m12954a(TAG, "onBackPressed, mbInBurstShotCapturing: " + this.mbInBurstShotCapturing);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        if (2 == this.mCameraEntry.m13317J()) {
        }
        return "key_filter_index";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectPrevSelectedKey() {
        return 2 == this.mCameraEntry.m13317J() ? CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE_OTHER_APP : CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        if (2 == this.mCameraEntry.m13317J()) {
            return FilterHelper.f21327q.m22566b(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        if (1 == getCurFilterListType()) {
            return FilterHelper.f21322l.f21250d;
        }
        return super.getFilterNameIdList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() {
        if (getSupportFunction(CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            FilterHelper.m22627c();
        }
        updateNowRearEffectIndex();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        if (2 == this.mCameraEntry.m13317J()) {
            return FilterHelper.f21327q.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        if (1 == getCurFilterListType()) {
            return FilterHelper.f21322l.f21248b;
        }
        return super.getFilterTypeList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        if (isPIModeOpen() || isShowBeauty3D()) {
            CameraLog.m12954a(TAG, "getCurrFilterIndex, no filter");
            return FilterHelper.f21279a;
        }
        return super.getCurrFilterIndex();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurFilterListType() {
        if (this.mPreferences == null) {
            return 0;
        }
        if (getSupportFunction(CameraUIInterface.KEY_FUJI_FILTER_MENU)) {
            return this.mPreferences.getInt(CameraUIInterface.KEY_FILTER_LIST_TYPE, 0);
        }
        return super.getCurFilterListType();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int OplusGLSurfaceView_13) {
        if (isPIModeOpen() && OplusGLSurfaceView_13 != FilterHelper.f21279a) {
            forceClosePIEffect();
        }
        int currFilterIndex = super.getCurrFilterIndex();
        if (!this.mbFrontCamera && (isMonoIndex(currFilterIndex) || isMonoIndex(OplusGLSurfaceView_13))) {
            this.mbShowBlurAnim = true;
        } else {
            this.mbShowBlurAnim = false;
        }
        if (isHighPictureSize() && isMonoIndex(OplusGLSurfaceView_13)) {
            forceCloseHighResolution();
        }
        if (1 == getCurFilterListType()) {
            updateFujiFilterHint(getFilterType(OplusGLSurfaceView_13));
        }
        if (!this.mbFrontCamera && currFilterIndex != OplusGLSurfaceView_13) {
            if (this.mbShowBlurAnim) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MONO_FILTER_LOGIC_ID_IS_SAT)) {
                    this.mCameraInterface.mo10468X();
                } else if (!this.mbInBurstShotCapturing && !this.mbBurstShot && !this.mbHighResolutionChangeRatio) {
                    this.mCameraInterface.mo10571g(isMonoIndex(OplusGLSurfaceView_13));
                }
                this.mCameraUIInterface.mo18108a(true, false, true);
            }
            this.mNowRearEffectIndex = OplusGLSurfaceView_13;
        }
        super.onFilterItemChange(OplusGLSurfaceView_13);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateFujiFilterHint(java.lang.String r13) {
        /*
            r12 = this;
            int r0 = r13.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1839295640: goto L3f;
                case -1838817266: goto L35;
                case -1121714170: goto L2b;
                case -740382771: goto L21;
                case -580703011: goto L17;
                case 1544803905: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L49
        Ld:
            java.lang.String r0 = "default"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L49
            r13 = 0
            goto L4a
        L17:
            java.lang.String r0 = "type_fuji_velvia"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L49
            r13 = r4
            goto L4a
        L21:
            java.lang.String r0 = "type_fuji_provia"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L49
            r13 = r1
            goto L4a
        L2b:
            java.lang.String r0 = "type_fuji_chrome"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L49
            r13 = r2
            goto L4a
        L35:
            java.lang.String r0 = "type_fuji_astia"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L49
            r13 = r3
            goto L4a
        L3f:
            java.lang.String r0 = "type_fuji_acros"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L49
            r13 = r5
            goto L4a
        L49:
            r13 = -1
        L4a:
            if (r13 == 0) goto L98
            if (r13 == r5) goto L8b
            if (r13 == r4) goto L7e
            if (r13 == r3) goto L71
            if (r13 == r2) goto L64
            if (r13 == r1) goto L57
            goto L9b
        L57:
            com.oplus.camera.ui.CameraUIInterface r6 = r12.mCameraUIInterface
            r7 = 2131755765(0x7f1002f5, float:1.9142419E38)
            r8 = -1
            r9 = 1
            r10 = 0
            r11 = 0
            r6.mo18070a(r7, r8, r9, r10, r11)
            goto L9b
        L64:
            com.oplus.camera.ui.CameraUIInterface r0 = r12.mCameraUIInterface
            r1 = 2131755252(0x7f1000f4, float:1.9141378E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.mo18070a(r1, r2, r3, r4, r5)
            goto L9b
        L71:
            com.oplus.camera.ui.CameraUIInterface r6 = r12.mCameraUIInterface
            r7 = 2131755190(0x7f1000b6, float:1.9141252E38)
            r8 = -1
            r9 = 1
            r10 = 0
            r11 = 0
            r6.mo18070a(r7, r8, r9, r10, r11)
            goto L9b
        L7e:
            com.oplus.camera.ui.CameraUIInterface r0 = r12.mCameraUIInterface
            r1 = 2131756172(0x7f10048c, float:1.9143244E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.mo18070a(r1, r2, r3, r4, r5)
            goto L9b
        L8b:
            com.oplus.camera.ui.CameraUIInterface r6 = r12.mCameraUIInterface
            r7 = 2131755129(0x7f100079, float:1.9141129E38)
            r8 = -1
            r9 = 1
            r10 = 0
            r11 = 0
            r6.mo18070a(r7, r8, r9, r10, r11)
            goto L9b
        L98:
            r12.hideAllFujiHint()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonCapMode.updateFujiFilterHint(java.lang.String):void");
    }

    private void hideAllFujiHint() {
        this.mCameraUIInterface.mo18067a(R.string.camera_acros_film_description);
        this.mCameraUIInterface.mo18067a(R.string.camera_velvia_film_description);
        this.mCameraUIInterface.mo18067a(R.string.camera_astic_film_description);
        this.mCameraUIInterface.mo18067a(R.string.camera_classic_chrome_film_description);
        this.mCameraUIInterface.mo18067a(R.string.camera_provoa_film_description);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterListTypeChanged(int OplusGLSurfaceView_13) {
        this.mPreferences.edit().putInt(CameraUIInterface.KEY_FILTER_LIST_TYPE, OplusGLSurfaceView_13).apply();
        onFilterItemChange(FilterHelper.f21279a);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateFilterParam(int OplusGLSurfaceView_13) {
        if (isPIModeOpen() && OplusGLSurfaceView_13 != FilterHelper.f21279a) {
            forceClosePIEffect();
        }
        super.updateFilterParam(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(CameraRequestTag c2693c) throws Resources.NotFoundException {
        super.updateCaptureParam(c2693c);
        if (this.mbOcclusion && isMonoIndex(getCurrFilterIndex()) && this.mOneCamera != null) {
            this.mOneCamera.mo13046a("default", isFilterOpen("default"), false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        CameraLog.m12954a(TAG, "onBeforePreview");
        this.mbSuperTextOpen = false;
        this.mbAutoMicroOpen = false;
        if (getSupportFunction(CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22847k(isSuperTextOpen());
        }
        applyBeautyParam();
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null && c2674b.m12849f() > 0) {
            this.mBeauty3DManager.m12837b(this.mOneCamera);
        }
        setTiltShiftPreview();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return isShowBeauty3D();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (isMonoIndex(getCurrFilterIndex())) {
            builder.setParameter(CameraParameter.MONO_FILTER_TYPE, CameraParameter.MonoFilterType.BLACK_WHITE);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUpdateCameraSettingMenu() {
        if (getSupportFunction(CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            updateMenuWithMono(isMonoIndex(getCurrFilterIndex()));
        }
        super.onUpdateCameraSettingMenu();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(String str) {
        if (isMonoIndex(getCurrFilterIndex()) && CameraUIInterface.KEY_MACRO_SWITCH.equals(str) && getSupportFunction(CameraUIInterface.KEY_MACRO_SWITCH)) {
            return false;
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    public boolean shouldShowSteadyTips() {
        CameraApsDecision cameraApsDecision;
        boolean zIsInNightProcess = isInNightProcess();
        boolean z = zIsInNightProcess && isTripodNight();
        boolean zIsInNightProProcess = isInNightProProcess();
        synchronized (this.mApsDecisionResultLock) {
            cameraApsDecision = this.mDecisionResult;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shouldShowSteadyTips, isInNightProcess: ");
        sb.append(zIsInNightProcess);
        sb.append(", isTripodNight: ");
        sb.append(z);
        sb.append(", mbBurstShot: ");
        sb.append(this.mbBurstShot);
        sb.append(", mbSceneNight: ");
        sb.append(this.mbSceneNight);
        sb.append(", mSupportCaptureZoomFeature: ");
        sb.append(cameraApsDecision == null ? null : Integer.valueOf(cameraApsDecision.mSupportCaptureZoomFeature));
        sb.append(", mRequestNum: ");
        sb.append(this.mbBurstShot ? Util.f22996d : getDefaultCaptureNumber());
        sb.append(", isTripodModeOpened: ");
        sb.append(isTripodModeOpened());
        CameraLog.m12954a(TAG, sb.toString());
        if (this.mbBurstShot || isTripodModeOpened() || isSuperSeNightOpen()) {
            return false;
        }
        if ((this.mbSceneNight || zIsInNightProcess) && !z && !zIsInNightProProcess) {
            return true;
        }
        int defaultCaptureNumber = getDefaultCaptureNumber();
        return cameraApsDecision != null && 4 == cameraApsDecision.mSupportCaptureZoomFeature && (1 == defaultCaptureNumber || 3 <= defaultCaptureNumber) && this.mCameraInterface.mo10575i();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        this.mbCheckTakeAnimateDelay = this.mbFrontCamera;
        this.mbNightShutterCountDown = (!isInNightProcess() || isInNightProMode() || isSuperSeNightOpen()) ? false : true;
        CameraLog.m12954a(TAG, "onBeforeSnapping, mbNightShutterCountDown: " + this.mbNightShutterCountDown);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.13
            @Override // java.lang.Runnable
            public void run() {
                if (CommonCapMode.this.mbPaused) {
                    CameraLog.m12954a(CommonCapMode.TAG, "onBeforeSnapping, return after pause");
                    return;
                }
                boolean zIsInNightProcess = CommonCapMode.this.isInNightProcess();
                boolean z = zIsInNightProcess && CommonCapMode.this.isTripodNight();
                boolean zIsInNightProProcess = CommonCapMode.this.isInNightProProcess();
                if (CommonCapMode.this.shouldShowSteadyTips()) {
                    CommonCapMode.this.mCameraUIInterface.mo18233k().m18502g();
                    CommonCapMode.this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_pro_fixed_tips_oplus_r);
                    CommonCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                    CommonCapMode c2650d = CommonCapMode.this;
                    c2650d.mbShowSteadyTips = true;
                    c2650d.mbStopSteadyTips = false;
                    if (c2650d.isNightAlgoCaptureTriggered()) {
                        if (!(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_AINIGHT_SUPPORT_NIGHT_PROCESS) && CommonCapMode.this.isAISceneOpen() && 12 == CommonCapMode.this.mCameraInterface.mo10576j())) {
                            CommonCapMode.this.hideAllViewsExceptShutter();
                        }
                        CommonCapMode.this.mNightAlgoTriggeredStep = 1;
                    }
                }
                if (CommonCapMode.this.mbBurstShot && CommonCapMode.this.mActivity != null && CommonCapMode.this.mCameraUIInterface.mo18237l().equals(CommonCapMode.this.mActivity.getString(R.string.camera_ai_scn_night))) {
                    CommonCapMode.this.mCameraUIInterface.mo18108a(true, false, true);
                }
                if (!CommonCapMode.this.mbBurstShot && ((CommonCapMode.this.mbSceneNight || zIsInNightProcess) && (!zIsInNightProcess || (!z && !zIsInNightProProcess && !CommonCapMode.this.mbSupportNightPictureTime)))) {
                    if (CommonCapMode.this.isSuperSeNightOpen()) {
                        CommonCapMode.this.mCameraUIInterface.mo18200d(false, false);
                        CommonCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_image_optimizing_tips_oplus_r, -1, false, false, true);
                        CommonCapMode.this.mbShowImageOptimizingTips = true;
                    }
                    if (CommonCapMode.this.isSuperNightShutterCountDownOpen()) {
                        CommonCapMode.this.startNightCaptureCountDown();
                    } else if (CommonCapMode.this.isSuperSeNightOpen()) {
                        if (CommonCapMode.this.mMainShutterButtonInfo == null) {
                            CommonCapMode.this.mMainShutterButtonInfo = new MainShutterButtonInfo();
                        }
                        CommonCapMode.this.mMainShutterButtonInfo.m19227a("button_color_inside_none");
                        CommonCapMode.this.mMainShutterButtonInfo.m19226a(13);
                        CommonCapMode.this.mMainShutterButtonInfo.m19234c(4);
                        CommonCapMode.this.mCameraUIInterface.mo18091a(CommonCapMode.this.mMainShutterButtonInfo);
                        CommonCapMode.this.mCameraUIInterface.mo18200d(false, false);
                        CommonCapMode.this.mCameraUIInterface.mo18221h(CommonCapMode.this.mSeNightCostTime);
                        CommonCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_image_optimizing_tips_oplus_r, -1, false, false, true);
                        CommonCapMode.this.mbShowImageOptimizingTips = true;
                    } else {
                        MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                        c3200b.m19227a("button_color_inside_none");
                        if (Util.m24352ao()) {
                            c3200b.m19226a(25);
                        } else {
                            c3200b.m19226a(4);
                        }
                        CommonCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                    }
                }
                if (CommonCapMode.this.getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && CommonCapMode.this.mBeauty3DManager != null) {
                    if (CommonCapMode.this.isShowBeauty3DEditChooseMenu()) {
                        CommonCapMode.this.mBeauty3DManager.m12859p();
                        CommonCapMode.this.mBeauty3DManager.m12848e(false);
                    } else {
                        CommonCapMode.this.mBeauty3DManager.m12860q();
                    }
                    String torchMode = CommonCapMode.this.getTorchMode();
                    if ((torchMode.equals("on") || torchMode.equals("auto")) && CommonCapMode.this.mbFrontCamera && CommonCapMode.this.getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
                        CommonCapMode.this.mBeauty3DManager.m12860q();
                    }
                }
                if (CommonCapMode.this.isGoogleLensEnable()) {
                    CommonCapMode.this.setGoogleLensIconClickable(false);
                }
                if ((zIsInNightProcess || zIsInNightProProcess) && !CommonCapMode.this.mbBurstShot) {
                    CommonCapMode.this.closePIBeforeCapture();
                    if (z || CommonCapMode.this.mbSupportNightPictureTime || zIsInNightProProcess) {
                        CommonCapMode.this.hideAllViewsExceptShutter();
                        CommonCapMode c2650d2 = CommonCapMode.this;
                        c2650d2.mbCaptureRawTimeDone = false;
                        c2650d2.mbNightJpegDone = false;
                        if (zIsInNightProProcess) {
                            return;
                        }
                        CommonCapMode.this.mCameraUIInterface.mo18138ab();
                        CommonCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_keep_phone_steady, -1, false, false, false);
                    }
                }
            }
        });
        if (Util.m24169C() && this.mCameraInterface.mo10575i()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_LOCK_AE_BEFORE_CAPTURE_SUPPORT) && this.mbFrontCamera) {
                this.mOneCamera.mo13071b(true, false);
                this.mbResetAeLockAfterCaptured = true;
            }
            if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_LOCK_AWB_BEFORE_CAPTURE_REAR_SUPPORT) && !isFlashRequired() && !isTorchMode()) || this.mbFrontCamera) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
                this.mbResetAwbLockAfterCaptured = true;
            }
            CameraLog.m12959b(TAG, "beforeSnapping, in QualcommPlatform front：" + this.mbFrontCamera + ", camera lock ae: " + this.mbResetAeLockAfterCaptured + " and awb: " + this.mbResetAwbLockAfterCaptured + ", CameraMode: " + getCameraMode());
        }
        if (c2693c.f13396Y) {
            if (isTripodNight()) {
                this.mOneCamera.mo13135t(2400);
            }
            this.mOneCamera.mo13120o(getNightStateDecision());
            if (!isInNightProMode()) {
                this.mOneCamera.mo13029a(1, AEAFHelp.m11154b(), AEAFHelp.m11154b(), false);
            }
            if (!isFlashRequired()) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
            }
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_FILTER_SUPPORT) && !getSupportFunction(CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
                updateFilterParam(FilterHelper.f21279a);
            }
            if (!this.mbAutoSeNight) {
                closeHdrAndFlashModeBeforeCapture();
            }
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MTK_FACE_BEAUTY_REMOSAIC_SUPPORT) && this.mbFrontCamera && isFaceBeautyOrMakeupOpen() && !isFilterEffectOpen()) {
            this.mOneCamera.mo13126q(1);
        } else if (isFaceBeautyOrMakeupOpen() || isFilterEffectOpen() || isPIModeOpen()) {
            this.mOneCamera.mo13126q(0);
        } else {
            this.mOneCamera.mo13126q(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_REMOSAIC_SUPPORT_DEFAULT_VALUE));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MTK_INSENSOR_ZOOM)) {
            if (!Util.m24169C() && 4 == c2693c.f13392U) {
                this.mOneCamera.mo13129r(1);
            } else {
                this.mOneCamera.mo13129r(0);
            }
        }
        setCaptureRequestPictureSizeScale();
        boolean supportFunction = getSupportFunction(CameraUIInterface.KEY_HIGH_RESOLUTION_CANCEL_SNAPSHOT);
        if ((isSuperTextOpen() || isIdPhotoOpen() || supportFunction) && !this.mbBurstShot) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.14
                @Override // java.lang.Runnable
                public void run() {
                    CommonCapMode.this.mCameraUIInterface.mo18200d(false, false);
                    MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                    c3200b.m19227a("button_color_inside_none");
                    if (Util.m24352ao()) {
                        c3200b.m19226a(25);
                    } else {
                        c3200b.m19226a(4);
                    }
                    CommonCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                }
            });
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        if ((this.mbSceneNight || (isPIModeOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI))) && !this.mbFrontCamera) {
            if (z) {
                shutterButtonInfo.m19226a(8);
                shutterButtonInfo.m19227a("button_color_inside_none");
            } else {
                shutterButtonInfo.m19226a(11);
                shutterButtonInfo.m19227a("button_color_inside_none");
            }
        }
        this.mCameraUIInterface.mo18091a(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAISSnapshotChecked(CameraApsDecision cameraApsDecision) {
        if (Util.m24169C()) {
            return;
        }
        this.mOneCamera.mo13138u(cameraApsDecision.mbAIShutter);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCancelTakePicture() {
        CameraLog.m12966e(TAG, "onCancelTakePicture, reset mbShutterCallback");
        if (isGoogleLensEnable()) {
            setGoogleLensIconClickable(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.15
            @Override // java.lang.Runnable
            public void run() {
                if (!CommonCapMode.this.mbPaused) {
                    CommonCapMode.this.onUpdateCameraSettingMenu();
                }
                if (CommonCapMode.this.isHighPictureSize() && !CommonCapMode.this.mCameraUIInterface.mo18057R() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                    if (TextUtils.isEmpty(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                        double displayHighPictureSize = CommonCapMode.this.getDisplayHighPictureSize();
                        CommonCapMode.this.mCameraUIInterface.mo18067a(R.string.toast_ultra_wide_angel_lens);
                        CommonCapMode.this.mCameraUIInterface.mo18166b(CommonCapMode.this.getHighPictureSizeHint(), R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Double.valueOf(displayHighPictureSize));
                    } else {
                        CommonCapMode.this.mCameraUIInterface.mo18166b(R.string.camera_setting_menu_high_resolution_item, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                    }
                } else {
                    CommonCapMode.this.mCameraUIInterface.mo18110a(CommonCapMode.this.getHighPictureSizeHint());
                    CommonCapMode.this.mCameraUIInterface.mo18282w(true);
                }
                if (CommonCapMode.this.getSupportFunction(CameraFunction.GOOGLE_LENS)) {
                    CommonCapMode.this.checkGoogleLensAvailability();
                }
            }
        });
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z) {
        String string = this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
        if ("square".equals(string) || (Util.m24495t() && !Util.m24498u() && "standard".equals(string))) {
            InverseManager.INS.setPositionRatio(this.mActivity, InverseMaskView.getPositionRatioSquare(), z);
        } else if ("standard".equals(string) || "standard_high".equals(string)) {
            InverseManager.INS.setPositionRatio(this.mActivity, 0.5f, z);
        } else {
            InverseManager.INS.setPositionRatio(this.mActivity, 0.87f, z);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        CameraLog.m12954a(TAG, "onAfterSnapping()");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getReceiveBustShotNum() {
        return this.mReceivedSnapNum;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBurstShotCapture() {
        CameraLog.m12954a(TAG, "onBurstShotCapture");
        this.mReceivedSnapNum = 0;
        this.mBurstCaptureBufferLostNum = 0;
        this.mMyHandler.removeMessages(1);
        this.mCameraInterface.mo10489a(true);
        if (!this.mbAutoMicroOpen) {
            closePIBeforeCapture();
        }
        getExif(null);
        if (Util.m24169C() && this.mOneCamera != null) {
            this.mOneCamera.mo13112l(true);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        if (isGoogleLensEnable()) {
            setGoogleLensIconClickable(false);
        }
        if (capture(false)) {
            return true;
        }
        disableBurstShot();
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13112l(false);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        super.onShutterCallback(z, z2);
        if (z || !z2) {
            return;
        }
        if (!this.mbTakeAnimateDelay) {
            this.mCameraInterface.mo10572h();
        } else {
            CameraLog.m12954a(TAG, "onShutterCallback, animateTakePicture delay");
        }
        if (!isInNightProcess()) {
            this.mCameraInterface.mo10558c(0);
        }
        if (isPIModeOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            CameraLog.m12954a(TAG, "onShutterCallback, PIOpen");
            Handler handler = this.mMyHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!CommonCapMode.this.mbInCapturing) {
                            CameraLog.m12954a(CommonCapMode.TAG, "pictureTakenCallback is already received, so return");
                        } else if (CommonCapMode.this.mCameraUIInterface.mo18265s() != 4) {
                            MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                            c3200b.m19227a("button_color_inside_none");
                            c3200b.m19226a(4);
                            CommonCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                        }
                    }
                });
            }
        }
        if (this.mBeauty3DManager != null) {
            if (isShowBeauty3DEditChooseMenu()) {
                this.mBeauty3DManager.m12859p();
            } else {
                this.mBeauty3DManager.m12860q();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c) {
        if (this.mbBurstShot) {
            this.mBurstCaptureBufferLostNum++;
        }
        super.onCaptureFailed(captureRequest, c2693c);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
        CameraLog.m12954a(TAG, "onCaptureFirstFrameArrived, result: " + cameraCaptureResult + ", isTripodNight: " + isTripodNight());
        if (this.mbPaused || !isInNightProcess()) {
            return;
        }
        if (!this.mbSupportNightPictureTime || isTripodNight()) {
            this.mNightCaptureTotalTime = cameraCaptureResult.mNightCaptureTotaltime;
        }
        if (isTripodNight() || (this.mbSupportNightPictureTime && !isInNightProProcess())) {
            this.mFirstExposureTime = cameraCaptureResult.mFirstExposureTime;
            onFirstCaptureArrived();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        CameraLog.m12954a(TAG, "onCaptureCompleted, result: " + cameraCaptureResult + ", mReceivedRawResultNum: " + this.mReceivedRawResultNum + ", mbPaused: " + this.mbPaused);
        if (c2693c.f13401ac) {
            this.mCameraInterface.mo10478a(cameraCaptureResult.mIdentity, Util.m24246a(System.currentTimeMillis()), false, false, false);
        }
        if (!this.mbPaused && isInNightProcess()) {
            CameraRequestTag.PlatformImplementations.kt_3 aVarM13006a = c2693c.m13006a();
            if (CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_RAW == aVarM13006a && c2693c.f13385N != null && this.mReceivedRawResultNum < c2693c.f13385N.mMultiFrameCount) {
                this.mReceivedRawResultNum++;
            }
            if (this.mOneCamera != null && !Util.m24169C() && CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_REPROCESS == aVarM13006a && this.mReceivedRawResultNum > 0) {
                this.mOneCamera.mo13120o(0);
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureSequenceCompleted() {
        if (this.mbPaused || this.mActivity == null) {
            return;
        }
        if (this.mbFrontCamera && 2 == this.mCameraEntryType) {
            this.mCameraInterface.mo10517aS();
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.17
            @Override // java.lang.Runnable
            public void run() {
                if (CommonCapMode.this.isSuperNightShutterCountDownOpen()) {
                    CommonCapMode.this.mNightAlgoTriggeredStep = 2;
                    return;
                }
                if (1 == CommonCapMode.this.mNightAlgoTriggeredStep && CommonCapMode.this.mCameraUIInterface != null) {
                    CommonCapMode c2650d = CommonCapMode.this;
                    c2650d.mNightAlgoTriggeredStep = 2;
                    if (c2650d.isAISceneOpen()) {
                        CommonCapMode.this.mCameraUIInterface.mo18138ab();
                    }
                    if (!CommonCapMode.this.mbCaptureRawTimeDone || CommonCapMode.this.isInOfflineNightProcess()) {
                        return;
                    }
                    CommonCapMode.this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_keep_phone_steady);
                    CommonCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
                    CommonCapMode.this.mCameraUIInterface.mo18107a(false, false);
                    CommonCapMode.this.restoreAllViews(false);
                    return;
                }
                if (CommonCapMode.this.isUltraHighResolutionOpened() && Util.m24458h(MyApplication.m11092d())) {
                    CommonCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
                    if (CommonCapMode.this.isAISceneOpen()) {
                        CommonCapMode.this.mCameraUIInterface.mo18138ab();
                    }
                }
            }
        });
    }

    protected void restoreAllViews(boolean z) {
        restoreAllViews(z, true, false);
    }

    private void onFirstCaptureArrived() {
        long jMin;
        if (isCountDownStarted()) {
            return;
        }
        if (this.mNightCaptureTotalTime == 0 || (this.mbSupportNightPictureTime && !isTripodNight())) {
            jMin = 0;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getDefaultCaptureNumber(); OplusGLSurfaceView_13++) {
                jMin += Math.min((long) ((this.mFirstExposureTime * Math.pow(2.0d, OplusGLSurfaceView_13 / 2.0f)) / 1000000.0d), isTripodNight() ? 5000L : MAX_EXPOSURETIME_HAND);
            }
            this.mNightCaptureTotalTime = jMin;
        } else {
            jMin = 0;
        }
        long jRound = (isInOfflineNightProcess() ? 100L : 1000L) * Math.round(this.mNightCaptureTotalTime / r0);
        if (0 == jRound) {
            jRound = 1000;
        } else if (jRound < 500) {
            jRound = 500;
        }
        this.mNightCountDownUI.m20100a(jRound);
        CameraLog.m12959b(TAG, "onFirstCaptureArrived, nightProcessTotalTime: " + jRound + ", realTime: " + jMin + ", mNightCaptureTotalTime: " + this.mNightCaptureTotalTime);
        updateNightCaptureShutter();
    }

    protected boolean isNightAlgoCaptureTriggered() {
        return (this.mbBurstShot || isTripodModeOpened() || !isInNightProcess() || (isInNightProcess() && isTripodNight()) || isInNightProProcess()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCountDownStarted() {
        NightCountDownUI c3361p = this.mNightCountDownUI;
        if (c3361p == null) {
            return false;
        }
        return c3361p.m20106g();
    }

    protected void updateNightCaptureShutter() {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.2
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonCapMode.this.mbPaused) {
                        CameraLog.m12959b(CommonCapMode.TAG, "onFirstCaptureArrived, mbPaused, so return!");
                        return;
                    }
                    MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                    c3200b.m19227a("button_color_inside_none");
                    c3200b.m19231b("button_color_ring_theme");
                    long jC = CommonCapMode.this.mNightCountDownUI.m20102c();
                    if (jC >= 100) {
                        CommonCapMode.this.mCameraUIInterface.mo18221h((int) jC);
                        int iMo18265s = CommonCapMode.this.mCameraUIInterface.mo18265s();
                        if (iMo18265s == 2 || iMo18265s == 10 || iMo18265s == 11) {
                            c3200b.m19226a(3);
                        } else {
                            c3200b.m19226a(Util.m24352ao() ? 27 : 13);
                        }
                        CommonCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                        CommonCapMode c2650d = CommonCapMode.this;
                        c2650d.mbTripodNight = c2650d.isTripodNight();
                        CommonCapMode.this.mCameraUIInterface.mo18186c(0, true);
                        CommonCapMode.this.mNightCountDownUI.mo20103d();
                        CommonCapMode.this.mNightCountDownUI.mo20104e();
                    } else if (CommonCapMode.this.mCameraUIInterface.mo18265s() == 1) {
                        c3200b.m19226a(4);
                    } else {
                        c3200b.m19226a(2);
                    }
                    CommonCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12962c(TAG, "onBeforePictureTaken, mReceivedSnapNum: " + this.mReceivedSnapNum + ", isBurstShot: " + z);
        if (!this.mbPaused && z && this.mReceivedSnapNum < Util.f22996d) {
            this.mReceivedSnapNum++;
            if (Util.m24169C() && 1 == this.mReceivedSnapNum && this.mOneCamera != null) {
                this.mOneCamera.mo13112l(false);
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            int iJ = this.mCameraInterface.mo10519aU().mo16539j();
            if (1 != iJ && 4 != iJ) {
                this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, false, false);
            }
            this.mCameraUIInterface.mo18078a(this.mReceivedSnapNum, false, false);
            if (SystemClock.uptimeMillis() - this.mPlaySoundTime >= MIN_PLAY_INTERVAL) {
                this.mCameraInterface.mo10558c(1);
                this.mPlaySoundTime = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4) {
        if (this.mbTakeAnimateDelay) {
            Util.m24416c(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$IntrinsicsJvm.kt_5$PcUHyhOV5vydrXaGsH7sT22LGZE
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.lambda$onPictureCallback$0$IntrinsicsJvm.kt_5();
                }
            });
        }
        super.onPictureCallback(bArr, OplusGLSurfaceView_13, i2, i3, z, i4);
    }

    public /* synthetic */ void lambda$onPictureCallback$0$IntrinsicsJvm.kt_5() {
        CameraLog.m12954a(TAG, "onPictureCallback, animateTakePicture delay");
        this.mCameraInterface.mo10572h();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12954a(TAG, "onAfterPictureTaken, mReceivedSnapNum: " + this.mReceivedSnapNum + ", mBurstCaptureBufferLostNum: " + this.mBurstCaptureBufferLostNum + ", isBurstShot: " + z + ", isInBurstShotCapturing: " + this.mbInBurstShotCapturing + ", getMainShutterButtonType: " + this.mCameraUIInterface.mo18265s());
        this.mbNightJpegDone = true;
        this.mbStopSteadyTips = true;
        if (this.mbEnableUILater) {
            this.mbEnableUILater = false;
            this.mCameraUIInterface.mo18200d(true, false);
            resetAfterPictureTaken(true, this.mbBurstShot);
        }
        if (z) {
            if (Util.f22996d == this.mReceivedSnapNum + this.mBurstCaptureBufferLostNum || ((!Util.m24169C() && this.mMemoryManager.m12304b()) || !this.mbInBurstShotCapturing)) {
                disableBurstShot();
            }
        } else {
            if (this.mCameraInterface.mo10575i() && this.mbCaptureRawTimeDone && !this.mbCaptureHasSuperTextResult) {
                if (!this.mCameraUIInterface.mo18057R()) {
                    this.mCameraUIInterface.mo18200d(true, false);
                } else {
                    this.mCameraUIInterface.mo18200d(false, true);
                }
            }
            boolean zIsInNightProcess = isInNightProcess();
            if (((this.mCameraUIInterface.mo18265s() == 4 || this.mCameraUIInterface.mo18265s() == 3 || this.mCameraUIInterface.mo18265s() == 28 || this.mCameraUIInterface.mo18265s() == 23 || this.mCameraUIInterface.mo18265s() == 26) && ((getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE) || getSupportFunction(CameraUIInterface.KEY_AUTO_NIGHT_SCENCE) || getSupportFunction(CameraUIInterface.KEY_PI) || zIsInNightProcess) && !this.mbCaptureHasSuperTextResult && !isIdPhotoOpen())) || 2 == this.mNightAlgoTriggeredStep) {
                resetAfterPictureTaken(zIsInNightProcess, z);
            }
            if (this.mbShowSteadyTips && this.mbCaptureRawTimeDone) {
                this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_keep_phone_steady);
                this.mbShowSteadyTips = false;
            }
            if (this.mbShowImageOptimizingTips && this.mbCaptureRawTimeDone) {
                this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_image_optimizing_tips_oplus_r);
                this.mbShowImageOptimizingTips = false;
            }
            if (this.mbCaptureRawTimeDone) {
                this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_process_image_after_capture);
            }
            if (2 == this.mNightAlgoTriggeredStep) {
                this.mNightAlgoTriggeredStep = 0;
            }
            if (this.mBeauty3DManager != null) {
                if (isShowBeauty3DEditChooseMenu()) {
                    this.mBeauty3DManager.m12848e(true);
                    this.mBeauty3DManager.m12859p();
                } else {
                    this.mBeauty3DManager.m12860q();
                }
            }
            if (isGoogleLensEnable()) {
                setGoogleLensIconClickable(true);
            }
        }
        resetAeLockAfterCaptured();
        if ((this.mbFrontCamera || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_LOCK_AWB_BEFORE_CAPTURE_REAR_SUPPORT)) && Util.m24169C() && this.mCameraInterface.mo10575i()) {
            resetAwbLockAfterCaptured();
        }
    }

    protected void resetAfterPictureTaken(boolean z, boolean z2) {
        if (!this.mbCaptureRawTimeDone && z) {
            CameraLog.m12954a(TAG, "resetAfterPictureTaken, CaptureRawTime not end");
            return;
        }
        this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), getSupportFunction(CameraUIInterface.KEY_BURST_SHOT));
        if (!this.mCameraUIInterface.mo18023A() && isPIModeOpen() && !z2 && this.mCameraUIInterface.mo18043K()) {
            this.mCameraUIInterface.mo18240l(false, false);
        }
        if (z) {
            if (this.mbTripodNight || this.mbSupportNightPictureTime || 2 == this.mNightAlgoTriggeredStep || isSuperNightShutterCountDownOpen()) {
                restoreAllViews(!this.mbPaused, true, false);
                this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_keep_phone_steady);
                this.mbTripodNight = false;
            }
            this.mOneCamera.mo13120o(0);
            if (!isInNightProMode() && this.mCameraInterface != null && !this.mCameraInterface.mo10529ae()) {
                this.mCameraInterface.mo10527ac();
                this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), false);
            }
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            updateFilterParam(getCurrFilterIndex());
            resetHdrAndFlashModeAfterCapture();
            resetPIModeAfterCapture();
            displayScreenHintIconInSwitchOn();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperClearPortraitOpen() {
        return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, "off")) && isSuperClearPortraitEnable() && !this.mbBurstShot;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperClearPortraitEnable() {
        return (!getSupportFunction(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT) || isPIAISceneOpen() || "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_PI, "off")) || isFilterEffectOpen() || isUltraHighResolutionOpened() || isHighPictureSize() || isSuperSeNightOpen()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDisableBurstShot() {
        CameraLog.m12954a(TAG, "onDisableBurstShot");
        if (this.mbBurstShot) {
            if (this.mReceivedSnapNum > 0) {
                this.mCameraInterface.mo10558c(2);
            }
            this.mbBurstShot = false;
            this.mbInCapturing = false;
            this.mCameraInterface.mo10489a(false);
            this.mCameraInterface.mo10568f(this.mReceivedSnapNum);
            CameraLog.m12954a(TAG, "onDisableBurstShot, CameraTest Continuous Shot End");
            this.mMyHandler.removeMessages(1);
            if (this.mReceivedSnapNum > 0) {
                if (!this.mbPaused) {
                    this.mCameraUIInterface.mo18155as();
                }
                this.mMyHandler.sendEmptyMessageDelayed(1, 500L);
                this.mCameraInterface.mo10446B();
            } else {
                this.mCameraUIInterface.mo18206e(false, false);
                if (!getSupportFunction(CameraUIInterface.KEY_EXPAND_POPBAR)) {
                    this.mCameraInterface.mo10492a(true, false);
                }
                if (getSupportFunction(CameraUIInterface.KEY_FILTER_MENU)) {
                    this.mCameraUIInterface.mo18190c(true);
                }
                if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
                    this.mCameraUIInterface.mo18190c(true);
                }
                displayScreenHintIconInSwitchOn();
            }
            resetPIModeAfterCapture();
            if (!this.mCameraUIInterface.mo18057R()) {
                this.mCameraUIInterface.mo18107a(true, false);
                this.mCameraUIInterface.mo18175b(true, false);
                this.mCameraUIInterface.mo18191c(true, false);
                this.mCameraUIInterface.mo18213f(true, false);
            }
            if (isGoogleLensEnable()) {
                setGoogleLensIconClickable(true);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean needOverlayBitmap() {
        if (1 == getCurFilterListType()) {
            return false;
        }
        return super.needOverlayBitmap();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetX(int OplusGLSurfaceView_13) {
        int[] iArrMo10498a;
        if (6 == OplusGLSurfaceView_13) {
            return this.mActivity.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_add_offset_x);
        }
        if (9 != OplusGLSurfaceView_13) {
            return 0;
        }
        if (this.mCameraInterface.mo10509aK() == null) {
            return -1;
        }
        if (1 == this.mCameraInterface.mo10519aU().mo16539j() && (iArrMo10498a = this.mCameraInterface.mo10498a(this.mActivity, 9)) != null) {
            return iArrMo10498a[0];
        }
        return (int) this.mCameraInterface.mo10509aK()[0];
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetY(int OplusGLSurfaceView_13) {
        int[] iArrMo10498a;
        if (6 == OplusGLSurfaceView_13) {
            return this.mActivity.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_add_offset_y);
        }
        if (9 != OplusGLSurfaceView_13 || this.mCameraInterface.mo10509aK() == null) {
            return 0;
        }
        if (1 == this.mCameraInterface.mo10519aU().mo16539j() && (iArrMo10498a = this.mCameraInterface.mo10498a(this.mActivity, 9)) != null) {
            return iArrMo10498a[1];
        }
        return ((int) this.mCameraInterface.mo10509aK()[1]) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.bubble_sticker_guide_ultra_zoom_gap_y);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (OplusGLSurfaceView_13 == 2) {
            if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D)) {
                if (getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && !isShowBeauty3D() && this.mCameraUIInterface.mo18023A() && "beauty".equals(getCurrEffectMenuName()) && ImageBeautyTools.m22674a(this.mActivity) == 0) {
                    this.mCameraUIInterface.mo18086a((View) null, 6, getBubbleOffsetX(6), getBubbleOffsetY(6));
                } else {
                    this.mCameraUIInterface.mo18210f(6, false);
                }
            }
            if (this.mBeauty3DManager != null) {
                if (isShowBeauty3DEditChooseMenu()) {
                    this.mBeauty3DManager.m12848e(true);
                    this.mBeauty3DManager.m12859p();
                } else {
                    this.mBeauty3DManager.m12860q();
                }
            }
            if (!isGoogleLensEnable()) {
                hideGoogleLensIcon(true);
                return;
            } else {
                if (z) {
                    if (this.mCameraUIInterface.mo18023A()) {
                        return;
                    }
                    showGoogleLensIcon(true);
                    return;
                }
                hideGoogleLensIcon(true);
                return;
            }
        }
        if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 5) {
            Beauty3DManager c2674b = this.mBeauty3DManager;
            if (c2674b != null) {
                c2674b.m12860q();
            }
            if (isGoogleLensEnable()) {
                if (z) {
                    showGoogleLensIcon(true);
                    return;
                } else {
                    hideGoogleLensIcon(true);
                    return;
                }
            }
            return;
        }
        if (OplusGLSurfaceView_13 == 18) {
            handleBeauty3DGuideView(false);
            if (isGoogleLensEnable()) {
                if (z) {
                    showGoogleLensIcon(true);
                    return;
                } else {
                    hideGoogleLensIcon(true);
                    return;
                }
            }
            return;
        }
        if (OplusGLSurfaceView_13 != 20) {
            switch (OplusGLSurfaceView_13) {
                case 12:
                    if (this.mBeauty3DManager != null) {
                        if (z && isShowBeauty3DEditChooseMenu()) {
                            this.mBeauty3DManager.m12848e(true);
                            this.mBeauty3DManager.m12859p();
                            break;
                        } else {
                            this.mBeauty3DManager.m12860q();
                            break;
                        }
                    }
                    break;
                case 13:
                    handleBeauty3DGuideView(z);
                    break;
                case 14:
                    Beauty3DManager c2674b2 = this.mBeauty3DManager;
                    if (c2674b2 != null) {
                        c2674b2.m12853j();
                        break;
                    }
                    break;
                case 15:
                    showBeauty3DView();
                    break;
            }
            return;
        }
        updateMenuWithMono(isMonoIndex(getCurrFilterIndex()));
        this.mCameraUIInterface.mo18108a(true, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showEffectMenu() {
        return (isInNightProcess() && this.mbInCapturing) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        if (isInNightProcess() && isTripodNight()) {
            return true;
        }
        return super.isNeedProgressBarInCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProgressBarForOtherApp() {
        return isFilterEffectOpen() && isHDRState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getPreviewStreamNum() {
        int OplusGLSurfaceView_13;
        if (isSatOpen()) {
            synchronized (this.mApsDecisionResultLock) {
                OplusGLSurfaceView_13 = this.mSensorNumber;
            }
            return OplusGLSurfaceView_13;
        }
        return super.getPreviewStreamNum();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected OneCamera.PlatformImplementations.kt_3 getCaptureCallback() {
        this.mReceivedRawResultNum = 0;
        return super.getCaptureCallback();
    }

    /* compiled from: CommonCapMode.java */
    /* renamed from: com.oplus.camera.capmode.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Runtime f12836b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f12837c;

        private PlatformImplementations.kt_3() {
            this.f12836b = null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m12303a() {
            if (this.f12836b == null) {
                this.f12836b = Runtime.getRuntime();
            }
            this.f12837c = this.f12836b.maxMemory();
            CameraLog.m12954a(CommonCapMode.TAG, "initMemory, mMaxMemory: " + this.f12837c);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m12304b() {
            if (this.f12836b == null) {
                this.f12836b = Runtime.getRuntime();
            }
            if (this.f12837c - (this.f12836b.totalMemory() - this.f12836b.freeMemory()) > 52428800) {
                return false;
            }
            CameraLog.m12954a(CommonCapMode.TAG, "isNeedStopCapture, realfree <= MIN_LEFT_MEMEORY");
            return true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.mo18210f(5, true);
        }
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D) && ImageBeautyTools.m22674a(this.mActivity) == 0 && !isShowBeauty3D() && getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && "beauty".equals(getCurrEffectMenuName())) {
            this.mCameraUIInterface.mo18086a((View) null, 6, getBubbleOffsetX(6), getBubbleOffsetY(6));
        }
        if (this.mBeauty3DManager != null) {
            if (isShowBeauty3DEditChooseMenu()) {
                this.mBeauty3DManager.m12848e(true);
                this.mBeauty3DManager.m12859p();
            } else {
                this.mBeauty3DManager.m12860q();
            }
        }
        this.mbFirstEffectMenuOpened = true;
        if (isGoogleLensEnable()) {
            hideGoogleLensIcon(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_preview_frame".equals(str)) {
            if (getSupportFunction(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || getSupportFunction(CameraFunction.SUPER_TEXT_CPU_PROCESS)) {
                return getBeauty3Dstatus() == 0 || getBeauty3Dstatus() == 4;
            }
            return false;
        }
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return 3 == AlgoSwitchConfig.getApsVersion() && getSupportFunction(CameraFunction.SAT_CAMERA) && !isHighPictureSize() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL);
        }
        if ("type_still_capture_raw".equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_RAW);
        }
        if ("type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str)) {
            return isSatOpen();
        }
        if ("type_tele_small_preview".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TELE_SMALL_PREVIEW_SUPPORT) && isSatOpen();
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_reprocess_data_yuv".equals(str)) {
            return Util.m24169C() && getSupportFunction(CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) && !this.mbFrontCamera && this.mCameraInterface.mo10575i();
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z) {
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D)) {
            this.mCameraUIInterface.mo18210f(6, true);
        }
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.mo18210f(5, true);
        }
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null) {
            c2674b.m12860q();
        }
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) || CameraCharacteristicsUtil.m12987j() == getProperCameraId(this.mCameraId) || this.mbFrontCamera || getFaceBeautyCurrIndex() != 0 || this.mbPreburstShotCapture) {
            return;
        }
        this.mCameraInterface.mo10554b(this.mLastPreviewSize);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isPIAISceneOpen() {
        if (this.mPreferences == null || this.mActivity == null || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || this.mbFrontCamera) {
            return false;
        }
        return TextUtils.equals("on", this.mPreferences.getString(CameraUIInterface.KEY_PI_AI, this.mActivity.getString(R.string.camera_pi_ai_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAISceneOpen() {
        if (!getSupportFunction(CameraUIInterface.KEY_AI_SCN)) {
            return false;
        }
        String string = this.mActivity != null ? this.mActivity.getString(R.string.camera_ai_scene_default_value) : "on";
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && this.mActivity != null) {
            string = this.mActivity.getString(R.string.camera_pi_ai_scene_default_value);
        }
        if (this.mPreferences != null) {
            string = this.mPreferences.getString(CameraUIInterface.KEY_AI_SCN, string);
        }
        return "on".equals(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBeauty3Dstatus() {
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null) {
            return c2674b.m12849f();
        }
        return 0;
    }

    public boolean isShowBeauty3DEditChooseMenu() {
        return ImageBeautyTools.m22674a(this.mActivity) == 1 && getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) && getFaceBeautyCurrIndex() == -1 && this.mCameraUIInterface.mo18023A() && getBeauty3Dstatus() == 0 && "beauty".equals(getCurrEffectMenuName());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        int[] iArrMo13061a;
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f(TAG, "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
            return;
        }
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (this.mbCheckTakeAnimateDelay) {
            this.mbCheckTakeAnimateDelay = false;
            this.mbTakeAnimateDelay = Util.m24203a(captureResult) > ((float) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_LUX_DELAY_ANIMATE_THRESHOLD));
        }
        if (isShowBeauty3D() && getBeauty3DConfigured()) {
            this.mBeauty3DManager.m12835b(captureResult);
            return;
        }
        int[] iArrMo13061a2 = this.mOneCamera.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13260Z, captureResult);
        if (iArrMo13061a2 != null && iArrMo13061a2.length > 0 && !isHalVideoRecording() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_AUTO_MICRO)) {
            if (this.mbInCapturing) {
                if (!this.mbAutoMicroOpen) {
                    this.mOneCamera.mo13012B(false);
                }
            } else if (isTiltShiftOpen()) {
                this.mOneCamera.mo13012B(false);
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            } else {
                String string = this.mPreferences.getString(CameraUIInterface.KEY_MACRO_SWITCH, "auto");
                if (1 == iArrMo13061a2[0] && "auto".equals(string) && !isMonoIndex(getCurrFilterIndex()) && !isInNightProcess()) {
                    if (!this.mbAutoMicroOpen && !this.mCameraUIInterface.mo18057R()) {
                        CameraLog.m12959b(TAG, "onPreviewCaptureResult, micro mode");
                        this.mbAutoMicroOpen = true;
                        if (this.mMyHandler != null) {
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 4;
                            messageObtain.arg1 = 1;
                            this.mMyHandler.sendMessage(messageObtain);
                        }
                    }
                } else if (this.mbAutoMicroOpen) {
                    CameraLog.m12959b(TAG, "onPreviewCaptureResult, exit micro mode");
                    this.mbAutoMicroOpen = false;
                    Handler handler = this.mMyHandler;
                    if (handler != null) {
                        handler.sendEmptyMessage(5);
                    }
                } else if ("off".equals(string)) {
                    this.mOneCamera.mo13012B(false);
                    this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
            }
        }
        if (!this.mbInCapturing) {
            if (Util.m24169C()) {
                iArrMo13061a = this.mOneCamera.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13289ab, captureResult);
            } else {
                iArrMo13061a = this.mOneCamera.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13290ac, captureResult);
            }
            if (iArrMo13061a != null && iArrMo13061a.length > 0) {
                this.mbSceneNight = iArrMo13061a[0] == 1;
            } else {
                this.mbSceneNight = false;
            }
        }
        if (isMonoIndex(getCurrFilterIndex())) {
            updateMonoFilterEffect(captureResult);
        }
        super.onPreviewCaptureResult(cameraPreviewResult);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFlashMode() {
        return isMonoIndex(getCurrFilterIndex()) ? "off" : super.getFlashMode();
    }

    private void updateMonoFilterEffect(CaptureResult captureResult) {
        if (this.mActivity == null) {
            return;
        }
        final int[] iArrMo13061a = this.mOneCamera.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13288aa, captureResult);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr;
                if (CommonCapMode.this.mbPaused || (iArr = iArrMo13061a) == null || iArr.length <= 0) {
                    return;
                }
                CommonCapMode c2650d = CommonCapMode.this;
                if (c2650d.isMonoIndex(c2650d.getCurrFilterIndex())) {
                    CommonCapMode.this.updateShelter(iArrMo13061a[0]);
                }
            }
        });
    }

    private void updateNowRearEffectIndex() {
        if (!this.mbFrontCamera) {
            this.mNowRearEffectIndex = this.mPreferences.getInt("key_filter_index", FilterHelper.f21279a);
        }
        if (getSupportFunction(CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            updateMenuWithMono(isMonoIndex(getCurrFilterIndex()));
        }
    }

    private void updateMenuWithMono(final boolean z) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.4
            @Override // java.lang.Runnable
            public void run() {
                if (CommonCapMode.this.mOneCamera == null) {
                    return;
                }
                if (CommonCapMode.this.getSupportFunction(CameraUIInterface.KEY_FLASH_MODE)) {
                    if (z) {
                        CommonCapMode.this.mOneCamera.mo13069b("off");
                        CommonCapMode.this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
                    } else if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM)) {
                        String string = CommonCapMode.this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, "off");
                        CommonCapMode.this.mOneCamera.mo13069b(string);
                        CommonCapMode.this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, string);
                    }
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_AUTO_MICRO) && CommonCapMode.this.mOneCamera != null) {
                    if (z) {
                        CommonCapMode.this.mOneCamera.mo13012B(false);
                        CommonCapMode.this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_MACRO_SWITCH, "off");
                    } else {
                        String string2 = CommonCapMode.this.mPreferences.getString(CameraUIInterface.KEY_MACRO_SWITCH, "auto");
                        CommonCapMode.this.mOneCamera.mo13012B("auto".equals(string2));
                        CommonCapMode.this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_MACRO_SWITCH, string2);
                    }
                }
                CommonCapMode.this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        });
    }

    private void onHighResolution() {
        this.mbHighResolutionChangeRatio = true;
        onFilterItemChange(FilterHelper.f21279a);
        this.mbHighResolutionChangeRatio = false;
        if (this.mCameraUIInterface.mo18023A() && MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
            this.mCameraUIInterface.mo18267s(true);
            this.mCameraInterface.mo10492a(true, false);
            this.mCameraInterface.mo10563d(true);
        } else {
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
        }
        if (this.mCameraUIInterface.mo18043K()) {
            this.mCameraUIInterface.mo18109a(true, true, true, true);
        }
        this.mCameraUIInterface.mo18263r(true);
    }

    private void forceCloseHighResolution() {
        if (getSupportFunction(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION) && this.mPreferences != null) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard");
            editorEdit.commit();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShelter(int OplusGLSurfaceView_13) {
        String defaultFilterType;
        if (this.mPreviewEffectProcess == null) {
            return;
        }
        if (1 == OplusGLSurfaceView_13) {
            this.mbOcclusion = true;
            this.mCameraUIInterface.mo18070a(R.string.camera_bokeh_camera_do_not_occlusion, 0, false, false, true);
            defaultFilterType = "default";
        } else {
            defaultFilterType = getDefaultFilterType(getCurrFilterIndex());
            if (this.mbOcclusion) {
                this.mbOcclusion = false;
                this.mCameraUIInterface.mo18108a(true, false, true);
            }
        }
        this.mPreviewEffectProcess.mo22792a(defaultFilterType);
        this.mCameraUIInterface.mo18076a(getCurrFilterIndex(), defaultFilterType);
    }

    private String getDefaultFilterType(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == FilterHelper.m22634h() ? FilterPackageUtil.PORTRAIT4_1 : OplusGLSurfaceView_13 == FilterHelper.m22635i() ? FilterPackageUtil.PORTRAIT4_3 : OplusGLSurfaceView_13 == FilterHelper.m22636j() ? FilterPackageUtil.F_COMMON_5 : OplusGLSurfaceView_13 == FilterHelper.m22637k() ? FilterPackageUtil.F_COMMON_6 : "default";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        Handler handler;
        if (!this.mbShowSteadyTips) {
            super.displayScreenHintIconInSwitchOn();
        }
        if (is10bitsHeicEncodeEnable() && !this.mbFrontCamera) {
            this.mCameraUIInterface.mo18166b(R.string.camera_10bit_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
        }
        if (!this.mbAutoMicroOpen || (handler = this.mMyHandler) == null) {
            return;
        }
        handler.sendEmptyMessage(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportMicroShowReminderToDcs() {
        this.mMsgData = new ReminderMsgData(this.mActivity, true);
        if (this.mCameraInterface != null) {
            if (!this.mCameraInterface.mo10575i()) {
                this.mMsgData.mCameraEnterType = String.valueOf(2);
            }
            this.mMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        }
        this.mMsgData.mCaptureMode = getCameraMode();
        this.mMsgData.mOrientation = this.mOrientation;
        ReminderMsgData reminderMsgData = this.mMsgData;
        reminderMsgData.mReminderTypeValue = "ai_scene";
        reminderMsgData.mReminderCodeValue = String.valueOf(18);
        this.mMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        this.mMsgData.report();
        this.mMsgData = null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setBeauty3DState(int OplusGLSurfaceView_13) {
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b != null) {
            c2674b.m12826a(OplusGLSurfaceView_13);
        }
    }

    private void handleBeauty3DGuideView(boolean z) {
        if (this.mbPaused) {
            CameraLog.m12967f(TAG, "handleBeauty3DGuideView, pause, so return");
            return;
        }
        Beauty3DManager c2674b = this.mBeauty3DManager;
        if (c2674b == null) {
            CameraLog.m12954a(TAG, "handleBeauty3DGuideView, mBeauty3DManager null");
            return;
        }
        if (!z) {
            if (c2674b.m12852i()) {
                this.mBeauty3DManager.m12856m();
                return;
            }
            return;
        }
        if (!getSupportFunction(CameraUIInterface.KEY_BEAUTY3D)) {
            CameraLog.m12954a(TAG, "handleBeauty3DGuideView, not support return");
            return;
        }
        if (ImageBeautyTools.m22674a(this.mActivity) == 1) {
            CameraLog.m12954a(TAG, "handleBeauty3DGuideView, files exist, return");
            return;
        }
        if (this.mCameraInterface.mo10575i() && z && this.mPreferences.getBoolean(CameraUIInterface.KEY_FRONT_CAMERA_FIRST_SWITCH, true)) {
            CameraLog.m12954a(TAG, "handleBeauty3DGuideView, start showBeauty3DGuide");
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(CameraUIInterface.KEY_FRONT_CAMERA_FIRST_SWITCH, false);
            editorEdit.apply();
            this.mCameraUIInterface.mo18032F();
            this.mBeauty3DManager.m12841c(getPreviewSize(this.mOneCamera.mo13086e()));
            return;
        }
        if (isShowingGuideView() && z) {
            this.mCameraUIInterface.mo18032F();
            this.mBeauty3DManager.m12844d(getPreviewSize(this.mOneCamera.mo13086e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBeauty3DChange(boolean z) {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10573h(z);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isPIModeOpen() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            return getSupportFunction(CameraUIInterface.KEY_PI) && this.mPreferences != null && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_PI, "off"));
        }
        if (getSupportFunction(CameraUIInterface.KEY_PI_AI)) {
            return isPIAISceneOpen();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInNightProcess() {
        if (isSuperSeNightOpen()) {
            return getSupportFunction(CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS) && getNightStateDecision() > 0;
        }
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y);
        return getSupportFunction(CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS) && !this.mbBurstShot && getNightStateDecision() > 0 && this.mCameraInterface != null && this.mCameraInterface.mo10575i() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y) || (isAISceneOpen() && 12 == this.mCameraInterface.mo10576j())) && ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || !isPIModeOpen()) && ((!isFaceBeautyOrMakeupOpen() || configBooleanValue) && ((!isFilterEffectOpen() || configBooleanValue) && !((isHDRState() && !configBooleanValue) || isFlashState() || isSuperClearPortraitOpen()))));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInOfflineNightProcess() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y) && isInNightProcess();
    }

    protected void forceClosePIEffect() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            if (getSupportFunction(CameraUIInterface.KEY_PI_AI) && this.mPreferences != null) {
                SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                editorEdit.putString(CameraUIInterface.KEY_PI_AI, "off");
                editorEdit.commit();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_PI_AI);
                return;
            }
            return;
        }
        if (getSupportFunction(CameraUIInterface.KEY_PI) && this.mPreferences != null) {
            SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
            editorEdit2.putString(CameraUIInterface.KEY_PI, "off");
            editorEdit2.commit();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_PI);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSatOpen() {
        if (getSupportFunction(CameraFunction.SAT_CAMERA)) {
            return !isHighPictureSize();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUltraWideAngleOpened() {
        if (isHighPictureSize()) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (isNoneSatUltraWideAngleOpen()) {
            return (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || Float.compare(this.mOneCamera.mo13086e().m13279n(), 0.0f) == 0) ? R.string.toast_ultra_wide_angel_lens : Util.m24445f(R.string.toast_ultra_wide_micro_lens);
        }
        return -1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayFixedUpModeHint() {
        super.displayFixedUpModeHint();
        if (this.mActivity == null) {
            return;
        }
        CameraLog.m12954a(TAG, "displayFixedUpModeHint");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.5
            @Override // java.lang.Runnable
            public void run() {
                if (!CommonCapMode.this.isHighPictureSize() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                    return;
                }
                if (TextUtils.isEmpty(CameraConfig.getConfigStringValue(ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                    CommonCapMode.this.mCameraUIInterface.mo18166b(CommonCapMode.this.getHighPictureSizeHint(), R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Double.valueOf(CommonCapMode.this.getDisplayHighPictureSize()));
                } else {
                    CommonCapMode.this.mCameraUIInterface.mo18166b(R.string.camera_setting_menu_high_resolution_item, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11352l(isHighPictureSize());
        zoomConfigure.m11356n(getSupportFunction(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE));
        zoomConfigure.m11368t(getSupportFunction(CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X));
        zoomConfigure.m11370u(getSupportFunction(CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_INSENSOR_ZOOM_POINT_3X_SUPPORT));
        zoomConfigure.m11329b(CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetCaptureButton() {
        if (this.mCameraInterface.mo10575i()) {
            this.mCameraUIInterface.mo18200d(true, false);
        }
        if (this.mCameraUIInterface.mo18265s() == 4 || this.mCameraUIInterface.mo18265s() == 28) {
            this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), getSupportFunction(CameraUIInterface.KEY_BURST_SHOT));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onHomeKeyClick() {
        resetMonoFilter();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        if (this.mbDestroyed || this.mCameraInterface == null) {
            return null;
        }
        return !this.mCameraInterface.mo10575i() ? ApsConstant.FEATURE_COMMON_DUMMY : (isSatOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) ? ApsConstant.FEATURE_COMMON_SAT_HAL : isHighPictureSize() ? ApsConstant.FEATURE_COMMON_DUMMY : super.getCameraFeature();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(String str) {
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return (!Util.m24169C() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && isSatOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL);
        }
        if ("type_still_capture_yuv_main".equals(str) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return (!Util.m24169C() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && isSatOpen();
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean checkSensorMask(boolean z, boolean z2) {
        if (isSatOpen()) {
            synchronized (this.mApsDecisionResultLock) {
                if (this.mDecisionResult != null && this.mDecisionResult.mSensorMask != null) {
                    if (z) {
                        return 1 == this.mDecisionResult.mSensorMask[0];
                    }
                    if (z2) {
                        return 1 == this.mDecisionResult.mSensorMask[2];
                    }
                    return 1 == this.mDecisionResult.mSensorMask[1];
                }
            }
        }
        return super.checkSensorMask(z, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCaptureInDarkLight(int OplusGLSurfaceView_13) {
        return (this.mbBurstShot || !(17 == OplusGLSurfaceView_13 || 18 == OplusGLSurfaceView_13 || 19 == OplusGLSurfaceView_13) || this.mbFrontCamera) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int OplusGLSurfaceView_13) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL) && OplusGLSurfaceView_13 == 0 && this.mReceivedPreviewResultNum == 0) {
            return false;
        }
        return super.needPreviewMeta(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onReceivePreviewCaptureResult(CaptureResult captureResult) {
        super.onReceivePreviewCaptureResult(captureResult);
        this.mReceivedPreviewResultNum++;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        if (isGoogleLensEnable()) {
            hideGoogleLensIcon(false);
        }
        if (isAISceneOpen()) {
            this.mCameraUIInterface.mo18239l(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        super.onZoomChanged();
        displayScreenHintIconInSwitchOn();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        if (isGoogleLensEnable()) {
            hideGoogleLensIcon(false);
        }
        if (isAISceneOpen()) {
            this.mCameraUIInterface.mo18239l(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
        if (1 == OplusGLSurfaceView_13 || 2 == OplusGLSurfaceView_13) {
            return;
        }
        showNextTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGoogleLensAvailability() {
        boolean zBooleanValue;
        String string;
        SharedPreferences sharedPreferences = this.mActivity != null ? this.mActivity.getApplicationContext().getSharedPreferences("rom_update_info", 0) : null;
        if (sharedPreferences == null || (string = sharedPreferences.getString("google_lens_switch", null)) == null) {
            zBooleanValue = true;
        } else {
            try {
                zBooleanValue = Boolean.valueOf(string).booleanValue();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        CameraLog.m12954a(TAG, "checkGoogleLensAvailability, enableGoogleLens: " + zBooleanValue);
        if (zBooleanValue && this.mLensApi == null && this.mActivity != null) {
            this.mLensApi = new LensApi(this.mActivity.getApplicationContext());
            this.mLensApi.checkLensAvailability(new LensApi.LensAvailabilityCallback() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.6
                @Override // com.google.lens.sdk.LensApi.LensAvailabilityCallback
                public void onAvailabilityStatusFetched(int OplusGLSurfaceView_13) {
                    CameraLog.m12954a(CommonCapMode.TAG, "checkGoogleLensAvailability, onAvailabilityStatusFetched, status: " + OplusGLSurfaceView_13);
                    if (OplusGLSurfaceView_13 == 0) {
                        CommonCapMode.this.mbGoogleLensStatusReady = true;
                        if (CommonCapMode.this.mbCapModeInit && CommonCapMode.this.isGoogleLensEnable()) {
                            CommonCapMode.this.showGoogleLensIcon(false);
                            CommonCapMode.this.setGoogleLensIconClickable(true);
                        }
                    }
                }
            });
        }
    }

    public boolean isGoogleLensEnable() {
        if (getSupportFunction(CameraFunction.GOOGLE_LENS)) {
            return this.mbGoogleLensStatusReady;
        }
        return false;
    }

    private void initGoogleLensIcon() {
        this.mActivity.getLayoutInflater().inflate(R.layout.google_lens, this.mCameraRootView);
        this.mGoogleLensIcon = (RotateImageView) this.mCameraRootView.findViewById(R.id_renamed.google_lens_icon_view);
        this.mGoogleLensIcon.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommonCapMode.this.mLensApi != null) {
                    try {
                        CommonCapMode.this.mLensApi.launchLensActivity(CommonCapMode.this.mActivity);
                        CommonCapMode.this.reportClickMenuToDcs();
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickMenuToDcs() {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        if (this.mCameraInterface != null) {
            menuClickMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        }
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mFuncKeyId = 53;
        menuClickMsgData.report();
    }

    public void showGoogleLensIcon(boolean z) {
        if (this.mCameraUIInterface.mo18023A() || this.mCameraUIInterface.mo18043K() || this.mCameraUIInterface.mo18057R() || this.mCameraUIInterface.mo18159aw() || this.mCameraUIInterface.mo18160ax() || this.mCameraInterface.mo10445A() || !this.mGoogleLensShouldShow) {
            return;
        }
        if (this.mGoogleLensIcon == null) {
            initGoogleLensIcon();
        }
        if (z) {
            Util.m24263a(this.mGoogleLensIcon);
            return;
        }
        Animation animation = this.mGoogleLensIcon.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            animation.cancel();
        }
        this.mGoogleLensIcon.setVisibility(0);
    }

    public void hideGoogleLensIcon(boolean z) {
        RotateImageView rotateImageView = this.mGoogleLensIcon;
        if (rotateImageView != null) {
            if (z) {
                Util.m24387b(rotateImageView);
                return;
            }
            Animation animation = rotateImageView.getAnimation();
            if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
                animation.cancel();
            }
            this.mGoogleLensIcon.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoogleLensIconClickable(boolean z) {
        RotateImageView rotateImageView = this.mGoogleLensIcon;
        if (rotateImageView != null) {
            rotateImageView.setClickable(z);
        }
    }

    private boolean isDeviceLocked() {
        KeyguardManager keyguardManager;
        if (this.mActivity == null || (keyguardManager = (KeyguardManager) this.mActivity.getApplicationContext().getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.isDeviceLocked();
    }

    private boolean isTorchMode() {
        return getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && CameraParameter.FlashMode.FLASH_TORCH.equals(getRearFlashMode());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void showNextTip() {
        super.showNextTip();
        if (this.mActivity == null || this.mCameraUIInterface == null || isMoreModeShowing() || showOutPreviewGuide()) {
            return;
        }
        if (isFirstTipsEnable(CameraUIInterface.KEY_FIRST_BEAUTY_TIPS)) {
            showFirstBeautyTipView();
        } else if (isFirstTipsEnable(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE)) {
            final View viewFindViewById = this.mActivity.findViewById(R.id_renamed.zoom_seek_anchor_view);
            if (viewFindViewById != null) {
                viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.8
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (CommonCapMode.this.isMoreModeShowing() || !CommonCapMode.this.isFirstTipsEnable(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE) || viewFindViewById.getMeasuredWidth() == 0) {
                            return;
                        }
                        CameraTipsManager.m14374a().m14375a(1);
                    }
                });
            }
            this.mCameraUIInterface.mo18115aE();
        }
    }

    private boolean showOutPreviewGuide() {
        return this.mCameraUIInterface != null && this.mCameraUIInterface.mo18182be();
    }

    public void showUltraWideTips() {
        if (this.mActivity != null && this.mCameraUIInterface != null && !isMoreModeShowing() && isFirstTipsEnable(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE)) {
            final View viewFindViewById = this.mActivity.findViewById(R.id_renamed.zoom_seek_anchor_view);
            if (viewFindViewById != null) {
                viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.IntrinsicsJvm.kt_5.9
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (!CommonCapMode.this.isMoreModeShowing() && CommonCapMode.this.isFirstTipsEnable(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE) && viewFindViewById.getMeasuredWidth() != 0) {
                            CommonCapMode.this.showFirstBubble(viewFindViewById, 9);
                            viewFindViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        } else {
                            CameraTipsManager.m14374a().m14378c();
                        }
                    }
                });
            } else {
                CameraTipsManager.m14374a().m14378c();
            }
            this.mCameraUIInterface.mo18115aE();
            return;
        }
        CameraTipsManager.m14374a().m14378c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMoreModeShowing() {
        return this.mCameraUIInterface != null && (this.mCameraUIInterface.mo18057R() || this.mCameraUIInterface.mo18058S());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(String str) {
        if (CameraEntry.m13302b(this.mCameraEntryType)) {
            return false;
        }
        if (CameraUIInterface.KEY_FIRST_BEAUTY_TIPS.equals(str)) {
            if (this.mCameraEntry == null || !this.mCameraEntry.m13325R()) {
                return isBubbleOpen(CameraUIInterface.KEY_FIRST_BEAUTY_TIPS);
            }
            return false;
        }
        if (CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS.equals(str)) {
            return isBubbleOpen(CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS);
        }
        return CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE.equals(str) && isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE) && getSupportFunction(CameraUIInterface.KEY_ZOOM) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_BUBBLE_TIPS_SUPPORT) && !this.mbFrontCamera;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAllViewsExceptShutter() {
        if (this.mCameraUIInterface.mo18023A()) {
            this.mCameraUIInterface.mo18267s(false);
        } else {
            this.mCameraUIInterface.mo18259q(false);
        }
        this.mCameraUIInterface.mo18232j(false, false);
        this.mCameraUIInterface.mo18215g(4);
        this.mCameraUIInterface.mo18193d(4);
        this.mCameraUIInterface.mo18167b(4, Util.m24420c(getPreviewSize(getCameraInfo(this.mCameraId))));
        this.mCameraUIInterface.mo18209f(4);
        this.mCameraUIInterface.mo18052P(false);
        this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
        if (isPanelMode()) {
            this.mCameraUIInterface.mo18077a(4, true);
        } else {
            this.mCameraUIInterface.mo18068a(4, 1);
        }
    }

    protected void restoreAllViews(boolean z, boolean z2, boolean z3) {
        this.mCameraUIInterface.mo18217g(true);
        this.mCameraUIInterface.mo18186c(8, false);
        this.mCameraUIInterface.mo18215g(0);
        this.mCameraUIInterface.mo18167b(0, Util.m24420c(getPreviewSize(getCameraInfo(this.mCameraId))));
        this.mCameraUIInterface.mo18052P(true);
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
            this.mCameraUIInterface.mo18193d(0);
        }
        if (supportBeautyButton()) {
            this.mCameraUIInterface.mo18240l(true, false);
        }
        if (z2) {
            this.mCameraUIInterface.mo18209f(0);
        }
        this.mCameraInterface.mo10550az();
        if (z) {
            this.mCameraUIInterface.mo18155as();
        }
        if (this.mCameraUIInterface.mo18023A()) {
            return;
        }
        this.mCameraUIInterface.mo18263r(true);
        if (isPanelMode()) {
            this.mCameraUIInterface.mo18077a(0, true);
        } else {
            this.mCameraUIInterface.mo18068a(0, 1);
        }
        if (isShowProPanelMenu()) {
            return;
        }
        if (isInNightProMode() && z3) {
            return;
        }
        this.mCameraInterface.mo10492a(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return (shouldShowSteadyTips() && isNightAlgoCaptureTriggered()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideHeadLine() {
        if (this.mbInCapturing && isInNightProcess()) {
            return true;
        }
        return super.isHideHeadLine();
    }

    private boolean isAISSnapshotUseMFNR(boolean z) {
        int[] configIntArrayValue;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MFNR) && (configIntArrayValue = CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_AIS_SNAPSHOT_USE_MFNR)) != null) {
            return z ? 1 == configIntArrayValue[1] : 1 == configIntArrayValue[0];
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setPreburstShotCapture(boolean z) {
        this.mbPreburstShotCapture = z;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemChange(int OplusGLSurfaceView_13) {
        if (this.mbPaused) {
            updateFaceBeautyValue(OplusGLSurfaceView_13);
            return;
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) || !this.mbFrontCamera || this.mbPreburstShotCapture) {
            super.onFaceBeautyItemChange(OplusGLSurfaceView_13);
            return;
        }
        int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
        CameraLog.m12954a(TAG, "onFaceBeautyItemChange, level: " + OplusGLSurfaceView_13 + ", currentLevel: " + faceBeautyCurrIndex);
        if (faceBeautyCurrIndex != OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 != 0) {
                this.mChangePreviewSize = getFaceBeautyPreviewSize();
                if (this.mChangePreviewSize != null) {
                    this.mCameraInterface.mo10554b(this.mChangePreviewSize);
                }
            } else {
                this.mCameraInterface.mo10554b(this.mLastPreviewSize);
            }
        }
        super.onFaceBeautyItemChange(OplusGLSurfaceView_13);
    }

    private Size getFaceBeautyPreviewSize() {
        if (this.mPreferences != null) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
            CameraLog.m12954a(TAG, "getFaceBeautyPreviewSize, pictureSizeType: " + string);
            double dM24196X = 1.3333333333333333d;
            if (!"standard".equals(string) && !"standard_high".equals(string)) {
                if (DcsMsgData.FULL.equals(string)) {
                    dM24196X = Util.m24196X();
                } else if ("square".equals(string)) {
                    dM24196X = 1.0d;
                } else if ("16_9".equals(string)) {
                    dM24196X = 1.7777777777777777d;
                }
            }
            List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE);
            if (configSizeListValue != null && configSizeListValue.size() > 0) {
                CameraLog.m12954a(TAG, "getFaceBeautyPreviewSize, sizeList: " + configSizeListValue.toString());
                return Util.m24235a(configSizeListValue, dM24196X);
            }
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onFaceBeautyMenuClick() {
        Size faceBeautyPreviewSize;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) && CameraCharacteristicsUtil.m12987j() != getProperCameraId(this.mCameraId) && !this.mbFrontCamera && !this.mbPreburstShotCapture) {
            CameraLog.m12954a(TAG, "onFaceBeautyMenuClick, isFaceBeautyMenuOpen: " + this.mCameraUIInterface.mo18043K());
            if (!this.mCameraUIInterface.mo18043K() && (faceBeautyPreviewSize = getFaceBeautyPreviewSize()) != null) {
                this.mCameraInterface.mo10554b(faceBeautyPreviewSize);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNightCaptureCountDown() {
        this.mNightCaptureTotalTime = ((long) this.mSeNightCostTime) >= 100 ? Math.round(r0 / 1000.0f) * 1000 : 100L;
        this.mNightCountDownUI.m20100a(this.mNightCaptureTotalTime);
        updateNightCaptureShutter();
    }

    private void pauseNightCapture() {
        NightCountDownUI c3361p = this.mNightCountDownUI;
        if (c3361p != null) {
            c3361p.m20101b();
        }
    }

    public boolean isSuperSeNightOpen() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SE_NIGHT_SUPPORT)) {
            return this.mbAutoSeNight;
        }
        return false;
    }

    public boolean isSuperNightShutterCountDownOpen() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_MODE_SHUTTER_COUNTDOWN_SUPPORT)) {
            return this.mbNightShutterCountDown;
        }
        return false;
    }

    private void updateSeNightCaptureTime(CameraApsDecision cameraApsDecision) {
        if (cameraApsDecision != null) {
            this.mSeNightCostTime = cameraApsDecision.mNightTotalExpTime;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewDecisionResult(CameraApsDecision cameraApsDecision) {
        super.onPreviewDecisionResult(cameraApsDecision);
        updateSeNightCaptureTime(cameraApsDecision);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void resetWhenCaptureFail() {
        super.resetWhenCaptureFail();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$IntrinsicsJvm.kt_5$19iBhqhD5oPK5U7BWQ2wrzx52H8
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.lambda$resetWhenCaptureFail$1$IntrinsicsJvm.kt_5();
                }
            });
        }
    }

    public /* synthetic */ void lambda$resetWhenCaptureFail$1$IntrinsicsJvm.kt_5() {
        if (this.mbPaused) {
            return;
        }
        this.mbCaptureRawTimeDone = true;
        this.mCameraUIInterface.mo18200d(true, false);
        resetAfterPictureTaken(isInNightProcess(), this.mbBurstShot);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getIsCapturingState() {
        return super.getIsCapturingState() || !this.mbCaptureRawTimeDone;
    }
}
