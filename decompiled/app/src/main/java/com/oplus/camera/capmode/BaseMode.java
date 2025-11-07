package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.Face;
import android.media.CamcorderProfile;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.ZoomManager;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraTipsManager;
import com.oplus.camera.MagShellResponseStatus;
import com.oplus.camera.OplusConfigure;
import com.oplus.camera.Camera;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.algovisualization.AppAlgoProcessor;
import com.oplus.camera.algovisualization.VisualizationStatePreferenceHelper;
import com.oplus.camera.algovisualization.AlgoVisualViewManager;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.service.ApsService;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.service.ThumbnailItem;
import com.oplus.camera.aps.service.ThumbnailProcessor;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.capmode.p139a.MultiCameraDecision;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.camera.doubleexposure.VideoClipManager;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCameraProxy;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p144g.C2735b;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p153l.MyRegionAdapter;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.OplusViewOutlineProvider;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.levelcontrol.BlurMenu;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import com.oplus.camera.p172ui.modepanel.DataBaseOperator;
import com.oplus.camera.p172ui.modepanel.ModeDataInfo;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.FilterModel;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.ImageCallback;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.perf.ComprehensivePerformance;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.tiltshift.TiltShiftParam;
import com.oplus.camera.util.Util;
import com.oplus.exif.OplusExifTag;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.tblplayer.misc.MediaInfo;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class BaseMode implements CameraConstant, OneCamera.PlatformImplementations.kt_3 {
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
    public static final String CONTACT_PACKAGE_NAME = "com.android.contacts";
    private static final int DATA_PADDING_ALIGN = 16;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_EXPECTED_FRAME_RATE = 30;
    private static final int DEFAULT_LUX_VALUE = 500;
    private static final int DIS_SCREEN_HINT_ICON_DELAY = 400;
    private static final int FACE_COUNT_CHECKING_SIZE = 30;
    private static final float FLASH_BRIGHTNESS = 0.8f;
    public static final String GOOGLE_KEEP_PACKAGE_NAME = "com.google.android.keep";
    public static final int ISO_CONSTANT = 100;
    private static final String KEY_IS_BURST_SHOT = "is_burst_shot";
    private static final String KEY_PICTURE_DATA = "picture_data";
    private static final String KEY_PICTURE_FORMAT = "picture_format";
    private static final String KEY_PICTURE_HEIGHT = "picture_height";
    private static final String KEY_PICTURE_WIDTH = "picture_width";
    private static final String KEY_REQ_FORMAT = "request_format";
    public static final float MAX_BRIGHTNESS = 255.0f;
    public static final String MMS_PACKAGE_NAME = "com.android.mms";
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
    public static final String PICTURE_SIZE_5M = "5000000";
    public static final String PICTURE_SIZE_8M = "8000000";
    private static final int PI_OFF = 0;
    private static final int PI_ON = 1;
    private static final int PULL_DOWN_ANIMATION_DURATION = 500;
    private static final int SAT_CAMERA_NUMBER = 3;
    private static final int SLOGAN_OFF = 0;
    private static final int SLOGAN_ON = 1;
    private static final float SYSTEM_BRIGHTNESS = -1.0f;
    private static final String TAG = "BaseMode";
    protected static final int TOLERATE_TIME = 10;
    public static final float VALUE_HYPER_LAPSE_ULTRA_WIDE = 0.6f;
    public static final int ZOOM_LIST_DEFAULT_LENGTH = 1;
    public AlgoVisualViewManager algoVisualViewManager;
    protected Activity mActivity;
    protected CameraEntry mCameraEntry;
    protected int mCameraEntryType;
    protected CameraInterface mCameraInterface;
    protected CameraUIInterface mCameraUIInterface;
    protected int mCaptureOrientation;
    public String mModeName;
    protected SharedPreferences mPreferences;
    protected PreviewEffectProcess mPreviewEffectProcess;
    private VisualizationStatePreferenceHelper mStatePreferenceHelper;
    protected boolean mbInCapturing;
    protected boolean mbShowPostCaptureAlert;
    public SharedPreferences preferences;
    public static final String[] FILTER_KEYS = {CameraUIInterface.KEY_PHOTO_RATIO, CameraUIInterface.KEY_FLASH_MODE};
    public static final String NOTE_PACKAGE_NAME = OplusConfigure.m24653c();
    protected static boolean sHighBrightness = false;
    private static boolean sbRearDirtyLensToastShown = true;
    private static boolean sbFrontDirtyLensToastShown = true;
    protected final Object mApsDecisionResultLock = new Object();
    protected final Object mNeedCaptureLock = new Object();
    private final Object mCapturePreviewDataStateLock = new Object();
    public float mPreviewXScale = 1.0f;
    public float mBrightness = 255.0f;
    public boolean mbHasClickedFromThird = false;
    public int[] mForceUpscaleSize = null;
    public int mApsDecisionSceneMode = 0;
    public String[] mApsAlgoFlag = null;
    public int[] mCaptureEVList = null;
    public ArrayList<String> mPreAlgoListFromApp = null;
    public ArrayList<String> mCapAlgoListFromApp = null;
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
    protected String mHDRMode = "off";
    protected String mFlashMode = "off";
    protected OneCamera mOneCamera = null;
    protected ViewGroup mCameraRootView = null;
    protected List<String> mEffectMenuNames = null;
    protected String mEffectMenuSelect = "beauty";
    protected CameraApsDecision mDecisionResult = null;
    protected DetectResult mDetectResult = null;
    protected int mCaptureStartedCallbackNum = 0;
    protected ApsService mApsService = null;
    protected Integer mPreviweStreamNeedState = 1;
    protected CameraRequestTag mCaptureRequestTag = null;
    protected boolean mbRawRequestTag = false;
    protected boolean mbBackPressedAfterCapture = false;
    protected int mApsBracketMode = 0;
    protected int mAsdSceneValue = 0;
    protected long mCaptureDate = 0;
    protected int mApsDecisionFeatureType = 0;
    protected int mFaceCountStatusCount = 0;
    protected String mFullAlgoKey = "";
    protected String mFullAlgoValue = "";
    private Object mFocusOutOfRange = null;
    private boolean mbNeedReloadFlashMenu = false;
    private boolean mbShowEnvironmentTips = false;
    private boolean mbTrackFocusOpen = false;
    private boolean mbSupportSelectPhotoRatio = false;
    private int mCapturePreviewDataState = 0;
    private String mThumbnailTitle = null;
    private BaseSloganUtil mBaseSloganUtil = null;
    private int mMergeIndex = 0;
    private long mCaptureMergeIdentity = 0;
    private long mReprocessMetadataTimeStamp = 0;
    private int mEVValueFromMetadata = 0;
    private boolean mbLuxHasChange = false;
    private int mMultiFrameCount = 1;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.capmode.BaseMode.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                CameraLog.m12967f(BaseMode.TAG, "handleMessage, msg is null");
            }
            CameraLog.m12962c(BaseMode.TAG, "handleMessage, msg is: " + BaseMode.this.getMessageType(message.what));
            switch (message.what) {
                case 1:
                    Bundle data = message.getData();
                    if (data != null) {
                        BaseMode.this.doOnPictureCallback((byte[]) data.get(BaseMode.KEY_PICTURE_DATA), ((Integer) data.get(BaseMode.KEY_PICTURE_WIDTH)).intValue(), ((Integer) data.get(BaseMode.KEY_PICTURE_HEIGHT)).intValue(), ((Integer) data.get(BaseMode.KEY_PICTURE_FORMAT)).intValue(), ((Boolean) data.get(BaseMode.KEY_IS_BURST_SHOT)).booleanValue(), ((Integer) data.get(BaseMode.KEY_REQ_FORMAT)).intValue());
                        break;
                    }
                    break;
                case 2:
                    BaseMode.this.displayScreenHintIconInSwitchOn();
                    break;
                case 3:
                    BaseMode.this.doAfterStartPreview();
                    break;
                case 4:
                    BaseMode.this.updateEffectMenuNames();
                    break;
                case 5:
                    BaseMode.this.doCreateEffectTextures((ImageCallback) message.obj);
                    break;
                case 6:
                    BaseMode.this.mCameraUIInterface.mo18094a((Thumbnail) message.obj, 1);
                    break;
                case 7:
                    if (!BaseMode.this.mbPaused && BaseMode.this.mCameraUIInterface != null && !BaseMode.this.mCameraUIInterface.mo18117aG()) {
                        BaseMode.this.showNextTip();
                        break;
                    }
                    break;
                case 8:
                    if (!BaseMode.this.mbPaused) {
                        CameraLog.m12952a("onShowBubble");
                        BaseMode.this.onShowBubble();
                        CameraLog.m12958b("onShowBubble");
                        break;
                    }
                    break;
                case 9:
                    if (!BaseMode.this.mbPaused && BaseMode.this.mActivity != null) {
                        BaseMode baseMode = BaseMode.this;
                        baseMode.showFirstBubble(baseMode.mActivity.findViewById(R.id_renamed.face_beauty_enter_button), 17);
                        break;
                    }
                    break;
                case 10:
                    if (BaseMode.this.mCameraUIInterface != null && BaseMode.this.mHandler != null) {
                        BaseMode.this.mCameraUIInterface.mo18210f(17, true);
                        BaseMode.this.mHandler.removeMessages(9);
                        break;
                    }
                    break;
                case 11:
                    if (BaseMode.this.mCameraUIInterface != null && BaseMode.this.mHandler != null) {
                        BaseMode.this.mCameraUIInterface.mo18210f(20, true);
                        break;
                    }
                    break;
            }
        }
    };
    private final CameraPictureCallback mCameraPictureCallback = new CameraPictureCallback() { // from class: com.oplus.camera.capmode.BaseMode.3
        @Override // com.oplus.ocs.camera.CameraPictureCallback
        public void onCaptureFailed(CameraPictureCallback.CameraPictureResult cameraPictureResult) {
            if (BaseMode.this.interruptCaptureFailedEvent()) {
                CameraLog.m12967f(BaseMode.TAG, "onCaptureFailed, interruptCaptureFailedEvent");
                return;
            }
            super.onCaptureFailed(cameraPictureResult);
            int iIntValue = cameraPictureResult != null ? ((Integer) cameraPictureResult.get(CameraParameter.CAPTURE_FAIL_CODE)).intValue() : 0;
            CameraLog.m12967f(BaseMode.TAG, "onCaptureFailed, resultCode: " + iIntValue);
            if (BaseMode.this.mCameraUIInterface != null && BaseMode.this.mCameraUIInterface.mo18183c() != null) {
                BaseMode.this.mCameraUIInterface.mo18183c().m14222a(BaseMode.this.mCaptureMergeIdentity);
            }
            if (iIntValue == 1) {
                CameraLog.m12967f(BaseMode.TAG, "beforeSnapping, memory is not enough!");
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MEMORY_NOT_ENOUGH_HINT)) {
                    BaseMode.this.showLowMemory();
                }
                BaseMode.this.resetWhenCaptureFail();
                BaseMode.this.mbInCapturing = false;
            }
            BaseMode.this.setAllowSwitchMode(true);
            BaseMode.this.setCapturePreviewDataStateIdle();
            if (BaseMode.this.mCameraInterface != null) {
                BaseMode.this.mCameraInterface.mo10569f(true);
            }
            BaseMode baseMode = BaseMode.this;
            baseMode.onPictureCallback(null, 0, 0, baseMode.getImageFormat(), false, 0);
            if (!BaseMode.this.mbBurstShot || BaseMode.this.mbPaused) {
                return;
            }
            BaseMode.this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.3.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseMode.this.disableBurstShot();
                }
            });
        }
    };

    /* renamed from: com.oplus.camera.capmode.BaseMode$PlatformImplementations.kt_3 */
    protected enum EnumC2645a {
        INPUT,
        OUTPUT
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMessageType(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
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

    public void beforeStartRecording(boolean z) {
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

    public void cancelOp(boolean z) {
    }

    public boolean check3HDRPreCondition() {
        return false;
    }

    public void checkAiEnhancementVideoState() {
    }

    public void checkFunction() {
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void checkIfLockAutoExposure() {
    }

    public boolean checkSensorMask(boolean z, boolean z2) {
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

    public boolean consumeImage(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        return false;
    }

    public void deleteCurrentVideo() {
    }

    protected boolean disableBokehHDR(CameraApsDecision cameraApsDecision) {
        return false;
    }

    public void disableRedDotHintOnModes() {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void doReturnToCaller(boolean z) {
    }

    public boolean enterNeedShutterButtonAlphaTransition() {
        return false;
    }

    protected boolean exclusiveInverse() {
        return false;
    }

    public void forceStopVideoRecording(boolean z) {
    }

    public void generateImageInfo(Map<String, Object> map) {
    }

    protected Thumbnail.IntrinsicsJvm.kt_3 getAfterStoreRunnable() {
        return null;
    }

    public int getAssistViewLayoutType() {
        return 0;
    }

    protected String getBackUpFaceBeautyKey() {
        return null;
    }

    public int getBeauty3DScanIconType(int OplusGLSurfaceView_13) {
        return 0;
    }

    protected int getBeauty3Dstatus() {
        return 0;
    }

    protected int getBubbleOffsetX(int OplusGLSurfaceView_13) {
        return 0;
    }

    protected int getBubbleOffsetY(int OplusGLSurfaceView_13) {
        return 0;
    }

    public String getCameraFeature() {
        return null;
    }

    public abstract String getCameraMode();

    protected OneCamera.PlatformImplementations.kt_3 getCaptureCallback() {
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

    protected String[] getCustomBeautyKeys() {
        return null;
    }

    protected int getDefaultMakeupIndex() {
        return 0;
    }

    public float getDefaultZoomValue(OplusCameraCharacteristics c2698h) {
        return 1.0f;
    }

    public int getEnvironmentTipsThreshold() {
        return 0;
    }

    public int getExpectedFrameRate() {
        return 30;
    }

    protected String getFaceBeautyKey() {
        return null;
    }

    protected int getFaceBeautyModeIndex() {
        return 0;
    }

    public String getFilterEffectMenuPreferenceKey() {
        return "key_filter_index";
    }

    public String getFilterEffectPrevSelectedKey() {
        return CameraUIInterface.KEY_FILTER_PREV_SELECTED_FILTERTYPE;
    }

    public int getFilterNoneIndex() {
        return 0;
    }

    public String getFilterRedpotKey(String str) {
        return null;
    }

    public int getFilterTitleTexId() {
        return R.string.camera_filter;
    }

    protected int getFrontDefaultCommonBeautyValue() {
        return 40;
    }

    public boolean getFrontEnable() {
        return true;
    }

    public String getFullPictureSizeType() {
        return DcsMsgData.FULL;
    }

    public boolean getGrandTourFilterKey(String str) {
        return false;
    }

    protected String getGuideLineKey() {
        return CameraUIInterface.KEY_LINE_PHOTO;
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

    public ScreenModeConst.PlatformImplementations.kt_3 getLockedScreenMode() {
        return null;
    }

    protected String[] getMakeupKeys() {
        return null;
    }

    protected int getMakeupOpenState() {
        return 1;
    }

    protected String getMakeupTypeKey() {
        return CameraUIInterface.KEY_COMMON_MAKEUP_TYPE;
    }

    public Byte getMovieHdrEnable() {
        return null;
    }

    protected MultiCameraDecision getMultiCameraDecision() {
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

    protected String getPhotoRatio() {
        return null;
    }

    public OplusViewOutlineProvider getPreviewOutlineProvider() {
        return null;
    }

    public int getPreviewStreamNum() {
        return 1;
    }

    public Size getPreviewSurfaceSize(Size size) {
        return size;
    }

    public CamcorderProfile getProfile() {
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

    public boolean getSupportSubMenu(String str) {
        return false;
    }

    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) {
        return z;
    }

    public int getVideoFps() {
        return 0;
    }

    public Range<Integer> getVideoFpsRange() {
        return null;
    }

    protected int getVideoOrientation(int OplusGLSurfaceView_13) {
        return 0;
    }

    public String getVideoSizeType() {
        return null;
    }

    public Bitmap getVideoThumbnail(int OplusGLSurfaceView_13) {
        return null;
    }

    protected boolean getZoomAutoMicroOpen() {
        return false;
    }

    public int getZoomBarOffset() {
        return 0;
    }

    public void handleStartError(boolean z, boolean z2) {
    }

    public void hideBubble(String str) {
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

    protected boolean isCameraSettingMenuOptionEnable(String str) {
        return true;
    }

    protected boolean isCaptureInDarkLight(int OplusGLSurfaceView_13) {
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

    public boolean isFirstTipsEnable(String str) {
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

    public boolean isMonoIndex(int OplusGLSurfaceView_13) {
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

    public boolean needConfigPhysicalStream(String str) {
        return false;
    }

    public boolean needDelayCloseForCapture() {
        return true;
    }

    public boolean needDelayFaceDetection() {
        return false;
    }

    public boolean needDeleteTheSizeByRatio(String str) {
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

    public boolean needPreviewMeta(int OplusGLSurfaceView_13) {
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

    protected void onAISSnapshotChecked(CameraApsDecision cameraApsDecision) {
    }

    public void onAISceneClosed(int OplusGLSurfaceView_13) {
    }

    protected abstract void onAfterPictureTaken(byte[] bArr, boolean z);

    public boolean onAfterSnapping() {
        return true;
    }

    public void onApsPreviewCaptureCompleted(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, boolean z) {
    }

    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
    }

    protected abstract void onBeforePreview();

    protected abstract boolean onBeforeSnapping(CameraRequestTag c2693c);

    protected void onBinauralRecordStateChanged(boolean z) {
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

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult) {
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureSequenceCompleted() {
    }

    protected abstract void onDeInitCameraMode(String str);

    protected abstract void onDestroy();

    protected void onDisableBurstShot() {
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onEffectItemClick(int OplusGLSurfaceView_13) {
        return false;
    }

    public void onEffectMenuPopDown(boolean z) {
    }

    public void onEffectMenuPopUp() {
    }

    public boolean onFaceBeautyMenuClick() {
        return true;
    }

    public void onFaceBeautyMenuClose() {
    }

    protected void onFilterListTypeChanged(int OplusGLSurfaceView_13) {
    }

    protected void onFilterMenuClicked() {
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onFirstCaptureFrameAdd() {
    }

    protected void onFrameInterpolationStarted() {
    }

    public DcsMsgData onGetAfterCaptureMsgCommonData(DcsMsgData dcsMsgData, Storage.CameraPicture cameraPicture) {
        return dcsMsgData;
    }

    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        return dcsMsgData;
    }

    public void onGetNearMeOnClickData() {
    }

    public void onHomeKeyClick() {
    }

    public boolean onImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        return false;
    }

    protected abstract void onInitCameraMode();

    public boolean onLongPress(MotionEvent motionEvent) {
        return false;
    }

    public void onMenuBackButtonClick() {
    }

    public void onMenuOptionAdded(String str) {
    }

    public void onMenuOptionRemoved(String str) {
    }

    public void onModeShownTips(int OplusGLSurfaceView_13) {
    }

    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
    }

    public void onMoreModeShown() {
    }

    protected void onMotionDetected() {
    }

    protected abstract void onPause();

    protected boolean onPreviewFrameReceived(Image image) {
        return true;
    }

    public void onProcessCapturePictureRequest() {
    }

    public void onRawImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
    }

    protected void onResumeFromSetting() {
    }

    public void onScreenOffWhenLocked() {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
        return false;
    }

    public void onSendCapturePictureRequest() {
    }

    public void onShareMenuExpand() {
    }

    public void onShutterButtonLongClick() {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void onSlowVideoFrameChange(int OplusGLSurfaceView_13) {
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

    public void onVideoLoadedDone(ClipVideoInfo c2683b, VideoClipManager.PlatformImplementations.kt_3 aVar) {
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
    public void m17833aj() {
    }

    public void onVideoTemperatureThresholdChanged(int OplusGLSurfaceView_13) {
    }

    public void onYuvDataReceviced(byte[] bArr) {
    }

    public void onZoomAlphaChanged(float COUIBaseListPopupWindow_12) {
    }

    public void onZoomChanged() {
    }

    public void onZoomMenuCollapsed() {
    }

    public void onZoomMenuCollapsing() {
    }

    public void onZoomMenuExpand() {
    }

    public void onZoomTransitionChanged(int OplusGLSurfaceView_13) {
    }

    public void operateSpecificViewCallBack(Object obj, boolean z, boolean z2) {
    }

    public void operateViewWhenMultiFinger(boolean z) {
    }

    public boolean performSlide(int OplusGLSurfaceView_13, MotionEvent motionEvent) {
        return false;
    }

    public void reportIntelligentDragViewMoveToDcs(int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
    }

    public void resetCaptureButton() {
    }

    public void resetFiltersList() {
    }

    public void resetMetadataBokehCode() {
    }

    protected void resetWhenCaptureFail() {
    }

    public void restoreDefaultMode(boolean z) {
    }

    protected void restoreEffectAfterBurstShot() {
    }

    public void revertOp() {
    }

    protected void saveAndClearEffectBeforeBurstShot() {
    }

    protected void setBeauty3DState(int OplusGLSurfaceView_13) {
    }

    public void setFlashState() {
    }

    protected void setFocusTrackingLocation(float COUIBaseListPopupWindow_12, float f2) {
    }

    protected void setFocusTrackingState(boolean z) {
    }

    protected void setFocusingSoundVolume(int OplusGLSurfaceView_13) {
    }

    public void setLowBatteryState(boolean z) {
    }

    public void setOpenFaceBeautyMenu(boolean z) {
    }

    public void setPIEnable(int OplusGLSurfaceView_13, boolean z) {
    }

    public void setPreburstShotCapture(boolean z) {
    }

    protected void setQuickVideoBeforeLockTime(boolean z) {
    }

    protected void setVideoBlurOpen(boolean z) {
    }

    protected void setVideoSoundValue(float COUIBaseListPopupWindow_12) {
    }

    public boolean shouldHideBlur() {
        return true;
    }

    public boolean showEffectMenu() {
        return true;
    }

    public void startLoadVideo(boolean z) {
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

    public void switchSuperEISWide(boolean z) {
    }

    protected void switchVideoBlur(boolean z, boolean z2) {
    }

    public void updateControlPanelBgColor(int OplusGLSurfaceView_13) {
    }

    public void updateGrandTourCityFiltersPosition(String str) {
    }

    public void updateHintView() {
    }

    public void updateRatioType() {
    }

    public boolean updateViewByEnterCameraType() {
        return false;
    }

    public BaseMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        this.mCameraInterface = null;
        this.mCameraUIInterface = null;
        this.mActivity = null;
        this.mPreferences = null;
        this.mPreviewEffectProcess = null;
        this.mCameraEntry = null;
        this.mCameraEntryType = 1;
        CameraLog.m12954a(TAG, "BaseMode, constructor init");
        this.mActivity = activity;
        this.mCameraInterface = interfaceC2646a;
        this.mCameraUIInterface = cameraUIInterface;
        this.mPreferences = this.mCameraInterface.mo10590t();
        this.mPreviewEffectProcess = interfaceC3423t;
        this.mCameraEntry = this.mCameraInterface.mo10551b();
        this.mCameraEntryType = this.mCameraEntry.m13317J();
        this.mStatePreferenceHelper = new VisualizationStatePreferenceHelper(this.mActivity);
    }

    public final int getProperCameraId(int OplusGLSurfaceView_13) {
        CameraEntry c2701b = this.mCameraEntry;
        if (c2701b == null) {
            return -1;
        }
        return c2701b.m13329a(getCameraMode(), OplusGLSurfaceView_13);
    }

    public MainShutterButtonInfo getShutterButtonInfo() {
        SharedPreferences sharedPreferences = this.mPreferences;
        String str = "button_shape_ring_none";
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(R.string.camera_shutter_mode_default_value));
            if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return new MainShutterButtonInfo(1, "button_color_inside_none", str, 0);
    }

    protected void onResume(boolean z) {
        this.mbLuxHasChange = false;
    }

    public void resetAeLockAfterCaptured() {
        OneCamera interfaceC2694d;
        if (!this.mbResetAeLockAfterCaptured || (interfaceC2694d = this.mOneCamera) == null) {
            return;
        }
        this.mbResetAeLockAfterCaptured = false;
        interfaceC2694d.mo13071b(this.mCameraInterface.mo10596z(), false);
        if (this.mCameraInterface.mo10575i()) {
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    public void resetAwbLockAfterCaptured() {
        OneCamera interfaceC2694d;
        if (!this.mbResetAwbLockAfterCaptured || (interfaceC2694d = this.mOneCamera) == null) {
            return;
        }
        this.mbResetAwbLockAfterCaptured = false;
        interfaceC2694d.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
        if (this.mCameraInterface.mo10575i()) {
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    private void showBubble() {
        this.mHandler.removeMessages(8);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(8), 100L);
    }

    protected void showFirstBeautyTipView() {
        Handler handler = this.mHandler;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 9;
            this.mHandler.sendMessage(messageObtainMessage);
        }
    }

    protected void hideFirstBeautyTipView() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(10));
        }
    }

    protected void hideStreetRockerShutterTipView() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(11));
        }
    }

    public void onShowBubble() {
        CameraInterface interfaceC2646a;
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null || (sharedPreferences != null && (!sharedPreferences.getBoolean(CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false) || !this.mPreferences.getBoolean("pref_camera_statement_key", false)))) {
            CameraLog.m12959b(TAG, "onShowBubble return");
        } else {
            if (this.mCameraUIInterface == null || (interfaceC2646a = this.mCameraInterface) == null || !interfaceC2646a.mo10575i() || this.mCameraInterface.mo10463S()) {
                return;
            }
            showNextTip();
        }
    }

    public void showFirstBubble(View view, int OplusGLSurfaceView_13) {
        if (this.mCameraUIInterface != null) {
            int bubbleOffsetX = getBubbleOffsetX(OplusGLSurfaceView_13);
            if (-1 != bubbleOffsetX) {
                this.mCameraUIInterface.mo18086a(view, OplusGLSurfaceView_13, bubbleOffsetX, getBubbleOffsetY(OplusGLSurfaceView_13));
            } else {
                CameraLog.m12966e(TAG, "showFirstBubble, ultra wide anchor view not found");
            }
        }
    }

    public void sendDrawerSettingGuideAniDelayMessage() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(7), 1000L);
    }

    public void showNextTip() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(7);
        }
    }

    public void showFirstTip() {
        Handler handler;
        if (!isBubbleOpen(CameraUIInterface.KEY_FIRST_BEAUTY_TIPS) || (handler = this.mHandler) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
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

    public void updateBracketMode(boolean z, int OplusGLSurfaceView_13) {
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13137u(OplusGLSurfaceView_13);
            if (z) {
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    public void updateAsdSceneValue(boolean z, int OplusGLSurfaceView_13) {
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13141v(OplusGLSurfaceView_13);
            if (z) {
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    private void updateNeonValue() {
        OneCamera interfaceC2694d;
        if (Util.m24169C()) {
            return;
        }
        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT)) && (interfaceC2694d = this.mOneCamera) != null) {
            interfaceC2694d.mo13014C("neon-2020.cube.rgb.bin".equals(getCurrFilterType()));
        }
    }

    public void updateRearAicolorEnable(boolean z, boolean z2) {
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13130r(z2);
            if (z) {
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    public void updateVideoNeonEnable(boolean z, boolean z2) {
        if (this.mOneCamera != null) {
            CameraLog.m12954a(TAG, "setVideoNeonEnable, submit: " + z + ", enable: " + z2);
            this.mOneCamera.mo13133s(z2);
            if (z) {
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    public void updateVideoBlurEnable(boolean z, boolean z2) {
        if (this.mOneCamera != null) {
            CameraLog.m12954a(TAG, "setVideoBlurEnable, submit: " + z + ", enable: " + z2);
            this.mOneCamera.mo13136t(z2);
            if (z) {
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    public void onPreviewDecisionResult(CameraApsDecision cameraApsDecision) {
        if (this.mbDestroyed) {
            CameraLog.m12954a(TAG, "onPreviewDecisionResult, mbDestroyed is true, so return.");
            return;
        }
        CameraRequestTag captureRequestTag = getCaptureRequestTag(cameraApsDecision, true);
        if (this.mStatePreferenceHelper == null) {
            Activity activity = this.mActivity;
            if (activity == null) {
                CameraLog.m12954a(TAG, "onPreviewDecisionResult, mActivity is null, so return.");
                return;
            }
            this.mStatePreferenceHelper = new VisualizationStatePreferenceHelper(activity);
        }
        if (this.mStatePreferenceHelper.m11639b() && this.mStatePreferenceHelper.m11637a()) {
            AppAlgoProcessor c2620d = new AppAlgoProcessor(isBlurOpen(), isFilterOpen(getCurrFilterType()), isFaceBeautyOpen(), isMultiStickerOpen(), isAnimojiOpen(), getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS), isVideoNeonOpen(), isSuperTextOpen(), isVideoRetentionOpen(), isTiltShiftOpen(), isDoubleExposureOpen(), isFishEyeMode(), this.mbBurstShot, isFaceRectifyOpen(), getSupportFunction(CameraFunction.DERED_EYE), isFlashState(), getSupportFunction(CameraFunction.VIDEO_RETENTION), isHasSuperTextDetectResult(), isSloganOpen(), getTiltShiftBlurValue(), this.mCameraId);
            this.mCapAlgoListFromApp = c2620d.m11615a(captureRequestTag);
            this.mPreAlgoListFromApp = c2620d.m11614a();
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
                boolean z = this.mDecisionResult == null && cameraApsDecision != null;
                this.mDecisionResult = cameraApsDecision;
                updateAutoHDRUI(cameraApsDecision);
                updateAutoSeNightUI(cameraApsDecision);
                if (z) {
                    this.mCameraUIInterface.mo18247n(getSupportQuickJpeg(null) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CACHE_WHILE_PREVIEW));
                }
                synchronized (this.mNeedCaptureLock) {
                    if (this.mbNeedCapture) {
                        CameraLog.m12954a(TAG, "onPreviewDecisionResult, needCapture");
                        this.mbNeedCapture = false;
                        if (this.mOneCamera != null) {
                            this.mOneCamera.mo13110l().post(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.4
                                @Override // java.lang.Runnable
                                public void run() throws Resources.NotFoundException {
                                    BaseMode.this.capture(false);
                                }
                            });
                        }
                    }
                }
                return;
            }
            CameraLog.m12967f(TAG, "onPreviewDecisionResult, mbInCapturing: " + this.mbInCapturing + ", mbPaused: " + this.mbPaused + ", mbCapModeInit: " + this.mbCapModeInit);
        }
    }

    private void updateAutoHDRUI(CameraApsDecision cameraApsDecision) {
        boolean z;
        boolean z2;
        this.mbHDRAvoidedByAIS = false;
        if (isAutoHDR() && cameraApsDecision != null && !this.mbBurstShot) {
            int OplusGLSurfaceView_13 = cameraApsDecision.mApsDecisionSceneMode;
            boolean z3 = this.mbAutoHDR;
            if (1 == OplusGLSurfaceView_13 || 11 == OplusGLSurfaceView_13 || 14 == OplusGLSurfaceView_13 || 23 == OplusGLSurfaceView_13 || 1 == cameraApsDecision.mApsDecisionShowHdrIcon) {
                this.mbAutoHDR = true;
                synchronized (this.mApsDecisionResultLock) {
                    if (this.mDecisionResult.mAISState > 0 && !isOpenHDR()) {
                        this.mbHDRAvoidedByAIS = true;
                        this.mbAutoHDR = false;
                    }
                }
                if (InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
                    this.mbAutoHDR = false;
                }
                if (this.mCameraUIInterface.mo18131aU()) {
                    this.mbAutoHDR = false;
                }
                if (isOpenHDR() || this.mbShowPostCaptureAlert || z3 == (z = this.mbAutoHDR)) {
                    return;
                }
                displayAllIcon(z, this.mbAutoFlash);
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

    private void updateAutoSeNightUI(CameraApsDecision cameraApsDecision) {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SE_NIGHT_SUPPORT) || 2 == this.mCameraInterface.mo10570g()) {
            return;
        }
        if (!this.mbBurstShot && cameraApsDecision != null && ((35 == cameraApsDecision.mApsDecisionFeatureType || 40 == cameraApsDecision.mApsDecisionFeatureType) && 12 != this.mCameraInterface.mo10576j())) {
            this.mbAutoSeNight = true;
            if (this.mCameraUIInterface.mo18158av()) {
                return;
            }
            this.mCameraUIInterface.mo18071a(R.string.camera_ai_scn_night, -1, false, false, false, R.drawable.se_night_hint_icon);
            return;
        }
        this.mbAutoSeNight = false;
        if (this.mActivity == null || !this.mCameraUIInterface.mo18237l().equals(this.mActivity.getString(R.string.camera_ai_scn_night))) {
            return;
        }
        this.mCameraUIInterface.mo18067a(R.string.camera_ai_scn_night);
    }

    public CameraRequestTag getCaptureRequestTag(CameraApsDecision cameraApsDecision, boolean z) {
        CameraRequestTag c2693c = new CameraRequestTag();
        String currFilterType = getCurrFilterType();
        c2693c.f13414i = currFilterType;
        c2693c.f13398a = isSuperTextOpen();
        boolean z2 = true;
        c2693c.f13412g = getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS) && isBlurOpen();
        c2693c.f13409d = getSupportFunction(CameraFunction.FACE_BLUR) ? getSingleBlurAlgoName(currFilterType) : null;
        c2693c.f13413h = isVideoNeonOpen();
        c2693c.f13389R = getBlurIndex();
        c2693c.f13390S = getShowBlurValue();
        boolean z3 = this.mbBurstShot;
        c2693c.f13415j = z3;
        c2693c.f13430y = z3 ? Util.f22996d : getDefaultCaptureNumber();
        if (cameraApsDecision != null) {
            c2693c.f13431z = this.mbBurstShot ? 35 : cameraApsDecision.mRequestFormat;
            c2693c.f13372A = getCameraMode();
            c2693c.f13373B = this.mCameraInterface.mo10547aw();
            if (getSupportFunction(CameraFunction.LONG_EXPOSURE)) {
                c2693c.f13431z = 32;
                c2693c.f13408c = true;
            }
            if (c2693c.f13431z == 32 || c2693c.f13431z == 37 || c2693c.f13431z == 36 || c2693c.f13431z == 34) {
                c2693c.m13007a(CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_RAW);
            } else {
                c2693c.m13007a(CameraRequestTag.PlatformImplementations.kt_3.CAPTURE);
            }
            if (getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
                c2693c.f13374C = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
                c2693c.f13375D = isHDRState();
            }
            c2693c.f13376E = getCameraShutterType();
            c2693c.f13377F = this.mCameraInterface.mo10529ae();
            String strMo10530af = this.mCameraInterface.mo10530af();
            String strMo10531ag = this.mCameraInterface.mo10531ag();
            if (TextUtils.isEmpty(strMo10531ag)) {
                c2693c.f13378G = strMo10530af;
            } else {
                c2693c.f13378G = strMo10531ag;
                c2693c.f13379H = strMo10530af;
            }
            if (getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
                c2693c.f13380I = this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, this.mActivity.getString(R.string.ultra_wide_angle_default_value));
            }
            c2693c.f13381J = this.mOrientation;
            c2693c.f13384M = "on".equals((this.mbFrontCamera || this.mCameraUIInterface.mo18207e()) ? getMirror() : "off");
            c2693c.f13386O = this.mCameraInterface.mo10576j();
            c2693c.f13387P = this.mCameraInterface.mo10580l();
            c2693c.f13388Q = isSuperClearPortraitOpen();
            c2693c.f13391T = this.mbBurstShot ? 1 : getCaptureStreamNum();
            c2693c.f13397Z = getHeicCodecFormat();
            boolean z4 = 4 == cameraApsDecision.mApsDecisionFeatureType || 8 == cameraApsDecision.mApsDecisionFeatureType || 16 == cameraApsDecision.mApsDecisionFeatureType || 24 == cameraApsDecision.mApsDecisionFeatureType || 26 == cameraApsDecision.mApsDecisionFeatureType || 30 == cameraApsDecision.mApsDecisionFeatureType || 34 == cameraApsDecision.mApsDecisionFeatureType || 27 == cameraApsDecision.mApsDecisionFeatureType || 28 == cameraApsDecision.mApsDecisionFeatureType || 32 == cameraApsDecision.mApsDecisionFeatureType || 36 == cameraApsDecision.mApsDecisionFeatureType || 37 == cameraApsDecision.mApsDecisionFeatureType || 27 == cameraApsDecision.mApsDecisionSceneMode || 28 == cameraApsDecision.mApsDecisionSceneMode;
            boolean z5 = 12 == cameraApsDecision.mApsDecisionSceneMode || 13 == cameraApsDecision.mApsDecisionSceneMode || 30 == cameraApsDecision.mApsDecisionSceneMode;
            if ((z4 && !disableBokehHDR(cameraApsDecision) && !this.mbBurstShot) || ((isInNightProcess() && !this.mbBurstShot) || ((getSupportFunction(CameraUIInterface.KEY_SUPPORT_BOKEH_HDR) && z5) || 13 == cameraApsDecision.mApsDecisionSceneMode || 26 == cameraApsDecision.mApsDecisionSceneMode))) {
                c2693c.f13383L = cameraApsDecision.mCaptureEVList;
            }
            synchronized (this.mApsDecisionResultLock) {
                c2693c.f13382K = this.mbBurstShot ? null : cameraApsDecision.mApsAlgoFlag;
            }
            c2693c.f13385N = this.mbBurstShot ? null : cameraApsDecision;
            if ((isApsDecisionAlgoOpen(CameraUnitKeys.ALGO_NAME_PF_V3) || isApsDecisionAlgoOpen(CameraUnitKeys.ALGO_NAME_PF_V1)) && getSupportFunction(CameraUIInterface.KEY_PI_AI)) {
                c2693c.f13407b = false;
            } else {
                c2693c.f13407b = isFaceBeautyOpen();
            }
            if (isMakeupOpen()) {
                int currMakeupIndex = getCurrMakeupIndex();
                c2693c.f13410e = getMakeupType(currMakeupIndex);
                c2693c.f13411f = getMakeupItemValue(currMakeupIndex);
            } else {
                c2693c.f13410e = "none";
                c2693c.f13411f = 0;
            }
            this.mOneCamera.mo13044a(c2693c.f13410e, c2693c.f13411f);
            if (!this.mbBurstShot) {
                c2693c.f13392U = cameraApsDecision.mSupportCaptureZoomFeature;
                c2693c.f13395X = cameraApsDecision.mApsDecisionFeatureType;
                c2693c.f13393V = cameraApsDecision.mApsBracketMode;
                c2693c.f13394W = cameraApsDecision.mAsdSceneValue;
            }
            if (this.mbBurstShot || (!isInNightProcess() && getNightStateDecision() <= 0)) {
                z2 = false;
            }
            c2693c.f13396Y = z2;
            c2693c.f13399aa = z;
            return c2693c;
        }
        CameraLog.m12967f(TAG, "ops, decisionResult is null");
        return c2693c;
    }

    public boolean isMirrorEnable() {
        return this.mbFrontCamera && !isMultiVideoMode();
    }

    public void onThumbnailUpdated(ThumbnailItem thumbnailItem) {
        if (thumbnailItem == null || thumbnailItem.mOriginBitmap == null || thumbnailItem.mOriginBitmap.isRecycled()) {
            return;
        }
        thumbnailItem.mOriginBitmap.recycle();
        thumbnailItem.mOriginBitmap = null;
    }

    public void setCapturePreviewDataStateIdle() {
        setCapturePreviewDataState(0);
    }

    public void setCachePreviewStart(boolean z) {
        this.mCameraUIInterface.mo18251o(z);
    }

    protected void setCapturePreviewDataState(int OplusGLSurfaceView_13) {
        synchronized (this.mCapturePreviewDataStateLock) {
            CameraLog.m12954a(TAG, "setCapturePreviewDataState: " + this.mCapturePreviewDataState + " -> " + OplusGLSurfaceView_13);
            this.mCapturePreviewDataState = OplusGLSurfaceView_13;
        }
    }

    private int getCapturePreviewDataState() {
        int OplusGLSurfaceView_13;
        synchronized (this.mCapturePreviewDataStateLock) {
            OplusGLSurfaceView_13 = this.mCapturePreviewDataState;
        }
        return OplusGLSurfaceView_13;
    }

    protected void setCaptureRequestPictureSizeScale() {
        if (this.mOneCamera != null) {
            if (isApsDecisionAlgoOpen(CameraUnitKeys.ALGO_NAME_SUPERPHOTO) && !this.mbBurstShot) {
                this.mOneCamera.mo13095g(1);
            } else {
                this.mOneCamera.mo13095g(0);
            }
        }
    }

    protected boolean isApsDecisionAlgoOpen(String str) {
        synchronized (this.mApsDecisionResultLock) {
            if (this.mDecisionResult != null && this.mDecisionResult.mApsAlgoFlag != null) {
                for (String str2 : this.mDecisionResult.mApsAlgoFlag) {
                    if (TextUtils.equals(str, str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    protected boolean isSupportNoneSat() {
        return Util.m24394b(getCameraMode(), this.mbFrontCamera);
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long OplusGLSurfaceView_15, long j2) {
        int OplusGLSurfaceView_13;
        int i2;
        boolean z;
        boolean z2;
        CameraScreenNail c3445h;
        boolean z3;
        int i3;
        CameraLog.m12955a("captureX onCaptureStarted frameNumber: " + j2 + ", timestamp: " + OplusGLSurfaceView_15, "08ct_CaptureStarted TS", OplusGLSurfaceView_15);
        final boolean z4 = this.mCaptureStartedCallbackNum == 0;
        this.mCaptureStartedCallbackNum++;
        boolean z5 = (this.mbBurstShot ? Util.f22996d : getDefaultCaptureNumber()) == this.mCaptureStartedCallbackNum;
        CameraRequestTag c2693c = this.mCaptureRequestTag;
        boolean z6 = c2693c != null && c2693c.f13399aa;
        final boolean z7 = this.mbBurstShot;
        boolean z8 = getCapturePreviewDataState() == 1;
        CameraLog.m12959b(TAG, "onCaptureStarted, burstShot: " + z7 + ", timestamp: " + OplusGLSurfaceView_15 + ", firstFrame: " + z4 + ", capturePreviewStart: " + z8 + ", watchRequest: " + z6);
        if (z4) {
            this.mCaptureMergeIdentity = OplusGLSurfaceView_15;
            if (this.mCameraInterface != null && !z8 && needStoreImage()) {
                this.mCameraInterface.mo10478a(this.mCaptureMergeIdentity, this.mThumbnailTitle, getSupportFunction(CameraUIInterface.KEY_SUPPORT_UPDATE_THUMBNAIL_USER_PICTURE), z6, z7);
            }
            ComprehensivePerformance.m15115a(OplusGLSurfaceView_15, this.mCameraId, getCameraMode());
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BaseMode.this.mbPaused || BaseMode.this.mCameraUIInterface == null) {
                            return;
                        }
                        BaseMode.this.mCameraUIInterface.mo18249o();
                    }
                });
            }
        }
        if (this.mActivity != null && getNeedCheckTimeStamp()) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.6
                @Override // java.lang.Runnable
                public void run() {
                    BaseMode.this.shutterCallback(z7, z4);
                }
            });
        }
        synchronized (this.mApsDecisionResultLock) {
            OplusGLSurfaceView_13 = this.mDecisionResult != null ? this.mDecisionResult.mThumbnailIndex : 1;
            int i4 = this.mDecisionResult != null ? this.mDecisionResult.mApsDecisionFeatureType : 0;
            i2 = this.mDecisionResult != null ? this.mDecisionResult.mApsDecisionSceneMode : 0;
            boolean z9 = 5 == i4 || 38 == i4;
            boolean z10 = 4 == i4 || 8 == i4 || 16 == i4;
            boolean z11 = 12 == i2 || 13 == i2 || 30 == i2;
            z = z9 || isCaptureInDarkLight(i4) || z10;
            z2 = z10 || z11;
        }
        CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null) {
            CameraScreenNail c3445hMo18183c = cameraUIInterface.mo18183c();
            if (OplusGLSurfaceView_13 == this.mCaptureStartedCallbackNum && z8 && c3445hMo18183c != null) {
                c3445h = c3445hMo18183c;
                z3 = z5;
                i3 = i2;
                c3445hMo18183c.m14224a(j2, this.mCaptureMergeIdentity, OplusGLSurfaceView_15, getSupportQuickJpeg(this.mOneCamera.mo13140v()), z);
            } else {
                c3445h = c3445hMo18183c;
                z3 = z5;
                i3 = i2;
            }
            if (getSupportQuickJpeg(this.mOneCamera.mo13140v()) && c3445h != null) {
                c3445h.m14223a(j2, OplusGLSurfaceView_15);
            }
            if (!this.mbFrontCamera && z2 && ((!Util.m24169C() || 30 != i3) && c3445h != null)) {
                c3445h.m14239b(j2, OplusGLSurfaceView_15);
            }
            if (z3) {
                this.mCameraUIInterface.mo18251o(false);
            }
        }
        CameraLog.m12964d("captureX onCaptureStarted frameNumber: " + j2, "08ct_CaptureStarted TS");
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureProgressed(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        if (cameraCaptureResult == null || cameraCaptureResult.getCaptureResult() == null) {
            return;
        }
        CameraLog.m12955a("captureX onCaptureProgressed frameNumber: " + cameraCaptureResult.getCaptureResult().getFrameNumber(), "10ct_CaptureProgressed", CameraConstant.f13119d.longValue());
        if (getSupportQuickJpeg(c2693c) && Util.m24169C()) {
            try {
                Long OplusGLSurfaceView_14 = (Long) cameraCaptureResult.getCaptureResult().get(CameraMetadataKey.f13356m);
                CameraLog.m12962c(TAG, "onCaptureProgressed, refTimestamp: " + OplusGLSurfaceView_14);
                if (OplusGLSurfaceView_14 != null && OplusGLSurfaceView_14.longValue() > 0) {
                    this.mCameraUIInterface.mo18251o(false);
                    this.mCameraUIInterface.mo18075a(CameraScreenNail.f14187b.intValue(), this.mCaptureMergeIdentity, OplusGLSurfaceView_14.longValue());
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12967f(TAG, "onCaptureProgressed, error msg: " + COUIBaseListPopupWindow_8.getMessage());
            }
        }
        CameraLog.m12964d("captureX onCaptureProgressed frameNumber: " + cameraCaptureResult.getCaptureResult().getFrameNumber(), "10ct_CaptureProgressed");
    }

    protected boolean isHasSuperTextDetectResult() {
        DetectResult c3077a = this.mDetectResult;
        return c3077a != null && c3077a.m17956c();
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        Object objM13005a;
        CameraLog.m12952a("captureX onCaptureCompleted");
        if (c2693c == null || this.mbDestroyed) {
            CameraLog.m12962c(TAG, "onApsCaptureCompleted, tag:" + c2693c);
            return;
        }
        this.mbCaptureNotMatchMeta = false;
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null && !interfaceC2646a.mo10512aN() && isNeedAPSProcess() && isSatOpen() && AlgoSwitchConfig.getApsVersion() <= 2 && (objM13005a = CameraMetadataKey.m13005a(cameraCaptureResult.getCaptureResult(), CameraMetadataKey.f13303ap)) != null && (objM13005a instanceof Integer)) {
            int iIntValue = ((Integer) objM13005a).intValue();
            synchronized (this.mApsDecisionResultLock) {
                if (iIntValue > 0) {
                    this.mSensorNumber = iIntValue;
                } else {
                    this.mSensorNumber = 1;
                }
            }
        }
        CameraLog.m12958b("captureX onCaptureCompleted");
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCapturePrepared() {
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            interfaceC2646a.mo10521aW();
        }
    }

    protected String getSingleBlurAlgoName(String str) {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SINGLE_PORTRAIT_SUPPORT) ? CameraUnitKeys.ALGO_NAME_SINGLE_PORTRAIT : CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT) ? CameraUnitKeys.ALGO_NAME_SINGLE_BOKEH : "portrait_retention".equals(str) ? CameraUnitKeys.ALGO_NAME_SINGLE_AICOLOR : CameraUnitKeys.ALGO_NAME_SINGLE_BLUR;
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCanceled(CameraRequestTag c2693c) {
        CameraLog.m12967f(TAG, "onCaptureCanceled, requestTag: " + c2693c);
        this.mbCaptureNotMatchMeta = false;
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            interfaceC2646a.mo10477a(this.mCaptureMergeIdentity, 0, 0);
        }
        onPictureCallback(null, 0, 0, getImageFormat(), false, 0);
    }

    @Override // com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c) {
        CameraLog.m12967f(TAG, "onCaptureFailed, mCaptureMergeIdentity: " + this.mCaptureMergeIdentity);
        this.mbCaptureNotMatchMeta = false;
        if (this.mCameraInterface != null && c2693c != null) {
            if (c2693c.f13415j) {
                this.mCameraInterface.mo10477a(this.mCaptureMergeIdentity, c2693c.f13391T, c2693c.f13391T);
            } else {
                int OplusGLSurfaceView_13 = CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_RAW == c2693c.m13006a() || CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_REPROCESS == c2693c.m13006a() ? 1 : c2693c.f13391T;
                this.mCameraInterface.mo10477a(this.mCaptureMergeIdentity, OplusGLSurfaceView_13, c2693c.f13430y * OplusGLSurfaceView_13);
            }
        }
        CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null && cameraUIInterface.mo18183c() != null) {
            this.mCameraUIInterface.mo18183c().m14222a(this.mCaptureMergeIdentity);
        }
        onPictureCallback(null, 0, 0, getImageFormat(), false, 0);
    }

    public boolean getSupportMenu(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_SETTING.equals(strM13305d)) {
            CameraInterface interfaceC2646a = this.mCameraInterface;
            return (interfaceC2646a != null && interfaceC2646a.mo10583m()) || !isSubMenuEnable();
        }
        if (CameraUIInterface.KEY_TORCH_MODE.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(strM13305d) || CameraUIInterface.KEY_PORTRAIT_BLUR_MENU.equals(strM13305d) || CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(strM13305d) || CameraUIInterface.KEY_NIGHT_TRIPOD_MODE.equals(strM13305d) || CameraUIInterface.KEY_NIGHT_STARBURST_MODE.equals(strM13305d)) {
            return getSupportFunction(strM13305d);
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strM13305d)) {
        }
        return false;
    }

    public boolean needUploadOplusStatistics(String str) {
        if (CameraUIInterface.KEY_ZOOM.equals(str)) {
            return getSupportFunction(str) || this.mbBurstShot;
        }
        return getSupportFunction(str);
    }

    public void checkoutTimerSnapShotState() {
        MainShutterButtonInfo c3200b = Util.m24352ao() ? new MainShutterButtonInfo(24, "button_color_inside_none", "button_shape_countdown_cancel") : new MainShutterButtonInfo(10, "button_color_inside_none");
        c3200b.m19230b(0);
        this.mCameraUIInterface.mo18091a(c3200b);
    }

    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo(Util.m24352ao() ? 23 : 11, "button_color_inside_none");
        c3200b.m19230b(0);
        this.mCameraUIInterface.mo18091a(c3200b);
    }

    public boolean getScreenTorchModeState() {
        String string = this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity));
        return (string.equals("on") || string.equals("auto")) && this.mbFrontCamera && !getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT) && getSupportFunction(CameraUIInterface.KEY_TORCH_MODE);
    }

    public boolean isHeifEnable() {
        return getSupportFunction(CameraUIInterface.KEY_HEIF_SUPPORT) && !this.mbFrontCamera && is10bitsHeicEncodeEnable();
    }

    public boolean isSupportShowFilterMenu() {
        return getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0224  */
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
        return getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS) && FilterHelper.f21279a != getCurrFilterIndex();
    }

    protected boolean isAutoMacroOpen() {
        if (getSupportFunction(CameraUIInterface.KEY_MACRO_SWITCH)) {
            return "auto".equals(this.mPreferences.getString(CameraUIInterface.KEY_MACRO_SWITCH, "auto"));
        }
        return false;
    }

    public boolean isFilterOpen(String str) {
        return !"default".equals(str);
    }

    public boolean getIsShowPostCaptureAlert() {
        return this.mbShowPostCaptureAlert;
    }

    public int getNightStateDecision() {
        int OplusGLSurfaceView_13;
        synchronized (this.mApsDecisionResultLock) {
            int i2 = this.mDecisionResult != null ? this.mDecisionResult.mApsDecisionFeatureType : 0;
            OplusGLSurfaceView_13 = (i2 == 9 || i2 == 10 || i2 == 11 || i2 == 13 || i2 == 29 || i2 == 14 || i2 == 21 || i2 == 31 || i2 == 32 || i2 == 35 || i2 == 40 || i2 == 41) ? this.mDecisionResult.mSuperNightScene : 0;
        }
        return OplusGLSurfaceView_13;
    }

    public boolean isTripodNight() {
        boolean z;
        synchronized (this.mApsDecisionResultLock) {
            z = true;
            if (this.mDecisionResult == null || this.mDecisionResult.mApsAlgoFlag == null || !CameraUnitKeys.ALGO_NAME_SUPERNIGHT.equals(this.mDecisionResult.mApsAlgoFlag[0]) || this.mDecisionResult.mSuperNightScene != 1) {
                z = false;
            }
        }
        return z;
    }

    public void showLowMemory() {
        this.mCameraUIInterface.mo18070a(R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
    }

    public void beforeSwitchCamera() {
        if (this.mCameraUIInterface.mo18059T() && canCloseSubMenuWhenSwitchCamera()) {
            this.mCameraUIInterface.mo18060U();
        }
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22819c(2);
        }
        if (this.mbFrontCamera) {
            this.mCameraUIInterface.mo18067a(R.string.camera_bokeh_move_farther_away);
        }
        this.mCameraUIInterface.mo18067a(R.string.camera_pi_ai_scenes_on_hint);
        this.mCameraUIInterface.mo18067a(R.string.camera_pi_ai_scenes_off_hint);
        this.mCameraUIInterface.mo18067a(R.string.camera_bokeh_need_more_light);
        this.mCameraUIInterface.mo18067a(R.string.camera_ai_scn_night);
        this.mCameraUIInterface.mo18108a(true, true, false);
        this.mCameraUIInterface.mo18174b(false);
        this.mbShowEnvironmentTips = false;
    }

    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        this.mApsDecisionFeatureType = 0;
        this.mApsBracketMode = 0;
        this.mAsdSceneValue = 0;
        this.mbShowPostCaptureAlert = false;
        this.mPostCounter = 0;
        this.mCameraId = OplusGLSurfaceView_13;
        this.mbFrontCamera = CameraCharacteristicsUtil.m12974a(this.mCameraId);
    }

    public final void resume(boolean z) {
        this.mbShowPostCaptureAlert = false;
        this.mbPaused = false;
        sbFrontDirtyLensToastShown = false;
        sbRearDirtyLensToastShown = false;
        this.mbDestroyed = false;
        setForceMode();
        onResume(z);
        if (getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            setHDRMenuVisibility(true);
        } else {
            setHDRMenuVisibility(false);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_EXPLORER_SUPPORT) && this.mPreferences.getInt(CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1) == 0) {
            this.mCameraUIInterface.mo18074a(R.string.explorer_chip_damage_tip, 2000, new Object[0]);
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
        CameraLog.m12954a(TAG, "pause, mbInCapturing: " + this.mbInCapturing);
        onPause();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (isOpenHDR()) {
            updateMenuWithHDRChange(false);
        }
        this.mCameraUIInterface.mo18108a(true, true, true);
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE)) {
            this.mCameraUIInterface.mo18210f(8, true);
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
        CameraLog.m12954a(TAG, "destroy");
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

    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        Integer num;
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f(TAG, "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        if (this.mStatePreferenceHelper == null) {
            this.mStatePreferenceHelper = new VisualizationStatePreferenceHelper(this.mActivity);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_EXPLORER_SUPPORT)) {
            checkExplorerChipState(cameraPreviewResult.getCaptureResult());
        }
        if (this.algoVisualViewManager != null && this.mStatePreferenceHelper.m11639b()) {
            this.algoVisualViewManager.m11613d();
            if (this.algoVisualViewManager != null && this.mStatePreferenceHelper.m11637a()) {
                this.algoVisualViewManager.m11610a(cameraPreviewResult, this.mFullAlgoKey, this.mFullAlgoValue, this.mCapAlgoListFromApp, this.mPreAlgoListFromApp, getCameraMode(), this.mCameraId);
            }
        }
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (!getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT)) {
            Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
            Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_MODE);
            if (num2 != null && !this.mbBurstShot) {
                boolean z = this.mbAutoFlash;
                if (this.mCameraInterface.mo10596z()) {
                    setAutoFlash(false);
                } else if (!this.mbInCapturing) {
                    if (isAutoFrontTorch() && InverseManager.INS.isInverseAble(this.mActivity)) {
                        setAutoFlash(InverseManager.INS.isInverseColor(this.mActivity.hashCode()));
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
                if (this.mbAutoFlash != z) {
                    if (isOpenFlash() || isOpenFrontTorch() || this.mbShowPostCaptureAlert) {
                        return;
                    } else {
                        displayAllIcon(this.mbAutoHDR, this.mbAutoFlash);
                    }
                }
            }
        }
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22844j(isAiEnhancementVideoOpen());
            Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13252R);
            if (objM13005a != null && (objM13005a instanceof Integer)) {
                this.mPreviewEffectProcess.mo22840i(isVideoModeType() ? ((Integer) objM13005a).intValue() : 0);
            }
        }
        Object objM13005a2 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13251Q);
        if (objM13005a2 != null && (objM13005a2 instanceof Integer)) {
            Integer num4 = (Integer) objM13005a2;
            if (103 == num4.intValue()) {
                this.mbAutoBinning = true;
            } else if (104 == num4.intValue()) {
                this.mbAutoBinning = false;
            }
        }
        Object objM13005a3 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13253S);
        if (objM13005a3 != null && (objM13005a3 instanceof Integer)) {
            Integer num5 = (Integer) objM13005a3;
            if (1002 == num5.intValue() || 1003 == num5.intValue()) {
                int OplusGLSurfaceView_13 = this.mPostCounter;
                if (OplusGLSurfaceView_13 > 0) {
                    this.mPostCounter = OplusGLSurfaceView_13 - 1;
                }
                if (this.mCameraUIInterface.mo18265s() == 4 && (getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE) || getSupportFunction(CameraUIInterface.KEY_AUTO_NIGHT_SCENCE))) {
                    this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), getSupportFunction(CameraUIInterface.KEY_BURST_SHOT));
                }
                onCancelTakePicture();
            }
        }
        Object objM13005a4 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13259Y);
        if (InverseManager.INS.isInverseAble(this.mActivity) && getSupportFunction(CameraUIInterface.KEY_TORCH_MODE) && "off".equals(this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity)))) {
            if (Util.m24203a(captureResult) > InverseManager.INS.getThreshold()) {
                updateDimHintView(true);
            } else if (Util.m24203a(captureResult) < InverseManager.INS.getThresholdRecover()) {
                updateDimHintView(false);
            }
        } else if (objM13005a4 != null && (objM13005a4 instanceof int[])) {
            this.mFlashTrigger = ((int[]) objM13005a4)[0];
            updateDimHintView(this.mFlashTrigger == 1);
        }
        Object objM13005a5 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13309av);
        if (objM13005a5 instanceof Integer) {
            this.mPreviweStreamNeedState = (Integer) objM13005a5;
        }
        if (shouldShowDirtyToast(cameraPreviewResult)) {
            showDirtyLensHintView();
        }
        Integer num6 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
        if (num6 != null) {
            this.mEVValueFromMetadata = num6.intValue();
        }
        Object objM13005a6 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13329bj);
        if (this.mFocusOutOfRange != objM13005a6) {
            this.mFocusOutOfRange = objM13005a6;
            if (this.mCameraUIInterface != null && getSupportFunction(CameraUIInterface.KEY_SUPOORT_FOCUS_OUT_OF_RANGE) && objM13005a6 != null && (objM13005a6 instanceof Integer)) {
                if (1 == ((Integer) objM13005a6).intValue() && !this.mCameraUIInterface.mo18059T() && !this.mbInCapturing && !this.mCameraUIInterface.mo18131aU()) {
                    this.mCameraUIInterface.mo18070a(R.string.camera_bokeh_move_farther_away, -1, false, false, true);
                } else {
                    this.mCameraUIInterface.mo18067a(R.string.camera_bokeh_move_farther_away);
                }
            }
        }
        CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null && cameraUIInterface.mo18131aU()) {
            this.mCameraUIInterface.mo18067a(R.string.camera_bokeh_move_farther_away);
        }
        if ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MAINCAMERA_ASD_AISCENE_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_WIDECAMERA_ASD_AISCENE_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SATCAMERA_ASD_AISCENE_SUPPORT) && !needUpdateAsdSceneValue()) || (num = (Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_AI_SCENE)) == null || this.mAsdSceneValue == num.intValue()) {
            return;
        }
        this.mAsdSceneValue = num.intValue();
        updateAsdSceneValue(true, this.mAsdSceneValue);
    }

    private boolean shouldShowDirtyToast(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        Object objM13005a;
        if ((2 != AlgoSwitchConfig.getApsVersion() ? !(cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_LENS_DIRTY) == null || 1 != ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_LENS_DIRTY)).intValue()) : (objM13005a = CameraMetadataKey.m13005a(cameraPreviewResult.getCaptureResult(), CameraMetadataKey.f13302ao)) != null && (objM13005a instanceof Integer) && ((Integer) objM13005a).intValue() == 1) && getSupportFunction(CameraUIInterface.KEY_LENS_DIRTY_DETECTION) && isLensDirtyDetectionOpen() && isZoomDirtyDetectionSupported(getZoomValue())) {
            return (this.mbFrontCamera && !sbFrontDirtyLensToastShown) || !(this.mbFrontCamera || sbRearDirtyLensToastShown);
        }
        return false;
    }

    private boolean isZoomDirtyDetectionSupported(float COUIBaseListPopupWindow_12) {
        if (!getSupportFunction(CameraFunction.SAT_CAMERA)) {
            if (Float.compare(COUIBaseListPopupWindow_12, ZoomManager.f12334a) != 0) {
                return Float.compare(COUIBaseListPopupWindow_12, 1.0f) >= 0 && Float.compare(COUIBaseListPopupWindow_12, 2.0f) <= 0;
            }
            return true;
        }
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE);
        if (configFloatArrayValue == null || 2 != configFloatArrayValue.length) {
            return false;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, ZoomManager.f12334a) == 0) {
            return true;
        }
        if (Float.compare(COUIBaseListPopupWindow_12, 1.0f) >= 0 || Float.compare(COUIBaseListPopupWindow_12, getMinZoomValue()) != 0) {
            return Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[0]) >= 0 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[1]) <= 0 && !getZoomAutoMicroOpen();
        }
        return true;
    }

    public boolean isLensDirtyDetectionOpen() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_LENS_DIRTY_DETECTION, this.mActivity.getString(R.string.lens_dirty_detection_default_value)));
        }
        return false;
    }

    public boolean isGestureOpen() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return getSupportFunction(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, this.mActivity.getString(R.string.camera_gesture_shutter_default_value)));
        }
        return false;
    }

    private void showDirtyLensHintView() {
        if (this.mCameraUIInterface.mo18065Z()) {
            if (this.mbFrontCamera) {
                sbFrontDirtyLensToastShown = true;
            } else {
                sbRearDirtyLensToastShown = true;
            }
        }
    }

    public boolean onBackPressed() {
        if (isPanelMode()) {
            if (this.mCameraUIInterface.mo18159aw()) {
                this.mCameraUIInterface.mo18033F(false);
            } else {
                if (this.mCameraUIInterface.mo18161ay()) {
                    return true;
                }
                this.mCameraUIInterface.mo18189c((String) null, !Util.m24338aa());
            }
            return true;
        }
        resetMonoFilter();
        return false;
    }

    public void setForceMode() {
        String string = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_MODE, Util.m24382b(this.mCameraInterface.mo10583m()));
        CameraLog.m12954a(TAG, "setForceMode, capMode: " + string + ", modeName: " + getCameraMode());
        if (string.equals(getCameraMode())) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_CAMERA_MODE, getCameraMode());
        editorEdit.apply();
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.mOrientation = OplusGLSurfaceView_13;
    }

    public void updateOneCamera(OneCamera interfaceC2694d) {
        this.mOneCamera = interfaceC2694d;
    }

    public final void initCameraMode() {
        CameraLog.m12954a(TAG, "initCameraMode");
        this.mbCapModeInit = false;
        this.mbModePreInit = false;
        if (this.mPreviewEffectProcess.mo22845k() != 0) {
            updateFilterParam(getCurrFilterIndex());
            if (getSupportFunction(CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(getCurrFilterType())) {
                this.mPreviewEffectProcess.mo22820c(true);
            } else {
                this.mPreviewEffectProcess.mo22820c(false);
            }
        }
        this.mbShowPostCaptureAlert = false;
        this.mOrientation = this.mCameraInterface.mo10591u();
        this.mbModePreInit = true;
        this.mbSupportSelectPhotoRatio = isSupportPhotoRatioMenu();
        this.mCameraRootView = this.mCameraUIInterface.mo18163b();
        this.mPreviewEffectProcess.mo22817c();
        onInitCameraMode();
        disableRedDotHintOnModes();
        this.mCameraUIInterface.mo18258q();
        removeSettingMenuOption(FILTER_KEYS);
        updateEffectMenuNames();
        if (isOpenHDR()) {
            updateMenuWithHDRChange(true);
        } else if (isAutoHDR()) {
            updateFlashMenuIfHDRIsAuto(this.mbFrontCamera);
        }
        this.mCameraUIInterface.mo18095a(getPreviewOutlineProvider());
        this.mCameraUIInterface.mo18172b(getCameraMode(), true);
        this.mbCapModeInit = true;
    }

    public final void deInitCameraMode(String str) {
        CameraLog.m12954a(TAG, "deInitCameraMode, targetMode: " + str);
        Handler handler = this.mHandler;
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
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            if (interfaceC2694d.mo13086e().m13251H()) {
                this.mOneCamera.mo13127q(false);
            } else if (isAutoHDR()) {
                this.mOneCamera.mo13079c("off");
            }
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_REGIONS, (CaptureRequest.Key) AEAFHelp.m11154b());
        }
        setAutoFlash(false);
        this.mbAutoHDR = false;
        this.mbAutoBinning = false;
        this.mCameraUIInterface.mo18028D();
        onDeInitCameraMode(str);
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
        }
        this.mPreviewEffectProcess.mo22819c(1);
        this.mbCapModeInit = false;
        this.mApsDecisionFeatureType = 0;
        this.mApsBracketMode = 0;
        this.mAsdSceneValue = 0;
        onGetNearMeOnClickData();
    }

    public final void afterStartPreview(boolean z) {
        if (this.mbCapModeInit) {
            updateTrackEnable();
            onAfterStartPreview(z);
        }
        if (this.mStatePreferenceHelper == null) {
            this.mStatePreferenceHelper = new VisualizationStatePreferenceHelper(this.mActivity);
        }
        if (this.mStatePreferenceHelper.m11639b() && this.mStatePreferenceHelper.m11637a()) {
            if (isSlowVideoMode() || (TextUtils.equals(ApsConstant.CAPTURE_MODE_STICKER, getCameraMode()) && TextUtils.isEmpty(this.mFullAlgoValue) && TextUtils.isEmpty(this.mFullAlgoKey))) {
                if (this.algoVisualViewManager == null) {
                    this.algoVisualViewManager = new AlgoVisualViewManager(this.mActivity, this.mOneCamera);
                    this.algoVisualViewManager.m11607a();
                }
                this.algoVisualViewManager.m11608a(this.mActivity, this.mCameraId);
            }
        }
    }

    public final void beforePreview() throws NumberFormatException {
        OneCamera interfaceC2694d;
        CameraLog.m12967f(TAG, "onBeforePreview, capMode: " + getCameraMode() + ", mCurrentMode: " + this);
        OneCamera interfaceC2694d2 = this.mOneCamera;
        if (interfaceC2694d2 != null) {
            interfaceC2694d2.mo13148x(true);
            this.mOneCamera.mo13117n(0);
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
            this.mOneCamera.mo13154z(isSalientObjectDetectionEnabled());
            this.mOneCamera.mo13142v(false);
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.IS_FROM_MAIN_MENU, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(isFromMainMenuApp()));
            if (!TextUtils.isEmpty(this.mCameraInterface.mo10505aG())) {
                this.mOneCamera.mo13057a(this.mCameraInterface.mo10505aG().getBytes());
            }
            if (!Util.m24169C()) {
                if (isSlowVideoMode()) {
                    this.mOneCamera.mo13053a(true, getVideoSizeType());
                } else {
                    this.mOneCamera.mo13053a(false, (String) null);
                }
            }
            if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_ZSL) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_REQUEST_ZSL_MODE) && (Build.VERSION.SDK_INT <= 30 || !Util.m24169C())) {
                this.mOneCamera.mo13115m(getZSLMode());
            }
            this.mOneCamera.mo13093f(this.mCameraUIInterface.mo18207e());
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
        if (Util.m24169C()) {
            updateBracketMode(false, this.mApsBracketMode);
        } else {
            this.mbEnableTuningData = true;
        }
        if (isNoneSatUltraWideAngleOpen() && isOpenFlash() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CAPTURE_FLASH_ONLY_MAIN_ZOOM)) {
            if (getSupportFunction(CameraUIInterface.KEY_FLASH_MODE)) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_FLASH_MODE, "off").apply();
            }
            if (getSupportFunction(CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").apply();
            }
        }
        if (is10bitsHeicEncodeEnable()) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_PHOTO_CODEC, "HEIF").apply();
        } else {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_PHOTO_CODEC, this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "JPEG")).apply();
        }
        String flashMode = getFlashMode();
        OneCamera interfaceC2694d3 = this.mOneCamera;
        if (interfaceC2694d3 != null) {
            interfaceC2694d3.mo13069b(flashMode);
        }
        if (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE) && "auto".equals(flashMode) && InverseManager.INS.isInverseAble(this.mActivity) && (interfaceC2694d = this.mOneCamera) != null) {
            interfaceC2694d.mo13080c(true);
        } else {
            this.mOneCamera.mo13080c(false);
        }
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22853n(false);
            this.mPreviewEffectProcess.mo22823d(1.0f);
        }
        onBeforePreview();
        setLSDEnable();
        PreviewEffectProcess interfaceC3423t2 = this.mPreviewEffectProcess;
        if (interfaceC3423t2 != null) {
            interfaceC3423t2.mo22825d(needSetMakeupToAlgo());
            if (isMakeupOpen()) {
                int currMakeupIndex = getCurrMakeupIndex();
                this.mPreviewEffectProcess.mo22812b(getMakeupType(currMakeupIndex));
                this.mPreviewEffectProcess.mo22837h(getMakeupItemValue(currMakeupIndex));
                OneCamera interfaceC2694d4 = this.mOneCamera;
                if (interfaceC2694d4 != null) {
                    interfaceC2694d4.mo13044a(getMakeupType(currMakeupIndex), getMakeupItemValue(currMakeupIndex));
                }
            } else {
                this.mPreviewEffectProcess.mo22812b("none");
            }
            this.mPreviewEffectProcess.mo22830f(getFaceBeautyModeIndex());
        }
        if (this.mPreferences != null && getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            updateHDRMode(this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId)), false);
        }
        setAutoFlash(false);
        this.mbAutoHDR = false;
        this.mbAutoBinning = false;
        updateMirrorParam();
        setCapturePreviewDataState(0);
        OneCamera interfaceC2694d5 = this.mOneCamera;
        if (interfaceC2694d5 != null) {
            if (interfaceC2694d5.mo13086e() != null && this.mOneCamera.mo13086e().m13250G()) {
                this.mOneCamera.mo13124p(getSupportFunction(CameraFunction.REQUEST_FAST_LAUNCH) && this.mCameraInterface.mo10502aD());
            }
            if (isVideoHdrOpen()) {
                this.mOneCamera.mo13102i(AEAFHelp.PlatformImplementations.kt_3.FrameAverage.ordinal());
            } else {
                this.mOneCamera.mo13102i(AEAFHelp.PlatformImplementations.kt_3.CenterWeighted.ordinal());
            }
            if (!Util.m24169C()) {
                byte[] bArr = OneCamera.f13432g;
                if (this.mbEnableTuningData) {
                    bArr = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT) ? OneCamera.f13434i : OneCamera.f13433h;
                }
                this.mOneCamera.mo13072b(bArr);
            }
            this.mOneCamera.mo13092f(DateTimeFormatter.ofPattern("XXX").format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault())));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.FACE_RECTIFY_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(isFaceRectifyOpen()));
            if (getSupportFunction(CameraUIInterface.KEY_PORTRAIT_HALF_BODY) && !Util.m24169C()) {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(1.0f));
            } else if (CameraCharacteristicsUtil.m12982e() && this.mbFrontCamera) {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(1.0f));
            } else {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(this.mCameraInterface.mo10535ak()));
            }
            if (getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL) && this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off").equals("super_raw")) {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "super_raw");
            } else {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "none");
            }
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.SUPER_CLEAR_PORTRAIT_ENABLE, (CameraParameter.PreviewKey<String>) (isSuperClearPortraitOpen() ? "on" : "off"));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.TRIPOD_MODE_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(getSupportFunction(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE) && this.mPreferences.getString(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, "off").equals("on")));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.STARBURST_MODE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(getSupportFunction(CameraUIInterface.KEY_NIGHT_STARBURST_MODE) && this.mPreferences.getString(CameraUIInterface.KEY_NIGHT_STARBURST_MODE, "off").equals("on")));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.ULTRA_HIGH_RESOLUTION_ENABLE, (CameraParameter.PreviewKey<String>) (isUltraHighResolutionOpened() ? "on" : "off"));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.STAR_VIDEO_ENABLE, (CameraParameter.PreviewKey<String>) (isStarVideoOpen() ? "on" : "off"));
            String currFilterType = getCurrFilterType();
            if (currFilterType != null) {
                this.mOneCamera.mo13046a(currFilterType, isFilterOpen(currFilterType), getSupportFunction(CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(currFilterType));
            }
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FACE_BEAUTY_ENABLE, (CameraParameter.PreviewKey<String>) (isFaceBeautyOpen() ? "on" : "off"));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.PORTRAIT_NEON_ENABLE, (CameraParameter.PreviewKey<String>) (isNeonEnable() ? "on" : "off"));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.AI_PHOTO, (CameraParameter.PreviewKey<String>) (isPIModeOpen() ? "on" : "off"));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_RETENTION_OPEN, (CameraParameter.PreviewKey<String>) (getSupportFunction(CameraFunction.VIDEO_RETENTION) && isVideoRetentionOpen() ? "on" : "off"));
            if (!isAutoMacroOpen() || isTiltShiftOpen()) {
                this.mOneCamera.mo13012B(false);
            }
        }
    }

    private boolean isSupportPhotoRatioMenu() {
        return (getSupportMenu(CameraUIInterface.KEY_PHOTO_RATIO) && getCanAddMenuOption(CameraUIInterface.KEY_PHOTO_RATIO)) || getSupportSubMenu(CameraUIInterface.KEY_PHOTO_RATIO);
    }

    private boolean isFromMainMenuApp() {
        return 1 == this.mCameraEntry.m13317J();
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
        return getSupportFunction(CameraUIInterface.KEY_SUPPORT_MAKEUP);
    }

    protected void updateDimHintView(boolean z) {
        this.mCameraUIInterface.mo18022A(z);
    }

    public void updateTrackEnable() {
        SharedPreferences sharedPreferences;
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT) || this.mOneCamera == null) {
            return;
        }
        boolean z = getSupportFunction(CameraUIInterface.KEY_TRACK_FOCUS) && (sharedPreferences = this.mPreferences) != null && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_TRACK_FOCUS, this.mActivity.getString(R.string.camera_face_rectify_default_value)));
        boolean z2 = z != this.mbTrackFocusOpen;
        this.mbTrackFocusOpen = z;
        this.mOneCamera.mo13010A(this.mbTrackFocusOpen);
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            if (this.mbTrackFocusOpen) {
                interfaceC2646a.mo10481a(getTrackHalAlgoSize());
            } else {
                interfaceC2646a.mo10581l(false);
            }
            if (z2) {
                this.mCameraInterface.mo10582m(this.mbTrackFocusOpen);
            }
        }
    }

    protected void updateBlurValue() {
        PreviewEffectProcess interfaceC3423t;
        if (getSupportFunction(CameraFunction.BOKEH)) {
            OneCamera interfaceC2694d = this.mOneCamera;
            if (interfaceC2694d != null) {
                interfaceC2694d.mo13021a(getBlurValue());
                return;
            }
            return;
        }
        if (!getSupportFunction(CameraFunction.FACE_BLUR) || (interfaceC3423t = this.mPreviewEffectProcess) == null) {
            return;
        }
        interfaceC3423t.mo22777a(getBlurValue());
    }

    public void onAfterStartPreview(boolean z) {
        Activity activity;
        setAllowSwitchMode(true);
        this.mbSupportSelectPhotoRatio = isSupportPhotoRatioMenu();
        this.mHandler.removeMessages(3);
        this.mHandler.sendEmptyMessage(3);
        if (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
            this.mCameraUIInterface.mo18100a(CameraUIInterface.KEY_TORCH_MODE, "on", this.mActivity.getString(R.string.camera_torch_mode_torch));
        }
        if (this.mStatePreferenceHelper == null && (activity = this.mActivity) != null) {
            this.mStatePreferenceHelper = new VisualizationStatePreferenceHelper(activity);
        }
        VisualizationStatePreferenceHelper c2626j = this.mStatePreferenceHelper;
        if (c2626j != null && c2626j.m11639b()) {
            this.algoVisualViewManager = new AlgoVisualViewManager(this.mActivity, this.mOneCamera);
            this.algoVisualViewManager.m11607a();
        }
        this.mCameraUIInterface.mo18101a(getEffectMenuKeyByMode(), isMicroscopeMode());
        this.mCameraUIInterface.mo18116aF();
        if (z) {
            showBubble();
        }
    }

    public void updateInversePositionRatio(boolean z) {
        InverseManager.INS.setPositionRatio(this.mActivity, 0.5f, z);
    }

    protected void doAfterStartPreview() {
        if (this.mbPaused) {
            return;
        }
        if (this.mCameraUIInterface != null) {
            MagShellResponseStatus c2918sMo10514aP = this.mCameraInterface.mo10514aP();
            CameraLog.m12959b(TAG, "doAfterStartPreview, front: " + this.mbFrontCamera + ", cameraMode: " + getCameraMode() + ", shell response status: " + c2918sMo10514aP);
            if (!this.mbFrontCamera && c2918sMo10514aP.m16303e() && this.mCameraInterface.mo10515aQ()) {
                c2918sMo10514aP.m16305f(true);
                this.mCameraUIInterface.mo18070a(R.string.rio_toast_shell_covered_camera_lens, -1, true, false, false);
            } else {
                this.mCameraUIInterface.mo18067a(R.string.rio_toast_shell_covered_camera_lens);
            }
            if (!isFlashState() && !isHDRState() && !isInProMode() && !InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                    this.mCameraUIInterface.mo18110a(R.string.camera_video_hdr);
                }
                if (!isUltraNightVideoOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO) && !isInProMode()) {
                    this.mCameraUIInterface.mo18110a(R.string.camera_ultra_video_night);
                }
                this.mCameraUIInterface.mo18108a(false, true, true);
            }
            if (this.mPreferences != null) {
                if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE) && "standard_high".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value)))) {
                    this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, true).commit();
                }
                if (isOpenHDR()) {
                    updateMenuWithHDRChange(true);
                } else if (isAutoHDR()) {
                    updateFlashMenuIfHDRIsAuto(this.mbFrontCamera);
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeMessages(2);
                    this.mHandler.sendEmptyMessageDelayed(2, 400L);
                }
            }
        }
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            interfaceC2646a.mo10516aR();
        }
    }

    private final boolean beforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12952a("captureX beforeSnapping");
        this.mCaptureOrientation = this.mCameraInterface.mo10591u();
        boolean zMo10560c = this.mCameraInterface.mo10560c();
        CameraLog.m12954a(TAG, "beforeSnapping, ret: " + zMo10560c + ", mbAutoHDR: " + this.mbAutoHDR);
        if (!zMo10560c) {
            CameraLog.m12967f(TAG, "beforeSnapping, beforeCaptureProcess return false");
            return false;
        }
        getExif(null);
        boolean zOnBeforeSnapping = onBeforeSnapping(c2693c);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.7
            @Override // java.lang.Runnable
            public void run() {
                if (BaseMode.this.mbDestroyed) {
                    return;
                }
                BaseMode.this.mCameraInterface.mo10563d(false);
            }
        });
        this.mJpgOrientation = getJpegOrientation(getProperCameraId(this.mCameraId), this.mCaptureOrientation);
        if (!getSupportFunction(CameraFunction.APS_BRACKETMODE) || disableBokehHDR(c2693c.f13385N)) {
            updateBracketMode(false, 0);
        } else {
            this.mApsBracketMode = c2693c.f13393V;
            updateBracketMode(false, this.mApsBracketMode);
        }
        if (this.mApsDecisionFeatureType != c2693c.f13395X) {
            this.mApsDecisionFeatureType = c2693c.f13395X;
        }
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf(this.mJpgOrientation));
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.FACE_RECTIFY_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(isFaceRectifyOpen()));
        if (this.mbBurstShot) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 75);
        } else if (!Util.m24169C()) {
            String heicCodecFormat = getHeicCodecFormat();
            if (heicCodecFormat == null) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 95);
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
                    this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 50);
                } else if (c2 == 1) {
                    this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 70);
                } else {
                    this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 95);
                }
            }
            CameraLog.m12962c(TAG, "beforeSnapping, heicCodecFormat: " + heicCodecFormat);
        } else {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 95);
        }
        this.mOneCamera.mo13067b((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_GPS_LOCATION, (CaptureRequest.Key) this.mCameraInterface.mo10595y());
        if (!Util.m24169C() && c2693c.f13383L != null && (!this.mbFrontCamera || !isInNightProcess())) {
            this.mOneCamera.mo13071b(true, false);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            this.mbResetAeLockAfterCaptured = true;
        }
        CameraLog.m12958b("captureX beforeSnapping");
        return zOnBeforeSnapping;
    }

    public long getMinimumCaptureMemory() {
        return (isHighPictureSize() && "heic_8bits".equalsIgnoreCase(getHeicCodecFormat())) ? 150994944L : 52428800L;
    }

    public OplusCameraCharacteristics getCameraInfo(int OplusGLSurfaceView_13) {
        return CameraCharacteristicsUtil.m12971a(getCameraMode(), OplusGLSurfaceView_13);
    }

    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21315e.m22566b(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21315e.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    protected void onShutterCallback(boolean z, boolean z2) {
        CameraLog.m12967f(TAG, "CameraTest Shutter clickable Restart");
    }

    private void capturePreviewData(final CameraRequestTag c2693c) {
        CameraLog.m12954a(TAG, "capturePreviewData, title: " + this.mThumbnailTitle);
        if (this.mCameraUIInterface == null || getCapturePreviewDataState() != 1) {
            return;
        }
        this.mCameraUIInterface.mo18088a(new SurfaceTextureScreenNail.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.capmode.BaseMode.8
            @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo11761a() {
                return c2693c.f13384M;
            }

            @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
            /* renamed from: IntrinsicsJvm.kt_4 */
            public int mo11762b() {
                BaseMode baseMode = BaseMode.this;
                int jpegOrientation = baseMode.getJpegOrientation(baseMode.getProperCameraId(baseMode.mCameraId), c2693c.f13381J);
                if (BaseMode.this.mbFrontCamera) {
                    if (mo11761a() && jpegOrientation % 180 == 0) {
                        return 180 - jpegOrientation;
                    }
                    if (jpegOrientation % 180 != 0) {
                        return 360 - jpegOrientation;
                    }
                }
                return (BaseMode.this.mCameraUIInterface.mo18207e() && jpegOrientation % 180 == 0) ? 180 - jpegOrientation : jpegOrientation;
            }

            @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11760a(Bitmap bitmap) {
                if (c2693c.f13403ae) {
                    return;
                }
                if (!c2693c.f13415j) {
                    BaseMode.this.mHandler.removeMessages(6);
                    BaseMode.this.mHandler.sendMessage(BaseMode.this.mHandler.obtainMessage(6, new Thumbnail(bitmap, c2693c.hashCode(), c2693c.f13400ab)));
                } else {
                    BaseMode.this.mCameraInterface.mo10486a(new Thumbnail(bitmap));
                }
            }

            @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo10414a(Integer num, Bitmap bitmap, long OplusGLSurfaceView_15, long j2, CaptureResult captureResult) {
                Face[] faceArr;
                CameraLog.m12954a(BaseMode.TAG, "capturePreviewData, onPreviewCaptured, which: " + num + ", bitmap: " + bitmap + ", timestamp: " + j2 + ", result: " + captureResult + ", title: " + BaseMode.this.mThumbnailTitle);
                String string = (BaseMode.this.mPreferences == null || BaseMode.this.mActivity == null) ? "off" : BaseMode.this.mPreferences.getString(CameraUIInterface.KEY_MIRROR, BaseMode.this.mActivity.getString(R.string.camera_mirror_default_value));
                if (0 == j2) {
                    BaseMode.this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseMode.this.shutterCallback(false, true);
                        }
                    });
                }
                ThumbnailProcessor.DataRequest dataRequest = new ThumbnailProcessor.DataRequest();
                if (c2693c.f13405ag && !c2693c.f13384M) {
                    if (c2693c.f13381J == 0 || 180 == c2693c.f13381J) {
                        dataRequest.mThumbBitmap = Util.m24218a(bitmap);
                    } else {
                        dataRequest.mThumbBitmap = Util.m24371b(bitmap);
                    }
                } else {
                    dataRequest.mThumbBitmap = bitmap;
                }
                dataRequest.mCapMode = BaseMode.this.getCameraMode();
                dataRequest.mResolver = BaseMode.this.mActivity.getApplicationContext().getContentResolver();
                dataRequest.mPreviewSize = new Size(bitmap.getWidth(), bitmap.getHeight());
                dataRequest.mDate = BaseMode.this.mCaptureDate;
                dataRequest.mTitle = BaseMode.this.mThumbnailTitle;
                dataRequest.mExif = BaseMode.this.getExif(null);
                dataRequest.mMirrorState = string;
                dataRequest.mRearMirrorState = c2693c.f13405ag ? "on" : "off";
                dataRequest.mThumbOrientation = BaseMode.this.mCaptureOrientation;
                dataRequest.mCameraId = BaseMode.this.mCameraId;
                BaseMode baseMode = BaseMode.this;
                dataRequest.mLogicCameraId = baseMode.getProperCameraId(baseMode.mCameraId);
                dataRequest.mJpegOrientation = BaseMode.this.getJpegOrientation(dataRequest.mLogicCameraId, BaseMode.this.mCaptureOrientation);
                dataRequest.mIdentity = OplusGLSurfaceView_15;
                dataRequest.mTimeStamp = j2;
                dataRequest.mbBurstShot = BaseMode.this.mbBurstShot;
                dataRequest.mRecBurstNum = BaseMode.this.mbBurstShot ? 1 : -1;
                dataRequest.mbLockScreen = BaseMode.this.mbDisplayOnLock;
                dataRequest.mRequestHash = c2693c.hashCode();
                dataRequest.mStickerCaptureTime = c2693c.f13402ad;
                dataRequest.mbUltraHighResolution = BaseMode.this.isUltraHighResolutionOpened();
                dataRequest.mbSuperClearPortrait = BaseMode.this.isSuperClearPortraitOpen() && BaseMode.this.isApsDecisionAlgoOpen(CameraUnitKeys.ALGO_NAME_SCPORTRAIT);
                dataRequest.mHeicCodecFormat = c2693c.f13397Z;
                dataRequest.mbWatchRequest = c2693c.f13399aa;
                dataRequest.mbQuickJpeg = CameraScreenNail.f14187b == num;
                dataRequest.mbSupportQuickJpeg = BaseMode.this.getSupportQuickJpeg(c2693c);
                dataRequest.mApsService = BaseMode.this.mApsService;
                dataRequest.mbMakeupWatermark = !c2693c.f13410e.equals("none") && BaseMode.this.mPreferences != null && "on".equals(BaseMode.this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off")) && "on".equals(BaseMode.this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"));
                if (Float.compare(BaseMode.this.getZoomValue(), ZoomManager.f12334a) != 0 && dataRequest.mbQuickJpeg && captureResult != null && BaseMode.this.isFaceRectifyOpen() && (faceArr = (Face[]) captureResult.get(CaptureResult.STATISTICS_FACES)) != null && faceArr.length != 0) {
                    dataRequest.mOneCamera = BaseMode.this.mOneCamera;
                    dataRequest.mResult = captureResult;
                }
                if (BaseMode.this.mbBurstShot) {
                    dataRequest.mCshotPath = BaseMode.this.mCameraInterface.mo10593w();
                    dataRequest.mBurstShotFlagId = BaseMode.this.mCameraInterface.mo10594x();
                }
                boolean zIsInNightProcess = BaseMode.this.isInNightProcess();
                boolean zIsInOfflineNightProcess = BaseMode.this.isInOfflineNightProcess();
                if ((!Util.m24169C() || !zIsInNightProcess || zIsInOfflineNightProcess || BaseMode.this.mbBurstShot) && !c2693c.f13403ae) {
                    BaseMode.this.mCameraInterface.mo10471a(dataRequest);
                }
                if (!dataRequest.mbQuickJpeg) {
                    BaseMode.this.setCapturePreviewDataState(2);
                }
                CameraLog.m12954a(BaseMode.TAG, "capturePreviewData, onPreviewCaptured, X, isInNightProcess: " + zIsInNightProcess + ", isInOfflineNightProcess: " + zIsInOfflineNightProcess);
            }
        }, true, getNeedCheckTimeStamp(), SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14253d);
    }

    public final void shutterCallback(boolean z, boolean z2) {
        if (!z && !this.mbPaused) {
            this.mPostCounter++;
            CameraLog.m12954a(TAG, "shutterCallback, mPostCounter: " + this.mPostCounter);
            setInPreparing(false);
        }
        if (this.mbPaused) {
            CameraLog.m12954a(TAG, "shutterCallback, camera pause, so return");
            return;
        }
        if (!z && !isInNightProcess()) {
            this.mCameraInterface.mo10561d();
        }
        onShutterCallback(z, z2);
    }

    public boolean withinSatMainRange(float COUIBaseListPopupWindow_12) {
        float[] configFloatArrayValue;
        return getSupportFunction(CameraFunction.SAT_CAMERA) && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[0]) >= 0 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[1]) < 0 && !getZoomAutoMicroOpen();
    }

    public boolean withinSatMainAndWideRange(float COUIBaseListPopupWindow_12) {
        float[] configFloatArrayValue;
        return getSupportFunction(CameraFunction.SAT_CAMERA) && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[1]) < 0;
    }

    public final void pictureTakenCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, String str, boolean z, boolean z2, long OplusGLSurfaceView_15, int i3) {
        pictureTakenCallback(bArr, OplusGLSurfaceView_13, i2, str, z, z2, true, OplusGLSurfaceView_15, i3);
    }

    public final void pictureTakenCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, String str, boolean z, boolean z2, boolean z3, long OplusGLSurfaceView_15, int i3) {
        CameraUIInterface cameraUIInterface;
        int height;
        int width;
        OneCamera interfaceC2694d;
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            interfaceC2646a.mo10493a(bArr);
            onBeforePictureTaken(bArr, z2);
        }
        if (z) {
            if (this.mbPaused && z3) {
                return;
            }
            if (OplusGLSurfaceView_13 != 0 || i2 != 0 || (interfaceC2694d = this.mOneCamera) == null || this.mCameraInterface == null) {
                height = OplusGLSurfaceView_13;
                width = i2;
            } else {
                Size pictureSize = getPictureSize(interfaceC2694d.mo13086e());
                if (getJpegOrientation(getProperCameraId(this.mCameraId), this.mCameraInterface.mo10591u()) % 180 == 0) {
                    height = pictureSize.getWidth();
                    width = pictureSize.getHeight();
                } else {
                    height = pictureSize.getHeight();
                    width = pictureSize.getWidth();
                }
            }
            Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
            cameraPicture.f12142o = height;
            cameraPicture.f12143p = width;
            cameraPicture.f12132e = bArr;
            cameraPicture.f12135h = str;
            cameraPicture.f12136i = getCameraMode();
            cameraPicture.f12147t = Util.m24369b(bArr);
            cameraPicture.f12147t = this.mJpgOrientation;
            cameraPicture.mPath = null;
            cameraPicture.f12107E = this.mbDisplayOnLock;
            cameraPicture.f12139l = OplusGLSurfaceView_15;
            cameraPicture.f12150w = getNeedStoreRawPic();
            if (this.mThumbnailTitle != null && "raw".equalsIgnoreCase(cameraPicture.f12135h)) {
                cameraPicture.f12134g = this.mThumbnailTitle;
            }
            CameraInterface interfaceC2646a2 = this.mCameraInterface;
            if (interfaceC2646a2 != null) {
                interfaceC2646a2.mo10483a(cameraPicture, z3);
            }
        }
        CameraInterface interfaceC2646a3 = this.mCameraInterface;
        if (interfaceC2646a3 != null) {
            interfaceC2646a3.mo10494a(bArr, z2, i3);
            onAfterPictureTaken(bArr, z2);
        }
        if (!this.mbInBurstShotCapturing) {
            setAllowSwitchMode(true);
        }
        this.mbInCapturing = false;
        this.mbHasClickedFromThird = true;
        CameraInterface interfaceC2646a4 = this.mCameraInterface;
        if (interfaceC2646a4 != null && interfaceC2646a4.mo10575i()) {
            this.mCameraInterface.mo10563d(true);
        }
        CameraUIInterface cameraUIInterface2 = this.mCameraUIInterface;
        if (cameraUIInterface2 != null) {
            cameraUIInterface2.mo18240l(true, true);
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$FR4PEsLfF-CF_kRPXzCtUb8_Zzg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$pictureTakenCallback$0$BaseMode();
                    }
                });
            }
        }
        if ((Camera.f10610l || Camera.f10611m) && this.mbNeedReloadFlashMenu && (cameraUIInterface = this.mCameraUIInterface) != null && !z2) {
            this.mbNeedReloadFlashMenu = false;
            cameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_FLASH_MODE);
        }
        CameraInterface interfaceC2646a5 = this.mCameraInterface;
        if (interfaceC2646a5 != null) {
            interfaceC2646a5.mo10564e();
        }
        CameraLog.m12954a(TAG, "pictureTakenCallback, mbInCapturing: " + this.mbInCapturing + ", mbNeedReloadFlashMenu: " + this.mbNeedReloadFlashMenu);
    }

    public /* synthetic */ void lambda$pictureTakenCallback$0$BaseMode() {
        this.mCameraUIInterface.mo18052P(true);
    }

    public final boolean burstShotCapture() {
        CameraLog.m12954a(TAG, "burstShotCapture");
        this.mbBurstShot = true;
        updateAutoSeNightUI(null);
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13143w();
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

    public void onThermalLevelChange(int OplusGLSurfaceView_13, int i2) throws NumberFormatException {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(CameraUIInterface.KEY_CURRENT_TEMPERATURE, i2).apply();
        }
        setCurTemperatureToHAL();
    }

    protected float getZoomValue() {
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            return interfaceC2646a.mo10535ak();
        }
        return 1.0f;
    }

    protected float getMinZoomValue() {
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            return interfaceC2646a.mo10537am();
        }
        return 1.0f;
    }

    protected boolean checkPreviewResult(CameraApsDecision cameraApsDecision) {
        return cameraApsDecision != null && cameraApsDecision.mCameraId == this.mCameraId;
    }

    public final boolean capture(boolean z) throws Resources.NotFoundException {
        CameraApsDecision cameraApsDecision;
        boolean z2;
        boolean z3;
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        int i4;
        if (1 == getCapturePreviewDataState()) {
            CameraLog.m12967f(TAG, "capture, capturePreview not done!");
            onCancleCapturePictureRequest();
            return false;
        }
        this.mCameraUIInterface.mo18251o(getSupportQuickJpeg(null));
        this.mbCaptureHasSuperTextResult = false;
        synchronized (this.mApsDecisionResultLock) {
            this.mbInCapturing = true;
            cameraApsDecision = this.mDecisionResult;
        }
        if (!checkPreviewResult(cameraApsDecision) || this.mOneCamera == null) {
            this.mbInCapturing = false;
            CameraLog.m12967f(TAG, "capture, decisionResult is null!");
            onCancleCapturePictureRequest();
            this.mCameraUIInterface.mo18251o(false);
            this.mbInCapturing = false;
            return false;
        }
        if (cameraApsDecision != null) {
            CameraLog.m12954a(TAG, "capture, decisionResult: " + cameraApsDecision.toString());
            onAISSnapshotChecked(cameraApsDecision);
            if (!getSupportFunction(CameraUIInterface.KEY_START_PREIVEW_SYNC)) {
                setInPreparing(true);
            }
            setAllowSwitchMode(false);
            this.mCaptureRequestTag = getCaptureRequestTag(cameraApsDecision, z);
            if (!beforeSnapping(this.mCaptureRequestTag)) {
                this.mCameraUIInterface.mo18251o(false);
                onCancleCapturePictureRequest();
                this.mbInCapturing = false;
                setInPreparing(false);
                setAllowSwitchMode(true);
                ComprehensivePerformance.m15113a();
                CameraLog.m12958b("captureX beforeSnapping");
                return false;
            }
            this.mCaptureStartedCallbackNum = 0;
            this.mMergeIndex = 0;
            synchronized (this.mApsDecisionResultLock) {
                z2 = this.mDecisionResult != null && (30 == this.mDecisionResult.mApsDecisionFeatureType || 34 == this.mDecisionResult.mApsDecisionFeatureType);
                z3 = this.mDecisionResult != null && (40 == this.mDecisionResult.mApsDecisionFeatureType || 41 == this.mDecisionResult.mApsDecisionFeatureType);
            }
            if (z2) {
                if (this.mCaptureRequestTag.f13383L == null || this.mCaptureRequestTag.f13383L.length <= 0) {
                    OplusGLSurfaceView_13 = 0;
                } else {
                    OplusGLSurfaceView_13 = 0;
                    for (int i5 = 0; i5 < getDefaultCaptureNumber(); i5++) {
                        if (this.mCaptureRequestTag.f13383L[i5] == 0) {
                            OplusGLSurfaceView_13++;
                        }
                    }
                }
                this.mOneCamera.mo13108k(OplusGLSurfaceView_13);
            } else {
                OplusGLSurfaceView_13 = 0;
            }
            if (z3) {
                if (this.mCaptureRequestTag.f13383L == null || this.mCaptureRequestTag.f13383L.length <= 0) {
                    i3 = OplusGLSurfaceView_13;
                    i4 = 0;
                } else {
                    int i6 = this.mDecisionResult.mMetaIndex - 1;
                    i4 = this.mCaptureRequestTag.f13383L[i6];
                    i3 = this.mCaptureRequestTag.f13430y - i6;
                }
                this.mOneCamera.mo13108k(i3);
                this.mOneCamera.mo13111l(i4);
            }
            if (isNeedSetZslWhenCapture()) {
                this.mOneCamera.mo13115m(getZSLMode());
            }
            this.mbCaptureNotMatchMeta = true;
            this.mCameraInterface.mo10487a(this.mCameraPictureCallback);
            if (isImmediateCapture()) {
                this.mCaptureDate = System.currentTimeMillis();
                CameraRequestTag c2693c = this.mCaptureRequestTag;
                long OplusGLSurfaceView_15 = this.mCaptureDate;
                c2693c.f13400ab = OplusGLSurfaceView_15;
                this.mThumbnailTitle = Util.m24247a(OplusGLSurfaceView_15, this.mbBurstShot);
                if (isSloganOpen() && cameraApsDecision != null) {
                    if (isVideoModeType()) {
                        i2 = 1;
                    } else {
                        i2 = this instanceof XPanMode ? 3 : 0;
                    }
                    this.mCameraInterface.mo10490a(false, i2, false, cameraApsDecision.mMasterPipeline, true);
                }
                if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_CAPTURE_PREVIEW)) {
                    setCapturePreviewDataState(1);
                } else {
                    setCapturePreviewDataState(0);
                }
                this.mCameraInterface.mo10569f(false);
                updateCaptureParam(this.mCaptureRequestTag);
                this.mCaptureRequestTag.f13405ag = this.mCameraUIInterface.mo18207e();
                if (this.mbBurstShot) {
                    setBurstShotCapturing(true);
                }
                burstCapture(this.mCaptureRequestTag.f13430y, this.mCaptureRequestTag, getCaptureCallback());
                if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_CAPTURE_PREVIEW)) {
                    capturePreviewData(this.mCaptureRequestTag);
                    onStartCapturePreviewData();
                }
            } else {
                this.mCameraInterface.mo10448D();
            }
            this.mFirstCaptureHash = 0;
            onAfterSnapping();
            return true;
        }
        CameraLog.m12967f(TAG, "ops, decisionResult is null");
        onCancleCapturePictureRequest();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0155  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0152 -> B:60:0x0155). Please report as PlatformImplementations.kt_3 decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void updateCaptureParam(com.oplus.camera.p141e.CameraRequestTag r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.BaseMode.updateCaptureParam(com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_3):void");
    }

    protected void burstCapture(int OplusGLSurfaceView_13, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar) {
        this.mCameraInterface.mo10475a(OplusGLSurfaceView_13, c2693c, aVar);
    }

    public boolean isInPreviewArea(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public boolean isInSlideModeChangeAreaForFull(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        return new Rect(rect.left, rect.top + Util.m24347aj(), rect.right, rect.bottom).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public final boolean stopTakePicture(boolean z) {
        if (needCancelToForceStop() && z) {
            onCancelTakePicture();
            return true;
        }
        return onStopTakePicture();
    }

    public void setCameraId(int OplusGLSurfaceView_13) {
        this.mCameraId = OplusGLSurfaceView_13;
        this.mbFrontCamera = CameraCharacteristicsUtil.m12974a(this.mCameraId);
    }

    public void updateFilterNoneIndex() {
        FilterHelper.f21279a = getFilterNoneIndex();
    }

    public void beforeSwitchToMode(boolean z) {
        this.mCameraUIInterface.mo18108a(true, z, false);
        this.mbShowEnvironmentTips = false;
    }

    public boolean isAllowSwitch(CameraConstant.PlatformImplementations.kt_3 aVar) {
        return this.mbAllowSwitchMode && getCapturePreviewDataState() != 1;
    }

    public final boolean getAddMenuOptionEnabled(String str) {
        if (this.mbModePreInit) {
            return getCanAddMenuOption(str);
        }
        return true;
    }

    public boolean getCanAddMenuOption(String str) {
        return (CameraUIInterface.KEY_FLASH_MODE.equals(str) && onGetSupportSettingList(CameraUIInterface.KEY_FLASH_MODE, this.mCameraId) == null) ? false : true;
    }

    public List<String> onGetSupportSettingList(String str, int OplusGLSurfaceView_13) {
        return getSupportSettingList(str, OplusGLSurfaceView_13);
    }

    public final List<String> getSupportSettingList(String str, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_FLASH_MODE.equals(strM13305d) && this.mbFrontCamera) {
            return null;
        }
        List<String> supportedList = CameraConfig.getSupportedList(strM13305d, OplusGLSurfaceView_13);
        if (supportedList == null) {
            supportedList = new ArrayList<>();
            String[] stringArray = CameraUIInterface.KEY_FLASH_MODE.equals(strM13305d) ? this.mActivity.getResources().getStringArray(R.array.flash_mode_values) : null;
            if (CameraUIInterface.KEY_PHOTO_RATIO.equals(strM13305d)) {
                stringArray = this.mActivity.getResources().getStringArray(R.array.photo_ratio_values);
            }
            if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strM13305d)) {
                stringArray = this.mActivity.getResources().getStringArray(R.array.timer_shutter_values);
            }
            if (stringArray != null) {
                for (String str2 : stringArray) {
                    supportedList.add(str2);
                }
            }
        }
        return supportedList;
    }

    public final void restoreSettingMenuOption(String[] strArr) {
        List<String> supportSettingList;
        if (strArr == null) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
            List<String> listOnGetSupportSettingList = onGetSupportSettingList(strArr[OplusGLSurfaceView_13], this.mCameraId);
            if (listOnGetSupportSettingList != null && listOnGetSupportSettingList.size() >= 2 && (supportSettingList = getSupportSettingList(strArr[OplusGLSurfaceView_13], this.mCameraId)) != null) {
                for (int i2 = 0; i2 < supportSettingList.size(); i2++) {
                    String str = supportSettingList.get(i2);
                    if (!listOnGetSupportSettingList.contains(str)) {
                        this.mCameraUIInterface.mo18103a(strArr[OplusGLSurfaceView_13], str);
                    }
                }
            }
        }
    }

    public final void removeSettingMenuOption(String[] strArr) {
        List<String> supportSettingList;
        if (strArr == null) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
            List<String> listOnGetSupportSettingList = onGetSupportSettingList(strArr[OplusGLSurfaceView_13], this.mCameraId);
            if (listOnGetSupportSettingList != null && listOnGetSupportSettingList.size() >= 2 && (supportSettingList = getSupportSettingList(strArr[OplusGLSurfaceView_13], this.mCameraId)) != null) {
                for (int i2 = 0; i2 < supportSettingList.size(); i2++) {
                    String str = supportSettingList.get(i2);
                    if (!listOnGetSupportSettingList.contains(str)) {
                        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(strArr[OplusGLSurfaceView_13]) && str.equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value)))) {
                            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                            editorEdit.putString(CameraUIInterface.KEY_PHOTO_RATIO, supportSettingList.get(0));
                            editorEdit.apply();
                        }
                        this.mCameraUIInterface.mo18173b(strArr[OplusGLSurfaceView_13], str);
                    }
                }
            }
        }
    }

    public void restoreProPreference() throws Resources.NotFoundException {
        Activity activity;
        if ((!isNightProModeSupport() && !isProModeSupport()) || (activity = this.mActivity) == null || this.mPreferences == null) {
            return;
        }
        String string = activity.getResources().getString(R.string.camera_iso_default_value);
        String string2 = this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value);
        String string3 = this.mActivity.getResources().getString(R.string.camera_whitebalance_default_value);
        this.mPreferences.edit().putString("pref_professional_iso_key", string).putString("pref_professional_exposure_time_key", string2).putString("pref_professional_whitebalance_key", string3).putString("pref_professional_focus_mode_key", this.mActivity.getResources().getString(R.string.camera_focus_mode_default_value)).putString("pref_professional_exposure_compensation_key", this.mActivity.getResources().getString(R.string.camera_exposure_compensation_default_value)).apply();
    }

    protected boolean isNightProModeSupport() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_PRO_MODE_SUPPORT);
    }

    protected boolean isProModeSupport() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HIGHPICTURE_PRO_MODE_SUPPORT);
    }

    public boolean getZSLMode() {
        if (Util.m24169C()) {
            synchronized (this.mApsDecisionResultLock) {
                if (this.mDecisionResult != null && (30 == this.mDecisionResult.mApsDecisionFeatureType || 34 == this.mDecisionResult.mApsDecisionFeatureType)) {
                    return true;
                }
                if (this.mbFrontCamera && getLogicCameraType() != 0) {
                    return false;
                }
            }
        }
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a == null || interfaceC2646a.mo10575i() || Util.m24169C()) {
            return !Util.m24169C() || this.mApsBracketMode <= 0;
        }
        return false;
    }

    public int getLogicCameraType() {
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d == null || interfaceC2694d.mo13086e() == null || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZSL_SUPPORT_PREVERSION)) {
            return -1;
        }
        return this.mOneCamera.mo13086e().m13252I();
    }

    public int getDefaultAFMode() {
        List listAsList;
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null && interfaceC2694d.mo13086e() != null && (listAsList = Arrays.asList(this.mOneCamera.mo13086e().m13244A())) != null && listAsList.size() > 0) {
            if (listAsList.contains(4)) {
                return 4;
            }
            if (listAsList.contains(1)) {
                return 1;
            }
        }
        CameraLog.m12954a(TAG, "getDefaultAFMode, focusMode: 4");
        return 4;
    }

    public String getFlashMode() {
        if (this.mbFlashTemporaryDisabled) {
            return (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && !withinSatMainAndWideRange(getZoomValue()) && isCaptureModeType() && getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && CameraParameter.FlashMode.FLASH_TORCH.equals(getRearFlashMode())) ? CameraParameter.FlashMode.FLASH_TORCH : "off";
        }
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_FLASH_MODE)) {
            return getVideoFlashMode();
        }
        if (getSupportFunction(CameraUIInterface.KEY_MOVIE_FLASH_MODE)) {
            return getMovieFlashMode();
        }
        if (!getSupportFunction(CameraUIInterface.KEY_TORCH_MODE) && !getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT)) {
            return getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) ? getRearFlashMode() : "off";
        }
        String torchMode = getTorchMode();
        if (getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT) && "on".equals(torchMode)) {
            torchMode = CameraParameter.FlashMode.FLASH_TORCH;
        }
        return (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE) && "on".equals(torchMode) && InverseManager.INS.isInverseAble(this.mActivity)) ? CameraParameter.FlashMode.FLASH_TORCH : torchMode;
    }

    protected String getRearFlashMode() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null && this.mActivity != null) {
            return sharedPreferences.getString(CameraEntry.m13299b(CameraUIInterface.KEY_FLASH_MODE, this.mCameraEntry.m13317J()), this.mActivity.getString(R.string.camera_flash_mode_default_value));
        }
        Activity activity = this.mActivity;
        return activity != null ? activity.getString(R.string.camera_flash_mode_default_value) : "off";
    }

    protected String getTorchMode() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity));
        }
        Activity activity = this.mActivity;
        return activity != null ? Util.m24174F(activity) : "off";
    }

    private String getVideoFlashMode() {
        Activity activity = this.mActivity;
        String string = activity != null ? activity.getString(R.string.camera_flash_mode_video_default_value) : "off";
        SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, string) : string;
    }

    private String getMovieFlashMode() {
        Activity activity = this.mActivity;
        String string = activity != null ? activity.getString(R.string.camera_flash_mode_video_default_value) : "off";
        SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null ? sharedPreferences.getString(CameraUIInterface.KEY_MOVIE_FLASH_MODE, string) : string;
    }

    private boolean isSystemAppCall() {
        String callingPackage = this.mActivity.getCallingPackage();
        return MMS_PACKAGE_NAME.equals(callingPackage) || CONTACT_PACKAGE_NAME.equals(callingPackage) || NOTE_PACKAGE_NAME.equals(callingPackage) || GOOGLE_KEEP_PACKAGE_NAME.equals(callingPackage);
    }

    public Size getDecreasedSizeForThirdApp(OplusCameraCharacteristics c2698h) {
        if (!isSystemAppCall()) {
            return null;
        }
        return Util.m24239a(c2698h.m13258a(256), PICTURE_SIZE_5M, Util.m24211a(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value))));
    }

    public double getDisplayHighPictureSize() {
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.mCameraId) / 100;
        boolean zEquals = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off"));
        String str = ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE;
        if (!zEquals || CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.mCameraId) == null) {
            str = ConfigDataBase.KEY_HIGH_PICTURE_SIZE;
        }
        return configIntValue > 0 ? configIntValue : Util.m24199a(this.mActivity, CameraConfig.getSizeConfigValue(str, this.mCameraId));
    }

    public Size getSurfaceSize(String str, OplusCameraCharacteristics c2698h) {
        int[] iArrM13265b;
        List<Size> configSizeListValue;
        List<Size> configSizeListValue2;
        if ("type_tuning_data_yuv".equals(str)) {
            int[] iArrM13265b2 = c2698h.m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13278aQ);
            if (iArrM13265b2 != null && iArrM13265b2.length >= 2) {
                return new Size(iArrM13265b2[0], iArrM13265b2[1]);
            }
        } else if ("type_tuning_data_raw".equals(str) && (iArrM13265b = c2698h.m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13279aR)) != null && iArrM13265b.length >= 2) {
            return new Size(iArrM13265b[0], iArrM13265b[1]);
        }
        this.mForceUpscaleSize = c2698h.m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13275aN);
        if (isSatOpen()) {
            if (!Util.m24169C() && needConfigPhysicalStream(str)) {
                return getPhysicalPictureSize(c2698h, null, str);
            }
            if ("type_still_capture_yuv_main".equals(str)) {
                Size ultraPictureSize = getUltraPictureSize(ConfigDataBase.KEY_SAT_WIDE_PICTURE_SIZE);
                return ultraPictureSize == null ? getPictureSize(c2698h) : ultraPictureSize;
            }
            if ("type_still_capture_yuv_sub".equals(str)) {
                return getUltraPictureSize(ConfigDataBase.KEY_SAT_ULTRA_PICTURE_SIZE);
            }
            if ("type_still_capture_yuv_third".equals(str)) {
                return getUltraPictureSize(ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE);
            }
            if ("type_reprocess_data_yuv".equals(str)) {
                return Util.m24240a(new Size[]{getUltraPictureSize(ConfigDataBase.KEY_SAT_WIDE_PICTURE_SIZE), getUltraPictureSize(ConfigDataBase.KEY_SAT_ULTRA_PICTURE_SIZE), getUltraPictureSize(ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE)});
            }
        } else if (getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA)) {
            int[] iArrM13265b3 = c2698h.m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13308au);
            if ("type_still_capture_yuv_main".equals(str)) {
                if (Math.abs(getDefaultZoomValue(c2698h) - 2.0f) > 1.0E-6f) {
                    configSizeListValue2 = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_1X);
                } else {
                    configSizeListValue2 = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_2X);
                }
                Size size = (configSizeListValue2 == null || configSizeListValue2.size() == 0) ? null : configSizeListValue2.get(0);
                if (size != null) {
                    return new Size(size.getWidth(), size.getHeight());
                }
                if (iArrM13265b3 != null && iArrM13265b3.length >= 2) {
                    return new Size(iArrM13265b3[0], iArrM13265b3[1]);
                }
            } else if ("type_still_capture_yuv_sub".equals(str)) {
                if (Math.abs(getDefaultZoomValue(c2698h) - 2.0f) > 1.0E-6f) {
                    configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_1X);
                } else {
                    configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_2X);
                }
                Size size2 = (configSizeListValue == null || configSizeListValue.size() < 2) ? null : configSizeListValue.get(1);
                if (size2 != null) {
                    return new Size(size2.getWidth(), size2.getHeight());
                }
                if (iArrM13265b3 != null && iArrM13265b3.length >= 4) {
                    return new Size(iArrM13265b3[2], iArrM13265b3[3]);
                }
            }
        } else if (!"type_video_frame".equals(str)) {
            return getPictureSize(c2698h);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
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
            android.util.Size r5 = com.oplus.camera.util.Util.m24378b(r6, r0)
            return r5
        L67:
            r0 = 4610685218510194460(0x3ffc71c71c71c71c, double:1.7777777777777777)
            android.util.Size r5 = com.oplus.camera.util.Util.m24378b(r6, r0)
            return r5
        L71:
            double r0 = com.oplus.camera.util.Util.m24196X()
            android.util.Size r5 = com.oplus.camera.util.Util.m24378b(r6, r0)
            if (r5 != 0) goto L9d
            android.util.Size r5 = com.oplus.camera.util.Util.m24412c(r6, r0)
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
            com.oplus.camera.CameraLog.m12954a(r0, r6)
        L9d:
            return r5
        L9e:
            r0 = 4608683618675807573(0x3ff5555555555555, double:1.3333333333333333)
            android.util.Size r5 = com.oplus.camera.util.Util.m24378b(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.BaseMode.getUltraPictureSize(java.lang.String):android.util.Size");
    }

    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        if (!this.mbDestroyed && getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE) && this.mPreferences.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false)) {
            if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off")) && CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE) != null) {
                return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.mCameraId);
            }
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        String string = this.mbDestroyed ? "" : this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
        if (needDeleteTheSizeByRatio(string)) {
            string = "standard";
        }
        List<Size> listM13258a = c2698h.m13258a(256);
        CameraLog.m12954a(TAG, "getPictureSize, sizeList: " + listM13258a.toString());
        if ("standard".equals(string)) {
            return Util.m24378b(listM13258a, 1.3333333333333333d);
        }
        if (DcsMsgData.FULL.equals(string)) {
            double dM24196X = Util.m24196X();
            Size sizeM24378b = Util.m24378b(listM13258a, dM24196X);
            if (sizeM24378b != null || !Util.m24350am()) {
                return sizeM24378b;
            }
            Size sizeM24412c = Util.m24412c(listM13258a, Util.m24196X());
            CameraLog.m12954a(TAG, "getPictureSize, get imprecise size: " + sizeM24412c + " with screen ratio: " + dM24196X);
            return sizeM24412c;
        }
        if ("square".equals(string)) {
            return Util.m24378b(listM13258a, 1.0d);
        }
        if ("16_9".equals(string)) {
            return Util.m24378b(listM13258a, 1.7777777777777777d);
        }
        if (!"standard_high".equals(string)) {
            return null;
        }
        if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE)) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        return Util.m24378b(listM13258a, 1.3333333333333333d);
    }

    public Size getPhysicalPictureSize(OplusCameraCharacteristics c2698h, CameraCharacteristics cameraCharacteristics, String str) {
        Size ultraPictureSize;
        if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE) && this.mPreferences.getBoolean(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false)) {
            if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off")) && CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE) != null) {
                return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.mCameraId);
            }
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        SharedPreferences sharedPreferences = this.mPreferences;
        String string = sharedPreferences != null ? sharedPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value)) : null;
        List<Size> listM13259a = c2698h.m13259a(35, cameraCharacteristics, str);
        if ("type_still_capture_yuv_third".equals(str) && (ultraPictureSize = getUltraPictureSize(ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE)) != null) {
            return ultraPictureSize;
        }
        CameraLog.m12954a(TAG, "getPhysicalPictureSize, surfaceType: " + str + ", sizeList: " + listM13259a.toString());
        if ("standard".equals(string)) {
            return Util.m24378b(listM13259a, 1.3333333333333333d);
        }
        if (DcsMsgData.FULL.equals(string)) {
            return Util.m24378b(listM13259a, Util.m24196X());
        }
        if ("square".equals(string)) {
            return Util.m24378b(listM13259a, 1.0d);
        }
        if ("16_9".equals(string)) {
            return Util.m24378b(listM13259a, 1.7777777777777777d);
        }
        if (!"standard_high".equals(string)) {
            return null;
        }
        if (getSupportFunction(CameraUIInterface.KEY_HIGH_PICTURE_SIZE)) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.mCameraId);
        }
        return Util.m24378b(listM13259a, 1.3333333333333333d);
    }

    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        List<Size> configSizeListValue;
        Size pictureSize = getPictureSize(c2698h);
        double targetPreviewRatio = getTargetPreviewRatio(c2698h);
        List<Size> listM13257a = c2698h.m13257a();
        if (isNoneSatUltraWideAngleOpen() && (configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_WIDE_NORMAL_PREVIEW_SIZE)) != null && configSizeListValue.size() > 0) {
            listM13257a = configSizeListValue;
        }
        List<Size> configSizeListValue2 = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_CONTROL_PREVIEW_SIZE);
        if (configSizeListValue2 != null && configSizeListValue2.size() > 0) {
            listM13257a = configSizeListValue2;
        }
        CameraLog.m12954a(TAG, "getPreviewSize, sizeList: " + listM13257a.toString());
        Size sizeM24235a = Util.m24235a(listM13257a, targetPreviewRatio);
        return (Util.m24169C() || sizeM24235a == null) ? sizeM24235a : (!(sizeM24235a.getWidth() % 16 == 0 && sizeM24235a.getHeight() % 16 == 0) && "square".equals(Util.m24248a(pictureSize, this.mCameraId))) ? new Size(1088, 1088) : sizeM24235a;
    }

    protected double getTargetPreviewRatio(OplusCameraCharacteristics c2698h) {
        Size pictureSize = getPictureSize(c2698h);
        if ("standard".equals(Util.m24248a(pictureSize, this.mCameraId)) || "standard_high".equals(Util.m24248a(pictureSize, this.mCameraId))) {
            return 1.3333333333333333d;
        }
        if (DcsMsgData.FULL.equals(Util.m24248a(pictureSize, this.mCameraId))) {
            return Util.m24196X();
        }
        if ("square".equals(Util.m24248a(pictureSize, this.mCameraId))) {
            return 1.0d;
        }
        return "16_9".equals(Util.m24248a(pictureSize, this.mCameraId)) ? 1.7777777777777777d : 1.3333333333333333d;
    }

    public Size getPreviewSize(OplusCameraCharacteristics c2698h, double IntrinsicsJvm.kt_5) {
        List<Size> listM13257a = c2698h.m13257a();
        CameraLog.m12954a(TAG, "getPreviewSize, sizeList: " + listM13257a.toString());
        return Util.m24235a(listM13257a, IntrinsicsJvm.kt_5);
    }

    public Size getPreviewSize(OplusCameraCharacteristics c2698h, String str) {
        return getPreviewSize(c2698h);
    }

    public Size getPreviewFrameSize(OplusCameraCharacteristics c2698h) {
        return getPreviewSize(c2698h);
    }

    public String getTimeLapse() throws NumberFormatException {
        if (this.mPreferences != null && getSupportFunction(CameraUIInterface.KEY_TIME_LAPSE)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(R.string.camera_shutter_mode_default_value));
            try {
                Integer.valueOf(string);
                return string;
            } catch (NumberFormatException unused) {
            }
        }
        return "off";
    }

    public String getMirror() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(CameraUIInterface.KEY_MIRROR, this.mActivity.getString(R.string.camera_mirror_default_value));
        }
        return null;
    }

    public String getCameraShutterType() {
        return this.mCameraInterface.mo10532ah();
    }

    public boolean isInCapturePreparing() {
        return this.mbInPreparing;
    }

    private void setInPreparing(boolean z) {
        CameraLog.m12954a(TAG, "setInPreparing: " + this.mbInPreparing + " -> " + z);
        this.mbInPreparing = z;
    }

    protected boolean getIsCapturingState() {
        return this.mbInCapturing;
    }

    public boolean getIsBurstShotCapturing() {
        return this.mbInBurstShotCapturing;
    }

    public void setBurstShotCapturing(boolean z) {
        CameraLog.m12954a(TAG, "setInBurstShotCapturing :" + this.mbInBurstShotCapturing + " -> " + z);
        this.mbInBurstShotCapturing = z;
    }

    public void setAllowSwitchMode(boolean z) {
        CameraLog.m12954a(TAG, "setAllowSwitchMode: " + this.mbAllowSwitchMode + " -> " + z);
        this.mbAllowSwitchMode = z;
    }

    public void closeHdrAndFlashModeBeforeCapture() {
        if (getSupportFunction(CameraUIInterface.KEY_FLASH_MODE)) {
            setAutoFlash(false);
            this.mFlashMode = getFlashMode();
            if ("on".equals(this.mFlashMode) || "auto".equals(this.mFlashMode)) {
                this.mCameraUIInterface.mo18108a(false, true, true);
                this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, "off");
                OneCamera interfaceC2694d = this.mOneCamera;
                if (interfaceC2694d != null) {
                    interfaceC2694d.mo13069b("off");
                    this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            this.mbAutoHDR = false;
            this.mHDRMode = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
            if ("off".equals(this.mHDRMode)) {
                return;
            }
            this.mCameraUIInterface.mo18108a(false, true, true);
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
            updateHDRMode("off", false);
        }
    }

    protected void openViviEffect() {
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_VIVID_EFFECT, "on");
        editorEdit.apply();
        this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_VIVID_EFFECT, "on");
    }

    protected void closeViviEffect() {
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_VIVID_EFFECT, "off");
        editorEdit.apply();
        this.mCameraUIInterface.mo18108a(true, false, true);
        this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_VIVID_EFFECT, "off");
    }

    public void resetHdrAndFlashModeAfterCapture() {
        if (getSupportFunction(CameraUIInterface.KEY_FLASH_MODE)) {
            this.mFlashMode = getFlashMode();
            if ("on".equals(this.mFlashMode) || "auto".equals(this.mFlashMode)) {
                this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                this.mCameraInterface.mo10585o();
                OneCamera interfaceC2694d = this.mOneCamera;
                if (interfaceC2694d != null) {
                    interfaceC2694d.mo13069b(this.mFlashMode);
                    this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            this.mHDRMode = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
            if ("off".equals(this.mHDRMode)) {
                return;
            }
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_CAMERA_HDR_MODE, (String) null);
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
        if ((Camera.f10610l || Camera.f10611m) && this.mbNeedReloadFlashMenu) {
            this.mbNeedReloadFlashMenu = false;
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_FLASH_MODE);
        }
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a != null) {
            interfaceC2646a.mo10563d(true);
        }
    }

    public void onUpdateCameraSettingMenu() {
        CameraLog.m12954a(TAG, "onUpdateCameraSettingMenu");
        if (getSupportFunction(CameraUIInterface.KEY_FILTER_MENU)) {
            this.mCameraUIInterface.mo18271t(getSupportFunction(CameraUIInterface.KEY_FUJI_FILTER_MENU));
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
        } else if (getSupportFunction(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU);
        } else if (getSupportFunction(CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_VIDEO_FILTER_MENU);
        } else if (getSupportFunction(CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_NIGHT_FILTER_MENU);
        }
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_BLUR_MENU)) {
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        }
        if (getSupportFunction(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU)) {
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU);
        }
        if (getSupportFunction(CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU)) {
            this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU);
        }
        removeSettingMenuOption(FILTER_KEYS);
        setHDRMenuVisibility(getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE));
    }

    public void onEffectSurfaceCreated() {
        CameraLog.m12954a(TAG, "onEffectSurfaceCreated");
        this.mHandler.removeMessages(4);
        this.mHandler.sendEmptyMessage(4);
    }

    public void onEffectMenuChange(String str) {
        CameraLog.m12954a(TAG, "onEffectMenuChange, menuName: " + str);
        this.mEffectMenuSelect = str;
    }

    protected String getCurrEffectMenuName() {
        return this.mEffectMenuSelect;
    }

    protected void updateEffectMenuNames() {
        CameraLog.m12954a(TAG, "updateEffectMenuNames");
        if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
            if (this.mEffectMenuNames == null) {
                this.mEffectMenuNames = new CopyOnWriteArrayList();
            }
            this.mEffectMenuNames.clear();
            if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
                this.mEffectMenuNames.add("beauty");
            }
            if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
                this.mEffectMenuNames.add(MenuClickMsgData.KEY_FILTER);
            }
            String currEffectMenuName = getCurrEffectMenuName();
            int currFilterIndex = 0;
            if ("beauty".equals(currEffectMenuName)) {
                currFilterIndex = getFaceBeautyMenuIndex();
            } else if (MenuClickMsgData.KEY_FILTER.equals(currEffectMenuName)) {
                currFilterIndex = getCurrFilterIndex();
            }
            this.mCameraInterface.mo10491a(true, this.mEffectMenuNames, currEffectMenuName, currFilterIndex);
        }
    }

    private List<String> getEffectMenuNames() {
        if (this.mEffectMenuNames == null) {
            updateEffectMenuNames();
        }
        return this.mEffectMenuNames;
    }

    public boolean hasEffectSelected() {
        List<String> effectMenuNames = getEffectMenuNames();
        int currFilterIndex = FilterHelper.f21279a;
        if (effectMenuNames != null) {
            Iterator<String> it = effectMenuNames.iterator();
            while (it.hasNext()) {
                if (MenuClickMsgData.KEY_FILTER.equals(it.next())) {
                    currFilterIndex = getCurrFilterIndex();
                }
            }
        } else {
            CameraLog.m12954a(TAG, "hasEffectSelected, not Support filter effect.");
        }
        return currFilterIndex != FilterHelper.f21279a;
    }

    public String getFilterCurrName() {
        return this.mActivity.getString(getFilterNameIdList(this.mCameraId).get(getCurrFilterIndex()).intValue());
    }

    public void createEffectTextures(ImageCallback interfaceC3419p) {
        if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
            this.mHandler.removeMessages(5);
            Message message = new Message();
            message.obj = interfaceC3419p;
            message.what = 5;
            this.mHandler.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCreateEffectTextures(ImageCallback interfaceC3419p) {
        boolean z;
        Activity activity;
        String currEffectMenuName = getCurrEffectMenuName();
        boolean z2 = this.mbFrontCamera;
        CameraInterface interfaceC2646a = this.mCameraInterface;
        int sensorOrientation = getSensorOrientation(interfaceC2646a != null ? interfaceC2646a.mo10547aw() : 0);
        boolean z3 = !isMicroscopeMode() ? 270 != sensorOrientation : 90 != sensorOrientation;
        if (Util.m24495t() && z2) {
            z = 270 == sensorOrientation;
        } else {
            z = z3;
        }
        boolean z4 = ApsConstant.CAPTURE_MODE_MACRO.equals(getCameraMode()) && z;
        if (MenuClickMsgData.KEY_FILTER.equals(currEffectMenuName) && (activity = this.mActivity) != null) {
            FilterHelper.m22605a(activity.getResources(), currEffectMenuName, getCurrFilterIndex(), getCurFilterListType(), z2, z, z4, getFilterModelList(), interfaceC3419p, getPreviewSize(CameraCharacteristicsUtil.m12971a(getCameraMode(), this.mCameraId)), this.mCameraUIInterface.mo18207e());
            return;
        }
        CameraLog.m12966e(TAG, "doCreateEffectTextures, currMenuName: " + currEffectMenuName + "; mActivity: " + this.mActivity);
    }

    private List<FilterModel> getFilterModelList() {
        ArrayList arrayList = new ArrayList();
        List<String> filterTypeList = getFilterTypeList(this.mCameraId);
        List<Integer> filterNameIdList = getFilterNameIdList(this.mCameraId);
        int size = filterTypeList.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            FilterModel c3414k = new FilterModel();
            c3414k.f21337a = filterTypeList.get(OplusGLSurfaceView_13);
            c3414k.f21338b = this.mActivity.getString(filterNameIdList.get(OplusGLSurfaceView_13).intValue());
            c3414k.f21339c = getFilterRedpotKey(c3414k.f21337a) != null;
            c3414k.f21340d = getGrandTourFilterKey(c3414k.f21337a);
            arrayList.add(c3414k);
        }
        return arrayList;
    }

    protected int getSensorOrientation(int OplusGLSurfaceView_13) {
        return CameraCharacteristicsUtil.m12968a(getCameraInfo(OplusGLSurfaceView_13));
    }

    protected int getJpegOrientation(int OplusGLSurfaceView_13, int i2) {
        return CameraCharacteristicsUtil.m12975b(getCameraInfo(OplusGLSurfaceView_13), i2);
    }

    public int getFaceBeautyMenuType() {
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            return 1;
        }
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_COMMON)) {
            return 2;
        }
        return getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS) ? 1 : 0;
    }

    public void resetFaceBeautyValues() {
        String[] customBeautyKeys = getCustomBeautyKeys();
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null && customBeautyKeys != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < customBeautyKeys.length; OplusGLSurfaceView_13++) {
                editorEdit.putInt(customBeautyKeys[OplusGLSurfaceView_13], getDefaultCustomBeautyValues()[OplusGLSurfaceView_13]);
            }
            editorEdit.commit();
        }
        updateCustomBeautyValues(getCustomBeautyValues());
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22798a(getCustomBeautyValues());
        }
    }

    public int getFaceBeautyItemValue(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "getFaceBeautyItemValue, index: " + OplusGLSurfaceView_13);
        if (getCustomBeautyKeys() != null) {
            return this.mPreferences.getInt(getCustomBeautyKeys()[OplusGLSurfaceView_13], getFaceBeautyItemDefaultValue(OplusGLSurfaceView_13));
        }
        return getFaceBeautyItemDefaultValue(OplusGLSurfaceView_13);
    }

    public void onFaceBeautyItemValueChange(int OplusGLSurfaceView_13, int i2, boolean z) {
        int[] customBeautyValues = getCustomBeautyValues();
        if (customBeautyValues == null) {
            CameraLog.m12966e(TAG, "onFaceBeautyItemValueChange, return");
            return;
        }
        customBeautyValues[OplusGLSurfaceView_13] = i2;
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22798a(customBeautyValues);
        }
        updateCustomBeautyValues(customBeautyValues);
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        if (!z || this.mPreferences == null || getCustomBeautyKeys() == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getCustomBeautyKeys()[OplusGLSurfaceView_13], i2);
        editorEdit.commit();
    }

    public int getShortcutFaceBeautyIndex() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FACE_BEAUTY_CUSTOM_MENU_SUPPORT) ? 102 : 0;
    }

    public int getFaceBeautyCurrIndex() {
        SharedPreferences sharedPreferences;
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
            return ((getFaceBeautyKey() == null || (sharedPreferences = this.mPreferences) == null) ? 0 : sharedPreferences.getInt(getFaceBeautyKey(), getFaceBeautyDefaultIndex())) <= 0 ? 0 : 102;
        }
        return 0;
    }

    protected boolean isFaceBeautyDefaultOff() {
        return MyRegionAdapter.m14512b();
    }

    protected int getFaceBeautyDefaultIndex() {
        if (isFaceBeautyDefaultOff()) {
            return 0;
        }
        return ((!getSupportFunction(CameraFunction.FACE_BEAUTY_COMMON) || getDefaultCommonBeautyValue() == 0) && !getSupportFunction(CameraFunction.FACE_BEAUTY_CUSTOM)) ? 0 : 102;
    }

    protected int getFaceBeautyItemDefaultValue(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_COMMON)) {
            if (OplusGLSurfaceView_13 == 0) {
                return getDefaultCommonBeautyValue();
            }
            return 0;
        }
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            return getDefaultCustomBeautyValues()[OplusGLSurfaceView_13];
        }
        return -100000;
    }

    protected boolean isFaceBeautyOrMakeupOpen() {
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
            return getFaceBeautyCurrIndex() != 0 || isMakeupOpen();
        }
        return false;
    }

    private boolean isFaceBeautyOpen() {
        return getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS) && getFaceBeautyCurrIndex() != 0;
    }

    protected boolean isCommonFaceBeautyOpen() {
        return getSupportFunction(CameraFunction.FACE_BEAUTY_COMMON) && this.mPreferences.getInt(getFaceBeautyKey(), 0) != 0;
    }

    public void onFaceBeautyItemChange(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "onFaceBeautyItemChange, index: " + OplusGLSurfaceView_13);
        if (updateFaceBeautyValue(OplusGLSurfaceView_13)) {
            updateFaceBeautyLevel(OplusGLSurfaceView_13, true);
            PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
            if (interfaceC3423t != null) {
                interfaceC3423t.mo22834g(OplusGLSurfaceView_13);
            }
            OneCamera interfaceC2694d = this.mOneCamera;
            if (interfaceC2694d == null) {
                CameraLog.m12967f(TAG, "onFaceBeautyItemChange, failed, mOneCamera is null !");
            } else {
                interfaceC2694d.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FACE_BEAUTY_ENABLE, (CameraParameter.PreviewKey<String>) (OplusGLSurfaceView_13 != 0 ? "on" : "off"));
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    protected boolean updateFaceBeautyValue(int OplusGLSurfaceView_13) {
        if (this.mPreferences == null || getFaceBeautyKey() == null) {
            CameraLog.m12966e(TAG, "updateFaceBeautyValue, mPreferences: " + this.mPreferences + ", key: " + getFaceBeautyKey());
            return false;
        }
        this.mPreferences.edit().putInt(getFaceBeautyKey(), OplusGLSurfaceView_13).apply();
        CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface == null) {
            return true;
        }
        cameraUIInterface.mo18230j(OplusGLSurfaceView_13);
        return true;
    }

    protected void updateFaceBeautyLevel(int OplusGLSurfaceView_13, boolean z) {
        if (this.mOneCamera != null) {
            if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
                if (isMultiVideoMode()) {
                    ((OneCameraProxy) this.mOneCamera).m13227a(OplusGLSurfaceView_13, 2);
                    return;
                } else {
                    this.mOneCamera.mo13099h(OplusGLSurfaceView_13);
                    return;
                }
            }
            this.mOneCamera.mo13099h(0);
        }
    }

    private int getFaceBeautyMenuIndex() {
        int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
        return getSupportFunction(CameraUIInterface.KEY_BEAUTY3D) ? faceBeautyCurrIndex + 1 : faceBeautyCurrIndex;
    }

    public String getCurrFilterType() {
        return getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS) ? getFilterType(getCurrFilterIndex()) : "default";
    }

    public int getCurrFilterIndex() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            return FilterHelper.f21279a;
        }
        return Util.m24205a(sharedPreferences.getInt(getFilterEffectMenuPreferenceKey(), getFilterNoneIndex()), 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    protected void onFilterItemChange(int OplusGLSurfaceView_13) {
        onFilterItemChange(OplusGLSurfaceView_13, false);
    }

    protected void onFilterItemChange(int OplusGLSurfaceView_13, boolean z) {
        if (!z) {
            updateFilterParam(OplusGLSurfaceView_13);
        }
        String filterEffectMenuPreferenceKey = getFilterEffectMenuPreferenceKey();
        int i2 = this.mPreferences.getInt(filterEffectMenuPreferenceKey, FilterHelper.f21279a);
        this.mPreferences.edit().putInt(filterEffectMenuPreferenceKey, OplusGLSurfaceView_13).apply();
        CameraLog.m12959b(TAG, "onFilterItemChange, key: " + filterEffectMenuPreferenceKey + ", previousIndex: " + i2 + ", currentIndex: " + OplusGLSurfaceView_13);
        if (this.mCameraUIInterface != null) {
            String effectMenuKeyByMode = getEffectMenuKeyByMode();
            this.mCameraUIInterface.mo18197d(effectMenuKeyByMode, OplusGLSurfaceView_13 != FilterHelper.f21279a ? 1 : 0);
            if (i2 == FilterHelper.f21279a && OplusGLSurfaceView_13 != FilterHelper.f21279a && !isMicroscopeMode()) {
                this.mCameraUIInterface.mo18170b(effectMenuKeyByMode, R.drawable.menu_effect_on_light);
            } else {
                int i3 = FilterHelper.f21279a;
                int i4 = R.drawable.menu_effect_off_selector;
                if (i2 != i3 && OplusGLSurfaceView_13 == FilterHelper.f21279a && !isMicroscopeMode()) {
                    if (this.mCameraUIInterface.mo18023A()) {
                        i4 = R.drawable.menu_effect_off_light_selector;
                    }
                    this.mCameraUIInterface.mo18170b(effectMenuKeyByMode, i4);
                } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER) && !FilterHelper.f21312b.equalsIgnoreCase(MediaInfo.RENDERER_TYPE_NONE) && !this.mPreferences.getBoolean(CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, false) && getSupportFunction(CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
                    this.mCameraUIInterface.mo18170b(effectMenuKeyByMode, R.drawable.menu_effect_grandtour_recommend);
                } else if (i2 == FilterHelper.f21279a && OplusGLSurfaceView_13 == FilterHelper.f21279a) {
                    this.mCameraUIInterface.mo18170b(effectMenuKeyByMode, R.drawable.menu_effect_off_selector);
                }
            }
            this.mCameraUIInterface.mo18230j(OplusGLSurfaceView_13);
        }
    }

    public String getEffectMenuKeyByMode() {
        return CameraEntry.m13299b(CameraUIInterface.KEY_FILTER_MENU, this.mCameraEntryType);
    }

    public String getBlurMenuKeyByMode() {
        return CameraEntry.m13299b(CameraUIInterface.KEY_VIDEO_BLUR_MENU, this.mCameraEntryType);
    }

    protected void updateFlashState(String str) {
        updateFlashState(str, true);
    }

    public void updateFlashState(String str, boolean z) {
        if ("on".equals(str) && needUpdateFlashIcon()) {
            if (this.mCameraUIInterface.mo18233k().m18494b() && (CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d()) || CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.mo18233k().m18498d()))) {
                this.mCameraUIInterface.mo18108a(false, true, false);
                this.mCameraUIInterface.mo18070a(R.string.hint_flash_on, -1, true, true, false);
            }
        } else if ("auto".equals(str)) {
            if (!isOpenFlash()) {
                this.mCameraUIInterface.mo18108a(false, true, true);
            }
            if (this.mCameraUIInterface.mo18233k().m18494b() && (CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d()) || CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.mo18233k().m18498d()))) {
                this.mbFirstShowAfterAuto = true;
                this.mCameraUIInterface.mo18108a(false, true, false);
                this.mCameraUIInterface.mo18070a(R.string.hint_flash_auto, -1, true, true, false);
            }
            if (this.mbAutoFlash && needUpdateFlashIcon() && isOpenFlash()) {
                this.mCameraUIInterface.mo18070a(-1, R.drawable.flash_hint_icon, false, true, false);
            }
        } else if (CameraParameter.FlashMode.FLASH_TORCH.equals(str)) {
            if (!isMicroscopeMode() && needUpdateFlashIcon() && this.mCameraUIInterface.mo18233k().m18494b() && (CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d()) || CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.mo18233k().m18498d()))) {
                this.mCameraUIInterface.mo18108a(false, true, false);
                this.mCameraUIInterface.mo18070a(R.string.hint_flash_torch, -1, true, true, false);
            }
        } else {
            if ("off".equals(str)) {
                setAutoFlash(false);
                if (this.mCameraUIInterface.mo18233k().m18494b() && (CameraUIInterface.KEY_FLASH_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d()) || CameraUIInterface.KEY_FLASH_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.mo18233k().m18498d()))) {
                    this.mCameraUIInterface.mo18108a(false, true, false);
                    this.mCameraUIInterface.mo18070a(R.string.hint_flash_off, -1, true, true, false);
                }
            }
            if (!isOpenHDR()) {
                this.mCameraUIInterface.mo18108a(false, true, true);
            }
        }
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13069b(str);
            if (z) {
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    private boolean updateMenuWithFlashChange() {
        String string;
        if (this.mbFrontCamera) {
            string = this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity));
        } else {
            string = this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value));
        }
        String string2 = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (!"off".equals(string) && "on".equals(string2)) {
            editorEdit.putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
            editorEdit.apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_CAMERA_HDR_MODE);
            return true;
        }
        if ((!CameraParameter.FlashMode.FLASH_TORCH.equals(string) && !"on".equals(string)) || !"auto".equals(string2)) {
            return false;
        }
        editorEdit.putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
        editorEdit.apply();
        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_CAMERA_HDR_MODE);
        return true;
    }

    private boolean updateMenuWithSoftLightChange() {
        if (!getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT)) {
            return true;
        }
        String string = this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value));
        String string2 = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId));
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (!"off".equals(string) && "on".equals(string2)) {
            editorEdit.putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
            editorEdit.apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_CAMERA_HDR_MODE);
            return true;
        }
        if (!"on".equals(string) || !"auto".equals(string2)) {
            return false;
        }
        editorEdit.putString(CameraUIInterface.KEY_CAMERA_HDR_MODE, "off");
        editorEdit.apply();
        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_CAMERA_HDR_MODE);
        return true;
    }

    private void setHDRMenuVisibility(boolean z) {
        CameraLog.m12959b(TAG, "setHDRMenuVisibility(), flag: " + z + ", mCameraUIInterface: " + this.mCameraUIInterface);
        CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface == null) {
            return;
        }
        if (z) {
            cameraUIInterface.mo18171b(CameraUIInterface.KEY_CAMERA_HDR_MODE, (String) null);
            this.mCameraUIInterface.mo18196d(CameraUIInterface.KEY_CAMERA_HDR_MODE);
        } else {
            cameraUIInterface.mo18204e(CameraUIInterface.KEY_CAMERA_HDR_MODE);
        }
    }

    private void updateFlashMenuIfHDRIsAuto(boolean z) {
        String str;
        String str2;
        if (this.mPreferences == null) {
            CameraLog.m12954a(TAG, "updateFlashMenuIfHDRIsAuto null  == mPreferences");
            return;
        }
        if (z) {
            str = CameraUIInterface.KEY_TORCH_MODE;
            str2 = "off";
        } else {
            str = CameraUIInterface.KEY_FLASH_MODE;
            str2 = "auto";
        }
        String strM13305d = CameraEntry.m13305d(str);
        String string = this.mPreferences.getString(strM13305d, str2);
        CameraLog.m12954a(TAG, "updateFlashMenuIfHDRIsAuto, flashMode: " + string);
        if ("on".equals(string) || CameraParameter.FlashMode.FLASH_TORCH.equals(string)) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(strM13305d, "off");
            editorEdit.apply();
            CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
            if (cameraUIInterface != null) {
                cameraUIInterface.mo18211f(strM13305d);
            }
        }
    }

    private void updateMenuWithHDRChange(boolean z) {
        CameraLog.m12954a(TAG, "updateMenuWithHDRChange(), enable: " + z);
        if (this.mCameraUIInterface != null && z) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            if (this.mbFrontCamera) {
                String strM13305d = CameraEntry.m13305d(CameraUIInterface.KEY_TORCH_MODE);
                editorEdit.putString(strM13305d, "off");
                editorEdit.apply();
                this.mCameraUIInterface.mo18211f(strM13305d);
                return;
            }
            editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
            editorEdit.apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
        }
    }

    public void setAutoFlash(boolean z) {
        if (this.mbAutoFlash != z) {
            this.mbAutoFlash = z;
            OneCamera interfaceC2694d = this.mOneCamera;
            if (interfaceC2694d != null) {
                interfaceC2694d.mo13084d(z);
            }
        }
    }

    private void updateHDRMode(String str, boolean z) {
        CameraLog.m12954a(TAG, "updateHDRMode, value: " + str + ", update: " + z);
        if (this.mOneCamera != null) {
            if ("close".equals(str)) {
                this.mOneCamera.mo13079c("off");
            } else {
                this.mOneCamera.mo13079c(str);
            }
            if (z) {
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
        }
    }

    public boolean isTrackFocusOpen() {
        return this.mbTrackFocusOpen;
    }

    public Size getTrackHalAlgoSize() {
        return getPreviewSize(this.mOneCamera.mo13086e());
    }

    public boolean isVividEffectOpen() {
        if (!getSupportFunction(CameraUIInterface.KEY_VIVID_EFFECT)) {
            return false;
        }
        SharedPreferences sharedPreferences = this.mPreferences;
        return "on".equals(sharedPreferences != null ? sharedPreferences.getString(CameraUIInterface.KEY_VIVID_EFFECT, this.mActivity.getString(R.string.camera_vivid_effect_off)) : "off");
    }

    public void forceCloseVividEffect() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_VIVID_EFFECT, this.mActivity.getString(R.string.camera_vivid_effect_off));
            editorEdit.commit();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIVID_EFFECT);
        }
    }

    protected void updateFilterParam(int OplusGLSurfaceView_13) {
        if (this.mPreviewEffectProcess != null) {
            if (isVividEffectOpen() && OplusGLSurfaceView_13 != FilterHelper.f21279a) {
                forceCloseVividEffect();
            }
            String filterType = getFilterType(Math.min(OplusGLSurfaceView_13, FilterHelper.f21279a));
            OneCamera interfaceC2694d = this.mOneCamera;
            if (interfaceC2694d != null) {
                interfaceC2694d.mo13046a(filterType, isFilterOpen(filterType), getSupportFunction(CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(getFilterType(OplusGLSurfaceView_13)));
            }
            this.mPreviewEffectProcess.mo22792a(getFilterType(OplusGLSurfaceView_13));
            return;
        }
        CameraLog.m12967f(TAG, "updateFilterParam, mPreviewEffectProcess: " + this.mPreviewEffectProcess + ", mPreferences: " + this.mPreferences);
    }

    public void updateAISceneMode() {
        if (this.mOneCamera == null) {
            CameraLog.m12966e(TAG, "updateAISceneMode failed");
            return;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            boolean zIsPIAISceneOpen = isPIAISceneOpen();
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.AI_PHOTO, (CameraParameter.PreviewKey<String>) (zIsPIAISceneOpen ? "on" : "off"));
            this.mOneCamera.mo13123p(this.mCameraUIInterface.mo18137aa());
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SECNES_FORCE_ATHENA) && zIsPIAISceneOpen && getSupportFunction(CameraUIInterface.KEY_PI_AI)) {
                Util.m24168C(this.mActivity);
            }
        }
        if (isAISceneOpen()) {
            this.mOneCamera.mo13087e(1);
        } else {
            this.mOneCamera.mo13087e(0);
        }
    }

    public void updatePIMode() {
        if (this.mOneCamera == null) {
            CameraLog.m12966e(TAG, "updatePIMode failed");
        } else {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                return;
            }
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.AI_PHOTO, (CameraParameter.PreviewKey<String>) (isPIModeOpen() ? "on" : "off"));
        }
    }

    private void setCurTemperatureToHAL() throws NumberFormatException {
        if (this.mOneCamera == null || this.mPreferences == null || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TEMPERATURE_SEND_TO_HAL) || !needSetMakeupToAlgo()) {
            return;
        }
        float COUIBaseListPopupWindow_12 = this.mPreferences.getFloat(CameraUIInterface.KEY_CURRENT_TEMPERATURE, SYSTEM_BRIGHTNESS);
        String string = this.mActivity.getSharedPreferences("rom_update_info", 0).getString("com.oplus.phone.max.temperature", "");
        float f2 = 39.0f;
        if (!"".equals(string)) {
            try {
                f2 = Float.parseFloat(string);
            } catch (NumberFormatException COUIBaseListPopupWindow_8) {
                CameraLog.m12967f(TAG, "setCurTemperatureToHAL, parse tempThresholdStr error: " + COUIBaseListPopupWindow_8);
            }
        }
        if (SYSTEM_BRIGHTNESS != COUIBaseListPopupWindow_12) {
            this.mOneCamera.mo13022a(COUIBaseListPopupWindow_12, f2);
            return;
        }
        CameraLog.m12959b(TAG, "setCurTemperatureToHAL, failed with curTemperature: " + COUIBaseListPopupWindow_12);
    }

    private void setSloganEnable() {
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"))) {
            return;
        }
        if (this.mOneCamera == null) {
            CameraLog.m12966e(TAG, "setSloganEnable failed");
        } else if (getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            this.mOneCamera.mo13104j(1);
        } else {
            this.mOneCamera.mo13104j(0);
        }
    }

    public final DcsMsgData getBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        CameraLog.m12959b(TAG, "getBeforeCaptureMsgCommonData");
        dcsMsgData.mScreenBrightness = this.mSysBrightness;
        if (dcsMsgData instanceof CaptureMsgData) {
            String strM24248a = Util.m24248a(getPictureSize(this.mOneCamera.mo13086e()), this.mCameraId);
            if ("16_9".equals(strM24248a)) {
                strM24248a = "16:9";
            } else if (DcsMsgData.FULL.equals(strM24248a)) {
                if (Util.m24451g() == 0) {
                    strM24248a = "second_full";
                } else if (1 == Util.m24451g()) {
                    strM24248a = "15_14";
                }
            }
            ((CaptureMsgData) dcsMsgData).mPicSizeType = strM24248a;
        }
        CameraLog.m12959b(TAG, "getBeforeCaptureMsgCommonData X");
        return onGetBeforeCaptureMsgCommonData(dcsMsgData);
    }

    public final DcsMsgData getAfterCaptureMsgCommonData(DcsMsgData dcsMsgData, Storage.CameraPicture cameraPicture) {
        return onGetAfterCaptureMsgCommonData(dcsMsgData, cameraPicture);
    }

    protected String getFilterType(int OplusGLSurfaceView_13) {
        return getFilterTypeList(this.mCameraId).get(OplusGLSurfaceView_13);
    }

    public boolean isFlashRequired() {
        if (getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && "on".equals(getRearFlashMode())) {
            return true;
        }
        if (isAutoFlash() && this.mbAutoFlash) {
            return true;
        }
        if (!isOpenFrontTorch() || getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT)) {
            return isAutoFrontTorch() && this.mbAutoFlash && !getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT);
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
        if (!getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
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
            CameraLog.m12954a(TAG, "isOpenFlash mPreferences is equal null ");
            return false;
        }
        if (isMultiVideoMode() && CameraParameter.FlashMode.FLASH_TORCH.equals(getFlashMode())) {
            return true;
        }
        return ("on".equals(getFlashMode()) || CameraParameter.FlashMode.FLASH_TORCH.equals(getFlashMode())) && !this.mbFrontCamera;
    }

    protected boolean isAutoFlash() {
        if (this.mPreferences != null) {
            return "auto".equals(getFlashMode()) && !this.mbFrontCamera;
        }
        CameraLog.m12954a(TAG, "isAutoFlash mPreferences is equal null ");
        return false;
    }

    protected boolean isAutoFrontTorch() {
        SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null && "auto".equals(sharedPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity))) && getSupportFunction(CameraUIInterface.KEY_TORCH_MODE);
    }

    protected boolean isOpenFrontTorch() {
        SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity))) && getSupportFunction(CameraUIInterface.KEY_TORCH_MODE);
    }

    public boolean isAutoHDR() {
        return this.mPreferences != null && getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE) && "auto".equals(this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId)));
    }

    public boolean isOpenHDR() {
        SharedPreferences sharedPreferences = this.mPreferences;
        return sharedPreferences != null && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_CAMERA_HDR_MODE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraId))) && getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE);
    }

    public boolean isHDRSceneModeInAuto() {
        return this.mbAutoHDR;
    }

    protected String getHDRKey() {
        return CameraEntry.m13299b(CameraUIInterface.KEY_CAMERA_HDR_MODE, this.mCameraEntryType);
    }

    protected String getHDRModeValue(String str) {
        return this.mPreferences.getString(str, getDefaultHDRValue());
    }

    protected String getDefaultHDRValue() {
        return CameraConfig.getOptionKeyDefaultValue(CameraEntry.m13305d(getHDRKey()), this.mCameraId);
    }

    protected boolean isVideoHdrOpen() {
        if (getSupportMenu(CameraFunction.VIDEO_HDR)) {
            return "on".equals(getHDRModeValue(getHDRKey())) || "auto".equals(getHDRModeValue(getHDRKey()));
        }
        return false;
    }

    public void displayScreenHintIconInSwitchOn() {
        CameraLog.m12954a(TAG, "displayScreenHintIconInSwitchOn, isOpenFrontTorch: " + isOpenFrontTorch() + ", isOpenFlash: " + isOpenFlash());
        if (getBeauty3Dstatus() != 0) {
            CameraLog.m12954a(TAG, "displayScreenHintIconInSwitchOn, beauty3DMode");
            return;
        }
        if (this.mCameraUIInterface.mo18057R()) {
            return;
        }
        if (!isPIAISceneOpen() || this.mCameraInterface.mo10576j() == 0) {
            if ((isOpenFrontTorch() || isFlashState() || isHDRState()) && !this.mbShowPostCaptureAlert && !this.mbBurstShot) {
                if (!isHDRState()) {
                    if ("auto".equals(getFlashMode())) {
                        this.mCameraUIInterface.mo18070a(-1, getFrontFlashHintDrawable(), false, true, false);
                        return;
                    }
                    return;
                } else {
                    if (isAutoHDR() && this.mbAutoHDR) {
                        if (getSupportFunction(CameraFunction.VIDEO_HDR)) {
                            this.mCameraUIInterface.mo18070a(-1, R.drawable.hdr_hint_icon_3hdr, false, true, false);
                            return;
                        } else {
                            this.mCameraUIInterface.mo18070a(-1, R.drawable.hdr_hint_icon, false, true, false);
                            return;
                        }
                    }
                    return;
                }
            }
            this.mCameraUIInterface.mo18108a(false, true, true);
        }
    }

    public void displayAllIcon(boolean z, boolean z2) {
        if (getBeauty3Dstatus() != 0) {
            CameraLog.m12954a(TAG, "displayAllIcon, beauty3DMode");
            return;
        }
        if (this.mCameraUIInterface.mo18057R()) {
            return;
        }
        if (z) {
            if (getSupportFunction(CameraFunction.VIDEO_HDR)) {
                this.mCameraUIInterface.mo18070a(-1, R.drawable.hdr_hint_icon_3hdr, false, false, false);
                return;
            } else {
                this.mCameraUIInterface.mo18070a(-1, R.drawable.hdr_hint_icon, false, false, false);
                return;
            }
        }
        if (z2) {
            if (this.mbBurstShot) {
                return;
            }
            if (isAutoFlash() || isAutoFrontTorch()) {
                this.mCameraUIInterface.mo18070a(-1, R.drawable.flash_hint_icon, false, true, false);
                return;
            } else {
                if (isOpenHDR()) {
                    return;
                }
                this.mCameraUIInterface.mo18108a(false, true, true);
                return;
            }
        }
        this.mCameraUIInterface.mo18108a(false, true, true);
    }

    protected String getExif(CameraPictureCallback.CameraPictureResult cameraPictureResult) {
        int iM13773a = C2735b.m13773a(getExifCameraMode(), this.mCameraId);
        int jpegOrientation = getJpegOrientation(getProperCameraId(this.mCameraId), this.mCaptureOrientation);
        if (jpegOrientation > 0) {
            iM13773a |= 32;
        }
        if (getFaceBeautyCurrIndex() > 0) {
            iM13773a |= 2;
        }
        if (isUltraHighResolutionOpened()) {
            iM13773a |= 8192;
        }
        if (isBlurOpen()) {
            iM13773a |= 16;
        }
        if (getCurrFilterIndex() != FilterHelper.f21279a) {
            iM13773a |= 1024;
        }
        if (cameraPictureResult != null && "1".equals(cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_SUPER_TEXT_ENABLE))) {
            iM13773a |= 4096;
        }
        CameraLog.m12959b(TAG, "getExif, exif: " + iM13773a + ", jpegOrientation: " + jpegOrientation);
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13144w(iM13773a);
        }
        return OplusExifTag.EXIF_TAG_PREFIX + iM13773a;
    }

    protected String getExifCameraMode() {
        return getCameraMode();
    }

    protected void applyBeautyParam() {
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
            int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
            CameraLog.m12954a(TAG, "applyBeautyParam, index: " + faceBeautyCurrIndex);
            updateFaceBeautyLevel(faceBeautyCurrIndex, false);
            updateCustomBeautyValues(getCustomBeautyValues());
            PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
            if (interfaceC3423t != null) {
                interfaceC3423t.mo22834g(faceBeautyCurrIndex);
                this.mPreviewEffectProcess.mo22798a(getCustomBeautyValues());
                return;
            }
            return;
        }
        updateFaceBeautyLevel(0, false);
        PreviewEffectProcess interfaceC3423t2 = this.mPreviewEffectProcess;
        if (interfaceC3423t2 != null) {
            interfaceC3423t2.mo22834g(0);
        }
    }

    protected int getDefaultCommonBeautyValue() {
        if (!isFaceBeautyDefaultOff() && this.mbFrontCamera) {
            return getFrontDefaultCommonBeautyValue();
        }
        return 0;
    }

    protected int[] getDefaultCustomBeautyValues() {
        return f13116a;
    }

    protected boolean isMakeupOpen() {
        return getSupportFunction(CameraUIInterface.KEY_SUPPORT_MAKEUP) && getCurrMakeupIndex() != 0;
    }

    protected List getMakeupTypeList() {
        return FaceBeautyHelp.f21227b;
    }

    protected int[] getDefaultMakeupValues() {
        return FaceBeautyHelp.f21226a;
    }

    protected int getCurrMakeupIndex() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(getMakeupTypeKey(), getDefaultMakeupIndex());
        }
        return getDefaultMakeupIndex();
    }

    protected boolean getSupportShowCustomAll() {
        return !getSupportFunction(CameraUIInterface.KEY_SUPPORT_MAKEUP);
    }

    protected String getMakeupType(int OplusGLSurfaceView_13) {
        return (String) getMakeupTypeList().get(OplusGLSurfaceView_13);
    }

    protected int getMakeupItemValue(int OplusGLSurfaceView_13) {
        SharedPreferences sharedPreferences;
        CameraLog.m12954a(TAG, "getMakeupItemValue, index: " + OplusGLSurfaceView_13);
        if (getMakeupKeys() != null && (sharedPreferences = this.mPreferences) != null) {
            return sharedPreferences.getInt(getMakeupKeys()[OplusGLSurfaceView_13], getDefaultMakeupValues()[OplusGLSurfaceView_13]);
        }
        return getDefaultMakeupValues()[OplusGLSurfaceView_13];
    }

    protected void onMakeupTypeChanged(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a(TAG, "onMakeupTypeChanged, index: " + OplusGLSurfaceView_13);
        int currMakeupIndex = getCurrMakeupIndex();
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22812b(getMakeupType(OplusGLSurfaceView_13));
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getMakeupTypeKey(), OplusGLSurfaceView_13);
        editorEdit.apply();
        if ((currMakeupIndex != 0 || OplusGLSurfaceView_13 == 0) && (currMakeupIndex == 0 || OplusGLSurfaceView_13 != 0)) {
            return;
        }
        Util.m24416c(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$kEpe0TB9SBzpTd2qO2Rr3OcEOxY
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.lambda$onMakeupTypeChanged$1$BaseMode();
            }
        });
    }

    public /* synthetic */ void lambda$onMakeupTypeChanged$1$BaseMode() {
        this.mCameraInterface.mo10546av();
    }

    protected void onMakeupValueChanged(int OplusGLSurfaceView_13, int i2, boolean z) {
        CameraLog.m12959b(TAG, "onMakeupValueChanged, index: " + OplusGLSurfaceView_13 + ", value: " + i2 + ", update: " + z);
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22837h(i2);
        }
        if (!z || this.mPreferences == null || getMakeupKeys() == null || OplusGLSurfaceView_13 == -3) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getMakeupKeys()[OplusGLSurfaceView_13], i2);
        editorEdit.apply();
    }

    protected String[] getCurrentKeys(String[] strArr) {
        if (!CameraEntry.m13302b(this.mCameraEntryType)) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr2.length; OplusGLSurfaceView_13++) {
            strArr2[OplusGLSurfaceView_13] = CameraEntry.m13299b(strArr[OplusGLSurfaceView_13], this.mCameraEntryType);
        }
        return strArr2;
    }

    protected String[] getCurrentKeys(List<String> list) {
        if (CameraEntry.m13302b(this.mCameraEntryType)) {
            String[] strArr = new String[list.size()];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
                strArr[OplusGLSurfaceView_13] = CameraEntry.m13299b(list.get(OplusGLSurfaceView_13), this.mCameraEntryType);
            }
            return strArr;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    protected int[] getCustomBeautyValues() {
        String[] customBeautyKeys = getCustomBeautyKeys();
        if (customBeautyKeys == null) {
            CameraLog.m12966e(TAG, "getCustomBeautyValues, customBeautyKeys null");
            return null;
        }
        int[] iArr = new int[customBeautyKeys.length];
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < customBeautyKeys.length; OplusGLSurfaceView_13++) {
                SharedPreferences sharedPreferences = this.mPreferences;
                if (sharedPreferences != null) {
                    iArr[OplusGLSurfaceView_13] = sharedPreferences.getInt(customBeautyKeys[OplusGLSurfaceView_13], getDefaultCustomBeautyValues()[OplusGLSurfaceView_13]);
                } else {
                    iArr[OplusGLSurfaceView_13] = getDefaultCustomBeautyValues()[OplusGLSurfaceView_13];
                }
            }
        } else if (getSupportFunction(CameraFunction.FACE_BEAUTY_COMMON)) {
            SharedPreferences sharedPreferences2 = this.mPreferences;
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
        OneCamera interfaceC2694d;
        if ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NEED_HAL_HANDING_FACE_BEAUTY) && Util.m24169C()) || (interfaceC2694d = this.mOneCamera) == null || iArr == null) {
            return;
        }
        interfaceC2694d.mo13058a(Util.m24311a(iArr));
    }

    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure c2614af = new ZoomConfigure();
        c2614af.f12308a = isVideoHighFps();
        c2614af.f12309b = is4k();
        c2614af.m11326a(isCaptureModeType());
        c2614af.m11331b(isSatOpen());
        c2614af.m11334c(isNoneSatUltraWideAngleOpen());
        if (isNoneSatUltraWideAngleOpen()) {
            c2614af.m11324a(CameraCharacteristicsUtil.m12971a(getCameraMode(), CameraCharacteristicsUtil.m12985h()).m13270e());
        }
        c2614af.m11340f(getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE));
        c2614af.m11342g(getSupportFunction(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE));
        c2614af.m11354m(this.mbFrontCamera);
        c2614af.m11360p(getSupportFunction(CameraUIInterface.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE));
        c2614af.m11308G(isTiltShiftOpen());
        c2614af.m11336d(isStreetOpen());
        return c2614af;
    }

    public String getGuideLineType() {
        String guideLineKey = getGuideLineKey();
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null || guideLineKey == null) {
            return null;
        }
        return sharedPreferences.getString(guideLineKey, null);
    }

    public long getCaptureDate() {
        return this.mCaptureDate;
    }

    public FilterTexturePreview.PlatformImplementations.kt_3 getFilterCategory() {
        return FilterTexturePreview.PlatformImplementations.kt_3.Polarr;
    }

    public boolean needShow10bitHint() {
        return is10bitsHeicEncodeEnable();
    }

    public boolean supportBeautyButton() {
        return getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS) || getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS) || getSupportFunction(CameraUIInterface.KEY_FILTER_MENU) || getSupportFunction(CameraUIInterface.KEY_FILTER_MENU_UPDATED) || getSupportFunction(CameraUIInterface.KEY_VIDEO_FILTER_MENU) || getSupportFunction(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU) || getSupportFunction(CameraUIInterface.KEY_NIGHT_FILTER_MENU) || getSupportFunction(CameraUIInterface.KEY_FUJI_FILTER_MENU);
    }

    public boolean showBeautyButton() {
        return supportBeautyButton();
    }

    public boolean showMenuLeftButton() {
        return supportMenuLeftButton();
    }

    public boolean supportMenuLeftButton() {
        return getSupportFunction(CameraUIInterface.KEY_VIDEO_BLUR_MENU) || getSupportFunction(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU) || getSupportFunction(CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU) || getSupportFunction(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU) || getSupportFunction(CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU);
    }

    public void onUiModeChanged() {
        CameraLog.m12954a(TAG, "onUiModeChanged");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
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
            r7.mo18070a(r8, r9, r10, r11, r12)
            goto L9b
        L57:
            com.oplus.camera.ui.CameraUIInterface r0 = r13.mCameraUIInterface
            r1 = 2131756483(0x7f1005c3, float:1.9143875E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.mo18070a(r1, r2, r3, r4, r5)
            goto L9b
        L64:
            com.oplus.camera.ui.CameraUIInterface r1 = r13.mCameraUIInterface
            int r1 = r1.mo18134aX()
            if (r1 == 0) goto L82
            com.oplus.camera.ui.CameraUIInterface r1 = r13.mCameraUIInterface
            int r1 = r1.mo18134aX()
            if (r6 != r1) goto L75
            goto L82
        L75:
            com.oplus.camera.ui.CameraUIInterface r7 = r13.mCameraUIInterface
            r8 = 2131756482(0x7f1005c2, float:1.9143873E38)
            r9 = -1
            r10 = 1
            r11 = 0
            r12 = 0
            r7.mo18070a(r8, r9, r10, r11, r12)
            goto L9b
        L82:
            com.oplus.camera.ui.CameraUIInterface r0 = r13.mCameraUIInterface
            r1 = 2131756486(0x7f1005c6, float:1.914388E38)
            r2 = -1
            r3 = 1
            r4 = 0
            r5 = 0
            r0.mo18070a(r1, r2, r3, r4, r5)
            goto L9b
        L8f:
            com.oplus.camera.ui.CameraUIInterface r6 = r13.mCameraUIInterface
            r7 = 2131756485(0x7f1005c5, float:1.9143879E38)
            r8 = -1
            r9 = 1
            r10 = 0
            r11 = 0
            r6.mo18070a(r7, r8, r9, r10, r11)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.BaseMode.showPictureSizeHint(java.lang.String):void");
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        SharedPreferences sharedPreferences2;
        String strM13305d = CameraEntry.m13305d(str);
        if (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_PHOTO_RATIO) || this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_PHOTO_RATIO_FROM_OTHER_APP)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
            this.mCameraUIInterface.mo18233k().m18491b(Util.m24211a(string));
            if (!Util.m24495t()) {
                showPictureSizeHint(string);
            }
        }
        if ((this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER) || this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER_FROM_OTHER_APP)) && (sharedPreferences2 = this.mPreferences) != null) {
            String string2 = sharedPreferences2.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(R.string.camera_shutter_mode_default_value));
            if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string2)) {
                this.mCameraUIInterface.mo18070a(R.string.hint_countdown_10, -1, true, false, false);
            } else if ("3".equals(string2)) {
                this.mCameraUIInterface.mo18070a(R.string.hint_countdown_3, -1, true, false, false);
            } else {
                this.mCameraUIInterface.mo18070a(R.string.hint_countdown_off, -1, true, false, false);
            }
        }
        if (CameraUIInterface.KEY_FLASH_MODE.equals(strM13305d)) {
            String string3 = sharedPreferences.getString(CameraEntry.m13299b(CameraUIInterface.KEY_FLASH_MODE, this.mCameraEntry.m13317J()), this.mActivity.getString(R.string.camera_flash_mode_default_value));
            CameraLog.m12954a(TAG, "onSharedPreferenceChanged, flashMode: " + string3 + ", mbAutoFlash: " + this.mbAutoFlash);
            if (Camera.f10610l || Camera.f10611m) {
                this.mbNeedReloadFlashMenu = true;
                if (!"off".equals(string3)) {
                    SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                    editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
                    editorEdit.apply();
                    this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
                } else {
                    setAutoFlash(false);
                    displayAllIcon(this.mbAutoHDR, this.mbAutoFlash);
                    if (Camera.f10611m) {
                        this.mCameraUIInterface.mo18070a(R.string.camera_high_temperature_flash_disable, -1, true, false, false);
                    } else if (Camera.f10610l) {
                        this.mCameraUIInterface.mo18070a(R.string.camera_low_battery_flash_disable, -1, true, false, false);
                    }
                }
            } else {
                updateFlashState(string3);
                updateMenuWithFlashChange();
            }
        }
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(strM13305d)) {
            updateInversePositionRatio(true);
        }
        if (CameraUIInterface.KEY_TORCH_MODE.equals(strM13305d)) {
            if (getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT) && (Camera.f10610l || Camera.f10611m)) {
                this.mbNeedReloadFlashMenu = true;
                setAutoFlash(false);
                displayAllIcon(this.mbAutoHDR, this.mbAutoFlash);
                if (!"off".equals(sharedPreferences.getString(strM13305d, "off"))) {
                    if (Camera.f10611m) {
                        this.mCameraUIInterface.mo18070a(R.string.camera_high_temperature_flash_disable, -1, true, false, false);
                    } else if (Camera.f10610l) {
                        this.mCameraUIInterface.mo18070a(R.string.camera_low_battery_flash_disable, -1, true, false, false);
                    }
                    SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
                    editorEdit2.putString(CameraUIInterface.KEY_TORCH_MODE, "off");
                    editorEdit2.apply();
                    this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_TORCH_MODE);
                }
            } else {
                String string4 = sharedPreferences.getString(strM13305d, "off");
                if ("on".equals(string4)) {
                    this.mCameraUIInterface.mo18108a(false, true, true);
                    if (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE)) {
                        this.mCameraUIInterface.mo18070a(R.string.hint_flash_torch, -1, true, true, false);
                    } else if (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.mo18070a(R.string.hint_flash_on, -1, true, true, false);
                    }
                } else if ("auto".equals(string4)) {
                    if (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE) || this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.mo18070a(R.string.hint_flash_auto, -1, true, true, false);
                    }
                    if (this.mbAutoFlash) {
                        this.mCameraUIInterface.mo18070a(-1, R.drawable.flash_hint_icon, false, true, false);
                    } else {
                        this.mCameraUIInterface.mo18108a(false, true, true);
                    }
                } else if (CameraParameter.FlashMode.FLASH_TORCH.equals(string4)) {
                    this.mCameraUIInterface.mo18108a(false, true, true);
                    if (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE) || this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.mo18070a(R.string.hint_flash_torch, -1, true, true, false);
                    }
                } else {
                    this.mCameraUIInterface.mo18108a(false, true, true);
                    if (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE) || this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_TORCH_MODE_FROM_OTHER_APP)) {
                        this.mCameraUIInterface.mo18070a(R.string.hint_flash_off, -1, true, true, false);
                    }
                }
                if (getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT)) {
                    updateMenuWithSoftLightChange();
                } else {
                    updateMenuWithFlashChange();
                }
                if (this.mOneCamera != null) {
                    if (getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT) && "on".equals(string4)) {
                        string4 = CameraParameter.FlashMode.FLASH_TORCH;
                    }
                    if (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE) && "on".equals(string4) && InverseManager.INS.isInverseAble(this.mActivity)) {
                        string4 = CameraParameter.FlashMode.FLASH_TORCH;
                    }
                    if (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE) && "auto".equals(string4) && InverseManager.INS.isInverseAble(this.mActivity)) {
                        this.mOneCamera.mo13080c(true);
                    } else {
                        this.mOneCamera.mo13080c(false);
                    }
                    this.mOneCamera.mo13069b(string4);
                    this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
            }
        }
        if (CameraUIInterface.KEY_VIVID_EFFECT.equals(strM13305d) && isVividEffectOpen() && isFilterEffectOpen()) {
            onFilterItemChange(FilterHelper.f21279a);
            if (MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.mo18188c(this.mActivity.getString(R.string.camera_filter_none), FilterHelper.f21279a);
            }
        }
        if ("slow_video_high_frame_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("slow_video_high_frame_reddot_show", true)) {
            this.mCameraUIInterface.mo18246n(2);
        }
        if ("id_photo_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("id_photo_reddot_show", false)) {
            this.mCameraUIInterface.mo18246n(13);
        }
        if ("fish_eye_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("fish_eye_reddot_show", true)) {
            this.mCameraUIInterface.mo18246n(29);
        }
        if ("microscope_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("microscope_reddot_show", true)) {
            this.mCameraUIInterface.mo18246n(16);
        }
        if ("multi_video_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("multi_video_reddot_show", false)) {
            this.mCameraUIInterface.mo18246n(14);
        }
        if ("mode_high_pixel_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("mode_high_pixel_reddot_show", true)) {
            this.mCameraUIInterface.mo18246n(31);
        }
        if ("profession_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("profession_reddot_show", true)) {
            this.mCameraUIInterface.mo18246n(4);
        }
        if ("double_exposure_reddot_show".equals(strM13305d) && !sharedPreferences.getBoolean("double_exposure_reddot_show", true)) {
            this.mCameraUIInterface.mo18246n(18);
        }
        if (!"long_exposure_reddot_show".equals(strM13305d) || sharedPreferences.getBoolean("long_exposure_reddot_show", true)) {
            return;
        }
        this.mCameraUIInterface.mo18246n(27);
    }

    private void updateHdrChangeUi(String str, boolean z) {
        if (getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            updateHDRMode(str, true);
            updateMenuWithHDRChange("on".equals(str));
        }
        if ("on".equals(str)) {
            if (this.mActivity != null) {
                if (getSupportFunction(CameraFunction.VIDEO_HDR)) {
                    if (getSupportSubMenu(CameraUIInterface.KEY_VIDEO_HDR)) {
                        this.mCameraUIInterface.mo18166b(R.string.camera_video_hdr, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                        return;
                    }
                    return;
                } else {
                    if (this.mCameraUIInterface.mo18233k().m18494b()) {
                        if (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d()) || CameraUIInterface.KEY_CAMERA_HDR_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.mo18233k().m18498d())) {
                            this.mCameraUIInterface.mo18108a(false, true, false);
                            this.mCameraUIInterface.mo18070a(R.string.hint_hdr_on, -1, true, true, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (getSupportFunction(CameraUIInterface.KEY_CAMERA_HDR_MODE)) {
            if (!isOpenFlash() && !isOpenFrontTorch() && !isAutoHDR()) {
                if (!((isAutoFlash() || isAutoFrontTorch()) && this.mbAutoFlash) && z && this.mCameraUIInterface.mo18233k().m18494b() && (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d()) || CameraUIInterface.KEY_CAMERA_HDR_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.mo18233k().m18498d()))) {
                    this.mCameraUIInterface.mo18108a(false, true, false);
                    this.mCameraUIInterface.mo18070a(R.string.hint_hdr_off, -1, true, true, false);
                }
            }
            if ("auto".equals(str) && z) {
                if (this.mCameraUIInterface.mo18233k().m18494b() && (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d()) || CameraUIInterface.KEY_CAMERA_HDR_MODE_FROM_OTHER_APP.equals(this.mCameraUIInterface.mo18233k().m18498d()))) {
                    this.mCameraUIInterface.mo18108a(false, true, false);
                    this.mCameraUIInterface.mo18070a(R.string.hint_hdr_auto, -1, true, true, false);
                }
                updateFlashMenuIfHDRIsAuto(this.mbFrontCamera);
                return;
            }
            return;
        }
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_HDR)) {
            this.mCameraUIInterface.mo18108a(false, true, true);
        }
    }

    public void onHDRModeChanged(String str) {
        String hDRModeValue = getHDRModeValue(str);
        if (this.mCameraInterface.mo10570g() != 0) {
            updateHDRMode(hDRModeValue, true);
            updateHdrChangeUi(hDRModeValue, true);
        }
    }

    protected void setTiltShiftPreview() {
        boolean zIsTiltShiftOpen = isTiltShiftOpen();
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22828e(zIsTiltShiftOpen);
            if (zIsTiltShiftOpen) {
                this.mPreviewEffectProcess.mo22818c(getTiltShiftBlurValue());
            }
        }
    }

    public void setTiltShiftParams(TiltShiftParam tiltShiftParam) {
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22788a(tiltShiftParam);
        }
    }

    protected float getTiltShiftBlurValue() {
        return getBlurValue(getTiltShiftBlurIndex());
    }

    protected int getTiltShiftBlurIndex() {
        if (getSupportFunction(CameraFunction.TILT_SHIFT)) {
            return this.mPreferences.getInt(CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU_INDEX, 70);
        }
        return 70;
    }

    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a(TAG, "changeModeAllViewWhenAnimation, animType: " + OplusGLSurfaceView_13 + ", isShow: " + z);
        if (5 == OplusGLSurfaceView_13) {
            if (z) {
                this.mbHasClickedFromThird = false;
                this.mbShowPostCaptureAlert = false;
                this.mbAutoHDR = false;
                return;
            } else {
                this.mbShowPostCaptureAlert = true;
                CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
                if (cameraUIInterface != null) {
                    cameraUIInterface.mo18108a(true, true, false);
                    return;
                }
                return;
            }
        }
        if (6 == OplusGLSurfaceView_13) {
            updateHdrChangeUi(getHDRModeValue(getHDRKey()), false);
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_CAMERA_HDR_MODE);
            return;
        }
        if (2 == OplusGLSurfaceView_13) {
            if (z) {
                this.mCameraUIInterface.mo18227i(z);
                this.mCameraUIInterface.mo18231j(z);
            }
            if (this.mCameraUIInterface == null || getSupportFunction(CameraUIInterface.KEY_SUPOORT_FOCUS_OUT_OF_RANGE)) {
                return;
            }
            this.mCameraUIInterface.mo18067a(R.string.camera_bokeh_move_farther_away);
            return;
        }
        if (10 == OplusGLSurfaceView_13) {
            if (this.mCameraUIInterface == null) {
                return;
            } else {
                return;
            }
        }
        if (18 != OplusGLSurfaceView_13 || z) {
            return;
        }
        if (isVideoModeType()) {
            if (isAiEnhancementVideoOpen()) {
                this.mCameraUIInterface.mo18067a(R.string.camera_ai_enhancement_video_hint_on);
            } else {
                this.mCameraUIInterface.mo18067a(R.string.camera_ai_enhancement_video_hint_off);
            }
            if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
                this.mCameraUIInterface.mo18210f(7, true);
            }
            this.mCameraInterface.mo10565e(0);
        } else {
            if (isAISceneOpen()) {
                this.mCameraUIInterface.mo18067a(R.string.camera_pi_ai_scenes_hint_on);
            } else {
                this.mCameraUIInterface.mo18067a(R.string.camera_pi_ai_scenes_hint_off);
            }
            this.mCameraUIInterface.mo18174b(false);
        }
        this.mCameraUIInterface.mo18067a(R.string.camera_toast_clean_lens_suggestion);
    }

    public void setDisplayOnLock(boolean z) {
        this.mbDisplayOnLock = z;
    }

    public boolean isBubbleOpen(String str) {
        if (this.mPreferences == null) {
            CameraLog.m12967f(TAG, "isBubbleOpen, mPreference null");
            return false;
        }
        CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
        if (cameraUIInterface != null && ((1 == cameraUIInterface.mo18134aX() && 7 != this.mCameraUIInterface.mo18180bc()) || ((3 == this.mCameraUIInterface.mo18134aX() && this.mCameraId != 0) || 4 == this.mCameraUIInterface.mo18134aX()))) {
            return false;
        }
        if (CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO.equals(str)) {
            return this.mPreferences.getBoolean(str, false);
        }
        if (CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE.equals(str)) {
            int iM14379d = CameraTipsManager.m14374a().m14379d();
            boolean zM14381f = CameraTipsManager.m14374a().m14381f();
            if (5 > iM14379d || zM14381f) {
                return false;
            }
            return this.mPreferences.getBoolean(str, true);
        }
        if (CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER.equals(str)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
                return this.mPreferences.getBoolean(str, true);
            }
            return false;
        }
        return this.mPreferences.getBoolean(str, true);
    }

    public boolean containsBubbleKey(String str) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            CameraLog.m12967f(TAG, "containsBubbleKey, mPreference null");
            return true;
        }
        return sharedPreferences.contains(str);
    }

    public void updateBubbleValue(String str, boolean z) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            CameraLog.m12967f(TAG, "updateBubbleValue, mPreference null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public CameraStatisticsUtil.MakerNote getMakerNote() {
        CameraStatisticsUtil.MakerNote makerNote = new CameraStatisticsUtil.MakerNote();
        if (this.mPreviewEffectProcess != null && needUploadOplusStatistics(CameraUIInterface.KEY_FILTER_PROCESS)) {
            makerNote.f16153O = String.valueOf(getCurrFilterIndex());
        }
        return makerNote;
    }

    public void setSysBrightness(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "setSysBrightness, sysBrightness: " + OplusGLSurfaceView_13);
        this.mSysBrightness = OplusGLSurfaceView_13;
    }

    public void setPictureHasSuperTextResult(boolean z) {
        this.mbCaptureHasSuperTextResult = z;
    }

    public void onPictureCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPictureCallback, data size: ");
        sb.append(bArr != null ? Integer.valueOf(bArr.length) : null);
        sb.append(", width: ");
        sb.append(OplusGLSurfaceView_13);
        sb.append(", height: ");
        sb.append(i2);
        sb.append(", imageFormat: ");
        sb.append(i3);
        sb.append(", isBurstShot: ");
        sb.append(z);
        CameraLog.m12954a(TAG, sb.toString());
        setInPreparing(false);
        if (!z) {
            this.mHandler.removeMessages(1);
        }
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putByteArray(KEY_PICTURE_DATA, bArr);
        bundle.putInt(KEY_PICTURE_WIDTH, OplusGLSurfaceView_13);
        bundle.putInt(KEY_PICTURE_HEIGHT, i2);
        bundle.putInt(KEY_PICTURE_FORMAT, i3);
        bundle.putBoolean(KEY_IS_BURST_SHOT, z);
        bundle.putInt(KEY_REQ_FORMAT, i4);
        message.setData(bundle);
        message.what = 1;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnPictureCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4) {
        int i5;
        int i6;
        CameraLog.m12954a(TAG, "doOnPictureCallback, mbPaused: " + this.mbPaused);
        if (this.mbPaused) {
            return;
        }
        CameraInterface interfaceC2646a = this.mCameraInterface;
        int iMo10591u = interfaceC2646a != null ? interfaceC2646a.mo10591u() : this.mCaptureOrientation;
        if (iMo10591u == 0 || iMo10591u == 180) {
            i5 = OplusGLSurfaceView_13;
            i6 = i2;
        } else {
            i6 = OplusGLSurfaceView_13;
            i5 = i2;
        }
        pictureTakenCallback(bArr, i6, i5, Util.m24243a(i3), bArr != null, z, 0L, i4);
    }

    public boolean needSurface(String str) {
        if ("type_still_capture_yuv_main".equals(str)) {
            return true;
        }
        if ("type_still_capture_raw".equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW);
        }
        if ("type_tuning_data_yuv".equals(str)) {
            return !Util.m24169C() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT);
        }
        if ("type_tuning_data_raw".equals(str)) {
            return !Util.m24169C() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT) && getSupportFunction(CameraUIInterface.KEY_SUPPORT_RAW_POST_PROCESS);
        }
        return false;
    }

    public boolean needSatCrossAnimation() {
        return this.mCameraUIInterface != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_NEED_CROSS_ANIMATION) && this.mCameraUIInterface.mo18159aw() && isSatOpen();
    }

    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        checkFunction();
        builder.setParameter(CameraParameter.ANTI_BANDING_ENABLE, isAntibandingEnable() ? "on" : "off");
        builder.setParameter(CameraParameter.QUICK_JPEG_SWITCH, Boolean.valueOf(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_JPEG)));
        if (isMirrorEnable() || this.mCameraUIInterface.mo18207e()) {
            builder.setParameter(CameraParameter.MIRROR_ENABLE, this.mPreferences.getString(CameraUIInterface.KEY_MIRROR, this.mActivity.getString(R.string.camera_mirror_default_value)));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_EXPLORER_SUPPORT)) {
            builder.setParameter(CameraParameter.KEY_EXPLORER_CHIP_STATE, Integer.valueOf(this.mPreferences.getInt(CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1)));
        }
        if (is10bitsHeicEncodeEnable()) {
            builder.setParameter(CameraParameter.PHOTO_10BIT_ENABLE, "on");
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_FLASH)) {
            builder.setParameter(CameraParameter.TORCH_FLASH_ENABLE, "on");
        }
        if (isHighPictureSize()) {
            builder.setParameter(CameraParameter.HIGH_PICTURE_SIZE_ENABLE, "on");
        }
        builder.setParameter(CameraParameter.MAKEUP_STATE, Integer.valueOf(getMakeupState()));
        if (!TextUtils.isEmpty(this.mCameraInterface.mo10505aG())) {
            builder.setParameter(CameraParameter.KEY_CALLER_PACKAGE_NAME, this.mCameraInterface.mo10505aG().getBytes());
        }
        builder.setParameter(CameraParameter.KEY_REQUEST_ZSL_MODE, getZSLMode() ? new byte[]{1} : new byte[]{0});
        builder.setParameter(CameraParameter.KEY_ZOOM_RATION_CONFIGURE, Float.valueOf(getZoomValue()));
    }

    public void onSessionConfigured() {
        if (!getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
            resetScreenState();
        }
        if (this.mCameraInterface.mo10463S() && (isFilterEffectOpen() || getFaceBeautyCurrIndex() != 0)) {
            this.mCameraUIInterface.mo18040J();
        }
        clearFocusOutOfRange();
    }

    protected int getSwitchAnimTime(int OplusGLSurfaceView_13) {
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEFAULT_TO_REAL_SWITCH_ANIM_TIME);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEFAULT_TO_FRONT_SWITCH_ANIM_TIME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isPanelMode() {
        ModeDataInfo c3351iM21781a;
        if (isFromMainMenuApp() && (c3351iM21781a = DataBaseOperator.m21777a().m21781a(HeadlineHelper.m20352e(HeadlineHelper.m20344a(getCameraMode())))) != null) {
            return "position_mode_panel".equals(c3351iM21781a.m21910c());
        }
        return false;
    }

    protected final boolean isSupportFastShot() {
        OneCamera interfaceC2694d = this.mOneCamera;
        return (interfaceC2694d == null || interfaceC2694d.mo13086e() == null || !this.mOneCamera.mo13086e().m13248E()) ? false : true;
    }

    protected boolean isSloganOpen() {
        SharedPreferences sharedPreferences;
        if (getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            return ((isSuperTextOpen() && isHasSuperTextDetectResult()) || is4k120fps() || (sharedPreferences = this.mPreferences) == null || !"on".equals(sharedPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off"))) ? false : true;
        }
        return false;
    }

    protected boolean isMakeupSloganOpen() {
        return isSloganOpen() && "on".equals(this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off"));
    }

    public String getHeicCodecFormat() {
        if (this.mPreferences == null) {
            return null;
        }
        if ((isSuperTextOpen() && isHasSuperTextDetectResult()) || this.mbBurstShot || !this.mCameraInterface.mo10575i() || !isCaptureModeType() || isVideoRecording()) {
            return null;
        }
        if (is10bitsHeicEncodeEnable() && isHeifEnable()) {
            return "heic_10bits";
        }
        if ("HEIF".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG"))) {
            return "heic_8bits";
        }
        return null;
    }

    public boolean is10bitsHeicEncodeEnable() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return getSupportFunction(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off")) && !this.mbDestroyed && this.mCameraInterface.mo10575i();
        }
        return false;
    }

    protected int getBlurIndex() {
        if (isTiltShiftOpen()) {
            return this.mPreferences.getInt(CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU_INDEX, 70);
        }
        if (getSupportFunction(CameraFunction.BOKEH) || getSupportFunction(CameraFunction.FACE_BLUR)) {
            return this.mPreferences.getInt(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX, getDefaultBlurValue());
        }
        if (getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS)) {
            return this.mPreferences.getInt(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX, getDefaultBlurValue());
        }
        return getDefaultBlurValue();
    }

    protected float getShowBlurValue() {
        int blurIndex = getBlurIndex();
        float[] videoBlurValues = BlurMenu.getVideoBlurValues(this.mbFrontCamera);
        int blurIndexInArrays = getBlurIndexInArrays(videoBlurValues, 0, videoBlurValues.length, blurIndex);
        return -1 == blurIndexInArrays ? SYSTEM_BRIGHTNESS : BlurMenu.BLUR_SHOWING_TEXT_VALUES[blurIndexInArrays];
    }

    private int getBlurIndexInArrays(float[] fArr, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        int i3 = (OplusGLSurfaceView_13 + i2) / 2;
        if (fArr[i3] == COUIBaseListPopupWindow_12) {
            return i3;
        }
        if (OplusGLSurfaceView_13 >= i2) {
            return -1;
        }
        if (COUIBaseListPopupWindow_12 < fArr[i3]) {
            return getBlurIndexInArrays(fArr, OplusGLSurfaceView_13, i3 - 1, COUIBaseListPopupWindow_12);
        }
        if (COUIBaseListPopupWindow_12 > fArr[i3]) {
            return getBlurIndexInArrays(fArr, i3 + 1, i2, COUIBaseListPopupWindow_12);
        }
        return -1;
    }

    public int getDefaultBlurValue() {
        if (this.mbFrontCamera) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FRONT_BLUR_VALUE_DEFAULT);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_REAR_BLUR_VALUE_DEFAULT);
    }

    protected float getBlurValue() {
        return getBlurValue(getBlurIndex());
    }

    protected float getBlurValue(int OplusGLSurfaceView_13) {
        return new BigDecimal(OplusGLSurfaceView_13).multiply(CameraConstant.f13118c).floatValue();
    }

    protected boolean isShowUltraWide() {
        return (isVideoNeonOpen() || isBlurOpen()) ? false : true;
    }

    protected void setBlurIndex(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "setBlurIndex, index: " + OplusGLSurfaceView_13);
        float blurValue = getBlurValue(OplusGLSurfaceView_13);
        if (getSupportFunction(CameraFunction.BOKEH)) {
            OneCamera interfaceC2694d = this.mOneCamera;
            if (interfaceC2694d != null) {
                interfaceC2694d.mo13021a(blurValue);
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            this.mPreferences.edit().putInt(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX, OplusGLSurfaceView_13).apply();
            return;
        }
        if (getSupportFunction(CameraFunction.FACE_BLUR)) {
            PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
            if (interfaceC3423t != null) {
                interfaceC3423t.mo22777a(blurValue);
            }
            this.mPreferences.edit().putInt(CameraUIInterface.KEY_PORTRAIT_BLUR_MENU_INDEX, OplusGLSurfaceView_13).apply();
            return;
        }
        if (isTiltShiftOpen()) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putInt(CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU_INDEX, OplusGLSurfaceView_13);
            editorEdit.apply();
            setTiltShiftPreview();
            return;
        }
        if (getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS)) {
            PreviewEffectProcess interfaceC3423t2 = this.mPreviewEffectProcess;
            if (interfaceC3423t2 != null) {
                interfaceC3423t2.mo22808b(blurValue);
            }
            SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
            editorEdit2.putInt(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX, OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 0) {
                editorEdit2.putString(CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off");
            } else {
                editorEdit2.putString(CameraUIInterface.KEY_VIDEO_BLUR_MENU, "on");
            }
            if (!getSupportFunction(CameraFunction.SAT_CAMERA)) {
                editorEdit2.putBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, OplusGLSurfaceView_13 != 0);
            }
            editorEdit2.apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        }
    }

    public boolean isSatOpen() {
        return getSupportFunction(CameraFunction.SAT_CAMERA);
    }

    public boolean isNoneSatUltraWideAngleOpen() {
        SharedPreferences sharedPreferences;
        Activity activity;
        if (!getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) || (sharedPreferences = this.mPreferences) == null || (activity = this.mActivity) == null) {
            return false;
        }
        return "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, activity.getString(R.string.ultra_wide_angle_default_value)));
    }

    public boolean isNoneSatTeleAngleOpen() {
        SharedPreferences sharedPreferences;
        if (!getSupportFunction(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE) || (sharedPreferences = this.mPreferences) == null) {
            return false;
        }
        return "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, this.mActivity.getString(R.string.tele_angle_default_value)));
    }

    public void displayFixedUpModeHint() {
        this.mbShowEnvironmentTips = false;
    }

    private void updateMirrorParam() {
        OneCamera interfaceC2694d;
        if (!this.mbFrontCamera || (interfaceC2694d = this.mOneCamera) == null) {
            return;
        }
        interfaceC2694d.mo13109k(TextUtils.equals(getMirror(), "off"));
    }

    protected void setRawRequestTag(boolean z) {
        this.mbRawRequestTag = z;
    }

    public void setPreviewDetectResult(DetectResult c3077a) {
        this.mDetectResult = c3077a;
    }

    public boolean isQrCodeOpened() {
        SharedPreferences sharedPreferences;
        return MyRegionAdapter.m14514d() && getSupportFunction(CameraUIInterface.KEY_QR_CODE) && (sharedPreferences = this.mPreferences) != null && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_QR_CODE, "on"));
    }

    public void onReceivePreviewCaptureResult(CaptureResult captureResult) {
        if (InverseManager.INS.isInverseAble(this.mActivity)) {
            updateScreenState(captureResult);
        } else {
            updateScreenBrightnessState(captureResult);
        }
        updateDarkEnvironmentTips(captureResult);
    }

    public void setFlashTemporaryDisabled(boolean z) {
        this.mbFlashTemporaryDisabled = z;
    }

    public void clearApsDecisionResult() {
        CameraLog.m12954a(TAG, "clearApsDecisionResult");
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

    public void setNeedCapture(boolean z) {
        CameraLog.m12954a(TAG, "setNeedCapture, needCapture: " + z);
        if (z) {
            this.mbInCapturing = false;
            setCapturePreviewDataState(0);
        }
        synchronized (this.mNeedCaptureLock) {
            this.mbNeedCapture = z;
        }
    }

    public int getEntryGalleryAnim() {
        return Util.m24495t() ? R.anim.gallery_in_folder : 1 == this.mActivity.getResources().getConfiguration().getLayoutDirection() ? R.anim.gallery_in_rtl : R.anim.gallery_in;
    }

    public float getPreviewXScale() {
        return this.mPreviewXScale;
    }

    public int getPreviewDispalyWidth() {
        return Util.getScreenWidth();
    }

    public void setApsService(ApsService apsService) {
        this.mApsService = apsService;
    }

    private void updateScreenState(CaptureResult captureResult) {
        if (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
            if (this.mbInCapturing) {
                InverseManager.INS.removeMessages();
                return;
            }
            String string = this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity));
            int threshold = InverseManager.INS.getThreshold();
            int thresholdRecover = InverseManager.INS.getThresholdRecover();
            if (threshold > 0) {
                if ("auto".equals(string)) {
                    if (exclusiveInverse()) {
                        if (InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
                            InverseManager.INS.postInverseColor(this.mActivity.hashCode(), false, false);
                        }
                        InverseManager.INS.removeMessages();
                        checkFlashMode();
                    } else {
                        float fM24203a = Util.m24203a(captureResult);
                        CameraLog.m12954a(TAG, "updateScreenState, currentLux: " + fM24203a + ", threshold: " + threshold);
                        long frameNumber = captureResult.getFrameNumber();
                        if (500.0f != fM24203a) {
                            this.mbLuxHasChange = true;
                        }
                        if (threshold <= fM24203a && (10 < frameNumber || this.mbLuxHasChange)) {
                            if (!InverseManager.INS.setInverseDelay(this.mActivity, true, true, new InverseManager.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$A2xGlTZfC7H-3NriJYlQp7_Tkvk
                                @Override // com.oplus.camera.p172ui.inverse.InverseManager.PlatformImplementations.kt_3
                                public final void call() {
                                    this.COUIBaseListPopupWindow_12$0.lambda$updateScreenState$2$BaseMode();
                                }
                            })) {
                                checkFlashMode();
                            }
                            if (InverseManager.INS.isInverseColor(this.mActivity.hashCode()) && !this.mCameraUIInterface.mo18158av()) {
                                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.10
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (BaseMode.this.mPreferences == null || BaseMode.this.mCameraUIInterface == null || !"auto".equals(BaseMode.this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(BaseMode.this.mActivity)))) {
                                            return;
                                        }
                                        BaseMode.this.mCameraUIInterface.mo18070a(-1, R.drawable.flash_hint_icon, false, true, false);
                                    }
                                });
                            }
                        } else if (thresholdRecover > fM24203a) {
                            if (!InverseManager.INS.setInverseDelay(this.mActivity, false, true, new InverseManager.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.-$$Lambda$BaseMode$dPQNtGnJJ6Pj54aeIJvoTRkdg9k
                                @Override // com.oplus.camera.p172ui.inverse.InverseManager.PlatformImplementations.kt_3
                                public final void call() {
                                    this.COUIBaseListPopupWindow_12$0.lambda$updateScreenState$3$BaseMode();
                                }
                            })) {
                                checkFlashMode();
                            }
                        } else {
                            checkFlashMode();
                            if (InverseManager.INS.isInverseColor(this.mActivity.hashCode()) && !this.mCameraUIInterface.mo18158av()) {
                                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (BaseMode.this.mPreferences == null || BaseMode.this.mCameraUIInterface == null || !"auto".equals(BaseMode.this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(BaseMode.this.mActivity)))) {
                                            return;
                                        }
                                        BaseMode.this.mCameraUIInterface.mo18070a(-1, R.drawable.flash_hint_icon, false, true, false);
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
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.BaseMode.9
            @Override // java.lang.Runnable
            public void run() {
                if (BaseMode.this.mPreferences == null || BaseMode.this.mCameraUIInterface == null || !"auto".equals(BaseMode.this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(BaseMode.this.mActivity)))) {
                    return;
                }
                BaseMode.this.mCameraUIInterface.mo18070a(-1, R.drawable.flash_hint_icon, false, true, false);
                BaseMode.this.checkFlashMode();
                BaseMode.this.mCameraUIInterface.mo18287z();
            }
        });
    }

    public /* synthetic */ void lambda$updateScreenState$3$BaseMode() {
        displayAllIcon(this.mbAutoHDR, false);
        checkFlashMode();
        this.mCameraUIInterface.mo18287z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFlashMode() {
        if (InverseManager.INS.isInverseColor(this.mActivity.hashCode()) && !CameraParameter.FlashMode.FLASH_TORCH.equals(this.mOneCamera.mo13125q())) {
            this.mOneCamera.mo13069b(CameraParameter.FlashMode.FLASH_TORCH);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        } else {
            if (InverseManager.INS.isInverseColor(this.mActivity.hashCode()) || "off".equals(this.mOneCamera.mo13125q())) {
                return;
            }
            this.mOneCamera.mo13069b("off");
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    private void checkHighBrightness() {
        if (InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
            if (sHighBrightness && InverseManager.INS.getCurrentHighBrightnessValue() == getHighBrightnessValue()) {
                return;
            }
            InverseManager.INS.setCurrentHighBrightnessValue(getHighBrightnessValue());
            this.mCameraInterface.mo10552b(InverseManager.INS.getCurrentHighBrightnessValue());
            sHighBrightness = true;
            return;
        }
        if (sHighBrightness) {
            resetScreenState();
        }
    }

    protected float getHighBrightnessValue() {
        return InverseManager.INS.getBrightness();
    }

    private void updateScreenBrightnessState(CaptureResult captureResult) {
        if (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity));
            float fM24203a = Util.m24203a(captureResult);
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_THRESHOLD);
            int configIntValue2 = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_RECOVER_THRESHOLD);
            if (!sHighBrightness && configIntValue != 0 && configIntValue <= fM24203a && ("on".equals(string) || "auto".equals(string))) {
                this.mCameraInterface.mo10552b(FLASH_BRIGHTNESS);
                sHighBrightness = true;
                return;
            } else {
                if (sHighBrightness) {
                    if ((configIntValue == 0 || configIntValue2 <= fM24203a) && !"off".equals(string)) {
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
        return (getSupportFunction(CameraUIInterface.KEY_TORCH_MODE) && "on".equals(getTorchMode()) && this.mbFrontCamera && !CameraEntry.m13302b(this.mCameraEntryType)) ? R.drawable.torch_hint_icon : R.drawable.flash_hint_icon;
    }

    private void resetScreenState() {
        this.mCameraInterface.mo10552b(SYSTEM_BRIGHTNESS);
        sHighBrightness = false;
    }

    public String getRelativePath() {
        return Storage.m11140e(null);
    }

    private void updateDarkEnvironmentTips(CaptureResult captureResult) {
        if (getSupportFunction(CameraUIInterface.KEY_DARK_ENVIRONMENT_TIPS) && captureResult != null) {
            float fM24203a = Util.m24203a(captureResult);
            int environmentTipsThreshold = getEnvironmentTipsThreshold();
            if (environmentTipsThreshold != 0 && environmentTipsThreshold < fM24203a && !this.mbShowEnvironmentTips) {
                this.mbShowEnvironmentTips = true;
                this.mCameraUIInterface.mo18067a(R.string.hint_function_not_support_1080_60);
                this.mCameraUIInterface.mo18070a(R.string.camera_id_photo_mode_need_more_light, -1, true, false, false);
                return;
            } else {
                if (environmentTipsThreshold == 0 || environmentTipsThreshold <= fM24203a || !this.mbShowEnvironmentTips) {
                    return;
                }
                this.mbShowEnvironmentTips = false;
                this.mCameraUIInterface.mo18067a(R.string.camera_id_photo_mode_need_more_light);
                return;
            }
        }
        if (this.mbShowEnvironmentTips) {
            this.mbShowEnvironmentTips = false;
            this.mCameraUIInterface.mo18067a(R.string.camera_id_photo_mode_need_more_light);
        }
    }

    public void setVideoBlurEffect(boolean z) {
        PreviewEffectProcess interfaceC3423t = this.mPreviewEffectProcess;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22841i(z);
        }
    }

    protected void sendBoradCastNotifyMicroscopeState(boolean z) {
        Intent intent;
        if (z) {
            intent = new Intent("oplus.camera.microscope.start");
        } else {
            intent = new Intent("oplus.camera.microscope.stop");
        }
        this.mActivity.sendBroadcast(intent, "com.oplus.permission.safe.PHONE");
    }

    public long getCaptureMergeIdentity() {
        return this.mCaptureMergeIdentity;
    }

    public void setLSDEnable() {
        OneCamera interfaceC2694d = this.mOneCamera;
        if (interfaceC2694d != null) {
            interfaceC2694d.mo13153z(isLensDirtyDetectionOpen() ? 1 : 0);
        }
    }

    public boolean isMenuOn(String str) {
        return (this.mPreferences == null || TextUtils.isEmpty(str) || !"on".equals(this.mPreferences.getString(str, "off"))) ? false : true;
    }

    protected long getHalMemory() {
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_COMMON);
    }

    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
        SharedPreferences sharedPreferences;
        boolean z = (c2693c == null || c2693c.f13385N == null || 5 != c2693c.f13385N.mApsDecisionFeatureType || (isFaceBeautyOrMakeupOpen() && (!this.mbFrontCamera || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MTK_FACE_BEAUTY_REMOSAIC_SUPPORT))) || isFilterEffectOpen() || isPIAISceneOpen()) ? false : true;
        boolean z2 = (c2693c == null || c2693c.f13385N == null || 4 != c2693c.f13385N.mSupportCaptureZoomFeature) ? false : true;
        boolean z3 = (c2693c == null || c2693c.f13410e.equals("none") || (sharedPreferences = this.mPreferences) == null || !"on".equals(sharedPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, "off")) || !"on".equals(this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, "off"))) ? false : true;
        boolean z4 = c2693c != null && c2693c.f13398a && isHasSuperTextDetectResult();
        CameraInterface interfaceC2646a = this.mCameraInterface;
        return (interfaceC2646a == null || !interfaceC2646a.mo10575i() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_JPEG) || !Util.m24501w(this.mActivity) || z || (c2693c == null ? this.mbBurstShot : c2693c.f13415j) || z2 || z3 || z4 || isVideoRecording() || (isInNightProcess() && !isInOfflineNightProcess())) ? false : true;
    }

    public boolean isSupportHyperLapseZoomChange() {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_HYPER_LAPSE_ZOOM_LIST_SUPPORT);
        return configFloatArrayValue != null && configFloatArrayValue.length > 1;
    }

    public boolean isHyperLapseUltraWide() {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_HYPER_LAPSE_ZOOM_LIST_SUPPORT);
        return (configFloatArrayValue == null || configFloatArrayValue.length == 0 || configFloatArrayValue[0] != 0.6f) ? false : true;
    }

    public ScreenModeConst.PlatformImplementations.kt_3 getPreferredScreenMode(int OplusGLSurfaceView_13) {
        return ScreenModeConst.PlatformImplementations.kt_3.common;
    }

    protected void processFaceCount() {
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a == null || this.mCameraUIInterface == null) {
            return;
        }
        int OplusGLSurfaceView_13 = this.mFaceCountStatusCount;
        if (OplusGLSurfaceView_13 < 30) {
            this.mFaceCountStatusCount = OplusGLSurfaceView_13 + 1;
            return;
        }
        this.mFaceCountStatusCount = 0;
        if (interfaceC2646a.mo10534aj() > 1) {
            this.mCameraUIInterface.mo18070a(R.string.camera_one_subject_hint, -1, true, false, false);
        } else {
            this.mCameraUIInterface.mo18067a(R.string.camera_one_subject_hint);
        }
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public void resetMonoFilter() {
        if (isMonoIndex(getCurrFilterIndex())) {
            if (this.mCameraUIInterface.mo18023A()) {
                this.mCameraUIInterface.mo18244m(true, false);
            }
            if (isFilterEffectOpen()) {
                this.mPreferences.edit().putInt(getFilterEffectMenuPreferenceKey(), FilterHelper.f21279a).apply();
            }
        }
    }

    public BaseScreenMode getCurrentScreenMode() {
        CameraInterface interfaceC2646a = this.mCameraInterface;
        if (interfaceC2646a == null) {
            return null;
        }
        return interfaceC2646a.mo10520aV();
    }

    private void checkExplorerChipState(CaptureResult captureResult) {
        Activity activity;
        Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13307at);
        if (objM13005a instanceof Integer) {
            int iIntValue = ((Integer) objM13005a).intValue();
            int OplusGLSurfaceView_13 = (iIntValue == 1073741824 || iIntValue == 0) ? 0 : 1;
            int i2 = this.mPreferences.getInt(CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1);
            CameraLog.m12959b(TAG, "checkExplorerChipState, explorerChipStateValue: " + Integer.toHexString(iIntValue));
            if (OplusGLSurfaceView_13 != i2) {
                this.mPreferences.edit().putInt(CameraUIInterface.KEY_EXPLORER_CHIP_STATE, OplusGLSurfaceView_13).apply();
                if (1073741824 != iIntValue || (activity = this.mActivity) == null || activity.isFinishing()) {
                    return;
                }
                this.mActivity.finish();
            }
        }
    }
}
