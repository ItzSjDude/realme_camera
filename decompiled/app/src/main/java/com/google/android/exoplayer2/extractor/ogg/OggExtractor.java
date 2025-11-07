package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
public class OggExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ogg.-$$Lambda$OggExtractor$Ibu4KG2n586HVQ8R-UQJ8hUhsso
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.ogg.OggExtractor.lambda$static$0();
        }
    };
    private static final int MAX_VERIFICATION_BYTES = 8;
    private com.google.android.exoplayer2.extractor.ExtractorOutput output;
    private com.google.android.exoplayer2.extractor.ogg.StreamReader streamReader;
    private boolean streamReaderInitialized;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ogg.OggExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        try {
            return sniffInternal(extractorInput);
        } catch (com.google.android.exoplayer2.ParserException unused) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        com.google.android.exoplayer2.extractor.ogg.StreamReader streamReader = this.streamReader;
        if (streamReader != null) {
            streamReader.seek(j_renamed, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        if (this.streamReader == null) {
            if (!sniffInternal(extractorInput)) {
                throw new com.google.android.exoplayer2.ParserException("Failed to determine bitstream type");
            }
            extractorInput.resetPeekPosition();
        }
        if (!this.streamReaderInitialized) {
            com.google.android.exoplayer2.extractor.TrackOutput trackOutputTrack = this.output.track(0, 1);
            this.output.endTracks();
            this.streamReader.init(this.output, trackOutputTrack);
            this.streamReaderInitialized = true;
        }
        return this.streamReader.read(extractorInput, positionHolder);
    }

    private boolean sniffInternal(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader = new com.google.android.exoplayer2.extractor.ogg.OggPageHeader();
        if (oggPageHeader.populate(extractorInput, true) && (oggPageHeader.type & 2) == 2) {
            int iMin = java.lang.Math.min(oggPageHeader.bodySize, 8);
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(iMin);
            extractorInput.peekFully(parsableByteArray.data, 0, iMin);
            if (com.google.android.exoplayer2.extractor.ogg.FlacReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                this.streamReader = new com.google.android.exoplayer2.extractor.ogg.FlacReader();
            } else if (com.google.android.exoplayer2.extractor.ogg.VorbisReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                this.streamReader = new com.google.android.exoplayer2.extractor.ogg.VorbisReader();
            } else if (com.google.android.exoplayer2.extractor.ogg.OpusReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                this.streamReader = new com.google.android.exoplayer2.extractor.ogg.OpusReader();
            }
            return true;
        }
        return false;
    }

    private static com.google.android.exoplayer2.util.ParsableByteArray resetPosition(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(0);
        return parsableByteArray;
    }
}
