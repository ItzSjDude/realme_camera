package com.oplus.tblplayer.render;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tblplayer.ffmpeg.FfmpegUtil;
import com.oplus.tblplayer.utils.LogUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class TBLMediaCodecVideoRenderer extends MediaCodecVideoRenderer implements FallbackRenderer {
    private static final String TAG = "TBLMediaCodecRenderer";
    private AtomicBoolean fallbackRenderer;
    private boolean reconfigureFormat;

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long OplusGLSurfaceView_15) {
        this(context, mediaCodecSelector, OplusGLSurfaceView_15, null, null, -1);
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13) {
        this(context, mediaCodecSelector, OplusGLSurfaceView_15, null, false, handler, videoRendererEventListener, OplusGLSurfaceView_13);
    }

    public TBLMediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long OplusGLSurfaceView_15, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13) {
        super(context, mediaCodecSelector, OplusGLSurfaceView_15, drmSessionManager, z, handler, videoRendererEventListener, OplusGLSurfaceView_13);
        this.reconfigureFormat = false;
        this.fallbackRenderer = new AtomicBoolean(false);
    }

    @Override // com.oplus.tblplayer.render.MediaCodecVideoRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        if (isFallback()) {
            return 0;
        }
        int iSupportsFormat = super.supportsFormat(mediaCodecSelector, drmSessionManager, format);
        LogUtil.m25450d(TAG, "Video format support with mime type: " + format.sampleMimeType + ", support: " + iSupportsFormat);
        if (format.colorInfo != null && (format.colorInfo.colorTransfer == 6 || format.colorInfo.colorTransfer == 7)) {
            LogUtil.m25450d(TAG, "Video format support with HDR info: " + format.colorInfo);
            String str = Util.MODEL;
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
                throw new VideoOverSpecificationException(new Exception("Device not support HDR 10bit"));
            }
        }
        if ((FfmpegUtil.isFfmpegExtraDataEmpty(format) && format.sampleMimeType.equals(MimeTypes.VIDEO_MP4V)) || format.sampleMimeType.equals(MimeTypes.VIDEO_AV1) || FfmpegUtil.isSpecialVideoCodec()) {
            return 0;
        }
        if (FfmpegUtil.isFfmpegExtractor(format) && FfmpegUtil.isVideoPixelFormatHwNotSupported(format)) {
            return 0;
        }
        if ((iSupportsFormat & 3) != 3) {
            return iSupportsFormat;
        }
        LogUtil.m25456w(TAG, "Format exceed the renderer's capabilities, need reconfigure.");
        this.reconfigureFormat = true;
        return (iSupportsFormat & 24) | (iSupportsFormat & 32) | 4;
    }

    @Override // com.oplus.tblplayer.render.MediaCodecVideoRenderer, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float COUIBaseListPopupWindow_12) throws MediaCodecUtil.DecoderQueryException {
        Format formatCopyWithFrameRate;
        float f2;
        Format formatMaybeRemoveFfmpegCodecParameters = FfmpegUtil.maybeRemoveFfmpegCodecParameters(format);
        if (this.reconfigureFormat) {
            LogUtil.m25456w(TAG, "Format exceed the renderer's capabilities, will reconfigure.");
            formatCopyWithFrameRate = formatMaybeRemoveFfmpegCodecParameters.copyWithFrameRate(-1.0f);
            f2 = -1.0f;
        } else {
            formatCopyWithFrameRate = formatMaybeRemoveFfmpegCodecParameters;
            f2 = COUIBaseListPopupWindow_12;
        }
        super.configureCodec(mediaCodecInfo, mediaCodec, formatCopyWithFrameRate, mediaCrypto, f2);
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

    public final class VideoOverSpecificationException extends MediaCodecUtil.DecoderQueryException {
        public VideoOverSpecificationException(Throwable th) {
            super(th);
        }
    }
}
