package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class FfmpegOplusVideoDecoder extends com.oplus.tblplayer.ffmpeg.SimpleDecoder<com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer, com.oplus.tblplayer.ffmpeg.FrameOutputBuffer, com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException> implements com.oplus.tblplayer.ffmpeg.FrameOutputBuffer.Owner {
    private static final int AV_PKT_FLAG_CORRUPT = 2;
    private static final int AV_PKT_FLAG_DISCARD = 4;
    private static final int AV_PKT_FLAG_DISPOSABLE = 16;
    private static final int AV_PKT_FLAG_KEY = 1;
    private static final int AV_PKT_FLAG_TRUSTED = 8;
    private static final int DECODER_ERROR_EAGAIN = -3;
    private static final int DECODER_ERROR_EOF = -4;
    private static final int DECODER_ERROR_INVALID_DATA = -2;
    private static final int DECODER_ERROR_OTHER = -1;
    private static final int DECODER_SUCCESS = 0;
    private static final int ERROR_DECODING = 3;
    private static final int ERROR_INIT = 2;
    private static final int ERROR_LOAD_LIB = 1;
    private static final int ERROR_OTHER = 5;
    private static final int ERROR_RENDERING = 6;
    private static final int ERROR_RESETTING = 4;
    public static final int OUTPUT_MODE_NONE = -1;
    public static final int OUTPUT_MODE_RGB = 1;
    public static final int OUTPUT_MODE_YUV = 0;
    private static final java.lang.String TAG = "FfmpegOplusVideoDecoder";
    private final java.lang.String codecName;
    private final byte[] codecParametersData;
    private boolean draining;
    private final byte[] extraData;
    private long nativeContext;
    private int outputMode;
    private int rotationDegrees;

    private native long ffmpegInitialize(java.lang.String str, byte[] bArr, byte[] bArr2, int i_renamed, int i2);

    private native int ffmpegReceiveFrame(long j_renamed, int i_renamed, com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer, boolean z_renamed);

    private native void ffmpegRelease(long j_renamed);

    private native int ffmpegRenderFrame(long j_renamed, android.view.Surface surface, com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer, int i_renamed, int i2, int i3);

    private native long ffmpegReset(long j_renamed);

    private native int ffmpegSendPacket(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed, long j2, int i2);

    private native void ffmpegUpdateSurface(long j_renamed, android.view.Surface surface);

    public FfmpegOplusVideoDecoder(int i_renamed, int i2, int i3, com.google.android.exoplayer2.Format format) throws com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException {
        super(new com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer[i_renamed], new com.oplus.tblplayer.ffmpeg.FrameOutputBuffer[i2]);
        this.outputMode = 0;
        this.rotationDegrees = 0;
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.i_renamed(TAG, "FfmpegOplusVideoDecoder create.");
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable()) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(1, "Failed to load decoder native libraries.");
        }
        if (format == null) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(2, "Create ffmpeg decoder fail with format is_renamed null.");
        }
        this.codecName = com.oplus.tblplayer.ffmpeg.FfmpegLibrary.getCodecName(format.sampleMimeType);
        if (this.codecName == null) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(2, "NULL codec name for mime type: " + format.sampleMimeType);
        }
        this.extraData = getExtraData(format);
        this.codecParametersData = getCodecParametersData(format);
        this.rotationDegrees = format.rotationDegrees;
        this.outputMode = 0;
        if (com.google.android.exoplayer2.util.Util.MODEL.toString().contains("CPH2095") || com.google.android.exoplayer2.util.Util.MODEL.toString().contains("CPH2097") || com.google.android.exoplayer2.util.Util.MODEL.toString().contains("CPH2101") || com.google.android.exoplayer2.util.Util.MODEL.toString().contains("CPH2099") || com.google.android.exoplayer2.util.Util.MODEL.toString().contains("CPH2103")) {
            this.rotationDegrees = 0;
        }
        try {
            this.nativeContext = ffmpegInitialize(this.codecName, this.extraData, this.codecParametersData, this.rotationDegrees, 0);
            if (this.nativeContext == 0) {
                throw new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(2, "Failed to initialize decoder.");
            }
            try {
                setInitialInputBufferSize(i3);
            } catch (java.lang.OutOfMemoryError e_renamed) {
                e_renamed.printStackTrace();
                throw new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(2, e_renamed.getMessage());
            }
        } catch (java.lang.Throwable th) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(2, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer createInputBuffer() {
        return new com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FrameOutputBuffer createOutputBuffer() {
        return new com.oplus.tblplayer.ffmpeg.FrameOutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException createUnexpectedDecodeException(java.lang.Throwable th) {
        return new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(5, "video decode failed", th);
    }

    public void setOutputMode(int i_renamed) {
        this.outputMode = i_renamed;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public void releaseOutputBuffer(com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer) {
        super.releaseOutputBuffer((com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder) frameOutputBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException decode(com.oplus.tblplayer.ffmpeg.FfmpegVideoInputBuffer ffmpegVideoInputBuffer, com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer, boolean z_renamed) {
        int i_renamed;
        int i2;
        int iLimit;
        int i3;
        java.nio.ByteBuffer byteBuffer;
        if (z_renamed) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "Decode context reset.");
            this.nativeContext = ffmpegReset(this.nativeContext);
            if (this.nativeContext == 0) {
                return new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(4, "Error resetting (see logcat).");
            }
            this.draining = false;
        }
        if (this.draining || ffmpegVideoInputBuffer == null) {
            i_renamed = -3;
            i2 = -1;
        } else {
            if (!ffmpegVideoInputBuffer.isEndOfStream()) {
                java.nio.ByteBuffer byteBuffer2 = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Util.castNonNull(ffmpegVideoInputBuffer.data);
                byteBuffer = byteBuffer2;
                iLimit = byteBuffer2.limit();
                i3 = (ffmpegVideoInputBuffer.isDecodeOnly() ? 4 : 0) | 0;
            } else {
                ffmpegVideoInputBuffer.timeUs = 0L;
                this.draining = true;
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.i_renamed(TAG, "The decoder entering the draining mode.");
                iLimit = 0;
                i3 = 0;
                byteBuffer = null;
            }
            i2 = -1;
            i_renamed = -3;
            int iFfmpegSendPacket = ffmpegSendPacket(this.nativeContext, byteBuffer, iLimit, ffmpegVideoInputBuffer.timeUs, i3);
            if (iFfmpegSendPacket == -3) {
                com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "DECODER_ERROR_EAGAIN: timeUs = " + ffmpegVideoInputBuffer.timeUs);
            } else {
                if (iFfmpegSendPacket == -2) {
                    ffmpegVideoInputBuffer.setFlags(Integer.MIN_VALUE);
                    return null;
                }
                if (iFfmpegSendPacket == -1) {
                    return new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(-1, "ffmpegDecode error: (see logcat)");
                }
            }
        }
        int iFfmpegReceiveFrame = ffmpegReceiveFrame(this.nativeContext, this.outputMode, frameOutputBuffer, false);
        if (iFfmpegReceiveFrame == -4) {
            frameOutputBuffer.addFlag(4);
            this.draining = false;
        } else if (iFfmpegReceiveFrame == i_renamed) {
            frameOutputBuffer.addFlag(Integer.MIN_VALUE);
        } else if (iFfmpegReceiveFrame == i2) {
            return new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(i2, "ffmpegDecode error: (see logcat)");
        }
        return null;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    protected boolean isDraining() {
        return this.draining;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() throws java.lang.InterruptedException {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public void renderToSurface(com.oplus.tblplayer.ffmpeg.FrameOutputBuffer frameOutputBuffer, android.view.Surface surface) throws com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException {
        if (ffmpegRenderFrame(this.nativeContext, surface, frameOutputBuffer, frameOutputBuffer.width, frameOutputBuffer.height, frameOutputBuffer.rgbLineSize) == 6) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderException(6, "Buffer render error: ");
        }
    }

    public void updateRenderSurface(android.view.Surface surface) {
        ffmpegUpdateSurface(this.nativeContext, surface);
    }

    private static byte[] getExtraData(com.google.android.exoplayer2.Format format) {
        return com.oplus.tblplayer.ffmpeg.FfmpegUtil.getFfmpegExtraData(format);
    }

    public static byte[] getCodecParametersData(com.google.android.exoplayer2.Format format) {
        return com.oplus.tblplayer.ffmpeg.FfmpegUtil.getFfmpegCodecParametersData(format);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "Ffmpeg." + com.oplus.tblplayer.ffmpeg.FfmpegLibrary.getVersion() + "." + this.codecName;
    }
}
