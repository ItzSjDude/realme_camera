package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
final class FfmpegAudioDecoder extends com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.SimpleOutputBuffer, com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException> {
    private static final int ERROR_DECODING = 3;
    private static final int ERROR_INIT = 2;
    private static final int ERROR_LOAD_LIB = 1;
    private static final int ERROR_OTHER = 5;
    private static final int ERROR_RESETTING = 4;
    private static final int OUTPUT_BUFFER_SIZE = 368640;
    private volatile int channelCount;
    private final java.lang.String codecName;
    private final byte[] codecParametersData;
    private final byte[] extraData;
    private boolean hasOutputFormat;
    private long nativeContext;
    private volatile int sampleRate;

    private static native byte[] ffmpegCreateCodecParametersData(int i_renamed, int i2);

    private native int ffmpegDecode(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed, java.nio.ByteBuffer byteBuffer2, int i2);

    private native int ffmpegGetChannelCount(long j_renamed);

    private native int ffmpegGetSampleRate(long j_renamed);

    private native long ffmpegInitialize(java.lang.String str, byte[] bArr, byte[] bArr2);

    private native void ffmpegRelease(long j_renamed);

    private native long ffmpegReset(long j_renamed, byte[] bArr, byte[] bArr2);

    public FfmpegAudioDecoder(int i_renamed, int i2, int i3, com.google.android.exoplayer2.Format format) throws com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException {
        super(new com.google.android.exoplayer2.decoder.DecoderInputBuffer[i_renamed], new com.google.android.exoplayer2.decoder.SimpleOutputBuffer[i2]);
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable()) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(1, "Failed to load decoder native libraries.");
        }
        this.codecName = com.oplus.tblplayer.ffmpeg.FfmpegLibrary.getCodecName(format.sampleMimeType);
        this.extraData = getExtraData(format);
        this.codecParametersData = getCodecParametersData(format);
        this.nativeContext = ffmpegInitialize(this.codecName, this.extraData, this.codecParametersData);
        if (this.nativeContext == 0) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(2, "Initialization failed. Mime type: " + format.sampleMimeType + ", codec name: " + this.codecName);
        }
        setInitialInputBufferSize(i3);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "Ffmpeg." + com.oplus.tblplayer.ffmpeg.FfmpegLibrary.getVersion() + "." + this.codecName;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.google.android.exoplayer2.decoder.DecoderInputBuffer createInputBuffer() {
        return new com.google.android.exoplayer2.decoder.DecoderInputBuffer(2);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.google.android.exoplayer2.decoder.SimpleOutputBuffer createOutputBuffer() {
        return new com.google.android.exoplayer2.decoder.SimpleOutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException createUnexpectedDecodeException(java.lang.Throwable th) {
        return new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(5, "audio decode failed.", th);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException decode(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, com.google.android.exoplayer2.decoder.SimpleOutputBuffer simpleOutputBuffer, boolean z_renamed) {
        if (z_renamed) {
            this.nativeContext = ffmpegReset(this.nativeContext, this.extraData, this.codecParametersData);
            if (this.nativeContext == 0) {
                return new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(4, "Error resetting (see logcat).");
            }
        }
        java.nio.ByteBuffer byteBuffer = decoderInputBuffer.data;
        int iFfmpegDecode = ffmpegDecode(this.nativeContext, byteBuffer, byteBuffer.limit(), simpleOutputBuffer.init(decoderInputBuffer.timeUs, OUTPUT_BUFFER_SIZE), OUTPUT_BUFFER_SIZE);
        if (iFfmpegDecode < 0) {
            return new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(3, "Error decoding (see logcat). result: " + iFfmpegDecode);
        }
        if (!this.hasOutputFormat) {
            this.channelCount = ffmpegGetChannelCount(this.nativeContext);
            this.sampleRate = ffmpegGetSampleRate(this.nativeContext);
            if (this.sampleRate == 0 && "alac".equals(this.codecName)) {
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(this.extraData);
                parsableByteArray.setPosition(this.extraData.length - 4);
                this.sampleRate = parsableByteArray.readUnsignedIntToInt();
            }
            this.hasOutputFormat = true;
        }
        simpleOutputBuffer.data.position(0);
        simpleOutputBuffer.data.limit(iFfmpegDecode);
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    private static byte[] getExtraData(com.google.android.exoplayer2.Format format) {
        return com.oplus.tblplayer.ffmpeg.FfmpegUtil.getFfmpegExtraData(format);
    }

    private static byte[] getCodecParametersData(com.google.android.exoplayer2.Format format) {
        byte[] ffmpegCodecParametersData = com.oplus.tblplayer.ffmpeg.FfmpegUtil.getFfmpegCodecParametersData(format);
        return ffmpegCodecParametersData != null ? ffmpegCodecParametersData : ffmpegCreateCodecParametersData(format.channelCount, format.sampleRate);
    }
}
