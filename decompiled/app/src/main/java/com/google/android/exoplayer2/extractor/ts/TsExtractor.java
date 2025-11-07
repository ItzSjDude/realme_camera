package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class TsExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    private static final int BUFFER_SIZE = 9400;
    private static final int MAX_PID_PLUS_ONE = 8192;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    private static final int SNIFF_TS_PACKET_COUNT = 5;
    public static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_AC4 = 172;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    public static final int TS_SYNC_BYTE = 71;
    private int bytesSinceLastSync;
    private final android.util.SparseIntArray continuityCounters;
    private final com.google.android.exoplayer2.extractor.ts.TsDurationReader durationReader;
    private boolean hasOutputSeekMap;
    private com.google.android.exoplayer2.extractor.ts.TsPayloadReader id3Reader;
    private final int mode;
    private com.google.android.exoplayer2.extractor.ExtractorOutput output;
    private final com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory payloadReaderFactory;
    private int pcrPid;
    private boolean pendingSeekToStart;
    private int remainingPmts;
    private final java.util.List<com.google.android.exoplayer2.util.TimestampAdjuster> timestampAdjusters;
    private final android.util.SparseBooleanArray trackIds;
    private final android.util.SparseBooleanArray trackPids;
    private boolean tracksEnded;
    private com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker tsBinarySearchSeeker;
    private final com.google.android.exoplayer2.util.ParsableByteArray tsPacketBuffer;
    private final android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> tsPayloadReaders;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.-$$Lambda$TsExtractor$f_renamed-UE6PC86cqq4V-qVoFQnPhfFZ8
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.ts.TsExtractor.lambda$static$0();
        }
    };
    private static final long AC3_FORMAT_IDENTIFIER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("AC-3");
    private static final long E_AC3_FORMAT_IDENTIFIER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("EAC3");
    private static final long AC4_FORMAT_IDENTIFIER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("AC-4");
    private static final long HEVC_FORMAT_IDENTIFIER = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("HEVC");

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ int access$108(com.google.android.exoplayer2.extractor.ts.TsExtractor tsExtractor) {
        int i_renamed = tsExtractor.remainingPmts;
        tsExtractor.remainingPmts = i_renamed + 1;
        return i_renamed;
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.TsExtractor()};
    }

    public TsExtractor() {
        this(0);
    }

    public TsExtractor(int i_renamed) {
        this(1, i_renamed);
    }

    public TsExtractor(int i_renamed, int i2) {
        this(i_renamed, new com.google.android.exoplayer2.util.TimestampAdjuster(0L), new com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory(i2));
    }

    public TsExtractor(int i_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory factory) {
        this.payloadReaderFactory = (com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
        this.mode = i_renamed;
        if (i_renamed == 1 || i_renamed == 2) {
            this.timestampAdjusters = java.util.Collections.singletonList(timestampAdjuster);
        } else {
            this.timestampAdjusters = new java.util.ArrayList();
            this.timestampAdjusters.add(timestampAdjuster);
        }
        this.tsPacketBuffer = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[BUFFER_SIZE], 0);
        this.trackIds = new android.util.SparseBooleanArray();
        this.trackPids = new android.util.SparseBooleanArray();
        this.tsPayloadReaders = new android.util.SparseArray<>();
        this.continuityCounters = new android.util.SparseIntArray();
        this.durationReader = new com.google.android.exoplayer2.extractor.ts.TsDurationReader();
        this.pcrPid = -1;
        resetPayloadReaders();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        boolean z_renamed;
        byte[] bArr = this.tsPacketBuffer.data;
        extractorInput.peekFully(bArr, 0, 940);
        for (int i_renamed = 0; i_renamed < 188; i_renamed++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z_renamed = true;
                    break;
                }
                if (bArr[(i2 * 188) + i_renamed] != 71) {
                    z_renamed = false;
                    break;
                }
                i2++;
            }
            if (z_renamed) {
                extractorInput.skipFully(i_renamed);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker tsBinarySearchSeeker;
        com.google.android.exoplayer2.util.Assertions.checkState(this.mode != 2);
        int size = this.timestampAdjusters.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.timestampAdjusters.get(i_renamed);
            if ((timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) || (timestampAdjuster.getTimestampOffsetUs() != 0 && timestampAdjuster.getFirstSampleTimestampUs() != j2)) {
                timestampAdjuster.reset();
                timestampAdjuster.setFirstSampleTimestampUs(j2);
            }
        }
        if (j2 != 0 && (tsBinarySearchSeeker = this.tsBinarySearchSeeker) != null) {
            tsBinarySearchSeeker.setSeekTargetUs(j2);
        }
        this.tsPacketBuffer.reset();
        this.continuityCounters.clear();
        for (int i2 = 0; i2 < this.tsPayloadReaders.size(); i2++) {
            this.tsPayloadReaders.valueAt(i2).seek();
        }
        this.bytesSinceLastSync = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        long length = extractorInput.getLength();
        if (this.tracksEnded) {
            if (((length == -1 || this.mode == 2) ? false : true) && !this.durationReader.isDurationReadFinished()) {
                return this.durationReader.readDuration(extractorInput, positionHolder, this.pcrPid);
            }
            maybeOutputSeekMap(length);
            if (this.pendingSeekToStart) {
                this.pendingSeekToStart = false;
                seek(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.position = 0L;
                    return 1;
                }
            }
            com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker tsBinarySearchSeeker = this.tsBinarySearchSeeker;
            if (tsBinarySearchSeeker != null && tsBinarySearchSeeker.isSeeking()) {
                return this.tsBinarySearchSeeker.handlePendingSeek(extractorInput, positionHolder, null);
            }
        }
        if (!fillBufferWithAtLeastOnePacket(extractorInput)) {
            return -1;
        }
        int iFindEndOfFirstTsPacketInBuffer = findEndOfFirstTsPacketInBuffer();
        int iLimit = this.tsPacketBuffer.limit();
        if (iFindEndOfFirstTsPacketInBuffer > iLimit) {
            return 0;
        }
        int i_renamed = this.tsPacketBuffer.readInt();
        if ((8388608 & i_renamed) != 0) {
            this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
            return 0;
        }
        int i2 = ((4194304 & i_renamed) != 0 ? 1 : 0) | 0;
        int i3 = (2096896 & i_renamed) >> 8;
        boolean z_renamed = (i_renamed & 32) != 0;
        com.google.android.exoplayer2.extractor.ts.TsPayloadReader tsPayloadReader = (i_renamed & 16) != 0 ? this.tsPayloadReaders.get(i3) : null;
        if (tsPayloadReader == null) {
            this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
            return 0;
        }
        if (this.mode != 2) {
            int i4 = i_renamed & 15;
            int i5 = this.continuityCounters.get(i3, i4 - 1);
            this.continuityCounters.put(i3, i4);
            if (i5 == i4) {
                this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
                return 0;
            }
            if (i4 != ((i5 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z_renamed) {
            int unsignedByte = this.tsPacketBuffer.readUnsignedByte();
            i2 |= (this.tsPacketBuffer.readUnsignedByte() & 64) != 0 ? 2 : 0;
            this.tsPacketBuffer.skipBytes(unsignedByte - 1);
        }
        boolean z2 = this.tracksEnded;
        if (shouldConsumePacketPayload(i3)) {
            this.tsPacketBuffer.setLimit(iFindEndOfFirstTsPacketInBuffer);
            tsPayloadReader.consume(this.tsPacketBuffer, i2);
            this.tsPacketBuffer.setLimit(iLimit);
        }
        if (this.mode != 2 && !z2 && this.tracksEnded && length != -1) {
            this.pendingSeekToStart = true;
        }
        this.tsPacketBuffer.setPosition(iFindEndOfFirstTsPacketInBuffer);
        return 0;
    }

    private void maybeOutputSeekMap(long j_renamed) {
        if (this.hasOutputSeekMap) {
            return;
        }
        this.hasOutputSeekMap = true;
        if (this.durationReader.getDurationUs() != -9223372036854775807L) {
            this.tsBinarySearchSeeker = new com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker(this.durationReader.getPcrTimestampAdjuster(), this.durationReader.getDurationUs(), j_renamed, this.pcrPid);
            this.output.seekMap(this.tsBinarySearchSeeker.getSeekMap());
        } else {
            this.output.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.durationReader.getDurationUs()));
        }
    }

    private boolean fillBufferWithAtLeastOnePacket(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        byte[] bArr = this.tsPacketBuffer.data;
        if (9400 - this.tsPacketBuffer.getPosition() < 188) {
            int iBytesLeft = this.tsPacketBuffer.bytesLeft();
            if (iBytesLeft > 0) {
                java.lang.System.arraycopy(bArr, this.tsPacketBuffer.getPosition(), bArr, 0, iBytesLeft);
            }
            this.tsPacketBuffer.reset(bArr, iBytesLeft);
        }
        while (this.tsPacketBuffer.bytesLeft() < 188) {
            int iLimit = this.tsPacketBuffer.limit();
            int i_renamed = extractorInput.read(bArr, iLimit, 9400 - iLimit);
            if (i_renamed == -1) {
                return false;
            }
            this.tsPacketBuffer.setLimit(iLimit + i_renamed);
        }
        return true;
    }

    private int findEndOfFirstTsPacketInBuffer() throws com.google.android.exoplayer2.ParserException {
        int position = this.tsPacketBuffer.getPosition();
        int iLimit = this.tsPacketBuffer.limit();
        int iFindSyncBytePosition = com.google.android.exoplayer2.extractor.ts.TsUtil.findSyncBytePosition(this.tsPacketBuffer.data, position, iLimit);
        this.tsPacketBuffer.setPosition(iFindSyncBytePosition);
        int i_renamed = iFindSyncBytePosition + 188;
        if (i_renamed > iLimit) {
            this.bytesSinceLastSync += iFindSyncBytePosition - position;
            if (this.mode == 2 && this.bytesSinceLastSync > 376) {
                throw new com.google.android.exoplayer2.ParserException("Cannot find sync byte. Most likely not a_renamed Transport Stream.");
            }
        } else {
            this.bytesSinceLastSync = 0;
        }
        return i_renamed;
    }

    private boolean shouldConsumePacketPayload(int i_renamed) {
        return this.mode == 2 || this.tracksEnded || !this.trackPids.get(i_renamed, false);
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> sparseArrayCreateInitialPayloadReaders = this.payloadReaderFactory.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.tsPayloadReaders.put(sparseArrayCreateInitialPayloadReaders.keyAt(i_renamed), sparseArrayCreateInitialPayloadReaders.valueAt(i_renamed));
        }
        this.tsPayloadReaders.put(0, new com.google.android.exoplayer2.extractor.ts.SectionReader(new com.google.android.exoplayer2.extractor.ts.TsExtractor.PatReader()));
        this.id3Reader = null;
    }

    private class PatReader implements com.google.android.exoplayer2.extractor.ts.SectionPayloadReader {
        private final com.google.android.exoplayer2.util.ParsableBitArray patScratch = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[4]);

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public PatReader() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() != 0) {
                return;
            }
            parsableByteArray.skipBytes(7);
            int iBytesLeft = parsableByteArray.bytesLeft() / 4;
            for (int i_renamed = 0; i_renamed < iBytesLeft; i_renamed++) {
                parsableByteArray.readBytes(this.patScratch, 4);
                int bits = this.patScratch.readBits(16);
                this.patScratch.skipBits(3);
                if (bits == 0) {
                    this.patScratch.skipBits(13);
                } else {
                    int bits2 = this.patScratch.readBits(13);
                    com.google.android.exoplayer2.extractor.ts.TsExtractor.this.tsPayloadReaders.put(bits2, new com.google.android.exoplayer2.extractor.ts.SectionReader(com.google.android.exoplayer2.extractor.ts.TsExtractor.this.new PmtReader(bits2)));
                    com.google.android.exoplayer2.extractor.ts.TsExtractor.access$108(com.google.android.exoplayer2.extractor.ts.TsExtractor.this);
                }
            }
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode != 2) {
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.tsPayloadReaders.remove(0);
            }
        }
    }

    private class PmtReader implements com.google.android.exoplayer2.extractor.ts.SectionPayloadReader {
        private static final int TS_PMT_DESC_AC3 = 106;
        private static final int TS_PMT_DESC_DTS = 123;
        private static final int TS_PMT_DESC_DVBSUBS = 89;
        private static final int TS_PMT_DESC_DVB_EXT = 127;
        private static final int TS_PMT_DESC_DVB_EXT_AC4 = 21;
        private static final int TS_PMT_DESC_EAC3 = 122;
        private static final int TS_PMT_DESC_ISO639_LANG = 10;
        private static final int TS_PMT_DESC_REGISTRATION = 5;
        private final int pid;
        private final com.google.android.exoplayer2.util.ParsableBitArray pmtScratch = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[5]);
        private final android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> trackIdToReaderScratch = new android.util.SparseArray<>();
        private final android.util.SparseIntArray trackIdToPidScratch = new android.util.SparseIntArray();

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public PmtReader(int i_renamed) {
            this.pid = i_renamed;
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;
            if (parsableByteArray.readUnsignedByte() != 2) {
                return;
            }
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode == 1 || com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode == 2 || com.google.android.exoplayer2.extractor.ts.TsExtractor.this.remainingPmts == 1) {
                timestampAdjuster = (com.google.android.exoplayer2.util.TimestampAdjuster) com.google.android.exoplayer2.extractor.ts.TsExtractor.this.timestampAdjusters.get(0);
            } else {
                timestampAdjuster = new com.google.android.exoplayer2.util.TimestampAdjuster(((com.google.android.exoplayer2.util.TimestampAdjuster) com.google.android.exoplayer2.extractor.ts.TsExtractor.this.timestampAdjusters.get(0)).getFirstSampleTimestampUs());
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.timestampAdjusters.add(timestampAdjuster);
            }
            parsableByteArray.skipBytes(2);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            int i_renamed = 3;
            parsableByteArray.skipBytes(3);
            parsableByteArray.readBytes(this.pmtScratch, 2);
            this.pmtScratch.skipBits(3);
            int i2 = 13;
            com.google.android.exoplayer2.extractor.ts.TsExtractor.this.pcrPid = this.pmtScratch.readBits(13);
            parsableByteArray.readBytes(this.pmtScratch, 2);
            int i3 = 4;
            this.pmtScratch.skipBits(4);
            parsableByteArray.skipBytes(this.pmtScratch.readBits(12));
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode == 2 && com.google.android.exoplayer2.extractor.ts.TsExtractor.this.id3Reader == null) {
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo = new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo(21, null, null, com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
                com.google.android.exoplayer2.extractor.ts.TsExtractor tsExtractor = com.google.android.exoplayer2.extractor.ts.TsExtractor.this;
                tsExtractor.id3Reader = tsExtractor.payloadReaderFactory.createPayloadReader(21, esInfo);
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.id3Reader.init(timestampAdjuster, com.google.android.exoplayer2.extractor.ts.TsExtractor.this.output, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(unsignedShort, 21, 8192));
            }
            this.trackIdToReaderScratch.clear();
            this.trackIdToPidScratch.clear();
            int iBytesLeft = parsableByteArray.bytesLeft();
            while (iBytesLeft > 0) {
                parsableByteArray.readBytes(this.pmtScratch, 5);
                int bits = this.pmtScratch.readBits(8);
                this.pmtScratch.skipBits(i_renamed);
                int bits2 = this.pmtScratch.readBits(i2);
                this.pmtScratch.skipBits(i3);
                int bits3 = this.pmtScratch.readBits(12);
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo2 = readEsInfo(parsableByteArray, bits3);
                if (bits == 6) {
                    bits = esInfo2.streamType;
                }
                iBytesLeft -= bits3 + 5;
                int i4 = com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode == 2 ? bits : bits2;
                if (!com.google.android.exoplayer2.extractor.ts.TsExtractor.this.trackIds.get(i4)) {
                    com.google.android.exoplayer2.extractor.ts.TsPayloadReader tsPayloadReaderCreatePayloadReader = (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode == 2 && bits == 21) ? com.google.android.exoplayer2.extractor.ts.TsExtractor.this.id3Reader : com.google.android.exoplayer2.extractor.ts.TsExtractor.this.payloadReaderFactory.createPayloadReader(bits, esInfo2);
                    if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode != 2 || bits2 < this.trackIdToPidScratch.get(i4, 8192)) {
                        this.trackIdToPidScratch.put(i4, bits2);
                        this.trackIdToReaderScratch.put(i4, tsPayloadReaderCreatePayloadReader);
                    }
                }
                i_renamed = 3;
                i3 = 4;
                i2 = 13;
            }
            int size = this.trackIdToPidScratch.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = this.trackIdToPidScratch.keyAt(i5);
                int iValueAt = this.trackIdToPidScratch.valueAt(i5);
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.trackIds.put(iKeyAt, true);
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.trackPids.put(iValueAt, true);
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader tsPayloadReaderValueAt = this.trackIdToReaderScratch.valueAt(i5);
                if (tsPayloadReaderValueAt != null) {
                    if (tsPayloadReaderValueAt != com.google.android.exoplayer2.extractor.ts.TsExtractor.this.id3Reader) {
                        tsPayloadReaderValueAt.init(timestampAdjuster, com.google.android.exoplayer2.extractor.ts.TsExtractor.this.output, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(unsignedShort, iKeyAt, 8192));
                    }
                    com.google.android.exoplayer2.extractor.ts.TsExtractor.this.tsPayloadReaders.put(iValueAt, tsPayloadReaderValueAt);
                }
            }
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.mode == 2) {
                if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.tracksEnded) {
                    return;
                }
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.output.endTracks();
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.remainingPmts = 0;
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.tracksEnded = true;
                return;
            }
            com.google.android.exoplayer2.extractor.ts.TsExtractor.this.tsPayloadReaders.remove(this.pid);
            com.google.android.exoplayer2.extractor.ts.TsExtractor tsExtractor2 = com.google.android.exoplayer2.extractor.ts.TsExtractor.this;
            tsExtractor2.remainingPmts = tsExtractor2.mode != 1 ? com.google.android.exoplayer2.extractor.ts.TsExtractor.this.remainingPmts - 1 : 0;
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.remainingPmts == 0) {
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.output.endTracks();
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.tracksEnded = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo readEsInfo(com.google.android.exoplayer2.util.ParsableByteArray r13, int r14) {
            /*
                r12 = this;
                int r12 = r13.getPosition()
                int r14 = r14 + r12
                r0 = 0
                r1 = -1
                r2 = r0
            L8:
                int r3 = r13.getPosition()
                if (r3 >= r14) goto Lb5
                int r3 = r13.readUnsignedByte()
                int r4 = r13.readUnsignedByte()
                int r5 = r13.getPosition()
                int r5 = r5 + r4
                r4 = 5
                r6 = 89
                r7 = 172(0xac, float:2.41E-43)
                r8 = 135(0x87, float:1.89E-43)
                r9 = 129(0x81, float:1.81E-43)
                if (r3 != r4) goto L52
                long r3 = r13.readUnsignedInt()
                long r10 = com.google.android.exoplayer2.extractor.ts.TsExtractor.access$1100()
                int r6 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
                if (r6 != 0) goto L33
                goto L56
            L33:
                long r9 = com.google.android.exoplayer2.extractor.ts.TsExtractor.access$1200()
                int r6 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
                if (r6 != 0) goto L3c
                goto L5c
            L3c:
                long r8 = com.google.android.exoplayer2.extractor.ts.TsExtractor.access$1300()
                int r6 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
                if (r6 != 0) goto L47
            L44:
                r1 = r7
                goto Lab
            L47:
                long r6 = com.google.android.exoplayer2.extractor.ts.TsExtractor.access$1400()
                int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r3 != 0) goto Lab
                r1 = 36
                goto Lab
            L52:
                r4 = 106(0x6a, float:1.49E-43)
                if (r3 != r4) goto L58
            L56:
                r1 = r9
                goto Lab
            L58:
                r4 = 122(0x7a, float:1.71E-43)
                if (r3 != r4) goto L5e
            L5c:
                r1 = r8
                goto Lab
            L5e:
                r4 = 127(0x7f, float:1.78E-43)
                if (r3 != r4) goto L6b
                int r3 = r13.readUnsignedByte()
                r4 = 21
                if (r3 != r4) goto Lab
                goto L44
            L6b:
                r4 = 123(0x7b, float:1.72E-43)
                if (r3 != r4) goto L72
                r1 = 138(0x8a, float:1.93E-43)
                goto Lab
            L72:
                r4 = 10
                r7 = 3
                if (r3 != r4) goto L80
                java.lang.String r0 = r13.readString(r7)
                java.lang.String r0 = r0.trim()
                goto Lab
            L80:
                if (r3 != r6) goto Lab
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
            L87:
                int r2 = r13.getPosition()
                if (r2 >= r5) goto La9
                java.lang.String r2 = r13.readString(r7)
                java.lang.String r2 = r2.trim()
                int r3 = r13.readUnsignedByte()
                r4 = 4
                byte[] r8 = new byte[r4]
                r9 = 0
                r13.readBytes(r8, r9, r4)
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader$DvbSubtitleInfo r4 = new com.google.android.exoplayer2.extractor.ts.TsPayloadReader$DvbSubtitleInfo
                r4.<init>(r2, r3, r8)
                r1.add(r4)
                goto L87
            La9:
                r2 = r1
                r1 = r6
            Lab:
                int r3 = r13.getPosition()
                int r5 = r5 - r3
                r13.skipBytes(r5)
                goto L8
            Lb5:
                r13.setPosition(r14)
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader$EsInfo r3 = new com.google.android.exoplayer2.extractor.ts.TsPayloadReader$EsInfo
                byte[] r13 = r13.data
                byte[] r12 = java.util.Arrays.copyOfRange(r13, r12, r14)
                r3.<init>(r1, r0, r2, r12)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.TsExtractor.PmtReader.readEsInfo(com.google.android.exoplayer2.util.ParsableByteArray, int):com.google.android.exoplayer2.extractor.ts.TsPayloadReader$EsInfo");
        }
    }
}
