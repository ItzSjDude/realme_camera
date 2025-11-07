package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
final class FloatResamplingAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    private static final int FLOAT_NAN_AS_INT = java.lang.Float.floatToIntBits(Float.NaN);
    private static final double PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR = 4.656612875245797E-10d;
    private boolean inputEnded;
    private int sampleRateHz = -1;
    private int channelCount = -1;
    private int sourceEncoding = 0;
    private java.nio.ByteBuffer buffer = EMPTY_BUFFER;
    private java.nio.ByteBuffer outputBuffer = EMPTY_BUFFER;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 4;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i_renamed, int i2, int i3) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException {
        if (!com.google.android.exoplayer2.util.Util.isEncodingHighResolutionIntegerPcm(i3)) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException(i_renamed, i2, i3);
        }
        if (this.sampleRateHz == i_renamed && this.channelCount == i2 && this.sourceEncoding == i3) {
            return false;
        }
        this.sampleRateHz = i_renamed;
        this.channelCount = i2;
        this.sourceEncoding = i3;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return com.google.android.exoplayer2.util.Util.isEncodingHighResolutionIntegerPcm(this.sourceEncoding);
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
        boolean z_renamed = this.sourceEncoding == 1073741824;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i_renamed = iLimit - iPosition;
        if (!z_renamed) {
            i_renamed = (i_renamed / 3) * 4;
        }
        if (this.buffer.capacity() < i_renamed) {
            this.buffer = java.nio.ByteBuffer.allocateDirect(i_renamed).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        if (z_renamed) {
            while (iPosition < iLimit) {
                writePcm32BitFloat((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), this.buffer);
                iPosition += 4;
            }
        } else {
            while (iPosition < iLimit) {
                writePcm32BitFloat(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), this.buffer);
                iPosition += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.inputEnded = true;
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
        this.outputBuffer = EMPTY_BUFFER;
        this.inputEnded = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.sampleRateHz = -1;
        this.channelCount = -1;
        this.sourceEncoding = 0;
        this.buffer = EMPTY_BUFFER;
    }

    private static void writePcm32BitFloat(int i_renamed, java.nio.ByteBuffer byteBuffer) {
        int iFloatToIntBits = java.lang.Float.floatToIntBits((float) (i_renamed * PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR));
        if (iFloatToIntBits == FLOAT_NAN_AS_INT) {
            iFloatToIntBits = java.lang.Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }
}
