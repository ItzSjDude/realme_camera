package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class SilenceSkippingAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    private static final long MINIMUM_SILENCE_DURATION_US = 150000;
    private static final long PADDING_SILENCE_US = 20000;
    private static final short SILENCE_THRESHOLD_LEVEL = 1024;
    private static final byte SILENCE_THRESHOLD_LEVEL_MSB = 4;
    private static final int STATE_MAYBE_SILENT = 1;
    private static final int STATE_NOISY = 0;
    private static final int STATE_SILENT = 2;
    private int bytesPerFrame;
    private boolean enabled;
    private boolean hasOutputNoise;
    private boolean inputEnded;
    private int maybeSilenceBufferSize;
    private int paddingSize;
    private long skippedFrames;
    private int state;
    private java.nio.ByteBuffer buffer = EMPTY_BUFFER;
    private java.nio.ByteBuffer outputBuffer = EMPTY_BUFFER;
    private int channelCount = -1;
    private int sampleRateHz = -1;
    private byte[] maybeSilenceBuffer = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    private byte[] paddingBuffer = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    public void setEnabled(boolean z_renamed) {
        this.enabled = z_renamed;
        flush();
    }

    public long getSkippedFrames() {
        return this.skippedFrames;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i_renamed, int i2, int i3) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException(i_renamed, i2, i3);
        }
        if (this.sampleRateHz == i_renamed && this.channelCount == i2) {
            return false;
        }
        this.sampleRateHz = i_renamed;
        this.channelCount = i2;
        this.bytesPerFrame = i2 * 2;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.sampleRateHz != -1 && this.enabled;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        return this.channelCount;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.outputBuffer.hasRemaining()) {
            int i_renamed = this.state;
            if (i_renamed == 0) {
                processNoisy(byteBuffer);
            } else if (i_renamed == 1) {
                processMaybeSilence(byteBuffer);
            } else if (i_renamed == 2) {
                processSilence(byteBuffer);
            } else {
                throw new java.lang.IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.inputEnded = true;
        int i_renamed = this.maybeSilenceBufferSize;
        if (i_renamed > 0) {
            output(this.maybeSilenceBuffer, i_renamed);
        }
        if (this.hasOutputNoise) {
            return;
        }
        this.skippedFrames += this.paddingSize / this.bytesPerFrame;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public java.nio.ByteBuffer getOutput() {
        java.nio.ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.inputEnded && this.outputBuffer == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            int iDurationUsToFrames = durationUsToFrames(MINIMUM_SILENCE_DURATION_US) * this.bytesPerFrame;
            if (this.maybeSilenceBuffer.length != iDurationUsToFrames) {
                this.maybeSilenceBuffer = new byte[iDurationUsToFrames];
            }
            this.paddingSize = durationUsToFrames(PADDING_SILENCE_US) * this.bytesPerFrame;
            int length = this.paddingBuffer.length;
            int i_renamed = this.paddingSize;
            if (length != i_renamed) {
                this.paddingBuffer = new byte[i_renamed];
            }
        }
        this.state = 0;
        this.outputBuffer = EMPTY_BUFFER;
        this.inputEnded = false;
        this.skippedFrames = 0L;
        this.maybeSilenceBufferSize = 0;
        this.hasOutputNoise = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.enabled = false;
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.paddingSize = 0;
        this.maybeSilenceBuffer = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
        this.paddingBuffer = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }

    private void processNoisy(java.nio.ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(java.lang.Math.min(iLimit, byteBuffer.position() + this.maybeSilenceBuffer.length));
        int iFindNoiseLimit = findNoiseLimit(byteBuffer);
        if (iFindNoiseLimit == byteBuffer.position()) {
            this.state = 1;
        } else {
            byteBuffer.limit(iFindNoiseLimit);
            output(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void processMaybeSilence(java.nio.ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iFindNoisePosition = findNoisePosition(byteBuffer);
        int iPosition = iFindNoisePosition - byteBuffer.position();
        byte[] bArr = this.maybeSilenceBuffer;
        int length = bArr.length;
        int i_renamed = this.maybeSilenceBufferSize;
        int i2 = length - i_renamed;
        if (iFindNoisePosition < iLimit && iPosition < i2) {
            output(bArr, i_renamed);
            this.maybeSilenceBufferSize = 0;
            this.state = 0;
            return;
        }
        int iMin = java.lang.Math.min(iPosition, i2);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.maybeSilenceBuffer, this.maybeSilenceBufferSize, iMin);
        this.maybeSilenceBufferSize += iMin;
        int i3 = this.maybeSilenceBufferSize;
        byte[] bArr2 = this.maybeSilenceBuffer;
        if (i3 == bArr2.length) {
            if (this.hasOutputNoise) {
                output(bArr2, this.paddingSize);
                this.skippedFrames += (this.maybeSilenceBufferSize - (this.paddingSize * 2)) / this.bytesPerFrame;
            } else {
                this.skippedFrames += (i3 - this.paddingSize) / this.bytesPerFrame;
            }
            updatePaddingBuffer(byteBuffer, this.maybeSilenceBuffer, this.maybeSilenceBufferSize);
            this.maybeSilenceBufferSize = 0;
            this.state = 2;
        }
        byteBuffer.limit(iLimit);
    }

    private void processSilence(java.nio.ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iFindNoisePosition = findNoisePosition(byteBuffer);
        byteBuffer.limit(iFindNoisePosition);
        this.skippedFrames += byteBuffer.remaining() / this.bytesPerFrame;
        updatePaddingBuffer(byteBuffer, this.paddingBuffer, this.paddingSize);
        if (iFindNoisePosition < iLimit) {
            output(this.paddingBuffer, this.paddingSize);
            this.state = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private void output(byte[] bArr, int i_renamed) {
        prepareForOutput(i_renamed);
        this.buffer.put(bArr, 0, i_renamed);
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    private void output(java.nio.ByteBuffer byteBuffer) {
        prepareForOutput(byteBuffer.remaining());
        this.buffer.put(byteBuffer);
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    private void prepareForOutput(int i_renamed) {
        if (this.buffer.capacity() < i_renamed) {
            this.buffer = java.nio.ByteBuffer.allocateDirect(i_renamed).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        if (i_renamed > 0) {
            this.hasOutputNoise = true;
        }
    }

    private void updatePaddingBuffer(java.nio.ByteBuffer byteBuffer, byte[] bArr, int i_renamed) {
        int iMin = java.lang.Math.min(byteBuffer.remaining(), this.paddingSize);
        int i2 = this.paddingSize - iMin;
        java.lang.System.arraycopy(bArr, i_renamed - i2, this.paddingBuffer, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.paddingBuffer, i2, iMin);
    }

    private int durationUsToFrames(long j_renamed) {
        return (int) ((j_renamed * this.sampleRateHz) / 1000000);
    }

    private int findNoisePosition(java.nio.ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (java.lang.Math.abs((int) byteBuffer.get(iPosition)) > 4) {
                int i_renamed = this.bytesPerFrame;
                return i_renamed * (iPosition / i_renamed);
            }
        }
        return byteBuffer.limit();
    }

    private int findNoiseLimit(java.nio.ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (java.lang.Math.abs((int) byteBuffer.get(iLimit)) > 4) {
                int i_renamed = this.bytesPerFrame;
                return ((iLimit / i_renamed) * i_renamed) + i_renamed;
            }
        }
        return byteBuffer.position();
    }
}
