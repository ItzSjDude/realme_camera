package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public abstract class DecoderVideoRenderer extends com.google.android.exoplayer2.BaseRenderer {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final java.lang.String TAG = "DecoderVideoRenderer";
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private com.google.android.exoplayer2.decoder.Decoder<com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer, ? extends com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer, ? extends com.oplus.tblplayer.ffmpeg.DecoderException> decoder;
    protected com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters;
    private com.google.android.exoplayer2.drm.DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final com.google.android.exoplayer2.decoder.DecoderInputBuffer flagsOnlyBuffer;
    protected final com.google.android.exoplayer2.FormatHolder formatHolder;
    private final com.google.android.exoplayer2.util.TimedValueQueue<com.google.android.exoplayer2.Format> formatQueue;
    private com.google.android.exoplayer2.video.VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;
    private com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer inputBuffer;
    private com.google.android.exoplayer2.Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer outputBuffer;
    private com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBufferRenderer outputBufferRenderer;
    private com.google.android.exoplayer2.Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private int reportedWidth;
    private com.google.android.exoplayer2.drm.DrmSession sourceDrmSession;
    private android.view.Surface surface;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForKeys;

    private static boolean isBufferLate(long j_renamed) {
        return j_renamed < -30000;
    }

    private static boolean isBufferVeryLate(long j_renamed) {
        return j_renamed < -500000;
    }

    protected abstract com.google.android.exoplayer2.decoder.Decoder<com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer, ? extends com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer, ? extends com.oplus.tblplayer.ffmpeg.DecoderException> createDecoder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.oplus.tblplayer.ffmpeg.DecoderException;

    protected void onQueueInputBuffer(com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer videoDecoderInputBuffer) {
    }

    protected abstract void renderOutputBufferToSurface(com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer, android.view.Surface surface) throws com.oplus.tblplayer.ffmpeg.DecoderException;

    protected abstract void setDecoderOutputMode(int i_renamed);

    protected DecoderVideoRenderer(long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        super(2);
        this.allowedJoiningTimeMs = j_renamed;
        this.maxDroppedFramesToNotify = i_renamed;
        this.joiningDeadlineMs = -9223372036854775807L;
        clearReportedVideoSize();
        this.formatQueue = new com.google.android.exoplayer2.util.TimedValueQueue<>();
        this.flagsOnlyBuffer = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
        this.decoderReinitializationState = 0;
        this.outputMode = -1;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.inputFormat == null) {
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
            onInputFormatChanged(this.formatHolder);
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
            } catch (com.oplus.tblplayer.ffmpeg.DecoderException e_renamed) {
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
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrameAfterReset || !hasOutput()))) {
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

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (i_renamed == 1) {
            setOutputSurface((android.view.Surface) obj);
        } else if (i_renamed == 6) {
            this.frameMetadataListener = (com.google.android.exoplayer2.video.VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i_renamed, obj);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = true;
        this.renderedFirstFrameAfterEnable = false;
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
        this.inputFormat = null;
        this.waitingForKeys = false;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        try {
            setSourceDrmSession(null);
            releaseDecoder();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
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
        com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    protected void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
        com.google.android.exoplayer2.decoder.Decoder<com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer, ? extends com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer, ? extends com.oplus.tblplayer.ffmpeg.DecoderException> decoder = this.decoder;
        if (decoder != null) {
            decoder.release();
            this.decoder = null;
            this.decoderCounters.decoderReleaseCount++;
        }
        setDecoderDrmSession(null);
    }

    protected void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder formatHolder) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.waitingForFirstSampleInFormat = true;
        this.inputFormat = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format);
        if (this.sourceDrmSession != this.decoderDrmSession) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
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

    protected void skipOutputBuffer(com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        videoDecoderOutputBuffer.release();
    }

    protected void dropOutputBuffer(com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        android.util.Log.d_renamed(TAG, "dropOutputBuffer: ");
        updateDroppedBufferCounters(1);
        videoDecoderOutputBuffer.release();
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

    protected void renderOutputBuffer(com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j_renamed, com.google.android.exoplayer2.Format format) throws java.lang.IllegalAccessException, com.oplus.tblplayer.ffmpeg.DecoderException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j_renamed, java.lang.System.nanoTime(), format);
        }
        this.lastRenderTimeUs = com.google.android.exoplayer2.C_renamed.msToUs(android.os.SystemClock.elapsedRealtime() * 1000);
        int i_renamed = videoDecoderOutputBuffer.mode;
        boolean z_renamed = i_renamed == 1 && this.surface != null;
        boolean z2 = i_renamed == 0 && this.outputBufferRenderer != null;
        if (!z2 && !z_renamed) {
            dropOutputBuffer(videoDecoderOutputBuffer);
            return;
        }
        maybeNotifyVideoSizeChanged(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
        if (z2) {
            this.outputBufferRenderer.setOutputBuffer(videoDecoderOutputBuffer);
        } else {
            renderOutputBufferToSurface(videoDecoderOutputBuffer, this.surface);
        }
        this.consecutiveDroppedFrameCount = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
    }

    protected final void setOutputSurface(android.view.Surface surface) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.surface == surface) {
            if (surface != null) {
                onOutputReset();
                return;
            }
            return;
        }
        android.util.Log.d_renamed(TAG, "setOutputSurface: " + surface);
        this.surface = surface;
        if (surface != null) {
            this.outputBufferRenderer = null;
            this.outputMode = 1;
            if (this.decoder != null) {
                setDecoderOutputMode(this.outputMode);
            }
            onOutputChanged();
            return;
        }
        this.outputMode = -1;
        onOutputRemoved();
    }

    protected final void setOutputBufferRenderer(com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.outputBufferRenderer == videoDecoderOutputBufferRenderer) {
            if (videoDecoderOutputBufferRenderer != null) {
                onOutputReset();
                return;
            }
            return;
        }
        this.outputBufferRenderer = videoDecoderOutputBufferRenderer;
        if (videoDecoderOutputBufferRenderer != null) {
            this.surface = null;
            this.outputMode = 0;
            if (this.decoder != null) {
                setDecoderOutputMode(this.outputMode);
            }
            onOutputChanged();
            return;
        }
        this.outputMode = -1;
        onOutputRemoved();
    }

    private void setSourceDrmSession(com.google.android.exoplayer2.drm.DrmSession drmSession) {
        this.sourceDrmSession = drmSession;
    }

    private void setDecoderDrmSession(com.google.android.exoplayer2.drm.DrmSession drmSession) {
        this.decoderDrmSession = drmSession;
    }

    private void maybeInitDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.decoder != null) {
            return;
        }
        setDecoderDrmSession(this.sourceDrmSession);
        com.google.android.exoplayer2.drm.ExoMediaCrypto mediaCrypto = null;
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.decoderDrmSession;
        if (drmSession != null && (mediaCrypto = drmSession.getMediaCrypto()) == null && this.decoderDrmSession.getError() == null) {
            return;
        }
        try {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.decoder = createDecoder(this.inputFormat, mediaCrypto);
            setDecoderOutputMode(this.outputMode);
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            onDecoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (com.oplus.tblplayer.ffmpeg.DecoderException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    private boolean feedInputBuffer() throws java.lang.Exception {
        com.google.android.exoplayer2.decoder.Decoder<com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer, ? extends com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer, ? extends com.oplus.tblplayer.ffmpeg.DecoderException> decoder = this.decoder;
        if (decoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = decoder.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        int source = this.waitingForKeys ? -4 : readSource(this.formatHolder, this.inputBuffer, false);
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            onInputFormatChanged(this.formatHolder);
            return true;
        }
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        if (this.waitingForKeys) {
            return false;
        }
        if (this.waitingForFirstSampleInFormat) {
            this.formatQueue.add(this.inputBuffer.timeUs, this.inputFormat);
            this.waitingForFirstSampleInFormat = false;
        }
        this.inputBuffer.flip();
        this.inputBuffer.colorInfo = this.inputFormat.colorInfo;
        onQueueInputBuffer(this.inputBuffer);
        this.decoder.queueInputBuffer(this.inputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    private boolean drainOutputBuffer(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, com.oplus.tblplayer.ffmpeg.DecoderException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
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

    private boolean processOutputBuffer(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, com.oplus.tblplayer.ffmpeg.DecoderException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j_renamed;
        }
        long j3 = this.outputBuffer.timeUs - j_renamed;
        if (!hasOutput()) {
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
        long jElapsedRealtime = (android.os.SystemClock.elapsedRealtime() * 1000) - this.lastRenderTimeUs;
        boolean z_renamed = getState() == 2;
        if ((this.renderedFirstFrameAfterEnable ? !this.renderedFirstFrameAfterReset : z_renamed || this.mayRenderFirstFrameAfterEnableIfNotStarted) || (z_renamed && shouldForceRenderOutputBuffer(j3, jElapsedRealtime))) {
            renderOutputBuffer(this.outputBuffer, j4, this.outputFormat);
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
            renderOutputBuffer(this.outputBuffer, j4, this.outputFormat);
            return true;
        }
        return false;
    }

    private boolean hasOutput() {
        return this.outputMode != -1;
    }

    private void onOutputChanged() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        maybeRenotifyVideoSizeChanged();
        clearRenderedFirstFrame();
        if (getState() == 2) {
            setJoiningDeadlineMs();
        }
    }

    private void onOutputRemoved() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
    }

    private void onOutputReset() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    private boolean shouldWaitForKeys(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.decoderDrmSession;
        if (drmSession == null || !z_renamed) {
            return false;
        }
        int state = drmSession.getState();
        if (state == 1) {
            android.util.Log.e_renamed(TAG, "shouldWaitForKeys: ");
        }
        return state != 4;
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? android.os.SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrameAfterReset = false;
    }

    private void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (this.renderedFirstFrameAfterReset) {
            return;
        }
        this.renderedFirstFrameAfterReset = true;
        this.eventDispatcher.renderedFirstFrame(this.surface);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrameAfterReset) {
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
