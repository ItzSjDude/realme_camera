package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.decoder.Buffer;

/* loaded from: classes2.dex */
public abstract class OutputBuffer extends Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public interface Owner<S extends OutputBuffer> {
        void releaseOutputBuffer(S s);
    }

    public abstract void release();
}
