package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class AdtsExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_PACKET_SIZE = 2048;
    private static final int MAX_SNIFF_BYTES = 8192;
    private static final int NUM_FRAMES_FOR_AVERAGE_FRAME_SIZE = 1000;
    private int averageFrameSize;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private long firstFramePosition;
    private long firstSampleTimestampUs;
    private final long firstStreamSampleTimestampUs;
    private final int flags;
    private boolean hasCalculatedAverageFrameSize;
    private boolean hasOutputSeekMap;
    private final com.google.android.exoplayer2.util.ParsableByteArray packetBuffer;
    private final com.google.android.exoplayer2.extractor.ts.AdtsReader reader;
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch;
    private final com.google.android.exoplayer2.util.ParsableBitArray scratchBits;
    private boolean startedPacket;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.-$$Lambda$AdtsExtractor$cqGYwjddB4W6E3ogPGiWfjTa23c
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.ts.AdtsExtractor.lambda$static$0();
        }
    };
    private static final int ID3_TAG = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ID3");

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.AdtsExtractor()};
    }

    public AdtsExtractor() {
        this(0L);
    }

    public AdtsExtractor(long j_renamed) {
        this(j_renamed, 0);
    }

    public AdtsExtractor(long j_renamed, int i_renamed) {
        this.firstStreamSampleTimestampUs = j_renamed;
        this.firstSampleTimestampUs = j_renamed;
        this.flags = i_renamed;
        this.reader = new com.google.android.exoplayer2.extractor.ts.AdtsReader(true);
        this.packetBuffer = new com.google.android.exoplayer2.util.ParsableByteArray(2048);
        this.averageFrameSize = -1;
        this.firstFramePosition = -1L;
        this.scratch = new com.google.android.exoplayer2.util.ParsableByteArray(10);
        this.scratchBits = new com.google.android.exoplayer2.util.ParsableBitArray(this.scratch.data);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:6:0x0021, code lost:
    
        r9.resetPeekPosition();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:7:0x002a, code lost:
    
        if ((r3 - r0) < 8192) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:8:0x002c, code lost:
    
        return false;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput r9) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.peekId3Header(r9)
            r1 = 0
            r3 = r0
        L6:
            r2 = r1
            r4 = r2
        L8:
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.scratch
            byte[] r5 = r5.data
            r6 = 2
            r9.peekFully(r5, r1, r6)
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.scratch
            r5.setPosition(r1)
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.scratch
            int r5 = r5.readUnsignedShort()
            boolean r5 = com.google.android.exoplayer2.extractor.ts.AdtsReader.isAdtsSyncWord(r5)
            if (r5 != 0) goto L31
            r9.resetPeekPosition()
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r2 < r4) goto L2d
            return r1
        L2d:
            r9.advancePeekPosition(r3)
            goto L6
        L31:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L3b
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L3b
            return r5
        L3b:
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r8.scratch
            byte[] r5 = r5.data
            r9.peekFully(r5, r1, r6)
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r8.scratchBits
            r6 = 14
            r5.setPosition(r6)
            com.google.android.exoplayer2.util.ParsableBitArray r5 = r8.scratchBits
            r6 = 13
            int r5 = r5.readBits(r6)
            r6 = 6
            if (r5 > r6) goto L55
            return r1
        L55:
            int r6 = r5 + (-6)
            r9.advancePeekPosition(r6)
            int r4 = r4 + r5
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.AdtsExtractor.sniff(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.reader.createTracks(extractorOutput, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.startedPacket = false;
        this.reader.seek();
        this.firstSampleTimestampUs = this.firstStreamSampleTimestampUs + j2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        long length = extractorInput.getLength();
        boolean z_renamed = ((this.flags & 1) == 0 || length == -1) ? false : true;
        if (z_renamed) {
            calculateAverageFrameSize(extractorInput);
        }
        int i_renamed = extractorInput.read(this.packetBuffer.data, 0, 2048);
        boolean z2 = i_renamed == -1;
        maybeOutputSeekMap(length, z_renamed, z2);
        if (z2) {
            return -1;
        }
        this.packetBuffer.setPosition(0);
        this.packetBuffer.setLimit(i_renamed);
        if (!this.startedPacket) {
            this.reader.packetStarted(this.firstSampleTimestampUs, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.packetBuffer);
        return 0;
    }

    private int peekId3Header(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed = 0;
        while (true) {
            extractorInput.peekFully(this.scratch.data, 0, 10);
            this.scratch.setPosition(0);
            if (this.scratch.readUnsignedInt24() != ID3_TAG) {
                break;
            }
            this.scratch.skipBytes(3);
            int synchSafeInt = this.scratch.readSynchSafeInt();
            i_renamed += synchSafeInt + 10;
            extractorInput.advancePeekPosition(synchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i_renamed);
        if (this.firstFramePosition == -1) {
            this.firstFramePosition = i_renamed;
        }
        return i_renamed;
    }

    private void maybeOutputSeekMap(long j_renamed, boolean z_renamed, boolean z2) {
        if (this.hasOutputSeekMap) {
            return;
        }
        boolean z3 = z_renamed && this.averageFrameSize > 0;
        if (z3 && this.reader.getSampleDurationUs() == -9223372036854775807L && !z2) {
            return;
        }
        com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput = (com.google.android.exoplayer2.extractor.ExtractorOutput) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.extractorOutput);
        if (z3 && this.reader.getSampleDurationUs() != -9223372036854775807L) {
            extractorOutput.seekMap(getConstantBitrateSeekMap(j_renamed));
        } else {
            extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
        }
        this.hasOutputSeekMap = true;
    }

    private void calculateAverageFrameSize(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (this.hasCalculatedAverageFrameSize) {
            return;
        }
        this.averageFrameSize = -1;
        extractorInput.resetPeekPosition();
        long j_renamed = 0;
        if (extractorInput.getPosition() == 0) {
            peekId3Header(extractorInput);
        }
        int i_renamed = 0;
        while (true) {
            if (!extractorInput.peekFully(this.scratch.data, 0, 2, true)) {
                break;
            }
            this.scratch.setPosition(0);
            if (!com.google.android.exoplayer2.extractor.ts.AdtsReader.isAdtsSyncWord(this.scratch.readUnsignedShort())) {
                i_renamed = 0;
                break;
            }
            if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                break;
            }
            this.scratchBits.setPosition(14);
            int bits = this.scratchBits.readBits(13);
            if (bits <= 6) {
                this.hasCalculatedAverageFrameSize = true;
                throw new com.google.android.exoplayer2.ParserException("Malformed ADTS stream");
            }
            j_renamed += bits;
            i_renamed++;
            if (i_renamed == 1000 || !extractorInput.advancePeekPosition(bits - 6, true)) {
                break;
            }
        }
        extractorInput.resetPeekPosition();
        if (i_renamed > 0) {
            this.averageFrameSize = (int) (j_renamed / i_renamed);
        } else {
            this.averageFrameSize = -1;
        }
        this.hasCalculatedAverageFrameSize = true;
    }

    private com.google.android.exoplayer2.extractor.SeekMap getConstantBitrateSeekMap(long j_renamed) {
        return new com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap(j_renamed, this.firstFramePosition, getBitrateFromFrameSize(this.averageFrameSize, this.reader.getSampleDurationUs()), this.averageFrameSize);
    }

    private static int getBitrateFromFrameSize(int i_renamed, long j_renamed) {
        return (int) (((i_renamed * 8) * 1000000) / j_renamed);
    }
}
