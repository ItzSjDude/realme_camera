package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegVideoDecoderException extends com.oplus.tblplayer.exception.VideoDecoderException {
    FfmpegVideoDecoderException(int i_renamed, java.lang.String str) {
        super(com.oplus.tblplayer.exception.ExceptionUtil.formatMessage(i_renamed, str));
    }

    FfmpegVideoDecoderException(int i_renamed, java.lang.String str, java.lang.Throwable th) {
        super(com.oplus.tblplayer.exception.ExceptionUtil.formatMessage(i_renamed, str), th);
    }
}
