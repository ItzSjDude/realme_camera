package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegVideoRenderer extends com.oplus.tblplayer.ffmpeg.DecoderVideoRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = ((com.google.android.exoplayer2.util.Util.ceilDivide(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, 64) * com.google.android.exoplayer2.util.Util.ceilDivide(com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT, 64)) * 6144) / 2;
    private static final int DEFAULT_NUM_OF_INPUT_BUFFERS = 4;
    private static final int DEFAULT_NUM_OF_OUTPUT_BUFFERS = 4;
    private static final java.lang.String TAG = "FfmpegVideoRenderer";
    private com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderHigh decoder;
    private final int numInputBuffers;
    private final int numOutputBuffers;
    private final int threads;

    public FfmpegVideoRenderer(long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        this(j_renamed, handler, videoRendererEventListener, i_renamed, java.lang.Runtime.getRuntime().availableProcessors(), 4, 4);
    }

    public FfmpegVideoRenderer(long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed, int i2, int i3, int i4) {
        super(j_renamed, handler, videoRendererEventListener, i_renamed);
        this.threads = i2;
        this.numInputBuffers = i3;
        this.numOutputBuffers = i4;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(com.google.android.exoplayer2.Format format) {
        java.lang.String str = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(format.sampleMimeType);
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable() || !com.google.android.exoplayer2.util.MimeTypes.isVideo(str)) {
            return 0;
        }
        if (com.oplus.tblplayer.ffmpeg.FfmpegLibrary.supportsFormat(format)) {
            return format.drmInitData != null ? 2 : 4;
        }
        return 1;
    }

    @Override // com.oplus.tblplayer.ffmpeg.DecoderVideoRenderer
    protected com.google.android.exoplayer2.decoder.Decoder<com.oplus.tblplayer.ffmpeg.VideoDecoderInputBuffer, com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer, com.oplus.tblplayer.ffmpeg.FfmpegDecoderException> createDecoder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.oplus.tblplayer.ffmpeg.FfmpegDecoderException {
        com.google.android.exoplayer2.util.TraceUtil.beginSection("createGav1Decoder");
        com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderHigh ffmpegVideoDecoderHigh = new com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderHigh(this.numInputBuffers, this.numOutputBuffers, format.maxInputSize != -1 ? format.maxInputSize : DEFAULT_INPUT_BUFFER_SIZE, this.threads, format);
        this.decoder = ffmpegVideoDecoderHigh;
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        return ffmpegVideoDecoderHigh;
    }

    @Override // com.oplus.tblplayer.ffmpeg.DecoderVideoRenderer
    protected void renderOutputBufferToSurface(com.oplus.tblplayer.ffmpeg.VideoDecoderOutputBuffer videoDecoderOutputBuffer, android.view.Surface surface) throws com.oplus.tblplayer.ffmpeg.FfmpegDecoderException {
        com.oplus.tblplayer.ffmpeg.FfmpegVideoDecoderHigh ffmpegVideoDecoderHigh = this.decoder;
        if (ffmpegVideoDecoderHigh == null) {
            throw new com.oplus.tblplayer.ffmpeg.FfmpegDecoderException("Failed to render output buffer to surface: decoder is_renamed not initialized.");
        }
        ffmpegVideoDecoderHigh.renderToSurface(videoDecoderOutputBuffer, surface);
        videoDecoderOutputBuffer.release();
    }

    @Override // com.oplus.tblplayer.ffmpeg.DecoderVideoRenderer
    protected void setDecoderOutputMode(int i_renamed) {
        if (this.decoder != null) {
            android.util.Log.d_renamed(TAG, "setDecoderOutputMode: ");
            this.decoder.setOutputMode(i_renamed);
        }
    }
}
