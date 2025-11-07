package com.oplus.camera.capmode;

/* compiled from: VideoMode.java */
/* loaded from: classes2.dex */
public abstract class w_renamed extends com.oplus.camera.capmode.BaseMode implements com.oplus.camera.capmode.x_renamed.f_renamed, com.oplus.camera.capmode.x_renamed.g_renamed, com.oplus.camera.capmode.x_renamed.h_renamed {
    private static final java.lang.String APS_VIDEO_EIS = "preview_video_eis";
    private static final java.lang.String APS_VIDEO_SUPER_EIS = "preview_video_supereis";
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
    public static final java.lang.String KEY_IS_CAMERA_RECORDING = "oplus_is_camera_recording";
    public static final java.lang.String KEY_RECORD_FORBID = "record_forbid";
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
    private static final java.lang.String TAG = "VideoMode";
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
    public static final java.lang.String VIDEO_DEFAULT_FPS = "30";
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
    private com.oplus.camera.capmode.w_renamed.a_renamed mBrightnessAnimationListener;
    private android.animation.ValueAnimator mBrightnessAnimator;
    private com.coui.appcompat.dialog.app.b_renamed mCameraErrorAlertDialogBuilder;
    private android.content.DialogInterface.OnClickListener mCameraErrorPositiveButtonListener;
    private com.oplus.ocs.camera.CameraRecordingCallback mCameraRecordingCallback;
    private android.os.AsyncTask mCheckStorageTask;
    private int mCount;
    protected java.lang.String mCurrentVideoFilename;
    protected android.net.Uri mCurrentVideoUri;
    protected android.content.ContentValues mCurrentVideoValues;
    protected int mDcsCCT;
    protected long mDcsExp;
    protected int mDcsIso;
    protected float mDcsLux;
    protected java.lang.String mEndType;
    private int mFaceCountOnStop;
    protected java.lang.String mFileName;
    protected android.os.Handler mHandler;
    private long mLastPausingTime;
    private int mMaxVideoDurationInMs;
    private volatile int mMediaRecorderState;
    private java.lang.String mNoiseFilter;
    private androidx.appcompat.app.f_renamed mPGDialog;
    private int mPauseClickTimes;
    private long mPictureTakenTime;
    private final android.os.ConditionVariable mPrepareVideoSurface;
    private com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig mPreviewConfig;
    private long mPreviewOkTime;
    private long mPreviewVideoCostTime;
    protected android.media.CamcorderProfile mProfile;
    private final android.os.ConditionVariable mRecordFileNameChange;
    private android.os.Handler mRecordHandler;
    private android.os.HandlerThread mRecordHandlerThread;
    private final android.os.ConditionVariable mRecordSig;
    protected float mRecordingEndTemperature;
    protected float mRecordingStartTemperature;
    private long mRecordingStartTime;
    protected long mRecordingTotalTime;
    protected android.content.res.Resources mResouces;
    private long mResumePauseRecordingTotalTime;
    private java.lang.String mShutterType;
    private java.lang.String mSoundType;
    private int mStartRecordingFaceCount;
    private int mStartRecordingOrientation;
    private long mTotalPausingTime;
    private boolean mVideoAeAfLock;
    protected android.os.ParcelFileDescriptor mVideoFileDescriptor;
    protected java.lang.String mVideoFilename;
    protected int mVideoOrientation;
    protected com.oplus.camera.capmode.x_renamed mVideoRecorder;
    private final java.lang.Object mVideoRecorderSig;
    private java.lang.String mVideoSavePath;
    protected java.lang.String mVideoSizeType;
    protected android.view.Surface mVideoSurface;
    protected java.lang.Object mVideoSurfaceLock;
    private volatile int mVideoSurfaceState;
    private int mVideoWatermarkOrientation;
    public android.os.ConditionVariable mWaitRecordStarted;
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

    private java.lang.String convertOutputFormatToFileExt(int i_renamed) {
        return i_renamed == 2 ? ".mp4" : ".3gp";
    }

    private java.lang.String convertOutputFormatToMimeType(int i_renamed) {
        return i_renamed == 2 ? com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4 : com.google.android.exoplayer2.util.MimeTypes.VIDEO_H263;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getGuideLineKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO;
    }

    protected java.lang.Double getRealCaptureRate() {
        return null;
    }

    public java.lang.Float getRealVideoTimeRatio() {
        return null;
    }

    protected int getRecordingMaxDuration(java.lang.String str, java.lang.String str2) {
        return -1;
    }

    protected int getRecordingMinTime(boolean z_renamed) {
        return 1000;
    }

    protected int getSlowVideoFps() {
        return 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        return false;
    }

    protected java.lang.Double getTimeLapseSpeed() {
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

    protected java.lang.String getVideoTitle() {
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
    protected void onDeInitCameraMode(java.lang.String str) {
    }

    protected void onInitializeRecorder(com.oplus.camera.capmode.x_renamed xVar) {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoRetakeButtonClick() {
    }

    protected void processPlatformSlowVideo() {
    }

    public void setHalStatus(int i_renamed) {
    }

    protected boolean shouldAutoStop(long j_renamed) {
        return false;
    }

    protected void startShutterButtonProgress() {
    }

    protected void stopShutterButtonProgress() {
    }

    protected void updateVideoTypeExif(java.io.File file) {
    }

    public w_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.mRecordSig = new android.os.ConditionVariable();
        this.mPrepareVideoSurface = new android.os.ConditionVariable();
        this.mRecordFileNameChange = new android.os.ConditionVariable(true);
        this.mVideoRecorderSig = new java.lang.Object();
        this.mWaitRecordStarted = new android.os.ConditionVariable();
        this.mResouces = null;
        this.mHandler = null;
        this.mVideoSizeType = "video_size_1080p";
        this.mRecordingTotalTime = 0L;
        this.mProfile = null;
        this.mVideoSurface = null;
        this.mVideoSurfaceLock = new java.lang.Object();
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
        this.mCameraErrorPositiveButtonListener = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.capmode.w_renamed.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                com.oplus.camera.capmode.w_renamed.this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
            }
        };
        this.mCameraRecordingCallback = new com.oplus.ocs.camera.CameraRecordingCallback() { // from class: com.oplus.camera.capmode.w_renamed.8
            @Override // com.oplus.ocs.camera.CameraRecordingCallback
            public void onRecordingResult(com.oplus.ocs.camera.CameraRecordingCallback.CameraRecordingResult cameraRecordingResult) {
                super.onRecordingResult(cameraRecordingResult);
                if (cameraRecordingResult == null) {
                    return;
                }
                com.oplus.camera.e_renamed.f_renamed(com.oplus.camera.capmode.w_renamed.TAG, "onRecordingResult, state: " + cameraRecordingResult.getRecordingState());
            }
        };
        this.mResouces = activity.getResources();
        this.mHandler = new com.oplus.camera.capmode.w_renamed.c_renamed();
        this.mBrightnessAnimationListener = new com.oplus.camera.capmode.w_renamed.a_renamed(activity);
        this.mBrightnessAnimator = android.animation.ValueAnimator.ofFloat(1.0f, BRIGHTNESS_ALPHA_END);
        this.mBrightnessAnimator.setDuration(10000L);
        this.mBrightnessAnimator.addUpdateListener(this.mBrightnessAnimationListener);
        initRecordThread();
    }

    protected void initRecordThread() {
        if (this.mRecordHandlerThread == null) {
            this.mRecordHandlerThread = new android.os.HandlerThread("CameraRecorder");
            this.mRecordHandlerThread.start();
            this.mRecordHandler = new android.os.Handler(this.mRecordHandlerThread.getLooper()) { // from class: com.oplus.camera.capmode.w_renamed.2
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) throws java.lang.IllegalStateException, java.io.IOException {
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.w_renamed.TAG, "initRecordThread,  what:" + message.what);
                    int i_renamed = message.what;
                    if (i_renamed == 8) {
                        com.oplus.camera.capmode.w_renamed.this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.w_renamed.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.oplus.camera.capmode.w_renamed.this.hideHintViewShowZoom();
                            }
                        });
                        return;
                    }
                    if (i_renamed != 12) {
                        switch (i_renamed) {
                            case 1:
                                com.oplus.camera.capmode.w_renamed.this.startVideoRecordThread();
                                break;
                            case 2:
                                com.oplus.camera.capmode.w_renamed.this.stopVideoRecordThread();
                                break;
                            case 3:
                                com.oplus.camera.capmode.w_renamed.this.deleteVideoFile((java.lang.String) message.obj);
                                break;
                            case 4:
                                com.oplus.camera.capmode.w_renamed.this.cleanupEmptyFile((java.lang.String) message.obj);
                                break;
                            case 5:
                                com.oplus.camera.capmode.w_renamed.this.onStopVideoRecording(true);
                                break;
                            case 6:
                                com.oplus.camera.capmode.w_renamed.this.prepareVideoSurface();
                                break;
                        }
                        return;
                    }
                    com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.w_renamed.TAG, "mRecordSig open");
                    com.oplus.camera.capmode.w_renamed.this.mRecordSig.open();
                }
            };
        }
    }

    protected boolean isVideoFlashTorchOpen() {
        if (this.mbFlashTemporaryDisabled) {
            return false;
        }
        if (this.mPreferences == null || !com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_video_default_value))) || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE) || (this.mbFrontCamera && !isMultiVideoMode())) {
            return this.mPreferences != null && "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.mActivity))) && getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT) && this.mbFrontCamera;
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected com.oplus.camera.ui.control.e_renamed.c_renamed getAfterStoreRunnable() {
        return new com.oplus.camera.ui.control.e_renamed.c_renamed() { // from class: com.oplus.camera.capmode.w_renamed.3
            @Override // com.oplus.camera.ui.control.e_renamed.c_renamed
            public void a_renamed(long j_renamed) {
                if (com.oplus.camera.capmode.w_renamed.this.mbPictureTakenDuringRecord && j_renamed == com.oplus.camera.capmode.w_renamed.this.mPictureTakenTime) {
                    com.oplus.camera.capmode.w_renamed.this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.w_renamed.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.capmode.w_renamed.this.mCameraUIInterface.d_renamed(true);
                        }
                    });
                }
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onPause");
        setLowBatteryState(false);
        android.os.Handler handler = this.mRecordHandler;
        if (handler != null) {
            handler.removeMessages(5);
            this.mRecordHandler.removeMessages(6);
        }
        if (this.mOneCamera != null && (!needSurface("type_preview_frame") || !isAnimojiOpen())) {
            this.mOneCamera.n_renamed(!isSlowVideoHighFrame());
        }
        forceStopVideoRecording(false);
        if (this.mCameraInterface != null && !com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
            this.mCameraInterface.U_renamed();
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
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onResume");
        this.mbMediaLimitProcess = this.mCameraInterface.aF_renamed() && !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_VIDEO_THUMBNAIL_SIMULTANEOUS);
        if (this.mbMediaLimitProcess) {
            com.oplus.camera.ui.control.e_renamed.c_renamed();
        }
        this.mResumePauseRecordingTotalTime = 0L;
        this.mHandler.removeMessages(9);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        if (this.mPreferences != null && !this.mbFrontCamera) {
            return java.lang.Integer.valueOf(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, VIDEO_DEFAULT_FPS)).intValue();
        }
        return java.lang.Integer.valueOf(VIDEO_DEFAULT_FPS).intValue();
    }

    public java.lang.String getVideoCodec() {
        return (this.mPreferences == null || this.mActivity == null) ? com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264 : this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_codec_default_value));
    }

    public java.lang.String getDefaultVideoCodec() {
        return this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_codec_default_value);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onDestroy");
        if (isVideoRecordStopping()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onDestroy, block");
            this.mRecordSig.block(com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
        android.os.HandlerThread handlerThread = this.mRecordHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mRecordHandlerThread = null;
        }
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        android.animation.ValueAnimator valueAnimator = this.mBrightnessAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mBrightnessAnimator.removeAllUpdateListeners();
            this.mBrightnessAnimator = null;
        }
        if (this.mBrightnessAnimationListener != null) {
            this.mBrightnessAnimationListener = null;
        }
        com.coui.appcompat.dialog.app.b_renamed bVar = this.mCameraErrorAlertDialogBuilder;
        if (bVar != null) {
            if (bVar.isShowing()) {
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
            com.oplus.camera.util.Util.e_renamed(this.mActivity, "camera_mode_changed");
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_video_shutter_button));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return "video_size_4kuhd".equals(getVideoSizeType()) ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_4KUHD : super.getCameraFeature();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean needUpdateAsdSceneValue() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_ASD_AISCENE_V3_SUPPORT) && !this.mbFrontCamera && isAiEnhancementVideoOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.c_renamed("button_shape_ring_none");
        if (isVideoRecording()) {
            shutterButtonInfo.a_renamed(2);
            shutterButtonInfo.a_renamed("button_color_inside_none");
            shutterButtonInfo.b_renamed(1);
        } else {
            shutterButtonInfo.a_renamed("button_color_inside_red");
        }
        return shutterButtonInfo;
    }

    public java.lang.String getDefaultVideoSize() {
        return this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_size_default);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public java.lang.String getVideoFileName() {
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
    public boolean getSupportMenu(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(strD)) {
            return getSupportFunction(strD);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(strD)) {
            return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(strD)) {
            return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR.equals(strD)) {
            return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR);
        }
        return super.getSupportMenu(strD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed.b_renamed(1 == i_renamed);
        }
        return super.getFilterNameIdList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed.a_renamed(1 == i_renamed);
        }
        return super.getFilterTypeList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return isSubMenuEnable();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return getSupportSubMenu(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR) || getSupportSubMenu(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU) ? com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_INDEX : super.getFilterEffectMenuPreferenceKey();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:62:0x00dd  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.w_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.H_renamed();
        }
        if (this.mCameraInterface != null) {
            this.mCameraUIInterface.f_renamed(7, true);
        }
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_QUICK_VIDEO) && !needPostProcessAfterStopRecord()) {
            showRecordingTimeUI();
        }
        this.mbPictureTakenDuringRecord = false;
        this.mbGetDcsData = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (this.mCameraUIInterface == null || this.mCameraInterface == null || this.mCameraInterface.i_renamed()) {
            return;
        }
        this.mCameraUIInterface.b_renamed(4, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        java.lang.Object obj;
        android.hardware.camera2.CaptureResult.Key<int[]> key;
        java.lang.Integer num;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onPreviewCaptureResult, invalid totalResult : " + cameraPreviewResult);
            return;
        }
        android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.S_renamed);
        java.lang.Object objA2 = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.ai_renamed);
        if (objA2 != null) {
            this.mbEisHalCache = ((java.lang.Integer) objA2).intValue() > 0;
        }
        if (objA != null && (objA instanceof java.lang.Integer) && (num = (java.lang.Integer) objA) != null && this.mActivity != null && 2 == this.mCameraInterface.g_renamed() && (1002 == num.intValue() || 1003 == num.intValue())) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.w_renamed.4
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.capmode.w_renamed.this.mCameraInterface.f_renamed();
                }
            });
        }
        this.mFaceCountOnStop = this.mCameraInterface.aj_renamed();
        if (this.mbGetDcsData) {
            this.mbGetDcsData = false;
            if (com.oplus.camera.util.Util.C_renamed()) {
                obj = com.oplus.camera.e_renamed.b_renamed.U_renamed;
                key = com.oplus.camera.e_renamed.b_renamed.T_renamed;
            } else {
                obj = com.oplus.camera.e_renamed.b_renamed.W_renamed;
                key = com.oplus.camera.e_renamed.b_renamed.ah_renamed;
            }
            try {
                if (com.oplus.camera.util.Util.C_renamed()) {
                    float[] fArr = (float[]) captureResult.get(obj);
                    if (fArr != null && fArr.length > 0) {
                        this.mDcsLux = fArr[0];
                    } else {
                        com.oplus.camera.e_renamed.a_renamed(TAG, "onPreviewCaptureResult, lux value: " + java.util.Arrays.toString(fArr));
                    }
                } else {
                    int[] iArr = (int[]) captureResult.get(obj);
                    if (iArr != null && iArr.length > 0) {
                        this.mDcsLux = iArr[0];
                    } else {
                        com.oplus.camera.e_renamed.a_renamed(TAG, "onPreviewCaptureResult, key: " + obj + ", luxIntValues: " + java.util.Arrays.toString(iArr));
                    }
                }
                int[] iArr2 = (int[]) captureResult.get(key);
                if (iArr2 != null && iArr2.length > 0) {
                    this.mDcsCCT = iArr2[0];
                } else {
                    com.oplus.camera.e_renamed.a_renamed(TAG, "onPreviewCaptureResult, cct value: " + this.mDcsCCT);
                }
                this.mDcsIso = (((java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY)).intValue() * ((java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)).intValue()) / 100;
                this.mDcsExp = ((java.lang.Long) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME)).longValue();
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.d_renamed(TAG, "onPreviewCaptureResult, getValue error.", e_renamed);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getSurfaceSize(java.lang.String str, com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size sizeFromConfig = getSizeFromConfig(getCameraFeature(), str, com.oplus.camera.capmode.BaseMode.a_renamed.INPUT);
        return sizeFromConfig != null ? sizeFromConfig : getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.media.CamcorderProfile profile = getProfile();
        if (profile != null) {
            return new android.util.Size(profile.videoFrameWidth, profile.videoFrameHeight);
        }
        return super.getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (isVideoRecording()) {
            if (isVideoRecordStarted() && this.mCameraInterface.g_renamed() == 1) {
                onStopVideoRecording(true);
            } else if (isVideoRecordStarting() && this.mbStartFailue) {
                onStopVideoRecording(false);
            }
            com.oplus.camera.e_renamed.a_renamed(TAG, "onBackPressed, isVideoRecording return");
            return true;
        }
        if (isVideoRecordStopping()) {
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z_renamed) {
        if (isVideoRecordStarting()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "forceStopVideoRecording, mRecordSig.block");
            this.mRecordSig.close();
            if (!isVideoRecordStarted()) {
                this.mRecordSig.block();
            }
            com.oplus.camera.e_renamed.a_renamed(TAG, "forceStopVideoRecording, mRecordSig.block X_renamed");
        }
        if (isVideoRecordStarted() || isVideoRecordStarting()) {
            onStopVideoRecording(z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBeforePreview");
        readProfile();
        this.mbEnableTuningData = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setLowBatteryState(boolean z_renamed) {
        this.mbLowBatteryDisabled = z_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void doReturnToCaller(boolean z_renamed) {
        int i_renamed;
        android.content.Intent intent = new android.content.Intent();
        if (z_renamed) {
            i_renamed = -1;
            intent.setData(this.mCurrentVideoUri);
            intent.addFlags(1);
        } else {
            i_renamed = 0;
        }
        this.mActivity.setResult(i_renamed, intent);
        this.mActivity.finish();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void deleteCurrentVideo() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "deleteCurrentVideo");
        java.lang.String str = this.mCurrentVideoFilename;
        if (str != null) {
            this.mRecordHandler.obtainMessage(3, str).sendToTarget();
            this.mCurrentVideoFilename = null;
        }
        this.mCameraUIInterface.t_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void startPlayVideoActivity() {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setDataAndType(this.mCurrentVideoUri, convertOutputFormatToMimeType(getProfile().fileFormat));
        intent.addFlags(1);
        if (!android.text.TextUtils.isEmpty(com.oplus.camera.v_renamed.f_renamed())) {
            intent.putExtra(com.oplus.camera.v_renamed.f_renamed(), true);
        }
        try {
            this.mActivity.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e_renamed) {
            com.oplus.camera.e_renamed.d_renamed(TAG, "startPlayVideoActivity, Couldn't_renamed view video: " + this.mCurrentVideoUri, e_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onBeforeSnapping");
        if (isVideoRecordStarted()) {
            return true;
        }
        com.oplus.camera.e_renamed.f_renamed(TAG, "onBeforeSnapping, is_renamed not in_renamed RECORD_STARTED");
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    /* renamed from: onVideoShutterButtonClick */
    public void aj_renamed() throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.camera.e_renamed.f_renamed(TAG, "onVideoShutterButtonClick, mMediaRecorderState: " + this.mMediaRecorderState + ", mCameraInterface.isAnimationRunning: " + this.mCameraInterface.R_renamed());
        if (this.mbPaused || this.mCameraInterface.g_renamed() != 1 || this.mCameraInterface.R_renamed() || this.mCameraInterface.S_renamed() || this.mCameraInterface.E_renamed()) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onVideoShutterButtonClick, mbPaused: " + this.mbPaused + ", CameraState: " + this.mCameraInterface.g_renamed() + ", isAnimationRunning: " + this.mCameraInterface.R_renamed() + ", isBlurAnimRunning: " + this.mCameraInterface.S_renamed() + ", mCameraInterface.getSwitchingCameraState: " + this.mCameraInterface.E_renamed());
            return;
        }
        if (isMultiVideoMode() && !this.mCameraUIInterface.aW_renamed()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoShutterButtonClick, multi video is_renamed not prepared yet");
            return;
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(7, true);
        }
        if (this.mCameraInterface.F_renamed()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoShutterButtonClick, being capture mode change!");
            return;
        }
        if (com.oplus.camera.Storage.w_renamed != 0) {
            this.mCameraUIInterface.t_renamed();
            return;
        }
        if (!isVideoRecording() && !this.mCameraInterface.P_renamed()) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "onVideoShutterButtonClick, memory or storage is_renamed not enough");
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
            reportReminderToDcs(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_MEMORY_CAPTURE);
            return;
        }
        if (isVideoRecordStarting() || this.mHandler.hasMessages(5)) {
            com.oplus.camera.e_renamed.e_renamed(TAG, "onVideoShutterButtonClick, starting or error processing");
            return;
        }
        if (recDisabledReturn()) {
            return;
        }
        if (this.mbRecordAudio && this.mActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onVideoShutterButtonClick, permission not granted");
            setHalStatus(0);
            if (com.oplus.camera.util.Util.ak_renamed()) {
                androidx.appcompat.app.f_renamed fVar = this.mPGDialog;
                if (fVar != null && fVar.isShowing()) {
                    this.mPGDialog.dismiss();
                }
                com.oplus.camera.util.g_renamed.a_renamed(this.mActivity, "android.permission.RECORD_AUDIO", new com.oplus.camera.util.g_renamed.b_renamed() { // from class: com.oplus.camera.capmode.w_renamed.5
                    @Override // com.oplus.camera.util.g_renamed.b_renamed
                    public void a_renamed(androidx.appcompat.app.f_renamed fVar2) {
                        com.oplus.camera.capmode.w_renamed.this.mPGDialog = fVar2;
                    }

                    @Override // com.oplus.camera.util.g_renamed.b_renamed
                    public void a_renamed(androidx.appcompat.app.f_renamed fVar2, boolean z_renamed) {
                        if (fVar2 != null && fVar2.isShowing()) {
                            fVar2.dismiss();
                        }
                        if (z_renamed) {
                            com.oplus.camera.capmode.w_renamed.this.mActivity.requestPermissions(new java.lang.String[]{"android.permission.RECORD_AUDIO"}, 2);
                        }
                    }
                });
                return;
            }
            this.mActivity.requestPermissions(new java.lang.String[]{"android.permission.RECORD_AUDIO"}, 2);
            return;
        }
        com.oplus.camera.e_renamed.f_renamed(TAG, "onVideoShutterButtonClick, CameraTest Click Video Button");
        if (isVideoRecordStarted()) {
            onStopVideoRecording(true);
        } else if (isVideoRecordStopped()) {
            com.oplus.camera.perf.b_renamed.a_renamed("start_video_record");
            this.mPreviewVideoCostTime = java.lang.System.currentTimeMillis() - this.mPreviewOkTime;
            startVideoRecording();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onScreenOffWhenLocked() {
        if (isVideoRecordStarted() || isVideoRecordStarting()) {
            this.mActivity.sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.fromFile(new java.io.File(this.mVideoFilename))));
            com.oplus.camera.e_renamed.a_renamed(TAG, "notifyScanVideoFile, sendBroadcast() success");
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
    public void handleStartError(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "handleStartError, fromBroadcast: " + z_renamed + ", showDialog: " + z2);
        this.mRecordHandler.obtainMessage(3, this.mVideoFilename).sendToTarget();
        if (!isUseMediaCodec()) {
            releaseVideoRecorderWrapper();
        }
        this.mCameraInterface.U_renamed();
        if (isVideoRecordStarting() || isVideoRecordStarted()) {
            onStopVideoRecording(false);
        }
        if (z_renamed) {
            android.os.Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(5);
            }
            this.mActivity.onBackPressed();
        } else {
            this.mCameraUIInterface.x_renamed();
            if ("on_renamed".equals(com.oplus.camera.Storage.u_renamed) && !com.oplus.camera.Storage.f_renamed()) {
                com.oplus.camera.Storage.v_renamed = 5;
                com.oplus.camera.Storage.u_renamed = "invalid";
                com.oplus.camera.Storage.w_renamed = 3;
                this.mEndType = com.oplus.camera.statistics.model.VideoRecordMsgData.END_TYPE_MOMORY_LIMIT;
                this.mCameraUIInterface.t_renamed();
                this.mbStartFailue = false;
                return;
            }
            if (z2) {
                this.mCameraUIInterface.a_renamed(new android.content.DialogInterface.OnCancelListener() { // from class: com.oplus.camera.capmode.w_renamed.6
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(android.content.DialogInterface dialogInterface) {
                        com.oplus.camera.capmode.w_renamed.this.mActivity.onBackPressed();
                    }
                });
            }
        }
        this.mbStartFailue = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingPause() throws java.lang.IllegalStateException {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoRecordingPause");
        if (!isVideoRecordStarted()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoRecordingPause, VideoRecord is_renamed not started, so return");
            return false;
        }
        if (this.mRecordingTotalTime < getRecordingMinTime(true)) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoRecordingPause, mRecordingTotalTime less then 1s, so return");
            return false;
        }
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mCameraUIInterface.e_renamed(false);
        this.mLastPausingTime = android.os.SystemClock.uptimeMillis();
        if (isHyperLapseOpen()) {
            this.mOneCamera.A_renamed();
            return true;
        }
        this.mPauseClickTimes++;
        reportPauseClickMsg();
        boolean zG = this.mVideoRecorder.g_renamed();
        if (!isUseMediaCodec()) {
            this.mOneCamera.A_renamed();
        }
        return zG;
    }

    private void reportPauseClickMsg() {
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData = new com.oplus.camera.statistics.model.VideoRecordMsgData(this.mActivity);
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
    public boolean onVideoRecordingResume() throws java.lang.IllegalStateException {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoRecordingResume");
        if (!isVideoRecordStarted()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoRecordingResume, VideoRecord is_renamed not started, so return");
            return false;
        }
        this.mHandler.sendEmptyMessage(1);
        this.mCameraUIInterface.e_renamed(true);
        this.mTotalPausingTime += android.os.SystemClock.uptimeMillis() - this.mLastPausingTime;
        this.mLastPausingTime = 0L;
        if (isHyperLapseOpen()) {
            this.mOneCamera.B_renamed();
            return true;
        }
        boolean zF = this.mVideoRecorder.f_renamed();
        if (!isUseMediaCodec()) {
            this.mOneCamera.B_renamed();
        }
        return zF;
    }

    private void setVideoSurfaceState(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setVideoSurfaceState, mVideoSurfaceState: " + this.mVideoSurfaceState + " => " + i_renamed);
        this.mVideoSurfaceState = i_renamed;
    }

    private boolean isVideoSurfacePrepared() {
        return this.mVideoSurfaceState == 2;
    }

    private boolean isVideoSurfacePreparing() {
        return this.mVideoSurfaceState == 1;
    }

    protected void setVideoRecordState(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "setVideoRecordState, mMediaRecorderState: " + this.mMediaRecorderState + " => " + i_renamed);
        this.mMediaRecorderState = i_renamed;
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
    public android.media.CamcorderProfile getProfile() {
        return this.mProfile;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:4:0x000e  */
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
            com.oplus.camera.e_renamed.a_renamed(r1, r5)
            android.util.Size r5 = new android.util.Size
            r5.<init>(r0, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.w_renamed.getVideoPreviewSize(java.lang.String):android.util.Size");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.graphics.Bitmap getVideoThumbnail(int i_renamed) {
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.mVideoFileDescriptor;
        if (parcelFileDescriptor != null) {
            return com.oplus.camera.ui.control.e_renamed.a_renamed(parcelFileDescriptor.getFileDescriptor(), i_renamed);
        }
        java.lang.String str = this.mCurrentVideoFilename;
        if (str != null) {
            return com.oplus.camera.ui.control.e_renamed.a_renamed(str, i_renamed);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.x_renamed.g_renamed
    public void onException(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onException, exceptionCode: " + i_renamed);
        if (1 != i_renamed || isVideoRecordStopped()) {
            return;
        }
        onStopVideoRecording(false);
    }

    @Override // com.oplus.camera.capmode.x_renamed.f_renamed
    public void onError(java.lang.Object obj, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onError, what: " + i_renamed + ", extra: " + i2);
        if (isUseMediaCodec() || (i_renamed != 1 && i2 != -1007)) {
            if (!isUseMediaCodec()) {
                return;
            }
            if (i_renamed != 1100 && i_renamed != 1101 && i_renamed >= 0) {
                return;
            }
        }
        if (isUseMediaCodec() && i_renamed < 0) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onError, kill myself");
            if (this.mCameraInterface != null) {
                this.mCameraInterface.Q_renamed();
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

    @Override // com.oplus.camera.capmode.x_renamed.h_renamed
    public void onInfo(java.lang.Object obj, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onInfo");
        if (i_renamed == 800) {
            if (isVideoRecordStarted()) {
                onStopVideoRecording(true);
            }
        } else if ((i_renamed == 801 || i_renamed == 802) && isVideoRecordStarted()) {
            this.mbShowHint = true;
            onStopVideoRecording(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteVideoFile(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "deleteVideoFile, fileName: " + str);
        if (str == null) {
            this.mRecordFileNameChange.open();
            return;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && !file.delete()) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "deleteVideoFile, Could not delete " + str);
        }
        if (this.mCurrentVideoUri != null) {
            try {
                try {
                    this.mActivity.getContentResolver().delete(this.mCurrentVideoUri, null, null);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            } finally {
                this.mCurrentVideoUri = null;
            }
        }
        this.mRecordFileNameChange.open();
    }

    protected void closeVideoFileDescriptor() throws java.io.IOException {
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.mVideoFileDescriptor;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (java.io.IOException e_renamed) {
                com.oplus.camera.e_renamed.d_renamed(TAG, "closeVideoFileDescriptor, Fail to close fd_renamed", e_renamed);
            }
            this.mVideoFileDescriptor = null;
        }
    }

    private void releaseVideoRecorderWrapper() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "releaseVideoRecorderWrapper, Releasing media recorder.");
        synchronized (this.mVideoRecorderSig) {
            if (this.mVideoRecorder != null) {
                if (this.mVideoFilename != null) {
                    this.mRecordHandler.obtainMessage(4, this.mVideoFilename).sendToTarget();
                }
                this.mVideoRecorder.d_renamed();
                this.mVideoRecorder = null;
            }
        }
    }

    private void stopCheckStorageAsyncTask() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(2);
        }
        android.os.AsyncTask asyncTask = this.mCheckStorageTask;
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
        if (this.mCameraInterface != null && !com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
            this.mCameraInterface.U_renamed();
        }
        if (this.mHandler != null) {
            stopUpdateRecordTime();
            this.mHandler.removeMessages(4);
            this.mHandler.removeMessages(3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:117:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:137:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean stopVideoRecording() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.w_renamed.stopVideoRecording():boolean");
    }

    protected void onStopVideoRecording(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onStopVideoRecording, checkRecordTime: " + z_renamed);
        this.mbStartFailue = false;
        this.mRecordingEndTemperature = this.mPreferences.getFloat(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_TEMPERATURE, -1.0f);
        if (!this.mbPaused && this.mOneCamera != null && (!com.oplus.camera.util.Util.C_renamed() || !isHFR())) {
            this.mOneCamera.A_renamed(0);
        }
        if (!this.mbPaused && this.mCameraInterface != null && this.mCameraInterface.i_renamed() && !supportParameterAdjust() && this.mOneCamera != null) {
            this.mCameraInterface.ac_renamed();
            this.mCameraInterface.b_renamed(false, false);
            this.mOneCamera.a_renamed(3, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        com.oplus.camera.perf.b_renamed.a_renamed("video_save");
        setVideoRecordState(3);
        android.os.Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(7)) {
            this.mHandler.removeMessages(7);
        }
        if (this.mCameraInterface != null && !this.mCameraInterface.ay_renamed()) {
            this.mCameraInterface.N_renamed();
        }
        this.mRecordSig.close();
        android.os.Handler handler2 = this.mHandler;
        if (handler2 != null && handler2.hasMessages(6)) {
            this.mHandler.removeMessages(6);
        }
        android.os.Handler handler3 = this.mHandler;
        if (handler3 != null && handler3.hasMessages(13)) {
            this.mHandler.removeMessages(13);
        }
        this.mBrightnessAnimator.cancel();
        if (this.mCameraInterface != null && needVideoPipeline() && !isHalEisCache() && (isSlowVideoHighFrame() || isHyperLapseOpen())) {
            this.mOneCamera.z_renamed();
        }
        if (this.mRecordHandler != null && !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && !isHyperLapseOpen()) {
            this.mRecordHandler.removeMessages(2);
            this.mRecordHandler.sendEmptyMessage(2);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.M_renamed();
        }
        com.oplus.camera.perf.FluencyPerformance.e_renamed(java.lang.System.currentTimeMillis());
    }

    protected void stopVideoRecordThread() {
        android.os.Handler handler = this.mHandler;
        if (handler != null && handler.hasMessages(7)) {
            this.mHandler.removeMessages(7);
        }
        java.lang.String videoTitle = getVideoTitle();
        boolean z_renamed = this.mbHasDragIntelligentView;
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
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.w_renamed.7
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.capmode.w_renamed.this.mbDestroyed) {
                        return;
                    }
                    if (com.oplus.camera.capmode.w_renamed.this.isVideoHdrOpen() && com.oplus.camera.capmode.w_renamed.this.isCommonVideoMode()) {
                        com.oplus.camera.capmode.w_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_video_hdr, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
                    }
                    if (com.oplus.camera.capmode.w_renamed.this.isUltraNightVideoOpen() && com.oplus.camera.capmode.w_renamed.this.isCommonVideoMode()) {
                        com.oplus.camera.capmode.w_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_ultra_video_night, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
                    }
                    if (com.oplus.camera.capmode.w_renamed.this.mPreviewEffectProcess != null) {
                        com.oplus.camera.capmode.w_renamed.this.mPreviewEffectProcess.f_renamed(false);
                    }
                    com.oplus.camera.capmode.w_renamed.this.mCameraInterface.O_renamed();
                    com.oplus.camera.capmode.w_renamed.this.stopShutterButtonProgress();
                    com.oplus.camera.capmode.w_renamed.this.restoreVideoPreviewState();
                }
            });
        }
        final com.oplus.camera.ui.control.e_renamed.d_renamed dVar = new com.oplus.camera.ui.control.e_renamed.d_renamed();
        dVar.k_renamed = 1;
        if (zIsRecordFileValid && this.mActivity != null) {
            if (!isDoubleExposureOpen()) {
                addVideoToMediaStore(dVar, z_renamed, videoTitle);
            }
            dVar.d_renamed = this.mCurrentVideoUri;
        }
        android.os.Handler handler2 = this.mHandler;
        if (handler2 == null) {
            return;
        }
        handler2.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$w_renamed$m_renamed-1Sq3iArwzFawybFCdK_j6Tj5o
            @Override // java.lang.Runnable
            public final void run() throws java.io.IOException {
                this.f_renamed$0.lambda$stopVideoRecordThread$0$w_renamed(dVar, zIsRecordFileValid);
            }
        });
        if (this.mHandler.hasMessages(9)) {
            this.mHandler.removeMessages(9);
            this.mHandler.sendEmptyMessageDelayed(9, 100L);
        }
        this.mRecordHandler.sendEmptyMessageDelayed(12, 300L);
    }

    public /* synthetic */ void lambda$stopVideoRecordThread$0$w_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed dVar, boolean z_renamed) throws java.io.IOException {
        if (this.mbDestroyed) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "stopVideoRecordThread, return");
            return;
        }
        resumeAudioPlayback();
        int i_renamed = (this.mStartRecordingOrientation + 90) % 360;
        com.oplus.camera.e_renamed.a_renamed(TAG, "stopVideoRecordThread, mStartRecordingOrientation: " + this.mStartRecordingOrientation + ", orientation: " + i_renamed);
        dVar.f6062b = i_renamed;
        this.mCameraInterface.a_renamed(dVar, z_renamed ^ true, isDoubleExposureOpen() ^ true);
        closeVideoFileDescriptor();
        setVideoRecordState(2);
        if (this.mCameraInterface.aY_renamed()) {
            this.mCameraInterface.aZ_renamed();
        }
        if (this.mbShowHint) {
            com.oplus.camera.util.o_renamed.a_renamed(this.mActivity, com.oplus.camera.R_renamed.string.camera_video_reach_size_limit);
            this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
            this.mCameraInterface.d_renamed(false);
            this.mRecordHandler.removeMessages(8);
            this.mRecordHandler.sendEmptyMessageDelayed(8, 3000L);
            this.mbShowHint = false;
            reportReminderToDcs(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_VIDEO_SIZE_LIMIT);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoRecordingFail() {
        com.oplus.camera.e_renamed.f_renamed(TAG, "onVideoRecordingFail");
        if (this.mCameraInterface != null) {
            this.mCameraInterface.f_renamed(true);
        } else {
            com.oplus.camera.e_renamed.f_renamed(TAG, "onVideoRecordingFail, mCameraInterface is_renamed null");
        }
    }

    private boolean checkVideoFileReady(java.lang.String str) throws java.lang.InterruptedException {
        com.oplus.camera.e_renamed.a_renamed(TAG, "checkVideoFileReady, videoFilename: " + str);
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        try {
            java.lang.Thread.sleep(WAIT_FOR_VIDEO_DURATION);
        } catch (java.lang.InterruptedException e_renamed) {
            e_renamed.printStackTrace();
        }
        java.io.File file2 = new java.io.File(str);
        boolean zExists = file2.exists();
        long length = file2.length();
        com.oplus.camera.e_renamed.a_renamed(TAG, "checkVideoFileReady, exist: " + zExists + ", fileLength: " + length);
        return zExists && length > 0;
    }

    protected boolean isRecordFileValid() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "isRecordFileValid, mbStopVideoFail:  " + this.mbStopVideoFail + ", mRecordingTotalTime: " + this.mRecordingTotalTime);
        return !this.mbStopVideoFail && ((long) getRecordingMinTime(false)) <= this.mRecordingTotalTime;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:103:0x00ef A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:107:? A_renamed[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x00e7 A_renamed[Catch: Exception -> 0x00d4, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x00d4, blocks: (B_renamed:27:0x00d0, B_renamed:37:0x00e7), top: B_renamed:101:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:47:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:51:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x012f A_renamed[Catch: all -> 0x01f2, Exception -> 0x01f4, Merged into TryCatch #2 {all -> 0x01f2, Exception -> 0x01f4, blocks: (B_renamed:52:0x0129, B_renamed:54:0x012f, B_renamed:56:0x0135, B_renamed:58:0x015e, B_renamed:60:0x016c, B_renamed:62:0x0170, B_renamed:64:0x0191, B_renamed:65:0x0196, B_renamed:57:0x014f, B_renamed:70:0x01f5), top: B_renamed:97:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:77:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:80:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:87:0x024d  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean addVideoToMediaStore(com.oplus.camera.ui.control.e_renamed.d_renamed r16, boolean r17, java.lang.String r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.w_renamed.addVideoToMediaStore(com.oplus.camera.ui.control.e_renamed$d_renamed, boolean, java.lang.String):boolean");
    }

    protected android.util.Size getSizeFromConfig(java.lang.String str, java.lang.String str2, com.oplus.camera.capmode.BaseMode.a_renamed aVar) {
        android.util.Size videoPreviewSize;
        android.util.Size size;
        if (isRearSuperEISOpen() || isVideoSuperEisWideOpen() || isHyperLapseOpen() || getProfile() == null) {
            videoPreviewSize = null;
            size = null;
        } else {
            videoPreviewSize = getVideoPreviewSize(getVideoSizeType());
            size = new android.util.Size(getProfile().videoFrameWidth, getProfile().videoFrameHeight);
        }
        com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig previewConfig = str != null ? com.oplus.camera.aps.util.AlgoSwitchConfig.getPreviewConfig(str, this.mCameraId, videoPreviewSize, size, needApsToProcessVideoWatermark(), com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_SAT_HAL.equals(str) || com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_4KUHD.equals(str) || com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_LIVE_HDR.equals(str) || com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_ULTRA_NIGHT.equals(str) || com.oplus.camera.aps.constant.ApsConstant.FEATURE_REC_AI_ENHANCEMENT.equals(str) || (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON.equals(str) && 1 == this.mCameraId) || (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO.equals(str) && 1 == this.mCameraId), com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) && this.mCameraId == 0) : null;
        if (previewConfig != null && previewConfig.mComponentMap.containsKey("video")) {
            com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig.Component component = previewConfig.mComponentMap.get("video");
            this.mPreviewConfig = previewConfig;
            if (component.mbEnable) {
                if ("type_video_frame".equals(str2)) {
                    if (aVar == com.oplus.camera.capmode.BaseMode.a_renamed.INPUT) {
                        return new android.util.Size(component.mMasterInputWidth, component.mMasterInputHeight);
                    }
                    return new android.util.Size(component.mOutputWidth, component.mOutputHeight);
                }
                if ("type_still_capture_yuv_main".equals(str2)) {
                    return new android.util.Size(component.mOutputWidth, component.mOutputHeight);
                }
            }
        }
        if (previewConfig != null && previewConfig.mComponentMap.containsKey("preview")) {
            com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig.Component component2 = previewConfig.mComponentMap.get("preview");
            this.mPreviewConfig = previewConfig;
            if (component2.mbEnable && "type_main_preview_frame".equals(str2)) {
                return new android.util.Size(component2.mMasterInputWidth, component2.mMasterInputHeight);
            }
        }
        this.mPreviewConfig = previewConfig;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoRecordThread() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "startVideoRecordThread");
        if (this.mbPaused) {
            return;
        }
        boolean z_renamed = false;
        try {
            try {
                this.mVideoRecorder.e_renamed();
                if (this.mOneCamera != null && !com.oplus.camera.util.Util.C_renamed()) {
                    this.mOneCamera.a_renamed(getVideoFpsRange());
                }
                if (this.mOneCamera != null) {
                    setRecordingParameter();
                    if (!isUseMediaCodec()) {
                        this.mOneCamera.a_renamed(this.mCameraRecordingCallback, this.mRecordHandler);
                    } else {
                        this.mOneCamera.A_renamed(1);
                    }
                }
                boolean zB = this.mVideoRecorder.b_renamed();
                this.mRecordingTotalTime = 0L;
                com.oplus.camera.e_renamed.a_renamed(TAG, "startVideoRecordThread, start end, result: " + zB + ", isUseMediaCodec: " + isUseMediaCodec());
                if (zB) {
                    if (this.mPreviewEffectProcess != null) {
                        this.mPreviewEffectProcess.f_renamed(true);
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
            } catch (java.lang.Exception e_renamed) {
                java.lang.String parameters = ((android.media.AudioManager) this.mActivity.getApplicationContext().getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO)).getParameters(KEY_RECORD_FORBID);
                com.oplus.camera.e_renamed.d_renamed(TAG, "startVideoRecordThread failed, mVideoFilename: " + this.mVideoFilename + ", value: " + parameters, e_renamed);
                this.mbStartFailue = true;
                if ((!android.text.TextUtils.isEmpty(parameters) && "true".contains(parameters)) || (!isUseMediaCodec() && this.mbDisplayOnLock)) {
                    z_renamed = true;
                }
                this.mHandler.obtainMessage(5, java.lang.Boolean.valueOf(z_renamed)).sendToTarget();
            }
        } finally {
            this.mRecordSig.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoRecordHandler() throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        startShutterButtonProgress();
        this.mRecordingStartTime = android.os.SystemClock.uptimeMillis();
        updateRecordingTime();
        this.mCameraUIInterface.e_renamed(true);
        this.mCameraInterface.e_renamed(true);
        com.oplus.camera.e_renamed.a_renamed(TAG, "startVideoRecordHandler end");
    }

    protected void showRecordingTimeUI() {
        this.mCameraUIInterface.a_renamed(getRealVideoTimeRatio(), getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.record_time_margin_top), needShowVideoTime(), true);
    }

    public void showPreparingErrorDialog() {
        if (this.mCameraErrorAlertDialogBuilder != null) {
            if (!(this.mActivity instanceof android.app.Activity) || this.mActivity.isFinishing()) {
                return;
            }
            this.mCameraErrorAlertDialogBuilder.show();
            return;
        }
        java.lang.String string = this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_prepare_error_dialog_message_1080);
        com.coui.appcompat.dialog.app.b_renamed.a_renamed aVar = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.mActivity);
        aVar.setTitle(string);
        aVar.setPositiveButton(com.oplus.camera.R_renamed.string.camera_video_prepare_error_dialog_switch, this.mCameraErrorPositiveButtonListener);
        aVar.setNegativeButton(com.oplus.camera.R_renamed.string.camera_video_prepare_error_dialog_cancel, (android.content.DialogInterface.OnClickListener) null);
        this.mCameraErrorAlertDialogBuilder = aVar.create();
        if ((this.mActivity instanceof android.app.Activity) && !this.mActivity.isFinishing()) {
            this.mCameraErrorAlertDialogBuilder.show();
        }
        if (this.mCameraErrorAlertDialogBuilder.a_renamed(-1) != null) {
            androidx.core.widget.i_renamed.a_renamed(this.mCameraErrorAlertDialogBuilder.a_renamed(-1), com.oplus.camera.R_renamed.style.CameraErrorPositiveButtonStyle);
        }
        if (this.mCameraErrorAlertDialogBuilder.a_renamed(-2) != null) {
            androidx.core.widget.i_renamed.a_renamed(this.mCameraErrorAlertDialogBuilder.a_renamed(-2), com.oplus.camera.R_renamed.style.CameraErrorNegativeButtonStyle);
        }
    }

    private int getDimensionPixelSize(int i_renamed) {
        android.content.res.Resources resources = this.mResouces;
        if (resources != null) {
            return resources.getDimensionPixelSize(i_renamed);
        }
        return 0;
    }

    private void startVideoRecording() throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (1 == android.provider.Settings.System.getInt(this.mActivity.getContentResolver(), "oplus.camera.video", 0)) {
            setVideoRecordState(2);
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_high_temperature_video_record_disable, -1, true, false, false);
            com.oplus.camera.e_renamed.f_renamed(TAG, "startVideoRecording, Can't_renamed start recording video due to high temperature, so return");
            return;
        }
        this.mRecordingStartTemperature = this.mPreferences.getFloat(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_TEMPERATURE, -1.0f);
        boolean zK = this.mCameraInterface.K_renamed();
        this.mbShowHint = false;
        this.mbVideoFrameInAPS = isVideoFrameProcessInAPS();
        if (this.mRecordHandler.hasMessages(8)) {
            this.mRecordHandler.removeMessages(8);
            hideHintViewShowZoom();
        }
        sendBoradCastToStopRecordSound();
        sendBoradCastToStopVideo();
        if (!zK) {
            setVideoRecordState(2);
            com.oplus.camera.e_renamed.f_renamed(TAG, "startVideoRecording, ret is_renamed false, so return");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "startVideoRecording, mVideoRecorder: " + this.mVideoRecorder);
        com.oplus.camera.perf.FluencyPerformance.d_renamed(java.lang.System.currentTimeMillis());
        if (is4k()) {
            com.oplus.camera.util.Util.e_renamed(this.mActivity, "camera_video_recorder");
        }
        updateVideoWatermarkResource();
        this.mRecordHandler.removeMessages(12);
        this.mRecordHandler.removeMessages(5);
        if ((!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) || isMotionDetectOpen()) && !needPostProcessAfterStopRecord()) {
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
            com.oplus.camera.e_renamed.f_renamed(TAG, "startVideoRecording, init FileDescriptor fail");
            return;
        }
        initializeRecorder();
        pauseAudioPlayback();
        this.mCameraInterface.c_renamed(4);
        this.mHandler.removeMessages(6);
        this.mHandler.sendEmptyMessageDelayed(6, 10000L);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS_SECOND_DECREASE_SUPPORT)) {
            this.mHandler.removeMessages(13);
            this.mHandler.sendEmptyMessageDelayed(13, 300000L);
        }
        this.mVideoWatermarkOrientation = this.mOrientation;
        this.mRecordHandler.sendEmptyMessage(1);
        this.mCameraInterface.L_renamed();
        com.oplus.camera.l_renamed.c_renamed.a_renamed(this.mActivity.getContentResolver(), 1);
        this.mHandler.sendEmptyMessageDelayed(2, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        this.mStartRecordingOrientation = this.mCameraInterface.u_renamed();
        this.mStartRecordingFaceCount = this.mCameraInterface.aj_renamed();
        this.mShutterType = getCameraShutterType();
        this.mCameraInterface.a_renamed("normal");
        com.oplus.camera.e_renamed.a_renamed(TAG, "afterInitRecorder end");
    }

    private boolean isVideoFrameProcessInAPS() {
        com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig.Component component;
        com.oplus.camera.aps.util.AlgoSwitchConfig.PreviewConfig previewConfig = this.mPreviewConfig;
        if (previewConfig == null || previewConfig.mComponentMap == null || (component = this.mPreviewConfig.mComponentMap.get("video")) == null) {
            return false;
        }
        java.lang.String[] strArr = component.mAlgoList;
        if (com.oplus.camera.util.Util.a_renamed(strArr)) {
            return false;
        }
        for (java.lang.String str : strArr) {
            if (APS_VIDEO_SUPER_EIS.equals(str) || APS_VIDEO_EIS.equals(str)) {
                return true;
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) && "preview_video_frc".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void setVideoWaterMarkParameter() {
        if (isSloganOpen()) {
            if (isUseMediaCodec()) {
                int iU = this.mCameraInterface.u_renamed() % 360;
                if (this.mPreviewEffectProcess != null) {
                    this.mPreviewEffectProcess.d_renamed(iU);
                    this.mPreviewEffectProcess.a_renamed(this.mCameraInterface.aq_renamed().a_renamed(iU));
                    this.mPreviewEffectProcess.g_renamed(true);
                    return;
                }
                return;
            }
            com.oplus.camera.ad_renamed adVarAq = this.mCameraInterface.aq_renamed();
            com.oplus.camera.c_renamed.a_renamed aVarAr = this.mCameraInterface.ar_renamed();
            if (adVarAq == null || aVarAr == null || aVarAr.b_renamed() == null || aVarAr.c_renamed() == 0 || aVarAr.a_renamed() == null) {
                return;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("orientation", isSloganForceLandscape() ? 270 : this.mVideoWatermarkOrientation);
            bundle.putInt(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.REF_WIDTH, aVarAr.c_renamed());
            bundle.putInt(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.WATERMARK_BORDER_X, aVarAr.d_renamed());
            bundle.putInt(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.WATERMARK_BORDER_Y, aVarAr.e_renamed());
            bundle.putSize(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.SIZE, aVarAr.a_renamed());
            bundle.putString(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.FILE_PATH, adVarAq.d_renamed());
            bundle.putByteArray(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.YUV_BUFFER, aVarAr.b_renamed());
            this.mOneCamera.a_renamed(bundle);
            return;
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.a_renamed((com.oplus.camera.c_renamed.a_renamed) null);
        }
    }

    private void setRecordingParameter() {
        java.lang.String currFilterType = getCurrFilterType();
        this.mOneCamera.a_renamed(currFilterType, isFilterOpen(currFilterType), getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(currFilterType));
        this.mOneCamera.a_renamed(isFaceBeautyOrMakeupOpen(), java.lang.String.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE)), com.oplus.camera.util.Util.a_renamed(getCustomBeautyValues()));
        this.mOneCamera.h_renamed(getSupportFunction(com.oplus.camera.aps.config.CameraFunction.DERED_EYE) && isFlashState());
        setVideoWaterMarkParameter();
    }

    private void updateVideoWatermarkResource() {
        if (!isSloganOpen() || this.mCameraInterface == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("getVideoWatermark");
        boolean z_renamed = !isUseMediaCodec();
        com.oplus.camera.e_renamed.b_renamed(TAG, "updateVideoWatermarkResource, needToSetToHal: " + z_renamed);
        this.mCameraInterface.y_renamed();
        this.mCameraInterface.a_renamed(z_renamed, isMovieMode() ? 2 : 1, isSloganForceLandscape(), 1, false);
        com.oplus.camera.e_renamed.b_renamed("getVideoWatermark");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(com.oplus.camera.e_renamed.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        super.updateCaptureParam(cVar);
        boolean z_renamed = getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_RETENTION) && isVideoRetentionOpen();
        if (cVar.h_renamed) {
            com.oplus.camera.ui.preview.a_renamed.ad_renamed adVar = (com.oplus.camera.ui.preview.a_renamed.ad_renamed) this.mPreviewEffectProcess.j_renamed(32);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("orientation", getVideoOrientation(this.mOrientation));
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>>) com.oplus.ocs.camera.CameraParameter.VIDEO_EFFECT_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>) bundle);
            this.mOneCamera.a_renamed(cVar.h_renamed, adVar.y_renamed() ? 5 : 0, java.util.Arrays.toString(adVar.q_renamed()));
        } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_BLUR_PROCESS) && isBlurOpen()) {
            com.oplus.camera.ui.preview.a_renamed.y_renamed yVarJ = this.mPreviewEffectProcess.j_renamed(32);
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putInt(com.oplus.ocs.camera.CameraParameter.VideoEffectParamKeys.BLUR_LEVEL, yVarJ.y_renamed() ? getBlurIndex() : 0);
            bundle2.putInt("orientation", getVideoOrientation(this.mOrientation));
            bundle2.putFloat(com.oplus.ocs.camera.CameraParameter.VideoEffectParamKeys.BLUR_SHOW, getShowBlurValue());
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>>) com.oplus.ocs.camera.CameraParameter.VIDEO_EFFECT_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>) bundle2);
            int[] iArrZ = yVarJ.z_renamed();
            if (iArrZ != null) {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_BLUR_PARAMS, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) java.util.Arrays.toString(iArrZ));
            }
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_BLUR_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "on_renamed");
        } else if (z_renamed) {
            com.oplus.camera.ui.preview.a_renamed.y_renamed yVarJ2 = this.mPreviewEffectProcess.j_renamed(256);
            android.os.Bundle bundle3 = new android.os.Bundle();
            bundle3.putInt("orientation", getVideoOrientation(this.mOrientation));
            bundle3.putBoolean(com.oplus.ocs.camera.CameraParameter.VideoEffectParamKeys.RETENTION_PROCESS, yVarJ2.y_renamed());
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>>) com.oplus.ocs.camera.CameraParameter.VIDEO_EFFECT_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>) bundle3);
        }
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_RETENTION_OPEN, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        com.oplus.camera.e_renamed.c_renamed(TAG, "setConfigureParameter");
        if (isSloganOpen()) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.WATERMARK_VIDEO_ENABLE, "on_renamed");
        }
        if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264.equals(getVideoCodec())) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_ENCODER, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264);
            if (this.mProfile != null) {
                builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_BITRATE, java.lang.Integer.valueOf(this.mProfile.videoBitRate));
            }
        } else if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(getVideoCodec())) {
            builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_ENCODER, com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265);
            if (this.mProfile != null) {
                builder.setParameter(com.oplus.ocs.camera.CameraParameter.VIDEO_BITRATE, java.lang.Integer.valueOf(this.mProfile.videoBitRate / 2));
            }
        }
        if (needSurface("type_video")) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "setConfigureParameter, mVideoSurfaceState: " + this.mVideoSurfaceState);
            synchronized (this.mPrepareVideoSurface) {
                if (!isVideoSurfacePrepared()) {
                    if (!this.mRecordHandler.hasMessages(6) && !isVideoSurfacePreparing()) {
                        com.oplus.camera.e_renamed.a_renamed(TAG, "configSessionSurface, send MSG_PREPARE_VIDEO_SURFACE");
                        this.mRecordHandler.sendEmptyMessage(6);
                    }
                    this.mPrepareVideoSurface.close();
                    this.mPrepareVideoSurface.block();
                }
            }
            setVideoSurfaceState(0);
            synchronized (this.mVideoSurfaceLock) {
                if (this.mVideoSurface != null && this.mProfile != null) {
                    builder.setVideoConfig(new com.oplus.ocs.camera.CameraDeviceConfig.VideoConfig(com.oplus.camera.e_renamed.a_renamed.b_renamed(this.mOneCamera.c_renamed()), new android.util.Size(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight), this.mVideoSurface));
                }
            }
        }
    }

    private void resumeAudioPlayback() {
        android.media.AudioManager audioManager = (android.media.AudioManager) this.mActivity.getApplicationContext().getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO);
        if (!this.mbBroadcastPauseMusic) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "resumeAudioPlayback, Not send broadcast to restore the background music: " + audioManager.abandonAudioFocus(null));
            return;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "resumeAudioPlayback, send broadcast to restore the background music: 0");
        android.content.Intent intent = new android.content.Intent("com.heytap.music.musicservicecommand.resume");
        intent.putExtra("command", "VideoReqMusicRestore");
        this.mActivity.sendBroadcast(intent);
    }

    private void pauseAudioPlayback() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "pauseAudioPlayback");
        int iRequestAudioFocus = ((android.media.AudioManager) this.mActivity.getApplicationContext().getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO)).requestAudioFocus(null, 3, 2);
        if (iRequestAudioFocus == 1) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "pauseAudioPlayback, Not send broadcast to pause the background music: " + iRequestAudioFocus);
            this.mbBroadcastPauseMusic = false;
        }
        if (iRequestAudioFocus == 0) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "pauseAudioPlayback, send broadcast to pause the background music: " + iRequestAudioFocus);
            this.mbBroadcastPauseMusic = true;
            android.content.Intent intent = new android.content.Intent("com.heytap.music.musicservicecommand.pause");
            intent.putExtra("command", "VideoReqMusicPause");
            this.mActivity.sendBroadcast(intent);
        }
    }

    private boolean recDisabledReturn() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "recDisabledReturn");
        if (!this.mbLowBatteryDisabled) {
            return false;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_low_battery_rec_disabled, -1, true, false, false);
        reportReminderToDcs(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_BATTERY_VIDEO);
        return true;
    }

    private java.lang.String createName(long j_renamed) {
        return new java.text.SimpleDateFormat(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_file_name_format), java.util.Locale.US).format(new java.util.Date(j_renamed));
    }

    private void generateVideoFilename(int i_renamed) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strCreateName = createName(jCurrentTimeMillis);
        java.lang.String str = strCreateName + convertOutputFormatToFileExt(i_renamed);
        java.lang.String strConvertOutputFormatToMimeType = convertOutputFormatToMimeType(i_renamed);
        this.mVideoSavePath = getVideoSavePath();
        java.lang.String str2 = this.mVideoSavePath + str;
        com.oplus.camera.e_renamed.a_renamed(TAG, "generateVideoFilename, path: " + str2 + ", mime: " + strConvertOutputFormatToMimeType);
        this.mFileName = str;
        this.mVideoFilename = str2;
        this.mCurrentVideoValues = new android.content.ContentValues(7);
        this.mCurrentVideoValues.put("title", strCreateName);
        this.mCurrentVideoValues.put("_display_name", str);
        this.mCurrentVideoValues.put("datetaken", java.lang.Long.valueOf(jCurrentTimeMillis));
        this.mCurrentVideoValues.put("mime_type", strConvertOutputFormatToMimeType);
        this.mCurrentVideoValues.put("relative_path", com.oplus.camera.Storage.e_renamed(null));
        this.mCurrentVideoValues.put("is_pending", (java.lang.Integer) 1);
        if (isNeedGenerateUri()) {
            this.mCurrentVideoUri = com.oplus.camera.util.storage.a_renamed.a_renamed(this.mActivity, this.mActivity.getContentResolver(), this.mCurrentVideoValues);
            try {
                this.mVideoFileDescriptor = this.mActivity.getContentResolver().openFileDescriptor(this.mCurrentVideoUri, "rw");
            } catch (java.io.FileNotFoundException e_renamed) {
                e_renamed.printStackTrace();
            } catch (java.lang.SecurityException e2) {
                e2.printStackTrace();
            }
        }
        this.mVideoOrientation = this.mCameraInterface.u_renamed();
        this.mVideoAeAfLock = this.mCameraInterface.ae_renamed();
        android.media.CamcorderProfile profile = getProfile();
        this.mCurrentVideoValues.put("resolution", java.lang.Integer.toString(profile.videoFrameWidth) + "x_renamed" + java.lang.Integer.toString(profile.videoFrameHeight));
        this.mCurrentVideoValues.put("width", java.lang.Integer.toString(profile.videoFrameWidth));
        this.mCurrentVideoValues.put("height", java.lang.Integer.toString(profile.videoFrameHeight));
        android.location.Location locationY = this.mCameraInterface.y_renamed();
        if (locationY != null) {
            this.mCurrentVideoValues.put("latitude", java.lang.Double.valueOf(locationY.getLatitude()));
            this.mCurrentVideoValues.put("longitude", java.lang.Double.valueOf(locationY.getLongitude()));
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "generateVideoFilename, New video filename: " + this.mVideoFilename);
    }

    protected java.lang.String getVideoSavePath() {
        if (com.oplus.camera.Storage.u_renamed.equals("off")) {
            return com.oplus.camera.Storage.q_renamed + '/';
        }
        return com.oplus.camera.Storage.l_renamed + '/';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupEmptyFile(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "cleanupEmptyFile");
        if (str != null) {
            java.io.File file = new java.io.File(str);
            if (file.length() == 0 && file.delete()) {
                com.oplus.camera.e_renamed.a_renamed(TAG, "cleanupEmptyFile, Empty video file deleted: " + str);
            }
        }
    }

    protected boolean getNeedReduceBitRate() {
        return !(120 == getVideoFps() || "video_size_1080p".equals(this.mVideoSizeType) || ("video_size_720p".equals(this.mVideoSizeType) && !com.oplus.camera.util.Util.C_renamed())) || com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(getVideoCodec());
    }

    public boolean initVideoFileDescriptor() throws java.io.IOException {
        this.mRecordFileNameChange.block();
        android.os.Bundle extras = this.mActivity.getIntent().getExtras();
        closeVideoFileDescriptor();
        if (this.mCameraInterface.m_renamed() && extras != null) {
            android.net.Uri uri = (android.net.Uri) extras.getParcelable("output");
            com.oplus.camera.e_renamed.c_renamed(TAG, "initializeRecorder, saveUri: " + uri);
            if (uri != null) {
                try {
                    this.mVideoFileDescriptor = this.mActivity.getContentResolver().openFileDescriptor(uri, "rw");
                    this.mCurrentVideoUri = uri;
                } catch (java.io.FileNotFoundException e_renamed) {
                    com.oplus.camera.e_renamed.f_renamed(TAG, e_renamed.toString());
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
        com.oplus.camera.e_renamed.f_renamed(TAG, "initializeRecorder, mVideoFilename is_renamed null");
        return false;
    }

    private void initializeRecorder() throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.camera.e_renamed.c_renamed(TAG, "initializeRecorder");
        android.os.Bundle extras = this.mActivity.getIntent().getExtras();
        long j_renamed = "on_renamed".equals(com.oplus.camera.Storage.u_renamed) ? 4294967296L : 0L;
        if (this.mCameraInterface.m_renamed() && extras != null) {
            j_renamed = extras.getLong("android.intent.extra.sizeLimit");
        }
        if (extras != null && this.mCameraInterface.m_renamed()) {
            j_renamed = extras.getLong("android.intent.extra.sizeLimit");
        }
        this.mVideoRecorder = new com.oplus.camera.capmode.x_renamed(isUseMediaCodec(), this.mCameraInterface.al_renamed());
        this.mVideoRecorder.h_renamed(isNeedAudioEncode());
        synchronized (this.mVideoSurfaceLock) {
            if (this.mVideoSurface != null) {
                this.mVideoRecorder.a_renamed(this.mVideoSurface);
            }
        }
        this.mVideoRecorder.a_renamed(this.mCameraUIInterface.a_renamed());
        android.media.CamcorderProfile profile = getProfile();
        if (this.mbRecordAudio && com.oplus.camera.util.Util.as_renamed()) {
            this.mVideoRecorder.a_renamed(5);
            profile.audioCodec = 3;
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_ELEVATE_AUDIO_BIT_RATE)) {
                profile.audioBitRate = AUDIO_BITRATE_ENHANCE;
            }
        } else {
            profile.audioCodec = -1;
        }
        this.mVideoRecorder.f_renamed(2);
        setBinauralRecordState(this.mbBinauralRecordEnable);
        java.lang.String videoTitle = getVideoTitle();
        if (this.mbBinauralRecordEnable) {
            videoTitle = videoTitle != null ? videoTitle.concat("binaural") : "binaural";
        }
        if (videoTitle != null) {
            this.mVideoRecorder.c_renamed(getVideoFileExifTag().concat(videoTitle));
        }
        checkVideoCodecAndReset();
        java.lang.String videoCodec = getVideoCodec();
        if (isVideo10BitOpen()) {
            profile.videoCodec = 5;
            this.mVideoRecorder.b_renamed(2, 16384);
        } else if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(videoCodec)) {
            profile.videoCodec = 5;
        } else if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264.equals(videoCodec)) {
            profile.videoCodec = 2;
            this.mVideoRecorder.b_renamed(8, 2048);
        }
        if (com.oplus.camera.util.Util.C_renamed()) {
            if ((isMirrorEnable() || this.mCameraUIInterface.e_renamed()) && android.text.TextUtils.equals(getMirror(), "off")) {
                int iU = this.mCameraInterface.u_renamed();
                if (iU == 0 || iU == 180) {
                    this.mVideoRecorder.n_renamed(2);
                } else {
                    this.mVideoRecorder.n_renamed(1);
                }
            }
            profile.videoFrameRate = getVideoFrameRate();
            com.oplus.camera.e_renamed.b_renamed(TAG, "initializeRecorder, videoCodec: " + profile.videoCodec + ", videoBitRate: " + profile.videoBitRate + ", getNeedReduceBitRate(): " + getNeedReduceBitRate());
            this.mVideoRecorder.a_renamed(java.lang.String.valueOf(this.mCameraId), profile);
            if (this.mCameraInterface.m_renamed()) {
                this.mVideoRecorder.g_renamed(profile.videoBitRate);
            } else {
                this.mVideoRecorder.g_renamed(getNeedReduceBitRate() ? profile.videoBitRate / 2 : profile.videoBitRate);
            }
        } else {
            android.media.CamcorderProfile camcorderProfile = this.mProfile;
            camcorderProfile.fileFormat = 2;
            this.mVideoRecorder.h_renamed(camcorderProfile.fileFormat);
            this.mProfile.videoFrameRate = getVideoFrameRate();
            this.mVideoRecorder.i_renamed(this.mProfile.videoFrameRate);
            this.mVideoRecorder.a_renamed(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight);
            this.mVideoRecorder.j_renamed(this.mProfile.videoCodec);
            if (this.mCameraInterface.m_renamed()) {
                this.mVideoRecorder.g_renamed(profile.videoBitRate / 4);
            } else {
                this.mVideoRecorder.g_renamed(getNeedReduceBitRate() ? profile.videoBitRate / 2 : profile.videoBitRate);
            }
            if (this.mbRecordAudio) {
                if (this.mVideoSizeType.equals("video_size_cif") || this.mVideoSizeType.equals("video_size_qcif")) {
                    this.mVideoRecorder.b_renamed(this.mProfile.audioBitRate / 8);
                    this.mVideoRecorder.c_renamed(this.mProfile.audioChannels);
                    this.mVideoRecorder.d_renamed(this.mProfile.audioSampleRate / 8);
                    this.mVideoRecorder.e_renamed(this.mProfile.audioCodec);
                } else {
                    this.mVideoRecorder.b_renamed(this.mProfile.audioBitRate);
                    this.mVideoRecorder.c_renamed(this.mProfile.audioChannels);
                    this.mVideoRecorder.d_renamed(this.mProfile.audioSampleRate);
                    this.mVideoRecorder.e_renamed(this.mProfile.audioCodec);
                }
            }
        }
        updateSurroundRecord();
        this.mVideoRecorder.m_renamed(this.mCameraInterface.u_renamed());
        android.location.Location locationY = this.mCameraInterface.y_renamed();
        if (locationY != null) {
            this.mVideoRecorder.a_renamed((float) locationY.getLatitude(), (float) locationY.getLongitude());
        }
        java.lang.Double timeLapseSpeed = getTimeLapseSpeed();
        int iIntValue = timeLapseSpeed != null ? timeLapseSpeed.intValue() : -1;
        com.oplus.camera.capmode.x_renamed xVar = this.mVideoRecorder;
        if (!isVideoTimeLapseTiltShiftOpen()) {
            iIntValue = -1;
        }
        xVar.k_renamed(iIntValue);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_DURATION_LIMIT)) {
            this.mVideoRecorder.l_renamed(15000);
        } else {
            int recordingMaxDuration = getRecordingMaxDuration(this.mVideoSizeType, java.lang.String.valueOf(profile.videoFrameRate));
            if (recordingMaxDuration > 0) {
                int i_renamed = recordingMaxDuration * 1000;
                int i2 = this.mMaxVideoDurationInMs;
                if (i2 > 0 && i_renamed > i2) {
                    i_renamed = i2;
                }
                this.mVideoRecorder.l_renamed(i_renamed);
                com.oplus.camera.e_renamed.a_renamed(TAG, "initializeRecorder, videoRecorder setMaxDuration: " + i_renamed);
            } else {
                this.mVideoRecorder.l_renamed(this.mMaxVideoDurationInMs);
            }
        }
        java.lang.String str = profile.videoFrameWidth + "x_renamed" + profile.videoFrameHeight;
        this.mCameraUIInterface.b_renamed(profile.videoFrameWidth, profile.videoFrameHeight);
        com.oplus.camera.e_renamed.a_renamed(TAG, "initializeRecorder, profile.videoFrameRate: " + profile.videoFrameRate + ", profile.duration: " + profile.duration + ", videoSize: " + str + ", profile.videoBitRate: " + profile.videoBitRate);
        int iU2 = (this.mCameraInterface.u_renamed() + getOrientationRectify()) % 360;
        if (!isUseMediaCodec()) {
            iU2 = getJpegOrientation(this.mCameraId, iU2);
        }
        this.mVideoRecorder.o_renamed(iU2);
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.mVideoFileDescriptor;
        if (parcelFileDescriptor != null) {
            this.mVideoRecorder.a_renamed(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.mVideoRecorder.b_renamed(this.mVideoFilename);
        }
        if (getRealCaptureRate() != null && getRealCaptureRate().doubleValue() > 0.0d) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "initializeRecorder, setCaptureRate: " + getRealCaptureRate());
            this.mVideoRecorder.a_renamed(getRealCaptureRate().doubleValue());
        }
        long jC = com.oplus.camera.Storage.c_renamed(com.oplus.camera.Storage.u_renamed);
        if (j_renamed > 0 && j_renamed < jC) {
            jC = j_renamed;
        }
        try {
            this.mVideoRecorder.a_renamed(jC);
        } catch (java.lang.RuntimeException unused) {
        }
        this.mVideoRecorder.a_renamed((com.oplus.camera.capmode.x_renamed.f_renamed) this);
        this.mVideoRecorder.a_renamed((com.oplus.camera.capmode.x_renamed.h_renamed) this);
        this.mVideoRecorder.a_renamed((com.oplus.camera.capmode.x_renamed.g_renamed) this);
        onInitializeRecorder(this.mVideoRecorder);
        com.oplus.camera.e_renamed.a_renamed(TAG, "initializeRecorder end, maxFileSize: " + jC + ", requestedSizeLimit: " + j_renamed);
    }

    private void updateSurroundRecord() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        boolean zH = com.oplus.camera.util.Util.h_renamed("oplus.software.video.surround_record_support");
        java.lang.String str = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA;
        java.lang.String str2 = com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT;
        if (zH && com.oplus.camera.util.Util.E_renamed()) {
            if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO.equals(getCameraMode()) || "movie".equals(getCameraMode()) || com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO.equals(getCameraMode()) || "video_size_8k".equals(getVideoSizeType())) {
                this.mSoundType = "normal";
            } else {
                android.content.SharedPreferences sharedPreferences = this.mPreferences;
                if (!this.mbFrontCamera) {
                    str2 = com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR;
                }
                boolean zEquals = "all_around".equals(sharedPreferences.getString(str2, "all_around"));
                boolean z_renamed = java.lang.Float.compare(getZoomValue(), 1.0f) != 0;
                this.mNoiseFilter = zEquals ? "on_renamed" : "off";
                if (zEquals) {
                    if (z_renamed) {
                        str = "focusing";
                    }
                    this.mSoundType = str;
                } else {
                    this.mSoundType = "normal";
                }
            }
            this.mVideoRecorder.a_renamed(this.mNoiseFilter, this.mSoundType, this.mCameraId, this.mCameraInterface.u_renamed());
            int zoomValue = (int) ((getZoomValue() - 1.0f) * 10.0f);
            if (zoomValue <= 0) {
                zoomValue = 1;
            }
            com.oplus.camera.e_renamed.c_renamed(TAG, "initSoundType, soundType: " + this.mSoundType + ", modeType: " + getCameraMode() + ", mNoiseFilter: " + this.mNoiseFilter + ", soundValue: " + zoomValue);
            this.mVideoRecorder.a_renamed(zoomValue, getZoomValue());
            return;
        }
        if (com.oplus.camera.util.Util.h_renamed("oplus.software.video.surround_record_support") && com.oplus.camera.util.Util.F_renamed()) {
            if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO.equals(getCameraMode()) || "movie".equals(getCameraMode()) || com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO.equals(getCameraMode())) {
                this.mSoundType = "normal";
            } else {
                android.content.SharedPreferences sharedPreferences2 = this.mPreferences;
                if (!this.mbFrontCamera) {
                    str2 = com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR;
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
            com.oplus.camera.e_renamed.c_renamed(TAG, "initAudioType, audioType: " + this.mSoundType + ", modeType: " + getCameraMode());
            this.mVideoRecorder.a_renamed(this.mSoundType, getZoomValue(), this.mOrientation);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        com.oplus.camera.capmode.x_renamed xVar = this.mVideoRecorder;
        if (xVar != null) {
            xVar.a_renamed(getZoomValue());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        super.setOrientation(i_renamed);
        com.oplus.camera.capmode.x_renamed xVar = this.mVideoRecorder;
        if (xVar != null) {
            xVar.m_renamed(i_renamed);
        }
    }

    protected java.lang.String getVideoFileExifTag() {
        return com.oplus.camera.g_renamed.b_renamed.b_renamed(getCameraMode(), this.mCameraId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecordingTime() throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (!isVideoRecordStarted()) {
            resetTimeUi();
            return;
        }
        long jUptimeMillis = (android.os.SystemClock.uptimeMillis() - this.mRecordingStartTime) - this.mTotalPausingTime;
        this.mRecordingTotalTime = jUptimeMillis;
        if (shouldAutoStop(jUptimeMillis)) {
            aj_renamed();
            return;
        }
        this.mCameraUIInterface.a_renamed(this.mRecordingTotalTime, getVideoTime(), this.mbShowRecordingIndicator, getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_VIDEO_COUNT_DOWN), getVideoTimeLimit());
        if (this.mCount == 0) {
            this.mCameraInterface.a_renamed(this.mRecordingTotalTime);
        }
        this.mCount++;
        this.mCount %= 6;
        if (this.mCount == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("updateRecordingTime, mbShowRecordingIndicator: ");
            sb.append(this.mbShowRecordingIndicator);
            sb.append("->");
            sb.append(!this.mbShowRecordingIndicator);
            com.oplus.camera.e_renamed.a_renamed(TAG, sb.toString());
            this.mbShowRecordingIndicator = !this.mbShowRecordingIndicator;
        }
        this.mHandler.sendEmptyMessageDelayed(1, 81L);
    }

    public void resetTimeUi() {
        boolean supportFunction = getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_VIDEO_COUNT_DOWN);
        long videoTimeLimit = getVideoTimeLimit();
        if (!supportFunction || videoTimeLimit - this.mRecordingTotalTime >= 300) {
            return;
        }
        this.mRecordingTotalTime = videoTimeLimit;
        this.mCameraUIInterface.a_renamed(videoTimeLimit, getVideoTime(), this.mbShowRecordingIndicator, true, videoTimeLimit);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onBinauralRecordStateChanged(boolean z_renamed) {
        if (this.mbBinauralRecordEnable != z_renamed) {
            this.mbBinauralRecordEnable = z_renamed;
            com.oplus.camera.e_renamed.a_renamed(TAG, "onBinauralRecordStateChanged, enable: " + z_renamed);
            if (isVideoRecording()) {
                setBinauralRecordState(this.mbBinauralRecordEnable);
            }
        }
    }

    private void setBinauralRecordState(boolean z_renamed) {
        com.oplus.camera.capmode.x_renamed xVar;
        com.oplus.camera.e_renamed.a_renamed(TAG, "setBinauralRecordState, enable: " + z_renamed);
        if (!supportBinauralRecord() || (xVar = this.mVideoRecorder) == null) {
            return;
        }
        xVar.d_renamed(z_renamed);
        if (z_renamed) {
            this.mVideoRecorder.e_renamed(this.mbFrontCamera);
            if (this.mbFrontCamera) {
                this.mVideoRecorder.f_renamed("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_mirror_default_value))));
            }
            if (this.mCameraUIInterface != null) {
                this.mCameraUIInterface.v_renamed();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x0041  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getVideoSizeType() {
        /*
            r4 = this;
            com.oplus.camera.capmode.a_renamed r0 = r4.mCameraInterface
            java.lang.String r1 = "VideoMode"
            if (r0 == 0) goto L5e
            android.app.Activity r0 = r4.mActivity
            if (r0 == 0) goto L5e
            com.oplus.camera.capmode.a_renamed r0 = r4.mCameraInterface
            boolean r0 = r0.m_renamed()
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
            com.oplus.camera.e_renamed.e_renamed(r1, r4)
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
            java.lang.String r0 = "getVideoSizeType, mPreferences is_renamed null!"
            com.oplus.camera.e_renamed.e_renamed(r1, r0)
            java.lang.String r4 = r4.getDefaultVideoSize()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.w_renamed.getVideoSizeType():java.lang.String");
    }

    private void sendBoradCastToStopRecordSound() {
        this.mActivity.sendBroadcast(new android.content.Intent("oplus.multimedia.soundrecorder.stopRecroderNormal"));
    }

    private void sendBoradCastToStopVideo() {
        this.mActivity.sendBroadcast(new android.content.Intent("oplus.camera.record.start"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenBrightness(int i_renamed, float f_renamed) {
        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.mActivity.hashCode())) {
            return;
        }
        float f2 = i_renamed;
        if (f_renamed > f2) {
            try {
                this.mBrightnessAnimationListener.a_renamed(f_renamed, f_renamed - f2, f2);
                this.mBrightnessAnimator.start();
            } catch (java.lang.NoSuchMethodError unused) {
                com.oplus.camera.e_renamed.f_renamed(TAG, "setScreenBrightness, no such method error.");
                return;
            }
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "setScreenBrightness, brightness: " + i_renamed + ", currBrightness: " + f_renamed);
    }

    private java.lang.String getDefaultVideoQuality(int i_renamed, java.lang.String str) {
        return android.media.CamcorderProfile.hasProfile(i_renamed, java.lang.Integer.valueOf(str).intValue()) ? str : java.lang.Integer.toString(1);
    }

    protected void enableVideoRecordingSound(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed(TAG, "enableVideoRecordingSound, enable: " + z_renamed);
        this.mbRecordAudio = z_renamed;
    }

    private int matchRecModeToVideoQuality(java.lang.String str) {
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
            iIntValue = "video_size_qcif".equals(this.mVideoSizeType) ? 2 : java.lang.Integer.valueOf(str).intValue();
        }
        if (isMultiVideoMode()) {
            iIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_1080P_SUPPORT) ? 6 : 5;
        }
        if (isFastVideoMode() && "video_size_4kuhd".equals(this.mVideoSizeType) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FAST_VIDEO_RESOLUTION_SWITCH)) {
            iIntValue = com.heytap.accessory.CommonStatusCodes.CAPABILITY_EXCEPTION;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "matchRecModeToVideoQuality, mVideoSizeType: " + this.mVideoSizeType + ", videoQuality: " + iIntValue);
        return iIntValue;
    }

    /* compiled from: VideoMode.java */
    private final class c_renamed extends android.os.Handler {
        private c_renamed() {
            super(android.os.Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            int configIntValue;
            switch (message.what) {
                case 1:
                    com.oplus.camera.capmode.w_renamed.this.updateRecordingTime();
                    break;
                case 2:
                    com.oplus.camera.capmode.w_renamed wVar = com.oplus.camera.capmode.w_renamed.this;
                    wVar.mCheckStorageTask = new com.oplus.camera.capmode.w_renamed.b_renamed().execute(new java.lang.Void[0]);
                    break;
                case 3:
                    com.oplus.camera.capmode.w_renamed.this.mCameraUIInterface.b_renamed(true, false);
                    break;
                case 4:
                    com.oplus.camera.capmode.w_renamed.this.mCameraUIInterface.a_renamed(true, false);
                    break;
                case 5:
                    com.oplus.camera.capmode.w_renamed.this.handleStartError(false, message.obj != null ? ((java.lang.Boolean) message.obj).booleanValue() : true);
                    break;
                case 6:
                    com.oplus.camera.capmode.w_renamed.this.setScreenBrightness(1 == com.oplus.camera.util.Util.a_renamed("persist.sys.oplus.display.brightness.mode", 0) ? com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS) : 130, android.provider.Settings.System.getInt(com.oplus.camera.capmode.w_renamed.this.mActivity.getContentResolver(), com.oplus.camera.statistics.CameraStatisticsUtil.SCREEN_BRIGHTNESS, r5));
                    break;
                case 7:
                    com.oplus.camera.capmode.w_renamed.this.startVideoRecordHandler();
                    break;
                case 9:
                    if (!com.oplus.camera.capmode.w_renamed.this.isVideoRecordStopped()) {
                        com.oplus.camera.capmode.w_renamed.this.mRecordHandler.sendEmptyMessageDelayed(9, 1000L);
                        break;
                    } else {
                        com.oplus.camera.MyApplication.c_renamed();
                        break;
                    }
                case 10:
                    if (com.oplus.camera.capmode.w_renamed.this.isVideoRecordStarted()) {
                        com.oplus.camera.capmode.w_renamed.this.aj_renamed();
                        break;
                    } else {
                        sendEmptyMessageDelayed(10, 1000L);
                        break;
                    }
                case 11:
                    com.oplus.camera.util.o_renamed.a_renamed(com.oplus.camera.capmode.w_renamed.this.mActivity, com.oplus.camera.R_renamed.string.super_eis_on_keep_on_toast);
                    break;
                case 12:
                    com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.capmode.w_renamed.TAG, "handleMessage, timeout with MotionDetected: " + com.oplus.camera.capmode.w_renamed.this.isMotionDetected());
                    if (com.oplus.camera.capmode.w_renamed.this.isVideoRecordStarted() && !com.oplus.camera.capmode.w_renamed.this.isMotionDetected()) {
                        com.oplus.camera.capmode.w_renamed.this.aj_renamed();
                        break;
                    }
                    break;
                case 13:
                    if (1 == com.oplus.camera.util.Util.a_renamed("persist.sys.oplus.display.brightness.mode", 0)) {
                        configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS);
                        configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CAMERA_VIDEO_BRIGHTNESS_SECOND);
                    } else {
                        configIntValue = 130;
                    }
                    if (android.provider.Settings.System.getInt(com.oplus.camera.capmode.w_renamed.this.mActivity.getContentResolver(), com.oplus.camera.statistics.CameraStatisticsUtil.SCREEN_BRIGHTNESS, configIntValue) > 179.0f) {
                        com.oplus.camera.capmode.w_renamed.this.setScreenBrightness(configIntValue, configIntValue);
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
    private class b_renamed extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Boolean> {
        private b_renamed() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean doInBackground(java.lang.Void... voidArr) {
            int iB = com.oplus.camera.Storage.b_renamed(com.oplus.camera.Storage.u_renamed);
            if (iB != 0) {
                if (iB == 3 && com.oplus.camera.capmode.w_renamed.this.mCameraInterface != null) {
                    com.oplus.camera.capmode.w_renamed.this.mCameraInterface.Q_renamed();
                }
                return true;
            }
            if (com.oplus.camera.capmode.w_renamed.this.isVideoRecordStopped() && "on_renamed".equals(com.oplus.camera.Storage.u_renamed) && !com.oplus.camera.Storage.b_renamed(true)) {
                com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.w_renamed.TAG, "doInBackground, external storage is_renamed removed, wait unmounted broadcast to finish activity");
                return false;
            }
            if (com.oplus.camera.capmode.w_renamed.this.mHandler != null) {
                com.oplus.camera.capmode.w_renamed.this.mHandler.removeMessages(2);
                com.oplus.camera.capmode.w_renamed.this.mHandler.sendEmptyMessageDelayed(2, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(java.lang.Boolean bool) {
            if (bool.booleanValue()) {
                com.oplus.camera.capmode.w_renamed.this.onStopVideoRecording(true);
            }
        }
    }

    /* compiled from: VideoMode.java */
    public class a_renamed implements android.animation.ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private float f4339b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private float f4340c;
        private float d_renamed;
        private android.view.Window e_renamed;
        private android.view.WindowManager.LayoutParams f_renamed;

        public a_renamed(android.app.Activity activity) {
            this.e_renamed = activity.getWindow();
            this.f_renamed = this.e_renamed.getAttributes();
        }

        public void a_renamed(float f_renamed, float f2, float f3) {
            com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.w_renamed.TAG, "setTargetBrightness, targetBrightness: " + f3 + ", deltaBrightness: " + f2 + ", MaxScreenBrightness: " + com.oplus.camera.capmode.w_renamed.this.mCameraInterface.V_renamed());
            this.f4339b = f3;
            this.f4340c = f2;
            this.d_renamed = f_renamed;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            if (com.oplus.camera.capmode.w_renamed.this.mCameraInterface != null) {
                float fFloatValue = (this.f4340c * ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue()) + this.f4339b;
                float f_renamed = this.f4340c;
                if (this.d_renamed - fFloatValue >= (f_renamed >= 20.0f ? f_renamed / 20.0f : 1.0f)) {
                    this.f_renamed.screenBrightness = fFloatValue / com.oplus.camera.capmode.w_renamed.this.mCameraInterface.V_renamed();
                    this.e_renamed.setAttributes(this.f_renamed);
                    this.d_renamed = fFloatValue;
                    com.oplus.camera.capmode.w_renamed.this.mBrightness = this.d_renamed;
                }
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
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
    public void beforeSwitchToMode(boolean z_renamed) {
        super.beforeSwitchToMode(z_renamed);
        if (z_renamed) {
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
            if (5 == this.mCameraInterface.g_renamed()) {
                this.mPrepareVideoSurface.close();
                this.mPrepareVideoSurface.block();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean prepareVideoSurface() throws java.lang.IllegalStateException, java.io.IOException {
        if (needSurface("type_video") && this.mPreferences != null) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "prepareVideoSurface");
            setVideoSurfaceState(1);
            beforeConfig();
            readProfile();
            com.oplus.camera.e_renamed.a_renamed("prepareVideoSurface");
            com.oplus.camera.capmode.x_renamed xVar = new com.oplus.camera.capmode.x_renamed(false, this.mCameraInterface.al_renamed());
            synchronized (this.mVideoSurfaceLock) {
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_SURFACE_RELEASE)) {
                    if (this.mVideoSurface != null) {
                        this.mVideoSurface.release();
                    }
                    this.mVideoSurface = android.media.MediaCodec.createPersistentInputSurface();
                } else if (this.mVideoSurface == null) {
                    this.mVideoSurface = android.media.MediaCodec.createPersistentInputSurface();
                }
                xVar.a_renamed(this.mVideoSurface);
            }
            xVar.f_renamed(2);
            xVar.h_renamed(2);
            xVar.o_renamed(this.mOrientation);
            java.lang.String videoCodec = getVideoCodec();
            xVar.i_renamed(30);
            xVar.a_renamed(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight);
            if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264.equals(videoCodec)) {
                xVar.j_renamed(2);
                xVar.b_renamed(8, 2048);
                xVar.g_renamed(this.mProfile.videoBitRate);
            } else if (com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(videoCodec)) {
                xVar.j_renamed(5);
                xVar.g_renamed(this.mProfile.videoBitRate / 2);
                if (isVideo10BitOpen()) {
                    xVar.b_renamed(2, 16384);
                }
            }
            java.io.File fileCreateTempFile = null;
            try {
                fileCreateTempFile = java.io.File.createTempFile(TAG, "TempMediaRecorder");
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
            if (fileCreateTempFile != null) {
                xVar.b_renamed(fileCreateTempFile.getAbsolutePath());
            } else {
                com.oplus.camera.e_renamed.f_renamed(TAG, "prepareVideoSurface, setOutputFile failed, tempFile: " + fileCreateTempFile);
            }
            java.lang.Double realCaptureRate = getRealCaptureRate();
            com.oplus.camera.e_renamed.a_renamed(TAG, "prepareVideoSurface, captureRate: " + realCaptureRate);
            if (realCaptureRate != null && realCaptureRate.doubleValue() > 0.0d) {
                xVar.a_renamed(realCaptureRate.doubleValue());
            }
            try {
                xVar.e_renamed();
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
            xVar.d_renamed();
            if (this.mbMediaLimitProcess) {
                com.oplus.camera.ui.control.e_renamed.d_renamed();
                this.mbMediaLimitProcess = false;
            }
            if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                com.oplus.camera.q_renamed.a_renamed.c_renamed(fileCreateTempFile.getAbsolutePath());
            }
            setVideoSurfaceState(2);
            this.mPrepareVideoSurface.open();
            com.oplus.camera.e_renamed.b_renamed("prepareVideoSurface");
            com.oplus.camera.e_renamed.b_renamed(TAG, "prepareVideoSurface, X_renamed");
        }
        return true;
    }

    protected void readProfile() {
        java.lang.String defaultVideoQuality;
        com.oplus.camera.e_renamed.a_renamed(TAG, "readProfile");
        com.oplus.camera.e_renamed.a_renamed("readProfile");
        this.mVideoSizeType = getVideoSizeType();
        if (this.mbFrontCamera) {
            defaultVideoQuality = getDefaultVideoQuality(this.mCameraId, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_quality_front_default_value));
        } else {
            defaultVideoQuality = getDefaultVideoQuality(this.mCameraId, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_quality_default_value));
        }
        int iMatchRecModeToVideoQuality = matchRecModeToVideoQuality(defaultVideoQuality);
        android.content.Intent intent = this.mActivity.getIntent();
        android.os.Bundle extras = intent.getExtras();
        if (intent.hasExtra("android.intent.extra.videoQuality")) {
            if (extras != null) {
                iMatchRecModeToVideoQuality = extras.getInt("android.intent.extra.videoQuality", 4);
            }
            if (iMatchRecModeToVideoQuality == 1 && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUALITY_HIGH_1080P_SUPPORT)) {
                iMatchRecModeToVideoQuality = 6;
            } else if (iMatchRecModeToVideoQuality == 1) {
                iMatchRecModeToVideoQuality = 5;
            }
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "readProfile, quality: " + iMatchRecModeToVideoQuality);
        if (intent.hasExtra("android.intent.extra.durationLimit")) {
            int intExtra = intent.getIntExtra("android.intent.extra.durationLimit", -1);
            if (intExtra >= 0) {
                this.mMaxVideoDurationInMs = intExtra * 1000;
            }
            com.oplus.camera.e_renamed.a_renamed(TAG, "readProfile, mMaxVideoDurationInMs: " + this.mMaxVideoDurationInMs);
        }
        try {
            this.mProfile = android.media.CamcorderProfile.get(this.mCameraId, iMatchRecModeToVideoQuality);
        } catch (java.lang.Exception e_renamed) {
            this.mProfile = null;
            com.oplus.camera.e_renamed.a_renamed(TAG, "readProfile, CamcorderProfile.get fail! ", e_renamed);
        }
        if (this.mProfile == null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "readProfile, mProfile is_renamed null, so return...");
            return;
        }
        if (!isMultiVideoMode()) {
            if ("video_size_4kuhd".equals(this.mVideoSizeType)) {
                android.media.CamcorderProfile camcorderProfile = this.mProfile;
                camcorderProfile.videoBitRate = VIDEO_4K_BIT_RATE;
                camcorderProfile.videoFrameWidth = VIDEO_4K_FRAME_WIDTH;
                camcorderProfile.videoFrameHeight = VIDEO_4K_FRAME_HEIGHT;
                camcorderProfile.audioSampleRate = VIDEO_4K_AUDIO_SAMPLE_RATE;
                camcorderProfile.audioBitRate = VIDEO_4K_AUDIO_BIT_RATE;
                camcorderProfile.audioChannels = 2;
            } else if ("video_size_8k".equals(this.mVideoSizeType)) {
                android.media.CamcorderProfile camcorderProfile2 = this.mProfile;
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
        com.oplus.camera.e_renamed.b_renamed("readProfile");
        com.oplus.camera.e_renamed.a_renamed(TAG, "readProfile, videoFrameWidth: " + this.mProfile.videoFrameWidth + ", videoFrameHeight: " + this.mProfile.videoFrameHeight + ", videoFrameRate: " + this.mProfile.videoFrameRate + ", mProfile.videoBitRate: " + this.mProfile.videoBitRate);
    }

    public android.util.Size getVideoSize() {
        int i_renamed;
        int i2 = 720;
        if (this.mVideoSizeType.equals("video_size_1080p")) {
            i2 = VIDEO_1080P_WIDTH;
            i_renamed = VIDEO_1080P_HEIGHT;
        } else if (this.mVideoSizeType.equals("video_size_720p")) {
            i2 = 1280;
            i_renamed = 720;
        } else if (this.mVideoSizeType.equals("video_size_cif")) {
            i2 = VIDEO_CIF_WIDTH;
            i_renamed = 288;
        } else if (this.mVideoSizeType.equals("video_size_qcif")) {
            i2 = 176;
            i_renamed = 144;
        } else {
            i_renamed = 480;
        }
        return new android.util.Size(i2, i_renamed);
    }

    public int getResolutionBySizeType(java.lang.String str) {
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
        com.oplus.camera.e_renamed.a_renamed(TAG, "hideHintViewShowZoom");
        if (!this.mbStopVideoFail || this.mCameraInterface == null) {
            return;
        }
        this.mCameraInterface.a_renamed(true, false);
        this.mCameraInterface.d_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        if (this.mbMediaLimitProcess) {
            com.oplus.camera.ui.control.e_renamed.d_renamed();
            this.mbMediaLimitProcess = false;
        }
    }

    public void checkVideoCodecAndReset() {
        if (com.oplus.camera.util.Util.at_renamed() || !com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(getVideoCodec())) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed(TAG, "checkVideoCodecAndReset, reset video codec to default.");
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, getDefaultVideoCodec());
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        this.mCameraInterface.h_renamed();
        this.mbPictureTakenDuringRecord = true;
        this.mPictureTakenTime = this.mCaptureDate;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        this.mCameraUIInterface.d_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        this.mPreviewOkTime = java.lang.System.currentTimeMillis();
        this.mPreviewVideoCostTime = -1L;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SECNES_FORCE_ATHENA)) {
            if (is4k() || isHighFps() || isSuperEISOpen()) {
                com.oplus.camera.util.Util.C_renamed(this.mActivity);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainAndWideRange(float f_renamed) {
        float[] configFloatArrayValue;
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
            return false;
        }
        if (isVideoHighFps() && (configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2) {
            return java.lang.Float.compare(f_renamed, configFloatArrayValue[1]) <= 0;
        }
        return super.withinSatMainAndWideRange(f_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainRange(float f_renamed) {
        float[] configFloatArrayValue;
        if (!getSupportFunction(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA)) {
            return false;
        }
        if (isVideoHighFps() && (configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2) {
            return java.lang.Float.compare(f_renamed, configFloatArrayValue[0]) >= 0 && java.lang.Float.compare(f_renamed, configFloatArrayValue[1]) <= 0 && !getZoomAutoMicroOpen();
        }
        return super.withinSatMainRange(f_renamed);
    }

    private void reportVideoRecordToDcs(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        boolean z2;
        java.lang.String str;
        java.lang.String strValueOf;
        this.mPauseClickTimes = 0;
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData = new com.oplus.camera.statistics.model.VideoRecordMsgData(com.oplus.camera.util.Util.l_renamed());
        com.oplus.camera.statistics.DcsUtil.fillSecondScreenStatus(videoRecordMsgData, this.mCameraUIInterface.f_renamed(), this.mCameraUIInterface.g_renamed());
        videoRecordMsgData.mCaptureMode = getCameraMode();
        videoRecordMsgData.mCaptureType = !isCaptureModeType() ? 1 : 0;
        videoRecordMsgData.mVideoMode = getCameraMode();
        videoRecordMsgData.mVideoTime = this.mRecordingTotalTime;
        videoRecordMsgData.mVideoSizeType = getVideoSizeType();
        videoRecordMsgData.mFlashMode = getFlashMode();
        videoRecordMsgData.mAvaliableStorage = com.oplus.camera.Storage.c_renamed(com.oplus.camera.Storage.u_renamed) / 1024;
        videoRecordMsgData.mOrientation = this.mOrientation;
        videoRecordMsgData.mVideoCodec = getVideoCodec();
        videoRecordMsgData.mIsSDCard = java.lang.String.valueOf("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE, com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_storage_default_value))));
        videoRecordMsgData.mMagneticShellStatus = com.oplus.camera.util.Util.aI_renamed() ? "on_renamed" : "off";
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
            videoRecordMsgData.mIsStablized = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU)) {
            if (!"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) {
                videoRecordMsgData.mUltraSteady = com.oplus.camera.statistics.model.MenuClickMsgData.ULTRA_ON;
            } else {
                videoRecordMsgData.mUltraSteady = com.oplus.camera.statistics.model.MenuClickMsgData.ULTRA_OFF;
            }
        }
        if (this.mCameraInterface.m_renamed()) {
            videoRecordMsgData.mCameraEnterType = java.lang.String.valueOf(3);
        }
        videoRecordMsgData.mCameraId = this.mCameraInterface.ax_renamed();
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_VIDEO_RECORDER) && !this.mbFrontCamera) {
            videoRecordMsgData.mVideoRecorderSound = this.mSoundType;
            this.mSoundType = this.mPreferences.getString(this.mbFrontCamera ? com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_FRONT : com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SOUND_REAR, com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_default_sound));
            if (!"normal".equals(this.mSoundType)) {
                videoRecordMsgData.mNoiseFilter = this.mNoiseFilter;
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
            int currMakeupIndex = getCurrMakeupIndex();
            if (currMakeupIndex == 0) {
                videoRecordMsgData.mMakeupType = "off";
                videoRecordMsgData.mMakeupValue = 0;
            } else {
                videoRecordMsgData.mMakeupType = com.oplus.camera.statistics.model.DcsMsgData.sKeyMakeupList.get(currMakeupIndex);
                videoRecordMsgData.mMakeupValue = getMakeupItemValue(currMakeupIndex);
            }
        }
        if (needUploadOplusStatistics(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM)) {
            videoRecordMsgData.mZoomValue = java.lang.String.valueOf(this.mCameraInterface.ak_renamed());
        }
        if (needUploadOplusStatistics(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen()) {
            videoRecordMsgData.mIsCustomSlogan = android.text.TextUtils.isEmpty(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, "")) ? "0" : "1";
            java.util.Set<java.lang.String> stringSet = this.mPreferences.getStringSet(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, new java.util.HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                z2 = true;
            } else {
                java.lang.String[] stringArray = com.oplus.camera.util.Util.l_renamed().getResources().getStringArray(com.oplus.camera.R_renamed.array.camera_setting_watermark_display_info_values);
                boolean zContains = stringSet.contains(stringArray[0]);
                z2 = true;
                boolean zContains2 = stringSet.contains(stringArray[1]);
                boolean zContains3 = stringSet.contains(stringArray[2]);
                videoRecordMsgData.mIsModelSlogan = zContains ? "on_renamed" : "off";
                videoRecordMsgData.mIsTimeSlogan = zContains2 ? "on_renamed" : "off";
                videoRecordMsgData.mIsLocationSlogan = zContains3 ? "on_renamed" : "off";
            }
            videoRecordMsgData.mSloganLocate = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, "");
            videoRecordMsgData.mSloganSize = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, "");
        } else {
            z2 = true;
        }
        videoRecordMsgData.mMotionFastVideo = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_video_hyper_lapse_default_value));
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_HYPER_LAPSE_PROCESS) && "on_renamed".equals(videoRecordMsgData.mMotionFastVideo)) {
            if (getHyperLapseRate() != 0) {
                videoRecordMsgData.mPosterizeTime = (30 / getHyperLapseRate()) + "X_renamed";
            }
            videoRecordMsgData.mTouchXYMotionFastVideo = this.mCameraUIInterface.y_renamed();
        }
        if (!"off".equals(videoRecordMsgData.mMotionFastVideo) || getTimeLapseSpeed() == null) {
            str = "on_renamed";
        } else {
            videoRecordMsgData.mPosterizeTime = java.lang.String.valueOf(getTimeLapseSpeed());
            str = "on_renamed";
            videoRecordMsgData.mGenerateTime = getVideoTime();
        }
        videoRecordMsgData.mSmooth = getFaceBeautyCurrIndex();
        if (videoRecordMsgData.mSmooth == 102) {
            videoRecordMsgData.parseFaceBeauty(getCustomBeautyValues());
        }
        videoRecordMsgData.mIsRecordLocation = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RECORD_LOCATION, com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_location_default_value));
        videoRecordMsgData.mPreviewCaptureCostTime = this.mPreviewVideoCostTime;
        if (isMirrorEnable()) {
            videoRecordMsgData.mIsMirror = getMirror();
        }
        if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO.equals(getCameraMode())) {
            strValueOf = getSlowVideoFps() + com.meicam.sdk.NvsStreamingContext.COMPILE_FPS;
        } else {
            strValueOf = java.lang.String.valueOf(getVideoFps());
        }
        videoRecordMsgData.mVideoFps = strValueOf;
        if (needUploadOplusStatistics(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) && com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a != getCurrFilterIndex()) {
            if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_MICROSCOPE.equals(getCameraMode())) {
                videoRecordMsgData.mAncFilterType = getFilterType(getCurrFilterIndex());
            } else {
                videoRecordMsgData.mFilterType = getFilterType(getCurrFilterIndex());
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) {
            videoRecordMsgData.mFlashMode = getFlashMode();
        }
        if (!this.mbFrontCamera) {
            videoRecordMsgData.mAeAfLock = java.lang.String.valueOf(this.mVideoAeAfLock);
        }
        if (needUploadOplusStatistics(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM)) {
            videoRecordMsgData.mZoomValue = java.lang.String.valueOf(this.mCameraInterface.ak_renamed());
        }
        com.oplus.camera.l_renamed.c_renamed.a_renamed(videoRecordMsgData, (this.mPreferences == null || !this.mPreferences.getBoolean("pref_camera_statement_agree", false)) ? false : z2, this.mCameraInterface.y_renamed());
        videoRecordMsgData.mFlashTrigger = com.oplus.camera.a_renamed.a_renamed.a_renamed(getFlashMode());
        videoRecordMsgData.mTouchXYValue = this.mCameraInterface.af_renamed();
        videoRecordMsgData.mTouchEVValue = java.lang.String.valueOf(this.mCameraInterface.ai_renamed());
        videoRecordMsgData.mVolumeFunction = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VOLUME_KEY_FUNCTION, com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_volume_key_function_default_value));
        videoRecordMsgData.mIsShutterVoice = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_SOUND, com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.camera_sound_default_value));
        videoRecordMsgData.mFaceCount = this.mFaceCountOnStop;
        videoRecordMsgData.mScreenBrightness = this.mSysBrightness;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            videoRecordMsgData.mIsWideAngle = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, com.oplus.camera.util.Util.l_renamed().getString(com.oplus.camera.R_renamed.string.ultra_wide_angle_default_value));
        }
        if (isBlurOpen()) {
            videoRecordMsgData.mBlurLevel = getBlurIndex();
        }
        videoRecordMsgData.mStartVideoRecordingOrientation = this.mStartRecordingOrientation;
        videoRecordMsgData.mStartVideoRecordingFaceCount = this.mStartRecordingFaceCount;
        videoRecordMsgData.mMemoryValue = java.lang.String.valueOf(com.oplus.camera.util.Util.k_renamed(com.oplus.camera.util.Util.l_renamed()));
        videoRecordMsgData.mFilePath = this.mCurrentVideoFilename;
        videoRecordMsgData.mShutterType = this.mShutterType + com.oplus.camera.statistics.model.DcsMsgData.DIVIDER + getCameraShutterType();
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.VIDEO_HDR)) {
            videoRecordMsgData.mIs3HDR = getHDRModeValue(getHDRKey());
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ULTRA_NIGHT_VIDEO)) {
            videoRecordMsgData.mIsNightScene = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off");
        }
        videoRecordMsgData.mPicSizeType = com.oplus.camera.util.Util.a_renamed(getPictureSize(this.mOneCamera.e_renamed()), this.mCameraId);
        if ("16_9".equals(videoRecordMsgData.mPicSizeType)) {
            videoRecordMsgData.mPicSizeType = "16:9";
        }
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            videoRecordMsgData.mIsAiEnhance = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, com.oplus.camera.util.Util.e_renamed(this.mbFrontCamera));
            videoRecordMsgData.mAiEnhanceSceneStart = this.mAiEnhanceSceneStart;
            videoRecordMsgData.mAiEnhanceSceneEnd = this.mAiEnhanceSceneEnd;
            videoRecordMsgData.mAiEnhanceSceneChangeCount = this.mAiEnhanceSceneChangeCount;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
            videoRecordMsgData.mIsStablized = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU)) {
            if (!"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) {
                videoRecordMsgData.mUltraSteady = com.oplus.camera.statistics.model.MenuClickMsgData.ULTRA_ON;
            } else {
                videoRecordMsgData.mUltraSteady = com.oplus.camera.statistics.model.MenuClickMsgData.ULTRA_OFF;
            }
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
            videoRecordMsgData.m10BitsEncode = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
        }
        if ("".equals(this.mEndType)) {
            this.mEndType = "normal";
        }
        videoRecordMsgData.mEndType = this.mEndType;
        videoRecordMsgData.mRecordingStartTemperature = java.lang.String.valueOf(this.mRecordingStartTemperature);
        videoRecordMsgData.mRecordingEndTemperature = java.lang.String.valueOf(this.mRecordingEndTemperature);
        videoRecordMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO)) {
            if (this.mPreferences != null) {
                videoRecordMsgData.mVideoAssistantLine = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LINE_VIDEO, "off");
            }
            videoRecordMsgData.mSpiritLevel = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER, "off");
            if (str.equals(videoRecordMsgData.mSpiritLevel)) {
                videoRecordMsgData.mIsOverlap = java.lang.String.valueOf(this.mCameraUIInterface.ap_renamed());
            }
            if (this.mCameraUIInterface.ap_renamed()) {
                videoRecordMsgData.mHorizontalOrVertical = this.mCameraUIInterface.aq_renamed();
            }
        }
        if (isSlowVideoHighFrame()) {
            videoRecordMsgData.mIsDragBox = java.lang.String.valueOf(z_renamed);
        }
        if (supportBinauralRecord() && this.mbBinauralRecordEnable) {
            videoRecordMsgData.mVideoRecorderSound = "binaural";
        }
        onGetBeforeCaptureMsgCommonData(videoRecordMsgData);
        videoRecordMsgData.report();
    }

    protected boolean supportBinauralRecord() {
        return com.oplus.camera.util.Util.a_renamed();
    }

    protected void reportReminderToDcs(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.statistics.model.ReminderMsgData reminderMsgData = new com.oplus.camera.statistics.model.ReminderMsgData(this.mActivity, false);
        if (this.mCameraInterface != null) {
            if (this.mCameraInterface.m_renamed()) {
                reminderMsgData.mCameraEnterType = java.lang.String.valueOf(3);
            }
            reminderMsgData.mCameraId = this.mCameraInterface.ax_renamed();
        }
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mCaptureType = 1;
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mbRecording = isVideoRecording();
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        reminderMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CUSTOM_BEAUTY;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x00ec  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.w_renamed.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    protected boolean needVideoPipeline() {
        return (isUseMediaCodec() || isUseMediaRecorderNotUseAPS()) ? false : true;
    }

    private boolean canNotStopVideoRecordingImmediately() {
        return (isSatOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL)) || (isRearSuperEISOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) || isHyperLapseOpen() || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopRecordingFrame() {
        com.oplus.camera.e_renamed.b_renamed(TAG, "stopRecordingFrame, isHyperLapseOpen: " + isHyperLapseOpen());
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_USAGE) || isHyperLapseOpen()) {
            this.mRecordHandler.removeMessages(2);
            this.mRecordHandler.sendEmptyMessage(2);
        }
        if (!this.mbVideoFrameInAPS || this.mCameraInterface == null) {
            return;
        }
        this.mCameraInterface.c_renamed(5);
    }

    protected android.view.Surface getVideoSurface() {
        android.view.Surface surface;
        synchronized (this.mVideoSurfaceLock) {
            surface = this.mVideoSurface;
        }
        return surface;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(java.lang.String str) {
        if ("type_main_preview_frame".equals(str) || "type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return (!com.oplus.camera.util.Util.C_renamed() || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && isSatOpen() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL);
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needApsToProcessVideoWatermark() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen() && !isUseMediaCodec();
    }

    private boolean isHalEisCache() {
        return this.mbEisHalCache || (isSatOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_USE_HAL) && needApsToProcessVideoWatermark());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSupportLensSwicth() {
        return com.oplus.camera.util.Util.C_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoTemperatureThresholdChanged(int i_renamed) {
        boolean zIsVideoRecording = isVideoRecording();
        com.oplus.camera.e_renamed.a_renamed(TAG, "onVideoTemperatureThresholdChanged, thresholdLevel: " + i_renamed + ", isVideoRecording: " + zIsVideoRecording);
        if (zIsVideoRecording && !this.mCameraInterface.k_renamed() && 1 == i_renamed) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_stop_video_recording_hint, -1, true, false, false);
            this.mCameraInterface.d_renamed(5);
            this.mEndType = com.oplus.camera.statistics.model.VideoRecordMsgData.END_TYPE_TEMP_COUNT_DOWN_TO_STOP;
            reportReminderToDcs(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_TEMP_STOP_ALL_VIDEO);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needShow10bitHint() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) && isVideo10BitOpen() && !isMovieMode();
    }

    private boolean videoSloganSupportAndOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
    }

    private boolean isHalVideoWaterSlogan() {
        return isSloganOpen() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getExpectedFrameRate() {
        return getVideoFps();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null && currentScreenMode.r_renamed() && this.mCameraUIInterface != null) {
            this.mCameraUIInterface.b_renamed(true, true, false, false);
        }
        return super.onSingleTapUp(motionEvent);
    }
}
