package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class FfmpegRawAudioDecoder extends com.google.android.exoplayer2.decoder.SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, FfmpegAudioDecoderException> {
    protected static final int ERROR_DECODING = 3;
    protected static final int ERROR_INIT = 2;
    protected static final int ERROR_LOAD_LIB = 1;
    protected static final int ERROR_OTHER = 5;
    private final Format inFormat;
    protected long nativeContext;
    private final Format outFormat;
    private PCMConvertor pcmConvertor;

    protected native long ffmpegCreateResampleContext(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6);

    protected native void ffmpegDestroyResampleContext(long OplusGLSurfaceView_15);

    protected native int ffmpegResample(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, int OplusGLSurfaceView_13, ByteBuffer byteBuffer2, int i2);

    public FfmpegRawAudioDecoder(int OplusGLSurfaceView_13, int i2, int i3, Format format) throws FfmpegAudioDecoderException {
        super(new DecoderInputBuffer[OplusGLSurfaceView_13], new SimpleOutputBuffer[i2]);
        this.inFormat = format;
        int i4 = this.inFormat.channelCount > 2 ? 2 : this.inFormat.channelCount;
        if (this.inFormat.channelCount == i4) {
            this.nativeContext = 0L;
            this.outFormat = this.inFormat;
        } else {
            this.pcmConvertor = new PCMConvertor(this.inFormat.pcmEncoding);
            this.outFormat = Format.createAudioSampleFormat(null, MimeTypes.AUDIO_RAW, null, -1, -1, i4, this.inFormat.sampleRate, this.pcmConvertor.getOutPcmEncoding(), null, null, 0, null);
            if (!FfmpegLibrary.isAvailable()) {
                throw new FfmpegAudioDecoderException(1, "Failed to load decoder native libraries.");
            }
            this.nativeContext = ffmpegCreateResampleContext(this.inFormat.channelCount, FfmpegUtil.pcmEncodingToAVSampleFormat(this.pcmConvertor.getOutPcmEncoding()), this.inFormat.sampleRate, this.outFormat.channelCount, FfmpegUtil.pcmEncodingToAVSampleFormat(this.outFormat.pcmEncoding), this.outFormat.sampleRate);
            if (this.nativeContext == 0) {
                throw new FfmpegAudioDecoderException(2, "Initialization failed.");
            }
        }
        setInitialInputBufferSize(i3);
    }

    public Format getOutFormat() {
        return this.outFormat;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "ffmpeg" + FfmpegLibrary.getVersion() + "-" + MimeTypes.AUDIO_RAW;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(2);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FfmpegAudioDecoderException createUnexpectedDecodeException(Throwable th) {
        return new FfmpegAudioDecoderException(5, "audio decode failed.", th);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public FfmpegAudioDecoderException decode(DecoderInputBuffer decoderInputBuffer, SimpleOutputBuffer simpleOutputBuffer, boolean z) {
        if (this.nativeContext == 0) {
            simpleOutputBuffer.init(decoderInputBuffer.timeUs, decoderInputBuffer.data.limit());
            simpleOutputBuffer.data.put(decoderInputBuffer.data);
            simpleOutputBuffer.data.position(0);
            simpleOutputBuffer.data.limit(decoderInputBuffer.data.limit());
            return null;
        }
        ByteBuffer byteBufferConvert = this.pcmConvertor.convert(decoderInputBuffer.data);
        int iLimit = byteBufferConvert.limit();
        int outSampleSize = ((iLimit / this.inFormat.channelCount) / this.pcmConvertor.getOutSampleSize()) * this.outFormat.channelCount * PCMConvertor.getSampleSize(this.outFormat.pcmEncoding);
        simpleOutputBuffer.init(decoderInputBuffer.timeUs, outSampleSize);
        int iFfmpegResample = ffmpegResample(this.nativeContext, byteBufferConvert, iLimit, simpleOutputBuffer.data, outSampleSize);
        if (iFfmpegResample < 0) {
            return new FfmpegAudioDecoderException(3, "Error decoding (see logcat). Code: " + iFfmpegResample);
        }
        simpleOutputBuffer.data.position(0);
        simpleOutputBuffer.data.limit(iFfmpegResample);
        decoderInputBuffer.data.position(decoderInputBuffer.data.limit());
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        long OplusGLSurfaceView_15 = this.nativeContext;
        if (OplusGLSurfaceView_15 != 0) {
            ffmpegDestroyResampleContext(OplusGLSurfaceView_15);
            this.nativeContext = 0L;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long OplusGLSurfaceView_15 = this.nativeContext;
        if (OplusGLSurfaceView_15 != 0) {
            ffmpegDestroyResampleContext(OplusGLSurfaceView_15);
            this.nativeContext = 0L;
        }
    }
}
