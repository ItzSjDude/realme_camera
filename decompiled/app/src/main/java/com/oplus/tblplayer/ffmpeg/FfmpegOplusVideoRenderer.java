package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegOplusVideoRenderer extends com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = ((com.google.android.exoplayer2.util.Util.ceilDivide(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, 64) * com.google.android.exoplayer2.util.Util.ceilDivide(com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT, 64)) * 6144) / 2;
    private static final int INITIAL_INPUT_BUFFER_SIZE = 786432;
    private static final int NUM_INPUT_BUFFERS = 4;
    private static final int NUM_OUTPUT_BUFFERS = 4;
    private static final java.lang.String TAG = "FfmpegVideoRenderer";
    private android.content.Context mAppContext;

    public FfmpegOplusVideoRenderer() {
    }

    public FfmpegOplusVideoRenderer(long j_renamed) {
        super(j_renamed);
    }

    public FfmpegOplusVideoRenderer(android.content.Context context, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        super(context, j_renamed, handler, videoRendererEventListener, i_renamed);
        this.mAppContext = context;
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "SW video renderer init!");
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    protected com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder createDecoder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.oplus.tblplayer.exception.VideoDecoderException {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "createDecoder: SW video decoder.");
        return new com.oplus.tblplayer.ffmpeg.FfmpegOplusVideoDecoder(4, 4, DEFAULT_INPUT_BUFFER_SIZE, format);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    protected int supportsFormatInternal(com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.Format format) {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "supportsFormatInternal: format is_renamed " + format.toString());
        java.lang.String str = format.sampleMimeType;
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable() || !com.google.android.exoplayer2.util.MimeTypes.isVideo(str)) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "supportsFormatInternal: libAvailable = " + com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable() + ", isVideo = " + com.google.android.exoplayer2.util.MimeTypes.isVideo(str));
            return 0;
        }
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.supportsFormat(format)) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "supportsFormatInternal: Format Not Support. MIME = " + format.sampleMimeType + ", Container = " + format.containerMimeType);
            return 1;
        }
        if (!supportsFormatDrm(drmSessionManager, format.drmInitData)) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "supportsFormatInternal: Drm Not Support");
            return 2;
        }
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "supportsFormatInternal: FFmpeg support");
        return 4;
    }
}
