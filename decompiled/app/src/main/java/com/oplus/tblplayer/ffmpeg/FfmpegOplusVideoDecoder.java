package com.oplus.tblplayer.ffmpeg;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.oplus.tblplayer.ffmpeg.FrameOutputBuffer;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class FfmpegOplusVideoDecoder extends SimpleDecoder<FfmpegVideoInputBuffer, FrameOutputBuffer, FfmpegVideoDecoderException> implements FrameOutputBuffer.Owner {
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
    private static final String TAG = "FfmpegOplusVideoDecoder";
    private final String codecName;
    private final byte[] codecParametersData;
    private boolean draining;
    private final byte[] extraData;
    private long nativeContext;
    private int outputMode;
    private int rotationDegrees;

    private native long ffmpegInitialize(String str, byte[] bArr, byte[] bArr2, int OplusGLSurfaceView_13, int i2);

    private native int ffmpegReceiveFrame(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, FrameOutputBuffer frameOutputBuffer, boolean z);

    private native void ffmpegRelease(long OplusGLSurfaceView_15);

    private native int ffmpegRenderFrame(long OplusGLSurfaceView_15, Surface surface, FrameOutputBuffer frameOutputBuffer, int OplusGLSurfaceView_13, int i2, int i3);

    private native long ffmpegReset(long OplusGLSurfaceView_15);

    private native int ffmpegSendPacket(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, int OplusGLSurfaceView_13, long j2, int i2);

    private native void ffmpegUpdateSurface(long OplusGLSurfaceView_15, Surface surface);

    public FfmpegOplusVideoDecoder(int OplusGLSurfaceView_13, int i2, int i3, Format format) throws FfmpegVideoDecoderException {
        super(new FfmpegVideoInputBuffer[OplusGLSurfaceView_13], new FrameOutputBuffer[i2]);
        this.outputMode = 0;
        this.rotationDegrees = 0;
        FfmpegUtil.m25446i(TAG, "FfmpegOplusVideoDecoder create.");
        if (!FfmpegLibrary.isAvailable()) {
            throw new FfmpegVideoDecoderException(1, "Failed to load decoder native libraries.");
        }
        if (format == null) {
            throw new FfmpegVideoDecoderException(2, "Create ffmpeg decoder fail with format is null.");
        }
        this.codecName = FfmpegLibrary.getCodecName(format.sampleMimeType);
        if (this.codecName == null) {
            throw new FfmpegVideoDecoderException(2, "NULL codec name for mime type: " + format.sampleMimeType);
        }
        this.extraData = getExtraData(format);
        this.codecParametersData = getCodecParametersData(format);
        this.rotationDegrees = format.rotationDegrees;
        this.outputMode = 0;
        if (Util.MODEL.toString().contains("CPH2095") || Util.MODEL.toString().contains("CPH2097") || Util.MODEL.toString().contains("CPH2101") || Util.MODEL.toString().contains("CPH2099") || Util.MODEL.toString().contains("CPH2103")) {
            this.rotationDegrees = 0;
        }
        try {
            this.nativeContext = ffmpegInitialize(this.codecName, this.extraData, this.codecParametersData, this.rotationDegrees, 0);
            if (this.nativeContext == 0) {
                throw new FfmpegVideoDecoderException(2, "Failed to initialize decoder.");
            }
            try {
                setInitialInputBufferSize(i3);
            } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                throw new FfmpegVideoDecoderException(2, COUIBaseListPopupWindow_8.getMessage());
            }
        } catch (Throwable th) {
            throw new FfmpegVideoDecoderException(2, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FfmpegVideoInputBuffer createInputBuffer() {
        return new FfmpegVideoInputBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FrameOutputBuffer createOutputBuffer() {
        return new FrameOutputBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FfmpegVideoDecoderException createUnexpectedDecodeException(Throwable th) {
        return new FfmpegVideoDecoderException(5, "video decode failed", th);
    }

    public void setOutputMode(int OplusGLSurfaceView_13) {
        this.outputMode = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public void releaseOutputBuffer(FrameOutputBuffer frameOutputBuffer) {
        super.releaseOutputBuffer((FfmpegOplusVideoDecoder) frameOutputBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FfmpegVideoDecoderException decode(FfmpegVideoInputBuffer ffmpegVideoInputBuffer, FrameOutputBuffer frameOutputBuffer, boolean z) {
        int OplusGLSurfaceView_13;
        int i2;
        int iLimit;
        int i3;
        ByteBuffer byteBuffer;
        if (z) {
            FfmpegUtil.m25442d(TAG, "Decode context reset.");
            this.nativeContext = ffmpegReset(this.nativeContext);
            if (this.nativeContext == 0) {
                return new FfmpegVideoDecoderException(4, "Error resetting (see logcat).");
            }
            this.draining = false;
        }
        if (this.draining || ffmpegVideoInputBuffer == null) {
            OplusGLSurfaceView_13 = -3;
            i2 = -1;
        } else {
            if (!ffmpegVideoInputBuffer.isEndOfStream()) {
                ByteBuffer byteBuffer2 = (ByteBuffer) Util.castNonNull(ffmpegVideoInputBuffer.data);
                byteBuffer = byteBuffer2;
                iLimit = byteBuffer2.limit();
                i3 = (ffmpegVideoInputBuffer.isDecodeOnly() ? 4 : 0) | 0;
            } else {
                ffmpegVideoInputBuffer.timeUs = 0L;
                this.draining = true;
                FfmpegUtil.m25446i(TAG, "The decoder entering the draining mode.");
                iLimit = 0;
                i3 = 0;
                byteBuffer = null;
            }
            i2 = -1;
            OplusGLSurfaceView_13 = -3;
            int iFfmpegSendPacket = ffmpegSendPacket(this.nativeContext, byteBuffer, iLimit, ffmpegVideoInputBuffer.timeUs, i3);
            if (iFfmpegSendPacket == -3) {
                FfmpegUtil.m25442d(TAG, "DECODER_ERROR_EAGAIN: timeUs = " + ffmpegVideoInputBuffer.timeUs);
            } else {
                if (iFfmpegSendPacket == -2) {
                    ffmpegVideoInputBuffer.setFlags(Integer.MIN_VALUE);
                    return null;
                }
                if (iFfmpegSendPacket == -1) {
                    return new FfmpegVideoDecoderException(-1, "ffmpegDecode error: (see logcat)");
                }
            }
        }
        int iFfmpegReceiveFrame = ffmpegReceiveFrame(this.nativeContext, this.outputMode, frameOutputBuffer, false);
        if (iFfmpegReceiveFrame == -4) {
            frameOutputBuffer.addFlag(4);
            this.draining = false;
        } else if (iFfmpegReceiveFrame == OplusGLSurfaceView_13) {
            frameOutputBuffer.addFlag(Integer.MIN_VALUE);
        } else if (iFfmpegReceiveFrame == i2) {
            return new FfmpegVideoDecoderException(i2, "ffmpegDecode error: (see logcat)");
        }
        return null;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    protected boolean isDraining() {
        return this.draining;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() throws InterruptedException {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public void renderToSurface(FrameOutputBuffer frameOutputBuffer, Surface surface) throws FfmpegVideoDecoderException {
        if (ffmpegRenderFrame(this.nativeContext, surface, frameOutputBuffer, frameOutputBuffer.width, frameOutputBuffer.height, frameOutputBuffer.rgbLineSize) == 6) {
            throw new FfmpegVideoDecoderException(6, "Buffer render error: ");
        }
    }

    public void updateRenderSurface(Surface surface) {
        ffmpegUpdateSurface(this.nativeContext, surface);
    }

    private static byte[] getExtraData(Format format) {
        return FfmpegUtil.getFfmpegExtraData(format);
    }

    public static byte[] getCodecParametersData(Format format) {
        return FfmpegUtil.getFfmpegCodecParametersData(format);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Ffmpeg." + FfmpegLibrary.getVersion() + "." + this.codecName;
    }
}
