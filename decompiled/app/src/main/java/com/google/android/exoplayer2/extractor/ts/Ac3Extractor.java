package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class Ac3Extractor implements com.google.android.exoplayer2.extractor.Extractor {
    private static final int AC3_SYNC_WORD = 2935;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.-$$Lambda$Ac3Extractor$c2Fqr1pF6vjFNOhLk9sPPtkNnGE
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.ts.Ac3Extractor.lambda$static$0();
        }
    };
    private static final int ID3_TAG = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ID3");
    private static final int MAX_SNIFF_BYTES = 8192;
    private static final int MAX_SYNC_FRAME_SIZE = 2786;
    private final long firstSampleTimestampUs;
    private final com.google.android.exoplayer2.extractor.ts.Ac3Reader reader;
    private final com.google.android.exoplayer2.util.ParsableByteArray sampleData;
    private boolean startedPacket;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.Ac3Extractor()};
    }

    public Ac3Extractor() {
        this(0L);
    }

    public Ac3Extractor(long j_renamed) {
        this.firstSampleTimestampUs = j_renamed;
        this.reader = new com.google.android.exoplayer2.extractor.ts.Ac3Reader();
        this.sampleData = new com.google.android.exoplayer2.util.ParsableByteArray(MAX_SYNC_FRAME_SIZE);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(10);
        int i_renamed = 0;
        while (true) {
            extractorInput.peekFully(parsableByteArray.data, 0, 10);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != ID3_TAG) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int synchSafeInt = parsableByteArray.readSynchSafeInt();
            i_renamed += synchSafeInt + 10;
            extractorInput.advancePeekPosition(synchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i_renamed);
        int i2 = 0;
        int i3 = i_renamed;
        while (true) {
            extractorInput.peekFully(parsableByteArray.data, 0, 6);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedShort() != AC3_SYNC_WORD) {
                extractorInput.resetPeekPosition();
                i3++;
                if (i3 - i_renamed >= 8192) {
                    return false;
                }
                extractorInput.advancePeekPosition(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int ac3SyncframeSize = com.google.android.exoplayer2.audio.Ac3Util.parseAc3SyncframeSize(parsableByteArray.data);
                if (ac3SyncframeSize == -1) {
                    return false;
                }
                extractorInput.advancePeekPosition(ac3SyncframeSize - 6);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.reader.createTracks(extractorOutput, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
        extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.startedPacket = false;
        this.reader.seek();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed = extractorInput.read(this.sampleData.data, 0, MAX_SYNC_FRAME_SIZE);
        if (i_renamed == -1) {
            return -1;
        }
        this.sampleData.setPosition(0);
        this.sampleData.setLimit(i_renamed);
        if (!this.startedPacket) {
            this.reader.packetStarted(this.firstSampleTimestampUs, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.sampleData);
        return 0;
    }
}
