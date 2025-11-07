package com.oplus.tblplayer.ffmpeg;

import android.os.Handler;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes2.dex */
public class FfmpegRawAudioRenderer extends SimpleDecoderAudioRenderer {
    protected static final int INITIAL_INPUT_BUFFER_SIZE = 5760;
    protected static final int NUM_BUFFERS = 16;
    private static final String TAG = "FFRawAudioRenderer";
    protected FfmpegRawAudioDecoder decoder;

    public FfmpegRawAudioRenderer() {
        this(null, null, new AudioProcessor[0]);
    }

    public FfmpegRawAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        super(handler, audioRendererEventListener, audioProcessorArr);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    protected int supportsFormatInternal(DrmSessionManager<ExoMediaCrypto> drmSessionManager, Format format) {
        FfmpegUtil.dfmt(TAG, format.toString(), new Object[0]);
        String str = format.sampleMimeType;
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isAudio(str)) {
            FfmpegUtil.dfmt(TAG, "LibAlive: %IntrinsicsJvm.kt_4, isVideo: %IntrinsicsJvm.kt_4", Boolean.valueOf(FfmpegLibrary.isAvailable()), Boolean.valueOf(MimeTypes.isAudio(str)));
            return 0;
        }
        if (MimeTypes.AUDIO_RAW.compareTo(str) != 0) {
            FfmpegUtil.dfmt(TAG, "Format Not Support", new Object[0]);
            return 0;
        }
        FfmpegUtil.dfmt(TAG, "Format audio/raw support", new Object[0]);
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    public FfmpegRawAudioDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws FfmpegAudioDecoderException {
        this.decoder = new FfmpegRawAudioDecoder(16, 16, INITIAL_INPUT_BUFFER_SIZE, format);
        return this.decoder;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long OplusGLSurfaceView_15, boolean z) throws ExoPlaybackException {
        onPositionReset(OplusGLSurfaceView_15, z);
    }

    @Override // com.google.android.exoplayer2.audio.SimpleDecoderAudioRenderer
    protected Format getOutputFormat() {
        return this.decoder.getOutFormat();
    }
}
