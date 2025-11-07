package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.video.ColorInfo;

/* loaded from: classes2.dex */
public final class FfmpegVideoInputBuffer extends DecoderInputBuffer {
    public ColorInfo colorInfo;

    public FfmpegVideoInputBuffer() {
        super(2);
    }
}
