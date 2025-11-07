package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public abstract class SimpleDecoderAudioRenderer extends com.google.android.exoplayer2.BaseRenderer implements com.google.android.exoplayer2.util.MediaClock {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final com.google.android.exoplayer2.audio.AudioSink audioSink;
    private boolean audioTrackNeedsConfigure;
    private long currentPositionUs;
    private com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.audio.AudioDecoderException> decoder;
    private com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession;
    private final com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager;
    private int encoderDelay;
    private int encoderPadding;
    private final com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher;
    private final com.google.android.exoplayer2.decoder.DecoderInputBuffer flagsOnlyBuffer;
    private final com.google.android.exoplayer2.FormatHolder formatHolder;
    private com.google.android.exoplayer2.decoder.DecoderInputBuffer inputBuffer;
    private com.google.android.exoplayer2.Format inputFormat;
    private boolean inputStreamEnded;
    private com.google.android.exoplayer2.decoder.SimpleOutputBuffer outputBuffer;
    private boolean outputStreamEnded;
    private com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean waitingForKeys;

    protected abstract com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.audio.AudioDecoderException> createDecoder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.google.android.exoplayer2.audio.AudioDecoderException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return this;
    }

    protected void onAudioSessionId(int i_renamed) {
    }

    protected void onAudioTrackPositionDiscontinuity() {
    }

    protected void onAudioTrackUnderrun(int i_renamed, long j_renamed, long j2) {
    }

    protected abstract int supportsFormatInternal(com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format);

    public SimpleDecoderAudioRenderer() {
        this((android.os.Handler) null, (com.google.android.exoplayer2.audio.AudioRendererEventListener) null, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public SimpleDecoderAudioRenderer(android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, null, null, false, audioProcessorArr);
    }

    public SimpleDecoderAudioRenderer(android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities) {
        this(handler, audioRendererEventListener, audioCapabilities, null, false, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public SimpleDecoderAudioRenderer(android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, boolean z_renamed, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, drmSessionManager, z_renamed, new com.google.android.exoplayer2.audio.DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public SimpleDecoderAudioRenderer(android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, boolean z_renamed, com.google.android.exoplayer2.audio.AudioSink audioSink) {
        super(1);
        this.drmSessionManager = drmSessionManager;
        this.playClearSamplesWithoutKeys = z_renamed;
        this.eventDispatcher = new com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSink = audioSink;
        audioSink.setListener(new com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.AudioSinkListener());
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
        this.flagsOnlyBuffer = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = true;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(com.google.android.exoplayer2.Format format) {
        if (!com.google.android.exoplayer2.util.MimeTypes.isAudio(format.sampleMimeType)) {
            return 0;
        }
        int iSupportsFormatInternal = supportsFormatInternal(this.drmSessionManager, format);
        if (iSupportsFormatInternal <= 2) {
            return iSupportsFormatInternal;
        }
        return iSupportsFormatInternal | (com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? 32 : 0) | 8;
    }

    protected final boolean supportsOutput(int i_renamed, int i2) {
        return this.audioSink.supportsOutput(i_renamed, i2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.outputStreamEnded) {
            try {
                this.audioSink.playToEndOfStream();
                return;
            } catch (com.google.android.exoplayer2.audio.AudioSink.WriteException e_renamed) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
            }
        }
        if (this.inputFormat == null) {
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
        maybeInitDecoder();
        if (this.decoder != null) {
            try {
                com.google.android.exoplayer2.util.TraceUtil.beginSection("drainAndFeed");
                while (drainOutputBuffer()) {
                }
                while (feedInputBuffer()) {
                }
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (com.google.android.exoplayer2.audio.AudioDecoderException | com.google.android.exoplayer2.audio.AudioSink.ConfigurationException | com.google.android.exoplayer2.audio.AudioSink.InitializationException | com.google.android.exoplayer2.audio.AudioSink.WriteException e2) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }

    protected com.google.android.exoplayer2.Format getOutputFormat() {
        return com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW, null, -1, -1, this.inputFormat.channelCount, this.inputFormat.sampleRate, 2, null, null, 0, null);
    }

    private boolean drainOutputBuffer() throws com.google.android.exoplayer2.ExoPlaybackException, com.google.android.exoplayer2.audio.AudioSink.WriteException, com.google.android.exoplayer2.audio.AudioDecoderException, com.google.android.exoplayer2.audio.AudioSink.InitializationException, com.google.android.exoplayer2.audio.AudioSink.ConfigurationException {
        if (this.outputBuffer == null) {
            this.outputBuffer = (com.google.android.exoplayer2.decoder.SimpleOutputBuffer) this.decoder.dequeueOutputBuffer();
            com.google.android.exoplayer2.decoder.SimpleOutputBuffer simpleOutputBuffer = this.outputBuffer;
            if (simpleOutputBuffer == null) {
                return false;
            }
            if (simpleOutputBuffer.skippedOutputBufferCount > 0) {
                this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
                this.audioSink.handleDiscontinuity();
            }
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                processEndOfStream();
            }
            return false;
        }
        if (this.audioTrackNeedsConfigure) {
            com.google.android.exoplayer2.Format outputFormat = getOutputFormat();
            this.audioSink.configure(outputFormat.pcmEncoding, outputFormat.channelCount, outputFormat.sampleRate, 0, null, this.encoderDelay, this.encoderPadding);
            this.audioTrackNeedsConfigure = false;
        }
        if (!this.audioSink.handleBuffer(this.outputBuffer.data, this.outputBuffer.timeUs)) {
            return false;
        }
        this.decoderCounters.renderedOutputBufferCount++;
        this.outputBuffer.release();
        this.outputBuffer = null;
        return true;
    }

    private boolean feedInputBuffer() throws java.lang.Exception {
        com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.audio.AudioDecoderException> simpleDecoder = this.decoder;
        if (simpleDecoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            this.inputBuffer = simpleDecoder.dequeueInputBuffer();
            if (this.inputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer((com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.audio.AudioDecoderException>) this.inputBuffer);
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
            this.decoder.queueInputBuffer((com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.audio.AudioDecoderException>) this.inputBuffer);
            this.inputBuffer = null;
            return false;
        }
        this.waitingForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
        if (this.waitingForKeys) {
            return false;
        }
        this.inputBuffer.flip();
        onQueueInputBuffer(this.inputBuffer);
        this.decoder.queueInputBuffer((com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.audio.AudioDecoderException>) this.inputBuffer);
        this.decoderReceivedBuffers = true;
        this.decoderCounters.inputBufferCount++;
        this.inputBuffer = null;
        return true;
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

    private void processEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.outputStreamEnded = true;
        try {
            this.audioSink.playToEndOfStream();
        } catch (com.google.android.exoplayer2.audio.AudioSink.WriteException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    private void flushDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.waitingForKeys = false;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        com.google.android.exoplayer2.decoder.SimpleOutputBuffer simpleOutputBuffer = this.outputBuffer;
        if (simpleOutputBuffer != null) {
            simpleOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded && this.audioSink.isEnded();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.audioSink.hasPendingData() || !(this.inputFormat == null || this.waitingForKeys || (!isSourceReady() && this.outputBuffer == null));
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        return this.audioSink.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
        this.eventDispatcher.enabled(this.decoderCounters);
        int i_renamed = getConfiguration().tunnelingAudioSessionId;
        if (i_renamed != 0) {
            this.audioSink.enableTunnelingV21(i_renamed);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.audioSink.reset();
        this.currentPositionUs = j_renamed;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoder != null) {
            flushDecoder();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        this.audioSink.play();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.inputFormat = null;
        this.audioTrackNeedsConfigure = true;
        this.waitingForKeys = false;
        try {
            releaseDecoder();
            this.audioSink.release();
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

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i_renamed == 2) {
            this.audioSink.setVolume(((java.lang.Float) obj).floatValue());
            return;
        }
        if (i_renamed == 3) {
            this.audioSink.setAudioAttributes((com.google.android.exoplayer2.audio.AudioAttributes) obj);
        } else if (i_renamed == 5) {
            this.audioSink.setAuxEffectInfo((com.google.android.exoplayer2.audio.AuxEffectInfo) obj);
        } else {
            super.handleMessage(i_renamed, obj);
        }
    }

    private void maybeInitDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.decoder != null) {
            return;
        }
        this.drmSession = this.pendingDrmSession;
        com.google.android.exoplayer2.drm.ExoMediaCrypto mediaCrypto = null;
        com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSession = this.drmSession;
        if (drmSession != null && (mediaCrypto = drmSession.getMediaCrypto()) == null && this.drmSession.getError() == null) {
            return;
        }
        try {
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.google.android.exoplayer2.util.TraceUtil.beginSection("createAudioDecoder");
            this.decoder = createDecoder(this.inputFormat, mediaCrypto);
            com.google.android.exoplayer2.util.TraceUtil.endSection();
            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            this.eventDispatcher.decoderInitialized(this.decoder.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (com.google.android.exoplayer2.audio.AudioDecoderException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    private void releaseDecoder() {
        com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.audio.AudioDecoderException> simpleDecoder = this.decoder;
        if (simpleDecoder == null) {
            return;
        }
        this.inputBuffer = null;
        this.outputBuffer = null;
        simpleDecoder.release();
        this.decoder = null;
        this.decoderCounters.decoderReleaseCount++;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
    }

    private void onInputFormatChanged(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
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
        if (this.decoderReceivedBuffers) {
            this.decoderReinitializationState = 1;
        } else {
            releaseDecoder();
            maybeInitDecoder();
            this.audioTrackNeedsConfigure = true;
        }
        this.encoderDelay = format.encoderDelay;
        this.encoderPadding = format.encoderPadding;
        this.eventDispatcher.inputFormatChanged(format);
    }

    private void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
        if (!this.allowFirstBufferPositionDiscontinuity || decoderInputBuffer.isDecodeOnly()) {
            return;
        }
        if (java.lang.Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
            this.currentPositionUs = decoderInputBuffer.timeUs;
        }
        this.allowFirstBufferPositionDiscontinuity = false;
    }

    private void updateCurrentPosition() {
        long currentPositionUs = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs = java.lang.Math.max(this.currentPositionUs, currentPositionUs);
            }
            this.currentPositionUs = currentPositionUs;
            this.allowPositionDiscontinuity = false;
        }
    }

    private final class AudioSinkListener implements com.google.android.exoplayer2.audio.AudioSink.Listener {
        private AudioSinkListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i_renamed) {
            com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.this.eventDispatcher.audioSessionId(i_renamed);
            com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.this.onAudioSessionId(i_renamed);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i_renamed, long j_renamed, long j2) {
            com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.this.eventDispatcher.audioTrackUnderrun(i_renamed, j_renamed, j2);
            com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer.this.onAudioTrackUnderrun(i_renamed, j_renamed, j2);
        }
    }
}
