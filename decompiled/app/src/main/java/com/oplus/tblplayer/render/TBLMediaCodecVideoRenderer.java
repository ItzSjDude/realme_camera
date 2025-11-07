package com.oplus.tblplayer.render;

/* loaded from: classes2.dex */
public class TBLMediaCodecVideoRenderer extends com.oplus.tblplayer.render.MediaCodecVideoRenderer implements com.oplus.tblplayer.render.FallbackRenderer {
    private static final java.lang.String TAG = "TBLMediaCodecRenderer";
    private java.util.concurrent.atomic.AtomicBoolean fallbackRenderer;
    private boolean reconfigureFormat;

    public TBLMediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public TBLMediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j_renamed) {
        this(context, mediaCodecSelector, j_renamed, null, null, -1);
    }

    public TBLMediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        this(context, mediaCodecSelector, j_renamed, null, false, handler, videoRendererEventListener, i_renamed);
    }

    public TBLMediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j_renamed, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i_renamed) {
        super(context, mediaCodecSelector, j_renamed, drmSessionManager, z_renamed, handler, videoRendererEventListener, i_renamed);
        this.reconfigureFormat = false;
        this.fallbackRenderer = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    @Override // com.oplus.tblplayer.render.MediaCodecVideoRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        if (isFallback()) {
            return 0;
        }
        int iSupportsFormat = super.supportsFormat(mediaCodecSelector, drmSessionManager, format);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "Video format support with mime type: " + format.sampleMimeType + ", support: " + iSupportsFormat);
        if (format.colorInfo != null && (format.colorInfo.colorTransfer == 6 || format.colorInfo.colorTransfer == 7)) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "Video format support with HDR info: " + format.colorInfo);
            java.lang.String str = com.google.android.exoplayer2.util.Util.MODEL;
            char c2 = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != 1691570181) {
                if (iHashCode == 1907627891 && str.equals("A102OP")) {
                    c2 = 1;
                }
            } else if (str.equals("CPH2309")) {
                c2 = 0;
            }
            if (c2 == 0 || c2 == 1) {
                throw new com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer.VideoOverSpecificationException(new java.lang.Exception("Device not support HDR 10bit"));
            }
        }
        if ((com.oplus.tblplayer.ffmpeg.FfmpegUtil.isFfmpegExtraDataEmpty(format) && format.sampleMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4V)) || format.sampleMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1) || com.oplus.tblplayer.ffmpeg.FfmpegUtil.isSpecialVideoCodec()) {
            return 0;
        }
        if (com.oplus.tblplayer.ffmpeg.FfmpegUtil.isFfmpegExtractor(format) && com.oplus.tblplayer.ffmpeg.FfmpegUtil.isVideoPixelFormatHwNotSupported(format)) {
            return 0;
        }
        if ((iSupportsFormat & 3) != 3) {
            return iSupportsFormat;
        }
        com.oplus.tblplayer.utils.LogUtil.w_renamed(TAG, "Format exceed the renderer's_renamed capabilities, need reconfigure.");
        this.reconfigureFormat = true;
        return (iSupportsFormat & 24) | (iSupportsFormat & 32) | 4;
    }

    @Override // com.oplus.tblplayer.render.MediaCodecVideoRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.Format format, android.media.MediaCrypto mediaCrypto, float f_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.Format formatCopyWithFrameRate;
        float f2;
        com.google.android.exoplayer2.Format formatMaybeRemoveFfmpegCodecParameters = com.oplus.tblplayer.ffmpeg.FfmpegUtil.maybeRemoveFfmpegCodecParameters(format);
        if (this.reconfigureFormat) {
            com.oplus.tblplayer.utils.LogUtil.w_renamed(TAG, "Format exceed the renderer's_renamed capabilities, will reconfigure.");
            formatCopyWithFrameRate = formatMaybeRemoveFfmpegCodecParameters.copyWithFrameRate(-1.0f);
            f2 = -1.0f;
        } else {
            formatCopyWithFrameRate = formatMaybeRemoveFfmpegCodecParameters;
            f2 = f_renamed;
        }
        super.configureCodec(mediaCodecInfo, mediaCodec, formatCopyWithFrameRate, mediaCrypto, f2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        try {
            super.render(j_renamed, j2);
        } catch (java.lang.IllegalStateException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public boolean isFallback() {
        return this.fallbackRenderer.get();
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public void setFallbackRenderer(boolean z_renamed) {
        if (this.fallbackRenderer.get() != z_renamed) {
            this.fallbackRenderer.set(z_renamed);
        }
    }

    public final class VideoOverSpecificationException extends com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        public VideoOverSpecificationException(java.lang.Throwable th) {
            super(th);
        }
    }
}
