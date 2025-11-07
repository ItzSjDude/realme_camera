package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public abstract class SimpleDecoderVideoRenderer extends com.google.android.exoplayer2.BaseRenderer {
    private static final boolean DEBUG = true;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final java.lang.String TAG = "SimpleVideoRenderer";
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder decoder;
    private com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession;
    private final com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private android.view.Surface dummySurface;
    private final com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher eventDispatcher;
    private long fastRendererTimeUs;
    private final com.google.android.exoplayer2.decoder.DecoderInputBuffer flagsOnlyBuffer;
    private boolean forceRenderFrame;
    protected final com.google.android.exoplayer2.FormatHolder formatHolder;
    private long initialPositionUs;
    private com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer inputBuffer;
    private com.google.android.exoplayer2.Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastPresentTimeUs;
    private long lastRenderTimeUs;
    private android.content.Context mAppContext;
    protected final int maxDroppedFramesToNotify;
    private boolean needDropFrame;
    private com.oplus.tblplayer.ffmpeg.FrameOutputBuffer nextOutputBuffer;
    private com.oplus.tblplayer.ffmpeg.FrameOutputBuffer outputBuffer;
    private int outputHeight;
    private boolean outputStreamEnded;
    private int outputWidth;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private int reportedWidth;
    private android.view.Surface surface;
    private boolean waitingForKeys;

    private static boolean isBufferLate(long j_renamed) {
        return j_renamed < -30000;
    }

    private static boolean isBufferVeryLate(long j_renamed) {
        return j_renamed < -500000;
    }

    protected abstract com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder createDecoder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.oplus.tblplayer.exception.VideoDecoderException;

    protected boolean shouldForceRenderOutputBuffer(long j_renamed, long j2) {
        return j_renamed == Long.MIN_VALUE && j2 > 100000;
    }

    protected abstract int supportsFormatInternal(com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format);

    public SimpleDecoderVideoRenderer() {
        this(0L);
    }

    public SimpleDecoderVideoRenderer(long j_renamed) {
        this(null, j_renamed, null, null, 0);
    }

    public SimpleDecoderVideoRenderer(android.content.Context context, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        this(context, j_renamed, handler, videoRendererEventListener, i_renamed, null, false);
    }

    public SimpleDecoderVideoRenderer(android.content.Context context, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, boolean z_renamed) {
        super(2);
        this.mAppContext = context;
        this.allowedJoiningTimeMs = j_renamed;
        this.maxDroppedFramesToNotify = i_renamed;
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z_renamed;
        this.joiningDeadlineMs = -9223372036854775807L;
        clearReportedVideoSize();
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
        this.flagsOnlyBuffer = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = new com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.decoderReinitializationState = 0;
        this.initialPositionUs = -9223372036854775807L;
        this.lastPresentTimeUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        this.needDropFrame = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.InterruptedException {
        if (this.outputStreamEnded) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, java.lang.Integer.toHexString(hashCode()) + " outputStreamEnded");
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
            onInputFormatChanged(this.formatHolder.format);
        }
        maybeInitDecoder();
        if (this.decoder != null) {
            try {
                com.google.android.exoplayer2.util.TraceUtil.beginSection("drainAndFeed");
                while (drainOutputBuffer(j_renamed)) {
                }
                while (feedInputBuffer()) {
                }
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (com.oplus.tblplayer.exception.VideoDecoderException e_renamed) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
            }
        }
    }

    private void onInputFormatChanged(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.InterruptedException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "onInputFormatChanged: " + java.lang.Integer.toHexString(hashCode()));
        com.google.android.exoplayer2.Format format2 = this.inputFormat;
        this.inputFormat = format;
        if (!com.google.android.exoplayer2.util.Util.areEqual(this.inputFormat.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (this.inputFormat.drmInitData != null) {
                com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager = this.drmSessionManager;
                if (drmSessionManager == null) {
                    throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(new java.lang.IllegalStateException("Media requires a_renamed DrmSessionManager"), getIndex());
                }
                this.pendingDrmSession = drmSessionManager.acquireSession(android.os.Looper.myLooper(), this.inputFormat.drmInitData);
                com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession = this.pendingDrmSession;
                if (drmSession == this.drmSession) {
                    this.drmSessionManager.releaseSession(drmSession);
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession2 = this.pendingDrmSession;
        com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession3 = this.drmSession;
        if (drmSession2 != drmSession3 || (drmSession2 == null && drmSession3 == null)) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat);
    }

    private void maybeInitDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.decoder != null) {
            return;
        }
        this.drmSession = this.pendingDrmSession;
        com.google.android.exoplayer2.drm.ExoMediaCrypto mediaCrypto = null;
        com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession = this.drmSession;
        if (drmSession != null && (mediaCrypto = drmSession.getMediaCrypto()) == null) {
            com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error = this.drmSession.getError();
            if (error != null) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(error, getIndex());
            }
            return;
        }
        try {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "maybeInitDecoder: createVideoDecoder");
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.google.android.exoplayer2.util.TraceUtil.beginSection("createVideoDecoder");
            this.decoder = createDecoder(this.inputFormat, mediaCrypto);
            com.google.android.exoplayer2.util.TraceUtil.endSection();
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            this.eventDispatcher.decoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (com.oplus.tblplayer.exception.VideoDecoderException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    private void releaseDecoder() throws java.lang.InterruptedException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "releaseDecoder: ");
        com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder ffmpegOplusVideoDecoder = this.decoder;
        if (ffmpegOplusVideoDecoder == null) {
            return;
        }
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.nextOutputBuffer = null;
        if (this.surface != null) {
            ffmpegOplusVideoDecoder.updateRenderSurface(null);
        }
        this.decoder.release();
        this.decoder = null;
        this.decoderCounters.decoderReleaseCount++;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.forceRenderFrame = false;
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

    private void renderToEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.needDropFrame = false;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean drainOutputBuffer(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.InterruptedException, java.lang.NoSuchMethodException, java.lang.SecurityException, com.oplus.tblplayer.exception.VideoDecoderException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j_renamed;
        }
        if (this.outputBuffer == null) {
            com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer = this.nextOutputBuffer;
            if (frameOutputBuffer != null) {
                this.outputBuffer = frameOutputBuffer;
                this.nextOutputBuffer = null;
            } else {
                this.outputBuffer = this.decoder.dequeueOutputBuffer();
            }
            if (this.outputBuffer == null) {
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "drainOutputBuffer:  no buffers");
                return false;
            }
            this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
            this.buffersInCodecCount -= this.outputBuffer.skippedOutputBufferCount;
        }
        if (this.nextOutputBuffer == null) {
            this.nextOutputBuffer = this.decoder.dequeueOutputBuffer();
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                this.outputStreamEnded = true;
                renderToEndOfStream();
            }
            return false;
        }
        if (this.outputBuffer.timeUs >= this.initialPositionUs) {
            this.needDropFrame = false;
        }
        this.lastPresentTimeUs = this.outputBuffer.timeUs;
        if (this.needDropFrame) {
            long j2 = this.fastRendererTimeUs;
            if (j2 == -9223372036854775807L || j2 > this.lastPresentTimeUs) {
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "need drop timeUs:" + this.lastPresentTimeUs);
                dropBuffer();
                this.buffersInCodecCount = this.buffersInCodecCount - 1;
                return true;
            }
        }
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(this.outputBuffer.timeUs - j_renamed)) {
                return false;
            }
            this.forceRenderFrame = false;
            skipBuffer();
            this.buffersInCodecCount--;
            return true;
        }
        if (this.forceRenderFrame) {
            this.forceRenderFrame = false;
            renderBuffer();
            this.buffersInCodecCount--;
            return true;
        }
        com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer2 = this.nextOutputBuffer;
        long j3 = (frameOutputBuffer2 == null || frameOutputBuffer2.isEndOfStream()) ? -9223372036854775807L : this.nextOutputBuffer.timeUs;
        long j4 = this.outputBuffer.timeUs - j_renamed;
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
        if (!this.renderedFirstFrame || (getState() == 2 && (j4 <= 30000 || shouldForceRenderOutputBuffer(this.outputBuffer.timeUs, jElapsedRealtime - this.lastRenderTimeUs)))) {
            renderBuffer();
            this.buffersInCodecCount--;
            return true;
        }
        if (shouldDropBuffersToKeyframe(j4) && maybeDropBuffersToKeyframe(j_renamed)) {
            this.forceRenderFrame = true;
            return false;
        }
        if (!shouldDropOutputBuffer(this.outputBuffer.timeUs, j3, j_renamed, -9223372036854775807L)) {
            return false;
        }
        dropBuffer();
        this.buffersInCodecCount--;
        return true;
    }

    private boolean shouldDropOutputBuffer(long j_renamed, long j2, long j3, long j4) {
        return isBufferLate(j_renamed - j3) && !(j4 == -9223372036854775807L && j2 == -9223372036854775807L);
    }

    private boolean shouldDropBuffersToKeyframe(long j_renamed) {
        return isBufferVeryLate(j_renamed);
    }

    private void renderBuffer() throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "renderBuffer start");
        if (this.surface == null) {
            dropBuffer();
            return;
        }
        if (this.outputBuffer.width != this.outputWidth || this.outputBuffer.height != this.outputHeight) {
            this.outputWidth = this.outputBuffer.width;
            this.outputHeight = this.outputBuffer.height;
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "renderBuffer: videoSizeChanged [" + this.outputWidth + " x_renamed " + this.outputHeight + "]");
        }
        maybeNotifyVideoSizeChanged(this.outputBuffer.width, this.outputBuffer.height);
        try {
            if (this.outputBuffer.data != null) {
                this.decoder.renderToSurface(this.outputBuffer, this.surface);
                this.lastRenderTimeUs = android.os.SystemClock.elapsedRealtime() * 1000;
            }
        } catch (com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "renderBuffer end");
        this.outputBuffer.release();
        this.outputBuffer = null;
        this.consecutiveDroppedFrameCount = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
    }

    private void dropBuffer() {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "dropBuffer");
        updateDroppedBufferCounters(1);
        this.outputBuffer.release();
        this.outputBuffer = null;
    }

    private boolean maybeDropBuffersToKeyframe(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.InterruptedException {
        int iSkipSource = skipSource(j_renamed);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource);
        flushDecoder();
        return true;
    }

    private void updateDroppedBufferCounters(int i_renamed) {
        this.decoderCounters.droppedBufferCount += i_renamed;
        this.droppedFrames += i_renamed;
        this.consecutiveDroppedFrameCount += i_renamed;
        com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.maxConsecutiveDroppedBufferCount = java.lang.Math.max(this.consecutiveDroppedFrameCount, decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    private void skipBuffer() {
        this.decoderCounters.skippedOutputBufferCount++;
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "skipBuffer: " + this.decoderCounters.skippedOutputBufferCount);
        this.outputBuffer.release();
        this.outputBuffer = null;
    }

    private void flushDecoder() throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.InterruptedException {
        this.waitingForKeys = false;
        this.forceRenderFrame = false;
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer = this.outputBuffer;
        if (frameOutputBuffer != null) {
            frameOutputBuffer.release();
            this.outputBuffer = null;
        }
        com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer2 = this.nextOutputBuffer;
        if (frameOutputBuffer2 != null) {
            frameOutputBuffer2.release();
            this.nextOutputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    private boolean feedInputBuffer() throws java.lang.Exception {
        int source;
        com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder ffmpegOplusVideoDecoder = this.decoder;
        if (ffmpegOplusVideoDecoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = ffmpegOplusVideoDecoder.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer((com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder) this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        if (this.waitingForKeys) {
            source = -4;
        } else {
            try {
                source = readSource(this.formatHolder, this.inputBuffer, false);
            } catch (java.lang.OutOfMemoryError e_renamed) {
                e_renamed.printStackTrace();
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(new java.lang.Exception(e_renamed), getIndex());
            }
        }
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        }
        if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer((com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder) this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        if (this.waitingForKeys) {
            return false;
        }
        this.inputBuffer.flip();
        queueInputBuffer(this.decoder, this.inputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    protected void queueInputBuffer(com.oplus.tblplayer.ffmpeg.SimpleDecoder<com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer, ? extends com.oplus.tblplayer.ffmpeg.FrameOutputBuffer, ? extends com.oplus.tblplayer.exception.VideoDecoderException> simpleDecoder, com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer ffmpegVideoInputBuffer) throws java.lang.Exception {
        simpleDecoder.queueInputBuffer((com.oplus.tblplayer.ffmpeg.SimpleDecoder<com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer, ? extends com.oplus.tblplayer.ffmpeg.FrameOutputBuffer, ? extends com.oplus.tblplayer.exception.VideoDecoderException>) ffmpegVideoInputBuffer);
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

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (i_renamed == 1) {
            setSurface((android.view.Surface) obj);
        } else {
            if (i_renamed == 4) {
                return;
            }
            super.handleMessage(i_renamed, obj);
        }
    }

    private void setSurface(android.view.Surface surface) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (surface == null) {
            android.view.Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else if (this.decoder != null) {
                this.dummySurface = com.google.android.exoplayer2.video.DummySurface.newInstanceV17(this.mAppContext, false);
                surface = this.dummySurface;
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder ffmpegOplusVideoDecoder = this.decoder;
                if (ffmpegOplusVideoDecoder != null && surface != null) {
                    ffmpegOplusVideoDecoder.updateRenderSurface(surface);
                } else {
                    com.oplus.tblplayer.ffmpeg.FfmpegUtil.i_renamed(TAG, "setSurface: Don't_renamed release SW decoder");
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

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? android.os.SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrame = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected boolean getRenderedFirstFrame() {
        return this.renderedFirstFrame;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected long getLastPresentTimeUs() {
        return this.lastPresentTimeUs;
    }

    private void maybeNotifyRenderedFirstFrame() {
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
    }

    private void maybeNotifyVideoSizeChanged(int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.reportedWidth == i_renamed && this.reportedHeight == i2) {
            return;
        }
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "maybeNotifyVideoSizeChanged: [" + i_renamed + " x_renamed " + i2 + "]");
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

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.waitingForKeys) {
            return false;
        }
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.renderedFirstFrame || this.surface == null))) {
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
        super.onEnabled(z_renamed);
        this.decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException, java.lang.InterruptedException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "onPositionReset: " + j_renamed);
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.lastPresentTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
        clearRenderedFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z_renamed) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.lastPresentTimeUs >= j_renamed) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "invalid positionUs:" + j_renamed + ",lastPresentTimeUs:" + this.lastPresentTimeUs);
            return;
        }
        this.needDropFrame = true;
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.fastRendererTimeUs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onSetFastRendererPosition(long j_renamed, boolean z_renamed) {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "onSetFastRendererPosition positionUs:" + j_renamed);
        this.fastRendererTimeUs = j_renamed;
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
        this.outputWidth = -1;
        this.outputHeight = -1;
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

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable()) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.e_renamed(TAG, "CoreLibrary not available");
            return 0;
        }
        int iSupportsFormatInternal = supportsFormatInternal(this.drmSessionManager, format);
        if (iSupportsFormatInternal <= 2) {
            return iSupportsFormatInternal;
        }
        return iSupportsFormatInternal | (com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? 32 : 0) | 8;
    }
}
