package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public interface SampleStream {
    boolean isReady();

    void maybeThrowError() throws java.io.IOException;

    int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed);

    int skipData(long j_renamed);
}
