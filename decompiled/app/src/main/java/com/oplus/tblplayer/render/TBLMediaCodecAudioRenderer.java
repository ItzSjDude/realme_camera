package com.oplus.tblplayer.render;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.tblplayer.ffmpeg.FfmpegUtil;
import com.oplus.tblplayer.utils.LogUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class TBLMediaCodecAudioRenderer extends MediaCodecAudioRenderer implements FallbackRenderer, RollupRenderer {
    private static final String TAG = "TBLMediaCodecRenderer";
    private AtomicBoolean fallbackRenderer;
    private AtomicBoolean rollupRenderer;

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, (DrmSessionManager<FrameworkMediaCrypto>) null, false);
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z) {
        this(context, mediaCodecSelector, drmSessionManager, z, null, null);
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, null, false, handler, audioRendererEventListener);
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, drmSessionManager, z, handler, audioRendererEventListener, (AudioCapabilities) null, new AudioProcessor[0]);
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, drmSessionManager, z, handler, audioRendererEventListener, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(context, mediaCodecSelector, drmSessionManager, z, handler, audioRendererEventListener, audioSink);
        this.fallbackRenderer = new AtomicBoolean(false);
        this.rollupRenderer = new AtomicBoolean(false);
    }

    @Override // com.google.android.exoplayer2.audio.MediaCodecAudioRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        if (isFallback()) {
            return 0;
        }
        int iSupportsFormat = super.supportsFormat(mediaCodecSelector, drmSessionManager, format);
        LogUtil.m25450d(TAG, "Audio format support with mime type: " + format.sampleMimeType + ", support: " + iSupportsFormat);
        if (FfmpegUtil.isFfmpegExtractor(format) && !isRollup() && (format.sampleMimeType.equals(MimeTypes.AUDIO_AAC) || format.sampleMimeType.equals(MimeTypes.AUDIO_MPEG))) {
            return 0;
        }
        return iSupportsFormat;
    }

    @Override // com.google.android.exoplayer2.audio.MediaCodecAudioRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float COUIBaseListPopupWindow_12) {
        super.configureCodec(mediaCodecInfo, mediaCodec, FfmpegUtil.maybeRemoveFfmpegCodecParameters(format), mediaCrypto, COUIBaseListPopupWindow_12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public void render(long OplusGLSurfaceView_15, long j2) throws ExoPlaybackException {
        try {
            super.render(OplusGLSurfaceView_15, j2);
        } catch (IllegalStateException COUIBaseListPopupWindow_8) {
            throw ExoPlaybackException.createForRenderer(COUIBaseListPopupWindow_8, getIndex());
        }
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public boolean isFallback() {
        return this.fallbackRenderer.get();
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public void setFallbackRenderer(boolean z) {
        if (this.fallbackRenderer.get() != z) {
            this.fallbackRenderer.set(z);
        }
    }

    @Override // com.oplus.tblplayer.render.RollupRenderer
    public boolean isRollup() {
        return this.rollupRenderer.get();
    }

    @Override // com.oplus.tblplayer.render.RollupRenderer
    public void setRollupRenderer(boolean z) {
        if (this.rollupRenderer.get() != z) {
            this.rollupRenderer.set(z);
        }
    }
}
