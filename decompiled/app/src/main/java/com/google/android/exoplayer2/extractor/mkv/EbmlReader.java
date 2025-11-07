package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes.dex */
interface EbmlReader {
    void init(com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput ebmlReaderOutput);

    boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException;

    void reset();
}
