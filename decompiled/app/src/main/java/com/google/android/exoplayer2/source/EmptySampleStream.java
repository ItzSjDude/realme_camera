package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class EmptySampleStream implements com.google.android.exoplayer2.source.SampleStream {
    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws java.io.IOException {
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j_renamed) {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }
}
