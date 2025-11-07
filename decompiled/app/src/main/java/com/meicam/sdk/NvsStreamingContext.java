package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsStreamingContext {
    public static final int AV_FILEINFO_EXTRA_NULL = 0;
    public static final int AV_FILEINFO_EXTRA_PIXELFORMAT = 1;
    public static final int AV_FILEINFO_EXTRA_VIDEO_CODEC_ID = 2;
    public static final int BUFFER_IMAGE_ROTATION_0 = 0;
    public static final int BUFFER_IMAGE_ROTATION_180 = 2;
    public static final int BUFFER_IMAGE_ROTATION_270 = 3;
    public static final int BUFFER_IMAGE_ROTATION_90 = 1;
    public static final int CAPTURE_DEVICE_ERROR_SERVER_DIED = 2;
    public static final int CAPTURE_DEVICE_ERROR_UNKNOWN = 1;
    public static final int CLEAR_CACHE_FLAG_AVFILE_INFO = 8;
    public static final int CLEAR_CACHE_FLAG_AVFILE_KEYFRAME_INFO = 16;
    public static final int CLEAR_CACHE_FLAG_CAPTION_FONT_INFO = 32;
    public static final int CLEAR_CACHE_FLAG_ICON_ENGINE = 2;
    public static final int CLEAR_CACHE_FLAG_STREAMING_ENGINE = 1;
    public static final int CLEAR_CACHE_FLAG_WAVEFORM_ENGINE = 4;
    public static final java.lang.String COMPILE_AUDIO_BITRATE = "audio bitrate";
    public static final java.lang.String COMPILE_BITRATE = "bitrate";
    public static final int COMPILE_BITRATE_GRADE_HIGH = 2;
    public static final int COMPILE_BITRATE_GRADE_LOW = 0;
    public static final int COMPILE_BITRATE_GRADE_MEDIUM = 1;
    public static final java.lang.String COMPILE_CREATION_TIME = "creation time";
    public static final java.lang.String COMPILE_DISABLE_ASYNC_ENCODE = "disable async encode";
    public static final java.lang.String COMPILE_FPS = "fps";
    public static final java.lang.String COMPILE_GOP_SIZE = "gopsize";
    public static final java.lang.String COMPILE_LOSSLESS_AUDIO = "lossless audio";
    public static final java.lang.String COMPILE_OPTIMIZE_FOR_NETWORK_USE = "optimize-for-network-use";
    public static final java.lang.String COMPILE_SOFTWARE_ENCODER_CRF = "software encorder crf";
    public static final java.lang.String COMPILE_SOFTWARE_ENCODER_CRF_BITRATE_MAX = "software encorder crf bitrate max";
    public static final java.lang.String COMPILE_SOFTWARE_ENCODER_MODE = "software encorder mode";
    public static final java.lang.String COMPILE_SOFTWARE_ENCODER_PRESET = "software encorder preset";
    public static final java.lang.String COMPILE_USE_OPERATING_RATE = "use operating rate";
    public static final java.lang.String COMPILE_VIDEO_ENCODER_NAME = "video encoder name";
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_1080 = 3;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_2160 = 4;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_360 = 0;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_480 = 1;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_720 = 2;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_CUSTOM = 256;
    public static final int DEBUG_LEVEL_DEBUG = 3;
    public static final int DEBUG_LEVEL_ERROR = 1;
    public static final int DEBUG_LEVEL_NONE = 0;
    public static final int DEBUG_LEVEL_WARNING = 2;
    public static final int HUMAN_DETECTION_DATA_TYPE_FAKE_FACE = 0;
    public static final int HUMAN_DETECTION_FEATURE_FACE_ACTION = 2;
    public static final int HUMAN_DETECTION_FEATURE_FACE_LANDMARK = 1;
    public static final java.lang.String RECORD_BITRATE = "bitrate";
    public static final java.lang.String RECORD_GOP_SIZE = "gopsize";
    public static final int STREAMING_CONTEXT_FLAG_ASYNC_ENGINE_STATE = 16;
    public static final int STREAMING_CONTEXT_FLAG_ASYNC_INITIALIZED = 64;
    public static final int STREAMING_CONTEXT_FLAG_COMPACT_MEMORY_MODE = 2;
    public static final int STREAMING_CONTEXT_FLAG_NO_HARDWARE_VIDEO_READER = 8;
    public static final int STREAMING_CONTEXT_FLAG_SUPPORT_4K_EDIT = 1;
    public static final int STREAMING_CONTEXT_FLAG_SUPPORT_8K_EDIT = 4;
    public static final int STREAMING_CONTEXT_VIDEO_DECODER_WITHOUT_SURFACE_TEXTURE = 32;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_CAPTURE_BUDDY_HOST_VIDEO_FRAME = 32;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_DONT_CAPTURE_AUDIO = 16;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_DONT_USE_SYSTEM_RECORDER = 4;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_FACE_ACTION_WITH_PARTICLE = 256;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_GRAB_CAPTURED_VIDEO_FRAME = 1;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_LOW_PIPELINE_SIZE = 512;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_STRICT_PREVIEW_VIDEO_SIZE = 8;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DISABLE_HARDWARE_ENCODER = 1;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DISABLE_MEDIA_MUXER = 16;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DONT_USE_INPUT_SURFACE = 2;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_ONLY_AUDIO = 8;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_ONLY_VIDEO = 4;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_DECODER_SETUP_ERROR = 2;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_DECODING_ERROR = 3;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_ENCODER_SETUP_ERROR = 0;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_ENCODING_ERROR = 1;
    public static final int STREAMING_ENGINE_INTERRUPT_STOP = 4;
    public static final int STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_HARDWARE_CODEC_ERROR = 1;
    public static final int STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_MEDIA_FILE_DECODE_ERROR = 4;
    public static final int STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_MEDIA_FILE_ERROR = 0;
    public static final int STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_MEDIA_FILE_OPEN_ERROR = 3;
    public static final int STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_SOFTWARE_CODEC_ERROR = 2;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_DISABLE_FIXED_PREROLL_TIME = 16;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_LOW_PIPELINE_SIZE = 8;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_PLAYBACK_ADAPTIVE_FPS = 32;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_DISABLE_HARDWARE_ENCODER = 4;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_DISABLE_MEDIA_MUXER = 128;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_DONT_USE_INPUT_SURFACE = 64;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_IGNORE_VIDEO_ROTATION = 32;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_ONLY_RECORD_VIDEO = 16;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_SOFTWARE_VIDEO_INTRA_FRAME_ONLY_FAST_STOP = 8;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_VIDEO_INTRA_FRAME_ONLY = 2;
    public static final int STREAMING_ENGINE_SEEK_FLAG_SHOW_ANIMATED_STICKER_POSTER = 4;
    public static final int STREAMING_ENGINE_SEEK_FLAG_SHOW_CAPTION_POSTER = 2;
    public static final int STREAMING_ENGINE_SEND_BUFFER_FLAG_ONLY_FOR_BUDDY = 2;
    public static final int STREAMING_ENGINE_SEND_BUFFER_FLAG_ONLY_FOR_GRAB = 1;
    public static final int STREAMING_ENGINE_STATE_CAPTUREPREVIEW = 1;
    public static final int STREAMING_ENGINE_STATE_CAPTURERECORDING = 2;
    public static final int STREAMING_ENGINE_STATE_COMPILE = 5;
    public static final int STREAMING_ENGINE_STATE_PLAYBACK = 3;
    public static final int STREAMING_ENGINE_STATE_SEEKING = 4;
    public static final int STREAMING_ENGINE_STATE_STOPPED = 0;
    public static final int STREAMING_ENGINE_STOP_FLAG_ASYNC = 2;
    public static final int STREAMING_ENGINE_STOP_FLAG_FORCE_STOP_COMPILATION = 1;
    private static final java.lang.String TAG = "Meicam";
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_HIGH = 2;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_LOW = 0;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_MEDIUM = 1;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_SUPER_HIGH = 3;
    public static final int VIDEO_FRAME_RETRIEVER_FLAG_DEFAULT_MEDIA_CODEC_USED = 1;
    public static final int VIDEO_FRAME_RETRIEVER_FLAG_DEFAULT_MEDIA_CODEC_USED_HAS_INDEX_TABLE = 2;
    public static final int VIDEO_PREVIEW_SIZEMODE_FULLSIZE = 0;
    public static final int VIDEO_PREVIEW_SIZEMODE_LIVEWINDOW_SIZE = 1;
    public static final int VIDEO_STABILIZATION_MODE_AUTO = 1;
    public static final int VIDEO_STABILIZATION_MODE_OFF = 0;
    public static final int VIDEO_STABILIZATION_MODE_STANDARD = 2;
    public static final int VIDEO_STABILIZATION_MODE_SUPER = 3;
    private static android.content.res.AssetManager m_assetManager = null;
    private static java.lang.ClassLoader m_classLoader = null;
    private static android.content.Context m_context = null;
    private static boolean m_customNativeLibraryDirPath = false;
    private static int m_debugLevel = 3;
    private static boolean m_faceDetectionLibLoaded;
    private static int m_iconSize;
    private static boolean m_initializedOnce;
    private static com.meicam.sdk.NvsStreamingContext m_instance;
    public static java.lang.String m_logFilePath;
    private static int m_maxIconReader;
    private static int m_maxReaderCount;
    private static java.lang.String m_nativeLibraryDirPath;
    private static boolean m_saveDebugMessagesToFile;
    private com.meicam.sdk.NvsAssetPackageManager m_assetPackageManager;
    private com.meicam.sdk.NvsStreamingContext.CaptureRecordingDurationCallback m_captureRecordingDurationCallback;
    private com.meicam.sdk.NvsStreamingContext.CaptureRecordingStartedCallback m_captureRecordingStartedCallback;
    private com.meicam.sdk.NvsStreamingContext.CaptureDeviceCallback m_catpureDeviceCallback;
    private com.meicam.sdk.NvsStreamingContext.CapturedVideoFrameGrabberCallback m_catpuredVideoFrameGrabberCallback;
    private com.meicam.sdk.NvsStreamingContext.CompileCallback m_compileCallback;
    private com.meicam.sdk.NvsStreamingContext.CompileCallback2 m_compileCallback2;
    private com.meicam.sdk.NvsStreamingContext.CompileFloatProgressCallback m_compileFloatProgressCallback;
    private com.meicam.sdk.NvsStreamingContext.HardwareErrorCallback m_hardwareErrorCallback;
    private com.meicam.sdk.NvsStreamingContext.PlaybackCallback m_playbackCallback;
    private com.meicam.sdk.NvsStreamingContext.PlaybackCallback2 m_playbackCallback2;
    private com.meicam.sdk.NvsStreamingContext.PlaybackDelayCallback m_playbackDelayCallback;
    private com.meicam.sdk.NvsStreamingContext.PlaybackExceptionCallback m_playbackExceptionCallback;
    private com.meicam.sdk.NvsStreamingContext.SeekingCallback m_seekingCallback;
    private com.meicam.sdk.NvsStreamingContext.StreamingEngineCallback m_streamingEngineCallback;
    private com.meicam.sdk.NvsStreamingContext.StreamingEngineCallback2 m_streamingEngineCallback2;
    private com.meicam.sdk.NvsStreamingContext.TimelineTimestampCallback m_timelineTimestampCallback;
    private long m_internalObject = 0;
    private boolean m_isAuxiliaryContext = false;
    private float m_compileVideoBitrateMultiplier = 1.0f;
    private float m_recordVideoBitrateMultiplier = 1.0f;
    private java.util.Hashtable<java.lang.String, java.lang.Object> m_compileConfigurations = new java.util.Hashtable<>();

    public interface CaptureDeviceCallback {
        void onCaptureDeviceAutoFocusComplete(int i_renamed, boolean z_renamed);

        void onCaptureDeviceCapsReady(int i_renamed);

        void onCaptureDeviceError(int i_renamed, int i2);

        void onCaptureDevicePreviewResolutionReady(int i_renamed);

        void onCaptureDevicePreviewStarted(int i_renamed);

        void onCaptureDeviceStopped(int i_renamed);

        void onCaptureRecordingError(int i_renamed);

        void onCaptureRecordingFinished(int i_renamed);
    }

    public static class CaptureDeviceCapability {
        public float exposureCompensationStep;
        public int maxExposureCompensation;
        public int maxZoom;
        public int minExposureCompensation;
        public boolean supportAutoExposure;
        public boolean supportAutoFocus;
        public boolean supportContinuousFocus;
        public boolean supportExposureCompensation;
        public boolean supportFlash;
        public boolean supportVideoStabilization;
        public boolean supportZoom;
        public float[] zoomRatios;
    }

    public interface CaptureRecordingDurationCallback {
        void onCaptureRecordingDuration(int i_renamed, long j_renamed);
    }

    public interface CaptureRecordingStartedCallback {
        void onCaptureRecordingStarted(int i_renamed);
    }

    public interface CapturedVideoFrameGrabberCallback {
        void onCapturedVideoFrameGrabbedArrived(java.nio.ByteBuffer byteBuffer, com.meicam.sdk.NvsVideoFrameInfo nvsVideoFrameInfo);
    }

    public interface CompileCallback {
        void onCompileFailed(com.meicam.sdk.NvsTimeline nvsTimeline);

        void onCompileFinished(com.meicam.sdk.NvsTimeline nvsTimeline);

        void onCompileProgress(com.meicam.sdk.NvsTimeline nvsTimeline, int i_renamed);
    }

    public interface CompileCallback2 {
        void onCompileCompleted(com.meicam.sdk.NvsTimeline nvsTimeline, boolean z_renamed);
    }

    public interface CompileFloatProgressCallback {
        void onCompileFloatProgress(com.meicam.sdk.NvsTimeline nvsTimeline, float f_renamed);
    }

    public interface HardwareErrorCallback {
        void onHardwareError(int i_renamed, java.lang.String str);
    }

    public interface PlaybackCallback {
        void onPlaybackEOF(com.meicam.sdk.NvsTimeline nvsTimeline);

        void onPlaybackPreloadingCompletion(com.meicam.sdk.NvsTimeline nvsTimeline);

        void onPlaybackStopped(com.meicam.sdk.NvsTimeline nvsTimeline);
    }

    public interface PlaybackCallback2 {
        void onPlaybackTimelinePosition(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed);
    }

    public interface PlaybackDelayCallback {
        void onPlaybackDelayed(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, boolean z_renamed);
    }

    public interface PlaybackExceptionCallback {
        void onPlaybackException(com.meicam.sdk.NvsTimeline nvsTimeline, int i_renamed, java.lang.String str);
    }

    public static class SdkVersion {
        public int majorVersion;
        public int minorVersion;
        public int revisionNumber;
    }

    public interface SeekingCallback {
        void onSeekingTimelinePosition(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed);
    }

    public interface StreamingEngineCallback {
        void onFirstVideoFramePresented(com.meicam.sdk.NvsTimeline nvsTimeline);

        void onStreamingEngineStateChanged(int i_renamed);
    }

    public interface StreamingEngineCallback2 {
        void onStreamingEngineStateChangedWithTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, int i_renamed);
    }

    public interface TimelineTimestampCallback {
        void onTimestampOutOfRange(com.meicam.sdk.NvsTimeline nvsTimeline);
    }

    public static class VerifyLicenseResult {
        public boolean needCheckExpiration;
        public boolean success;
    }

    private native boolean nativeApplyCaptureScene(java.lang.String str);

    private native boolean nativeCanDecodeVideoStreamBySoftware(java.lang.String str);

    private native void nativeCancelAutoFocus();

    private native boolean nativeCheckDontSetCameraParamOnRecordingWithSystemRecorder();

    private native void nativeClearCachedResources(boolean z_renamed);

    private native void nativeClearCachedResourcesFlags(boolean z_renamed, int i_renamed);

    private static native void nativeClose();

    private static native void nativeCloseHumanDetection();

    private native boolean nativeCompileTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, long j2, java.lang.String str, int i_renamed, int i2, float f_renamed, java.util.Hashtable hashtable, int i3);

    private native boolean nativeConnectCapturePreviewWithLiveWindow(java.lang.Object obj);

    private native boolean nativeConnectCapturePreviewWithSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture);

    private native boolean nativeConnectTimelineWithLiveWindow(com.meicam.sdk.NvsTimeline nvsTimeline, java.lang.Object obj);

    private native boolean nativeConnectTimelineWithSurfaceTexture(com.meicam.sdk.NvsTimeline nvsTimeline, android.graphics.SurfaceTexture surfaceTexture, com.meicam.sdk.NvsRational nvsRational);

    private native boolean nativeCreateAuxiliaryStreamingContext(com.meicam.sdk.NvsStreamingContext nvsStreamingContext, int i_renamed);

    private native com.meicam.sdk.NvsTimeline nativeCreateTimeline(com.meicam.sdk.NvsVideoResolution nvsVideoResolution, com.meicam.sdk.NvsRational nvsRational, com.meicam.sdk.NvsAudioResolution nvsAudioResolution);

    private native void nativeDestoryAuxiliaryStreamingContext(com.meicam.sdk.NvsStreamingContext nvsStreamingContext);

    private native float nativeDetectEngineRenderFramePerSecond();

    private native void nativeDetectPackageName(android.content.Context context);

    private native int nativeDetectVideoFileKeyframeInterval(java.lang.String str);

    private native void nativeEnableGetAVFileInfoFromMediaExtractor(java.lang.String str);

    private static native boolean nativeFunctionalityAuthorised(java.lang.String str);

    private native com.meicam.sdk.NvsAVFileInfo nativeGetAVFileInfo(java.lang.String str, int i_renamed);

    private static native com.meicam.sdk.NvsAVFileInfo nativeGetAVInfoFromFile(java.lang.String str, int i_renamed);

    private native java.util.List<java.lang.String> nativeGetAllBuiltinAudioFxNames();

    private native java.util.List<java.lang.String> nativeGetAllBuiltinCaptureVideoFxNames();

    private native java.util.List<java.lang.String> nativeGetAllBuiltinVideoFxNames();

    private native java.util.List<java.lang.String> nativeGetAllBuiltinVideoTransitionNames();

    private native long nativeGetAssetPackageManager();

    private native com.meicam.sdk.NvsFxDescription nativeGetAudioFxDescription(java.lang.String str);

    private native int nativeGetAudioStreamCountInMediaFile(java.lang.String str);

    private native java.lang.String nativeGetBeautyVideoFxName();

    private native com.meicam.sdk.NvsStreamingContext.CaptureDeviceCapability nativeGetCaptureDeviceCapability(int i_renamed);

    private native int nativeGetCaptureDeviceCount();

    private native com.meicam.sdk.NvsSize nativeGetCapturePreviewVideoSize(int i_renamed);

    private native com.meicam.sdk.NvsCaptureVideoFx nativeGetCaptureVideoFxByIndex(int i_renamed);

    private native int nativeGetCaptureVideoFxCount();

    private native java.lang.String nativeGetCurrentCaptureSceneId();

    private native int nativeGetCustomCompileVideoHeight();

    private native java.lang.String nativeGetDefaultThemeEndingLogoImageFilePath();

    private native java.lang.String nativeGetDefaultVideoTransitionName();

    private native int nativeGetExposureCompensation();

    private native com.meicam.sdk.NvsStreamingContext.SdkVersion nativeGetSdkVersion();

    private static native int nativeGetStatisticsFrequency();

    private native int nativeGetStreamingEngineState();

    private native long nativeGetTimelineCurrentPosition(com.meicam.sdk.NvsTimeline nvsTimeline);

    private native com.meicam.sdk.NvsFxDescription nativeGetVideoFxDescription(java.lang.String str);

    private native int nativeGetVideoStabilization();

    private native int nativeGetZoom();

    private native android.graphics.Bitmap nativeGrabImageFromTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, com.meicam.sdk.NvsRational nvsRational, int i_renamed);

    private static native int nativeHasARModule();

    private static native boolean nativeInit(java.lang.String str, int i_renamed);

    private static native boolean nativeInitHumanDetection(android.content.Context context, java.lang.String str, java.lang.String str2, int i_renamed);

    private static native boolean nativeInitJNI(android.content.Context context);

    private native com.meicam.sdk.NvsCaptureVideoFx nativeInsertBuiltinCaptureVideoFx(java.lang.String str, int i_renamed);

    private native com.meicam.sdk.NvsCaptureVideoFx nativeInsertCustomCaptureVideoFx(com.meicam.sdk.NvsCustomVideoFx.Renderer renderer, int i_renamed);

    private native com.meicam.sdk.NvsCaptureVideoFx nativeInsertPackagedCaptureVideoFx(java.lang.String str, int i_renamed);

    private native boolean nativeIsCaptureDeviceBackFacing(int i_renamed);

    private native boolean nativeIsCompilingPaused();

    private native boolean nativeIsDefaultCaptionFade();

    private native boolean nativeIsFlashOn();

    private static native boolean nativeIsNeedCheckExpiration();

    private native boolean nativeIsPlaybackPaused();

    private native boolean nativeIsRecordingPaused();

    private native boolean nativeIsSdkAuthorised();

    private static native boolean nativeIsStatisticsPrivateInfo();

    private native boolean nativePauseResumeCompiling(boolean z_renamed);

    private native boolean nativePauseResumePlayback(boolean z_renamed);

    private native boolean nativePauseResumeRecording(boolean z_renamed);

    private native boolean nativePlaybackTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, long j2, int i_renamed, boolean z_renamed, int i2);

    private native boolean nativePlaybackTimelineWithProxyScale(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, long j2, com.meicam.sdk.NvsRational nvsRational, boolean z_renamed, int i_renamed);

    private native java.lang.String nativeRegisterFontByFilePath(java.lang.String str);

    private native void nativeRemoveAllCaptureVideoFx();

    private native boolean nativeRemoveCaptureVideoFx(int i_renamed);

    private native void nativeRemoveCurrentCaptureScene();

    private native boolean nativeRemoveTimeline(com.meicam.sdk.NvsTimeline nvsTimeline);

    private native com.meicam.sdk.NvsColor nativeSampleColorFromCapturedVideoFrame(android.graphics.RectF rectF);

    private native boolean nativeSeekTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, int i_renamed, int i2);

    private native boolean nativeSeekTimelineWithProxyScale(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, com.meicam.sdk.NvsRational nvsRational, int i_renamed);

    private native boolean nativeSendBufferToCapturePreview(byte[] bArr, long j_renamed, int i_renamed);

    private static native void nativeSetAssetManager(android.content.res.AssetManager assetManager);

    private native void nativeSetAudioOutputDeviceVolume(float f_renamed);

    private native void nativeSetAutoExposureRect(android.graphics.RectF rectF);

    private static native void nativeSetCaptureDeviceCallback(com.meicam.sdk.NvsStreamingContext.CaptureDeviceCallback captureDeviceCallback);

    private static native void nativeSetCaptureRecordingDurationCallback(com.meicam.sdk.NvsStreamingContext.CaptureRecordingDurationCallback captureRecordingDurationCallback);

    private static native void nativeSetCaptureRecordingStartedCallback(com.meicam.sdk.NvsStreamingContext.CaptureRecordingStartedCallback captureRecordingStartedCallback);

    private static native void nativeSetCapturedVideoFrameGrabberCallback(com.meicam.sdk.NvsStreamingContext.CapturedVideoFrameGrabberCallback capturedVideoFrameGrabberCallback);

    private native void nativeSetCompileCallback(com.meicam.sdk.NvsStreamingContext.CompileCallback compileCallback);

    private native void nativeSetCompileCallback2(com.meicam.sdk.NvsStreamingContext.CompileCallback2 compileCallback2);

    private native void nativeSetCompileFloatProgressCallback(com.meicam.sdk.NvsStreamingContext.CompileFloatProgressCallback compileFloatProgressCallback);

    private native void nativeSetCustomCompileVideoHeight(int i_renamed);

    private static native void nativeSetDebugLevel(int i_renamed);

    private native void nativeSetDefaultCaptionFade(boolean z_renamed);

    private native boolean nativeSetDefaultThemeEndingLogoImageFilePath(java.lang.String str);

    private native void nativeSetExposureCompensation(int i_renamed);

    private native void nativeSetHDRLutFilePath(java.lang.String str, boolean z_renamed);

    private native void nativeSetHardwareErrorCallback(com.meicam.sdk.NvsStreamingContext.HardwareErrorCallback hardwareErrorCallback);

    private static native void nativeSetIconSize(int i_renamed);

    private static native void nativeSetLogFilePath(java.lang.String str);

    private static native void nativeSetMaxIconReader(int i_renamed);

    private static native void nativeSetMaxReaderCount(int i_renamed);

    private native void nativeSetMediaCodecIconReaderEnabled(java.lang.String str, boolean z_renamed);

    private native void nativeSetMediaCodecVideoDecodingOperatingRate(java.lang.String str, int i_renamed);

    private native void nativeSetMediaFileActualDuration(java.lang.String str, long j_renamed);

    private native void nativeSetPlaybackCallback(com.meicam.sdk.NvsStreamingContext.PlaybackCallback playbackCallback);

    private native void nativeSetPlaybackCallback2(com.meicam.sdk.NvsStreamingContext.PlaybackCallback2 playbackCallback2);

    private native void nativeSetPlaybackDelayCallback(com.meicam.sdk.NvsStreamingContext.PlaybackDelayCallback playbackDelayCallback);

    private native void nativeSetPlaybackExceptionCallback(com.meicam.sdk.NvsStreamingContext.PlaybackExceptionCallback playbackExceptionCallback);

    private static native void nativeSetSaveDebugMessagesToFile(boolean z_renamed);

    private native void nativeSetSeekingCallback(com.meicam.sdk.NvsStreamingContext.SeekingCallback seekingCallback);

    private native void nativeSetStreamingEngineCallback(com.meicam.sdk.NvsStreamingContext.StreamingEngineCallback streamingEngineCallback);

    private native void nativeSetStreamingEngineCallback2(com.meicam.sdk.NvsStreamingContext.StreamingEngineCallback2 streamingEngineCallback2);

    private native boolean nativeSetThemeEndingEnabled(boolean z_renamed);

    private native void nativeSetUserWatermarkForCapture(java.lang.String str, int i_renamed, int i2, float f_renamed, int i3, int i4, int i5);

    private native void nativeSetVideoStabilization(int i_renamed);

    private native void nativeSetZoom(int i_renamed);

    private static native boolean nativeSetupHumanDetectionData(int i_renamed, java.lang.String str);

    private native void nativeStartAutoFocus(android.graphics.RectF rectF);

    private native boolean nativeStartBufferCapturePreview(int i_renamed, int i2, com.meicam.sdk.NvsRational nvsRational, int i3, boolean z_renamed);

    private native boolean nativeStartCapturePreview(int i_renamed, int i2, int i3, com.meicam.sdk.NvsRational nvsRational);

    private native void nativeStartContinuousFocus();

    private native boolean nativeStartDualBufferCapturePreview(int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed, int i6, com.meicam.sdk.NvsRational nvsRational, int i7, com.cdv.io.NvAndroidVirtualCameraSurfaceTexture nvAndroidVirtualCameraSurfaceTexture);

    private native boolean nativeStartRecording(java.lang.String str, float f_renamed, int i_renamed, int i2, int i3);

    private native void nativeStop(int i_renamed);

    private native void nativeStopRecording();

    private native void nativeToggleFlash(boolean z_renamed);

    private static native com.meicam.sdk.NvsStreamingContext.VerifyLicenseResult nativeVerifySdkLicenseFile(android.content.Context context, java.lang.String str, boolean z_renamed);

    public boolean startCapturePreviewForLiveStreaming(int i_renamed, int i2, int i3, com.meicam.sdk.NvsRational nvsRational, java.lang.String str) {
        return false;
    }

    public static void setNativeLibraryDirPath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        m_nativeLibraryDirPath = str + "/";
        if (str != null) {
            m_customNativeLibraryDirPath = true;
        }
    }

    public static void setLoadPluginFromAssets(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
    }

    public static void setPluginDirPath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
    }

    public static void setDebugLevel(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed == m_debugLevel) {
            return;
        }
        m_debugLevel = i_renamed;
        if (m_instance != null) {
            nativeSetDebugLevel(m_debugLevel);
        }
    }

    public static void setSaveDebugMessagesToFile(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (z_renamed == m_saveDebugMessagesToFile) {
            return;
        }
        m_saveDebugMessagesToFile = z_renamed;
        if (m_instance != null) {
            nativeSetSaveDebugMessagesToFile(m_saveDebugMessagesToFile);
        }
    }

    public static void setLogFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (str == null) {
            return;
        }
        if (str.endsWith("/")) {
            if (str.length() - 2 <= 0) {
                return;
            } else {
                str = str.substring(0, str.length() - 2);
            }
        }
        if (str.isEmpty()) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            m_logFilePath = str;
            if (m_instance != null) {
                nativeSetLogFilePath(str);
            }
        }
    }

    public static android.content.Context getContext() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return m_context;
    }

    public static java.lang.ClassLoader getClassLoader() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return m_classLoader;
    }

    public boolean isSdkAuthorised() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsSdkAuthorised();
    }

    public static com.meicam.sdk.NvsStreamingContext init(android.content.Context context, java.lang.String str, int i_renamed) throws java.lang.Exception {
        boolean z_renamed;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        com.meicam.sdk.NvsStreamingContext nvsStreamingContext = m_instance;
        if (nvsStreamingContext != null) {
            return nvsStreamingContext;
        }
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (m_nativeLibraryDirPath == null) {
            m_nativeLibraryDirPath = applicationInfo.nativeLibraryDir + "/";
        }
        java.lang.String str2 = ("HOME=" + context.getFilesDir().getAbsolutePath()) + "\tTMPDIR=" + context.getFilesDir().getAbsolutePath();
        try {
            m_assetManager = context.getAssets();
            m_context = context.getApplicationContext();
            m_classLoader = m_context.getClassLoader();
            if (!m_initializedOnce) {
                try {
                    java.lang.Class.forName("com.meicam.sdk.NvsLazyLoadingIndicator");
                    z_renamed = true;
                } catch (java.lang.Exception unused) {
                    z_renamed = false;
                }
                if (!z_renamed) {
                    tryLoadFaceDetectionLibrary();
                }
                loadNativeLibrary("NvStreamingSdkCore");
            }
            if (!nativeInitJNI(m_context)) {
                throw new java.lang.Exception("nativeInitJNI() failed!");
            }
            nativeSetAssetManager(m_assetManager);
            if (m_maxReaderCount > 0) {
                nativeSetMaxReaderCount(m_maxReaderCount);
            }
            if (m_iconSize > 0) {
                nativeSetIconSize(m_iconSize);
            }
            if (m_maxIconReader > 0) {
                nativeSetMaxIconReader(m_maxIconReader);
            }
            nativeSetDebugLevel(m_debugLevel);
            nativeSetSaveDebugMessagesToFile(m_saveDebugMessagesToFile);
            boolean z2 = com.meicam.sdk.NvsSystemVariableManager.getSystemVariableInt(context, "isExpired") == 1;
            new com.meicam.sdk.NvsStreamingContext.VerifyLicenseResult();
            if (!m_initializedOnce) {
                nativeVerifySdkLicenseFile(context, str, z2);
            }
            if (!nativeInit(str2, i_renamed)) {
                return null;
            }
            if (m_logFilePath != null) {
                nativeSetLogFilePath(m_logFilePath);
            }
            m_instance = new com.meicam.sdk.NvsStreamingContext(context, true);
            m_initializedOnce = true;
            if (m_instance.isSdkAuthorised() && nativeIsNeedCheckExpiration()) {
                new com.meicam.sdk.NvsStatisticsSender(context).sendStatistics(nativeGetStatisticsFrequency(), nativeIsStatisticsPrivateInfo());
            }
            return m_instance;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            m_context = null;
            m_classLoader = null;
            m_assetManager = null;
            return null;
        }
    }

    public static com.meicam.sdk.NvsStreamingContext init(android.app.Activity activity, java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return init((android.content.Context) activity, str, i_renamed);
    }

    public static com.meicam.sdk.NvsStreamingContext init(android.app.Activity activity, java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return init(activity, str, 0);
    }

    public static void close() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        com.meicam.sdk.NvsStreamingContext nvsStreamingContext = m_instance;
        if (nvsStreamingContext == null) {
            return;
        }
        com.meicam.sdk.NvsAssetPackageManager assetPackageManager = nvsStreamingContext.getAssetPackageManager();
        if (assetPackageManager != null) {
            assetPackageManager.setCallbackInterface(null);
        }
        m_instance.setCaptureDeviceCallback(null);
        m_instance.setCapturedVideoFrameGrabberCallback(null);
        m_instance.setCaptureRecordingStartedCallback(null);
        m_instance.setCaptureRecordingDurationCallback(null);
        m_instance.setPlaybackCallback(null);
        m_instance.setCompileCallback(null);
        m_instance.setStreamingEngineCallback(null);
        m_instance.setTimelineTimestampCallback(null);
        m_instance.setCompileCallback2(null);
        m_instance.setCompileFloatProgressCallback(null);
        m_instance.setPlaybackCallback2(null);
        m_instance.setPlaybackDelayCallback(null);
        m_instance.setPlaybackExceptionCallback(null);
        m_instance.setHardwareErrorCallback(null);
        m_instance = null;
        m_context = null;
        m_classLoader = null;
        nativeSetAssetManager(null);
        m_assetManager = null;
        nativeClose();
    }

    public static com.meicam.sdk.NvsStreamingContext getInstance() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return m_instance;
    }

    public static boolean initHumanDetection(android.content.Context context, java.lang.String str, java.lang.String str2, int i_renamed) throws java.lang.ClassNotFoundException {
        tryLoadFaceDetectionLibrary();
        if (m_faceDetectionLibLoaded) {
            return nativeInitHumanDetection(context, str, str2, i_renamed);
        }
        return false;
    }

    public static boolean setupHumanDetectionData(int i_renamed, java.lang.String str) {
        return nativeSetupHumanDetectionData(i_renamed, str);
    }

    public static void closeHumanDetection() {
        nativeCloseHumanDetection();
    }

    public static int hasARModule() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeHasARModule();
    }

    public float detectEngineRenderFramePerSecond() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeDetectEngineRenderFramePerSecond();
    }

    private NvsStreamingContext(android.content.Context context, boolean z_renamed) {
        this.m_assetPackageManager = null;
        if (z_renamed) {
            this.m_assetPackageManager = new com.meicam.sdk.NvsAssetPackageManager(false);
            this.m_assetPackageManager.setInternalObject(nativeGetAssetPackageManager());
            nativeDetectPackageName(context);
        }
    }

    public com.meicam.sdk.NvsStreamingContext.SdkVersion getSdkVersion() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetSdkVersion();
    }

    public com.meicam.sdk.NvsAssetPackageManager getAssetPackageManager() {
        if (this.m_isAuxiliaryContext) {
            com.meicam.sdk.NvsStreamingContext nvsStreamingContext = getInstance();
            if (nvsStreamingContext == null) {
                return null;
            }
            return nvsStreamingContext.getAssetPackageManager();
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_assetPackageManager;
    }

    public void setCaptureDeviceCallback(com.meicam.sdk.NvsStreamingContext.CaptureDeviceCallback captureDeviceCallback) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_catpureDeviceCallback = captureDeviceCallback;
        nativeSetCaptureDeviceCallback(captureDeviceCallback);
    }

    public void setCapturedVideoFrameGrabberCallback(com.meicam.sdk.NvsStreamingContext.CapturedVideoFrameGrabberCallback capturedVideoFrameGrabberCallback) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_catpuredVideoFrameGrabberCallback = capturedVideoFrameGrabberCallback;
        nativeSetCapturedVideoFrameGrabberCallback(capturedVideoFrameGrabberCallback);
    }

    public void setCaptureRecordingStartedCallback(com.meicam.sdk.NvsStreamingContext.CaptureRecordingStartedCallback captureRecordingStartedCallback) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_captureRecordingStartedCallback = captureRecordingStartedCallback;
        nativeSetCaptureRecordingStartedCallback(captureRecordingStartedCallback);
    }

    public void setCaptureRecordingDurationCallback(com.meicam.sdk.NvsStreamingContext.CaptureRecordingDurationCallback captureRecordingDurationCallback) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_captureRecordingDurationCallback = captureRecordingDurationCallback;
        nativeSetCaptureRecordingDurationCallback(captureRecordingDurationCallback);
    }

    public void setPlaybackCallback(com.meicam.sdk.NvsStreamingContext.PlaybackCallback playbackCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_playbackCallback = playbackCallback;
        nativeSetPlaybackCallback(playbackCallback);
    }

    public void setCompileCallback(com.meicam.sdk.NvsStreamingContext.CompileCallback compileCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_compileCallback = compileCallback;
        nativeSetCompileCallback(compileCallback);
    }

    public void setStreamingEngineCallback(com.meicam.sdk.NvsStreamingContext.StreamingEngineCallback streamingEngineCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_streamingEngineCallback = streamingEngineCallback;
        nativeSetStreamingEngineCallback(streamingEngineCallback);
    }

    public void setStreamingEngineCallback2(com.meicam.sdk.NvsStreamingContext.StreamingEngineCallback2 streamingEngineCallback2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_streamingEngineCallback2 = streamingEngineCallback2;
        nativeSetStreamingEngineCallback2(streamingEngineCallback2);
    }

    public void setTimelineTimestampCallback(com.meicam.sdk.NvsStreamingContext.TimelineTimestampCallback timelineTimestampCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_timelineTimestampCallback = timelineTimestampCallback;
    }

    public void setCompileCallback2(com.meicam.sdk.NvsStreamingContext.CompileCallback2 compileCallback2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_compileCallback2 = compileCallback2;
        nativeSetCompileCallback2(compileCallback2);
    }

    public void setCompileFloatProgressCallback(com.meicam.sdk.NvsStreamingContext.CompileFloatProgressCallback compileFloatProgressCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_compileFloatProgressCallback = compileFloatProgressCallback;
        nativeSetCompileFloatProgressCallback(compileFloatProgressCallback);
    }

    public void setPlaybackCallback2(com.meicam.sdk.NvsStreamingContext.PlaybackCallback2 playbackCallback2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_playbackCallback2 = playbackCallback2;
        nativeSetPlaybackCallback2(playbackCallback2);
    }

    public void setPlaybackDelayCallback(com.meicam.sdk.NvsStreamingContext.PlaybackDelayCallback playbackDelayCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_playbackDelayCallback = playbackDelayCallback;
        nativeSetPlaybackDelayCallback(playbackDelayCallback);
    }

    public void setPlaybackExceptionCallback(com.meicam.sdk.NvsStreamingContext.PlaybackExceptionCallback playbackExceptionCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_playbackExceptionCallback = playbackExceptionCallback;
        nativeSetPlaybackExceptionCallback(playbackExceptionCallback);
    }

    public void setSeekingCallback(com.meicam.sdk.NvsStreamingContext.SeekingCallback seekingCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_seekingCallback = seekingCallback;
        nativeSetSeekingCallback(seekingCallback);
    }

    public void setHardwareErrorCallback(com.meicam.sdk.NvsStreamingContext.HardwareErrorCallback hardwareErrorCallback) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_hardwareErrorCallback = hardwareErrorCallback;
        nativeSetHardwareErrorCallback(hardwareErrorCallback);
    }

    public com.meicam.sdk.NvsAVFileInfo getAVFileInfo(java.lang.String str) {
        return nativeGetAVFileInfo(str, 0);
    }

    public com.meicam.sdk.NvsAVFileInfo getAVFileInfo(java.lang.String str, int i_renamed) {
        return nativeGetAVFileInfo(str, i_renamed);
    }

    public static com.meicam.sdk.NvsAVFileInfo getAVInfoFromFile(java.lang.String str, int i_renamed) {
        return nativeGetAVInfoFromFile(str, i_renamed);
    }

    public int detectVideoFileKeyframeInterval(java.lang.String str) {
        return nativeDetectVideoFileKeyframeInterval(str);
    }

    public boolean canDecodeVideoStreamBySoftware(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeCanDecodeVideoStreamBySoftware(str);
    }

    public static boolean functionalityAuthorised(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeFunctionalityAuthorised(str);
    }

    public boolean setDefaultThemeEndingLogoImageFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSetDefaultThemeEndingLogoImageFilePath(str);
    }

    public java.lang.String getDefaultThemeEndingLogoImageFilePath() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDefaultThemeEndingLogoImageFilePath();
    }

    public java.lang.String registerFontByFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRegisterFontByFilePath(str);
    }

    public boolean setThemeEndingEnabled(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSetThemeEndingEnabled(z_renamed);
    }

    public com.meicam.sdk.NvsTimeline createTimeline(com.meicam.sdk.NvsVideoResolution nvsVideoResolution, com.meicam.sdk.NvsRational nvsRational, com.meicam.sdk.NvsAudioResolution nvsAudioResolution) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeCreateTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
    }

    public boolean removeTimeline(com.meicam.sdk.NvsTimeline nvsTimeline) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveTimeline(nvsTimeline);
    }

    public int getStreamingEngineState() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetStreamingEngineState();
    }

    public long getTimelineCurrentPosition(com.meicam.sdk.NvsTimeline nvsTimeline) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineCurrentPosition(nvsTimeline);
    }

    public boolean compileTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, long j2, java.lang.String str, int i_renamed, int i2, int i3) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeCompileTimeline(nvsTimeline, j_renamed, j2, str, i_renamed, i2, this.m_compileVideoBitrateMultiplier, this.m_compileConfigurations, i3);
    }

    public boolean pauseCompiling() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeCompiling(true);
    }

    public boolean resumeCompiling() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeCompiling(false);
    }

    public boolean isCompilingPaused() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsCompilingPaused();
    }

    public void setCustomCompileVideoHeight(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetCustomCompileVideoHeight(i_renamed);
    }

    public int getCustomCompileVideoHeight() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCustomCompileVideoHeight();
    }

    public boolean connectTimelineWithLiveWindow(com.meicam.sdk.NvsTimeline nvsTimeline, com.meicam.sdk.NvsLiveWindow nvsLiveWindow) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindow);
    }

    public boolean connectTimelineWithLiveWindowExt(com.meicam.sdk.NvsTimeline nvsTimeline, com.meicam.sdk.NvsLiveWindowExt nvsLiveWindowExt) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindowExt);
    }

    public boolean connectTimelineWithSurfaceTexture(com.meicam.sdk.NvsTimeline nvsTimeline, android.graphics.SurfaceTexture surfaceTexture) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithSurfaceTexture(nvsTimeline, surfaceTexture, new com.meicam.sdk.NvsRational(1, 1));
    }

    public boolean connectTimelineWithSurfaceTexture(com.meicam.sdk.NvsTimeline nvsTimeline, android.graphics.SurfaceTexture surfaceTexture, com.meicam.sdk.NvsRational nvsRational) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithSurfaceTexture(nvsTimeline, surfaceTexture, nvsRational);
    }

    public boolean seekTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, int i_renamed, int i2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (j_renamed < 0 || j_renamed >= nvsTimeline.getDuration()) {
            com.meicam.sdk.NvsStreamingContext.TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativeSeekTimeline(nvsTimeline, j_renamed, i_renamed, i2);
    }

    public boolean seekTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, com.meicam.sdk.NvsRational nvsRational, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (j_renamed < 0 || j_renamed >= nvsTimeline.getDuration()) {
            com.meicam.sdk.NvsStreamingContext.TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativeSeekTimelineWithProxyScale(nvsTimeline, j_renamed, nvsRational, i_renamed);
    }

    public android.graphics.Bitmap grabImageFromTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, com.meicam.sdk.NvsRational nvsRational) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGrabImageFromTimeline(nvsTimeline, j_renamed, nvsRational, 0);
    }

    public android.graphics.Bitmap grabImageFromTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, com.meicam.sdk.NvsRational nvsRational, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGrabImageFromTimeline(nvsTimeline, j_renamed, nvsRational, i_renamed);
    }

    public boolean playbackTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, long j2, int i_renamed, boolean z_renamed, int i2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (j_renamed < 0 || j_renamed >= nvsTimeline.getDuration() || (j2 >= 0 && j_renamed >= j2)) {
            com.meicam.sdk.NvsStreamingContext.TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativePlaybackTimeline(nvsTimeline, j_renamed, j2, i_renamed, z_renamed, i2);
    }

    public boolean playbackTimeline(com.meicam.sdk.NvsTimeline nvsTimeline, long j_renamed, long j2, com.meicam.sdk.NvsRational nvsRational, boolean z_renamed, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (j_renamed < 0 || j_renamed >= nvsTimeline.getDuration() || (j2 >= 0 && j_renamed >= j2)) {
            com.meicam.sdk.NvsStreamingContext.TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativePlaybackTimelineWithProxyScale(nvsTimeline, j_renamed, j2, nvsRational, z_renamed, i_renamed);
    }

    public boolean pausePlayback() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativePauseResumePlayback(true);
    }

    public boolean resumePlayback() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativePauseResumePlayback(false);
    }

    public boolean isPlaybackPaused() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsPlaybackPaused();
    }

    public void stop() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeStop(0);
    }

    public void stop(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeStop(i_renamed);
    }

    public void clearCachedResources(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeClearCachedResources(z_renamed);
    }

    public void clearCachedResources(boolean z_renamed, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeClearCachedResourcesFlags(z_renamed, i_renamed);
    }

    public int getCaptureDeviceCount() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureDeviceCount();
    }

    public boolean isCaptureDeviceBackFacing(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsCaptureDeviceBackFacing(i_renamed);
    }

    public com.meicam.sdk.NvsStreamingContext.CaptureDeviceCapability getCaptureDeviceCapability(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureDeviceCapability(i_renamed);
    }

    public boolean checkDontSetCameraParamOnRecordingWithSystemRecorder() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeCheckDontSetCameraParamOnRecordingWithSystemRecorder();
    }

    public boolean connectCapturePreviewWithLiveWindow(com.meicam.sdk.NvsLiveWindow nvsLiveWindow) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeConnectCapturePreviewWithLiveWindow(nvsLiveWindow);
    }

    public boolean connectCapturePreviewWithLiveWindowExt(com.meicam.sdk.NvsLiveWindowExt nvsLiveWindowExt) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeConnectCapturePreviewWithLiveWindow(nvsLiveWindowExt);
    }

    public boolean connectCapturePreviewWithSurfaceTexture(android.graphics.SurfaceTexture surfaceTexture) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeConnectCapturePreviewWithSurfaceTexture(surfaceTexture);
    }

    public void setUserWatermarkForCapture(java.lang.String str, int i_renamed, int i2, float f_renamed, int i3, int i4, int i5) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeSetUserWatermarkForCapture(str, i_renamed, i2, f_renamed, i3, i4, i5);
        }
    }

    public void removeUserWatermarkForCapture() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeSetUserWatermarkForCapture(null, 0, 0, 0.0f, 0, 0, 0);
        }
    }

    public boolean startCapturePreview(int i_renamed, int i2, int i3, com.meicam.sdk.NvsRational nvsRational) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (checkCameraPermission()) {
            return nativeStartCapturePreview(i_renamed, i2, i3, nvsRational);
        }
        return false;
    }

    public boolean startBufferCapturePreview(int i_renamed, int i2, com.meicam.sdk.NvsRational nvsRational, int i3, boolean z_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeStartBufferCapturePreview(i_renamed, i2, nvsRational, i3, z_renamed);
    }

    public boolean startDualBufferCapturePreview(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed, int i6, com.meicam.sdk.NvsRational nvsRational, int i7) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (surfaceTexture == null) {
            return false;
        }
        com.cdv.io.NvAndroidVirtualCameraSurfaceTexture nvAndroidVirtualCameraSurfaceTexture = new com.cdv.io.NvAndroidVirtualCameraSurfaceTexture(surfaceTexture);
        if (nativeStartDualBufferCapturePreview(i_renamed, i2, i3, i4, i5, z_renamed, i6, nvsRational, i7, nvAndroidVirtualCameraSurfaceTexture)) {
            return true;
        }
        nvAndroidVirtualCameraSurfaceTexture.release();
        return false;
    }

    public boolean sendBufferToCapturePreview(byte[] bArr, long j_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        return sendBufferToCapturePreview(bArr, j_renamed, 0);
    }

    public boolean sendBufferToCapturePreview(byte[] bArr, long j_renamed, int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        return nativeSendBufferToCapturePreview(bArr, j_renamed, i_renamed);
    }

    public com.meicam.sdk.NvsSize getCapturePreviewVideoSize(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return new com.meicam.sdk.NvsSize(0, 0);
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCapturePreviewVideoSize(i_renamed);
    }

    public com.meicam.sdk.NvsColor sampleColorFromCapturedVideoFrame(android.graphics.RectF rectF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeSampleColorFromCapturedVideoFrame(rectF);
    }

    public void startAutoFocus(android.graphics.RectF rectF) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeStartAutoFocus(rectF);
        }
    }

    public void cancelAutoFocus() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeCancelAutoFocus();
        }
    }

    public void StartContinuousFocus() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeStartContinuousFocus();
        }
    }

    public void setAutoExposureRect(android.graphics.RectF rectF) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeSetAutoExposureRect(rectF);
        }
    }

    public void setZoom(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeSetZoom(i_renamed);
        }
    }

    public int getZoom() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return 1;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetZoom();
    }

    public void toggleFlash(boolean z_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeToggleFlash(z_renamed);
        }
    }

    public boolean isFlashOn() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsFlashOn();
    }

    public int getVideoStabilization() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoStabilization();
    }

    public void setVideoStabilization(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeSetVideoStabilization(i_renamed);
        }
    }

    public void setExposureCompensation(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeSetExposureCompensation(i_renamed);
        }
    }

    public int getExposureCompensation() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetExposureCompensation();
    }

    public com.meicam.sdk.NvsCaptureVideoFx appendBuiltinCaptureVideoFx(java.lang.String str) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertBuiltinCaptureVideoFx(str, getCaptureVideoFxCount());
    }

    public com.meicam.sdk.NvsCaptureVideoFx insertBuiltinCaptureVideoFx(java.lang.String str, int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertBuiltinCaptureVideoFx(str, i_renamed);
    }

    public com.meicam.sdk.NvsCaptureVideoFx appendPackagedCaptureVideoFx(java.lang.String str) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertPackagedCaptureVideoFx(str, getCaptureVideoFxCount());
    }

    public com.meicam.sdk.NvsCaptureVideoFx insertPackagedCaptureVideoFx(java.lang.String str, int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertPackagedCaptureVideoFx(str, i_renamed);
    }

    public com.meicam.sdk.NvsCaptureVideoFx appendCustomCaptureVideoFx(com.meicam.sdk.NvsCustomVideoFx.Renderer renderer) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomCaptureVideoFx(renderer, getCaptureVideoFxCount());
    }

    public com.meicam.sdk.NvsCaptureVideoFx insertCustomCaptureVideoFx(com.meicam.sdk.NvsCustomVideoFx.Renderer renderer, int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomCaptureVideoFx(renderer, i_renamed);
    }

    public com.meicam.sdk.NvsCaptureVideoFx appendBeautyCaptureVideoFx() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertBeautyCaptureVideoFx(getCaptureVideoFxCount());
    }

    public com.meicam.sdk.NvsCaptureVideoFx insertBeautyCaptureVideoFx(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return insertBuiltinCaptureVideoFx(getBeautyVideoFxName(), i_renamed);
    }

    public boolean removeCaptureVideoFx(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeRemoveCaptureVideoFx(i_renamed);
    }

    public void removeAllCaptureVideoFx() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeRemoveAllCaptureVideoFx();
        }
    }

    public int getCaptureVideoFxCount() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxCount();
    }

    public com.meicam.sdk.NvsCaptureVideoFx getCaptureVideoFxByIndex(int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxByIndex(i_renamed);
    }

    public boolean applyCaptureScene(java.lang.String str) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeApplyCaptureScene(str);
    }

    public java.lang.String getCurrentCaptureSceneId() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCurrentCaptureSceneId();
    }

    public void removeCurrentCaptureScene() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeRemoveCurrentCaptureScene();
        }
    }

    public void setCompileConfigurations(java.util.Hashtable<java.lang.String, java.lang.Object> hashtable) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        this.m_compileConfigurations = hashtable;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getCompileConfigurations() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_compileConfigurations;
    }

    public void setCompileVideoBitrateMultiplier(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (f_renamed <= 0.0f) {
            return;
        }
        this.m_compileVideoBitrateMultiplier = f_renamed;
    }

    public float getCompileVideoBitrateMultiplier() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_compileVideoBitrateMultiplier;
    }

    public void setRecordVideoBitrateMultiplier(float f_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (f_renamed <= 0.0f) {
            return;
        }
        this.m_recordVideoBitrateMultiplier = f_renamed;
    }

    public float getRecordVideoBitrateMultiplier() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return 1.0f;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_recordVideoBitrateMultiplier;
    }

    public boolean startRecording(java.lang.String str) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeStartRecording(str, this.m_recordVideoBitrateMultiplier, 0, 0, 0);
    }

    public boolean startRecording(java.lang.String str, int i_renamed) {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeStartRecording(str, this.m_recordVideoBitrateMultiplier, 0, 0, i_renamed);
    }

    public boolean startRecording(java.lang.String str, int i_renamed, java.util.Hashtable<java.lang.String, java.lang.Object> hashtable) {
        int i2;
        int iIntValue;
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (hashtable != null) {
            java.lang.Number number = (java.lang.Number) hashtable.get("bitrate");
            int iIntValue2 = number != null ? number.intValue() : 0;
            java.lang.Number number2 = (java.lang.Number) hashtable.get("gopsize");
            i2 = iIntValue2;
            iIntValue = number2 != null ? number2.intValue() : 0;
        } else {
            i2 = 0;
            iIntValue = 0;
        }
        return nativeStartRecording(str, this.m_recordVideoBitrateMultiplier, i2, iIntValue, i_renamed);
    }

    public void stopRecording() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
            nativeStopRecording();
        }
    }

    public boolean pauseRecording() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeRecording(true);
    }

    public boolean resumeRecording() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeRecording(false);
    }

    public boolean isRecordingPaused() {
        if (this.m_isAuxiliaryContext) {
            android.util.Log.e_renamed(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsRecordingPaused();
    }

    public java.util.List<java.lang.String> getAllBuiltinVideoFxNames() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinVideoFxNames();
    }

    public java.util.List<java.lang.String> getAllBuiltinAudioFxNames() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinAudioFxNames();
    }

    public java.util.List<java.lang.String> getAllBuiltinVideoTransitionNames() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinVideoTransitionNames();
    }

    public java.util.List<java.lang.String> getAllBuiltinCaptureVideoFxNames() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinCaptureVideoFxNames();
    }

    public java.lang.String getBeautyVideoFxName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBeautyVideoFxName();
    }

    public java.lang.String getDefaultVideoTransitionName() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDefaultVideoTransitionName();
    }

    public com.meicam.sdk.NvsFxDescription getVideoFxDescription(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxDescription(str);
    }

    public com.meicam.sdk.NvsFxDescription getAudioFxDescription(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioFxDescription(str);
    }

    public com.meicam.sdk.NvsVideoFrameRetriever createVideoFrameRetriever(java.lang.String str) {
        return new com.meicam.sdk.NvsVideoFrameRetriever(str, 0);
    }

    public com.meicam.sdk.NvsVideoFrameRetriever createVideoFrameRetriever(java.lang.String str, int i_renamed) {
        return new com.meicam.sdk.NvsVideoFrameRetriever(str, i_renamed);
    }

    public com.meicam.sdk.NvsVideoKeyFrameRetriever createVideoKeyFrameRetriever(java.lang.String str, int i_renamed, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return new com.meicam.sdk.NvsVideoKeyFrameRetriever(str, i_renamed, z_renamed);
    }

    public void setDefaultCaptionFade(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetDefaultCaptionFade(z_renamed);
    }

    public boolean isDefaultCaptionFade() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsDefaultCaptionFade();
    }

    public void setAudioOutputDeviceVolume(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetAudioOutputDeviceVolume(f_renamed);
    }

    public com.meicam.sdk.NvsStreamingContext createAuxiliaryStreamingContext(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        android.content.Context context = m_context;
        if (context == null) {
            return null;
        }
        com.meicam.sdk.NvsStreamingContext nvsStreamingContext = new com.meicam.sdk.NvsStreamingContext(context, false);
        if (!nativeCreateAuxiliaryStreamingContext(nvsStreamingContext, i_renamed)) {
            return null;
        }
        nvsStreamingContext.m_isAuxiliaryContext = true;
        return nvsStreamingContext;
    }

    public void destoryAuxiliaryStreamingContext(com.meicam.sdk.NvsStreamingContext nvsStreamingContext) {
        if (nvsStreamingContext == null) {
            return;
        }
        nativeDestoryAuxiliaryStreamingContext(nvsStreamingContext);
    }

    public static void setMaxReaderCount(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        m_maxReaderCount = i_renamed;
    }

    public static void setIconSize(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        m_iconSize = i_renamed;
    }

    public static void setMaxIconReader(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        m_maxIconReader = i_renamed;
    }

    public void enableGetAVFileInfoFromMediaExtractor(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeEnableGetAVFileInfoFromMediaExtractor(str);
    }

    public void setMediaFileActualDuration(java.lang.String str, long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetMediaFileActualDuration(str, j_renamed);
    }

    public void setMediaCodecVideoDecodingOperatingRate(java.lang.String str, int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetMediaCodecVideoDecodingOperatingRate(str, i_renamed);
    }

    public void setMediaCodecIconReaderEnabled(java.lang.String str, boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetMediaCodecIconReaderEnabled(str, z_renamed);
    }

    public int getAudioStreamCountInMediaFile(java.lang.String str) {
        return nativeGetAudioStreamCountInMediaFile(str);
    }

    public void setHDRLutFilePath(java.lang.String str, boolean z_renamed) {
        nativeSetHDRLutFilePath(str, z_renamed);
    }

    protected void setInternalObject(long j_renamed) {
        this.m_internalObject = j_renamed;
    }

    protected long getInternalObject() {
        return this.m_internalObject;
    }

    protected boolean isAuxiliaryContext() {
        return this.m_isAuxiliaryContext;
    }

    private boolean checkCameraPermission() {
        if (android.os.Build.VERSION.SDK_INT < 23 || m_context.checkSelfPermission("android.permission.CAMERA") == 0) {
            return true;
        }
        android.util.Log.e_renamed(TAG, "CAMERA permission has not been granted!");
        return false;
    }

    private boolean checkInternetPermission() {
        if (android.os.Build.VERSION.SDK_INT < 23 || m_context.checkSelfPermission("android.permission.INTERNET") == 0) {
            return true;
        }
        android.util.Log.e_renamed(TAG, "INTERNET permission has not been granted!");
        return false;
    }

    private static void loadNativeLibrary(java.lang.String str) throws java.lang.SecurityException, java.lang.UnsatisfiedLinkError, java.lang.NullPointerException {
        if (!m_customNativeLibraryDirPath) {
            java.lang.System.loadLibrary(str);
            return;
        }
        java.lang.System.load(m_nativeLibraryDirPath + "lib" + str + ".so");
    }

    private static boolean tryLoadNativeLibrary(java.lang.String str) throws java.lang.SecurityException, java.lang.UnsatisfiedLinkError, java.lang.NullPointerException {
        if (!m_customNativeLibraryDirPath) {
            try {
                java.lang.System.loadLibrary(str);
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
        try {
            java.lang.System.load(m_nativeLibraryDirPath + "lib" + str + ".so");
            return true;
        } catch (java.lang.Throwable unused2) {
            return false;
        }
    }

    private static void tryLoadFaceDetectionLibrary() throws java.lang.ClassNotFoundException {
        boolean z_renamed;
        boolean z2;
        boolean z3;
        boolean z4;
        if (m_faceDetectionLibLoaded) {
            return;
        }
        boolean z5 = false;
        try {
            java.lang.Class.forName("com.meicam.sdk.NvsBEFFaceEffectDetector");
            z_renamed = true;
        } catch (java.lang.Exception unused) {
            z_renamed = false;
        }
        if (!z_renamed || tryLoadNativeLibrary("effect")) {
            try {
                java.lang.Class.forName("com.meicam.sdk.NvsMGFaceEffectDetector");
                z2 = true;
            } catch (java.lang.Exception unused2) {
                z2 = false;
            }
            if (!z2 || (tryLoadNativeLibrary("megface-new") && tryLoadNativeLibrary("MegviiFacepp"))) {
                try {
                    java.lang.Class.forName("com.meicam.sdk.NvsSTFaceEffectDetector");
                    z3 = true;
                } catch (java.lang.Exception unused3) {
                    z3 = false;
                }
                if (!z3 || tryLoadNativeLibrary("st_mobile")) {
                    try {
                        java.lang.Class.forName("com.meicam.sdk.NvsFaceEffectV1Detector");
                        z4 = true;
                    } catch (java.lang.Exception unused4) {
                        z4 = false;
                    }
                    if (!z4 || tryLoadNativeLibrary("nama")) {
                        try {
                            java.lang.Class.forName("com.meicam.sdk.NvsFaceEffect2Init");
                            z5 = true;
                        } catch (java.lang.Exception unused5) {
                        }
                        if (!z5 || tryLoadNativeLibrary("st_mobile")) {
                            m_faceDetectionLibLoaded = true;
                        }
                    }
                }
            }
        }
    }
}
