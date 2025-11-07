package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public interface ExtractorOutput {
    void endTracks();

    void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap);

    com.google.android.exoplayer2.extractor.TrackOutput track(int i_renamed, int i2);
}
