package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class DefaultAudioSink implements com.google.android.exoplayer2.audio.AudioSink {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final int ERROR_BAD_VALUE = -2;
    private static final long MAX_BUFFER_DURATION_US = 750000;
    private static final long MIN_BUFFER_DURATION_US = 250000;
    private static final int MODE_STATIC = 0;
    private static final int MODE_STREAM = 1;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final java.lang.String TAG = "AudioTrack";

    @android.annotation.SuppressLint({"InlinedApi"})
    private static final int WRITE_NON_BLOCKING = 1;
    public static boolean enablePreV21AudioSessionWorkaround;
    public static boolean failOnSpuriousAudioTimestamp;
    private com.google.android.exoplayer2.audio.AudioProcessor[] activeAudioProcessors;
    private com.google.android.exoplayer2.PlaybackParameters afterDrainPlaybackParameters;
    private com.google.android.exoplayer2.audio.AudioAttributes audioAttributes;
    private final com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities;
    private final com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    private android.media.AudioTrack audioTrack;
    private final com.google.android.exoplayer2.audio.AudioTrackPositionTracker audioTrackPositionTracker;
    private com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo;
    private java.nio.ByteBuffer avSyncHeader;
    private int bufferSize;
    private int bytesUntilNextAvSync;
    private boolean canApplyPlaybackParameters;
    private final com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private int drainingAudioProcessorIndex;
    private final boolean enableConvertHighResIntPcmToFloat;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private java.nio.ByteBuffer inputBuffer;
    private int inputSampleRate;
    private boolean isInputPcm;
    private android.media.AudioTrack keepSessionIdAudioTrack;
    private long lastFeedElapsedRealtimeMs;
    private com.google.android.exoplayer2.audio.AudioSink.Listener listener;
    private java.nio.ByteBuffer outputBuffer;
    private java.nio.ByteBuffer[] outputBuffers;
    private int outputChannelConfig;
    private int outputEncoding;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private int pcmFrameSize;
    private com.google.android.exoplayer2.PlaybackParameters playbackParameters;
    private final java.util.ArrayDeque<com.google.android.exoplayer2.audio.DefaultAudioSink.PlaybackParametersCheckpoint> playbackParametersCheckpoints;
    private long playbackParametersOffsetUs;
    private long playbackParametersPositionUs;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private boolean processingEnabled;
    private final android.os.ConditionVariable releasingConditionVariable;
    private boolean shouldConvertHighResIntPcmToFloat;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final com.google.android.exoplayer2.audio.AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final com.google.android.exoplayer2.audio.AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final com.google.android.exoplayer2.audio.TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public interface AudioProcessorChain {
        com.google.android.exoplayer2.PlaybackParameters applyPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters);

        com.google.android.exoplayer2.audio.AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j_renamed);

        long getSkippedOutputFrameCount();
    }

    public static final class InvalidAudioTrackTimestampException extends java.lang.RuntimeException {
        private InvalidAudioTrackTimestampException(java.lang.String str) {
            super(str);
        }
    }

    public static class DefaultAudioProcessorChain implements com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain {
        private final com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessors;
        private final com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor();
        private final com.google.android.exoplayer2.audio.SonicAudioProcessor sonicAudioProcessor = new com.google.android.exoplayer2.audio.SonicAudioProcessor();

        public DefaultAudioProcessorChain(com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
            this.audioProcessors = (com.google.android.exoplayer2.audio.AudioProcessor[]) java.util.Arrays.copyOf(audioProcessorArr, audioProcessorArr.length + 2);
            com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr2 = this.audioProcessors;
            audioProcessorArr2[audioProcessorArr.length] = this.silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = this.sonicAudioProcessor;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public com.google.android.exoplayer2.audio.AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public com.google.android.exoplayer2.PlaybackParameters applyPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            this.silenceSkippingAudioProcessor.setEnabled(playbackParameters.skipSilence);
            return new com.google.android.exoplayer2.PlaybackParameters(this.sonicAudioProcessor.setSpeed(playbackParameters.speed), this.sonicAudioProcessor.setPitch(playbackParameters.pitch), playbackParameters.skipSilence);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getMediaDuration(long j_renamed) {
            return this.sonicAudioProcessor.scaleDurationForSpeedup(j_renamed);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }
    }

    public DefaultAudioSink(com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities, audioProcessorArr, false);
    }

    public DefaultAudioSink(com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr, boolean z_renamed) {
        this(audioCapabilities, new com.google.android.exoplayer2.audio.DefaultAudioSink.DefaultAudioProcessorChain(audioProcessorArr), z_renamed);
    }

    public DefaultAudioSink(com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain audioProcessorChain, boolean z_renamed) {
        this.audioCapabilities = audioCapabilities;
        this.audioProcessorChain = (com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain) com.google.android.exoplayer2.util.Assertions.checkNotNull(audioProcessorChain);
        this.enableConvertHighResIntPcmToFloat = z_renamed;
        this.releasingConditionVariable = new android.os.ConditionVariable(true);
        this.audioTrackPositionTracker = new com.google.android.exoplayer2.audio.AudioTrackPositionTracker(new com.google.android.exoplayer2.audio.DefaultAudioSink.PositionTrackerListener());
        this.channelMappingAudioProcessor = new com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor();
        this.trimmingAudioProcessor = new com.google.android.exoplayer2.audio.TrimmingAudioProcessor();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Collections.addAll(arrayList, new com.google.android.exoplayer2.audio.ResamplingAudioProcessor(), this.channelMappingAudioProcessor, this.trimmingAudioProcessor);
        java.util.Collections.addAll(arrayList, audioProcessorChain.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (com.google.android.exoplayer2.audio.AudioProcessor[]) arrayList.toArray(new com.google.android.exoplayer2.audio.AudioProcessor[arrayList.size()]);
        this.toFloatPcmAvailableAudioProcessors = new com.google.android.exoplayer2.audio.AudioProcessor[]{new com.google.android.exoplayer2.audio.FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.startMediaTimeState = 0;
        this.audioAttributes = com.google.android.exoplayer2.audio.AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.auxEffectInfo = new com.google.android.exoplayer2.audio.AuxEffectInfo(0, 0.0f);
        this.playbackParameters = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new com.google.android.exoplayer2.audio.AudioProcessor[0];
        this.outputBuffers = new java.nio.ByteBuffer[0];
        this.playbackParametersCheckpoints = new java.util.ArrayDeque<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(com.google.android.exoplayer2.audio.AudioSink.Listener listener) {
        this.listener = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsOutput(int i_renamed, int i2) {
        if (com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(i2)) {
            return i2 != 4 || com.google.android.exoplayer2.util.Util.SDK_INT >= 21;
        }
        com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities = this.audioCapabilities;
        return audioCapabilities != null && audioCapabilities.supportsEncoding(i2) && (i_renamed == -1 || i_renamed <= this.audioCapabilities.getMaxChannelCount());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z_renamed) {
        if (!isInitialized() || this.startMediaTimeState == 0) {
            return Long.MIN_VALUE;
        }
        return this.startMediaTimeUs + applySkipping(applySpeedup(java.lang.Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z_renamed), framesToDurationUs(getWrittenFrames()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void configure(int i_renamed, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws java.lang.IllegalStateException, com.google.android.exoplayer2.audio.AudioSink.ConfigurationException {
        int outputSampleRateHz;
        int outputEncoding;
        boolean zConfigure;
        this.inputSampleRate = i3;
        this.isInputPcm = com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(i_renamed);
        this.shouldConvertHighResIntPcmToFloat = this.enableConvertHighResIntPcmToFloat && supportsOutput(i2, 4) && com.google.android.exoplayer2.util.Util.isEncodingHighResolutionIntegerPcm(i_renamed);
        if (this.isInputPcm) {
            this.pcmFrameSize = com.google.android.exoplayer2.util.Util.getPcmFrameSize(i_renamed, i2);
        }
        boolean z_renamed = this.isInputPcm && i_renamed != 4;
        this.canApplyPlaybackParameters = z_renamed && !this.shouldConvertHighResIntPcmToFloat;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21 && i2 == 8 && iArr == null) {
            iArr = new int[6];
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr[i7] = i7;
            }
        }
        if (z_renamed) {
            this.trimmingAudioProcessor.setTrimFrameCount(i5, i6);
            this.channelMappingAudioProcessor.setChannelMap(iArr);
            outputSampleRateHz = i3;
            outputEncoding = i_renamed;
            zConfigure = false;
            for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor : getAvailableAudioProcessors()) {
                try {
                    zConfigure |= audioProcessor.configure(outputSampleRateHz, i2, outputEncoding);
                    if (audioProcessor.isActive()) {
                        i2 = audioProcessor.getOutputChannelCount();
                        outputSampleRateHz = audioProcessor.getOutputSampleRateHz();
                        outputEncoding = audioProcessor.getOutputEncoding();
                    }
                } catch (com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException e_renamed) {
                    throw new com.google.android.exoplayer2.audio.AudioSink.ConfigurationException(e_renamed);
                }
            }
        } else {
            outputSampleRateHz = i3;
            outputEncoding = i_renamed;
            zConfigure = false;
        }
        int channelConfig = getChannelConfig(i2, this.isInputPcm);
        if (channelConfig == 0) {
            throw new com.google.android.exoplayer2.audio.AudioSink.ConfigurationException("Unsupported channel count: " + i2);
        }
        if (!zConfigure && isInitialized() && this.outputEncoding == outputEncoding && this.outputSampleRate == outputSampleRateHz && this.outputChannelConfig == channelConfig) {
            return;
        }
        reset();
        this.processingEnabled = z_renamed;
        this.outputSampleRate = outputSampleRateHz;
        this.outputChannelConfig = channelConfig;
        this.outputEncoding = outputEncoding;
        this.outputPcmFrameSize = this.isInputPcm ? com.google.android.exoplayer2.util.Util.getPcmFrameSize(this.outputEncoding, i2) : -1;
        if (i4 == 0) {
            i4 = getDefaultBufferSize();
        }
        this.bufferSize = i4;
    }

    private int getDefaultBufferSize() {
        if (this.isInputPcm) {
            int minBufferSize = android.media.AudioTrack.getMinBufferSize(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
            com.google.android.exoplayer2.util.Assertions.checkState(minBufferSize != -2);
            return com.google.android.exoplayer2.util.Util.constrainValue(minBufferSize * 4, ((int) durationUsToFrames(250000L)) * this.outputPcmFrameSize, (int) java.lang.Math.max(minBufferSize, durationUsToFrames(MAX_BUFFER_DURATION_US) * this.outputPcmFrameSize));
        }
        int maximumEncodedRateBytesPerSecond = getMaximumEncodedRateBytesPerSecond(this.outputEncoding);
        if (this.outputEncoding == 5) {
            maximumEncodedRateBytesPerSecond *= 2;
        }
        return (int) ((maximumEncodedRateBytesPerSecond * 250000) / 1000000);
    }

    private void setupAudioProcessors() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor : getAvailableAudioProcessors()) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.activeAudioProcessors = (com.google.android.exoplayer2.audio.AudioProcessor[]) arrayList.toArray(new com.google.android.exoplayer2.audio.AudioProcessor[size]);
        this.outputBuffers = new java.nio.ByteBuffer[size];
        flushAudioProcessors();
    }

    private void flushAudioProcessors() {
        int i_renamed = 0;
        while (true) {
            com.google.android.exoplayer2.audio.AudioProcessor[] audioProcessorArr = this.activeAudioProcessors;
            if (i_renamed >= audioProcessorArr.length) {
                return;
            }
            com.google.android.exoplayer2.audio.AudioProcessor audioProcessor = audioProcessorArr[i_renamed];
            audioProcessor.flush();
            this.outputBuffers[i_renamed] = audioProcessor.getOutput();
            i_renamed++;
        }
    }

    private void initialize() throws com.google.android.exoplayer2.audio.AudioSink.InitializationException {
        this.releasingConditionVariable.block();
        this.audioTrack = initializeAudioTrack();
        int audioSessionId = this.audioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            android.media.AudioTrack audioTrack = this.keepSessionIdAudioTrack;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(audioSessionId);
            }
        }
        if (this.audioSessionId != audioSessionId) {
            this.audioSessionId = audioSessionId;
            com.google.android.exoplayer2.audio.AudioSink.Listener listener = this.listener;
            if (listener != null) {
                listener.onAudioSessionId(audioSessionId);
            }
        }
        this.playbackParameters = this.canApplyPlaybackParameters ? this.audioProcessorChain.applyPlaybackParameters(this.playbackParameters) : com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
        setupAudioProcessors();
        this.audioTrackPositionTracker.setAudioTrack(this.audioTrack, this.outputEncoding, this.outputPcmFrameSize, this.bufferSize);
        setVolumeInternal();
        if (this.auxEffectInfo.effectId != 0) {
            this.audioTrack.attachAuxEffect(this.auxEffectInfo.effectId);
            this.audioTrack.setAuxEffectSendLevel(this.auxEffectInfo.sendLevel);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() throws java.lang.IllegalStateException {
        this.playing = true;
        if (isInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        if (this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(java.nio.ByteBuffer byteBuffer, long j_renamed) throws java.lang.IllegalStateException, com.google.android.exoplayer2.audio.AudioSink.WriteException, com.google.android.exoplayer2.audio.AudioSink.InitializationException {
        java.nio.ByteBuffer byteBuffer2 = this.inputBuffer;
        com.google.android.exoplayer2.util.Assertions.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            initialize();
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.isInputPcm && this.framesPerEncodedSample == 0) {
                this.framesPerEncodedSample = getFramesPerEncodedSample(this.outputEncoding, byteBuffer);
                if (this.framesPerEncodedSample == 0) {
                    return true;
                }
            }
            if (this.afterDrainPlaybackParameters != null) {
                if (!drainAudioProcessorsToEndOfStream()) {
                    return false;
                }
                com.google.android.exoplayer2.PlaybackParameters playbackParameters = this.afterDrainPlaybackParameters;
                this.afterDrainPlaybackParameters = null;
                this.playbackParametersCheckpoints.add(new com.google.android.exoplayer2.audio.DefaultAudioSink.PlaybackParametersCheckpoint(this.audioProcessorChain.applyPlaybackParameters(playbackParameters), java.lang.Math.max(0L, j_renamed), framesToDurationUs(getWrittenFrames())));
                setupAudioProcessors();
            }
            if (this.startMediaTimeState == 0) {
                this.startMediaTimeUs = java.lang.Math.max(0L, j_renamed);
                this.startMediaTimeState = 1;
            } else {
                long jInputFramesToDurationUs = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames() - this.trimmingAudioProcessor.getTrimmedFrameCount());
                if (this.startMediaTimeState == 1 && java.lang.Math.abs(jInputFramesToDurationUs - j_renamed) > 200000) {
                    com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Discontinuity detected [expected " + jInputFramesToDurationUs + ", got " + j_renamed + "]");
                    this.startMediaTimeState = 2;
                }
                if (this.startMediaTimeState == 2) {
                    long j2 = j_renamed - jInputFramesToDurationUs;
                    this.startMediaTimeUs += j2;
                    this.startMediaTimeState = 1;
                    com.google.android.exoplayer2.audio.AudioSink.Listener listener = this.listener;
                    if (listener != null && j2 != 0) {
                        listener.onPositionDiscontinuity();
                    }
                }
            }
            if (this.isInputPcm) {
                this.submittedPcmBytes += byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += this.framesPerEncodedSample;
            }
            this.inputBuffer = byteBuffer;
        }
        if (this.processingEnabled) {
            processBuffers(j_renamed);
        } else {
            writeBuffer(this.inputBuffer, j_renamed);
        }
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            return true;
        }
        if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return false;
        }
        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Resetting stalled audio track");
        reset();
        return true;
    }

    private void processBuffers(long j_renamed) throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        java.nio.ByteBuffer byteBuffer;
        int length = this.activeAudioProcessors.length;
        int i_renamed = length;
        while (i_renamed >= 0) {
            if (i_renamed > 0) {
                byteBuffer = this.outputBuffers[i_renamed - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i_renamed == length) {
                writeBuffer(byteBuffer, j_renamed);
            } else {
                com.google.android.exoplayer2.audio.AudioProcessor audioProcessor = this.activeAudioProcessors[i_renamed];
                audioProcessor.queueInput(byteBuffer);
                java.nio.ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i_renamed] = output;
                if (output.hasRemaining()) {
                    i_renamed++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i_renamed--;
            }
        }
    }

    private void writeBuffer(java.nio.ByteBuffer byteBuffer, long j_renamed) throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        if (byteBuffer.hasRemaining()) {
            java.nio.ByteBuffer byteBuffer2 = this.outputBuffer;
            int iWriteNonBlockingV21 = 0;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.Assertions.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.outputBuffer = byteBuffer;
                if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.preV21OutputBuffer;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.preV21OutputBuffer = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.preV21OutputBuffer, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.preV21OutputBufferOffset = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
                int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if (availableBufferSize > 0) {
                    iWriteNonBlockingV21 = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, java.lang.Math.min(iRemaining2, availableBufferSize));
                    if (iWriteNonBlockingV21 > 0) {
                        this.preV21OutputBufferOffset += iWriteNonBlockingV21;
                        byteBuffer.position(byteBuffer.position() + iWriteNonBlockingV21);
                    }
                }
            } else if (this.tunneling) {
                com.google.android.exoplayer2.util.Assertions.checkState(j_renamed != -9223372036854775807L);
                iWriteNonBlockingV21 = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, iRemaining2, j_renamed);
            } else {
                iWriteNonBlockingV21 = writeNonBlockingV21(this.audioTrack, byteBuffer, iRemaining2);
            }
            this.lastFeedElapsedRealtimeMs = android.os.SystemClock.elapsedRealtime();
            if (iWriteNonBlockingV21 < 0) {
                throw new com.google.android.exoplayer2.audio.AudioSink.WriteException(iWriteNonBlockingV21);
            }
            if (this.isInputPcm) {
                this.writtenPcmBytes += iWriteNonBlockingV21;
            }
            if (iWriteNonBlockingV21 == iRemaining2) {
                if (!this.isInputPcm) {
                    this.writtenEncodedFrames += this.framesPerEncodedSample;
                }
                this.outputBuffer = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws java.lang.IllegalStateException, com.google.android.exoplayer2.audio.AudioSink.WriteException {
        if (!this.handledEndOfStream && isInitialized() && drainAudioProcessorsToEndOfStream()) {
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
            this.handledEndOfStream = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B_renamed:19:0x0032 -> B_renamed:9:0x0012). Please report as_renamed a_renamed decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean drainAudioProcessorsToEndOfStream() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.drainingAudioProcessorIndex
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.processingEnabled
            if (r0 == 0) goto Ld
            r0 = r3
            goto L10
        Ld:
            com.google.android.exoplayer2.audio.AudioProcessor[] r0 = r9.activeAudioProcessors
            int r0 = r0.length
        L10:
            r9.drainingAudioProcessorIndex = r0
        L12:
            r0 = r2
            goto L15
        L14:
            r0 = r3
        L15:
            int r4 = r9.drainingAudioProcessorIndex
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.activeAudioProcessors
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.queueEndOfStream()
        L28:
            r9.processBuffers(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.drainingAudioProcessorIndex
            int r0 = r0 + r2
            r9.drainingAudioProcessorIndex = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L44
            r9.writeBuffer(r0, r7)
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L44
            return r3
        L44:
            r9.drainingAudioProcessorIndex = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.drainAudioProcessorsToEndOfStream():boolean");
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !isInitialized() || (this.handledEndOfStream && !hasPendingData());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return isInitialized() && this.audioTrackPositionTracker.hasPendingData(getWrittenFrames());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public com.google.android.exoplayer2.PlaybackParameters setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        if (isInitialized() && !this.canApplyPlaybackParameters) {
            this.playbackParameters = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
            return this.playbackParameters;
        }
        com.google.android.exoplayer2.PlaybackParameters playbackParameters2 = this.afterDrainPlaybackParameters;
        if (playbackParameters2 == null) {
            playbackParameters2 = !this.playbackParametersCheckpoints.isEmpty() ? this.playbackParametersCheckpoints.getLast().playbackParameters : this.playbackParameters;
        }
        if (!playbackParameters.equals(playbackParameters2)) {
            if (isInitialized()) {
                this.afterDrainPlaybackParameters = playbackParameters;
            } else {
                this.playbackParameters = this.audioProcessorChain.applyPlaybackParameters(playbackParameters);
            }
        }
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) throws java.lang.IllegalStateException {
        if (this.audioAttributes.equals(audioAttributes)) {
            return;
        }
        this.audioAttributes = audioAttributes;
        if (this.tunneling) {
            return;
        }
        reset();
        this.audioSessionId = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i_renamed) throws java.lang.IllegalStateException {
        if (this.audioSessionId != i_renamed) {
            this.audioSessionId = i_renamed;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo) {
        if (this.auxEffectInfo.equals(auxEffectInfo)) {
            return;
        }
        int i_renamed = auxEffectInfo.effectId;
        float f_renamed = auxEffectInfo.sendLevel;
        if (this.audioTrack != null) {
            if (this.auxEffectInfo.effectId != i_renamed) {
                this.audioTrack.attachAuxEffect(i_renamed);
            }
            if (i_renamed != 0) {
                this.audioTrack.setAuxEffectSendLevel(f_renamed);
            }
        }
        this.auxEffectInfo = auxEffectInfo;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i_renamed) throws java.lang.IllegalStateException {
        com.google.android.exoplayer2.util.Assertions.checkState(com.google.android.exoplayer2.util.Util.SDK_INT >= 21);
        if (this.tunneling && this.audioSessionId == i_renamed) {
            return;
        }
        this.tunneling = true;
        this.audioSessionId = i_renamed;
        reset();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() throws java.lang.IllegalStateException {
        if (this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f_renamed) {
        if (this.volume != f_renamed) {
            this.volume = f_renamed;
            setVolumeInternal();
        }
    }

    private void setVolumeInternal() {
        if (isInitialized()) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() throws java.lang.IllegalStateException {
        this.playing = false;
        if (isInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() throws java.lang.IllegalStateException {
        if (isInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.writtenPcmBytes = 0L;
            this.writtenEncodedFrames = 0L;
            this.framesPerEncodedSample = 0;
            com.google.android.exoplayer2.PlaybackParameters playbackParameters = this.afterDrainPlaybackParameters;
            if (playbackParameters != null) {
                this.playbackParameters = playbackParameters;
                this.afterDrainPlaybackParameters = null;
            } else if (!this.playbackParametersCheckpoints.isEmpty()) {
                this.playbackParameters = this.playbackParametersCheckpoints.getLast().playbackParameters;
            }
            this.playbackParametersCheckpoints.clear();
            this.playbackParametersOffsetUs = 0L;
            this.playbackParametersPositionUs = 0L;
            this.trimmingAudioProcessor.resetTrimmedFrameCount();
            this.inputBuffer = null;
            this.outputBuffer = null;
            flushAudioProcessors();
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            this.startMediaTimeState = 0;
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            final android.media.AudioTrack audioTrack = this.audioTrack;
            this.audioTrack = null;
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            new java.lang.Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        com.google.android.exoplayer2.audio.DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() throws java.lang.IllegalStateException {
        reset();
        releaseKeepSessionIdAudioTrack();
        for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor : this.toIntPcmAvailableAudioProcessors) {
            audioProcessor.reset();
        }
        for (com.google.android.exoplayer2.audio.AudioProcessor audioProcessor2 : this.toFloatPcmAvailableAudioProcessors) {
            audioProcessor2.reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void releaseKeepSessionIdAudioTrack() {
        final android.media.AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack == null) {
            return;
        }
        this.keepSessionIdAudioTrack = null;
        new java.lang.Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                audioTrack.release();
            }
        }.start();
    }

    private long applySpeedup(long j_renamed) {
        long j2;
        long mediaDurationForPlayoutDuration;
        com.google.android.exoplayer2.audio.DefaultAudioSink.PlaybackParametersCheckpoint playbackParametersCheckpointRemove = null;
        while (!this.playbackParametersCheckpoints.isEmpty() && j_renamed >= this.playbackParametersCheckpoints.getFirst().positionUs) {
            playbackParametersCheckpointRemove = this.playbackParametersCheckpoints.remove();
        }
        if (playbackParametersCheckpointRemove != null) {
            this.playbackParameters = playbackParametersCheckpointRemove.playbackParameters;
            this.playbackParametersPositionUs = playbackParametersCheckpointRemove.positionUs;
            this.playbackParametersOffsetUs = playbackParametersCheckpointRemove.mediaTimeUs - this.startMediaTimeUs;
        }
        if (this.playbackParameters.speed == 1.0f) {
            return (j_renamed + this.playbackParametersOffsetUs) - this.playbackParametersPositionUs;
        }
        if (this.playbackParametersCheckpoints.isEmpty()) {
            j2 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = this.audioProcessorChain.getMediaDuration(j_renamed - this.playbackParametersPositionUs);
        } else {
            j2 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = com.google.android.exoplayer2.util.Util.getMediaDurationForPlayoutDuration(j_renamed - this.playbackParametersPositionUs, this.playbackParameters.speed);
        }
        return j2 + mediaDurationForPlayoutDuration;
    }

    private long applySkipping(long j_renamed) {
        return j_renamed + framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private boolean isInitialized() {
        return this.audioTrack != null;
    }

    private long inputFramesToDurationUs(long j_renamed) {
        return (j_renamed * 1000000) / this.inputSampleRate;
    }

    private long framesToDurationUs(long j_renamed) {
        return (j_renamed * 1000000) / this.outputSampleRate;
    }

    private long durationUsToFrames(long j_renamed) {
        return (j_renamed * this.outputSampleRate) / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getSubmittedFrames() {
        return this.isInputPcm ? this.submittedPcmBytes / this.pcmFrameSize : this.submittedEncodedFrames;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getWrittenFrames() {
        return this.isInputPcm ? this.writtenPcmBytes / this.outputPcmFrameSize : this.writtenEncodedFrames;
    }

    private android.media.AudioTrack initializeAudioTrack() throws com.google.android.exoplayer2.audio.AudioSink.InitializationException {
        android.media.AudioTrack audioTrack;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            audioTrack = createAudioTrackV21();
        } else {
            int streamTypeForAudioUsage = com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
            int i_renamed = this.audioSessionId;
            if (i_renamed == 0) {
                audioTrack = new android.media.AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
            } else {
                audioTrack = new android.media.AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, i_renamed);
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (java.lang.Exception unused) {
        }
        throw new com.google.android.exoplayer2.audio.AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize);
    }

    @android.annotation.TargetApi(21)
    private android.media.AudioTrack createAudioTrackV21() {
        android.media.AudioAttributes audioAttributesV21;
        if (this.tunneling) {
            audioAttributesV21 = new android.media.AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            audioAttributesV21 = this.audioAttributes.getAudioAttributesV21();
        }
        android.media.AudioAttributes audioAttributes = audioAttributesV21;
        android.media.AudioFormat audioFormatBuild = new android.media.AudioFormat.Builder().setChannelMask(this.outputChannelConfig).setEncoding(this.outputEncoding).setSampleRate(this.outputSampleRate).build();
        int i_renamed = this.audioSessionId;
        if (i_renamed == 0) {
            i_renamed = 0;
        }
        return new android.media.AudioTrack(audioAttributes, audioFormatBuild, this.bufferSize, 1, i_renamed);
    }

    private android.media.AudioTrack initializeKeepSessionIdAudioTrack(int i_renamed) {
        return new android.media.AudioTrack(3, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_ASSET, 4, 2, 2, 0, i_renamed);
    }

    private com.google.android.exoplayer2.audio.AudioProcessor[] getAvailableAudioProcessors() {
        return this.shouldConvertHighResIntPcmToFloat ? this.toFloatPcmAvailableAudioProcessors : this.toIntPcmAvailableAudioProcessors;
    }

    private static int getChannelConfig(int i_renamed, boolean z_renamed) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 28 && !z_renamed) {
            if (i_renamed == 7) {
                i_renamed = 8;
            } else if (i_renamed == 3 || i_renamed == 4 || i_renamed == 5) {
                i_renamed = 6;
            }
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 26 && "fugu".equals(com.google.android.exoplayer2.util.Util.DEVICE) && !z_renamed && i_renamed == 1) {
            i_renamed = 2;
        }
        return com.google.android.exoplayer2.util.Util.getAudioTrackChannelConfig(i_renamed);
    }

    private static int getMaximumEncodedRateBytesPerSecond(int i_renamed) {
        if (i_renamed == 5) {
            return 80000;
        }
        if (i_renamed == 6) {
            return 768000;
        }
        if (i_renamed == 7) {
            return 192000;
        }
        if (i_renamed == 8) {
            return 2250000;
        }
        if (i_renamed == 14) {
            return 3062500;
        }
        if (i_renamed == 17) {
            return 336000;
        }
        throw new java.lang.IllegalArgumentException();
    }

    private static int getFramesPerEncodedSample(int i_renamed, java.nio.ByteBuffer byteBuffer) {
        if (i_renamed == 7 || i_renamed == 8) {
            return com.google.android.exoplayer2.audio.DtsUtil.parseDtsAudioSampleCount(byteBuffer);
        }
        if (i_renamed == 5) {
            return com.google.android.exoplayer2.audio.Ac3Util.getAc3SyncframeAudioSampleCount();
        }
        if (i_renamed == 6) {
            return com.google.android.exoplayer2.audio.Ac3Util.parseEAc3SyncframeAudioSampleCount(byteBuffer);
        }
        if (i_renamed == 14) {
            int iFindTrueHdSyncframeOffset = com.google.android.exoplayer2.audio.Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
            if (iFindTrueHdSyncframeOffset == -1) {
                return 0;
            }
            return com.google.android.exoplayer2.audio.Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, iFindTrueHdSyncframeOffset) * 16;
        }
        if (i_renamed == 17) {
            return com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer);
        }
        throw new java.lang.IllegalStateException("Unexpected audio encoding: " + i_renamed);
    }

    @android.annotation.TargetApi(21)
    private static int writeNonBlockingV21(android.media.AudioTrack audioTrack, java.nio.ByteBuffer byteBuffer, int i_renamed) {
        return audioTrack.write(byteBuffer, i_renamed, 1);
    }

    @android.annotation.TargetApi(21)
    private int writeNonBlockingWithAvSyncV21(android.media.AudioTrack audioTrack, java.nio.ByteBuffer byteBuffer, int i_renamed, long j_renamed) {
        if (this.avSyncHeader == null) {
            this.avSyncHeader = java.nio.ByteBuffer.allocate(16);
            this.avSyncHeader.order(java.nio.ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i_renamed);
            this.avSyncHeader.putLong(8, j_renamed * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i_renamed;
        }
        int iRemaining = this.avSyncHeader.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.avSyncHeader, iRemaining, 1);
            if (iWrite < 0) {
                this.bytesUntilNextAvSync = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iWriteNonBlockingV21 = writeNonBlockingV21(audioTrack, byteBuffer, i_renamed);
        if (iWriteNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return iWriteNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= iWriteNonBlockingV21;
        return iWriteNonBlockingV21;
    }

    @android.annotation.TargetApi(21)
    private static void setVolumeInternalV21(android.media.AudioTrack audioTrack, float f_renamed) {
        audioTrack.setVolume(f_renamed);
    }

    private static void setVolumeInternalV3(android.media.AudioTrack audioTrack, float f_renamed) {
        audioTrack.setStereoVolume(f_renamed, f_renamed);
    }

    private static final class PlaybackParametersCheckpoint {
        private final long mediaTimeUs;
        private final com.google.android.exoplayer2.PlaybackParameters playbackParameters;
        private final long positionUs;

        private PlaybackParametersCheckpoint(com.google.android.exoplayer2.PlaybackParameters playbackParameters, long j_renamed, long j2) {
            this.playbackParameters = playbackParameters;
            this.mediaTimeUs = j_renamed;
            this.positionUs = j2;
        }
    }

    private final class PositionTrackerListener implements com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionFramesMismatch(long j_renamed, long j2, long j3, long j4) {
            java.lang.String str = "Spurious audio timestamp (frame position mismatch): " + j_renamed + ", " + j2 + ", " + j3 + ", " + j4 + ", " + com.google.android.exoplayer2.audio.DefaultAudioSink.this.getSubmittedFrames() + ", " + com.google.android.exoplayer2.audio.DefaultAudioSink.this.getWrittenFrames();
            if (com.google.android.exoplayer2.audio.DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new com.google.android.exoplayer2.audio.DefaultAudioSink.InvalidAudioTrackTimestampException(str);
            }
            com.google.android.exoplayer2.util.Log.w_renamed(com.google.android.exoplayer2.audio.DefaultAudioSink.TAG, str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onSystemTimeUsMismatch(long j_renamed, long j2, long j3, long j4) {
            java.lang.String str = "Spurious audio timestamp (system clock mismatch): " + j_renamed + ", " + j2 + ", " + j3 + ", " + j4 + ", " + com.google.android.exoplayer2.audio.DefaultAudioSink.this.getSubmittedFrames() + ", " + com.google.android.exoplayer2.audio.DefaultAudioSink.this.getWrittenFrames();
            if (com.google.android.exoplayer2.audio.DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new com.google.android.exoplayer2.audio.DefaultAudioSink.InvalidAudioTrackTimestampException(str);
            }
            com.google.android.exoplayer2.util.Log.w_renamed(com.google.android.exoplayer2.audio.DefaultAudioSink.TAG, str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onInvalidLatency(long j_renamed) {
            com.google.android.exoplayer2.util.Log.w_renamed(com.google.android.exoplayer2.audio.DefaultAudioSink.TAG, "Ignoring impossibly large audio latency: " + j_renamed);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onUnderrun(int i_renamed, long j_renamed) {
            if (com.google.android.exoplayer2.audio.DefaultAudioSink.this.listener != null) {
                com.google.android.exoplayer2.audio.DefaultAudioSink.this.listener.onUnderrun(i_renamed, j_renamed, android.os.SystemClock.elapsedRealtime() - com.google.android.exoplayer2.audio.DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }
}
