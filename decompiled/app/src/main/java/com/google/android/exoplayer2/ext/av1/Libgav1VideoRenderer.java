package com.google.android.exoplayer2.ext.av1;

/* loaded from: classes.dex */
public class Libgav1VideoRenderer extends com.google.android.exoplayer2.BaseRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = ((com.google.android.exoplayer2.util.Util.ceilDivide(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, 64) * com.google.android.exoplayer2.util.Util.ceilDivide(com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT, 64)) * 6144) / 2;
    private static final int DEFAULT_NUM_OF_INPUT_BUFFERS = 4;
    private static final int DEFAULT_NUM_OF_OUTPUT_BUFFERS = 4;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final java.lang.String TAG = "Libgav1VideoRenderer";
    public static final int THREAD_COUNT_AUTODETECT = 0;
    private final long allowedJoiningTimeMs;
    private android.graphics.Bitmap bitmap;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private com.google.android.exoplayer2.ext.av1.Gav1Decoder decoder;
    protected com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private final boolean disableLoopFilter;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession;
    private final com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final com.google.android.exoplayer2.decoder.DecoderInputBuffer flagsOnlyBuffer;
    private com.google.android.exoplayer2.Format format;
    private final com.google.android.exoplayer2.FormatHolder formatHolder;
    private final com.google.android.exoplayer2.util.TimedValueQueue<com.google.android.exoplayer2.Format> formatQueue;
    private com.google.android.exoplayer2.video.VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;
    private com.google.android.exoplayer2.ext.av1.Gav1InputBuffer inputBuffer;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer outputBuffer;
    private com.google.android.exoplayer2.ext.av1.Gav1OutputBufferRenderer outputBufferRenderer;
    private com.google.android.exoplayer2.Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> pendingDrmSession;
    private com.google.android.exoplayer2.Format pendingFormat;
    private final boolean playClearSamplesWithoutKeys;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private int reportedWidth;
    private final boolean scaleToFit;
    private android.view.Surface surface;
    private final boolean useSurfaceYuvOutput;
    private boolean waitingForKeys;

    private static boolean isBufferLate(long j_renamed) {
        return j_renamed < -30000;
    }

    private static boolean isBufferVeryLate(long j_renamed) {
        return j_renamed < -500000;
    }

    protected void onQueueInputBuffer(com.google.android.exoplayer2.ext.av1.Gav1InputBuffer gav1InputBuffer) {
    }

    public Libgav1VideoRenderer(boolean z_renamed, long j_renamed) {
        this(z_renamed, j_renamed, null, null, 0);
    }

    public Libgav1VideoRenderer(boolean z_renamed, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        this(z_renamed, j_renamed, handler, videoRendererEventListener, i_renamed, null, false, false, true);
    }

    public Libgav1VideoRenderer(boolean z_renamed, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, boolean z2, boolean z3, boolean z4) {
        super(2);
        this.scaleToFit = z_renamed;
        this.disableLoopFilter = z3;
        this.allowedJoiningTimeMs = j_renamed;
        this.maxDroppedFramesToNotify = i_renamed;
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z2;
        this.useSurfaceYuvOutput = z4;
        this.joiningDeadlineMs = -9223372036854775807L;
        clearReportedVideoSize();
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
        this.formatQueue = new com.google.android.exoplayer2.util.TimedValueQueue<>();
        this.flagsOnlyBuffer = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.outputMode = -1;
        this.decoderReinitializationState = 0;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) {
        if (com.google.android.exoplayer2.ext.av1.Gav1Library.isAvailable() && com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1.equalsIgnoreCase(format.sampleMimeType)) {
            return !supportsFormatDrm(this.drmSessionManager, format.drmInitData) ? 2 : 20;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.format == null) {
            this.flagsOnlyBuffer.clear();
            int source = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
            if (source != -5) {
                if (source == -4) {
                    com.google.android.exoplayer2.util.Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            onInputFormatChanged(this.formatHolder.format);
        }
        maybeInitDecoder();
        if (this.decoder != null) {
            try {
                com.google.android.exoplayer2.util.TraceUtil.beginSection("drainAndFeed");
                while (drainOutputBuffer(j_renamed, j2)) {
                }
                while (feedInputBuffer()) {
                }
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (com.google.android.exoplayer2.ext.av1.Gav1DecoderException e_renamed) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.waitingForKeys) {
            return false;
        }
        if (this.format != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrame || this.outputMode == -1))) {
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

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z_renamed) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
        this.formatQueue.clear();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = android.os.SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = android.os.SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.format = null;
        this.waitingForKeys = false;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        try {
            releaseDecoder();
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

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.outputStreamOffsetUs = j_renamed;
        super.onStreamChanged(formatArr, j_renamed);
    }

    protected void onDecoderInitialized(java.lang.String str, long j_renamed, long j2) {
        this.eventDispatcher.decoderInitialized(str, j_renamed, j2);
    }

    protected void flushDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.waitingForKeys = false;
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer = this.outputBuffer;
        if (gav1OutputBuffer != null) {
            gav1OutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    protected void releaseDecoder() {
        com.google.android.exoplayer2.ext.av1.Gav1Decoder gav1Decoder = this.decoder;
        if (gav1Decoder == null) {
            return;
        }
        this.inputBuffer = null;
        this.outputBuffer = null;
        gav1Decoder.release();
        this.decoder = null;
        this.decoderCounters.decoderReleaseCount++;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
    }

    protected void onInputFormatChanged(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.Format format2 = this.format;
        this.format = format;
        this.pendingFormat = format;
        if (!com.google.android.exoplayer2.util.Util.areEqual(this.format.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.format.drmInitData != null) {
                com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager = this.drmSessionManager;
                if (drmSessionManager == null) {
                    throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(new java.lang.IllegalStateException("Media requires a_renamed DrmSessionManager"), getIndex());
                }
                this.pendingDrmSession = drmSessionManager.acquireSession(android.os.Looper.myLooper(), this.format.drmInitData);
                com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession = this.pendingDrmSession;
                if (drmSession == this.drmSession) {
                    this.drmSessionManager.releaseSession(drmSession);
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        if (this.pendingDrmSession != this.drmSession) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.format);
    }

    protected void onProcessedOutputBuffer(long j_renamed) {
        this.buffersInCodecCount--;
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

    protected void skipOutputBuffer(com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        gav1OutputBuffer.release();
    }

    protected void dropOutputBuffer(com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer) {
        updateDroppedBufferCounters(1);
        gav1OutputBuffer.release();
    }

    protected void renderOutputBuffer(com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, com.google.android.exoplayer2.ext.av1.Gav1DecoderException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        this.lastRenderTimeUs = android.os.SystemClock.elapsedRealtime() * 1000;
        int i_renamed = gav1OutputBuffer.mode;
        boolean z_renamed = i_renamed == 1 && this.surface != null;
        boolean z2 = i_renamed == 0 && this.outputBufferRenderer != null;
        if (!z2 && !z_renamed) {
            dropOutputBuffer(gav1OutputBuffer);
            return;
        }
        maybeNotifyVideoSizeChanged(gav1OutputBuffer.width, gav1OutputBuffer.height);
        if (z2) {
            this.outputBufferRenderer.setOutputBuffer(gav1OutputBuffer);
        } else {
            renderOutputBufferToSurface(gav1OutputBuffer, this.surface);
        }
        this.consecutiveDroppedFrameCount = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
    }

    protected void renderOutputBufferToSurface(com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer, android.view.Surface surface) throws com.google.android.exoplayer2.ext.av1.Gav1DecoderException {
        com.google.android.exoplayer2.ext.av1.Gav1Decoder gav1Decoder = this.decoder;
        if (gav1Decoder == null) {
            throw new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("Failed to render output buffer to surface: decoder is_renamed not initialized.");
        }
        gav1Decoder.renderToSurface(gav1OutputBuffer, surface);
        gav1OutputBuffer.release();
    }

    protected boolean maybeDropBuffersToKeyframe(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        int iSkipSource = skipSource(j_renamed);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource);
        flushDecoder();
        return true;
    }

    protected void updateDroppedBufferCounters(int i_renamed) {
        this.decoderCounters.droppedBufferCount += i_renamed;
        this.droppedFrames += i_renamed;
        this.consecutiveDroppedFrameCount += i_renamed;
        com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.maxConsecutiveDroppedBufferCount = java.lang.Math.max(this.consecutiveDroppedFrameCount, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 <= 0 || this.droppedFrames < i2) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (i_renamed == 1) {
            setOutput((android.view.Surface) obj, null);
            return;
        }
        if (i_renamed == 10000) {
            setOutput(null, (com.google.android.exoplayer2.ext.av1.Gav1OutputBufferRenderer) obj);
        } else if (i_renamed == 6) {
            this.frameMetadataListener = (com.google.android.exoplayer2.video.VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i_renamed, obj);
        }
    }

    private void setOutput(android.view.Surface surface, com.google.android.exoplayer2.ext.av1.Gav1OutputBufferRenderer gav1OutputBufferRenderer) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.exoplayer2.util.Assertions.checkState(surface == null || gav1OutputBufferRenderer == null);
        if (this.surface != surface || this.outputBufferRenderer != gav1OutputBufferRenderer) {
            this.surface = surface;
            this.outputBufferRenderer = gav1OutputBufferRenderer;
            if (surface != null) {
                this.outputMode = this.useSurfaceYuvOutput ? 1 : -1;
            } else {
                this.outputMode = gav1OutputBufferRenderer == null ? -1 : 0;
            }
            int i_renamed = this.outputMode;
            if (i_renamed != -1) {
                com.google.android.exoplayer2.ext.av1.Gav1Decoder gav1Decoder = this.decoder;
                if (gav1Decoder != null) {
                    gav1Decoder.setOutputMode(i_renamed);
                }
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (getState() == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        if (this.outputMode != -1) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    private void maybeInitDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.decoder != null) {
            return;
        }
        this.drmSession = this.pendingDrmSession;
        com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession = this.drmSession;
        if (drmSession != null && drmSession.getMediaCrypto() == null && this.drmSession.getError() == null) {
            return;
        }
        try {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.google.android.exoplayer2.util.TraceUtil.beginSection("createVpxDecoder");
            this.decoder = new com.google.android.exoplayer2.ext.av1.Gav1Decoder(4, 4, this.format.maxInputSize != -1 ? this.format.maxInputSize : DEFAULT_INPUT_BUFFER_SIZE, 0);
            this.decoder.setOutputMode(this.outputMode);
            com.google.android.exoplayer2.util.TraceUtil.endSection();
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            onDecoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (com.google.android.exoplayer2.ext.av1.Gav1DecoderException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    private boolean feedInputBuffer() throws com.google.android.exoplayer2.ExoPlaybackException, com.google.android.exoplayer2.ext.av1.Gav1DecoderException {
        com.google.android.exoplayer2.ext.av1.Gav1Decoder gav1Decoder = this.decoder;
        if (gav1Decoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = gav1Decoder.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer((com.google.android.exoplayer2.ext.av1.Gav1Decoder) this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        int source = this.waitingForKeys ? -4 : readSource(this.formatHolder, this.inputBuffer, false);
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer((com.google.android.exoplayer2.ext.av1.Gav1Decoder) this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        if (this.waitingForKeys) {
            return false;
        }
        if (this.pendingFormat != null) {
            this.formatQueue.add(this.inputBuffer.timeUs, this.pendingFormat);
            this.pendingFormat = null;
        }
        this.inputBuffer.flip();
        this.inputBuffer.colorInfo = this.formatHolder.format.colorInfo;
        onQueueInputBuffer(this.inputBuffer);
        this.decoder.queueInputBuffer((com.google.android.exoplayer2.ext.av1.Gav1Decoder) this.inputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    private boolean drainOutputBuffer(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, com.google.android.exoplayer2.ext.av1.Gav1DecoderException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.outputBuffer == null) {
            this.outputBuffer = this.decoder.dequeueOutputBuffer();
            if (this.outputBuffer == null) {
                return false;
            }
            this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
            this.buffersInCodecCount -= this.outputBuffer.skippedOutputBufferCount;
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
            }
            return false;
        }
        boolean zProcessOutputBuffer = processOutputBuffer(j_renamed, j2);
        if (zProcessOutputBuffer) {
            onProcessedOutputBuffer(this.outputBuffer.timeUs);
            this.outputBuffer = null;
        }
        return zProcessOutputBuffer;
    }

    private boolean processOutputBuffer(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, com.google.android.exoplayer2.ext.av1.Gav1DecoderException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j_renamed;
        }
        long j3 = this.outputBuffer.timeUs - j_renamed;
        if (this.outputMode == -1) {
            if (!isBufferLate(j3)) {
                return false;
            }
            skipOutputBuffer(this.outputBuffer);
            return true;
        }
        long j4 = this.outputBuffer.timeUs - this.outputStreamOffsetUs;
        com.google.android.exoplayer2.Format formatPollFloor = this.formatQueue.pollFloor(j4);
        if (formatPollFloor != null) {
            this.outputFormat = formatPollFloor;
        }
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
        boolean z_renamed = getState() == 2;
        if (!this.renderedFirstFrame || (z_renamed && shouldForceRenderOutputBuffer(j3, jElapsedRealtime - this.lastRenderTimeUs))) {
            com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j4, java.lang.System.nanoTime(), this.outputFormat);
            }
            renderOutputBuffer(this.outputBuffer);
            return true;
        }
        if (!z_renamed || j_renamed == this.initialPositionUs || (shouldDropBuffersToKeyframe(j3, j2) && maybeDropBuffersToKeyframe(j_renamed))) {
            return false;
        }
        if (shouldDropOutputBuffer(j3, j2)) {
            dropOutputBuffer(this.outputBuffer);
            return true;
        }
        if (j3 < 30000) {
            com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener2 = this.frameMetadataListener;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j4, java.lang.System.nanoTime(), this.outputFormat);
            }
            renderOutputBuffer(this.outputBuffer);
            return true;
        }
        return false;
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

    private void renderRgbFrame(com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer, boolean z_renamed) throws android.view.Surface.OutOfResourcesException, java.lang.IllegalArgumentException {
        android.graphics.Bitmap bitmap = this.bitmap;
        if (bitmap == null || bitmap.getWidth() != gav1OutputBuffer.width || this.bitmap.getHeight() != gav1OutputBuffer.height) {
            this.bitmap = android.graphics.Bitmap.createBitmap(gav1OutputBuffer.width, gav1OutputBuffer.height, android.graphics.Bitmap.Config.RGB_565);
        }
        this.bitmap.copyPixelsFromBuffer(gav1OutputBuffer.data);
        android.graphics.Canvas canvasLockCanvas = this.surface.lockCanvas(null);
        if (z_renamed) {
            canvasLockCanvas.scale(canvasLockCanvas.getWidth() / gav1OutputBuffer.width, canvasLockCanvas.getHeight() / gav1OutputBuffer.height);
        }
        canvasLockCanvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (android.graphics.Paint) null);
        this.surface.unlockCanvasAndPost(canvasLockCanvas);
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? android.os.SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrame = false;
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            return;
        }
        this.renderedFirstFrame = true;
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
    }

    private void maybeNotifyVideoSizeChanged(int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.reportedWidth == i_renamed && this.reportedHeight == i2) {
            return;
        }
        this.reportedWidth = i_renamed;
        this.reportedHeight = i2;
        this.eventDispatcher.videoSizeChanged(i_renamed, i2, 0, 1.0f);
    }

    private void maybeRenotifyVideoSizeChanged() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.reportedWidth == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, 0, 1.0f);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }
}
