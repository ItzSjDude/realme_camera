package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes.dex */
public final class FlvExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    private static final int FLV_HEADER_SIZE = 9;
    private static final int FLV_TAG_HEADER_SIZE = 11;
    private static final int STATE_READING_FLV_HEADER = 1;
    private static final int STATE_READING_TAG_DATA = 4;
    private static final int STATE_READING_TAG_HEADER = 3;
    private static final int STATE_SKIPPING_TO_TAG_HEADER = 2;
    private static final int TAG_TYPE_AUDIO = 8;
    private static final int TAG_TYPE_SCRIPT_DATA = 18;
    private static final int TAG_TYPE_VIDEO = 9;
    private com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader audioReader;
    private int bytesToNextTagHeader;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private boolean outputSeekMap;
    private int tagDataSize;
    private long tagTimestampUs;
    private int tagType;
    private com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader videoReader;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new com.google.android.exoplayer2.extractor.ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.flv.-$$Lambda$FlvExtractor$bd1zICO7f-FQot_hbozdu7LjVyE
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
            return com.google.android.exoplayer2.extractor.flv.FlvExtractor.lambda$static$0();
        }
    };
    private static final int FLV_TAG = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("FLV");
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch = new com.google.android.exoplayer2.util.ParsableByteArray(4);
    private final com.google.android.exoplayer2.util.ParsableByteArray headerBuffer = new com.google.android.exoplayer2.util.ParsableByteArray(9);
    private final com.google.android.exoplayer2.util.ParsableByteArray tagHeaderBuffer = new com.google.android.exoplayer2.util.ParsableByteArray(11);
    private final com.google.android.exoplayer2.util.ParsableByteArray tagData = new com.google.android.exoplayer2.util.ParsableByteArray();
    private final com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader metadataReader = new com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader();
    private int state = 1;
    private long mediaTagTimestampOffsetUs = -9223372036854775807L;

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] lambda$static$0() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.flv.FlvExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.peekFully(this.scratch.data, 0, 3);
        this.scratch.setPosition(0);
        if (this.scratch.readUnsignedInt24() != FLV_TAG) {
            return false;
        }
        extractorInput.peekFully(this.scratch.data, 0, 2);
        this.scratch.setPosition(0);
        if ((this.scratch.readUnsignedShort() & 250) != 0) {
            return false;
        }
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        int i_renamed = this.scratch.readInt();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i_renamed);
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        return this.scratch.readInt() == 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j_renamed, long j2) {
        this.state = 1;
        this.mediaTagTimestampOffsetUs = -9223372036854775807L;
        this.bytesToNextTagHeader = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        while (true) {
            int i_renamed = this.state;
            if (i_renamed != 1) {
                if (i_renamed == 2) {
                    skipToTagHeader(extractorInput);
                } else if (i_renamed != 3) {
                    if (i_renamed == 4) {
                        if (readTagData(extractorInput)) {
                            return 0;
                        }
                    } else {
                        throw new java.lang.IllegalStateException();
                    }
                } else if (!readTagHeader(extractorInput)) {
                    return -1;
                }
            } else if (!readFlvHeader(extractorInput)) {
                return -1;
            }
        }
    }

    private boolean readFlvHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (!extractorInput.readFully(this.headerBuffer.data, 0, 9, true)) {
            return false;
        }
        this.headerBuffer.setPosition(0);
        this.headerBuffer.skipBytes(4);
        int unsignedByte = this.headerBuffer.readUnsignedByte();
        boolean z_renamed = (unsignedByte & 4) != 0;
        boolean z2 = (unsignedByte & 1) != 0;
        if (z_renamed && this.audioReader == null) {
            this.audioReader = new com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader(this.extractorOutput.track(8, 1));
        }
        if (z2 && this.videoReader == null) {
            this.videoReader = new com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader(this.extractorOutput.track(9, 2));
        }
        this.extractorOutput.endTracks();
        this.bytesToNextTagHeader = (this.headerBuffer.readInt() - 9) + 4;
        this.state = 2;
        return true;
    }

    private void skipToTagHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.skipFully(this.bytesToNextTagHeader);
        this.bytesToNextTagHeader = 0;
        this.state = 3;
    }

    private boolean readTagHeader(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (!extractorInput.readFully(this.tagHeaderBuffer.data, 0, 11, true)) {
            return false;
        }
        this.tagHeaderBuffer.setPosition(0);
        this.tagType = this.tagHeaderBuffer.readUnsignedByte();
        this.tagDataSize = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = this.tagHeaderBuffer.readUnsignedInt24();
        this.tagTimestampUs = ((this.tagHeaderBuffer.readUnsignedByte() << 24) | this.tagTimestampUs) * 1000;
        this.tagHeaderBuffer.skipBytes(3);
        this.state = 4;
        return true;
    }

    private boolean readTagData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        boolean z_renamed = true;
        if (this.tagType == 8 && this.audioReader != null) {
            ensureReadyForMediaOutput();
            this.audioReader.consume(prepareTagData(extractorInput), this.mediaTagTimestampOffsetUs + this.tagTimestampUs);
        } else if (this.tagType == 9 && this.videoReader != null) {
            ensureReadyForMediaOutput();
            this.videoReader.consume(prepareTagData(extractorInput), this.mediaTagTimestampOffsetUs + this.tagTimestampUs);
        } else if (this.tagType == 18 && !this.outputSeekMap) {
            this.metadataReader.consume(prepareTagData(extractorInput), this.tagTimestampUs);
            long durationUs = this.metadataReader.getDurationUs();
            if (durationUs != -9223372036854775807L) {
                this.extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(durationUs));
                this.outputSeekMap = true;
            }
        } else {
            extractorInput.skipFully(this.tagDataSize);
            z_renamed = false;
        }
        this.bytesToNextTagHeader = 4;
        this.state = 2;
        return z_renamed;
    }

    private com.google.android.exoplayer2.util.ParsableByteArray prepareTagData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (this.tagDataSize > this.tagData.capacity()) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.tagData;
            parsableByteArray.reset(new byte[java.lang.Math.max(parsableByteArray.capacity() * 2, this.tagDataSize)], 0);
        } else {
            this.tagData.setPosition(0);
        }
        this.tagData.setLimit(this.tagDataSize);
        extractorInput.readFully(this.tagData.data, 0, this.tagDataSize);
        return this.tagData;
    }

    private void ensureReadyForMediaOutput() {
        if (!this.outputSeekMap) {
            this.extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
            this.outputSeekMap = true;
        }
        if (this.mediaTagTimestampOffsetUs == -9223372036854775807L) {
            this.mediaTagTimestampOffsetUs = this.metadataReader.getDurationUs() == -9223372036854775807L ? -this.tagTimestampUs : 0L;
        }
    }
}
