package com.google.android.exoplayer2.extractor.rawcc;

/* loaded from: classes.dex */
public final class RawCcExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    private static final int HEADER_ID = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("RCC\u0001");
    private static final int HEADER_SIZE = 8;
    private static final int SCRATCH_SIZE = 9;
    private static final int STATE_READING_HEADER = 0;
    private static final int STATE_READING_SAMPLES = 2;
    private static final int STATE_READING_TIMESTAMP_AND_COUNT = 1;
    private static final int TIMESTAMP_SIZE_V0 = 4;
    private static final int TIMESTAMP_SIZE_V1 = 8;
    private final com.google.android.exoplayer2.Format format;
    private int remainingSampleCount;
    private int sampleBytesWritten;
    private long timestampUs;
    private com.google.android.exoplayer2.extractor.TrackOutput trackOutput;
    private int version;
    private final com.google.android.exoplayer2.util.ParsableByteArray dataScratch = new com.google.android.exoplayer2.util.ParsableByteArray(9);
    private int parserState = 0;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public RawCcExtractor(com.google.android.exoplayer2.Format format) {
        this.format = format;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
        this.trackOutput = extractorOutput.track(0, 3);
        extractorOutput.endTracks();
        this.trackOutput.format(this.format);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        this.dataScratch.reset();
        extractorInput.peekFully(this.dataScratch.data, 0, 8);
        return this.dataScratch.readInt() == HEADER_ID;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        while (true) {
            int i_renamed = this.parserState;
            if (i_renamed != 0) {
                if (i_renamed != 1) {
                    if (i_renamed == 2) {
                        parseSamples(extractorInput);
                        this.parserState = 1;
                        return 0;
                    }
                    throw new java.lang.IllegalStateException();
                }
                if (parseTimestampAndSampleCount(extractorInput)) {
                    this.parserState = 2;
                } else {
                    this.parserState = 0;
                    return -1;
                }
            } else {
                if (!parseHeader(extractorInput)) {
                    return -1;
                }
                this.parserState = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.parserState = 0;
    }

    private boolean parseHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        this.dataScratch.reset();
        if (!extractorInput.readFully(this.dataScratch.data, 0, 8, true)) {
            return false;
        }
        if (this.dataScratch.readInt() != HEADER_ID) {
            throw new java.io.IOException("Input not RawCC");
        }
        this.version = this.dataScratch.readUnsignedByte();
        return true;
    }

    private boolean parseTimestampAndSampleCount(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        this.dataScratch.reset();
        int i_renamed = this.version;
        if (i_renamed == 0) {
            if (!extractorInput.readFully(this.dataScratch.data, 0, 5, true)) {
                return false;
            }
            this.timestampUs = (this.dataScratch.readUnsignedInt() * 1000) / 45;
        } else if (i_renamed == 1) {
            if (!extractorInput.readFully(this.dataScratch.data, 0, 9, true)) {
                return false;
            }
            this.timestampUs = this.dataScratch.readLong();
        } else {
            throw new com.google.android.exoplayer2.ParserException("Unsupported version number: " + this.version);
        }
        this.remainingSampleCount = this.dataScratch.readUnsignedByte();
        this.sampleBytesWritten = 0;
        return true;
    }

    private void parseSamples(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        while (this.remainingSampleCount > 0) {
            this.dataScratch.reset();
            extractorInput.readFully(this.dataScratch.data, 0, 3);
            this.trackOutput.sampleData(this.dataScratch, 3);
            this.sampleBytesWritten += 3;
            this.remainingSampleCount--;
        }
        int i_renamed = this.sampleBytesWritten;
        if (i_renamed > 0) {
            this.trackOutput.sampleMetadata(this.timestampUs, 1, i_renamed, 0, null);
        }
    }
}
