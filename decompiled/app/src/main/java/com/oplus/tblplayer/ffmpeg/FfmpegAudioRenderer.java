package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegAudioRenderer extends com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer {
    private static final int INITIAL_INPUT_BUFFER_SIZE = 5760;
    private static final int NUM_BUFFERS = 16;
    private static final java.lang.String TAG = "FfmpegAudioRenderer";
    private com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoder decoder;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() throws com.google.android.exoplayer2.ExoPlaybackException {
        return 8;
    }

    public FfmpegAudioRenderer() {
        this(null, null, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public FfmpegAudioRenderer(android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        super(handler, audioRendererEventListener, audioProcessorArr);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    protected int supportsFormatInternal(com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format) {
        java.lang.String str = format.sampleMimeType;
        if (com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable() && com.google.android.exoplayer2.util.MimeTypes.isAudio(str) && com.oplus.tblplayer.ffmpeg.FfmpegLibrary.supportsFormat(format)) {
            return !supportsFormatDrm(drmSessionManager, format.drmInitData) ? 2 : 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoder createDecoder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException {
        this.decoder = new com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoder(16, 16, INITIAL_INPUT_BUFFER_SIZE, format);
        return this.decoder;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        onPositionReset(j_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public com.google.android.exoplayer2.Format getOutputFormat() {
        return com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW, null, -1, -1, this.decoder.getChannelCount(), this.decoder.getSampleRate(), 2, null, null, 0, null);
    }
}
