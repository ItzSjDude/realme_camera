package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes.dex */
abstract class TagPayloadReader {
    protected final com.google.android.exoplayer2.extractor.TrackOutput output;

    protected abstract boolean parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException;

    protected abstract void parsePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException;

    public abstract void seek();

    public static final class UnsupportedFormatException extends com.google.android.exoplayer2.ParserException {
        public UnsupportedFormatException(java.lang.String str) {
            super(str);
        }
    }

    protected TagPayloadReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public final void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        if (parseHeader(parsableByteArray)) {
            parsePayload(parsableByteArray, j_renamed);
        }
    }
}
