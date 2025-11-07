package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
final class ChannelMappingAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    private boolean active;
    private boolean inputEnded;
    private int[] outputChannels;
    private int[] pendingOutputChannels;
    private java.nio.ByteBuffer buffer = EMPTY_BUFFER;
    private java.nio.ByteBuffer outputBuffer = EMPTY_BUFFER;
    private int channelCount = -1;
    private int sampleRateHz = -1;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    public void setChannelMap(int[] iArr) {
        this.pendingOutputChannels = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i_renamed, int i2, int i3) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException {
        boolean z_renamed = !java.util.Arrays.equals(this.pendingOutputChannels, this.outputChannels);
        this.outputChannels = this.pendingOutputChannels;
        if (this.outputChannels == null) {
            this.active = false;
            return z_renamed;
        }
        if (i3 != 2) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException(i_renamed, i2, i3);
        }
        if (!z_renamed && this.sampleRateHz == i_renamed && this.channelCount == i2) {
            return false;
        }
        this.sampleRateHz = i_renamed;
        this.channelCount = i2;
        this.active = i2 != this.outputChannels.length;
        int i4 = 0;
        while (true) {
            int[] iArr = this.outputChannels;
            if (i4 >= iArr.length) {
                return true;
            }
            int i5 = iArr[i4];
            if (i5 >= i2) {
                throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException(i_renamed, i2, i3);
            }
            this.active = (i5 != i4) | this.active;
            i4++;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.active;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        int[] iArr = this.outputChannels;
        return iArr == null ? this.channelCount : iArr.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.outputChannels != null);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = ((iLimit - iPosition) / (this.channelCount * 2)) * this.outputChannels.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = java.nio.ByteBuffer.allocateDirect(length).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        while (iPosition < iLimit) {
            for (int i_renamed : this.outputChannels) {
                this.buffer.putShort(byteBuffer.getShort((i_renamed * 2) + iPosition));
            }
            iPosition += this.channelCount * 2;
        }
        byteBuffer.position(iLimit);
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
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputChannels = null;
        this.pendingOutputChannels = null;
        this.active = false;
    }
}
