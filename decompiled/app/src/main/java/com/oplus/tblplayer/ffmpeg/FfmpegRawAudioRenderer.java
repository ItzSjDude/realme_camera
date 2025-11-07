package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class FfmpegRawAudioRenderer extends com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer {
    protected static final int INITIAL_INPUT_BUFFER_SIZE = 5760;
    protected static final int NUM_BUFFERS = 16;
    private static final java.lang.String TAG = "FFRawAudioRenderer";
    protected com.oplus.tblplayer.ffmpeg.FfmpegRawAudioDecoder decoder;

    public FfmpegRawAudioRenderer() {
        this(null, null, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public FfmpegRawAudioRenderer(android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        super(handler, audioRendererEventListener, audioProcessorArr);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    protected int supportsFormatInternal(com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.ExoMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format) {
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.dfmt(TAG, format.toString(), new java.lang.Object[0]);
        java.lang.String str = format.sampleMimeType;
        if (!com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable() || !com.google.android.exoplayer2.util.MimeTypes.isAudio(str)) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.dfmt(TAG, "LibAlive: %b_renamed, isVideo: %b_renamed", java.lang.Boolean.valueOf(com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable()), java.lang.Boolean.valueOf(com.google.android.exoplayer2.util.MimeTypes.isAudio(str)));
            return 0;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW.compareTo(str) != 0) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.dfmt(TAG, "Format Not Support", new java.lang.Object[0]);
            return 0;
        }
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.dfmt(TAG, "Format audio/raw support", new java.lang.Object[0]);
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public com.oplus.tblplayer.ffmpeg.FfmpegRawAudioDecoder createDecoder(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.oplus.tblplayer.ffmpeg.FfmpegAudioDecoderException {
        this.decoder = new com.oplus.tblplayer.ffmpeg.FfmpegRawAudioDecoder(16, 16, INITIAL_INPUT_BUFFER_SIZE, format);
        return this.decoder;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        onPositionReset(j_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    protected com.google.android.exoplayer2.Format getOutputFormat() {
        return this.decoder.getOutFormat();
    }
}
