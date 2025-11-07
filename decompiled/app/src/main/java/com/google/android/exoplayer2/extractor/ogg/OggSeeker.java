package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
interface OggSeeker {
    com.google.android.exoplayer2.extractor.SeekMap createSeekMap();

    long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException;

    long startSeek(long j_renamed);
}
