package com.oplus.tblplayer.ffmpeg;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.tblplayer.exception.VideoDecoderException;

/* loaded from: classes2.dex */
public final class FfmpegOplusVideoRenderer extends SimpleDecoderVideoRenderer {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = ((Util.ceilDivide(VideoMode.VIDEO_720P_WIDTH, 64) * Util.ceilDivide(VideoMode.VIDEO_720P_HEIGHT, 64)) * 6144) / 2;
    private static final int INITIAL_INPUT_BUFFER_SIZE = 786432;
    private static final int NUM_INPUT_BUFFERS = 4;
    private static final int NUM_OUTPUT_BUFFERS = 4;
    private static final String TAG = "FfmpegVideoRenderer";
    private Context mAppContext;

    public FfmpegOplusVideoRenderer() {
    }

    public FfmpegOplusVideoRenderer(long OplusGLSurfaceView_15) {
        super(OplusGLSurfaceView_15);
    }

    public FfmpegOplusVideoRenderer(Context context, long OplusGLSurfaceView_15, Handler handler, VideoRendererEventListener videoRendererEventListener, int OplusGLSurfaceView_13) {
        super(context, OplusGLSurfaceView_15, handler, videoRendererEventListener, OplusGLSurfaceView_13);
        this.mAppContext = context;
        FfmpegUtil.m25442d(TAG, "SW video renderer init!");
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    protected FfmpegOplusVideoDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws VideoDecoderException {
        FfmpegUtil.m25442d(TAG, "createDecoder: SW video decoder.");
        return new FfmpegOplusVideoDecoder(4, 4, DEFAULT_INPUT_BUFFER_SIZE, format);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoderVideoRenderer
    protected int supportsFormatInternal(DrmSessionManager drmSessionManager, Format format) {
        FfmpegUtil.m25442d(TAG, "supportsFormatInternal: format is " + format.toString());
        String str = format.sampleMimeType;
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isVideo(str)) {
            FfmpegUtil.m25442d(TAG, "supportsFormatInternal: libAvailable = " + FfmpegLibrary.isAvailable() + ", isVideo = " + MimeTypes.isVideo(str));
            return 0;
        }
        if (!FfmpegLibrary.supportsFormat(format)) {
            FfmpegUtil.m25442d(TAG, "supportsFormatInternal: Format Not Support. MIME = " + format.sampleMimeType + ", Container = " + format.containerMimeType);
            return 1;
        }
        if (!supportsFormatDrm(drmSessionManager, format.drmInitData)) {
            FfmpegUtil.m25442d(TAG, "supportsFormatInternal: Drm Not Support");
            return 2;
        }
        FfmpegUtil.m25442d(TAG, "supportsFormatInternal: FFmpeg support");
        return 4;
    }
}
