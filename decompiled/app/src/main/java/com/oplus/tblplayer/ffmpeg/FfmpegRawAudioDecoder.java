package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class FfmpegRawAudioDecoder extends com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.SimpleOutputBuffer, com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException> {
    protected static final int ERROR_DECODING = 3;
    protected static final int ERROR_INIT = 2;
    protected static final int ERROR_LOAD_LIB = 1;
    protected static final int ERROR_OTHER = 5;
    private final com.google.android.exoplayer2.Format inFormat;
    protected long nativeContext;
    private final com.google.android.exoplayer2.Format outFormat;
    private com.oplus.tblplayer.ffmpeg.PCMConvertor pcmConvertor;

    protected native long ffmpegCreateResampleContext(int i_renamed, int i2, int i3, int i4, int i5, int i6);

    protected native void ffmpegDestroyResampleContext(long j_renamed);

    protected native int ffmpegResample(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed, java.nio.ByteBuffer byteBuffer2, int i2);

    public FfmpegRawAudioDecoder(int i_renamed, int i2, int i3, com.google.android.exoplayer2.Format format) throws com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException {
        super(new com.google.android.exoplayer2.decoder.DecoderInputBuffer[i_renamed], new com.google.android.exoplayer2.decoder.SimpleOutputBuffer[i2]);
        this.inFormat = format;
        int i4 = this.inFormat.channelCount > 2 ? 2 : this.inFormat.channelCount;
        if (this.inFormat.channelCount == i4) {
            this.nativeContext = 0L;
            this.outFormat = this.inFormat;
        } else {
            this.pcmConvertor = new com.oplus.tblplayer.ffmpeg.PCMConvertor(this.inFormat.pcmEncoding);
            this.outFormat = com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW, null, -1, -1, i4, this.inFormat.sampleRate, this.pcmConvertor.getOutPcmEncoding(), null, null, 0, null);
            if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable()) {
                throw new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(1, "Failed to load decoder native libraries.");
            }
            this.nativeContext = ffmpegCreateResampleContext(this.inFormat.channelCount, com.oplus.tblplayer.ffmpeg.FfmpegUtil.pcmEncodingToAVSampleFormat(this.pcmConvertor.getOutPcmEncoding()), this.inFormat.sampleRate, this.outFormat.channelCount, com.oplus.tblplayer.ffmpeg.FfmpegUtil.pcmEncodingToAVSampleFormat(this.outFormat.pcmEncoding), this.outFormat.sampleRate);
            if (this.nativeContext == 0) {
                throw new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(2, "Initialization failed.");
            }
        }
        setInitialInputBufferSize(i3);
    }

    public com.google.android.exoplayer2.Format getOutFormat() {
        return this.outFormat;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "ffmpeg" + com.oplus.tblplayer.ffmpeg.FfmpegLibrary.getVersion() + "-" + com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW;
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
        if (this.nativeContext == 0) {
            simpleOutputBuffer.init(decoderInputBuffer.timeUs, decoderInputBuffer.data.limit());
            simpleOutputBuffer.data.put(decoderInputBuffer.data);
            simpleOutputBuffer.data.position(0);
            simpleOutputBuffer.data.limit(decoderInputBuffer.data.limit());
            return null;
        }
        java.nio.ByteBuffer byteBufferConvert = this.pcmConvertor.convert(decoderInputBuffer.data);
        int iLimit = byteBufferConvert.limit();
        int outSampleSize = ((iLimit / this.inFormat.channelCount) / this.pcmConvertor.getOutSampleSize()) * this.outFormat.channelCount * com.oplus.tblplayer.ffmpeg.PCMConvertor.getSampleSize(this.outFormat.pcmEncoding);
        simpleOutputBuffer.init(decoderInputBuffer.timeUs, outSampleSize);
        int iFfmpegResample = ffmpegResample(this.nativeContext, byteBufferConvert, iLimit, simpleOutputBuffer.data, outSampleSize);
        if (iFfmpegResample < 0) {
            return new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException(3, "Error decoding (see logcat). Code: " + iFfmpegResample);
        }
        simpleOutputBuffer.data.position(0);
        simpleOutputBuffer.data.limit(iFfmpegResample);
        decoderInputBuffer.data.position(decoderInputBuffer.data.limit());
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        long j_renamed = this.nativeContext;
        if (j_renamed != 0) {
            ffmpegDestroyResampleContext(j_renamed);
            this.nativeContext = 0L;
        }
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        long j_renamed = this.nativeContext;
        if (j_renamed != 0) {
            ffmpegDestroyResampleContext(j_renamed);
            this.nativeContext = 0L;
        }
    }
}
