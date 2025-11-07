package com.oplus.tblplayer.ffmpeg;

import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.oplus.camera.capmode.VideoMode;

/* loaded from: classes2.dex */
public final class FfmpegVideoRenderer extends DecoderVideoRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = ((Util.ceilDivide(VideoMode.VIDEO_720P_WIDTH, 64) * Util.ceilDivide(VideoMode.VIDEO_720P_HEIGHT, 64)) * 6144) / 2;
    private static final int DEFAULT_NUM_OF_INPUT_BUFFERS = 4;
    private static final int DEFAULT_NUM_OF_OUTPUT_BUFFERS = 4;
    private static final String TAG = "FfmpegVideoRenderer";
    private FfmpegVideoDecoderHigh decoder;
    private final int numInputBuffers;
    private final int numOutputBuffers;
    private final int threads;

    public FfmpegVideoRenderer(long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13) {
        this(OplusGLSurfaceView_15, handler, videoRendererEventListener, OplusGLSurfaceView_13, Runtime.getRuntime().availableProcessors(), 4, 4);
    }

    public FfmpegVideoRenderer(long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super(OplusGLSurfaceView_15, handler, videoRendererEventListener, OplusGLSurfaceView_13);
        this.threads = i2;
        this.numInputBuffers = i3;
        this.numOutputBuffers = i4;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) {
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isVideo(str)) {
            return 0;
        }
        if (FfmpegLibrary.supportsFormat(format)) {
            return format.drmInitData != null ? 2 : 4;
        }
        return 1;
    }

    @Override // com.oplus.tblplayer.ffmpeg.DecoderVideoRenderer
    protected Decoder<VideoDecoderInputBuffer, VideoDecoderOutputBuffer, FfmpegDecoderException> createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws FfmpegDecoderException {
        TraceUtil.beginSection("createGav1Decoder");
        FfmpegVideoDecoderHigh ffmpegVideoDecoderHigh = new FfmpegVideoDecoderHigh(this.numInputBuffers, this.numOutputBuffers, format.maxInputSize != -1 ? format.maxInputSize : DEFAULT_INPUT_BUFFER_SIZE, this.threads, format);
        this.decoder = ffmpegVideoDecoderHigh;
        TraceUtil.endSection();
        return ffmpegVideoDecoderHigh;
    }

    @Override // com.oplus.tblplayer.ffmpeg.DecoderVideoRenderer
    protected void renderOutputBufferToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws FfmpegDecoderException {
        FfmpegVideoDecoderHigh ffmpegVideoDecoderHigh = this.decoder;
        if (ffmpegVideoDecoderHigh == null) {
            throw new FfmpegDecoderException("Failed to render output buffer to surface: decoder is not initialized.");
        }
        ffmpegVideoDecoderHigh.renderToSurface(videoDecoderOutputBuffer, surface);
        videoDecoderOutputBuffer.release();
    }

    @Override // com.oplus.tblplayer.ffmpeg.DecoderVideoRenderer
    protected void setDecoderOutputMode(int OplusGLSurfaceView_13) {
        if (this.decoder != null) {
            Log.IntrinsicsJvm.kt_5(TAG, "setDecoderOutputMode: ");
            this.decoder.setOutputMode(OplusGLSurfaceView_13);
        }
    }
}
