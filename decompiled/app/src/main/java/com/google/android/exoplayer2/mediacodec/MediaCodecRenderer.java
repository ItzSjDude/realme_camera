package com.google.android.exoplayer2.mediacodec;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = com.google.android.exoplayer2.util.Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    protected static final float CODEC_OPERATING_RATE_UNSET = -1.0f;
    protected static final int KEEP_CODEC_RESULT_NO = 0;
    protected static final int KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = 1;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = 3;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final java.lang.String TAG = "MediaCodecRenderer";
    private final float assumedMinimumCodecOperatingRate;
    private java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> availableCodecInfos;
    private final com.google.android.exoplayer2.decoder.DecoderInputBuffer buffer;
    private android.media.MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private boolean codecConfiguredWithOperatingRate;
    private long codecHotswapDeadlineMs;
    private com.google.android.exoplayer2.mediacodec.MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsReconfigureWorkaround;
    private float codecOperatingRate;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private int codecReinitializationState;
    private final java.util.List<java.lang.Long> decodeOnlyPresentationTimestamps;
    protected com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSession;
    private final com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager;
    private final com.google.android.exoplayer2.decoder.DecoderInputBuffer flagsOnlyBuffer;
    private com.google.android.exoplayer2.Format format;
    private final com.google.android.exoplayer2.FormatHolder formatHolder;
    private final com.google.android.exoplayer2.util.TimedValueQueue<com.google.android.exoplayer2.Format> formatQueue;
    private java.nio.ByteBuffer[] inputBuffers;
    private int inputIndex;
    private boolean inputStreamEnded;
    private final com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector;
    private java.nio.ByteBuffer outputBuffer;
    private final android.media.MediaCodec.BufferInfo outputBufferInfo;
    private java.nio.ByteBuffer[] outputBuffers;
    private com.google.android.exoplayer2.Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> pendingDrmSession;
    private com.google.android.exoplayer2.Format pendingFormat;
    private final boolean playClearSamplesWithoutKeys;
    private com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException preferredDecoderInitializationException;
    private float rendererOperatingRate;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private boolean shouldSkipOutputBuffer;
    private boolean waitingForFirstSyncFrame;
    private boolean waitingForKeys;

    protected int canKeepCodec(android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        return 0;
    }

    protected abstract void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.Format format, android.media.MediaCrypto mediaCrypto, float f_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;

    protected boolean getCodecNeedsEosPropagation() {
        return false;
    }

    protected float getCodecOperatingRate(float f_renamed, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        return CODEC_OPERATING_RATE_UNSET;
    }

    protected long getDequeueOutputBufferTimeoutUs() {
        return 0L;
    }

    protected boolean isNeedDecodeForDecodeOnlyBuffer() {
        return true;
    }

    protected void onCodecInitialized(java.lang.String str, long j_renamed, long j2) {
    }

    protected void onOutputFormatChanged(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected void onProcessedOutputBuffer(long j_renamed) {
    }

    protected void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onSetFastRendererPosition(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
    }

    protected abstract boolean processOutputBuffer(long j_renamed, long j2, android.media.MediaCodec mediaCodec, java.nio.ByteBuffer byteBuffer, int i_renamed, int i2, long j3, boolean z_renamed, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException;

    protected void renderToEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    protected boolean shouldInitCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    protected abstract int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends java.lang.Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final java.lang.String decoderName;
        public final java.lang.String diagnosticInfo;
        public final com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException fallbackDecoderInitializationException;
        public final java.lang.String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(com.google.android.exoplayer2.Format format, java.lang.Throwable th, boolean z_renamed, int i_renamed) {
            this("Decoder init failed: [" + i_renamed + "], " + format, th, format.sampleMimeType, z_renamed, null, buildCustomDiagnosticInfo(i_renamed), null);
        }

        public DecoderInitializationException(com.google.android.exoplayer2.Format format, java.lang.Throwable th, boolean z_renamed, java.lang.String str) {
            this("Decoder init failed: " + str + ", " + format, th, format.sampleMimeType, z_renamed, str, com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null, null);
        }

        private DecoderInitializationException(java.lang.String str, java.lang.Throwable th, java.lang.String str2, boolean z_renamed, java.lang.String str3, java.lang.String str4, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z_renamed;
            this.decoderName = str3;
            this.diagnosticInfo = str4;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException copyWithFallbackException(com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException decoderInitializationException) {
            return new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.decoderName, this.diagnosticInfo, decoderInitializationException);
        }

        @android.annotation.TargetApi(21)
        private static java.lang.String getDiagnosticInfoV21(java.lang.Throwable th) {
            if (th instanceof android.media.MediaCodec.CodecException) {
                return ((android.media.MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static java.lang.String buildCustomDiagnosticInfo(int i_renamed) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i_renamed < 0 ? "neg_" : "") + java.lang.Math.abs(i_renamed);
        }
    }

    public MediaCodecRenderer(int i_renamed, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, float f_renamed) {
        super(i_renamed);
        com.google.android.exoplayer2.util.Assertions.checkState(com.google.android.exoplayer2.util.Util.SDK_INT >= 16);
        this.mediaCodecSelector = (com.google.android.exoplayer2.mediacodec.MediaCodecSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaCodecSelector);
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z_renamed;
        this.assumedMinimumCodecOperatingRate = f_renamed;
        this.buffer = new com.google.android.exoplayer2.decoder.DecoderInputBuffer(0);
        this.flagsOnlyBuffer = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
        this.formatQueue = new com.google.android.exoplayer2.util.TimedValueQueue<>();
        this.decodeOnlyPresentationTimestamps = new java.util.ArrayList();
        this.outputBufferInfo = new android.media.MediaCodec.BufferInfo();
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
        this.codecOperatingRate = CODEC_OPERATING_RATE_UNSET;
        this.rendererOperatingRate = 1.0f;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, this.drmSessionManager, format);
        } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, this.getIndex());
        }
    }

    protected java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        return mediaCodecSelector.getDecoderInfos(format.sampleMimeType, z_renamed);
    }

    protected final void maybeInitCodec() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.Format format;
        boolean zRequiresSecureDecoderComponent;
        if (this.codec != null || (format = this.format) == null) {
            return;
        }
        this.drmSession = this.pendingDrmSession;
        java.lang.String str = format.sampleMimeType;
        android.media.MediaCrypto wrappedMediaCrypto = null;
        com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSession = this.drmSession;
        if (drmSession != null) {
            com.google.android.exoplayer2.drm.FrameworkMediaCrypto frameworkMediaCrypto = (com.google.android.exoplayer2.drm.FrameworkMediaCrypto) drmSession.getMediaCrypto();
            if (frameworkMediaCrypto == null) {
                if (this.drmSession.getError() == null) {
                    return;
                } else {
                    zRequiresSecureDecoderComponent = false;
                }
            } else {
                wrappedMediaCrypto = frameworkMediaCrypto.getWrappedMediaCrypto();
                zRequiresSecureDecoderComponent = frameworkMediaCrypto.requiresSecureDecoderComponent(str);
            }
            if (deviceNeedsDrmKeysToConfigureCodecWorkaround()) {
                int state = this.drmSession.getState();
                if (state == 1) {
                    throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
                }
                if (state != 4) {
                    return;
                }
            }
        } else {
            zRequiresSecureDecoderComponent = false;
        }
        try {
            if (initCodecWithFallback(wrappedMediaCrypto, zRequiresSecureDecoderComponent)) {
                java.lang.String str2 = this.codecInfo.name;
                this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str2);
                this.codecNeedsReconfigureWorkaround = codecNeedsReconfigureWorkaround(str2);
                this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str2, this.format);
                this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str2);
                this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str2);
                this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str2);
                this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str2, this.format);
                this.codecNeedsEosPropagation = codecNeedsEosPropagationWorkaround(this.codecInfo) || getCodecNeedsEosPropagation();
                this.codecHotswapDeadlineMs = getState() == 2 ? android.os.SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                resetInputBuffer();
                resetOutputBuffer();
                this.waitingForFirstSyncFrame = true;
                this.decoderCounters.decoderInitCount++;
            }
        } catch (com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    protected final com.google.android.exoplayer2.Format updateOutputFormatForTime(long j_renamed) {
        com.google.android.exoplayer2.Format formatPollFloor = this.formatQueue.pollFloor(j_renamed);
        if (formatPollFloor != null) {
            this.outputFormat = formatPollFloor;
        }
        return formatPollFloor;
    }

    protected final android.media.MediaCodec getCodec() {
        return this.codec;
    }

    protected final com.google.android.exoplayer2.mediacodec.MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.codec != null) {
            flushCodec();
        }
        this.formatQueue.clear();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setOperatingRate(float f_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.rendererOperatingRate = f_renamed;
        updateCodecOperatingRate();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.format = null;
        this.availableCodecInfos = null;
        try {
            releaseCodec();
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                } finally {
                }
            } catch (java.lang.Throwable th) {
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th2;
                } finally {
                }
            } catch (java.lang.Throwable th3) {
                try {
                    if (this.pendingDrmSession != null && this.pendingDrmSession != this.drmSession) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    protected void releaseCodec() {
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        resetCodecBuffers();
        this.codecInfo = null;
        this.codecReconfigured = false;
        this.codecReceivedBuffers = false;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsReconfigureWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.codecNeedsEosPropagation = false;
        this.codecReceivedEos = false;
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
        this.codecConfiguredWithOperatingRate = false;
        if (this.codec != null) {
            this.decoderCounters.decoderReleaseCount++;
            try {
                this.codec.stop();
                try {
                    this.codec.release();
                    this.codec = null;
                    com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSession = this.drmSession;
                    if (drmSession == null || this.pendingDrmSession == drmSession) {
                        return;
                    }
                    try {
                        this.drmSessionManager.releaseSession(drmSession);
                    } finally {
                    }
                } catch (java.lang.Throwable th) {
                    this.codec = null;
                    com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSession2 = this.drmSession;
                    if (drmSession2 != null && this.pendingDrmSession != drmSession2) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                try {
                    this.codec.release();
                    this.codec = null;
                    com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSession3 = this.drmSession;
                    if (drmSession3 != null && this.pendingDrmSession != drmSession3) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (java.lang.Throwable th3) {
                    this.codec = null;
                    com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSession4 = this.drmSession;
                    if (drmSession4 != null && this.pendingDrmSession != drmSession4) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.outputStreamEnded) {
            renderToEndOfStream();
            return;
        }
        if (this.format == null) {
            this.flagsOnlyBuffer.clear();
            int source = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
            if (source != -5) {
                if (source == -4) {
                    com.google.android.exoplayer2.util.Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    processEndOfStream();
                    return;
                }
                return;
            }
            onInputFormatChanged(this.formatHolder.format);
        }
        maybeInitCodec();
        if (this.codec != null) {
            com.google.android.exoplayer2.util.TraceUtil.beginSection("drainAndFeed");
            while (drainOutputBuffer(j_renamed, j2)) {
            }
            while (feedInputBuffer()) {
            }
            com.google.android.exoplayer2.util.TraceUtil.endSection();
        } else {
            this.decoderCounters.skippedInputBufferCount += skipSource(j_renamed);
            this.flagsOnlyBuffer.clear();
            int source2 = readSource(this.formatHolder, this.flagsOnlyBuffer, false);
            if (source2 == -5) {
                onInputFormatChanged(this.formatHolder.format);
            } else if (source2 == -4) {
                com.google.android.exoplayer2.util.Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                this.inputStreamEnded = true;
                processEndOfStream();
            }
        }
        this.decoderCounters.ensureUpdated();
    }

    protected void flushCodec() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForFirstSyncFrame = true;
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        if (this.codecNeedsFlushWorkaround || ((this.codecNeedsEosFlushWorkaround && this.codecReceivedEos) || this.codecReinitializationState != 0)) {
            releaseCodec();
            maybeInitCodec();
        } else {
            this.codec.flush();
            this.codecReceivedBuffers = false;
        }
        if (!this.codecReconfigured || this.format == null) {
            return;
        }
        this.codecReconfigurationState = 1;
    }

    private boolean initCodecWithFallback(android.media.MediaCrypto mediaCrypto, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException {
        if (this.availableCodecInfos == null) {
            try {
                this.availableCodecInfos = new java.util.ArrayDeque<>(getAvailableCodecInfos(z_renamed));
                this.preferredDecoderInitializationException = null;
            } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException e_renamed) {
                throw new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(this.format, e_renamed, z_renamed, -49998);
            }
        }
        if (this.availableCodecInfos.isEmpty()) {
            throw new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(this.format, (java.lang.Throwable) null, z_renamed, -49999);
        }
        do {
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfoPeekFirst = this.availableCodecInfos.peekFirst();
            if (!shouldInitCodec(mediaCodecInfoPeekFirst)) {
                return false;
            }
            try {
                initCodec(mediaCodecInfoPeekFirst, mediaCrypto);
                return true;
            } catch (java.lang.Exception e2) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Failed to initialize decoder: " + mediaCodecInfoPeekFirst, e2);
                this.availableCodecInfos.removeFirst();
                com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException decoderInitializationException = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(this.format, e2, z_renamed, mediaCodecInfoPeekFirst.name);
                com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException decoderInitializationException2 = this.preferredDecoderInitializationException;
                if (decoderInitializationException2 != null) {
                    this.preferredDecoderInitializationException = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                } else {
                    this.preferredDecoderInitializationException = decoderInitializationException;
                }
            }
        } while (!this.availableCodecInfos.isEmpty());
        throw this.preferredDecoderInitializationException;
    }

    private java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getAvailableCodecInfos(boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.format, z_renamed);
        if (decoderInfos.isEmpty() && z_renamed) {
            decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.format, false);
            if (!decoderInfos.isEmpty()) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Drm session requires secure decoder for " + this.format.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos + ".");
            }
        }
        return decoderInfos;
    }

    private void initCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, android.media.MediaCrypto mediaCrypto) throws java.lang.Exception {
        android.media.MediaCodec mediaCodecCreateDecoderByType;
        long jElapsedRealtime;
        java.lang.String str = mediaCodecInfo.name;
        java.lang.String str2 = mediaCodecInfo.mimeType;
        updateCodecOperatingRate();
        boolean z_renamed = this.codecOperatingRate > this.assumedMinimumCodecOperatingRate;
        try {
            jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.google.android.exoplayer2.util.TraceUtil.beginSection("createCodec:" + str);
            mediaCodecCreateDecoderByType = android.media.MediaCodec.createDecoderByType(str2);
        } catch (java.lang.Exception e_renamed) {
            e_renamed = e_renamed;
            mediaCodecCreateDecoderByType = null;
        }
        try {
            com.google.android.exoplayer2.util.TraceUtil.endSection();
            com.google.android.exoplayer2.util.TraceUtil.beginSection("configureCodec");
            configureCodec(mediaCodecInfo, mediaCodecCreateDecoderByType, this.format, mediaCrypto, z_renamed ? this.codecOperatingRate : CODEC_OPERATING_RATE_UNSET);
            this.codecConfiguredWithOperatingRate = z_renamed;
            com.google.android.exoplayer2.util.TraceUtil.endSection();
            com.google.android.exoplayer2.util.TraceUtil.beginSection("startCodec");
            mediaCodecCreateDecoderByType.start();
            com.google.android.exoplayer2.util.TraceUtil.endSection();
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            getCodecBuffers(mediaCodecCreateDecoderByType);
            this.codec = mediaCodecCreateDecoderByType;
            this.codecInfo = mediaCodecInfo;
            onCodecInitialized(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            if (mediaCodecCreateDecoderByType != null) {
                resetCodecBuffers();
                mediaCodecCreateDecoderByType.release();
            }
            throw e_renamed;
        }
    }

    private void getCodecBuffers(android.media.MediaCodec mediaCodec) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            this.inputBuffers = mediaCodec.getInputBuffers();
            this.outputBuffers = mediaCodec.getOutputBuffers();
        }
    }

    private void resetCodecBuffers() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private java.nio.ByteBuffer getInputBuffer(int i_renamed) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i_renamed);
        }
        return this.inputBuffers[i_renamed];
    }

    private java.nio.ByteBuffer getOutputBuffer(int i_renamed) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i_renamed);
        }
        return this.outputBuffers[i_renamed];
    }

    private boolean hasOutputBuffer() {
        return this.outputIndex >= 0;
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private boolean feedInputBuffer() throws com.google.android.exoplayer2.ExoPlaybackException, android.media.MediaCodec.CryptoException {
        int iPosition;
        int source;
        android.media.MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            this.inputIndex = mediaCodec.dequeueInputBuffer(0L);
            int i_renamed = this.inputIndex;
            if (i_renamed < 0) {
                return false;
            }
            this.buffer.data = getInputBuffer(i_renamed);
            this.buffer.clear();
        }
        if (this.codecReinitializationState == 1) {
            if (!this.codecNeedsEosPropagation) {
                this.codecReceivedEos = true;
                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                resetInputBuffer();
            }
            this.codecReinitializationState = 2;
            return false;
        }
        if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.buffer.data.put(ADAPTATION_WORKAROUND_BUFFER);
            this.codec.queueInputBuffer(this.inputIndex, 0, ADAPTATION_WORKAROUND_BUFFER.length, 0L, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        }
        if (this.waitingForKeys) {
            source = -4;
            iPosition = 0;
        } else {
            if (this.codecReconfigurationState == 1) {
                for (int i2 = 0; i2 < this.format.initializationData.size(); i2++) {
                    this.buffer.data.put(this.format.initializationData.get(i2));
                }
                this.codecReconfigurationState = 2;
            }
            iPosition = this.buffer.data.position();
            source = readSource(this.formatHolder, this.buffer, false);
        }
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        if (this.buffer.isEndOfStream()) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            this.inputStreamEnded = true;
            if (!this.codecReceivedBuffers) {
                processEndOfStream();
                return false;
            }
            try {
                if (!this.codecNeedsEosPropagation) {
                    this.codecReceivedEos = true;
                    this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                    resetInputBuffer();
                }
                return false;
            } catch (android.media.MediaCodec.CryptoException e_renamed) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
            }
        }
        if (this.waitingForFirstSyncFrame && !this.buffer.isKeyFrame()) {
            this.buffer.clear();
            if (this.codecReconfigurationState == 2) {
                this.codecReconfigurationState = 1;
            }
            return true;
        }
        this.waitingForFirstSyncFrame = false;
        boolean zIsEncrypted = this.buffer.isEncrypted();
        this.waitingForKeys = shouldWaitForKeys(zIsEncrypted);
        if (this.waitingForKeys) {
            return false;
        }
        if (this.codecNeedsDiscardToSpsWorkaround && !zIsEncrypted) {
            com.google.android.exoplayer2.util.NalUnitUtil.discardToSps(this.buffer.data);
            if (this.buffer.data.position() == 0) {
                return true;
            }
            this.codecNeedsDiscardToSpsWorkaround = false;
        }
        try {
            long j_renamed = this.buffer.timeUs;
            if (this.buffer.isDecodeOnly()) {
                if (!isNeedDecodeForDecodeOnlyBuffer()) {
                    this.buffer.clear();
                    return true;
                }
                this.decodeOnlyPresentationTimestamps.add(java.lang.Long.valueOf(j_renamed));
            }
            if (this.pendingFormat != null) {
                this.formatQueue.add(j_renamed, this.pendingFormat);
                this.pendingFormat = null;
            }
            this.buffer.flip();
            onQueueInputBuffer(this.buffer);
            if (zIsEncrypted) {
                this.codec.queueSecureInputBuffer(this.inputIndex, 0, getFrameworkCryptoInfo(this.buffer, iPosition), j_renamed, 0);
            } else {
                this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j_renamed, 0);
            }
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            this.codecReconfigurationState = 0;
            this.decoderCounters.inputBufferCount++;
            return true;
        } catch (android.media.MediaCodec.CryptoException e2) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e2, getIndex());
        }
    }

    private boolean shouldWaitForKeys(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.drmSession == null || (!z_renamed && this.playClearSamplesWithoutKeys)) {
            return false;
        }
        int state = this.drmSession.getState();
        if (state != 1) {
            return state != 4;
        }
        throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:40:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onInputFormatChanged(com.google.android.exoplayer2.Format r6) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r5 = this;
            com.google.android.exoplayer2.Format r0 = r5.format
            r5.format = r6
            r5.pendingFormat = r6
            com.google.android.exoplayer2.Format r6 = r5.format
            com.google.android.exoplayer2.drm.DrmInitData r6 = r6.drmInitData
            r1 = 0
            if (r0 != 0) goto Lf
            r2 = r1
            goto L11
        Lf:
            com.google.android.exoplayer2.drm.DrmInitData r2 = r0.drmInitData
        L11:
            boolean r6 = com.google.android.exoplayer2.util.Util.areEqual(r6, r2)
            r2 = 1
            r6 = r6 ^ r2
            if (r6 == 0) goto L4f
            com.google.android.exoplayer2.Format r6 = r5.format
            com.google.android.exoplayer2.drm.DrmInitData r6 = r6.drmInitData
            if (r6 == 0) goto L4d
            com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> r6 = r5.drmSessionManager
            if (r6 == 0) goto L3d
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.exoplayer2.Format r3 = r5.format
            com.google.android.exoplayer2.drm.DrmInitData r3 = r3.drmInitData
            com.google.android.exoplayer2.drm.DrmSession r6 = r6.acquireSession(r1, r3)
            r5.pendingDrmSession = r6
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> r6 = r5.pendingDrmSession
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> r1 = r5.drmSession
            if (r6 != r1) goto L4f
            com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> r1 = r5.drmSessionManager
            r1.releaseSession(r6)
            goto L4f
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a_renamed DrmSessionManager"
            r6.<init>(r0)
            int r5 = r5.getIndex()
            com.google.android.exoplayer2.ExoPlaybackException r5 = com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(r6, r5)
            throw r5
        L4d:
            r5.pendingDrmSession = r1
        L4f:
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> r6 = r5.pendingDrmSession
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> r1 = r5.drmSession
            r3 = 0
            if (r6 != r1) goto L92
            android.media.MediaCodec r6 = r5.codec
            if (r6 == 0) goto L92
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r1 = r5.codecInfo
            com.google.android.exoplayer2.Format r4 = r5.format
            int r6 = r5.canKeepCodec(r6, r1, r0, r4)
            if (r6 == 0) goto L92
            if (r6 == r2) goto L93
            r1 = 3
            if (r6 != r1) goto L8c
            boolean r6 = r5.codecNeedsReconfigureWorkaround
            if (r6 != 0) goto L92
            r5.codecReconfigured = r2
            r5.codecReconfigurationState = r2
            int r6 = r5.codecAdaptationWorkaroundMode
            r1 = 2
            if (r6 == r1) goto L88
            if (r6 != r2) goto L89
            com.google.android.exoplayer2.Format r6 = r5.format
            int r6 = r6.width
            int r1 = r0.width
            if (r6 != r1) goto L89
            com.google.android.exoplayer2.Format r6 = r5.format
            int r6 = r6.height
            int r0 = r0.height
            if (r6 != r0) goto L89
        L88:
            r3 = r2
        L89:
            r5.codecNeedsAdaptationWorkaroundBuffer = r3
            goto L93
        L8c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>()
            throw r5
        L92:
            r2 = r3
        L93:
            if (r2 != 0) goto L99
            r5.reinitializeCodec()
            goto L9c
        L99:
            r5.updateCodecOperatingRate()
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.onInputFormatChanged(com.google.android.exoplayer2.Format):void");
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return (this.format == null || this.waitingForKeys || (!isSourceReady() && !hasOutputBuffer() && (this.codecHotswapDeadlineMs == -9223372036854775807L || android.os.SystemClock.elapsedRealtime() >= this.codecHotswapDeadlineMs))) ? false : true;
    }

    private void updateCodecOperatingRate() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.format == null || com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            return;
        }
        float codecOperatingRate = getCodecOperatingRate(this.rendererOperatingRate, this.format, getStreamFormats());
        if (this.codecOperatingRate == codecOperatingRate) {
            return;
        }
        this.codecOperatingRate = codecOperatingRate;
        if (this.codec == null || this.codecReinitializationState != 0) {
            return;
        }
        if (codecOperatingRate == CODEC_OPERATING_RATE_UNSET && this.codecConfiguredWithOperatingRate) {
            reinitializeCodec();
            return;
        }
        if (codecOperatingRate != CODEC_OPERATING_RATE_UNSET) {
            if (this.codecConfiguredWithOperatingRate || codecOperatingRate > this.assumedMinimumCodecOperatingRate) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putFloat("operating-rate", codecOperatingRate);
                this.codec.setParameters(bundle);
                this.codecConfiguredWithOperatingRate = true;
            }
        }
    }

    private void reinitializeCodec() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.availableCodecInfos = null;
        if (this.codecReceivedBuffers) {
            this.codecReinitializationState = 1;
        } else {
            releaseCodec();
            maybeInitCodec();
        }
    }

    private boolean drainOutputBuffer(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean zProcessOutputBuffer;
        int iDequeueOutputBuffer;
        if (!hasOutputBuffer()) {
            if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
                try {
                    iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                } catch (java.lang.IllegalStateException unused) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
            }
            if (iDequeueOutputBuffer < 0) {
                if (iDequeueOutputBuffer == -2) {
                    processOutputFormat();
                    return true;
                }
                if (iDequeueOutputBuffer == -3) {
                    processOutputBuffersChanged();
                    return true;
                }
                if (this.codecNeedsEosPropagation && (this.inputStreamEnded || this.codecReinitializationState == 2)) {
                    processEndOfStream();
                }
                return false;
            }
            if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                this.codec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                return true;
            }
            if (this.outputBufferInfo.size == 0 && (this.outputBufferInfo.flags & 4) != 0) {
                processEndOfStream();
                return false;
            }
            this.outputIndex = iDequeueOutputBuffer;
            this.outputBuffer = getOutputBuffer(iDequeueOutputBuffer);
            java.nio.ByteBuffer byteBuffer = this.outputBuffer;
            if (byteBuffer != null) {
                byteBuffer.position(this.outputBufferInfo.offset);
                this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
            }
            this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            updateOutputFormatForTime(this.outputBufferInfo.presentationTimeUs);
        }
        if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
            try {
                zProcessOutputBuffer = processOutputBuffer(j_renamed, j2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer, this.outputFormat);
            } catch (java.lang.IllegalStateException unused2) {
                processEndOfStream();
                if (this.outputStreamEnded) {
                    releaseCodec();
                }
                return false;
            }
        } else {
            zProcessOutputBuffer = processOutputBuffer(j_renamed, j2, this.codec, this.outputBuffer, this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer, this.outputFormat);
        }
        if (zProcessOutputBuffer) {
            onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            boolean z_renamed = (this.outputBufferInfo.flags & 4) != 0;
            resetOutputBuffer();
            if (!z_renamed) {
                return true;
            }
            processEndOfStream();
        }
        return false;
    }

    private void processOutputFormat() throws com.google.android.exoplayer2.ExoPlaybackException {
        android.media.MediaFormat outputFormat = this.codec.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat.setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.codec, outputFormat);
    }

    private void processOutputBuffersChanged() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private void processEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.codecReinitializationState == 2) {
            releaseCodec();
            maybeInitCodec();
        } else {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        }
    }

    private boolean shouldSkipOutputBuffer(long j_renamed) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (this.decodeOnlyPresentationTimestamps.get(i_renamed).longValue() == j_renamed) {
                this.decodeOnlyPresentationTimestamps.remove(i_renamed);
                return true;
            }
        }
        return false;
    }

    private static android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfo(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, int i_renamed) {
        android.media.MediaCodec.CryptoInfo frameworkCryptoInfoV16 = decoderInputBuffer.cryptoInfo.getFrameworkCryptoInfoV16();
        if (i_renamed == 0) {
            return frameworkCryptoInfoV16;
        }
        if (frameworkCryptoInfoV16.numBytesOfClearData == null) {
            frameworkCryptoInfoV16.numBytesOfClearData = new int[1];
        }
        int[] iArr = frameworkCryptoInfoV16.numBytesOfClearData;
        iArr[0] = iArr[0] + i_renamed;
        return frameworkCryptoInfoV16;
    }

    private boolean deviceNeedsDrmKeysToConfigureCodecWorkaround() {
        return "Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && ("AFTM".equals(com.google.android.exoplayer2.util.Util.MODEL) || "AFTB".equals(com.google.android.exoplayer2.util.Util.MODEL));
    }

    private static boolean codecNeedsFlushWorkaround(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.SDK_INT < 18 || (com.google.android.exoplayer2.util.Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (com.google.android.exoplayer2.util.Util.SDK_INT == 19 && com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int codecAdaptationWorkaroundMode(java.lang.String str) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-T585") || com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-A510") || com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-A520") || com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "flounder_lte".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "grouper".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "tilapia".equals(com.google.android.exoplayer2.util.Util.DEVICE)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean codecNeedsReconfigureWorkaround(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(java.lang.String str, com.google.android.exoplayer2.Format format) {
        return com.google.android.exoplayer2.util.Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean codecNeedsEosPropagationWorkaround(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        java.lang.String str = mediaCodecInfo.name;
        return (com.google.android.exoplayer2.util.Util.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) || ("Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && "AFTS".equals(com.google.android.exoplayer2.util.Util.MODEL) && mediaCodecInfo.secure);
    }

    private static boolean codecNeedsEosFlushWorkaround(java.lang.String str) {
        return (com.google.android.exoplayer2.util.Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (com.google.android.exoplayer2.util.Util.SDK_INT <= 19 && (("hb2000".equals(com.google.android.exoplayer2.util.Util.DEVICE) || "stvm8".equals(com.google.android.exoplayer2.util.Util.DEVICE)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))));
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(java.lang.String str, com.google.android.exoplayer2.Format format) {
        return com.google.android.exoplayer2.util.Util.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
