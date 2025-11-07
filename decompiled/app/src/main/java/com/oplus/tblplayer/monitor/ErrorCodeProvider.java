package com.oplus.tblplayer.monitor;

import android.opengl.GLException;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DecryptionException;
import com.google.android.exoplayer2.drm.KeysExpiredException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public class ErrorCodeProvider implements ErrorCode {
    private static final String TAG = "ErrorCodeProvider";

    private static int toErrorReason(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return 100000;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return ErrorCode.REASON_RD_AUDIO;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return OplusGLSurfaceView_13 != 3 ? OplusGLSurfaceView_13 != 4 ? OplusGLSurfaceView_13 != 6 ? ErrorCode.REASON_RD_OTHERS : ErrorCode.REASON_RD_NONE : ErrorCode.REASON_RD_METADATA : ErrorCode.REASON_RD_TEXT;
        }
        return 300000;
    }

    public static int parseException(ExoPlayer exoPlayer, ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException instanceof ExoPlaybackException) {
            int OplusGLSurfaceView_13 = exoPlaybackException.type;
            if (OplusGLSurfaceView_13 == 0) {
                int errorCode = getErrorCode(6, exoPlaybackException.getCause());
                return errorCode == 999999 ? ErrorCode.REASON_MS_OTHERS : errorCode;
            }
            if (OplusGLSurfaceView_13 == 1) {
                int rendererType = exoPlayer.getRendererType(exoPlaybackException.rendererIndex);
                int errorCode2 = getErrorCode(rendererType, exoPlaybackException.getCause());
                return errorCode2 == 999999 ? toErrorReason(rendererType) : errorCode2;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return ErrorCode.REASON_OTHERS;
            }
        }
        return 0;
    }

    private static int getErrorCode(int OplusGLSurfaceView_13, Throwable th) {
        if (th instanceof Cache.CacheException) {
            return 3000;
        }
        if (th instanceof AssetDataSource.AssetDataSourceException) {
            return ErrorCode.REASON_DS_ASSET;
        }
        if (th instanceof FileDataSource.FileDataSourceException) {
            return ErrorCode.REASON_DS_FILE;
        }
        if (th instanceof HttpDataSource.HttpDataSourceException) {
            if (th instanceof HttpDataSource.InvalidContentTypeException) {
                return 8997;
            }
            if (th instanceof HttpDataSource.InvalidResponseCodeException) {
                int i2 = ((HttpDataSource.InvalidResponseCodeException) th).responseCode;
                if (i2 < 0 || i2 > 900) {
                    return 8996;
                }
                return i2 + 8000;
            }
            int i3 = ((HttpDataSource.HttpDataSourceException) th).type;
            int i4 = ErrorCode.REASON_DS_HTTP_OPEN;
            if (i3 != 1) {
                if (i3 == 2) {
                    i4 = ErrorCode.REASON_DS_HTTP_READ;
                } else if (i3 == 3) {
                    i4 = 10000;
                }
            }
            return th.getCause() instanceof UnknownHostException ? i4 + 999 : th.getCause() instanceof SocketTimeoutException ? i4 + ErrorCode.DETAIL_HTTP_TIMEOUT : i4;
        }
        if (th instanceof UdpDataSource.UdpDataSourceException) {
            return ErrorCode.REASON_DS_UDP;
        }
        if (th instanceof RawResourceDataSource.RawResourceDataSourceException) {
            return 15000;
        }
        if (th instanceof ContentDataSource.ContentDataSourceException) {
            return ErrorCode.REASON_DS_CONTENT;
        }
        if (th instanceof DataSourceException) {
            return ErrorCode.REASON_DS_OUT_OF_RANGE;
        }
        if (th instanceof BehindLiveWindowException) {
            return ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW;
        }
        if (th instanceof ParserException) {
            return th instanceof SsManifestParser.MissingFieldException ? ErrorCode.REASON_SS_MISSING_FIELD : th instanceof UnrecognizedInputFormatException ? ErrorCode.REASON_EXTRACTOR_UNSUPPORT : ErrorCode.REASON_PARSER;
        }
        if (th instanceof HlsPlaylistTracker.PlaylistResetException) {
            return ErrorCode.REASON_HLS_PLAYLIST_RESET;
        }
        if (th instanceof HlsPlaylistTracker.PlaylistStuckException) {
            return 25000;
        }
        return th instanceof Loader.UnexpectedLoaderException ? ErrorCode.REASON_UNEXPECTED_LOADER : th instanceof AudioSink.WriteException ? ErrorCode.REASON_RD_AUDIO_WRITE : th instanceof AudioSink.ConfigurationException ? ErrorCode.REASON_RD_AUDIO_CONFIG : th instanceof AudioSink.InitializationException ? ErrorCode.REASON_RD_AUDIO_INIT : th instanceof AudioProcessor.UnhandledFormatException ? ErrorCode.REASON_RD_UNHANDLED_FORMAT : th instanceof MediaCodecRenderer.DecoderInitializationException ? OplusGLSurfaceView_13 == 1 ? ErrorCode.REASON_RD_AUDIO_MC_INIT : OplusGLSurfaceView_13 == 2 ? ErrorCode.REASON_RD_VIDEO_MC_INIT : ErrorCode.REASON_OTHERS : th instanceof MediaCodecUtil.DecoderQueryException ? OplusGLSurfaceView_13 == 1 ? ErrorCode.REASON_RD_AUDIO_MC_QUERY : OplusGLSurfaceView_13 == 2 ? th instanceof TBLMediaCodecVideoRenderer.VideoOverSpecificationException ? ErrorCode.REASON_RD_VIDEO_OVER_SPEC : ErrorCode.REASON_RD_VIDEO_MC_QUERY : ErrorCode.REASON_OTHERS : th instanceof GLException ? ErrorCode.REASON_RD_VIDEO_GL_ERROR : th instanceof SubtitleDecoderException ? ErrorCode.REASON_RD_TEXT_SUBTITLE : th instanceof DecryptionException ? ErrorCode.REASON_DRM_DECRYPTION : th instanceof KeysExpiredException ? ErrorCode.REASON_DRM_KEYS_EXPIRED : ErrorCode.REASON_OTHERS;
    }
}
