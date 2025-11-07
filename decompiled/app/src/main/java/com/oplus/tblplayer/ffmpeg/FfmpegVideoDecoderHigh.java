package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
final class FfmpegVideoDecoderHigh extends com.oplus.tblplayer.ffmpeg.HighSimpleDecoder<com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer, com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer, com.oplus.tblplayer.ffmpeg.FfmpegDecoderException> {
    private static final int DECODER_ERROR_INVALID_DATA = -1;
    private static final int DECODER_ERROR_OTHER = -2;
    private static final int DECODER_ERROR_READ_FRAME = -3;
    private static final int DECODER_ERROR_SEND_PACKET = -4;
    private static final java.lang.String TAG = "FfmpegVideoDecoderHigh";
    private final java.lang.String codecName;
    private final byte[] codecParametersData;
    private final byte[] extraData;
    private long nativeContext;
    private volatile int outputMode;

    private native long ffmpegInitialize(java.lang.String str, byte[] bArr, byte[] bArr2, int i_renamed);

    private native int ffmpegReceiveFrame(long j_renamed, int i_renamed, com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z_renamed);

    private native void ffmpegRelease(long j_renamed);

    private native int ffmpegRenderFrame(long j_renamed, android.view.Surface surface, com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer, int i_renamed, int i2);

    private native long ffmpegReset(long j_renamed);

    private native int ffmpegSendPacket(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed, long j2);

    public FfmpegVideoDecoderHigh(int i_renamed, int i2, int i3, int i4, com.google.android.exoplayer2.Format format) throws com.oplus.tblplayer.ffmpeg.FfmpegDecoderException {
        super(new com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer[i_renamed], new com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer[i2]);
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable()) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("Failed to load decoder native library.");
        }
        this.codecName = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.oplus.tblplayer.ffmpeg.FfmpegLibrary.getCodecName(format.sampleMimeType));
        this.extraData = getExtraData(format);
        this.codecParametersData = getCodecParametersData(format);
        this.nativeContext = ffmpegInitialize(this.codecName, this.extraData, this.codecParametersData, i4);
        if (this.nativeContext == 0) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("Failed to initialize decoder.");
        }
        setInitialInputBufferSize(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] getExtraData(java.lang.String r4, java.util.List<byte[]> r5) {
        /*
            int r0 = r4.hashCode()
            r1 = -1662541442(0xffffffff9ce7a17e, float:-1.5328042E-21)
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1b
            r1 = 1331836730(0x4f62373a, float:3.79527014E9)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "video/avc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L25
            r4 = r3
            goto L26
        L1b:
            java.lang.String r0 = "video/hevc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L25
            r4 = r2
            goto L26
        L25:
            r4 = -1
        L26:
            if (r4 == 0) goto L33
            if (r4 == r2) goto L2c
            r4 = 0
            return r4
        L2c:
            java.lang.Object r4 = r5.get(r3)
            byte[] r4 = (byte[]) r4
            return r4
        L33:
            java.lang.Object r4 = r5.get(r3)
            byte[] r4 = (byte[]) r4
            java.lang.Object r5 = r5.get(r2)
            byte[] r5 = (byte[]) r5
            int r0 = r4.length
            int r1 = r5.length
            int r0 = r0 + r1
            byte[] r0 = new byte[r0]
            int r1 = r4.length
            java.lang.System.arraycopy(r4, r3, r0, r3, r1)
            int r4 = r4.length
            int r1 = r5.length
            java.lang.System.arraycopy(r5, r3, r0, r4, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderHigh.getExtraData(java.lang.String, java.util.List):byte[]");
    }

    private static byte[] getExtraData(com.google.android.exoplayer2.Format format) {
        if (format.initializationData == null || format.initializationData.size() == 0) {
            return null;
        }
        if (format.initializationData.size() == 1) {
            return format.initializationData.get(0);
        }
        if (format.label != null && format.label.compareTo(com.oplus.tblplayer.ffmpeg.FfmpegExtractor.TAG) == 0) {
            if (format.initializationData.size() == 2) {
                return format.initializationData.get(0);
            }
            return null;
        }
        if (format.initializationData.size() != 2) {
            return null;
        }
        byte[] bArr = format.initializationData.get(0);
        byte[] bArr2 = format.initializationData.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & 255);
        java.lang.System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
        java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }

    private static byte[] getCodecParametersData(com.google.android.exoplayer2.Format format) {
        if (format.initializationData != null && format.initializationData.size() >= 1 && com.oplus.tblplayer.ffmpeg.FfmpegUtil.isFfmpegExtractor(format)) {
            return format.initializationData.get(format.initializationData.size() - 1);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "ffmpeg" + com.oplus.tblplayer.ffmpeg.FfmpegLibrary.getVersion() + "-" + this.codecName;
    }

    public void setOutputMode(int i_renamed) {
        this.outputMode = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.HighSimpleDecoder
    public com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer createInputBuffer() {
        return new com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.HighSimpleDecoder
    public com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer createOutputBuffer() {
        return new com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer(new com.oplus.tblplayer.ffmpeg.OutputBuffer.Owner() { // from class: com.oplus.tblplayer.ffmpeg.-$$Lambda$TKm6H1u51oJyy4jvvEkhfLkjPvw
            @Override // com.oplus.tblplayer.ffmpeg.OutputBuffer.Owner
            public final void releaseOutputBuffer(com.oplus.tblplayer.ffmpeg.OutputBuffer outputBuffer) {
                this.f_renamed$0.releaseOutputBuffer((com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer) outputBuffer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.HighSimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FfmpegDecoderException decode(com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer videoDecoderInputBuffer, com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z_renamed) {
        if (z_renamed) {
            this.nativeContext = ffmpegReset(this.nativeContext);
            if (this.nativeContext == 0) {
                return new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Util.castNonNull(videoDecoderInputBuffer.data);
        boolean z2 = false;
        int iFfmpegSendPacket = ffmpegSendPacket(this.nativeContext, byteBuffer, byteBuffer.limit(), videoDecoderInputBuffer.timeUs);
        if (iFfmpegSendPacket == -1) {
            videoDecoderOutputBuffer.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (iFfmpegSendPacket == -3) {
            z2 = true;
        } else if (iFfmpegSendPacket == -2) {
            return new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        boolean zIsDecodeOnly = videoDecoderInputBuffer.isDecodeOnly();
        int iFfmpegReceiveFrame = ffmpegReceiveFrame(this.nativeContext, this.outputMode, videoDecoderOutputBuffer, zIsDecodeOnly);
        if (iFfmpegReceiveFrame == -4) {
            return null;
        }
        if (iFfmpegReceiveFrame == -2) {
            return new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        if (iFfmpegReceiveFrame == -1) {
            videoDecoderOutputBuffer.addFlag(Integer.MIN_VALUE);
        }
        if (!zIsDecodeOnly) {
            videoDecoderOutputBuffer.colorInfo = videoDecoderInputBuffer.colorInfo;
        }
        if (z2) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.e_renamed(TAG, "timeUs = " + videoDecoderInputBuffer.timeUs + ", needSendAgain");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.HighSimpleDecoder
    public com.oplus.tblplayer.ffmpeg.FfmpegDecoderException createUnexpectedDecodeException(java.lang.Throwable th) {
        return new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("Unexpected decode error", th);
    }

    @Override // com.oplus.tblplayer.ffmpeg.HighSimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() throws java.lang.InterruptedException {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public void renderToSurface(com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer, android.view.Surface surface) throws com.oplus.tblplayer.ffmpeg.FfmpegDecoderException {
        if (videoDecoderOutputBuffer.mode != 1) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("Invalid output mode.");
        }
        if (ffmpegRenderFrame(this.nativeContext, surface, videoDecoderOutputBuffer, videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height) == -2) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("Buffer render error: ");
        }
    }
}
