package com.google.android.exoplayer2.ext.av1;

/* loaded from: classes.dex */
public final class Gav1Decoder extends com.google.android.exoplayer2.decoder.SimpleDecoder<com.google.android.exoplayer2.ext.av1.Gav1InputBuffer, com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer, com.google.android.exoplayer2.ext.av1.Gav1DecoderException> {
    private static final int GAV1_DECODE_ONLY = 2;
    private static final int GAV1_ERROR = 0;
    private static final int GAV1_OK = 1;
    public static final int OUTPUT_MODE_NONE = -1;
    public static final int OUTPUT_MODE_SURFACE_YUV = 1;
    public static final int OUTPUT_MODE_YUV = 0;
    private final long gav1DecoderContext;
    private volatile int outputMode;

    private native int gav1CheckError(long j_renamed);

    private native void gav1Close(long j_renamed);

    private native int gav1Decode(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed);

    private native java.lang.String gav1GetErrorMessage(long j_renamed);

    private native int gav1GetFrame(long j_renamed, com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer, boolean z_renamed);

    private native int gav1GetThreads();

    private native long gav1Init(int i_renamed);

    private native void gav1ReleaseFrame(long j_renamed, com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer);

    private native int gav1RenderFrame(long j_renamed, android.view.Surface surface, com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public java.lang.String getName() {
        return "libgav1";
    }

    public Gav1Decoder(int i_renamed, int i2, int i3, int i4) throws com.google.android.exoplayer2.ext.av1.Gav1DecoderException {
        super(new com.google.android.exoplayer2.ext.av1.Gav1InputBuffer[i_renamed], new com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer[i2]);
        if (!com.google.android.exoplayer2.ext.av1.Gav1Library.isAvailable()) {
            throw new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("Failed to load decoder native library.");
        }
        if (i4 == 0 && (i4 = gav1GetThreads()) <= 0) {
            i4 = java.lang.Runtime.getRuntime().availableProcessors();
        }
        this.gav1DecoderContext = gav1Init(i4);
        long j_renamed = this.gav1DecoderContext;
        if (j_renamed == 0 || gav1CheckError(j_renamed) == 0) {
            throw new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("Failed to initialize decoder. Error: " + gav1GetErrorMessage(this.gav1DecoderContext));
        }
        setInitialInputBufferSize(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.google.android.exoplayer2.ext.av1.Gav1InputBuffer createInputBuffer() {
        return new com.google.android.exoplayer2.ext.av1.Gav1InputBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer createOutputBuffer() {
        return new com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.google.android.exoplayer2.ext.av1.Gav1DecoderException decode(com.google.android.exoplayer2.ext.av1.Gav1InputBuffer gav1InputBuffer, com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer, boolean z_renamed) {
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Util.castNonNull(gav1InputBuffer.data);
        if (gav1Decode(this.gav1DecoderContext, byteBuffer, byteBuffer.limit()) == 0) {
            return new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("gav1Decode error: " + gav1GetErrorMessage(this.gav1DecoderContext));
        }
        boolean zIsDecodeOnly = gav1InputBuffer.isDecodeOnly();
        if (!zIsDecodeOnly) {
            gav1OutputBuffer.init(gav1InputBuffer.timeUs, this.outputMode);
        }
        int iGav1GetFrame = gav1GetFrame(this.gav1DecoderContext, gav1OutputBuffer, zIsDecodeOnly);
        if (iGav1GetFrame == 0) {
            return new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("gav1GetFrame error: " + gav1GetErrorMessage(this.gav1DecoderContext));
        }
        if (iGav1GetFrame == 2) {
            gav1OutputBuffer.addFlag(Integer.MIN_VALUE);
        }
        if (zIsDecodeOnly) {
            return null;
        }
        gav1OutputBuffer.colorInfo = gav1InputBuffer.colorInfo;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public com.google.android.exoplayer2.ext.av1.Gav1DecoderException createUnexpectedDecodeException(java.lang.Throwable th) {
        return new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("Unexpected decode error", th);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        gav1Close(this.gav1DecoderContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public void releaseOutputBuffer(com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer) {
        if (gav1OutputBuffer.mode == 1 && !gav1OutputBuffer.isDecodeOnly()) {
            gav1ReleaseFrame(this.gav1DecoderContext, gav1OutputBuffer);
        }
        super.releaseOutputBuffer((com.google.android.exoplayer2.ext.av1.Gav1Decoder) gav1OutputBuffer);
    }

    public void setOutputMode(int i_renamed) {
        this.outputMode = i_renamed;
    }

    public void renderToSurface(com.google.android.exoplayer2.ext.av1.Gav1OutputBuffer gav1OutputBuffer, android.view.Surface surface) throws com.google.android.exoplayer2.ext.av1.Gav1DecoderException {
        if (gav1OutputBuffer.mode != 1) {
            throw new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("Invalid output mode.");
        }
        if (gav1RenderFrame(this.gav1DecoderContext, surface, gav1OutputBuffer) != 0) {
            return;
        }
        throw new com.google.android.exoplayer2.ext.av1.Gav1DecoderException("Buffer render error: " + gav1GetErrorMessage(this.gav1DecoderContext));
    }
}
