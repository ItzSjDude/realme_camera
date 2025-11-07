package com.google.android.exoplayer2.ext.av1;

import android.view.Surface;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Gav1Decoder extends SimpleDecoder<Gav1InputBuffer, Gav1OutputBuffer, Gav1DecoderException> {
    private static final int GAV1_DECODE_ONLY = 2;
    private static final int GAV1_ERROR = 0;
    private static final int GAV1_OK = 1;
    public static final int OUTPUT_MODE_NONE = -1;
    public static final int OUTPUT_MODE_SURFACE_YUV = 1;
    public static final int OUTPUT_MODE_YUV = 0;
    private final long gav1DecoderContext;
    private volatile int outputMode;

    private native int gav1CheckError(long OplusGLSurfaceView_15);

    private native void gav1Close(long OplusGLSurfaceView_15);

    private native int gav1Decode(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, int OplusGLSurfaceView_13);

    private native String gav1GetErrorMessage(long OplusGLSurfaceView_15);

    private native int gav1GetFrame(long OplusGLSurfaceView_15, Gav1OutputBuffer gav1OutputBuffer, boolean z);

    private native int gav1GetThreads();

    private native long gav1Init(int OplusGLSurfaceView_13);

    private native void gav1ReleaseFrame(long OplusGLSurfaceView_15, Gav1OutputBuffer gav1OutputBuffer);

    private native int gav1RenderFrame(long OplusGLSurfaceView_15, Surface surface, Gav1OutputBuffer gav1OutputBuffer);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "libgav1";
    }

    public Gav1Decoder(int OplusGLSurfaceView_13, int i2, int i3, int i4) throws Gav1DecoderException {
        super(new Gav1InputBuffer[OplusGLSurfaceView_13], new Gav1OutputBuffer[i2]);
        if (!Gav1Library.isAvailable()) {
            throw new Gav1DecoderException("Failed to load decoder native library.");
        }
        if (i4 == 0 && (i4 = gav1GetThreads()) <= 0) {
            i4 = Runtime.getRuntime().availableProcessors();
        }
        this.gav1DecoderContext = gav1Init(i4);
        long OplusGLSurfaceView_15 = this.gav1DecoderContext;
        if (OplusGLSurfaceView_15 == 0 || gav1CheckError(OplusGLSurfaceView_15) == 0) {
            throw new Gav1DecoderException("Failed to initialize decoder. Error: " + gav1GetErrorMessage(this.gav1DecoderContext));
        }
        setInitialInputBufferSize(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public Gav1InputBuffer createInputBuffer() {
        return new Gav1InputBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public Gav1OutputBuffer createOutputBuffer() {
        return new Gav1OutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public Gav1DecoderException decode(Gav1InputBuffer gav1InputBuffer, Gav1OutputBuffer gav1OutputBuffer, boolean z) {
        ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(gav1InputBuffer.data);
        if (gav1Decode(this.gav1DecoderContext, byteBuffer, byteBuffer.limit()) == 0) {
            return new Gav1DecoderException("gav1Decode error: " + gav1GetErrorMessage(this.gav1DecoderContext));
        }
        boolean zIsDecodeOnly = gav1InputBuffer.isDecodeOnly();
        if (!zIsDecodeOnly) {
            gav1OutputBuffer.init(gav1InputBuffer.timeUs, this.outputMode);
        }
        int iGav1GetFrame = gav1GetFrame(this.gav1DecoderContext, gav1OutputBuffer, zIsDecodeOnly);
        if (iGav1GetFrame == 0) {
            return new Gav1DecoderException("gav1GetFrame error: " + gav1GetErrorMessage(this.gav1DecoderContext));
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
    public Gav1DecoderException createUnexpectedDecodeException(Throwable th) {
        return new Gav1DecoderException("Unexpected decode error", th);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        gav1Close(this.gav1DecoderContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    public void releaseOutputBuffer(Gav1OutputBuffer gav1OutputBuffer) {
        if (gav1OutputBuffer.mode == 1 && !gav1OutputBuffer.isDecodeOnly()) {
            gav1ReleaseFrame(this.gav1DecoderContext, gav1OutputBuffer);
        }
        super.releaseOutputBuffer((Gav1Decoder) gav1OutputBuffer);
    }

    public void setOutputMode(int OplusGLSurfaceView_13) {
        this.outputMode = OplusGLSurfaceView_13;
    }

    public void renderToSurface(Gav1OutputBuffer gav1OutputBuffer, Surface surface) throws Gav1DecoderException {
        if (gav1OutputBuffer.mode != 1) {
            throw new Gav1DecoderException("Invalid output mode.");
        }
        if (gav1RenderFrame(this.gav1DecoderContext, surface, gav1OutputBuffer) != 0) {
            return;
        }
        throw new Gav1DecoderException("Buffer render error: " + gav1GetErrorMessage(this.gav1DecoderContext));
    }
}
