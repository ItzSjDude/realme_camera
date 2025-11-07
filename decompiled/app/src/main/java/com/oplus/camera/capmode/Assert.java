package com.oplus.camera.capmode;

/* loaded from: classes2.dex */
public abstract class BaseMode implements com.oplus.camera.d_renamed, com.oplus.camera.e_renamed.d_renamed.a_renamed {
    public static final int AI_SCN_OFF = 0;
    public static final int AI_SCN_ON = 1;
    public static final int BEAUTY3D_ADD_ICON = 1;
    public static final int BEAUTY3D_HEAD_ICON = 2;
    public static final int BEAUTY3D_MAX_NUM = 1;
    private static final int BLUR_INDEX_ERR = -1;
    private static final int CALCULATE_CURRENTLUX_MAX_FRAME_COUNT = 10;
    protected static final int CAPTURE_PREVIEW_DONE = 2;
    protected static final int CAPTURE_PREVIEW_IDLE = 0;
    protected static final int CAPTURE_PREVIEW_START = 1;
    public static final java.lang.String CONTACT_PACKAGE_NAME = "com.android.contacts";
    private static final int DATA_PADDING_ALIGN = 16;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_EXPECTED_FRAME_RATE = 30;
    private static final int DEFAULT_LUX_VALUE = 500;
    private static final int DIS_SCREEN_HINT_ICON_DELAY = 400;
    private static final int FACE_COUNT_CHECKING_SIZE = 30;
    private static final float FLASH_BRIGHTNESS = 0.8f;
    public static final java.lang.String GOOGLE_KEEP_PACKAGE_NAME = "com.google.android.keep";
    public static final int ISO_CONSTANT = 100;
    private static final java.lang.String KEY_IS_BURST_SHOT = "is_burst_shot";
    private static final java.lang.String KEY_PICTURE_DATA = "picture_data";
    private static final java.lang.String KEY_PICTURE_FORMAT = "picture_format";
    private static final java.lang.String KEY_PICTURE_HEIGHT = "picture_height";
    private static final java.lang.String KEY_PICTURE_WIDTH = "picture_width";
    private static final java.lang.String KEY_REQ_FORMAT = "request_format";
    public static final float MAX_BRIGHTNESS = 255.0f;
    public static final java.lang.String MMS_PACKAGE_NAME = "com.android.mms";
    private static final int MSG_AFTER_START_PREVIEW = 3;
    private static final int MSG_AFTER_TAKEPICTURE = 1;
    private static final int MSG_CODE_HIDE_FIRST_BEAUTY_BUBBLE_TIP = 10;
    private static final int MSG_CODE_HIDE_STREET_ROCKER_SHUTTER_BUBBLE = 11;
    private static final int MSG_CODE_SHOW_BUBBLE_TIP = 8;
    private static final int MSG_CODE_SHOW_FIRST_BEAUTY_BUBBLE_TIP = 9;
    private static final int MSG_CODE_SHOW_NEXT_TIP_AFTER_DRAWER_GUIDE = 7;
    private static final int MSG_CREATE_EFFECT_TEXTURE = 5;
    private static final int MSG_DIS_SCREEN_HINT_ICON = 2;
    private static final int MSG_PRE_UPDATE_THUMBNAIL = 6;
    private static final int MSG_UPDATE_EFFECT_MENUNAME = 4;
    public static final int NO_BEAUTY3D_ICON = 0;
    public static final java.lang.String PICTURE_SIZE_5M = "5000000";
    public static final java.lang.String PICTURE_SIZE_8M = "8000000";
    private static final int PI_OFF = 0;
    private static final int PI_ON = 1;
    private static final int PULL_DOWN_ANIMATION_DURATION = 500;
    private static final int SAT_CAMERA_NUMBER = 3;
    private static final int SLOGAN_OFF = 0;
    private static final int SLOGAN_ON = 1;
    private static final float SYSTEM_BRIGHTNESS = -1.0f;
    private static final java.lang.String TAG = "BaseMode";
    protected static final int TOLERATE_TIME = 10;
    public static final float VALUE_HYPER_LAPSE_ULTRA_WIDE = 0.6f;
    public static final int ZOOM_LIST_DEFAULT_LENGTH = 1;
    public com.oplus.camera.algovisualization.c_renamed algoVisualViewManager;
    protected android.app.Activity mActivity;
    protected com.oplus.camera.entry.b_renamed mCameraEntry;
    protected int mCameraEntryType;
    protected com.oplus.camera.capmode.a_renamed mCameraInterface;
    protected com.oplus.camera.ui.CameraUIInterface mCameraUIInterface;
    protected int mCaptureOrientation;
    public java.lang.String mModeName;
    protected android.content.SharedPreferences mPreferences;
    protected com.oplus.camera.ui.preview.a_renamed.t_renamed mPreviewEffectProcess;
    private com.oplus.camera.algovisualization.j_renamed mStatePreferenceHelper;
    protected boolean mbInCapturing;
    protected boolean mbShowPostCaptureAlert;
    public android.content.SharedPreferences preferences;
    public static final java.lang.String[] FILTER_KEYS = {com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE};
    public static final java.lang.String NOTE_PACKAGE_NAME = com.oplus.camera.v_renamed.c_renamed();
    protected static boolean sHighBrightness = false;
    private static boolean sbRearDirtyLensToastShown = true;
    private static boolean sbFrontDirtyLensToastShown = true;
    protected final java.lang.Object mApsDecisionResultLock = new java.lang.Object();
    protected final java.lang.Object mNeedCaptureLock = new java.lang.Object();
    private final java.lang.Object mCapturePreviewDataStateLock = new java.lang.Object();
    public float mPreviewXScale = 1.0f;
    public float mBrightness = 255.0f;
    public boolean mbHasClickedFromThird = false;
    public int[] mForceUpscaleSize = null;
    public int mApsDecisionSceneMode = 0;
    public java.lang.String[] mApsAlgoFlag = null;
    public int[] mCaptureEVList = null;
    public java.util.ArrayList<java.lang.String> mPreAlgoListFromApp = null;
    public java.util.ArrayList<java.lang.String> mCapAlgoListFromApp = null;
    protected int mOrientation = 0;
    protected int mJpgOrientation = 0;
    protected int mCameraId = 0;
    protected int mFirstCaptureHash = 0;
    protected int mPostCounter = 0;
    protected int mSensorNumber = 1;
    protected int mSysBrightness = 0;
    protected int mFlashTrigger = 0;
    protected boolean mbNeedCapture = false;
    protected boolean mbFrontCamera = false;
    protected boolean mbBurstShot = false;
    protected boolean mbInBurstShotCapturing = false;
    protected boolean mbInPreparing = false;
    protected volatile boolean mbPaused = false;
    protected volatile boolean mbDestroyed = false;
    protected boolean mbCapModeInit = false;
    protected boolean mbModePreInit = false;
    protected boolean mbAutoHDR = false;
    protected boolean mbAutoBinning = false;
    protected boolean mbAutoFlash = false;
    protected boolean mbAllowSwitchMode = true;
    protected boolean mbOpenViviEffectAfterBurstShot = false;
    protected boolean mbDisplayOnLock = false;
    protected boolean mbEnableTuningData = false;
    protected boolean mbResetAeLockAfterCaptured = false;
    protected boolean mbResetAwbLockAfterCaptured = false;
    protected boolean mbForbidPreferenceChange = false;
    protected boolean mbFlashTemporaryDisabled = false;
    protected boolean mbHDRAvoidedByAIS = false;
    protected boolean mbCaptureNotMatchMeta = false;
    protected boolean mbCaptureHasSuperTextResult = false;
    protected boolean mbAutoSeNight = false;
    protected boolean mbFirstShowAfterAuto = false;
    protected java.lang.String mHDRMode = "off";
    protected java.lang.String mFlashMode = "off";
    protected com.oplus.camera.e_renamed.d_renamed mOneCamera = null;
    protected android.view.ViewGroup mCameraRootView = null;
    protected java.util.List<java.lang.String> mEffectMenuNames = null;
    protected java.lang.String mEffectMenuSelect = "beauty";
    protected com.oplus.camera.aps.util.CameraApsDecision mDecisionResult = null;
    protected com.oplus.camera.u_renamed.a_renamed mDetectResult = null;
    protected int mCaptureStartedCallbackNum = 0;
    protected com.oplus.camera.aps.service.ApsService mApsService = null;
    protected java.lang.Integer mPreviweStreamNeedState = 1;
    protected com.oplus.camera.e_renamed.c_renamed mCaptureRequestTag = null;
    protected boolean mbRawRequestTag = false;
    protected boolean mbBackPressedAfterCapture = false;
    protected int mApsBracketMode = 0;
    protected int mAsdSceneValue = 0;
    protected long mCaptureDate = 0;
    protected int mApsDecisionFeatureType = 0;
    protected int mFaceCountStatusCount = 0;
    protected java.lang.String mFullAlgoKey = "";
    protected java.lang.String mFullAlgoValue = "";
    private java.lang.Object mFocusOutOfRange = null;
    private boolean mbNeedReloadFlashMenu = false;
    private boolean mbShowEnvironmentTips = false;
    private boolean mbTrackFocusOpen = false;
    private boolean mbSupportSelectPhotoRatio = false;
    private int mCapturePreviewDataState = 0;
    private java.lang.String mThumbnailTitle = null;
    private com.oplus.camera.c_renamed mBaseSloganUtil = null;
    private int mMergeIndex = 0;
    private long mCaptureMergeIdentity = 0;
    private long mReprocessMetadataTimeStamp = 0;
    private int mEVValueFromMetadata = 0;
    private boolean mbLuxHasChange = false;
    private int mMultiFrameCount = 1;
    private android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.capmode.BaseMode.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message == null) {
                com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.capmode.BaseMode.TAG, "handleMessage, msg is_renamed null");
            }
            com.oplus.camera.e_renamed.c_renamed(com.oplus.camera.capmode.BaseMode.TAG, "handleMessage, msg is_renamed: " + com.oplus.camera.capmode.BaseMode.this.getMessageType(message.what));
            switch (message.what) {
                case 1:
                    android.os.Bundle data = message.getData();
                    if (data != null) {
                        com.oplus.camera.capmode.BaseMode.this.doOnPictureCallback((byte[]) data.get(com.oplus.camera.capmode.BaseMode.KEY_PICTURE_DATA), ((java.lang.Integer) data.get(com.oplus.camera.capmode.BaseMode.KEY_PICTURE_WIDTH)).intValue(), ((java.lang.Integer) data.get(com.oplus.camera.capmode.BaseMode.KEY_PICTURE_HEIGHT)).intValue(), ((java.lang.Integer) data.get(com.oplus.camera.capmode.BaseMode.KEY_PICTURE_FORMAT)).intValue(), ((java.lang.Boolean) data.get(com.oplus.camera.capmode.BaseMode.KEY_IS_BURST_SHOT)).booleanValue(), ((java.lang.Integer) data.get(com.oplus.camera.capmode.BaseMode.KEY_REQ_FORMAT)).intValue());
                        break;
                    }
                    break;
                case 2:
                    com.oplus.camera.capmode.BaseMode.this.displayScreenHintIconInSwitchOn();
                    break;
                case 3:
                    com.oplus.camera.capmode.BaseMode.this.doAfterStartPreview();
                    break;
                case 4:
                    com.oplus.camera.capmode.BaseMode.this.updateEffectMenuNames();
                    break;
                case 5:
                    com.oplus.camera.capmode.BaseMode.this.doCreateEffectTextures((com.oplus.camera.ui.preview.a_renamed.p_renamed) message.obj);
                    break;
                case 6:
                    com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.a_renamed((com.oplus.camera.ui.control.e_renamed) message.obj, 1);
                    break;
                case 7:
                    if (!com.oplus.camera.capmode.BaseMode.this.mbPaused && com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface != null && !com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.aG_renamed()) {
                        com.oplus.camera.capmode.BaseMode.this.showNextTip();
                        break;
                    }
                    break;
                case 8:
                    if (!com.oplus.camera.capmode.BaseMode.this.mbPaused) {
                        com.oplus.camera.e_renamed.a_renamed("onShowBubble");
                        com.oplus.camera.capmode.BaseMode.this.onShowBubble();
                        com.oplus.camera.e_renamed.b_renamed("onShowBubble");
                        break;
                    }
                    break;
                case 9:
                    if (!com.oplus.camera.capmode.BaseMode.this.mbPaused && com.oplus.camera.capmode.BaseMode.this.mActivity != null) {
                        com.oplus.camera.capmode.BaseMode baseMode = com.oplus.camera.capmode.BaseMode.this;
                        baseMode.showFirstBubble(baseMode.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button), 17);
                        break;
                    }
                    break;
                case 10:
                    if (com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface != null && com.oplus.camera.capmode.BaseMode.this.mHandler != null) {
                        com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.f_renamed(17, true);
                        com.oplus.camera.capmode.BaseMode.this.mHandler.removeMessages(9);
                        break;
                    }
                    break;
                case 11:
                    if (com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface != null && com.oplus.camera.capmode.BaseMode.this.mHandler != null) {
                        com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.f_renamed(20, true);
                        break;
                    }
                    break;
            }
        }
    };
    private final com.oplus.ocs.camera.CameraPictureCallback mCameraPictureCallback = new com.oplus.ocs.camera.CameraPictureCallback() { // from class: com.oplus.camera.capmode.BaseMode.3
        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureFailed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            if (com.oplus.camera.capmode.BaseMode.this.interruptCaptureFailedEvent()) {
                com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.capmode.BaseMode.TAG, "onCaptureFailed, interruptCaptureFailedEvent");
                return;
            }
            super.onCaptureFailed(cameraPictureResult);
            int iIntValue = cameraPictureResult != null ? ((java.lang.Integer) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.CAPTURE_FAIL_CODE)).intValue() : 0;
            com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.capmode.BaseMode.TAG, "onCaptureFailed, resultCode: " + iIntValue);
            if (com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface != null && com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.c_renamed() != null) {
                com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.c_renamed().a_renamed(com.oplus.camera.capmode.BaseMode.this.mCaptureMergeIdentity);
            }
            if (iIntValue == 1) {
                com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.capmode.BaseMode.TAG, "beforeSnapping, memory is_renamed not enough!");
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MEMORY_NOT_ENOUGH_HINT)) {
                    com.oplus.camera.capmode.BaseMode.this.showLowMemory();
                }
                com.oplus.camera.capmode.BaseMode.this.resetWhenCaptureFail();
                com.oplus.camera.capmode.BaseMode.this.mbInCapturing = false;
            }
            com.oplus.camera.capmode.BaseMode.this.setAllowSwitchMode(true);
            com.oplus.camera.capmode.BaseMode.this.setCapturePreviewDataStateIdle();
            if (com.oplus.camera.capmode.BaseMode.this.mCameraInterface != null) {
                com.oplus.camera.capmode.BaseMode.this.mCameraInterface.f_renamed(true);
            }
            com.oplus.camera.capmode.BaseMode baseMode = com.oplus.camera.capmode.BaseMode.this;
            baseMode.onPictureCallback(null, 0, 0, baseMode.getImageFormat(), false, 0);
            if (!com.oplus.camera.capmode.BaseMode.this.mbBurstShot || com.oplus.camera.capmode.BaseMode.this.mbPaused) {
                return;
            }
            com.oplus.camera.capmode.BaseMode.this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.3.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.capmode.BaseMode.this.disableBurstShot();
                }
            });
        }
    };

    protected enum a_renamed {
        INPUT,
        OUTPUT
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getMessageType(int i_renamed) {
        switch (i_renamed) {
            case 1:
                return "MSG_AFTER_TAKEPICTURE";
            case 2:
                return "MSG_DIS_SCREEN_HINT_ICON";
            case 3:
                return "MSG_AFTER_START_PREVIEW";
            case 4:
                return "MSG_UPDATE_EFFECT_MENUNAME";
            case 5:
                return "MSG_CREATE_EFFECT_TEXTURE";
            case 6:
                return "MSG_PRE_UPDATE_THUMBNAIL";
            default:
                return null;
        }
    }

    public void afterStartRecording() {
    }

    public void afterStopRecording() {
    }

    public boolean allowSwitchCamera() {
        return true;
    }

    public void beforeConfig() {
    }

    public void beforeModeChanged() {
    }

    public void beforeStartRecording() {
    }

    public void beforeStartRecording(boolean z_renamed) {
    }

    protected boolean canCloseSubMenuWhenSwitchCamera() {
        return true;
    }

    protected boolean canShowResumeButton() {
        return true;
    }

    public boolean canShowTimeLapseProButtons() {
        return false;
    }

    public void cancelOp(boolean z_renamed) {
    }

    public boolean check3HDRPreCondition() {
        return false;
    }

    public void checkAiEnhancementVideoState() {
    }

    public void checkFunction() {
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void checkIfLockAutoExposure() {
    }

    public boolean checkSensorMask(boolean z_renamed, boolean z2) {
        return true;
    }

    public boolean checkVideoHdrPreCondition() {
        return false;
    }

    public void closeImageReader() {
    }

    public boolean consumeBackEventOnPictureTaken() {
        return false;
    }

    public boolean consumeImage(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        return false;
    }

    public void deleteCurrentVideo() {
    }

    protected boolean disableBokehHDR(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        return false;
    }

    public void disableRedDotHintOnModes() {
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return false;
    }

    public void doReturnToCaller(boolean z_renamed) {
    }

    public boolean enterNeedShutterButtonAlphaTransition() {
        return false;
    }

    protected boolean exclusiveInverse() {
        return false;
    }

    public void forceStopVideoRecording(boolean z_renamed) {
    }

    public void generateImageInfo(java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    protected com.oplus.camera.ui.control.e_renamed.c_renamed getAfterStoreRunnable() {
        return null;
    }

    public int getAssistViewLayoutType() {
        return 0;
    }

    protected java.lang.String getBackUpFaceBeautyKey() {
        return null;
    }

    public int getBeauty3DScanIconType(int i_renamed) {
        return 0;
    }

    protected int getBeauty3Dstatus() {
        return 0;
    }

    protected int getBubbleOffsetX(int i_renamed) {
        return 0;
    }

    protected int getBubbleOffsetY(int i_renamed) {
        return 0;
    }

    public java.lang.String getCameraFeature() {
        return null;
    }

    public abstract java.lang.String getCameraMode();

    protected com.oplus.camera.e_renamed.d_renamed.a_renamed getCaptureCallback() {
        return this;
    }

    public long getCaptureExposureTime() {
        return -1L;
    }

    public int getCaptureIso() {
        return -1;
    }

    public int getCurFilterListType() {
        return 0;
    }

    protected java.lang.String[] getCustomBeautyKeys() {
        return null;
    }

    protected int getDefaultMakeupIndex() {
        return 0;
    }

    public float getDefaultZoomValue(com.oplus.camera.e_renamed.h_renamed hVar) {
        return 1.0f;
    }

    public int getEnvironmentTipsThreshold() {
        return 0;
    }

    public int getExpectedFrameRate() {
        return 30;
    }

    protected java.lang.String getFaceBeautyKey() {
        return null;
    }

    protected int getFaceBeautyModeIndex() {
        return 0;
    }

    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return "key_filter_index";
    }

    public java.lang.String getFilterEffectPrevSelectedKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE;
    }

    public int getFilterNoneIndex() {
        return 0;
    }

    public java.lang.String getFilterRedpotKey(java.lang.String str) {
        return null;
    }

    public int getFilterTitleTexId() {
        return com.oplus.camera.R_renamed.string.camera_filter;
    }

    protected int getFrontDefaultCommonBeautyValue() {
        return 40;
    }

    public boolean getFrontEnable() {
        return true;
    }

    public java.lang.String getFullPictureSizeType() {
        return com.oplus.camera.statistics.model.DcsMsgData.FULL;
    }

    public boolean getGrandTourFilterKey(java.lang.String str) {
        return false;
    }

    protected java.lang.String getGuideLineKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_LINE_PHOTO;
    }

    protected int getHintTextId() {
        return -1;
    }

    public int getHyperLapseRate() {
        return 0;
    }

    public int getImageFormat() {
        return 256;
    }

    public com.oplus.camera.screen.f_renamed.a_renamed getLockedScreenMode() {
        return null;
    }

    protected java.lang.String[] getMakeupKeys() {
        return null;
    }

    protected int getMakeupOpenState() {
        return 1;
    }

    protected java.lang.String getMakeupTypeKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_MAKEUP_TYPE;
    }

    public java.lang.Byte getMovieHdrEnable() {
        return null;
    }

    protected com.oplus.camera.capmode.a_renamed.a_renamed getMultiCameraDecision() {
        return null;
    }

    public boolean getNeedCheckTimeStamp() {
        return true;
    }

    protected boolean getNeedStoreRawPic() {
        return false;
    }

    public abstract int getOperatingMode();

    public int getOrientationRectify() {
        return 0;
    }

    protected java.lang.String getPhotoRatio() {
        return null;
    }

    public com.oplus.camera.ui.q_renamed getPreviewOutlineProvider() {
        return null;
    }

    public int getPreviewStreamNum() {
        return 1;
    }

    public android.util.Size getPreviewSurfaceSize(android.util.Size size) {
        return size;
    }

    public android.media.CamcorderProfile getProfile() {
        return null;
    }

    protected boolean getQuickVideoRecording() {
        return false;
    }

    public boolean getRearEnable() {
        return true;
    }

    public int getReceiveBustShotNum() {
        return 0;
    }

    public long getResumePauseRecordingTotalTime() {
        return 0L;
    }

    public boolean getSupportFaceView() {
        return true;
    }

    public boolean getSupportGestureCapture() {
        return true;
    }

    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) {
        return z_renamed;
    }

    public int getVideoFps() {
        return 0;
    }

    public android.util.Range<java.lang.Integer> getVideoFpsRange() {
        return null;
    }

    protected int getVideoOrientation(int i_renamed) {
        return 0;
    }

    public java.lang.String getVideoSizeType() {
        return null;
    }

    public android.graphics.Bitmap getVideoThumbnail(int i_renamed) {
        return null;
    }

    protected boolean getZoomAutoMicroOpen() {
        return false;
    }

    public int getZoomBarOffset() {
        return 0;
    }

    public void handleStartError(boolean z_renamed, boolean z2) {
    }

    public void hideBubble(java.lang.String str) {
    }

    protected void hideViewWhileResume() {
    }

    protected boolean interruptCaptureFailedEvent() {
        return false;
    }

    public boolean is4k() {
        return false;
    }

    public boolean is4k120fps() {
        return false;
    }

    public boolean is4k60fps() {
        return false;
    }

    public boolean isAISceneOpen() {
        return false;
    }

    public boolean isAfFixFocuse() {
        return false;
    }

    public boolean isAiEnhancementVideoOpen() {
        return false;
    }

    public boolean isAnimojiOpen() {
        return false;
    }

    public boolean isAntibandingEnable() {
        return true;
    }

    public boolean isAnyModeAnimationRunning() {
        return false;
    }

    public boolean isAutoFocus() {
        return true;
    }

    public boolean isBackPortraitCameraSwitching() {
        return false;
    }

    protected boolean isBlurOpen() {
        return false;
    }

    public boolean isBottomGuideEntryViewShown() {
        return false;
    }

    protected boolean isCameraSettingMenuOptionEnable(java.lang.String str) {
        return true;
    }

    protected boolean isCaptureInDarkLight(int i_renamed) {
        return false;
    }

    public boolean isCaptureModeType() {
        return true;
    }

    public boolean isCommonVideoMode() {
        return false;
    }

    public boolean isCountDownStarted() {
        return false;
    }

    public boolean isCropX() {
        return false;
    }

    public boolean isDoubleExposureOpen() {
        return false;
    }

    public boolean isFaceRectifyMenuOpen() {
        return false;
    }

    public boolean isFaceRectifyOpen() {
        return false;
    }

    public boolean isFastVideoMode() {
        return false;
    }

    public boolean isFirstTipsEnable(java.lang.String str) {
        return false;
    }

    public boolean isFishEyeMode() {
        return false;
    }

    protected boolean isFixFocusOpen() {
        return false;
    }

    protected boolean isHFR() {
        return false;
    }

    public boolean isHalVideoRecording() {
        return false;
    }

    protected boolean isHideHeadLine() {
        return false;
    }

    protected boolean isHideUICapture() {
        return false;
    }

    public boolean isHighPictureSize() {
        return false;
    }

    public boolean isHistogramOpen() {
        return false;
    }

    protected boolean isHyperLapseOpen() {
        return false;
    }

    public boolean isHyperLapseUltraWideOpen() {
        return false;
    }

    public boolean isIdPhotoOpen() {
        return false;
    }

    public boolean isImmediateCapture() {
        return true;
    }

    protected boolean isInNightProcess() {
        return false;
    }

    protected boolean isInOfflineNightProcess() {
        return false;
    }

    protected boolean isInProMode() {
        return false;
    }

    public boolean isLongExposureSceneMenuOpen() {
        return false;
    }

    public boolean isMicroscopeMode() {
        return false;
    }

    protected boolean isModeBarSelected() {
        return false;
    }

    public boolean isMonoIndex(int i_renamed) {
        return false;
    }

    public boolean isMultiStickerOpen() {
        return false;
    }

    public boolean isMultiVideoMode() {
        return false;
    }

    public boolean isNeedAPSProcess() {
        return true;
    }

    public boolean isNeedMetaDataWhenPause() {
        return false;
    }

    public boolean isNeedProgressBarInCapture() {
        return false;
    }

    public boolean isNeedResetAutoFocus() {
        return true;
    }

    public boolean isNeedSetRecordingMargin() {
        return false;
    }

    protected boolean isNeedSetZslWhenCapture() {
        return true;
    }

    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return true;
    }

    public boolean isNeedTransAnimWhenRecording() {
        return true;
    }

    public boolean isNeonEnable() {
        return false;
    }

    public boolean isPIAISceneOpen() {
        return false;
    }

    public boolean isPIModeOpen() {
        return false;
    }

    protected boolean isQuickVideoInRestriction() {
        return false;
    }

    protected boolean isRawOpen() {
        return false;
    }

    protected boolean isRawRequestTag() {
        return false;
    }

    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    public boolean isShowAnimojiMenu() {
        return false;
    }

    public boolean isShowBeauty3D() {
        return false;
    }

    public boolean isShowFaceBeautyMenu() {
        return true;
    }

    public boolean isShowFixFocusMenu() {
        return false;
    }

    public boolean isShowProPanelMenu() {
        return false;
    }

    public boolean isShowProgressBarForOtherApp() {
        return true;
    }

    public boolean isShowSceneNightTips() {
        return false;
    }

    public boolean isShowZoomMenu() {
        return true;
    }

    public boolean isShowingGuideView() {
        return false;
    }

    public boolean isSloganForceLandscape() {
        return false;
    }

    public boolean isSlowVideoMode() {
        return false;
    }

    protected boolean isStarVideoOpen() {
        return false;
    }

    public boolean isStarryMode() {
        return false;
    }

    public boolean isStickerMenuOpen() {
        return false;
    }

    public boolean isStreamerEnable() {
        return false;
    }

    public boolean isStreamerOpen() {
        return false;
    }

    public boolean isStreetOpen() {
        return false;
    }

    public boolean isSubMenuEnable() {
        return true;
    }

    protected boolean isSuperClearPortraitEnable() {
        return false;
    }

    protected boolean isSuperClearPortraitOpen() {
        return false;
    }

    protected boolean isSuperEISOpen() {
        return false;
    }

    protected boolean isSuperEISProOpen() {
        return false;
    }

    protected boolean isSuperRawOpen() {
        return false;
    }

    public boolean isSuperTextOpen() {
        return false;
    }

    public boolean isSupportAutoFocus() {
        return true;
    }

    public boolean isSupportLensSwicth() {
        return true;
    }

    protected boolean isTiltShiftOpen() {
        return false;
    }

    protected boolean isTiltShiftSupportBeauty() {
        return false;
    }

    public boolean isUltraHighResolutionOpened() {
        return false;
    }

    public boolean isUltraNightVideoOpen() {
        return false;
    }

    public boolean isUltraWideHighPictureSize() {
        return false;
    }

    protected boolean isUseMediaCodec() {
        return false;
    }

    protected boolean isUseMediaRecorderNotUseAPS() {
        return true;
    }

    public boolean isVideo10BitOpen() {
        return false;
    }

    public boolean isVideoHighFps() {
        return false;
    }

    public boolean isVideoModeType() {
        return false;
    }

    protected boolean isVideoNeonOpen() {
        return false;
    }

    public boolean isVideoRecordStarted() {
        return false;
    }

    public boolean isVideoRecordStarting() {
        return false;
    }

    public boolean isVideoRecordStopped() {
        return true;
    }

    public boolean isVideoRecordStopping() {
        return false;
    }

    public boolean isVideoRecording() {
        return false;
    }

    protected boolean isVideoRetentionOpen() {
        return false;
    }

    public boolean isVideoSuperEisWideOpen() {
        return false;
    }

    protected boolean isVideoTimeLapseTiltShiftOpen() {
        return false;
    }

    public boolean isZoomFaceRectifySupported() {
        return false;
    }

    protected void lastCaptureFrameArrive() {
    }

    public boolean needApsToProcessVideoWatermark() {
        return false;
    }

    protected boolean needCancelToForceStop() {
        return false;
    }

    public boolean needClearFocusView() {
        return false;
    }

    public boolean needConfigPhysicalStream(java.lang.String str) {
        return false;
    }

    public boolean needDelayCloseForCapture() {
        return true;
    }

    public boolean needDelayFaceDetection() {
        return false;
    }

    public boolean needDeleteTheSizeByRatio(java.lang.String str) {
        return false;
    }

    public boolean needLutTexture() {
        return false;
    }

    protected boolean needOverlayBitmap() {
        return true;
    }

    public boolean needPostProcessAfterStopRecord() {
        return false;
    }

    public boolean needPreviewMeta(int i_renamed) {
        return true;
    }

    public boolean needStoreImage() {
        return true;
    }

    protected boolean needUpdateAsdSceneValue() {
        return false;
    }

    public boolean needUpdateFlashIcon() {
        return true;
    }

    protected void onAISSnapshotChecked(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
    }

    public void onAISceneClosed(int i_renamed) {
    }

    protected abstract void onAfterPictureTaken(byte[] bArr, boolean z_renamed);

    public boolean onAfterSnapping() {
        return true;
    }

    public void onApsPreviewCaptureCompleted(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, boolean z_renamed) {
    }

    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
    }

    protected abstract void onBeforePreview();

    protected abstract boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar);

    protected void onBinauralRecordStateChanged(boolean z_renamed) {
    }

    protected boolean onBurstShotCapture() {
        return true;
    }

    public void onCameraIdChangedAnimationEnd() {
    }

    public void onCameraPermissionGranted() {
    }

    protected void onCancelTakePicture() {
    }

    public void onCancleCapturePictureRequest() {
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult) {
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureSequenceCompleted() {
    }

    protected abstract void onDeInitCameraMode(java.lang.String str);

    protected abstract void onDestroy();

    protected void onDisableBurstShot() {
    }

    public boolean onDown(android.view.MotionEvent motionEvent) {
        return false;
    }

    public boolean onEffectItemClick(int i_renamed) {
        return false;
    }

    public void onEffectMenuPopDown(boolean z_renamed) {
    }

    public void onEffectMenuPopUp() {
    }

    public boolean onFaceBeautyMenuClick() {
        return true;
    }

    public void onFaceBeautyMenuClose() {
    }

    protected void onFilterListTypeChanged(int i_renamed) {
    }

    protected void onFilterMenuClicked() {
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onFirstCaptureFrameAdd() {
    }

    protected void onFrameInterpolationStarted() {
    }

    public com.oplus.camera.statistics.model.DcsMsgData onGetAfterCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) {
        return dcsMsgData;
    }

    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        return dcsMsgData;
    }

    public void onGetNearMeOnClickData() {
    }

    public void onHomeKeyClick() {
    }

    public boolean onImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        return false;
    }

    protected abstract void onInitCameraMode();

    public boolean onLongPress(android.view.MotionEvent motionEvent) {
        return false;
    }

    public void onMenuBackButtonClick() {
    }

    public void onMenuOptionAdded(java.lang.String str) {
    }

    public void onMenuOptionRemoved(java.lang.String str) {
    }

    public void onModeShownTips(int i_renamed) {
    }

    public void onMoreModeHidden(int i_renamed) {
    }

    public void onMoreModeShown() {
    }

    protected void onMotionDetected() {
    }

    protected abstract void onPause();

    protected boolean onPreviewFrameReceived(android.media.Image image) {
        return true;
    }

    public void onProcessCapturePictureRequest() {
    }

    public void onRawImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
    }

    protected void onResumeFromSetting() {
    }

    public void onScreenOffWhenLocked() {
    }

    public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
        return false;
    }

    public void onSendCapturePictureRequest() {
    }

    public void onShareMenuExpand() {
    }

    public void onShutterButtonLongClick() {
    }

    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        return false;
    }

    public void onSlowVideoFrameChange(int i_renamed) {
    }

    public void onStartCapturePreviewData() {
    }

    protected abstract void onStop();

    protected abstract boolean onStopTakePicture();

    public void onSuperEISChange() {
    }

    protected void onSwitchCameraButtonClick() {
    }

    public void onTeleAngleOpened() {
    }

    protected void onTopSubMenuCollapse() {
    }

    protected void onTopSubMenuExpand() {
    }

    public void onTouchFocus() {
    }

    public void onUltraWideAngleOpened() {
    }

    public void onVideoLoadedDone(com.oplus.camera.doubleexposure.b_renamed bVar, com.oplus.camera.doubleexposure.g_renamed.a_renamed aVar) {
    }

    public void onVideoRecordingFail() {
    }

    public void onVideoRecordingFinish() {
    }

    public boolean onVideoRecordingPause() {
        return false;
    }

    public boolean onVideoRecordingResume() {
        return false;
    }

    public void onVideoRetakeButtonClick() {
    }

    /* renamed from: onVideoShutterButtonClick */
    public void aj_renamed() {
    }

    public void onVideoTemperatureThresholdChanged(int i_renamed) {
    }

    public void onYuvDataReceviced(byte[] bArr) {
    }

    public void onZoomAlphaChanged(float f_renamed) {
    }

    public void onZoomChanged() {
    }

    public void onZoomMenuCollapsed() {
    }

    public void onZoomMenuCollapsing() {
    }

    public void onZoomMenuExpand() {
    }

    public void onZoomTransitionChanged(int i_renamed) {
    }

    public void operateSpecificViewCallBack(java.lang.Object obj, boolean z_renamed, boolean z2) {
    }

    public void operateViewWhenMultiFinger(boolean z_renamed) {
    }

    public boolean performSlide(int i_renamed, android.view.MotionEvent motionEvent) {
        return false;
    }

    public void reportIntelligentDragViewMoveToDcs(int i_renamed, int i2, boolean z_renamed, int i3) {
    }

    public void resetCaptureButton() {
    }

    public void resetFiltersList() {
    }

    public void resetMetadataBokehCode() {
    }

    protected void resetWhenCaptureFail() {
    }

    public void restoreDefaultMode(boolean z_renamed) {
    }

    protected void restoreEffectAfterBurstShot() {
    }

    public void revertOp() {
    }

    protected void saveAndClearEffectBeforeBurstShot() {
    }

    protected void setBeauty3DState(int i_renamed) {
    }

    public void setFlashState() {
    }

    protected void setFocusTrackingLocation(float f_renamed, float f2) {
    }

    protected void setFocusTrackingState(boolean z_renamed) {
    }

    protected void setFocusingSoundVolume(int i_renamed) {
    }

    public void setLowBatteryState(boolean z_renamed) {
    }

    public void setOpenFaceBeautyMenu(boolean z_renamed) {
    }

    public void setPIEnable(int i_renamed, boolean z_renamed) {
    }

    public void setPreburstShotCapture(boolean z_renamed) {
    }

    protected void setQuickVideoBeforeLockTime(boolean z_renamed) {
    }

    protected void setVideoBlurOpen(boolean z_renamed) {
    }

    protected void setVideoSoundValue(float f_renamed) {
    }

    public boolean shouldHideBlur() {
        return true;
    }

    public boolean showEffectMenu() {
        return true;
    }

    public void startLoadVideo(boolean z_renamed) {
    }

    public void startPlayVideoActivity() {
    }

    public void startScreenTorch() {
    }

    protected void startShortVideoRecording() {
    }

    protected void stopQuickVideoRecording() {
    }

    protected void stopRecordingFrame() {
    }

    public void stopScreenTorch() {
    }

    protected void stopShortVideoRecording() {
    }

    public void stopVideoRestoreUIWithControlUI() {
    }

    protected boolean supportParameterAdjust() {
        return false;
    }

    public void switchSuperEISWide(boolean z_renamed) {
    }

    protected void switchVideoBlur(boolean z_renamed, boolean z2) {
    }

    public void updateControlPanelBgColor(int i_renamed) {
    }

    public void updateGrandTourCityFiltersPosition(java.lang.String str) {
    }

    public void updateHintView() {
    }

    public void updateRatioType() {
    }

    public boolean updateViewByEnterCameraType() {
        return false;
    }

    public BaseMode(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        this.mCameraInterface = null;
        this.mCameraUIInterface = null;
        this.mActivity = null;
        this.mPreferences = null;
        this.mPreviewEffectProcess = null;
        this.mCameraEntry = null;
        this.mCameraEntryType = 1;
        com.oplus.camera.e_renamed.a_renamed(TAG, "BaseMode, constructor init");
        this.mActivity = activity;
        this.mCameraInterface = aVar;
        this.mCameraUIInterface = cameraUIInterface;
        this.mPreferences = this.mCameraInterface.t_renamed();
        this.mPreviewEffectProcess = tVar;
        this.mCameraEntry = this.mCameraInterface.b_renamed();
        this.mCameraEntryType = this.mCameraEntry.J_renamed();
        this.mStatePreferenceHelper = new com.oplus.camera.algovisualization.j_renamed(this.mActivity);
    }

    public final int getProperCameraId(int i_renamed) {
        com.oplus.camera.entry.b_renamed bVar = this.mCameraEntry;
        if (bVar == null) {
            return -1;
        }
        return bVar.a_renamed(getCameraMode(), i_renamed);
    }

    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        java.lang.String str = "button_shape_ring_none";
        if (sharedPreferences != null) {
            java.lang.String string = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_shutter_mode_default_value));
            if (com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return new com.oplus.camera.ui.control.b_renamed(1, "button_color_inside_none", str, 0);
    }

    protected void onResume(boolean z_renamed) {
        this.mbLuxHasChange = false;
    }

    public void resetAeLockAfterCaptured() {
        com.oplus.camera.e_renamed.d_renamed dVar;
        if (!this.mbResetAeLockAfterCaptured || (dVar = this.mOneCamera) == null) {
            return;
        }
        this.mbResetAeLockAfterCaptured = false;
        dVar.b_renamed(this.mCameraInterface.z_renamed(), false);
        if (this.mCameraInterface.i_renamed()) {
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    public void resetAwbLockAfterCaptured() {
        com.oplus.camera.e_renamed.d_renamed dVar;
        if (!this.mbResetAwbLockAfterCaptured || (dVar = this.mOneCamera) == null) {
            return;
        }
        this.mbResetAwbLockAfterCaptured = false;
        dVar.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
        if (this.mCameraInterface.i_renamed()) {
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    private void showBubble() {
        this.mHandler.removeMessages(8);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(8), 100L);
    }

    protected void showFirstBeautyTipView() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            android.os.Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 9;
            this.mHandler.sendMessage(messageObtainMessage);
        }
    }

    protected void hideFirstBeautyTipView() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(10));
        }
    }

    protected void hideStreetRockerShutterTipView() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(11));
        }
    }

    public void onShowBubble() {
        com.oplus.camera.capmode.a_renamed aVar;
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null || (sharedPreferences != null && (!sharedPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false) || !this.mPreferences.getBoolean("pref_camera_statement_key", false)))) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "onShowBubble return");
        } else {
            if (this.mCameraUIInterface == null || (aVar = this.mCameraInterface) == null || !aVar.i_renamed() || this.mCameraInterface.S_renamed()) {
                return;
            }
            showNextTip();
        }
    }

    public void showFirstBubble(android.view.View view, int i_renamed) {
        if (this.mCameraUIInterface != null) {
            int bubbleOffsetX = getBubbleOffsetX(i_renamed);
            if (-1 != bubbleOffsetX) {
                this.mCameraUIInterface.a_renamed(view, i_renamed, bubbleOffsetX, getBubbleOffsetY(i_renamed));
            } else {
                com.oplus.camera.e_renamed.e_renamed(TAG, "showFirstBubble, ultra wide anchor view not found");
            }
        }
    }

    public void sendDrawerSettingGuideAniDelayMessage() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(7), 1000L);
    }

    public void showNextTip() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(7);
        }
    }

    public void showFirstTip() {
        android.os.Handler handler;
        if (!isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_BEAUTY_TIPS) || (handler = this.mHandler) == null) {
            return;
        }
        android.os.Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 9;
        this.mHandler.sendMessage(messageObtainMessage);
    }

    public int getDefaultCaptureNumber() {
        synchronized (this.mApsDecisionResultLock) {
            if (this.mDecisionResult == null) {
                return 1;
            }
            return this.mDecisionResult.mMultiFrameCount;
        }
    }

    public int getCaptureStreamNum() {
        return getPreviewStreamNum();
    }

    public void updateBracketMode(boolean z_renamed, int i_renamed) {
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.u_renamed(i_renamed);
            if (z_renamed) {
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    public void updateAsdSceneValue(boolean z_renamed, int i_renamed) {
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.v_renamed(i_renamed);
            if (z_renamed) {
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    private void updateNeonValue() {
        com.oplus.camera.e_renamed.d_renamed dVar;
        if (com.oplus.camera.util.Util.C_renamed()) {
            return;
        }
        if ((com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT)) && (dVar = this.mOneCamera) != null) {
            dVar.C_renamed("neon-2020.cube.rgb.bin".equals(getCurrFilterType()));
        }
    }

    public void updateRearAicolorEnable(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.r_renamed(z2);
            if (z_renamed) {
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    public void updateVideoNeonEnable(boolean z_renamed, boolean z2) {
        if (this.mOneCamera != null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "setVideoNeonEnable, submit: " + z_renamed + ", enable: " + z2);
            this.mOneCamera.s_renamed(z2);
            if (z_renamed) {
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    public void updateVideoBlurEnable(boolean z_renamed, boolean z2) {
        if (this.mOneCamera != null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "setVideoBlurEnable, submit: " + z_renamed + ", enable: " + z2);
            this.mOneCamera.t_renamed(z2);
            if (z_renamed) {
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    public void onPreviewDecisionResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        if (this.mbDestroyed) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onPreviewDecisionResult, mbDestroyed is_renamed true, so return.");
            return;
        }
        com.oplus.camera.e_renamed.c_renamed captureRequestTag = getCaptureRequestTag(cameraApsDecision, true);
        if (this.mStatePreferenceHelper == null) {
            android.app.Activity activity = this.mActivity;
            if (activity == null) {
                com.oplus.camera.e_renamed.a_renamed(TAG, "onPreviewDecisionResult, mActivity is_renamed null, so return.");
                return;
            }
            this.mStatePreferenceHelper = new com.oplus.camera.algovisualization.j_renamed(activity);
        }
        if (this.mStatePreferenceHelper.b_renamed() && this.mStatePreferenceHelper.a_renamed()) {
            com.oplus.camera.algovisualization.d_renamed dVar = new com.oplus.camera.algovisualization.d_renamed(isBlurOpen(), isFilterOpen(getCurrFilterType()), isFaceBeautyOpen(), isMultiStickerOpen(), isAnimojiOpen(), getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS), isVideoNeonOpen(), isSuperTextOpen(), isVideoRetentionOpen(), isTiltShiftOpen(), isDoubleExposureOpen(), isFishEyeMode(), this.mbBurstShot, isFaceRectifyOpen(), getSupportFunction(com.oplus.camera.aps.config.CameraFunction.DERED_EYE), isFlashState(), getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_RETENTION), isHasSuperTextDetectResult(), isSloganOpen(), getTiltShiftBlurValue(), this.mCameraId);
            this.mCapAlgoListFromApp = dVar.a_renamed(captureRequestTag);
            this.mPreAlgoListFromApp = dVar.a_renamed();
            if (cameraApsDecision != null) {
                this.mFullAlgoKey = cameraApsDecision.mFullAlgoKey;
                this.mFullAlgoValue = cameraApsDecision.mFullAlgoValue;
            }
        }
        synchronized (this.mApsDecisionResultLock) {
            if (cameraApsDecision != null) {
                this.mMultiFrameCount = cameraApsDecision.mMultiFrameCount;
                this.mApsDecisionSceneMode = cameraApsDecision.mApsDecisionSceneMode;
                this.mApsDecisionFeatureType = cameraApsDecision.mApsDecisionFeatureType;
                this.mApsAlgoFlag = cameraApsDecision.mApsAlgoFlag;
                this.mCaptureEVList = cameraApsDecision.mCaptureEVList;
                this.mApsBracketMode = cameraApsDecision.mApsBracketMode;
            }
            if (!this.mbInCapturing && !this.mbPaused && this.mbCapModeInit) {
                boolean z_renamed = this.mDecisionResult == null && cameraApsDecision != null;
                this.mDecisionResult = cameraApsDecision;
                updateAutoHDRUI(cameraApsDecision);
                updateAutoSeNightUI(cameraApsDecision);
                if (z_renamed) {
                    this.mCameraUIInterface.n_renamed(getSupportQuickJpeg(null) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CACHE_WHILE_PREVIEW));
                }
                synchronized (this.mNeedCaptureLock) {
                    if (this.mbNeedCapture) {
                        com.oplus.camera.e_renamed.a_renamed(TAG, "onPreviewDecisionResult, needCapture");
                        this.mbNeedCapture = false;
                        if (this.mOneCamera != null) {
                            this.mOneCamera.l_renamed().post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.4
                                @Override // java.lang.Runnable
                                public void run() throws android.content.res.Resources.NotFoundException {
                                    com.oplus.camera.capmode.BaseMode.this.capture(false);
                                }
                            });
                        }
                    }
                }
                return;
            }
            com.oplus.camera.e_renamed.f_renamed(TAG, "onPreviewDecisionResult, mbInCapturing: " + this.mbInCapturing + ", mbPaused: " + this.mbPaused + ", mbCapModeInit: " + this.mbCapModeInit);
        }
    }

    private void updateAutoHDRUI(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        boolean z_renamed;
        boolean z2;
        this.mbHDRAvoidedByAIS = false;
        if (isAutoHDR() && cameraApsDecision != null && !this.mbBurstShot) {
            int i_renamed = cameraApsDecision.mApsDecisionSceneMode;
            boolean z3 = this.mbAutoHDR;
            if (1 == i_renamed || 11 == i_renamed || 14 == i_renamed || 23 == i_renamed || 1 == cameraApsDecision.mApsDecisionShowHdrIcon) {
                this.mbAutoHDR = true;
                synchronized (this.mApsDecisionResultLock) {
                    if (this.mDecisionResult.mAISState > 0 && !isOpenHDR()) {
                        this.mbHDRAvoidedByAIS = true;
                        this.mbAutoHDR = false;
                    }
                }
                if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
                    this.mbAutoHDR = false;
                }
                if (this.mCameraUIInterface.aU_renamed()) {
                    this.mbAutoHDR = false;
                }
                if (isOpenHDR() || this.mbShowPostCaptureAlert || z3 == (z_renamed = this.mbAutoHDR)) {
                    return;
                }
                displayAllIcon(z_renamed, this.mbAutoFlash);
                return;
            }
            this.mbAutoHDR = false;
            if (isOpenHDR() || this.mbShowPostCaptureAlert || z3 == (z2 = this.mbAutoHDR)) {
                return;
            }
            displayAllIcon(z2, this.mbAutoFlash);
            return;
        }
        this.mbAutoHDR = false;
    }

    private void updateAutoSeNightUI(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SE_NIGHT_SUPPORT) || 2 == this.mCameraInterface.g_renamed()) {
            return;
        }
        if (!this.mbBurstShot && cameraApsDecision != null && ((35 == cameraApsDecision.mApsDecisionFeatureType || 40 == cameraApsDecision.mApsDecisionFeatureType) && 12 != this.mCameraInterface.j_renamed())) {
            this.mbAutoSeNight = true;
            if (this.mCameraUIInterface.av_renamed()) {
                return;
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_night, -1, false, false, false, com.oplus.camera.R_renamed.drawable.se_night_hint_icon);
            return;
        }
        this.mbAutoSeNight = false;
        if (this.mActivity == null || !this.mCameraUIInterface.l_renamed().equals(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_ai_scn_night))) {
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_night);
    }

    public com.oplus.camera.e_renamed.c_renamed getCaptureRequestTag(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed cVar = new com.oplus.camera.e_renamed.c_renamed();
        java.lang.String currFilterType = getCurrFilterType();
        cVar.i_renamed = currFilterType;
        cVar.f4423a = isSuperTextOpen();
        boolean z2 = true;
        cVar.g_renamed = getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS) && isBlurOpen();
        cVar.d_renamed = getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR) ? getSingleBlurAlgoName(currFilterType) : null;
        cVar.h_renamed = isVideoNeonOpen();
        cVar.R_renamed = getBlurIndex();
        cVar.S_renamed = getShowBlurValue();
        boolean z3 = this.mbBurstShot;
        cVar.j_renamed = z3;
        cVar.y_renamed = z3 ? com.oplus.camera.util.Util.d_renamed : getDefaultCaptureNumber();
        if (cameraApsDecision != null) {
            cVar.z_renamed = this.mbBurstShot ? 35 : cameraApsDecision.mRequestFormat;
            cVar.A_renamed = getCameraMode();
            cVar.B_renamed = this.mCameraInterface.aw_renamed();
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.LONG_EXPOSURE)) {
                cVar.z_renamed = 32;
                cVar.f4425c = true;
            }
            if (cVar.z_renamed == 32 || cVar.z_renamed == 37 || cVar.z_renamed == 36 || cVar.z_renamed == 34) {
                cVar.a_renamed(com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_RAW);
            } else {
                cVar.a_renamed(com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE);
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
                cVar.C_renamed = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
                cVar.D_renamed = isHDRState();
            }
            cVar.E_renamed = getCameraShutterType();
            cVar.F_renamed = this.mCameraInterface.ae_renamed();
            java.lang.String strAf = this.mCameraInterface.af_renamed();
            java.lang.String strAg = this.mCameraInterface.ag_renamed();
            if (android.text.TextUtils.isEmpty(strAg)) {
                cVar.G_renamed = strAf;
            } else {
                cVar.G_renamed = strAg;
                cVar.H_renamed = strAf;
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
                cVar.I_renamed = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, this.mActivity.getString(com.oplus.camera.R_renamed.string.ultra_wide_angle_default_value));
            }
            cVar.J_renamed = this.mOrientation;
            cVar.M_renamed = "on_renamed".equals((this.mbFrontCamera || this.mCameraUIInterface.e_renamed()) ? getMirror() : "off");
            cVar.O_renamed = this.mCameraInterface.j_renamed();
            cVar.P_renamed = this.mCameraInterface.l_renamed();
            cVar.Q_renamed = isSuperClearPortraitOpen();
            cVar.T_renamed = this.mbBurstShot ? 1 : getCaptureStreamNum();
            cVar.Z_renamed = getHeicCodecFormat();
            boolean z4 = 4 == cameraApsDecision.mApsDecisionFeatureType || 8 == cameraApsDecision.mApsDecisionFeatureType || 16 == cameraApsDecision.mApsDecisionFeatureType || 24 == cameraApsDecision.mApsDecisionFeatureType || 26 == cameraApsDecision.mApsDecisionFeatureType || 30 == cameraApsDecision.mApsDecisionFeatureType || 34 == cameraApsDecision.mApsDecisionFeatureType || 27 == cameraApsDecision.mApsDecisionFeatureType || 28 == cameraApsDecision.mApsDecisionFeatureType || 32 == cameraApsDecision.mApsDecisionFeatureType || 36 == cameraApsDecision.mApsDecisionFeatureType || 37 == cameraApsDecision.mApsDecisionFeatureType || 27 == cameraApsDecision.mApsDecisionSceneMode || 28 == cameraApsDecision.mApsDecisionSceneMode;
            boolean z5 = 12 == cameraApsDecision.mApsDecisionSceneMode || 13 == cameraApsDecision.mApsDecisionSceneMode || 30 == cameraApsDecision.mApsDecisionSceneMode;
            if ((z4 && !disableBokehHDR(cameraApsDecision) && !this.mbBurstShot) || ((isInNightProcess() && !this.mbBurstShot) || ((getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_BOKEH_HDR) && z5) || 13 == cameraApsDecision.mApsDecisionSceneMode || 26 == cameraApsDecision.mApsDecisionSceneMode))) {
                cVar.L_renamed = cameraApsDecision.mCaptureEVList;
            }
            synchronized (this.mApsDecisionResultLock) {
                cVar.K_renamed = this.mbBurstShot ? null : cameraApsDecision.mApsAlgoFlag;
            }
            cVar.N_renamed = this.mbBurstShot ? null : cameraApsDecision;
            if ((isApsDecisionAlgoOpen(com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_PF_V3) || isApsDecisionAlgoOpen(com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_PF_V1)) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI)) {
                cVar.f4424b = false;
            } else {
                cVar.f4424b = isFaceBeautyOpen();
            }
            if (isMakeupOpen()) {
                int currMakeupIndex = getCurrMakeupIndex();
                cVar.e_renamed = getMakeupType(currMakeupIndex);
                cVar.f_renamed = getMakeupItemValue(currMakeupIndex);
            } else {
                cVar.e_renamed = "none";
                cVar.f_renamed = 0;
            }
            this.mOneCamera.a_renamed(cVar.e_renamed, cVar.f_renamed);
            if (!this.mbBurstShot) {
                cVar.U_renamed = cameraApsDecision.mSupportCaptureZoomFeature;
                cVar.X_renamed = cameraApsDecision.mApsDecisionFeatureType;
                cVar.V_renamed = cameraApsDecision.mApsBracketMode;
                cVar.W_renamed = cameraApsDecision.mAsdSceneValue;
            }
            if (this.mbBurstShot || (!isInNightProcess() && getNightStateDecision() <= 0)) {
                z2 = false;
            }
            cVar.Y_renamed = z2;
            cVar.aa_renamed = z_renamed;
            return cVar;
        }
        com.oplus.camera.e_renamed.f_renamed(TAG, "ops, decisionResult is_renamed null");
        return cVar;
    }

    public boolean isMirrorEnable() {
        return this.mbFrontCamera && !isMultiVideoMode();
    }

    public void onThumbnailUpdated(com.oplus.camera.aps.service.ThumbnailItem thumbnailItem) {
        if (thumbnailItem == null || thumbnailItem.mOriginBitmap == null || thumbnailItem.mOriginBitmap.isRecycled()) {
            return;
        }
        thumbnailItem.mOriginBitmap.recycle();
        thumbnailItem.mOriginBitmap = null;
    }

    public void setCapturePreviewDataStateIdle() {
        setCapturePreviewDataState(0);
    }

    public void setCachePreviewStart(boolean z_renamed) {
        this.mCameraUIInterface.o_renamed(z_renamed);
    }

    protected void setCapturePreviewDataState(int i_renamed) {
        synchronized (this.mCapturePreviewDataStateLock) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "setCapturePreviewDataState: " + this.mCapturePreviewDataState + " -> " + i_renamed);
            this.mCapturePreviewDataState = i_renamed;
        }
    }

    private int getCapturePreviewDataState() {
        int i_renamed;
        synchronized (this.mCapturePreviewDataStateLock) {
            i_renamed = this.mCapturePreviewDataState;
        }
        return i_renamed;
    }

    protected void setCaptureRequestPictureSizeScale() {
        if (this.mOneCamera != null) {
            if (isApsDecisionAlgoOpen(com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SUPERPHOTO) && !this.mbBurstShot) {
                this.mOneCamera.g_renamed(1);
            } else {
                this.mOneCamera.g_renamed(0);
            }
        }
    }

    protected boolean isApsDecisionAlgoOpen(java.lang.String str) {
        synchronized (this.mApsDecisionResultLock) {
            if (this.mDecisionResult != null && this.mDecisionResult.mApsAlgoFlag != null) {
                for (java.lang.String str2 : this.mDecisionResult.mApsAlgoFlag) {
                    if (android.text.TextUtils.equals(str, str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    protected boolean isSupportNoneSat() {
        return com.oplus.camera.util.Util.b_renamed(getCameraMode(), this.mbFrontCamera);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureStarted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, long j_renamed, long j2) {
        int i_renamed;
        int i2;
        boolean z_renamed;
        boolean z2;
        com.oplus.camera.ui.preview.h_renamed hVar;
        boolean z3;
        int i3;
        com.oplus.camera.e_renamed.a_renamed("captureX onCaptureStarted frameNumber: " + j2 + ", timestamp: " + j_renamed, "08ct_CaptureStarted TS", j_renamed);
        final boolean z4 = this.mCaptureStartedCallbackNum == 0;
        this.mCaptureStartedCallbackNum++;
        boolean z5 = (this.mbBurstShot ? com.oplus.camera.util.Util.d_renamed : getDefaultCaptureNumber()) == this.mCaptureStartedCallbackNum;
        com.oplus.camera.e_renamed.c_renamed cVar = this.mCaptureRequestTag;
        boolean z6 = cVar != null && cVar.aa_renamed;
        final boolean z7 = this.mbBurstShot;
        boolean z8 = getCapturePreviewDataState() == 1;
        com.oplus.camera.e_renamed.b_renamed(TAG, "onCaptureStarted, burstShot: " + z7 + ", timestamp: " + j_renamed + ", firstFrame: " + z4 + ", capturePreviewStart: " + z8 + ", watchRequest: " + z6);
        if (z4) {
            this.mCaptureMergeIdentity = j_renamed;
            if (this.mCameraInterface != null && !z8 && needStoreImage()) {
                this.mCameraInterface.a_renamed(this.mCaptureMergeIdentity, this.mThumbnailTitle, getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_UPDATE_THUMBNAIL_USER_PICTURE), z6, z7);
            }
            com.oplus.camera.perf.ComprehensivePerformance.a_renamed(j_renamed, this.mCameraId, getCameraMode());
            android.app.Activity activity = this.mActivity;
            if (activity != null) {
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.capmode.BaseMode.this.mbPaused || com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface == null) {
                            return;
                        }
                        com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.o_renamed();
                    }
                });
            }
        }
        if (this.mActivity != null && getNeedCheckTimeStamp()) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.6
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.capmode.BaseMode.this.shutterCallback(z7, z4);
                }
            });
        }
        synchronized (this.mApsDecisionResultLock) {
            i_renamed = this.mDecisionResult != null ? this.mDecisionResult.mThumbnailIndex : 1;
            int i4 = this.mDecisionResult != null ? this.mDecisionResult.mApsDecisionFeatureType : 0;
            i2 = this.mDecisionResult != null ? this.mDecisionResult.mApsDecisionSceneMode : 0;
            boolean z9 = 5 == i4 || 38 == i4;
            boolean z10 = 4 == i4 || 8 == i4 || 16 == i4;
            boolean z11 = 12 == i2 || 13 == i2 || 30 == i2;
            z_renamed = z9 || isCaptureInDarkLight(i4) || z10;
            z2 = z10 || z11;
        }
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null) {
            com.oplus.camera.ui.preview.h_renamed hVarC = cameraUIInterface.c_renamed();
            if (i_renamed == this.mCaptureStartedCallbackNum && z8 && hVarC != null) {
                hVar = hVarC;
                z3 = z5;
                i3 = i2;
                hVarC.a_renamed(j2, this.mCaptureMergeIdentity, j_renamed, getSupportQuickJpeg(this.mOneCamera.v_renamed()), z_renamed);
            } else {
                hVar = hVarC;
                z3 = z5;
                i3 = i2;
            }
            if (getSupportQuickJpeg(this.mOneCamera.v_renamed()) && hVar != null) {
                hVar.a_renamed(j2, j_renamed);
            }
            if (!this.mbFrontCamera && z2 && ((!com.oplus.camera.util.Util.C_renamed() || 30 != i3) && hVar != null)) {
                hVar.b_renamed(j2, j_renamed);
            }
            if (z3) {
                this.mCameraUIInterface.o_renamed(false);
            }
        }
        com.oplus.camera.e_renamed.d_renamed("captureX onCaptureStarted frameNumber: " + j2, "08ct_CaptureStarted TS");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        if (cameraCaptureResult == null || cameraCaptureResult.getCaptureResult() == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("captureX onCaptureProgressed frameNumber: " + cameraCaptureResult.getCaptureResult().getFrameNumber(), "10ct_CaptureProgressed", com.oplus.camera.d_renamed.d_renamed.longValue());
        if (getSupportQuickJpeg(cVar) && com.oplus.camera.util.Util.C_renamed()) {
            try {
                java.lang.Long l_renamed = (java.lang.Long) cameraCaptureResult.getCaptureResult().get(com.oplus.camera.e_renamed.b_renamed.m_renamed);
                com.oplus.camera.e_renamed.c_renamed(TAG, "onCaptureProgressed, refTimestamp: " + l_renamed);
                if (l_renamed != null && l_renamed.longValue() > 0) {
                    this.mCameraUIInterface.o_renamed(false);
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.preview.h_renamed.f4666b.intValue(), this.mCaptureMergeIdentity, l_renamed.longValue());
                }
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.f_renamed(TAG, "onCaptureProgressed, error msg: " + e_renamed.getMessage());
            }
        }
        com.oplus.camera.e_renamed.d_renamed("captureX onCaptureProgressed frameNumber: " + cameraCaptureResult.getCaptureResult().getFrameNumber(), "10ct_CaptureProgressed");
    }

    protected boolean isHasSuperTextDetectResult() {
        com.oplus.camera.u_renamed.a_renamed aVar = this.mDetectResult;
        return aVar != null && aVar.c_renamed();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        java.lang.Object objA;
        com.oplus.camera.e_renamed.a_renamed("captureX onCaptureCompleted");
        if (cVar == null || this.mbDestroyed) {
            com.oplus.camera.e_renamed.c_renamed(TAG, "onApsCaptureCompleted, tag:" + cVar);
            return;
        }
        this.mbCaptureNotMatchMeta = false;
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null && !aVar.aN_renamed() && isNeedAPSProcess() && isSatOpen() && com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() <= 2 && (objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(cameraCaptureResult.getCaptureResult(), com.oplus.camera.e_renamed.b_renamed.ap_renamed)) != null && (objA instanceof java.lang.Integer)) {
            int iIntValue = ((java.lang.Integer) objA).intValue();
            synchronized (this.mApsDecisionResultLock) {
                if (iIntValue > 0) {
                    this.mSensorNumber = iIntValue;
                } else {
                    this.mSensorNumber = 1;
                }
            }
        }
        com.oplus.camera.e_renamed.b_renamed("captureX onCaptureCompleted");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCapturePrepared() {
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            aVar.aW_renamed();
        }
    }

    protected java.lang.String getSingleBlurAlgoName(java.lang.String str) {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SINGLE_PORTRAIT_SUPPORT) ? com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SINGLE_PORTRAIT : com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT) ? com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SINGLE_BOKEH : "portrait_retention".equals(str) ? com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SINGLE_AICOLOR : com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SINGLE_BLUR;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCanceled(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.f_renamed(TAG, "onCaptureCanceled, requestTag: " + cVar);
        this.mbCaptureNotMatchMeta = false;
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            aVar.a_renamed(this.mCaptureMergeIdentity, 0, 0);
        }
        onPictureCallback(null, 0, 0, getImageFormat(), false, 0);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.f_renamed(TAG, "onCaptureFailed, mCaptureMergeIdentity: " + this.mCaptureMergeIdentity);
        this.mbCaptureNotMatchMeta = false;
        if (this.mCameraInterface != null && cVar != null) {
            if (cVar.j_renamed) {
                this.mCameraInterface.a_renamed(this.mCaptureMergeIdentity, cVar.T_renamed, cVar.T_renamed);
            } else {
                int i_renamed = com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_RAW == cVar.a_renamed() || com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_REPROCESS == cVar.a_renamed() ? 1 : cVar.T_renamed;
                this.mCameraInterface.a_renamed(this.mCaptureMergeIdentity, i_renamed, cVar.y_renamed * i_renamed);
            }
        }
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null && cameraUIInterface.c_renamed() != null) {
            this.mCameraUIInterface.c_renamed().a_renamed(this.mCaptureMergeIdentity);
        }
        onPictureCallback(null, 0, 0, getImageFormat(), false, 0);
    }

    public boolean getSupportMenu(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD)) {
            com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
            return (aVar != null && aVar.m_renamed()) || !isSubMenuEnable();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE.equals(strD)) {
            return getSupportFunction(strD);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strD)) {
        }
        return false;
    }

    public boolean needUploadOplusStatistics(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM.equals(str)) {
            return getSupportFunction(str) || this.mbBurstShot;
        }
        return getSupportFunction(str);
    }

    public void checkoutTimerSnapShotState() {
        com.oplus.camera.ui.control.b_renamed bVar = com.oplus.camera.util.Util.ao_renamed() ? new com.oplus.camera.ui.control.b_renamed(24, "button_color_inside_none", "button_shape_countdown_cancel") : new com.oplus.camera.ui.control.b_renamed(10, "button_color_inside_none");
        bVar.b_renamed(0);
        this.mCameraUIInterface.a_renamed(bVar);
    }

    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(com.oplus.camera.util.Util.ao_renamed() ? 23 : 11, "button_color_inside_none");
        bVar.b_renamed(0);
        this.mCameraUIInterface.a_renamed(bVar);
    }

    public boolean getScreenTorchModeState() {
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity));
        return (string.equals("on_renamed") || string.equals("auto")) && this.mbFrontCamera && !getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE);
    }

    public boolean isHeifEnable() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HEIF_SUPPORT) && !this.mbFrontCamera && is10bitsHeicEncodeEnable();
    }

    public boolean isSupportShowFilterMenu() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:143:0x0224  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 1242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.BaseMode.getSupportFunction(java.lang.String):boolean");
    }

    public boolean isFilterEffectOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) && com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a != getCurrFilterIndex();
    }

    protected boolean isAutoMacroOpen() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH)) {
            return "auto".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH, "auto"));
        }
        return false;
    }

    public boolean isFilterOpen(java.lang.String str) {
        return !"default".equals(str);
    }

    public boolean getIsShowPostCaptureAlert() {
        return this.mbShowPostCaptureAlert;
    }

    public int getNightStateDecision() {
        int i_renamed;
        synchronized (this.mApsDecisionResultLock) {
            int i2 = this.mDecisionResult != null ? this.mDecisionResult.mApsDecisionFeatureType : 0;
            i_renamed = (i2 == 9 || i2 == 10 || i2 == 11 || i2 == 13 || i2 == 29 || i2 == 14 || i2 == 21 || i2 == 31 || i2 == 32 || i2 == 35 || i2 == 40 || i2 == 41) ? this.mDecisionResult.mSuperNightScene : 0;
        }
        return i_renamed;
    }

    public boolean isTripodNight() {
        boolean z_renamed;
        synchronized (this.mApsDecisionResultLock) {
            z_renamed = true;
            if (this.mDecisionResult == null || this.mDecisionResult.mApsAlgoFlag == null || !com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SUPERNIGHT.equals(this.mDecisionResult.mApsAlgoFlag[0]) || this.mDecisionResult.mSuperNightScene != 1) {
                z_renamed = false;
            }
        }
        return z_renamed;
    }

    public void showLowMemory() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
    }

    public void beforeSwitchCamera() {
        if (this.mCameraUIInterface.T_renamed() && canCloseSubMenuWhenSwitchCamera()) {
            this.mCameraUIInterface.U_renamed();
        }
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.c_renamed(2);
        }
        if (this.mbFrontCamera) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_move_farther_away);
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_on_hint);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_off_hint);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_need_more_light);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_night);
        this.mCameraUIInterface.a_renamed(true, true, false);
        this.mCameraUIInterface.b_renamed(false);
        this.mbShowEnvironmentTips = false;
    }

    public void cameraIdChanged(int i_renamed) {
        this.mApsDecisionFeatureType = 0;
        this.mApsBracketMode = 0;
        this.mAsdSceneValue = 0;
        this.mbShowPostCaptureAlert = false;
        this.mPostCounter = 0;
        this.mCameraId = i_renamed;
        this.mbFrontCamera = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraId);
    }

    public final void resume(boolean z_renamed) {
        this.mbShowPostCaptureAlert = false;
        this.mbPaused = false;
        sbFrontDirtyLensToastShown = false;
        sbRearDirtyLensToastShown = false;
        this.mbDestroyed = false;
        setForceMode();
        onResume(z_renamed);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            setHDRMenuVisibility(true);
        } else {
            setHDRMenuVisibility(false);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EXPLORER_SUPPORT) && this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1) == 0) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.explorer_chip_damage_tip, 2000, new java.lang.Object[0]);
        }
    }

    public final void pause() {
        this.mbPaused = true;
        this.mbHasClickedFromThird = false;
        this.mbInCapturing = false;
        setBurstShotCapturing(false);
        setInPreparing(false);
        setAllowSwitchMode(true);
        sbFrontDirtyLensToastShown = false;
        sbRearDirtyLensToastShown = false;
        this.mbShowEnvironmentTips = false;
        this.mbCaptureNotMatchMeta = false;
        sHighBrightness = false;
        com.oplus.camera.e_renamed.a_renamed(TAG, "pause, mbInCapturing: " + this.mbInCapturing);
        onPause();
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (isOpenHDR()) {
            updateMenuWithHDRChange(false);
        }
        this.mCameraUIInterface.a_renamed(true, true, true);
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE)) {
            this.mCameraUIInterface.f_renamed(8, true);
        }
        setAutoFlash(false);
        setNeedCapture(false);
        this.mbAutoHDR = false;
        this.mbAutoBinning = false;
        this.mbOpenViviEffectAfterBurstShot = false;
        this.mPostCounter = 0;
        onGetNearMeOnClickData();
    }

    public final void stop() {
        onStop();
    }

    public final void destroy() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "destroy");
        this.mbDestroyed = true;
        onDestroy();
        this.mbCapModeInit = false;
        this.mbModePreInit = false;
        this.mPreferences = null;
        this.mPreviewEffectProcess = null;
        this.mActivity = null;
        this.mCameraInterface = null;
        this.mCameraRootView = null;
        this.mStatePreferenceHelper = null;
    }

    public final void beforePause() {
        setCapturePreviewDataState(0);
    }

    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        java.lang.Integer num;
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        if (this.mStatePreferenceHelper == null) {
            this.mStatePreferenceHelper = new com.oplus.camera.algovisualization.j_renamed(this.mActivity);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EXPLORER_SUPPORT)) {
            checkExplorerChipState(cameraPreviewResult.getCaptureResult());
        }
        if (this.algoVisualViewManager != null && this.mStatePreferenceHelper.b_renamed()) {
            this.algoVisualViewManager.d_renamed();
            if (this.algoVisualViewManager != null && this.mStatePreferenceHelper.a_renamed()) {
                this.algoVisualViewManager.a_renamed(cameraPreviewResult, this.mFullAlgoKey, this.mFullAlgoValue, this.mCapAlgoListFromApp, this.mPreAlgoListFromApp, getCameraMode(), this.mCameraId);
            }
        }
        android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT)) {
            java.lang.Integer num2 = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE);
            java.lang.Integer num3 = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_MODE);
            if (num2 != null && !this.mbBurstShot) {
                boolean z_renamed = this.mbAutoFlash;
                if (this.mCameraInterface.z_renamed()) {
                    setAutoFlash(false);
                } else if (!this.mbInCapturing) {
                    if (isAutoFrontTorch() && com.oplus.camera.ui.inverse.e_renamed.INS.isInverseAble(this.mActivity)) {
                        setAutoFlash(com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode()));
                    } else if (2 == num3.intValue()) {
                        if (4 == num2.intValue()) {
                            setAutoFlash(true);
                            if ("auto".equals(getFlashMode()) && this.mbFirstShowAfterAuto) {
                                this.mbFirstShowAfterAuto = false;
                                updateFlashState("auto", false);
                            }
                        } else if (2 == num2.intValue()) {
                            setAutoFlash(false);
                        }
                    }
                }
                if (this.mbAutoFlash != z_renamed) {
                    if (isOpenFlash() || isOpenFrontTorch() || this.mbShowPostCaptureAlert) {
                        return;
                    } else {
                        displayAllIcon(this.mbAutoHDR, this.mbAutoFlash);
                    }
                }
            }
        }
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.j_renamed(isAiEnhancementVideoOpen());
            java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.R_renamed);
            if (objA != null && (objA instanceof java.lang.Integer)) {
                this.mPreviewEffectProcess.i_renamed(isVideoModeType() ? ((java.lang.Integer) objA).intValue() : 0);
            }
        }
        java.lang.Object objA2 = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.Q_renamed);
        if (objA2 != null && (objA2 instanceof java.lang.Integer)) {
            java.lang.Integer num4 = (java.lang.Integer) objA2;
            if (103 == num4.intValue()) {
                this.mbAutoBinning = true;
            } else if (104 == num4.intValue()) {
                this.mbAutoBinning = false;
            }
        }
        java.lang.Object objA3 = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.S_renamed);
        if (objA3 != null && (objA3 instanceof java.lang.Integer)) {
            java.lang.Integer num5 = (java.lang.Integer) objA3;
            if (1002 == num5.intValue() || 1003 == num5.intValue()) {
                int i_renamed = this.mPostCounter;
                if (i_renamed > 0) {
                    this.mPostCounter = i_renamed - 1;
                }
                if (this.mCameraUIInterface.s_renamed() == 4 && (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_AUTO_NIGHT_SCENCE))) {
                    this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BURST_SHOT));
                }
                onCancelTakePicture();
            }
        }
        java.lang.Object objA4 = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.Y_renamed);
        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseAble(this.mActivity) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && "off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity)))) {
            if (com.oplus.camera.util.Util.a_renamed(captureResult) > com.oplus.camera.ui.inverse.e_renamed.INS.getThreshold()) {
                updateDimHintView(true);
            } else if (com.oplus.camera.util.Util.a_renamed(captureResult) < com.oplus.camera.ui.inverse.e_renamed.INS.getThresholdRecover()) {
                updateDimHintView(false);
            }
        } else if (objA4 != null && (objA4 instanceof int[])) {
            this.mFlashTrigger = ((int[]) objA4)[0];
            updateDimHintView(this.mFlashTrigger == 1);
        }
        java.lang.Object objA5 = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.av_renamed);
        if (objA5 instanceof java.lang.Integer) {
            this.mPreviweStreamNeedState = (java.lang.Integer) objA5;
        }
        if (shouldShowDirtyToast(cameraPreviewResult)) {
            showDirtyLensHintView();
        }
        java.lang.Integer num6 = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
        if (num6 != null) {
            this.mEVValueFromMetadata = num6.intValue();
        }
        java.lang.Object objA6 = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bj_renamed);
        if (this.mFocusOutOfRange != objA6) {
            this.mFocusOutOfRange = objA6;
            if (this.mCameraUIInterface != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPOORT_FOCUS_OUT_OF_RANGE) && objA6 != null && (objA6 instanceof java.lang.Integer)) {
                if (1 == ((java.lang.Integer) objA6).intValue() && !this.mCameraUIInterface.T_renamed() && !this.mbInCapturing && !this.mCameraUIInterface.aU_renamed()) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_move_farther_away, -1, false, false, true);
                } else {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_move_farther_away);
                }
            }
        }
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null && cameraUIInterface.aU_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_move_farther_away);
        }
        if ((!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MAINCAMERA_ASD_AISCENE_SUPPORT) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_WIDECAMERA_ASD_AISCENE_SUPPORT) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SATCAMERA_ASD_AISCENE_SUPPORT) && !needUpdateAsdSceneValue()) || (num = (java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_AI_SCENE)) == null || this.mAsdSceneValue == num.intValue()) {
            return;
        }
        this.mAsdSceneValue = num.intValue();
        updateAsdSceneValue(true, this.mAsdSceneValue);
    }

    private boolean shouldShowDirtyToast(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        java.lang.Object objA;
        if ((2 != com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() ? !(cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_LENS_DIRTY) == null || 1 != ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_LENS_DIRTY)).intValue()) : (objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(cameraPreviewResult.getCaptureResult(), com.oplus.camera.e_renamed.b_renamed.ao_renamed)) != null && (objA instanceof java.lang.Integer) && ((java.lang.Integer) objA).intValue() == 1) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION) && isLensDirtyDetectionOpen() && isZoomDirtyDetectionSupported(getZoomValue())) {
            return (this.mbFrontCamera && !sbFrontDirtyLensToastShown) || !(this.mbFrontCamera || sbRearDirtyLensToastShown);
        }
        return false;
    }

    private boolean isZoomDirtyDetectionSupported(float f_renamed) {
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
            if (java.lang.Float.compare(f_renamed, com.oplus.camera.ag_renamed.f4106a) != 0) {
                return java.lang.Float.compare(f_renamed, 1.0f) >= 0 && java.lang.Float.compare(f_renamed, 2.0f) <= 0;
            }
            return true;
        }
        float[] configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE);
        if (configFloatArrayValue == null || 2 != configFloatArrayValue.length) {
            return false;
        }
        if (java.lang.Float.compare(f_renamed, com.oplus.camera.ag_renamed.f4106a) == 0) {
            return true;
        }
        if (java.lang.Float.compare(f_renamed, 1.0f) >= 0 || java.lang.Float.compare(f_renamed, getMinZoomValue()) != 0) {
            return java.lang.Float.compare(f_renamed, configFloatArrayValue[0]) >= 0 && java.lang.Float.compare(f_renamed, configFloatArrayValue[1]) <= 0 && !getZoomAutoMicroOpen();
        }
        return true;
    }

    public boolean isLensDirtyDetectionOpen() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LENS_DIRTY_DETECTION, this.mActivity.getString(com.oplus.camera.R_renamed.string.lens_dirty_detection_default_value)));
        }
        return false;
    }

    public boolean isGestureOpen() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_gesture_shutter_default_value)));
        }
        return false;
    }

    private void showDirtyLensHintView() {
        if (this.mCameraUIInterface.Z_renamed()) {
            if (this.mbFrontCamera) {
                sbFrontDirtyLensToastShown = true;
            } else {
                sbRearDirtyLensToastShown = true;
            }
        }
    }

    public boolean onBackPressed() {
        if (isPanelMode()) {
            if (this.mCameraUIInterface.aw_renamed()) {
                this.mCameraUIInterface.F_renamed(false);
            } else {
                if (this.mCameraUIInterface.ay_renamed()) {
                    return true;
                }
                this.mCameraUIInterface.c_renamed((java.lang.String) null, !com.oplus.camera.util.Util.aa_renamed());
            }
            return true;
        }
        resetMonoFilter();
        return false;
    }

    public void setForceMode() {
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, com.oplus.camera.util.Util.b_renamed(this.mCameraInterface.m_renamed()));
        com.oplus.camera.e_renamed.a_renamed(TAG, "setForceMode, capMode: " + string + ", modeName: " + getCameraMode());
        if (string.equals(getCameraMode())) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, getCameraMode());
        editorEdit.apply();
    }

    public void setOrientation(int i_renamed) {
        this.mOrientation = i_renamed;
    }

    public void updateOneCamera(com.oplus.camera.e_renamed.d_renamed dVar) {
        this.mOneCamera = dVar;
    }

    public final void initCameraMode() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "initCameraMode");
        this.mbCapModeInit = false;
        this.mbModePreInit = false;
        if (this.mPreviewEffectProcess.k_renamed() != 0) {
            updateFilterParam(getCurrFilterIndex());
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(getCurrFilterType())) {
                this.mPreviewEffectProcess.c_renamed(true);
            } else {
                this.mPreviewEffectProcess.c_renamed(false);
            }
        }
        this.mbShowPostCaptureAlert = false;
        this.mOrientation = this.mCameraInterface.u_renamed();
        this.mbModePreInit = true;
        this.mbSupportSelectPhotoRatio = isSupportPhotoRatioMenu();
        this.mCameraRootView = this.mCameraUIInterface.b_renamed();
        this.mPreviewEffectProcess.c_renamed();
        onInitCameraMode();
        disableRedDotHintOnModes();
        this.mCameraUIInterface.q_renamed();
        removeSettingMenuOption(FILTER_KEYS);
        updateEffectMenuNames();
        if (isOpenHDR()) {
            updateMenuWithHDRChange(true);
        } else if (isAutoHDR()) {
            updateFlashMenuIfHDRIsAuto(this.mbFrontCamera);
        }
        this.mCameraUIInterface.a_renamed(getPreviewOutlineProvider());
        this.mCameraUIInterface.b_renamed(getCameraMode(), true);
        this.mbCapModeInit = true;
    }

    public final void deInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "deInitCameraMode, targetMode: " + str);
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mbModePreInit = false;
        this.mPostCounter = 0;
        restoreSettingMenuOption(FILTER_KEYS);
        setHDRMenuVisibility(false);
        if (isOpenHDR()) {
            updateMenuWithHDRChange(false);
            updateHDRMode("off", true);
        }
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            if (dVar.e_renamed().H_renamed()) {
                this.mOneCamera.q_renamed(false);
            } else if (isAutoHDR()) {
                this.mOneCamera.c_renamed("off");
            }
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_REGIONS, (android.hardware.camera2.CaptureRequest.Key) com.oplus.camera.a_renamed.b_renamed());
        }
        setAutoFlash(false);
        this.mbAutoHDR = false;
        this.mbAutoBinning = false;
        this.mCameraUIInterface.D_renamed();
        onDeInitCameraMode(str);
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").apply();
        }
        this.mPreviewEffectProcess.c_renamed(1);
        this.mbCapModeInit = false;
        this.mApsDecisionFeatureType = 0;
        this.mApsBracketMode = 0;
        this.mAsdSceneValue = 0;
        onGetNearMeOnClickData();
    }

    public final void afterStartPreview(boolean z_renamed) {
        if (this.mbCapModeInit) {
            updateTrackEnable();
            onAfterStartPreview(z_renamed);
        }
        if (this.mStatePreferenceHelper == null) {
            this.mStatePreferenceHelper = new com.oplus.camera.algovisualization.j_renamed(this.mActivity);
        }
        if (this.mStatePreferenceHelper.b_renamed() && this.mStatePreferenceHelper.a_renamed()) {
            if (isSlowVideoMode() || (android.text.TextUtils.equals(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER, getCameraMode()) && android.text.TextUtils.isEmpty(this.mFullAlgoValue) && android.text.TextUtils.isEmpty(this.mFullAlgoKey))) {
                if (this.algoVisualViewManager == null) {
                    this.algoVisualViewManager = new com.oplus.camera.algovisualization.c_renamed(this.mActivity, this.mOneCamera);
                    this.algoVisualViewManager.a_renamed();
                }
                this.algoVisualViewManager.a_renamed(this.mActivity, this.mCameraId);
            }
        }
    }

    public final void beforePreview() throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.d_renamed dVar;
        com.oplus.camera.e_renamed.f_renamed(TAG, "onBeforePreview, capMode: " + getCameraMode() + ", mCurrentMode: " + this);
        com.oplus.camera.e_renamed.d_renamed dVar2 = this.mOneCamera;
        if (dVar2 != null) {
            dVar2.x_renamed(true);
            this.mOneCamera.n_renamed(0);
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
            this.mOneCamera.z_renamed(isSalientObjectDetectionEnabled());
            this.mOneCamera.v_renamed(false);
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.IS_FROM_MAIN_MENU, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(isFromMainMenuApp()));
            if (!android.text.TextUtils.isEmpty(this.mCameraInterface.aG_renamed())) {
                this.mOneCamera.a_renamed(this.mCameraInterface.aG_renamed().getBytes());
            }
            if (!com.oplus.camera.util.Util.C_renamed()) {
                if (isSlowVideoMode()) {
                    this.mOneCamera.a_renamed(true, getVideoSizeType());
                } else {
                    this.mOneCamera.a_renamed(false, (java.lang.String) null);
                }
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_ZSL) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_REQUEST_ZSL_MODE) && (android.os.Build.VERSION.SDK_INT <= 30 || !com.oplus.camera.util.Util.C_renamed())) {
                this.mOneCamera.m_renamed(getZSLMode());
            }
            this.mOneCamera.f_renamed(this.mCameraUIInterface.e_renamed());
        }
        updateAISceneMode();
        updateAsdSceneValue(false, this.mAsdSceneValue);
        setSloganEnable();
        setCurTemperatureToHAL();
        updateRearAicolorEnable(false, false);
        updateFilterParam(getCurrFilterIndex());
        updateBlurValue();
        updateNeonValue();
        updateVideoBlurEnable(false, isVideoModeType() && isBlurOpen());
        updateVideoNeonEnable(false, isVideoNeonOpen());
        updateFaceBeautyLevel(getFaceBeautyCurrIndex(), false);
        updateCustomBeautyValues(getCustomBeautyValues());
        if (com.oplus.camera.util.Util.C_renamed()) {
            updateBracketMode(false, this.mApsBracketMode);
        } else {
            this.mbEnableTuningData = true;
        }
        if (isNoneSatUltraWideAngleOpen() && isOpenFlash() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM)) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE)) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off").apply();
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").apply();
            }
        }
        if (is10bitsHeicEncodeEnable()) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "HEIF").apply();
        } else {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "JPEG")).apply();
        }
        java.lang.String flashMode = getFlashMode();
        com.oplus.camera.e_renamed.d_renamed dVar3 = this.mOneCamera;
        if (dVar3 != null) {
            dVar3.b_renamed(flashMode);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && "auto".equals(flashMode) && com.oplus.camera.ui.inverse.e_renamed.INS.isInverseAble(this.mActivity) && (dVar = this.mOneCamera) != null) {
            dVar.c_renamed(true);
        } else {
            this.mOneCamera.c_renamed(false);
        }
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.n_renamed(false);
            this.mPreviewEffectProcess.d_renamed(1.0f);
        }
        onBeforePreview();
        setLSDEnable();
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar2 = this.mPreviewEffectProcess;
        if (tVar2 != null) {
            tVar2.d_renamed(needSetMakeupToAlgo());
            if (isMakeupOpen()) {
                int currMakeupIndex = getCurrMakeupIndex();
                this.mPreviewEffectProcess.b_renamed(getMakeupType(currMakeupIndex));
                this.mPreviewEffectProcess.h_renamed(getMakeupItemValue(currMakeupIndex));
                com.oplus.camera.e_renamed.d_renamed dVar4 = this.mOneCamera;
                if (dVar4 != null) {
                    dVar4.a_renamed(getMakeupType(currMakeupIndex), getMakeupItemValue(currMakeupIndex));
                }
            } else {
                this.mPreviewEffectProcess.b_renamed("none");
            }
            this.mPreviewEffectProcess.f_renamed(getFaceBeautyModeIndex());
        }
        if (this.mPreferences != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            updateHDRMode(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId)), false);
        }
        setAutoFlash(false);
        this.mbAutoHDR = false;
        this.mbAutoBinning = false;
        updateMirrorParam();
        setCapturePreviewDataState(0);
        com.oplus.camera.e_renamed.d_renamed dVar5 = this.mOneCamera;
        if (dVar5 != null) {
            if (dVar5.e_renamed() != null && this.mOneCamera.e_renamed().G_renamed()) {
                this.mOneCamera.p_renamed(getSupportFunction(com.oplus.camera.aps.config.CameraFunction.REQUEST_FAST_LAUNCH) && this.mCameraInterface.aD_renamed());
            }
            if (isVideoHdrOpen()) {
                this.mOneCamera.i_renamed(com.oplus.camera.a_renamed.AEAFHelp_2.FrameAverage.ordinal());
            } else {
                this.mOneCamera.i_renamed(com.oplus.camera.a_renamed.AEAFHelp_2.CenterWeighted.ordinal());
            }
            if (!com.oplus.camera.util.Util.C_renamed()) {
                byte[] bArr = com.oplus.camera.e_renamed.d_renamed.g_renamed;
                if (this.mbEnableTuningData) {
                    bArr = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT) ? com.oplus.camera.e_renamed.d_renamed.i_renamed : com.oplus.camera.e_renamed.d_renamed.h_renamed;
                }
                this.mOneCamera.b_renamed(bArr);
            }
            this.mOneCamera.f_renamed(java.time.format.DateTimeFormatter.ofPattern("XXX").format(java.time.ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(java.lang.System.currentTimeMillis()), java.time.ZoneId.systemDefault())));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.FACE_RECTIFY_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(isFaceRectifyOpen()));
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY) && !com.oplus.camera.util.Util.C_renamed()) {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>>) com.oplus.ocs.camera.CameraParameter.ZOOM_RATIO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) java.lang.Float.valueOf(1.0f));
            } else if (com.oplus.camera.e_renamed.a_renamed.e_renamed() && this.mbFrontCamera) {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>>) com.oplus.ocs.camera.CameraParameter.ZOOM_RATIO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) java.lang.Float.valueOf(1.0f));
            } else {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>>) com.oplus.ocs.camera.CameraParameter.ZOOM_RATIO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) java.lang.Float.valueOf(this.mCameraInterface.ak_renamed()));
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL) && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off").equals("super_raw")) {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "super_raw");
            } else {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "none");
            }
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.SUPER_CLEAR_PORTRAIT_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isSuperClearPortraitOpen() ? "on_renamed" : "off"));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.TRIPOD_MODE_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE) && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, "off").equals("on_renamed")));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.STARBURST_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE) && this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE, "off").equals("on_renamed")));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.ULTRA_HIGH_RESOLUTION_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isUltraHighResolutionOpened() ? "on_renamed" : "off"));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.STAR_VIDEO_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isStarVideoOpen() ? "on_renamed" : "off"));
            java.lang.String currFilterType = getCurrFilterType();
            if (currFilterType != null) {
                this.mOneCamera.a_renamed(currFilterType, isFilterOpen(currFilterType), getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(currFilterType));
            }
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FACE_BEAUTY_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isFaceBeautyOpen() ? "on_renamed" : "off"));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.PORTRAIT_NEON_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isNeonEnable() ? "on_renamed" : "off"));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.AI_PHOTO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isPIModeOpen() ? "on_renamed" : "off"));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_RETENTION_OPEN, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_RETENTION) && isVideoRetentionOpen() ? "on_renamed" : "off"));
            if (!isAutoMacroOpen() || isTiltShiftOpen()) {
                this.mOneCamera.B_renamed(false);
            }
        }
    }

    private boolean isSupportPhotoRatioMenu() {
        return (getSupportMenu(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO) && getCanAddMenuOption(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO)) || getSupportSubMenu(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO);
    }

    private boolean isFromMainMenuApp() {
        return 1 == this.mCameraEntry.J_renamed();
    }

    private int getMakeupState() {
        if (!needSetMakeupToAlgo()) {
            return 0;
        }
        if (isMakeupOpen()) {
            return getMakeupOpenState();
        }
        return 2;
    }

    protected boolean needSetMakeupToAlgo() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP);
    }

    protected void updateDimHintView(boolean z_renamed) {
        this.mCameraUIInterface.A_renamed(z_renamed);
    }

    public void updateTrackEnable() {
        android.content.SharedPreferences sharedPreferences;
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT) || this.mOneCamera == null) {
            return;
        }
        boolean z_renamed = getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TRACK_FOCUS) && (sharedPreferences = this.mPreferences) != null && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TRACK_FOCUS, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_face_rectify_default_value)));
        boolean z2 = z_renamed != this.mbTrackFocusOpen;
        this.mbTrackFocusOpen = z_renamed;
        this.mOneCamera.A_renamed(this.mbTrackFocusOpen);
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            if (this.mbTrackFocusOpen) {
                aVar.a_renamed(getTrackHalAlgoSize());
            } else {
                aVar.l_renamed(false);
            }
            if (z2) {
                this.mCameraInterface.m_renamed(this.mbTrackFocusOpen);
            }
        }
    }

    protected void updateBlurValue() {
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar;
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.BOKEH)) {
            com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
            if (dVar != null) {
                dVar.a_renamed(getBlurValue());
                return;
            }
            return;
        }
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR) || (tVar = this.mPreviewEffectProcess) == null) {
            return;
        }
        tVar.a_renamed(getBlurValue());
    }

    public void onAfterStartPreview(boolean z_renamed) {
        android.app.Activity activity;
        setAllowSwitchMode(true);
        this.mbSupportSelectPhotoRatio = isSupportPhotoRatioMenu();
        this.mHandler.removeMessages(3);
        this.mHandler.sendEmptyMessage(3);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, "on_renamed", this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_torch_mode_torch));
        }
        if (this.mStatePreferenceHelper == null && (activity = this.mActivity) != null) {
            this.mStatePreferenceHelper = new com.oplus.camera.algovisualization.j_renamed(activity);
        }
        com.oplus.camera.algovisualization.j_renamed jVar = this.mStatePreferenceHelper;
        if (jVar != null && jVar.b_renamed()) {
            this.algoVisualViewManager = new com.oplus.camera.algovisualization.c_renamed(this.mActivity, this.mOneCamera);
            this.algoVisualViewManager.a_renamed();
        }
        this.mCameraUIInterface.a_renamed(getEffectMenuKeyByMode(), isMicroscopeMode());
        this.mCameraUIInterface.aF_renamed();
        if (z_renamed) {
            showBubble();
        }
    }

    public void updateInversePositionRatio(boolean z_renamed) {
        com.oplus.camera.ui.inverse.e_renamed.INS.setPositionRatio(this.mActivity, 0.5f, z_renamed);
    }

    protected void doAfterStartPreview() {
        if (this.mbPaused) {
            return;
        }
        if (this.mCameraUIInterface != null) {
            com.oplus.camera.s_renamed sVarAP = this.mCameraInterface.aP_renamed();
            com.oplus.camera.e_renamed.b_renamed(TAG, "doAfterStartPreview, front: " + this.mbFrontCamera + ", cameraMode: " + getCameraMode() + ", shell response status: " + sVarAP);
            if (!this.mbFrontCamera && sVarAP.e_renamed() && this.mCameraInterface.aQ_renamed()) {
                sVarAP.f_renamed(true);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.rio_toast_shell_covered_camera_lens, -1, true, false, false);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.rio_toast_shell_covered_camera_lens);
            }
            if (!isFlashState() && !isHDRState() && !isInProMode() && !com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr);
                }
                if (!isUltraNightVideoOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO) && !isInProMode()) {
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ultra_video_night);
                }
                this.mCameraUIInterface.a_renamed(false, true, true);
            }
            if (this.mPreferences != null) {
                if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE) && "standard_high".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value)))) {
                    this.mPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, true).commit();
                }
                if (isOpenHDR()) {
                    updateMenuWithHDRChange(true);
                } else if (isAutoHDR()) {
                    updateFlashMenuIfHDRIsAuto(this.mbFrontCamera);
                }
                android.os.Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeMessages(2);
                    this.mHandler.sendEmptyMessageDelayed(2, 400L);
                }
            }
        }
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            aVar.aR_renamed();
        }
    }

    private final boolean beforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed("captureX beforeSnapping");
        this.mCaptureOrientation = this.mCameraInterface.u_renamed();
        boolean zC = this.mCameraInterface.c_renamed();
        com.oplus.camera.e_renamed.a_renamed(TAG, "beforeSnapping, ret: " + zC + ", mbAutoHDR: " + this.mbAutoHDR);
        if (!zC) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "beforeSnapping, beforeCaptureProcess return false");
            return false;
        }
        getExif(null);
        boolean zOnBeforeSnapping = onBeforeSnapping(cVar);
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.7
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.BaseMode.this.mbDestroyed) {
                    return;
                }
                com.oplus.camera.capmode.BaseMode.this.mCameraInterface.d_renamed(false);
            }
        });
        this.mJpgOrientation = getJpegOrientation(getProperCameraId(this.mCameraId), this.mCaptureOrientation);
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.APS_BRACKETMODE) || disableBokehHDR(cVar.N_renamed)) {
            updateBracketMode(false, 0);
        } else {
            this.mApsBracketMode = cVar.V_renamed;
            updateBracketMode(false, this.mApsBracketMode);
        }
        if (this.mApsDecisionFeatureType != cVar.X_renamed) {
            this.mApsDecisionFeatureType = cVar.X_renamed;
        }
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(this.mJpgOrientation));
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.FACE_RECTIFY_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(isFaceRectifyOpen()));
        if (this.mbBurstShot) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 75);
        } else if (!com.oplus.camera.util.Util.C_renamed()) {
            java.lang.String heicCodecFormat = getHeicCodecFormat();
            if (heicCodecFormat == null) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 95);
            } else {
                char c2 = 65535;
                int iHashCode = heicCodecFormat.hashCode();
                if (iHashCode != -773316083) {
                    if (iHashCode == 1922678230 && heicCodecFormat.equals("heic_8bits")) {
                        c2 = 1;
                    }
                } else if (heicCodecFormat.equals("heic_10bits")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 50);
                } else if (c2 == 1) {
                    this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 70);
                } else {
                    this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 95);
                }
            }
            com.oplus.camera.e_renamed.c_renamed(TAG, "beforeSnapping, heicCodecFormat: " + heicCodecFormat);
        } else {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_QUALITY, (android.hardware.camera2.CaptureRequest.Key) (byte) 95);
        }
        this.mOneCamera.b_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_GPS_LOCATION, (android.hardware.camera2.CaptureRequest.Key) this.mCameraInterface.y_renamed());
        if (!com.oplus.camera.util.Util.C_renamed() && cVar.L_renamed != null && (!this.mbFrontCamera || !isInNightProcess())) {
            this.mOneCamera.b_renamed(true, false);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            this.mbResetAeLockAfterCaptured = true;
        }
        com.oplus.camera.e_renamed.b_renamed("captureX beforeSnapping");
        return zOnBeforeSnapping;
    }

    public long getMinimumCaptureMemory() {
        return (isHighPictureSize() && "heic_8bits".equalsIgnoreCase(getHeicCodecFormat())) ? 150994944L : 52428800L;
    }

    public com.oplus.camera.e_renamed.h_renamed getCameraInfo(int i_renamed) {
        return com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), i_renamed);
    }

    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.e_renamed.b_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.e_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.f_renamed(TAG, "CameraTest Shutter clickable Restart");
    }

    private void capturePreviewData(final com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "capturePreviewData, title: " + this.mThumbnailTitle);
        if (this.mCameraUIInterface == null || getCapturePreviewDataState() != 1) {
            return;
        }
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.gl_renamed.t_renamed.b_renamed() { // from class: com.oplus.camera.capmode.BaseMode.8
            @Override // com.oplus.camera.gl_renamed.t_renamed.b_renamed
            public boolean a_renamed() {
                return cVar.M_renamed;
            }

            @Override // com.oplus.camera.gl_renamed.t_renamed.b_renamed
            public int b_renamed() {
                com.oplus.camera.capmode.BaseMode baseMode = com.oplus.camera.capmode.BaseMode.this;
                int jpegOrientation = baseMode.getJpegOrientation(baseMode.getProperCameraId(baseMode.mCameraId), cVar.J_renamed);
                if (com.oplus.camera.capmode.BaseMode.this.mbFrontCamera) {
                    if (a_renamed() && jpegOrientation % 180 == 0) {
                        return 180 - jpegOrientation;
                    }
                    if (jpegOrientation % 180 != 0) {
                        return 360 - jpegOrientation;
                    }
                }
                return (com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.e_renamed() && jpegOrientation % 180 == 0) ? 180 - jpegOrientation : jpegOrientation;
            }

            @Override // com.oplus.camera.gl_renamed.t_renamed.b_renamed
            public void a_renamed(android.graphics.Bitmap bitmap) {
                if (cVar.ae_renamed) {
                    return;
                }
                if (!cVar.j_renamed) {
                    com.oplus.camera.capmode.BaseMode.this.mHandler.removeMessages(6);
                    com.oplus.camera.capmode.BaseMode.this.mHandler.sendMessage(com.oplus.camera.capmode.BaseMode.this.mHandler.obtainMessage(6, new com.oplus.camera.ui.control.e_renamed(bitmap, cVar.hashCode(), cVar.ab_renamed)));
                } else {
                    com.oplus.camera.capmode.BaseMode.this.mCameraInterface.a_renamed(new com.oplus.camera.ui.control.e_renamed(bitmap));
                }
            }

            @Override // com.oplus.camera.gl_renamed.t_renamed.b_renamed
            public void a_renamed(java.lang.Integer num, android.graphics.Bitmap bitmap, long j_renamed, long j2, android.hardware.camera2.CaptureResult captureResult) {
                android.hardware.camera2.params.Face[] faceArr;
                com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.BaseMode.TAG, "capturePreviewData, onPreviewCaptured, which: " + num + ", bitmap: " + bitmap + ", timestamp: " + j2 + ", result: " + captureResult + ", title: " + com.oplus.camera.capmode.BaseMode.this.mThumbnailTitle);
                java.lang.String string = (com.oplus.camera.capmode.BaseMode.this.mPreferences == null || com.oplus.camera.capmode.BaseMode.this.mActivity == null) ? "off" : com.oplus.camera.capmode.BaseMode.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR, com.oplus.camera.capmode.BaseMode.this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_mirror_default_value));
                if (0 == j2) {
                    com.oplus.camera.capmode.BaseMode.this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.capmode.BaseMode.this.shutterCallback(false, true);
                        }
                    });
                }
                com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest dataRequest = new com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest();
                if (cVar.ag_renamed && !cVar.M_renamed) {
                    if (cVar.J_renamed == 0 || 180 == cVar.J_renamed) {
                        dataRequest.mThumbBitmap = com.oplus.camera.util.Util.a_renamed(bitmap);
                    } else {
                        dataRequest.mThumbBitmap = com.oplus.camera.util.Util.b_renamed(bitmap);
                    }
                } else {
                    dataRequest.mThumbBitmap = bitmap;
                }
                dataRequest.mCapMode = com.oplus.camera.capmode.BaseMode.this.getCameraMode();
                dataRequest.mResolver = com.oplus.camera.capmode.BaseMode.this.mActivity.getApplicationContext().getContentResolver();
                dataRequest.mPreviewSize = new android.util.Size(bitmap.getWidth(), bitmap.getHeight());
                dataRequest.mDate = com.oplus.camera.capmode.BaseMode.this.mCaptureDate;
                dataRequest.mTitle = com.oplus.camera.capmode.BaseMode.this.mThumbnailTitle;
                dataRequest.mExif = com.oplus.camera.capmode.BaseMode.this.getExif(null);
                dataRequest.mMirrorState = string;
                dataRequest.mRearMirrorState = cVar.ag_renamed ? "on_renamed" : "off";
                dataRequest.mThumbOrientation = com.oplus.camera.capmode.BaseMode.this.mCaptureOrientation;
                dataRequest.mCameraId = com.oplus.camera.capmode.BaseMode.this.mCameraId;
                com.oplus.camera.capmode.BaseMode baseMode = com.oplus.camera.capmode.BaseMode.this;
                dataRequest.mLogicCameraId = baseMode.getProperCameraId(baseMode.mCameraId);
                dataRequest.mJpegOrientation = com.oplus.camera.capmode.BaseMode.this.getJpegOrientation(dataRequest.mLogicCameraId, com.oplus.camera.capmode.BaseMode.this.mCaptureOrientation);
                dataRequest.mIdentity = j_renamed;
                dataRequest.mTimeStamp = j2;
                dataRequest.mbBurstShot = com.oplus.camera.capmode.BaseMode.this.mbBurstShot;
                dataRequest.mRecBurstNum = com.oplus.camera.capmode.BaseMode.this.mbBurstShot ? 1 : -1;
                dataRequest.mbLockScreen = com.oplus.camera.capmode.BaseMode.this.mbDisplayOnLock;
                dataRequest.mRequestHash = cVar.hashCode();
                dataRequest.mStickerCaptureTime = cVar.ad_renamed;
                dataRequest.mbUltraHighResolution = com.oplus.camera.capmode.BaseMode.this.isUltraHighResolutionOpened();
                dataRequest.mbSuperClearPortrait = com.oplus.camera.capmode.BaseMode.this.isSuperClearPortraitOpen() && com.oplus.camera.capmode.BaseMode.this.isApsDecisionAlgoOpen(com.oplus.camera.aps.constant.CameraUnitKeys.ALGO_NAME_SCPORTRAIT);
                dataRequest.mHeicCodecFormat = cVar.Z_renamed;
                dataRequest.mbWatchRequest = cVar.aa_renamed;
                dataRequest.mbQuickJpeg = com.oplus.camera.ui.preview.h_renamed.f4666b == num;
                dataRequest.mbSupportQuickJpeg = com.oplus.camera.capmode.BaseMode.this.getSupportQuickJpeg(cVar);
                dataRequest.mApsService = com.oplus.camera.capmode.BaseMode.this.mApsService;
                dataRequest.mbMakeupWatermark = !cVar.e_renamed.equals("none") && com.oplus.camera.capmode.BaseMode.this.mPreferences != null && "on_renamed".equals(com.oplus.camera.capmode.BaseMode.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off")) && "on_renamed".equals(com.oplus.camera.capmode.BaseMode.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"));
                if (java.lang.Float.compare(com.oplus.camera.capmode.BaseMode.this.getZoomValue(), com.oplus.camera.ag_renamed.f4106a) != 0 && dataRequest.mbQuickJpeg && captureResult != null && com.oplus.camera.capmode.BaseMode.this.isFaceRectifyOpen() && (faceArr = (android.hardware.camera2.params.Face[]) captureResult.get(android.hardware.camera2.CaptureResult.STATISTICS_FACES)) != null && faceArr.length != 0) {
                    dataRequest.mOneCamera = com.oplus.camera.capmode.BaseMode.this.mOneCamera;
                    dataRequest.mResult = captureResult;
                }
                if (com.oplus.camera.capmode.BaseMode.this.mbBurstShot) {
                    dataRequest.mCshotPath = com.oplus.camera.capmode.BaseMode.this.mCameraInterface.w_renamed();
                    dataRequest.mBurstShotFlagId = com.oplus.camera.capmode.BaseMode.this.mCameraInterface.x_renamed();
                }
                boolean zIsInNightProcess = com.oplus.camera.capmode.BaseMode.this.isInNightProcess();
                boolean zIsInOfflineNightProcess = com.oplus.camera.capmode.BaseMode.this.isInOfflineNightProcess();
                if ((!com.oplus.camera.util.Util.C_renamed() || !zIsInNightProcess || zIsInOfflineNightProcess || com.oplus.camera.capmode.BaseMode.this.mbBurstShot) && !cVar.ae_renamed) {
                    com.oplus.camera.capmode.BaseMode.this.mCameraInterface.a_renamed(dataRequest);
                }
                if (!dataRequest.mbQuickJpeg) {
                    com.oplus.camera.capmode.BaseMode.this.setCapturePreviewDataState(2);
                }
                com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.BaseMode.TAG, "capturePreviewData, onPreviewCaptured, X_renamed, isInNightProcess: " + zIsInNightProcess + ", isInOfflineNightProcess: " + zIsInOfflineNightProcess);
            }
        }, true, getNeedCheckTimeStamp(), com.oplus.camera.gl_renamed.t_renamed.b_renamed.d_renamed);
    }

    public final void shutterCallback(boolean z_renamed, boolean z2) {
        if (!z_renamed && !this.mbPaused) {
            this.mPostCounter++;
            com.oplus.camera.e_renamed.a_renamed(TAG, "shutterCallback, mPostCounter: " + this.mPostCounter);
            setInPreparing(false);
        }
        if (this.mbPaused) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "shutterCallback, camera pause, so return");
            return;
        }
        if (!z_renamed && !isInNightProcess()) {
            this.mCameraInterface.d_renamed();
        }
        onShutterCallback(z_renamed, z2);
    }

    public boolean withinSatMainRange(float f_renamed) {
        float[] configFloatArrayValue;
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA) && (configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && java.lang.Float.compare(f_renamed, configFloatArrayValue[0]) >= 0 && java.lang.Float.compare(f_renamed, configFloatArrayValue[1]) < 0 && !getZoomAutoMicroOpen();
    }

    public boolean withinSatMainAndWideRange(float f_renamed) {
        float[] configFloatArrayValue;
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA) && (configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && java.lang.Float.compare(f_renamed, configFloatArrayValue[1]) < 0;
    }

    public final void pictureTakenCallback(byte[] bArr, int i_renamed, int i2, java.lang.String str, boolean z_renamed, boolean z2, long j_renamed, int i3) {
        pictureTakenCallback(bArr, i_renamed, i2, str, z_renamed, z2, true, j_renamed, i3);
    }

    public final void pictureTakenCallback(byte[] bArr, int i_renamed, int i2, java.lang.String str, boolean z_renamed, boolean z2, boolean z3, long j_renamed, int i3) {
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface;
        int height;
        int width;
        com.oplus.camera.e_renamed.d_renamed dVar;
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            aVar.a_renamed(bArr);
            onBeforePictureTaken(bArr, z2);
        }
        if (z_renamed) {
            if (this.mbPaused && z3) {
                return;
            }
            if (i_renamed != 0 || i2 != 0 || (dVar = this.mOneCamera) == null || this.mCameraInterface == null) {
                height = i_renamed;
                width = i2;
            } else {
                android.util.Size pictureSize = getPictureSize(dVar.e_renamed());
                if (getJpegOrientation(getProperCameraId(this.mCameraId), this.mCameraInterface.u_renamed()) % 180 == 0) {
                    height = pictureSize.getWidth();
                    width = pictureSize.getHeight();
                } else {
                    height = pictureSize.getHeight();
                    width = pictureSize.getWidth();
                }
            }
            com.oplus.camera.Storage.CameraPicture cameraPicture = new com.oplus.camera.Storage.CameraPicture();
            cameraPicture.o_renamed = height;
            cameraPicture.p_renamed = width;
            cameraPicture.e_renamed = bArr;
            cameraPicture.h_renamed = str;
            cameraPicture.i_renamed = getCameraMode();
            cameraPicture.t_renamed = com.oplus.camera.util.Util.b_renamed(bArr);
            cameraPicture.t_renamed = this.mJpgOrientation;
            cameraPicture.mPath = null;
            cameraPicture.E_renamed = this.mbDisplayOnLock;
            cameraPicture.l_renamed = j_renamed;
            cameraPicture.w_renamed = getNeedStoreRawPic();
            if (this.mThumbnailTitle != null && "raw".equalsIgnoreCase(cameraPicture.h_renamed)) {
                cameraPicture.g_renamed = this.mThumbnailTitle;
            }
            com.oplus.camera.capmode.a_renamed aVar2 = this.mCameraInterface;
            if (aVar2 != null) {
                aVar2.a_renamed(cameraPicture, z3);
            }
        }
        com.oplus.camera.capmode.a_renamed aVar3 = this.mCameraInterface;
        if (aVar3 != null) {
            aVar3.a_renamed(bArr, z2, i3);
            onAfterPictureTaken(bArr, z2);
        }
        if (!this.mbInBurstShotCapturing) {
            setAllowSwitchMode(true);
        }
        this.mbInCapturing = false;
        this.mbHasClickedFromThird = true;
        com.oplus.camera.capmode.a_renamed aVar4 = this.mCameraInterface;
        if (aVar4 != null && aVar4.i_renamed()) {
            this.mCameraInterface.d_renamed(true);
        }
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface2 = this.mCameraUIInterface;
        if (cameraUIInterface2 != null) {
            cameraUIInterface2.l_renamed(true, true);
            android.app.Activity activity = this.mActivity;
            if (activity != null) {
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$FR4PEsLfF-CF_kRPXzCtUb8_Zzg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$pictureTakenCallback$0$BaseMode();
                    }
                });
            }
        }
        if ((com.oplus.camera.Camera.l_renamed || com.oplus.camera.Camera.m_renamed) && this.mbNeedReloadFlashMenu && (cameraUIInterface = this.mCameraUIInterface) != null && !z2) {
            this.mbNeedReloadFlashMenu = false;
            cameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE);
        }
        com.oplus.camera.capmode.a_renamed aVar5 = this.mCameraInterface;
        if (aVar5 != null) {
            aVar5.e_renamed();
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "pictureTakenCallback, mbInCapturing: " + this.mbInCapturing + ", mbNeedReloadFlashMenu: " + this.mbNeedReloadFlashMenu);
    }

    public /* synthetic */ void lambda$pictureTakenCallback$0$BaseMode() {
        this.mCameraUIInterface.P_renamed(true);
    }

    public final boolean burstShotCapture() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "burstShotCapture");
        this.mbBurstShot = true;
        updateAutoSeNightUI(null);
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.w_renamed();
        }
        closeHdrAndFlashModeBeforeCapture();
        saveAndClearEffectBeforeBurstShot();
        if (isVividEffectOpen()) {
            closeViviEffect();
            this.mbOpenViviEffectAfterBurstShot = true;
        } else {
            this.mbOpenViviEffectAfterBurstShot = false;
        }
        return onBurstShotCapture();
    }

    public void onThermalLevelChange(int i_renamed, int i2) throws java.lang.NumberFormatException {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_TEMPERATURE, i2).apply();
        }
        setCurTemperatureToHAL();
    }

    protected float getZoomValue() {
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            return aVar.ak_renamed();
        }
        return 1.0f;
    }

    protected float getMinZoomValue() {
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            return aVar.am_renamed();
        }
        return 1.0f;
    }

    protected boolean checkPreviewResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        return cameraApsDecision != null && cameraApsDecision.mCameraId == this.mCameraId;
    }

    public final boolean capture(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision;
        boolean z2;
        boolean z3;
        int i_renamed;
        int i2;
        int i3;
        int i4;
        if (1 == getCapturePreviewDataState()) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "capture, capturePreview not done!");
            onCancleCapturePictureRequest();
            return false;
        }
        this.mCameraUIInterface.o_renamed(getSupportQuickJpeg(null));
        this.mbCaptureHasSuperTextResult = false;
        synchronized (this.mApsDecisionResultLock) {
            this.mbInCapturing = true;
            cameraApsDecision = this.mDecisionResult;
        }
        if (!checkPreviewResult(cameraApsDecision) || this.mOneCamera == null) {
            this.mbInCapturing = false;
            com.oplus.camera.e_renamed.f_renamed(TAG, "capture, decisionResult is_renamed null!");
            onCancleCapturePictureRequest();
            this.mCameraUIInterface.o_renamed(false);
            this.mbInCapturing = false;
            return false;
        }
        if (cameraApsDecision != null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "capture, decisionResult: " + cameraApsDecision.toString());
            onAISSnapshotChecked(cameraApsDecision);
            if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_START_PREIVEW_SYNC)) {
                setInPreparing(true);
            }
            setAllowSwitchMode(false);
            this.mCaptureRequestTag = getCaptureRequestTag(cameraApsDecision, z_renamed);
            if (!beforeSnapping(this.mCaptureRequestTag)) {
                this.mCameraUIInterface.o_renamed(false);
                onCancleCapturePictureRequest();
                this.mbInCapturing = false;
                setInPreparing(false);
                setAllowSwitchMode(true);
                com.oplus.camera.perf.ComprehensivePerformance.a_renamed();
                com.oplus.camera.e_renamed.b_renamed("captureX beforeSnapping");
                return false;
            }
            this.mCaptureStartedCallbackNum = 0;
            this.mMergeIndex = 0;
            synchronized (this.mApsDecisionResultLock) {
                z2 = this.mDecisionResult != null && (30 == this.mDecisionResult.mApsDecisionFeatureType || 34 == this.mDecisionResult.mApsDecisionFeatureType);
                z3 = this.mDecisionResult != null && (40 == this.mDecisionResult.mApsDecisionFeatureType || 41 == this.mDecisionResult.mApsDecisionFeatureType);
            }
            if (z2) {
                if (this.mCaptureRequestTag.L_renamed == null || this.mCaptureRequestTag.L_renamed.length <= 0) {
                    i_renamed = 0;
                } else {
                    i_renamed = 0;
                    for (int i5 = 0; i5 < getDefaultCaptureNumber(); i5++) {
                        if (this.mCaptureRequestTag.L_renamed[i5] == 0) {
                            i_renamed++;
                        }
                    }
                }
                this.mOneCamera.k_renamed(i_renamed);
            } else {
                i_renamed = 0;
            }
            if (z3) {
                if (this.mCaptureRequestTag.L_renamed == null || this.mCaptureRequestTag.L_renamed.length <= 0) {
                    i3 = i_renamed;
                    i4 = 0;
                } else {
                    int i6 = this.mDecisionResult.mMetaIndex - 1;
                    i4 = this.mCaptureRequestTag.L_renamed[i6];
                    i3 = this.mCaptureRequestTag.y_renamed - i6;
                }
                this.mOneCamera.k_renamed(i3);
                this.mOneCamera.l_renamed(i4);
            }
            if (isNeedSetZslWhenCapture()) {
                this.mOneCamera.m_renamed(getZSLMode());
            }
            this.mbCaptureNotMatchMeta = true;
            this.mCameraInterface.a_renamed(this.mCameraPictureCallback);
            if (isImmediateCapture()) {
                this.mCaptureDate = java.lang.System.currentTimeMillis();
                com.oplus.camera.e_renamed.c_renamed cVar = this.mCaptureRequestTag;
                long j_renamed = this.mCaptureDate;
                cVar.ab_renamed = j_renamed;
                this.mThumbnailTitle = com.oplus.camera.util.Util.a_renamed(j_renamed, this.mbBurstShot);
                if (isSloganOpen() && cameraApsDecision != null) {
                    if (isVideoModeType()) {
                        i2 = 1;
                    } else {
                        i2 = this instanceof com.oplus.camera.capmode.y_renamed ? 3 : 0;
                    }
                    this.mCameraInterface.a_renamed(false, i2, false, cameraApsDecision.mMasterPipeline, true);
                }
                if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_CAPTURE_PREVIEW)) {
                    setCapturePreviewDataState(1);
                } else {
                    setCapturePreviewDataState(0);
                }
                this.mCameraInterface.f_renamed(false);
                updateCaptureParam(this.mCaptureRequestTag);
                this.mCaptureRequestTag.ag_renamed = this.mCameraUIInterface.e_renamed();
                if (this.mbBurstShot) {
                    setBurstShotCapturing(true);
                }
                burstCapture(this.mCaptureRequestTag.y_renamed, this.mCaptureRequestTag, getCaptureCallback());
                if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_CAPTURE_PREVIEW)) {
                    capturePreviewData(this.mCaptureRequestTag);
                    onStartCapturePreviewData();
                }
            } else {
                this.mCameraInterface.D_renamed();
            }
            this.mFirstCaptureHash = 0;
            onAfterSnapping();
            return true;
        }
        com.oplus.camera.e_renamed.f_renamed(TAG, "ops, decisionResult is_renamed null");
        onCancleCapturePictureRequest();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:60:0x0155  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:59:0x0152 -> B_renamed:60:0x0155). Please report as_renamed a_renamed decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void updateCaptureParam(com.oplus.camera.e_renamed.c_renamed r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.BaseMode.updateCaptureParam(com.oplus.camera.e_renamed.c_renamed):void");
    }

    protected void burstCapture(int i_renamed, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) {
        this.mCameraInterface.a_renamed(i_renamed, cVar, aVar);
    }

    public boolean isInPreviewArea(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public boolean isInSlideModeChangeAreaForFull(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        return new android.graphics.Rect(rect.left, rect.top + com.oplus.camera.util.Util.aj_renamed(), rect.right, rect.bottom).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public final boolean stopTakePicture(boolean z_renamed) {
        if (needCancelToForceStop() && z_renamed) {
            onCancelTakePicture();
            return true;
        }
        return onStopTakePicture();
    }

    public void setCameraId(int i_renamed) {
        this.mCameraId = i_renamed;
        this.mbFrontCamera = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraId);
    }

    public void updateFilterNoneIndex() {
        com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a = getFilterNoneIndex();
    }

    public void beforeSwitchToMode(boolean z_renamed) {
        this.mCameraUIInterface.a_renamed(true, z_renamed, false);
        this.mbShowEnvironmentTips = false;
    }

    public boolean isAllowSwitch(com.oplus.camera.d_renamed.a_renamed aVar) {
        return this.mbAllowSwitchMode && getCapturePreviewDataState() != 1;
    }

    public final boolean getAddMenuOptionEnabled(java.lang.String str) {
        if (this.mbModePreInit) {
            return getCanAddMenuOption(str);
        }
        return true;
    }

    public boolean getCanAddMenuOption(java.lang.String str) {
        return (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str) && onGetSupportSettingList(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mCameraId) == null) ? false : true;
    }

    public java.util.List<java.lang.String> onGetSupportSettingList(java.lang.String str, int i_renamed) {
        return getSupportSettingList(str, i_renamed);
    }

    public final java.util.List<java.lang.String> getSupportSettingList(java.lang.String str, int i_renamed) throws android.content.res.Resources.NotFoundException {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(strD) && this.mbFrontCamera) {
            return null;
        }
        java.util.List<java.lang.String> supportedList = com.oplus.camera.aps.config.CameraConfig.getSupportedList(strD, i_renamed);
        if (supportedList == null) {
            supportedList = new java.util.ArrayList<>();
            java.lang.String[] stringArray = com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(strD) ? this.mActivity.getResources().getStringArray(com.oplus.camera.R_renamed.array.flash_mode_values) : null;
            if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(strD)) {
                stringArray = this.mActivity.getResources().getStringArray(com.oplus.camera.R_renamed.array.photo_ratio_values);
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strD)) {
                stringArray = this.mActivity.getResources().getStringArray(com.oplus.camera.R_renamed.array.timer_shutter_values);
            }
            if (stringArray != null) {
                for (java.lang.String str2 : stringArray) {
                    supportedList.add(str2);
                }
            }
        }
        return supportedList;
    }

    public final void restoreSettingMenuOption(java.lang.String[] strArr) {
        java.util.List<java.lang.String> supportSettingList;
        if (strArr == null) {
            return;
        }
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            java.util.List<java.lang.String> listOnGetSupportSettingList = onGetSupportSettingList(strArr[i_renamed], this.mCameraId);
            if (listOnGetSupportSettingList != null && listOnGetSupportSettingList.size() >= 2 && (supportSettingList = getSupportSettingList(strArr[i_renamed], this.mCameraId)) != null) {
                for (int i2 = 0; i2 < supportSettingList.size(); i2++) {
                    java.lang.String str = supportSettingList.get(i2);
                    if (!listOnGetSupportSettingList.contains(str)) {
                        this.mCameraUIInterface.a_renamed(strArr[i_renamed], str);
                    }
                }
            }
        }
    }

    public final void removeSettingMenuOption(java.lang.String[] strArr) {
        java.util.List<java.lang.String> supportSettingList;
        if (strArr == null) {
            return;
        }
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            java.util.List<java.lang.String> listOnGetSupportSettingList = onGetSupportSettingList(strArr[i_renamed], this.mCameraId);
            if (listOnGetSupportSettingList != null && listOnGetSupportSettingList.size() >= 2 && (supportSettingList = getSupportSettingList(strArr[i_renamed], this.mCameraId)) != null) {
                for (int i2 = 0; i2 < supportSettingList.size(); i2++) {
                    java.lang.String str = supportSettingList.get(i2);
                    if (!listOnGetSupportSettingList.contains(str)) {
                        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(strArr[i_renamed]) && str.equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value)))) {
                            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, supportSettingList.get(0));
                            editorEdit.apply();
                        }
                        this.mCameraUIInterface.b_renamed(strArr[i_renamed], str);
                    }
                }
            }
        }
    }

    public void restoreProPreference() throws android.content.res.Resources.NotFoundException {
        android.app.Activity activity;
        if ((!isNightProModeSupport() && !isProModeSupport()) || (activity = this.mActivity) == null || this.mPreferences == null) {
            return;
        }
        java.lang.String string = activity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value);
        java.lang.String string2 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value);
        java.lang.String string3 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value);
        this.mPreferences.edit().putString("pref_professional_iso_key", string).putString("pref_professional_exposure_time_key", string2).putString("pref_professional_whitebalance_key", string3).putString("pref_professional_focus_mode_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value)).putString("pref_professional_exposure_compensation_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value)).apply();
    }

    protected boolean isNightProModeSupport() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT_PRO_MODE_SUPPORT);
    }

    protected boolean isProModeSupport() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGHPICTURE_PRO_MODE_SUPPORT);
    }

    public boolean getZSLMode() {
        if (com.oplus.camera.util.Util.C_renamed()) {
            synchronized (this.mApsDecisionResultLock) {
                if (this.mDecisionResult != null && (30 == this.mDecisionResult.mApsDecisionFeatureType || 34 == this.mDecisionResult.mApsDecisionFeatureType)) {
                    return true;
                }
                if (this.mbFrontCamera && getLogicCameraType() != 0) {
                    return false;
                }
            }
        }
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar == null || aVar.i_renamed() || com.oplus.camera.util.Util.C_renamed()) {
            return !com.oplus.camera.util.Util.C_renamed() || this.mApsBracketMode <= 0;
        }
        return false;
    }

    public int getLogicCameraType() {
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar == null || dVar.e_renamed() == null || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZSL_SUPPORT_PREVERSION)) {
            return -1;
        }
        return this.mOneCamera.e_renamed().I_renamed();
    }

    public int getDefaultAFMode() {
        java.util.List listAsList;
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null && dVar.e_renamed() != null && (listAsList = java.util.Arrays.asList(this.mOneCamera.e_renamed().A_renamed())) != null && listAsList.size() > 0) {
            if (listAsList.contains(4)) {
                return 4;
            }
            if (listAsList.contains(1)) {
                return 1;
            }
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "getDefaultAFMode, focusMode: 4");
        return 4;
    }

    public java.lang.String getFlashMode() {
        if (this.mbFlashTemporaryDisabled) {
            return (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && !withinSatMainAndWideRange(getZoomValue()) && isCaptureModeType() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(getRearFlashMode())) ? com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH : "off";
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
            return getVideoFlashMode();
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE)) {
            return getMovieFlashMode();
        }
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && !getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) ? getRearFlashMode() : "off";
        }
        java.lang.String torchMode = getTorchMode();
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT) && "on_renamed".equals(torchMode)) {
            torchMode = com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH;
        }
        return (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && "on_renamed".equals(torchMode) && com.oplus.camera.ui.inverse.e_renamed.INS.isInverseAble(this.mActivity)) ? com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH : torchMode;
    }

    protected java.lang.String getRearFlashMode() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null && this.mActivity != null) {
            return sharedPreferences.getString(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mCameraEntry.J_renamed()), this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value));
        }
        android.app.Activity activity = this.mActivity;
        return activity != null ? activity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value) : "off";
    }

    protected java.lang.String getTorchMode() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity));
        }
        android.app.Activity activity = this.mActivity;
        return activity != null ? com.oplus.camera.util.Util.F_renamed(activity) : "off";
    }

    private java.lang.String getVideoFlashMode() {
        android.app.Activity activity = this.mActivity;
        java.lang.String string = activity != null ? activity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_video_default_value) : "off";
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, string) : string;
    }

    private java.lang.String getMovieFlashMode() {
        android.app.Activity activity = this.mActivity;
        java.lang.String string = activity != null ? activity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_video_default_value) : "off";
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, string) : string;
    }

    private boolean isSystemAppCall() {
        java.lang.String callingPackage = this.mActivity.getCallingPackage();
        return MMS_PACKAGE_NAME.equals(callingPackage) || CONTACT_PACKAGE_NAME.equals(callingPackage) || NOTE_PACKAGE_NAME.equals(callingPackage) || GOOGLE_KEEP_PACKAGE_NAME.equals(callingPackage);
    }

    public android.util.Size getDecreasedSizeForThirdApp(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (!isSystemAppCall()) {
            return null;
        }
        return com.oplus.camera.util.Util.a_renamed(hVar.a_renamed(256), PICTURE_SIZE_5M, com.oplus.camera.util.Util.a_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value))));
    }

    public double getDisplayHighPictureSize() {
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.mCameraId) / 100;
        boolean zEquals = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off"));
        java.lang.String str = com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE;
        if (!zEquals || com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.mCameraId) == null) {
            str = com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE;
        }
        return configIntValue > 0 ? configIntValue : com.oplus.camera.util.Util.a_renamed(this.mActivity, com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(str, this.mCameraId));
    }

    public android.util.Size getSurfaceSize(java.lang.String str, com.oplus.camera.e_renamed.h_renamed hVar) {
        int[] iArrB;
        java.util.List<android.util.Size> configSizeListValue;
        java.util.List<android.util.Size> configSizeListValue2;
        if ("type_tuning_data_yuv".equals(str)) {
            int[] iArrB2 = hVar.b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.aQ_renamed);
            if (iArrB2 != null && iArrB2.length >= 2) {
                return new android.util.Size(iArrB2[0], iArrB2[1]);
            }
        } else if ("type_tuning_data_raw".equals(str) && (iArrB = hVar.b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.aR_renamed)) != null && iArrB.length >= 2) {
            return new android.util.Size(iArrB[0], iArrB[1]);
        }
        this.mForceUpscaleSize = hVar.b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.aN_renamed);
        if (isSatOpen()) {
            if (!com.oplus.camera.util.Util.C_renamed() && needConfigPhysicalStream(str)) {
                return getPhysicalPictureSize(hVar, null, str);
            }
            if ("type_still_capture_yuv_main".equals(str)) {
                android.util.Size ultraPictureSize = getUltraPictureSize(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_WIDE_PICTURE_SIZE);
                return ultraPictureSize == null ? getPictureSize(hVar) : ultraPictureSize;
            }
            if ("type_still_capture_yuv_sub".equals(str)) {
                return getUltraPictureSize(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_ULTRA_PICTURE_SIZE);
            }
            if ("type_still_capture_yuv_third".equals(str)) {
                return getUltraPictureSize(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE);
            }
            if ("type_reprocess_data_yuv".equals(str)) {
                return com.oplus.camera.util.Util.a_renamed(new android.util.Size[]{getUltraPictureSize(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_WIDE_PICTURE_SIZE), getUltraPictureSize(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_ULTRA_PICTURE_SIZE), getUltraPictureSize(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE)});
            }
        } else if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DUAL_CAMERA)) {
            int[] iArrB3 = hVar.b_renamed((android.hardware.camera2.CameraCharacteristics.Key<?>) com.oplus.camera.e_renamed.b_renamed.au_renamed);
            if ("type_still_capture_yuv_main".equals(str)) {
                if (java.lang.Math.abs(getDefaultZoomValue(hVar) - 2.0f) > 1.0E-6f) {
                    configSizeListValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_1X);
                } else {
                    configSizeListValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_2X);
                }
                android.util.Size size = (configSizeListValue2 == null || configSizeListValue2.size() == 0) ? null : configSizeListValue2.get(0);
                if (size != null) {
                    return new android.util.Size(size.getWidth(), size.getHeight());
                }
                if (iArrB3 != null && iArrB3.length >= 2) {
                    return new android.util.Size(iArrB3[0], iArrB3[1]);
                }
            } else if ("type_still_capture_yuv_sub".equals(str)) {
                if (java.lang.Math.abs(getDefaultZoomValue(hVar) - 2.0f) > 1.0E-6f) {
                    configSizeListValue = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_1X);
                } else {
                    configSizeListValue = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_2X);
                }
                android.util.Size size2 = (configSizeListValue == null || configSizeListValue.size() < 2) ? null : configSizeListValue.get(1);
                if (size2 != null) {
                    return new android.util.Size(size2.getWidth(), size2.getHeight());
                }
                if (iArrB3 != null && iArrB3.length >= 4) {
                    return new android.util.Size(iArrB3[2], iArrB3[3]);
                }
            }
        } else if (!"type_video_frame".equals(str)) {
            return getPictureSize(hVar);
        }
        return null;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.util.Size getUltraPictureSize(java.lang.String r6) {
        /*
            r5 = this;
            java.util.List r6 = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(r6)
            android.content.SharedPreferences r0 = r5.mPreferences
            android.app.Activity r5 = r5.mActivity
            r1 = 2131755710(0x7f1002be, float:1.9142307E38)
            java.lang.String r5 = r5.getString(r1)
            java.lang.String r1 = "pref_camera_photo_ratio_key"
            java.lang.String r5 = r0.getString(r1, r5)
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1993005596: goto L49;
                case -894674659: goto L3f;
                case 1514655: goto L35;
                case 3154575: goto L2b;
                case 1312628413: goto L21;
                default: goto L20;
            }
        L20:
            goto L53
        L21:
            java.lang.String r0 = "standard"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L53
            r5 = 0
            goto L54
        L2b:
            java.lang.String r0 = "full"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L53
            r5 = r3
            goto L54
        L35:
            java.lang.String r0 = "16_9"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L53
            r5 = r2
            goto L54
        L3f:
            java.lang.String r0 = "square"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L53
            r5 = r1
            goto L54
        L49:
            java.lang.String r0 = "standard_high"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L53
            r5 = r4
            goto L54
        L53:
            r5 = -1
        L54:
            if (r5 == 0) goto L9e
            if (r5 == r4) goto L9e
            if (r5 == r3) goto L71
            if (r5 == r2) goto L67
            if (r5 == r1) goto L60
            r5 = 0
            return r5
        L60:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            android.util.Size r5 = com.oplus.camera.util.Util.b_renamed(r6, r0)
            return r5
        L67:
            r0 = 4610685218510194460(0x3ffc71c71c71c71c, double:1.7777777777777777)
            android.util.Size r5 = com.oplus.camera.util.Util.b_renamed(r6, r0)
            return r5
        L71:
            double r0 = com.oplus.camera.util.Util.X_renamed()
            android.util.Size r5 = com.oplus.camera.util.Util.b_renamed(r6, r0)
            if (r5 != 0) goto L9d
            android.util.Size r5 = com.oplus.camera.util.Util.c_renamed(r6, r0)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "getUltraPictureSize, get imprecise size: "
            r6.append(r2)
            r6.append(r5)
            java.lang.String r2 = " with screen ratio: "
            r6.append(r2)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "BaseMode"
            com.oplus.camera.e_renamed.a_renamed(r0, r6)
        L9d:
            return r5
        L9e:
            r0 = 4608683618675807573(0x3ff5555555555555, double:1.3333333333333333)
            android.util.Size r5 = com.oplus.camera.util.Util.b_renamed(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.BaseMode.getUltraPictureSize(java.lang.String):android.util.Size");
    }

    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (!this.mbDestroyed && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE) && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false)) {
            if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off")) && com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE) != null) {
                return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.mCameraId);
            }
            return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        java.lang.String string = this.mbDestroyed ? "" : this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
        if (needDeleteTheSizeByRatio(string)) {
            string = "standard";
        }
        java.util.List<android.util.Size> listA = hVar.a_renamed(256);
        com.oplus.camera.e_renamed.a_renamed(TAG, "getPictureSize, sizeList: " + listA.toString());
        if ("standard".equals(string)) {
            return com.oplus.camera.util.Util.b_renamed(listA, 1.3333333333333333d);
        }
        if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(string)) {
            double dX_renamed = com.oplus.camera.util.Util.X_renamed();
            android.util.Size sizeB = com.oplus.camera.util.Util.b_renamed(listA, dX_renamed);
            if (sizeB != null || !com.oplus.camera.util.Util.am_renamed()) {
                return sizeB;
            }
            android.util.Size sizeC = com.oplus.camera.util.Util.c_renamed(listA, com.oplus.camera.util.Util.X_renamed());
            com.oplus.camera.e_renamed.a_renamed(TAG, "getPictureSize, get imprecise size: " + sizeC + " with screen ratio: " + dX_renamed);
            return sizeC;
        }
        if ("square".equals(string)) {
            return com.oplus.camera.util.Util.b_renamed(listA, 1.0d);
        }
        if ("16_9".equals(string)) {
            return com.oplus.camera.util.Util.b_renamed(listA, 1.7777777777777777d);
        }
        if (!"standard_high".equals(string)) {
            return null;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE)) {
            return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        return com.oplus.camera.util.Util.b_renamed(listA, 1.3333333333333333d);
    }

    public android.util.Size getPhysicalPictureSize(com.oplus.camera.e_renamed.h_renamed hVar, android.hardware.camera2.CameraCharacteristics cameraCharacteristics, java.lang.String str) {
        android.util.Size ultraPictureSize;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE) && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false)) {
            if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off")) && com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE) != null) {
                return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.mCameraId);
            }
            return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        java.lang.String string = sharedPreferences != null ? sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value)) : null;
        java.util.List<android.util.Size> listA = hVar.a_renamed(35, cameraCharacteristics, str);
        if ("type_still_capture_yuv_third".equals(str) && (ultraPictureSize = getUltraPictureSize(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE)) != null) {
            return ultraPictureSize;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "getPhysicalPictureSize, surfaceType: " + str + ", sizeList: " + listA.toString());
        if ("standard".equals(string)) {
            return com.oplus.camera.util.Util.b_renamed(listA, 1.3333333333333333d);
        }
        if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(string)) {
            return com.oplus.camera.util.Util.b_renamed(listA, com.oplus.camera.util.Util.X_renamed());
        }
        if ("square".equals(string)) {
            return com.oplus.camera.util.Util.b_renamed(listA, 1.0d);
        }
        if ("16_9".equals(string)) {
            return com.oplus.camera.util.Util.b_renamed(listA, 1.7777777777777777d);
        }
        if (!"standard_high".equals(string)) {
            return null;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE)) {
            return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        return com.oplus.camera.util.Util.b_renamed(listA, 1.3333333333333333d);
    }

    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        java.util.List<android.util.Size> configSizeListValue;
        android.util.Size pictureSize = getPictureSize(hVar);
        double targetPreviewRatio = getTargetPreviewRatio(hVar);
        java.util.List<android.util.Size> listA = hVar.a_renamed();
        if (isNoneSatUltraWideAngleOpen() && (configSizeListValue = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_WIDE_NORMAL_PREVIEW_SIZE)) != null && configSizeListValue.size() > 0) {
            listA = configSizeListValue;
        }
        java.util.List<android.util.Size> configSizeListValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CONTROL_PREVIEW_SIZE);
        if (configSizeListValue2 != null && configSizeListValue2.size() > 0) {
            listA = configSizeListValue2;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "getPreviewSize, sizeList: " + listA.toString());
        android.util.Size sizeA = com.oplus.camera.util.Util.a_renamed(listA, targetPreviewRatio);
        return (com.oplus.camera.util.Util.C_renamed() || sizeA == null) ? sizeA : (!(sizeA.getWidth() % 16 == 0 && sizeA.getHeight() % 16 == 0) && "square".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId))) ? new android.util.Size(1088, 1088) : sizeA;
    }

    protected double getTargetPreviewRatio(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size pictureSize = getPictureSize(hVar);
        if ("standard".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId)) || "standard_high".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId))) {
            return 1.3333333333333333d;
        }
        if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId))) {
            return com.oplus.camera.util.Util.X_renamed();
        }
        if ("square".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId))) {
            return 1.0d;
        }
        return "16_9".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId)) ? 1.7777777777777777d : 1.3333333333333333d;
    }

    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, double d_renamed) {
        java.util.List<android.util.Size> listA = hVar.a_renamed();
        com.oplus.camera.e_renamed.a_renamed(TAG, "getPreviewSize, sizeList: " + listA.toString());
        return com.oplus.camera.util.Util.a_renamed(listA, d_renamed);
    }

    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, java.lang.String str) {
        return getPreviewSize(hVar);
    }

    public android.util.Size getPreviewFrameSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return getPreviewSize(hVar);
    }

    public java.lang.String getTimeLapse() throws java.lang.NumberFormatException {
        if (this.mPreferences != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_shutter_mode_default_value));
            try {
                java.lang.Integer.valueOf(string);
                return string;
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return "off";
    }

    public java.lang.String getMirror() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_mirror_default_value));
        }
        return null;
    }

    public java.lang.String getCameraShutterType() {
        return this.mCameraInterface.ah_renamed();
    }

    public boolean isInCapturePreparing() {
        return this.mbInPreparing;
    }

    private void setInPreparing(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setInPreparing: " + this.mbInPreparing + " -> " + z_renamed);
        this.mbInPreparing = z_renamed;
    }

    protected boolean getIsCapturingState() {
        return this.mbInCapturing;
    }

    public boolean getIsBurstShotCapturing() {
        return this.mbInBurstShotCapturing;
    }

    public void setBurstShotCapturing(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setInBurstShotCapturing :" + this.mbInBurstShotCapturing + " -> " + z_renamed);
        this.mbInBurstShotCapturing = z_renamed;
    }

    public void setAllowSwitchMode(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setAllowSwitchMode: " + this.mbAllowSwitchMode + " -> " + z_renamed);
        this.mbAllowSwitchMode = z_renamed;
    }

    public void closeHdrAndFlashModeBeforeCapture() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE)) {
            setAutoFlash(false);
            this.mFlashMode = getFlashMode();
            if ("on_renamed".equals(this.mFlashMode) || "auto".equals(this.mFlashMode)) {
                this.mCameraUIInterface.a_renamed(false, true, true);
                this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
                if (dVar != null) {
                    dVar.b_renamed("off");
                    this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            this.mbAutoHDR = false;
            this.mHDRMode = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
            if ("off".equals(this.mHDRMode)) {
                return;
            }
            this.mCameraUIInterface.a_renamed(false, true, true);
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
            updateHDRMode("off", false);
        }
    }

    protected void openViviEffect() {
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT, "on_renamed");
        editorEdit.apply();
        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT, "on_renamed");
    }

    protected void closeViviEffect() {
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT, "off");
        editorEdit.apply();
        this.mCameraUIInterface.a_renamed(true, false, true);
        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT, "off");
    }

    public void resetHdrAndFlashModeAfterCapture() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE)) {
            this.mFlashMode = getFlashMode();
            if ("on_renamed".equals(this.mFlashMode) || "auto".equals(this.mFlashMode)) {
                this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                this.mCameraInterface.o_renamed();
                com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
                if (dVar != null) {
                    dVar.b_renamed(this.mFlashMode);
                    this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            this.mHDRMode = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
            if ("off".equals(this.mHDRMode)) {
                return;
            }
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, (java.lang.String) null);
            updateHDRMode(this.mHDRMode, false);
        }
    }

    public final void disableBurstShot() {
        resetHdrAndFlashModeAfterCapture();
        restoreEffectAfterBurstShot();
        setBurstShotCapturing(false);
        onDisableBurstShot();
        this.mPostCounter = 0;
        if (this.mbOpenViviEffectAfterBurstShot) {
            this.mbOpenViviEffectAfterBurstShot = false;
            openViviEffect();
        }
        if ((com.oplus.camera.Camera.l_renamed || com.oplus.camera.Camera.m_renamed) && this.mbNeedReloadFlashMenu) {
            this.mbNeedReloadFlashMenu = false;
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE);
        }
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar != null) {
            aVar.d_renamed(true);
        }
    }

    public void onUpdateCameraSettingMenu() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onUpdateCameraSettingMenu");
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU)) {
            this.mCameraUIInterface.t_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FUJI_FILTER_MENU));
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
        } else if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU);
        } else if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU);
        } else if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU)) {
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU)) {
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU)) {
            this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU);
        }
        removeSettingMenuOption(FILTER_KEYS);
        setHDRMenuVisibility(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE));
    }

    public void onEffectSurfaceCreated() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onEffectSurfaceCreated");
        this.mHandler.removeMessages(4);
        this.mHandler.sendEmptyMessage(4);
    }

    public void onEffectMenuChange(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onEffectMenuChange, menuName: " + str);
        this.mEffectMenuSelect = str;
    }

    protected java.lang.String getCurrEffectMenuName() {
        return this.mEffectMenuSelect;
    }

    protected void updateEffectMenuNames() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "updateEffectMenuNames");
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            if (this.mEffectMenuNames == null) {
                this.mEffectMenuNames = new java.util.concurrent.CopyOnWriteArrayList();
            }
            this.mEffectMenuNames.clear();
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
                this.mEffectMenuNames.add("beauty");
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
                this.mEffectMenuNames.add(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER);
            }
            java.lang.String currEffectMenuName = getCurrEffectMenuName();
            int currFilterIndex = 0;
            if ("beauty".equals(currEffectMenuName)) {
                currFilterIndex = getFaceBeautyMenuIndex();
            } else if (com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(currEffectMenuName)) {
                currFilterIndex = getCurrFilterIndex();
            }
            this.mCameraInterface.a_renamed(true, this.mEffectMenuNames, currEffectMenuName, currFilterIndex);
        }
    }

    private java.util.List<java.lang.String> getEffectMenuNames() {
        if (this.mEffectMenuNames == null) {
            updateEffectMenuNames();
        }
        return this.mEffectMenuNames;
    }

    public boolean hasEffectSelected() {
        java.util.List<java.lang.String> effectMenuNames = getEffectMenuNames();
        int currFilterIndex = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        if (effectMenuNames != null) {
            java.util.Iterator<java.lang.String> it = effectMenuNames.iterator();
            while (it.hasNext()) {
                if (com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(it.next())) {
                    currFilterIndex = getCurrFilterIndex();
                }
            }
        } else {
            com.oplus.camera.e_renamed.a_renamed(TAG, "hasEffectSelected, not Support filter effect.");
        }
        return currFilterIndex != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
    }

    public java.lang.String getFilterCurrName() {
        return this.mActivity.getString(getFilterNameIdList(this.mCameraId).get(getCurrFilterIndex()).intValue());
    }

    public void createEffectTextures(com.oplus.camera.ui.preview.a_renamed.p_renamed pVar) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            this.mHandler.removeMessages(5);
            android.os.Message message = new android.os.Message();
            message.obj = pVar;
            message.what = 5;
            this.mHandler.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCreateEffectTextures(com.oplus.camera.ui.preview.a_renamed.p_renamed pVar) {
        boolean z_renamed;
        android.app.Activity activity;
        java.lang.String currEffectMenuName = getCurrEffectMenuName();
        boolean z2 = this.mbFrontCamera;
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        int sensorOrientation = getSensorOrientation(aVar != null ? aVar.aw_renamed() : 0);
        boolean z3 = !isMicroscopeMode() ? 270 != sensorOrientation : 90 != sensorOrientation;
        if (com.oplus.camera.util.Util.t_renamed() && z2) {
            z_renamed = 270 == sensorOrientation;
        } else {
            z_renamed = z3;
        }
        boolean z4 = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO.equals(getCameraMode()) && z_renamed;
        if (com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(currEffectMenuName) && (activity = this.mActivity) != null) {
            com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(activity.getResources(), currEffectMenuName, getCurrFilterIndex(), getCurFilterListType(), z2, z_renamed, z4, getFilterModelList(), pVar, getPreviewSize(com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), this.mCameraId)), this.mCameraUIInterface.e_renamed());
            return;
        }
        com.oplus.camera.e_renamed.e_renamed(TAG, "doCreateEffectTextures, currMenuName: " + currEffectMenuName + "; mActivity: " + this.mActivity);
    }

    private java.util.List<com.oplus.camera.ui.preview.a_renamed.k_renamed> getFilterModelList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<java.lang.String> filterTypeList = getFilterTypeList(this.mCameraId);
        java.util.List<java.lang.Integer> filterNameIdList = getFilterNameIdList(this.mCameraId);
        int size = filterTypeList.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.oplus.camera.ui.preview.a_renamed.k_renamed kVar = new com.oplus.camera.ui.preview.a_renamed.k_renamed();
            kVar.f6908a = filterTypeList.get(i_renamed);
            kVar.f6909b = this.mActivity.getString(filterNameIdList.get(i_renamed).intValue());
            kVar.f6910c = getFilterRedpotKey(kVar.f6908a) != null;
            kVar.d_renamed = getGrandTourFilterKey(kVar.f6908a);
            arrayList.add(kVar);
        }
        return arrayList;
    }

    protected int getSensorOrientation(int i_renamed) {
        return com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraInfo(i_renamed));
    }

    protected int getJpegOrientation(int i_renamed, int i2) {
        return com.oplus.camera.e_renamed.a_renamed.b_renamed(getCameraInfo(i_renamed), i2);
    }

    public int getFaceBeautyMenuType() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM)) {
            return 1;
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_COMMON)) {
            return 2;
        }
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) ? 1 : 0;
    }

    public void resetFaceBeautyValues() {
        java.lang.String[] customBeautyKeys = getCustomBeautyKeys();
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null && customBeautyKeys != null) {
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (int i_renamed = 0; i_renamed < customBeautyKeys.length; i_renamed++) {
                editorEdit.putInt(customBeautyKeys[i_renamed], getDefaultCustomBeautyValues()[i_renamed]);
            }
            editorEdit.commit();
        }
        updateCustomBeautyValues(getCustomBeautyValues());
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.a_renamed(getCustomBeautyValues());
        }
    }

    public int getFaceBeautyItemValue(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "getFaceBeautyItemValue, index: " + i_renamed);
        if (getCustomBeautyKeys() != null) {
            return this.mPreferences.getInt(getCustomBeautyKeys()[i_renamed], getFaceBeautyItemDefaultValue(i_renamed));
        }
        return getFaceBeautyItemDefaultValue(i_renamed);
    }

    public void onFaceBeautyItemValueChange(int i_renamed, int i2, boolean z_renamed) {
        int[] customBeautyValues = getCustomBeautyValues();
        if (customBeautyValues == null) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "onFaceBeautyItemValueChange, return");
            return;
        }
        customBeautyValues[i_renamed] = i2;
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.a_renamed(customBeautyValues);
        }
        updateCustomBeautyValues(customBeautyValues);
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        if (!z_renamed || this.mPreferences == null || getCustomBeautyKeys() == null) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getCustomBeautyKeys()[i_renamed], i2);
        editorEdit.commit();
    }

    public int getShortcutFaceBeautyIndex() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_CUSTOM_MENU_SUPPORT) ? 102 : 0;
    }

    public int getFaceBeautyCurrIndex() {
        android.content.SharedPreferences sharedPreferences;
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
            return ((getFaceBeautyKey() == null || (sharedPreferences = this.mPreferences) == null) ? 0 : sharedPreferences.getInt(getFaceBeautyKey(), getFaceBeautyDefaultIndex())) <= 0 ? 0 : 102;
        }
        return 0;
    }

    protected boolean isFaceBeautyDefaultOff() {
        return com.oplus.camera.l_renamed.a_renamed.b_renamed();
    }

    protected int getFaceBeautyDefaultIndex() {
        if (isFaceBeautyDefaultOff()) {
            return 0;
        }
        return ((!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_COMMON) || getDefaultCommonBeautyValue() == 0) && !getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM)) ? 0 : 102;
    }

    protected int getFaceBeautyItemDefaultValue(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_COMMON)) {
            if (i_renamed == 0) {
                return getDefaultCommonBeautyValue();
            }
            return 0;
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM)) {
            return getDefaultCustomBeautyValues()[i_renamed];
        }
        return -100000;
    }

    protected boolean isFaceBeautyOrMakeupOpen() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
            return getFaceBeautyCurrIndex() != 0 || isMakeupOpen();
        }
        return false;
    }

    private boolean isFaceBeautyOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS) && getFaceBeautyCurrIndex() != 0;
    }

    protected boolean isCommonFaceBeautyOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_COMMON) && this.mPreferences.getInt(getFaceBeautyKey(), 0) != 0;
    }

    public void onFaceBeautyItemChange(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onFaceBeautyItemChange, index: " + i_renamed);
        if (updateFaceBeautyValue(i_renamed)) {
            updateFaceBeautyLevel(i_renamed, true);
            com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
            if (tVar != null) {
                tVar.g_renamed(i_renamed);
            }
            com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
            if (dVar == null) {
                com.oplus.camera.e_renamed.f_renamed(TAG, "onFaceBeautyItemChange, failed, mOneCamera is_renamed null !");
            } else {
                dVar.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FACE_BEAUTY_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (i_renamed != 0 ? "on_renamed" : "off"));
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    protected boolean updateFaceBeautyValue(int i_renamed) {
        if (this.mPreferences == null || getFaceBeautyKey() == null) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "updateFaceBeautyValue, mPreferences: " + this.mPreferences + ", key: " + getFaceBeautyKey());
            return false;
        }
        this.mPreferences.edit().putInt(getFaceBeautyKey(), i_renamed).apply();
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface == null) {
            return true;
        }
        cameraUIInterface.j_renamed(i_renamed);
        return true;
    }

    protected void updateFaceBeautyLevel(int i_renamed, boolean z_renamed) {
        if (this.mOneCamera != null) {
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
                if (isMultiVideoMode()) {
                    ((com.oplus.camera.e_renamed.f_renamed) this.mOneCamera).a_renamed(i_renamed, 2);
                    return;
                } else {
                    this.mOneCamera.h_renamed(i_renamed);
                    return;
                }
            }
            this.mOneCamera.h_renamed(0);
        }
    }

    private int getFaceBeautyMenuIndex() {
        int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BEAUTY3D) ? faceBeautyCurrIndex + 1 : faceBeautyCurrIndex;
    }

    public java.lang.String getCurrFilterType() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) ? getFilterType(getCurrFilterIndex()) : "default";
    }

    public int getCurrFilterIndex() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        }
        return com.oplus.camera.util.Util.a_renamed(sharedPreferences.getInt(getFilterEffectMenuPreferenceKey(), getFilterNoneIndex()), 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    protected void onFilterItemChange(int i_renamed) {
        onFilterItemChange(i_renamed, false);
    }

    protected void onFilterItemChange(int i_renamed, boolean z_renamed) {
        if (!z_renamed) {
            updateFilterParam(i_renamed);
        }
        java.lang.String filterEffectMenuPreferenceKey = getFilterEffectMenuPreferenceKey();
        int i2 = this.mPreferences.getInt(filterEffectMenuPreferenceKey, com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        this.mPreferences.edit().putInt(filterEffectMenuPreferenceKey, i_renamed).apply();
        com.oplus.camera.e_renamed.b_renamed(TAG, "onFilterItemChange, key: " + filterEffectMenuPreferenceKey + ", previousIndex: " + i2 + ", currentIndex: " + i_renamed);
        if (this.mCameraUIInterface != null) {
            java.lang.String effectMenuKeyByMode = getEffectMenuKeyByMode();
            this.mCameraUIInterface.d_renamed(effectMenuKeyByMode, i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a ? 1 : 0);
            if (i2 == com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a && i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a && !isMicroscopeMode()) {
                this.mCameraUIInterface.b_renamed(effectMenuKeyByMode, com.oplus.camera.R_renamed.drawable.menu_effect_on_light);
            } else {
                int i3 = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
                int i4 = com.oplus.camera.R_renamed.drawable.menu_effect_off_selector;
                if (i2 != i3 && i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a && !isMicroscopeMode()) {
                    if (this.mCameraUIInterface.A_renamed()) {
                        i4 = com.oplus.camera.R_renamed.drawable.menu_effect_off_light_selector;
                    }
                    this.mCameraUIInterface.b_renamed(effectMenuKeyByMode, i4);
                } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER) && !com.oplus.camera.ui.preview.a_renamed.j_renamed.f6906b.equalsIgnoreCase(com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_NONE) && !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, false) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
                    this.mCameraUIInterface.b_renamed(effectMenuKeyByMode, com.oplus.camera.R_renamed.drawable.menu_effect_grandtour_recommend);
                } else if (i2 == com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a && i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
                    this.mCameraUIInterface.b_renamed(effectMenuKeyByMode, com.oplus.camera.R_renamed.drawable.menu_effect_off_selector);
                }
            }
            this.mCameraUIInterface.j_renamed(i_renamed);
        }
    }

    public java.lang.String getEffectMenuKeyByMode() {
        return com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU, this.mCameraEntryType);
    }

    public java.lang.String getBlurMenuKeyByMode() {
        return com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, this.mCameraEntryType);
    }

    protected void updateFlashState(java.lang.String str) {
        updateFlashState(str, true);
    }

    public void updateFlashState(java.lang.String str, boolean z_renamed) {
        if ("on_renamed".equals(str) && needUpdateFlashIcon()) {
            if (this.mCameraUIInterface.k_renamed().b_renamed() && (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.k_renamed().d_renamed()))) {
                this.mCameraUIInterface.a_renamed(false, true, false);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_on, -1, true, true, false);
            }
        } else if ("auto".equals(str)) {
            if (!isOpenFlash()) {
                this.mCameraUIInterface.a_renamed(false, true, true);
            }
            if (this.mCameraUIInterface.k_renamed().b_renamed() && (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.k_renamed().d_renamed()))) {
                this.mbFirstShowAfterAuto = true;
                this.mCameraUIInterface.a_renamed(false, true, false);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_auto, -1, true, true, false);
            }
            if (this.mbAutoFlash && needUpdateFlashIcon() && isOpenFlash()) {
                this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.flash_hint_icon, false, true, false);
            }
        } else if (com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(str)) {
            if (!isMicroscopeMode() && needUpdateFlashIcon() && this.mCameraUIInterface.k_renamed().b_renamed() && (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.k_renamed().d_renamed()))) {
                this.mCameraUIInterface.a_renamed(false, true, false);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_torch, -1, true, true, false);
            }
        } else {
            if ("off".equals(str)) {
                setAutoFlash(false);
                if (this.mCameraUIInterface.k_renamed().b_renamed() && (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.k_renamed().d_renamed()))) {
                    this.mCameraUIInterface.a_renamed(false, true, false);
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_off, -1, true, true, false);
                }
            }
            if (!isOpenHDR()) {
                this.mCameraUIInterface.a_renamed(false, true, true);
            }
        }
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.b_renamed(str);
            if (z_renamed) {
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    private boolean updateMenuWithFlashChange() {
        java.lang.String string;
        if (this.mbFrontCamera) {
            string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity));
        } else {
            string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value));
        }
        java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (!"off".equals(string) && "on_renamed".equals(string2)) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
            editorEdit.apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
            return true;
        }
        if ((!com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(string) && !"on_renamed".equals(string)) || !"auto".equals(string2)) {
            return false;
        }
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
        editorEdit.apply();
        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
        return true;
    }

    private boolean updateMenuWithSoftLightChange() {
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT)) {
            return true;
        }
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value));
        java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (!"off".equals(string) && "on_renamed".equals(string2)) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
            editorEdit.apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
            return true;
        }
        if (!"on_renamed".equals(string) || !"auto".equals(string2)) {
            return false;
        }
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
        editorEdit.apply();
        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
        return true;
    }

    private void setHDRMenuVisibility(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "setHDRMenuVisibility(), flag: " + z_renamed + ", mCameraUIInterface: " + this.mCameraUIInterface);
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface == null) {
            return;
        }
        if (z_renamed) {
            cameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, (java.lang.String) null);
            this.mCameraUIInterface.d_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
        } else {
            cameraUIInterface.e_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
        }
    }

    private void updateFlashMenuIfHDRIsAuto(boolean z_renamed) {
        java.lang.String str;
        java.lang.String str2;
        if (this.mPreferences == null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "updateFlashMenuIfHDRIsAuto null  == mPreferences");
            return;
        }
        if (z_renamed) {
            str = com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE;
            str2 = "off";
        } else {
            str = com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE;
            str2 = "auto";
        }
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        java.lang.String string = this.mPreferences.getString(strD, str2);
        com.oplus.camera.e_renamed.a_renamed(TAG, "updateFlashMenuIfHDRIsAuto, flashMode: " + string);
        if ("on_renamed".equals(string) || com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(string)) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(strD, "off");
            editorEdit.apply();
            com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
            if (cameraUIInterface != null) {
                cameraUIInterface.f_renamed(strD);
            }
        }
    }

    private void updateMenuWithHDRChange(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "updateMenuWithHDRChange(), enable: " + z_renamed);
        if (this.mCameraUIInterface != null && z_renamed) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            if (this.mbFrontCamera) {
                java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE);
                editorEdit.putString(strD, "off");
                editorEdit.apply();
                this.mCameraUIInterface.f_renamed(strD);
                return;
            }
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
            editorEdit.apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
        }
    }

    public void setAutoFlash(boolean z_renamed) {
        if (this.mbAutoFlash != z_renamed) {
            this.mbAutoFlash = z_renamed;
            com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
            if (dVar != null) {
                dVar.d_renamed(z_renamed);
            }
        }
    }

    private void updateHDRMode(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "updateHDRMode, value: " + str + ", update: " + z_renamed);
        if (this.mOneCamera != null) {
            if ("close".equals(str)) {
                this.mOneCamera.c_renamed("off");
            } else {
                this.mOneCamera.c_renamed(str);
            }
            if (z_renamed) {
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
        }
    }

    public boolean isTrackFocusOpen() {
        return this.mbTrackFocusOpen;
    }

    public android.util.Size getTrackHalAlgoSize() {
        return getPreviewSize(this.mOneCamera.e_renamed());
    }

    public boolean isVividEffectOpen() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT)) {
            return false;
        }
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        return "on_renamed".equals(sharedPreferences != null ? sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_vivid_effect_off)) : "off");
    }

    public void forceCloseVividEffect() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_vivid_effect_off));
            editorEdit.commit();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT);
        }
    }

    protected void updateFilterParam(int i_renamed) {
        if (this.mPreviewEffectProcess != null) {
            if (isVividEffectOpen() && i_renamed != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
                forceCloseVividEffect();
            }
            java.lang.String filterType = getFilterType(java.lang.Math.min(i_renamed, com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a));
            com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
            if (dVar != null) {
                dVar.a_renamed(filterType, isFilterOpen(filterType), getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(getFilterType(i_renamed)));
            }
            this.mPreviewEffectProcess.a_renamed(getFilterType(i_renamed));
            return;
        }
        com.oplus.camera.e_renamed.f_renamed(TAG, "updateFilterParam, mPreviewEffectProcess: " + this.mPreviewEffectProcess + ", mPreferences: " + this.mPreferences);
    }

    public void updateAISceneMode() {
        if (this.mOneCamera == null) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "updateAISceneMode failed");
            return;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
            boolean zIsPIAISceneOpen = isPIAISceneOpen();
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.AI_PHOTO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (zIsPIAISceneOpen ? "on_renamed" : "off"));
            this.mOneCamera.p_renamed(this.mCameraUIInterface.aa_renamed());
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SECNES_FORCE_ATHENA) && zIsPIAISceneOpen && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI)) {
                com.oplus.camera.util.Util.C_renamed(this.mActivity);
            }
        }
        if (isAISceneOpen()) {
            this.mOneCamera.e_renamed(1);
        } else {
            this.mOneCamera.e_renamed(0);
        }
    }

    public void updatePIMode() {
        if (this.mOneCamera == null) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "updatePIMode failed");
        } else {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
                return;
            }
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.AI_PHOTO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (isPIModeOpen() ? "on_renamed" : "off"));
        }
    }

    private void setCurTemperatureToHAL() throws java.lang.NumberFormatException {
        if (this.mOneCamera == null || this.mPreferences == null || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TEMPERATURE_SEND_TO_HAL) || !needSetMakeupToAlgo()) {
            return;
        }
        float f_renamed = this.mPreferences.getFloat(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_TEMPERATURE, SYSTEM_BRIGHTNESS);
        java.lang.String string = this.mActivity.getSharedPreferences("rom_update_info", 0).getString("com.oplus.phone.max.temperature", "");
        float f2 = 39.0f;
        if (!"".equals(string)) {
            try {
                f2 = java.lang.Float.parseFloat(string);
            } catch (java.lang.NumberFormatException e_renamed) {
                com.oplus.camera.e_renamed.f_renamed(TAG, "setCurTemperatureToHAL, parse tempThresholdStr error: " + e_renamed);
            }
        }
        if (SYSTEM_BRIGHTNESS != f_renamed) {
            this.mOneCamera.a_renamed(f_renamed, f2);
            return;
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "setCurTemperatureToHAL, failed with curTemperature: " + f_renamed);
    }

    private void setSloganEnable() {
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"))) {
            return;
        }
        if (this.mOneCamera == null) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "setSloganEnable failed");
        } else if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            this.mOneCamera.j_renamed(1);
        } else {
            this.mOneCamera.j_renamed(0);
        }
    }

    public final com.oplus.camera.statistics.model.DcsMsgData getBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "getBeforeCaptureMsgCommonData");
        dcsMsgData.mScreenBrightness = this.mSysBrightness;
        if (dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData) {
            java.lang.String strA = com.oplus.camera.util.Util.a_renamed(getPictureSize(this.mOneCamera.e_renamed()), this.mCameraId);
            if ("16_9".equals(strA)) {
                strA = "16:9";
            } else if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(strA)) {
                if (com.oplus.camera.util.Util.g_renamed() == 0) {
                    strA = "second_full";
                } else if (1 == com.oplus.camera.util.Util.g_renamed()) {
                    strA = "15_14";
                }
            }
            ((com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData).mPicSizeType = strA;
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "getBeforeCaptureMsgCommonData X_renamed");
        return onGetBeforeCaptureMsgCommonData(dcsMsgData);
    }

    public final com.oplus.camera.statistics.model.DcsMsgData getAfterCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) {
        return onGetAfterCaptureMsgCommonData(dcsMsgData, cameraPicture);
    }

    protected java.lang.String getFilterType(int i_renamed) {
        return getFilterTypeList(this.mCameraId).get(i_renamed);
    }

    public boolean isFlashRequired() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && "on_renamed".equals(getRearFlashMode())) {
            return true;
        }
        if (isAutoFlash() && this.mbAutoFlash) {
            return true;
        }
        if (!isOpenFrontTorch() || getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT)) {
            return isAutoFrontTorch() && this.mbAutoFlash && !getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT);
        }
        return true;
    }

    public boolean isFlashState() {
        if (isOpenFlash()) {
            return true;
        }
        if ((isAutoFlash() && this.mbAutoFlash) || isOpenFrontTorch()) {
            return true;
        }
        return isAutoFrontTorch() && this.mbAutoFlash;
    }

    public boolean isFrontTorchEnabled() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            return false;
        }
        if (isOpenFrontTorch()) {
            return true;
        }
        return isAutoFrontTorch() && this.mbAutoFlash;
    }

    public boolean isHDRState() {
        if (isOpenHDR()) {
            return true;
        }
        return isAutoHDR() && this.mbAutoHDR;
    }

    protected boolean isOpenFlash() {
        if (this.mbFlashTemporaryDisabled) {
            return false;
        }
        if (this.mPreferences == null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "isOpenFlash mPreferences is_renamed equal null ");
            return false;
        }
        if (isMultiVideoMode() && com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(getFlashMode())) {
            return true;
        }
        return ("on_renamed".equals(getFlashMode()) || com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(getFlashMode())) && !this.mbFrontCamera;
    }

    protected boolean isAutoFlash() {
        if (this.mPreferences != null) {
            return "auto".equals(getFlashMode()) && !this.mbFrontCamera;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "isAutoFlash mPreferences is_renamed equal null ");
        return false;
    }

    protected boolean isAutoFrontTorch() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null && "auto".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity))) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE);
    }

    protected boolean isOpenFrontTorch() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity))) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE);
    }

    public boolean isAutoHDR() {
        return this.mPreferences != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE) && "auto".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId)));
    }

    public boolean isOpenHDR() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId))) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
    }

    public boolean isHDRSceneModeInAuto() {
        return this.mbAutoHDR;
    }

    protected java.lang.String getHDRKey() {
        return com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraEntryType);
    }

    protected java.lang.String getHDRModeValue(java.lang.String str) {
        return this.mPreferences.getString(str, getDefaultHDRValue());
    }

    protected java.lang.String getDefaultHDRValue() {
        return com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.entry.b_renamed.d_renamed(getHDRKey()), this.mCameraId);
    }

    protected boolean isVideoHdrOpen() {
        if (getSupportMenu(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
            return "on_renamed".equals(getHDRModeValue(getHDRKey())) || "auto".equals(getHDRModeValue(getHDRKey()));
        }
        return false;
    }

    public void displayScreenHintIconInSwitchOn() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "displayScreenHintIconInSwitchOn, isOpenFrontTorch: " + isOpenFrontTorch() + ", isOpenFlash: " + isOpenFlash());
        if (getBeauty3Dstatus() != 0) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "displayScreenHintIconInSwitchOn, beauty3DMode");
            return;
        }
        if (this.mCameraUIInterface.R_renamed()) {
            return;
        }
        if (!isPIAISceneOpen() || this.mCameraInterface.j_renamed() == 0) {
            if ((isOpenFrontTorch() || isFlashState() || isHDRState()) && !this.mbShowPostCaptureAlert && !this.mbBurstShot) {
                if (!isHDRState()) {
                    if ("auto".equals(getFlashMode())) {
                        this.mCameraUIInterface.a_renamed(-1, getFrontFlashHintDrawable(), false, true, false);
                        return;
                    }
                    return;
                } else {
                    if (isAutoHDR() && this.mbAutoHDR) {
                        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
                            this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.hdr_hint_icon_3hdr, false, true, false);
                            return;
                        } else {
                            this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.hdr_hint_icon, false, true, false);
                            return;
                        }
                    }
                    return;
                }
            }
            this.mCameraUIInterface.a_renamed(false, true, true);
        }
    }

    public void displayAllIcon(boolean z_renamed, boolean z2) {
        if (getBeauty3Dstatus() != 0) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "displayAllIcon, beauty3DMode");
            return;
        }
        if (this.mCameraUIInterface.R_renamed()) {
            return;
        }
        if (z_renamed) {
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
                this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.hdr_hint_icon_3hdr, false, false, false);
                return;
            } else {
                this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.hdr_hint_icon, false, false, false);
                return;
            }
        }
        if (z2) {
            if (this.mbBurstShot) {
                return;
            }
            if (isAutoFlash() || isAutoFrontTorch()) {
                this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.flash_hint_icon, false, true, false);
                return;
            } else {
                if (isOpenHDR()) {
                    return;
                }
                this.mCameraUIInterface.a_renamed(false, true, true);
                return;
            }
        }
        this.mCameraUIInterface.a_renamed(false, true, true);
    }

    protected java.lang.String getExif(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult) {
        int iA = com.oplus.camera.g_renamed.b_renamed.a_renamed(getExifCameraMode(), this.mCameraId);
        int jpegOrientation = getJpegOrientation(getProperCameraId(this.mCameraId), this.mCaptureOrientation);
        if (jpegOrientation > 0) {
            iA |= 32;
        }
        if (getFaceBeautyCurrIndex() > 0) {
            iA |= 2;
        }
        if (isUltraHighResolutionOpened()) {
            iA |= 8192;
        }
        if (isBlurOpen()) {
            iA |= 16;
        }
        if (getCurrFilterIndex() != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
            iA |= 1024;
        }
        if (cameraPictureResult != null && "1".equals(cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_SUPER_TEXT_ENABLE))) {
            iA |= 4096;
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "getExif, exif: " + iA + ", jpegOrientation: " + jpegOrientation);
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.w_renamed(iA);
        }
        return com.oplus.exif.OplusExifTag.EXIF_TAG_PREFIX + iA;
    }

    protected java.lang.String getExifCameraMode() {
        return getCameraMode();
    }

    protected void applyBeautyParam() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS)) {
            int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
            com.oplus.camera.e_renamed.a_renamed(TAG, "applyBeautyParam, index: " + faceBeautyCurrIndex);
            updateFaceBeautyLevel(faceBeautyCurrIndex, false);
            updateCustomBeautyValues(getCustomBeautyValues());
            com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
            if (tVar != null) {
                tVar.g_renamed(faceBeautyCurrIndex);
                this.mPreviewEffectProcess.a_renamed(getCustomBeautyValues());
                return;
            }
            return;
        }
        updateFaceBeautyLevel(0, false);
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar2 = this.mPreviewEffectProcess;
        if (tVar2 != null) {
            tVar2.g_renamed(0);
        }
    }

    protected int getDefaultCommonBeautyValue() {
        if (!isFaceBeautyDefaultOff() && this.mbFrontCamera) {
            return getFrontDefaultCommonBeautyValue();
        }
        return 0;
    }

    protected int[] getDefaultCustomBeautyValues() {
        return f4356a;
    }

    protected boolean isMakeupOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP) && getCurrMakeupIndex() != 0;
    }

    protected java.util.List getMakeupTypeList() {
        return com.oplus.camera.ui.preview.a_renamed.g_renamed.f6896b;
    }

    protected int[] getDefaultMakeupValues() {
        return com.oplus.camera.ui.preview.a_renamed.g_renamed.f6895a;
    }

    protected int getCurrMakeupIndex() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(getMakeupTypeKey(), getDefaultMakeupIndex());
        }
        return getDefaultMakeupIndex();
    }

    protected boolean getSupportShowCustomAll() {
        return !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP);
    }

    protected java.lang.String getMakeupType(int i_renamed) {
        return (java.lang.String) getMakeupTypeList().get(i_renamed);
    }

    protected int getMakeupItemValue(int i_renamed) {
        android.content.SharedPreferences sharedPreferences;
        com.oplus.camera.e_renamed.a_renamed(TAG, "getMakeupItemValue, index: " + i_renamed);
        if (getMakeupKeys() != null && (sharedPreferences = this.mPreferences) != null) {
            return sharedPreferences.getInt(getMakeupKeys()[i_renamed], getDefaultMakeupValues()[i_renamed]);
        }
        return getDefaultMakeupValues()[i_renamed];
    }

    protected void onMakeupTypeChanged(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onMakeupTypeChanged, index: " + i_renamed);
        int currMakeupIndex = getCurrMakeupIndex();
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.b_renamed(getMakeupType(i_renamed));
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getMakeupTypeKey(), i_renamed);
        editorEdit.apply();
        if ((currMakeupIndex != 0 || i_renamed == 0) && (currMakeupIndex == 0 || i_renamed != 0)) {
            return;
        }
        com.oplus.camera.util.Util.c_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$kEpe0TB9SBzpTd2qO2Rr3OcEOxY
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$onMakeupTypeChanged$1$BaseMode();
            }
        });
    }

    public /* synthetic */ void lambda$onMakeupTypeChanged$1$BaseMode() {
        this.mCameraInterface.av_renamed();
    }

    protected void onMakeupValueChanged(int i_renamed, int i2, boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "onMakeupValueChanged, index: " + i_renamed + ", value: " + i2 + ", update: " + z_renamed);
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.h_renamed(i2);
        }
        if (!z_renamed || this.mPreferences == null || getMakeupKeys() == null || i_renamed == -3) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getMakeupKeys()[i_renamed], i2);
        editorEdit.apply();
    }

    protected java.lang.String[] getCurrentKeys(java.lang.String[] strArr) {
        if (!com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType)) {
            return strArr;
        }
        java.lang.String[] strArr2 = new java.lang.String[strArr.length];
        for (int i_renamed = 0; i_renamed < strArr2.length; i_renamed++) {
            strArr2[i_renamed] = com.oplus.camera.entry.b_renamed.b_renamed(strArr[i_renamed], this.mCameraEntryType);
        }
        return strArr2;
    }

    protected java.lang.String[] getCurrentKeys(java.util.List<java.lang.String> list) {
        if (com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType)) {
            java.lang.String[] strArr = new java.lang.String[list.size()];
            for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
                strArr[i_renamed] = com.oplus.camera.entry.b_renamed.b_renamed(list.get(i_renamed), this.mCameraEntryType);
            }
            return strArr;
        }
        return (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);
    }

    protected int[] getCustomBeautyValues() {
        java.lang.String[] customBeautyKeys = getCustomBeautyKeys();
        if (customBeautyKeys == null) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "getCustomBeautyValues, customBeautyKeys null");
            return null;
        }
        int[] iArr = new int[customBeautyKeys.length];
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM)) {
            for (int i_renamed = 0; i_renamed < customBeautyKeys.length; i_renamed++) {
                android.content.SharedPreferences sharedPreferences = this.mPreferences;
                if (sharedPreferences != null) {
                    iArr[i_renamed] = sharedPreferences.getInt(customBeautyKeys[i_renamed], getDefaultCustomBeautyValues()[i_renamed]);
                } else {
                    iArr[i_renamed] = getDefaultCustomBeautyValues()[i_renamed];
                }
            }
        } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_COMMON)) {
            android.content.SharedPreferences sharedPreferences2 = this.mPreferences;
            if (sharedPreferences2 != null) {
                iArr[0] = sharedPreferences2.getInt(customBeautyKeys[0], getDefaultCommonBeautyValue());
            } else {
                iArr[0] = 0;
            }
            for (int i2 = 1; i2 < customBeautyKeys.length; i2++) {
                iArr[i2] = 0;
            }
        } else {
            for (int i3 = 0; i3 < customBeautyKeys.length; i3++) {
                iArr[i3] = 0;
            }
        }
        return iArr;
    }

    protected void updateCustomBeautyValues(int[] iArr) {
        com.oplus.camera.e_renamed.d_renamed dVar;
        if ((!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NEED_HAL_HANDING_FACE_BEAUTY) && com.oplus.camera.util.Util.C_renamed()) || (dVar = this.mOneCamera) == null || iArr == null) {
            return;
        }
        dVar.a_renamed(com.oplus.camera.util.Util.a_renamed(iArr));
    }

    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed afVar = new com.oplus.camera.af_renamed();
        afVar.f4103a = isVideoHighFps();
        afVar.f4104b = is4k();
        afVar.a_renamed(isCaptureModeType());
        afVar.b_renamed(isSatOpen());
        afVar.c_renamed(isNoneSatUltraWideAngleOpen());
        if (isNoneSatUltraWideAngleOpen()) {
            afVar.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), com.oplus.camera.e_renamed.a_renamed.h_renamed()).e_renamed());
        }
        afVar.f_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE));
        afVar.g_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE));
        afVar.m_renamed(this.mbFrontCamera);
        afVar.p_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE));
        afVar.G_renamed(isTiltShiftOpen());
        afVar.d_renamed(isStreetOpen());
        return afVar;
    }

    public java.lang.String getGuideLineType() {
        java.lang.String guideLineKey = getGuideLineKey();
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null || guideLineKey == null) {
            return null;
        }
        return sharedPreferences.getString(guideLineKey, null);
    }

    public long getCaptureDate() {
        return this.mCaptureDate;
    }

    public com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed getFilterCategory() {
        return com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr;
    }

    public boolean needShow10bitHint() {
        return is10bitsHeicEncodeEnable();
    }

    public boolean supportBeautyButton() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_PROCESS) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU_UPDATED) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FUJI_FILTER_MENU);
    }

    public boolean showBeautyButton() {
        return supportBeautyButton();
    }

    public boolean showMenuLeftButton() {
        return supportMenuLeftButton();
    }

    public boolean supportMenuLeftButton() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU);
    }

    public void onUiModeChanged() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onUiModeChanged");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showPictureSizeHint(java.lang.String r14) {
        /*
            r13 = this;
            int r2 = r14.hashCode()
            r3 = 4
            r4 = 3
            r5 = 1
            r6 = 2
            switch(r2) {
                case -1993005596: goto L34;
                case -894674659: goto L2a;
                case 1514655: goto L20;
                case 3154575: goto L16;
                case 1312628413: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L3e
        Lc:
            java.lang.String r2 = "standard"
            boolean r1 = r14.equals(r2)
            if (r1 == 0) goto L3e
            r1 = 0
            goto L3f
        L16:
            java.lang.String r2 = "full"
            boolean r1 = r14.equals(r2)
            if (r1 == 0) goto L3e
            r1 = r6
            goto L3f
        L20:
            java.lang.String r2 = "16_9"
            boolean r1 = r14.equals(r2)
            if (r1 == 0) goto L3e
            r1 = r4
            goto L3f
        L2a:
            java.lang.String r2 = "square"
            boolean r1 = r14.equals(r2)
            if (r1 == 0) goto L3e
            r1 = r3
            goto L3f
        L34:
            java.lang.String r2 = "standard_high"
            boolean r1 = r14.equals(r2)
            if (r1 == 0) goto L3e
            r1 = r5
            goto L3f
        L3e:
            r1 = -1
        L3f:
            if (r1 == 0) goto L8f
            if (r1 == r5) goto L8f
            if (r1 == r6) goto L64
            if (r1 == r4) goto L57
            if (r1 == r3) goto L4a
            goto L9b
        L4a:
            com.oplus.camera.ui.CameraUIInterface r7 = r13.mCameraUIInterface
            r8 = 2131756484(0x7f1005c4, float:1.9143877E38)
            r9 = -1
            r10 = 1
            r11 = 0
            r12 = 0
            r7.a_renamed(r8, r9, r10, r11, r12)
            goto L9b
        L57:
            com.oplus.camera.ui.CameraUIInterface r0 = r13.mCameraUIInterface
            r1 = 2131756483(0x7f1005c3, float:1.9143875E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.a_renamed(r1, r2, r3, r4, r5)
            goto L9b
        L64:
            com.oplus.camera.ui.CameraUIInterface r1 = r13.mCameraUIInterface
            int r1 = r1.aX_renamed()
            if (r1 == 0) goto L82
            com.oplus.camera.ui.CameraUIInterface r1 = r13.mCameraUIInterface
            int r1 = r1.aX_renamed()
            if (r6 != r1) goto L75
            goto L82
        L75:
            com.oplus.camera.ui.CameraUIInterface r7 = r13.mCameraUIInterface
            r8 = 2131756482(0x7f1005c2, float:1.9143873E38)
            r9 = -1
            r10 = 1
            r11 = 0
            r12 = 0
            r7.a_renamed(r8, r9, r10, r11, r12)
            goto L9b
        L82:
            com.oplus.camera.ui.CameraUIInterface r0 = r13.mCameraUIInterface
            r1 = 2131756486(0x7f1005c6, float:1.914388E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.a_renamed(r1, r2, r3, r4, r5)
            goto L9b
        L8f:
            com.oplus.camera.ui.CameraUIInterface r6 = r13.mCameraUIInterface
            r7 = 2131756485(0x7f1005c5, float:1.9143879E38)
            r8 = -1
            r9 = 1
            r10 = 0
            r11 = 0
            r6.a_renamed(r7, r8, r9, r10, r11)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.BaseMode.showPictureSizeHint(java.lang.String):void");
    }

    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences2;
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO) || this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO_FROM_OTHER_APP)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
            this.mCameraUIInterface.k_renamed().b_renamed(com.oplus.camera.util.Util.a_renamed(string));
            if (!com.oplus.camera.util.Util.t_renamed()) {
                showPictureSizeHint(string);
            }
        }
        if ((this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER) || this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER_FROM_OTHER_APP)) && (sharedPreferences2 = this.mPreferences) != null) {
            java.lang.String string2 = sharedPreferences2.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_shutter_mode_default_value));
            if (com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string2)) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_countdown_10, -1, true, false, false);
            } else if ("3".equals(string2)) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_countdown_3, -1, true, false, false);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_countdown_off, -1, true, false, false);
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(strD)) {
            java.lang.String string3 = sharedPreferences.getString(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mCameraEntry.J_renamed()), this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value));
            com.oplus.camera.e_renamed.a_renamed(TAG, "onSharedPreferenceChanged, flashMode: " + string3 + ", mbAutoFlash: " + this.mbAutoFlash);
            if (com.oplus.camera.Camera.l_renamed || com.oplus.camera.Camera.m_renamed) {
                this.mbNeedReloadFlashMenu = true;
                if (!"off".equals(string3)) {
                    android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                    editorEdit.apply();
                    this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
                } else {
                    setAutoFlash(false);
                    displayAllIcon(this.mbAutoHDR, this.mbAutoFlash);
                    if (com.oplus.camera.Camera.m_renamed) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_high_temperature_flash_disable, -1, true, false, false);
                    } else if (com.oplus.camera.Camera.l_renamed) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_low_battery_flash_disable, -1, true, false, false);
                    }
                }
            } else {
                updateFlashState(string3);
                updateMenuWithFlashChange();
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(strD)) {
            updateInversePositionRatio(true);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(strD)) {
            if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT) && (com.oplus.camera.Camera.l_renamed || com.oplus.camera.Camera.m_renamed)) {
                this.mbNeedReloadFlashMenu = true;
                setAutoFlash(false);
                displayAllIcon(this.mbAutoHDR, this.mbAutoFlash);
                if (!"off".equals(sharedPreferences.getString(strD, "off"))) {
                    if (com.oplus.camera.Camera.m_renamed) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_high_temperature_flash_disable, -1, true, false, false);
                    } else if (com.oplus.camera.Camera.l_renamed) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_low_battery_flash_disable, -1, true, false, false);
                    }
                    android.content.SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
                    editorEdit2.putString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, "off");
                    editorEdit2.apply();
                    this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE);
                }
            } else {
                java.lang.String string4 = sharedPreferences.getString(strD, "off");
                if ("on_renamed".equals(string4)) {
                    this.mCameraUIInterface.a_renamed(false, true, true);
                    if (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_torch, -1, true, true, false);
                    } else if (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_on, -1, true, true, false);
                    }
                } else if ("auto".equals(string4)) {
                    if (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) || this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_auto, -1, true, true, false);
                    }
                    if (this.mbAutoFlash) {
                        this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.flash_hint_icon, false, true, false);
                    } else {
                        this.mCameraUIInterface.a_renamed(false, true, true);
                    }
                } else if (com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(string4)) {
                    this.mCameraUIInterface.a_renamed(false, true, true);
                    if (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) || this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_torch, -1, true, true, false);
                    }
                } else {
                    this.mCameraUIInterface.a_renamed(false, true, true);
                    if (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) || this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_flash_off, -1, true, true, false);
                    }
                }
                if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT)) {
                    updateMenuWithSoftLightChange();
                } else {
                    updateMenuWithFlashChange();
                }
                if (this.mOneCamera != null) {
                    if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT) && "on_renamed".equals(string4)) {
                        string4 = com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH;
                    }
                    if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && "on_renamed".equals(string4) && com.oplus.camera.ui.inverse.e_renamed.INS.isInverseAble(this.mActivity)) {
                        string4 = com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH;
                    }
                    if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && "auto".equals(string4) && com.oplus.camera.ui.inverse.e_renamed.INS.isInverseAble(this.mActivity)) {
                        this.mOneCamera.c_renamed(true);
                    } else {
                        this.mOneCamera.c_renamed(false);
                    }
                    this.mOneCamera.b_renamed(string4);
                    this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT.equals(strD) && isVividEffectOpen() && isFilterEffectOpen()) {
            onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
            if (com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_filter_none), com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
            }
        }
        if ("slow_video_high_frame_reddot_show".equals(strD) && !sharedPreferences.getBoolean("slow_video_high_frame_reddot_show", true)) {
            this.mCameraUIInterface.n_renamed(2);
        }
        if ("id_photo_reddot_show".equals(strD) && !sharedPreferences.getBoolean("id_photo_reddot_show", false)) {
            this.mCameraUIInterface.n_renamed(13);
        }
        if ("fish_eye_reddot_show".equals(strD) && !sharedPreferences.getBoolean("fish_eye_reddot_show", true)) {
            this.mCameraUIInterface.n_renamed(29);
        }
        if ("microscope_reddot_show".equals(strD) && !sharedPreferences.getBoolean("microscope_reddot_show", true)) {
            this.mCameraUIInterface.n_renamed(16);
        }
        if ("multi_video_reddot_show".equals(strD) && !sharedPreferences.getBoolean("multi_video_reddot_show", false)) {
            this.mCameraUIInterface.n_renamed(14);
        }
        if ("mode_high_pixel_reddot_show".equals(strD) && !sharedPreferences.getBoolean("mode_high_pixel_reddot_show", true)) {
            this.mCameraUIInterface.n_renamed(31);
        }
        if ("profession_reddot_show".equals(strD) && !sharedPreferences.getBoolean("profession_reddot_show", true)) {
            this.mCameraUIInterface.n_renamed(4);
        }
        if ("double_exposure_reddot_show".equals(strD) && !sharedPreferences.getBoolean("double_exposure_reddot_show", true)) {
            this.mCameraUIInterface.n_renamed(18);
        }
        if (!"long_exposure_reddot_show".equals(strD) || sharedPreferences.getBoolean("long_exposure_reddot_show", true)) {
            return;
        }
        this.mCameraUIInterface.n_renamed(27);
    }

    private void updateHdrChangeUi(java.lang.String str, boolean z_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            updateHDRMode(str, true);
            updateMenuWithHDRChange("on_renamed".equals(str));
        }
        if ("on_renamed".equals(str)) {
            if (this.mActivity != null) {
                if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
                    if (getSupportSubMenu(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR)) {
                        this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
                        return;
                    }
                    return;
                } else {
                    if (this.mCameraUIInterface.k_renamed().b_renamed()) {
                        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.k_renamed().d_renamed())) {
                            this.mCameraUIInterface.a_renamed(false, true, false);
                            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_hdr_on, -1, true, true, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            if (!isOpenFlash() && !isOpenFrontTorch() && !isAutoHDR()) {
                if (!((isAutoFlash() || isAutoFrontTorch()) && this.mbAutoFlash) && z_renamed && this.mCameraUIInterface.k_renamed().b_renamed() && (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.k_renamed().d_renamed()))) {
                    this.mCameraUIInterface.a_renamed(false, true, false);
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_hdr_off, -1, true, true, false);
                }
            }
            if ("auto".equals(str) && z_renamed) {
                if (this.mCameraUIInterface.k_renamed().b_renamed() && (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(this.mCameraUIInterface.k_renamed().d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.k_renamed().d_renamed()))) {
                    this.mCameraUIInterface.a_renamed(false, true, false);
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_hdr_auto, -1, true, true, false);
                }
                updateFlashMenuIfHDRIsAuto(this.mbFrontCamera);
                return;
            }
            return;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR)) {
            this.mCameraUIInterface.a_renamed(false, true, true);
        }
    }

    public void onHDRModeChanged(java.lang.String str) {
        java.lang.String hDRModeValue = getHDRModeValue(str);
        if (this.mCameraInterface.g_renamed() != 0) {
            updateHDRMode(hDRModeValue, true);
            updateHdrChangeUi(hDRModeValue, true);
        }
    }

    protected void setTiltShiftPreview() {
        boolean zIsTiltShiftOpen = isTiltShiftOpen();
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.e_renamed(zIsTiltShiftOpen);
            if (zIsTiltShiftOpen) {
                this.mPreviewEffectProcess.c_renamed(getTiltShiftBlurValue());
            }
        }
    }

    public void setTiltShiftParams(com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParam) {
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.a_renamed(tiltShiftParam);
        }
    }

    protected float getTiltShiftBlurValue() {
        return getBlurValue(getTiltShiftBlurIndex());
    }

    protected int getTiltShiftBlurIndex() {
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TILT_SHIFT)) {
            return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU_INDEX, 70);
        }
        return 70;
    }

    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "changeModeAllViewWhenAnimation, animType: " + i_renamed + ", isShow: " + z_renamed);
        if (5 == i_renamed) {
            if (z_renamed) {
                this.mbHasClickedFromThird = false;
                this.mbShowPostCaptureAlert = false;
                this.mbAutoHDR = false;
                return;
            } else {
                this.mbShowPostCaptureAlert = true;
                com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
                if (cameraUIInterface != null) {
                    cameraUIInterface.a_renamed(true, true, false);
                    return;
                }
                return;
            }
        }
        if (6 == i_renamed) {
            updateHdrChangeUi(getHDRModeValue(getHDRKey()), false);
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE);
            return;
        }
        if (2 == i_renamed) {
            if (z_renamed) {
                this.mCameraUIInterface.i_renamed(z_renamed);
                this.mCameraUIInterface.j_renamed(z_renamed);
            }
            if (this.mCameraUIInterface == null || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPOORT_FOCUS_OUT_OF_RANGE)) {
                return;
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_bokeh_move_farther_away);
            return;
        }
        if (10 == i_renamed) {
            if (this.mCameraUIInterface == null) {
                return;
            } else {
                return;
            }
        }
        if (18 != i_renamed || z_renamed) {
            return;
        }
        if (isVideoModeType()) {
            if (isAiEnhancementVideoOpen()) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_enhancement_video_hint_on);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_ai_enhancement_video_hint_off);
            }
            if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
                this.mCameraUIInterface.f_renamed(7, true);
            }
            this.mCameraInterface.e_renamed(0);
        } else {
            if (isAISceneOpen()) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_hint_on);
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_hint_off);
            }
            this.mCameraUIInterface.b_renamed(false);
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_clean_lens_suggestion);
    }

    public void setDisplayOnLock(boolean z_renamed) {
        this.mbDisplayOnLock = z_renamed;
    }

    public boolean isBubbleOpen(java.lang.String str) {
        if (this.mPreferences == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "isBubbleOpen, mPreference null");
            return false;
        }
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null && ((1 == cameraUIInterface.aX_renamed() && 7 != this.mCameraUIInterface.bc_renamed()) || ((3 == this.mCameraUIInterface.aX_renamed() && this.mCameraId != 0) || 4 == this.mCameraUIInterface.aX_renamed()))) {
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO.equals(str)) {
            return this.mPreferences.getBoolean(str, false);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE.equals(str)) {
            int iD = com.oplus.camera.j_renamed.a_renamed().d_renamed();
            boolean zF = com.oplus.camera.j_renamed.a_renamed().f_renamed();
            if (5 > iD || zF) {
                return false;
            }
            return this.mPreferences.getBoolean(str, true);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER.equals(str)) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
                return this.mPreferences.getBoolean(str, true);
            }
            return false;
        }
        return this.mPreferences.getBoolean(str, true);
    }

    public boolean containsBubbleKey(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "containsBubbleKey, mPreference null");
            return true;
        }
        return sharedPreferences.contains(str);
    }

    public void updateBubbleValue(java.lang.String str, boolean z_renamed) {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "updateBubbleValue, mPreference null");
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str, z_renamed);
        editorEdit.commit();
    }

    public com.oplus.camera.statistics.CameraStatisticsUtil.MakerNote getMakerNote() {
        com.oplus.camera.statistics.CameraStatisticsUtil.MakerNote makerNote = new com.oplus.camera.statistics.CameraStatisticsUtil.MakerNote();
        if (this.mPreviewEffectProcess != null && needUploadOplusStatistics(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            makerNote.O_renamed = java.lang.String.valueOf(getCurrFilterIndex());
        }
        return makerNote;
    }

    public void setSysBrightness(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setSysBrightness, sysBrightness: " + i_renamed);
        this.mSysBrightness = i_renamed;
    }

    public void setPictureHasSuperTextResult(boolean z_renamed) {
        this.mbCaptureHasSuperTextResult = z_renamed;
    }

    public void onPictureCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, int i4) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onPictureCallback, data size: ");
        sb.append(bArr != null ? java.lang.Integer.valueOf(bArr.length) : null);
        sb.append(", width: ");
        sb.append(i_renamed);
        sb.append(", height: ");
        sb.append(i2);
        sb.append(", imageFormat: ");
        sb.append(i3);
        sb.append(", isBurstShot: ");
        sb.append(z_renamed);
        com.oplus.camera.e_renamed.a_renamed(TAG, sb.toString());
        setInPreparing(false);
        if (!z_renamed) {
            this.mHandler.removeMessages(1);
        }
        android.os.Message message = new android.os.Message();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putByteArray(KEY_PICTURE_DATA, bArr);
        bundle.putInt(KEY_PICTURE_WIDTH, i_renamed);
        bundle.putInt(KEY_PICTURE_HEIGHT, i2);
        bundle.putInt(KEY_PICTURE_FORMAT, i3);
        bundle.putBoolean(KEY_IS_BURST_SHOT, z_renamed);
        bundle.putInt(KEY_REQ_FORMAT, i4);
        message.setData(bundle);
        message.what = 1;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnPictureCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, int i4) {
        int i5;
        int i6;
        com.oplus.camera.e_renamed.a_renamed(TAG, "doOnPictureCallback, mbPaused: " + this.mbPaused);
        if (this.mbPaused) {
            return;
        }
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        int iU = aVar != null ? aVar.u_renamed() : this.mCaptureOrientation;
        if (iU == 0 || iU == 180) {
            i5 = i_renamed;
            i6 = i2;
        } else {
            i6 = i_renamed;
            i5 = i2;
        }
        pictureTakenCallback(bArr, i6, i5, com.oplus.camera.util.Util.a_renamed(i3), bArr != null, z_renamed, 0L, i4);
    }

    public boolean needSurface(java.lang.String str) {
        if ("type_still_capture_yuv_main".equals(str)) {
            return true;
        }
        if ("type_still_capture_raw".equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_RAW);
        }
        if ("type_tuning_data_yuv".equals(str)) {
            return !com.oplus.camera.util.Util.C_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT);
        }
        if ("type_tuning_data_raw".equals(str)) {
            return !com.oplus.camera.util.Util.C_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS);
        }
        return false;
    }

    public boolean needSatCrossAnimation() {
        return this.mCameraUIInterface != null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_NEED_CROSS_ANIMATION) && this.mCameraUIInterface.aw_renamed() && isSatOpen();
    }

    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        checkFunction();
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.ANTI_BANDING_ENABLE, isAntibandingEnable() ? "on_renamed" : "off");
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.QUICK_JPEG_SWITCH, java.lang.Boolean.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_JPEG)));
        if (isMirrorEnable() || this.mCameraUIInterface.e_renamed()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.MIRROR_ENABLE, this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_mirror_default_value)));
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EXPLORER_SUPPORT)) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.KEY_EXPLORER_CHIP_STATE, java.lang.Integer.valueOf(this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1)));
        }
        if (is10bitsHeicEncodeEnable()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.PHOTO_10BIT_ENABLE, "on_renamed");
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TORCH_FLASH)) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.TORCH_FLASH_ENABLE, "on_renamed");
        }
        if (isHighPictureSize()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.HIGH_PICTURE_SIZE_ENABLE, "on_renamed");
        }
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.MAKEUP_STATE, java.lang.Integer.valueOf(getMakeupState()));
        if (!android.text.TextUtils.isEmpty(this.mCameraInterface.aG_renamed())) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.KEY_CALLER_PACKAGE_NAME, this.mCameraInterface.aG_renamed().getBytes());
        }
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.KEY_REQUEST_ZSL_MODE, getZSLMode() ? new byte[]{1} : new byte[]{0});
        builder.setParameter(com.oplus.ocs.camera.CameraParameter.KEY_ZOOM_RATION_CONFIGURE, java.lang.Float.valueOf(getZoomValue()));
    }

    public void onSessionConfigured() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            resetScreenState();
        }
        if (this.mCameraInterface.S_renamed() && (isFilterEffectOpen() || getFaceBeautyCurrIndex() != 0)) {
            this.mCameraUIInterface.J_renamed();
        }
        clearFocusOutOfRange();
    }

    protected int getSwitchAnimTime(int i_renamed) {
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEFAULT_TO_REAL_SWITCH_ANIM_TIME);
        }
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEFAULT_TO_FRONT_SWITCH_ANIM_TIME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isPanelMode() {
        com.oplus.camera.ui.modepanel.i_renamed iVarA;
        if (isFromMainMenuApp() && (iVarA = com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(com.oplus.camera.ui.menu.a_renamed.c_renamed.e_renamed(com.oplus.camera.ui.menu.a_renamed.c_renamed.a_renamed(getCameraMode())))) != null) {
            return "position_mode_panel".equals(iVarA.c_renamed());
        }
        return false;
    }

    protected final boolean isSupportFastShot() {
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        return (dVar == null || dVar.e_renamed() == null || !this.mOneCamera.e_renamed().E_renamed()) ? false : true;
    }

    protected boolean isSloganOpen() {
        android.content.SharedPreferences sharedPreferences;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            return ((isSuperTextOpen() && isHasSuperTextDetectResult()) || is4k120fps() || (sharedPreferences = this.mPreferences) == null || !"on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"))) ? false : true;
        }
        return false;
    }

    protected boolean isMakeupSloganOpen() {
        return isSloganOpen() && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off"));
    }

    public java.lang.String getHeicCodecFormat() {
        if (this.mPreferences == null) {
            return null;
        }
        if ((isSuperTextOpen() && isHasSuperTextDetectResult()) || this.mbBurstShot || !this.mCameraInterface.i_renamed() || !isCaptureModeType() || isVideoRecording()) {
            return null;
        }
        if (is10bitsHeicEncodeEnable() && isHeifEnable()) {
            return "heic_10bits";
        }
        if ("HEIF".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG"))) {
            return "heic_8bits";
        }
        return null;
    }

    public boolean is10bitsHeicEncodeEnable() {
        android.content.SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off")) && !this.mbDestroyed && this.mCameraInterface.i_renamed();
        }
        return false;
    }

    protected int getBlurIndex() {
        if (isTiltShiftOpen()) {
            return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU_INDEX, 70);
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.BOKEH) || getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR)) {
            return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX, getDefaultBlurValue());
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS)) {
            return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX, getDefaultBlurValue());
        }
        return getDefaultBlurValue();
    }

    protected float getShowBlurValue() {
        int blurIndex = getBlurIndex();
        float[] videoBlurValues = com.oplus.camera.ui.menu.levelcontrol.c_renamed.getVideoBlurValues(this.mbFrontCamera);
        int blurIndexInArrays = getBlurIndexInArrays(videoBlurValues, 0, videoBlurValues.length, blurIndex);
        return -1 == blurIndexInArrays ? SYSTEM_BRIGHTNESS : com.oplus.camera.ui.menu.levelcontrol.c_renamed.BLUR_SHOWING_TEXT_VALUES[blurIndexInArrays];
    }

    private int getBlurIndexInArrays(float[] fArr, int i_renamed, int i2, float f_renamed) {
        int i3 = (i_renamed + i2) / 2;
        if (fArr[i3] == f_renamed) {
            return i3;
        }
        if (i_renamed >= i2) {
            return -1;
        }
        if (f_renamed < fArr[i3]) {
            return getBlurIndexInArrays(fArr, i_renamed, i3 - 1, f_renamed);
        }
        if (f_renamed > fArr[i3]) {
            return getBlurIndexInArrays(fArr, i3 + 1, i2, f_renamed);
        }
        return -1;
    }

    public int getDefaultBlurValue() {
        if (this.mbFrontCamera) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_BLUR_VALUE_DEFAULT);
        }
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_REAR_BLUR_VALUE_DEFAULT);
    }

    protected float getBlurValue() {
        return getBlurValue(getBlurIndex());
    }

    protected float getBlurValue(int i_renamed) {
        return new java.math.BigDecimal(i_renamed).multiply(com.oplus.camera.d_renamed.f4358c).floatValue();
    }

    protected boolean isShowUltraWide() {
        return (isVideoNeonOpen() || isBlurOpen()) ? false : true;
    }

    protected void setBlurIndex(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setBlurIndex, index: " + i_renamed);
        float blurValue = getBlurValue(i_renamed);
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.BOKEH)) {
            com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
            if (dVar != null) {
                dVar.a_renamed(blurValue);
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
            this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX, i_renamed).apply();
            return;
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BLUR)) {
            com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
            if (tVar != null) {
                tVar.a_renamed(blurValue);
            }
            this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX, i_renamed).apply();
            return;
        }
        if (isTiltShiftOpen()) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU_INDEX, i_renamed);
            editorEdit.apply();
            setTiltShiftPreview();
            return;
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS)) {
            com.oplus.camera.ui.preview.a_renamed.t_renamed tVar2 = this.mPreviewEffectProcess;
            if (tVar2 != null) {
                tVar2.b_renamed(blurValue);
            }
            android.content.SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
            editorEdit2.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX, i_renamed);
            if (i_renamed == 0) {
                editorEdit2.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off");
            } else {
                editorEdit2.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, "on_renamed");
            }
            if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
                editorEdit2.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, i_renamed != 0);
            }
            editorEdit2.apply();
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        }
    }

    public boolean isSatOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA);
    }

    public boolean isNoneSatUltraWideAngleOpen() {
        android.content.SharedPreferences sharedPreferences;
        android.app.Activity activity;
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) || (sharedPreferences = this.mPreferences) == null || (activity = this.mActivity) == null) {
            return false;
        }
        return "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, activity.getString(com.oplus.camera.R_renamed.string.ultra_wide_angle_default_value)));
    }

    public boolean isNoneSatTeleAngleOpen() {
        android.content.SharedPreferences sharedPreferences;
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE) || (sharedPreferences = this.mPreferences) == null) {
            return false;
        }
        return "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, this.mActivity.getString(com.oplus.camera.R_renamed.string.tele_angle_default_value)));
    }

    public void displayFixedUpModeHint() {
        this.mbShowEnvironmentTips = false;
    }

    private void updateMirrorParam() {
        com.oplus.camera.e_renamed.d_renamed dVar;
        if (!this.mbFrontCamera || (dVar = this.mOneCamera) == null) {
            return;
        }
        dVar.k_renamed(android.text.TextUtils.equals(getMirror(), "off"));
    }

    protected void setRawRequestTag(boolean z_renamed) {
        this.mbRawRequestTag = z_renamed;
    }

    public void setPreviewDetectResult(com.oplus.camera.u_renamed.a_renamed aVar) {
        this.mDetectResult = aVar;
    }

    public boolean isQrCodeOpened() {
        android.content.SharedPreferences sharedPreferences;
        return com.oplus.camera.l_renamed.a_renamed.d_renamed() && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_QR_CODE) && (sharedPreferences = this.mPreferences) != null && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_QR_CODE, "on_renamed"));
    }

    public void onReceivePreviewCaptureResult(android.hardware.camera2.CaptureResult captureResult) {
        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseAble(this.mActivity)) {
            updateScreenState(captureResult);
        } else {
            updateScreenBrightnessState(captureResult);
        }
        updateDarkEnvironmentTips(captureResult);
    }

    public void setFlashTemporaryDisabled(boolean z_renamed) {
        this.mbFlashTemporaryDisabled = z_renamed;
    }

    public void clearApsDecisionResult() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "clearApsDecisionResult");
        synchronized (this.mApsDecisionResultLock) {
            this.mDecisionResult = null;
        }
    }

    public void clearFocusOutOfRange() {
        this.mFocusOutOfRange = null;
    }

    public boolean isSupportSelectPhotoRatio() {
        return this.mbSupportSelectPhotoRatio;
    }

    public void setNeedCapture(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setNeedCapture, needCapture: " + z_renamed);
        if (z_renamed) {
            this.mbInCapturing = false;
            setCapturePreviewDataState(0);
        }
        synchronized (this.mNeedCaptureLock) {
            this.mbNeedCapture = z_renamed;
        }
    }

    public int getEntryGalleryAnim() {
        return com.oplus.camera.util.Util.t_renamed() ? com.oplus.camera.R_renamed.anim.gallery_in_folder : 1 == this.mActivity.getResources().getConfiguration().getLayoutDirection() ? com.oplus.camera.R_renamed.anim.gallery_in_rtl : com.oplus.camera.R_renamed.anim.gallery_in;
    }

    public float getPreviewXScale() {
        return this.mPreviewXScale;
    }

    public int getPreviewDispalyWidth() {
        return com.oplus.camera.util.Util.getScreenWidth();
    }

    public void setApsService(com.oplus.camera.aps.service.ApsService apsService) {
        this.mApsService = apsService;
    }

    private void updateScreenState(android.hardware.camera2.CaptureResult captureResult) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            if (this.mbInCapturing) {
                com.oplus.camera.ui.inverse.e_renamed.INS.removeMessages();
                return;
            }
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity));
            int threshold = com.oplus.camera.ui.inverse.e_renamed.INS.getThreshold();
            int thresholdRecover = com.oplus.camera.ui.inverse.e_renamed.INS.getThresholdRecover();
            if (threshold > 0) {
                if ("auto".equals(string)) {
                    if (exclusiveInverse()) {
                        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
                            com.oplus.camera.ui.inverse.e_renamed.INS.postInverseColor(this.mActivity.hashCode(), false, false);
                        }
                        com.oplus.camera.ui.inverse.e_renamed.INS.removeMessages();
                        checkFlashMode();
                    } else {
                        float fA_renamed = com.oplus.camera.util.Util.a_renamed(captureResult);
                        com.oplus.camera.e_renamed.a_renamed(TAG, "updateScreenState, currentLux: " + fA_renamed + ", threshold: " + threshold);
                        long frameNumber = captureResult.getFrameNumber();
                        if (500.0f != fA_renamed) {
                            this.mbLuxHasChange = true;
                        }
                        if (threshold <= fA_renamed && (10 < frameNumber || this.mbLuxHasChange)) {
                            if (!com.oplus.camera.ui.inverse.e_renamed.INS.setInverseDelay(this.mActivity, true, true, new com.oplus.camera.ui.inverse.e_renamed.a_renamed() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$A2xGlTZfC7H-3NriJYlQp7_Tkvk
                                @Override // com.oplus.camera.ui.inverse.e_renamed.a_renamed
                                public final void call() {
                                    this.f_renamed$0.lambda$updateScreenState$2$BaseMode();
                                }
                            })) {
                                checkFlashMode();
                            }
                            if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode()) && !this.mCameraUIInterface.av_renamed()) {
                                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.10
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (com.oplus.camera.capmode.BaseMode.this.mPreferences == null || com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface == null || !"auto".equals(com.oplus.camera.capmode.BaseMode.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(com.oplus.camera.capmode.BaseMode.this.mActivity)))) {
                                            return;
                                        }
                                        com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.flash_hint_icon, false, true, false);
                                    }
                                });
                            }
                        } else if (thresholdRecover > fA_renamed) {
                            if (!com.oplus.camera.ui.inverse.e_renamed.INS.setInverseDelay(this.mActivity, false, true, new com.oplus.camera.ui.inverse.e_renamed.a_renamed() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$dPQNtGnJJ6Pj54aeIJvoTRkdg9k
                                @Override // com.oplus.camera.ui.inverse.e_renamed.a_renamed
                                public final void call() {
                                    this.f_renamed$0.lambda$updateScreenState$3$BaseMode();
                                }
                            })) {
                                checkFlashMode();
                            }
                        } else {
                            checkFlashMode();
                            if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode()) && !this.mCameraUIInterface.av_renamed()) {
                                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (com.oplus.camera.capmode.BaseMode.this.mPreferences == null || com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface == null || !"auto".equals(com.oplus.camera.capmode.BaseMode.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(com.oplus.camera.capmode.BaseMode.this.mActivity)))) {
                                            return;
                                        }
                                        com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.flash_hint_icon, false, true, false);
                                    }
                                });
                            }
                        }
                    }
                }
                checkHighBrightness();
                return;
            }
            return;
        }
        if (sHighBrightness) {
            resetScreenState();
        }
    }

    public /* synthetic */ void lambda$updateScreenState$2$BaseMode() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.BaseMode.9
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.capmode.BaseMode.this.mPreferences == null || com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface == null || !"auto".equals(com.oplus.camera.capmode.BaseMode.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(com.oplus.camera.capmode.BaseMode.this.mActivity)))) {
                    return;
                }
                com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.a_renamed(-1, com.oplus.camera.R_renamed.drawable.flash_hint_icon, false, true, false);
                com.oplus.camera.capmode.BaseMode.this.checkFlashMode();
                com.oplus.camera.capmode.BaseMode.this.mCameraUIInterface.z_renamed();
            }
        });
    }

    public /* synthetic */ void lambda$updateScreenState$3$BaseMode() {
        displayAllIcon(this.mbAutoHDR, false);
        checkFlashMode();
        this.mCameraUIInterface.z_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFlashMode() {
        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode()) && !com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(this.mOneCamera.q_renamed())) {
            this.mOneCamera.b_renamed(com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        } else {
            if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode()) || "off".equals(this.mOneCamera.q_renamed())) {
                return;
            }
            this.mOneCamera.b_renamed("off");
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    private void checkHighBrightness() {
        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
            if (sHighBrightness && com.oplus.camera.ui.inverse.e_renamed.INS.getCurrentHighBrightnessValue() == getHighBrightnessValue()) {
                return;
            }
            com.oplus.camera.ui.inverse.e_renamed.INS.setCurrentHighBrightnessValue(getHighBrightnessValue());
            this.mCameraInterface.b_renamed(com.oplus.camera.ui.inverse.e_renamed.INS.getCurrentHighBrightnessValue());
            sHighBrightness = true;
            return;
        }
        if (sHighBrightness) {
            resetScreenState();
        }
    }

    protected float getHighBrightnessValue() {
        return com.oplus.camera.ui.inverse.e_renamed.INS.getBrightness();
    }

    private void updateScreenBrightnessState(android.hardware.camera2.CaptureResult captureResult) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity));
            float fA_renamed = com.oplus.camera.util.Util.a_renamed(captureResult);
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SCREEN_BRIGHTNESS_THRESHOLD);
            int configIntValue2 = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SCREEN_BRIGHTNESS_RECOVER_THRESHOLD);
            if (!sHighBrightness && configIntValue != 0 && configIntValue <= fA_renamed && ("on_renamed".equals(string) || "auto".equals(string))) {
                this.mCameraInterface.b_renamed(FLASH_BRIGHTNESS);
                sHighBrightness = true;
                return;
            } else {
                if (sHighBrightness) {
                    if ((configIntValue == 0 || configIntValue2 <= fA_renamed) && !"off".equals(string)) {
                        return;
                    }
                    resetScreenState();
                    return;
                }
                return;
            }
        }
        if (sHighBrightness) {
            resetScreenState();
        }
    }

    private int getFrontFlashHintDrawable() {
        return (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && "on_renamed".equals(getTorchMode()) && this.mbFrontCamera && !com.oplus.camera.entry.b_renamed.b_renamed(this.mCameraEntryType)) ? com.oplus.camera.R_renamed.drawable.torch_hint_icon : com.oplus.camera.R_renamed.drawable.flash_hint_icon;
    }

    private void resetScreenState() {
        this.mCameraInterface.b_renamed(SYSTEM_BRIGHTNESS);
        sHighBrightness = false;
    }

    public java.lang.String getRelativePath() {
        return com.oplus.camera.Storage.e_renamed(null);
    }

    private void updateDarkEnvironmentTips(android.hardware.camera2.CaptureResult captureResult) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_DARK_ENVIRONMENT_TIPS) && captureResult != null) {
            float fA_renamed = com.oplus.camera.util.Util.a_renamed(captureResult);
            int environmentTipsThreshold = getEnvironmentTipsThreshold();
            if (environmentTipsThreshold != 0 && environmentTipsThreshold < fA_renamed && !this.mbShowEnvironmentTips) {
                this.mbShowEnvironmentTips = true;
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_need_more_light, -1, true, false, false);
                return;
            } else {
                if (environmentTipsThreshold == 0 || environmentTipsThreshold <= fA_renamed || !this.mbShowEnvironmentTips) {
                    return;
                }
                this.mbShowEnvironmentTips = false;
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_need_more_light);
                return;
            }
        }
        if (this.mbShowEnvironmentTips) {
            this.mbShowEnvironmentTips = false;
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_need_more_light);
        }
    }

    public void setVideoBlurEffect(boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed.t_renamed tVar = this.mPreviewEffectProcess;
        if (tVar != null) {
            tVar.i_renamed(z_renamed);
        }
    }

    protected void sendBoradCastNotifyMicroscopeState(boolean z_renamed) {
        android.content.Intent intent;
        if (z_renamed) {
            intent = new android.content.Intent("oplus.camera.microscope.start");
        } else {
            intent = new android.content.Intent("oplus.camera.microscope.stop");
        }
        this.mActivity.sendBroadcast(intent, "com.oplus.permission.safe.PHONE");
    }

    public long getCaptureMergeIdentity() {
        return this.mCaptureMergeIdentity;
    }

    public void setLSDEnable() {
        com.oplus.camera.e_renamed.d_renamed dVar = this.mOneCamera;
        if (dVar != null) {
            dVar.z_renamed(isLensDirtyDetectionOpen() ? 1 : 0);
        }
    }

    public boolean isMenuOn(java.lang.String str) {
        return (this.mPreferences == null || android.text.TextUtils.isEmpty(str) || !"on_renamed".equals(this.mPreferences.getString(str, "off"))) ? false : true;
    }

    protected long getHalMemory() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HAL_MEMORY_COMMON);
    }

    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        android.content.SharedPreferences sharedPreferences;
        boolean z_renamed = (cVar == null || cVar.N_renamed == null || 5 != cVar.N_renamed.mApsDecisionFeatureType || (isFaceBeautyOrMakeupOpen() && (!this.mbFrontCamera || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MTK_FACE_BEAUTY_REMOSAIC_SUPPORT))) || isFilterEffectOpen() || isPIAISceneOpen()) ? false : true;
        boolean z2 = (cVar == null || cVar.N_renamed == null || 4 != cVar.N_renamed.mSupportCaptureZoomFeature) ? false : true;
        boolean z3 = (cVar == null || cVar.e_renamed.equals("none") || (sharedPreferences = this.mPreferences) == null || !"on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off")) || !"on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off"))) ? false : true;
        boolean z4 = cVar != null && cVar.f4423a && isHasSuperTextDetectResult();
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        return (aVar == null || !aVar.i_renamed() || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_JPEG) || !com.oplus.camera.util.Util.w_renamed(this.mActivity) || z_renamed || (cVar == null ? this.mbBurstShot : cVar.j_renamed) || z2 || z3 || z4 || isVideoRecording() || (isInNightProcess() && !isInOfflineNightProcess())) ? false : true;
    }

    public boolean isSupportHyperLapseZoomChange() {
        float[] configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HYPER_LAPSE_ZOOM_LIST_SUPPORT);
        return configFloatArrayValue != null && configFloatArrayValue.length > 1;
    }

    public boolean isHyperLapseUltraWide() {
        float[] configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HYPER_LAPSE_ZOOM_LIST_SUPPORT);
        return (configFloatArrayValue == null || configFloatArrayValue.length == 0 || configFloatArrayValue[0] != 0.6f) ? false : true;
    }

    public com.oplus.camera.screen.f_renamed.a_renamed getPreferredScreenMode(int i_renamed) {
        return com.oplus.camera.screen.f_renamed.a_renamed.common;
    }

    protected void processFaceCount() {
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar == null || this.mCameraUIInterface == null) {
            return;
        }
        int i_renamed = this.mFaceCountStatusCount;
        if (i_renamed < 30) {
            this.mFaceCountStatusCount = i_renamed + 1;
            return;
        }
        this.mFaceCountStatusCount = 0;
        if (aVar.aj_renamed() > 1) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_one_subject_hint, -1, true, false, false);
        } else {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_one_subject_hint);
        }
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public void resetMonoFilter() {
        if (isMonoIndex(getCurrFilterIndex())) {
            if (this.mCameraUIInterface.A_renamed()) {
                this.mCameraUIInterface.m_renamed(true, false);
            }
            if (isFilterEffectOpen()) {
                this.mPreferences.edit().putInt(getFilterEffectMenuPreferenceKey(), com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a).apply();
            }
        }
    }

    public com.oplus.camera.screen.b_renamed.a_renamed getCurrentScreenMode() {
        com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
        if (aVar == null) {
            return null;
        }
        return aVar.aV_renamed();
    }

    private void checkExplorerChipState(android.hardware.camera2.CaptureResult captureResult) {
        android.app.Activity activity;
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.at_renamed);
        if (objA instanceof java.lang.Integer) {
            int iIntValue = ((java.lang.Integer) objA).intValue();
            int i_renamed = (iIntValue == 1073741824 || iIntValue == 0) ? 0 : 1;
            int i2 = this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1);
            com.oplus.camera.e_renamed.b_renamed(TAG, "checkExplorerChipState, explorerChipStateValue: " + java.lang.Integer.toHexString(iIntValue));
            if (i_renamed != i2) {
                this.mPreferences.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_EXPLORER_CHIP_STATE, i_renamed).apply();
                if (1073741824 != iIntValue || (activity = this.mActivity) == null || activity.isFinishing()) {
                    return;
                }
                this.mActivity.finish();
            }
        }
    }
}
