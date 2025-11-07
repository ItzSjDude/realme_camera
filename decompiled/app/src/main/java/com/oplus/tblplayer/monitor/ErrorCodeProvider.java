package com.oplus.tblplayer.monitor;

/* loaded from: classes2.dex */
public class ErrorCodeProvider implements com.oplus.tblplayer.monitor.ErrorCode {
    private static final java.lang.String TAG = "ErrorCodeProvider";

    private static int toErrorReason(int i_renamed) {
        if (i_renamed == 0) {
            return 100000;
        }
        if (i_renamed == 1) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_AUDIO;
        }
        if (i_renamed != 2) {
            return i_renamed != 3 ? i_renamed != 4 ? i_renamed != 6 ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_OTHERS : com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_NONE : com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_METADATA : com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_TEXT;
        }
        return 300000;
    }

    public static int parseException(com.google.android.exoplayer2.ExoPlayer exoPlayer, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException instanceof com.google.android.exoplayer2.ExoPlaybackException) {
            int i_renamed = exoPlaybackException.type;
            if (i_renamed == 0) {
                int errorCode = getErrorCode(6, exoPlaybackException.getCause());
                return errorCode == 999999 ? com.oplus.tblplayer.monitor.ErrorCode.REASON_MS_OTHERS : errorCode;
            }
            if (i_renamed == 1) {
                int rendererType = exoPlayer.getRendererType(exoPlaybackException.rendererIndex);
                int errorCode2 = getErrorCode(rendererType, exoPlaybackException.getCause());
                return errorCode2 == 999999 ? toErrorReason(rendererType) : errorCode2;
            }
            if (i_renamed == 2) {
                return com.oplus.tblplayer.monitor.ErrorCode.REASON_OTHERS;
            }
        }
        return 0;
    }

    private static int getErrorCode(int i_renamed, java.lang.Throwable th) {
        if (th instanceof com.google.android.exoplayer2.upstream.cache.Cache.CacheException) {
            return 3000;
        }
        if (th instanceof com.google.android.exoplayer2.upstream.AssetDataSource.AssetDataSourceException) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_ASSET;
        }
        if (th instanceof com.google.android.exoplayer2.upstream.FileDataSource.FileDataSourceException) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_FILE;
        }
        if (th instanceof com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException) {
            if (th instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException) {
                return 8997;
            }
            if (th instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) {
                int i2 = ((com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) th).responseCode;
                if (i2 < 0 || i2 > 900) {
                    return 8996;
                }
                return i2 + 8000;
            }
            int i3 = ((com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException) th).type;
            int i4 = com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_HTTP_OPEN;
            if (i3 != 1) {
                if (i3 == 2) {
                    i4 = com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_HTTP_READ;
                } else if (i3 == 3) {
                    i4 = 10000;
                }
            }
            return th.getCause() instanceof java.net.UnknownHostException ? i4 + 999 : th.getCause() instanceof java.net.SocketTimeoutException ? i4 + com.oplus.tblplayer.monitor.ErrorCode.DETAIL_HTTP_TIMEOUT : i4;
        }
        if (th instanceof com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_UDP;
        }
        if (th instanceof com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException) {
            return 15000;
        }
        if (th instanceof com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_CONTENT;
        }
        if (th instanceof com.google.android.exoplayer2.upstream.DataSourceException) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_OUT_OF_RANGE;
        }
        if (th instanceof com.google.android.exoplayer2.source.BehindLiveWindowException) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW;
        }
        if (th instanceof com.google.android.exoplayer2.ParserException) {
            return th instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_SS_MISSING_FIELD : th instanceof com.google.android.exoplayer2.source.UnrecognizedInputFormatException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_EXTRACTOR_UNSUPPORT : com.oplus.tblplayer.monitor.ErrorCode.REASON_PARSER;
        }
        if (th instanceof com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistResetException) {
            return com.oplus.tblplayer.monitor.ErrorCode.REASON_HLS_PLAYLIST_RESET;
        }
        if (th instanceof com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistStuckException) {
            return 25000;
        }
        return th instanceof com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_UNEXPECTED_LOADER : th instanceof com.google.android.exoplayer2.audio.AudioSink.WriteException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_AUDIO_WRITE : th instanceof com.google.android.exoplayer2.audio.AudioSink.ConfigurationException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_AUDIO_CONFIG : th instanceof com.google.android.exoplayer2.audio.AudioSink.InitializationException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_AUDIO_INIT : th instanceof com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_UNHANDLED_FORMAT : th instanceof com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException ? i_renamed == 1 ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_AUDIO_MC_INIT : i_renamed == 2 ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_VIDEO_MC_INIT : com.oplus.tblplayer.monitor.ErrorCode.REASON_OTHERS : th instanceof com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException ? i_renamed == 1 ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_AUDIO_MC_QUERY : i_renamed == 2 ? th instanceof com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer.VideoOverSpecificationException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_VIDEO_OVER_SPEC : com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_VIDEO_MC_QUERY : com.oplus.tblplayer.monitor.ErrorCode.REASON_OTHERS : th instanceof android.opengl.GLException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_VIDEO_GL_ERROR : th instanceof com.google.android.exoplayer2.text.SubtitleDecoderException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_RD_TEXT_SUBTITLE : th instanceof com.google.android.exoplayer2.drm.DecryptionException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_DRM_DECRYPTION : th instanceof com.google.android.exoplayer2.drm.KeysExpiredException ? com.oplus.tblplayer.monitor.ErrorCode.REASON_DRM_KEYS_EXPIRED : com.oplus.tblplayer.monitor.ErrorCode.REASON_OTHERS;
    }
}
