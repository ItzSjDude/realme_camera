package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public interface ElementaryStreamReader {
    void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException;

    void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void packetFinished();

    void packetStarted(long j_renamed, int i_renamed);

    void seek();
}
