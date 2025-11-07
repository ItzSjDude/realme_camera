package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class TeeAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    private final com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink audioBufferSink;
    private int encoding;
    private boolean inputEnded;
    private boolean isActive;
    private java.nio.ByteBuffer buffer = EMPTY_BUFFER;
    private java.nio.ByteBuffer outputBuffer = EMPTY_BUFFER;
    private int channelCount = -1;
    private int sampleRateHz = -1;

    public interface AudioBufferSink {
        void flush(int i_renamed, int i2, int i3);

        void handleBuffer(java.nio.ByteBuffer byteBuffer);
    }

    public TeeAudioProcessor(com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink audioBufferSink) {
        this.audioBufferSink = (com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink) com.google.android.exoplayer2.util.Assertions.checkNotNull(audioBufferSink);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i_renamed, int i2, int i3) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException {
        this.sampleRateHz = i_renamed;
        this.channelCount = i2;
        this.encoding = i3;
        boolean z_renamed = this.isActive;
        this.isActive = true;
        return !z_renamed;
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
    public int getOutputEncoding() {
        return this.encoding;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(java.nio.ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        this.audioBufferSink.handleBuffer(byteBuffer.asReadOnlyBuffer());
        if (this.buffer.capacity() < iRemaining) {
            this.buffer = java.nio.ByteBuffer.allocateDirect(iRemaining).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        this.buffer.put(byteBuffer);
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
        return this.inputEnded && this.buffer == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.outputBuffer = EMPTY_BUFFER;
        this.inputEnded = false;
        this.audioBufferSink.flush(this.sampleRateHz, this.channelCount, this.encoding);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.sampleRateHz = -1;
        this.channelCount = -1;
        this.encoding = -1;
    }

    public static final class WavFileAudioBufferSink implements com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink {
        private static final int FILE_SIZE_MINUS_44_OFFSET = 40;
        private static final int FILE_SIZE_MINUS_8_OFFSET = 4;
        private static final int HEADER_LENGTH = 44;
        private static final java.lang.String TAG = "WaveFileAudioBufferSink";
        private int bytesWritten;
        private int channelCount;
        private int counter;
        private int encoding;
        private final java.lang.String outputFileNamePrefix;
        private java.io.RandomAccessFile randomAccessFile;
        private int sampleRateHz;
        private final byte[] scratchBuffer = new byte[1024];
        private final java.nio.ByteBuffer scratchByteBuffer = java.nio.ByteBuffer.wrap(this.scratchBuffer).order(java.nio.ByteOrder.LITTLE_ENDIAN);

        public WavFileAudioBufferSink(java.lang.String str) {
            this.outputFileNamePrefix = str;
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void flush(int i_renamed, int i2, int i3) {
            try {
                reset();
            } catch (java.io.IOException e_renamed) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Error resetting", e_renamed);
            }
            this.sampleRateHz = i_renamed;
            this.channelCount = i2;
            this.encoding = i3;
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void handleBuffer(java.nio.ByteBuffer byteBuffer) {
            try {
                maybePrepareFile();
                writeBuffer(byteBuffer);
            } catch (java.io.IOException e_renamed) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Error writing data", e_renamed);
            }
        }

        private void maybePrepareFile() throws java.io.IOException {
            if (this.randomAccessFile != null) {
                return;
            }
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(getNextOutputFileName(), "rw");
            writeFileHeader(randomAccessFile);
            this.randomAccessFile = randomAccessFile;
            this.bytesWritten = 44;
        }

        private void writeFileHeader(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.RIFF_FOURCC);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.WAVE_FOURCC);
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.FMT_FOURCC);
            this.scratchByteBuffer.clear();
            this.scratchByteBuffer.putInt(16);
            this.scratchByteBuffer.putShort((short) com.google.android.exoplayer2.audio.WavUtil.getTypeForEncoding(this.encoding));
            this.scratchByteBuffer.putShort((short) this.channelCount);
            this.scratchByteBuffer.putInt(this.sampleRateHz);
            int pcmFrameSize = com.google.android.exoplayer2.util.Util.getPcmFrameSize(this.encoding, this.channelCount);
            this.scratchByteBuffer.putInt(this.sampleRateHz * pcmFrameSize);
            this.scratchByteBuffer.putShort((short) pcmFrameSize);
            this.scratchByteBuffer.putShort((short) ((pcmFrameSize * 8) / this.channelCount));
            randomAccessFile.write(this.scratchBuffer, 0, this.scratchByteBuffer.position());
            randomAccessFile.writeInt(com.google.android.exoplayer2.audio.WavUtil.DATA_FOURCC);
            randomAccessFile.writeInt(-1);
        }

        private void writeBuffer(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            java.io.RandomAccessFile randomAccessFile = (java.io.RandomAccessFile) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.randomAccessFile);
            while (byteBuffer.hasRemaining()) {
                int iMin = java.lang.Math.min(byteBuffer.remaining(), this.scratchBuffer.length);
                byteBuffer.get(this.scratchBuffer, 0, iMin);
                randomAccessFile.write(this.scratchBuffer, 0, iMin);
                this.bytesWritten += iMin;
            }
        }

        private void reset() throws java.io.IOException {
            java.io.RandomAccessFile randomAccessFile = this.randomAccessFile;
            if (randomAccessFile == null) {
                return;
            }
            try {
                this.scratchByteBuffer.clear();
                this.scratchByteBuffer.putInt(this.bytesWritten - 8);
                randomAccessFile.seek(4L);
                randomAccessFile.write(this.scratchBuffer, 0, 4);
                this.scratchByteBuffer.clear();
                this.scratchByteBuffer.putInt(this.bytesWritten - 44);
                randomAccessFile.seek(40L);
                randomAccessFile.write(this.scratchBuffer, 0, 4);
            } catch (java.io.IOException e_renamed) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Error updating file size", e_renamed);
            }
            try {
                randomAccessFile.close();
            } finally {
                this.randomAccessFile = null;
            }
        }

        private java.lang.String getNextOutputFileName() {
            int i_renamed = this.counter;
            this.counter = i_renamed + 1;
            return com.google.android.exoplayer2.util.Util.formatInvariant("%s_renamed-%04d.wav", this.outputFileNamePrefix, java.lang.Integer.valueOf(i_renamed));
        }
    }
}
