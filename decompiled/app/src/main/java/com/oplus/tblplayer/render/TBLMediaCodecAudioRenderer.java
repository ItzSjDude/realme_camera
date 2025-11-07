package com.oplus.tblplayer.render;

/* loaded from: classes2.dex */
public class TBLMediaCodecAudioRenderer extends com.google.android.exoplayer2.audio.MediaCodecAudioRenderer implements com.oplus.tblplayer.render.FallbackRenderer, com.oplus.tblplayer.render.RollupRenderer {
    private static final java.lang.String TAG = "TBLMediaCodecRenderer";
    private java.util.concurrent.atomic.AtomicBoolean fallbackRenderer;
    private java.util.concurrent.atomic.AtomicBoolean rollupRenderer;

    public TBLMediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, (com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto>) null, false);
    }

    public TBLMediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed) {
        this(context, mediaCodecSelector, drmSessionManager, z_renamed, null, null);
    }

    public TBLMediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, null, false, handler, audioRendererEventListener);
    }

    public TBLMediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, drmSessionManager, z_renamed, handler, audioRendererEventListener, (com.google.android.exoplayer2.audio.AudioCapabilities) null, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public TBLMediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, drmSessionManager, z_renamed, handler, audioRendererEventListener, new com.google.android.exoplayer2.audio.DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public TBLMediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink audioSink) {
        super(context, mediaCodecSelector, drmSessionManager, z_renamed, handler, audioRendererEventListener, audioSink);
        this.fallbackRenderer = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.rollupRenderer = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    @Override // com.google.android.exoplayer2.audio.MediaCodecAudioRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        if (isFallback()) {
            return 0;
        }
        int iSupportsFormat = super.supportsFormat(mediaCodecSelector, drmSessionManager, format);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "Audio format support with mime type: " + format.sampleMimeType + ", support: " + iSupportsFormat);
        if (com.oplus.tblplayer.ffmpeg.FfmpegUtil.isFfmpegExtractor(format) && !isRollup() && (format.sampleMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC) || format.sampleMimeType.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG))) {
            return 0;
        }
        return iSupportsFormat;
    }

    @Override // com.google.android.exoplayer2.audio.MediaCodecAudioRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.Format format, android.media.MediaCrypto mediaCrypto, float f_renamed) {
        super.configureCodec(mediaCodecInfo, mediaCodec, com.oplus.tblplayer.ffmpeg.FfmpegUtil.maybeRemoveFfmpegCodecParameters(format), mediaCrypto, f_renamed);
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

    @Override // com.oplus.tblplayer.render.RollupRenderer
    public boolean isRollup() {
        return this.rollupRenderer.get();
    }

    @Override // com.oplus.tblplayer.render.RollupRenderer
    public void setRollupRenderer(boolean z_renamed) {
        if (this.rollupRenderer.get() != z_renamed) {
            this.rollupRenderer.set(z_renamed);
        }
    }
}
