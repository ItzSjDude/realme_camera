package com.google.android.exoplayer2.extractor.avi;

/* loaded from: classes.dex */
abstract class AviCodecReader {
    protected final com.google.android.exoplayer2.extractor.TrackOutput output;

    protected abstract void parseData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException;

    protected abstract boolean parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException;

    public static final class UnsupportedFormatException extends com.google.android.exoplayer2.ParserException {
        public UnsupportedFormatException(java.lang.String str) {
            super(str);
        }
    }

    protected AviCodecReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public final void parse(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        if (parseHeader(parsableByteArray)) {
            parseData(parsableByteArray, j_renamed);
        }
    }
}
