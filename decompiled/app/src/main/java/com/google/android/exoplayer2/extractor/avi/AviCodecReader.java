package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
abstract class AviCodecReader {
    protected final TrackOutput output;

    protected abstract void parseData(ParsableByteArray parsableByteArray, long OplusGLSurfaceView_15) throws ParserException;

    protected abstract boolean parseHeader(ParsableByteArray parsableByteArray) throws ParserException;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    protected AviCodecReader(TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public final void parse(ParsableByteArray parsableByteArray, long OplusGLSurfaceView_15) throws ParserException {
        if (parseHeader(parsableByteArray)) {
            parseData(parsableByteArray, OplusGLSurfaceView_15);
        }
    }
}
