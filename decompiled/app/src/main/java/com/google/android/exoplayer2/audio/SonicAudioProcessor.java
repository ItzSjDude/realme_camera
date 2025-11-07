package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class SonicAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    private static final float CLOSE_THRESHOLD = 0.01f;
    public static final float MAXIMUM_PITCH = 8.0f;
    public static final float MAXIMUM_SPEED = 8.0f;
    public static final float MINIMUM_PITCH = 0.1f;
    public static final float MINIMUM_SPEED = 0.1f;
    private static final int MIN_BYTES_FOR_SPEEDUP_CALCULATION = 1024;
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    private long inputBytes;
    private boolean inputEnded;
    private long outputBytes;
    private com.google.android.exoplayer2.audio.Sonic sonic;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int sampleRateHz = -1;
    private int outputSampleRateHz = -1;
    private java.nio.ByteBuffer buffer = EMPTY_BUFFER;
    private java.nio.ShortBuffer shortBuffer = this.buffer.asShortBuffer();
    private java.nio.ByteBuffer outputBuffer = EMPTY_BUFFER;
    private int pendingOutputSampleRateHz = -1;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    public float setSpeed(float f_renamed) {
        float fConstrainValue = com.google.android.exoplayer2.util.Util.constrainValue(f_renamed, 0.1f, 8.0f);
        if (this.speed != fConstrainValue) {
            this.speed = fConstrainValue;
            this.sonic = null;
        }
        flush();
        return fConstrainValue;
    }

    public float setPitch(float f_renamed) {
        float fConstrainValue = com.google.android.exoplayer2.util.Util.constrainValue(f_renamed, 0.1f, 8.0f);
        if (this.pitch != fConstrainValue) {
            this.pitch = fConstrainValue;
            this.sonic = null;
        }
        flush();
        return fConstrainValue;
    }

    public void setOutputSampleRateHz(int i_renamed) {
        this.pendingOutputSampleRateHz = i_renamed;
    }

    public long scaleDurationForSpeedup(long j_renamed) {
        long j2 = this.outputBytes;
        if (j2 >= 1024) {
            int i_renamed = this.outputSampleRateHz;
            int i2 = this.sampleRateHz;
            if (i_renamed == i2) {
                return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j_renamed, this.inputBytes, j2);
            }
            return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j_renamed, this.inputBytes * i_renamed, j2 * i2);
        }
        return (long) (this.speed * j_renamed);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i_renamed, int i2, int i3) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException(i_renamed, i2, i3);
        }
        int i4 = this.pendingOutputSampleRateHz;
        if (i4 == -1) {
            i4 = i_renamed;
        }
        if (this.sampleRateHz == i_renamed && this.channelCount == i2 && this.outputSampleRateHz == i4) {
            return false;
        }
        this.sampleRateHz = i_renamed;
        this.channelCount = i2;
        this.outputSampleRateHz = i4;
        this.sonic = null;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.sampleRateHz != -1 && (java.lang.Math.abs(this.speed - 1.0f) >= CLOSE_THRESHOLD || java.lang.Math.abs(this.pitch - 1.0f) >= CLOSE_THRESHOLD || this.outputSampleRateHz != this.sampleRateHz);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        return this.channelCount;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        return this.outputSampleRateHz;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.sonic != null);
        if (byteBuffer.hasRemaining()) {
            java.nio.ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.inputBytes += iRemaining;
            this.sonic.queueInput(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int framesAvailable = this.sonic.getFramesAvailable() * this.channelCount * 2;
        if (framesAvailable > 0) {
            if (this.buffer.capacity() < framesAvailable) {
                this.buffer = java.nio.ByteBuffer.allocateDirect(framesAvailable).order(java.nio.ByteOrder.nativeOrder());
                this.shortBuffer = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.shortBuffer.clear();
            }
            this.sonic.getOutput(this.shortBuffer);
            this.outputBytes += framesAvailable;
            this.buffer.limit(framesAvailable);
            this.outputBuffer = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.sonic != null);
        this.sonic.queueEndOfStream();
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
        com.google.android.exoplayer2.audio.Sonic sonic;
        return this.inputEnded && ((sonic = this.sonic) == null || sonic.getFramesAvailable() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            com.google.android.exoplayer2.audio.Sonic sonic = this.sonic;
            if (sonic == null) {
                this.sonic = new com.google.android.exoplayer2.audio.Sonic(this.sampleRateHz, this.channelCount, this.speed, this.pitch, this.outputSampleRateHz);
            } else {
                sonic.flush();
            }
        }
        this.outputBuffer = EMPTY_BUFFER;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputSampleRateHz = -1;
        this.buffer = EMPTY_BUFFER;
        this.shortBuffer = this.buffer.asShortBuffer();
        this.outputBuffer = EMPTY_BUFFER;
        this.pendingOutputSampleRateHz = -1;
        this.sonic = null;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }
}
