package com.oplus.camera.capmode;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.camera2.CaptureResult;
import android.location.Location;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.widget.TextViewCompat;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.heytap.accessory.CommonStatusCodes;
import com.meicam.sdk.NvsStreamingContext;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.SloganUtil;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.CameraLog;
import com.oplus.camera.OplusConfigure;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.VideoRecorder;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p136a.CaptureMsgDataReportUtil;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p144g.C2735b;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.VideoFusionTexturePreview;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.perf.FluencyPerformance;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.DcsUtil;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.ExportPGrantUtil;
import com.oplus.camera.util.ToastUtil;
import com.oplus.camera.util.Util;
import com.oplus.camera.util.storage.MediaStoreUtil;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.ocs.camera.CameraRecordingCallback;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: VideoMode.java */
/* renamed from: com.oplus.camera.capmode.w */
/* loaded from: classes2.dex */
public abstract class VideoMode extends BaseMode implements VideoRecorder.COUIBaseListPopupWindow_12, VideoRecorder.COUIBaseListPopupWindow_11, VideoRecorder.COUIBaseListPopupWindow_10 {
    private static final String APS_VIDEO_EIS = "preview_video_eis";
    private static final String APS_VIDEO_SUPER_EIS = "preview_video_supereis";
    private static final int AUDIO_BITRATE_ENHANCE = 320000;
    private static final float BRIGHTNESS_ALPHA_END = 0.0f;
    private static final float BRIGHTNESS_ALPHA_START = 1.0f;
    private static final int BRIGHTNESS_ANIM_DELAY_FIRST_STEP = 10000;
    private static final int BRIGHTNESS_ANIM_DELAY_SECOND_STEP = 300000;
    private static final int BRIGHTNESS_ANIM_DURATION = 10000;
    private static final int BRIGHTNESS_MODE_EXPONENTIAL = 1;
    private static final int BRIGHTNESS_MODE_LINEAR = 0;
    private static final int CAMERA_UNIT_RECORDING_STOP = 4;
    private static final int CHECK_SD_SPACE_DELAY = 5000;
    private static final int CIF_AUDIO_RATE_SCALE = 8;
    private static final int CONTENT_VALUE_SIZE = 7;
    private static final int DEFAULT_EXPONENTIAL_BRIGHTNESS = 191;
    private static final int DEFAULT_LINEAR_BRIGHTNESS = 130;
    protected static final int DEFAULT_VIDEO_QUALITY = 4;
    private static final int ERR_VIDEO_MALFORMED = -1007;
    public static final String KEY_IS_CAMERA_RECORDING = "oplus_is_camera_recording";
    public static final String KEY_RECORD_FORBID = "record_forbid";
    private static final float MAX_ADJUST_STEP_FOR_BRIGHTNESS = 20.0f;
    private static final long MAX_VIDEO_SIZE = 4294967296L;
    private static final int MIRROR_TYPE_HORIZONTAL = 2;
    private static final int MIRROR_TYPE_VERTICAL = 1;
    private static final int MSG_CLEANUP_EMPTY_FILE = 4;
    private static final int MSG_CODE_CHECK_SD_SPACE = 2;
    private static final int MSG_CODE_ENABLE_SHUTTER_BUTTON = 4;
    private static final int MSG_CODE_ENABLE_VIDEO_BUTTON = 3;
    private static final int MSG_CODE_FINISH_AFTER_STOP = 9;
    private static final int MSG_CODE_ON_START_ERROR = 5;
    private static final int MSG_CODE_START_LOWER_BRIGHTNESS_FIRST_STEP = 6;
    private static final int MSG_CODE_START_LOWER_BRIGHTNESS_SECOND_STEP = 13;
    private static final int MSG_CODE_START_RECORDING = 7;
    private static final int MSG_CODE_UPDATE_RECORD_TIME = 1;
    private static final int MSG_DELETE_VIDEO_FILE = 3;
    private static final int MSG_HIDE_HINT_VIEW = 8;
    private static final int MSG_HIDE_HINT_VIEW_DELAY = 3000;
    protected static final int MSG_NO_MOVEMENT_DETECT = 12;
    private static final int MSG_OPEN_RECORD_SIG = 12;
    private static final int MSG_PREPARE_VIDEO_SURFACE = 6;
    private static final int MSG_RECORD_START = 1;
    private static final int MSG_RECORD_STOP = 2;
    protected static final int MSG_SHOW_LONG_TIME_RECORDING_TEMPERATURE_TOAST = 11;
    private static final int MSG_STOP_SHORT_VIDEO = 5;
    protected static final int MSG_STOP_SHORT_VIDEO_DELAY = 10;
    private static final int MTK_OTHER_VIDEO_BIT_RATE_REDUCE_SCALE = 4;
    private static final int MTK_VIDEO_FRAME_RATE = 30;
    public static final int PREVIEW_FPS_120 = 120;
    public static final int PREVIEW_FPS_HIGH = 60;
    public static final int PREVIEW_FPS_LOW = 20;
    public static final int PREVIEW_FPS_NORMAL = 30;
    private static final int RECORDING_MIN_TIME = 1000;
    public static final int RECORDING_STOP_COUNT_DOWN_SECONDS = 5;
    private static final int RECORD_STARTED = 0;
    private static final int RECORD_STARTING = 1;
    private static final int RECORD_STOPPED = 2;
    private static final int RECORD_STOPPING = 3;
    private static final int RECRDSIG_TIMEOUT_DELAY = 5000;
    private static final int SECOND_BRIGHTNESS_LIMIT = 179;
    private static final String TAG = "VideoMode";
    private static final int TIME_INDICATOR_BLINK_SPACE = 6;
    private static final int TIME_OPEN_RECORD_SIG_DELAY = 300;
    private static final int TIME_STOP_SOUND_DELAY = 100;
    private static final int TIME_VIDEO_STOP_DELAY = 1000;
    private static final int UPDATE_RECORD_TIME_DELAY = 81;
    private static final int VIDEO_1080P_BIT_RATE = 17000000;
    public static final int VIDEO_1080P_HEIGHT = 1080;
    public static final int VIDEO_1080P_WIDTH = 1920;
    private static final int VIDEO_480P_HEIGHT = 480;
    private static final int VIDEO_480P_WIDTH = 720;
    private static final int VIDEO_4K_AUDIO_BIT_RATE = 156000;
    private static final int VIDEO_4K_AUDIO_CHANNELS = 2;
    private static final int VIDEO_4K_AUDIO_SAMPLE_RATE = 48000;
    private static final int VIDEO_4K_BIT_RATE = 100000000;
    public static final int VIDEO_4K_FRAME_HEIGHT = 2160;
    public static final int VIDEO_4K_FRAME_WIDTH = 3840;
    private static final int VIDEO_720P_BIT_RATE = 9000000;
    public static final int VIDEO_720P_HEIGHT = 720;
    public static final int VIDEO_720P_WIDTH = 1280;
    private static final int VIDEO_8K_BIT_RATE = 105000000;
    public static final int VIDEO_8K_FRAME_HEIGHT = 4320;
    public static final int VIDEO_8K_FRAME_WIDTH = 7680;
    private static final int VIDEO_BIT_RATE_REDUCE_SCALE = 2;
    private static final int VIDEO_BUTTON_DELAY = 200;
    private static final int VIDEO_CIF_BIT_RATE = 720000;
    private static final int VIDEO_CIF_HEIGHT = 288;
    private static final int VIDEO_CIF_WIDTH = 352;
    public static final String VIDEO_DEFAULT_FPS = "30";
    public static final long VIDEO_FRAME_DEFAULT_USAGE = 128;
    private static final int VIDEO_QCIF_BIT_RATE = 192000;
    private static final int VIDEO_QCIF_HEIGHT = 144;
    private static final int VIDEO_QCIF_WIDTH = 176;
    private static final int VIDEO_SURFACE_IDLE = 0;
    private static final int VIDEO_SURFACE_PREPARED = 2;
    private static final int VIDEO_SURFACE_PREPARING = 1;
    private static final long WAIT_FOR_VIDEO_DURATION = 20;
    protected int mAiEnhanceSceneChangeCount;
    protected int mAiEnhanceSceneEnd;
    protected int mAiEnhanceSceneStart;
    private PlatformImplementations.kt_3 mBrightnessAnimationListener;
    private ValueAnimator mBrightnessAnimator;
    private COUIAlertDialog mCameraErrorAlertDialogBuilder;
    private DialogInterface.OnClickListener mCameraErrorPositiveButtonListener;
    private CameraRecordingCallback mCameraRecordingCallback;
    private AsyncTask mCheckStorageTask;
    private int mCount;
    protected String mCurrentVideoFilename;
    protected Uri mCurrentVideoUri;
    protected ContentValues mCurrentVideoValues;
    protected int mDcsCCT;
    protected long mDcsExp;
    protected int mDcsIso;
    protected float mDcsLux;
    protected String mEndType;
    private int mFaceCountOnStop;
    protected String mFileName;
    protected Handler mHandler;
    private long mLastPausingTime;
    private int mMaxVideoDurationInMs;
    private volatile int mMediaRecorderState;
    private String mNoiseFilter;
    private AppCompatDialog mPGDialog;
    private int mPauseClickTimes;
    private long mPictureTakenTime;
    private final ConditionVariable mPrepareVideoSurface;
    private AlgoSwitchConfig.PreviewConfig mPreviewConfig;
    private long mPreviewOkTime;
    private long mPreviewVideoCostTime;
    protected CamcorderProfile mProfile;
    private final ConditionVariable mRecordFileNameChange;
    private Handler mRecordHandler;
    private HandlerThread mRecordHandlerThread;
    private final ConditionVariable mRecordSig;
    protected float mRecordingEndTemperature;
    protected float mRecordingStartTemperature;
    private long mRecordingStartTime;
    protected long mRecordingTotalTime;
    protected Resources mResouces;
    private long mResumePauseRecordingTotalTime;
    private String mShutterType;
    private String mSoundType;
    private int mStartRecordingFaceCount;
    private int mStartRecordingOrientation;
    private long mTotalPausingTime;
    private boolean mVideoAeAfLock;
    protected ParcelFileDescriptor mVideoFileDescriptor;
    protected String mVideoFilename;
    protected int mVideoOrientation;
    protected VideoRecorder mVideoRecorder;
    private final Object mVideoRecorderSig;
    private String mVideoSavePath;
    protected String mVideoSizeType;
    protected Surface mVideoSurface;
    protected Object mVideoSurfaceLock;
    private volatile int mVideoSurfaceState;
    private int mVideoWatermarkOrientation;
    public ConditionVariable mWaitRecordStarted;
    private boolean mbBinauralRecordEnable;
    private boolean mbBroadcastPauseMusic;
    private boolean mbEisHalCache;
    private boolean mbGetDcsData;
    protected boolean mbHasDragIntelligentView;
    protected boolean mbLowBatteryDisabled;
    private boolean mbMediaLimitProcess;
    private boolean mbPictureTakenDuringRecord;
    protected boolean mbPipelineEnable;
    private boolean mbRecordAudio;
    private boolean mbShowHint;
    private boolean mbShowRecordingIndicator;
    private boolean mbStartFailue;
    protected boolean mbStopVideoFail;
    private boolean mbVideoFrameInAPS;

    private String convertOutputFormatToFileExt(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 2 ? ".mp4" : ".3gp";
    }

    private String convertOutputFormatToMimeType(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 2 ? MimeTypes.VIDEO_MP4 : MimeTypes.VIDEO_H263;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getGuideLineKey() {
        return CameraUIInterface.KEY_LINE_VIDEO;
    }

    protected Double getRealCaptureRate() {
        return null;
    }

    public Float getRealVideoTimeRatio() {
        return null;
    }

    protected int getRecordingMaxDuration(String str, String str2) {
        return -1;
    }

    protected int getRecordingMinTime(boolean z) {
        return 1000;
    }

    protected int getSlowVideoFps() {
        return 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
        return false;
    }

    protected Double getTimeLapseSpeed() {
        return null;
    }

    protected int getVideoFrameRate() {
        return 30;
    }

    protected long getVideoTime() {
        return 0L;
    }

    protected long getVideoTimeLimit() {
        return 0L;
    }

    protected String getVideoTitle() {
        return "";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCaptureModeType() {
        return false;
    }

    protected boolean isHighFps() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHyperLapseOpen() {
        return false;
    }

    protected boolean isMotionDetectOpen() {
        return false;
    }

    protected boolean isMotionDetected() {
        return false;
    }

    protected boolean isMovieMode() {
        return false;
    }

    protected boolean isNeedAudioEncode() {
        return true;
    }

    protected boolean isNeedGenerateUri() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isNeedSetZslWhenCapture() {
        return false;
    }

    protected boolean isQualcommEndOfStreamNeed() {
        return false;
    }

    protected boolean isRearSuperEISOpen() {
        return false;
    }

    protected boolean isSlowVideoHighFrame() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperEISOpen() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoModeType() {
        return true;
    }

    protected boolean needShowVideoTime() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
    }

    protected void onInitializeRecorder(VideoRecorder c2670x) {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoRetakeButtonClick() {
    }

    protected void processPlatformSlowVideo() {
    }

    public void setHalStatus(int OplusGLSurfaceView_13) {
    }

    protected boolean shouldAutoStop(long OplusGLSurfaceView_15) {
        return false;
    }

    protected void startShutterButtonProgress() {
    }

    protected void stopShutterButtonProgress() {
    }

    protected void updateVideoTypeExif(File file) {
    }

    public VideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.mRecordSig = new ConditionVariable();
        this.mPrepareVideoSurface = new ConditionVariable();
        this.mRecordFileNameChange = new ConditionVariable(true);
        this.mVideoRecorderSig = new Object();
        this.mWaitRecordStarted = new ConditionVariable();
        this.mResouces = null;
        this.mHandler = null;
        this.mVideoSizeType = "video_size_1080p";
        this.mRecordingTotalTime = 0L;
        this.mProfile = null;
        this.mVideoSurface = null;
        this.mVideoSurfaceLock = new Object();
        this.mVideoRecorder = null;
        this.mEndType = "normal";
        this.mRecordingStartTemperature = -1.0f;
        this.mRecordingEndTemperature = -1.0f;
        this.mbStopVideoFail = false;
        this.mDcsLux = BRIGHTNESS_ALPHA_END;
        this.mDcsCCT = 0;
        this.mDcsIso = 0;
        this.mDcsExp = 0L;
        this.mbPipelineEnable = false;
        this.mAiEnhanceSceneStart = 0;
        this.mAiEnhanceSceneEnd = 0;
        this.mAiEnhanceSceneChangeCount = 0;
        this.mFileName = "";
        this.mCurrentVideoUri = null;
        this.mCurrentVideoValues = null;
        this.mVideoOrientation = 0;
        this.mbHasDragIntelligentView = false;
        this.mVideoFileDescriptor = null;
        this.mbLowBatteryDisabled = false;
        this.mRecordHandler = null;
        this.mRecordHandlerThread = null;
        this.mVideoSavePath = null;
        this.mSoundType = "";
        this.mNoiseFilter = "";
        this.mCount = 0;
        this.mMaxVideoDurationInMs = -1;
        this.mMediaRecorderState = 2;
        this.mbBroadcastPauseMusic = false;
        this.mbShowRecordingIndicator = true;
        this.mbRecordAudio = true;
        this.mbShowHint = false;
        this.mbVideoFrameInAPS = false;
        this.mbStartFailue = false;
        this.mTotalPausingTime = 0L;
        this.mLastPausingTime = 0L;
        this.mRecordingStartTime = 0L;
        this.mPauseClickTimes = 0;
        this.mPreviewConfig = null;
        this.mCheckStorageTask = null;
        this.mBrightnessAnimator = null;
        this.mBrightnessAnimationListener = null;
        this.mCameraErrorAlertDialogBuilder = null;
        this.mResumePauseRecordingTotalTime = 0L;
        this.mVideoAeAfLock = false;
        this.mVideoSurfaceState = 0;
        this.mStartRecordingOrientation = 0;
        this.mStartRecordingFaceCount = 0;
        this.mFaceCountOnStop = 0;
        this.mShutterType = "";
        this.mbPictureTakenDuringRecord = false;
        this.mPictureTakenTime = 0L;
        this.mbGetDcsData = false;
        this.mbEisHalCache = false;
        this.mbMediaLimitProcess = false;
        this.mVideoWatermarkOrientation = 0;
        this.mbBinauralRecordEnable = false;
        this.mPGDialog = null;
        this.mCameraErrorPositiveButtonListener = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.capmode.w.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                VideoMode.this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
            }
        };
        this.mCameraRecordingCallback = new CameraRecordingCallback() { // from class: com.oplus.camera.capmode.w.8
            @Override // com.oplus.ocs.camera.CameraRecordingCallback
            public void onRecordingResult(CameraRecordingCallback.CameraRecordingResult cameraRecordingResult) {
                super.onRecordingResult(cameraRecordingResult);
                if (cameraRecordingResult == null) {
                    return;
                }
                CameraLog.m12967f(VideoMode.TAG, "onRecordingResult, state: " + cameraRecordingResult.getRecordingState());
            }
        };
        this.mResouces = activity.getResources();
        this.mHandler = new IntrinsicsJvm.kt_3();
        this.mBrightnessAnimationListener = new PlatformImplementations.kt_3(activity);
        this.mBrightnessAnimator = ValueAnimator.ofFloat(1.0f, BRIGHTNESS_ALPHA_END);
        this.mBrightnessAnimator.setDuration(10000L);
        this.mBrightnessAnimator.addUpdateListener(this.mBrightnessAnimationListener);
        initRecordThread();
    }

    protected void initRecordThread() {
        if (this.mRecordHandlerThread == null) {
            this.mRecordHandlerThread = new HandlerThread("CameraRecorder");
            this.mRecordHandlerThread.start();
            this.mRecordHandler = new Handler(this.mRecordHandlerThread.getLooper()) { // from class: com.oplus.camera.capmode.w.2
                @Override // android.os.Handler
                public void handleMessage(Message message) throws IllegalStateException, IOException {
                    CameraLog.m12954a(VideoMode.TAG, "initRecordThread,  what:" + message.what);
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 == 8) {
                        VideoMode.this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.w.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                VideoMode.this.hideHintViewShowZoom();
                            }
                        });
                        return;
                    }
                    if (OplusGLSurfaceView_13 != 12) {
                        switch (OplusGLSurfaceView_13) {
                            case 1:
                                VideoMode.this.startVideoRecordThread();
                                break;
                            case 2:
                                VideoMode.this.stopVideoRecordThread();
                                break;
                            case 3:
                                VideoMode.this.deleteVideoFile((String) message.obj);
                                break;
                            case 4:
                                VideoMode.this.cleanupEmptyFile((String) message.obj);
                                break;
                            case 5:
                                VideoMode.this.onStopVideoRecording(true);
                                break;
                            case 6:
                                VideoMode.this.prepareVideoSurface();
                                break;
                        }
                        return;
                    }
                    CameraLog.m12954a(VideoMode.TAG, "mRecordSig open");
                    VideoMode.this.mRecordSig.open();
                }
            };
        }
    }

    protected boolean isVideoFlashTorchOpen() {
        if (this.mbFlashTemporaryDisabled) {
            return false;
        }
        if (this.mPreferences == null || !CameraParameter.FlashMode.FLASH_TORCH.equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_video_default_value))) || !getSupportFunction(CameraUIInterface.KEY_VIDEO_FLASH_MODE) || (this.mbFrontCamera && !isMultiVideoMode())) {
            return this.mPreferences != null && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_TORCH_MODE, Util.m24174F(this.mActivity))) && getSupportFunction(CameraFunction.TORCH_SOFT_LIGHT) && this.mbFrontCamera;
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected Thumbnail.IntrinsicsJvm.kt_3 getAfterStoreRunnable() {
        return new Thumbnail.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.capmode.w.3
            @Override // com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12685a(long OplusGLSurfaceView_15) {
                if (VideoMode.this.mbPictureTakenDuringRecord && OplusGLSurfaceView_15 == VideoMode.this.mPictureTakenTime) {
                    VideoMode.this.mHandler.post(new Runnable() { // from class: com.oplus.camera.capmode.w.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            VideoMode.this.mCameraUIInterface.mo18199d(true);
                        }
                    });
                }
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a(TAG, "onPause");
        setLowBatteryState(false);
        Handler handler = this.mRecordHandler;
        if (handler != null) {
            handler.removeMessages(5);
            this.mRecordHandler.removeMessages(6);
        }
        if (this.mOneCamera != null && (!needSurface("type_preview_frame") || !isAnimojiOpen())) {
            this.mOneCamera.mo13118n(!isSlowVideoHighFrame());
        }
        forceStopVideoRecording(false);
        if (this.mCameraInterface != null && !InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
            this.mCameraInterface.mo10465U();
        }
        if (isVideoRecordStopped()) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        synchronized (this.mPrepareVideoSurface) {
            if (isVideoSurfacePreparing()) {
                this.mPrepareVideoSurface.block();
            } else {
                this.mPrepareVideoSurface.open();
            }
        }
        setVideoSurfaceState(0);
        this.mbStartFailue = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        CameraLog.m12954a(TAG, "onResume");
        this.mbMediaLimitProcess = this.mCameraInterface.mo10504aF() && !getSupportFunction(CameraUIInterface.KEY_SUPPORT_VIDEO_THUMBNAIL_SIMULTANEOUS);
        if (this.mbMediaLimitProcess) {
            Thumbnail.m19283c();
        }
        this.mResumePauseRecordingTotalTime = 0L;
        this.mHandler.removeMessages(9);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        if (this.mPreferences != null && !this.mbFrontCamera) {
            return Integer.valueOf(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VIDEO_DEFAULT_FPS)).intValue();
        }
        return Integer.valueOf(VIDEO_DEFAULT_FPS).intValue();
    }

    public String getVideoCodec() {
        return (this.mPreferences == null || this.mActivity == null) ? CameraParameter.VideoEncoder.H264 : this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_CODEC, this.mActivity.getString(R.string.camera_video_codec_default_value));
    }

    public String getDefaultVideoCodec() {
        return this.mActivity.getString(R.string.camera_video_codec_default_value);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a(TAG, "onDestroy");
        if (isVideoRecordStopping()) {
            CameraLog.m12954a(TAG, "onDestroy, block");
            this.mRecordSig.block(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
        HandlerThread handlerThread = this.mRecordHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mRecordHandlerThread = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        ValueAnimator valueAnimator = this.mBrightnessAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mBrightnessAnimator.removeAllUpdateListeners();
            this.mBrightnessAnimator = null;
        }
        if (this.mBrightnessAnimationListener != null) {
            this.mBrightnessAnimationListener = null;
        }
        COUIAlertDialog dialogInterfaceC1289b = this.mCameraErrorAlertDialogBuilder;
        if (dialogInterfaceC1289b != null) {
            if (dialogInterfaceC1289b.isShowing()) {
                this.mCameraErrorAlertDialogBuilder.dismiss();
            }
            this.mCameraErrorAlertDialogBuilder = null;
        }
        synchronized (this.mVideoSurfaceLock) {
            if (this.mVideoSurface != null) {
                this.mVideoSurface.release();
                this.mVideoSurface = null;
            }
        }
        this.mCurrentVideoUri = null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        checkVideoCodecAndReset();
        if (is4k()) {
            Util.m24441e(this.mActivity, "camera_mode_changed");
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_video_shutter_button));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return "video_size_4kuhd".equals(getVideoSizeType()) ? ApsConstant.FEATURE_REC_4KUHD : super.getCameraFeature();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean needUpdateAsdSceneValue() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_ASD_AISCENE_V3_SUPPORT) && !this.mbFrontCamera && isAiEnhancementVideoOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.m19235c("button_shape_ring_none");
        if (isVideoRecording()) {
            shutterButtonInfo.m19226a(2);
            shutterButtonInfo.m19227a("button_color_inside_none");
            shutterButtonInfo.m19230b(1);
        } else {
            shutterButtonInfo.m19227a("button_color_inside_red");
        }
        return shutterButtonInfo;
    }

    public String getDefaultVideoSize() {
        return this.mActivity.getString(R.string.camera_video_size_default);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getVideoFileName() {
        return this.mCurrentVideoFilename;
    }

    protected int configVideoBitRate() {
        return this.mProfile.videoBitRate;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultAFMode() {
        return (!isVideoRecording() || isTrackFocusOpen()) ? 3 : 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(strM13305d)) {
            return getSupportFunction(strM13305d);
        }
        if (CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(strM13305d)) {
            return getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO);
        }
        if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(strM13305d)) {
            return getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO);
        }
        if (CameraUIInterface.KEY_VIDEO_HDR.equals(strM13305d)) {
            return getSupportFunction(CameraFunction.VIDEO_HDR);
        }
        return super.getSupportMenu(strM13305d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            return FilterHelper.f21320j.m22566b(1 == OplusGLSurfaceView_13);
        }
        return super.getFilterNameIdList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            return FilterHelper.f21320j.m22561a(1 == OplusGLSurfaceView_13);
        }
        return super.getFilterTypeList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        if (CameraUIInterface.KEY_SETTING.equals(str)) {
            return isSubMenuEnable();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return getSupportSubMenu(CameraUIInterface.KEY_VIDEO_HDR) || getSupportSubMenu(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return getSupportFunction(CameraUIInterface.KEY_VIDEO_FILTER_MENU) ? CameraUIInterface.KEY_VIDEO_FILTER_INDEX : super.getFilterEffectMenuPreferenceKey();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00dd  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.VideoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10452H();
        }
        if (this.mCameraInterface != null) {
            this.mCameraUIInterface.mo18210f(7, true);
        }
        if (!getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && !getSupportFunction(CameraUIInterface.KEY_QUICK_VIDEO) && !needPostProcessAfterStopRecord()) {
            showRecordingTimeUI();
        }
        this.mbPictureTakenDuringRecord = false;
        this.mbGetDcsData = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (this.mCameraUIInterface == null || this.mCameraInterface == null || this.mCameraInterface.mo10575i()) {
            return;
        }
        this.mCameraUIInterface.mo18167b(4, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        Object obj;
        CaptureResult.Key<int[]> key;
        Integer num;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f(TAG, "onPreviewCaptureResult, invalid totalResult : " + cameraPreviewResult);
            return;
        }
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13253S);
        Object objM13005a2 = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13296ai);
        if (objM13005a2 != null) {
            this.mbEisHalCache = ((Integer) objM13005a2).intValue() > 0;
        }
        if (objM13005a != null && (objM13005a instanceof Integer) && (num = (Integer) objM13005a) != null && this.mActivity != null && 2 == this.mCameraInterface.mo10570g() && (1002 == num.intValue() || 1003 == num.intValue())) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.w.4
                @Override // java.lang.Runnable
                public void run() {
                    VideoMode.this.mCameraInterface.mo10567f();
                }
            });
        }
        this.mFaceCountOnStop = this.mCameraInterface.mo10534aj();
        if (this.mbGetDcsData) {
            this.mbGetDcsData = false;
            if (Util.m24169C()) {
                obj = CameraMetadataKey.f13255U;
                key = CameraMetadataKey.f13254T;
            } else {
                obj = CameraMetadataKey.f13257W;
                key = CameraMetadataKey.f13295ah;
            }
            try {
                if (Util.m24169C()) {
                    float[] fArr = (float[]) captureResult.get(obj);
                    if (fArr != null && fArr.length > 0) {
                        this.mDcsLux = fArr[0];
                    } else {
                        CameraLog.m12954a(TAG, "onPreviewCaptureResult, lux value: " + Arrays.toString(fArr));
                    }
                } else {
                    int[] iArr = (int[]) captureResult.get(obj);
                    if (iArr != null && iArr.length > 0) {
                        this.mDcsLux = iArr[0];
                    } else {
                        CameraLog.m12954a(TAG, "onPreviewCaptureResult, key: " + obj + ", luxIntValues: " + Arrays.toString(iArr));
                    }
                }
                int[] iArr2 = (int[]) captureResult.get(key);
                if (iArr2 != null && iArr2.length > 0) {
                    this.mDcsCCT = iArr2[0];
                } else {
                    CameraLog.m12954a(TAG, "onPreviewCaptureResult, cct value: " + this.mDcsCCT);
                }
                this.mDcsIso = (((Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY)).intValue() * ((Integer) captureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)).intValue()) / 100;
                this.mDcsExp = ((Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME)).longValue();
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12965d(TAG, "onPreviewCaptureResult, getValue error.", COUIBaseListPopupWindow_8);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getSurfaceSize(String str, OplusCameraCharacteristics c2698h) {
        Size sizeFromConfig = getSizeFromConfig(getCameraFeature(), str, BaseMode.EnumC2645a.INPUT);
        return sizeFromConfig != null ? sizeFromConfig : getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        CamcorderProfile profile = getProfile();
        if (profile != null) {
            return new Size(profile.videoFrameWidth, profile.videoFrameHeight);
        }
        return super.getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (isVideoRecording()) {
            if (isVideoRecordStarted() && this.mCameraInterface.mo10570g() == 1) {
                onStopVideoRecording(true);
            } else if (isVideoRecordStarting() && this.mbStartFailue) {
                onStopVideoRecording(false);
            }
            CameraLog.m12954a(TAG, "onBackPressed, isVideoRecording return");
            return true;
        }
        if (isVideoRecordStopping()) {
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z) {
        if (isVideoRecordStarting()) {
            CameraLog.m12954a(TAG, "forceStopVideoRecording, mRecordSig.block");
            this.mRecordSig.close();
            if (!isVideoRecordStarted()) {
                this.mRecordSig.block();
            }
            CameraLog.m12954a(TAG, "forceStopVideoRecording, mRecordSig.block X");
        }
        if (isVideoRecordStarted() || isVideoRecordStarting()) {
            onStopVideoRecording(z);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        CameraLog.m12954a(TAG, "onBeforePreview");
        readProfile();
        this.mbEnableTuningData = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setLowBatteryState(boolean z) {
        this.mbLowBatteryDisabled = z;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void doReturnToCaller(boolean z) {
        int OplusGLSurfaceView_13;
        Intent intent = new Intent();
        if (z) {
            OplusGLSurfaceView_13 = -1;
            intent.setData(this.mCurrentVideoUri);
            intent.addFlags(1);
        } else {
            OplusGLSurfaceView_13 = 0;
        }
        this.mActivity.setResult(OplusGLSurfaceView_13, intent);
        this.mActivity.finish();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void deleteCurrentVideo() {
        CameraLog.m12954a(TAG, "deleteCurrentVideo");
        String str = this.mCurrentVideoFilename;
        if (str != null) {
            this.mRecordHandler.obtainMessage(3, str).sendToTarget();
            this.mCurrentVideoFilename = null;
        }
        this.mCameraUIInterface.mo18269t();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void startPlayVideoActivity() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(this.mCurrentVideoUri, convertOutputFormatToMimeType(getProfile().fileFormat));
        intent.addFlags(1);
        if (!TextUtils.isEmpty(OplusConfigure.m24656f())) {
            intent.putExtra(OplusConfigure.m24656f(), true);
        }
        try {
            this.mActivity.startActivity(intent);
        } catch (ActivityNotFoundException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d(TAG, "startPlayVideoActivity, Couldn't view video: " + this.mCurrentVideoUri, COUIBaseListPopupWindow_8);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12954a(TAG, "onBeforeSnapping");
        if (isVideoRecordStarted()) {
            return true;
        }
        CameraLog.m12967f(TAG, "onBeforeSnapping, is not in RECORD_STARTED");
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    /* renamed from: onVideoShutterButtonClick */
    public void m17833aj() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12967f(TAG, "onVideoShutterButtonClick, mMediaRecorderState: " + this.mMediaRecorderState + ", mCameraInterface.isAnimationRunning: " + this.mCameraInterface.mo10462R());
        if (this.mbPaused || this.mCameraInterface.mo10570g() != 1 || this.mCameraInterface.mo10462R() || this.mCameraInterface.mo10463S() || this.mCameraInterface.mo10449E()) {
            CameraLog.m12967f(TAG, "onVideoShutterButtonClick, mbPaused: " + this.mbPaused + ", CameraState: " + this.mCameraInterface.mo10570g() + ", isAnimationRunning: " + this.mCameraInterface.mo10462R() + ", isBlurAnimRunning: " + this.mCameraInterface.mo10463S() + ", mCameraInterface.getSwitchingCameraState: " + this.mCameraInterface.mo10449E());
            return;
        }
        if (isMultiVideoMode() && !this.mCameraUIInterface.mo18133aW()) {
            CameraLog.m12954a(TAG, "onVideoShutterButtonClick, multi video is not prepared yet");
            return;
        }
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(7, true);
        }
        if (this.mCameraInterface.mo10450F()) {
            CameraLog.m12954a(TAG, "onVideoShutterButtonClick, being capture mode change!");
            return;
        }
        if (Storage.f12097w != 0) {
            this.mCameraUIInterface.mo18269t();
            return;
        }
        if (!isVideoRecording() && !this.mCameraInterface.mo10460P()) {
            CameraLog.m12966e(TAG, "onVideoShutterButtonClick, memory or storage is not enough");
            this.mCameraUIInterface.mo18070a(R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
            reportReminderToDcs(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
            return;
        }
        if (isVideoRecordStarting() || this.mHandler.hasMessages(5)) {
            CameraLog.m12966e(TAG, "onVideoShutterButtonClick, starting or error processing");
            return;
        }
        if (recDisabledReturn()) {
            return;
        }
        if (this.mbRecordAudio && this.mActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            CameraLog.m12967f(TAG, "onVideoShutterButtonClick, permission not granted");
            setHalStatus(0);
            if (Util.m24348ak()) {
                AppCompatDialog dialogC0208f = this.mPGDialog;
                if (dialogC0208f != null && dialogC0208f.isShowing()) {
                    this.mPGDialog.dismiss();
                }
                ExportPGrantUtil.m24539a(this.mActivity, "android.permission.RECORD_AUDIO", new ExportPGrantUtil.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.capmode.w.5
                    @Override // com.oplus.camera.util.ExportPGrantUtil.IntrinsicsJvm.kt_4
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo12686a(AppCompatDialog dialogC0208f2) {
                        VideoMode.this.mPGDialog = dialogC0208f2;
                    }

                    @Override // com.oplus.camera.util.ExportPGrantUtil.IntrinsicsJvm.kt_4
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo12687a(AppCompatDialog dialogC0208f2, boolean z) {
                        if (dialogC0208f2 != null && dialogC0208f2.isShowing()) {
                            dialogC0208f2.dismiss();
                        }
                        if (z) {
                            VideoMode.this.mActivity.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 2);
                        }
                    }
                });
                return;
            }
            this.mActivity.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 2);
            return;
        }
        CameraLog.m12967f(TAG, "onVideoShutterButtonClick, CameraTest Click Video Button");
        if (isVideoRecordStarted()) {
            onStopVideoRecording(true);
        } else if (isVideoRecordStopped()) {
            CameraPerformance.m15185a("start_video_record");
            this.mPreviewVideoCostTime = System.currentTimeMillis() - this.mPreviewOkTime;
            startVideoRecording();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onScreenOffWhenLocked() {
        if (isVideoRecordStarted() || isVideoRecordStarting()) {
            this.mActivity.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.mVideoFilename))));
            CameraLog.m12954a(TAG, "notifyScanVideoFile, sendBroadcast() success");
        }
        if (isVideoRecordStopped()) {
            return;
        }
        this.mHandler.removeMessages(9);
        this.mHandler.sendEmptyMessage(9);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedMetaDataWhenPause() {
        return needVideoPipeline() && this.mbPipelineEnable;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void handleStartError(boolean z, boolean z2) {
        CameraLog.m12954a(TAG, "handleStartError, fromBroadcast: " + z + ", showDialog: " + z2);
        this.mRecordHandler.obtainMessage(3, this.mVideoFilename).sendToTarget();
        if (!isUseMediaCodec()) {
            releaseVideoRecorderWrapper();
        }
        this.mCameraInterface.mo10465U();
        if (isVideoRecordStarting() || isVideoRecordStarted()) {
            onStopVideoRecording(false);
        }
        if (z) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(5);
            }
            this.mActivity.onBackPressed();
        } else {
            this.mCameraUIInterface.mo18283x();
            if ("on".equals(Storage.f12095u) && !Storage.m11142f()) {
                Storage.f12096v = 5;
                Storage.f12095u = "invalid";
                Storage.f12097w = 3;
                this.mEndType = VideoRecordMsgData.END_TYPE_MOMORY_LIMIT;
                this.mCameraUIInterface.mo18269t();
                this.mbStartFailue = false;
                return;
            }
            if (z2) {
                this.mCameraUIInterface.mo18083a(new DialogInterface.OnCancelListener() { // from class: com.oplus.camera.capmode.w.6
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        VideoMode.this.mActivity.onBackPressed();
                    }
                });
            }
        }
        this.mbStartFailue = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingPause() throws IllegalStateException {
        CameraLog.m12954a(TAG, "onVideoRecordingPause");
        if (!isVideoRecordStarted()) {
            CameraLog.m12954a(TAG, "onVideoRecordingPause, VideoRecord is not started, so return");
            return false;
        }
        if (this.mRecordingTotalTime < getRecordingMinTime(true)) {
            CameraLog.m12954a(TAG, "onVideoRecordingPause, mRecordingTotalTime less then 1s, so return");
            return false;
        }
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mCameraUIInterface.mo18205e(false);
        this.mLastPausingTime = SystemClock.uptimeMillis();
        if (isHyperLapseOpen()) {
            this.mOneCamera.mo13008A();
            return true;
        }
        this.mPauseClickTimes++;
        reportPauseClickMsg();
        boolean zM12748g = this.mVideoRecorder.m12748g();
        if (!isUseMediaCodec()) {
            this.mOneCamera.mo13008A();
        }
        return zM12748g;
    }

    private void reportPauseClickMsg() {
        VideoRecordMsgData videoRecordMsgData = new VideoRecordMsgData(this.mActivity);
        videoRecordMsgData.buildEvent(true);
        videoRecordMsgData.mCaptureType = 1;
        videoRecordMsgData.mCaptureMode = getCameraMode();
        videoRecordMsgData.mCameraId = this.mCameraId;
        videoRecordMsgData.mOrientation = this.mOrientation;
        videoRecordMsgData.mBeforePauseDuration = this.mRecordingTotalTime;
        videoRecordMsgData.mPauseTimes = this.mPauseClickTimes;
        onGetBeforeCaptureMsgCommonData(videoRecordMsgData);
        videoRecordMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingResume() throws IllegalStateException {
        CameraLog.m12954a(TAG, "onVideoRecordingResume");
        if (!isVideoRecordStarted()) {
            CameraLog.m12954a(TAG, "onVideoRecordingResume, VideoRecord is not started, so return");
            return false;
        }
        this.mHandler.sendEmptyMessage(1);
        this.mCameraUIInterface.mo18205e(true);
        this.mTotalPausingTime += SystemClock.uptimeMillis() - this.mLastPausingTime;
        this.mLastPausingTime = 0L;
        if (isHyperLapseOpen()) {
            this.mOneCamera.mo13011B();
            return true;
        }
        boolean zM12745f = this.mVideoRecorder.m12745f();
        if (!isUseMediaCodec()) {
            this.mOneCamera.mo13011B();
        }
        return zM12745f;
    }

    private void setVideoSurfaceState(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "setVideoSurfaceState, mVideoSurfaceState: " + this.mVideoSurfaceState + " => " + OplusGLSurfaceView_13);
        this.mVideoSurfaceState = OplusGLSurfaceView_13;
    }

    private boolean isVideoSurfacePrepared() {
        return this.mVideoSurfaceState == 2;
    }

    private boolean isVideoSurfacePreparing() {
        return this.mVideoSurfaceState == 1;
    }

    protected void setVideoRecordState(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "setVideoRecordState, mMediaRecorderState: " + this.mMediaRecorderState + " => " + OplusGLSurfaceView_13);
        this.mMediaRecorderState = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarted() {
        return this.mMediaRecorderState == 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarting() {
        return this.mMediaRecorderState == 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecording() {
        return isVideoRecordStarted() || isVideoRecordStarting();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopped() {
        return this.mMediaRecorderState == 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportGestureCapture() {
        return isVideoRecordStopped();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopping() {
        return this.mMediaRecorderState == 3;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public CamcorderProfile getProfile() {
        return this.mProfile;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.util.Size getVideoPreviewSize(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r4 = "video_size_4kuhd"
            boolean r4 = r4.equals(r5)
            r0 = 720(0x2d0, float:1.009E-42)
            r1 = 1080(0x438, float:1.513E-42)
            r2 = 1920(0x780, float:2.69E-42)
            if (r4 == 0) goto L11
        Le:
            r4 = r1
            r0 = r2
            goto L4c
        L11:
            java.lang.String r4 = "video_size_1080p"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L1a
            goto Le
        L1a:
            java.lang.String r4 = "video_size_720p"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L28
            r4 = 1280(0x500, float:1.794E-42)
            r3 = r0
            r0 = r4
            r4 = r3
            goto L4c
        L28:
            java.lang.String r4 = "video_size_480p"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L33
            r4 = 480(0x1e0, float:6.73E-43)
            goto L4c
        L33:
            java.lang.String r4 = "video_size_cif"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L40
            r0 = 352(0x160, float:4.93E-43)
            r4 = 288(0x120, float:4.04E-43)
            goto L4c
        L40:
            java.lang.String r4 = "video_size_qcif"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto Le
            r0 = 176(0xb0, float:2.47E-43)
            r4 = 144(0x90, float:2.02E-43)
        L4c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getVideoPreviewSize, videoSizeType: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = ", width: "
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = ", height: "
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "VideoMode"
            com.oplus.camera.CameraLog.m12954a(r1, r5)
            android.util.Size r5 = new android.util.Size
            r5.<init>(r0, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.VideoMode.getVideoPreviewSize(java.lang.String):android.util.Size");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Bitmap getVideoThumbnail(int OplusGLSurfaceView_13) {
        ParcelFileDescriptor parcelFileDescriptor = this.mVideoFileDescriptor;
        if (parcelFileDescriptor != null) {
            return Thumbnail.m19269a(parcelFileDescriptor.getFileDescriptor(), OplusGLSurfaceView_13);
        }
        String str = this.mCurrentVideoFilename;
        if (str != null) {
            return Thumbnail.m19271a(str, OplusGLSurfaceView_13);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_11
    public void onException(int OplusGLSurfaceView_13) {
        CameraLog.m12954a(TAG, "onException, exceptionCode: " + OplusGLSurfaceView_13);
        if (1 != OplusGLSurfaceView_13 || isVideoRecordStopped()) {
            return;
        }
        onStopVideoRecording(false);
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_12
    public void onError(Object obj, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a(TAG, "onError, what: " + OplusGLSurfaceView_13 + ", extra: " + i2);
        if (isUseMediaCodec() || (OplusGLSurfaceView_13 != 1 && i2 != -1007)) {
            if (!isUseMediaCodec()) {
                return;
            }
            if (OplusGLSurfaceView_13 != 1100 && OplusGLSurfaceView_13 != 1101 && OplusGLSurfaceView_13 >= 0) {
                return;
            }
        }
        if (isUseMediaCodec() && OplusGLSurfaceView_13 < 0) {
            CameraLog.m12967f(TAG, "onError, kill myself");
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10461Q();
                return;
            }
        }
        if (isVideoRecordStopped()) {
            return;
        }
        onStopVideoRecording(true);
        if (isUseMediaCodec() || -1007 != i2) {
            return;
        }
        showPreparingErrorDialog();
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_10
    public void onInfo(Object obj, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a(TAG, "onInfo");
        if (OplusGLSurfaceView_13 == 800) {
            if (isVideoRecordStarted()) {
                onStopVideoRecording(true);
            }
        } else if ((OplusGLSurfaceView_13 == 801 || OplusGLSurfaceView_13 == 802) && isVideoRecordStarted()) {
            this.mbShowHint = true;
            onStopVideoRecording(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteVideoFile(String str) {
        CameraLog.m12954a(TAG, "deleteVideoFile, fileName: " + str);
        if (str == null) {
            this.mRecordFileNameChange.open();
            return;
        }
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            CameraLog.m12954a(TAG, "deleteVideoFile, Could not delete " + str);
        }
        if (this.mCurrentVideoUri != null) {
            try {
                try {
                    this.mActivity.getContentResolver().delete(this.mCurrentVideoUri, null, null);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            } finally {
                this.mCurrentVideoUri = null;
            }
        }
        this.mRecordFileNameChange.open();
    }

    protected void closeVideoFileDescriptor() throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = this.mVideoFileDescriptor;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                CameraLog.m12965d(TAG, "closeVideoFileDescriptor, Fail to close fd", COUIBaseListPopupWindow_8);
            }
            this.mVideoFileDescriptor = null;
        }
    }

    private void releaseVideoRecorderWrapper() {
        CameraLog.m12954a(TAG, "releaseVideoRecorderWrapper, Releasing media recorder.");
        synchronized (this.mVideoRecorderSig) {
            if (this.mVideoRecorder != null) {
                if (this.mVideoFilename != null) {
                    this.mRecordHandler.obtainMessage(4, this.mVideoFilename).sendToTarget();
                }
                this.mVideoRecorder.m12739d();
                this.mVideoRecorder = null;
            }
        }
    }

    private void stopCheckStorageAsyncTask() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(2);
        }
        AsyncTask asyncTask = this.mCheckStorageTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mCheckStorageTask = null;
        }
    }

    private void stopUpdateRecordTime() {
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreVideoPreviewState() {
        this.mTotalPausingTime = 0L;
        this.mLastPausingTime = 0L;
        this.mBrightness = 255.0f;
        stopCheckStorageAsyncTask();
        if (this.mCameraInterface != null && !InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
            this.mCameraInterface.mo10465U();
        }
        if (this.mHandler != null) {
            stopUpdateRecordTime();
            this.mHandler.removeMessages(4);
            this.mHandler.removeMessages(3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean stopVideoRecording() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.VideoMode.stopVideoRecording():boolean");
    }

    protected void onStopVideoRecording(boolean z) {
        CameraLog.m12954a(TAG, "onStopVideoRecording, checkRecordTime: " + z);
        this.mbStartFailue = false;
        this.mRecordingEndTemperature = this.mPreferences.getFloat(CameraUIInterface.KEY_CURRENT_TEMPERATURE, -1.0f);
        if (!this.mbPaused && this.mOneCamera != null && (!Util.m24169C() || !isHFR())) {
            this.mOneCamera.mo13009A(0);
        }
        if (!this.mbPaused && this.mCameraInterface != null && this.mCameraInterface.mo10575i() && !supportParameterAdjust() && this.mOneCamera != null) {
            this.mCameraInterface.mo10527ac();
            this.mCameraInterface.mo10556b(false, false);
            this.mOneCamera.mo13029a(3, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        CameraPerformance.m15185a("video_save");
        setVideoRecordState(3);
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(7)) {
            this.mHandler.removeMessages(7);
        }
        if (this.mCameraInterface != null && !this.mCameraInterface.mo10549ay()) {
            this.mCameraInterface.mo10458N();
        }
        this.mRecordSig.close();
        Handler handler2 = this.mHandler;
        if (handler2 != null && handler2.hasMessages(6)) {
            this.mHandler.removeMessages(6);
        }
        Handler handler3 = this.mHandler;
        if (handler3 != null && handler3.hasMessages(13)) {
            this.mHandler.removeMessages(13);
        }
        this.mBrightnessAnimator.cancel();
        if (this.mCameraInterface != null && needVideoPipeline() && !isHalEisCache() && (isSlowVideoHighFrame() || isHyperLapseOpen())) {
            this.mOneCamera.mo13152z();
        }
        if (this.mRecordHandler != null && !getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && !isHyperLapseOpen()) {
            this.mRecordHandler.removeMessages(2);
            this.mRecordHandler.sendEmptyMessage(2);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10457M();
        }
        FluencyPerformance.m15140e(System.currentTimeMillis());
    }

    protected void stopVideoRecordThread() {
        Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(7)) {
            this.mHandler.removeMessages(7);
        }
        String videoTitle = getVideoTitle();
        boolean z = this.mbHasDragIntelligentView;
        this.mbStopVideoFail = stopVideoRecording();
        final boolean zIsRecordFileValid = isRecordFileValid();
        if (!zIsRecordFileValid) {
            if (this.mVideoFilename != null) {
                this.mRecordFileNameChange.close();
                this.mRecordHandler.obtainMessage(3, this.mVideoFilename).sendToTarget();
            }
            onVideoRecordingFail();
        } else {
            this.mbPictureTakenDuringRecord = false;
            if (isDoubleExposureOpen()) {
                if (checkVideoFileReady(this.mVideoFilename)) {
                    onVideoRecordingFinish();
                } else {
                    onVideoRecordingFail();
                }
            }
        }
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.w.7
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoMode.this.mbDestroyed) {
                        return;
                    }
                    if (VideoMode.this.isVideoHdrOpen() && VideoMode.this.isCommonVideoMode()) {
                        VideoMode.this.mCameraUIInterface.mo18166b(R.string.camera_video_hdr, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                    }
                    if (VideoMode.this.isUltraNightVideoOpen() && VideoMode.this.isCommonVideoMode()) {
                        VideoMode.this.mCameraUIInterface.mo18166b(R.string.camera_ultra_video_night, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
                    }
                    if (VideoMode.this.mPreviewEffectProcess != null) {
                        VideoMode.this.mPreviewEffectProcess.mo22831f(false);
                    }
                    VideoMode.this.mCameraInterface.mo10459O();
                    VideoMode.this.stopShutterButtonProgress();
                    VideoMode.this.restoreVideoPreviewState();
                }
            });
        }
        final Thumbnail.IntrinsicsJvm.kt_5 dVar = new Thumbnail.IntrinsicsJvm.kt_5();
        dVar.f18298k = 1;
        if (zIsRecordFileValid && this.mActivity != null) {
            if (!isDoubleExposureOpen()) {
                addVideoToMediaStore(dVar, z, videoTitle);
            }
            dVar.f18291d = this.mCurrentVideoUri;
        }
        Handler handler2 = this.mHandler;
        if (handler2 == null) {
            return;
        }
        handler2.post(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$w$OplusGLSurfaceView_6-1Sq3iArwzFawybFCdK_j6Tj5o
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.COUIBaseListPopupWindow_12$0.lambda$stopVideoRecordThread$0$w(dVar, zIsRecordFileValid);
            }
        });
        if (this.mHandler.hasMessages(9)) {
            this.mHandler.removeMessages(9);
            this.mHandler.sendEmptyMessageDelayed(9, 100L);
        }
        this.mRecordHandler.sendEmptyMessageDelayed(12, 300L);
    }

    public /* synthetic */ void lambda$stopVideoRecordThread$0$w(Thumbnail.IntrinsicsJvm.kt_5 dVar, boolean z) throws IOException {
        if (this.mbDestroyed) {
            CameraLog.m12954a(TAG, "stopVideoRecordThread, return");
            return;
        }
        resumeAudioPlayback();
        int OplusGLSurfaceView_13 = (this.mStartRecordingOrientation + 90) % 360;
        CameraLog.m12954a(TAG, "stopVideoRecordThread, mStartRecordingOrientation: " + this.mStartRecordingOrientation + ", orientation: " + OplusGLSurfaceView_13);
        dVar.f18289b = OplusGLSurfaceView_13;
        this.mCameraInterface.mo10485a(dVar, z ^ true, isDoubleExposureOpen() ^ true);
        closeVideoFileDescriptor();
        setVideoRecordState(2);
        if (this.mCameraInterface.mo10523aY()) {
            this.mCameraInterface.mo10524aZ();
        }
        if (this.mbShowHint) {
            ToastUtil.m24640a(this.mActivity, R.string.camera_video_reach_size_limit);
            this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
            this.mCameraInterface.mo10563d(false);
            this.mRecordHandler.removeMessages(8);
            this.mRecordHandler.sendEmptyMessageDelayed(8, 3000L);
            this.mbShowHint = false;
            reportReminderToDcs(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_VIDEO_SIZE_LIMIT);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoRecordingFail() {
        CameraLog.m12967f(TAG, "onVideoRecordingFail");
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10569f(true);
        } else {
            CameraLog.m12967f(TAG, "onVideoRecordingFail, mCameraInterface is null");
        }
    }

    private boolean checkVideoFileReady(String str) throws InterruptedException {
        CameraLog.m12954a(TAG, "checkVideoFileReady, videoFilename: " + str);
        File file = new File(str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        try {
            Thread.sleep(WAIT_FOR_VIDEO_DURATION);
        } catch (InterruptedException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        File file2 = new File(str);
        boolean zExists = file2.exists();
        long length = file2.length();
        CameraLog.m12954a(TAG, "checkVideoFileReady, exist: " + zExists + ", fileLength: " + length);
        return zExists && length > 0;
    }

    protected boolean isRecordFileValid() {
        CameraLog.m12954a(TAG, "isRecordFileValid, mbStopVideoFail:  " + this.mbStopVideoFail + ", mRecordingTotalTime: " + this.mRecordingTotalTime);
        return !this.mbStopVideoFail && ((long) getRecordingMinTime(false)) <= this.mRecordingTotalTime;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e7 A[Catch: Exception -> 0x00d4, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x00d4, blocks: (B:27:0x00d0, B:37:0x00e7), top: B:101:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012f A[Catch: all -> 0x01f2, Exception -> 0x01f4, Merged into TryCatch #2 {all -> 0x01f2, Exception -> 0x01f4, blocks: (B:52:0x0129, B:54:0x012f, B:56:0x0135, B:58:0x015e, B:60:0x016c, B:62:0x0170, B:64:0x0191, B:65:0x0196, B:57:0x014f, B:70:0x01f5), top: B:97:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024d  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean addVideoToMediaStore(com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_5 r16, boolean r17, java.lang.String r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.VideoMode.addVideoToMediaStore(com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5, boolean, java.lang.String):boolean");
    }

    protected Size getSizeFromConfig(String str, String str2, BaseMode.EnumC2645a enumC2645a) {
        Size videoPreviewSize;
        Size size;
        if (isRearSuperEISOpen() || isVideoSuperEisWideOpen() || isHyperLapseOpen() || getProfile() == null) {
            videoPreviewSize = null;
            size = null;
        } else {
            videoPreviewSize = getVideoPreviewSize(getVideoSizeType());
            size = new Size(getProfile().videoFrameWidth, getProfile().videoFrameHeight);
        }
        AlgoSwitchConfig.PreviewConfig previewConfig = str != null ? AlgoSwitchConfig.getPreviewConfig(str, this.mCameraId, videoPreviewSize, size, needApsToProcessVideoWatermark(), ApsConstant.FEATURE_REC_SAT_HAL.equals(str) || ApsConstant.FEATURE_REC_4KUHD.equals(str) || ApsConstant.FEATURE_REC_LIVE_HDR.equals(str) || ApsConstant.FEATURE_REC_ULTRA_NIGHT.equals(str) || ApsConstant.FEATURE_REC_AI_ENHANCEMENT.equals(str) || (ApsConstant.REC_MODE_COMMON.equals(str) && 1 == this.mCameraId) || (ApsConstant.REC_MODE_FAST_VIDEO.equals(str) && 1 == this.mCameraId), ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) && this.mCameraId == 0) : null;
        if (previewConfig != null && previewConfig.mComponentMap.containsKey("video")) {
            AlgoSwitchConfig.PreviewConfig.Component component = previewConfig.mComponentMap.get("video");
            this.mPreviewConfig = previewConfig;
            if (component.mbEnable) {
                if ("type_video_frame".equals(str2)) {
                    if (enumC2645a == BaseMode.EnumC2645a.INPUT) {
                        return new Size(component.mMasterInputWidth, component.mMasterInputHeight);
                    }
                    return new Size(component.mOutputWidth, component.mOutputHeight);
                }
                if ("type_still_capture_yuv_main".equals(str2)) {
                    return new Size(component.mOutputWidth, component.mOutputHeight);
                }
            }
        }
        if (previewConfig != null && previewConfig.mComponentMap.containsKey("preview")) {
            AlgoSwitchConfig.PreviewConfig.Component component2 = previewConfig.mComponentMap.get("preview");
            this.mPreviewConfig = previewConfig;
            if (component2.mbEnable && "type_main_preview_frame".equals(str2)) {
                return new Size(component2.mMasterInputWidth, component2.mMasterInputHeight);
            }
        }
        this.mPreviewConfig = previewConfig;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoRecordThread() {
        CameraLog.m12954a(TAG, "startVideoRecordThread");
        if (this.mbPaused) {
            return;
        }
        boolean z = false;
        try {
            try {
                this.mVideoRecorder.m12740e();
                if (this.mOneCamera != null && !Util.m24169C()) {
                    this.mOneCamera.mo13034a(getVideoFpsRange());
                }
                if (this.mOneCamera != null) {
                    setRecordingParameter();
                    if (!isUseMediaCodec()) {
                        this.mOneCamera.mo13042a(this.mCameraRecordingCallback, this.mRecordHandler);
                    } else {
                        this.mOneCamera.mo13009A(1);
                    }
                }
                boolean zM12730b = this.mVideoRecorder.m12730b();
                this.mRecordingTotalTime = 0L;
                CameraLog.m12954a(TAG, "startVideoRecordThread, start end, result: " + zM12730b + ", isUseMediaCodec: " + isUseMediaCodec());
                if (zM12730b) {
                    if (this.mPreviewEffectProcess != null) {
                        this.mPreviewEffectProcess.mo22831f(true);
                    }
                    setVideoRecordState(0);
                    this.mWaitRecordStarted.open();
                    if (this.mHandler.hasMessages(10)) {
                        this.mHandler.removeMessages(10);
                        this.mHandler.sendEmptyMessageDelayed(10, 1000L);
                    }
                    if (this.mHandler.hasMessages(7)) {
                        this.mHandler.removeMessages(7);
                    }
                    this.mHandler.sendEmptyMessage(7);
                } else if (isUseMediaCodec() && this.mbDisplayOnLock) {
                    this.mHandler.sendEmptyMessage(5);
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                String parameters = ((AudioManager) this.mActivity.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getParameters(KEY_RECORD_FORBID);
                CameraLog.m12965d(TAG, "startVideoRecordThread failed, mVideoFilename: " + this.mVideoFilename + ", value: " + parameters, COUIBaseListPopupWindow_8);
                this.mbStartFailue = true;
                if ((!TextUtils.isEmpty(parameters) && "true".contains(parameters)) || (!isUseMediaCodec() && this.mbDisplayOnLock)) {
                    z = true;
                }
                this.mHandler.obtainMessage(5, Boolean.valueOf(z)).sendToTarget();
            }
        } finally {
            this.mRecordSig.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoRecordHandler() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        startShutterButtonProgress();
        this.mRecordingStartTime = SystemClock.uptimeMillis();
        updateRecordingTime();
        this.mCameraUIInterface.mo18205e(true);
        this.mCameraInterface.mo10566e(true);
        CameraLog.m12954a(TAG, "startVideoRecordHandler end");
    }

    protected void showRecordingTimeUI() {
        this.mCameraUIInterface.mo18096a(getRealVideoTimeRatio(), getDimensionPixelSize(R.dimen.record_time_margin_top), needShowVideoTime(), true);
    }

    public void showPreparingErrorDialog() {
        if (this.mCameraErrorAlertDialogBuilder != null) {
            if (!(this.mActivity instanceof Activity) || this.mActivity.isFinishing()) {
                return;
            }
            this.mCameraErrorAlertDialogBuilder.show();
            return;
        }
        String string = this.mActivity.getString(R.string.camera_video_prepare_error_dialog_message_1080);
        COUIAlertDialog.PlatformImplementations.kt_3 aVar = new COUIAlertDialog.PlatformImplementations.kt_3(this.mActivity);
        aVar.setTitle(string);
        aVar.setPositiveButton(R.string.camera_video_prepare_error_dialog_switch, this.mCameraErrorPositiveButtonListener);
        aVar.setNegativeButton(R.string.camera_video_prepare_error_dialog_cancel, (DialogInterface.OnClickListener) null);
        this.mCameraErrorAlertDialogBuilder = aVar.create();
        if ((this.mActivity instanceof Activity) && !this.mActivity.isFinishing()) {
            this.mCameraErrorAlertDialogBuilder.show();
        }
        if (this.mCameraErrorAlertDialogBuilder.mo901a(-1) != null) {
            TextViewCompat.m3048a(this.mCameraErrorAlertDialogBuilder.mo901a(-1), R.style.CameraErrorPositiveButtonStyle);
        }
        if (this.mCameraErrorAlertDialogBuilder.mo901a(-2) != null) {
            TextViewCompat.m3048a(this.mCameraErrorAlertDialogBuilder.mo901a(-2), R.style.CameraErrorNegativeButtonStyle);
        }
    }

    private int getDimensionPixelSize(int OplusGLSurfaceView_13) {
        Resources resources = this.mResouces;
        if (resources != null) {
            return resources.getDimensionPixelSize(OplusGLSurfaceView_13);
        }
        return 0;
    }

    private void startVideoRecording() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (1 == Settings.System.getInt(this.mActivity.getContentResolver(), "oplus.camera.video", 0)) {
            setVideoRecordState(2);
            this.mCameraUIInterface.mo18070a(R.string.camera_high_temperature_video_record_disable, -1, true, false, false);
            CameraLog.m12967f(TAG, "startVideoRecording, Can't start recording video due to high temperature, so return");
            return;
        }
        this.mRecordingStartTemperature = this.mPreferences.getFloat(CameraUIInterface.KEY_CURRENT_TEMPERATURE, -1.0f);
        boolean zMo10455K = this.mCameraInterface.mo10455K();
        this.mbShowHint = false;
        this.mbVideoFrameInAPS = isVideoFrameProcessInAPS();
        if (this.mRecordHandler.hasMessages(8)) {
            this.mRecordHandler.removeMessages(8);
            hideHintViewShowZoom();
        }
        sendBoradCastToStopRecordSound();
        sendBoradCastToStopVideo();
        if (!zMo10455K) {
            setVideoRecordState(2);
            CameraLog.m12967f(TAG, "startVideoRecording, ret is false, so return");
            return;
        }
        CameraLog.m12954a(TAG, "startVideoRecording, mVideoRecorder: " + this.mVideoRecorder);
        FluencyPerformance.m15138d(System.currentTimeMillis());
        if (is4k()) {
            Util.m24441e(this.mActivity, "camera_video_recorder");
        }
        updateVideoWatermarkResource();
        this.mRecordHandler.removeMessages(12);
        this.mRecordHandler.removeMessages(5);
        if ((!getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) || isMotionDetectOpen()) && !needPostProcessAfterStopRecord()) {
            this.mHandler.sendEmptyMessageDelayed(4, 200L);
        }
        if (!needPostProcessAfterStopRecord()) {
            this.mHandler.sendEmptyMessageDelayed(3, 200L);
        }
        setVideoRecordState(1);
        this.mRecordSig.close();
        this.mCurrentVideoUri = null;
        this.mRecordingTotalTime = 0L;
        if (!initVideoFileDescriptor()) {
            CameraLog.m12967f(TAG, "startVideoRecording, init FileDescriptor fail");
            return;
        }
        initializeRecorder();
        pauseAudioPlayback();
        this.mCameraInterface.mo10558c(4);
        this.mHandler.removeMessages(6);
        this.mHandler.sendEmptyMessageDelayed(6, 10000L);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.f12542x7bcc43c9)) {
            this.mHandler.removeMessages(13);
            this.mHandler.sendEmptyMessageDelayed(13, 300000L);
        }
        this.mVideoWatermarkOrientation = this.mOrientation;
        this.mRecordHandler.sendEmptyMessage(1);
        this.mCameraInterface.mo10456L();
        RegionCommonFeatureAdapter.m14526a(this.mActivity.getContentResolver(), 1);
        this.mHandler.sendEmptyMessageDelayed(2, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        this.mStartRecordingOrientation = this.mCameraInterface.mo10591u();
        this.mStartRecordingFaceCount = this.mCameraInterface.mo10534aj();
        this.mShutterType = getCameraShutterType();
        this.mCameraInterface.mo10488a("normal");
        CameraLog.m12954a(TAG, "afterInitRecorder end");
    }

    private boolean isVideoFrameProcessInAPS() {
        AlgoSwitchConfig.PreviewConfig.Component component;
        AlgoSwitchConfig.PreviewConfig previewConfig = this.mPreviewConfig;
        if (previewConfig == null || previewConfig.mComponentMap == null || (component = this.mPreviewConfig.mComponentMap.get("video")) == null) {
            return false;
        }
        String[] strArr = component.mAlgoList;
        if (Util.m24301a(strArr)) {
            return false;
        }
        for (String str : strArr) {
            if (APS_VIDEO_SUPER_EIS.equals(str) || APS_VIDEO_EIS.equals(str)) {
                return true;
            }
            if (getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && "preview_video_frc".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void setVideoWaterMarkParameter() {
        if (isSloganOpen()) {
            if (isUseMediaCodec()) {
                int iMo10591u = this.mCameraInterface.mo10591u() % 360;
                if (this.mPreviewEffectProcess != null) {
                    this.mPreviewEffectProcess.mo22824d(iMo10591u);
                    this.mPreviewEffectProcess.mo22783a(this.mCameraInterface.mo10541aq().m11695a(iMo10591u));
                    this.mPreviewEffectProcess.mo22835g(true);
                    return;
                }
                return;
            }
            SloganUtil c2612adMo10541aq = this.mCameraInterface.mo10541aq();
            BaseSloganUtil.PlatformImplementations.kt_3 aVarMo10542ar = this.mCameraInterface.mo10542ar();
            if (c2612adMo10541aq == null || aVarMo10542ar == null || aVarMo10542ar.m11713b() == null || aVarMo10542ar.m11714c() == 0 || aVarMo10542ar.m11706a() == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("orientation", isSloganForceLandscape() ? 270 : this.mVideoWatermarkOrientation);
            bundle.putInt(CameraParameter.WaterMarkParamKeys.REF_WIDTH, aVarMo10542ar.m11714c());
            bundle.putInt(CameraParameter.WaterMarkParamKeys.WATERMARK_BORDER_X, aVarMo10542ar.m11716d());
            bundle.putInt(CameraParameter.WaterMarkParamKeys.WATERMARK_BORDER_Y, aVarMo10542ar.m11718e());
            bundle.putSize(CameraParameter.WaterMarkParamKeys.SIZE, aVarMo10542ar.m11706a());
            bundle.putString(CameraParameter.WaterMarkParamKeys.FILE_PATH, c2612adMo10541aq.m11702d());
            bundle.putByteArray(CameraParameter.WaterMarkParamKeys.YUV_BUFFER, aVarMo10542ar.m11713b());
            this.mOneCamera.mo13033a(bundle);
            return;
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22783a((BaseSloganUtil.PlatformImplementations.kt_3) null);
        }
    }

    private void setRecordingParameter() {
        String currFilterType = getCurrFilterType();
        this.mOneCamera.mo13046a(currFilterType, isFilterOpen(currFilterType), getSupportFunction(CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(currFilterType));
        this.mOneCamera.mo13055a(isFaceBeautyOrMakeupOpen(), String.valueOf(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE)), Util.m24311a(getCustomBeautyValues()));
        this.mOneCamera.mo13100h(getSupportFunction(CameraFunction.DERED_EYE) && isFlashState());
        setVideoWaterMarkParameter();
    }

    private void updateVideoWatermarkResource() {
        if (!isSloganOpen() || this.mCameraInterface == null) {
            return;
        }
        CameraLog.m12952a("getVideoWatermark");
        boolean z = !isUseMediaCodec();
        CameraLog.m12959b(TAG, "updateVideoWatermarkResource, needToSetToHal: " + z);
        this.mCameraInterface.mo10595y();
        this.mCameraInterface.mo10490a(z, isMovieMode() ? 2 : 1, isSloganForceLandscape(), 1, false);
        CameraLog.m12958b("getVideoWatermark");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(CameraRequestTag c2693c) throws Resources.NotFoundException {
        super.updateCaptureParam(c2693c);
        boolean z = getSupportFunction(CameraFunction.VIDEO_RETENTION) && isVideoRetentionOpen();
        if (c2693c.f13413h) {
            VideoFusionTexturePreview c3400ad = (VideoFusionTexturePreview) this.mPreviewEffectProcess.mo22843j(32);
            Bundle bundle = new Bundle();
            bundle.putInt("orientation", getVideoOrientation(this.mOrientation));
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Bundle>>) CameraParameter.VIDEO_EFFECT_PARAM, (CameraParameter.PreviewKey<Bundle>) bundle);
            this.mOneCamera.mo13049a(c2693c.f13413h, c3400ad.mo22428y() ? 5 : 0, Arrays.toString(c3400ad.m22458q()));
        } else if (getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS) && isBlurOpen()) {
            TexturePreview abstractC3428yMo22843j = this.mPreviewEffectProcess.mo22843j(32);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(CameraParameter.VideoEffectParamKeys.BLUR_LEVEL, abstractC3428yMo22843j.mo22428y() ? getBlurIndex() : 0);
            bundle2.putInt("orientation", getVideoOrientation(this.mOrientation));
            bundle2.putFloat(CameraParameter.VideoEffectParamKeys.BLUR_SHOW, getShowBlurValue());
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Bundle>>) CameraParameter.VIDEO_EFFECT_PARAM, (CameraParameter.PreviewKey<Bundle>) bundle2);
            int[] iArrMo22437z = abstractC3428yMo22843j.mo22437z();
            if (iArrMo22437z != null) {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_BLUR_PARAMS, (CameraParameter.PreviewKey<String>) Arrays.toString(iArrMo22437z));
            }
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_BLUR_ENABLE, (CameraParameter.PreviewKey<String>) "on");
        } else if (z) {
            TexturePreview abstractC3428yMo22843j2 = this.mPreviewEffectProcess.mo22843j(256);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("orientation", getVideoOrientation(this.mOrientation));
            bundle3.putBoolean(CameraParameter.VideoEffectParamKeys.RETENTION_PROCESS, abstractC3428yMo22843j2.mo22428y());
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Bundle>>) CameraParameter.VIDEO_EFFECT_PARAM, (CameraParameter.PreviewKey<Bundle>) bundle3);
        }
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_RETENTION_OPEN, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        CameraLog.m12962c(TAG, "setConfigureParameter");
        if (isSloganOpen()) {
            builder.setParameter(CameraParameter.WATERMARK_VIDEO_ENABLE, "on");
        }
        if (CameraParameter.VideoEncoder.H264.equals(getVideoCodec())) {
            builder.setParameter(CameraParameter.VIDEO_ENCODER, CameraParameter.VideoEncoder.H264);
            if (this.mProfile != null) {
                builder.setParameter(CameraParameter.VIDEO_BITRATE, Integer.valueOf(this.mProfile.videoBitRate));
            }
        } else if (CameraParameter.VideoEncoder.H265.equals(getVideoCodec())) {
            builder.setParameter(CameraParameter.VIDEO_ENCODER, CameraParameter.VideoEncoder.H265);
            if (this.mProfile != null) {
                builder.setParameter(CameraParameter.VIDEO_BITRATE, Integer.valueOf(this.mProfile.videoBitRate / 2));
            }
        }
        if (needSurface("type_video")) {
            CameraLog.m12954a(TAG, "setConfigureParameter, mVideoSurfaceState: " + this.mVideoSurfaceState);
            synchronized (this.mPrepareVideoSurface) {
                if (!isVideoSurfacePrepared()) {
                    if (!this.mRecordHandler.hasMessages(6) && !isVideoSurfacePreparing()) {
                        CameraLog.m12954a(TAG, "configSessionSurface, send MSG_PREPARE_VIDEO_SURFACE");
                        this.mRecordHandler.sendEmptyMessage(6);
                    }
                    this.mPrepareVideoSurface.close();
                    this.mPrepareVideoSurface.block();
                }
            }
            setVideoSurfaceState(0);
            synchronized (this.mVideoSurfaceLock) {
                if (this.mVideoSurface != null && this.mProfile != null) {
                    builder.setVideoConfig(new CameraDeviceConfig.VideoConfig(CameraCharacteristicsUtil.m12978b(this.mOneCamera.mo13075c()), new Size(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight), this.mVideoSurface));
                }
            }
        }
    }

    private void resumeAudioPlayback() {
        AudioManager audioManager = (AudioManager) this.mActivity.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (!this.mbBroadcastPauseMusic) {
            CameraLog.m12954a(TAG, "resumeAudioPlayback, Not send broadcast to restore the background music: " + audioManager.abandonAudioFocus(null));
            return;
        }
        CameraLog.m12954a(TAG, "resumeAudioPlayback, send broadcast to restore the background music: 0");
        Intent intent = new Intent("com.heytap.music.musicservicecommand.resume");
        intent.putExtra("command", "VideoReqMusicRestore");
        this.mActivity.sendBroadcast(intent);
    }

    private void pauseAudioPlayback() {
        CameraLog.m12954a(TAG, "pauseAudioPlayback");
        int iRequestAudioFocus = ((AudioManager) this.mActivity.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).requestAudioFocus(null, 3, 2);
        if (iRequestAudioFocus == 1) {
            CameraLog.m12954a(TAG, "pauseAudioPlayback, Not send broadcast to pause the background music: " + iRequestAudioFocus);
            this.mbBroadcastPauseMusic = false;
        }
        if (iRequestAudioFocus == 0) {
            CameraLog.m12954a(TAG, "pauseAudioPlayback, send broadcast to pause the background music: " + iRequestAudioFocus);
            this.mbBroadcastPauseMusic = true;
            Intent intent = new Intent("com.heytap.music.musicservicecommand.pause");
            intent.putExtra("command", "VideoReqMusicPause");
            this.mActivity.sendBroadcast(intent);
        }
    }

    private boolean recDisabledReturn() {
        CameraLog.m12954a(TAG, "recDisabledReturn");
        if (!this.mbLowBatteryDisabled) {
            return false;
        }
        this.mCameraUIInterface.mo18070a(R.string.camera_low_battery_rec_disabled, -1, true, false, false);
        reportReminderToDcs(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_VIDEO);
        return true;
    }

    private String createName(long OplusGLSurfaceView_15) {
        return new SimpleDateFormat(this.mActivity.getResources().getString(R.string.camera_video_file_name_format), Locale.US).format(new Date(OplusGLSurfaceView_15));
    }

    private void generateVideoFilename(int OplusGLSurfaceView_13) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strCreateName = createName(jCurrentTimeMillis);
        String str = strCreateName + convertOutputFormatToFileExt(OplusGLSurfaceView_13);
        String strConvertOutputFormatToMimeType = convertOutputFormatToMimeType(OplusGLSurfaceView_13);
        this.mVideoSavePath = getVideoSavePath();
        String str2 = this.mVideoSavePath + str;
        CameraLog.m12954a(TAG, "generateVideoFilename, path: " + str2 + ", mime: " + strConvertOutputFormatToMimeType);
        this.mFileName = str;
        this.mVideoFilename = str2;
        this.mCurrentVideoValues = new ContentValues(7);
        this.mCurrentVideoValues.put("title", strCreateName);
        this.mCurrentVideoValues.put("_display_name", str);
        this.mCurrentVideoValues.put("datetaken", Long.valueOf(jCurrentTimeMillis));
        this.mCurrentVideoValues.put("mime_type", strConvertOutputFormatToMimeType);
        this.mCurrentVideoValues.put("relative_path", Storage.m11140e(null));
        this.mCurrentVideoValues.put("is_pending", (Integer) 1);
        if (isNeedGenerateUri()) {
            this.mCurrentVideoUri = MediaStoreUtil.m24650a(this.mActivity, this.mActivity.getContentResolver(), this.mCurrentVideoValues);
            try {
                this.mVideoFileDescriptor = this.mActivity.getContentResolver().openFileDescriptor(this.mCurrentVideoUri, "rw");
            } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
        this.mVideoOrientation = this.mCameraInterface.mo10591u();
        this.mVideoAeAfLock = this.mCameraInterface.mo10529ae();
        CamcorderProfile profile = getProfile();
        this.mCurrentVideoValues.put("resolution", Integer.toString(profile.videoFrameWidth) + "x" + Integer.toString(profile.videoFrameHeight));
        this.mCurrentVideoValues.put("width", Integer.toString(profile.videoFrameWidth));
        this.mCurrentVideoValues.put("height", Integer.toString(profile.videoFrameHeight));
        Location locationMo10595y = this.mCameraInterface.mo10595y();
        if (locationMo10595y != null) {
            this.mCurrentVideoValues.put("latitude", Double.valueOf(locationMo10595y.getLatitude()));
            this.mCurrentVideoValues.put("longitude", Double.valueOf(locationMo10595y.getLongitude()));
        }
        CameraLog.m12954a(TAG, "generateVideoFilename, New video filename: " + this.mVideoFilename);
    }

    protected String getVideoSavePath() {
        if (Storage.f12095u.equals("off")) {
            return Storage.f12091q + '/';
        }
        return Storage.f12086l + '/';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupEmptyFile(String str) {
        CameraLog.m12954a(TAG, "cleanupEmptyFile");
        if (str != null) {
            File file = new File(str);
            if (file.length() == 0 && file.delete()) {
                CameraLog.m12954a(TAG, "cleanupEmptyFile, Empty video file deleted: " + str);
            }
        }
    }

    protected boolean getNeedReduceBitRate() {
        return !(120 == getVideoFps() || "video_size_1080p".equals(this.mVideoSizeType) || ("video_size_720p".equals(this.mVideoSizeType) && !Util.m24169C())) || CameraParameter.VideoEncoder.H265.equals(getVideoCodec());
    }

    public boolean initVideoFileDescriptor() throws IOException {
        this.mRecordFileNameChange.block();
        Bundle extras = this.mActivity.getIntent().getExtras();
        closeVideoFileDescriptor();
        if (this.mCameraInterface.mo10583m() && extras != null) {
            Uri uri = (Uri) extras.getParcelable("output");
            CameraLog.m12962c(TAG, "initializeRecorder, saveUri: " + uri);
            if (uri != null) {
                try {
                    this.mVideoFileDescriptor = this.mActivity.getContentResolver().openFileDescriptor(uri, "rw");
                    this.mCurrentVideoUri = uri;
                } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
                    CameraLog.m12967f(TAG, COUIBaseListPopupWindow_8.toString());
                }
            }
        }
        if (this.mVideoFileDescriptor != null) {
            return true;
        }
        if (getProfile() != null) {
            generateVideoFilename(getProfile().fileFormat);
        }
        if (this.mVideoFilename != null) {
            return true;
        }
        CameraLog.m12967f(TAG, "initializeRecorder, mVideoFilename is null");
        return false;
    }

    private void initializeRecorder() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12962c(TAG, "initializeRecorder");
        Bundle extras = this.mActivity.getIntent().getExtras();
        long OplusGLSurfaceView_15 = "on".equals(Storage.f12095u) ? 4294967296L : 0L;
        if (this.mCameraInterface.mo10583m() && extras != null) {
            OplusGLSurfaceView_15 = extras.getLong("android.intent.extra.sizeLimit");
        }
        if (extras != null && this.mCameraInterface.mo10583m()) {
            OplusGLSurfaceView_15 = extras.getLong("android.intent.extra.sizeLimit");
        }
        this.mVideoRecorder = new VideoRecorder(isUseMediaCodec(), this.mCameraInterface.mo10536al());
        this.mVideoRecorder.m12750h(isNeedAudioEncode());
        synchronized (this.mVideoSurfaceLock) {
            if (this.mVideoSurface != null) {
                this.mVideoRecorder.m12707a(this.mVideoSurface);
            }
        }
        this.mVideoRecorder.m12713a(this.mCameraUIInterface.mo18066a());
        CamcorderProfile profile = getProfile();
        if (this.mbRecordAudio && Util.m24356as()) {
            this.mVideoRecorder.m12703a(5);
            profile.audioCodec = 3;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_ELEVATE_AUDIO_BIT_RATE)) {
                profile.audioBitRate = AUDIO_BITRATE_ENHANCE;
            }
        } else {
            profile.audioCodec = -1;
        }
        this.mVideoRecorder.m12743f(2);
        setBinauralRecordState(this.mbBinauralRecordEnable);
        String videoTitle = getVideoTitle();
        if (this.mbBinauralRecordEnable) {
            videoTitle = videoTitle != null ? videoTitle.concat("binaural") : "binaural";
        }
        if (videoTitle != null) {
            this.mVideoRecorder.m12733c(getVideoFileExifTag().concat(videoTitle));
        }
        checkVideoCodecAndReset();
        String videoCodec = getVideoCodec();
        if (isVideo10BitOpen()) {
            profile.videoCodec = 5;
            this.mVideoRecorder.m12726b(2, 16384);
        } else if (CameraParameter.VideoEncoder.H265.equals(videoCodec)) {
            profile.videoCodec = 5;
        } else if (CameraParameter.VideoEncoder.H264.equals(videoCodec)) {
            profile.videoCodec = 2;
            this.mVideoRecorder.m12726b(8, 2048);
        }
        if (Util.m24169C()) {
            if ((isMirrorEnable() || this.mCameraUIInterface.mo18207e()) && TextUtils.equals(getMirror(), "off")) {
                int iMo10591u = this.mCameraInterface.mo10591u();
                if (iMo10591u == 0 || iMo10591u == 180) {
                    this.mVideoRecorder.m12758n(2);
                } else {
                    this.mVideoRecorder.m12758n(1);
                }
            }
            profile.videoFrameRate = getVideoFrameRate();
            CameraLog.m12959b(TAG, "initializeRecorder, videoCodec: " + profile.videoCodec + ", videoBitRate: " + profile.videoBitRate + ", getNeedReduceBitRate(): " + getNeedReduceBitRate());
            this.mVideoRecorder.m12717a(String.valueOf(this.mCameraId), profile);
            if (this.mCameraInterface.mo10583m()) {
                this.mVideoRecorder.m12746g(profile.videoBitRate);
            } else {
                this.mVideoRecorder.m12746g(getNeedReduceBitRate() ? profile.videoBitRate / 2 : profile.videoBitRate);
            }
        } else {
            CamcorderProfile camcorderProfile = this.mProfile;
            camcorderProfile.fileFormat = 2;
            this.mVideoRecorder.m12749h(camcorderProfile.fileFormat);
            this.mProfile.videoFrameRate = getVideoFrameRate();
            this.mVideoRecorder.m12751i(this.mProfile.videoFrameRate);
            this.mVideoRecorder.m12705a(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight);
            this.mVideoRecorder.m12753j(this.mProfile.videoCodec);
            if (this.mCameraInterface.mo10583m()) {
                this.mVideoRecorder.m12746g(profile.videoBitRate / 4);
            } else {
                this.mVideoRecorder.m12746g(getNeedReduceBitRate() ? profile.videoBitRate / 2 : profile.videoBitRate);
            }
            if (this.mbRecordAudio) {
                if (this.mVideoSizeType.equals("video_size_cif") || this.mVideoSizeType.equals("video_size_qcif")) {
                    this.mVideoRecorder.m12725b(this.mProfile.audioBitRate / 8);
                    this.mVideoRecorder.m12732c(this.mProfile.audioChannels);
                    this.mVideoRecorder.m12736d(this.mProfile.audioSampleRate / 8);
                    this.mVideoRecorder.m12741e(this.mProfile.audioCodec);
                } else {
                    this.mVideoRecorder.m12725b(this.mProfile.audioBitRate);
                    this.mVideoRecorder.m12732c(this.mProfile.audioChannels);
                    this.mVideoRecorder.m12736d(this.mProfile.audioSampleRate);
                    this.mVideoRecorder.m12741e(this.mProfile.audioCodec);
                }
            }
        }
        updateSurroundRecord();
        this.mVideoRecorder.m12757m(this.mCameraInterface.mo10591u());
        Location locationMo10595y = this.mCameraInterface.mo10595y();
        if (locationMo10595y != null) {
            this.mVideoRecorder.m12702a((float) locationMo10595y.getLatitude(), (float) locationMo10595y.getLongitude());
        }
        Double timeLapseSpeed = getTimeLapseSpeed();
        int iIntValue = timeLapseSpeed != null ? timeLapseSpeed.intValue() : -1;
        VideoRecorder c2670x = this.mVideoRecorder;
        if (!isVideoTimeLapseTiltShiftOpen()) {
            iIntValue = -1;
        }
        c2670x.m12755k(iIntValue);
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_DURATION_LIMIT)) {
            this.mVideoRecorder.m12756l(15000);
        } else {
            int recordingMaxDuration = getRecordingMaxDuration(this.mVideoSizeType, String.valueOf(profile.videoFrameRate));
            if (recordingMaxDuration > 0) {
                int OplusGLSurfaceView_13 = recordingMaxDuration * 1000;
                int i2 = this.mMaxVideoDurationInMs;
                if (i2 > 0 && OplusGLSurfaceView_13 > i2) {
                    OplusGLSurfaceView_13 = i2;
                }
                this.mVideoRecorder.m12756l(OplusGLSurfaceView_13);
                CameraLog.m12954a(TAG, "initializeRecorder, videoRecorder setMaxDuration: " + OplusGLSurfaceView_13);
            } else {
                this.mVideoRecorder.m12756l(this.mMaxVideoDurationInMs);
            }
        }
        String str = profile.videoFrameWidth + "x" + profile.videoFrameHeight;
        this.mCameraUIInterface.mo18165b(profile.videoFrameWidth, profile.videoFrameHeight);
        CameraLog.m12954a(TAG, "initializeRecorder, profile.videoFrameRate: " + profile.videoFrameRate + ", profile.duration: " + profile.duration + ", videoSize: " + str + ", profile.videoBitRate: " + profile.videoBitRate);
        int iMo10591u2 = (this.mCameraInterface.mo10591u() + getOrientationRectify()) % 360;
        if (!isUseMediaCodec()) {
            iMo10591u2 = getJpegOrientation(this.mCameraId, iMo10591u2);
        }
        this.mVideoRecorder.m12759o(iMo10591u2);
        ParcelFileDescriptor parcelFileDescriptor = this.mVideoFileDescriptor;
        if (parcelFileDescriptor != null) {
            this.mVideoRecorder.m12714a(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.mVideoRecorder.m12727b(this.mVideoFilename);
        }
        if (getRealCaptureRate() != null && getRealCaptureRate().doubleValue() > 0.0d) {
            CameraLog.m12954a(TAG, "initializeRecorder, setCaptureRate: " + getRealCaptureRate());
            this.mVideoRecorder.m12700a(getRealCaptureRate().doubleValue());
        }
        long jM11129c = Storage.m11129c(Storage.f12095u);
        if (OplusGLSurfaceView_15 > 0 && OplusGLSurfaceView_15 < jM11129c) {
            jM11129c = OplusGLSurfaceView_15;
        }
        try {
            this.mVideoRecorder.m12706a(jM11129c);
        } catch (RuntimeException unused) {
        }
        this.mVideoRecorder.m12710a((VideoRecorder.COUIBaseListPopupWindow_12) this);
        this.mVideoRecorder.m12712a((VideoRecorder.COUIBaseListPopupWindow_10) this);
        this.mVideoRecorder.m12711a((VideoRecorder.COUIBaseListPopupWindow_11) this);
        onInitializeRecorder(this.mVideoRecorder);
        CameraLog.m12954a(TAG, "initializeRecorder end, maxFileSize: " + jM11129c + ", requestedSizeLimit: " + OplusGLSurfaceView_15);
    }

    private void updateSurroundRecord() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean zM24459h = Util.m24459h("oplus.software.video.surround_record_support");
        String str = ApsConstant.CAPTURE_MODE_PANORAMA;
        String str2 = CameraUIInterface.KEY_VIDEO_SOUND_FRONT;
        if (zM24459h && Util.m24173E()) {
            if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(getCameraMode()) || "movie".equals(getCameraMode()) || ApsConstant.REC_MODE_FAST_VIDEO.equals(getCameraMode()) || "video_size_8k".equals(getVideoSizeType())) {
                this.mSoundType = "normal";
            } else {
                SharedPreferences sharedPreferences = this.mPreferences;
                if (!this.mbFrontCamera) {
                    str2 = CameraUIInterface.KEY_VIDEO_SOUND_REAR;
                }
                boolean zEquals = "all_around".equals(sharedPreferences.getString(str2, "all_around"));
                boolean z = Float.compare(getZoomValue(), 1.0f) != 0;
                this.mNoiseFilter = zEquals ? "on" : "off";
                if (zEquals) {
                    if (z) {
                        str = "focusing";
                    }
                    this.mSoundType = str;
                } else {
                    this.mSoundType = "normal";
                }
            }
            this.mVideoRecorder.m12719a(this.mNoiseFilter, this.mSoundType, this.mCameraId, this.mCameraInterface.mo10591u());
            int zoomValue = (int) ((getZoomValue() - 1.0f) * 10.0f);
            if (zoomValue <= 0) {
                zoomValue = 1;
            }
            CameraLog.m12962c(TAG, "initSoundType, soundType: " + this.mSoundType + ", modeType: " + getCameraMode() + ", mNoiseFilter: " + this.mNoiseFilter + ", soundValue: " + zoomValue);
            this.mVideoRecorder.m12704a(zoomValue, getZoomValue());
            return;
        }
        if (Util.m24459h("oplus.software.video.surround_record_support") && Util.m24175F()) {
            if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(getCameraMode()) || "movie".equals(getCameraMode()) || ApsConstant.REC_MODE_FAST_VIDEO.equals(getCameraMode())) {
                this.mSoundType = "normal";
            } else {
                SharedPreferences sharedPreferences2 = this.mPreferences;
                if (!this.mbFrontCamera) {
                    str2 = CameraUIInterface.KEY_VIDEO_SOUND_REAR;
                }
                if ("all_around".equals(sharedPreferences2.getString(str2, "all_around"))) {
                    if (getZoomValue() >= 1.1f) {
                        str = "focusing";
                    }
                    this.mSoundType = str;
                } else {
                    this.mSoundType = "normal";
                }
            }
            CameraLog.m12962c(TAG, "initAudioType, audioType: " + this.mSoundType + ", modeType: " + getCameraMode());
            this.mVideoRecorder.m12716a(this.mSoundType, getZoomValue(), this.mOrientation);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        VideoRecorder c2670x = this.mVideoRecorder;
        if (c2670x != null) {
            c2670x.m12701a(getZoomValue());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        VideoRecorder c2670x = this.mVideoRecorder;
        if (c2670x != null) {
            c2670x.m12757m(OplusGLSurfaceView_13);
        }
    }

    protected String getVideoFileExifTag() {
        return C2735b.m13779b(getCameraMode(), this.mCameraId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecordingTime() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!isVideoRecordStarted()) {
            resetTimeUi();
            return;
        }
        long jUptimeMillis = (SystemClock.uptimeMillis() - this.mRecordingStartTime) - this.mTotalPausingTime;
        this.mRecordingTotalTime = jUptimeMillis;
        if (shouldAutoStop(jUptimeMillis)) {
            m17833aj();
            return;
        }
        this.mCameraUIInterface.mo18081a(this.mRecordingTotalTime, getVideoTime(), this.mbShowRecordingIndicator, getSupportFunction(CameraUIInterface.KEY_SUPPORT_VIDEO_COUNT_DOWN), getVideoTimeLimit());
        if (this.mCount == 0) {
            this.mCameraInterface.mo10476a(this.mRecordingTotalTime);
        }
        this.mCount++;
        this.mCount %= 6;
        if (this.mCount == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateRecordingTime, mbShowRecordingIndicator: ");
            sb.append(this.mbShowRecordingIndicator);
            sb.append("->");
            sb.append(!this.mbShowRecordingIndicator);
            CameraLog.m12954a(TAG, sb.toString());
            this.mbShowRecordingIndicator = !this.mbShowRecordingIndicator;
        }
        this.mHandler.sendEmptyMessageDelayed(1, 81L);
    }

    public void resetTimeUi() {
        boolean supportFunction = getSupportFunction(CameraUIInterface.KEY_SUPPORT_VIDEO_COUNT_DOWN);
        long videoTimeLimit = getVideoTimeLimit();
        if (!supportFunction || videoTimeLimit - this.mRecordingTotalTime >= 300) {
            return;
        }
        this.mRecordingTotalTime = videoTimeLimit;
        this.mCameraUIInterface.mo18081a(videoTimeLimit, getVideoTime(), this.mbShowRecordingIndicator, true, videoTimeLimit);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onBinauralRecordStateChanged(boolean z) {
        if (this.mbBinauralRecordEnable != z) {
            this.mbBinauralRecordEnable = z;
            CameraLog.m12954a(TAG, "onBinauralRecordStateChanged, enable: " + z);
            if (isVideoRecording()) {
                setBinauralRecordState(this.mbBinauralRecordEnable);
            }
        }
    }

    private void setBinauralRecordState(boolean z) {
        VideoRecorder c2670x;
        CameraLog.m12954a(TAG, "setBinauralRecordState, enable: " + z);
        if (!supportBinauralRecord() || (c2670x = this.mVideoRecorder) == null) {
            return;
        }
        c2670x.m12738d(z);
        if (z) {
            this.mVideoRecorder.m12742e(this.mbFrontCamera);
            if (this.mbFrontCamera) {
                this.mVideoRecorder.m12744f("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_MIRROR, this.mActivity.getString(R.string.camera_mirror_default_value))));
            }
            if (this.mCameraUIInterface != null) {
                this.mCameraUIInterface.mo18277v();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getVideoSizeType() {
        /*
            r4 = this;
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r0 = r4.mCameraInterface
            java.lang.String r1 = "VideoMode"
            if (r0 == 0) goto L5e
            android.app.Activity r0 = r4.mActivity
            if (r0 == 0) goto L5e
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r0 = r4.mCameraInterface
            boolean r0 = r0.mo10583m()
            if (r0 == 0) goto L5e
            android.app.Activity r4 = r4.mActivity
            android.content.Intent r4 = r4.getIntent()
            android.os.Bundle r4 = r4.getExtras()
            java.lang.String r0 = "video_size_480p"
            if (r4 == 0) goto L41
            r2 = 4
            java.lang.String r3 = "android.intent.extra.videoQuality"
            int r4 = r4.getInt(r3, r2)
            r2 = 6
            if (r4 == r2) goto L3e
            r2 = 1
            if (r4 != r2) goto L36
            java.lang.String r3 = "com.oplus.quality.high.1080p.support"
            boolean r3 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            if (r3 == 0) goto L36
            goto L3e
        L36:
            r3 = 5
            if (r4 == r3) goto L3b
            if (r4 != r2) goto L41
        L3b:
            java.lang.String r4 = "video_size_720p"
            goto L42
        L3e:
            java.lang.String r4 = "video_size_1080p"
            goto L42
        L41:
            r4 = r0
        L42:
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 != 0) goto L49
            return r4
        L49:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getVideoSizeType, sizeType: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.oplus.camera.CameraLog.m12966e(r1, r4)
            return r0
        L5e:
            android.content.SharedPreferences r0 = r4.mPreferences
            if (r0 == 0) goto L6f
            android.content.SharedPreferences r0 = r4.mPreferences
            java.lang.String r4 = r4.getDefaultVideoSize()
            java.lang.String r1 = "pref_video_size_key"
            java.lang.String r4 = r0.getString(r1, r4)
            return r4
        L6f:
            java.lang.String r0 = "getVideoSizeType, mPreferences is null!"
            com.oplus.camera.CameraLog.m12966e(r1, r0)
            java.lang.String r4 = r4.getDefaultVideoSize()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.VideoMode.getVideoSizeType():java.lang.String");
    }

    private void sendBoradCastToStopRecordSound() {
        this.mActivity.sendBroadcast(new Intent("oplus.multimedia.soundrecorder.stopRecroderNormal"));
    }

    private void sendBoradCastToStopVideo() {
        this.mActivity.sendBroadcast(new Intent("oplus.camera.record.start"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenBrightness(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        if (InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
            return;
        }
        float f2 = OplusGLSurfaceView_13;
        if (COUIBaseListPopupWindow_12 > f2) {
            try {
                this.mBrightnessAnimationListener.m12688a(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12 - f2, f2);
                this.mBrightnessAnimator.start();
            } catch (NoSuchMethodError unused) {
                CameraLog.m12967f(TAG, "setScreenBrightness, no such method error.");
                return;
            }
        }
        CameraLog.m12954a(TAG, "setScreenBrightness, brightness: " + OplusGLSurfaceView_13 + ", currBrightness: " + COUIBaseListPopupWindow_12);
    }

    private String getDefaultVideoQuality(int OplusGLSurfaceView_13, String str) {
        return CamcorderProfile.hasProfile(OplusGLSurfaceView_13, Integer.valueOf(str).intValue()) ? str : Integer.toString(1);
    }

    protected void enableVideoRecordingSound(boolean z) {
        CameraLog.m12954a(TAG, "enableVideoRecordingSound, enable: " + z);
        this.mbRecordAudio = z;
    }

    private int matchRecModeToVideoQuality(String str) {
        int iIntValue;
        if ("video_size_4kuhd".equals(this.mVideoSizeType) || "video_size_1080p".equals(this.mVideoSizeType)) {
            iIntValue = 6;
        } else if ("video_size_720p".equals(this.mVideoSizeType)) {
            iIntValue = 5;
        } else if ("video_size_480p".equals(this.mVideoSizeType)) {
            iIntValue = 4;
        } else if ("video_size_cif".equals(this.mVideoSizeType)) {
            iIntValue = 3;
        } else {
            iIntValue = "video_size_qcif".equals(this.mVideoSizeType) ? 2 : Integer.valueOf(str).intValue();
        }
        if (isMultiVideoMode()) {
            iIntValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT) ? 6 : 5;
        }
        if (isFastVideoMode() && "video_size_4kuhd".equals(this.mVideoSizeType) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_RESOLUTION_SWITCH)) {
            iIntValue = CommonStatusCodes.CAPABILITY_EXCEPTION;
        }
        CameraLog.m12954a(TAG, "matchRecModeToVideoQuality, mVideoSizeType: " + this.mVideoSizeType + ", videoQuality: " + iIntValue);
        return iIntValue;
    }

    /* compiled from: VideoMode.java */
    /* renamed from: com.oplus.camera.capmode.w$IntrinsicsJvm.kt_3 */
    private final class IntrinsicsJvm.kt_3 extends Handler {
        private IntrinsicsJvm.kt_3() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int configIntValue;
            switch (message.what) {
                case 1:
                    VideoMode.this.updateRecordingTime();
                    break;
                case 2:
                    VideoMode abstractC2669w = VideoMode.this;
                    abstractC2669w.mCheckStorageTask = new IntrinsicsJvm.kt_4().execute(new Void[0]);
                    break;
                case 3:
                    VideoMode.this.mCameraUIInterface.mo18175b(true, false);
                    break;
                case 4:
                    VideoMode.this.mCameraUIInterface.mo18107a(true, false);
                    break;
                case 5:
                    VideoMode.this.handleStartError(false, message.obj != null ? ((Boolean) message.obj).booleanValue() : true);
                    break;
                case 6:
                    VideoMode.this.setScreenBrightness(1 == Util.m24212a("persist.sys.oplus.display.brightness.mode", 0) ? CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS) : 130, Settings.System.getInt(VideoMode.this.mActivity.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, r5));
                    break;
                case 7:
                    VideoMode.this.startVideoRecordHandler();
                    break;
                case 9:
                    if (!VideoMode.this.isVideoRecordStopped()) {
                        VideoMode.this.mRecordHandler.sendEmptyMessageDelayed(9, 1000L);
                        break;
                    } else {
                        MyApplication.m11090c();
                        break;
                    }
                case 10:
                    if (VideoMode.this.isVideoRecordStarted()) {
                        VideoMode.this.m17833aj();
                        break;
                    } else {
                        sendEmptyMessageDelayed(10, 1000L);
                        break;
                    }
                case 11:
                    ToastUtil.m24640a(VideoMode.this.mActivity, R.string.super_eis_on_keep_on_toast);
                    break;
                case 12:
                    CameraLog.m12959b(VideoMode.TAG, "handleMessage, timeout with MotionDetected: " + VideoMode.this.isMotionDetected());
                    if (VideoMode.this.isVideoRecordStarted() && !VideoMode.this.isMotionDetected()) {
                        VideoMode.this.m17833aj();
                        break;
                    }
                    break;
                case 13:
                    if (1 == Util.m24212a("persist.sys.oplus.display.brightness.mode", 0)) {
                        configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS);
                        configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS_SECOND);
                    } else {
                        configIntValue = 130;
                    }
                    if (Settings.System.getInt(VideoMode.this.mActivity.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, configIntValue) > 179.0f) {
                        VideoMode.this.setScreenBrightness(configIntValue, configIntValue);
                        break;
                    }
                    break;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public long getResumePauseRecordingTotalTime() {
        return this.mResumePauseRecordingTotalTime;
    }

    /* compiled from: VideoMode.java */
    /* renamed from: com.oplus.camera.capmode.w$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends AsyncTask<Void, Void, Boolean> {
        private IntrinsicsJvm.kt_4() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            int iM11122b = Storage.m11122b(Storage.f12095u);
            if (iM11122b != 0) {
                if (iM11122b == 3 && VideoMode.this.mCameraInterface != null) {
                    VideoMode.this.mCameraInterface.mo10461Q();
                }
                return true;
            }
            if (VideoMode.this.isVideoRecordStopped() && "on".equals(Storage.f12095u) && !Storage.m11128b(true)) {
                CameraLog.m12954a(VideoMode.TAG, "doInBackground, external storage is removed, wait unmounted broadcast to finish activity");
                return false;
            }
            if (VideoMode.this.mHandler != null) {
                VideoMode.this.mHandler.removeMessages(2);
                VideoMode.this.mHandler.sendEmptyMessageDelayed(2, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                VideoMode.this.onStopVideoRecording(true);
            }
        }
    }

    /* compiled from: VideoMode.java */
    /* renamed from: com.oplus.camera.capmode.w$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f13056b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f13057c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f13058d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Window f13059e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private WindowManager.LayoutParams f13060f;

        public PlatformImplementations.kt_3(Activity activity) {
            this.f13059e = activity.getWindow();
            this.f13060f = this.f13059e.getAttributes();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m12688a(float COUIBaseListPopupWindow_12, float f2, float f3) {
            CameraLog.m12954a(VideoMode.TAG, "setTargetBrightness, targetBrightness: " + f3 + ", deltaBrightness: " + f2 + ", MaxScreenBrightness: " + VideoMode.this.mCameraInterface.mo10466V());
            this.f13056b = f3;
            this.f13057c = f2;
            this.f13058d = COUIBaseListPopupWindow_12;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (VideoMode.this.mCameraInterface != null) {
                float fFloatValue = (this.f13057c * ((Float) valueAnimator.getAnimatedValue()).floatValue()) + this.f13056b;
                float COUIBaseListPopupWindow_12 = this.f13057c;
                if (this.f13058d - fFloatValue >= (COUIBaseListPopupWindow_12 >= 20.0f ? COUIBaseListPopupWindow_12 / 20.0f : 1.0f)) {
                    this.f13060f.screenBrightness = fFloatValue / VideoMode.this.mCameraInterface.mo10466V();
                    this.f13059e.setAttributes(this.f13060f);
                    this.f13058d = fFloatValue;
                    VideoMode.this.mBrightness = this.f13058d;
                }
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if (this.mbDestroyed) {
            return false;
        }
        if ("type_video".equals(str)) {
            return true;
        }
        if ("type_tuning_data_yuv".equals(str) || "type_tuning_data_raw".equals(str)) {
            return false;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeSwitchToMode(boolean z) {
        super.beforeSwitchToMode(z);
        if (z) {
            return;
        }
        this.mRecordHandler.removeMessages(6);
        this.mRecordHandler.sendEmptyMessage(6);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        synchronized (this.mPrepareVideoSurface) {
            this.mRecordHandler.removeMessages(6);
            this.mRecordHandler.sendEmptyMessage(6);
            if (5 == this.mCameraInterface.mo10570g()) {
                this.mPrepareVideoSurface.close();
                this.mPrepareVideoSurface.block();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean prepareVideoSurface() throws IllegalStateException, IOException {
        if (needSurface("type_video") && this.mPreferences != null) {
            CameraLog.m12959b(TAG, "prepareVideoSurface");
            setVideoSurfaceState(1);
            beforeConfig();
            readProfile();
            CameraLog.m12952a("prepareVideoSurface");
            VideoRecorder c2670x = new VideoRecorder(false, this.mCameraInterface.mo10536al());
            synchronized (this.mVideoSurfaceLock) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SURFACE_RELEASE)) {
                    if (this.mVideoSurface != null) {
                        this.mVideoSurface.release();
                    }
                    this.mVideoSurface = MediaCodec.createPersistentInputSurface();
                } else if (this.mVideoSurface == null) {
                    this.mVideoSurface = MediaCodec.createPersistentInputSurface();
                }
                c2670x.m12707a(this.mVideoSurface);
            }
            c2670x.m12743f(2);
            c2670x.m12749h(2);
            c2670x.m12759o(this.mOrientation);
            String videoCodec = getVideoCodec();
            c2670x.m12751i(30);
            c2670x.m12705a(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight);
            if (CameraParameter.VideoEncoder.H264.equals(videoCodec)) {
                c2670x.m12753j(2);
                c2670x.m12726b(8, 2048);
                c2670x.m12746g(this.mProfile.videoBitRate);
            } else if (CameraParameter.VideoEncoder.H265.equals(videoCodec)) {
                c2670x.m12753j(5);
                c2670x.m12746g(this.mProfile.videoBitRate / 2);
                if (isVideo10BitOpen()) {
                    c2670x.m12726b(2, 16384);
                }
            }
            File fileCreateTempFile = null;
            try {
                fileCreateTempFile = File.createTempFile(TAG, "TempMediaRecorder");
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (fileCreateTempFile != null) {
                c2670x.m12727b(fileCreateTempFile.getAbsolutePath());
            } else {
                CameraLog.m12967f(TAG, "prepareVideoSurface, setOutputFile failed, tempFile: " + fileCreateTempFile);
            }
            Double realCaptureRate = getRealCaptureRate();
            CameraLog.m12954a(TAG, "prepareVideoSurface, captureRate: " + realCaptureRate);
            if (realCaptureRate != null && realCaptureRate.doubleValue() > 0.0d) {
                c2670x.m12700a(realCaptureRate.doubleValue());
            }
            try {
                c2670x.m12740e();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            c2670x.m12739d();
            if (this.mbMediaLimitProcess) {
                Thumbnail.m19284d();
                this.mbMediaLimitProcess = false;
            }
            if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                DocumentUtil.m16205c(fileCreateTempFile.getAbsolutePath());
            }
            setVideoSurfaceState(2);
            this.mPrepareVideoSurface.open();
            CameraLog.m12958b("prepareVideoSurface");
            CameraLog.m12959b(TAG, "prepareVideoSurface, X");
        }
        return true;
    }

    protected void readProfile() {
        String defaultVideoQuality;
        CameraLog.m12954a(TAG, "readProfile");
        CameraLog.m12952a("readProfile");
        this.mVideoSizeType = getVideoSizeType();
        if (this.mbFrontCamera) {
            defaultVideoQuality = getDefaultVideoQuality(this.mCameraId, this.mActivity.getString(R.string.camera_video_quality_front_default_value));
        } else {
            defaultVideoQuality = getDefaultVideoQuality(this.mCameraId, this.mActivity.getString(R.string.camera_video_quality_default_value));
        }
        int iMatchRecModeToVideoQuality = matchRecModeToVideoQuality(defaultVideoQuality);
        Intent intent = this.mActivity.getIntent();
        Bundle extras = intent.getExtras();
        if (intent.hasExtra("android.intent.extra.videoQuality")) {
            if (extras != null) {
                iMatchRecModeToVideoQuality = extras.getInt("android.intent.extra.videoQuality", 4);
            }
            if (iMatchRecModeToVideoQuality == 1 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALITY_HIGH_1080P_SUPPORT)) {
                iMatchRecModeToVideoQuality = 6;
            } else if (iMatchRecModeToVideoQuality == 1) {
                iMatchRecModeToVideoQuality = 5;
            }
        }
        CameraLog.m12954a(TAG, "readProfile, quality: " + iMatchRecModeToVideoQuality);
        if (intent.hasExtra("android.intent.extra.durationLimit")) {
            int intExtra = intent.getIntExtra("android.intent.extra.durationLimit", -1);
            if (intExtra >= 0) {
                this.mMaxVideoDurationInMs = intExtra * 1000;
            }
            CameraLog.m12954a(TAG, "readProfile, mMaxVideoDurationInMs: " + this.mMaxVideoDurationInMs);
        }
        try {
            this.mProfile = CamcorderProfile.get(this.mCameraId, iMatchRecModeToVideoQuality);
        } catch (Exception COUIBaseListPopupWindow_8) {
            this.mProfile = null;
            CameraLog.m12956a(TAG, "readProfile, CamcorderProfile.get fail! ", COUIBaseListPopupWindow_8);
        }
        if (this.mProfile == null) {
            CameraLog.m12954a(TAG, "readProfile, mProfile is null, so return...");
            return;
        }
        if (!isMultiVideoMode()) {
            if ("video_size_4kuhd".equals(this.mVideoSizeType)) {
                CamcorderProfile camcorderProfile = this.mProfile;
                camcorderProfile.videoBitRate = VIDEO_4K_BIT_RATE;
                camcorderProfile.videoFrameWidth = VIDEO_4K_FRAME_WIDTH;
                camcorderProfile.videoFrameHeight = VIDEO_4K_FRAME_HEIGHT;
                camcorderProfile.audioSampleRate = VIDEO_4K_AUDIO_SAMPLE_RATE;
                camcorderProfile.audioBitRate = VIDEO_4K_AUDIO_BIT_RATE;
                camcorderProfile.audioChannels = 2;
            } else if ("video_size_8k".equals(this.mVideoSizeType)) {
                CamcorderProfile camcorderProfile2 = this.mProfile;
                camcorderProfile2.videoBitRate = VIDEO_8K_BIT_RATE;
                camcorderProfile2.videoFrameWidth = VIDEO_8K_FRAME_WIDTH;
                camcorderProfile2.videoFrameHeight = VIDEO_8K_FRAME_HEIGHT;
                camcorderProfile2.audioSampleRate = VIDEO_4K_AUDIO_SAMPLE_RATE;
                camcorderProfile2.audioBitRate = VIDEO_4K_AUDIO_BIT_RATE;
                camcorderProfile2.audioChannels = 2;
            }
        }
        this.mProfile.videoFrameRate = getVideoFrameRate();
        this.mProfile.videoBitRate = configVideoBitRate();
        CameraLog.m12958b("readProfile");
        CameraLog.m12954a(TAG, "readProfile, videoFrameWidth: " + this.mProfile.videoFrameWidth + ", videoFrameHeight: " + this.mProfile.videoFrameHeight + ", videoFrameRate: " + this.mProfile.videoFrameRate + ", mProfile.videoBitRate: " + this.mProfile.videoBitRate);
    }

    public Size getVideoSize() {
        int OplusGLSurfaceView_13;
        int i2 = 720;
        if (this.mVideoSizeType.equals("video_size_1080p")) {
            i2 = VIDEO_1080P_WIDTH;
            OplusGLSurfaceView_13 = VIDEO_1080P_HEIGHT;
        } else if (this.mVideoSizeType.equals("video_size_720p")) {
            i2 = 1280;
            OplusGLSurfaceView_13 = 720;
        } else if (this.mVideoSizeType.equals("video_size_cif")) {
            i2 = VIDEO_CIF_WIDTH;
            OplusGLSurfaceView_13 = 288;
        } else if (this.mVideoSizeType.equals("video_size_qcif")) {
            i2 = 176;
            OplusGLSurfaceView_13 = 144;
        } else {
            OplusGLSurfaceView_13 = 480;
        }
        return new Size(i2, OplusGLSurfaceView_13);
    }

    public int getResolutionBySizeType(String str) {
        if ("video_size_4kuhd".equals(str)) {
            return VIDEO_4K_FRAME_HEIGHT;
        }
        if ("video_size_1080p".equals(str)) {
            return VIDEO_1080P_HEIGHT;
        }
        if ("video_size_720p".equals(str)) {
            return 720;
        }
        if ("video_size_480p".equals(str)) {
            return 480;
        }
        if ("video_size_cif".equals(str)) {
            return 288;
        }
        return "video_size_qcif".equals(str) ? 144 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideHintViewShowZoom() {
        CameraLog.m12954a(TAG, "hideHintViewShowZoom");
        if (!this.mbStopVideoFail || this.mCameraInterface == null) {
            return;
        }
        this.mCameraInterface.mo10492a(true, false);
        this.mCameraInterface.mo10563d(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        if (this.mbMediaLimitProcess) {
            Thumbnail.m19284d();
            this.mbMediaLimitProcess = false;
        }
    }

    public void checkVideoCodecAndReset() {
        if (Util.m24357at() || !CameraParameter.VideoEncoder.H265.equals(getVideoCodec())) {
            return;
        }
        CameraLog.m12954a(TAG, "checkVideoCodecAndReset, reset video codec to default.");
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, getDefaultVideoCodec());
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        this.mCameraInterface.mo10572h();
        this.mbPictureTakenDuringRecord = true;
        this.mPictureTakenTime = this.mCaptureDate;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        this.mCameraUIInterface.mo18200d(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        this.mPreviewOkTime = System.currentTimeMillis();
        this.mPreviewVideoCostTime = -1L;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SECNES_FORCE_ATHENA)) {
            if (is4k() || isHighFps() || isSuperEISOpen()) {
                Util.m24168C(this.mActivity);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainAndWideRange(float COUIBaseListPopupWindow_12) {
        float[] configFloatArrayValue;
        if (!getSupportFunction(CameraFunction.SAT_CAMERA)) {
            return false;
        }
        if (isVideoHighFps() && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2) {
            return Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[1]) <= 0;
        }
        return super.withinSatMainAndWideRange(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainRange(float COUIBaseListPopupWindow_12) {
        float[] configFloatArrayValue;
        if (!getSupportFunction(CameraFunction.SAT_CAMERA)) {
            return false;
        }
        if (isVideoHighFps() && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2) {
            return Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[0]) >= 0 && Float.compare(COUIBaseListPopupWindow_12, configFloatArrayValue[1]) <= 0 && !getZoomAutoMicroOpen();
        }
        return super.withinSatMainRange(COUIBaseListPopupWindow_12);
    }

    private void reportVideoRecordToDcs(boolean z) throws Resources.NotFoundException {
        boolean z2;
        String str;
        String strValueOf;
        this.mPauseClickTimes = 0;
        VideoRecordMsgData videoRecordMsgData = new VideoRecordMsgData(Util.m24472l());
        DcsUtil.fillSecondScreenStatus(videoRecordMsgData, this.mCameraUIInterface.mo18214f(), this.mCameraUIInterface.mo18219g());
        videoRecordMsgData.mCaptureMode = getCameraMode();
        videoRecordMsgData.mCaptureType = !isCaptureModeType() ? 1 : 0;
        videoRecordMsgData.mVideoMode = getCameraMode();
        videoRecordMsgData.mVideoTime = this.mRecordingTotalTime;
        videoRecordMsgData.mVideoSizeType = getVideoSizeType();
        videoRecordMsgData.mFlashMode = getFlashMode();
        videoRecordMsgData.mAvaliableStorage = Storage.m11129c(Storage.f12095u) / 1024;
        videoRecordMsgData.mOrientation = this.mOrientation;
        videoRecordMsgData.mVideoCodec = getVideoCodec();
        videoRecordMsgData.mIsSDCard = String.valueOf("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_STORAGE_PLACE, Util.m24472l().getString(R.string.camera_storage_default_value))));
        videoRecordMsgData.mMagneticShellStatus = Util.m24320aI() ? "on" : "off";
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
            videoRecordMsgData.mIsStablized = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
        }
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU)) {
            if (!"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && this.mPreferences.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) {
                videoRecordMsgData.mUltraSteady = MenuClickMsgData.ULTRA_ON;
            } else {
                videoRecordMsgData.mUltraSteady = MenuClickMsgData.ULTRA_OFF;
            }
        }
        if (this.mCameraInterface.mo10583m()) {
            videoRecordMsgData.mCameraEnterType = String.valueOf(3);
        }
        videoRecordMsgData.mCameraId = this.mCameraInterface.mo10548ax();
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_VIDEO_RECORDER) && !this.mbFrontCamera) {
            videoRecordMsgData.mVideoRecorderSound = this.mSoundType;
            this.mSoundType = this.mPreferences.getString(this.mbFrontCamera ? CameraUIInterface.KEY_VIDEO_SOUND_FRONT : CameraUIInterface.KEY_VIDEO_SOUND_REAR, Util.m24472l().getString(R.string.camera_video_default_sound));
            if (!"normal".equals(this.mSoundType)) {
                videoRecordMsgData.mNoiseFilter = this.mNoiseFilter;
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
            int currMakeupIndex = getCurrMakeupIndex();
            if (currMakeupIndex == 0) {
                videoRecordMsgData.mMakeupType = "off";
                videoRecordMsgData.mMakeupValue = 0;
            } else {
                videoRecordMsgData.mMakeupType = DcsMsgData.sKeyMakeupList.get(currMakeupIndex);
                videoRecordMsgData.mMakeupValue = getMakeupItemValue(currMakeupIndex);
            }
        }
        if (needUploadOplusStatistics(CameraUIInterface.KEY_ZOOM)) {
            videoRecordMsgData.mZoomValue = String.valueOf(this.mCameraInterface.mo10535ak());
        }
        if (needUploadOplusStatistics(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen()) {
            videoRecordMsgData.mIsCustomSlogan = TextUtils.isEmpty(this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "")) ? "0" : "1";
            Set<String> stringSet = this.mPreferences.getStringSet(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                z2 = true;
            } else {
                String[] stringArray = Util.m24472l().getResources().getStringArray(R.array.camera_setting_watermark_display_info_values);
                boolean zContains = stringSet.contains(stringArray[0]);
                z2 = true;
                boolean zContains2 = stringSet.contains(stringArray[1]);
                boolean zContains3 = stringSet.contains(stringArray[2]);
                videoRecordMsgData.mIsModelSlogan = zContains ? "on" : "off";
                videoRecordMsgData.mIsTimeSlogan = zContains2 ? "on" : "off";
                videoRecordMsgData.mIsLocationSlogan = zContains3 ? "on" : "off";
            }
            videoRecordMsgData.mSloganLocate = this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "");
            videoRecordMsgData.mSloganSize = this.mPreferences.getString(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, "");
        } else {
            z2 = true;
        }
        videoRecordMsgData.mMotionFastVideo = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, Util.m24472l().getString(R.string.camera_video_hyper_lapse_default_value));
        if (getSupportFunction(CameraFunction.KEY_VIDEO_HYPER_LAPSE_PROCESS) && "on".equals(videoRecordMsgData.mMotionFastVideo)) {
            if (getHyperLapseRate() != 0) {
                videoRecordMsgData.mPosterizeTime = (30 / getHyperLapseRate()) + "X";
            }
            videoRecordMsgData.mTouchXYMotionFastVideo = this.mCameraUIInterface.mo18285y();
        }
        if (!"off".equals(videoRecordMsgData.mMotionFastVideo) || getTimeLapseSpeed() == null) {
            str = "on";
        } else {
            videoRecordMsgData.mPosterizeTime = String.valueOf(getTimeLapseSpeed());
            str = "on";
            videoRecordMsgData.mGenerateTime = getVideoTime();
        }
        videoRecordMsgData.mSmooth = getFaceBeautyCurrIndex();
        if (videoRecordMsgData.mSmooth == 102) {
            videoRecordMsgData.parseFaceBeauty(getCustomBeautyValues());
        }
        videoRecordMsgData.mIsRecordLocation = this.mPreferences.getString(CameraUIInterface.KEY_RECORD_LOCATION, Util.m24472l().getString(R.string.camera_location_default_value));
        videoRecordMsgData.mPreviewCaptureCostTime = this.mPreviewVideoCostTime;
        if (isMirrorEnable()) {
            videoRecordMsgData.mIsMirror = getMirror();
        }
        if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(getCameraMode())) {
            strValueOf = getSlowVideoFps() + NvsStreamingContext.COMPILE_FPS;
        } else {
            strValueOf = String.valueOf(getVideoFps());
        }
        videoRecordMsgData.mVideoFps = strValueOf;
        if (needUploadOplusStatistics(CameraUIInterface.KEY_FILTER_PROCESS) && FilterHelper.f21279a != getCurrFilterIndex()) {
            if (ApsConstant.REC_MODE_MICROSCOPE.equals(getCameraMode())) {
                videoRecordMsgData.mAncFilterType = getFilterType(getCurrFilterIndex());
            } else {
                videoRecordMsgData.mFilterType = getFilterType(getCurrFilterIndex());
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_FLASH_MODE) || getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
            videoRecordMsgData.mFlashMode = getFlashMode();
        }
        if (!this.mbFrontCamera) {
            videoRecordMsgData.mAeAfLock = String.valueOf(this.mVideoAeAfLock);
        }
        if (needUploadOplusStatistics(CameraUIInterface.KEY_ZOOM)) {
            videoRecordMsgData.mZoomValue = String.valueOf(this.mCameraInterface.mo10535ak());
        }
        RegionCommonFeatureAdapter.m14530a(videoRecordMsgData, (this.mPreferences == null || !this.mPreferences.getBoolean("pref_camera_statement_agree", false)) ? false : z2, this.mCameraInterface.mo10595y());
        videoRecordMsgData.mFlashTrigger = CaptureMsgDataReportUtil.m11167a(getFlashMode());
        videoRecordMsgData.mTouchXYValue = this.mCameraInterface.mo10530af();
        videoRecordMsgData.mTouchEVValue = String.valueOf(this.mCameraInterface.mo10533ai());
        videoRecordMsgData.mVolumeFunction = this.mPreferences.getString(CameraUIInterface.KEY_VOLUME_KEY_FUNCTION, Util.m24472l().getString(R.string.camera_volume_key_function_default_value));
        videoRecordMsgData.mIsShutterVoice = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_SOUND, Util.m24472l().getString(R.string.camera_sound_default_value));
        videoRecordMsgData.mFaceCount = this.mFaceCountOnStop;
        videoRecordMsgData.mScreenBrightness = this.mSysBrightness;
        if (getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            videoRecordMsgData.mIsWideAngle = this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, Util.m24472l().getString(R.string.ultra_wide_angle_default_value));
        }
        if (isBlurOpen()) {
            videoRecordMsgData.mBlurLevel = getBlurIndex();
        }
        videoRecordMsgData.mStartVideoRecordingOrientation = this.mStartRecordingOrientation;
        videoRecordMsgData.mStartVideoRecordingFaceCount = this.mStartRecordingFaceCount;
        videoRecordMsgData.mMemoryValue = String.valueOf(Util.m24468k(Util.m24472l()));
        videoRecordMsgData.mFilePath = this.mCurrentVideoFilename;
        videoRecordMsgData.mShutterType = this.mShutterType + DcsMsgData.DIVIDER + getCameraShutterType();
        if (getSupportFunction(CameraFunction.VIDEO_HDR)) {
            videoRecordMsgData.mIs3HDR = getHDRModeValue(getHDRKey());
        }
        if (getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO)) {
            videoRecordMsgData.mIsNightScene = this.mPreferences.getString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off");
        }
        videoRecordMsgData.mPicSizeType = Util.m24248a(getPictureSize(this.mOneCamera.mo13086e()), this.mCameraId);
        if ("16_9".equals(videoRecordMsgData.mPicSizeType)) {
            videoRecordMsgData.mPicSizeType = "16:9";
        }
        if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            videoRecordMsgData.mIsAiEnhance = this.mPreferences.getString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, Util.m24438e(this.mbFrontCamera));
            videoRecordMsgData.mAiEnhanceSceneStart = this.mAiEnhanceSceneStart;
            videoRecordMsgData.mAiEnhanceSceneEnd = this.mAiEnhanceSceneEnd;
            videoRecordMsgData.mAiEnhanceSceneChangeCount = this.mAiEnhanceSceneChangeCount;
        }
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
            videoRecordMsgData.mIsStablized = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
        }
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU)) {
            if (!"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && this.mPreferences.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) {
                videoRecordMsgData.mUltraSteady = MenuClickMsgData.ULTRA_ON;
            } else {
                videoRecordMsgData.mUltraSteady = MenuClickMsgData.ULTRA_OFF;
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
            videoRecordMsgData.m10BitsEncode = this.mPreferences.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
        }
        if ("".equals(this.mEndType)) {
            this.mEndType = "normal";
        }
        videoRecordMsgData.mEndType = this.mEndType;
        videoRecordMsgData.mRecordingStartTemperature = String.valueOf(this.mRecordingStartTemperature);
        videoRecordMsgData.mRecordingEndTemperature = String.valueOf(this.mRecordingEndTemperature);
        videoRecordMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        if (getSupportFunction(CameraUIInterface.KEY_LINE_VIDEO)) {
            if (this.mPreferences != null) {
                videoRecordMsgData.mVideoAssistantLine = this.mPreferences.getString(CameraUIInterface.KEY_LINE_VIDEO, "off");
            }
            videoRecordMsgData.mSpiritLevel = this.mPreferences.getString(CameraUIInterface.KEY_ASSIST_GRADIENTER, "off");
            if (str.equals(videoRecordMsgData.mSpiritLevel)) {
                videoRecordMsgData.mIsOverlap = String.valueOf(this.mCameraUIInterface.mo18152ap());
            }
            if (this.mCameraUIInterface.mo18152ap()) {
                videoRecordMsgData.mHorizontalOrVertical = this.mCameraUIInterface.mo18153aq();
            }
        }
        if (isSlowVideoHighFrame()) {
            videoRecordMsgData.mIsDragBox = String.valueOf(z);
        }
        if (supportBinauralRecord() && this.mbBinauralRecordEnable) {
            videoRecordMsgData.mVideoRecorderSound = "binaural";
        }
        onGetBeforeCaptureMsgCommonData(videoRecordMsgData);
        videoRecordMsgData.report();
    }

    protected boolean supportBinauralRecord() {
        return Util.m24284a();
    }

    protected void reportReminderToDcs(String str, String str2) {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.mActivity, false);
        if (this.mCameraInterface != null) {
            if (this.mCameraInterface.mo10583m()) {
                reminderMsgData.mCameraEnterType = String.valueOf(3);
            }
            reminderMsgData.mCameraId = this.mCameraInterface.mo10548ax();
        }
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mCaptureType = 1;
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mbRecording = isVideoRecording();
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return CameraUIInterface.KEY_VIDEO_CUSTOM_BEAUTY;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ec  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSharedPreferenceChanged(android.content.SharedPreferences r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.VideoMode.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    protected boolean needVideoPipeline() {
        return (isUseMediaCodec() || isUseMediaRecorderNotUseAPS()) ? false : true;
    }

    private boolean canNotStopVideoRecordingImmediately() {
        return (isSatOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) || (isRearSuperEISOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) || isHyperLapseOpen() || getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopRecordingFrame() {
        CameraLog.m12959b(TAG, "stopRecordingFrame, isHyperLapseOpen: " + isHyperLapseOpen());
        if (getSupportFunction(CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) || isHyperLapseOpen()) {
            this.mRecordHandler.removeMessages(2);
            this.mRecordHandler.sendEmptyMessage(2);
        }
        if (!this.mbVideoFrameInAPS || this.mCameraInterface == null) {
            return;
        }
        this.mCameraInterface.mo10558c(5);
    }

    protected Surface getVideoSurface() {
        Surface surface;
        synchronized (this.mVideoSurfaceLock) {
            surface = this.mVideoSurface;
        }
        return surface;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(String str) {
        if ("type_main_preview_frame".equals(str) || "type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return (!Util.m24169C() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && isSatOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL);
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needApsToProcessVideoWatermark() {
        return getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen() && !isUseMediaCodec();
    }

    private boolean isHalEisCache() {
        return this.mbEisHalCache || (isSatOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL) && needApsToProcessVideoWatermark());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSupportLensSwicth() {
        return Util.m24169C();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoTemperatureThresholdChanged(int OplusGLSurfaceView_13) {
        boolean zIsVideoRecording = isVideoRecording();
        CameraLog.m12954a(TAG, "onVideoTemperatureThresholdChanged, thresholdLevel: " + OplusGLSurfaceView_13 + ", isVideoRecording: " + zIsVideoRecording);
        if (zIsVideoRecording && !this.mCameraInterface.mo10579k() && 1 == OplusGLSurfaceView_13) {
            this.mCameraUIInterface.mo18070a(R.string.camera_stop_video_recording_hint, -1, true, false, false);
            this.mCameraInterface.mo10562d(5);
            this.mEndType = VideoRecordMsgData.END_TYPE_TEMP_COUNT_DOWN_TO_STOP;
            reportReminderToDcs(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMP_STOP_ALL_VIDEO);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needShow10bitHint() {
        return getSupportFunction(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) && isVideo10BitOpen() && !isMovieMode();
    }

    private boolean videoSloganSupportAndOpen() {
        return getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
    }

    private boolean isHalVideoWaterSlogan() {
        return isSloganOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getExpectedFrameRate() {
        return getVideoFps();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null && currentScreenMode.mo16631r() && this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18176b(true, true, false, false);
        }
        return super.onSingleTapUp(motionEvent);
    }
}
