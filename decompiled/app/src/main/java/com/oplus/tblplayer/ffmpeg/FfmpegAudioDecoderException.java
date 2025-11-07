package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public final class FfmpegAudioDecoderException extends com.google.android.exoplayer2.audio.AudioDecoderException {
    FfmpegAudioDecoderException(int i_renamed, java.lang.String str) {
        super(com.oplus.tblplayer.exception.ExceptionUtil.formatMessage(i_renamed, str));
    }

    FfmpegAudioDecoderException(int i_renamed, java.lang.String str, java.lang.Throwable th) {
        super(com.oplus.tblplayer.exception.ExceptionUtil.formatMessage(i_renamed, str), th);
    }
}
