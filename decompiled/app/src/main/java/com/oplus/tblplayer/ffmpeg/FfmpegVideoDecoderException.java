package com.oplus.tblplayer.ffmpeg;

import com.oplus.tblplayer.exception.ExceptionUtil;
import com.oplus.tblplayer.exception.VideoDecoderException;

/* loaded from: classes2.dex */
public final class FfmpegVideoDecoderException extends VideoDecoderException {
    FfmpegVideoDecoderException(int OplusGLSurfaceView_13, String str) {
        super(ExceptionUtil.formatMessage(OplusGLSurfaceView_13, str));
    }

    FfmpegVideoDecoderException(int OplusGLSurfaceView_13, String str, Throwable th) {
        super(ExceptionUtil.formatMessage(OplusGLSurfaceView_13, str), th);
    }
}
