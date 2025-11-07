package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
final class TrimmingAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    private static final int OUTPUT_ENCODING = 2;
    private int bytesPerFrame;
    private int endBufferSize;
    private boolean inputEnded;
    private boolean isActive;
    private int pendingTrimStartBytes;
    private boolean receivedInputSinceConfigure;
    private int trimEndFrames;
    private int trimStartFrames;
    private long trimmedFrameCount;
    private java.nio.ByteBuffer buffer = EMPTY_BUFFER;
    private java.nio.ByteBuffer outputBuffer = EMPTY_BUFFER;
    private int channelCount = -1;
    private int sampleRateHz = -1;
    private byte[] endBuffer = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    public void setTrimFrameCount(int i_renamed, int i2) {
        this.trimStartFrames = i_renamed;
        this.trimEndFrames = i2;
    }

    public void resetTrimmedFrameCount() {
        this.trimmedFrameCount = 0L;
    }

    public long getTrimmedFrameCount() {
        return this.trimmedFrameCount;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i_renamed, int i2, int i3) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException(i_renamed, i2, i3);
        }
        if (this.endBufferSize > 0) {
            this.trimmedFrameCount += r8 / this.bytesPerFrame;
        }
        this.channelCount = i2;
        this.sampleRateHz = i_renamed;
        this.bytesPerFrame = com.google.android.exoplayer2.util.Util.getPcmFrameSize(2, i2);
        int i4 = this.trimEndFrames;
        int i5 = this.bytesPerFrame;
        this.endBuffer = new byte[i4 * i5];
        this.endBufferSize = 0;
        int i6 = this.trimStartFrames;
        this.pendingTrimStartBytes = i5 * i6;
        boolean z_renamed = this.isActive;
        this.isActive = (i6 == 0 && i4 == 0) ? false : true;
        this.receivedInputSinceConfigure = false;
        return z_renamed != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
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
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i_renamed = iLimit - iPosition;
        if (i_renamed == 0) {
            return;
        }
        this.receivedInputSinceConfigure = true;
        int iMin = java.lang.Math.min(i_renamed, this.pendingTrimStartBytes);
        this.trimmedFrameCount += iMin / this.bytesPerFrame;
        this.pendingTrimStartBytes -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.pendingTrimStartBytes > 0) {
            return;
        }
        int i2 = i_renamed - iMin;
        int length = (this.endBufferSize + i2) - this.endBuffer.length;
        if (this.buffer.capacity() < length) {
            this.buffer = java.nio.ByteBuffer.allocateDirect(length).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        int iConstrainValue = com.google.android.exoplayer2.util.Util.constrainValue(length, 0, this.endBufferSize);
        this.buffer.put(this.endBuffer, 0, iConstrainValue);
        int iConstrainValue2 = com.google.android.exoplayer2.util.Util.constrainValue(length - iConstrainValue, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iConstrainValue2);
        this.buffer.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iConstrainValue2;
        this.endBufferSize -= iConstrainValue;
        byte[] bArr = this.endBuffer;
        java.lang.System.arraycopy(bArr, iConstrainValue, bArr, 0, this.endBufferSize);
        byteBuffer.get(this.endBuffer, this.endBufferSize, i3);
        this.endBufferSize += i3;
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
        if (this.inputEnded && this.endBufferSize > 0 && byteBuffer == EMPTY_BUFFER) {
            int iCapacity = this.buffer.capacity();
            int i_renamed = this.endBufferSize;
            if (iCapacity < i_renamed) {
                this.buffer = java.nio.ByteBuffer.allocateDirect(i_renamed).order(java.nio.ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            this.buffer.put(this.endBuffer, 0, this.endBufferSize);
            this.endBufferSize = 0;
            this.buffer.flip();
            byteBuffer = this.buffer;
        }
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.inputEnded && this.endBufferSize == 0 && this.outputBuffer == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.outputBuffer = EMPTY_BUFFER;
        this.inputEnded = false;
        if (this.receivedInputSinceConfigure) {
            this.pendingTrimStartBytes = 0;
        }
        this.endBufferSize = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.endBuffer = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }
}
