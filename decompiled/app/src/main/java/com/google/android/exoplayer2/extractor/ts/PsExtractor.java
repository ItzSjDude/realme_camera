package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class PsExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int AUDIO_STREAM = 192;
    public static final int AUDIO_STREAM_MASK = 224;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.-$$Lambda$PsExtractor$U8l9TedlJUwsYwV9EOSFo_ngcXY
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.ts.PsExtractor.lambda$static$0();
        }
    };
    private static final long MAX_SEARCH_LENGTH = 1048576;
    private static final long MAX_SEARCH_LENGTH_AFTER_AUDIO_AND_VIDEO_FOUND = 8192;
    private static final int MAX_STREAM_ID_PLUS_ONE = 256;
    static final int MPEG_PROGRAM_END_CODE = 441;
    static final int PACKET_START_CODE_PREFIX = 1;
    static final int PACK_START_CODE = 442;
    public static final int PRIVATE_STREAM_1 = 189;
    static final int SYSTEM_HEADER_START_CODE = 443;
    public static final int VIDEO_STREAM = 224;
    public static final int VIDEO_STREAM_MASK = 240;
    private final com.google.android.exoplayer2.extractor.ts.PsDurationReader durationReader;
    private boolean foundAllTracks;
    private boolean foundAudioTrack;
    private boolean foundVideoTrack;
    private boolean hasOutputSeekMap;
    private long lastTrackPosition;
    private com.google.android.exoplayer2.extractor.ExtractorOutput output;
    private com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker psBinarySearchSeeker;
    private final com.google.android.exoplayer2.util.ParsableByteArray psPacketBuffer;
    private final android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.PsExtractor.PesReader> psPayloadReaders;
    private final com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.PsExtractor()};
    }

    public PsExtractor() {
        this(new com.google.android.exoplayer2.util.TimestampAdjuster(0L));
    }

    public PsExtractor(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        this.timestampAdjuster = timestampAdjuster;
        this.psPacketBuffer = new com.google.android.exoplayer2.util.ParsableByteArray(4096);
        this.psPayloadReaders = new android.util.SparseArray<>();
        this.durationReader = new com.google.android.exoplayer2.extractor.ts.PsDurationReader();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        byte[] bArr = new byte[14];
        extractorInput.peekFully(bArr, 0, 14);
        if (PACK_START_CODE != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.advancePeekPosition(bArr[13] & 7);
        extractorInput.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        if ((this.timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) || (this.timestampAdjuster.getFirstSampleTimestampUs() != 0 && this.timestampAdjuster.getFirstSampleTimestampUs() != j2)) {
            this.timestampAdjuster.reset();
            this.timestampAdjuster.setFirstSampleTimestampUs(j2);
        }
        com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker psBinarySearchSeeker = this.psBinarySearchSeeker;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.setSeekTargetUs(j2);
        }
        for (int i_renamed = 0; i_renamed < this.psPayloadReaders.size(); i_renamed++) {
            this.psPayloadReaders.valueAt(i_renamed).seek();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        long length = extractorInput.getLength();
        if ((length != -1) && !this.durationReader.isDurationReadFinished()) {
            return this.durationReader.readDuration(extractorInput, positionHolder);
        }
        maybeOutputSeekMap(length);
        com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker psBinarySearchSeeker = this.psBinarySearchSeeker;
        com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader h262Reader = null;
        if (psBinarySearchSeeker != null && psBinarySearchSeeker.isSeeking()) {
            return this.psBinarySearchSeeker.handlePendingSeek(extractorInput, positionHolder, null);
        }
        extractorInput.resetPeekPosition();
        long peekPosition = length != -1 ? length - extractorInput.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !extractorInput.peekFully(this.psPacketBuffer.data, 0, 4, true)) {
            return -1;
        }
        this.psPacketBuffer.setPosition(0);
        int i_renamed = this.psPacketBuffer.readInt();
        if (i_renamed == MPEG_PROGRAM_END_CODE) {
            return -1;
        }
        if (i_renamed == PACK_START_CODE) {
            extractorInput.peekFully(this.psPacketBuffer.data, 0, 10);
            this.psPacketBuffer.setPosition(9);
            extractorInput.skipFully((this.psPacketBuffer.readUnsignedByte() & 7) + 14);
            return 0;
        }
        if (i_renamed == SYSTEM_HEADER_START_CODE) {
            extractorInput.peekFully(this.psPacketBuffer.data, 0, 2);
            this.psPacketBuffer.setPosition(0);
            extractorInput.skipFully(this.psPacketBuffer.readUnsignedShort() + 6);
            return 0;
        }
        if (((i_renamed & (-256)) >> 8) != 1) {
            extractorInput.skipFully(1);
            return 0;
        }
        int i2 = i_renamed & 255;
        com.google.android.exoplayer2.extractor.ts.PsExtractor.PesReader pesReader = this.psPayloadReaders.get(i2);
        if (!this.foundAllTracks) {
            if (pesReader == null) {
                if (i2 == 189) {
                    h262Reader = new com.google.android.exoplayer2.extractor.ts.Ac3Reader();
                    this.foundAudioTrack = true;
                    this.lastTrackPosition = extractorInput.getPosition();
                } else if ((i2 & 224) == 192) {
                    h262Reader = new com.google.android.exoplayer2.extractor.ts.MpegAudioReader();
                    this.foundAudioTrack = true;
                    this.lastTrackPosition = extractorInput.getPosition();
                } else if ((i2 & 240) == 224) {
                    h262Reader = new com.google.android.exoplayer2.extractor.ts.H262Reader();
                    this.foundVideoTrack = true;
                    this.lastTrackPosition = extractorInput.getPosition();
                }
                if (h262Reader != null) {
                    h262Reader.createTracks(this.output, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(i2, 256));
                    pesReader = new com.google.android.exoplayer2.extractor.ts.PsExtractor.PesReader(h262Reader, this.timestampAdjuster);
                    this.psPayloadReaders.put(i2, pesReader);
                }
            }
            if (extractorInput.getPosition() > ((this.foundAudioTrack && this.foundVideoTrack) ? this.lastTrackPosition + 8192 : 1048576L)) {
                this.foundAllTracks = true;
                this.output.endTracks();
            }
        }
        extractorInput.peekFully(this.psPacketBuffer.data, 0, 2);
        this.psPacketBuffer.setPosition(0);
        int unsignedShort = this.psPacketBuffer.readUnsignedShort() + 6;
        if (pesReader == null) {
            extractorInput.skipFully(unsignedShort);
        } else {
            this.psPacketBuffer.reset(unsignedShort);
            extractorInput.readFully(this.psPacketBuffer.data, 0, unsignedShort);
            this.psPacketBuffer.setPosition(6);
            pesReader.consume(this.psPacketBuffer);
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.psPacketBuffer;
            parsableByteArray.setLimit(parsableByteArray.capacity());
        }
        return 0;
    }

    private void maybeOutputSeekMap(long j_renamed) {
        if (this.hasOutputSeekMap) {
            return;
        }
        this.hasOutputSeekMap = true;
        if (this.durationReader.getDurationUs() != -9223372036854775807L) {
            this.psBinarySearchSeeker = new com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker(this.durationReader.getScrTimestampAdjuster(), this.durationReader.getDurationUs(), j_renamed);
            this.output.seekMap(this.psBinarySearchSeeker.getSeekMap());
        } else {
            this.output.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.durationReader.getDurationUs()));
        }
    }

    private static final class PesReader {
        private static final int PES_SCRATCH_SIZE = 64;
        private boolean dtsFlag;
        private int extendedHeaderLength;
        private final com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader pesPayloadReader;
        private final com.google.android.exoplayer2.util.ParsableBitArray pesScratch = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[64]);
        private boolean ptsFlag;
        private boolean seenFirstDts;
        private long timeUs;
        private final com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;

        public PesReader(com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader elementaryStreamReader, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
            this.pesPayloadReader = elementaryStreamReader;
            this.timestampAdjuster = timestampAdjuster;
        }

        public void seek() {
            this.seenFirstDts = false;
            this.pesPayloadReader.seek();
        }

        public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
            parsableByteArray.readBytes(this.pesScratch.data, 0, 3);
            this.pesScratch.setPosition(0);
            parseHeader();
            parsableByteArray.readBytes(this.pesScratch.data, 0, this.extendedHeaderLength);
            this.pesScratch.setPosition(0);
            parseHeaderExtension();
            this.pesPayloadReader.packetStarted(this.timeUs, 4);
            this.pesPayloadReader.consume(parsableByteArray);
            this.pesPayloadReader.packetFinished();
        }

        private void parseHeader() {
            this.pesScratch.skipBits(8);
            this.ptsFlag = this.pesScratch.readBit();
            this.dtsFlag = this.pesScratch.readBit();
            this.pesScratch.skipBits(6);
            this.extendedHeaderLength = this.pesScratch.readBits(8);
        }

        private void parseHeaderExtension() {
            this.timeUs = 0L;
            if (this.ptsFlag) {
                this.pesScratch.skipBits(4);
                this.pesScratch.skipBits(1);
                this.pesScratch.skipBits(1);
                long bits = (this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15);
                this.pesScratch.skipBits(1);
                if (!this.seenFirstDts && this.dtsFlag) {
                    this.pesScratch.skipBits(4);
                    this.pesScratch.skipBits(1);
                    this.pesScratch.skipBits(1);
                    this.pesScratch.skipBits(1);
                    this.timestampAdjuster.adjustTsTimestamp((this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15));
                    this.seenFirstDts = true;
                }
                this.timeUs = this.timestampAdjuster.adjustTsTimestamp(bits);
            }
        }
    }
}
