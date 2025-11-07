package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public abstract class OutputBuffer extends com.google.android.exoplayer2.decoder.Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public interface Owner<S_renamed extends com.oplus.tblplayer.ffmpeg.OutputBuffer> {
        void releaseOutputBuffer(S_renamed s_renamed);
    }

    public abstract void release();
}
