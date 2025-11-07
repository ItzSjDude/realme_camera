package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class FfmpegAudioDecoder extends com.google.android.exoplayer2.decoder.SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, FfmpegAudioDecoderException> {
    private static final int ERROR_DECODING = 3;
    private static final int ERROR_INIT = 2;
    private static final int ERROR_LOAD_LIB = 1;
    private static final int ERROR_OTHER = 5;
    private static final int ERROR_RESETTING = 4;
    private static final int OUTPUT_BUFFER_SIZE = 368640;
    private volatile int channelCount;
    private final String codecName;
    private final byte[] codecParametersData;
    private final byte[] extraData;
    private boolean hasOutputFormat;
    private long nativeContext;
    private volatile int sampleRate;

    private static native byte[] ffmpegCreateCodecParametersData(int OplusGLSurfaceView_13, int i2);

    private native int ffmpegDecode(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, int OplusGLSurfaceView_13, ByteBuffer byteBuffer2, int i2);

    private native int ffmpegGetChannelCount(long OplusGLSurfaceView_15);

    private native int ffmpegGetSampleRate(long OplusGLSurfaceView_15);

    private native long ffmpegInitialize(String str, byte[] bArr, byte[] bArr2);

    private native void ffmpegRelease(long OplusGLSurfaceView_15);

    private native long ffmpegReset(long OplusGLSurfaceView_15, byte[] bArr, byte[] bArr2);

    public FfmpegAudioDecoder(int OplusGLSurfaceView_13, int i2, int i3, Format format) throws FfmpegAudioDecoderException {
        super(new DecoderInputBuffer[OplusGLSurfaceView_13], new SimpleOutputBuffer[i2]);
        if (!FfmpegLibrary.isAvailable()) {
            throw new FfmpegAudioDecoderException(1, "Failed to load decoder native libraries.");
        }
        this.codecName = FfmpegLibrary.getCodecName(format.sampleMimeType);
        this.extraData = getExtraData(format);
        this.codecParametersData = getCodecParametersData(format);
        this.nativeContext = ffmpegInitialize(this.codecName, this.extraData, this.codecParametersData);
        if (this.nativeContext == 0) {
            throw new FfmpegAudioDecoderException(2, "Initialization failed. Mime type: " + format.sampleMimeType + ", codec name: " + this.codecName);
        }
        setInitialInputBufferSize(i3);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Ffmpeg." + FfmpegLibrary.getVersion() + "." + this.codecName;
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
        if (z) {
            this.nativeContext = ffmpegReset(this.nativeContext, this.extraData, this.codecParametersData);
            if (this.nativeContext == 0) {
                return new FfmpegAudioDecoderException(4, "Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        int iFfmpegDecode = ffmpegDecode(this.nativeContext, byteBuffer, byteBuffer.limit(), simpleOutputBuffer.init(decoderInputBuffer.timeUs, OUTPUT_BUFFER_SIZE), OUTPUT_BUFFER_SIZE);
        if (iFfmpegDecode < 0) {
            return new FfmpegAudioDecoderException(3, "Error decoding (see logcat). result: " + iFfmpegDecode);
        }
        if (!this.hasOutputFormat) {
            this.channelCount = ffmpegGetChannelCount(this.nativeContext);
            this.sampleRate = ffmpegGetSampleRate(this.nativeContext);
            if (this.sampleRate == 0 && "alac".equals(this.codecName)) {
                ParsableByteArray parsableByteArray = new ParsableByteArray(this.extraData);
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

    private static byte[] getExtraData(Format format) {
        return FfmpegUtil.getFfmpegExtraData(format);
    }

    private static byte[] getCodecParametersData(Format format) {
        byte[] ffmpegCodecParametersData = FfmpegUtil.getFfmpegCodecParametersData(format);
        return ffmpegCodecParametersData != null ? ffmpegCodecParametersData : ffmpegCreateCodecParametersData(format.channelCount, format.sampleRate);
    }
}
