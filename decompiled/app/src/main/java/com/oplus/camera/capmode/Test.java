package com.oplus.camera.capmode;

/* compiled from: CommonCapMode.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.capmode.BaseMode {
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
    private static final java.lang.String TAG = "CommonCapMode";
    private static final long UPDATE_COUNTDOWN_TIME_DELAY = 100;
    private com.oplus.camera.d_renamed.b_renamed mBeauty3DManager;
    private long mBeauty3DScanTime;
    private int mBurstCaptureBufferLostNum;
    private long mCaptureStartTime;
    private android.util.Size mChangePreviewSize;
    private long mCountDownTemp;
    private long mFirstExposureTime;
    private com.oplus.camera.ui.RotateImageView mGoogleLensIcon;
    private boolean mGoogleLensShouldShow;
    private android.util.Size mLastPreviewSize;
    private com.google.lens.sdk.LensApi mLensApi;
    private com.oplus.camera.ui.control.b_renamed mMainShutterButtonInfo;
    private com.oplus.camera.capmode.d_renamed.a_renamed mMemoryManager;
    private com.oplus.camera.statistics.model.ReminderMsgData mMsgData;
    private android.os.Handler mMyHandler;
    protected int mNightAlgoTriggeredStep;
    protected long mNightCaptureTotalTime;
    private int mNightClosedCounter;
    protected com.oplus.camera.ui.p_renamed mNightCountDownUI;
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
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_FACEBEAUTY_LEVEL_MENU;
    }

    protected int getHighPictureSizeHint() {
        return com.oplus.camera.R_renamed.string.camera_picture_size_standard_high_hint;
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

    public d_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
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
        this.mMemoryManager = new com.oplus.camera.capmode.d_renamed.a_renamed();
        this.mMyHandler = null;
        this.mSaveFilterIndexBeforeBurstShot = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
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
        this.mNowRearEffectIndex = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
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
        com.oplus.camera.e_renamed.a_renamed(TAG, "onInitCameraMode");
        com.oplus.camera.capmode.d_renamed.a_renamed aVar = this.mMemoryManager;
        if (aVar != null) {
            aVar.a_renamed();
        }
        if (this.mNightCountDownUI == null) {
            this.mNightCountDownUI = new com.oplus.camera.ui.p_renamed(this.mCameraUIInterface, new com.oplus.camera.ui.h_renamed.a_renamed() { // from class: com.oplus.camera.capmode.d_renamed.1
                @Override // com.oplus.camera.ui.h_renamed.a_renamed
                public void a_renamed(boolean z_renamed) {
                    com.oplus.camera.capmode.d_renamed.this.onTimerCountDownEnd();
                }

                @Override // com.oplus.camera.ui.h_renamed.a_renamed
                public void a_renamed() {
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "updateCountDownTime");
                    if (com.oplus.camera.capmode.d_renamed.this.mbPaused) {
                        return;
                    }
                    com.oplus.camera.capmode.d_renamed.this.mNightCountDownUI.e_renamed();
                }
            });
        }
        if (this.mMyHandler == null) {
            this.mMyHandler = new android.os.Handler() { // from class: com.oplus.camera.capmode.d_renamed.10
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    int i_renamed = message.what;
                    if (i_renamed == 1) {
                        com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "handleMessage, MSG_CODE_HIDE_PICTURE_NUM");
                        if (com.oplus.camera.capmode.d_renamed.this.mbPaused) {
                            return;
                        }
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.e_renamed(true, false);
                        if (com.oplus.camera.capmode.d_renamed.this.mCameraInterface != null && !com.oplus.camera.capmode.d_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_EXPAND_POPBAR)) {
                            com.oplus.camera.capmode.d_renamed.this.mCameraInterface.a_renamed(true, false);
                        }
                        if (com.oplus.camera.capmode.d_renamed.this.mCameraInterface != null && !com.oplus.camera.capmode.d_renamed.this.mCameraInterface.A_renamed() && com.oplus.camera.capmode.d_renamed.this.supportBeautyButton()) {
                            com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.l_renamed(true, false);
                            com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.v_renamed(true);
                        }
                        com.oplus.camera.capmode.d_renamed.this.displayScreenHintIconInSwitchOn();
                        return;
                    }
                    if (i_renamed == 4) {
                        if (com.oplus.camera.capmode.d_renamed.this.mbPaused) {
                            return;
                        }
                        com.oplus.camera.capmode.d_renamed.this.mCameraInterface.e_renamed(18);
                        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                            return;
                        }
                        com.oplus.camera.capmode.d_renamed dVar = com.oplus.camera.capmode.d_renamed.this;
                        dVar.mbFlashTemporaryDisabled = true;
                        dVar.updateFlashState("off");
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                        if (1 == message.arg1) {
                            com.oplus.camera.capmode.d_renamed.this.reportMicroShowReminderToDcs();
                            return;
                        }
                        return;
                    }
                    if (i_renamed == 5 && !com.oplus.camera.capmode.d_renamed.this.mbPaused) {
                        com.oplus.camera.capmode.d_renamed.this.mCameraInterface.e_renamed(0);
                        com.oplus.camera.capmode.d_renamed dVar2 = com.oplus.camera.capmode.d_renamed.this;
                        if (!dVar2.withinSatMainRange(dVar2.getZoomValue()) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                            return;
                        }
                        com.oplus.camera.capmode.d_renamed dVar3 = com.oplus.camera.capmode.d_renamed.this;
                        dVar3.mbFlashTemporaryDisabled = false;
                        dVar3.updateFlashState(dVar3.getFlashMode());
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                    }
                }
            };
        }
        this.mbSupportNightPictureTime = true;
        this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_common_shutter_button));
        initBeauty3DManager();
        setBurstShotCapturing(false);
        this.mReceivedPreviewResultNum = 0;
        this.mGoogleLensShouldShow = true;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences.contains(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
            this.mbForbidPreferenceChange = true;
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
            this.mbForbidPreferenceChange = false;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            com.oplus.camera.ui.preview.a_renamed.j_renamed.c_renamed();
        }
        updateNowRearEffectIndex();
    }

    protected void onTimerCountDownEnd() {
        if (this.mbDestroyed) {
            return;
        }
        if (!isInNightProProcess() || !isNightProSoundPlayed()) {
            this.mCameraInterface.c_renamed(0);
        }
        this.mbCaptureRawTimeDone = true;
        if (this.mbNightJpegDone || isInOfflineNightProcess()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onTimerCountDownEnd, resetAfterPictureTaken");
            this.mCameraUIInterface.d_renamed(true, false);
            resetAfterPictureTaken(true, this.mbBurstShot);
            return;
        }
        this.mbEnableUILater = true;
        com.oplus.camera.e_renamed.a_renamed(TAG, "onTimerCountDownEnd");
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
        int i_renamed = com.oplus.camera.util.Util.ao_renamed() ? 28 : 4;
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
        bVar.a_renamed("button_color_inside_none");
        bVar.a_renamed(i_renamed);
        this.mCameraUIInterface.a_renamed(bVar);
        this.mCameraUIInterface.a_renamed(false, false);
        restoreAllViews(false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBeauty3DManager() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && this.mBeauty3DManager == null) {
            this.mBeauty3DManager = new com.oplus.camera.d_renamed.b_renamed(this.mActivity, new com.oplus.camera.d_renamed.d_renamed() { // from class: com.oplus.camera.capmode.d_renamed.11
                @Override // com.oplus.camera.d_renamed.d_renamed
                public void a_renamed() {
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "onExitScan, beauty3D exit");
                    a_renamed(true);
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void b_renamed() {
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "onScanComplete, beauty3D scan Complete");
                    if (com.oplus.camera.capmode.d_renamed.this.mPreferences != null) {
                        android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.capmode.d_renamed.this.mPreferences.edit();
                        editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D, false);
                        editorEdit.apply();
                    }
                    com.oplus.camera.capmode.d_renamed.this.onBeauty3DChange(false);
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.oplus.camera.capmode.d_renamed.this.mBeauty3DScanTime;
                    if (jCurrentTimeMillis > 0) {
                        com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(com.oplus.camera.capmode.d_renamed.this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_BEAUTY3D, com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_SCAN_TIME, java.lang.String.valueOf(jCurrentTimeMillis)));
                    }
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void c_renamed() {
                    if (com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface != null) {
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.G_renamed();
                    }
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void d_renamed() {
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "onStartScan, open dual camera, Beauty3DState: " + com.oplus.camera.capmode.d_renamed.this.getBeauty3Dstatus());
                    com.oplus.camera.capmode.d_renamed.this.mBeauty3DScanTime = java.lang.System.currentTimeMillis();
                    int faceBeautyCurrIndex = com.oplus.camera.capmode.d_renamed.this.getFaceBeautyCurrIndex();
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "onStartScan, BeautyCurrIndex: " + faceBeautyCurrIndex);
                    if (faceBeautyCurrIndex == -1) {
                        com.oplus.camera.capmode.d_renamed dVar = com.oplus.camera.capmode.d_renamed.this;
                        dVar.createEffectTextures(dVar.mCameraUIInterface.I_renamed());
                    }
                    com.oplus.camera.ui.preview.a_renamed.o_renamed.b_renamed(com.oplus.camera.capmode.d_renamed.this.mActivity);
                    com.oplus.camera.capmode.d_renamed.this.onBeauty3DChange(false);
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void e_renamed() {
                    com.oplus.camera.capmode.d_renamed.this.onBeauty3DChange(false);
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void f_renamed() {
                    com.oplus.camera.ui.preview.a_renamed.o_renamed.b_renamed(com.oplus.camera.capmode.d_renamed.this.mActivity);
                    com.oplus.camera.capmode.d_renamed dVar = com.oplus.camera.capmode.d_renamed.this;
                    dVar.createEffectTextures(dVar.mCameraUIInterface.I_renamed());
                    if (com.oplus.camera.capmode.d_renamed.this.mPreferences != null) {
                        android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.capmode.d_renamed.this.mPreferences.edit();
                        editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D, true);
                        editorEdit.apply();
                    }
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void a_renamed(boolean z_renamed) {
                    if (com.oplus.camera.capmode.d_renamed.this.getBeauty3Dstatus() == 4) {
                        com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "onScanCancel, Beauty3DState == BEAUTY3D_STATE_SCAN_CANCEL, return");
                    } else if (z_renamed) {
                        com.oplus.camera.capmode.d_renamed.this.setBeauty3DState(4);
                        com.oplus.camera.capmode.d_renamed.this.onBeauty3DChange(false);
                    }
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void b_renamed(boolean z_renamed) {
                    if (z_renamed && com.oplus.camera.capmode.d_renamed.this.mPreferences != null) {
                        android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.capmode.d_renamed.this.mPreferences.edit();
                        editorEdit.putInt(com.oplus.camera.capmode.d_renamed.this.getFaceBeautyKey(), -1);
                        editorEdit.apply();
                    }
                    com.oplus.camera.capmode.d_renamed.this.onBeauty3DChange(z_renamed);
                }

                @Override // com.oplus.camera.d_renamed.d_renamed
                public void c_renamed(boolean z_renamed) {
                    if (com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface != null) {
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.p_renamed(z_renamed);
                    }
                }
            });
            this.mBeauty3DManager.a_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return getCurrentKeys(com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_CUSTOM_BEAUTY);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getMakeupKeys() {
        return getCurrentKeys(com.oplus.camera.ui.preview.a_renamed.g_renamed.f6897c);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getMakeupTypeKey() {
        return com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType) ? com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_MAKEUP_TYPE, this.mCameraEntryType) : com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_MAKEUP_TYPE;
    }

    protected void stopNightCountdownTime() {
        this.mNightCountDownUI.a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onEffectItemClick(int i_renamed) {
        com.oplus.camera.d_renamed.b_renamed bVar;
        if (1 != getBeauty3DScanIconType(i_renamed) || (bVar = this.mBeauty3DManager) == null) {
            return false;
        }
        bVar.k_renamed();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowingGuideView() {
        com.oplus.camera.d_renamed.b_renamed bVar;
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) || (bVar = this.mBeauty3DManager) == null) {
            return false;
        }
        return bVar.i_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setPIEnable(int i_renamed, boolean z_renamed) {
        if (this.mOneCamera == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "setPIEnable, code: " + i_renamed + ", enable: " + z_renamed);
        boolean z2 = this.mbSuperTextOpen;
        if (!this.mbBurstShot && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI) && 4 == i_renamed) {
            this.mbSuperTextOpen = z_renamed;
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.b_renamed(64);
            }
        } else {
            this.mbSuperTextOpen = false;
            if (12 == i_renamed && !this.mbNightCheckClosed && z_renamed) {
                this.mbNightCheckClosed = true;
                this.mOneCamera.o_renamed(0);
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                this.mNightClosedCounter++;
            }
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.k_renamed(this.mbSuperTextOpen);
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT) && z2 && !this.mbSuperTextOpen) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "setPIEnable, clear SuperText!");
            this.mCameraUIInterface.a_renamed((com.oplus.camera.u_renamed.a_renamed) null);
        }
        if (18 == i_renamed) {
            this.mOneCamera.B_renamed(z_renamed);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        } else {
            this.mOneCamera.p_renamed(this.mCameraUIInterface.aa_renamed());
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMonoIndex(int i_renamed) {
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_SUPPORT) || 1 == com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE)) {
            return false;
        }
        return i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed() || i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed() || i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed() || i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.k_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAISceneClosed(int i_renamed) {
        if (i_renamed != 12 || this.mbNightCheckClosed) {
            return;
        }
        this.mbNightCheckClosed = true;
        if (this.mOneCamera != null) {
            this.mOneCamera.o_renamed(0);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        this.mNightClosedCounter++;
    }

    public boolean getBeauty3DConfigured() {
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null) {
            return bVar.g_renamed();
        }
        return false;
    }

    public void showBeauty3DView() {
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar == null) {
            return;
        }
        int iF = bVar.f_renamed();
        com.oplus.camera.e_renamed.a_renamed(TAG, "updateBeauty3DView, type: " + iF);
        if (iF == 1) {
            this.mBeauty3DManager.h_renamed();
            return;
        }
        if (iF != 10) {
            if (iF == 6 || iF == 7) {
                this.mBeauty3DManager.a_renamed(1, new android.util.Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080));
                return;
            } else if (iF != 8) {
                return;
            }
        }
        this.mBeauty3DManager.a_renamed(2, new android.util.Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getBeauty3DScanIconType(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "getBeauty3DScanIconType, effectIndex: " + i_renamed);
        int iA = com.oplus.camera.ui.preview.a_renamed.o_renamed.a_renamed(this.mActivity);
        if (i_renamed != 0 || !"beauty".equals(getCurrEffectMenuName()) || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) || iA != 0) {
            return (i_renamed == 0 && "beauty".equals(getCurrEffectMenuName()) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && iA == 1) ? 2 : 0;
        }
        this.mCameraUIInterface.f_renamed(6, true);
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size decreasedSizeForThirdApp;
        if (getBeauty3Dstatus() == 2 || getBeauty3Dstatus() == 1) {
            return new android.util.Size(BEAUTY3D_SCAN_PIC_SIZE_W, BEAUTY3D_SCAN_PIC_SIZE_H);
        }
        if (getBeauty3Dstatus() == 6 || getBeauty3Dstatus() == 7 || getBeauty3Dstatus() == 8 || getBeauty3Dstatus() == 9) {
            return new android.util.Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080);
        }
        if (this.mCameraInterface == null) {
            return null;
        }
        return (this.mbDestroyed || this.mCameraInterface.i_renamed() || (decreasedSizeForThirdApp = getDecreasedSizeForThirdApp(hVar)) == null) ? super.getPictureSize(hVar) : decreasedSizeForThirdApp;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size previewSize = super.getPreviewSize(hVar);
        this.mLastPreviewSize = previewSize;
        if ((com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) && this.mbFrontCamera && getFaceBeautyCurrIndex() != 0) || ((com.oplus.camera.e_renamed.a_renamed.h_renamed() == this.mCameraId && (this.mCameraUIInterface.K_renamed() || getFaceBeautyCurrIndex() != 0)) || com.oplus.camera.e_renamed.a_renamed.j_renamed() == getProperCameraId(this.mCameraId))) {
            this.mChangePreviewSize = getFaceBeautyPreviewSize();
            android.util.Size size = this.mChangePreviewSize;
            if (size != null) {
                previewSize = size;
            }
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "getPreviewSize, previewSize: " + previewSize + ", mLastPreviewSize: " + this.mLastPreviewSize + ", mChangePreviewSize: " + this.mChangePreviewSize);
        int beauty3Dstatus = getBeauty3Dstatus();
        if (beauty3Dstatus != 0 && beauty3Dstatus != 4) {
            return new android.util.Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, 1080);
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MAKEUP_LOW_PERFORMANCE) || !isMakeupOpen()) {
            return previewSize;
        }
        double targetPreviewRatio = getTargetPreviewRatio(hVar);
        if (java.lang.Double.compare(targetPreviewRatio, 1.3333333333333333d) == 0) {
            return new android.util.Size(com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT);
        }
        if (java.lang.Double.compare(targetPreviewRatio, 1.0d) == 0) {
            return new android.util.Size(com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960, com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960);
        }
        if (java.lang.Double.compare(targetPreviewRatio, 1.7777777777777777d) == 0) {
            return new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT);
        }
        return new android.util.Size(1600, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getZoomAutoMicroOpen() {
        return this.mbAutoMicroOpen;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (this.mCameraInterface != null && !this.mCameraInterface.i_renamed() && this.mApsBracketMode <= 0 && com.oplus.camera.util.Util.C_renamed()) {
            return true;
        }
        if (com.oplus.camera.util.Util.C_renamed() && this.mDecisionResult != null && 28 == this.mDecisionResult.mApsDecisionFeatureType && 17 == this.mDecisionResult.mApsBracketMode) {
            return true;
        }
        if (!this.mbFrontCamera || !com.oplus.camera.util.Util.C_renamed() || !isFaceBeautyOrMakeupOpen() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZSL_SUPPORT_PREVERSION) || this.mDecisionResult == null || 4 == this.mDecisionResult.mApsDecisionFeatureType || 24 == this.mDecisionResult.mApsDecisionFeatureType || 5 == this.mDecisionResult.mApsDecisionFeatureType) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onDeInitCameraMode");
        this.mCameraUIInterface.w_renamed(true);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.micro_lens_mode_toast);
        this.mbNightCheckClosed = false;
        this.mReceivedRawResultNum = 0;
        this.mReceivedPreviewResultNum = 0;
        this.mbAutoMicroOpen = false;
        this.mGoogleLensShouldShow = false;
        this.mbCheckTakeAnimateDelay = false;
        this.mbTakeAnimateDelay = false;
        android.os.Handler handler = this.mMyHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MTK_INSENSOR_ZOOM)) {
                this.mOneCamera.r_renamed(0);
            }
        }
        updateFaceBeautyLevel(0, false);
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.g_renamed(0);
        }
        this.mCameraUIInterface.e_renamed(false, false);
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D)) {
            this.mCameraUIInterface.f_renamed(6, false);
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.f_renamed(5, false);
        }
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null) {
            bVar.c_renamed();
        }
        if (isUltraWideHighPictureSize() && this.mPreferences != null) {
            this.mbForbidPreferenceChange = true;
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
            this.mbForbidPreferenceChange = false;
        }
        if (this.mPreferences != null && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE, true)) {
            this.mCameraUIInterface.f_renamed(9, true);
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_BEAUTY_TIPS)) {
            this.mCameraUIInterface.f_renamed(17, true);
        }
        if (this.mPreferences != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && this.mbFirstEffectMenuOpened) {
            this.mPreferences.edit().putString(getFilterEffectPrevSelectedKey(), getCurrFilterType()).apply();
        }
        this.mCameraUIInterface.l_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHighPictureSize() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE) || this.mPreferences == null) {
            return false;
        }
        return this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isUltraWideHighPictureSize() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences != null && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false) && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFaceRectifyMenuOpen() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY)) {
            java.lang.String configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_RECTIFY_CONFIG_VALUE);
            if (android.text.TextUtils.isEmpty(configStringValue)) {
                configStringValue = this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_face_rectify_default_value);
            }
            if (this.mPreferences != null) {
                configStringValue = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_RECTIFY, configStringValue);
            }
            return "on_renamed".equals(configStringValue);
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
        return java.lang.Float.compare(zoomValue, getMinZoomValue()) == 0 || java.lang.Float.compare(zoomValue, 1.0f) == 0 || (this.mbFrontCamera && java.lang.Float.compare(zoomValue, 1.17f) == 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        if (com.oplus.camera.util.Util.ao_renamed()) {
            if (this.mCameraUIInterface.s_renamed() == 28 || this.mCameraUIInterface.s_renamed() == 29 || this.mCameraUIInterface.s_renamed() == 26) {
                shutterButtonInfo.a_renamed(26);
            } else {
                shutterButtonInfo.a_renamed(23);
            }
        }
        return shutterButtonInfo;
    }

    protected boolean isNeedResetNoneSatWide() {
        return isNoneSatUltraWideAngleOpen() && isHighPictureSize();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.d_renamed.b_renamed bVar;
        com.oplus.camera.e_renamed.f_renamed(TAG, "onResume");
        if (((android.app.KeyguardManager) this.mActivity.getApplicationContext().getSystemService("keyguard")).isKeyguardLocked()) {
            this.mbDisplayOnLock = true;
        }
        if (this.mbDisplayOnLock) {
            resetMonoFilter();
        }
        updateNowRearEffectIndex();
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && (bVar = this.mBeauty3DManager) != null && bVar.f_renamed() != 0) {
            this.mBeauty3DManager.a_renamed(new android.util.Size(BEAUTY3D_SCAN_PREVIEW_SIZE_W, BEAUTY3D_SCAN_PIC_SIZE_H));
        }
        if (isNeedResetNoneSatWide()) {
            this.mCameraInterface.c_renamed(true);
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            this.mCameraInterface.c_renamed(false);
        }
        com.google.lens.sdk.LensApi lensApi = this.mLensApi;
        if (lensApi != null) {
            try {
                lensApi.onResume();
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
            setGoogleLensIconClickable(true);
        } else {
            hideGoogleLensIcon(false);
        }
        if (this.mbShowSteadyTips) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_process_image_after_capture);
            this.mbShowSteadyTips = false;
            this.mNightAlgoTriggeredStep = 0;
        }
        if (this.mbShowImageOptimizingTips) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_image_optimizing_tips_oplus_r);
            this.mbShowImageOptimizingTips = false;
            this.mNightAlgoTriggeredStep = 0;
        }
        this.mCameraUIInterface.g_renamed(false);
        this.mCameraUIInterface.c_renamed(8, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        com.oplus.camera.e_renamed.f_renamed(TAG, "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onGetNearMeOnClickData() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i_renamed = this.mNightClosedCounter;
        if (i_renamed > 0) {
            java.lang.String str = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.NIGHT_CLOSED_NUM, java.lang.String.valueOf(i_renamed));
            this.mNightClosedCounter = 0;
            sb.append(str);
        }
        if (sb.length() > 0) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) ? null : (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS) && isAISceneOpen()) {
            captureMsgData.mNightState = getNightStateDecision();
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_AUTO_MICRO)) {
            captureMsgData.mIsMacro = java.lang.String.valueOf(this.mbAutoMicroOpen ? 1 : 0);
        }
        if (this.mbFrontCamera) {
            captureMsgData.mScreenHighLight = sHighBrightness ? "on_renamed" : "off";
        }
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        return dcsMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void saveAndClearEffectBeforeBurstShot() {
        this.mSaveFilterIndexBeforeBurstShot = getCurrFilterIndex();
        this.mSaveBeautyIndexBeforeBurstShot = getFaceBeautyCurrIndex();
        onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        onFaceBeautyItemChange(0);
        updateEffectMenuNames();
        this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
        this.mCameraUIInterface.j_renamed(0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null) {
            bVar.a_renamed(this.mOneCamera);
        }
        super.onSessionConfigured();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void restoreEffectAfterBurstShot() {
        onFilterItemChange(this.mSaveFilterIndexBeforeBurstShot);
        onFaceBeautyItemChange(this.mSaveBeautyIndexBeforeBurstShot);
        updateEffectMenuNames();
        this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
        this.mCameraUIInterface.j_renamed(this.mSaveBeautyIndexBeforeBurstShot);
    }

    private void resetPIModeAfterCapture() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI) || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI)) {
            return;
        }
        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI, (java.lang.String) null);
        onPIChanged(false, isPIModeOpen(), false, true);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:221:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:428:0x05b7  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.d_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_PI.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(strD)) {
            return getSupportFunction(strD);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strD)) {
            return this.mbFrontCamera || com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntry.J_renamed());
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(strD)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(strD)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        }
        return super.getSupportMenu(strD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(strD)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strD)) {
            return !this.mbFrontCamera;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(strD)) {
            return getSupportFunction(strD);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD)) {
            return !com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(strD)) {
            return getSupportFunction(strD);
        }
        return super.getSupportSubMenu(strD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowBeauty3D() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && getBeauty3Dstatus() > 0 && getBeauty3Dstatus() != 4;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI)) {
            boolean zEquals = "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_pi_ai_default_value)));
            if (this.mPreferences != null) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN, zEquals ? "on_renamed" : "off").apply();
            }
            onPIChanged(this.mbBurstShot, zEquals, true, true);
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PI.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI)) {
            onPIChanged(this.mbBurstShot, "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI, "off")), true, true);
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE.equals(str) && !this.mbForbidPreferenceChange) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && this.mPreferences != null) {
                if (isUltraWideHighPictureSize() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                    this.mbFlashTemporaryDisabled = true;
                    updateFlashState("off");
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                } else {
                    this.mbFlashTemporaryDisabled = false;
                    updateFlashState(getFlashMode());
                }
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.au_renamed();
                return;
            }
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
            if (isUltraWideHighPictureSize() && this.mPreferences != null) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
                this.mbForbidPreferenceChange = false;
            }
            if (isAISceneOpen()) {
                this.mCameraUIInterface.l_renamed(true);
                return;
            }
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(str)) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences != null && "standard_high".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard_high"))) {
                if (java.lang.Float.compare(getZoomValue(), 1.0f) < 0) {
                    this.mbForbidPreferenceChange = true;
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "on_renamed").apply();
                    this.mbForbidPreferenceChange = false;
                } else {
                    this.mbForbidPreferenceChange = true;
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
                    this.mbForbidPreferenceChange = false;
                }
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences != null && "standard".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard"))) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
                this.mbForbidPreferenceChange = false;
            }
            if (this.mPreferences != null && !"standard".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard")) && "auto".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "auto"))) {
                android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_MACRO_SWITCH, "auto");
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "off");
                editorEdit.apply();
            }
            if (this.mPreferences != null && "standard".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard")) && this.mPreferences.contains(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_MACRO_SWITCH)) {
                if (!"auto".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "auto")) && "auto".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_MACRO_SWITCH, "auto"))) {
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "auto").apply();
                }
                this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_MACRO_SWITCH).apply();
            }
            if (this.mPreferences == null || !isMonoIndex(getCurrFilterIndex()) || "standard".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard"))) {
                return;
            }
            onHighResolution();
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            if (this.mPreferences == null || !"auto".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "auto")) || "standard".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard"))) {
                return;
            }
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard").apply();
            if (this.mPreferences.contains(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_MACRO_SWITCH)) {
                this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_MACRO_SWITCH).apply();
                return;
            }
            return;
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closePIBeforeCapture() {
        if (isPIModeOpen()) {
            if (!com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(getFlashMode())) {
                this.mCameraUIInterface.a_renamed(false, true, true);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
                return;
            }
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI, "off");
            onPIChanged(this.mbBurstShot, false, false, true);
        }
    }

    public void onPIChanged(boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onPIChanged, isOpen: " + z2 + ", isBurstShot: " + z_renamed + ", isShowHint: " + z3 + ", isUpdateParam: " + z4);
        if (z_renamed) {
            return;
        }
        int i_renamed = com.oplus.camera.R_renamed.string.camera_pi_off_hint;
        if (z2) {
            if (z3 && (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI) || this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI))) {
                boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI);
                int i2 = configBooleanValue ? com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_hint_on : com.oplus.camera.R_renamed.string.camera_pi_on_hint;
                com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
                if (configBooleanValue) {
                    i_renamed = com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_hint_off;
                }
                cameraUIInterface.a_renamed(i_renamed);
                this.mCameraUIInterface.a_renamed(i2, -1, true, false, false);
            }
            onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
            if (this.mCameraUIInterface.A_renamed() && com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.s_renamed(true);
                this.mCameraInterface.a_renamed(true, false);
                this.mCameraInterface.d_renamed(true);
            } else {
                this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
            }
            if (this.mCameraUIInterface.K_renamed()) {
                this.mCameraUIInterface.a_renamed(true, true, true, true);
            }
            this.mCameraUIInterface.r_renamed(true);
            return;
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
            if (z3) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_pi_off_hint), -1, true, false, false);
                return;
            }
            return;
        }
        this.mbSuperTextOpen = false;
        this.mCameraUIInterface.a_renamed((com.oplus.camera.u_renamed.a_renamed) null);
        this.mCameraUIInterface.l_renamed(true);
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.k_renamed(false);
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT)) {
            this.mCameraUIInterface.a_renamed((com.oplus.camera.u_renamed.a_renamed) null);
        }
        if (z3) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_zoom_not_support);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_hint_off, -1, true, false, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed(TAG, "onCameraIdChanged");
        super.cameraIdChanged(i_renamed);
        this.mbNightCheckClosed = false;
        this.mReceivedRawResultNum = 0;
        this.mbCheckTakeAnimateDelay = false;
        this.mbTakeAnimateDelay = false;
        updateNowRearEffectIndex();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.12
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.capmode.d_renamed.this.initBeauty3DManager();
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.d_renamed.b_renamed bVar;
        com.oplus.camera.e_renamed.a_renamed(TAG, "onPause, mbBurstShot: " + this.mbBurstShot);
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
            this.mCameraUIInterface.g_renamed(0);
        }
        this.mbTripodNight = false;
        android.os.Handler handler = this.mMyHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mCameraUIInterface.w_renamed();
        this.mCameraUIInterface.e_renamed(false, false);
        this.mCameraUIInterface.g_renamed(false);
        this.mCameraUIInterface.c_renamed(8, false);
        this.mbNightCheckClosed = false;
        this.mReceivedRawResultNum = 0;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && (bVar = this.mBeauty3DManager) != null) {
            bVar.b_renamed();
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D) && this.mCameraUIInterface.A_renamed()) {
            this.mCameraUIInterface.f_renamed(6, true);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.f_renamed(5, true);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && this.mbFirstEffectMenuOpened) {
            this.mPreferences.edit().putString(getFilterEffectPrevSelectedKey(), getCurrFilterType()).apply();
        }
        if (this.mCameraInterface != null && !this.mCameraInterface.at_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE) && this.mPreferences.contains(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE)) {
            this.mbForbidPreferenceChange = true;
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off").apply();
            this.mbForbidPreferenceChange = false;
        }
        com.google.lens.sdk.LensApi lensApi = this.mLensApi;
        if (lensApi != null) {
            try {
                lensApi.onPause();
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        if (isAISceneOpen()) {
            this.mCameraUIInterface.l_renamed(true);
        }
        pauseNightCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getGrandTourFilterKey(java.lang.String str) {
        if (this.mbFrontCamera) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "getGrandTourFilterKey, Front camera. Ignore");
            return false;
        }
        if (!com.oplus.camera.ui.preview.a_renamed.j_renamed.f6906b.equalsIgnoreCase(com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_NONE)) {
            java.util.ArrayList<java.lang.String> arrayListA = com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6906b);
            if (arrayListA == null) {
                com.oplus.camera.e_renamed.e_renamed(TAG, "getGrandTourFilterKey, No grand filter for " + com.oplus.camera.ui.preview.a_renamed.j_renamed.f6906b + " city.");
                return false;
            }
            for (int i_renamed = 0; i_renamed < arrayListA.size(); i_renamed++) {
                if (str.equals(arrayListA.get(i_renamed))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateGrandTourCityFiltersPosition(java.lang.String str) {
        if (str == null) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "updateGrandTourCityFiltersPosition, City is_renamed null. Ignore!");
            return;
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "updateGrandTourCityFiltersPosition, City : " + str);
        java.lang.String string = this.mPreferences.getString(getFilterEffectPrevSelectedKey(), null);
        if (string == null) {
            if (this.mbFirstEffectMenuOpened) {
                this.mPreferences.edit().putString(getFilterEffectPrevSelectedKey(), getCurrFilterType()).apply();
                string = getCurrFilterType();
            } else {
                string = "default";
            }
        }
        com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(str);
        onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(string, this.mCameraId));
        super.updateGrandTourCityFiltersPosition(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetFiltersList() {
        com.oplus.camera.e_renamed.b_renamed(TAG, "resetFilterList() - Grand tour filters");
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
            java.lang.String currFilterType = getCurrFilterType();
            if (com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE_OTHER_APP.equals(getFilterEffectPrevSelectedKey())) {
                currFilterType = this.mPreferences.getString(getFilterEffectPrevSelectedKey(), "default");
            }
            com.oplus.camera.ui.preview.a_renamed.j_renamed.f_renamed();
            onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(currFilterType, this.mCameraId));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onDestroy");
        this.mMemoryManager = null;
        com.oplus.camera.statistics.model.ReminderMsgData reminderMsgData = this.mMsgData;
        if (reminderMsgData != null) {
            reminderMsgData.destroy();
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D)) {
            this.mCameraUIInterface.f_renamed(6, false);
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.f_renamed(5, false);
        }
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null) {
            bVar.r_renamed();
            this.mBeauty3DManager = null;
        }
        resetMonoFilter();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.d_renamed.b_renamed bVar;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && (bVar = this.mBeauty3DManager) != null && bVar.d_renamed()) {
            return true;
        }
        if (this.mbInBurstShotCapturing) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onBackPressed, mbInBurstShotCapturing: " + this.mbInBurstShotCapturing);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        if (2 == this.mCameraEntry.J_renamed()) {
        }
        return "key_filter_index";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectPrevSelectedKey() {
        return 2 == this.mCameraEntry.J_renamed() ? com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE_OTHER_APP : com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        if (2 == this.mCameraEntry.J_renamed()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.q_renamed.b_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        if (1 == getCurFilterListType()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.l_renamed.d_renamed;
        }
        return super.getFilterNameIdList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            com.oplus.camera.ui.preview.a_renamed.j_renamed.c_renamed();
        }
        updateNowRearEffectIndex();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        if (2 == this.mCameraEntry.J_renamed()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.q_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        if (1 == getCurFilterListType()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.l_renamed.f6903b;
        }
        return super.getFilterTypeList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        if (isPIModeOpen() || isShowBeauty3D()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "getCurrFilterIndex, no filter");
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        }
        return super.getCurrFilterIndex();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurFilterListType() {
        if (this.mPreferences == null) {
            return 0;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FUJI_FILTER_MENU)) {
            return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_LIST_TYPE, 0);
        }
        return super.getCurFilterListType();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int i_renamed) {
        if (isPIModeOpen() && i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
            forceClosePIEffect();
        }
        int currFilterIndex = super.getCurrFilterIndex();
        if (!this.mbFrontCamera && (isMonoIndex(currFilterIndex) || isMonoIndex(i_renamed))) {
            this.mbShowBlurAnim = true;
        } else {
            this.mbShowBlurAnim = false;
        }
        if (isHighPictureSize() && isMonoIndex(i_renamed)) {
            forceCloseHighResolution();
        }
        if (1 == getCurFilterListType()) {
            updateFujiFilterHint(getFilterType(i_renamed));
        }
        if (!this.mbFrontCamera && currFilterIndex != i_renamed) {
            if (this.mbShowBlurAnim) {
                if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_LOGIC_ID_IS_SAT)) {
                    this.mCameraInterface.X_renamed();
                } else if (!this.mbInBurstShotCapturing && !this.mbBurstShot && !this.mbHighResolutionChangeRatio) {
                    this.mCameraInterface.g_renamed(isMonoIndex(i_renamed));
                }
                this.mCameraUIInterface.a_renamed(true, false, true);
            }
            this.mNowRearEffectIndex = i_renamed;
        }
        super.onFilterItemChange(i_renamed);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0049  */
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
            r6.a_renamed(r7, r8, r9, r10, r11)
            goto L9b
        L64:
            com.oplus.camera.ui.CameraUIInterface r0 = r12.mCameraUIInterface
            r1 = 2131755252(0x7f1000f4, float:1.9141378E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.a_renamed(r1, r2, r3, r4, r5)
            goto L9b
        L71:
            com.oplus.camera.ui.CameraUIInterface r6 = r12.mCameraUIInterface
            r7 = 2131755190(0x7f1000b6, float:1.9141252E38)
            r8 = -1
            r9 = 1
            r10 = 0
            r11 = 0
            r6.a_renamed(r7, r8, r9, r10, r11)
            goto L9b
        L7e:
            com.oplus.camera.ui.CameraUIInterface r0 = r12.mCameraUIInterface
            r1 = 2131756172(0x7f10048c, float:1.9143244E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.a_renamed(r1, r2, r3, r4, r5)
            goto L9b
        L8b:
            com.oplus.camera.ui.CameraUIInterface r6 = r12.mCameraUIInterface
            r7 = 2131755129(0x7f100079, float:1.9141129E38)
            r8 = -1
            r9 = 1
            r10 = 0
            r11 = 0
            r6.a_renamed(r7, r8, r9, r10, r11)
            goto L9b
        L98:
            r12.hideAllFujiHint()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.d_renamed.updateFujiFilterHint(java.lang.String):void");
    }

    private void hideAllFujiHint() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_acros_film_description);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_velvia_film_description);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_astic_film_description);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_classic_chrome_film_description);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_provoa_film_description);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterListTypeChanged(int i_renamed) {
        this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_LIST_TYPE, i_renamed).apply();
        onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateFilterParam(int i_renamed) {
        if (isPIModeOpen() && i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
            forceClosePIEffect();
        }
        super.updateFilterParam(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(com.oplus.camera.e_renamed.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        super.updateCaptureParam(cVar);
        if (this.mbOcclusion && isMonoIndex(getCurrFilterIndex()) && this.mOneCamera != null) {
            this.mOneCamera.a_renamed("default", isFilterOpen("default"), false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBeforePreview");
        this.mbSuperTextOpen = false;
        this.mbAutoMicroOpen = false;
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT_GPU_PROCESS) && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.k_renamed(isSuperTextOpen());
        }
        applyBeautyParam();
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null && bVar.f_renamed() > 0) {
            this.mBeauty3DManager.b_renamed(this.mOneCamera);
        }
        setTiltShiftPreview();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return isShowBeauty3D();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (isMonoIndex(getCurrFilterIndex())) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.MONO_FILTER_TYPE, com.oplus.ocs.camera.CameraParameter.MonoFilterType.BLACK_WHITE);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUpdateCameraSettingMenu() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            updateMenuWithMono(isMonoIndex(getCurrFilterIndex()));
        }
        super.onUpdateCameraSettingMenu();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(java.lang.String str) {
        if (isMonoIndex(getCurrFilterIndex()) && com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH)) {
            return false;
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    public boolean shouldShowSteadyTips() {
        com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision;
        boolean zIsInNightProcess = isInNightProcess();
        boolean z_renamed = zIsInNightProcess && isTripodNight();
        boolean zIsInNightProProcess = isInNightProProcess();
        synchronized (this.mApsDecisionResultLock) {
            cameraApsDecision = this.mDecisionResult;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("shouldShowSteadyTips, isInNightProcess: ");
        sb.append(zIsInNightProcess);
        sb.append(", isTripodNight: ");
        sb.append(z_renamed);
        sb.append(", mbBurstShot: ");
        sb.append(this.mbBurstShot);
        sb.append(", mbSceneNight: ");
        sb.append(this.mbSceneNight);
        sb.append(", mSupportCaptureZoomFeature: ");
        sb.append(cameraApsDecision == null ? null : java.lang.Integer.valueOf(cameraApsDecision.mSupportCaptureZoomFeature));
        sb.append(", mRequestNum: ");
        sb.append(this.mbBurstShot ? com.oplus.camera.util.Util.d_renamed : getDefaultCaptureNumber());
        sb.append(", isTripodModeOpened: ");
        sb.append(isTripodModeOpened());
        com.oplus.camera.e_renamed.a_renamed(TAG, sb.toString());
        if (this.mbBurstShot || isTripodModeOpened() || isSuperSeNightOpen()) {
            return false;
        }
        if ((this.mbSceneNight || zIsInNightProcess) && !z_renamed && !zIsInNightProProcess) {
            return true;
        }
        int defaultCaptureNumber = getDefaultCaptureNumber();
        return cameraApsDecision != null && 4 == cameraApsDecision.mSupportCaptureZoomFeature && (1 == defaultCaptureNumber || 3 <= defaultCaptureNumber) && this.mCameraInterface.i_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        this.mbCheckTakeAnimateDelay = this.mbFrontCamera;
        this.mbNightShutterCountDown = (!isInNightProcess() || isInNightProMode() || isSuperSeNightOpen()) ? false : true;
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBeforeSnapping, mbNightShutterCountDown: " + this.mbNightShutterCountDown);
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.13
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.d_renamed.this.mbPaused) {
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "onBeforeSnapping, return after pause");
                    return;
                }
                boolean zIsInNightProcess = com.oplus.camera.capmode.d_renamed.this.isInNightProcess();
                boolean z_renamed = zIsInNightProcess && com.oplus.camera.capmode.d_renamed.this.isTripodNight();
                boolean zIsInNightProProcess = com.oplus.camera.capmode.d_renamed.this.isInNightProProcess();
                if (com.oplus.camera.capmode.d_renamed.this.shouldShowSteadyTips()) {
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.k_renamed().g_renamed();
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_pro_fixed_tips_oplus_r);
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                    com.oplus.camera.capmode.d_renamed dVar = com.oplus.camera.capmode.d_renamed.this;
                    dVar.mbShowSteadyTips = true;
                    dVar.mbStopSteadyTips = false;
                    if (dVar.isNightAlgoCaptureTriggered()) {
                        if (!(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_AINIGHT_SUPPORT_NIGHT_PROCESS) && com.oplus.camera.capmode.d_renamed.this.isAISceneOpen() && 12 == com.oplus.camera.capmode.d_renamed.this.mCameraInterface.j_renamed())) {
                            com.oplus.camera.capmode.d_renamed.this.hideAllViewsExceptShutter();
                        }
                        com.oplus.camera.capmode.d_renamed.this.mNightAlgoTriggeredStep = 1;
                    }
                }
                if (com.oplus.camera.capmode.d_renamed.this.mbBurstShot && com.oplus.camera.capmode.d_renamed.this.mActivity != null && com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.l_renamed().equals(com.oplus.camera.capmode.d_renamed.this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_ai_scn_night))) {
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(true, false, true);
                }
                if (!com.oplus.camera.capmode.d_renamed.this.mbBurstShot && ((com.oplus.camera.capmode.d_renamed.this.mbSceneNight || zIsInNightProcess) && (!zIsInNightProcess || (!z_renamed && !zIsInNightProProcess && !com.oplus.camera.capmode.d_renamed.this.mbSupportNightPictureTime)))) {
                    if (com.oplus.camera.capmode.d_renamed.this.isSuperSeNightOpen()) {
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.d_renamed(false, false);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_image_optimizing_tips_oplus_r, -1, false, false, true);
                        com.oplus.camera.capmode.d_renamed.this.mbShowImageOptimizingTips = true;
                    }
                    if (com.oplus.camera.capmode.d_renamed.this.isSuperNightShutterCountDownOpen()) {
                        com.oplus.camera.capmode.d_renamed.this.startNightCaptureCountDown();
                    } else if (com.oplus.camera.capmode.d_renamed.this.isSuperSeNightOpen()) {
                        if (com.oplus.camera.capmode.d_renamed.this.mMainShutterButtonInfo == null) {
                            com.oplus.camera.capmode.d_renamed.this.mMainShutterButtonInfo = new com.oplus.camera.ui.control.b_renamed();
                        }
                        com.oplus.camera.capmode.d_renamed.this.mMainShutterButtonInfo.a_renamed("button_color_inside_none");
                        com.oplus.camera.capmode.d_renamed.this.mMainShutterButtonInfo.a_renamed(13);
                        com.oplus.camera.capmode.d_renamed.this.mMainShutterButtonInfo.c_renamed(4);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.d_renamed.this.mMainShutterButtonInfo);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.d_renamed(false, false);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.h_renamed(com.oplus.camera.capmode.d_renamed.this.mSeNightCostTime);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_image_optimizing_tips_oplus_r, -1, false, false, true);
                        com.oplus.camera.capmode.d_renamed.this.mbShowImageOptimizingTips = true;
                    } else {
                        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                        bVar.a_renamed("button_color_inside_none");
                        if (com.oplus.camera.util.Util.ao_renamed()) {
                            bVar.a_renamed(25);
                        } else {
                            bVar.a_renamed(4);
                        }
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(bVar);
                    }
                }
                if (com.oplus.camera.capmode.d_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && com.oplus.camera.capmode.d_renamed.this.mBeauty3DManager != null) {
                    if (com.oplus.camera.capmode.d_renamed.this.isShowBeauty3DEditChooseMenu()) {
                        com.oplus.camera.capmode.d_renamed.this.mBeauty3DManager.p_renamed();
                        com.oplus.camera.capmode.d_renamed.this.mBeauty3DManager.e_renamed(false);
                    } else {
                        com.oplus.camera.capmode.d_renamed.this.mBeauty3DManager.q_renamed();
                    }
                    java.lang.String torchMode = com.oplus.camera.capmode.d_renamed.this.getTorchMode();
                    if ((torchMode.equals("on_renamed") || torchMode.equals("auto")) && com.oplus.camera.capmode.d_renamed.this.mbFrontCamera && com.oplus.camera.capmode.d_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
                        com.oplus.camera.capmode.d_renamed.this.mBeauty3DManager.q_renamed();
                    }
                }
                if (com.oplus.camera.capmode.d_renamed.this.isGoogleLensEnable()) {
                    com.oplus.camera.capmode.d_renamed.this.setGoogleLensIconClickable(false);
                }
                if ((zIsInNightProcess || zIsInNightProProcess) && !com.oplus.camera.capmode.d_renamed.this.mbBurstShot) {
                    com.oplus.camera.capmode.d_renamed.this.closePIBeforeCapture();
                    if (z_renamed || com.oplus.camera.capmode.d_renamed.this.mbSupportNightPictureTime || zIsInNightProProcess) {
                        com.oplus.camera.capmode.d_renamed.this.hideAllViewsExceptShutter();
                        com.oplus.camera.capmode.d_renamed dVar2 = com.oplus.camera.capmode.d_renamed.this;
                        dVar2.mbCaptureRawTimeDone = false;
                        dVar2.mbNightJpegDone = false;
                        if (zIsInNightProProcess) {
                            return;
                        }
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.ab_renamed();
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady, -1, false, false, false);
                    }
                }
            }
        });
        if (com.oplus.camera.util.Util.C_renamed() && this.mCameraInterface.i_renamed()) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LOCK_AE_BEFORE_CAPTURE_SUPPORT) && this.mbFrontCamera) {
                this.mOneCamera.b_renamed(true, false);
                this.mbResetAeLockAfterCaptured = true;
            }
            if ((com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LOCK_AWB_BEFORE_CAPTURE_REAR_SUPPORT) && !isFlashRequired() && !isTorchMode()) || this.mbFrontCamera) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
                this.mbResetAwbLockAfterCaptured = true;
            }
            com.oplus.camera.e_renamed.b_renamed(TAG, "beforeSnapping, in_renamed QualcommPlatform front：" + this.mbFrontCamera + ", camera lock ae_renamed: " + this.mbResetAeLockAfterCaptured + " and awb: " + this.mbResetAwbLockAfterCaptured + ", CameraMode: " + getCameraMode());
        }
        if (cVar.Y_renamed) {
            if (isTripodNight()) {
                this.mOneCamera.t_renamed(2400);
            }
            this.mOneCamera.o_renamed(getNightStateDecision());
            if (!isInNightProMode()) {
                this.mOneCamera.a_renamed(1, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), false);
            }
            if (!isFlashRequired()) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
            }
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_FILTER_SUPPORT) && !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
                updateFilterParam(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
            }
            if (!this.mbAutoSeNight) {
                closeHdrAndFlashModeBeforeCapture();
            }
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MTK_FACE_BEAUTY_REMOSAIC_SUPPORT) && this.mbFrontCamera && isFaceBeautyOrMakeupOpen() && !isFilterEffectOpen()) {
            this.mOneCamera.q_renamed(1);
        } else if (isFaceBeautyOrMakeupOpen() || isFilterEffectOpen() || isPIModeOpen()) {
            this.mOneCamera.q_renamed(0);
        } else {
            this.mOneCamera.q_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_REMOSAIC_SUPPORT_DEFAULT_VALUE));
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MTK_INSENSOR_ZOOM)) {
            if (!com.oplus.camera.util.Util.C_renamed() && 4 == cVar.U_renamed) {
                this.mOneCamera.r_renamed(1);
            } else {
                this.mOneCamera.r_renamed(0);
            }
        }
        setCaptureRequestPictureSizeScale();
        boolean supportFunction = getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION_CANCEL_SNAPSHOT);
        if ((isSuperTextOpen() || isIdPhotoOpen() || supportFunction) && !this.mbBurstShot) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.14
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.d_renamed(false, false);
                    com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                    bVar.a_renamed("button_color_inside_none");
                    if (com.oplus.camera.util.Util.ao_renamed()) {
                        bVar.a_renamed(25);
                    } else {
                        bVar.a_renamed(4);
                    }
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(bVar);
                }
            });
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        if ((this.mbSceneNight || (isPIModeOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI))) && !this.mbFrontCamera) {
            if (z_renamed) {
                shutterButtonInfo.a_renamed(8);
                shutterButtonInfo.a_renamed("button_color_inside_none");
            } else {
                shutterButtonInfo.a_renamed(11);
                shutterButtonInfo.a_renamed("button_color_inside_none");
            }
        }
        this.mCameraUIInterface.a_renamed(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAISSnapshotChecked(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        if (com.oplus.camera.util.Util.C_renamed()) {
            return;
        }
        this.mOneCamera.u_renamed(cameraApsDecision.mbAIShutter);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCancelTakePicture() {
        com.oplus.camera.e_renamed.e_renamed(TAG, "onCancelTakePicture, reset mbShutterCallback");
        if (isGoogleLensEnable()) {
            setGoogleLensIconClickable(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.15
            @Override // java.lang.Runnable
            public void run() {
                if (!com.oplus.camera.capmode.d_renamed.this.mbPaused) {
                    com.oplus.camera.capmode.d_renamed.this.onUpdateCameraSettingMenu();
                }
                if (com.oplus.camera.capmode.d_renamed.this.isHighPictureSize() && !com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.R_renamed() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                    if (android.text.TextUtils.isEmpty(com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                        double displayHighPictureSize = com.oplus.camera.capmode.d_renamed.this.getDisplayHighPictureSize();
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.toast_ultra_wide_angel_lens);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.capmode.d_renamed.this.getHighPictureSizeHint(), com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Double.valueOf(displayHighPictureSize));
                    } else {
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_setting_menu_high_resolution_item, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
                    }
                } else {
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.d_renamed.this.getHighPictureSizeHint());
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.w_renamed(true);
                }
                if (com.oplus.camera.capmode.d_renamed.this.getSupportFunction(com.oplus.camera.aps.config.CameraFunction.GOOGLE_LENS)) {
                    com.oplus.camera.capmode.d_renamed.this.checkGoogleLensAvailability();
                }
            }
        });
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z_renamed) {
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
        if ("square".equals(string) || (com.oplus.camera.util.Util.t_renamed() && !com.oplus.camera.util.Util.u_renamed() && "standard".equals(string))) {
            com.oplus.camera.ui.inverse.e_renamed.INS.setPositionRatio(this.mActivity, com.oplus.camera.ui.inverse.InverseMaskView.getPositionRatioSquare(), z_renamed);
        } else if ("standard".equals(string) || "standard_high".equals(string)) {
            com.oplus.camera.ui.inverse.e_renamed.INS.setPositionRatio(this.mActivity, 0.5f, z_renamed);
        } else {
            com.oplus.camera.ui.inverse.e_renamed.INS.setPositionRatio(this.mActivity, 0.87f, z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onAfterSnapping()");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getReceiveBustShotNum() {
        return this.mReceivedSnapNum;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBurstShotCapture() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBurstShotCapture");
        this.mReceivedSnapNum = 0;
        this.mBurstCaptureBufferLostNum = 0;
        this.mMyHandler.removeMessages(1);
        this.mCameraInterface.a_renamed(true);
        if (!this.mbAutoMicroOpen) {
            closePIBeforeCapture();
        }
        getExif(null);
        if (com.oplus.camera.util.Util.C_renamed() && this.mOneCamera != null) {
            this.mOneCamera.l_renamed(true);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        if (isGoogleLensEnable()) {
            setGoogleLensIconClickable(false);
        }
        if (capture(false)) {
            return true;
        }
        disableBurstShot();
        if (this.mOneCamera != null) {
            this.mOneCamera.l_renamed(false);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        super.onShutterCallback(z_renamed, z2);
        if (z_renamed || !z2) {
            return;
        }
        if (!this.mbTakeAnimateDelay) {
            this.mCameraInterface.h_renamed();
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onShutterCallback, animateTakePicture delay");
        }
        if (!isInNightProcess()) {
            this.mCameraInterface.c_renamed(0);
        }
        if (isPIModeOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onShutterCallback, PIOpen");
            android.os.Handler handler = this.mMyHandler;
            if (handler != null) {
                handler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.oplus.camera.capmode.d_renamed.this.mbInCapturing) {
                            com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "pictureTakenCallback is_renamed already received, so return");
                        } else if (com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.s_renamed() != 4) {
                            com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                            bVar.a_renamed("button_color_inside_none");
                            bVar.a_renamed(4);
                            com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(bVar);
                        }
                    }
                });
            }
        }
        if (this.mBeauty3DManager != null) {
            if (isShowBeauty3DEditChooseMenu()) {
                this.mBeauty3DManager.p_renamed();
            } else {
                this.mBeauty3DManager.q_renamed();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar) {
        if (this.mbBurstShot) {
            this.mBurstCaptureBufferLostNum++;
        }
        super.onCaptureFailed(captureRequest, cVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
        com.oplus.camera.e_renamed.a_renamed(TAG, "onCaptureFirstFrameArrived, result: " + cameraCaptureResult + ", isTripodNight: " + isTripodNight());
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

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onCaptureCompleted, result: " + cameraCaptureResult + ", mReceivedRawResultNum: " + this.mReceivedRawResultNum + ", mbPaused: " + this.mbPaused);
        if (cVar.ac_renamed) {
            this.mCameraInterface.a_renamed(cameraCaptureResult.mIdentity, com.oplus.camera.util.Util.a_renamed(java.lang.System.currentTimeMillis()), false, false, false);
        }
        if (!this.mbPaused && isInNightProcess()) {
            com.oplus.camera.e_renamed.c_renamed.a_renamed aVarA = cVar.a_renamed();
            if (com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_RAW == aVarA && cVar.N_renamed != null && this.mReceivedRawResultNum < cVar.N_renamed.mMultiFrameCount) {
                this.mReceivedRawResultNum++;
            }
            if (this.mOneCamera != null && !com.oplus.camera.util.Util.C_renamed() && com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_REPROCESS == aVarA && this.mReceivedRawResultNum > 0) {
                this.mOneCamera.o_renamed(0);
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
        super.onCaptureCompleted(cameraCaptureResult, cVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureSequenceCompleted() {
        if (this.mbPaused || this.mActivity == null) {
            return;
        }
        if (this.mbFrontCamera && 2 == this.mCameraEntryType) {
            this.mCameraInterface.aS_renamed();
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.17
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.d_renamed.this.isSuperNightShutterCountDownOpen()) {
                    com.oplus.camera.capmode.d_renamed.this.mNightAlgoTriggeredStep = 2;
                    return;
                }
                if (1 == com.oplus.camera.capmode.d_renamed.this.mNightAlgoTriggeredStep && com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface != null) {
                    com.oplus.camera.capmode.d_renamed dVar = com.oplus.camera.capmode.d_renamed.this;
                    dVar.mNightAlgoTriggeredStep = 2;
                    if (dVar.isAISceneOpen()) {
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.ab_renamed();
                    }
                    if (!com.oplus.camera.capmode.d_renamed.this.mbCaptureRawTimeDone || com.oplus.camera.capmode.d_renamed.this.isInOfflineNightProcess()) {
                        return;
                    }
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady);
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(false, false);
                    com.oplus.camera.capmode.d_renamed.this.restoreAllViews(false);
                    return;
                }
                if (com.oplus.camera.capmode.d_renamed.this.isUltraHighResolutionOpened() && com.oplus.camera.util.Util.h_renamed(com.oplus.camera.MyApplication.d_renamed())) {
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_process_image_after_capture, -1, false, false, true);
                    if (com.oplus.camera.capmode.d_renamed.this.isAISceneOpen()) {
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.ab_renamed();
                    }
                }
            }
        });
    }

    protected void restoreAllViews(boolean z_renamed) {
        restoreAllViews(z_renamed, true, false);
    }

    private void onFirstCaptureArrived() {
        long jMin;
        if (isCountDownStarted()) {
            return;
        }
        if (this.mNightCaptureTotalTime == 0 || (this.mbSupportNightPictureTime && !isTripodNight())) {
            jMin = 0;
            for (int i_renamed = 0; i_renamed < getDefaultCaptureNumber(); i_renamed++) {
                jMin += java.lang.Math.min((long) ((this.mFirstExposureTime * java.lang.Math.pow(2.0d, i_renamed / 2.0f)) / 1000000.0d), isTripodNight() ? 5000L : MAX_EXPOSURETIME_HAND);
            }
            this.mNightCaptureTotalTime = jMin;
        } else {
            jMin = 0;
        }
        long jRound = (isInOfflineNightProcess() ? 100L : 1000L) * java.lang.Math.round(this.mNightCaptureTotalTime / r0);
        if (0 == jRound) {
            jRound = 1000;
        } else if (jRound < 500) {
            jRound = 500;
        }
        this.mNightCountDownUI.a_renamed(jRound);
        com.oplus.camera.e_renamed.b_renamed(TAG, "onFirstCaptureArrived, nightProcessTotalTime: " + jRound + ", realTime: " + jMin + ", mNightCaptureTotalTime: " + this.mNightCaptureTotalTime);
        updateNightCaptureShutter();
    }

    protected boolean isNightAlgoCaptureTriggered() {
        return (this.mbBurstShot || isTripodModeOpened() || !isInNightProcess() || (isInNightProcess() && isTripodNight()) || isInNightProProcess()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCountDownStarted() {
        com.oplus.camera.ui.p_renamed pVar = this.mNightCountDownUI;
        if (pVar == null) {
            return false;
        }
        return pVar.g_renamed();
    }

    protected void updateNightCaptureShutter() {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.capmode.d_renamed.this.mbPaused) {
                        com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.capmode.d_renamed.TAG, "onFirstCaptureArrived, mbPaused, so return!");
                        return;
                    }
                    com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                    bVar.a_renamed("button_color_inside_none");
                    bVar.b_renamed("button_color_ring_theme");
                    long jC = com.oplus.camera.capmode.d_renamed.this.mNightCountDownUI.c_renamed();
                    if (jC >= 100) {
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.h_renamed((int) jC);
                        int iS = com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.s_renamed();
                        if (iS == 2 || iS == 10 || iS == 11) {
                            bVar.a_renamed(3);
                        } else {
                            bVar.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 27 : 13);
                        }
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(bVar);
                        com.oplus.camera.capmode.d_renamed dVar = com.oplus.camera.capmode.d_renamed.this;
                        dVar.mbTripodNight = dVar.isTripodNight();
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.c_renamed(0, true);
                        com.oplus.camera.capmode.d_renamed.this.mNightCountDownUI.d_renamed();
                        com.oplus.camera.capmode.d_renamed.this.mNightCountDownUI.e_renamed();
                    } else if (com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.s_renamed() == 1) {
                        bVar.a_renamed(4);
                    } else {
                        bVar.a_renamed(2);
                    }
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(bVar);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed(TAG, "onBeforePictureTaken, mReceivedSnapNum: " + this.mReceivedSnapNum + ", isBurstShot: " + z_renamed);
        if (!this.mbPaused && z_renamed && this.mReceivedSnapNum < com.oplus.camera.util.Util.d_renamed) {
            this.mReceivedSnapNum++;
            if (com.oplus.camera.util.Util.C_renamed() && 1 == this.mReceivedSnapNum && this.mOneCamera != null) {
                this.mOneCamera.l_renamed(false);
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
            int iJ = this.mCameraInterface.aU_renamed().j_renamed();
            if (1 != iJ && 4 != iJ) {
                this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, false, false);
            }
            this.mCameraUIInterface.a_renamed(this.mReceivedSnapNum, false, false);
            if (android.os.SystemClock.uptimeMillis() - this.mPlaySoundTime >= MIN_PLAY_INTERVAL) {
                this.mCameraInterface.c_renamed(1);
                this.mPlaySoundTime = android.os.SystemClock.uptimeMillis();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, int i4) {
        if (this.mbTakeAnimateDelay) {
            com.oplus.camera.util.Util.c_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$d_renamed$PcUHyhOV5vydrXaGsH7sT22LGZE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$onPictureCallback$0$d_renamed();
                }
            });
        }
        super.onPictureCallback(bArr, i_renamed, i2, i3, z_renamed, i4);
    }

    public /* synthetic */ void lambda$onPictureCallback$0$d_renamed() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onPictureCallback, animateTakePicture delay");
        this.mCameraInterface.h_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onAfterPictureTaken, mReceivedSnapNum: " + this.mReceivedSnapNum + ", mBurstCaptureBufferLostNum: " + this.mBurstCaptureBufferLostNum + ", isBurstShot: " + z_renamed + ", isInBurstShotCapturing: " + this.mbInBurstShotCapturing + ", getMainShutterButtonType: " + this.mCameraUIInterface.s_renamed());
        this.mbNightJpegDone = true;
        this.mbStopSteadyTips = true;
        if (this.mbEnableUILater) {
            this.mbEnableUILater = false;
            this.mCameraUIInterface.d_renamed(true, false);
            resetAfterPictureTaken(true, this.mbBurstShot);
        }
        if (z_renamed) {
            if (com.oplus.camera.util.Util.d_renamed == this.mReceivedSnapNum + this.mBurstCaptureBufferLostNum || ((!com.oplus.camera.util.Util.C_renamed() && this.mMemoryManager.b_renamed()) || !this.mbInBurstShotCapturing)) {
                disableBurstShot();
            }
        } else {
            if (this.mCameraInterface.i_renamed() && this.mbCaptureRawTimeDone && !this.mbCaptureHasSuperTextResult) {
                if (!this.mCameraUIInterface.R_renamed()) {
                    this.mCameraUIInterface.d_renamed(true, false);
                } else {
                    this.mCameraUIInterface.d_renamed(false, true);
                }
            }
            boolean zIsInNightProcess = isInNightProcess();
            if (((this.mCameraUIInterface.s_renamed() == 4 || this.mCameraUIInterface.s_renamed() == 3 || this.mCameraUIInterface.s_renamed() == 28 || this.mCameraUIInterface.s_renamed() == 23 || this.mCameraUIInterface.s_renamed() == 26) && ((getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_AUTO_NIGHT_SCENCE) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI) || zIsInNightProcess) && !this.mbCaptureHasSuperTextResult && !isIdPhotoOpen())) || 2 == this.mNightAlgoTriggeredStep) {
                resetAfterPictureTaken(zIsInNightProcess, z_renamed);
            }
            if (this.mbShowSteadyTips && this.mbCaptureRawTimeDone) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady);
                this.mbShowSteadyTips = false;
            }
            if (this.mbShowImageOptimizingTips && this.mbCaptureRawTimeDone) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_image_optimizing_tips_oplus_r);
                this.mbShowImageOptimizingTips = false;
            }
            if (this.mbCaptureRawTimeDone) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_process_image_after_capture);
            }
            if (2 == this.mNightAlgoTriggeredStep) {
                this.mNightAlgoTriggeredStep = 0;
            }
            if (this.mBeauty3DManager != null) {
                if (isShowBeauty3DEditChooseMenu()) {
                    this.mBeauty3DManager.e_renamed(true);
                    this.mBeauty3DManager.p_renamed();
                } else {
                    this.mBeauty3DManager.q_renamed();
                }
            }
            if (isGoogleLensEnable()) {
                setGoogleLensIconClickable(true);
            }
        }
        resetAeLockAfterCaptured();
        if ((this.mbFrontCamera || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LOCK_AWB_BEFORE_CAPTURE_REAR_SUPPORT)) && com.oplus.camera.util.Util.C_renamed() && this.mCameraInterface.i_renamed()) {
            resetAwbLockAfterCaptured();
        }
    }

    protected void resetAfterPictureTaken(boolean z_renamed, boolean z2) {
        if (!this.mbCaptureRawTimeDone && z_renamed) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "resetAfterPictureTaken, CaptureRawTime not end");
            return;
        }
        this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BURST_SHOT));
        if (!this.mCameraUIInterface.A_renamed() && isPIModeOpen() && !z2 && this.mCameraUIInterface.K_renamed()) {
            this.mCameraUIInterface.l_renamed(false, false);
        }
        if (z_renamed) {
            if (this.mbTripodNight || this.mbSupportNightPictureTime || 2 == this.mNightAlgoTriggeredStep || isSuperNightShutterCountDownOpen()) {
                restoreAllViews(!this.mbPaused, true, false);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady);
                this.mbTripodNight = false;
            }
            this.mOneCamera.o_renamed(0);
            if (!isInNightProMode() && this.mCameraInterface != null && !this.mCameraInterface.ae_renamed()) {
                this.mCameraInterface.ac_renamed();
                this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), false);
            }
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            updateFilterParam(getCurrFilterIndex());
            resetHdrAndFlashModeAfterCapture();
            resetPIModeAfterCapture();
            displayScreenHintIconInSwitchOn();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperClearPortraitOpen() {
        return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, "off")) && isSuperClearPortraitEnable() && !this.mbBurstShot;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperClearPortraitEnable() {
        return (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT) || isPIAISceneOpen() || "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI, "off")) || isFilterEffectOpen() || isUltraHighResolutionOpened() || isHighPictureSize() || isSuperSeNightOpen()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDisableBurstShot() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onDisableBurstShot");
        if (this.mbBurstShot) {
            if (this.mReceivedSnapNum > 0) {
                this.mCameraInterface.c_renamed(2);
            }
            this.mbBurstShot = false;
            this.mbInCapturing = false;
            this.mCameraInterface.a_renamed(false);
            this.mCameraInterface.f_renamed(this.mReceivedSnapNum);
            com.oplus.camera.e_renamed.a_renamed(TAG, "onDisableBurstShot, CameraTest Continuous Shot End");
            this.mMyHandler.removeMessages(1);
            if (this.mReceivedSnapNum > 0) {
                if (!this.mbPaused) {
                    this.mCameraUIInterface.as_renamed();
                }
                this.mMyHandler.sendEmptyMessageDelayed(1, 500L);
                this.mCameraInterface.B_renamed();
            } else {
                this.mCameraUIInterface.e_renamed(false, false);
                if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_EXPAND_POPBAR)) {
                    this.mCameraInterface.a_renamed(true, false);
                }
                if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU)) {
                    this.mCameraUIInterface.c_renamed(true);
                }
                if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
                    this.mCameraUIInterface.c_renamed(true);
                }
                displayScreenHintIconInSwitchOn();
            }
            resetPIModeAfterCapture();
            if (!this.mCameraUIInterface.R_renamed()) {
                this.mCameraUIInterface.a_renamed(true, false);
                this.mCameraUIInterface.b_renamed(true, false);
                this.mCameraUIInterface.c_renamed(true, false);
                this.mCameraUIInterface.f_renamed(true, false);
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
    protected int getBubbleOffsetX(int i_renamed) {
        int[] iArrA;
        if (6 == i_renamed) {
            return this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_type_beauty3d_add_offset_x);
        }
        if (9 != i_renamed) {
            return 0;
        }
        if (this.mCameraInterface.aK_renamed() == null) {
            return -1;
        }
        if (1 == this.mCameraInterface.aU_renamed().j_renamed() && (iArrA = this.mCameraInterface.a_renamed(this.mActivity, 9)) != null) {
            return iArrA[0];
        }
        return (int) this.mCameraInterface.aK_renamed()[0];
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetY(int i_renamed) {
        int[] iArrA;
        if (6 == i_renamed) {
            return this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_type_beauty3d_add_offset_y);
        }
        if (9 != i_renamed || this.mCameraInterface.aK_renamed() == null) {
            return 0;
        }
        if (1 == this.mCameraInterface.aU_renamed().j_renamed() && (iArrA = this.mCameraInterface.a_renamed(this.mActivity, 9)) != null) {
            return iArrA[1];
        }
        return ((int) this.mCameraInterface.aK_renamed()[1]) - this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_sticker_guide_ultra_zoom_gap_y);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (i_renamed == 2) {
            if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D)) {
                if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && !isShowBeauty3D() && this.mCameraUIInterface.A_renamed() && "beauty".equals(getCurrEffectMenuName()) && com.oplus.camera.ui.preview.a_renamed.o_renamed.a_renamed(this.mActivity) == 0) {
                    this.mCameraUIInterface.a_renamed((android.view.View) null, 6, getBubbleOffsetX(6), getBubbleOffsetY(6));
                } else {
                    this.mCameraUIInterface.f_renamed(6, false);
                }
            }
            if (this.mBeauty3DManager != null) {
                if (isShowBeauty3DEditChooseMenu()) {
                    this.mBeauty3DManager.e_renamed(true);
                    this.mBeauty3DManager.p_renamed();
                } else {
                    this.mBeauty3DManager.q_renamed();
                }
            }
            if (!isGoogleLensEnable()) {
                hideGoogleLensIcon(true);
                return;
            } else {
                if (z_renamed) {
                    if (this.mCameraUIInterface.A_renamed()) {
                        return;
                    }
                    showGoogleLensIcon(true);
                    return;
                }
                hideGoogleLensIcon(true);
                return;
            }
        }
        if (i_renamed == 3 || i_renamed == 5) {
            com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
            if (bVar != null) {
                bVar.q_renamed();
            }
            if (isGoogleLensEnable()) {
                if (z_renamed) {
                    showGoogleLensIcon(true);
                    return;
                } else {
                    hideGoogleLensIcon(true);
                    return;
                }
            }
            return;
        }
        if (i_renamed == 18) {
            handleBeauty3DGuideView(false);
            if (isGoogleLensEnable()) {
                if (z_renamed) {
                    showGoogleLensIcon(true);
                    return;
                } else {
                    hideGoogleLensIcon(true);
                    return;
                }
            }
            return;
        }
        if (i_renamed != 20) {
            switch (i_renamed) {
                case 12:
                    if (this.mBeauty3DManager != null) {
                        if (z_renamed && isShowBeauty3DEditChooseMenu()) {
                            this.mBeauty3DManager.e_renamed(true);
                            this.mBeauty3DManager.p_renamed();
                            break;
                        } else {
                            this.mBeauty3DManager.q_renamed();
                            break;
                        }
                    }
                    break;
                case 13:
                    handleBeauty3DGuideView(z_renamed);
                    break;
                case 14:
                    com.oplus.camera.d_renamed.b_renamed bVar2 = this.mBeauty3DManager;
                    if (bVar2 != null) {
                        bVar2.j_renamed();
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
        this.mCameraUIInterface.a_renamed(true, false, true);
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
        int i_renamed;
        if (isSatOpen()) {
            synchronized (this.mApsDecisionResultLock) {
                i_renamed = this.mSensorNumber;
            }
            return i_renamed;
        }
        return super.getPreviewStreamNum();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected com.oplus.camera.e_renamed.d_renamed.a_renamed getCaptureCallback() {
        this.mReceivedRawResultNum = 0;
        return super.getCaptureCallback();
    }

    /* compiled from: CommonCapMode.java */
    private class a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.Runtime f4259b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private long f4260c;

        private a_renamed() {
            this.f4259b = null;
        }

        public void a_renamed() {
            if (this.f4259b == null) {
                this.f4259b = java.lang.Runtime.getRuntime();
            }
            this.f4260c = this.f4259b.maxMemory();
            com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "initMemory, mMaxMemory: " + this.f4260c);
        }

        public boolean b_renamed() {
            if (this.f4259b == null) {
                this.f4259b = java.lang.Runtime.getRuntime();
            }
            if (this.f4260c - (this.f4259b.totalMemory() - this.f4259b.freeMemory()) > 52428800) {
                return false;
            }
            com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "isNeedStopCapture, realfree <= MIN_LEFT_MEMEORY");
            return true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.f_renamed(5, true);
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D) && com.oplus.camera.ui.preview.a_renamed.o_renamed.a_renamed(this.mActivity) == 0 && !isShowBeauty3D() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && "beauty".equals(getCurrEffectMenuName())) {
            this.mCameraUIInterface.a_renamed((android.view.View) null, 6, getBubbleOffsetX(6), getBubbleOffsetY(6));
        }
        if (this.mBeauty3DManager != null) {
            if (isShowBeauty3DEditChooseMenu()) {
                this.mBeauty3DManager.e_renamed(true);
                this.mBeauty3DManager.p_renamed();
            } else {
                this.mBeauty3DManager.q_renamed();
            }
        }
        this.mbFirstEffectMenuOpened = true;
        if (isGoogleLensEnable()) {
            hideGoogleLensIcon(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_preview_frame".equals(str)) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SUPER_TEXT_CPU_PROCESS)) {
                return getBeauty3Dstatus() == 0 || getBeauty3Dstatus() == 4;
            }
            return false;
        }
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return 3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() && getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA) && !isHighPictureSize() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL);
        }
        if ("type_still_capture_raw".equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_RAW) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_CAPTURE_RAW);
        }
        if ("type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str)) {
            return isSatOpen();
        }
        if ("type_tele_small_preview".equals(str)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TELE_SMALL_PREVIEW_SUPPORT) && isSatOpen();
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_reprocess_data_yuv".equals(str)) {
            return com.oplus.camera.util.Util.C_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_RAW) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) && !this.mbFrontCamera && this.mCameraInterface.i_renamed();
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z_renamed) {
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D)) {
            this.mCameraUIInterface.f_renamed(6, true);
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D)) {
            this.mCameraUIInterface.f_renamed(5, true);
        }
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null) {
            bVar.q_renamed();
        }
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) || com.oplus.camera.e_renamed.a_renamed.j_renamed() == getProperCameraId(this.mCameraId) || this.mbFrontCamera || getFaceBeautyCurrIndex() != 0 || this.mbPreburstShotCapture) {
            return;
        }
        this.mCameraInterface.b_renamed(this.mLastPreviewSize);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isPIAISceneOpen() {
        if (this.mPreferences == null || this.mActivity == null || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI) || this.mbFrontCamera) {
            return false;
        }
        return android.text.TextUtils.equals("on_renamed", this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_pi_ai_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAISceneOpen() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN)) {
            return false;
        }
        java.lang.String string = this.mActivity != null ? this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_ai_scene_default_value) : "on_renamed";
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI) && this.mActivity != null) {
            string = this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_pi_ai_scene_default_value);
        }
        if (this.mPreferences != null) {
            string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN, string);
        }
        return "on_renamed".equals(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBeauty3Dstatus() {
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null) {
            return bVar.f_renamed();
        }
        return 0;
    }

    public boolean isShowBeauty3DEditChooseMenu() {
        return com.oplus.camera.ui.preview.a_renamed.o_renamed.a_renamed(this.mActivity) == 1 && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) && getFaceBeautyCurrIndex() == -1 && this.mCameraUIInterface.A_renamed() && getBeauty3Dstatus() == 0 && "beauty".equals(getCurrEffectMenuName());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        int[] iArrA;
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
            return;
        }
        android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (this.mbCheckTakeAnimateDelay) {
            this.mbCheckTakeAnimateDelay = false;
            this.mbTakeAnimateDelay = com.oplus.camera.util.Util.a_renamed(captureResult) > ((float) com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_LUX_DELAY_ANIMATE_THRESHOLD));
        }
        if (isShowBeauty3D() && getBeauty3DConfigured()) {
            this.mBeauty3DManager.b_renamed(captureResult);
            return;
        }
        int[] iArrA2 = this.mOneCamera.a_renamed((android.hardware.camera2.CaptureResult.Key<?>) com.oplus.camera.e_renamed.b_renamed.Z_renamed, captureResult);
        if (iArrA2 != null && iArrA2.length > 0 && !isHalVideoRecording() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_AUTO_MICRO)) {
            if (this.mbInCapturing) {
                if (!this.mbAutoMicroOpen) {
                    this.mOneCamera.B_renamed(false);
                }
            } else if (isTiltShiftOpen()) {
                this.mOneCamera.B_renamed(false);
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            } else {
                java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "auto");
                if (1 == iArrA2[0] && "auto".equals(string) && !isMonoIndex(getCurrFilterIndex()) && !isInNightProcess()) {
                    if (!this.mbAutoMicroOpen && !this.mCameraUIInterface.R_renamed()) {
                        com.oplus.camera.e_renamed.b_renamed(TAG, "onPreviewCaptureResult, micro mode");
                        this.mbAutoMicroOpen = true;
                        if (this.mMyHandler != null) {
                            android.os.Message messageObtain = android.os.Message.obtain();
                            messageObtain.what = 4;
                            messageObtain.arg1 = 1;
                            this.mMyHandler.sendMessage(messageObtain);
                        }
                    }
                } else if (this.mbAutoMicroOpen) {
                    com.oplus.camera.e_renamed.b_renamed(TAG, "onPreviewCaptureResult, exit micro mode");
                    this.mbAutoMicroOpen = false;
                    android.os.Handler handler = this.mMyHandler;
                    if (handler != null) {
                        handler.sendEmptyMessage(5);
                    }
                } else if ("off".equals(string)) {
                    this.mOneCamera.B_renamed(false);
                    this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
            }
        }
        if (!this.mbInCapturing) {
            if (com.oplus.camera.util.Util.C_renamed()) {
                iArrA = this.mOneCamera.a_renamed((android.hardware.camera2.CaptureResult.Key<?>) com.oplus.camera.e_renamed.b_renamed.ab_renamed, captureResult);
            } else {
                iArrA = this.mOneCamera.a_renamed((android.hardware.camera2.CaptureResult.Key<?>) com.oplus.camera.e_renamed.b_renamed.ac_renamed, captureResult);
            }
            if (iArrA != null && iArrA.length > 0) {
                this.mbSceneNight = iArrA[0] == 1;
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
    public java.lang.String getFlashMode() {
        return isMonoIndex(getCurrFilterIndex()) ? "off" : super.getFlashMode();
    }

    private void updateMonoFilterEffect(android.hardware.camera2.CaptureResult captureResult) {
        if (this.mActivity == null) {
            return;
        }
        final int[] iArrA = this.mOneCamera.a_renamed((android.hardware.camera2.CaptureResult.Key<?>) com.oplus.camera.e_renamed.b_renamed.aa_renamed, captureResult);
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr;
                if (com.oplus.camera.capmode.d_renamed.this.mbPaused || (iArr = iArrA) == null || iArr.length <= 0) {
                    return;
                }
                com.oplus.camera.capmode.d_renamed dVar = com.oplus.camera.capmode.d_renamed.this;
                if (dVar.isMonoIndex(dVar.getCurrFilterIndex())) {
                    com.oplus.camera.capmode.d_renamed.this.updateShelter(iArrA[0]);
                }
            }
        });
    }

    private void updateNowRearEffectIndex() {
        if (!this.mbFrontCamera) {
            this.mNowRearEffectIndex = this.mPreferences.getInt("key_filter_index", com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            updateMenuWithMono(isMonoIndex(getCurrFilterIndex()));
        }
    }

    private void updateMenuWithMono(final boolean z_renamed) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.d_renamed.this.mOneCamera == null) {
                    return;
                }
                if (com.oplus.camera.capmode.d_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE)) {
                    if (z_renamed) {
                        com.oplus.camera.capmode.d_renamed.this.mOneCamera.b_renamed("off");
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                    } else if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM)) {
                        java.lang.String string = com.oplus.camera.capmode.d_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                        com.oplus.camera.capmode.d_renamed.this.mOneCamera.b_renamed(string);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, string);
                    }
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_AUTO_MICRO) && com.oplus.camera.capmode.d_renamed.this.mOneCamera != null) {
                    if (z_renamed) {
                        com.oplus.camera.capmode.d_renamed.this.mOneCamera.B_renamed(false);
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "off");
                    } else {
                        java.lang.String string2 = com.oplus.camera.capmode.d_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "auto");
                        com.oplus.camera.capmode.d_renamed.this.mOneCamera.B_renamed("auto".equals(string2));
                        com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, string2);
                    }
                }
                com.oplus.camera.capmode.d_renamed.this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        });
    }

    private void onHighResolution() {
        this.mbHighResolutionChangeRatio = true;
        onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        this.mbHighResolutionChangeRatio = false;
        if (this.mCameraUIInterface.A_renamed() && com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
            this.mCameraUIInterface.s_renamed(true);
            this.mCameraInterface.a_renamed(true, false);
            this.mCameraInterface.d_renamed(true);
        } else {
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
        }
        if (this.mCameraUIInterface.K_renamed()) {
            this.mCameraUIInterface.a_renamed(true, true, true, true);
        }
        this.mCameraUIInterface.r_renamed(true);
    }

    private void forceCloseHighResolution() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION) && this.mPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard");
            editorEdit.commit();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShelter(int i_renamed) {
        java.lang.String defaultFilterType;
        if (this.mPreviewEffectProcess == null) {
            return;
        }
        if (1 == i_renamed) {
            this.mbOcclusion = true;
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_camera_do_not_occlusion, 0, false, false, true);
            defaultFilterType = "default";
        } else {
            defaultFilterType = getDefaultFilterType(getCurrFilterIndex());
            if (this.mbOcclusion) {
                this.mbOcclusion = false;
                this.mCameraUIInterface.a_renamed(true, false, true);
            }
        }
        this.mPreviewEffectProcess.a_renamed(defaultFilterType);
        this.mCameraUIInterface.a_renamed(getCurrFilterIndex(), defaultFilterType);
    }

    private java.lang.String getDefaultFilterType(int i_renamed) {
        return i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed() ? co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1 : i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed() ? co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_3 : i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed() ? co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_5 : i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.k_renamed() ? co_renamed.polarr.renderer.FilterPackageUtil.F_COMMON_6 : "default";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        android.os.Handler handler;
        if (!this.mbShowSteadyTips) {
            super.displayScreenHintIconInSwitchOn();
        }
        if (is10bitsHeicEncodeEnable() && !this.mbFrontCamera) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_10bit_hint, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
        }
        if (!this.mbAutoMicroOpen || (handler = this.mMyHandler) == null) {
            return;
        }
        handler.sendEmptyMessage(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportMicroShowReminderToDcs() {
        this.mMsgData = new com.oplus.camera.statistics.model.ReminderMsgData(this.mActivity, true);
        if (this.mCameraInterface != null) {
            if (!this.mCameraInterface.i_renamed()) {
                this.mMsgData.mCameraEnterType = java.lang.String.valueOf(2);
            }
            this.mMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        }
        this.mMsgData.mCaptureMode = getCameraMode();
        this.mMsgData.mOrientation = this.mOrientation;
        com.oplus.camera.statistics.model.ReminderMsgData reminderMsgData = this.mMsgData;
        reminderMsgData.mReminderTypeValue = "ai_scene";
        reminderMsgData.mReminderCodeValue = java.lang.String.valueOf(18);
        this.mMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        this.mMsgData.report();
        this.mMsgData = null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setBeauty3DState(int i_renamed) {
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar != null) {
            bVar.a_renamed(i_renamed);
        }
    }

    private void handleBeauty3DGuideView(boolean z_renamed) {
        if (this.mbPaused) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "handleBeauty3DGuideView, pause, so return");
            return;
        }
        com.oplus.camera.d_renamed.b_renamed bVar = this.mBeauty3DManager;
        if (bVar == null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "handleBeauty3DGuideView, mBeauty3DManager null");
            return;
        }
        if (!z_renamed) {
            if (bVar.i_renamed()) {
                this.mBeauty3DManager.m_renamed();
                return;
            }
            return;
        }
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D)) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "handleBeauty3DGuideView, not support return");
            return;
        }
        if (com.oplus.camera.ui.preview.a_renamed.o_renamed.a_renamed(this.mActivity) == 1) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "handleBeauty3DGuideView, files exist, return");
            return;
        }
        if (this.mCameraInterface.i_renamed() && z_renamed && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_CAMERA_FIRST_SWITCH, true)) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "handleBeauty3DGuideView, start showBeauty3DGuide");
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_CAMERA_FIRST_SWITCH, false);
            editorEdit.apply();
            this.mCameraUIInterface.F_renamed();
            this.mBeauty3DManager.c_renamed(getPreviewSize(this.mOneCamera.e_renamed()));
            return;
        }
        if (isShowingGuideView() && z_renamed) {
            this.mCameraUIInterface.F_renamed();
            this.mBeauty3DManager.d_renamed(getPreviewSize(this.mOneCamera.e_renamed()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBeauty3DChange(boolean z_renamed) {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.h_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isPIModeOpen() {
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI) && this.mPreferences != null && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI, "off"));
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI)) {
            return isPIAISceneOpen();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInNightProcess() {
        if (isSuperSeNightOpen()) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS) && getNightStateDecision() > 0;
        }
        boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y);
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS) && !this.mbBurstShot && getNightStateDecision() > 0 && this.mCameraInterface != null && this.mCameraInterface.i_renamed() && (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y) || (isAISceneOpen() && 12 == this.mCameraInterface.j_renamed())) && ((com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI) || !isPIModeOpen()) && ((!isFaceBeautyOrMakeupOpen() || configBooleanValue) && ((!isFilterEffectOpen() || configBooleanValue) && !((isHDRState() && !configBooleanValue) || isFlashState() || isSuperClearPortraitOpen()))));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInOfflineNightProcess() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_OFFLINE_R2Y) && isInNightProcess();
    }

    protected void forceClosePIEffect() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI) && this.mPreferences != null) {
                android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, "off");
                editorEdit.commit();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI);
                return;
            }
            return;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI) && this.mPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
            editorEdit2.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PI, "off");
            editorEdit2.commit();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSatOpen() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
            return !isHighPictureSize();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUltraWideAngleOpened() {
        if (isHighPictureSize()) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
            editorEdit.apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (isNoneSatUltraWideAngleOpen()) {
            return (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || java.lang.Float.compare(this.mOneCamera.e_renamed().n_renamed(), 0.0f) == 0) ? com.oplus.camera.R_renamed.string.toast_ultra_wide_angel_lens : com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.toast_ultra_wide_micro_lens);
        }
        return -1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayFixedUpModeHint() {
        super.displayFixedUpModeHint();
        if (this.mActivity == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "displayFixedUpModeHint");
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.d_renamed.5
            @Override // java.lang.Runnable
            public void run() {
                if (!com.oplus.camera.capmode.d_renamed.this.isHighPictureSize() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                    return;
                }
                if (android.text.TextUtils.isEmpty(com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.capmode.d_renamed.this.getHighPictureSizeHint(), com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Double.valueOf(com.oplus.camera.capmode.d_renamed.this.getDisplayHighPictureSize()));
                } else {
                    com.oplus.camera.capmode.d_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_setting_menu_high_resolution_item, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.l_renamed(isHighPictureSize());
        zoomConfigure.n_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE));
        zoomConfigure.t_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X));
        zoomConfigure.u_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_INSENSOR_ZOOM_POINT_3X_SUPPORT));
        zoomConfigure.b_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetCaptureButton() {
        if (this.mCameraInterface.i_renamed()) {
            this.mCameraUIInterface.d_renamed(true, false);
        }
        if (this.mCameraUIInterface.s_renamed() == 4 || this.mCameraUIInterface.s_renamed() == 28) {
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BURST_SHOT));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onHomeKeyClick() {
        resetMonoFilter();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        if (this.mbDestroyed || this.mCameraInterface == null) {
            return null;
        }
        return !this.mCameraInterface.i_renamed() ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_DUMMY : (isSatOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL)) ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_SAT_HAL : isHighPictureSize() ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_COMMON_DUMMY : super.getCameraFeature();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(java.lang.String str) {
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return (!com.oplus.camera.util.Util.C_renamed() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && isSatOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL);
        }
        if ("type_still_capture_yuv_main".equals(str) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return (!com.oplus.camera.util.Util.C_renamed() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && isSatOpen();
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean checkSensorMask(boolean z_renamed, boolean z2) {
        if (isSatOpen()) {
            synchronized (this.mApsDecisionResultLock) {
                if (this.mDecisionResult != null && this.mDecisionResult.mSensorMask != null) {
                    if (z_renamed) {
                        return 1 == this.mDecisionResult.mSensorMask[0];
                    }
                    if (z2) {
                        return 1 == this.mDecisionResult.mSensorMask[2];
                    }
                    return 1 == this.mDecisionResult.mSensorMask[1];
                }
            }
        }
        return super.checkSensorMask(z_renamed, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCaptureInDarkLight(int i_renamed) {
        return (this.mbBurstShot || !(17 == i_renamed || 18 == i_renamed || 19 == i_renamed) || this.mbFrontCamera) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int i_renamed) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL) && i_renamed == 0 && this.mReceivedPreviewResultNum == 0) {
            return false;
        }
        return super.needPreviewMeta(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onReceivePreviewCaptureResult(android.hardware.camera2.CaptureResult captureResult) {
        super.onReceivePreviewCaptureResult(captureResult);
        this.mReceivedPreviewResultNum++;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        if (isGoogleLensEnable()) {
            hideGoogleLensIcon(false);
        }
        if (isAISceneOpen()) {
            this.mCameraUIInterface.l_renamed(false);
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
            this.mCameraUIInterface.l_renamed(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
        if (1 == i_renamed || 2 == i_renamed) {
            return;
        }
        showNextTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGoogleLensAvailability() {
        boolean zBooleanValue;
        java.lang.String string;
        android.content.SharedPreferences sharedPreferences = this.mActivity != null ? this.mActivity.getApplicationContext().getSharedPreferences("rom_update_info", 0) : null;
        if (sharedPreferences == null || (string = sharedPreferences.getString("google_lens_switch", null)) == null) {
            zBooleanValue = true;
        } else {
            try {
                zBooleanValue = java.lang.Boolean.valueOf(string).booleanValue();
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "checkGoogleLensAvailability, enableGoogleLens: " + zBooleanValue);
        if (zBooleanValue && this.mLensApi == null && this.mActivity != null) {
            this.mLensApi = new com.google.lens.sdk.LensApi(this.mActivity.getApplicationContext());
            this.mLensApi.checkLensAvailability(new com.google.lens.sdk.LensApi.LensAvailabilityCallback() { // from class: com.oplus.camera.capmode.d_renamed.6
                @Override // com.google.lens.sdk.LensApi.LensAvailabilityCallback
                public void onAvailabilityStatusFetched(int i_renamed) {
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.d_renamed.TAG, "checkGoogleLensAvailability, onAvailabilityStatusFetched, status: " + i_renamed);
                    if (i_renamed == 0) {
                        com.oplus.camera.capmode.d_renamed.this.mbGoogleLensStatusReady = true;
                        if (com.oplus.camera.capmode.d_renamed.this.mbCapModeInit && com.oplus.camera.capmode.d_renamed.this.isGoogleLensEnable()) {
                            com.oplus.camera.capmode.d_renamed.this.showGoogleLensIcon(false);
                            com.oplus.camera.capmode.d_renamed.this.setGoogleLensIconClickable(true);
                        }
                    }
                }
            });
        }
    }

    public boolean isGoogleLensEnable() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.GOOGLE_LENS)) {
            return this.mbGoogleLensStatusReady;
        }
        return false;
    }

    private void initGoogleLensIcon() {
        this.mActivity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.google_lens, this.mCameraRootView);
        this.mGoogleLensIcon = (com.oplus.camera.ui.RotateImageView) this.mCameraRootView.findViewById(com.oplus.camera.R_renamed.id_renamed.google_lens_icon_view);
        this.mGoogleLensIcon.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.capmode.d_renamed.7
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.capmode.d_renamed.this.mLensApi != null) {
                    try {
                        com.oplus.camera.capmode.d_renamed.this.mLensApi.launchLensActivity(com.oplus.camera.capmode.d_renamed.this.mActivity);
                        com.oplus.camera.capmode.d_renamed.this.reportClickMenuToDcs();
                    } catch (java.lang.Exception e_renamed) {
                        e_renamed.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickMenuToDcs() {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        if (this.mCameraInterface != null) {
            menuClickMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        }
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mFuncKeyId = 53;
        menuClickMsgData.report();
    }

    public void showGoogleLensIcon(boolean z_renamed) {
        if (this.mCameraUIInterface.A_renamed() || this.mCameraUIInterface.K_renamed() || this.mCameraUIInterface.R_renamed() || this.mCameraUIInterface.aw_renamed() || this.mCameraUIInterface.ax_renamed() || this.mCameraInterface.A_renamed() || !this.mGoogleLensShouldShow) {
            return;
        }
        if (this.mGoogleLensIcon == null) {
            initGoogleLensIcon();
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.mGoogleLensIcon);
            return;
        }
        android.view.animation.Animation animation = this.mGoogleLensIcon.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            animation.cancel();
        }
        this.mGoogleLensIcon.setVisibility(0);
    }

    public void hideGoogleLensIcon(boolean z_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.mGoogleLensIcon;
        if (rotateImageView != null) {
            if (z_renamed) {
                com.oplus.camera.util.Util.b_renamed(rotateImageView);
                return;
            }
            android.view.animation.Animation animation = rotateImageView.getAnimation();
            if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
                animation.cancel();
            }
            this.mGoogleLensIcon.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoogleLensIconClickable(boolean z_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.mGoogleLensIcon;
        if (rotateImageView != null) {
            rotateImageView.setClickable(z_renamed);
        }
    }

    private boolean isDeviceLocked() {
        android.app.KeyguardManager keyguardManager;
        if (this.mActivity == null || (keyguardManager = (android.app.KeyguardManager) this.mActivity.getApplicationContext().getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.isDeviceLocked();
    }

    private boolean isTorchMode() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(getRearFlashMode());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void showNextTip() {
        super.showNextTip();
        if (this.mActivity == null || this.mCameraUIInterface == null || isMoreModeShowing() || showOutPreviewGuide()) {
            return;
        }
        if (isFirstTipsEnable(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_BEAUTY_TIPS)) {
            showFirstBeautyTipView();
        } else if (isFirstTipsEnable(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE)) {
            final android.view.View viewFindViewById = this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_anchor_view);
            if (viewFindViewById != null) {
                viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.d_renamed.8
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (com.oplus.camera.capmode.d_renamed.this.isMoreModeShowing() || !com.oplus.camera.capmode.d_renamed.this.isFirstTipsEnable(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE) || viewFindViewById.getMeasuredWidth() == 0) {
                            return;
                        }
                        com.oplus.camera.j_renamed.a_renamed().a_renamed(1);
                    }
                });
            }
            this.mCameraUIInterface.aE_renamed();
        }
    }

    private boolean showOutPreviewGuide() {
        return this.mCameraUIInterface != null && this.mCameraUIInterface.be_renamed();
    }

    public void showUltraWideTips() {
        if (this.mActivity != null && this.mCameraUIInterface != null && !isMoreModeShowing() && isFirstTipsEnable(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE)) {
            final android.view.View viewFindViewById = this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_anchor_view);
            if (viewFindViewById != null) {
                viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.d_renamed.9
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (!com.oplus.camera.capmode.d_renamed.this.isMoreModeShowing() && com.oplus.camera.capmode.d_renamed.this.isFirstTipsEnable(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE) && viewFindViewById.getMeasuredWidth() != 0) {
                            com.oplus.camera.capmode.d_renamed.this.showFirstBubble(viewFindViewById, 9);
                            viewFindViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        } else {
                            com.oplus.camera.j_renamed.a_renamed().c_renamed();
                        }
                    }
                });
            } else {
                com.oplus.camera.j_renamed.a_renamed().c_renamed();
            }
            this.mCameraUIInterface.aE_renamed();
            return;
        }
        com.oplus.camera.j_renamed.a_renamed().c_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMoreModeShowing() {
        return this.mCameraUIInterface != null && (this.mCameraUIInterface.R_renamed() || this.mCameraUIInterface.S_renamed());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(java.lang.String str) {
        if (com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType)) {
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_BEAUTY_TIPS.equals(str)) {
            if (this.mCameraEntry == null || !this.mCameraEntry.R_renamed()) {
                return isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_BEAUTY_TIPS);
            }
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS.equals(str)) {
            return isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS);
        }
        return com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE.equals(str) && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_BUBBLE_TIPS_SUPPORT) && !this.mbFrontCamera;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAllViewsExceptShutter() {
        if (this.mCameraUIInterface.A_renamed()) {
            this.mCameraUIInterface.s_renamed(false);
        } else {
            this.mCameraUIInterface.q_renamed(false);
        }
        this.mCameraUIInterface.j_renamed(false, false);
        this.mCameraUIInterface.g_renamed(4);
        this.mCameraUIInterface.d_renamed(4);
        this.mCameraUIInterface.b_renamed(4, com.oplus.camera.util.Util.c_renamed(getPreviewSize(getCameraInfo(this.mCameraId))));
        this.mCameraUIInterface.f_renamed(4);
        this.mCameraUIInterface.P_renamed(false);
        this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        if (isPanelMode()) {
            this.mCameraUIInterface.a_renamed(4, true);
        } else {
            this.mCameraUIInterface.a_renamed(4, 1);
        }
    }

    protected void restoreAllViews(boolean z_renamed, boolean z2, boolean z3) {
        this.mCameraUIInterface.g_renamed(true);
        this.mCameraUIInterface.c_renamed(8, false);
        this.mCameraUIInterface.g_renamed(0);
        this.mCameraUIInterface.b_renamed(0, com.oplus.camera.util.Util.c_renamed(getPreviewSize(getCameraInfo(this.mCameraId))));
        this.mCameraUIInterface.P_renamed(true);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
            this.mCameraUIInterface.d_renamed(0);
        }
        if (supportBeautyButton()) {
            this.mCameraUIInterface.l_renamed(true, false);
        }
        if (z2) {
            this.mCameraUIInterface.f_renamed(0);
        }
        this.mCameraInterface.az_renamed();
        if (z_renamed) {
            this.mCameraUIInterface.as_renamed();
        }
        if (this.mCameraUIInterface.A_renamed()) {
            return;
        }
        this.mCameraUIInterface.r_renamed(true);
        if (isPanelMode()) {
            this.mCameraUIInterface.a_renamed(0, true);
        } else {
            this.mCameraUIInterface.a_renamed(0, 1);
        }
        if (isShowProPanelMenu()) {
            return;
        }
        if (isInNightProMode() && z3) {
            return;
        }
        this.mCameraInterface.a_renamed(true, false);
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

    private boolean isAISSnapshotUseMFNR(boolean z_renamed) {
        int[] configIntArrayValue;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MFNR) && (configIntArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AIS_SNAPSHOT_USE_MFNR)) != null) {
            return z_renamed ? 1 == configIntArrayValue[1] : 1 == configIntArrayValue[0];
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setPreburstShotCapture(boolean z_renamed) {
        this.mbPreburstShotCapture = z_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemChange(int i_renamed) {
        if (this.mbPaused) {
            updateFaceBeautyValue(i_renamed);
            return;
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) || !this.mbFrontCamera || this.mbPreburstShotCapture) {
            super.onFaceBeautyItemChange(i_renamed);
            return;
        }
        int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
        com.oplus.camera.e_renamed.a_renamed(TAG, "onFaceBeautyItemChange, level: " + i_renamed + ", currentLevel: " + faceBeautyCurrIndex);
        if (faceBeautyCurrIndex != i_renamed) {
            if (i_renamed != 0) {
                this.mChangePreviewSize = getFaceBeautyPreviewSize();
                if (this.mChangePreviewSize != null) {
                    this.mCameraInterface.b_renamed(this.mChangePreviewSize);
                }
            } else {
                this.mCameraInterface.b_renamed(this.mLastPreviewSize);
            }
        }
        super.onFaceBeautyItemChange(i_renamed);
    }

    private android.util.Size getFaceBeautyPreviewSize() {
        if (this.mPreferences != null) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
            com.oplus.camera.e_renamed.a_renamed(TAG, "getFaceBeautyPreviewSize, pictureSizeType: " + string);
            double dX_renamed = 1.3333333333333333d;
            if (!"standard".equals(string) && !"standard_high".equals(string)) {
                if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(string)) {
                    dX_renamed = com.oplus.camera.util.Util.X_renamed();
                } else if ("square".equals(string)) {
                    dX_renamed = 1.0d;
                } else if ("16_9".equals(string)) {
                    dX_renamed = 1.7777777777777777d;
                }
            }
            java.util.List<android.util.Size> configSizeListValue = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE);
            if (configSizeListValue != null && configSizeListValue.size() > 0) {
                com.oplus.camera.e_renamed.a_renamed(TAG, "getFaceBeautyPreviewSize, sizeList: " + configSizeListValue.toString());
                return com.oplus.camera.util.Util.a_renamed(configSizeListValue, dX_renamed);
            }
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onFaceBeautyMenuClick() {
        android.util.Size faceBeautyPreviewSize;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT) && com.oplus.camera.e_renamed.a_renamed.j_renamed() != getProperCameraId(this.mCameraId) && !this.mbFrontCamera && !this.mbPreburstShotCapture) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onFaceBeautyMenuClick, isFaceBeautyMenuOpen: " + this.mCameraUIInterface.K_renamed());
            if (!this.mCameraUIInterface.K_renamed() && (faceBeautyPreviewSize = getFaceBeautyPreviewSize()) != null) {
                this.mCameraInterface.b_renamed(faceBeautyPreviewSize);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNightCaptureCountDown() {
        this.mNightCaptureTotalTime = ((long) this.mSeNightCostTime) >= 100 ? java.lang.Math.round(r0 / 1000.0f) * 1000 : 100L;
        this.mNightCountDownUI.a_renamed(this.mNightCaptureTotalTime);
        updateNightCaptureShutter();
    }

    private void pauseNightCapture() {
        com.oplus.camera.ui.p_renamed pVar = this.mNightCountDownUI;
        if (pVar != null) {
            pVar.b_renamed();
        }
    }

    public boolean isSuperSeNightOpen() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SE_NIGHT_SUPPORT)) {
            return this.mbAutoSeNight;
        }
        return false;
    }

    public boolean isSuperNightShutterCountDownOpen() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_MODE_SHUTTER_COUNTDOWN_SUPPORT)) {
            return this.mbNightShutterCountDown;
        }
        return false;
    }

    private void updateSeNightCaptureTime(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        if (cameraApsDecision != null) {
            this.mSeNightCostTime = cameraApsDecision.mNightTotalExpTime;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewDecisionResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        super.onPreviewDecisionResult(cameraApsDecision);
        updateSeNightCaptureTime(cameraApsDecision);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void resetWhenCaptureFail() {
        super.resetWhenCaptureFail();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$d_renamed$19iBhqhD5oPK5U7BWQ2wrzx52H8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$resetWhenCaptureFail$1$d_renamed();
                }
            });
        }
    }

    public /* synthetic */ void lambda$resetWhenCaptureFail$1$d_renamed() {
        if (this.mbPaused) {
            return;
        }
        this.mbCaptureRawTimeDone = true;
        this.mCameraUIInterface.d_renamed(true, false);
        resetAfterPictureTaken(isInNightProcess(), this.mbBurstShot);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getIsCapturingState() {
        return super.getIsCapturingState() || !this.mbCaptureRawTimeDone;
    }
}
