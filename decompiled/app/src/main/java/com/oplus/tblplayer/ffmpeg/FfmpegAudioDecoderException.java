package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.audio.AudioDecoderException;
import com.oplus.tblplayer.exception.ExceptionUtil;

/* loaded from: classes2.dex */
public final class FfmpegAudioDecoderException extends AudioDecoderException {
    FfmpegAudioDecoderException(int OplusGLSurfaceView_13, String str) {
        super(ExceptionUtil.formatMessage(OplusGLSurfaceView_13, str));
    }

    FfmpegAudioDecoderException(int OplusGLSurfaceView_13, String str, Throwable th) {
        super(ExceptionUtil.formatMessage(OplusGLSurfaceView_13, str), th);
    }
}
