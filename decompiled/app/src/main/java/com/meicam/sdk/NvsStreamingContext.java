package com.meicam.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Log;
import com.cdv.p098io.NvAndroidVirtualCameraSurfaceTexture;
import com.meicam.sdk.NvsCustomVideoFx;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Hashtable;
import java.util.List;

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
    public static final String COMPILE_AUDIO_BITRATE = "audio bitrate";
    public static final String COMPILE_BITRATE = "bitrate";
    public static final int COMPILE_BITRATE_GRADE_HIGH = 2;
    public static final int COMPILE_BITRATE_GRADE_LOW = 0;
    public static final int COMPILE_BITRATE_GRADE_MEDIUM = 1;
    public static final String COMPILE_CREATION_TIME = "creation time";
    public static final String COMPILE_DISABLE_ASYNC_ENCODE = "disable async encode";
    public static final String COMPILE_FPS = "fps";
    public static final String COMPILE_GOP_SIZE = "gopsize";
    public static final String COMPILE_LOSSLESS_AUDIO = "lossless audio";
    public static final String COMPILE_OPTIMIZE_FOR_NETWORK_USE = "optimize-for-network-use";
    public static final String COMPILE_SOFTWARE_ENCODER_CRF = "software encorder crf";
    public static final String COMPILE_SOFTWARE_ENCODER_CRF_BITRATE_MAX = "software encorder crf bitrate max";
    public static final String COMPILE_SOFTWARE_ENCODER_MODE = "software encorder mode";
    public static final String COMPILE_SOFTWARE_ENCODER_PRESET = "software encorder preset";
    public static final String COMPILE_USE_OPERATING_RATE = "use operating rate";
    public static final String COMPILE_VIDEO_ENCODER_NAME = "video encoder name";
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
    public static final String RECORD_BITRATE = "bitrate";
    public static final String RECORD_GOP_SIZE = "gopsize";
    public static final int STREAMING_CONTEXT_FLAG_ASYNC_ENGINE_STATE = 16;
    public static final int STREAMING_CONTEXT_FLAG_ASYNC_INITIALIZED = 64;
    public static final int STREAMING_CONTEXT_FLAG_COMPACT_MEMORY_MODE = 2;
    public static final int STREAMING_CONTEXT_FLAG_NO_HARDWARE_VIDEO_READER = 8;
    public static final int STREAMING_CONTEXT_FLAG_SUPPORT_4K_EDIT = 1;
    public static final int STREAMING_CONTEXT_FLAG_SUPPORT_8K_EDIT = 4;

    /* renamed from: STREAMING_CONTEXT_VIDEO_DECODER_WITHOUT_SURFACE_TEXTURE */
    public static final int f9720xf22dbac6 = 32;

    /* renamed from: STREAMING_ENGINE_CAPTURE_FLAG_CAPTURE_BUDDY_HOST_VIDEO_FRAME */
    public static final int f9721x3c5ea53e = 32;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_DONT_CAPTURE_AUDIO = 16;

    /* renamed from: STREAMING_ENGINE_CAPTURE_FLAG_DONT_USE_SYSTEM_RECORDER */
    public static final int f9722xf621ef02 = 4;

    /* renamed from: STREAMING_ENGINE_CAPTURE_FLAG_FACE_ACTION_WITH_PARTICLE */
    public static final int f9723x765664be = 256;

    /* renamed from: STREAMING_ENGINE_CAPTURE_FLAG_GRAB_CAPTURED_VIDEO_FRAME */
    public static final int f9724xdbb10c21 = 1;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_LOW_PIPELINE_SIZE = 512;

    /* renamed from: STREAMING_ENGINE_CAPTURE_FLAG_STRICT_PREVIEW_VIDEO_SIZE */
    public static final int f9725x979f0018 = 8;

    /* renamed from: STREAMING_ENGINE_COMPILE_FLAG_DISABLE_HARDWARE_ENCODER */
    public static final int f9726x149d9723 = 1;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DISABLE_MEDIA_MUXER = 16;

    /* renamed from: STREAMING_ENGINE_COMPILE_FLAG_DONT_USE_INPUT_SURFACE */
    public static final int f9727x6fdf5599 = 2;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_ONLY_AUDIO = 8;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_ONLY_VIDEO = 4;

    /* renamed from: STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_DECODER_SETUP_ERROR */
    public static final int f9728x5e0e8510 = 2;

    /* renamed from: STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_DECODING_ERROR */
    public static final int f9729x46b0a98f = 3;

    /* renamed from: STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_ENCODER_SETUP_ERROR */
    public static final int f9730x14d9d9e8 = 0;

    /* renamed from: STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_ENCODING_ERROR */
    public static final int f9731x8b29adb7 = 1;
    public static final int STREAMING_ENGINE_INTERRUPT_STOP = 4;

    /* renamed from: STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_HARDWARE_CODEC_ERROR */
    public static final int f9732xfa165b99 = 1;

    /* renamed from: STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_MEDIA_FILE_DECODE_ERROR */
    public static final int f9733x27da71ce = 4;

    /* renamed from: STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_MEDIA_FILE_ERROR */
    public static final int f9734x5c982851 = 0;

    /* renamed from: STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_MEDIA_FILE_OPEN_ERROR */
    public static final int f9735x8f9b46ea = 3;

    /* renamed from: STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_SOFTWARE_CODEC_ERROR */
    public static final int f9736x12330d8 = 2;

    /* renamed from: STREAMING_ENGINE_PLAYBACK_FLAG_DISABLE_FIXED_PREROLL_TIME */
    public static final int f9737x6bdcc5fd = 16;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_LOW_PIPELINE_SIZE = 8;

    /* renamed from: STREAMING_ENGINE_PLAYBACK_FLAG_PLAYBACK_ADAPTIVE_FPS */
    public static final int f9738x71c17d5 = 32;

    /* renamed from: STREAMING_ENGINE_RECORDING_FLAG_DISABLE_HARDWARE_ENCODER */
    public static final int f9739x6f7ef661 = 4;

    /* renamed from: STREAMING_ENGINE_RECORDING_FLAG_DISABLE_MEDIA_MUXER */
    public static final int f9740xb0b1a9e6 = 128;

    /* renamed from: STREAMING_ENGINE_RECORDING_FLAG_DONT_USE_INPUT_SURFACE */
    public static final int f9741xfd6b6c57 = 64;

    /* renamed from: STREAMING_ENGINE_RECORDING_FLAG_IGNORE_VIDEO_ROTATION */
    public static final int f9742x92bb6eea = 32;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_ONLY_RECORD_VIDEO = 16;

    /* renamed from: STREAMING_ENGINE_RECORDING_FLAG_SOFTWARE_VIDEO_INTRA_FRAME_ONLY_FAST_STOP */
    public static final int f9743x7da85e3c = 8;

    /* renamed from: STREAMING_ENGINE_RECORDING_FLAG_VIDEO_INTRA_FRAME_ONLY */
    public static final int f9744x4ababcc8 = 2;

    /* renamed from: STREAMING_ENGINE_SEEK_FLAG_SHOW_ANIMATED_STICKER_POSTER */
    public static final int f9745x495084d5 = 4;
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
    private static final String TAG = "Meicam";
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_HIGH = 2;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_LOW = 0;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_MEDIUM = 1;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_SUPER_HIGH = 3;

    /* renamed from: VIDEO_FRAME_RETRIEVER_FLAG_DEFAULT_MEDIA_CODEC_USED */
    public static final int f9746x110300d3 = 1;

    /* renamed from: VIDEO_FRAME_RETRIEVER_FLAG_DEFAULT_MEDIA_CODEC_USED_HAS_INDEX_TABLE */
    public static final int f9747xc608e830 = 2;
    public static final int VIDEO_PREVIEW_SIZEMODE_FULLSIZE = 0;
    public static final int VIDEO_PREVIEW_SIZEMODE_LIVEWINDOW_SIZE = 1;
    public static final int VIDEO_STABILIZATION_MODE_AUTO = 1;
    public static final int VIDEO_STABILIZATION_MODE_OFF = 0;
    public static final int VIDEO_STABILIZATION_MODE_STANDARD = 2;
    public static final int VIDEO_STABILIZATION_MODE_SUPER = 3;
    private static AssetManager m_assetManager = null;
    private static ClassLoader m_classLoader = null;
    private static Context m_context = null;
    private static boolean m_customNativeLibraryDirPath = false;
    private static int m_debugLevel = 3;
    private static boolean m_faceDetectionLibLoaded;
    private static int m_iconSize;
    private static boolean m_initializedOnce;
    private static NvsStreamingContext m_instance;
    public static String m_logFilePath;
    private static int m_maxIconReader;
    private static int m_maxReaderCount;
    private static String m_nativeLibraryDirPath;
    private static boolean m_saveDebugMessagesToFile;
    private NvsAssetPackageManager m_assetPackageManager;
    private CaptureRecordingDurationCallback m_captureRecordingDurationCallback;
    private CaptureRecordingStartedCallback m_captureRecordingStartedCallback;
    private CaptureDeviceCallback m_catpureDeviceCallback;
    private CapturedVideoFrameGrabberCallback m_catpuredVideoFrameGrabberCallback;
    private CompileCallback m_compileCallback;
    private CompileCallback2 m_compileCallback2;
    private CompileFloatProgressCallback m_compileFloatProgressCallback;
    private HardwareErrorCallback m_hardwareErrorCallback;
    private PlaybackCallback m_playbackCallback;
    private PlaybackCallback2 m_playbackCallback2;
    private PlaybackDelayCallback m_playbackDelayCallback;
    private PlaybackExceptionCallback m_playbackExceptionCallback;
    private SeekingCallback m_seekingCallback;
    private StreamingEngineCallback m_streamingEngineCallback;
    private StreamingEngineCallback2 m_streamingEngineCallback2;
    private TimelineTimestampCallback m_timelineTimestampCallback;
    private long m_internalObject = 0;
    private boolean m_isAuxiliaryContext = false;
    private float m_compileVideoBitrateMultiplier = 1.0f;
    private float m_recordVideoBitrateMultiplier = 1.0f;
    private Hashtable<String, Object> m_compileConfigurations = new Hashtable<>();

    public interface CaptureDeviceCallback {
        void onCaptureDeviceAutoFocusComplete(int OplusGLSurfaceView_13, boolean z);

        void onCaptureDeviceCapsReady(int OplusGLSurfaceView_13);

        void onCaptureDeviceError(int OplusGLSurfaceView_13, int i2);

        void onCaptureDevicePreviewResolutionReady(int OplusGLSurfaceView_13);

        void onCaptureDevicePreviewStarted(int OplusGLSurfaceView_13);

        void onCaptureDeviceStopped(int OplusGLSurfaceView_13);

        void onCaptureRecordingError(int OplusGLSurfaceView_13);

        void onCaptureRecordingFinished(int OplusGLSurfaceView_13);
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
        void onCaptureRecordingDuration(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);
    }

    public interface CaptureRecordingStartedCallback {
        void onCaptureRecordingStarted(int OplusGLSurfaceView_13);
    }

    public interface CapturedVideoFrameGrabberCallback {
        void onCapturedVideoFrameGrabbedArrived(ByteBuffer byteBuffer, NvsVideoFrameInfo nvsVideoFrameInfo);
    }

    public interface CompileCallback {
        void onCompileFailed(NvsTimeline nvsTimeline);

        void onCompileFinished(NvsTimeline nvsTimeline);

        void onCompileProgress(NvsTimeline nvsTimeline, int OplusGLSurfaceView_13);
    }

    public interface CompileCallback2 {
        void onCompileCompleted(NvsTimeline nvsTimeline, boolean z);
    }

    public interface CompileFloatProgressCallback {
        void onCompileFloatProgress(NvsTimeline nvsTimeline, float COUIBaseListPopupWindow_12);
    }

    public interface HardwareErrorCallback {
        void onHardwareError(int OplusGLSurfaceView_13, String str);
    }

    public interface PlaybackCallback {
        void onPlaybackEOF(NvsTimeline nvsTimeline);

        void onPlaybackPreloadingCompletion(NvsTimeline nvsTimeline);

        void onPlaybackStopped(NvsTimeline nvsTimeline);
    }

    public interface PlaybackCallback2 {
        void onPlaybackTimelinePosition(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15);
    }

    public interface PlaybackDelayCallback {
        void onPlaybackDelayed(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, boolean z);
    }

    public interface PlaybackExceptionCallback {
        void onPlaybackException(NvsTimeline nvsTimeline, int OplusGLSurfaceView_13, String str);
    }

    public static class SdkVersion {
        public int majorVersion;
        public int minorVersion;
        public int revisionNumber;
    }

    public interface SeekingCallback {
        void onSeekingTimelinePosition(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15);
    }

    public interface StreamingEngineCallback {
        void onFirstVideoFramePresented(NvsTimeline nvsTimeline);

        void onStreamingEngineStateChanged(int OplusGLSurfaceView_13);
    }

    public interface StreamingEngineCallback2 {
        void onStreamingEngineStateChangedWithTimeline(NvsTimeline nvsTimeline, int OplusGLSurfaceView_13);
    }

    public interface TimelineTimestampCallback {
        void onTimestampOutOfRange(NvsTimeline nvsTimeline);
    }

    public static class VerifyLicenseResult {
        public boolean needCheckExpiration;
        public boolean success;
    }

    private native boolean nativeApplyCaptureScene(String str);

    private native boolean nativeCanDecodeVideoStreamBySoftware(String str);

    private native void nativeCancelAutoFocus();

    /* renamed from: nativeCheckDontSetCameraParamOnRecordingWithSystemRecorder */
    private native boolean m8732x40c3681d();

    private native void nativeClearCachedResources(boolean z);

    private native void nativeClearCachedResourcesFlags(boolean z, int OplusGLSurfaceView_13);

    private static native void nativeClose();

    private static native void nativeCloseHumanDetection();

    private native boolean nativeCompileTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, long j2, String str, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, Hashtable hashtable, int i3);

    private native boolean nativeConnectCapturePreviewWithLiveWindow(Object obj);

    private native boolean nativeConnectCapturePreviewWithSurfaceTexture(SurfaceTexture surfaceTexture);

    private native boolean nativeConnectTimelineWithLiveWindow(NvsTimeline nvsTimeline, Object obj);

    private native boolean nativeConnectTimelineWithSurfaceTexture(NvsTimeline nvsTimeline, SurfaceTexture surfaceTexture, NvsRational nvsRational);

    private native boolean nativeCreateAuxiliaryStreamingContext(NvsStreamingContext nvsStreamingContext, int OplusGLSurfaceView_13);

    private native NvsTimeline nativeCreateTimeline(NvsVideoResolution nvsVideoResolution, NvsRational nvsRational, NvsAudioResolution nvsAudioResolution);

    private native void nativeDestoryAuxiliaryStreamingContext(NvsStreamingContext nvsStreamingContext);

    private native float nativeDetectEngineRenderFramePerSecond();

    private native void nativeDetectPackageName(Context context);

    private native int nativeDetectVideoFileKeyframeInterval(String str);

    private native void nativeEnableGetAVFileInfoFromMediaExtractor(String str);

    private static native boolean nativeFunctionalityAuthorised(String str);

    private native NvsAVFileInfo nativeGetAVFileInfo(String str, int OplusGLSurfaceView_13);

    private static native NvsAVFileInfo nativeGetAVInfoFromFile(String str, int OplusGLSurfaceView_13);

    private native List<String> nativeGetAllBuiltinAudioFxNames();

    private native List<String> nativeGetAllBuiltinCaptureVideoFxNames();

    private native List<String> nativeGetAllBuiltinVideoFxNames();

    private native List<String> nativeGetAllBuiltinVideoTransitionNames();

    private native long nativeGetAssetPackageManager();

    private native NvsFxDescription nativeGetAudioFxDescription(String str);

    private native int nativeGetAudioStreamCountInMediaFile(String str);

    private native String nativeGetBeautyVideoFxName();

    private native CaptureDeviceCapability nativeGetCaptureDeviceCapability(int OplusGLSurfaceView_13);

    private native int nativeGetCaptureDeviceCount();

    private native NvsSize nativeGetCapturePreviewVideoSize(int OplusGLSurfaceView_13);

    private native NvsCaptureVideoFx nativeGetCaptureVideoFxByIndex(int OplusGLSurfaceView_13);

    private native int nativeGetCaptureVideoFxCount();

    private native String nativeGetCurrentCaptureSceneId();

    private native int nativeGetCustomCompileVideoHeight();

    private native String nativeGetDefaultThemeEndingLogoImageFilePath();

    private native String nativeGetDefaultVideoTransitionName();

    private native int nativeGetExposureCompensation();

    private native SdkVersion nativeGetSdkVersion();

    private static native int nativeGetStatisticsFrequency();

    private native int nativeGetStreamingEngineState();

    private native long nativeGetTimelineCurrentPosition(NvsTimeline nvsTimeline);

    private native NvsFxDescription nativeGetVideoFxDescription(String str);

    private native int nativeGetVideoStabilization();

    private native int nativeGetZoom();

    private native Bitmap nativeGrabImageFromTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, NvsRational nvsRational, int OplusGLSurfaceView_13);

    private static native int nativeHasARModule();

    private static native boolean nativeInit(String str, int OplusGLSurfaceView_13);

    private static native boolean nativeInitHumanDetection(Context context, String str, String str2, int OplusGLSurfaceView_13);

    private static native boolean nativeInitJNI(Context context);

    private native NvsCaptureVideoFx nativeInsertBuiltinCaptureVideoFx(String str, int OplusGLSurfaceView_13);

    private native NvsCaptureVideoFx nativeInsertCustomCaptureVideoFx(NvsCustomVideoFx.Renderer renderer, int OplusGLSurfaceView_13);

    private native NvsCaptureVideoFx nativeInsertPackagedCaptureVideoFx(String str, int OplusGLSurfaceView_13);

    private native boolean nativeIsCaptureDeviceBackFacing(int OplusGLSurfaceView_13);

    private native boolean nativeIsCompilingPaused();

    private native boolean nativeIsDefaultCaptionFade();

    private native boolean nativeIsFlashOn();

    private static native boolean nativeIsNeedCheckExpiration();

    private native boolean nativeIsPlaybackPaused();

    private native boolean nativeIsRecordingPaused();

    private native boolean nativeIsSdkAuthorised();

    private static native boolean nativeIsStatisticsPrivateInfo();

    private native boolean nativePauseResumeCompiling(boolean z);

    private native boolean nativePauseResumePlayback(boolean z);

    private native boolean nativePauseResumeRecording(boolean z);

    private native boolean nativePlaybackTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13, boolean z, int i2);

    private native boolean nativePlaybackTimelineWithProxyScale(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, long j2, NvsRational nvsRational, boolean z, int OplusGLSurfaceView_13);

    private native String nativeRegisterFontByFilePath(String str);

    private native void nativeRemoveAllCaptureVideoFx();

    private native boolean nativeRemoveCaptureVideoFx(int OplusGLSurfaceView_13);

    private native void nativeRemoveCurrentCaptureScene();

    private native boolean nativeRemoveTimeline(NvsTimeline nvsTimeline);

    private native NvsColor nativeSampleColorFromCapturedVideoFrame(RectF rectF);

    private native boolean nativeSeekTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    private native boolean nativeSeekTimelineWithProxyScale(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, NvsRational nvsRational, int OplusGLSurfaceView_13);

    private native boolean nativeSendBufferToCapturePreview(byte[] bArr, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private static native void nativeSetAssetManager(AssetManager assetManager);

    private native void nativeSetAudioOutputDeviceVolume(float COUIBaseListPopupWindow_12);

    private native void nativeSetAutoExposureRect(RectF rectF);

    private static native void nativeSetCaptureDeviceCallback(CaptureDeviceCallback captureDeviceCallback);

    private static native void nativeSetCaptureRecordingDurationCallback(CaptureRecordingDurationCallback captureRecordingDurationCallback);

    private static native void nativeSetCaptureRecordingStartedCallback(CaptureRecordingStartedCallback captureRecordingStartedCallback);

    private static native void nativeSetCapturedVideoFrameGrabberCallback(CapturedVideoFrameGrabberCallback capturedVideoFrameGrabberCallback);

    private native void nativeSetCompileCallback(CompileCallback compileCallback);

    private native void nativeSetCompileCallback2(CompileCallback2 compileCallback2);

    private native void nativeSetCompileFloatProgressCallback(CompileFloatProgressCallback compileFloatProgressCallback);

    private native void nativeSetCustomCompileVideoHeight(int OplusGLSurfaceView_13);

    private static native void nativeSetDebugLevel(int OplusGLSurfaceView_13);

    private native void nativeSetDefaultCaptionFade(boolean z);

    private native boolean nativeSetDefaultThemeEndingLogoImageFilePath(String str);

    private native void nativeSetExposureCompensation(int OplusGLSurfaceView_13);

    private native void nativeSetHDRLutFilePath(String str, boolean z);

    private native void nativeSetHardwareErrorCallback(HardwareErrorCallback hardwareErrorCallback);

    private static native void nativeSetIconSize(int OplusGLSurfaceView_13);

    private static native void nativeSetLogFilePath(String str);

    private static native void nativeSetMaxIconReader(int OplusGLSurfaceView_13);

    private static native void nativeSetMaxReaderCount(int OplusGLSurfaceView_13);

    private native void nativeSetMediaCodecIconReaderEnabled(String str, boolean z);

    private native void nativeSetMediaCodecVideoDecodingOperatingRate(String str, int OplusGLSurfaceView_13);

    private native void nativeSetMediaFileActualDuration(String str, long OplusGLSurfaceView_15);

    private native void nativeSetPlaybackCallback(PlaybackCallback playbackCallback);

    private native void nativeSetPlaybackCallback2(PlaybackCallback2 playbackCallback2);

    private native void nativeSetPlaybackDelayCallback(PlaybackDelayCallback playbackDelayCallback);

    private native void nativeSetPlaybackExceptionCallback(PlaybackExceptionCallback playbackExceptionCallback);

    private static native void nativeSetSaveDebugMessagesToFile(boolean z);

    private native void nativeSetSeekingCallback(SeekingCallback seekingCallback);

    private native void nativeSetStreamingEngineCallback(StreamingEngineCallback streamingEngineCallback);

    private native void nativeSetStreamingEngineCallback2(StreamingEngineCallback2 streamingEngineCallback2);

    private native boolean nativeSetThemeEndingEnabled(boolean z);

    private native void nativeSetUserWatermarkForCapture(String str, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, int i3, int i4, int i5);

    private native void nativeSetVideoStabilization(int OplusGLSurfaceView_13);

    private native void nativeSetZoom(int OplusGLSurfaceView_13);

    private static native boolean nativeSetupHumanDetectionData(int OplusGLSurfaceView_13, String str);

    private native void nativeStartAutoFocus(RectF rectF);

    private native boolean nativeStartBufferCapturePreview(int OplusGLSurfaceView_13, int i2, NvsRational nvsRational, int i3, boolean z);

    private native boolean nativeStartCapturePreview(int OplusGLSurfaceView_13, int i2, int i3, NvsRational nvsRational);

    private native void nativeStartContinuousFocus();

    private native boolean nativeStartDualBufferCapturePreview(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z, int i6, NvsRational nvsRational, int i7, NvAndroidVirtualCameraSurfaceTexture nvAndroidVirtualCameraSurfaceTexture);

    private native boolean nativeStartRecording(String str, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2, int i3);

    private native void nativeStop(int OplusGLSurfaceView_13);

    private native void nativeStopRecording();

    private native void nativeToggleFlash(boolean z);

    private static native VerifyLicenseResult nativeVerifySdkLicenseFile(Context context, String str, boolean z);

    public boolean startCapturePreviewForLiveStreaming(int OplusGLSurfaceView_13, int i2, int i3, NvsRational nvsRational, String str) {
        return false;
    }

    public static void setNativeLibraryDirPath(String str) {
        NvsUtils.checkFunctionInMainThread();
        m_nativeLibraryDirPath = str + "/";
        if (str != null) {
            m_customNativeLibraryDirPath = true;
        }
    }

    public static void setLoadPluginFromAssets(boolean z) {
        NvsUtils.checkFunctionInMainThread();
    }

    public static void setPluginDirPath(String str) {
        NvsUtils.checkFunctionInMainThread();
    }

    public static void setDebugLevel(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 == m_debugLevel) {
            return;
        }
        m_debugLevel = OplusGLSurfaceView_13;
        if (m_instance != null) {
            nativeSetDebugLevel(m_debugLevel);
        }
    }

    public static void setSaveDebugMessagesToFile(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        if (z == m_saveDebugMessagesToFile) {
            return;
        }
        m_saveDebugMessagesToFile = z;
        if (m_instance != null) {
            nativeSetSaveDebugMessagesToFile(m_saveDebugMessagesToFile);
        }
    }

    public static void setLogFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
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
        File file = new File(str);
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

    public static Context getContext() {
        NvsUtils.checkFunctionInMainThread();
        return m_context;
    }

    public static ClassLoader getClassLoader() {
        NvsUtils.checkFunctionInMainThread();
        return m_classLoader;
    }

    public boolean isSdkAuthorised() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsSdkAuthorised();
    }

    public static NvsStreamingContext init(Context context, String str, int OplusGLSurfaceView_13) throws Exception {
        boolean z;
        NvsUtils.checkFunctionInMainThread();
        NvsStreamingContext nvsStreamingContext = m_instance;
        if (nvsStreamingContext != null) {
            return nvsStreamingContext;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (m_nativeLibraryDirPath == null) {
            m_nativeLibraryDirPath = applicationInfo.nativeLibraryDir + "/";
        }
        String str2 = ("HOME=" + context.getFilesDir().getAbsolutePath()) + "\tTMPDIR=" + context.getFilesDir().getAbsolutePath();
        try {
            m_assetManager = context.getAssets();
            m_context = context.getApplicationContext();
            m_classLoader = m_context.getClassLoader();
            if (!m_initializedOnce) {
                try {
                    Class.forName("com.meicam.sdk.NvsLazyLoadingIndicator");
                    z = true;
                } catch (Exception unused) {
                    z = false;
                }
                if (!z) {
                    tryLoadFaceDetectionLibrary();
                }
                loadNativeLibrary("NvStreamingSdkCore");
            }
            if (!nativeInitJNI(m_context)) {
                throw new Exception("nativeInitJNI() failed!");
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
            boolean z2 = NvsSystemVariableManager.getSystemVariableInt(context, "isExpired") == 1;
            new VerifyLicenseResult();
            if (!m_initializedOnce) {
                nativeVerifySdkLicenseFile(context, str, z2);
            }
            if (!nativeInit(str2, OplusGLSurfaceView_13)) {
                return null;
            }
            if (m_logFilePath != null) {
                nativeSetLogFilePath(m_logFilePath);
            }
            m_instance = new NvsStreamingContext(context, true);
            m_initializedOnce = true;
            if (m_instance.isSdkAuthorised() && nativeIsNeedCheckExpiration()) {
                new NvsStatisticsSender(context).sendStatistics(nativeGetStatisticsFrequency(), nativeIsStatisticsPrivateInfo());
            }
            return m_instance;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            m_context = null;
            m_classLoader = null;
            m_assetManager = null;
            return null;
        }
    }

    public static NvsStreamingContext init(Activity activity, String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return init((Context) activity, str, OplusGLSurfaceView_13);
    }

    public static NvsStreamingContext init(Activity activity, String str) {
        NvsUtils.checkFunctionInMainThread();
        return init(activity, str, 0);
    }

    public static void close() {
        NvsUtils.checkFunctionInMainThread();
        NvsStreamingContext nvsStreamingContext = m_instance;
        if (nvsStreamingContext == null) {
            return;
        }
        NvsAssetPackageManager assetPackageManager = nvsStreamingContext.getAssetPackageManager();
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

    public static NvsStreamingContext getInstance() {
        NvsUtils.checkFunctionInMainThread();
        return m_instance;
    }

    public static boolean initHumanDetection(Context context, String str, String str2, int OplusGLSurfaceView_13) throws ClassNotFoundException {
        tryLoadFaceDetectionLibrary();
        if (m_faceDetectionLibLoaded) {
            return nativeInitHumanDetection(context, str, str2, OplusGLSurfaceView_13);
        }
        return false;
    }

    public static boolean setupHumanDetectionData(int OplusGLSurfaceView_13, String str) {
        return nativeSetupHumanDetectionData(OplusGLSurfaceView_13, str);
    }

    public static void closeHumanDetection() {
        nativeCloseHumanDetection();
    }

    public static int hasARModule() {
        NvsUtils.checkFunctionInMainThread();
        return nativeHasARModule();
    }

    public float detectEngineRenderFramePerSecond() {
        NvsUtils.checkFunctionInMainThread();
        return nativeDetectEngineRenderFramePerSecond();
    }

    private NvsStreamingContext(Context context, boolean z) {
        this.m_assetPackageManager = null;
        if (z) {
            this.m_assetPackageManager = new NvsAssetPackageManager(false);
            this.m_assetPackageManager.setInternalObject(nativeGetAssetPackageManager());
            nativeDetectPackageName(context);
        }
    }

    public SdkVersion getSdkVersion() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetSdkVersion();
    }

    public NvsAssetPackageManager getAssetPackageManager() {
        if (this.m_isAuxiliaryContext) {
            NvsStreamingContext nvsStreamingContext = getInstance();
            if (nvsStreamingContext == null) {
                return null;
            }
            return nvsStreamingContext.getAssetPackageManager();
        }
        NvsUtils.checkFunctionInMainThread();
        return this.m_assetPackageManager;
    }

    public void setCaptureDeviceCallback(CaptureDeviceCallback captureDeviceCallback) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_catpureDeviceCallback = captureDeviceCallback;
        nativeSetCaptureDeviceCallback(captureDeviceCallback);
    }

    public void setCapturedVideoFrameGrabberCallback(CapturedVideoFrameGrabberCallback capturedVideoFrameGrabberCallback) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_catpuredVideoFrameGrabberCallback = capturedVideoFrameGrabberCallback;
        nativeSetCapturedVideoFrameGrabberCallback(capturedVideoFrameGrabberCallback);
    }

    public void setCaptureRecordingStartedCallback(CaptureRecordingStartedCallback captureRecordingStartedCallback) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_captureRecordingStartedCallback = captureRecordingStartedCallback;
        nativeSetCaptureRecordingStartedCallback(captureRecordingStartedCallback);
    }

    public void setCaptureRecordingDurationCallback(CaptureRecordingDurationCallback captureRecordingDurationCallback) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_captureRecordingDurationCallback = captureRecordingDurationCallback;
        nativeSetCaptureRecordingDurationCallback(captureRecordingDurationCallback);
    }

    public void setPlaybackCallback(PlaybackCallback playbackCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackCallback = playbackCallback;
        nativeSetPlaybackCallback(playbackCallback);
    }

    public void setCompileCallback(CompileCallback compileCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileCallback = compileCallback;
        nativeSetCompileCallback(compileCallback);
    }

    public void setStreamingEngineCallback(StreamingEngineCallback streamingEngineCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_streamingEngineCallback = streamingEngineCallback;
        nativeSetStreamingEngineCallback(streamingEngineCallback);
    }

    public void setStreamingEngineCallback2(StreamingEngineCallback2 streamingEngineCallback2) {
        NvsUtils.checkFunctionInMainThread();
        this.m_streamingEngineCallback2 = streamingEngineCallback2;
        nativeSetStreamingEngineCallback2(streamingEngineCallback2);
    }

    public void setTimelineTimestampCallback(TimelineTimestampCallback timelineTimestampCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_timelineTimestampCallback = timelineTimestampCallback;
    }

    public void setCompileCallback2(CompileCallback2 compileCallback2) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileCallback2 = compileCallback2;
        nativeSetCompileCallback2(compileCallback2);
    }

    public void setCompileFloatProgressCallback(CompileFloatProgressCallback compileFloatProgressCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileFloatProgressCallback = compileFloatProgressCallback;
        nativeSetCompileFloatProgressCallback(compileFloatProgressCallback);
    }

    public void setPlaybackCallback2(PlaybackCallback2 playbackCallback2) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackCallback2 = playbackCallback2;
        nativeSetPlaybackCallback2(playbackCallback2);
    }

    public void setPlaybackDelayCallback(PlaybackDelayCallback playbackDelayCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackDelayCallback = playbackDelayCallback;
        nativeSetPlaybackDelayCallback(playbackDelayCallback);
    }

    public void setPlaybackExceptionCallback(PlaybackExceptionCallback playbackExceptionCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackExceptionCallback = playbackExceptionCallback;
        nativeSetPlaybackExceptionCallback(playbackExceptionCallback);
    }

    public void setSeekingCallback(SeekingCallback seekingCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_seekingCallback = seekingCallback;
        nativeSetSeekingCallback(seekingCallback);
    }

    public void setHardwareErrorCallback(HardwareErrorCallback hardwareErrorCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_hardwareErrorCallback = hardwareErrorCallback;
        nativeSetHardwareErrorCallback(hardwareErrorCallback);
    }

    public NvsAVFileInfo getAVFileInfo(String str) {
        return nativeGetAVFileInfo(str, 0);
    }

    public NvsAVFileInfo getAVFileInfo(String str, int OplusGLSurfaceView_13) {
        return nativeGetAVFileInfo(str, OplusGLSurfaceView_13);
    }

    public static NvsAVFileInfo getAVInfoFromFile(String str, int OplusGLSurfaceView_13) {
        return nativeGetAVInfoFromFile(str, OplusGLSurfaceView_13);
    }

    public int detectVideoFileKeyframeInterval(String str) {
        return nativeDetectVideoFileKeyframeInterval(str);
    }

    public boolean canDecodeVideoStreamBySoftware(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeCanDecodeVideoStreamBySoftware(str);
    }

    public static boolean functionalityAuthorised(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeFunctionalityAuthorised(str);
    }

    public boolean setDefaultThemeEndingLogoImageFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSetDefaultThemeEndingLogoImageFilePath(str);
    }

    public String getDefaultThemeEndingLogoImageFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDefaultThemeEndingLogoImageFilePath();
    }

    public String registerFontByFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRegisterFontByFilePath(str);
    }

    public boolean setThemeEndingEnabled(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSetThemeEndingEnabled(z);
    }

    public NvsTimeline createTimeline(NvsVideoResolution nvsVideoResolution, NvsRational nvsRational, NvsAudioResolution nvsAudioResolution) {
        NvsUtils.checkFunctionInMainThread();
        return nativeCreateTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
    }

    public boolean removeTimeline(NvsTimeline nvsTimeline) {
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveTimeline(nvsTimeline);
    }

    public int getStreamingEngineState() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetStreamingEngineState();
    }

    public long getTimelineCurrentPosition(NvsTimeline nvsTimeline) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTimelineCurrentPosition(nvsTimeline);
    }

    public boolean compileTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, long j2, String str, int OplusGLSurfaceView_13, int i2, int i3) {
        NvsUtils.checkFunctionInMainThread();
        return nativeCompileTimeline(nvsTimeline, OplusGLSurfaceView_15, j2, str, OplusGLSurfaceView_13, i2, this.m_compileVideoBitrateMultiplier, this.m_compileConfigurations, i3);
    }

    public boolean pauseCompiling() {
        NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeCompiling(true);
    }

    public boolean resumeCompiling() {
        NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeCompiling(false);
    }

    public boolean isCompilingPaused() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsCompilingPaused();
    }

    public void setCustomCompileVideoHeight(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetCustomCompileVideoHeight(OplusGLSurfaceView_13);
    }

    public int getCustomCompileVideoHeight() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCustomCompileVideoHeight();
    }

    public boolean connectTimelineWithLiveWindow(NvsTimeline nvsTimeline, NvsLiveWindow nvsLiveWindow) {
        NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindow);
    }

    public boolean connectTimelineWithLiveWindowExt(NvsTimeline nvsTimeline, NvsLiveWindowExt nvsLiveWindowExt) {
        NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindowExt);
    }

    public boolean connectTimelineWithSurfaceTexture(NvsTimeline nvsTimeline, SurfaceTexture surfaceTexture) {
        NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithSurfaceTexture(nvsTimeline, surfaceTexture, new NvsRational(1, 1));
    }

    public boolean connectTimelineWithSurfaceTexture(NvsTimeline nvsTimeline, SurfaceTexture surfaceTexture, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return nativeConnectTimelineWithSurfaceTexture(nvsTimeline, surfaceTexture, nvsRational);
    }

    public boolean seekTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) {
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (OplusGLSurfaceView_15 < 0 || OplusGLSurfaceView_15 >= nvsTimeline.getDuration()) {
            TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativeSeekTimeline(nvsTimeline, OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2);
    }

    public boolean seekTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, NvsRational nvsRational, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (OplusGLSurfaceView_15 < 0 || OplusGLSurfaceView_15 >= nvsTimeline.getDuration()) {
            TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativeSeekTimelineWithProxyScale(nvsTimeline, OplusGLSurfaceView_15, nvsRational, OplusGLSurfaceView_13);
    }

    public Bitmap grabImageFromTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGrabImageFromTimeline(nvsTimeline, OplusGLSurfaceView_15, nvsRational, 0);
    }

    public Bitmap grabImageFromTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, NvsRational nvsRational, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGrabImageFromTimeline(nvsTimeline, OplusGLSurfaceView_15, nvsRational, OplusGLSurfaceView_13);
    }

    public boolean playbackTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13, boolean z, int i2) {
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (OplusGLSurfaceView_15 < 0 || OplusGLSurfaceView_15 >= nvsTimeline.getDuration() || (j2 >= 0 && OplusGLSurfaceView_15 >= j2)) {
            TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativePlaybackTimeline(nvsTimeline, OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13, z, i2);
    }

    public boolean playbackTimeline(NvsTimeline nvsTimeline, long OplusGLSurfaceView_15, long j2, NvsRational nvsRational, boolean z, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        if (OplusGLSurfaceView_15 < 0 || OplusGLSurfaceView_15 >= nvsTimeline.getDuration() || (j2 >= 0 && OplusGLSurfaceView_15 >= j2)) {
            TimelineTimestampCallback timelineTimestampCallback = this.m_timelineTimestampCallback;
            if (timelineTimestampCallback != null) {
                timelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
            }
            return false;
        }
        return nativePlaybackTimelineWithProxyScale(nvsTimeline, OplusGLSurfaceView_15, j2, nvsRational, z, OplusGLSurfaceView_13);
    }

    public boolean pausePlayback() {
        NvsUtils.checkFunctionInMainThread();
        return nativePauseResumePlayback(true);
    }

    public boolean resumePlayback() {
        NvsUtils.checkFunctionInMainThread();
        return nativePauseResumePlayback(false);
    }

    public boolean isPlaybackPaused() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsPlaybackPaused();
    }

    public void stop() {
        NvsUtils.checkFunctionInMainThread();
        nativeStop(0);
    }

    public void stop(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeStop(OplusGLSurfaceView_13);
    }

    public void clearCachedResources(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeClearCachedResources(z);
    }

    public void clearCachedResources(boolean z, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeClearCachedResourcesFlags(z, OplusGLSurfaceView_13);
    }

    public int getCaptureDeviceCount() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureDeviceCount();
    }

    public boolean isCaptureDeviceBackFacing(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeIsCaptureDeviceBackFacing(OplusGLSurfaceView_13);
    }

    public CaptureDeviceCapability getCaptureDeviceCapability(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureDeviceCapability(OplusGLSurfaceView_13);
    }

    /* renamed from: checkDontSetCameraParamOnRecordingWithSystemRecorder */
    public boolean m8733xefd67166() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return m8732x40c3681d();
    }

    public boolean connectCapturePreviewWithLiveWindow(NvsLiveWindow nvsLiveWindow) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeConnectCapturePreviewWithLiveWindow(nvsLiveWindow);
    }

    public boolean connectCapturePreviewWithLiveWindowExt(NvsLiveWindowExt nvsLiveWindowExt) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeConnectCapturePreviewWithLiveWindow(nvsLiveWindowExt);
    }

    public boolean connectCapturePreviewWithSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeConnectCapturePreviewWithSurfaceTexture(surfaceTexture);
    }

    public void setUserWatermarkForCapture(String str, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, int i3, int i4, int i5) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeSetUserWatermarkForCapture(str, OplusGLSurfaceView_13, i2, COUIBaseListPopupWindow_12, i3, i4, i5);
        }
    }

    public void removeUserWatermarkForCapture() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeSetUserWatermarkForCapture(null, 0, 0, 0.0f, 0, 0, 0);
        }
    }

    public boolean startCapturePreview(int OplusGLSurfaceView_13, int i2, int i3, NvsRational nvsRational) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        if (checkCameraPermission()) {
            return nativeStartCapturePreview(OplusGLSurfaceView_13, i2, i3, nvsRational);
        }
        return false;
    }

    public boolean startBufferCapturePreview(int OplusGLSurfaceView_13, int i2, NvsRational nvsRational, int i3, boolean z) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeStartBufferCapturePreview(OplusGLSurfaceView_13, i2, nvsRational, i3, z);
    }

    public boolean startDualBufferCapturePreview(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z, int i6, NvsRational nvsRational, int i7) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        if (surfaceTexture == null) {
            return false;
        }
        NvAndroidVirtualCameraSurfaceTexture nvAndroidVirtualCameraSurfaceTexture = new NvAndroidVirtualCameraSurfaceTexture(surfaceTexture);
        if (nativeStartDualBufferCapturePreview(OplusGLSurfaceView_13, i2, i3, i4, i5, z, i6, nvsRational, i7, nvAndroidVirtualCameraSurfaceTexture)) {
            return true;
        }
        nvAndroidVirtualCameraSurfaceTexture.release();
        return false;
    }

    public boolean sendBufferToCapturePreview(byte[] bArr, long OplusGLSurfaceView_15) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        return sendBufferToCapturePreview(bArr, OplusGLSurfaceView_15, 0);
    }

    public boolean sendBufferToCapturePreview(byte[] bArr, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        return nativeSendBufferToCapturePreview(bArr, OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    public NvsSize getCapturePreviewVideoSize(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return new NvsSize(0, 0);
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCapturePreviewVideoSize(OplusGLSurfaceView_13);
    }

    public NvsColor sampleColorFromCapturedVideoFrame(RectF rectF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeSampleColorFromCapturedVideoFrame(rectF);
    }

    public void startAutoFocus(RectF rectF) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeStartAutoFocus(rectF);
        }
    }

    public void cancelAutoFocus() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeCancelAutoFocus();
        }
    }

    public void StartContinuousFocus() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeStartContinuousFocus();
        }
    }

    public void setAutoExposureRect(RectF rectF) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeSetAutoExposureRect(rectF);
        }
    }

    public void setZoom(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeSetZoom(OplusGLSurfaceView_13);
        }
    }

    public int getZoom() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return 1;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetZoom();
    }

    public void toggleFlash(boolean z) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeToggleFlash(z);
        }
    }

    public boolean isFlashOn() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeIsFlashOn();
    }

    public int getVideoStabilization() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoStabilization();
    }

    public void setVideoStabilization(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeSetVideoStabilization(OplusGLSurfaceView_13);
        }
    }

    public void setExposureCompensation(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeSetExposureCompensation(OplusGLSurfaceView_13);
        }
    }

    public int getExposureCompensation() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetExposureCompensation();
    }

    public NvsCaptureVideoFx appendBuiltinCaptureVideoFx(String str) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return insertBuiltinCaptureVideoFx(str, getCaptureVideoFxCount());
    }

    public NvsCaptureVideoFx insertBuiltinCaptureVideoFx(String str, int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertBuiltinCaptureVideoFx(str, OplusGLSurfaceView_13);
    }

    public NvsCaptureVideoFx appendPackagedCaptureVideoFx(String str) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return insertPackagedCaptureVideoFx(str, getCaptureVideoFxCount());
    }

    public NvsCaptureVideoFx insertPackagedCaptureVideoFx(String str, int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertPackagedCaptureVideoFx(str, OplusGLSurfaceView_13);
    }

    public NvsCaptureVideoFx appendCustomCaptureVideoFx(NvsCustomVideoFx.Renderer renderer) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomCaptureVideoFx(renderer, getCaptureVideoFxCount());
    }

    public NvsCaptureVideoFx insertCustomCaptureVideoFx(NvsCustomVideoFx.Renderer renderer, int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeInsertCustomCaptureVideoFx(renderer, OplusGLSurfaceView_13);
    }

    public NvsCaptureVideoFx appendBeautyCaptureVideoFx() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return insertBeautyCaptureVideoFx(getCaptureVideoFxCount());
    }

    public NvsCaptureVideoFx insertBeautyCaptureVideoFx(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return insertBuiltinCaptureVideoFx(getBeautyVideoFxName(), OplusGLSurfaceView_13);
    }

    public boolean removeCaptureVideoFx(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeRemoveCaptureVideoFx(OplusGLSurfaceView_13);
    }

    public void removeAllCaptureVideoFx() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeRemoveAllCaptureVideoFx();
        }
    }

    public int getCaptureVideoFxCount() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxCount();
    }

    public NvsCaptureVideoFx getCaptureVideoFxByIndex(int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptureVideoFxByIndex(OplusGLSurfaceView_13);
    }

    public boolean applyCaptureScene(String str) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeApplyCaptureScene(str);
    }

    public String getCurrentCaptureSceneId() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCurrentCaptureSceneId();
    }

    public void removeCurrentCaptureScene() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeRemoveCurrentCaptureScene();
        }
    }

    public void setCompileConfigurations(Hashtable<String, Object> hashtable) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileConfigurations = hashtable;
    }

    public Hashtable<String, Object> getCompileConfigurations() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_compileConfigurations;
    }

    public void setCompileVideoBitrateMultiplier(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            return;
        }
        this.m_compileVideoBitrateMultiplier = COUIBaseListPopupWindow_12;
    }

    public float getCompileVideoBitrateMultiplier() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_compileVideoBitrateMultiplier;
    }

    public void setRecordVideoBitrateMultiplier(float COUIBaseListPopupWindow_12) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            return;
        }
        this.m_recordVideoBitrateMultiplier = COUIBaseListPopupWindow_12;
    }

    public float getRecordVideoBitrateMultiplier() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return 1.0f;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.m_recordVideoBitrateMultiplier;
    }

    public boolean startRecording(String str) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeStartRecording(str, this.m_recordVideoBitrateMultiplier, 0, 0, 0);
    }

    public boolean startRecording(String str, int OplusGLSurfaceView_13) {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeStartRecording(str, this.m_recordVideoBitrateMultiplier, 0, 0, OplusGLSurfaceView_13);
    }

    public boolean startRecording(String str, int OplusGLSurfaceView_13, Hashtable<String, Object> hashtable) {
        int i2;
        int iIntValue;
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        if (hashtable != null) {
            Number number = (Number) hashtable.get("bitrate");
            int iIntValue2 = number != null ? number.intValue() : 0;
            Number number2 = (Number) hashtable.get("gopsize");
            i2 = iIntValue2;
            iIntValue = number2 != null ? number2.intValue() : 0;
        } else {
            i2 = 0;
            iIntValue = 0;
        }
        return nativeStartRecording(str, this.m_recordVideoBitrateMultiplier, i2, iIntValue, OplusGLSurfaceView_13);
    }

    public void stopRecording() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
        } else {
            NvsUtils.checkFunctionInMainThread();
            nativeStopRecording();
        }
    }

    public boolean pauseRecording() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeRecording(true);
    }

    public boolean resumeRecording() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativePauseResumeRecording(false);
    }

    public boolean isRecordingPaused() {
        if (this.m_isAuxiliaryContext) {
            Log.COUIBaseListPopupWindow_8(TAG, "The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return nativeIsRecordingPaused();
    }

    public List<String> getAllBuiltinVideoFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinVideoFxNames();
    }

    public List<String> getAllBuiltinAudioFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinAudioFxNames();
    }

    public List<String> getAllBuiltinVideoTransitionNames() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinVideoTransitionNames();
    }

    public List<String> getAllBuiltinCaptureVideoFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinCaptureVideoFxNames();
    }

    public String getBeautyVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBeautyVideoFxName();
    }

    public String getDefaultVideoTransitionName() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDefaultVideoTransitionName();
    }

    public NvsFxDescription getVideoFxDescription(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVideoFxDescription(str);
    }

    public NvsFxDescription getAudioFxDescription(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAudioFxDescription(str);
    }

    public NvsVideoFrameRetriever createVideoFrameRetriever(String str) {
        return new NvsVideoFrameRetriever(str, 0);
    }

    public NvsVideoFrameRetriever createVideoFrameRetriever(String str, int OplusGLSurfaceView_13) {
        return new NvsVideoFrameRetriever(str, OplusGLSurfaceView_13);
    }

    public NvsVideoKeyFrameRetriever createVideoKeyFrameRetriever(String str, int OplusGLSurfaceView_13, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        return new NvsVideoKeyFrameRetriever(str, OplusGLSurfaceView_13, z);
    }

    public void setDefaultCaptionFade(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetDefaultCaptionFade(z);
    }

    public boolean isDefaultCaptionFade() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsDefaultCaptionFade();
    }

    public void setAudioOutputDeviceVolume(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetAudioOutputDeviceVolume(COUIBaseListPopupWindow_12);
    }

    public NvsStreamingContext createAuxiliaryStreamingContext(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        Context context = m_context;
        if (context == null) {
            return null;
        }
        NvsStreamingContext nvsStreamingContext = new NvsStreamingContext(context, false);
        if (!nativeCreateAuxiliaryStreamingContext(nvsStreamingContext, OplusGLSurfaceView_13)) {
            return null;
        }
        nvsStreamingContext.m_isAuxiliaryContext = true;
        return nvsStreamingContext;
    }

    public void destoryAuxiliaryStreamingContext(NvsStreamingContext nvsStreamingContext) {
        if (nvsStreamingContext == null) {
            return;
        }
        nativeDestoryAuxiliaryStreamingContext(nvsStreamingContext);
    }

    public static void setMaxReaderCount(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        m_maxReaderCount = OplusGLSurfaceView_13;
    }

    public static void setIconSize(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        m_iconSize = OplusGLSurfaceView_13;
    }

    public static void setMaxIconReader(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        m_maxIconReader = OplusGLSurfaceView_13;
    }

    public void enableGetAVFileInfoFromMediaExtractor(String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeEnableGetAVFileInfoFromMediaExtractor(str);
    }

    public void setMediaFileActualDuration(String str, long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetMediaFileActualDuration(str, OplusGLSurfaceView_15);
    }

    public void setMediaCodecVideoDecodingOperatingRate(String str, int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetMediaCodecVideoDecodingOperatingRate(str, OplusGLSurfaceView_13);
    }

    public void setMediaCodecIconReaderEnabled(String str, boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetMediaCodecIconReaderEnabled(str, z);
    }

    public int getAudioStreamCountInMediaFile(String str) {
        return nativeGetAudioStreamCountInMediaFile(str);
    }

    public void setHDRLutFilePath(String str, boolean z) {
        nativeSetHDRLutFilePath(str, z);
    }

    protected void setInternalObject(long OplusGLSurfaceView_15) {
        this.m_internalObject = OplusGLSurfaceView_15;
    }

    protected long getInternalObject() {
        return this.m_internalObject;
    }

    protected boolean isAuxiliaryContext() {
        return this.m_isAuxiliaryContext;
    }

    private boolean checkCameraPermission() {
        if (Build.VERSION.SDK_INT < 23 || m_context.checkSelfPermission("android.permission.CAMERA") == 0) {
            return true;
        }
        Log.COUIBaseListPopupWindow_8(TAG, "CAMERA permission has not been granted!");
        return false;
    }

    private boolean checkInternetPermission() {
        if (Build.VERSION.SDK_INT < 23 || m_context.checkSelfPermission("android.permission.INTERNET") == 0) {
            return true;
        }
        Log.COUIBaseListPopupWindow_8(TAG, "INTERNET permission has not been granted!");
        return false;
    }

    private static void loadNativeLibrary(String str) throws SecurityException, UnsatisfiedLinkError, NullPointerException {
        if (!m_customNativeLibraryDirPath) {
            System.loadLibrary(str);
            return;
        }
        System.load(m_nativeLibraryDirPath + "lib" + str + ".so");
    }

    private static boolean tryLoadNativeLibrary(String str) throws SecurityException, UnsatisfiedLinkError, NullPointerException {
        if (!m_customNativeLibraryDirPath) {
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        try {
            System.load(m_nativeLibraryDirPath + "lib" + str + ".so");
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static void tryLoadFaceDetectionLibrary() throws ClassNotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (m_faceDetectionLibLoaded) {
            return;
        }
        boolean z5 = false;
        try {
            Class.forName("com.meicam.sdk.NvsBEFFaceEffectDetector");
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (!z || tryLoadNativeLibrary("effect")) {
            try {
                Class.forName("com.meicam.sdk.NvsMGFaceEffectDetector");
                z2 = true;
            } catch (Exception unused2) {
                z2 = false;
            }
            if (!z2 || (tryLoadNativeLibrary("megface-new") && tryLoadNativeLibrary("MegviiFacepp"))) {
                try {
                    Class.forName("com.meicam.sdk.NvsSTFaceEffectDetector");
                    z3 = true;
                } catch (Exception unused3) {
                    z3 = false;
                }
                if (!z3 || tryLoadNativeLibrary("st_mobile")) {
                    try {
                        Class.forName("com.meicam.sdk.NvsFaceEffectV1Detector");
                        z4 = true;
                    } catch (Exception unused4) {
                        z4 = false;
                    }
                    if (!z4 || tryLoadNativeLibrary("nama")) {
                        try {
                            Class.forName("com.meicam.sdk.NvsFaceEffect2Init");
                            z5 = true;
                        } catch (Exception unused5) {
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
