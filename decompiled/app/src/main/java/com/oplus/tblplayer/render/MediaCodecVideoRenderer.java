package com.oplus.tblplayer.render;

@android.annotation.TargetApi(16)
/* loaded from: classes2.dex */
public class MediaCodecVideoRenderer extends com.google.android.exoplayer2.mediacodec.MediaCodecRenderer {
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final java.lang.String KEY_CROP_BOTTOM = "crop-bottom";
    private static final java.lang.String KEY_CROP_LEFT = "crop-left";
    private static final java.lang.String KEY_CROP_RIGHT = "crop-right";
    private static final java.lang.String KEY_CROP_TOP = "crop-top";
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, 1600, 1440, com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960, 854, 640, 540, com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480};
    private static final java.lang.String TAG = "MediaCodecVideoRenderer";
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private long codecInitializedTimestampMs;
    private com.oplus.tblplayer.render.MediaCodecVideoRenderer.CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final android.content.Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private android.view.Surface dummySurface;
    private final com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher;
    private long fastRendererTimeUs;
    private com.google.android.exoplayer2.video.VideoFrameMetadataListener frameMetadataListener;
    private final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastInputTimeUs;
    private long lastPresentTimeUs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private java.util.HashMap<java.lang.String, java.lang.Integer> mediaFormatAttr;
    private boolean needDropFrame;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private android.view.Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    com.oplus.tblplayer.render.MediaCodecVideoRenderer.OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    private static boolean isBufferLate(long j_renamed) {
        return j_renamed < -30000;
    }

    private static boolean isBufferVeryLate(long j_renamed) {
        return j_renamed < -500000;
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j_renamed) {
        this(context, mediaCodecSelector, j_renamed, null, null, -1);
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        this(context, mediaCodecSelector, j_renamed, null, false, handler, videoRendererEventListener, i_renamed);
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j_renamed, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        super(2, mediaCodecSelector, drmSessionManager, z_renamed, 30.0f);
        this.mediaFormatAttr = new java.util.HashMap<>();
        this.allowedJoiningTimeMs = j_renamed;
        this.maxDroppedFramesToNotify = i_renamed;
        this.context = context.getApplicationContext();
        this.frameReleaseTimeHelper = new com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper(this.context);
        this.eventDispatcher = new com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.codecInitializedTimestampMs = -9223372036854775807L;
        this.lastInputTimeUs = -9223372036854775807L;
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
        this.needDropFrame = false;
        this.lastPresentTimeUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        boolean z_renamed;
        if (!com.google.android.exoplayer2.util.MimeTypes.isVideo(format.sampleMimeType)) {
            return 0;
        }
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z_renamed = false;
            for (int i_renamed = 0; i_renamed < drmInitData.schemeDataCount; i_renamed++) {
                z_renamed |= drmInitData.get(i_renamed).requiresSecureDecryption;
            }
        } else {
            z_renamed = false;
        }
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(format.sampleMimeType, z_renamed);
        if (decoderInfos.isEmpty()) {
            return (!z_renamed || mediaCodecSelector.getDecoderInfos(format.sampleMimeType, false).isEmpty()) ? 1 : 2;
        }
        if (!supportsFormatDrm(drmSessionManager, drmInitData)) {
            return 2;
        }
        com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        return (mediaCodecInfo.isFormatSupported(format) ? 4 : 3) | (mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8) | (mediaCodecInfo.tunneling ? 32 : 0);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onEnabled(z_renamed);
        this.tunnelingAudioSessionId = getConfiguration().tunnelingAudioSessionId;
        this.tunneling = this.tunnelingAudioSessionId != 0;
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = j_renamed;
        } else {
            int i_renamed = this.pendingOutputStreamOffsetCount;
            if (i_renamed == this.pendingOutputStreamOffsetsUs.length) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount = i_renamed + 1;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            int i2 = this.pendingOutputStreamOffsetCount;
            jArr[i2 - 1] = j_renamed;
            this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.lastInputTimeUs;
        }
        super.onStreamChanged(formatArr, j_renamed);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected boolean getRenderedFirstFrame() {
        return this.renderedFirstFrame;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected long getLastPresentTimeUs() {
        return this.lastPresentTimeUs;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onPositionReset(j_renamed, z_renamed);
        clearRenderedFirstFrame();
        this.lastPresentTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        this.lastInputTimeUs = -9223372036854775807L;
        int i_renamed = this.pendingOutputStreamOffsetCount;
        if (i_renamed != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i_renamed - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z_renamed) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.lastPresentTimeUs >= j_renamed) {
            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "invalid positionUs:" + j_renamed + ",lastPresentTimeUs:" + this.lastPresentTimeUs);
            return;
        }
        this.needDropFrame = true;
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onSetFastRendererPosition(long j_renamed, boolean z_renamed) {
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "onSetFastRendererPosition positionUs:" + j_renamed + ", initialPositionUs:" + this.initialPositionUs);
        this.fastRendererTimeUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        android.view.Surface surface;
        if (super.isReady() && (this.renderedFirstFrame || (((surface = this.dummySurface) != null && this.surface == surface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (android.os.SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = android.os.SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = android.os.SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.codecInitializedTimestampMs = -9223372036854775807L;
        this.lastInputTimeUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        this.tunneling = false;
        this.mediaFormatAttr.clear();
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.InterruptedException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (i_renamed == 1) {
            setSurface((android.view.Surface) obj);
            return;
        }
        if (i_renamed == 4) {
            this.scalingMode = ((java.lang.Integer) obj).intValue();
            android.media.MediaCodec codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
                return;
            }
            return;
        }
        if (i_renamed == 6) {
            this.frameMetadataListener = (com.google.android.exoplayer2.video.VideoFrameMetadataListener) obj;
            return;
        }
        if (i_renamed == 10) {
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper videoFrameReleaseTimeHelper = this.frameReleaseTimeHelper;
            if (videoFrameReleaseTimeHelper != null) {
                videoFrameReleaseTimeHelper.setVsyncOffsetPercentage(((java.lang.Integer) obj).intValue());
                return;
            }
            return;
        }
        if (i_renamed == 11) {
            java.util.HashMap map = (java.util.HashMap) obj;
            if (this.mediaFormatAttr == null || map == null || map.isEmpty()) {
                return;
            }
            this.mediaFormatAttr.putAll(map);
            return;
        }
        super.handleMessage(i_renamed, obj);
    }

    private void setSurface(android.view.Surface surface) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.InterruptedException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (surface == null) {
            android.view.Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    this.dummySurface = com.google.android.exoplayer2.video.DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    surface = this.dummySurface;
                }
            }
        }
        if (this.surface != surface) {
            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "setSurface: " + surface);
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                android.media.MediaCodec codec = getCodec();
                if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23 && codec != null && surface != null && !this.codecNeedsSetOutputSurfaceWorkaround) {
                    if (this.codecInitializedTimestampMs != -9223372036854775807L && android.os.SystemClock.elapsedRealtime() - this.codecInitializedTimestampMs < 50) {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Set surface within 50ms after MediaCodec start, will delay 50ms.");
                        try {
                            java.lang.Thread.sleep(50L);
                        } catch (java.lang.InterruptedException unused) {
                            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Thread sleep is_renamed interrupted.");
                        }
                    }
                    setOutputSurfaceV23(codec, surface);
                } else {
                    releaseCodec();
                    maybeInitCodec();
                }
            }
            if (surface != null && surface != this.dummySurface) {
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (state == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        if (surface == null || surface == this.dummySurface) {
            return;
        }
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean getCodecNeedsEosPropagation() {
        return this.tunneling;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.Format format, android.media.MediaCrypto mediaCrypto, float f_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        this.codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        android.media.MediaFormat mediaFormat = getMediaFormat(format, this.codecMaxValues, f_renamed, this.deviceNeedsNoPostProcessWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            com.google.android.exoplayer2.util.Assertions.checkState(shouldUseDummySurface(mediaCodecInfo));
            if (this.dummySurface == null) {
                this.dummySurface = com.google.android.exoplayer2.video.DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        java.util.HashMap<java.lang.String, java.lang.Integer> map = this.mediaFormatAttr;
        if (map != null && !map.isEmpty()) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : this.mediaFormatAttr.entrySet()) {
                mediaFormat.setInteger(entry.getKey(), entry.getValue().intValue());
            }
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 || !this.tunneling) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new com.oplus.tblplayer.render.MediaCodecVideoRenderer.OnFrameRenderedListenerV23(mediaCodec);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int canKeepCodec(android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        if (!mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true) || format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height || getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 1 : 3;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void releaseCodec() {
        try {
            super.releaseCodec();
        } finally {
            this.buffersInCodecCount = 0;
            android.view.Surface surface = this.dummySurface;
            if (surface != null) {
                if (this.surface == surface) {
                    this.surface = null;
                }
                this.dummySurface.release();
                this.dummySurface = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void flushCodec() throws com.google.android.exoplayer2.ExoPlaybackException {
        super.flushCodec();
        this.buffersInCodecCount = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRate(float f_renamed, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        float fMax = -1.0f;
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            float f2 = format2.frameRate;
            if (f2 != -1.0f) {
                fMax = java.lang.Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f_renamed;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(java.lang.String str, long j_renamed, long j2) {
        this.codecInitializedTimestampMs = j_renamed;
        this.eventDispatcher.decoderInitialized(str, j_renamed, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        this.buffersInCodecCount++;
        this.lastInputTimeUs = java.lang.Math.max(decoderInputBuffer.timeUs, this.lastInputTimeUs);
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23 || !this.tunneling) {
            return;
        }
        onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z_renamed = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
        if (z_renamed) {
            integer = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        if (z_renamed) {
            integer2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        processOutputFormat(mediaCodec, integer, integer2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j_renamed, long j2, android.media.MediaCodec mediaCodec, java.nio.ByteBuffer byteBuffer, int i_renamed, int i2, long j3, boolean z_renamed, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.InterruptedException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        long j4;
        long j5;
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j_renamed;
        }
        if (j3 >= this.initialPositionUs) {
            this.needDropFrame = false;
        }
        this.lastPresentTimeUs = j3;
        long j6 = j3 - this.outputStreamOffsetUs;
        if (z_renamed || this.needDropFrame) {
            long j7 = this.fastRendererTimeUs;
            if (j7 == -9223372036854775807L || j7 > this.lastPresentTimeUs) {
                com.google.android.exoplayer2.util.Log.d_renamed(TAG, "needDropFrame:" + this.needDropFrame + ", preTimeUs:" + j6 + ",initTimeUs:" + this.initialPositionUs);
                skipOutputBuffer(mediaCodec, i_renamed, j6);
                return true;
            }
        }
        long j8 = j3 - j_renamed;
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(j8)) {
                return false;
            }
            skipOutputBuffer(mediaCodec, i_renamed, j6);
            return true;
        }
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
        boolean z2 = getState() == 2;
        if (!this.renderedFirstFrame || (z2 && shouldForceRenderOutputBuffer(j8, jElapsedRealtime - this.lastRenderTimeUs))) {
            long jNanoTime = java.lang.System.nanoTime();
            notifyFrameMetadataListener(j6, jNanoTime, format);
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                renderOutputBufferV21(mediaCodec, i_renamed, j6, jNanoTime);
                return true;
            }
            renderOutputBuffer(mediaCodec, i_renamed, j6);
            return true;
        }
        if (!z2 || j_renamed == this.initialPositionUs) {
            return false;
        }
        long jNanoTime2 = java.lang.System.nanoTime();
        long jAdjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j3, ((j8 - (jElapsedRealtime - j2)) * 1000) + jNanoTime2);
        long j9 = (jAdjustReleaseTime - jNanoTime2) / 1000;
        if (deviceNeedsMandatoryRenderWorkaround(format)) {
            j4 = jAdjustReleaseTime;
            j5 = j6;
        } else {
            if (shouldDropBuffersToKeyframe(j9, j2)) {
                j4 = jAdjustReleaseTime;
                j5 = j6;
                if (maybeDropBuffersToKeyframe(mediaCodec, i_renamed, j6, j_renamed)) {
                    return false;
                }
            } else {
                j4 = jAdjustReleaseTime;
                j5 = j6;
            }
            if (shouldDropOutputBuffer(j9, j2)) {
                dropOutputBuffer(mediaCodec, i_renamed, j5);
                return true;
            }
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            if (j9 >= 50000) {
                return false;
            }
            notifyFrameMetadataListener(j5, j4, format);
            renderOutputBufferV21(mediaCodec, i_renamed, j5, j4);
            return true;
        }
        if (j9 >= 30000) {
            return false;
        }
        if (j9 > 11000) {
            try {
                java.lang.Thread.sleep((j9 - 10000) / 1000);
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
                return false;
            }
        }
        notifyFrameMetadataListener(j5, j4, format);
        renderOutputBuffer(mediaCodec, i_renamed, j5);
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void renderToEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
        maybeNotifyRenderedFirstFrame();
    }

    private void processOutputFormat(android.media.MediaCodec mediaCodec, int i_renamed, int i2) {
        this.currentWidth = i_renamed;
        this.currentHeight = i2;
        this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            int i3 = this.pendingRotationDegrees;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i4;
                this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        mediaCodec.setVideoScalingMode(this.scalingMode);
    }

    private void notifyFrameMetadataListener(long j_renamed, long j2, com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j_renamed, j2, format);
        }
    }

    protected long getOutputStreamOffsetUs() {
        return this.outputStreamOffsetUs;
    }

    protected void onProcessedTunneledBuffer(long j_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.exoplayer2.Format formatUpdateOutputFormatForTime = updateOutputFormatForTime(j_renamed);
        if (formatUpdateOutputFormatForTime != null) {
            processOutputFormat(getCodec(), formatUpdateOutputFormatForTime.width, formatUpdateOutputFormatForTime.height);
        }
        maybeNotifyVideoSizeChanged();
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j_renamed);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long j_renamed) {
        this.buffersInCodecCount--;
        while (true) {
            int i_renamed = this.pendingOutputStreamOffsetCount;
            if (i_renamed == 0 || j_renamed < this.pendingOutputStreamSwitchTimesUs[0]) {
                return;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            this.outputStreamOffsetUs = jArr[0];
            this.pendingOutputStreamOffsetCount = i_renamed - 1;
            java.lang.System.arraycopy(jArr, 1, jArr, 0, this.pendingOutputStreamOffsetCount);
            long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
            java.lang.System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
        }
    }

    protected boolean shouldDropOutputBuffer(long j_renamed, long j2) {
        return isBufferLate(j_renamed);
    }

    protected boolean shouldDropBuffersToKeyframe(long j_renamed, long j2) {
        return isBufferVeryLate(j_renamed);
    }

    protected boolean shouldForceRenderOutputBuffer(long j_renamed, long j2) {
        return isBufferLate(j_renamed) && j2 > 100000;
    }

    protected void skipOutputBuffer(android.media.MediaCodec mediaCodec, int i_renamed, long j_renamed) {
        com.google.android.exoplayer2.util.TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i_renamed, false);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    protected void dropOutputBuffer(android.media.MediaCodec mediaCodec, int i_renamed, long j_renamed) {
        com.google.android.exoplayer2.util.TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i_renamed, false);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    protected boolean maybeDropBuffersToKeyframe(android.media.MediaCodec mediaCodec, int i_renamed, long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        int iSkipSource = skipSource(j2);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource);
        flushCodec();
        return true;
    }

    protected void updateDroppedBufferCounters(int i_renamed) {
        this.decoderCounters.droppedBufferCount += i_renamed;
        this.droppedFrames += i_renamed;
        this.consecutiveDroppedFrameCount += i_renamed;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = java.lang.Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 <= 0 || this.droppedFrames < i2) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    protected void renderOutputBuffer(android.media.MediaCodec mediaCodec, int i_renamed, long j_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        maybeNotifyVideoSizeChanged();
        com.google.android.exoplayer2.util.TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i_renamed, true);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        this.lastRenderTimeUs = android.os.SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    @android.annotation.TargetApi(21)
    protected void renderOutputBufferV21(android.media.MediaCodec mediaCodec, int i_renamed, long j_renamed, long j2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        maybeNotifyVideoSizeChanged();
        com.google.android.exoplayer2.util.TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i_renamed, j2);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        this.lastRenderTimeUs = android.os.SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUseDummySurface(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || com.google.android.exoplayer2.video.DummySurface.isSecureSupported(this.context));
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? android.os.SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        android.media.MediaCodec codec;
        this.renderedFirstFrame = false;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new com.oplus.tblplayer.render.MediaCodecVideoRenderer.OnFrameRenderedListenerV23(codec);
    }

    void maybeNotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            return;
        }
        this.renderedFirstFrame = true;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.eventDispatcher.renderedFirstFrame(this.surface);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.currentWidth == -1 && this.currentHeight == -1) {
            return;
        }
        if (this.reportedWidth == this.currentWidth && this.reportedHeight == this.currentHeight && this.reportedUnappliedRotationDegrees == this.currentUnappliedRotationDegrees && this.reportedPixelWidthHeightRatio == this.currentPixelWidthHeightRatio) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
        this.reportedWidth = this.currentWidth;
        this.reportedHeight = this.currentHeight;
        this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
        this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
    }

    private void maybeRenotifyVideoSizeChanged() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.reportedWidth == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    @android.annotation.TargetApi(23)
    private static void setOutputSurfaceV23(android.media.MediaCodec mediaCodec, android.view.Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @android.annotation.TargetApi(21)
    private static void configureTunnelingV21(android.media.MediaFormat mediaFormat, int i_renamed) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id_renamed", i_renamed);
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    protected android.media.MediaFormat getMediaFormat(com.google.android.exoplayer2.Format format, com.oplus.tblplayer.render.MediaCodecVideoRenderer.CodecMaxValues codecMaxValues, float f_renamed, boolean z_renamed, int i_renamed) {
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME, format.sampleMimeType);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetFloat(mediaFormat, com.oplus.tblplayer.misc.IMediaFormat.KEY_FRAME_RATE, format.frameRate);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
            mediaFormat.setInteger(com.heytap.accessory.constant.AFConstants.EXTRA_PRIORITY, 0);
            if (f_renamed != -1.0f) {
                mediaFormat.setFloat("operating-rate", f_renamed);
            }
        }
        if (z_renamed) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i_renamed != 0) {
            configureTunnelingV21(mediaFormat, i_renamed);
        }
        return mediaFormat;
    }

    protected com.oplus.tblplayer.render.MediaCodecVideoRenderer.CodecMaxValues getCodecMaxValues(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        int codecMaxInputSize;
        int i_renamed = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) != -1) {
                maxInputSize = java.lang.Math.min((int) (maxInputSize * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new com.oplus.tblplayer.render.MediaCodecVideoRenderer.CodecMaxValues(i_renamed, i2, maxInputSize);
        }
        int iMax = i2;
        int iMax2 = maxInputSize;
        boolean z_renamed = false;
        int iMax3 = i_renamed;
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                z_renamed |= format2.width == -1 || format2.height == -1;
                iMax3 = java.lang.Math.max(iMax3, format2.width);
                iMax = java.lang.Math.max(iMax, format2.height);
                iMax2 = java.lang.Math.max(iMax2, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z_renamed) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Resolutions unknown. Codec max resolution: " + iMax3 + "x_renamed" + iMax);
            android.graphics.Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                iMax3 = java.lang.Math.max(iMax3, codecMaxSize.x_renamed);
                iMax = java.lang.Math.max(iMax, codecMaxSize.y_renamed);
                iMax2 = java.lang.Math.max(iMax2, getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, iMax3, iMax));
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Codec max resolution adjusted to: " + iMax3 + "x_renamed" + iMax);
            }
        }
        return new com.oplus.tblplayer.render.MediaCodecVideoRenderer.CodecMaxValues(iMax3, iMax, iMax2);
    }

    private static android.graphics.Point getCodecMaxSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        boolean z_renamed = format.height > format.width;
        int i_renamed = z_renamed ? format.height : format.width;
        int i2 = z_renamed ? format.width : format.height;
        float f_renamed = i2 / i_renamed;
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (i3 * f_renamed);
            if (i3 <= i_renamed || i4 <= i2) {
                break;
            }
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                int i5 = z_renamed ? i4 : i3;
                if (!z_renamed) {
                    i3 = i4;
                }
                android.graphics.Point pointAlignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x_renamed, pointAlignVideoSizeV21.y_renamed, format.frameRate)) {
                    return pointAlignVideoSizeV21;
                }
            } else {
                int iCeilDivide = com.google.android.exoplayer2.util.Util.ceilDivide(i3, 16) * 16;
                int iCeilDivide2 = 16 * com.google.android.exoplayer2.util.Util.ceilDivide(i4, 16);
                if (iCeilDivide * iCeilDivide2 <= com.google.android.exoplayer2.mediacodec.MediaCodecUtil.maxH264DecodableFrameSize()) {
                    int i6 = z_renamed ? iCeilDivide2 : iCeilDivide;
                    if (z_renamed) {
                        iCeilDivide2 = iCeilDivide;
                    }
                    return new android.graphics.Point(i6, iCeilDivide2);
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int length = 0;
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                length += format.initializationData.get(i_renamed).length;
            }
            return format.maxInputSize + length;
        }
        return getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r7, java.lang.String r8, int r9, int r10) {
        /*
            r0 = -1
            if (r9 == r0) goto La3
            if (r10 != r0) goto L7
            goto La3
        L7:
            int r1 = r8.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L46;
                case -1662541442: goto L3c;
                case 1187890754: goto L32;
                case 1331836730: goto L28;
                case 1599127256: goto L1e;
                case 1599127257: goto L14;
                default: goto L13;
            }
        L13:
            goto L50
        L14:
            java.lang.String r1 = "video/x_renamed-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = r2
            goto L51
        L1e:
            java.lang.String r1 = "video/x_renamed-vnd.on2.vp8"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = r5
            goto L51
        L28:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = r6
            goto L51
        L32:
            java.lang.String r1 = "video/mp4v-es_renamed"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = r3
            goto L51
        L3c:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = r4
            goto L51
        L46:
            java.lang.String r1 = "video/3gpp"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 0
            goto L51
        L50:
            r8 = r0
        L51:
            if (r8 == 0) goto L9d
            if (r8 == r3) goto L9d
            if (r8 == r6) goto L60
            if (r8 == r5) goto L9d
            if (r8 == r4) goto L5e
            if (r8 == r2) goto L5e
            return r0
        L5e:
            int r9 = r9 * r10
            goto L9f
        L60:
            java.lang.String r8 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L9c
            java.lang.String r8 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            java.lang.String r1 = "Amazon"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L8d
            java.lang.String r8 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "KFSOWI"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L9c
            java.lang.String r8 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "AFTS"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L8d
            boolean r7 = r7.secure
            if (r7 == 0) goto L8d
            goto L9c
        L8d:
            r7 = 16
            int r8 = com.google.android.exoplayer2.util.Util.ceilDivide(r9, r7)
            int r9 = com.google.android.exoplayer2.util.Util.ceilDivide(r10, r7)
            int r8 = r8 * r9
            int r8 = r8 * r7
            int r9 = r8 * 16
            goto L9e
        L9c:
            return r0
        L9d:
            int r9 = r9 * r10
        L9e:
            r4 = r6
        L9f:
            int r9 = r9 * r5
            int r4 = r4 * r6
            int r9 = r9 / r4
            return r9
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.tblplayer.render.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean deviceNeedsMandatoryRenderWorkaround(com.google.android.exoplayer2.Format r5) {
        /*
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            int r1 = r0.hashCode()
            r2 = -1957777675(0xffffffff8b4eaef5, float:-3.980578E-32)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L1d
            r2 = 2048109623(0x7a13ac37, float:1.9169014E35)
            if (r1 == r2) goto L13
            goto L27
        L13:
            java.lang.String r1 = "RMX2040"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L27
            r0 = r4
            goto L28
        L1d:
            java.lang.String r1 = "OP48A1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L27
            r0 = r3
            goto L28
        L27:
            r0 = -1
        L28:
            if (r0 == 0) goto L2d
            if (r0 == r4) goto L2d
            return r3
        L2d:
            if (r5 == 0) goto L3e
            int r0 = r5.width
            r1 = 3840(0xf00, float:5.381E-42)
            if (r0 != r1) goto L3e
            float r5 = r5.frameRate
            r0 = 1105723392(0x41e80000, float:29.0)
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L3e
            r3 = r4
        L3e:
            if (r3 == 0) goto L47
            java.lang.String r5 = "MediaCodecVideoRenderer"
            java.lang.String r0 = "deviceNeedsMandatoryRenderWorkaround: workaround for 4K 30fps"
            com.google.android.exoplayer2.util.Log.w_renamed(r5, r0)
        L47:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.tblplayer.render.MediaCodecVideoRenderer.deviceNeedsMandatoryRenderWorkaround(com.google.android.exoplayer2.Format):boolean");
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:394:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:409:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:413:0x0631 A_renamed[Catch: all -> 0x0639, TryCatch #0 {, blocks: (B_renamed:7:0x000d, B_renamed:9:0x0011, B_renamed:11:0x0018, B_renamed:13:0x0022, B_renamed:15:0x002c, B_renamed:414:0x0633, B_renamed:16:0x0030, B_renamed:19:0x0036, B_renamed:20:0x003d, B_renamed:395:0x0601, B_renamed:398:0x0607, B_renamed:413:0x0631, B_renamed:403:0x0618, B_renamed:406:0x0622, B_renamed:397:0x0605, B_renamed:22:0x0042, B_renamed:25:0x004e, B_renamed:28:0x005a, B_renamed:31:0x0065, B_renamed:34:0x0071, B_renamed:37:0x007d, B_renamed:40:0x0089, B_renamed:43:0x0095, B_renamed:46:0x00a1, B_renamed:49:0x00ad, B_renamed:52:0x00b9, B_renamed:55:0x00c5, B_renamed:58:0x00d1, B_renamed:61:0x00dd, B_renamed:64:0x00e9, B_renamed:67:0x00f5, B_renamed:70:0x0101, B_renamed:73:0x010d, B_renamed:76:0x0119, B_renamed:79:0x0125, B_renamed:82:0x0131, B_renamed:85:0x013d, B_renamed:88:0x0148, B_renamed:91:0x0154, B_renamed:94:0x0160, B_renamed:97:0x016c, B_renamed:100:0x0178, B_renamed:103:0x0184, B_renamed:106:0x0190, B_renamed:109:0x019c, B_renamed:112:0x01a8, B_renamed:115:0x01b4, B_renamed:118:0x01c0, B_renamed:121:0x01cc, B_renamed:124:0x01d8, B_renamed:127:0x01e4, B_renamed:130:0x01f0, B_renamed:133:0x01fc, B_renamed:136:0x0207, B_renamed:139:0x0213, B_renamed:142:0x021f, B_renamed:145:0x022b, B_renamed:148:0x0237, B_renamed:151:0x0243, B_renamed:154:0x024f, B_renamed:157:0x025b, B_renamed:160:0x0267, B_renamed:163:0x0273, B_renamed:166:0x027f, B_renamed:169:0x028b, B_renamed:172:0x0297, B_renamed:175:0x02a3, B_renamed:178:0x02af, B_renamed:181:0x02bb, B_renamed:184:0x02c6, B_renamed:187:0x02d2, B_renamed:190:0x02de, B_renamed:193:0x02ea, B_renamed:196:0x02f6, B_renamed:199:0x0302, B_renamed:202:0x030e, B_renamed:205:0x031a, B_renamed:208:0x0326, B_renamed:211:0x0332, B_renamed:214:0x033e, B_renamed:217:0x0349, B_renamed:220:0x0354, B_renamed:223:0x035f, B_renamed:226:0x036b, B_renamed:229:0x0377, B_renamed:232:0x0383, B_renamed:235:0x038f, B_renamed:238:0x039b, B_renamed:241:0x03a7, B_renamed:244:0x03b3, B_renamed:247:0x03bf, B_renamed:250:0x03cb, B_renamed:253:0x03d7, B_renamed:256:0x03e3, B_renamed:259:0x03ef, B_renamed:262:0x03fb, B_renamed:265:0x0407, B_renamed:268:0x0413, B_renamed:271:0x041f, B_renamed:274:0x042b, B_renamed:277:0x0437, B_renamed:280:0x0443, B_renamed:283:0x044f, B_renamed:286:0x045b, B_renamed:289:0x0467, B_renamed:292:0x0473, B_renamed:295:0x047f, B_renamed:298:0x048b, B_renamed:301:0x0497, B_renamed:304:0x04a3, B_renamed:307:0x04af, B_renamed:310:0x04ba, B_renamed:313:0x04c6, B_renamed:316:0x04d2, B_renamed:319:0x04de, B_renamed:322:0x04ea, B_renamed:325:0x04f5, B_renamed:328:0x0501, B_renamed:331:0x050d, B_renamed:334:0x0519, B_renamed:337:0x0525, B_renamed:340:0x0531, B_renamed:343:0x053d, B_renamed:346:0x0549, B_renamed:349:0x0555, B_renamed:352:0x0561, B_renamed:355:0x056d, B_renamed:358:0x0579, B_renamed:361:0x0585, B_renamed:364:0x0591, B_renamed:367:0x059d, B_renamed:370:0x05a8, B_renamed:373:0x05b3, B_renamed:376:0x05be, B_renamed:379:0x05c9, B_renamed:382:0x05d4, B_renamed:385:0x05df, B_renamed:388:0x05ea, B_renamed:391:0x05f5, B_renamed:415:0x0635), top: B_renamed:421:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean codecNeedsSetOutputSurfaceWorkaround(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 2346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.tblplayer.render.MediaCodecVideoRenderer.codecNeedsSetOutputSurfaceWorkaround(java.lang.String):boolean");
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i_renamed, int i2, int i3) {
            this.width = i_renamed;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    @android.annotation.TargetApi(23)
    private final class OnFrameRenderedListenerV23 implements android.media.MediaCodec.OnFrameRenderedListener {
        private OnFrameRenderedListenerV23(android.media.MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new android.os.Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(android.media.MediaCodec mediaCodec, long j_renamed, long j2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (this != com.oplus.tblplayer.render.MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener) {
                return;
            }
            com.oplus.tblplayer.render.MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j_renamed);
        }
    }
}
